package code.interviews.googlePrep;

import java.util.HashMap;
import java.util.Map;

class CheckForValidAnagram {

    public static void main(String[] args) {
        checkInclusion("adc", "dcda");
    }
    public static boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }

        int pointer1 = 0;
        int pointer2 = s1.length();

        while(pointer2 <= s2.length()){
            Map<Character, Integer> localMap = new HashMap<Character, Integer>();
            for(int j=pointer1; j<pointer2 ; j++){
                localMap.put(s2.charAt(j), localMap.getOrDefault(s2.charAt(j),0)+1);
            }
            boolean flag = true;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){

                // if(!localMap.containsKey(entry.getKey())
                // || (localMap.containsKey(entry.getKey())
                // && localMap.get(entry.getKey()) != entry.getValue())){
                if(localMap.getOrDefault(entry.getKey(), -1) != entry.getValue()){
                    flag = false;
                }
            }
            if(flag) return true;
            pointer1++;
            pointer2++;
        }

        return false;
    }
}
