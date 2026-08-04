import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cf_B_Compressed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String testCasesStr = reader.readLine();
        if (testCasesStr == null) return;
        int testCases = Integer.parseInt(testCasesStr.trim());
        
        StringBuilder output = new StringBuilder();
        
        while (testCases-- > 0) {
            String stringLengthStr = reader.readLine();
            if (stringLengthStr == null) break;
            
            char[] characters = reader.readLine().trim().toCharArray();
            int stringLength = characters.length;
            
            int compressedLength = 1;
            for (int i = 0; i < stringLength - 1; i++) {
                if (characters[i] != characters[i+1]) {
                    compressedLength++;
                }
            }
            
            int maxDecrease = 0;
            for (int i = 1; i < stringLength - 1; i++) {
                int currentDecrease = 0;
                if (characters[i-1] != characters[i]) currentDecrease++;
                if (characters[i] != characters[i+1]) currentDecrease++;
                if (characters[i-1] != characters[i+1]) currentDecrease--;
                
                if (currentDecrease > maxDecrease) {
                    maxDecrease = currentDecrease;
                    if (maxDecrease == 2) break;
                }
            }
            
            output.append(compressedLength - maxDecrease).append("\n");
        }
        System.out.print(output);
    }
}
