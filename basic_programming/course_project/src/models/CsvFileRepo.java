package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileRepo {
    private String filepath;

    public CsvFileRepo(String filepath) {
        this.filepath = filepath;
    }

    public void save(Collection<Labwork> data) {
        // записывает данные элеменов
        // коллекции в файл
        // в формате CSV

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Labwork labwork : data) {
                String line = labwork.getCSVLine();
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public Collection<Labwork> load() {
        Collection<Labwork> labworkList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filepath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                Labwork labwork = Labwork.parseFromCSV(line);
                labworkList.add(labwork);
            }
            return labworkList;
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return null;
        }
        // читает файл
        // формирует объекты
        // помещает их в список
        // и возвращает в качестве значения
    }
}
