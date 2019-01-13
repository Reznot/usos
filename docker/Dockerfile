FROM jboss/wildfly:14.0.0.Final
USER root
RUN chown -R jboss:0 ${JBOSS_HOME}
RUN chmod -R g+rw ${JBOSS_HOME}
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/*
COPY postgresql /opt/jboss/wildfly/modules/system/layers/base/com/postgresql
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug"]
