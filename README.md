# CasaLubetkin

This proyect uses the library AnimatonClass of https://sellfy.com/writecode

## How to install library

1- Copies the file that is in src\main\resources called AnimatonClass.jar in C:\
2- In /CasaLubetkin/ run the command: mvn install:install-file -Dfile=C:\AnimatonClass.jar -DgroupId=writecode -DartifactId=writecode -Dversion=1 -Dpackaging=jar
3- Now modifies the pom.xml:
```xml
    <dependency>
        <groupId>writecode</groupId>
        <artifactId>writecode</artifactId>
        <version>1</version>
    </dependency>
```
