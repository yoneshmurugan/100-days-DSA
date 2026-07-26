import java.util.Scanner;

public class ThresholdMovement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int elementCount = scanner.nextInt();
            int minOdd = Integer.MAX_VALUE;
            int maxEven = Integer.MIN_VALUE;
            
            for (int position = 1; position <= elementCount; position++) {
                int elementWeight = scanner.nextInt();
                if (position % 2 != 0) {
                    minOdd = Math.min(minOdd, elementWeight);
                } else {
                    maxEven = Math.max(maxEven, elementWeight);
                }
            }
            
            if (elementCount % 2 != 0) {
                System.out.println("NO");
            } else {
                if (maxEven + 1 < minOdd) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        scanner.close();
    }
}
