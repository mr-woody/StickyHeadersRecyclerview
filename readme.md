# StickyHeadersRecyclerview

#### 1.功能

1。用于RecyclerView添加头部Sticky悬浮效果
2。添加的头Sticky可以进行点击操作


#### 2.示例介绍
1. StickyHeadersRecyclerview演示


### 演示下载
[*Sample Apk*](http://git.okjiaoyu.cn/stu/stickyheadersrecyclerview/raw/master/apk/app-debug.apk)

### 三、AutoFlowLayout使用

#### 1.添加依赖

①.在项目的 build.gradle 文件中添加
```
allprojects {
		repositories {
			...
			maven { url 'http://10.60.0.100:8081/repository/okayclient_snapshot/' }
		}
	}
```
②.在build.gradle 文件中添加依赖
```
dependencies {
	 compile 'com.okay.sticky:sticky-headers-recyclerview:1.1.0-SNAPSHOT'
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
```

val layoutManager = SimpleStickyLayoutManager(this, adapter)
layoutManager.elevateHeaders(false) // Default elevation of 5dp
// You can also specify a specific dp for elevation
layoutManager.elevateHeaders(0)
recycler_view.layoutManager = layoutManager
recycler_view.adapter = adapter
layoutManager.setStickyHeaderListener(object : StickyHeaderListener {
    override fun headerAttached(headerView: View, adapterPosition: Int) {
        Log.d("Listener", "Attached with position: $adapterPosition")
        
    }

    override fun headerDetached(headerView: View, adapterPosition: Int) {
        Log.d("Listener", "Detached with position: $adapterPosition")
    }
})

```

其中adapter必须实现StickyCallback接口

```
interface StickyCallback<T> {

    fun getGroupingStrategy(): GroupingStrategy<T>

    fun getItems(): List<T>

    fun getItem(position: Int): T?
}

```


其中GroupingStrategy使用如下：

```
 strategy = GroupingStrategy.of(this).reduce { it->it.title.contains("Header")}
 
 或者
 
 strategy = GroupingStrategy.of(this).reduce(BinaryCondition<String> { t1, t2 -> t1[0] != t2[0] })
   
```


#### 3.注意事项

> RecyclerView 的父布局，暂时只支持FrameLayout和CoordinatorLayout：


#### 4.基于第三方库进行修改

第三方库地址：https://github.com/bgogetap/StickyHeaders



#### 5.后期规划

1. 自动给RecyclerView添加父布局FrameLayout,不需要手动处理


### 其他文档
* [ChangeLog](http://git.okjiaoyu.cn/stu/stickyheadersrecyclerview/blob/master/document/CHANGE_LOG.MD)



![](http://git.okjiaoyu.cn/stu/stickyheadersrecyclerview/raw/master/image/author.png)