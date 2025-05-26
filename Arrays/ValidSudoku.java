import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

// Imports not needed when submitting challenges

class Solution {

    public static void initializeMap(Map<Integer,Set<Character>> mp,int key){
        mp.put(key, new HashSet<>());
    }

     public static boolean containsOrPut(Map<Integer,Set<Character>> mp,int index,char c){
        if(!Character.isDigit(c)) return false;    
        if(mp.get(index).contains(c)){
                return true;
            }else{
                mp.get(index).add(c);
            }
            return false;
        }

    public boolean isValidSudoku(char[][] board) {

        Map<Integer,Set<Character>> rowMap=new HashMap<>();
        Map<Integer,Set<Character>> colMap=new HashMap<>();
        Map<Integer,Set<Character>> squareMap=new HashMap<>();
        
        boolean result=true;
        // precompute
        for(int i=0;i<board.length;i++){
            initializeMap(squareMap, i);
            for(int j=0;j<board[i].length;j++){
                int squareNum= (i/3)*3+ (j/3);
                if(!colMap.containsKey(j)) initializeMap(colMap,j);
                if(!squareMap.containsKey(squareNum)) initializeMap(squareMap, squareNum);
                // validate row
                if(containsOrPut(rowMap, i, board[i][j])) result= false;
                if(containsOrPut(colMap, j, board[i][j])) result= false;
                if(containsOrPut(squareMap, squareNum, board[i][j])) result= false;
            }
        }
        return result;
    }

    public static void main(String args[]){
       
    }
}
    // Not needed when submitting solution