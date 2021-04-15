# StickyHeadersRecyclerview

#### 1.功能

1。用于RecyclerView添加头部Sticky悬浮效果
2。添加的头Sticky可以进行点击操作


#### 2.示例介绍
1. StickyHeadersRecyclerview演示


### 演示下载
[*Sample Apk*](/apk/app-debug.apk)

### 三、StickyHeadersRecyclerview使用

#### 1.添加依赖

①.在项目的 build.gradle 文件中添加
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
②.在build.gradle 文件中添加依赖
```
dependencies {
	 compile 'com.github.mr-woody.StickyHeadersRecyclerview:library:1.0.0'
}
```


#### 2.使用示例
**布局**

RecyclerView 的父布局，暂时只支持FrameLayout和CoordinatorLayout

```
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_marginTop="50dp">

<android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:clipToPadding="false"
        android:padding="10dp" />
</FrameLayout>
```
**代码设置数据**


adapter必须实现StickyCallback接口

```
interface StickyCallback<T> {

    fun getGroupingStrategy(): GroupingStrategy<T>

    fun getItems(): List<T>
}

```


其中提供了分组策略工具类GroupingStrategy，如下提供两种策略使用如下：

```
//数据区分是否属于分组view，是由item对应data数据决定，可以使用如下策略
strategy = GroupingStrategy.of(this).reduce { it->it.title.contains("Header")}
 
//或者

//数据区分是否属于分组view,是由上下两条数据进行对比来决定，可以使用如下策略，例如（联系人姓名按照A、B、C等字母分组）
strategy = GroupingStrategy.of(this).reduce(BinaryCondition<String> { t1, t2 -> t1[0] != t2[0] })
   
```



1. 常规使用使用

```
//简单用法StickyLayoutManager其实继承LinearLayoutManager

val layoutManager = StickyLayoutManager(this, adapter)
//设置recyclerView的适配器adapter
recycler_view.adapter = adapter


```

2.设置悬浮置顶效果加卡片阴影效果

```
val layoutManager = StickyLayoutManager(this, adapter)
layoutManager.elevateHeaders(ture) // Default elevation of 5dp
// You can also specify a specific dp for elevation
layoutManager.elevateHeaders(10)
//设置recyclerView的适配器adapter
recycler_view.layoutManager = layoutManager

```

3.需要单独为悬浮置顶的view添加特殊处理，比如修改布局样式（字体大小，颜色，修改里面子View的样式或者添加子view），添加点击效果

注意：不能修改悬浮置顶的view的大小

```
layoutManager.setStickyHeaderListener(object : StickyHeaderListener {
    override fun headerAttached(headerView: View, adapterPosition: Int) {
        Log.d("Listener", "Attached with position: $adapterPosition")
        
    }

    override fun headerDetached(headerView: View, adapterPosition: Int) {
        Log.d("Listener", "Detached with position: $adapterPosition")
    }
})

```




#### 3.注意事项

> RecyclerView 的父布局，暂时只支持FrameLayout和CoordinatorLayout：


#### 4.基于第三方库进行修改

第三方库地址：https://github.com/bgogetap/StickyHeaders



#### 5.后期规划

1. 自动给RecyclerView添加父布局FrameLayout,不需要手动处理


### 其他文档
* [ChangeLog](/document/CHANGE_LOG.MD)

