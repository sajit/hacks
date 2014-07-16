package strings;

/**
 * Created by skunnumkal on 7/14/14.
 */
public class MyStringUtils {

    /**
     * This is a hack, but one of the ways to return something from a void method is to pass in an arr ref
     * and assign it to that, which is what Im doing as the last parameter for this method
     * Further improvements can be made in how much we can move idx j forward [as given in BMS algo]
     * @param source
     * @param srcIdx
     * @param target
     * @param targetIdx
     * @param cut
     * @param idxArr
     */
    public void myIndexOf(String source,final int srcIdx,String target,final int targetIdx,
                          final int cut,final int[] idxArr){
        if(source == null){
            throw new IllegalArgumentException("Source string cannot be null");
        }
        if(target == null){
            throw new IllegalArgumentException("Target string cannot be null");
        }
        if(srcIdx >= source.length()){
            throw new IllegalArgumentException("Source Idx greater than source string length");
        }
        if(srcIdx<0 || targetIdx<0 || cut<0){
            throw new IllegalArgumentException("Bad index");
        }
        if(targetIdx + cut >= target.length()){
            throw new IllegalArgumentException("Target Idx and Cut greater than target string length");
        }
        int j = srcIdx;
        String  targetSubStr = "";
        for(int k=targetIdx;k<cut+targetIdx;k++){
            targetSubStr = targetSubStr + target.charAt(k);
        }
        System.out.println("The target String is= " + targetSubStr);
        while(j<source.length()){
            boolean isSubMatch = findMatch(j,targetSubStr,source);
            if(isSubMatch){
              idxArr[0] = j;
              System.out.println("Found a match at " + idxArr[0]);
              return;
            }
            j++;
        }


    }

    private boolean findMatch(int startIdx, String targetSubStr, String sourceStr) {
        if((sourceStr.length()-1-(startIdx)) < targetSubStr.length()){
            return false;
        }
        for(int i=startIdx,j= 0;i<sourceStr.length() && j<targetSubStr.length();i++,j++){
            if(sourceStr.charAt(i) !=targetSubStr.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MyStringUtils utils = new MyStringUtils();
        String source = "This is a fun problem";
        String target = "it is cool";
        int srcIdx = 0;
        int targetIdx = 3;
        int cut = 4;
        int[] indexArr = {-1};
        utils.myIndexOf(source,srcIdx,target,targetIdx,cut,indexArr);

        System.out.println("In Calling Method " + indexArr[0]);
    }
}
