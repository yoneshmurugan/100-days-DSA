import java.util.Scanner;

public class cf_110A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        
        int luckyCount = 0;
        for (int i = 0; i < n.length(); i++) {
            char digit = n.charAt(i);
            if (digit == '4' || digit == '7') {
                luckyCount++;
            }
        }
        
        if (luckyCount == 4 || luckyCount == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }
}