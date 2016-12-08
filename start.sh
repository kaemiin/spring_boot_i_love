#!/bin/bash

version="1.0"

echo "Start Spring Boot"

nohup java -Xms48m -Xmx48m -XX:MetaspaceSize=34m -XX:MaxMetaspaceSize=512m  -XX:+HeapDumpOnOutOfMemoryError -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=8 -verbose:gc -Xloggc:./log/gc/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=10M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime -Dlogging.config=./conf/logback.xml -jar myapp-$version.jar &>./log/nohup.out & echo $! > ./RUNNING_PID
