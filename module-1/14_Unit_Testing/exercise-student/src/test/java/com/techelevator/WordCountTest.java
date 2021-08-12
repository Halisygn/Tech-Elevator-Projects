package com.techelevator;

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.is;

import java.util.Map;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.Assert.assertThat;

public class WordCountTest extends TestCase {

    public void testGetCount() {
        WordCount wordCount=new WordCount();

        Map<String, Integer> myMap = wordCount.getCount(new String[] { "ba", "ba", "black", "sheep" });
        assertThat( myMap.size(), is(3));
        assertThat(myMap, hasEntry("ba", 2));
        assertThat(myMap, hasEntry("black", 1));
        assertThat(myMap, hasEntry("sheep", 1));

        myMap = wordCount.getCount(new String[] { "a", "b", "a", "c", "b" });
        assertThat(myMap.size(), is(3));
        assertThat(myMap, hasEntry("a", 2));
        assertThat(myMap, hasEntry("b", 2));
        assertThat(myMap, hasEntry("c", 1));

        myMap = wordCount.getCount(new String[]{});
        assertThat(myMap.size(), is(0));

        myMap = wordCount.getCount(new String[] {"c","b","a"});
        assertThat(myMap.size(), is(3));
        assertThat(myMap, hasEntry("a", 1));
        assertThat(myMap, hasEntry("b", 1));
        assertThat(myMap, hasEntry("c", 1));

        myMap = wordCount.getCount(new String[] {"c","b"});
        assertThat(myMap.size(), is(2));
        assertThat(myMap, hasEntry("b", 1));
        assertThat(myMap, hasEntry("c", 1));
    }
}
