package com.okay.sticky.callback

import ccom.okay.sticky.strategy.GroupingStrategy

/**
 * Created by Administrator on 2017/5/20.
 */

interface StickyCallback<T> {

    fun getGroupingStrategy(): GroupingStrategy<T>

    fun getItems(): List<T>

    fun getItem(position: Int): T?
}
