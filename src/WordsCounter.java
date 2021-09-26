import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import org.jsoup.nodes.Document;


public class WordsCounter {
    public void readFile() {
        try {
            File myFile = new File("C://Users/Acer/Downloads", "file3.html");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            Map<String, Integer> wordsCounter = new HashMap<>();
            List<String> wordsList = new ArrayList<>();
            String[] wordsArray;
            while ((line = reader.readLine()) != null) {
                Document doc = Jsoup.parse(line);
                String lineWithoutTags = doc.body().text();
                    wordsArray = lineWithoutTags.split("\\s*(\\s|!|\\?|-|—|«|»|:|;|/|\\(|\\)|\\[|\\]|\\.|\t|\r|\n)\\s*");
                for (int i = 0; i < wordsArray.length; i++) {
                    wordsList.add(wordsArray[i].trim());
                }
            }
            reader.close();
            wordsList.removeIf(word -> word.equals(""));
            for (String word : wordsList) {
                if (!wordsCounter.containsKey(word)) {
                    wordsCounter.put(word, 1);
                } else {
                    wordsCounter.put(word, wordsCounter.get(word) + 1);
                }
            }
            Map<String, Integer> orderedMap = wordsCounter.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(LinkedHashMap::new,
                            (m, c) -> m.put(c.getKey(), c.getValue()),
                            LinkedHashMap::putAll);
            for (Map.Entry entry : orderedMap.entrySet()) {
                System.out.println(entry.getKey() + " — "
                        + entry.getValue());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
