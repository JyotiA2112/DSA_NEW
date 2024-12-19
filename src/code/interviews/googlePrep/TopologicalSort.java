package code.interviews.googlePrep;

import java.util.*;


public class TopologicalSort {
    public List<String> getExecutionOrder(List<List<String>> tasks) {
        Map<String, Integer> prereqs = new HashMap<>(); // prereqs[task] == number of incomplete jobs
        Map<String, List<String>> subsequent = new HashMap<>(); // subsequent[task] == list of tasks that directly depend on task

        for (List<String> lst : tasks) {
            prereqs.putIfAbsent(lst.get(0), 0); // make sure there's a key for every task
            for (int i = 0; i < lst.size() - 1; i++) {
                prereqs.putIfAbsent(lst.get(i + 1), 0);
                prereqs.put(lst.get(i + 1), prereqs.get(lst.get(i + 1)) + 1);
                subsequent.putIfAbsent(lst.get(i), new ArrayList<>());
                subsequent.get(lst.get(i)).add(lst.get(i + 1));
            }
        }

        List<String> out = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : prereqs.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            String task = q.poll();
            out.add(task); // no prereqs: can do this task right now
            for (String laterTask : subsequent.getOrDefault(task, new ArrayList<>())) {
                prereqs.put(laterTask, prereqs.get(laterTask) - 1);
                if (prereqs.get(laterTask) == 0) {
                    q.add(laterTask);
                }
            }
        }

        if (out.size() == prereqs.size()) {
            return out;
        } else {
            // didn't reach all tasks: there must be a cycle in the graph such that all remaining nodes have 1+ prerequisite
            return new ArrayList<>();
        }
    }
}


