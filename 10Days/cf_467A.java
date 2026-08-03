// Problem: George and Accommodation
// Contest: 467 | Index: A
// URL: https://codeforces.com/contest/467/problem/A
// Rating: 800 | Tags: implementation, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 
import java.util.Scanner;
public class cf_467A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count= sc.nextInt();
        int rooms=0;
        for (int i=0; i<count; i++){
            int p=sc.nextInt();
            int q=sc.nextInt();
            if (p<q){
                rooms+=1;
            }
        }
        System.out.println(rooms);
        sc.close();
    }
}

