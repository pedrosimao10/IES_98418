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
     
# ---- Exercício 1.3 ---------


