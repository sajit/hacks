package recursion;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by sajit on 2/17/15.
 */
public class LearnYou<T extends Number> {

    MyMax<T> myMax;
    public LearnYou(MyMax<T> myMax){
        this.myMax = myMax;
    }
    public T maxVal(List<T> input){
        if(input.isEmpty()){
            throw new RuntimeException("boo hoo");
        }
        else if(input.size()==1){
            return input.get(0);
        }
        else{
            return myMax.getMax(input.get(0),maxVal(input.subList(1,input.size())));
            //return Math.max(input.get(0), maxVal(input.subList(1, input.size())));
        }
    }

    public static void main(String[] args){
        MyMax<Integer> intMax = new MyMax<>();
        LearnYou<Integer> learnYou = new LearnYou(intMax);
        System.out.println(learnYou.maxVal(ImmutableList.of(4, 3, 5, 7)));
    }
}
class MyMax<T extends Number>{
    public T getMax(T a,T b){
        if(a instanceof Integer && b instanceof Integer){
            Integer intA = (Integer)a;
            Integer intB = (Integer)b;
            if(intA.intValue() < intB.intValue()){
                return b;
            }
            else{
                return a;
            }

        }

        if(a instanceof Double && b instanceof Double){
            Double doubA = (Double)a;
            Double doubB = (Double)b;
            if(doubA.doubleValue() < doubB.doubleValue()){
                return a;
            }
            else{
                return b;
            }

        }
        return null;
    }
}
