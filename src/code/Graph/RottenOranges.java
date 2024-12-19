package code.Graph;

import java.util.*;


class RottenOranges {
    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<int[]>();
        int count = 0;
        int time = 0;

        for(int i=0; i<grid.length; i++){
            int[] items = grid[i];

            for(int j=0; j<items.length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            boolean neighbourFound = false;
            int size = queue.size();
            for(int k=0; k<size; k++){

                int[] item = queue.poll();
                int i = item[0];
                int j = item[1];

                if(checkForNeighbours(i+1,j,grid)){
                    neighbourFound= true;
                    queue.add(new int[]{i+1,j});
                }
                if(checkForNeighbours(i-1,j,grid)) {
                    neighbourFound= true;
                    queue.add(new int[]{i-1,j});
                }
                if(checkForNeighbours(i,j+1,grid)) {
                    neighbourFound= true;
                    queue.add(new int[]{i,j+1});
                }
                if(checkForNeighbours(i,j-1,grid)) {
                    neighbourFound= true;
                    queue.add(new int[]{i,j-1});
                }
            }
            if(neighbourFound) time++;
        }

        return time;
    }

    public static boolean checkForNeighbours(int i, int j, int[][] grid){

        if(i < grid.length && i>=0 && j<grid[0].length && j>=0 && grid[i][j] == 1){
            grid[i][j] = 2;
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
