package code.arrays;

import java.util.*;

public class ValidAnagram {

public static void findValidAnagram(List<String> words, List<String> queries)
{

    Map<String,List<String>> map = new HashMap<>();
    List<List<String>> answer = new ArrayList<>();

    for(int i = 0; i < words.size(); i++ )
    {
        String word = words.get(i);
        char[] temp = word.toCharArray();
        Arrays.sort(temp);

        if(map.containsKey(String.valueOf(temp)))
        {
            List list = map.get(String.valueOf(temp));
            list.add(word);
            map.put(String.valueOf(temp),list);

        }
        else
        {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(String.valueOf(temp),list);
        }
    }

    for(int i = 0; i < queries.size() ; i++)
    {
        String query = queries.get(i);
        char[] temp = query.toCharArray();
        Arrays.sort(temp);
        if(map.containsKey(String.valueOf(temp)))
        {
            answer.add(map.get(String.valueOf(temp)));
        }

    }

    for(int i=0; i < answer.size(); i++)
    {
        List<String> ans = answer.get(i);
        System.out.println("-------");
        for(int j = 0 ; j < ans.size(); j++ )
        {
            System.out.println(ans.get(i));
        }
    }

}

    public static void main(String[] args) {
        List<String> words = Arrays.asList("spede","dpees","fsd","dfs");
        List<String> query = Arrays.asList("speed","ffs");

        findValidAnagram(words,query);

    }
}
