package com.okay.sticky.callback;

/**
 * Created by Administrator on 2017/5/20.
 */

public interface Condition<T> {
    boolean apply(T t);
}
