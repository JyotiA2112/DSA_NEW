package code.interviews;

import java.util.HashMap;
import java.util.Map;

public class Walmart2 {

    //String s = "JyotiAgrawal" //J1y1o1t1

    //Stack - FIFO
    //Heap - (Min Heap, )
    public static void main(String[] args) {
        String s = "JyotiAgrawal";
        String res = "";
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    //4*4, 3*3, 2*4 - cartons
        //2*2, 2*4 1*2 - item
    //3*4 3*3 2*4 //count = 1
        //1*4
    //2*4, 2*2, 1*2 //2*4 //2*2 // 1*2



    //ALGO -
    // 1*4, 4*4, 3*3, 2*4 - cartons //count = 3
    //2*4 3*3 4*4
    //3*4 3*3 2*4

    //1*4 0
    /*



    Sort the Carton in increasing
    sort the items in decreasing

    for(Item)
        for(Carton)

            if(cartonSize > ItemSize)
            space = carton - item
            if(space <= 0) cartonFull;
            break;

    */








}
