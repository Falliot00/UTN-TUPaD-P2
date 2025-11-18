@echo off
setlocal
if "%DB_HOST%"=="" set DB_HOST=localhost
if "%DB_PORT%"=="" set DB_PORT=3306
if "%DB_USER%"=="" set DB_USER=root
if "%DB_PASS%"=="" set "DB_PASS=TuContraseña"
if "%DB_NAME%"=="" set DB_NAME=tfi_prog2

echo [1/4] Creando base y tablas...
mysql -h "%DB_HOST%" -P "%DB_PORT%" -u "%DB_USER%" -p"%DB_PASS%" < 01_schema.sql || goto :err

echo [2/4] Insertando datos de prueba...
mysql -h "%DB_HOST%" -P "%DB_PORT%" -u "%DB_USER%" -p"%DB_PASS%" < 02_seed.sql || goto :err

echo [3/4] Compilando proyecto (Maven)...
call mvn -q -DskipTests clean package
if errorlevel 1 goto :err

echo [4/4] Ejecutando AppMenu...
call mvn -q exec:java -Dexec.mainClass="edu.utn.p2.tfi.main.AppMenu"
if errorlevel 1 goto :err

goto :eof
:err
echo Ocurrio un error. Revise las credenciales y requisitos.
exit /b 1
