package ru.jenia.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task number : list) {
            numbers.add(number.getNumber());
        }
        return numbers;
    }
}
