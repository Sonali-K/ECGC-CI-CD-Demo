#cd bin
chmod +x ./bin/logstash 
cp ./bin/logstash.conf /usr/share/logstash/logstash.conf
./bin/logstash -f logstash.conf
