# optionDemo-Android
## 目录
- [一、集成SDK](#一集成sdk)
- [二、快速使用SDK](#二快速使用sdk)
- [三、接口说明](#三接口说明)
- [四、常见问题](#四常见问题)
- [五、更新记录](#五更新记录)
- [六、功能截图](#六功能截图)




## 一、集成SDK


### 兼容性

| 类别     | 兼容范围                      |
| -------- | ----------------------------- |
| 兼容性     | android 4.0以上系统       |
| SDK版本     | 建议使用27       |
| 架构     | armv7、arm64、i386、x86_64    |
| 开发环境 | 建议使用最新版本Android studio进行开发 |


### 导入optionSDK到工程

#### 1.1 引入依赖包


添加仓库引用
```
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/fota/release' }
    }
}
```

添加依赖
```
dependencies {
    api('com.fota.android:option:0.1.0@aar') { transitive = true; }
}
```

#### 1.2 添加必要权限

在app/src/main/AndroidManifest.xml 中加入：

```java
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```


## 二、快速使用SDK


### 2.1 在Application中配置如下信息

```java
OptionManager.init("your brokerId", getOptionConfig(), this);

```


### 2.2 进入期权界面

```java
Intent intent = new Intent(getContext(), OptionActivity.class);
startActivity(intent);
```



## 三、接口说明

### 3.1 回调事件


```java
  //设置页面跳转的回调
config.setPageChangeListener(new OptionConfig.PageChangeListener() {
    @Override
    public void gotoDepositPage(Context context) {
        ...
    }

    @Override
    public void gotoLoginPage(Context context) {
        ...
    }

    @Override
    public void gotoAllOrderPage(Context context) {
        ...
    }
    });
    
```

### 3.2 设置语言 

```java
//   设置为中文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_SIMPLE_CHINESE);
//   设置为英文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_ENGLISH);
        
```


### 3.3 设置开发模式

```java


/**
* is development environment
* 是否是开发环境
*/
boolean isDevelopment;

/**
* set the socketHost ,only valid when development environment
* 配置socketHost 该配置只在开发模式下有效
*/
String socketHost;


/**
* set the httpHost ,only valid when development environment
* 配置httpHost 该配置只在开发模式下有效
*/
String httpHost;

        
```


### 3.4 设置登录token

```java
   
//登录成功后设置UserID和Token
OptionManager.setUserIdAndToken("your userId","your login token");

```




## 四、常见问题



### 如何拿到设置的Config
```java
OptionManager.getConfig()
```


## 五、更新记录
以下是SDK更新记录


## 六、功能截图

以下是SDK部分功能截图
