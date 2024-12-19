package code.interviews;

import java.util.*;

/**
 * In Android (the popular Google mobile operating system), the executable files storing apps on devices are called "APKs". And each APK contains something called a "Manifest" which stores which devices it is compatible with. So for example, it might say needs a specific Android version, or needs a GPS chip. In this question, we are only going to think about the Android version requirements in the Manifest.
 *
 * There are two values minSDKVersion and maxSDKVersion. Each of these is optional, and inclusive. By this I mean APKs don't have to specify minSDKVersion, but if they specify minSDKVersion = 3, then Android versions 3,4,5,etc all match, but 1 and 2 don't.
 *
 * An app developer can upload multiple APKs for their app to the Play Store, each with a different manifest. For example, they might have three APKs:
 *
 * APK	    | Min SDK Version	  | Max SDK Version
 * --------------------------------------------
 * APK A	  |    4	            |     -
 * --------------------------------------------
 * APK B	  |    -	            |     16
 * --------------------------------------------
 * APK C	  |    7	            |     10
 * --------------------------------------------
 *
 *   3     4 16 7 10 => 4 7 10 16 (4,0  7,1  10,2 16,3)
 *   17
 *   6
 *   11
 * Now, on Google Play you can have more than one APK per App, and we need to decide which one to deliver. So you could have A,B, and C. As part of this process we need to split up the space of all phones to which APKs they match.
 *
 * We want to divide the integer list of SDK versions into intervals that match the same APKs. So for this set we want to produce:
 *
 * (<=3), (4-6), (7-10), (11-16), (>=17)
 *
 * This is because <=3 matches only APK B, then (4-6) matches APK A & B, but not C, etc.
 *
 * Use whatever sensible data structure you want to represent the input and the output.
 *
 *
 *   class APK{
 *   String name;
 *   Integer minSDK;
 *   Integer maxSDK;
 *
 *   APK(String name, Integer minSDK, Integer maxSDK){
 *   }
 * }
 *
 * class Solution{
 *
 *   public static void main(String[] arg){
 *     List<APK> list = new ArrayList<APK>();
 *     int n= list.size()*2;
 *     int[] arr = new int[list.size()*2];
 *
 *     for(int i =0; i<list.size(); i++){
 *       int j = 2*i;
 *       APK apk = list.get(i);
 *       if(apk.minSDK != null) arr[j] = apk.minSDK;
 *       if(apk.maxSDK != null) arr[j+1] = apk.maxSDK;
 *   }
 *
 *     //[4,16,7,10]
 *     //[4,7,10,16]
 *
 *     Arrays.sort(arr);
 *     List<String> result = new ArrayList<>();
 *     list.add("<="+arr[0]-1); //<=3
 *
 *
 *       Map<Integer,Integer> map = new HashMap<>();
 *
 *     for(int i=0; i<arr.size(); i++){
 *       map.put(arr[i],i);
 *     }
 *
 *
 *     for(int i =0; i<list.size(); i++){
 *       int min = 0;
 *       int max = 0;
 *       APK apk = list.get(i);
 *       if(apk.minSDK != null){
 *         min = apk.minSDK; //4 //7
 *
 *         if(apk.maxSDK != null){
 *           max = apk.maxSDK //10
 *           }else{
 *           int index = map.get(apk.minSDK); //0
 *         max = arr[index+1] - 1; //6
 *
 *         }
 *       }else{
 *         if(apk.minSDK != null){
 *           min = apk.minSDK
 *         }else{
 *           int index = map.get(apk.maxSDK); //4
 *            min = arr[index-1] + 1; //11
 *         }
 *
 *         max = apk.maxSDK; //16
 *       }
 *
 *       list.add(min+"-"+max); //4-6 11-16 7-10
 *
 *     }
 *      list.add(">="+arr[n-1]+1) //>=17
 *     return list;
 * }
 *
 *   //Time Complexity = n + nlogn(sorting) = O(nlogn)
 *   //Space Complexity = O(n)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
class APK{
    String name;
    String min;
    String max;

    APK(String name, String min, String max){
        this.name = name;
        this.min = min;
        this.max = max;
    }
}

public class GoogleRound3 {

    public static void main(String[] args) {
        List< APK > input = new ArrayList< >();
        APK one = new APK (
                "A",
                "4",
                null
        );
        APK two = new APK (
                "B",
                null,
                "16"
        );
        APK three = new APK (
                "C",
                "7",
                "10"
        );
        input.add(one);
        input.add(two);
        input.add(three);

        int minSDK = Integer.MAX_VALUE;
        int maxSDK = Integer.MIN_VALUE;

        Set< Integer > startValues = new HashSet< >();
        for (APK eachEntry: input) {
            if (eachEntry.min != null) {
                startValues.add(Integer.parseInt(eachEntry.min));
                minSDK = Math.min(minSDK, Integer.parseInt(eachEntry.min));
            }
            if (eachEntry.max != null) {
                // Add 1 to the end range, as that would be the start of the next interval.
                startValues.add(Integer.parseInt(eachEntry.max) + 1);
                maxSDK = Math.max(maxSDK, Integer.parseInt(eachEntry.max));
            }
        }

        List < Integer > sortedList = new ArrayList < > (startValues);
        Collections.sort(sortedList);

        List < int[] > intervals = new ArrayList < > ();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            int start = sortedList.get(i);
            // Subtract 1 from the start of the next interval to get the end of the current range
            int end = sortedList.get(i + 1) - 1;
            intervals.add(new int[] {
                    start,
                    end
            });
        }

        System.out.println();
        System.out.print("<=" + (minSDK - 1) + ",");
        for (int[] interval: intervals) {
            System.out.print(" [" + interval[0] + ", " + interval[1] + "], ");
        }
        System.out.print(">=" + (maxSDK + 1) + ".");
        System.out.println();
    }
}
