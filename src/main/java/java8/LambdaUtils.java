package java8;

interface PerformOperation {
    boolean check(int a);
}
public class LambdaUtils {
    PerformOperation isOdd = a -> a%2!=0;
    PerformOperation isPrime = a -> {
        for(int i=2;i<=a/2;i++){
            if(a%i==0){
                return false;
            }
        }
        return a>1;
    };
    PerformOperation isPalindrome = a -> {
        String aStr = String.valueOf(a);
        for(int i=0;i<aStr.length()/2;i++){
            if(aStr.charAt(i)!=aStr.charAt(aStr.length()-1-i)){
                return false;
            }
        }
        return true;
    };
}
