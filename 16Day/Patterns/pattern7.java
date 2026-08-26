public class pattern7 {
    public static void main(String[] args){
        for (int i=1;i<=5;i++){
            for (int j=4;j>=i;j--){
                System.out.print(" ");
            }
            for (int q=1;q<=i*2-1;q++){
                System.out.print("*");
            }
            for (int p=4;p>=i;p--){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
