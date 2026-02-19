//class Students {
//    private String firstName;
//    private String lastName;
//    private String group;
//    private double gpa;
//
//    public Students(String firstName, String lastName, String group, double gpa) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.group = group;
//        this.gpa = gpa;
//    }
//
//
//    public String fullName() {
//        return lastName + " " + firstName;
//    }
//
//    public boolean isExcellent() {
//        return gpa >= 3.67;
//    }
//}
//
//
//class Rectangle{
//    private double width;
//    private double height;
//
//    public Rectangle(double width, double height){
//        this.width = width;
//        this.height = height;
//    }
//
//    public double area(){
//        return width * height;
//    }
//
//    public double perimetr(){
//        return (width + height) * 2;
//    }
//
//    public boolean isSquare(){
//        return width == height;
//    }
//
//}
//
//
//
//class BankAccount {
//    private String ownerName;
//    private double balance;
//
//
//    public BankAccount(String ownerName, double balance){
//        this.ownerName = ownerName;
//        this.balance = balance;
//    }
//
//    public double deposit(double amount){
//        return balance + amount;
//    }
//
//    public double withdraw(double amount){
//        if (balance >= amount){
//            return balance - amount;
//        } else {
//            return 0.0;
//        }
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//
//        Students student1 = new Students(
//                "Aribzhan",
//                "Kamilzhanov",
//                "SE2403",
//                3.67
//        );
//
//        Rectangle rec = new Rectangle(
//                3,
//                3
//        );
//
//
//        BankAccount bank = new BankAccount(
//                "Aribzhna",
//                0.0
//        );
//
//
//        System.out.println(student1.fullName());
//        System.out.println(student1.isExcellent());
//        System.out.println(rec.area());
//        System.out.println(rec.perimetr());
//        System.out.println(rec.isSquare());
//        System.out.println(bank.deposit(100));
//        System.out.println(bank.withdraw(110));
//
//
//    }
//}


import java.util.*;

class Driver {
    private String name;
    private String surname;
    private int age;
    private String carModel;
    private double rating;


    public Driver (String name, String surname, int age, String carModel,
                   double rating){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.carModel = carModel;
        this.rating = rating;
    }


    public String getName() {
        return name + " " + surname;
    }

    public String getInfo() {
        return name + " - " + carModel + " (" + rating + ")";
    }

}

class Customer {
    private String name;
    private String surname;
    private String location;


    public Customer(String name, String surname, String location){
        this.name = name;
        this.surname = surname;
        this.location = location;
    }


    public String getName() {
        return name + " " + surname;
    }

    public String getInfo(){
        return name + " " + location;
    }

}

class Trip {
    private String startLocation;
    private String finalLocation;
    private double distance;
    private double price;
    private Driver driver;
    private Customer customer;

    public Trip(String startLocation, String finalLocation, double distance,                                        Driver driver, Customer customer){
        this.startLocation = startLocation;
        this.finalLocation = finalLocation;
        this.distance = distance;
        calculatePrice();
        this.driver = driver;
        this.customer = customer;
    }

    public void calculatePrice(){
        price = distance * 500;
    }

    public double getPrice(){
        return price;
    }


    public String getInfo() {
        return customer.getName() + " trip with " + driver.getInfo();
    }

    public String whereGoing(){
        return "We are going to " + finalLocation + "from " + startLocation;
    }

}



class TaxiService{
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Trip> trips = new ArrayList<>();

    public void addDriver(Driver driver){
        drivers.add(driver);
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    public void allDrivers(){
        for (Driver d: drivers){
            System.out.println(d.getInfo());
        }
    }

    public double totalIncome(){
        double sum = 0;
        for (Trip t: trips){
            sum += t.getPrice();
        }
        return sum;
    }


    public void allTrips() {
        for (Trip t : trips) {
            System.out.println(t.getInfo());
        }
    }


}




class Main {
    public static void main(String[] args) {

        Driver d1 = new Driver("Aribzhan", "Kamilzhanov", 21, "BMW", 4.8);
        Driver d2 = new Driver("Zair", "Shukhratov", 21, "Mercides", 4.5);

        Customer c1 = new Customer("Ais", "Ais", "Astana");
        Customer c2 = new Customer("Ali", "Aliev", "Astana");

        Trip t1 = new Trip("Mangilic el C1", "Turkestan 10", 2, d1, c1);
        Trip t2 = new Trip("Mangilic el C2", "Turkestan 15", 2.5, d2, c2);

        TaxiService service = new TaxiService();
        service.addTrip(t1);
        service.addTrip(t2);

        service.allTrips();
        service.allDrivers();
        System.out.println("Total income: " + service.totalIncome());






    }
}