# AutoDispose

<p>
<a href="https://jitpack.io/#liangjingkanji/AutoDispose"><img src="https://jitpack.io/v/liangjingkanji/AutoDispose.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<img src="https://raw.githubusercontent.com/liangjingkanji/liangjingkanji/master/img/group.svg"/>
</p>

自动解绑RxJava订阅
<br>

- 支持Activity/Fragment/ViewModel自动解绑
- 仅使用一个函数完成自动解绑, 市面上最简单

<br>

## 安装

添加远程仓库根据创建项目的 Android Studio 版本有所不同

Android Studio Arctic Fox以下创建的项目 在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

Android Studio Arctic Fox以上创建的项目 在项目根目录的 settings.gradle 添加仓库

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

然后在 module 的 build.gradle 添加依赖框架

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
