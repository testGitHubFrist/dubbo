CATALINA_OPTS="-Xms1024m -Xmx6144m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Dspring.profiles.active=production -Xloggc:/data/logs/gc-`date +"%Y-%m-%d_%H%M%S"`.log -XX:MaxPermSize=1024M -Dcom.sun.management.jmxremote=true -Djava.rmi.server.hostname=192.168.1.107 -Dcom.sun.management.jmxremote.port=6666 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.managementote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"