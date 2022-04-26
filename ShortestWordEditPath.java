import java.io.*;
import java.util.*;

public class ShortestWordEditPath {
	
	private static int shortestWordEditPath(String source, String target, String[] words) {
        Map<String, List<String>> wordGraph = buildWordGraph(words);
        int minPathLen = Integer.MAX_VALUE;
        for (String word : words) {
            if (isNeighbour(source, word)) {
            	int pathLen = breadthFirstSearchPathLen(word, target, wordGraph);
                if (pathLen != -1 && minPathLen > pathLen) {
                    minPathLen = pathLen;
                }
            }
        }
        return (minPathLen == Integer.MAX_VALUE) ? -1 : minPathLen + 1;
    }

    private static int breadthFirstSearchPathLen(String source, String target, Map<String, List<String>> wordGraph) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        Set<String> visited = new HashSet<>();
        String dummy = "";
        int level = 0;
        queue.add(dummy);
        while (!queue.isEmpty()) {
        	String item = queue.poll();
        	if (item.equals(target)) {
                return level;
            }
            if (item.equals(dummy)) {
                if (queue.isEmpty()) {
                	return -1;
                }
                level++;
                queue.add(item);
                continue;
            }
            visited.add(item);
            for (String neighbour : wordGraph.get(item)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        return -1;
    }

    private static boolean isNeighbour(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        boolean diffFound = false;
        int i = 0;
        while (i < source.length()) {
            if (source.charAt(i) == target.charAt(i)) {
                i++;
            } else if (!diffFound) {
                diffFound = true;
                i++;
            } else {
                return false;
            }
        }
        return diffFound;
    }

    private static Map<String, List<String>> buildWordGraph(String[] words) {
        Map<String, List<String>> wordGraph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<String> neighboursOfI = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {
                if (j == i) continue;
                if (isNeighbour(words[i], words[j])) {
                    neighboursOfI.add(words[j]);
                }
            }
            wordGraph.put(words[i], neighboursOfI);
        }
        return wordGraph;
    }

    public static void main(String[] args) {
        System.out.println("shortest path: " + shortestWordEditPath("bit", "dog", new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"}));
        System.out.println("shortest path: " + shortestWordEditPath("no", "go", new String[]{"to"}));
    }
}
