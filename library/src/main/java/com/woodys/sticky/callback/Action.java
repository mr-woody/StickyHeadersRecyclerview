package com.woodys.sticky.callback;

/**
 * Created by Administrator on 2017/5/20.
 */

public interface Action<R,T> {
    R call(T t);
}
