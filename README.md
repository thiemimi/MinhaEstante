# MinhaEstante
API do projeto MinhaEstante - Controle de leituras pessoais

## Tarefas

- [] CRUD de explorar
- [] CRUD de comunidade
- [] CRUD de resenhas
- [] CRUD de estante

## Documentação de API

### Endpoint
- [Listar todas as resenhas](#listar-todas-as-resenha)
- [Cadastrar resenha](#cadastrar-resenha)
- [Detalhes da Resenha](#detalhes-da-resenha)
- [Apagar Resenhas](#apagar-resenhas)
- [Atualizar resenhas](#atualizar-resenhas)

### Listar todas as resenhas

`GET` /resenhas

Retorna um array com todas as resenhas cadastradas

 #### Exemplo de resposta
 ```js
 [
    {
        "id": 1,
        "nome": "Resenha",
        "icone": "Resenha"
    }
 ]
 ```

#### Código de Status

| codigo | descrição |
|--------| ----------|
201 | Os dados das resenhas foram retornados com sucesso
401 | Acesso negado. Você deve se autenticar
-----

### Cadastrar Resenha

`POST` /resenha -> criar recurso

Cria uma nova resenha com os dados enviados no copor da requisição

### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|-----------|---------|
|nome|string|   ✔️|Um nome curto para a resenha|
|icone|string|✖️|O nome do ícone de acordo com a biblioteca Material Icons|


```js
{
    "nome": "Resenha",
    "icone": "Resenha"
}
```

#### Exemplo da resposta
 ```js
 
{
    "id": 1,
    "nome": "Resenha",
    "icone": "Resenha"
}
 
 ```
#### Código de Status
| codigo | descrição |
|--------| ----------|
201 | Os dados das resenhas foram retornados com sucesso
400 | Dados enviados são inválidos. Verifique o corpo da requisição
401 | Acesso negado. Você deve se autenticar
-----

### Detalhes da Resenha
`GET` /resenhas/`{id}`

Retornar os detalhes da resenha com o `id` informado como parâmetro de path

### Exemplo de resposta
 ```js
 // requisição para /leitura/1
{
    "id": 1,
    "nome": "Resenha",
    "icone": "Resenha"
}
 
 ```

 #### Código de status
 | codigo | descrição |
|--------| ----------|
200 | Os dados das resenhas foram retornados com sucesso
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----

### Apagar Resenha

`DELETE` /resenha/ `{id}`

Apaga a categoria com id especificado no parâmetro de path

#### Código de Status
| codigo | descrição |
|--------| ----------|
204 | Resenha foi apagada com sucesso
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----

### Atualizar Resenha

`PUT` /resenha/ `{id}`
Altera os dados da resenha especificada no `id`, utilizando as informações enviadas no corpo da requisição

#### Corpo da requisição


|campo|tipo|obrigatório|descrição|
|-----|----|-----------|---------|
|nome|string|   ✔️|Um nome curto para a resenha|
|icone|string|✔️|O nome do ícone de acordo com a biblioteca Material Icons|

```js
{
    "nome": "Resenha",
    "icone": "Resenha"
}
```

### Exemplo de resposta
```js
{
    "id": 1,
    "nome": "Resenha",
    "icone": "Resenha"
}
```
#### Código de Status
| codigo | descrição |
|--------| ----------|
200 | Resenha alterada com sucesso.
400 | Dados enviados são inválidos. Verifique o corpo da requisição
401 | Acesso negado. Você deve se autenticar
404 | Não existe categoria com o `id` informado
-----