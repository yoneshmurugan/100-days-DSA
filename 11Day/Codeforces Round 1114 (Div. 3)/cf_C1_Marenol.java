import java.util.Scanner;

public class cf_C1_Marenol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            
            int aEven = 0, aOdd = 0;
            int bEven = 0, bOdd = 0;
            
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    if (i % 2 == 0) aEven++;
                    else aOdd++;
                }
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0) bEven++;
                    else bOdd++;
                }
            }
            
            if (aEven == bEven && aOdd == bOdd) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
