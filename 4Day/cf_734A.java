
import java.util.Scanner;
public class cf_734A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        String winers = sc.next();
        int anton = 0;
        int danik = 0;
        for (int i = 0; i < round; i++) {
            if(winers.charAt(i) == 'A'){
                anton++;
            }else{
                danik++;
            }
            
        }
        if (anton > danik) {
            System.out.println("Anton");
        }else if(danik > anton){
            System.out.println("Danik");
        }else{
            System.out.println("Friendship");
        }

        sc.close();

        
    }
}