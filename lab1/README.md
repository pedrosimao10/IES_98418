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


.gitignore - Ficheiros/Pastas que não devem ser incluídas no repositório

d)
Fazer "git clone git@github.com:pedrosimao10/IES_98418.git" para a nova location

e)
- Ficou um pouco confuso mas fiz o pedido nesta alínea no seguinte diretório "IES\IES_98418\lab1\lab1_3\location2\IES_98418\lab1\lab1_2\MyWeatherRadar
- Criou-se a pasta resources para incluir o ficheiro "log4j2.xml"


# --- Exercício 1.4 ---------

b) 
  O que é um container? Um container é um processo em "sandbox" a executar na minha máquina, isolado de todos os outros procesos na máquina host.
  
  O que é uma container image? Ao executar um container, usa-se um sistema de ficheiros isolados. O sistema de ficheiros é providenciado por uma container image. Visto que a image contém o sistema de ficheiros do container, deve conter também tudo o que é necessário para excutar a aplicação (dependências, configuração, scripts,etc.) 

Comandos importantes do docker:
	-d : executa o container em segundo plano
	-p 80:80 : associa a porta 80 do host à porta 80 do container
	docker/getting-image : imagem a usar

  Dockerfile : Um script de instruções a usar para criar uma container image

c)
 Arquitetura Portainer: Portainer consistem em dois elementos: o Portainer Server e o Portainer Agent. Ambos são executados como containers leves num container já criado. O Portainer Agent deve ser enviado para todos os nós do cluster e configurado de forma a reportar para o container do Portainer Server.

 Volume a ser usado pelo Portainer Serber para guardar a sua base de dados : docker volume create portainer_data

 Download e instalação do container do Portainer Server: docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest

 Instalação do Portainer: 
latest: Pulling from portainer/portainer-ce
7721cab3d696: Pull complete
0645e7e2a110: Pull complete
6329543ecfce: Pull complete
Digest: sha256:76ff22486bcd3713631b5f317efcb69e707a122fe96ffcc0589cf2d3e8e6b890
Status: Downloaded newer image for portainer/portainer-ce:latest
1f7dacecc760818f9a67137d815dff6c9dbc18680e2eff6aff9b48337f74ca37

Site acedido : https://localhost:9443 ( NOTA: Não acedi ao :9000 como no guião visto que na instalação do Portainer defini a porta como sendo a 9443

d)
  
  Comando para obter a imagem Postgres mais recente: docker pull postgres



