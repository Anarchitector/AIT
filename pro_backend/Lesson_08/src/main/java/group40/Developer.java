package group40;

public class Developer {
    private int id;
    private String name;
    private String speciality;
    private int salary;

    public Developer(int id, String name, String speciality, int salary) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", salary=" + salary +
                '}';
    }
}
