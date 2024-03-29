public class Employee {
    private final String fio;
    private String department;
    private int salary;
    private static int counterId;
    private int id;

    public String getFio() {
        return fio;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getCounterId() {
        return counterId;
    }

    public int getId() {
        return id;
    }
}
