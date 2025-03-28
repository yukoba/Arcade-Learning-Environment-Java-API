# Arcade Learning Environment Java API

The source code was generated using [JExtract](https://jdk.java.net/jextract/) and has been confirmed to work on Ubuntu 24.04 and MSYS2.

## Ubuntu 24.04

Please compile [the Arcade Learning Environment C API](https://github.com/yukoba/Arcade-Learning-Environment-C-API) and copy `build/src/ale/libale.so` to the top folder.

```sh
sudo apt install maven openjdk-21-jdk

MAVEN_OPTS="--enable-preview" mvn package -DskipTests
MAVEN_OPTS="--enable-preview --enable-native-access=ALL-UNNAMED -Djava.library.path=." mvn exec:java -Dexec.mainClass=jp.yukoba.ale.Test -Dexec.args=pong.bin -Dexec.classpathScope=test
```

## MSYS2 MINGW64 (Windows)

Please compile [the Arcade Learning Environment C API](https://github.com/yukoba/Arcade-Learning-Environment-C-API) and copy `build/src/ale/libale.dll` to the top folder.

Install Apache Maven and Java SE Development Kit 21.

```bat
set "JAVA_HOME=C:\Program Files\Java\Jdk-21"
set "PATH=C:\msys64\mingw64\bin;C:\Program Files\Java\apache-maven-3.9.9\bin;%PATH%"
set "MAVEN_OPTS=--enable-preview --enable-native-access=ALL-UNNAMED -Djava.library.path=."

rename libale.dll ale.dll

mvn package -DskipTests
mvn exec:java -Dexec.mainClass=jp.yukoba.ale.Test -Dexec.args=pong.bin -Dexec.classpathScope=test
```
