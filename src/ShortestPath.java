import java.util.LinkedList;
import java.util.Queue;

class ShortestPath {

    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        sp.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}});
    }

    class Cell
    {
        int x;
        int y;
        int dist;

        Cell(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;


        int x[] = {-1,0,1,-1,1,-1,0,1};
        int y[] = {-1,-1,-1,0,0,1,1,1};

        boolean[][] visited = new boolean[n][m];


        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0,0,0));


        while(!queue.isEmpty())
        {
            Cell cell = queue.poll();
            int dist = cell.dist;
            if(cell.x == n-1 && cell.y == m-1)
            {
                return cell.dist + 1;
            }
            for(int i = 0 ; i < 8 ; i++)
            {
                int posX = cell.x+x[i];
                int posY = cell.y+y[i];
                if(posX >= 0 && posY >= 0 && posX < n && posY < m && grid[posX][posY]==0 && !visited[posX][posY])
                {
                    visited[posX][posY] = true;
                    queue.add(new Cell(posX, posY, dist++));
                }
            }
        }

        return -1;
    }
}