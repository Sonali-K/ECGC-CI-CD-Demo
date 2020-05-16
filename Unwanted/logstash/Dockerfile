FROM docker.elastic.co/logstash/logstash:7.6.2
RUN rm -f bin/logstash.conf
COPY logs /home/Documents/logs
COPY logstash.conf bin/
COPY a.sh /a.sh
cmd ["chmod","+x","a.sh"]
ENTRYPOINT ["sh", "/a.sh"]
