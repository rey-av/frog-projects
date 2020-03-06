package com.frog.nika.sort;

import com.frog.nika.abstractClass.AbstractSort;
import com.frog.nika.sort.sortClass.SortBubbles;
import com.frog.nika.sort.sortClass.SortInsertion;
import com.frog.nika.sort.sortClass.SortSelection;

import static com.frog.nika.sort.EnumSort.*;

public class SorterFactory {
    public AbstractSort SelectSort(sortType type) {
        switch (type) {
            case BUBBLE:
                return new SortBubbles();
            case INSERTION:
                return new SortInsertion();
            case SELECTION:
                return new SortSelection();
        }
        return null;
    }
}
