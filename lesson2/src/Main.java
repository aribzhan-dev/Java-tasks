import java.util.*;

public class Main {
    public static void main(String[] args) {

        // dlya povtoreniya

        // task 1 and 2 and 4
//        List<String> names = new ArrayList<>();
//
//        names.add("Aribzhan");
//        names.add("Abu");
//        names.add("Sanzhar");
//        names.add("Azamat");
//        names.add("Bauka");
//        names.add("Aribzhan");
//
//        System.out.println(names);
//        System.out.println(names.contains("Abu"));


        // task 3

//        Set<String> cities = new HashSet<>();
//
//        cities.add("Astana");
//        cities.add("Alamty");
//        cities.add("Shimkent");
//        cities.add("Astana");
//
//        System.out.println(cities);


        // task 5

//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(5);
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(7);
//        numbers.add(8);
//        int sum = 0;
//        for (int x: numbers){
//            sum += x;
//        }
//        System.out.println(sum);



        // task 6
//        HashSet<Integer> numbers = new HashSet<>();
//        numbers.add(5);
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(7);
//        numbers.add(8);
//        System.out.println(numbers);





        // Practic task

        // task 1

//        System.out.println(isStrongPassword("qwerT12!"));


        // task 2

//        System.out.println(normalizeName("AribZHan"));


        // task 3

//        System.out.println(isBracketsValid("{()}"));


        // task 4

//        System.out.println(area(5))


        // tsak 5
        int n = 10;
        int leftPrime = 0;
        int rightPrime = 0;
        int c = n+1;
        for (int x = n - 1; x >= 2; i--){
            if(isPrime(x)){
                leftPrime = x;
            }
        }
        while (true){
            if (isPrime(c)) {
                rightPrime = c;
                break;
            }

            c++;
        }

        if (n - leftPrime < (n - rightPrime) * (-1)){
            System.out.println(leftPrime);
        }else{
            System.out.println(rightPrime);
        }








    }

    //  password validator
    public static boolean isStrongPassword(String password){
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        String cap_letters = "MNBVCXZASDFGHJKLQWERTYUIOP";
        String numbers = "1234567890";
        String elements = "!@#$%^&*";
        int hasElements = 0;
        int hasLowerCase = 0;
        int hasNumber = 0;
        int hasCapCase = 0;

        if (password.length() >= 8){
            for (int i = 0; i < password.length();  i++){
                String pass = String.valueOf(password.charAt(i));
                if (letters.contains(pass)){
                    hasLowerCase += 1;
                } else if (cap_letters.contains(pass)){
                    hasCapCase += 1;
                } else if (numbers.contains(pass)){
                    hasNumber += 1;
                }else if (elements.contains(pass)){
                    hasElements += 1;
                }
            }

            if (
                    hasElements >= 1
                    && hasNumber >= 1
                    && hasLowerCase >= 1
                    && hasCapCase >= 1
            ){
                return true;
            }

        }
        return false;

    }

    // normalizy name

    public static String normalizeName(String fullName){
        String name = fullName.toLowerCase();
        String n = "";
        for (int i = 0; i < name.length(); i++){
            if (i == 0){
                n += String.valueOf(name.charAt(i)).toUpperCase();
            }else{
                n += String.valueOf(name.charAt(i)).toLowerCase();
            }
        }
        return n;
    }


    // bracket cheker

    public static boolean isBracketsValid(String brackets){
        if (brackets == null || brackets.isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < brackets.length(); i++) {
            char current = brackets.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }
            else if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (current == '}' && top != '{') {
                    return false;
                }
                if (current == ')' && top != '(') {
                    return false;
                }
                if (current == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();



    }



    // area

    public static double area(int a){
        double square = a * a;
        return square;
    }

    public static double area(int a, int b){
        double square = a * b;
        return square;
    }

    public static double area(double r){
        double square = Math.PI * r * r;
        return square;
    }


    // isPrime funcsion

    public static boolean isPrime(int x){
        if(x <= 1) return false;
        if(x == 2) return true;
        for (int i=2; i < x; i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }




}