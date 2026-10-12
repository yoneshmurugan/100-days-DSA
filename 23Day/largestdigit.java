class Solution {
    public int largestDigit(int n) {
        int num = Math.abs(n);
        int digit=0;
        if (num==0){
            return 0;
        }
        while(num>0){
            int ladigit = num%10;
            digit=ladigit>digit?ladigit:digit;
            num = num/10;



        }
        return digit;

    }
}