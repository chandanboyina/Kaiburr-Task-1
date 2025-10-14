package com.chandan.task;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Task putTask(Task task) {
        // Validation check for malicious code
        if (isUnsafeCommand(task.getCommand())) {
            throw new IllegalArgumentException("Unsafe command detected.");
        }
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findTasksByName(String name) {
        return taskRepository.findByNameContaining(name);
    }

    public Optional<Task> putTaskExecution(String taskId) {
        return taskRepository.findById(taskId).map(task -> {
            // Initialize the list outside the try block
            if (task.getTaskExecutions() == null) {
                task.setTaskExecutions(new ArrayList<>());
            }

            TaskExecution execution = new TaskExecution();
            execution.setStartTime(new Date());

            try {
                // Corrected command for Windows
                String[] command = {"cmd.exe", "/c", task.getCommand()};
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();

                // Read the output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = reader.lines().collect(Collectors.joining("\n"));

                execution.setEndTime(new Date());
                execution.setOutput(output);

            } catch (Exception e) {
                // Handle exceptions
                execution.setEndTime(new Date());
                execution.setOutput("Execution failed: " + e.getMessage());
            }

            // Add the execution to the list
            task.getTaskExecutions().add(execution);
            taskRepository.save(task);

            return task;
        });
    }

    // A simple validation to prevent malicious commands.
    private boolean isUnsafeCommand(String command) {
        // A simple check, a real-world application would need a more robust security mechanism
        return command != null && (command.contains("rm -rf") || command.contains("sudo") || command.contains("&"));
    }
}