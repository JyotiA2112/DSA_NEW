package code.interviews;

public class SumOfAllGoodSubArrays {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 4, 5, 6, 5};

        int sum = 0;
        int sas = 0; // subarray sum
        int sad = 0; // prev subarray diff
        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];

            if(i < 1)
                continue;

            if(arr[i] - arr[i-1] == 1) {
                if(sad == 1) {
                    sas += arr[i];
                    sum += (arr[i] + arr[i-1]);
                } else {
                    sas = (arr[i] + arr[i-1]);
                }

                sum += sas;
                sad = 1;
            } else if(arr[i] - arr[i-1] == -1) {
                if(sad == -1) {
                    sas += arr[i];
                    sum += (arr[i] + arr[i-1]);
                } else {
                    sas = (arr[i] + arr[i-1]);
                }
                sad = -1;
                sum += sas;
            }
        }
        System.out.println(sum);
    }
}


