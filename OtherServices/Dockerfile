FROM openjdk:8

WORKDIR /IJlogic/bin

ENV PORT 6000
ENV TZ America/Bogota

COPY /target/classes /IJlogic/bin/classes
COPY /target/dependency /IJlogic/bin/dependency
RUN mkdir keystores
COPY keystores/* /IJlogic/bin/keystores/

CMD ["java","-cp","./classes:./dependency/*","edu.eci.arep.sparkwebapp.SecureSparkServices"]