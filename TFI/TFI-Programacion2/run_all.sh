#!/usr/bin/env bash
set -euo pipefail
DB_HOST="${DB_HOST:-localhost}"
DB_PORT="${DB_PORT:-3306}"
DB_USER="${DB_USER:-root}"
DB_PASS="${DB_PASS:-TuContraseña}"
DB_NAME="${DB_NAME:-tfi_prog2}"



echo "[1/4] Creando base y tablas..."
mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" < 01_schema.sql

echo "[2/4] Insertando datos de prueba..."
mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" < 02_seed.sql

echo "[3/4] Compilando proyecto (Maven)..."
mvn -q -e -DskipTests clean package

echo "[4/4] Ejecutando AppMenu..."
mvn -q exec:java -Dexec.mainClass="edu.utn.p2.tfi.main.AppMenu" -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8
