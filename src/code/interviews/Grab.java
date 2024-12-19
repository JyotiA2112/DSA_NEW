package code.interviews;

public class Grab {


// you can also use imports, for example:
// import java.util.*;


    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        System.out.println(findMaxWater(new int[]{0,2,4,0,2,0,4}));


    }

    public static int findMaxWater(int[] arr){
        int start = -1;
        int end = -1;

        for(int i=0 ; i < arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                start = i;
                break;
            }
        }

        for(int i=arr.length-1; i>0; i--){
            if(arr[i-1] < arr[i]){
                end = i;
                break;
            }
        }

        if(start == -1 || end == -1){
            return -1;
        }

        int area = 0;
        while(start < end){
            System.out.println("start"+start);
            System.out.println("end"+end);
            int pointer2 = end;
            int pointer1 = end-1;

            while(arr[pointer1] < arr[pointer2]){
                pointer1--;
                if(pointer1 == start){
                    break;
                }
            }
            System.out.println("pointer1"+pointer1);
            System.out.println("pointer2"+pointer2);

            area = area + calculateArea(pointer1, pointer2, arr);
            end = pointer1;
            pointer2 = pointer1;

        }

        return area;

    }

    public static int calculateArea(int pointer1 , int pointer2, int[] arr){
        int b = pointer2 - pointer1 -1;
        int l = Math.min(arr[pointer1], arr[pointer2]);

        int sum = 0;
        for(int i = pointer1+1; i<pointer2; i++){
            sum = sum + arr[i];
        }

        return (l*b) - sum;
    }


}

