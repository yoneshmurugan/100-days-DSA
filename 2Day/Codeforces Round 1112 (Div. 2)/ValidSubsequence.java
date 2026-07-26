import java.util.*;
import java.io.*;

public class ValidSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine().trim());

        while (testCases-- > 0) {
            int elementCount = Integer.parseInt(reader.readLine().trim());

            int[] leftStart  = new int[elementCount + 1];
            int[] leftEnd    = new int[elementCount + 1];
            int[] rightStart = new int[elementCount + 1];
            int[] rightEnd   = new int[elementCount + 1];

            for (int i = 1; i <= elementCount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                leftStart[i]  = Integer.parseInt(tokenizer.nextToken());
                leftEnd[i]    = Integer.parseInt(tokenizer.nextToken());
                rightStart[i] = Integer.parseInt(tokenizer.nextToken());
                rightEnd[i]   = Integer.parseInt(tokenizer.nextToken());
            }

            int answer = 0;

            for (int targetLength = elementCount; targetLength >= 1; targetLength--) {
                int selectedCount = 0;

                for (int i = 1; i <= elementCount && selectedCount < targetLength; i++) {
                    int nextPosition = selectedCount + 1;

                    boolean leftConstraintOk = nextPosition < leftStart[i] || nextPosition > leftEnd[i];

                    int rightForbiddenStart = rightStart[i] + nextPosition - 1;
                    int rightForbiddenEnd   = rightEnd[i]   + nextPosition - 1;
                    boolean rightConstraintOk = targetLength < rightForbiddenStart || targetLength > rightForbiddenEnd;

                    if (leftConstraintOk && rightConstraintOk) {
                        selectedCount++;
                    }
                }

                if (selectedCount >= targetLength) {
                    answer = targetLength;
                    break;
                }
            }

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}
