# IES_98418
# Lab 2  - Java at ther server-side and the role of application containers

# ------ Exercício 2.1 ---------

Docker Containers são usados para providenciar tempos de execução virtualizados para qualquer tipo de serviços;
Os Servlet Containers são usados para providenciar um tempo de execução para executar código Java "web-related" e "server-sided", ou seja, não há virtualização.
As funções do Servlet Container podem ser divididas em 6 objetivos:

- Servidor Web recebe pedido HTTP;
- Servidor Web encaminha o pedido para um servlet container;
- O servlet é recuperado dinamicamente e carregado no espaço de endereço do container, se não estiver no container;
- O container invoca o método init() do servlet para inicialização;
- O container invoca o método service() do servlet para processar a solicitação HTTP, ou seja, ler os dados na solicitação e formular uma resposta. O servlet permanece no espaço de endereço do container e pode processar outras solicitações HTTP.
- O servidor Web retorna os resultados gerados dinamicamente para o local correto.

Folder do Apache-Tomcat: home/apache-tomcat-9.0.54

User: admin
Password: admin

Superclasse do código fonte do Servlet : HttpServlet

Criar Web Application baseado em Maven: mvn archetype:generate -DgroupId=org.codehaus.mojo.archetypes -DartifactId=webapp-javaee7 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1 -DinteractiveMode=false

h) Obter data de URL: String user = request.getParameter("username");

i) Para implementar um runtime error (NullPointerException):
if(user == null){
            throw new NullPointerException("Username not found!");
        }

Caso o user não exista o error é triggered e é imprimida uma mensagem a dizer que o utilizador não foi encontrado

# ---- Exercício 2.2 --------

O Jetty pode ser executado no modo "embedded". Isto significa que não é necessário construir um ficheiro WAR e lançá-lo no servidor Jetty "solitário". 

# ---- Exercício 2.3 --------
NOTA: Caso volte a ter problemas com o wrapper do Maven fazer: mvn -N io.takari:maven:0.7.7:wrapper

a)---------------------------------------------------------------------------

Foi gerado o ficheiro DemoApplication.java
Para correr : ./mvnw spring-boot:run
O servidor vai correr no localhost na porta 8080

Resultado de aceder a http://localhost:8080/ após corer o Spring Boot:

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.
Fri Oct 29 21:58:40 WEST 2021
There was an unexpected error (type=Not Found, status=404).

b)--------------------------------------------------------------------------------

A alínea b) foi resolvida na mesma pasta que a alínea a), de modo a aproveitar o projeto maven criado na alínea anterior.
Com isto, todas as dependências necessárias para a realização da alínea b) foram adicionadas ao ficheiro "pom.xml". (Spring Web, Thymeleaf e Spring Boot DevTools).

@Controller - Responsável por lidar com os pedidos HTTP.
View - Responsável por renderizar o conteúdo do HTML.
@GetMapping - Certifica-se que os pedidos HTTP GET são direcionados para o método greeting().
@RequestParam - vincula o valor do nome do parâmetro da string de consulta ao parâmetro name do método greeting ().
Thymeleaf - Analisa o modelo greeting.html e avalia a expressão th:text para renderizar o valor do parâmetro ${name} que foi definido no controlador.

- Adicionar greeting.html à pasta lab2_3/src/main/resources/templates!

Spring Boot Devtools:

     - Alterna os mecanismos de modelo para desativar o cache.

     - Habilita LiveReload para atualizar automaticamente o navegador.

     - Outros padrões razoáveis com base no desenvolvimento em vez da produção. 
     
@SpringBootApplication é uma anotação de conveniência que adiciona o seguinte:

     - @Configuration: marca a classe como uma fonte de definições de bean para o contexto da aplicação.

     @EnableAutoConfiguration: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath, outros beans e várias configurações de propriedade. Por exemplo, se spring-webmvc estiver no caminho da classe, esta anotação sinaliza a aplicação como uma aplicação web e ativa comportamentos-chave, por exemplo,  como configurar um DispatcherServlet.

     @ComponentScan: Diz ao Spring para procurar outros componentes, configurações e serviços no pacote com/example, permitindo que ele encontre os controladores.
     
O método main () usa o método SpringApplication.run () do Spring Boot para iniciar uma aplicação.

