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

        int indexPercent = 10;
        indexSalary(indexPercent);

        salarySum = getSalarySum();
        System.out.println("Сумма всех зарплат после индексации: " + salarySum);

        int currentDepartment = 2;
        System.out.println("Сотрудник с минимальной зарплатой в отделе: " + currentDepartment + " - " + getEmployeeMinSalary(currentDepartment));

        System.out.println("Сотрудник с максимальной зарплатой в отделе: " + currentDepartment + " - " + getEmployeeMaxSalary(currentDepartment));

        salarySum = getSalarySum(currentDepartment);
        System.out.println("Сумма всех зарплат в отделе: " + currentDepartment + " - " + salarySum);

        System.out.println("Средняя зарплата в отделе: " + currentDepartment + " - " + getAverageSalary(currentDepartment));

        indexPercent = 5;
        indexSalary(indexPercent, currentDepartment);

        System.out.println("Список сотрудников после повторной индексации в отделе: " + currentDepartment);
        printEmployees(currentDepartment);
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

    private static void indexSalary(int percent) {
        int currentSalary;
        for (Employee employee : employees) {
            currentSalary = employee.getSalary();
            employee.setSalary(currentSalary + (currentSalary / 100 * percent));
        }
    }

    private static Employee getEmployeeMinSalary(int department) {
        Employee employeeMinSalary = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employeeMinSalary == null || employee.getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    private static Employee getEmployeeMaxSalary(int department) {
        Employee employeeMaxSalary = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employeeMaxSalary == null || employee.getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    private static int getSalarySum(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    private static double getAverageSalary(int department) {
        int sum = 0;
        int countOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
            countOfEmployees++;
        }
        return (double) sum / countOfEmployees;
    }

    private static void indexSalary(int percent, int department) {
        int currentSalary;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            currentSalary = employee.getSalary();
            employee.setSalary(currentSalary + (currentSalary / 100 * percent));
        }
    }

    private static void printEmployees(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            System.out.println(employee.toStringWithoutDep());
        }
    }
}