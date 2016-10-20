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


