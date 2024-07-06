package controllers;

import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;


public class LabworkController {
	
	private final LabworkRepo labworkRepo;
    private final CsvFileRepo fileRepo;
    Scanner scanner;

    public LabworkController(String filepath) {
        this.labworkRepo = new LabworkRepo();
        this.fileRepo = new CsvFileRepo(filepath);
        this.scanner = new Scanner(System.in);
        this.loadFile();
    }

    public void handleSaveCommand() {
        Collection<Labwork> labworkList = this.labworkRepo.getValues();
        this.fileRepo.save(labworkList);
    }

    public void handleClearCommand() {
        this.labworkRepo.clear();
    }

    private void loadFile() {
        Collection<Labwork> labworkList = this.fileRepo.load();
        for (Labwork labwork : labworkList) {
            this.labworkRepo.add(labwork);
        }
    }

    public Collection<Labwork> handleShowCommand() {
        return this.labworkRepo.getValues();
    }

//    public void handleAddCommand(int id, String labName, int minimalPoint, models.Labwork.Difficulty difficulty, models.Person author) {
public void handleAddCommand(int id, String labName, int minimalPoint, models.Labwork.Difficulty difficulty, String author) {
        this.labworkRepo.add(new Labwork(id, labName, minimalPoint, difficulty, author));
    }

    public void HelpRead() throws IOException {
        File f = new File("help.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);
    }

    /*
    // Метод для вывода информации о коллекции
    public void info() {
        System.out.println("Тип коллекции: ArrayList<LabWork>");
        System.out.println("Количество элементов: " + labworkList.size());
    }

    // Метод для вывода всех элементов коллекции
        public void show() {
        for (Labwork labWork : labworkList) {
            System.out.println(labwork);
        }
    }
*/
}