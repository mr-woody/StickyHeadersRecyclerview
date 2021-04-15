package com.woodys.sampletamplate.item

import android.content.Context

/**
 * @author :Created by woodys
 * @date 2019-05-09 14:22
 * @email yuetao.315@qq.com
 * 演示对象
 */
class SampleItem(var id:Int?, var pid:Int=0, var clazz:Class<*>?, var title:String?, var desc:String?){
    internal var callback:((Context)->Any)?=null

    fun obj(callback:(Context)->Any){
        this.callback=callback
    }

    constructor():this(null,0,null,null,null)
}