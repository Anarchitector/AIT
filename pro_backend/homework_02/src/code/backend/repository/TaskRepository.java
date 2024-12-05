package code.backend.repository;

import code.backend.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();
    private Integer nextId = 0;

    public Task add(Task task){
        task.setId(++nextId);
        tasks.add(task);
        return task;
    }

    public boolean deleteById(Integer id){
        Optional<Task> foundedTaskById = findById(id);

        if (foundedTaskById.isPresent()) {
            tasks.remove(foundedTaskById.get());
            return true;
        }
        else {
            return false;
        }
    }

    public Optional<Task> findById(Integer id){
        for(Task currentTask : tasks){
            if(currentTask.getId().equals(id)){
                return Optional.of(currentTask);
            }
        }
        return Optional.empty();
    }

    public Optional<Task> findByIdStream(Integer id){
        return tasks.stream()
                .filter(currentTask -> currentTask.getId().equals(id))
                .findFirst();
    }

    public Optional<Task> findByName(String name){
        for(Task currentTask : tasks){
            if(currentTask.getTaskName().equals(name)){
                return Optional.of(currentTask);
            }
        }
        return Optional.empty();
    }

    public Optional<Task> findByNameStream(String name){
        return tasks.stream()
                .filter(currentTask -> currentTask.getTaskName().equals(name))
                .findFirst();
    }

}
