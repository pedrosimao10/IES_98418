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


