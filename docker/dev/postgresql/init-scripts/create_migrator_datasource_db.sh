#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "postgres" --dbname "postgres" <<-EOSQL
    CREATE USER root with encrypted password 'adminadmin';
    ALTER USER root WITH SUPERUSER CREATEROLE CREATEDB REPLICATION BYPASSRLS;
    GRANT USAGE ON SCHEMA public TO root;

    CREATE DATABASE new_project_name_db;
    GRANT ALL PRIVILEGES ON DATABASE new_project_name_db TO root;
EOSQL
