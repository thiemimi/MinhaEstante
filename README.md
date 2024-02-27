# MinhaEstante
API do projeto MinhaEstante - Controle de leituras pessoais

## Tarefas

- [] CRUD de explorar
- [] CRUD de comunidade
- [] CRUD de resenhas
- [] CRUD de estante

## Documentação de API

### Endpoint
- [Listar todas as leituras](#listar-todas-as-leituras)
- [Cadastrar Leitura](#cadastrar-leitura)
- [Detalhes da Leitura](#detalhes-da-leitura)
- [Apagar Leituras](#apagar-leituras)
- [Atualizar Leituras]($atualizar-leituras)

### Listar todas as leituras

`GET` /leituras

Retorna um array com todas as leituras cadastradas

 #### Exemplo de resposta
 ```js
 [
    {
        "id": 1,
        "nome": "Livro",
        "icone": "Livro"
    }
 ]
 ```

#### Código de Status

| codigo | descrição |
|--------| ----------|
201 | Os dados das leituras foram retornados com sucesso
401 | Acesso negado. Você deve se autenticar
-----

### Cadastrar Leitura

`POST` /leitura -> criar recurso

Cria uma nova leitura com os dados enviados no copor da requisição

### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|-----------|---------|
|nome|string|   ✔️|Um nome curto para a leitura|
|icone|string|✖️|O nome do ícone de acordo com a biblioteca Material Icons|


```js
{
    "nome": "Livro",
    "icone": "Livro"
}
```

#### Exemplo da resposta
 ```js
 
{
    "id": 1,
    "nome": "Livro",
    "icone": "Livro"
}
 
 ```
#### Código de Status
| codigo | descrição |
|--------| ----------|
201 | Os dados das leituras foram retornados com sucesso
400 | Dados enviados são inválidos. Verifique o corpo da requisição
401 | Acesso negado. Você deve se autenticar
-----

### Detalhes da Leitura
`GET` /leituras/`{id}`

Retornar os detalhes da leitura com o `id` informado como parâmetro de path

### Exemplo de resposta
 ```js
 // requisição para /leitura/1
{
    "id": 1,
    "nome": "Livro",
    "icone": "Livro"
}
 
 ```

 #### Código de status
 | codigo | descrição |
|--------| ----------|
200 | Os dados das leituras foram retornados com sucesso
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----

### Apagar Leitura

`DELETE` /leitura/ `{id}`

Apaga a categoria com id especificado no parâmetro de path

#### Código de Status
| codigo | descrição |
|--------| ----------|
204 | Categoria foi apagada com sucesso
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----

### Atualizar Categoria

`PUT` /leitura/ `{id}`
Altera os dados da leitura especificada no `id`, utilizando as informações enviadas no corpo da requisição

#### Corpo da requisição


|campo|tipo|obrigatório|descrição|
|-----|----|-----------|---------|
|nome|string|   ✔️|Um nome curto para a leitura|
|icone|string|✔️|O nome do ícone de acordo com a biblioteca Material Icons|

```js
{
    "nome": "Livro",
    "icone": "Livro"
}
```

### Exemplo de resposta
```js
{
    "id": 1,
    "nome": "Livro",
    "icone": "Livro"
}
```
#### Código de Status
| codigo | descrição |
|--------| ----------|
200 | Categoria alterada com sucesso.
400 | Dados enviados são inválidos. Verifique o corpo da requisição
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----