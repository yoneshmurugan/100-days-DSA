import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(sc.readLine().trim());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(sc.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            if (n <= 2) {
                for (int i = 0; i < n; i++) {
                    out.append(a[i]).append(i == n - 1 ? "" : " ");
                }
                out.append("\n");
                continue;
            }
            long[] d = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                d[i] = a[i+1] - a[i];
            }
            int i = 0;
            while (i < n - 1) {
                int j = i;
                long parity = Math.abs(d[i] % 2);
                while (j < n - 1 && Math.abs(d[j] % 2) == parity) {
                    j++;
                }
                Arrays.sort(d, i, j);
                i = j;
            }
            
            out.append(a[0]);
            long current = a[0];
            for (int k = 0; k < n - 1; k++) {
                current += d[k];
                out.append(" ").append(current);
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}
