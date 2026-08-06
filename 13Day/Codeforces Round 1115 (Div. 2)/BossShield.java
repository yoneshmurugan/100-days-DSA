import java.util.*;

public class BossShield {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long sum = 0;
            int maxFreq = 0;
            int maxVal = 0;
            int[] count = new int[1005];
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                sum += a;
                count[a]++;
                
                if (count[a] > maxFreq) {
                    maxFreq = count[a];
                    maxVal = a;
                }
            } 
            int penalty = Math.max(0, 2 * maxFreq - n - 2);
            long ans = sum - (long) penalty * maxVal;
            
            System.out.println(ans);
        }
        sc.close();
    }
}
