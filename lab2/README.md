# IES_98418
# Lab 2  - Java at ther server-side and the role of application containers

# ------ Exercício 2.1 ---------

Docker Containers são usados para providenciar tempos de execução virtualizados para qualquer tipo de serviços;
Os Servlet Containers são usados para providenciar um tempo de execução para executar código Java "web-related" e "server-sided", ou seja, não há virtualização

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

