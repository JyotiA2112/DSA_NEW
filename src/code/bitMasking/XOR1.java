package code.bitMasking;

public class XOR1 {

    public static void main(String[] args) {
        //int[] arr = new int[5];
        int[] arr = new int[]{2, 4, 2, 4, 1};
        int ans = 0;
        for(int i =0; i < arr.length; i++)
        {
            ans = ans ^ arr[i];
        }
        System.out.println(ans);

       // System.out.println(4^4);
        System.out.println(1<<1); //2
        System.out.println(1<<0); //1


    }
}
