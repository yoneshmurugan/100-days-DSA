import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlwaysChanging {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
            int c0 = 0, c1 = 0;
            StringBuilder comp = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '0') c0++;
                else c1++;
                
                if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                    comp.append(c);
                }
            }
            
            int delta = c0 - c1;
            if (Math.abs(delta) > 2) {
                out.append("-1\n");
                continue;
            }
            
            int maxLen = -1;
            for (int start = 0; start <= 1; start++) {
                for (int end = 0; end <= 1; end++) {
                    int r0_minus_r1 = 0;
                    if (start == 0 && end == 0) r0_minus_r1 = 1;
                    else if (start == 1 && end == 1) r0_minus_r1 = -1;
                    
                    if (Math.abs(delta - r0_minus_r1) <= 1) {
                        int first = firstOcc(comp, (char)(start + '0'));
                        int last = lastOcc(comp, (char)(end + '0'));
                        if (first != -1 && last != -1 && first <= last) {
                            maxLen = Math.max(maxLen, last - first + 1);
                        }
                    }
                }
            }
            
            if (maxLen == -1) {
                out.append("-1\n");
            } else {
                out.append(n - maxLen).append("\n");
            }
        }
        System.out.print(out);
    }
    
    static int firstOcc(StringBuilder comp, char c) {
        if (comp.length() > 0 && comp.charAt(0) == c) return 0;
        if (comp.length() > 1 && comp.charAt(1) == c) return 1;
        return -1;
    }
    
    static int lastOcc(StringBuilder comp, char c) {
        int L = comp.length();
        if (L > 0 && comp.charAt(L - 1) == c) return L - 1;
        if (L > 1 && comp.charAt(L - 2) == c) return L - 2;
        return -1;
    }
}
