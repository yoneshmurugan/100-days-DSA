// Problem: Divide and Conquer
// Contest: 2241 | Index: A
// URL: https://codeforces.com/contest/2241/problem/A
// Rating: 800 | Tags: greedy, math, number theory, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 
import java.util.Scanner;
public class cf_2241A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input =  sc.nextInt();
        while (input-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x % y == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
