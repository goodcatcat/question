package org.example;

import org.junit.Test;

import static org.example.Main.removeAndPrint;
import static org.example.Main.replaceAndPrint;


public class MainTest {

    @Test
    public void testRemoveAndPrint() {
        removeAndPrint("aabbbccccdddeaabbcd");
    }

    @Test
    public void testReplaceAndPrint() {
        replaceAndPrint("aabbbccccdddeaabb");
    }
}