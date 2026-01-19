import java.util.Scanner;

//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("Hello, Java!");
//    }
//
//}


//public class Main {
//
//    public static void main(String[] args) {
//
//        int a = 5;
//        int b = 3;
//
//        int sum = a + b;
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("sum = " + sum);
//
//    }
//
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter your name: ");
//        String name = scanner.nextLine();
//
//        System.out.println("Hello, " + name + "!");
//    }
//}


// TASK 1

//public class Main {
//    public static void main(String[] args) {
//
//        int a = 7;
//        int b = 12;
//
//       int sum = a + b;
//
//       System.out.println(a + " + " + b + " = " + sum);
//
//    }
//}


// TASK 2

//public class Main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter your name: ");
//        String name = scanner.nextLine();
//
//        System.out.println("Hello, " + name + "!");
//
//    }
//}


// TASK 3
//public class Main {
//    public static void main(String[] args) {
//
//        int number = 10;
//
//        if (number > 5) {
//            System.out.println("Big number");
//        } else {
//            System.out.println("Small number");
//        }
//
//
//    }
//}


// TASK 4
//public class Main {
//    public static void main(String[] args) {
//
//        for (int i=1; i<6; i++) {
//            System.out.println(i);
//        }
//
//    }
//}



// HomeTask
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Do you want to continue  (yes/no) --->");
//        String answer = scanner.next();
//        while (answer.equalsIgnoreCase("no")) {
//            System.out.print("Enter a first number --->");
//            int a = scanner.nextInt();
//            System.out.print("Enter a second number --->");
//            int b = scanner.nextInt();
//            System.out.print("Choose operation (+, -, *, /) --->");
//            char c = scanner.next().charAt(0);
//
//
//            if (c == '+') {
//                int plus = a + b;
//                System.out.println(a + "+" + b + "=" + plus);
//            }
//            else if (c == '-'){
//                int minus  = a - b;
//                System.out.println(a + "-" + b + "=" + minus);
//            }
//            else if (c == '*') {
//                int multiply = a * b;
//                System.out.println(a + "*" + b + "=" + multiply);
//            }
//            else if (c == '/'){
//                if (a == 0 || b == 0){
//                    System.out.println("We can't divide for 0");
//                }else{
//                    float divide = a / b;
//                    System.out.println(a + "/" + b + "=" + divide);
//                }
//
//            }
//
//
//            if (answer.equalsIgnoreCase("no")) {
//                System.out.println("Game Over!!");
//                break;
//            }
//            else if (answer.equalsIgnoreCase("yes")){
//                continue;
//            } else{
//                System.out.println("Choose right option!!");
//                break;
//            }
//        }
//
//    }
//}


// 19.01.26
//Task 1

// A

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1 task


//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if (x > 0) {
//            System.out.println("positive");
//        }
//        else if (x < 0) {
//            System.out.println("negative");
//        }
//        else{
//            System.out.println("zero");
//        }

        // 2 task

//        System.out.print("Enter a first number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a second number -->");
//        int b = scanner.nextInt();
//        if(a > b) {
//            System.out.println(a);
//        }
//        else if (b > a) {
//            System.out.println(b);
//        } else {
//            System.out.println("equals");
//        }

        //3 task

//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//
//        if (x % 2 == 0) {
//            System.out.println("чётное");
//        }else {
//            System.out.println("нечётное");
//        }

        // 4 task

//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if (x % 3 == 0 && x % 5 == 0) {
//            System.out.println("We can divide   " + x + "   for 3 and 5");
//        }else {
//            System.out.println("We can't divide" + x + "  for 3 and 5");
//        }


        // 5 task

//        System.out.print("Enter a first number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a second number -->");
//        int b = scanner.nextInt();
//        System.out.print("Enter third number -- >");
//        int c = scanner.nextInt();
//        if (a > b && a > c) {
//            System.out.println("the biggest number   " + a);
//        } else if (b > a && b > c){
//            System.out.println("the biggest number   " + b);
//        }else{
//            System.out.println("the biggest number   " + c);
//        }


        // 6 task
