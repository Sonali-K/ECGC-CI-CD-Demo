FROM docker.elastic.co/kibana/kibana:7.6.2
# copy the configuration file into the container
COPY kibana.yml /usr/share/kibana/config/kibana.yml
COPY a.sh /a.sh
# expose the default kibana port
EXPOSE 5601
cmd ["chmod","+x","a.sh"]
ENTRYPOINT ["sh", "/a.sh"]

