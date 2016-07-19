package com.ford.acoe.tdd.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mikesmithson on 7/18/16.
 */
public class ListBackedSetTest {

    private ListBackedSet set;

    @Before
    public void setUp() {
        set = new ListBackedSet();
    }

    @Test
    public void set_exists() {
        assertThat(set).isNotNull();
    }


    @Test
    public void isEmpty_returns_true_when_no_elements_present() {
        assertThat(set.isEmpty()).isTrue();
    }

    @Test
    public void clear_removes_all_elements() {
        set.clear();
        assertThat(set.isEmpty()).isTrue();
        assertThat(set.size()).isEqualTo(0);
    }

    @Test
    public void add_element_returns_true_if_no_element_previously_inserted() {
        assertThat(set.add("Moe")).isTrue();
        assertThat(set.isEmpty()).isFalse();
        assertThat(set.size()).isEqualTo(1);

    }

    @Test
    public void add_null_element_returns_false() {
        assertThat(set.add(null)).isFalse();
        assertThat(set.isEmpty()).isTrue();
        assertThat(set.size()).isEqualTo(0);

    }

    @Test
    public void add_element_returns_false_if_element_previously_inserted() {
        assertThat(set.add("Moe")).isTrue();
        assertThat(set.add("Moe")).isFalse();
        assertThat(set.isEmpty()).isFalse();
        assertThat(set.size()).isEqualTo(1);

    }

    @Test
    public void contains_returns_true_if_element_is_present() {
        assertThat(set.add("Larry")).isTrue();
        assertThat(set.contains("Larry")).isTrue();
    }

    @Test
    public void contains_returns_false_if_element_is_present() {
        assertThat(set.add("Larry")).isTrue();
        assertThat(set.contains("Moe")).isFalse();
    }

    @Test
    public void removes_removes_element_when_present() {
        assertThat(set.add("Bob")).isTrue();
        assertThat(set.contains("Bob")).isTrue();
        assertThat(set.remove("Bob")).isTrue();
        assertThat(set.contains("Bob")).isFalse();
    }

    @Test
    public void removes_does_not_remove_element_when_not_present() {
        assertThat(set.add("Bob")).isTrue();
        assertThat(set.contains("Bob")).isTrue();
        assertThat(set.remove("Phil")).isFalse();
        assertThat(set.contains("Bob")).isTrue();
    }

    @Test
    public void to_array_returns_all_elements_in_set_of_the_correct_runtime_type() {
        List<String> expected = new ArrayList<>();
        expected.add("Moe");
        expected.add("Larry");
        expected.add("Curly");

        set.add("Moe");
        set.add("Larry");
        set.add("Curly");

        assertThat(set.toArray(new String[]{})).containsExactly(expected.toArray());
    }

    @Test
    public void to_array_returns_all_elements_in_set() {
        List<String> expected = new ArrayList<>();
        expected.add("Moe");
        expected.add("Larry");
        expected.add("Curly");

        set.add("Moe");
        set.add("Larry");
        set.add("Curly");

        assertThat(set.toArray()).containsExactly(expected.toArray());
    }

    @Test
    public void addAll_adds_all_non_duplicates() {
        List<String> listWithDuplicates = new ArrayList<>();
                listWithDuplicates.add("Moe");
                listWithDuplicates.add("Larry");
                listWithDuplicates.add("Curly");
                listWithDuplicates.add("Curly");

        List<String> expected = new ArrayList<>();
                expected.add("Moe");
                expected.add("Larry");
                expected.add("Curly");

        set.addAll(listWithDuplicates);

        assertThat(set.toArray(new String[]{})).containsOnlyElementsOf(expected);
    }

}
