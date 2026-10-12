import java.util.*;

public class odddigit {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int count =0;
        int num=Math.abs(n);
        if (num==0){
            System.out.println(1);

        }  
        while(num>0){
            int digit = num%10;
            count = digit%2==1?count+1:count+0;
            num = num/10;
        }      
        System.out.println(count);
    }
    
}