//        System.out.print("Enter a first number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a second number -->");
//        int b = scanner.nextInt();
//        System.out.print("Enter third number -- >");
//        int c = scanner.nextInt();
//        if (a > c && b > c) {
//            System.out.println("the smallest number   " + c);
//        } else if (b > a && c > a){
//            System.out.println("the smallest number   " + a);
//        }else{
//            System.out.println("the smallest number   " + b);
//        }


        // 7 task
//        System.out.print("your a age -->");
//        int age = scanner.nextInt();
//        if (age > 18) {
//            System.out.println("you are adult");
//        }
//        else {
//            System.out.println("you are child");
//        }

        // 8 task

//        System.out.print("your a score -->");
//        int score = scanner.nextInt();
//        if (score >= 50) {
//            System.out.println("you pass");
//        }else {
//            System.out.println("you fail");
//        }


        // 9 task
//        System.out.print("your a score -->");
//        int score = scanner.nextInt();
//        if (score >= 90) {
//            System.out.println("A");
//        }else if (score >= 80 && score < 90) {
//            System.out.println("B");
//        }else if (score >= 70 && score < 80) {
//            System.out.println("C");
//        }else if (score >= 60 && score < 70) {
//            System.out.println("D");
//        }else {
//            System.out.println("F");
//        }

        // Task 10

//        System.out.print("Enter a first number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a second number -->");
//        int b = scanner.nextInt();
//        System.out.print("Enter third number -- >");
//        int c = scanner.nextInt();
//        if (a+b > c && c+b > a && c+a > b) {
//            System.out.println("It can be triangle");
//        }else {
//            System.out.println("It can't be triangle");
//        }


        // Task 11

//        System.out.print("Enter a year -->");
//        int year = scanner.nextInt();
//        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
//            System.out.println("високосный");
//        }else {
//            System.out.println("не високосный");
//        }


        // task 12
//        System.out.print("Enter a year -->");
//        int x = scanner.nextInt();
//        if (x >= 10 && x <= 20){
//            System.out.println("in");
//        }else {
//            System.out.println("out");
//        }

        // task 13
//        System.out.print("Enter a year -->");
//        int temp = scanner.nextInt();
//        if(temp < 0){
//            System.out.println("freezing");
//        }else if(temp >= 0 && temp <= 15){
//            System.out.println("cold");
//        }else if(temp >= 16 && temp <= 25){
//            System.out.println("warm");
//        }else{
//            System.out.println("hot");
//        }


        // task 14
//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if (x >= 10 && x < 100){
//            System.out.println("two-digit");
//        }else{
//            System.out.println("not");
//        }

        // task 15

//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if(x % 2 == 0 || x % 7 == 0){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//        }

        // task 16
//        System.out.print("Enter a number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a number -->");
//        int b = scanner.nextInt();
//        if (b != 0){
//            System.out.println(a + " / " + b + " = " + a/b);
//        }else{
//            System.out.println("division by zero");
//        }

        // task 17
//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if (x >= 0){
//            System.out.println(x*x);
//        }else{
//            System.out.println(x*x*x);
//        }

        // task 18

//        System.out.print("enter a login -- >");
//        String login = scanner.nextLine();
//        System.out.print("enter a password -- >");
//        String password = scanner.nextLine();
//        if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")){
//            System.out.println("access granted");
//        }else{
//            System.out.println("denied");
//        }

        // task 19

        System.out.print("Enter a number -->");
        int a = scanner.nextInt();
        System.out.print("Enter a number -->");
        int b = scanner.nextInt();
        System.out.print("Enter a number -->");
        int c = scanner.nextInt();
        if (a == b && a == c){
            System.out.println("equilateral");
        }else if (b == c || c == a || a == b){
            System.out.println("isosceles");
        }else{
            System.out.println("scalene");
        }

































    }
}
