//package code.backend.service;
//
//import code.backend.dto.RequestDto;
//import code.backend.dto.ResponseDto;
//import code.backend.entity.Task;
//import code.backend.repository.TaskRepository;
//import code.backend.service.validation.Validation;
//
//import java.util.List;
//import java.util.Optional;
//
//public class TaskServiceDelete {
//
//    private final TaskRepository repository;
//    private final Validation validation;
//
//    public TaskServiceDelete(TaskRepository repository, Validation validation) {
//        this.repository = repository;
//        this.validation = validation;
//    }
//
//    public ResponseDto<Task> deleteTaskById(RequestDto requestDto) {
//        System.out.println("Received request: " + requestDto);
//        List<String> errors = validation.validate(requestDto);
//
//        if(errors.isEmpty()) {
//            if (repository.deleteById(requestDto.getId())){
//                return new Task
//            }
//            Task task = new Task
//
//        }
//    }
//}
