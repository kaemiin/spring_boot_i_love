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
mkdir myapp/conf
sudo chown km:km myapp
sudo chown km:km myapp/log
sudo chown km:km myapp/conf
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
將./src/main/resources/logback.xml 拷貝至 myapp/conf中
sudo chown km:km myapp/conf/logback.xml
```

設定開機排程：啟動請呼叫`start.sh`，停止請呼叫`stop.sh`，相關的log檔案會產生在`./log`下。
