cd src
java -Djava.rmi.server.hostname=$(hostname -I | awk '{print $1}') mx.ipn.esimecu.rpc.ServidorRMI
