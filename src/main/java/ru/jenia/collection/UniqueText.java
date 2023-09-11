package ru.jenia.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String duplicate : text) {
            if (!(check.contains(duplicate))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
