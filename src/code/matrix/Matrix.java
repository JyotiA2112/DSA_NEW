package code.matrix;



import java.util.ArrayDeque;
        import java.util.Queue;

public class Matrix {
    public static int minMovesToReach(int[][] matrix, int startRow,
                                      int startCol, int targetRow, int targetCol, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int distance = curr[2];
            System.out.println("row:" + row + " col:"+ col + " dis:" + distance);
            if (row == targetRow && col == targetCol) {
                return distance;
            }
            int[] dx = {0,1,-1,0};
            int[] dy = {1,0,0,-1};
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j <4; j++) {

                    int newRow = row + i*dx[j];
                    int newCol = col + i*dy[j];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol, distance + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0}
        };
        int startRow = 0;
        int startCol = 0;
        int targetRow = 4;
        int targetCol = 4;
        int k = 2;
        System.out.println(minMovesToReach(matrix, startRow, startCol, targetRow, targetCol, k));
    }
}


