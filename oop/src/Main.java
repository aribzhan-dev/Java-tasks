class Students {
    private String firstName;
    private String lastName;
    private String group;
    private double gpa;

    public Students(String firstName, String lastName, String group, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.gpa = gpa;
    }


    public String fullName() {
        return lastName + " " + firstName;
    }

    public boolean isExcellent() {
        return gpa >= 3.67;
    }
}


class Rectangle{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double area(){
        return width * height;
    }

    public double perimetr(){
        return (width + height) * 2;
    }

    public boolean isSquare(){
        return width == height;
    }

}



class BankAccount {
    private String ownerName;
    private double balance;


    public BankAccount(String ownerName, double balance){
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public double deposit(double amount){
        return balance + amount;
    }

    public double withdraw(double amount){
        if (balance >= amount){
            return balance - amount;
        } else {
            return 0.0;
        }
    }
}

class Main {
    public static void main(String[] args) {

        Students student1 = new Students(
                "Aribzhan",
                "Kamilzhanov",
                "SE2403",
                3.67
        );

        Rectangle rec = new Rectangle(
                3,
                3
        );


        BankAccount bank = new BankAccount(
                "Aribzhna",
                0.0
        );


        System.out.println(student1.fullName());
        System.out.println(student1.isExcellent());
        System.out.println(rec.area());
        System.out.println(rec.perimetr());
        System.out.println(rec.isSquare());
        System.out.println(bank.deposit(100));
        System.out.println(bank.withdraw(110));


    }
}