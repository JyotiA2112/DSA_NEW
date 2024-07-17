package src.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        int s = start[0];
        int e = end[0];

        //int[][] result = new int[][]{};
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i=0; i < intervals.length -1 ; i++)
        {
            if(start[i+1] < end[i])
            {
                s = Math.min(s,start[i+1]);
                e = Math.max(e,end[i+1]);
                //i=i+1;
            }
            else{
                result.add(Arrays.asList(s,e));
            }

        }

        return (int[][]) result.toArray();
    }
}
