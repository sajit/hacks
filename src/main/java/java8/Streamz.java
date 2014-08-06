package java8;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by skunnumkal on 7/30/14.
 */
public class Streamz {

    public static void main(String[] args){
        List<Integer> integerList = ImmutableList.of(4,5,1,6,8,19);
        Stream<Integer> aStream = integerList.stream().filter(p -> p %2 == 0);

        System.out.println(aStream.count());
    }
}
