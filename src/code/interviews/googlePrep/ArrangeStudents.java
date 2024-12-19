package code.interviews.googlePrep;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class ArrangeStudents {

    public static void main(String[] args) {

    }

    /*public static void findMinRows(int[] nums){

        List<TreeSet> list = new ArrayList<>();


        for(int i=0; i<nums.length; i++){

            if(list.size() == 0){
                TreeSet<Integer> treeSet = createTreeSet();
                treeSet.add(nums[i]);
            }else{
                for(int j=0; j<list.size(); j++){
                    TreeSet<Integer> treeSet = list.get(j);
                    int item = treeSet.first();

                }
            }
        }

    }*/

    public static int getMinimumRowsFormed(int[] students)  {
        int i = 0;
        int n = students.length;
        TreeMap<Integer, Integer> rows = new TreeMap<Integer, Integer>((a,b) -> Integer.compare(a,b));
        while( i < n) {
            Integer currRow = rows.higherKey(students[i]);

            if(rows.containsKey(students[i]))
                rows.put(students[i], rows.get(students[i])+1);
            else
                rows.put(students[i],  1);

            if(currRow != null) {
                int currRowfreq =  rows.get(currRow);
                if( currRowfreq == 1)
                    rows.remove(currRow);
                else{
                    rows.put(currRow, currRowfreq-1);
                }
            }
            // System.out.println(i+" "+rows);
            i++;
        }

        int noOfRows = 0;
        for(Integer row: rows.keySet())
            noOfRows += rows.get(row);

        return noOfRows;

    }

    public static TreeSet createTreeSet(){
        return new TreeSet<Integer>((a,b) -> Integer.compare(a,b));
    }
}
