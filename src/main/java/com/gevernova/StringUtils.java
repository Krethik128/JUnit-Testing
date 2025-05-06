package com.gevernova;

public class StringUtils {
        public static String reverse(String str){
                return new StringBuilder(str).reverse().toString();
        }

        public static Boolean isPalindrome(String str){
            String reversed=reverse(str);
            return str.equals(reversed);

        }
        public static String toUpperCase(String str){
            return str.toUpperCase();
        }

}

