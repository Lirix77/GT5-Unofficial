package com.sinthoras.visualprospecting.task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    public static final TaskManager instance = new TaskManager();

    private final List<com.sinthoras.visualprospecting.task.ITask> tasks = new ArrayList<>();

    public void addTask(com.sinthoras.visualprospecting.task.ITask task) {
        tasks.add(task);
    }

    public void onTick() {
        tasks.removeIf(ITask::process);
    }
}
