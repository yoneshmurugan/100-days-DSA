// Problem: Vanya and Fence
// Contest: 677 | Index: A
// URL: https://codeforces.com/contest/677/problem/A
// Rating: 800 | Tags: implementation, *800
// Memory: 256 megabytes | Time: 1 second
// Author: 
import java.util.Scanner;
public class cf_677A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int width = 0;
        int count = sc.nextInt();
        int fence = sc.nextInt();
        int [] height = new int[count];
        for (int i = 0; i < count; i++){
            height[i] = sc.nextInt();
            if (height[i] > fence){
                width +=2;
            }
            else{
                width +=1;
            }

        }
        System.out.println(width);
        sc.close();

    }
}

