<a name="readme-top"></a>

# Introdução

O SGP-Sistema de Gestão de Parquimetro, foi desenvolvido para atender a crescente demanda de estacionamento na cidade.

## Sumário
* [Instruções](#instruções)
* [API Usuário](#api-usuário)
* [API Endereço](#api-endereço)
* [API Eletrodoméstico](#api-eletrodoméstico)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok e Validation, portanto é necessário adicionar os plugins na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
<a name="funcionalidades-do-projeto"></a>
## 🔨  Funcionalidades do projeto

### Registro de Condutores

>[ Base URL: http://localhost:8080 ]

O registro de condutores permite que os usuários se cadastrem no sistema, fornecendo informações pessoais como nome, endereço e detalhes de contato.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``  
`*Para cadastro de Condutor`

```
	/condutores
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/usuarios' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "041.276.747-33",
    "email": "pedro_nunes@gmail.com",
    "telefone": "(98)99764-0567",
    "endereco": {
        "rua": "Avenida Viana Vaz",
        "numero": "914",
        "bairro": "Centro",
        "cidade": "Timon",
        "estado": "MA",
        "cep": "65630-150"
    }
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do condutor`

```
6544027c1d769121eb36feb1
```

400 - _Bad Request_

```
{
    "code": "argumentNotValid",
    "message": "cpf:número do registro de contribuinte individual brasileiro (CPF) inválido;"
}
```

422 - _Unprocessable Entity_
`- Caso o CPF já esteja cadastrado`

```
{
    "code": "sgp.cpfJaCadastrado",
    "message": "CPF já cadastrado"
}
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``

```
	/condutores/{CPF}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/condutores/04127674733'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o usuário`

```
{
    "id": "6544027c1d769121eb36feb1",
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "04127674733",
    "email": "pedro_nunes@gmail.com",
    "telefone": "(98)99764-0567",
    "endereco": {
        "rua": "Avenida Viana Vaz",
        "numero": "914",
        "bairro": "Centro",
        "cidade": "Timon",
        "estado": "MA",
        "cep": "65630-150"
    }
}
```

404 - _Not Found_

```
{
    "code": "sgp.condutorNaoEncontrado",
    "message": "Condutor não encontrado"
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do Condutor`

```
	/condutores/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8080/condutores/6544027c1d769121eb36feb1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Pedro Alves Nunes",
    "cpf": "04127674733",
    "email": "pedro_nunes@nunes.com",
    "telefone": "(98)99764-0567",
    "endereco": {
        "rua": "Rua Viana Vaz",
        "numero": "15",
        "bairro": "Centro",
        "cidade": "Timon",
        "estado": "MA",
        "cep": "65630-150"
    }
}'
```
</details>
<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
404 - _Not Found_  

```
{
    "code": "sgp.condutorNaoEncontrado",
    "message": "Condutor não encontrado"
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``
`*Para excluir Condutor`

```
	/condutores/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/condutores/654404c222882b466fed9e00'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
404 - _Not Found_  

```
{
    "code": "sgp.condutorNaoEncontrado",
    "message": "Condutor não encontrado"
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Registro de Veículo

>[ Base URL: http://localhost:8080 ]


A funcionalidade de registro de veículos permite que o condutor após o seu cadastro, inclua informações sobre seu(s) veículo(s). Essa etapa possibilita inclusão de detalhes de um ou vários veículos que o condutor possua ou opere.o

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastro de Veículo`

```
	/veiculos
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/veiculos' \
--header 'Content-Type: application/json' \
--data '{
    "marca": "VW - VolksWagen",
    "modelo": "Gol Rallye 1.6 T. Flex 16V 5p",
    "placa": "MUU-2202",
    "condutor": {
        "id": "6544027c1d769121eb36feb1"
    }
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do veículo`

```
65441af928166b3360397af4
```
400 - _Bad Request

```
{
    "code": "argumentNotValid",
    "message": "placa:não deve estar em branco;"
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do Veículo`


```
	veiculos/{idVeiculo}

```

<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location --request PUT 'http://localhost:8080/veiculos/65441af928166b3360397af4' \
--header 'Content-Type: application/json' \
--data '{
    "marca": "VW - VolksWagen",
    "modelo": "Gol Rallye 1.6 T. Flex 16V 5p",
    "placa": "NEV-1252"
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_
```
```
404 - _Not Found_  

```
{
    "code": "sgp.veiculoNaoEncontrado",
    "message": "Veiculo não encontrado"
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
```
	veiculos/{idVeiculo}
```
<details>
  <summary>Exemplo Request:</summary>
  
```
curl --location 'http://localhost:8080/veiculos/65441af928166b3360397af4'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
{
    "id": "65441af928166b3360397af4",
    "marca": "VW - VolksWagen",
    "modelo": "Gol Rallye 1.6 T. Flex 16V 5p",
    "placa": "NEV-1252",
    "condutor": {
        "id": "6544027c1d769121eb36feb1",
        "nome": "Pedro Alves Nunes",
        "cpf": "04127674733",
        "email": "pedro_nunes@nunes.com",
        "telefone": "(98)99764-0567",
        "endereco": {
            "rua": "Rua Viana Vaz",
            "numero": "15",
            "bairro": "Centro",
            "cidade": "Timon",
            "estado": "MA",
            "cep": "65630-150"
        }
    }
}
```

404 - _Not Found_
`- Caso o veículo não exista.`

```
{
    "code": "sgp.veiculoNaoEncontrado",
    "message": "Veiculo não encontrado"
}
```

</details>


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``

```
	veiculos/{idVeiculo}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/veiculos/65440b88a6a7c64b08bd79b9'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
404 - _Not Found_  
`- Caso o veículo não exista.`

```
{
    "code": "sgp.veiculoNaoEncontrado",
    "message": "Veiculo não encontrado"
}
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Registro de Estacionamento

>[ Base URL: http://localhost:8080 ]

//TODO descrever sobre o registro de estacionamento.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para iniciar o registro de estacionamento (check-in)`

```
	estacionamentos/check-in
```
<details>
  <summary>Exemplo Request Body:</summary>  
  
- _Cobrança por TEMPO_FIXO_

```
curl --location 'http://localhost:8080/estacionamentos/check-in' \
--header 'Content-Type: application/json' \
--data '{
    "quantidadeHoras": 4,
    "veiculoId": "65441af928166b3360397af4",
    "tipoEstacionamento": "TEMPO_FIXO"
}'
```

- _Cobrança por TEMPO_VARIAVEL_

```
curl --location 'http://localhost:8080/estacionamentos/check-in' \
--header 'Content-Type: application/json' \
--data '{
    "veiculoId": "6539b580eefbc3231bd4c8be",
    "tipoEstacionamento": "TEMPO_VARIAVEL"
}'
```

</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
`- Será retornado o id do registro estacionamento`

- _Cobrança por TEMPO_FIXO_

```
6544269962cd7f53cfcbb87e
```

- _Cobrança por TEMPO_VARIAVEL_

```
65442ec5e691fb37293402e5
```


</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter informações do registro de estacionamento`

```
	estacionamentos/{id}
```
<details>
  <summary>Exemplo Request Body:</summary>

- _Cobrança por TEMPO_FIXO  ou  TEMPO_VARIAVEL_

```
curl --location 'http://localhost:8080/estacionamentos/6544269962cd7f53cfcbb87e'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

- _Cobrança por TEMPO_FIXO_

```
{
    "id": "6544269962cd7f53cfcbb87e",
    "tipo": "FIXO",
    "dataHoraInicio": "2023-11-02T19:45:41.102",
    "dataHoraTermino": "2023-11-02T23:45:41.102",
    "valor": 15.0,
    "pagamento": null,
    "veiculo": {
        "id": "65441af928166b3360397af4",
        "placa": "NEV-1252",
        "condutor": {
            "id": "6544027c1d769121eb36feb1",
            "nome": "Pedro Alves Nunes",
            "cpf": "04127674733"
        }
    }
}
```

- _Cobrança por TEMPO_VARIAVEL_

```
{
    "id": "65442ec5e691fb37293402e5",
    "tipo": "VARIAVEL",
    "dataHoraInicio": "2023-11-02T18:20:37.585",
    "dataHoraTermino": null,
    "valor": 10.0,
    "pagamento": null,
    "veiculo": {
        "id": "6539b580eefbc3231bd4c8be",
        "placa": "NEV-4542",
        "condutor": {
            "id": "6539b3beeefbc3231bd4c8bd",
            "nome": "Ricardo Caio Oliveira",
            "cpf": "31253870780"
        }
    }
}
```


</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PATCH``
`*Para encerrar o registro de estacionamento (check-out)`

```
	estacionamentos/{id}/check-out
```
<details>
  <summary>Exemplo Request:</summary>
  
- _Cobrança por TEMPO_FIXO  ou  TEMPO_VARIAVEL_

```
curl --location --request PATCH 'http://localhost:8080/estacionamentos/6544269962cd7f53cfcbb87e/check-out'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

- _Cobrança por TEMPO_FIXO  ou  TEMPO_VARIAVEL_

```
{
    "solicitacaoPagamentoId": "18bef041-fb37-4eb5-800e-9286501cfb7d",
    "sistemaPagamentoName": "MOCK",
    "sistemaPagamentoRedirectUrl": "https://mock/iniciar-pagamento/18bef041-fb37-4eb5-800e-9286501cfb7d"
}
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter o recibo após concluir o pagamento`

```
	estacionamentos/{id}/recibo
```

<details>
  <summary>Exemplo Request:</summary>
  
- _Cobrança por TEMPO_FIXO  ou  TEMPO_VARIAVEL_

```
curl --location 'http://localhost:8080/estacionamentos/6544269962cd7f53cfcbb87e/recibo?status=PAGO'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

- _Cobrança por TEMPO_FIXO_

```
{
    "registroEstacionamentoId": "6544269962cd7f53cfcbb87e",
    "pagamento": {
        "idSolicitacaoPagamento": "18bef041-fb37-4eb5-800e-9286501cfb7d",
        "status": "PAGO",
        "valorPago": 15.0
    },
    "veiculo": {
        "id": "65441af928166b3360397af4",
        "marca": "VW - VolksWagen",
        "modelo": "Gol Rallye 1.6 T. Flex 16V 5p",
        "placa": "NEV-1252",
        "condutor": {
            "id": "6544027c1d769121eb36feb1",
            "nome": "Pedro Alves Nunes",
            "cpf": "04127674733",
            "email": "pedro_nunes@nunes.com",
            "telefone": "(98)99764-0567"
        }
    }
}
```

- _Cobrança por TEMPO_VARIAVEL_

```
{
    "registroEstacionamentoId": "65442ec5e691fb37293402e5",
    "pagamento": {
        "idSolicitacaoPagamento": "5183febb-1cbe-42d2-b9bb-0b476e6c625c",
        "status": "PAGO",
        "valorPago": 10.0
    },
    "veiculo": {
        "id": "6539b580eefbc3231bd4c8be",
        "marca": "Peugeot",
        "modelo": "206 Passion 1.6",
        "placa": "NEV-4542",
        "condutor": {
            "id": "6539b3beeefbc3231bd4c8bd",
            "nome": "Ricardo Caio Oliveira",
            "cpf": "31253870780",
            "email": "ricardo-oliveira80@huios.com.br",
            "telefone": "(69) 99665-3809"
        }
    }
}
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>


---------

<a name="tecnologias"></a>
## 📍️ Tecnologias

- As API's foram construídas em Java 17 utilizando Spring Framework 3.1.0
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MongoDB

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="desafios"></a>
## 📍️ Desafios

**FASE 3**  


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
