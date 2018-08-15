package dp;

import java.util.Arrays;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        return manipulate(a,b)?"YES":"NO";

    }
    static int getFirstLowerCaseLetterIdx(String str) {
        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    static boolean manipulate(String a,String b) {
        if(a.equals(b)){
            return true;
        }
        else {
            int firstLowerCaseLetterIdx = getFirstLowerCaseLetterIdx(a);
            //capitalize and call function
            if(firstLowerCaseLetterIdx==-1){
                //no lower case left
                return a.equals(b);
            }
            else {
                char[] aChars = a.toCharArray();
                String allSmallRemovedA = removeAllSmallCaseChars(a);
                boolean removedSmallResult = manipulate(allSmallRemovedA,b);
                if(!removedSmallResult) {
                    boolean capALetterResult = false;
                    for(int i=0;i<a.length();i++) {
                        if(Character.isLowerCase(a.charAt(i))){
                            aChars[i] = Character.toUpperCase(a.charAt(i));
                            capALetterResult = manipulate(new String(aChars),b);
                            if(capALetterResult){
                                break;
                            }
                            else {
                                aChars[i] = Character.toLowerCase(aChars[i]); //reset and next try another letter
                            }
                        }
                    }
                    return capALetterResult;
                }
                else
                    return true;


            }
            //or delete lowercases and call

        }

    }

    static String removeAllSmallCaseChars(String a) {
        StringBuilder sb = new StringBuilder();
        for(char ch : a.toCharArray()){
            if(Character.isUpperCase(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(abbreviation("AbcDE","ABDE"));
        System.out.println(abbreviation("AbcDE","AFDE"));
        System.out.println(abbreviation("daBcd","ABC"));
    }
}
