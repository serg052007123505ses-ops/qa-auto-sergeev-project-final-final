package com.sergeev.qa.utils;

import java.util.concurrent.TimeUnit;

/**
 * Утилита для работы с ожиданиями
 * Помогает избежать flaky тестов через явное ожидание
 */
public class WaitHelper {

    /**
     * Явное ожидание с повторными попытками
     * Борьба с flaky тестами через retry логику
     */
    public static void waitWithRetry(Runnable action, int maxAttempts, long delayMillis) {
        for (int i = 0; i < maxAttempts; i++) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                if (i == maxAttempts - 1) {
                    throw new RuntimeException("Action failed after " + maxAttempts + " attempts", e);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(delayMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * Стандартное ожидание
     */
    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Ожидание с условием
     */
    public static boolean waitForCondition(java.util.function.BooleanSupplier condition, long maxWaitTimeMs) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < maxWaitTimeMs) {
            if (condition.getAsBoolean()) {
                return true;
            }
            sleep(100);
        }
        return false;
    }
}