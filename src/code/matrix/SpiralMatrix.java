package code.matrix;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public List<Integer> spiralOrder(int[][] matrix) {



        int colEnd = matrix[0].length-1;
        int rowEnd = matrix.length-1;
        int rowStart = 0;
        int colStart = 0;

        int col = matrix[0].length;
        int row = matrix.length;

        //boolean visited[][] = new boolean[row][column];
        List<Integer> list = new ArrayList<>();

        int currentRow = 0;
        int currentCol = 0;

        while(rowStart <= rowEnd && colStart <= colEnd)
        {
            //printLeftToRight(currentRow,currentCol,rowStart,colEnd,list,matrix);
            while(currentCol <= colEnd)
            {
                list.add(matrix[currentRow][currentCol]);
                currentCol++;
            }
            rowStart ++;
            //printTopToDown(currentRow,currentCol,colEnd,rowEnd,list,matrix);
            while(currentRow <= rowEnd)
            {
                list.add(matrix[currentRow][currentCol]);
                currentRow++;
            }
            colEnd --;
            //printRightToLeft(currentRow,currentCol,rowEnd,colStart,list,matrix);
            while(currentCol >= colStart)
            {
                list.add(matrix[currentRow][currentCol]);
                currentCol--;
            }
            rowEnd --;
            //printDowntoTop(currentRow,currentCol,colStart,rowStart,list,matrix);
            while(currentRow >= rowStart)
            {
                list.add(matrix[currentRow][currentCol]);
                currentRow--;
            }
            colStart ++;

        }

        return list;
    }

    public void printLeftToRight(int currentRow,int currentCol,int rowStart,int colEnd,List<Integer> list,int[][] matrix){
        while(currentCol <= colEnd)
        {
            list.add(matrix[currentRow][currentCol]);
            currentCol++;
        }


    }

    public void printTopToDown(int currentRow,int currentCol,int colEnd,int rowEnd,List<Integer> list,int[][] matrix){
        while(currentRow <= rowEnd)
        {
            list.add(matrix[currentRow][currentCol]);
            currentRow++;
        }


    }

    public void printRightToLeft(int currentRow,int currentCol,int rowEnd,int colStart,List<Integer> list,int[][] matrix){
        while(currentCol >= colStart)
        {
            list.add(matrix[currentRow][currentCol]);
            currentCol--;
        }


    }

    public void printDowntoTop(int currentRow,int currentCol,int colStart,int rowStart,List<Integer> list,int[][] matrix){
        while(currentRow >= rowStart)
        {
            list.add(matrix[currentRow][currentCol]);
            currentRow--;
        }


    }
}