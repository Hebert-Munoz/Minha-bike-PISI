# language: pt

Funcionalidade: Insercao de pecas

Esquema do Cenario:
   Quando for requisitada a insercao de pecas para adicionar a seguinte "<peca>"
   Entao sera inserida a "<peca_inserida>"
   
   Exemplos:
 |  peca                                                            | peca_inserida                                                 |
 |  nome:banco vds,tipo:banco,marca:vds,descricao:vds rule          | nome:banco vds,tipo:banco,marca:vds,descricao:vds rule          |
 |  nome:lumiax,tipo:guidao,marca:lumiaxii,descricao:guidao cromado | nome:lumiax,tipo:guidao,marca:lumiaxii,descricao:guidao cromado |  
 |  nome:pisi,tipo:guidao,marca:nulo,descricao:guidao cromado       | nome:pisi,tipo:guidao,marca:nulo,descricao:guidao cromado       |  
