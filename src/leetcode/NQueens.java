package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class NQueens {
    public static void main(String[] args) {

        test1();
    }

    public static void test1() {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(4);

    }

    public List<List<String>> solveNQueens(int n) {

        List<String> rows = new ArrayList<>();
        int x = 0;
        int y = 0;
        int z = 0;
        StringBuilder row = new StringBuilder();
        int currentRow = -1;
        int currentColumn = -1;
        Set<Integer> currentRows = new HashSet<>();
        Set<Integer> currentColumns = new HashSet<>();
        List<Integer> currentElement =  new ArrayList<>();
        List<List> nQueen = new ArrayList<>();

        //[ (0,1) (1,3) (2,0) (3,2) ]
        //[ (0,2) (1,0) (2,3) (3,1) ]

        // not same row,
        //not same column
        // find out current element's diagonal co-ordinates

        while (x < n) {
            while (y < n) {

                if (x == y) {
                    // ignore this co-ordinate (diagonal case)
//                    System.out.println("diagonal (x,y)-->(" + x + ", " + y + ")");

                } else {
                    if (currentRows.isEmpty()) {
                        currentRows.add(x);
                        currentRows.add(y);
                        currentElement.add(x);
                        currentElement.add(y);
                        nQueen.add(currentElement);
                        row.append("Q");

                    } else {
                        if (!currentElement.get(0).equals(x) && !currentElement.get(1).equals(y) && ! isDiagonalOfCurrentElement(nQueen,x,y,n)) {
                            System.out.println(currentElement);
                            System.out.println("(x,y)-->(" + x + ", " + y + ")");
                            currentElement = new ArrayList<>();
                            currentElement.add(x);
                            currentElement.add(y);
                            nQueen.add(currentElement);
                            //Q maybe
//                            row.append("Q");

                        }
                        else{
                            // .(dot) maybe
//                            row.append(".");
                        }
                    }
                }
                y++;
            }
            x++;
            y = 0;
//            rows.add(row.toString());
//            row.setLength(0);

        }

        List<List<String>> finalList = new ArrayList<>();
        List<String> roww = new ArrayList<>();
        int yc;
        int r = 0;
        for(List<Integer> coordin: nQueen) {

            row.setLength(0);
//            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++) {
                    if (r == coordin.get(0) && c == coordin.get(1)) {
                        row.append("Q");
                    } else {
                        row.append(".");
                    }
                }
                roww.add(row.toString());
                row = new StringBuilder();
                r += 1;

//            }
        }
        finalList.add(roww);
     /*   List<Integer> coordincates = new ArrayList<>();
        List<List> nQueen = new ArrayList<>();
        while(true) {
            y +=1;
            z +=1;
            while (x < n) {
                coordincates.add(x);
                coordincates.add(y);
                x += 1;
                if(y >=n-1) y = 0;
                else y += 2;

                nQueen.add(coordincates);
                coordincates = new ArrayList<>();
            }
            break;
        }
*/
      /*  while (x < n) {
            while (y < n) {

                if( x == y){
                    System.out.println("if 1 --> x="+x+" y="+y);
//                    row.append("Q");
                  }
                else {
//                    if(currentRow !=x && currentColumn != y){
                    //[(0,1) (1,3) (2,0), (3,2) ]  [ (0,2) (1,0) (2,3) (3,2)]
                    if(! currentRows.contains(x) && ! currentColums.contains(y)){
                        System.out.println("if 2 --> x="+x+" y="+y);
                        currentRows.add(x);
                        currentColums.add(y);
                        currentRow = x;
                        currentColumn = y;

                    }
                    else{
                        System.out.println("if 3 --> x="+x+" y="+y);

                    }
//                    row.append(".");
                }

                y++;
            }

            rows.add(row.toString());
            x++;
            y=0;
            row.setLength(0);
            currentColums.clear();

        }
      */
        return finalList;
    }
    public boolean isDiagonalOfCurrentElement(List<List> nQueen, int x, int y, int n){
        //right side diagonal
        for( List<Integer> currentElement: nQueen ){
        int currentX = currentElement.get(0);
        int currentY = currentElement.get(1);

        while(true){
            if(currentX > n-1 || currentY > n-1) break;
            currentX = currentX + 1;
            currentY = currentY + 1;
            if(currentX == x && currentY == y) {
                System.out.println("isDiagonalOfCurrentElement-->true for "+currentX+","+currentY );
                return true;
            }

        }
        currentX = currentElement.get(0);
        currentY = currentElement.get(1);

        while(true){
            if( currentY <0 ) break;
            currentX = currentX + 1;
            currentY = currentY - 1;
            if(currentX == x && currentY == y) {
                System.out.println("isDiagonalOfCurrentElement--> true for "+currentX+","+currentY );
                return true;
            }

        }
            while(true){
                if( currentX <0 ) break;
                currentX = currentX - 1;
                currentY = currentY + 1;
                if(currentX == x && currentY == y) {
                    System.out.println("isDiagonalOfCurrentElement--> true for "+currentX+","+currentY );
                    return true;
                }

            }
        }
        return false;
    }
    public boolean isThereAnyElementInSameColumn(List<List> nQueen, int y){
        return false;
    }
}
