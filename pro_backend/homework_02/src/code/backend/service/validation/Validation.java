package code.backend.service.validation;

import code.backend.dto.RequestDto;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public List<String> validate(RequestDto requestDto){
        List<String> errors = new ArrayList<>();

        if (requestDto.getName() == null) {
            errors.add("Task name cannot be null");
        }
        if (requestDto.getDescription() == null) {
            errors.add("Task description cannot be null");
        }
        if (requestDto.getName().length() < 3) {
            errors.add("Task name must be at least 3 characters");
        }
        if (requestDto.getName().length() > 15) {
            errors.add("Task name cannot be longer than 15 characters");
        }
        if (requestDto.getDescription().length() < 3) {
            errors.add("Task description must be at least 3 characters");
        }
        if (requestDto.getDescription().length() > 25) {
            errors.add("Task description cannot be longer than 25 characters");
        }
        if (requestDto.getId() == null) {
            errors.add("Task ID cannot be null");
        }

        return errors;
    }
}
