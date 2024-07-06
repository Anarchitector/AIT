package views;

import controllers.LabworkController;
import models.Labwork;
import java.util.Collection;
import java.util.*;
import java.io.IOException;

public class CLIview {
    LabworkController labworkController;

    public void startIntro() { //начальное сообщение с приглашением к выбору команды
        System.out.println(
            "Выберите команду из списка. \n\n" +
                "help | save | info | show | add | update {id} | remove_by_id {id } | clear | exit");
        System.out.print("Введите выбранную команду: ");
    }

    public void run(String filepath) {
        //создан объект класса Manager
        labworkController = new LabworkController(filepath);

        //начало работы с пользовательским вводом
        Scanner scanner = new Scanner(System.in);
        String usersLine;// строка ввода пользователя

        System.out.println("Вас приветствует LabworkCollection!\n");

        do { // работу цикла надо проверить, когда напишем методы
            this.startIntro();// выводим приветствие и набор команд. ожидаем ввод пользователя
            usersLine = scanner.nextLine();// считывание ввода пользователя
            String[] lineInParts = null;//вводим переменные для последующей обработки строк с пробелами
            String argIn = null;

            if (usersLine.contains(" ")) { //если строка с командой пользователя содержит пробел,
                lineInParts = usersLine.split(" ");//делим строку на части до и после пробела с помощью метода split.
                // Метод возвращает String[]
                // 1я часть - команда, 2я - аргумент
            }

            if (lineInParts != null && lineInParts.length == 2) {
                usersLine = lineInParts[0];// 1я часть - команда
                argIn = lineInParts[1];// 2я часть - аргумент (например, id)
            }

            switch (usersLine) {
                case "help":
                    try {
                        if (filepath == null) {
                            throw new IllegalArgumentException("Файл не найден");
                        }
                        labworkController.HelpRead();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "save":
                    this.startSaveCommand();
                    break;
                case "show":
                    this.startShowCommand();
                    break;
                case "clear":
                    this.startClearCommand();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Вы ввели неверную команду. Попробуйте ещё раз: ");
                    continue;
            }
        } while (!usersLine.equals("exit"));
    }

    private void startShowCommand() {
        Collection<Labwork> labworkList = labworkController.handleShowCommand();
        for (Labwork labwork : labworkList) {
            System.out.println(labwork);
        }
    }

    public void startSaveCommand() {
        System.out.println("Сохраняем элементы...");
        this.labworkController.handleSaveCommand();
    }

    public void startClearCommand() {
        System.out.println("Очищаем элементы...");
        this.labworkController.handleClearCommand();
    }
}
