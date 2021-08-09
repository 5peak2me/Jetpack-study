# Jetpack系列之StartUp

`tools:node="remove"`

- 加在`provider`根节点上，则xml配置全部不生效，可通过`AppInitializer.getInstance(this).initializeComponent(XX)`去延迟初始化
- 加载`meta-data`节点上，则移除对应的初始化器

```xml
<provider
    android:name="androidx.startup.InitializationProvider"
    android:authorities="${applicationId}.androidx-startup"
    android:exported="false"
    tools:node="remove">

    <meta-data
        android:name="${applicationId}.Sdk2Initializer"
        android:value="androidx.startup" />
  
    <meta-data
        android:name="${applicationId}.Sdk1Initializer"
        android:value="androidx.startup" />
  
    <meta-data
        android:name="${applicationId}.Sdk3Initializer"
        android:value="androidx.startup" />
  
</provider>
```

![StartUp](StartUp.png)
