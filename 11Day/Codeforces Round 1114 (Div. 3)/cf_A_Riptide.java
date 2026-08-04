import java.util.Arrays;
import java.util.Scanner;

public class cf_A_Riptide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int aliceTokens = scanner.nextInt();
            int bobTokens = scanner.nextInt();
            int charlieTokens = scanner.nextInt();
            
            int totalRounds = 0;
            int[] tokenCounts = {aliceTokens, bobTokens, charlieTokens};
            
            while (true) {
                Arrays.sort(tokenCounts);
                if (tokenCounts[0] == tokenCounts[1] || tokenCounts[1] == tokenCounts[2]) {
                    break;
                }
                tokenCounts[0]++;
                tokenCounts[2]--;
                totalRounds++;
            }
            
            System.out.println(totalRounds);
        }
        scanner.close();
    }
}
