// Problem: Magnets
// Contest: 344 | Index: A
// URL: https://codeforces.com/contest/344/problem/A
// Rating: 800 | Tags: implementation, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 

import java.util.Scanner;

public class cf_344A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int groups = 1;
        String prev = sc.next();
        
        for (int i = 1; i < n; i++) {
            String curr = sc.next();
            if (!curr.equals(prev)) {
                groups++;
                prev = curr;
            }
        }
        
        System.out.println(groups);
        sc.close();
    }
}
