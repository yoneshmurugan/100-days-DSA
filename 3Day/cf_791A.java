import java.util.Scanner;

public class cf_791A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int year = 1;
        if (num1 == num2) {
            System.out.println(year);
        } else {
            while (num1 < num2) {
                year++;
                num1 = 3 * num1;
                num2 = 2 * num2;
            }
            System.out.println(year);
        }
        sc.close();
    }
}