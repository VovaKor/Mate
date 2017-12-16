package com.korobko.util;

import java.util.UUID;

/**
 * @author Vova Korobko
 */
public class BaseUtil {
    public static String getUserToken() {
        return UUID.randomUUID().toString();
    }
}
