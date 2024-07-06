import controllers.LabworkController;
import views.CLIview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Вы не указали путь до файла");
            return;
        }

        CLIview view = new CLIview();
        view.run(args[0]);
    }
}