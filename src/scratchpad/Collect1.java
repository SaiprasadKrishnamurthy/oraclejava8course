package scratchpad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by sai on 05/08/2015.
 */
public class Collect1 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Orange", "Banana", "Peach", "Lime", "Pear", "Strawberry", "Blueberry", "Mango", "Jackfruit");
        System.out.println(words.stream().collect(groupingBy(String::length)));

    }
}
