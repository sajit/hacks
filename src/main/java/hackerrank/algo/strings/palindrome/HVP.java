package hackerrank.algo.strings.palindrome;

import java.util.HashSet;
import java.util.Set;

public class HVP {

    static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    static String aPalindrome(String s,int attemptsLeft,int currentIdx,Set<Integer> changeSet){
        if(attemptsLeft>0 && currentIdx<s.length()/2){
            if(isPalindrome((s)))
                return maximizePalindrome(s,attemptsLeft+changeSet.size());
            else {
                //if needed change currentIdx
                //call aPalindrome for next index
                char thisChar = s.charAt(currentIdx);
                char otherChar = s.charAt(s.length()-1-currentIdx);
                if(thisChar==otherChar){
                    return aPalindrome(s,attemptsLeft,currentIdx+1,changeSet);
                }
                else {
                    //find max among the two digits
                    int maxNum = Math.max((int)thisChar,(int)otherChar);
                    char[] charArr = s.toCharArray();
                    charArr[currentIdx]=(char)maxNum;
                    charArr[charArr.length-1-currentIdx]=(char)maxNum;
                    if((char)maxNum<'9'){
                        changeSet.add(currentIdx);
                    }

                    return aPalindrome(new String(charArr),attemptsLeft-1,currentIdx+1,changeSet);

                }
            }
        }
        else {
            return isPalindrome(s)?s:"-1";
        }
    }

    static String maximizePalindrome(String palindrome, int attemptsLeft) {

        int index=0;
        char[] chars = palindrome.toCharArray();
        while(attemptsLeft>1){
            if(palindrome.charAt(index)<'9'){
                chars[index]='9';
                chars[chars.length-1-index]='9';
                attemptsLeft=attemptsLeft-2;
                index+=1;
            }
        }
        if(attemptsLeft==1 && chars.length%2!=0){
            chars[chars.length/2]='9';
        }
        return new String(chars);
    }

    public static void main(String[] args){
        System.out.println(aPalindrome("3943",1,0,new HashSet<>()));
        System.out.println(aPalindrome("092282",3,0, new HashSet<>()));
        System.out.println(aPalindrome("0011",1,0, new HashSet<>()));
    }
}
