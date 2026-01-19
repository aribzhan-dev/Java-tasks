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

//        System.out.print("Enter a number -->");
//        int a = scanner.nextInt();
//        System.out.print("Enter a number -->");
//        int b = scanner.nextInt();
//        System.out.print("Enter a number -->");
//        int c = scanner.nextInt();
//        if (a == b && a == c){
//            System.out.println("equilateral");
//        }else if (b == c || c == a || a == b){
//            System.out.println("isosceles");
//        }else{
//            System.out.println("scalene");
//        }

        // task 20
//        System.out.print("Enter a number -->");
//        int x = scanner.nextInt();
//        if (x > 0) {
//            if (x % 2 == 0) {
//                System.out.println("positive even");
//            }else {
//                System.out.println("positive odd");
//            }
//        }else{
//            System.out.println("non-positive");
//        }



        // B) switch

        // task 1
        //       System.out.print("Enter a day number");
//        int day = scanner.nextInt();
//
//        switch (day) {
//            case 1 -> System.out.println("Monday");
//            case 2 -> System.out.println("Tuesday");
//            case 3 -> System.out.println("Wednesday");
//            case 4 -> System.out.println("Thursday");
//            case 5 -> System.out.println("Friday");
//            case 6 -> System.out.println("Saturday");
//            case 7 -> System.out.println("Sunday");
//            default -> System.out.println("Invalid day");
//        }

        // task 2
        //       System.out.print("Enter a month number");
//        int month = scanner.nextInt();
//
//        switch (month) {
//            case 1 -> System.out.println("January");
//            case 2 -> System.out.println("February");
//            case 3 -> System.out.println("March");
//            case 4 -> System.out.println("April");
//            case 5 -> System.out.println("May");
//            case 6 -> System.out.println("June");
//            case 7 -> System.out.println("July");
//            case 8 -> System.out.println("August");
//            case 9 -> System.out.println("September");
//            case 10 -> System.out.println("October");
//            case 11 -> System.out.println("November");
//            case 12 -> System.out.println("December");
//            default -> System.out.println("Invalid month");
//        }

        // task 3
        //       System.out.print("Enter a number");
//        int mark = scanner.nextInt();
//
//        switch (mark) {
//            case 1 -> System.out.println("very bad");
//            case 2 -> System.out.println("bad");
//            case 3 -> System.out.println("average");
//            case 4 -> System.out.println("good");
//            case 5 -> System.out.println("excellent");
//            default -> System.out.println("Invalid mark");
//        }


        // task 4

//        char op = scanner.next().charAt(0);
//        float a = scanner.nextFloat();
//        float b = scanner.nextFloat();
//
//        switch (op) {
//            case '+' -> System.out.println(a + b);
//            case '-' -> System.out.println(a - b);
//            case '*' -> System.out.println(a * b);
//            case '/' -> System.out.println(b != 0 ? a / b : "Division by zero");
//            default -> System.out.println("Unknown operator");
//        }

        // task 5
        //       System.out.print("Enter a simbol");
//        char ch = scanner.next().toLowerCase().charAt(0);
//
//        switch (ch) {
//            case 'a','e','i','o','u' -> System.out.println("vowel");
//            default -> System.out.println("consonant/other");
//        }


        // task 6
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//
//        switch (n) {
//            case 0 -> System.out.println("zero");
//            case 1 -> System.out.println("one");
//            case 2 -> System.out.println("two");
//            case 3 -> System.out.println("three");
//            case 4 -> System.out.println("four");
//            case 5 -> System.out.println("five");
//            case 6 -> System.out.println("six");
//            case 7 -> System.out.println("seven");
//            case 8 -> System.out.println("eight");
//            case 9 -> System.out.println("nine");
//            default -> System.out.println("Invalid number");
//        }


        // task 7
        //       System.out.print("Enter a number");
//        int dir = scanner.nextInt();
//
//        switch (dir) {
//            case 1 -> System.out.println("North");
//            case 2 -> System.out.println("East");
//            case 3 -> System.out.println("South");
//            case 4 -> System.out.println("West");
//            default -> System.out.println("Invalid direction");
//        }

        // task 8

//        int code = scanner.nextInt();
//
//        switch (code) {
//            case 200 -> System.out.println("OK");
//            case 404 -> System.out.println("Not Found");
//            case 500 -> System.out.println("Server Error");
//            default -> System.out.println("Unknown");
//        }

        // task 9
        //       System.out.print("Enter a grade");
//        char grade = scanner.next().toUpperCase().charAt(0);
//
//        switch (grade) {
//            case 'A' -> System.out.println("90–100");
//            case 'B' -> System.out.println("80–89");
//            case 'C' -> System.out.println("70–79");
//            case 'D' -> System.out.println("60–69");
//            case 'F' -> System.out.println("0–59");
//            default -> System.out.println("Invalid grade");
//        }

        // task 10
        //       System.out.print("Enter a month number");
