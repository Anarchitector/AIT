package models;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import utils.Utils;

public class Labwork implements Comparable <Labwork> {
    private Integer id;
    //Поле не может быть null, Значение поля должно быть больше 0,
    //Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String labName; //Поле не может быть null, Строка не может быть пустой
    private Integer minimalPoint; //Поле не может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
//    private Person author; //Поле может быть null
    private String author;
    private static int counter = 0;

    public Labwork() {
        this.id = 0;
        this.labName = "name";
        this.minimalPoint = 1;
        this.difficulty = Difficulty.VERY_EASY;
//        this.author = new Person("name","0");
        this.author = "author";
        Labwork.counter++;
        this.id = ThreadLocalRandom.current().nextInt();
    }

//    public Labwork(int id, String labName, int minimalPoint, Difficulty difficulty, Person author) {
    public Labwork(int id, String labName, int minimalPoint, Difficulty difficulty, String author) {
        this.id = id;
        this.labName = labName;
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    public enum Difficulty {
        VERY_EASY,
        EASY,
        NORMAL,
        VERY_HARD,
        INSANE;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*
    public void setLabName(String labName) {

        if (labName.equals(null)) {
            System.out.println("Поле не может быть NULL");
        } else if (labName.isEmpty()) {
            System.out.println("Строка не может быть пустой");
        } else {
            this.labName = labName;
        }
    }
*/

    // Getters
    public Integer getID() { return id; }
    public String getLabName() { return labName; }
    public Integer getMinimalPoint() { return minimalPoint; }
    public Difficulty getDifficulty() { return difficulty; }
//    public Person getAuthor() { return author; }
    public String getAuthor() { return author; }

    public int generateID() {
        return ThreadLocalRandom.current().nextInt();
    }

    // Setters
    public void setID(Integer id) { this.id = id; }
//    public void setLabName(String name) { this.labName = name; }
    public void setMinimalPoint(Integer minimalPoint) { this.minimalPoint = minimalPoint; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
//    public void setAuthor(Person author) { this.author = author; }
    public void setAuthor(String author) { this.author = author; }

    public static boolean validateId(Integer id) {
        return (id == null || id <=0);
    }
    public static boolean validateName(String name) {
        return (name == null || name.isEmpty());
    }
    public static boolean validateDiffculty(Difficulty difficulty) {
        return (difficulty == null);
    }
    public static boolean validateMinimalPoint(Person author) {
        return (author == null);
    }
    //Validators
    public void validateID(Integer id) throws Exception{
        if (id == null || id <=0){
            throw new Exception("Введенное значение поля ID не соответствует требованиям");
        }
    }

    public void validateLabName(String name) throws Exception{
        if (name == null || name.isEmpty())
            throw new Exception("Введенное значение поля ID не соответствует требованиям");
    }
    public void validateDifficulty(Difficulty difficulty) throws Exception{
        if (difficulty == null)
            throw new Exception("Поле не может быть null");
    }

    public void validateAuthor(Person author) throws Exception{
        if (author == null)
            throw new Exception("Поле не может быть null");
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return  "Labwork " +
                "id=" + id +
                ", labName='" + labName + '\'' +
                ", author=" + author +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Labwork movie = (Labwork) o;
        return getId() == movie.getId() && Objects.equals(getLabName(), ((Labwork) o).getLabName())
                && Objects.equals(getAuthor(), ((Labwork) o).getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabName(), getAuthor());
    }


    @Override
    public int compareTo(Labwork o) {// переопределяем метод, приводим результат к int
        return (int)(this.getId() - o.getId());
    }

    public String getCSVLine() {
        return id + ";" +
               labName + ";" +
               minimalPoint  + ";" +
               difficulty + ";" +
               author;
    }
/*
    public Labwork(int id, String labName, int String author) throws Exception {
        if (!validateId(id)) {
            throw new Exception("ID is not correct");
        }

        this.labName = labName;
//        this.author = new Person(author, passportID);
        this.author = author;
        Labwork.counter++;
        this.id = id;
    }
*/
    public static Labwork parseFromCSV(String line) {
        // "id;Labwork Name;Minimal Point;difficulty;Author"
        String[] parts = line.split(";");

        if (!Utils.isInt(parts[0])) {
            return null;
        }
        int id = Integer.parseInt(parts[0]);

        if (!Utils.isInt(parts[2])) {
            return null;
        }
        int minimalPoint = Integer.parseInt(parts[2]);

        if (!Utils.isEnum(parts[3], Difficulty.class)) {
                return null;
        }
        Difficulty difficulty = Difficulty.valueOf(parts[3]);

        try {
            Labwork labwork = new Labwork(
                id,
                parts[1],
                minimalPoint,
                difficulty,
                parts[4]
            );
            return labwork;
        } catch (Exception e) {
            return null;
        }
    }
}