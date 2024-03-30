public class Main {

    private final static int EMPLOYEE_NUMBER = 10;

    private static Employee[] employees = new Employee[EMPLOYEE_NUMBER];

    public static void main(String[] args) {

        employees[0] = new Employee("Иван Иванович 1", 1, 100_000);
        employees[1] = new Employee("Иван Иванович 2", 2, 120_000);
        employees[2] = new Employee("Иван Иванович 3", 3, 130_000);
        employees[3] = new Employee("Иван Иванович 4", 4, 140_000);
        employees[4] = new Employee("Иван Иванович 5", 1, 150_000);
        employees[5] = new Employee("Иван Иванович 6", 2, 160_000);
        employees[6] = new Employee("Иван Иванович 7", 3, 170_000);
        employees[7] = new Employee("Иван Иванович 8", 4, 180_000);
        employees[8] = new Employee("Иван Иванович 9", 5, 190_000);
        employees[9] = new Employee("Иван Иванович 10", 5, 200_000);

        printEmployees();

        int salarySum = getSalarySum();
        System.out.println("Сумма всех зарплат: " + salarySum);

        System.out.println("Сотрудник с минимальной зарплатой: " + getEmployeeMinSalary());

        System.out.println("Сотрудник с максимальной зарплатой: " + getEmployeeMaxSalary());

        System.out.println("Средняя зарплата: " + getAverageSalary());

        printEmployeeFio();
    }

    private static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    private static int getSalarySum() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee getEmployeeMinSalary() {
        Employee employeeMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    private static Employee getEmployeeMaxSalary() {
        Employee employeeMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    private static double getAverageSalary() {
        return (double) getSalarySum() / EMPLOYEE_NUMBER;
    }

    private static void printEmployeeFio() {
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getFio());
        }
    }
}