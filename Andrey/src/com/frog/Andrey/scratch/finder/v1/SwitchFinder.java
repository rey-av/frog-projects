package com.frog.Andrey.scratch.finder.v1;

import com.frog.Andrey.scratch.finder.v1.inner.Switch;

import java.util.List;

/**
 * Given a number of booleans.
 * Each boolean switch switches in turn another random chosen booleans.
 * <p>
 * Find the most optimal way to switch all the booleans to false.
 */
public abstract class SwitchFinder {

    public static void find(List<Switch> switches) {
        int on = 0;
        int off = 0;
        for (Switch s : switches) {
            if (s.getState()) {
                on++;
            } else {
                off++;
            }
        }

        System.out.println(on);
        System.out.println(off);
    }

}
