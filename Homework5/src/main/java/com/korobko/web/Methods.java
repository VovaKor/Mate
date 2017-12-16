package com.korobko.web;

/**
 * @author Vova Korobko
 */
public enum Methods {
    GET {
        @Override
        public String toString() {
            return "GET";
        }
    },
    POST {
        @Override
        public String toString() {
            return "POST";
        }
    }
}
