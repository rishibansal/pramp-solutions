import java.io.*;
import java.util.*;

public class WordCountEngine {
	
	public static void main(String[] args) {
		String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
    	for (String[] entry : wordCountEngine(document)) {
      		System.out.println(Arrays.toString(entry));
    	}
	}

	private static String[][] wordCountEngine(String document) {
        Map<String, ThreeTuple> dict = new HashMap<>();
        String[] words = document.split("\\s");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            word = sanitizeWord(word);
            if (word.isEmpty()) {
                continue;
            }
            ThreeTuple tup = dict.getOrDefault(word, new ThreeTuple(word, i, 0));
            tup.incrementCount();
            dict.put(word, tup);
        }
        List<ThreeTuple> tupList = new ArrayList<>(dict.values());
        Collections.sort(tupList);
        String[][] outputArr = new String[tupList.size()][];
        for (int i = 0; i < tupList.size(); i++) {
            ThreeTuple tup = tupList.get(i);
            outputArr[i] = new String[]{tup.word, String.valueOf(tup.count)};
        }
        return outputArr;
    }

    private static String sanitizeWord(String orig) {
        orig = orig.toLowerCase();
        char[] cArr = new char[orig.length()];
        int j = 0;
        for (int i = 0; i < orig.length(); i++) {
            char c = orig.charAt(i);
            if (c >= 'a' && c <= 'z') {
                cArr[j++] = c;
            }
        }
        return String.valueOf(Arrays.copyOfRange(cArr, 0, j));
    }

    private static class ThreeTuple implements Comparable<ThreeTuple> {
        private String word;
        private int firstSeenIdx;
        private int count;

        private ThreeTuple(String word, int firstSeenIdx, int count) {
            this.word = word;
            this.firstSeenIdx = firstSeenIdx;
            this.count = count;
        }

        private void incrementCount() {
            this.count++;
        }

        public int compareTo(ThreeTuple other) {
            if (this.count == other.count) {
                return this.firstSeenIdx - other.firstSeenIdx;
            }
            return other.count - this.count;
        }
    }
}