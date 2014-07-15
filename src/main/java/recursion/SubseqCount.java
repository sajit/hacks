package recursion;

/**
 * Created by sajit on 7/13/14.
 */
public class SubseqCount {

    public static int count(String search,String target){
        if(search.isEmpty()){
            return 1;
        }
        else{
            int idx = target.indexOf(search.charAt(0));
            if(idx<0){
                return 0;
            }
            else{
                String remainingTarget = target.substring(idx+1);
                //choose this match --> search for rest of search in , rest of target
                //skip skip this match and search for substring in rest of target
                return count(search.substring(1),remainingTarget) + count(search,remainingTarget);
            }
        }
    }

    public static void main(String[] args){
        String search = "rabbi";
        String target = "rrabcbabitt";

        System.out.println(SubseqCount.count(search, target));

    }
}
