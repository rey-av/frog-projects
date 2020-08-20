package com.frog.Andrey.scratch.finder.v1;

import static com.frog.Andrey.scratch.finder.v1.SwitchFinder.find;
import static com.frog.Andrey.scratch.finder.v1.inner.SwitchUtil.getSwitches;

public class SwitchController {

    public static void main(String[] args) {
        find(getSwitches());
    }

}
