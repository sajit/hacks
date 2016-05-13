package recursion;

/**
 * Created by sajit.kunnumkal on 5/10/2016.
 */
public class SequenceSelector {

    public String seqeunceType(int[] arr){
        if(arr.length<3){
            return null;
        }
        if(arr[2]-arr[1] == arr[1] - arr[0]){
            return checkSequence(arr,2,SequenceType.ARITHMETIC,arr[2]-arr[1]);
        }
        else if(arr[2]/arr[1] == arr[1]/arr[0]){
            return checkSequence(arr,2,SequenceType.GEOMETRIC,arr[2]/arr[1]);
        }
        else return null;
    }

    private String checkSequence(int[] anArray, int currentIdx, SequenceType typeOfSequence, int ratio) {
        if(currentIdx>=anArray.length-1){
            return typeOfSequence.name();
        }
        else{
            if(typeOfSequence.equals(SequenceType.ARITHMETIC)){
                if(anArray[currentIdx+1]-anArray[currentIdx] == ratio){
                    return checkSequence(anArray,currentIdx+1,typeOfSequence,ratio);
                }
                else
                    return null;
            }
            else {
                if(anArray[currentIdx+1]/anArray[currentIdx] == ratio)
                    return checkSequence(anArray,currentIdx+1,typeOfSequence,ratio);
                else return null;
            }
        }

    }

    public static void main(String[] args){
            int[] arr = {2,4,6,8};
            SequenceSelector sequenceSelector = new SequenceSelector();
            System.out.println(sequenceSelector.seqeunceType(arr));
            System.out.println(sequenceSelector.seqeunceType(new int[]{2,4,6,8,12}));
    }
}
