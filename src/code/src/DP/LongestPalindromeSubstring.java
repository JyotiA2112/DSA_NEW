package src.DP;

class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {

        int n = s.length();
        int start = 0;
        int maxLength = 1;

        if(n <= 1)
        {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++)
        {
            dp[i][i] = true;
            for(int j = 0; j < i ; j++)
            {
                if((i-j <= 2 || dp[j+1][i-1]) && s.charAt(j) == s.charAt(i))
                {
                    dp[j][i] = true;
                    if((i-j + 1) > maxLength)
                    {
                        start = j;
                        maxLength = i-j+1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("cbbd"));

    }
}