Mudou-se a porta a usar de modo a não entrar em conflito com a porta usada na alínea anterior. Para tal, editou-se o ficheiro application.properties (src/main/resources):
server.port = 9000

A aplicação web que estamos a contruir é 100% Java, não requer nenhum ficheiro do tipo .xml

Após correr a aplicação com ./mvnw spring-boot:run (ou correndo o programa principal em qualquer IDE), acedeu-se ao site: http://localhost:9000/greeting onde foi apresentada uma página em branco e com a mensagem "Hello, World!"

Caso se adicione um parâmetro "name" ao site (http://localhost:9000/greeting?name=User) a mensagem "Hello,World!" muda para "Hello,User!". Isto comprova que o @RequestParam está a funcionar corretamente.

Por fim, foi adicionada o ficheiro index.html (src/main/resources/static) que, quando o programa principal é corrido e acede-se ao site http://localhost:9000, aparece a mensagem "Get your greeting here", e ao clicar no "here" aparece novamente a mensagem "Hello, World!" ou "Hello, <parâmetro nome>!"

c)----------------------------------------------------------------------------------

Criou-se o ficheiro "Greeting.java" de modo a modelar a representação da apresentação (greeting).

Criou-se o ficheiro "RestGreetingController.java", parecido ao controlador da alínea anterior com a diferença do @RestController

@RestController - Marca a classe como um controlador onde cada método retorna um objeto de domínio em vez de uma visualização. É uma forma abreviada de incluir @Controller e @ResponseBody. 

De modo a realizar a alínea comentei a parte referente à alínea anterior do ficheiro "GreetingController.java" e escrevi o código referente a esta alínea.
Após executar o comando "curl -v http://localhost:9000/greeting", o resultado obtido foi o seguinte:

