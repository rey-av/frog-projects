package com.frog.Andrey.scratch.finder.v1.inner;

import com.frog.Andrey.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static com.frog.Andrey.utils.Utils.getRandomInt;

public abstract class SwitchUtil {
    
    private static final int DEFAULT_COUNT = 20;

    private static int count = DEFAULT_COUNT;


    public static void setCount(int count) {
        SwitchUtil.count = count;
    }


    public static List<Switch> getSwitches() {
        final int COUNT = SwitchUtil.count;

        List<Switch> list = createSwitches(COUNT);

        list.forEach(item -> {
            item.correspondence().add(list.get(getRandomInt(count)));
            item.correspondence().add(list.get(getRandomInt(count)));
        });

        return list;
    }


    private static List<Switch> createSwitches(int count) {
        List<Switch> list = new ArrayList<>(count);

        for (int key = 0; key < count; key++) {
            list.add(new Switch(Utils.getRandomBool(), new ArrayList<>()));
        }

        return list;
    }

}
