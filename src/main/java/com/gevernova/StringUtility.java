package com.gevernova;

public class StringUtility {
    public String reverse(String str){
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    public boolean isPalindrome(String str){
        String result= reverse(str);
        if(result.equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }
    public String upperCase(String str){
        return str.toUpperCase();
    }
}


