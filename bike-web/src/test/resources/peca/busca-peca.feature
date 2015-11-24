# language: pt

Funcionalidade: Listagem de pecas

Esquema do Cenario:
   Dado que o banco de dados possua as seguintes "<pecas>"
   Quando for requisitada a listagem de pecas
   Entao serao retornadas as seguintes "<pecas_resultado>"
   
   Exemplos:
 |  pecas                                                           | pecas_resultado                                                 |
 |  nome:banco Tree,tipo:banco,marca:Tree,descricao:Tree eh isso ai | nome:banco Tree,tipo:banco,marca:Tree,descricao:Tree eh isso ai |
 |  nulo                                                            | nulo                                                            |
 |  nome:lumiax,tipo:guidao,marca:lumiaxii,descricao:guidao cromado | nome:lumiax,tipo:guidao,marca:lumiaxii,descricao:guidao cromado |  
 |  nome:pisi,tipo:guidao,marca:nulo,descricao:guidao cromado       | nome:pisi,tipo:guidao,marca:nulo,descricao:guidao cromado       |  
