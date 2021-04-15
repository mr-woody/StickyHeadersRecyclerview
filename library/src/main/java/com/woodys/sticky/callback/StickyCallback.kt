package com.woodys.sticky.callback

import com.woodys.sticky.strategy.GroupingStrategy

/**
 * Created by Administrator on 2017/5/20.
 */

interface StickyCallback<T> {

    fun getGroupingStrategy(): GroupingStrategy<T>

    fun getItems(): List<T>
}