//        int m = scanner.nextInt();
//
//        switch (m) {
//            case 12,1,2 -> System.out.println("Winter");
//            case 3,4,5 -> System.out.println("Spring");
//            case 6,7,8 -> System.out.println("Summer");
//            case 9,10,11 -> System.out.println("Autumn");
//            default -> System.out.println("Invalid month");
//        }


        // C) while

        // task 1
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//        int i = 1;
//
//        while (i <= n) {
//            System.out.print(i + " ");
//            i++;
//        }


        // task 2
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//
//        while (n >= 1) {
//            System.out.print(n + " ");
//            n--;
//        }

        // task 3
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//        int sum = 0;
//        int i = 1;
//
//        while (i <= n) {
//            sum += i;
//            i++;
//        }
//
//        System.out.println(sum);


        // task 4
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//        int count = 0;
//
//        while (n != 0) {
//            count++;
//            n /= 10;
//        }
//
//        System.out.println(count);


        // task 5
        //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//        int sum = 0;
//
//        while (n != 0) {
//            sum += n % 10;
//            n /= 10;
//        }
//
//        System.out.println(sum);


        // task 6
 //       System.out.print("Enter a number");
//        int n = scanner.nextInt();
//        int i = 1;
//
//        while (i <= n) {
//            if (n % i == 0) {
//                System.out.print(i + " ");
//            }
//            i++;
//        }

        // task 7
        //        int sum = 0;
//        System.out.print("Enter a number");
//        int x = scanner.nextInt();
//
//        while (x != 0) {
//            sum += x;
//            x = scanner.nextInt();
//        }
//
//        System.out.println(sum);


        // D) do-while


        // task 1

//        String password;
//
//        do {
//            System.out.print("Enter a password -- >");
//            password = scanner.next();
//        } while (!password.equals("java"));
//
//        System.out.println("Access granted");


        // task 2

//        int count = 0;
//        int x;
//
//        do {
//            System.out.print("Enter a number -- >");
//            x = scanner.nextInt();
//            if (x >= 0) {
//                count++;
//            }
//        } while (x >= 0);
//
//        System.out.println(count);


        // task 3

//        int choice;
//
//        do {
//            System.out.println("1) Hello");
//            System.out.println("2) Time");
//            System.out.println("0) Exit");
//
//            System.out.print("Choose a number -->");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1 -> System.out.println("Hello!");
//                case 2 -> System.out.println("Time info");
//            }
//        } while (choice != 0);



        // task 4

//        int x;
//
//        do {
//            System.out.print("Enter a number -- >");
//            x = scanner.nextInt();
//        } while (x < 1 || x > 10);
//
//        System.out.println("Correct: " + x);


        // task 5

//        int secret = 7;
//        int guess;
//
//        do {
//            System.out.print("Enter your number -- >");
//            guess = scanner.nextInt();
//
//            if (guess > secret) {
//                System.out.println("Less");
//            } else if (guess < secret) {
//                System.out.println("More");
//            }
//        } while (guess != secret);
//
//        System.out.println("Correct!");



        // E) For

        // task 1

//        System.out.print("Enter a number -- >");
//        int k = scanner.nextInt();
//
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(k + " * " + i + " = " + (k * i));
//        }


        // task 2
//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//        long fact = 1;
//
//        for (int i = 1; i <= n; i++) {
//            fact *= i;
//        }
//
//        System.out.println(fact);

        // task 3

//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//        int sum = 0;
//
//        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 0) {
//                sum += i;
//            }
//        }
//
//        System.out.println(sum);


        // task 4

//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            if (i % 3 == 0) continue;
//            System.out.print(i + " ");
//        }


        // task 5
//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            if (i % 7 == 0) {
//                System.out.println(i);
//                break;
//            }
//        }


        // task 6

//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//        boolean isPrime = n > 1;
//
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }
//
//        System.out.println(isPrime ? "Prime" : "Not prime");


        // task 7
//        System.out.print("Enter a number -- >");
//        int n = scanner.nextInt();
//        int a = 0, b = 1;
//
//        for (int i = 1; i <= n; i++) {
//            System.out.print(a + " ");
//            int c = a + b;
//            a = b;
//            b = c;
//        }

        // task 8
        System.out.print("Enter a number -- >");
        int n = scanner.nextInt();
        int max = 0;

        for (; n > 0; n /= 10) {
            int d = n % 10;
            if (d > max) max = d;
            if (max == 9) break;
        }

        System.out.println(max);





































    }
}
