package code.interviews;

import java.util.HashMap;
import java.util.Map;

public class GoogleRound1 {



        public static void main(String[] arg){
            int[] arr = new int[]{60,60,60};
            int N = 60;


            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int i=0; i<arr.length; i++){

                int mod = arr[i] % N;
                int diff = mod == 0 ? 0 : N-mod;
                count  = count + map.getOrDefault(diff, 0);
                map.put(mod, map.getOrDefault(mod,0)+1);
            }


            System.out.println(count);
        }
    }

