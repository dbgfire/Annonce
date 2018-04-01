set HSQLDB_LIB=hsqldb.jar

"C:\Program Files\Java\jdk-9.0.4\bin\java.exe" -classpath %HSQLDB_LIB% org.hsqldb.Server -database.0 file:projet1 -port 9003

pause