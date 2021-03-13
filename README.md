# Genshin API

Api rest utilizando SPRING, JAVA 11, JPA como ORM e MYSQL como banco de dados
## Como Executar ???
- Necessita do banco `MySQL` esta rodando
- Modifica o aquivo `application.properties` com a url, username, password do banco,
  mudar tambem `spring.jpa.hibernate.ddl-auto` para `create`
- Entrar na pasta do projeto  e rodar o comando `mvnw.cmd spring-boot:run`(precisa do java 11, pode ocorrer erros por conta do java_home no arquivo mvnw.cmd, usar set JAVA_HOME=path_do_jdk_java)
- Executar o arquivo `add-characteres.sql` no banco de dados (esse arquivo possui o conteúdo do banco de dados)

## Rotas da Aplicação
### Rotas publicas (apenas GET)
- `api/signup` necessita username e password sendo enviado como json para cria um novo usuário, recebe um token como resposta
- `api/login` necessita username e password sendo enviado como json, recebem um token como resposta
- `api/characters`
- `api/characters/{id}` id do personagem
- `api/characters/{nome}` nome do personagem
- `api/item`
- `api/item/{id}` id do item
- `api/item/{name}` nome do item


### Rotas com autenticação(necessitam um token)

#### POST

- `api/characters`
- `api/item`

#### PUT & DELETE

- `api/characters/{id}`
- `api/item/{id}`
