# Arcade Learning Environment Java API

Please compile [the Arcade Learning Environment C API](https://github.com/yukoba/Arcade-Learning-Environment-C-API) and copy `build/src/ale/libale.so` to the top folder.
The source code was generated using [JExtract](https://jdk.java.net/jextract/) and has been confirmed to work on Ubuntu 24.04.

```sh
sudo apt install maven openjdk-21-jdk

MAVEN_OPTS="--enable-preview" mvn package -DskipTests
MAVEN_OPTS="--enable-preview --enable-native-access=ALL-UNNAMED -Djava.library.path=." mvn exec:java -Dexec.mainClass=jp.yukoba.ale.Test -Dexec.args=pong.bin -Dexec.classpathScope=test
```
