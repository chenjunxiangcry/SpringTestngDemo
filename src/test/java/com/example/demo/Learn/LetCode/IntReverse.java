package com.example.demo.Learn.LetCode;

public class IntReverse {
        public static int reverse(int x) {
            int r=0;
            while(x!=0){
                r=10*r+x%10;
                x=x/10;
            }
            return r;
        }
        public static int myAtoi(String s) {
            long r = 0;
            int sign = 1;
            int i = 0;
            s = s.trim();
            if (s.length() == 0) {
                return -1;
            }
            switch (s.charAt(0)) {
                case '-':
                    sign = -1;
                    i = 1;
                    break;
                case '+':
                    sign = 1;
                    i = 1;
                    break;
                default:
                    break;
            }
            for (; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    r = 10 * r + (s.charAt(i)-'0');
                    if (sign * r > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (sign * r < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }else {
                    break;
                }
            }
            return (int) (sign * r);
        }

    public static void main(String[] args){
        System.out.println(reverse(-990019));
        System.out.println(myAtoi("   -42"));

    }


}
