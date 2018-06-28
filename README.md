神策分析数据接入封装Client公共jar包
使用说明：

1、导入maven依赖
<pre>
    <code>
    	&lt;dependency>
    		&lt;groupId&gt;com.xiaoniuapp.dataanalysis&lt;/groupId&gt;
    		&lt;artifactId&gt;sensorsdata-client&lt;/artifactId&gt;
    		&lt;version&gt;1.0-SNAPSHOT&lt;/version&gt;
    	&lt;/dependency&gt;
	</code>
</pre>
2、	Spring Context配置文件 引入相关配置

    添加引用：
    	<import resource="classpath:/sensorsdataClientConfig/sensorsdata-client-context.xml" />
    新增配置文件
    	application_sensorsdata.properties