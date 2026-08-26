public class pattern13 {
    static void imp1(int n) {
        int start = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        imp1(5);
    }
}
