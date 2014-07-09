package recursion;

/**
 * Created by sajit on 7/8/14.
 */
public class SequenceContains {

    public static boolean contains(String search,String target){
        if(search.isEmpty()){
            return true;
        }
        char first = search.charAt(0);
        int idx = target.indexOf(first);
        if(idx<0){
            return false;
        }
        return contains(search.substring(1),target.substring(idx+1));
    }

    
}
