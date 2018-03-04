# javainstruct
java指令集学习 

该功能主要是为了想阅读java字节码的新手提供方便（方便查看指令简要提示），将javap -verbose 输出加入了java指令集提示后输出成一个HTML文件 

功能缺陷：功能是基于java7的,目前不支持包含invokedynamic指令的class文件解析

使用见com.xwd.study.javainstruct.test.WatchJavaP

结果样例 sampleResult/com.xwd.study.javainstruct.test.Test.HTML

