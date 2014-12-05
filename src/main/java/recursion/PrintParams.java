package recursion;

/**
 * Created by sajit on 11/2/14.
 */
public class PrintParams {

    public void print(int startCount,int endCount,int max,String soFar){
        if(startCount == max){
            if(endCount == max){
                System.out.println(soFar);
            }
            else{ //endCount < max
                print(startCount, endCount + 1, max, soFar + ")");
            }
        }
        else{ //startCount < max
            if(startCount == endCount){
                print(startCount+1,endCount,max,soFar+"(");
            }
            else{
                print(startCount+1,endCount,max,soFar+"(");
                print(startCount,endCount+1,max,soFar+")");
            }
        }
    }

    public static void main(String[] args){
        PrintParams pp = new PrintParams();
        pp.print(0,0,3,"");
    }
}
