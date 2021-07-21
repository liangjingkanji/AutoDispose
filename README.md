# AutoDispose

<p>
<a href="https://jitpack.io/#liangjingkanji/AutoDispose"><img src="https://jitpack.io/v/liangjingkanji/AutoDispose.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>

自动解绑RxJava订阅
<br>

- 支持Activity/Fragment/ViewModel自动解绑
- 仅使用一个函数完成自动解绑, 市面上最简单

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
implementation 'com.github.liangjingkanji:autodispose:1.2.0'
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