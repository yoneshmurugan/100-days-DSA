import java.util.Scanner;

public class AYouDeleteIDelete {
    public static void main(String[] arguments) {
        Scanner inputScanner = new Scanner(System.in);
        if (!inputScanner.hasNextInt()) return;
        int totalTestCases = inputScanner.nextInt();
        while (totalTestCases-- > 0) {
            String binaryString = inputScanner.next();
            String bestPossibleString = "";
            for (int characterIndex = 0; characterIndex < binaryString.length(); characterIndex++) {
                if (binaryString.charAt(characterIndex) == '0') {
                    String stringAfterAliceMove = binaryString.substring(0, characterIndex) + binaryString.substring(characterIndex + 1);
                    int firstOccurrenceOfOne = stringAfterAliceMove.indexOf('1');
                    if (firstOccurrenceOfOne != -1) {
                        String stringAfterBobMove = stringAfterAliceMove.substring(0, firstOccurrenceOfOne) + stringAfterAliceMove.substring(firstOccurrenceOfOne + 1);
                        if (bestPossibleString.isEmpty() || stringAfterBobMove.compareTo(bestPossibleString) > 0) {
                            bestPossibleString = stringAfterBobMove;
                        }
                    }
                }
            }
            System.out.println(bestPossibleString);
        }
        inputScanner.close();
    }
}
