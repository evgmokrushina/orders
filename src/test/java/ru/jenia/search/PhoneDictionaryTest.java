package ru.jenia.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Evgeniya", "Mokrushina", "2460464", "Perm")
        );
        ArrayList<Person> persons = phones.find("Evgeniya");
        assertThat(persons.get(0).getSurname()).isEqualTo("Mokrushina");
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Marina", "Malysheva", "6361530", "Perm")
        );
        ArrayList<Person> persons = phones.find("895");
        assertThat(persons).isEmpty();
    }
}
