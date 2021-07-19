# AutoDispose

自动根据LifeCycle生命周期解绑RxJava订阅, 仅使用一个函数完成自动解绑
<br>

## 安装

project of build.gradle

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```


module of build.gradle

```groovy
implementation 'com.github.liangjingkanji:autodispose:1.0'
```

## 使用

在ViewModel/Activity/Fragment/LifecycleOwner都可以直接使用

```kotlin
Observable.interval(1, TimeUnit.SECONDS).auto(this).subscribe {
    Log.d("日志", "接受到事件")
}
```


指定解绑生命周期

```kotlin
Observable.interval(1, TimeUnit.SECONDS).auto(this, Lifecycle.Event.ON_PAUSE).subscribe {
    Log.d("日志", "接受到事件")
}
```