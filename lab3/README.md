# IES_98418
# Lab 3 - Multi-lyer web applications with Spring Boot

# ------ Exercício 3.1 -----------
a)

O ficheiro "User.java" vai ser acompanhado pela anotação @Entity, isto significa que a implementação JPA que neste caso é Hibernate, vai ser capaz de realizar operações CRUD nas entidades do domínio.
Os campos 'name' e 'fields' foram constrangidos com a restrição @NotBlank. Isto implica que podemos usar o Hibernate Validator para validar campos constrangidos(restritivos) antes de atualizar uma entidade na Base de Dados.

Spring Data JPA permite-nos implementar repositórios baseados em JPA sem ser necessário muito trabalho.

De maneira a providenciar à nossa aplicação funcionalidades básicas CRUD nos objetos do User basta extender a interface do CrudRepository.

Neste caso, uma classe Controller é suficiente para gerir pedidos HTTP de GET  e POST e de seguida mepeá-los para a nossa implementação do UserRepository
	showSignUpForm() - mostrar o formulário de registo;
	addUser() - adiciona novo utilizador à base de dados após validar os campos 'restritos' (name e fields);
	showUpdateForm() - relaciona a entidade User que dá match com o id da base de dados
	updateUser() - atualiza a entidade na base de dados
	delteUser() - elimina a entidade da base de dados
	
A view layer é essencial neste exercício de forma a mostrar o formulário de registo, o formulário atualizado e a lista de entidades do User

Após correr o programa principal, apareceu uma página onde era possível adicionar um novo utilizador, editar ou eliminar.
 
b)
The “UserController” class gets an instance of “userRepository” through its constructor; how
is this new repository instantiated?
R: Através da anotação "@Autowired", que insere uma instância do UserRepository no objeto do UserController

List the methods invoked in the “userRepository” object by the “UserController”. Where are
these methods defined?
R: Os métodos invocados são: save(), findAll(), findById() e delete(). Todos estes métodos estão definidos no CrudRepository (interface Spring Data usada para operações CRUD genéricas num determinado repositório), no qual o nosso repositório faz "extend".

Where is the data being saved?
R: A data está a ser guardada usando a h2database, que foi adicionada ao projeto como sendo uma dependência.

Where is the rule for the “not empty” email address defined?
R: Está definida no ficheiro "User.java" através da restrição @NotBlank quando declaramos o atributo.

c)
De forma a acrescentar um novo campo "Phone Number", alterou-se o ficheiro User.java:
	@NotBlank(message = "Phone is mandatory")
    	private int phone;
Alterou-se também os 3 ficheiros html criados. O "add-user.html":
	<label for="phone">Phone Number</label>
        <input type="text" th:field="*{phone}" id="phone" placeholder="Phone">
        <span th:if="${#fields.hasErrors('phone')}" th:errors="*{phone}"></span>
O "update-user.html":
	<label for="phone">Phone Number</label>
        <input type="text" th:field="*{phone}" id="phone" placeholder="Phone">
        <span th:if="${#fields.hasErrors('phone')}" th:errors="*{phone}"></span>
O "index.html":
	<th>Phone Number</th>
	...
	<td th:text="${user.phone}"></td>

# ------ Exercício 3.2 -----------

a)

Instalação do docker no linux: sudo snap install docker

Instalação do mysql no docker: sudo docker pull mysql

Instalação de docker container para resolver o exercício: $ docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7
Resultado do comando acima:
Unable to find image 'mysql/mysql-server:5.7' locally
5.7: Pulling from mysql/mysql-server
b8aa102ba20a: Pull complete 
2ff679d72626: Pull complete 
ea45979059fe: Pull complete 
526a484cb892: Pull complete 
4436dc023066: Pull complete 
98b382a658b6: Pull complete 
17d3acf6ac1e: Pull complete 
c5ce8d5cf40e: Pull complete 
Digest: sha256:32aac4632baa157d24e9eb3e20d2d62e775f0a2630afb8dabf5ee8c086b09c2a
Status: Downloaded newer image for mysql/mysql-server:5.7
d07e3e7965e47057c1d8c0bd9a9cc58a0bcd9cee45a189c93e8c136a6202c28c

b)
De maneira a resolver esta alínea criou-se um Spring Boot Application, com as seguintes características:
	
    Generate: Maven Project
    Java Version: 11 (Default)
    Spring Boot:2.5.6
    Group: net.guides.springboot2
    Artifact: springboot2-jpa-crud-example
    Name: springboot2-jpa-crud-example
    Description: Rest API for a Simple Employee Management Application
    Package Name : net.guides.springboot2.springboot2jpacrudexample
    Packaging: jar (This is the default value)
    Dependencies: Web, JPA, MySQL, DevTools and Validation
    
Após criar todas as entidades e classes, adicionou-se o seguinte ao ficheiro application.properties: 
	# MySQL
	spring.datasource.url=jdbc:mysql://127.0.0.1:33060/demo
	spring.datasource.username=demo
	spring.datasource.password=secret2
	spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
	# Strategy to auto update the schemas (create, create-drop, validate, update)
	spring.jpa.hibernate.ddl-auto = update
	
Testar a aplicação:
Todas as imagens a testar a aplicação vão estar disponíveis na pasta iamgesTestingRestAPI
 
d)
De maneira a ser possível pesquisar por email, adicionou-se ao ficheiro "EmployeeRepository" a query necessária para pesquisar pelo email:  public Employee getEmployeeByemailId(String emailId);}

De seguida foi só basear na função que já existia para procurar por Id e adaptar para procurar por email:
@GetMapping("/employees?email={email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "email") String employeeEmail)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.getEmployeeByemailId(employeeEmail);
        return ResponseEntity.ok().body(employee);
    }
    
O resultado encontra-se também em formato de imagem na pasta previamente descrita (SPOILER: alínea resolvida com sucesso)
