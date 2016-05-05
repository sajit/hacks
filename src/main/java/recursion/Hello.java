package recursion;

/**
 * Created by sajit on 5/5/16.
 */
public class Hello {

    private char[][] matrix = {{'o','l','l','o'},{'h','h','e','h'},{'h','e','l','o'},{'e','e','l','h'}};
    private int countHellos(String prefix, int i, int j){
        if(i<0 || j<0 || i>= matrix.length || j>= matrix.length || prefix.isEmpty()){
            return 0;

        }

        char head = prefix.charAt(0);
        if(head == matrix[i][j]){
            String tail = prefix.substring(1);
            if(tail.isEmpty()){
                //System.out.println("Exiting at " +i+","+j);
                return 1;
            }
            return countHellos(tail,i-1,j)+countHellos(tail,i,j+1)+countHellos(tail,i+1,j)+countHellos(tail,i,j-1);
        }
        else return 0;

    }

    public int countAll(){
        int sum = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j=0;j<matrix[i].length;j++){
                int thisCounts = countHellos("hello",i,j);
                if(thisCounts > 0)
                    System.out.println(" # hellos " + thisCounts + " at (i,j) = "+i+","+j);
                sum += thisCounts;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Hello hello = new Hello();
        System.out.println(hello.countAll());
    }
}
