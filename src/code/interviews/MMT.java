package code.interviews;

import java.util.Stack;

/*
No of wats you can come out of grid.
int rows = 1, cols =3, startRow = 0, startCol = 1, maxMoves = 2

[1,1,1] //8

 */

class Item{
    int row;
    int col;
    int moves;

    Item(int row, int col, int moves){
        this.row = row;
        this.col = col;
        this.moves = moves;

    }
}
public class MMT {

    public static void main(String[] args) {
        System.out.println("Hello");
        checkIfInsideGrid(new int[][]{{1,1,1},{1,1,1},{1,1,1}},2,1,1);
    }

    public static void checkIfInsideGrid(int[][] grid, int maxMoves, int startRow, int startCol){
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        Stack<Item> stack = new Stack();
        boolean[][] visited = new boolean[maxRow][maxCol];

        if(startRow >= 0 && startCol >= 0 && startRow < grid.length && startCol <grid[0].length ){
            stack.push(new Item(startRow, startCol, 0));
        }

        int count = 0;

        while(!stack.isEmpty()){
            Item item = stack.pop();
            if(visited[item.row][item.col]){
                continue;
            }
            visited[item.row][item.col] = true;
            int move = item.moves + 1;
            int row = item.row;
            int col = item.col;

            if(move <= maxMoves){
                count += checkForFourPosition(stack,row+1,col,grid,count,move);;
                count += checkForFourPosition(stack,row,col+1,grid,count,move);;
                count += checkForFourPosition(stack,row-1,col,grid,count,move);;
                count += checkForFourPosition(stack,row,col-1,grid,count,move);;
            }

        }


        System.out.println("Count" + count);

    }

    public static int checkForFourPosition(Stack stack, int startRow, int startCol, int[][] grid, int count, int move){
        if(startRow >= 0 && startCol >= 0 && startRow < grid.length && startCol <grid[0].length ){
            stack.push(new Item(startRow, startCol, move));
            return 0;
        }
        else{
            return 1;
        }
    }
}
