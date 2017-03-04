package com.aqatools.jpom;

/**
 * Created by user on 04.03.17.
 */
public class Utils {

    public static boolean wait(Runner run, int timeout) {
        boolean result;
        long limit = System.currentTimeMillis() + timeout;
        do {
            result = run.exec();
            if (result)
                break;
        } while (System.currentTimeMillis() < limit);
        return result;
    }
}
