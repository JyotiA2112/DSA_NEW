package code.interviews.googlePrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortHouseInNeighbourhood {

    /*
    You are given a list of houses grouped into neighborhoods. Houses are painted in colors.

The first input is an array representing house numbers in each neighborhood. One sub-array represents one neighborhood.
Example:

{ {8, 2, 9}, {4, 6, 4}, {4, 5, 1} }

Each house is painted, so the second input is an array representing the color codes for each house. Example:

{ {'r', 'g', 'b'}, {'w', 'c', 'b'}, {'x', 'y', 'b'} }

This means that House 8 is painted in color r, House 2 is g, House 9 is b etc.

Imagine that you can move houses, reorganize the neighborhoods such that the houses in each neighborhood are in
ascending order, and no house numbers are repeated in a neighborhood. The neighborhood structure must be preserved,
meaning that the number of neighborhoods and the number of houses in each neighborhood should remain the same as given.

Here are a couple of possible outputs of how the houses from the example above could be restructured:

{ {1, 2, 4}, {4, 5, 6}, {4, 8, 9} }

{ {1, 4, 6}, {2, 4, 8}, {4, 5, 9} }

Return all houses structured in neighborhoods along with their colors in the new order. If printing it, a
sample output would look like this:

{ {1b, 4b, 6c}, {2g, 4x, 8r}, {4w, 5y, 9b} }
     */

    static class Item{
        int house;
        char color;

        public Item(int house, char color){
            this.house = house;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        int house[][] = new int[][]{ {8, 2, 9}, {4, 6, 4}, {4, 5, 1} };
        char colors[][] = new char[][]{ {'r', 'g', 'b'}, {'w', 'c', 'b'}, {'x', 'y', 'b'} };

        int rows = house.length;
        int col = house[0].length;

        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.house));

        for(int i=0; i< rows; i++) {
            for(int j=0; j<col ; j++){
                pq.add(new Item(house[i][j], colors[i][j]));
            }
        }

        String output[][] = new String[rows][col];

        for(int j=0; j<col; j++){
            for(int i=0; i<rows; i++){
                Item item = pq.poll();
                output[i][j] = item.house + String.valueOf(item.color);
            }
        }


        Arrays.asList(output).forEach(data -> printArray(data));





    }

    public static void printArray(String[] arr){
        Arrays.stream(arr).forEach(data -> System.out.println(data));
    }
}
