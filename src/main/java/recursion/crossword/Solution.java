package recursion.crossword;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class Slot {
    final int start_row;
    final int start_col;
    final int end_row;
    final int end_col;

    public Slot(int start_row,int start_col,int end_row,int end_col){
        this.start_row = start_row;
        this.end_row = end_row;
        this.start_col  = start_col;
        this.end_col = end_col;
    }
    public int getLength(){
        if(start_col==end_col){
            return end_row-start_row+1;
        }
        else{
            return end_col-start_col+1;
        }
    }

    public boolean horizontalSlot(){
        return start_row==end_row;
    }

    @Override
    public String toString(){
        return "["+start_row+","+start_col+":"+end_row+","+end_col+"]";
    }
}
public class Solution {
    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        char[][] board = new char[crossword.length][crossword.length];
        int i=0;
        for(String s : crossword){
            for(int j=0;j<s.length();j++){
                board[i][j] = s.charAt(j);
            }
            i++;
        }
        List<Slot> slots = buildSlots(board);
        List<String> wordList = Arrays.asList(words.split(";"));
        solve(slots,wordList,board);

        return convert(board);

    }

    public static boolean solve(List<Slot> slots, List<String> wordList, char[][] board) {
        if(wordList.isEmpty()){
            return true;
        }
        String word = wordList.get(0);
        List<Slot> possibleSlots = slots.stream()
                .filter(aSlot -> aSlot.getLength()==word.length() && !conflicts(board,aSlot,word)).
                        collect(Collectors.toList());
        if(possibleSlots.isEmpty()){
            return false;
        }
        boolean result = true;
        for(Slot possibleSlot : possibleSlots){
            assign(word,possibleSlot,board);
            slots.remove(possibleSlot);
            wordList.remove(word);

            result = solve(slots,wordList,board);
            if(!result){
                unassign(word,possibleSlot,board);
                slots.add(possibleSlot);
                wordList.add(word);
            }

        }
        return result;
    }

    public static boolean conflicts(char[][] board, Slot slot, String word) {
        boolean conflict = false;
        if(slot.horizontalSlot()){
            int j=slot.start_col;
            for(int c=0;c<word.length();c++){
                char ch = board[slot.start_row][j];
                if(ch !='-' &&  ch!=word.charAt(c)) {
                    conflict = true;
                    break;
                }
                j++;
            }

        }
        else{
            int i=slot.start_row;
            for(int c=0;c<word.length();c++){
                char ch = board[i][slot.start_col];
                if(ch !='-' &&  ch!=word.charAt(c)) {
                    conflict = true;
                    break;
                }
                i++;
            }
        }
        return conflict;
    }

    public static void unassign(String word, Slot possibleSlot, char[][] board) {
        if(possibleSlot.horizontalSlot()){
            int j=possibleSlot.start_col;
            for(int c=0;c<word.length();c++){
                board[possibleSlot.start_row][j]='-';
                j++;
            }

        }
        else{
            int i=possibleSlot.start_row;
            for(int c=0;c<word.length();c++){
                board[i][possibleSlot.start_col]='-';
                i++;
            }
        }
    }

    public static void assign(String word, Slot possibleSlot, char[][] board) {


            if(possibleSlot.horizontalSlot()){
                int j=possibleSlot.start_col;
                for(int c=0;c<word.length();c++){
                    board[possibleSlot.start_row][j]=word.charAt(c);
                    j++;
                }

            }
            else{
                int i=possibleSlot.start_row;
                for(int c=0;c<word.length();c++){
                    board[i][possibleSlot.start_col]=word.charAt(c);
                    i++;
                }
            }

    }

    public static List<Slot> buildSlots(char[][] board) {
        List<Slot> slots = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            int j=0;
            boolean streak = false;
            int current_start=-1,current_end=-1;
            while(j<board[i].length){
                if(board[i][j]=='-'){
                    if(!streak){
                        current_start=j;
                    }
                    current_end=j;
                    streak = true;
                }
                else {
                    if(streak && current_end>current_start){
                        Slot newSlot = new Slot(i,current_start,i,current_end);
                        slots.add(newSlot);
                    }
                    current_start = current_end = -1;
                    streak = false;
                }
                j++;
            }
            if(streak && current_end>current_start){
                Slot newSlot = new Slot(i,current_start,i,current_end);
                slots.add(newSlot);
            }
        }
        for(int j=0;j<board[0].length;j++){
            int i=0;
            boolean streak = false;
            int current_start=-1,current_end=-1;
            while(i<board.length){
                if(board[i][j]=='-'){
                    if(!streak){
                        current_start=i;
                    }
                    current_end=i;
                    streak = true;
                }
                else {
                    if(streak && current_end>current_start){
                        Slot newSlot = new Slot(current_start,j,current_end,j);
                        slots.add(newSlot);
                    }
                    current_start = current_end = -1;
                    streak = false;
                }
                i++;
            }
            if(streak && current_end>current_start){
                Slot newSlot = new Slot(current_start,j,current_end,j);
                slots.add(newSlot);
            }
        }
        return slots;
    }

    private static String[] convert(char[][] board) {
        String[] crossword = new String[board.length];
        for(int i=0;i<crossword.length;i++){
            StringBuffer sb  = new StringBuffer();
            for(int j=0;j<board[i].length;j++){
                sb.append(board[i][j]);
            }
            crossword[i] = sb.toString();
        }
        return crossword;
    }

    // Complete the superDigit function below.

    static int doSuperDigit(String s){
        if(s.length()==1){
            return Integer.valueOf(s);
        }
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return doSuperDigit(String.valueOf(sum));

    }
    public static int superDigit(String n, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<k;i++){
            sb.append(n);
        }
        return doSuperDigit(sb.toString());
    }

    static long solve(long n) {

        for(long x=0;x<=n;x++){
            long xor = x^n;

            if(x+n==xor){
                return x;
            }
        }
        return n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] crossword = new String[10];

            for (int i = 0; i < 10; i++) {
                String crosswordItem = scanner.nextLine();
                crossword[i] = crosswordItem;
            }

            String words = scanner.nextLine();

            String[] result = crosswordPuzzle(crossword, words);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(result[i]);

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
