# IES_98418

# ---- Exercício 1.2 --------

grupoID - Identifica unicamente o projeto
artifactID - Nome do "jar" sem a versão
archetype:generate - cria um projeto Maven com base numa arquitetura rápida e simples
package - é uma fase do ciclo de vida do build. Quando uma fase é declarada, o Maven executa executa cada fase da sequência

 Como criar um projeto Maven - mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

 Como adicionar informações adicionais ao ficheiro "pom" -
  <developers>
        <developer>
            <id>pedro</id>
            <name>Pedro Jorge</name>
            <email>pedro.simao10@ua.pt</email>
            <organization>Universidade de Aveiro</organization>
            <organizationUrl>http://www.ua.pt</organizationUrl>
            <roles>
                <role>student</role>
            </roles>
            <timezone>0</timezone>
        </developer>
    </developers>

Declarar independências no "pom" - 
<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>retrofit</artifactId>
    <version>2.7.0</version>
</dependency>

<dependency>  
      <groupId>com.squareup.retrofit2</groupId>
      <artifactId>converter-gson</artifactId>
      <version>2.7.0</version>
<<<<<<< HEAD
    </dependency>
=======
      

Após compilar ($ mvn package) e executar ($ mvn exec:java -Dexec.mainClass="com.mycompany.weather.WeatherStarter") o código fornecido a propósito do exercício "MyWeatherRadar"
o resultado obtido foi o seguinte:

[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< com.mycompany.weather:MyWeatherRadar >----------------
[INFO] Building MyWeatherRadar 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ MyWeatherRadar ---
out 12, 2021 8:17:47 DA TARDE com.mycompany.weather.WeatherStarter main
INFO: max temp for today: 27.0
     
Utilizou-se StringBuilder de forma a ser possível pesquisar a cidade pelo city code.
Obteu-se o seguinte resultado:

[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< com.mycompany.weather:MyWeatherRadar >----------------
[INFO] Building MyWeatherRadar 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ MyWeatherRadar ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by retrofit2.Platform (file:/C:/Users/pedro/.m2/repository/com/squareup/retrofit2/retrofit/2.9.0/retrofit-2.9.0.jar) to constructor java.lang.invoke.MethodHandles$Lookup(java.lang.Class,int)
WARNING: Please consider reporting this to the maintainers of retrofit2.Platform
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
out 18, 2021 6:55:14 DA TARDE com.mycompany.weather.WeatherStarter main
INFO: max temp for today: 24.4
min temp for today: 16.8

Comando para correr o programa no maven com argumentos: mvn exec:java -Dexec.mainClass="what to put here?" -Dexec.args="arg0 arg1 arg2"~

# ---- Exercício 1.3 ---------

<<<<<<< HEAD
.gitignore - Ficheiros/Pastas que não devem ser incluídas no repositório
=======
>>>>>>> 7a1a885ac5dcf731fd953db9b544f01c3a8f2eb1

