abstract class Employee {
    protected int  id;
    protected String name;
    protected double baseSalary;

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();
    abstract String getRole();

    public void printInfo(){
        System.out.println("ID   :" +  id);
        System.out.println("NAME   :" +  name);
        System.out.println("ROLE   :" +  getRole());
        System.out.println("SALARY   :" +  calculateSalary());
    }


}

class Manager extends Employee {
    private double bonusPercent;

    public Manager(int id, String name, double baseSalary, double bonusPercent) {
        super(id, name, baseSalary);
        this.bonusPercent = bonusPercent;
    }

    @Override
    public double calculateSalary(){
        return baseSalary + (baseSalary * bonusPercent / 100);
    }

    @Override
    public String getRole(){
        return "Manager";
    }

}



class Developer extends Employee{
    private int completedProjects;

    public Developer(int id, String name, double baseSalary, int completedProjects){
        super(id, name, baseSalary);
        this.completedProjects = completedProjects;
    }

    @Override
    public double calculateSalary(){
        return baseSalary + (completedProjects * 10000);
    }

    @Override
    public String getRole(){
        return "Developer";
    }

}

class Intern extends Employee {
    public Intern(int id, String name) {
        super(id, name, 50000);
    }

    @Override
    public double calculateSalary(){
        return 50000;
    }

    @Override
    public String getRole(){
        return "Intern";
    }
}


public class Abstract {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager(1, "Алишер Каримов", 3_000_000, 20),
                new Manager(2, "Зульфия Рахимова", 2_500_000, 15),
                new Developer(3, "Бобур Ташматов", 2_000_000, 5),
                new Developer(4, "Нодира Юсупова", 1_800_000, 8),
                new Intern(5, "Жасур Мирзаев"),
                new Intern(6, "Малика Саидова")
        };

        System.out.println("\n СПИСОК ВСЕХ СОТРУДНИКОВ:");
        for (Employee emp : employees) {
            emp.printInfo();
        }

        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.calculateSalary();
        }
        System.out.println("\n Общий фонд зарплат: " + totalSalary + " тенге");


        Employee topEmployee = employees[0];
        for (Employee emp : employees) {
            if (emp.calculateSalary() > topEmployee.calculateSalary()) {
                topEmployee = emp;
            }
        }
        System.out.println("\n Сотрудник с наибольшей зарплатой: " + topEmployee.name);
        System.out.println("   Зарплата: " + topEmployee.calculateSalary() + " тенге");
    }
}
