package code.interviews;

public class MIcrosoft {

    //Implement an optimized code for the basic string compression algorithm which can convert the aabbbccaaa to a2b3c2a3 and cover the possible test cases and optimization.

    public static void main(String[] args) {


        System.out.println(compress("aabbbccaaa"));
        System.out.println(compress(""));
        System.out.println(compress("aaa1111bbb"));
        System.out.println(compress("aaaddddddddddddddddbbb1122233331111111111111111111"));
        System.out.println(compress("aaaaaaaaaaaaaaaaa"));
        System.out.println(compress("a b")); //a1 b1
        System.out.println(compress("aabb"));
        System.out.println(compress("a"));




    }

    public static StringBuilder compress(String a) //a b
    {
        //char ch = a.charAt(0);
        int count = 1;
        StringBuilder result = new StringBuilder("");

        if(a.length() == 1)
            return result.append(a);

        for(int i=1;i<a.length(); i++)//aaaaaaaaaa //O(n) //abcde //O(n)
        {




            while(i < a.length() && a.charAt(i) == a.charAt(i-1) )
            {
                count++;

                i++;
            }

            if(Integer.valueOf(a.charAt(i-1)) >=48 && Integer.valueOf(a.charAt(i-1))<=58)
            {
                result.append(".");
                //result = new StringBuilder(result + ".");
            }


            String intermediateString = count > 1 ? String.valueOf(a.charAt(i-1)) + count : String.valueOf(a.charAt(i-1));
            result = result.append(intermediateString);


            count = 1;

            if(i == a.length()-1 && a.charAt(i) != a.charAt(i-1))
            {
                if(Integer.valueOf(a.charAt(i-1)) >=48 && Integer.valueOf(a.charAt(i-1))<=58)
                {
                    result.append(".");
                }
                result = result.append(a.charAt(i));
            }
        }



        return result;
    }



}
