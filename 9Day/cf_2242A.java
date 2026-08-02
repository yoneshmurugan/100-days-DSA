// Problem: Bigrams
// Contest: 2242 | Index: A
// URL: https://codeforces.com/contest/2242/problem/A
// Rating: 800 | Tags: sortings, strings, *800
// Memory: 512 megabytes | Time: 2 seconds
// Author: 
import java.io.*;
import java.util.*;

public class cf_2242A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int k = sc.nextInt();
        int count3 = 0;
        int count2 = 0;
        for (int i = 0; i < k; i++) {
            int c = sc.nextInt();
            if (c >= 3) {
                count3++;
            }
            if (c >= 2) {
                count2++;
            }
        }
        
        if (count3 >= 1 || count2 >= 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
