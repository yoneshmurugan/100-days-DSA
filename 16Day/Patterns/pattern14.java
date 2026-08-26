public class pattern14 {
    static void square(int n) {
        int square = (n * 2) - 1;
        for (int i = 1; i <= square; i++) {
            for (int j = 1; j <= square; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == 1 + k || j == 1 + k || i == square - k || j == square - k) {
                        System.out.print((n - k) + " ");
                        break; 
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        square(6);
    }
}   
