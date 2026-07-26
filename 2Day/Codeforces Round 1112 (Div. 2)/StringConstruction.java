import java.util.Scanner;

public class StringConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int length = scanner.nextInt();
            int targetPairs = scanner.nextInt();

            if (targetPairs > length - 2) {
                System.out.println(-1);
                continue;
            }

            int onesCount = (length + 1) / 2;
            int zerosCount = length / 2;

            int runsNeeded = length - targetPairs;

            int onesRuns = (runsNeeded + 1) / 2;
            int zerosRuns = runsNeeded / 2;

            StringBuilder result = new StringBuilder();

            for (int currentRun = 0; currentRun < onesRuns; currentRun++) {
                int onesInThisRun = onesCount / onesRuns + (currentRun < onesCount % onesRuns ? 1 : 0);
                result.append("1".repeat(onesInThisRun));

                if (currentRun < zerosRuns) {
                    int zerosInThisRun = zerosCount / zerosRuns + (currentRun < zerosCount % zerosRuns ? 1 : 0);
                    result.append("0".repeat(zerosInThisRun));
                }
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}
