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
    </dependency>
