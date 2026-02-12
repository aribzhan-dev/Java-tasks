


public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);



    //        System.out.print("Enter a n -- >");
    //        int n = scanner.nextInt();
    //        System.out.print("Enter a k -- >");
    //        int k = scanner.nextInt();
    //        for (int i=0; i<n; i++){
    //            ArrayList<String> row = new ArrayList<String>();
    //            for (int j=0; j<n; j++){
    //                int block = (i / k + j / k) % 2;
    //                if (block == 0){
    //                    row.add("#");
    //                }else {
    //                    row.add(".");
    //                }
    //            }
    //            System.out.println(String.join("", row));
    //        }


    // Task 2

    //         int a=4;
    //         int[][]b=new int[a][a];
    //         int num=1;
    //         int top=0,buttom=a-1,left=0,right=a-1;
    //         while(num<=a*a){
    //             for(int i=left;i<=right;i++){
    //                 b[top][i]=num++;
    //             }
    //             top++;
    //             for(int i=top;i<=buttom;i++){
    //                 b[i][right]=num++;
    //             }
    //             right--;
    //             for(int i=right;i>=left;i--){
    //                 b[buttom][i]=num++;
    //             }
    //             buttom--;
    //             for(int i=buttom;i>=top;i--){
    //                 b[i][left]=num++;
    //             }
    //             left++;
    //         }


    // task 3

    //         int a = 5;
    //         int[][] b = new int[a][a];
    //         int num = 1;
    //         for(int s = 0; s <= 2 * (a-1); s++){
    //             if(s % 2 == 0){
    //                 for(int i = 0; i < a; i++){
    //                     int j = s - i;
    //                     if(j >= 0 && j < a){
    //                         b[i][j] = num++;
    //                     }
    //                 }
    //             }else{
    //                 for(int i = a-1; i >= 0; i--){
    //                     int j = s - i;
    //                     if(j >= 0 && j < a){
    //                         b[i][j] = num++;
    //                     }
    //                 }
    //             }
    //         }
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 System.out.print(b[i][j] + " ");
    //             }
    //             System.out.println();
    //         }



    // task 4

    //         int a = 7;
    //         int mid = a / 2;
    //         int[][] b = new int[a][a];
    //         for(int i = 0; i < a; i++){
    //             int s;
    //             if(i <= mid){
    //                 s = 1 + 2 * i;
    //             }else{
    //                 s = 1 + 2 * (a - i - 1);
    //             }
    //             int d = (a - s) / 2;
    //             for(int j = 0; j < d; j++){
    //                 b[i][j] = '.';
    //             }
    //             for(int j = d; j < s; j++){
    //                 b[i][j] = '#';
    //             }
    //             for(int j = d + s; j < d; j++){
    //                 b[i][j] = '.';
    //             }
    //         }
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 System.out.print((char)b[i][j]);
    //             }
    //             System.out.println();
    //         }



    // task 5

    //         int a = 20;
    //         int[][] b = new int[a][a];
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 b[i][j] = Math.min(Math.min(i, j),Math.min(a - 1 - i, a - 1 -j));
    //                 System.out.print(b[i][j]+" ");
    //             }
    //             System.out.println();
    //         }



    // task 6

    //         int a = 20;
    //         char[][] b = new char[a][a];
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 if(i <= j && i + j < a){
    //                     b[i][j] = '1';
    //                 }
    //                 else if(i < j && i + j >= a){
    //                     b[i][j] = '2';
    //                 }
    //                 else if(i >= j && i + j >= a){
    //                     b[i][j] = '3';
    //                 }
    //                 else{
    //                     b[i][j] = '4';
    //                 }
    //
    //             }
    //         }
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 System.out.print(b[i][j] + " ");
    //             }
    //             System.out.println();
    //         }



    // task 7

    //         int a=20;
    //         int[][] b = new int[a][a];
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 b[i][j]=(i+1) * (j+1);
    //             }
    //         }
    //         int max=a * a;
    //         int width=String.valueOf(max).length();
    //         for(int i = 0; i < a; i++){
    //             for(int j = 0; j < a; j++){
    //                 System.out.printf("%" + width + "d", b[i][j]);
    //                 if(j != a - 1){
    //                     System.out.print(" ");
    //                 }
    //             }
    //             System.out.println();
    //         }





    // task 8

    //        int a = 20;
    //        int[][] b = new int[a][a];
    //        int d = a / 2;
    //        for(int i = 0; i < a; i++){
    //            for(int j = 0; j < a; j++){
    //                int s=Math.max(Math.abs(i - d),Math.abs(j - d));
    //                b[i][j]=d - s;
    //            }
    //        }
    //        for(int i = 0; i < a; i++){
    //            for(int j = 0; j < a; j++){
    //                System.out.print(b[i][j] + " ");
    //            }
    //            System.out.println();
    //        }






    // block 2

    // task 1
    //        int n = 200;
    //        ArrayList<BigInteger> facSum = new ArrayList<>();
    //
    //        for (int i = 1; i <= n; i++) {
    //            BigInteger x = factorial(i);
    //            BigInteger sum = BigInteger.ZERO;
    //
    //            while (x.compareTo(BigInteger.ZERO) > 0) {
    //                sum = sum.add(x.mod(BigInteger.TEN));
    //                x = x.divide(BigInteger.TEN);
    //            }
    //
    //            facSum.add(sum);
    //        }
    //
    //        BigInteger total = BigInteger.ZERO;
    //        for (BigInteger val : facSum) {
    //            total = total.add(val);
    //        }
    //
    //        System.out.println(total);


    // task 2

    //        int n = 153;
    //        for (int i=1; i <= n; i++){
    //            String str_i = Integer.toString(i);
    //            int len_i = str_i.length();
    //            int total = 0;
    //            int copy_i = i;
    //
    //            while (copy_i > 0){
    //                int mod = copy_i % 10;
    //                total += (int) Math.pow(mod, len_i);
    //                copy_i /= 10;
    //            }
    //
    //            if (total == i){
    //                System.out.println(i);
    //            }
    //        }



    // task 3
    //        int n = 30;
    //        for (int i=1; i <= n; i++){
    //            boolean found = false;
    //            for (int j=2; j*j <= i; j++){
    //                if (i % (j*j) == 0){
    //                    found = true;
    //                    break;
    //                }
    //            }
    //            if (!found){
    //                System.out.println(i);
    //
    //            }
    //        }


    // task 4

    //        int n = 30;
    //        int argmax=1;
    //        int max=0;
    //        for (int i=1; i <= n; i++){
    //            int sum_i = 0;
    //            for (int j=1; j <= i; j++){
    //                if (i % j == 0){
    //                    sum_i += j;
    //                }
    //            }
    //            if (sum_i > max){
    //                max = sum_i;
    //                argmax = i;
    //            }
    //        }
    //
    //        System.out.println(argmax);
    //        System.out.println(max);



    // task 5

    //        int n = 5;
    //        int argmax = 1;
    //        int max = 0;
    //        for (int i=1; i<=n; i++){
    //            int counter = 0;
    //            for (int j=0; j*j <= i; j++){
    //                int b = i - (j*j);
    //                b = (int) Math.sqrt(b);
    //                if ((b*b) + (j*j) == i){
    //                    counter += 1;
    //                }
    //            }
    //            if (counter > max){
    //                max = counter;
    //                argmax = i;
    //            }
    //
    //        }
    //
    //        System.out.println(argmax);












    // block 3
    // task 1

    import java.math.BigInteger;

    String s = "ababab";
    int len_s = s.length();
    int mix_len = 0;
            for (int k=1; k <= len_s; k++){
            if (len_s % k == 0){
    int k_counter = 0;
                    for(int i=k; i < len_s; i++){
            if(s.charAt(i) == s.charAt(i % k)){
    k_counter += 1;

            }

            }
            if(k_counter == len_s-k){
    mix_len = k;
                        break;
                                }
                                }
                                }
                                if (mix_len == 0){
            System.out.println(len_s);
            }else{
                    System.out.println(mix_len);
            }


                    // task 2

    //        System.out.println(calculateUniqueLength(2, 3, 2, 7));

































                    }
    // task 3 block 2

    public static int calculateUniqueLength(int x, int a,
                                            int b, int m){
        int i = 0;
        int x2 = x;
        int x4 = x;
        do {
            x2 = (a * x2 + b) % m;
            x4 = (a * x4 + b) % m;
            x4 = (a * x4 + b) % m;
            i++;
            if (x2 == x4) {
                break;
            }
        } while (true);

        return i;
    }





    // task 1 block 2
    public static BigInteger factorial(int s) {
        BigInteger f = BigInteger.ONE;

        for (int i = 1; i <= s; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }
    }
