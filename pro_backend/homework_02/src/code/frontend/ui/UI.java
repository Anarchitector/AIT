package code.frontend.ui;

import code.backend.dto.RequestDto;
import code.backend.dto.ResponseDto;
import code.backend.entity.Task;
import code.backend.service.TaskServiceAdd;
import code.backend.service.TaskServiceFind;

import java.util.Scanner;

public class UI {

    private final TaskServiceAdd addService;
    private final TaskServiceFind findService;

    public UI(TaskServiceAdd addService, TaskServiceFind findService) {
        this.addService = addService;
        this.findService = findService;
    }

    public void start() {

        while(true){
            System.out.println("Please enter your choice");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by ID");
            System.out.println("3. Find task by name");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);
            String taskName;
            String taskDescription;
            ResponseDto<Task> responseDto;


            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1:
                    System.out.println("Please enter the task name");
                    taskName = scanner.nextLine();
                    System.out.println("Please enter the task description");
                    taskDescription = scanner.nextLine();

                    responseDto = addService.addNewTask(new RequestDto(taskName, taskDescription));

                    if (responseDto.getResponseCode() == 200) {
                        System.out.println("Task added successfully");
                    } else {
                        System.out.println(responseDto.getErrors());
                    }
                    break;
                case 2:
                    System.out.println("Please enter the task ID");
                    Integer taskId = scanner.nextInt();

                    responseDto = findService.findTaskById(new RequestDto(taskId));

                    if (responseDto.getResponseCode() == 200) {
                        System.out.println("Task found successfully");
                    } else {
                        System.out.println(responseDto.getErrors());
                    }
                    break;
                case 3:

                    break;
                case 4 :
                    System.exit(0);
                    break;
            }
        }
    }
}
