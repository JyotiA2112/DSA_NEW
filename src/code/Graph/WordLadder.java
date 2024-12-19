package code.Graph;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        wl.ladderLength("hit","cog",Arrays.asList(new String[]{"hit","hot", "dot", "dog", "lot", "log", "cog"}));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int wordLength = beginWord.length();
        Map<String,List<String>> map = new HashMap<>();
        /*if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }*/
        int dictSize = wordList.size();

        for(int i = 0; i<dictSize; i++){
            String word = wordList.get(i);
            map.put(word,new ArrayList<String>());

            for(int j=i+1; j<dictSize; j++){
                String currWord = wordList.get(j);
                int count = 0;

                for(int k=0;k<wordLength; k++){
                    if(word.charAt(k) != currWord.charAt(k)){
                        count++;
                    }
                }

                if(count == 1){
                    map.get(word).add(currWord);
                }
            }
        }

        return performBFS(beginWord,endWord,map);
    }

    public int performBFS(String beginWord, String endWord, Map<String,List<String>> map){
        Queue<Item> queue = new LinkedList();
        queue.add(new Item(beginWord,0));
        int dist = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Item item = queue.poll();
            List<String> list = map.get(item.word);
            for(int i=0; i<list.size(); i++){
                if(list.get(i) != endWord && list.get(i)!= beginWord){
                    queue.add(new Item(list.get(i),item.dist+1));
                }else{
                    dist = Math.min(dist,item.dist+1);
                }

            }


        }

        System.out.println(dist);
        return dist;


    }

    class Item{
        String word;
        int dist;

        Item(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }


}
