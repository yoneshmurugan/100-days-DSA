import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class RiskyTower {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        if (t == -1) return;
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLong();
            }
            
            int[][] a = new int[n][m];
            int[] allVals = new int[n * m];
            int ptr = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                    allVals[ptr++] = a[i][j];
                }
            }
            
            Arrays.sort(allVals);
            int k = 0;
            for (int i = 0; i < ptr; i++) {
                if (i == 0 || allVals[i] != allVals[i - 1]) {
                    allVals[k++] = allVals[i];
                }
            }
            
            int[] count = new int[4 * k];
            long[] sum = new long[4 * k];
            
            long ans = m; // Collapse condition 2 guarantees at most m pieces
            
            // Process from bottom to top
            for (int r = n - 1; r >= 0; r--) {
                for (int j = 0; j < m; j++) {
                    int idx = Arrays.binarySearch(allVals, 0, k, a[r][j]);
                    update(1, 0, k - 1, idx, allVals[idx], count, sum);
                }
                
                // If we have enough total damage available to collapse row r
                if (sum[1] >= v[r]) {
                    long pieces = query(1, 0, k - 1, v[r], allVals, count, sum);
                    if (pieces < ans) {
                        ans = pieces;
                    }
                }
            }
            
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }
    
    static void update(int node, int L, int R, int idx, int val, int[] count, long[] sum) {
        count[node]++;
        sum[node] += val;
        if (L == R) return;
        int mid = (L + R) / 2;
        if (idx <= mid) {
            update(2 * node, L, mid, idx, val, count, sum);
        } else {
            update(2 * node + 1, mid + 1, R, idx, val, count, sum);
        }
    }
    
    static long query(int node, int L, int R, long target, int[] allVals, int[] count, long[] sum) {
        if (target <= 0) return 0;
        if (L == R) {
            return (target + allVals[L] - 1) / allVals[L];
        }
        int mid = (L + R) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;
        
        if (sum[right] >= target) {
            return query(right, mid + 1, R, target, allVals, count, sum);
        } else {
            return count[right] + query(left, L, mid, target - sum[right], allVals, count, sum);
        }
    }
}

class FastScanner {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int head = 0, tail = 0;

    public FastScanner(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (head >= tail) {
            head = 0;
            try {
                tail = stream.read(buf, 0, buf.length);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (tail <= 0) return -1;
        }
        return buf[head++];
    }

    public int nextInt() {
        int c = read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = read();
        }
        int res = 0;
        while (c > 32) {
            if (c < '0' || c > '9') throw new RuntimeException("Invalid digit");
            res = res * 10 + c - '0';
            c = read();
        }
        return res;
    }
    
    public long nextLong() {
        int c = read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = read();
        }
        long res = 0;
        while (c > 32) {
            if (c < '0' || c > '9') throw new RuntimeException("Invalid digit");
            res = res * 10 + c - '0';
            c = read();
        }
        return res;
    }
}
