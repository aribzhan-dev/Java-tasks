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
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a first number --->");
            int a = scanner.nextInt();
            System.out.print("Enter a second number --->");
            int b = scanner.nextInt();
            System.out.print("Choose operation (+, -, *, /) --->");
            char c = scanner.next().charAt(0);

            switch (c){
                case '+':
                    int plus = a + b;
                    System.out.println(a + "+" + b + "=" + plus);
                    break;
                case '-':
                    int minus  = a - b;
                    System.out.println(a + "-" + b + "=" + minus);
                    break;
                case '*':
                    int multiply = a * b;
                    System.out.println(a + "-" + b + "=" + multiply);
                    break;
                case '/':
                    if (a == 0 || b == 0){
                        System.out.println("We can't divide for 0");
                        break;
                    }else {
                        int divide = a / b;
                        System.out.println(a + "-" + b + "=" + divide);
                        break;
                    }

            }


            System.out.print("Do you want to continue  (yes/no) --->");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                System.out.println("Game Over!!");
                break;
            }


        }

    }
}