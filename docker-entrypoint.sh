#!/usr/bin/env bash
set -Eeo pipefail

JAVA_OPTS="${JAVA_OPTS:--Dlog4j2.formatMsgNoLookups=true -Djava.net.preferIPv4Stack=true -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XshowSettings:vm -Dcom.sun.net.ssl.checkRevocation=false -Djava.security.egd=file:/dev/./urandom}"

if [[ "$1" = 'app' ]]; then
    exec java ${JAVA_OPTS} -jar "${APP_HOME}/app.jar"
else
    exec "$@"
fi
