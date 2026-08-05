// Problem: Threshold Movement
// Contest: 2250 | Index: A
// URL: https://codeforces.com/contest/2250/problem/A
// Rating: 800 | Tags: brute force, implementation, math, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf_2250A {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        String first = in.next();
        if (first == null) return;
        
        int t = Integer.parseInt(first);
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = in.nextInt();
            long minOdd = Long.MAX_VALUE;
            long maxEven = Long.MIN_VALUE;
            
            for (int i = 1; i <= n; i++) {
                long w = in.nextLong();
                if (i % 2 == 1) {
                    if (w < minOdd) minOdd = w;
                } else {
                    if (w > maxEven) maxEven = w;
                }
            }
            
            // If n is odd, someone is left without a partner to swap positions with,
            // meaning they would be forced out of bounds or double up on a position.
            if (n % 2 != 0) {
                out.append("NO\n");
            } else {
                // For even n, all odd positions must move right (k < minOdd)
                // and all even positions must move left (k > maxEven).
                // Thus we need maxEven < k < minOdd, which implies minOdd - maxEven >= 2.
                if (minOdd >= maxEven + 2) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            }
        }
        System.out.print(out);
    }
}
