FROM postgres
ENV POSTGRES_USER mydb
ENV POSTGRES_PASSWORD mydb
ADD init.sql /docker-entrypoint-initdb.d
EXPOSE 5432
