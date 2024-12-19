package code.arrays;

public class GenerateAllSubArrays {

    public static void main(String[] args) {
        printSubarrays(new int[]{1,2,3,4});
    }

    public static void printSubarrays(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}


