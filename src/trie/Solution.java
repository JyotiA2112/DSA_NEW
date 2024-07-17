package trie;


import java.util.Arrays;
import java.util.List;

class TrieNode{
    boolean wordEnd;
    TrieNode[] arr;

    TrieNode(){
        arr = new TrieNode[26];
        wordEnd = false;
        for (int i = 0; i < 26; i++)
            arr[i] = null;
    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(int i = 0; i< wordDict.size(); i++)
        {
            insertInTrie(root, wordDict.get(i));
        }

        return wordBreakImpl(root, s);
    }

    public void insertInTrie(TrieNode root, String word)
    {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(curr.arr[index] == null)
            {
                curr.arr[index] = new TrieNode();
            }
            curr = curr.arr[index];
        }
        curr.wordEnd = true;
    }

    public boolean search(TrieNode root, String s)
    {
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if(curr.arr[index] == null)
            {
                return false;
            }
            curr = curr.arr[index];
        }

        return curr != null && curr.wordEnd;
    }

    public boolean wordBreakImpl(TrieNode root, String str)
    {
        if(str.length() == 0) return true;
        for(int i = 1; i <= str.length(); i++)
        {
            if (search(root, str.substring(0, i))
                    && wordBreakImpl(root, str.substring(i, str.length())))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}