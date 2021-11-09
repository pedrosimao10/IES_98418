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
R: Através de uma referência na classe "UserController" : UserRepository userRepository; .

List the methods invoked in the “userRepository” object by the “UserController”. Where are
these methods defined?
R: Os métodos invocados são: save(), findAll(), findById() e delete(). Todos estes métodos estão definidos no CrudRepository (interface Spring Data usada para operações CRUD genéricas num determinado repositório)

Where is the data being saved?
R: A data é toda guardada numa base de dados relacional, que consiste em ter a data tabelada em colunas e ligada a outras tabelas de informação através de um sistema de keywords, que incluem chaves primárias e estrangeiras.

Where is the rule for the “not empty” email address defined?
R: Está definida no ficheiro "User.java" através da restrição @NotBlank no campo 'fields'.

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

