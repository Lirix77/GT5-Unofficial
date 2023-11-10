import org.jetbrains.gradle.ext.Gradle
import org.jetbrains.gradle.ext.RunConfigurationContainer

plugins {
    java
    idea
    id("java-library")
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
    id("com.gtnewhorizons.retrofuturagradle") version "1.3.19"
}

val mcVersion = "1.7.10"
val gtVersion = "5.09.41"
val forgeVersion = "10.13.4.1614"

val modFullVersion = "$mcVersion-$gtVersion"
val mcFullVersion = "$mcVersion-$forgeVersion-$mcVersion"

version = modFullVersion
group= "com.github.lirix77"

// Set the toolchain version to decouple the Java we run Gradle with from the Java used to compile and run the mod
java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
    // Azul covers the most platforms for Java 8 toolchains, crucially including MacOS arm64
    vendor.set(org.gradle.jvm.toolchain.JvmVendorSpec.AZUL)
  }
  // Generate sources and javadocs jars when building and publishing
  withSourcesJar()
  //withJavadocJar()
}

// Most RFG configuration lives here, see the JavaDoc for com.gtnewhorizons.retrofuturagradle.MinecraftExtension
minecraft {
  mcVersion.set("1.7.10")

  // Username for client run configurations
  username.set("Developer")

  // Generate a field named VERSION with the mod version in the injected Tags class
  injectedTags.put("VERSION", project.version)

  // If you need the old replaceIn mechanism, prefer the injectTags task because it doesn't inject a javac plugin.
  // tagReplacementFiles.add("RfgExampleMod.java")

  // Enable assertions in the mod's package when running the client or server
  extraRunJvmArguments.add("-ea:${project.group}")

  injectMissingGenerics.set(true)

  // If needed, add extra tweaker classes like for mixins.
  // extraTweakClasses.add("org.spongepowered.asm.launch.MixinTweaker")

  // Exclude some Maven dependency groups from being automatically included in the reobfuscated runs
  groupsToExcludeFromAutoReobfMapping.addAll("com.diffplug", "com.diffplug.durian", "net.industrial-craft")
}

// Generates a class named rfg.examplemod.Tags with the mod version in it, you can find it at
tasks.injectTags.configure {
  outputClassName.set("${project.group}.Tags")
}

// Put the version from gradle into mcmod.info
tasks.processResources.configure {
  inputs.property("version", project.version)

  filesMatching("mcmod.info") {
    expand(mapOf("modVersion" to project.version))
  }
}

// Add an access tranformer
// tasks.deobfuscateMergedJarToSrg.configure {accessTransformerFiles.from("src/main/resources/META-INF/mymod_at.cfg")}

// Dependencies
repositories {
  maven {
    name = "OvermindDL1 Maven"
    url = uri("https://gregtech.overminddl1.com/")
    mavenContent {
      excludeGroup("net.minecraftforge") // missing the `universal` artefact
    }
  }
  maven {
    name = "ic2"
    setUrl("https://maven.ic2.player.to/")
  }
}

dependencies {
    compileOnly(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))
    implementation(fileTree(mapOf("dir" to "dep", "include" to listOf("*.jar"))))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")

    implementation("mcp.mobius.waila:Waila:1.5.11-RC2-NONEI_1.7.10:dev")
    implementation("codechicken:CodeChickenLib:1.7.10-1.1.3.140:dev")
    implementation("codechicken:CodeChickenCore:1.7.10-1.0.7.47:dev")
    implementation("codechicken:NotEnoughItems:1.7.10-1.0.5.120:dev")

    compileOnly("com.enderio.core:EnderCore:1.7.10-0.2.0.39_beta:dev")
    compileOnly("com.enderio:EnderIO:1.7.10-2.3.0.429_beta:dev")

    compileOnly("cofh:CoFHCore:1.7.10R3.0.4:dev")
    compileOnly("cofh:CoFHLib:1.7.10R3.0.3:dev")
    compileOnly("com.mod-buildcraft:buildcraft:7.1.23:dev")
    compileOnly("net.sengir.forestry:forestry_1.7.10:4.2.16.64:dev")
    compileOnly("mods.railcraft:Railcraft_1.7.10:9.12.3.0:dev")

    compileOnly("micdoodle8.mods:GalacticraftCore:1.7-3.0.12.504:Dev")
    compileOnly("micdoodle8.mods:MicdoodleCore:1.7-3.0.12.504:Dev")

    compileOnly("thaumcraft:Thaumcraft:1.7.10-4.2.3.5:dev")
    compileOnly("com.azanor.baubles:Baubles:1.7.10-1.0.1.10:deobf")
    compileOnly("applecore:AppleCore:1.7.10-3.1.1:deobf")

    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("com.google.auto.value:auto-value-annotations:1.10")
    annotationProcessor("com.google.auto.value:auto-value:1.10")

    compileOnly("com.github.bsideup.jabel:jabel-javac-plugin:0.4.2")
    annotationProcessor("com.github.bsideup.jabel:jabel-javac-plugin:0.4.2")

    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.+")
}

tasks.withType<JavaCompile>().configureEach{
    sourceCompatibility = "17"
    options.release.set(8)
    javaCompiler.set(javaToolchains.compilerFor(){
        languageVersion.set(JavaLanguageVersion.of(17))
    })
}

idea {
  module {
    isDownloadJavadoc = true
    isDownloadSources = true
    inheritOutputDirs = true // Fix resources in IJ-Native runs
  }
  project {
    this.withGroovyBuilder {
      "settings" {
        "runConfigurations" {
          val self = this.delegate as RunConfigurationContainer
          self.add(Gradle("1. Run Client").apply {
            setProperty("taskNames", listOf("runClient"))
          })
          self.add(Gradle("2. Run Server").apply {
            setProperty("taskNames", listOf("runServer"))
          })
          self.add(Gradle("3. Run Obfuscated Client").apply {
            setProperty("taskNames", listOf("runObfClient"))
          })
          self.add(Gradle("4. Run Obfuscated Server").apply {
            setProperty("taskNames", listOf("runObfServer"))
          })
        }
        "compiler" {
          val self = this.delegate as org.jetbrains.gradle.ext.IdeaCompilerConfiguration
          afterEvaluate {
            self.javac.moduleJavacAdditionalOptions = mapOf(
              (project.name + ".main") to
                tasks.compileJava.get().options.compilerArgs.map { '"' + it + '"' }.joinToString(" ")
            )
          }
        }
      }
    }
  }
}

tasks.processIdeaSettings.configure {
  dependsOn(tasks.injectTags)
}
