package com.okay.sampletamplate.sample

import android.app.Application
import com.okay.sampletamplate.configurtion.Document
import com.okay.sampletamplate.configurtion.TemplateConfiguration
import com.okay.sampletamplate.sample.activity.*

/**
 * @author Created by cz
 * @date 2019-05-09 14:45
 * @email chenzhen@okay.cn
 * 演示程序入口
 */
@Document("readme.md")
class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //初始化演示模板
        initTemplate()
    }

    /**
     * 初始化演示模板
     */
    private fun initTemplate() {
        TemplateConfiguration.init(this) {
            item {
                id = 1
                title = "StickyHeadersRecyclerview演示"
                desc = "配器Adapter进行数据操作"
                clazz = Sample1Activity::class.java
            }
        }
    }
}