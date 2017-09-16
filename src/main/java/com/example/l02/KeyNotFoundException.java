package com.example.l02;

import java.io.Serializable;

/**
 * author: xiaoliufu
 * date:   2017/9/16.
 * description:
 */
public class KeyNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = -4801647524757429821L;

    public final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }
}
