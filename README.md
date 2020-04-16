#项目中用到Aligenie提供的sdk：aliGenie-intent-sematic.jar
#导入本地jar包方式：项目中新建lib目录（有则免之），该目录与src目录平级，jar包放入lib目录中。
#Idea打开File-ProjectStructure-ProjectSetting-Libraries，新加项目库，选择java，指向lib目录下的jar包。

#项目中已有keytool生成的证书，用于SpringBoot的https启动。
#证书存放路径：resources/keystore.p12
#https启动方式：打开application.properties文件，加入以下代码:
      #https端口号
      server.port=443
      #证书的路径
      server.ssl.key-store=classpath:keystore.p12
      #证书密码，请修改为您自己证书的密码
      server.ssl.key-store-password=123456
      #秘钥库类型
      server.ssl.keyStoreType=PKCS12
      #证书别名
      server.ssl.keyAlias=tomcat
#保存，启动项目。
