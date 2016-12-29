###USE SPRING BOOT

# Installing the Spring

USE MANUAL INSTALL

download `spring-boot-cli-1.4.1.RELEASE-bin.zip`

unzip it 

Set SPRING_HOME to point to a specific installation:

```
vim .bash_profile

export SPRING_HOME="/Users/kaemiin/spring/spring-1.4.1.RELEASE"

export PATH=/usr/local:/usr/local/sbin:$SPRING_HOME/bin

source .bash_profile

spring --version
```

###RUN

```
gradle bootRun --debug
```

###TEST
```
gradle test -i --rerun-tasks
```

###PACKAGE
```
gradle build
```
產生的JAR檔案會在`./build/libs`下。

###DEPLOY

建立執行目錄：
```
cd /opt
mkdir myapp
mkdir myapp/log
mkdir myapp/log/gc
mkdir myapp/conf
sudo chown km:km -R myapp
```
將以下檔案拷貝至執行目錄中：

```
將./build/libs/myapp-1.0.jar 拷貝至 myapp中
sudo chown km:km myapp-1.0.jar
sudo chmod a+x myapp-1.0.jar

```

```
將start.sh與stop.sh 拷貝至 myapp 中

注意：請根據目前版本號來更新start.sh中version的變數設定。

sudo chown km:km start.sh
sudo chmod a+x start.sh
sudo chown km:km stop.sh
sudo chmod a+x stop.sh
```

```
將./build/libs下的/logback.xml、application.properties 拷貝至 myapp/conf中
sudo chown km:km myapp/conf/logback.xml
sudo chown km:km ./conf/application.properties
```

設定開機排程：

1. 將專案目錄下的pwdsetter拷貝至/etc/init.d中，並註冊成服務：
```
sudo chmod a+x springboot
sudo mv springboot /etc/init.d
chkconfig --add springboot
chkconfig --level 345 springboot on
```
2. 啟動服務：
```
service springboot start
```
相關的log檔案會產生在`./log`下。

