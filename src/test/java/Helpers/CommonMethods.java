package Helpers;

import Config.BaseClass;

public class CommonMethods extends BaseClass {
    public static void wait(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}