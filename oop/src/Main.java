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



// Delivery Service

import java.util.*;


class Courier {
    private String name;
    private String surname;
    private String phone;
    private String transportType;
    private double rating;


    public Courier (String name, String surname, String phone, String transportType,
                   double rating){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.transportType = transportType;
        this.rating = rating;
    }


    public String getName() {
        return name + " " + surname;
    }

    public String getInfo() {
        return name + " - " + transportType + " (" + rating + ")";
    }

}

class Customer {
    private String name;
    private String surname;
    private String address;
    private String phone;


    public Customer(String name, String surname, String address, String phone){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }


    public String getName() {
        return name + " " + surname;
    }

    public String getInfo(){
        return name + " " + address + " tel:" + phone;
    }

}

enum DeliveryStatus {
    CREATED,
    ON_THE_WAY,
    DELIVERED
}

class DeliveryPackage{
    private int id;
    private double weight;
    private String fromAddress;
    private String toAddress;
    private DeliveryStatus status;



    public DeliveryPackage(int id, double weight, String fromAddress, String toAddress){
        this.id = id;
        this.weight = weight;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.status = DeliveryStatus.CREATED;
    }

    public void setStatus(DeliveryStatus status){
        this.status = status;
    }

    public String getInfo(){
        return id + ":" + weight + " ---- " + fromAddress + " --->" + toAddress + " status: " + status;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

}



class Delivery {
    private DeliveryPackage deliveryPackage;
    private Courier courier;
    private Customer customer;


    public Delivery(DeliveryPackage deliveryPackage, Courier courier, Customer customer){
        this.deliveryPackage = deliveryPackage;
        this.courier = courier;
        this.customer = customer;
    }

    public void startDelivery(){
        deliveryPackage.setStatus(DeliveryStatus.ON_THE_WAY);
    }

    public void finishDelivery(){
        deliveryPackage.setStatus(DeliveryStatus.DELIVERED);

    }

    public String getInfo(){
        return courier.getInfo() + " is delivering " + deliveryPackage.getInfo() + " to " + customer.getInfo();
    }

    public DeliveryStatus getStatus() {
        return deliveryPackage.getStatus();
    }


}


class DeliveryHistory{
    private List<Delivery> history = new ArrayList<>();


    public void addToHistory(Delivery delivery){
        if(delivery.getStatus() == DeliveryStatus.DELIVERED){
            history.add(delivery);
        } else {
            System.out.println("Delivery is not finished yet.");
        }
    }

    public void showHistory(){
        for (Delivery d: history){
            System.out.println(d.getInfo());
        }
    }
}


class DeliveryService {

    private List<Delivery> deliveries = new ArrayList<>();
    private DeliveryHistory history = new DeliveryHistory();


    public void startDelivery(Delivery delivery){
        delivery.startDelivery();
    }

    public void finishDelivery(Delivery delivery){
        delivery.finishDelivery();
        history.addToHistory(delivery);
    }

    public void allDeliveries(){
        for(Delivery d : deliveries){
            System.out.println(d.getInfo());
        }
    }

    public void showHistory(){
        history.showHistory();
    }
}







class Main {
    public static void main(String[] args) {


        Customer cus1 = new Customer(
                "Aribzhan",
                "Kamilzhanov",
                "Mangilik EL C1",
                "+77079928009"
        );

        Courier cour1 = new Courier(
                "Zair",
                "Shukhratov",
                "+77756270762",
                "Car",
                4.8
        );

        DeliveryPackage pack1 = new DeliveryPackage(
                1,
                3.5,
                "Turkestan 10",
                "Mangilik El 10"
        );

        DeliveryPackage pack2 = new DeliveryPackage(
                1,
                3.5,
                "Turkestan 13",
                "Mangilik El 35"
        );

        Delivery d = new Delivery(pack1, cour1, cus1);
        d.finishDelivery();
        d.startDelivery();

        DeliveryService delSer = new DeliveryService();
        delSer.allDeliveries();
        delSer.showHistory();



    }
}