package code.backend.service;

import code.backend.dto.RequestDto;
import code.backend.dto.ResponseDto;
import code.backend.entity.Task;
import code.backend.repository.TaskRepository;
import code.backend.service.validation.Validation;

import java.util.List;
import java.util.Optional;

public class TaskServiceFind {

    private final TaskRepository repository;
    private final Validation validation;

    public TaskServiceFind(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

//    public Optional<Task> FindTaskById(RequestDto requestDto){
//        return repository.findById(requestDto.getId());
//    }
//
//    public Optional<Task> FindTaskByName(RequestDto requestDto){
//        Optional<Task> foundedByName = repository.findByName(requestDto.getName());
//        if (foundedByName.isPresent()){
//            return foundedByName;
//        } else {
//            return Optional.empty();
//        }
//    }

    public ResponseDto<Task> findTaskById(RequestDto requestDto) {
        System.out.println("Received request: " + requestDto);
        List<String> errors = validation.validate(requestDto);

        if (errors.isEmpty()) {
            Optional<Task> taskToFind = repository.findById(requestDto.getId());
            Task task = new Task(requestDto.getId(), requestDto.getName(), requestDto.getDescription());
            return new ResponseDto<>(200, task, errors);
        } else {
            return new ResponseDto<>(400, new Task(), errors);
        }
    }
}
