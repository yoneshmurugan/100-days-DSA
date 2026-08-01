import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BMergeToMatch {
    public static void main(String[] arguments) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = inputReader.readLine();
        if (firstLine == null) return;
        int testCasesCount = Integer.parseInt(firstLine.trim());
        StringBuilder outputBuilder = new StringBuilder();
        
        while (testCasesCount-- > 0) {
            StringTokenizer lengthTokenizer = new StringTokenizer(inputReader.readLine());
            int sourceArrayLength = Integer.parseInt(lengthTokenizer.nextToken());
            int targetArrayLength = Integer.parseInt(lengthTokenizer.nextToken());
            
            int[] sourceArray = new int[sourceArrayLength];
            StringTokenizer sourceTokenizer = new StringTokenizer(inputReader.readLine());
            for (int arrayIndex = 0; arrayIndex < sourceArrayLength; arrayIndex++) {
                sourceArray[arrayIndex] = Integer.parseInt(sourceTokenizer.nextToken());
            }
            
            int[] targetArray = new int[targetArrayLength];
            StringTokenizer targetTokenizer = new StringTokenizer(inputReader.readLine());
            for (int arrayIndex = 0; arrayIndex < targetArrayLength; arrayIndex++) {
                targetArray[arrayIndex] = Integer.parseInt(targetTokenizer.nextToken());
            }
            
            if (sourceArrayLength < 2 * targetArrayLength) {
                outputBuilder.append("NO\n");
                continue;
            }
            
            Arrays.sort(sourceArray);
            Arrays.sort(targetArray);
            
            boolean isPossibleToMatch = true;
            for (int arrayIndex = 0; arrayIndex < targetArrayLength; arrayIndex++) {
                if (sourceArray[arrayIndex] > targetArray[arrayIndex] || sourceArray[sourceArrayLength - targetArrayLength + arrayIndex] < targetArray[arrayIndex]) {
                    isPossibleToMatch = false;
                    break;
                }
            }
            
            if (isPossibleToMatch) {
                outputBuilder.append("YES\n");
            } else {
                outputBuilder.append("NO\n");
            }
        }
        System.out.print(outputBuilder);
    }
}
