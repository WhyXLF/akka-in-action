package com.example.l02.provider;

import java.io.Serializable;

/**
 * author: xiaoliufu
 * date:   2017/9/16.
 * description:
 */
public class GetRequest implements Serializable{
    private static final long serialVersionUID = -844748017162394027L;
    public final String key;

    public GetRequest(String key) {
        this.key = key;
    }
}
