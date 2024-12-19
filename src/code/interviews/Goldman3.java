package code.interviews;

class Goldman3 {
    public static void main(String[] args) {
        Goldman3 gm = new Goldman3();
        gm.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
    }
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        for(int i=0; i<weights.length ; i++){
            sum += weights[i];
        }

        int avg = sum/days;

        int min = avg;
        int max = sum;

        return findMin(weights, min, max, days);



    }

    public int findMin(int[] weights, int min, int max, int days){
        while(min < max){
            int mid = (min+max)/2;
            boolean flag = checkForFitness(mid, weights, days);
            if(flag){
                findMin(weights, min, mid, days);
            }else{
                findMin(weights, mid+1, max, days);
            }
        }

        return min;
    }

    public boolean checkForFitness(int weight, int[] weights, int days){
        int count = 1;
        int end = weights.length;
        int i=0;
        int sum = 0;
        for (int w: weights) {
            if (sum + w > weight) {
                count += 1;
                sum = 0;
            }
            sum += w;
        }
        

        return count <= days;
    }
}
