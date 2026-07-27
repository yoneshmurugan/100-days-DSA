import java.util.Scanner;

public class cf_977A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        for (int i = 0; i < num2; i++) {
            if (num1 % 10 == 0) {
                num1 /= 10;
            }
            else {
                num1 -= 1;
            }
        }
        
        System.out.println(num1);
        sc.close();
    }
}
