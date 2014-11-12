package recursion;

/**
 * Created by sajit on 11/2/14.
 */
public class PaintFill {

    public void fill(int x,int y,boolean[][] colored){
        if(x<0 || y< 0 || x>= colored.length || y >=colored.length){
            return;
        }
        if(colored[x][y]){
            return;
        }
        colored[x][y] = true;
        fill(x+1,y,colored);
        fill(x,y-1,colored);
        fill(x-1,y,colored);
        fill(x,y+1,colored);
        printGrid(colored);
    }

    public void printGrid(boolean[][] xy){
        for(int i=0;i<xy.length;i++){
            for(int j=0;j<xy[i].length;j++){
                String s = (xy[i][j])? "T" : "F";
                System.out.print(" " + s);
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }


    public static void main(String[] args){

        boolean[][] colored = {{false,false,false,false},{true,true,true,false},{false,false,true,false},{false,false,false,false}};
        PaintFill paintFill = new PaintFill();
        paintFill.printGrid(colored);
        paintFill.fill(3,0,colored);

    }


}
