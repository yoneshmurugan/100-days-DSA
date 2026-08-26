public class pattern12 {
    public static void main(String[] args){
        for (int i=0;i<=3;i++){
            for (int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            for (int q=3;q>i;q--){
                System.out.print("**");
            }
            for (int k=i+1;k>0;k--){
                System.out.print(k);
            }
            
            System.out.println();
        }

    }
}