*   Trying 127.0.0.1:9000...
* Connected to localhost (127.0.0.1) port 9000 (#0)
> GET /greeting HTTP/1.1
> Host: localhost:9000
> User-Agent: curl/7.79.1
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 30 Oct 2021 21:32:36 GMT
< 
* Connection #0 to host localhost left intact
{"id":1,"content":"Hello, World!"}

Executando o comando "curl -v http://localhost:9000/greeting?name=Pedro", o resultado obtido foi o seguinte:

*   Trying 127.0.0.1:9000...
* Connected to localhost (127.0.0.1) port 9000 (#0)
> GET /greeting?name=Pedro HTTP/1.1
> Host: localhost:9000
> User-Agent: curl/7.79.1
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 30 Oct 2021 21:38:53 GMT
< 
* Connection #0 to host localhost left intact
{"id":2,"content":"Hello, Pedro!"}            Em vez de "World" aparece o nome que passei no parâmetro "name"

# ---- Exercício 2.4 --------

Neste exercício a minha abordagem foi tentar resolver de maneira semelhante à alínea anterior.

/* Primeira resolução que tentei fazer
Para isso, criei primeiro o ficheiro "shows.json", que é composto por um array que contém o id, nome, código e quote de séries famosas.
De seguida criei a classe representativa "Quotes.java" que recebe como argumentos o id,nome, código e quote, assim como os seus contrutores e métodos get.
Depois criei um controlador, "QuotesController.java" de forma a lidar com os GET requests de acordo com o url especificado:
	- /api/quotes - retorna uma quote aleatória de uma série aleatória
	- api/quotes?show=<show_id> - retorna uma quote aleatória de uma série específica
	- api/shows - lista de todas as séries que existem
De forma a ler o conteúdo do ficheiro JSON utilizei o Jackson, que é uma escolha popular para processar data JSON em Java e adicionei a dependência ao ficheiro pom.
/*

Nova Resolução:
Criei a classe representativa "Quotes.java" que recebe como argumentos o id, show e quote, assim como os seus contrutores e métodos get.
Depois criei um controlador, "QuotesController.java" de forma a lidar com os GET requests de acordo com o url especificado:
	- /api/quotes - retorna uma quote aleatória de uma série aleatória
	- api/quotes?show=<show_id> - retorna uma quote aleatória de uma série específica
	- api/shows - lista de todas as séries que existem
Criei um ArrayList para cada série e suas respetivas quotes e um HashMap "quotes" para guardar essas informações.
Usei o Random para retornar uma quote aleatória
Resultados obtidos:
	Para http://localhost:8080/api/quote:
	{"id":3,"show":"Drive to Survive","quote":"Max Max Super Max"}
	id: 3
	show: "Drive to Survive"
	quote: "Max Max Super Max"
	
	Ao atualizar a página:
	{"id":0,"show":"Game of Thrones","quote":"You know nothing Jon Snow"}
	id: 0
	show: "Game of Thrones"
	quote: "You know nothing Jon Snow"
	
	Para http://localhost:8080/api/quote?show=1:
	id: 1
	show: "Lúcifer"
	quote: "Detective!"
	
	Para http://localhost:8080/api/shows:
	["Game of Thrones","Lúcifer","You","Drive to Survive"]
	0: "Game of Thrones"
	1: "Lúcifer"
	2: "You"
	3: "Drive to Survive"

# ---- Review Questions -------
A. What are the responsibilities/services of a “servlet container”?

1. Ler os dados explícitos enviados pelos clientes. Isso inclui um formulário HTML numa página Web ou também pode vir de um miniaplicativo ou programa cliente HTTP personalizado.

2. Ler os dados de solicitação HTTP implícitos enviados pelos clientes. Por exemplo cookies ou tipo de media.

3. Enviar os dados explícitos (ou seja, o documento) para os clientes. Este documento pode ser enviado em vários formatos, incluindo texto (HTML ou XML), binário (imagens GIF) ou Excel.

4. Processar os dados e gerar os resultados. Esse processo pode exigir a comunicação com uma base de dadados, a execução de uma chamada RMI ou CORBA, a invocação de um serviço Web ou o cálculo direto da resposta.

5. Enviar a resposta HTTP implícita aos clientes. Ou seja informar os clientes que tipo de documento está a ser retornado (por exemplo, HTML), definir cookies e parâmetros de cache e outras tarefas semelhantes. 

B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)

O Spring usa MVC (Model, View, Controller) para servir o conteúdo da web:

     - O modelo é a camada lógica da aplicação. O framework Spring possui o org.springframework.ui.Model que permite mapear atributos para serem posteriormente renderizados nas visualizações.
     - A visualização é a camada "front-end" e geralmente é armazenada na pasta de modelos de um projeto Spring
     - O controlador aceita inputs e converte-os em comandos para o modelo ou vista. Spring tem uma anotação especial para designar uma classe como um Controlador.
      
C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?

As dependências iniciais permitem simplificar a construção do sistema, padronizando alguns aspectos do mesmo. 

D. Which annotations are transitively included in the @SpringBootApplication?

@SpringBootApplication é uma anotação de conveniência que adiciona o seguinte:

     - @Configuration: marca a classe como uma fonte de definições de bean para o contexto da aplicação.

     @EnableAutoConfiguration: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath, outros beans e várias configurações de propriedade. Por exemplo, se spring-webmvc estiver no caminho da classe, esta anotação sinaliza a aplicação como uma aplicação web e ativa comportamentos-chave, por exemplo,  como configurar um DispatcherServlet.

     @ComponentScan: Diz ao Spring para procurar outros componentes, configurações e serviços no pacote com/example, permitindo que ele encontre os controladores.
     
E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words.

1. Aceitar e responder com JSON
JSON é uma linguagem conhecida e uma das mais usadas, para além das inúmeras vantagens que possui: fácil de aprender, ler e perceber, e é compacto (é dois terços do tamanho da mesma data em XML)

2. Handle errors gracefully and return standard error codes
É conveniente para o endpoint da API retornar detalhes do erro no JSON ou no corpo da resposta para ajudar o utilizador com o debugging.

3. Versioning our APIs
A API precisa seguir medidas de segurança proativas para executar operações enquanto protege dados confidenciais sem problemas. É importante ter várias versões diferentes da API caso estejamos a fazer mudanças.

4. Cache data to improve performance
Podemos adicionar cache para retornar dados de cache de memória local em vez de consultar a base de dados para obter os dados sempre que quisermos recuperar alguns dados solicitados pelos utilizadores. A vantagem do armazenamento em cache é que os usuários podem obter dados mais rapidamente.

5. Nesting resources for hierarchical objects
Os objetivos dos recursos contêm sempre algum tipo de hierarquia funcional ou estão interligados. No entanto, ainda é ideal limitar o aninhamento na REST API, pois complica muito a distribuição do trabalho por meio dos mapeamentos. 
