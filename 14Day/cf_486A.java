// Problem: Calculating Function
// Contest: 486 | Index: A
// URL: https://codeforces.com/contest/486/problem/A
// Rating: 800 | Tags: implementation, math, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 
import java.util.Scanner;
public class cf_486A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long sum = 0;
        
        if (num % 2 == 0) {
            sum = num / 2;
        } else {
            sum = -(num + 1) / 2;
        }
        
        System.out.println(sum);


    }
}   
