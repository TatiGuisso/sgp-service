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
- Foi utilizado Lombok, portanto é necessário adicionar o plugin na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

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
### API Eletrodoméstico

>[ Base URL: http://localhost:8080 ]


A API Eletrodoméstico oferece a funcionalidade de cadastro das informações dos eletrodomésticos utilizados pelos usuários registrados. 
É imprescindível fornecer obrigatoriamente os seguintes dados: nome, modelo, marca, potência e voltagem. O campo cor, é opcional.
Com essa API, é possível simplificar o processo de gerenciamento e manutenção dos dados dos eletrodomésticos, garantindo a correta identificação e utilização desses equipamentos.

Cada usuário pode ter vários aparelhos eletrônicos cadastrados em nosso sistema. A plataforma também disponibiliza verbos GET, PUT e DELETE para consulta, edição e exclusão de informações. A busca pode ser personalizada por nome, modelo, marca ou qualquer dado relevante, enquanto a atualização de informações permite a edição de qualquer dado sobre o aparelho eletrônico.

A API Eletrodoméstico permite registrar o consumo de energia de aparelhos cadastrados. Um adaptador envia regularmente leitura do consumo atual à API. O intervalo de envio pode ser personalizado pelo usuário no adaptador, podendo ser configurado para envios a cada hora.

A plataforma permite o usuário realizar consultas sobre o consumo de energia de aparelhos cadastrados. 
É possível obter o consumo total do aparelho sem a necessidade de fornecer data/hora ou período específico. Além disso, é possível obter informações sobre o consumo em um período específico ao informar a data/hora desejada.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastro de Eletrodoméstico`

```
	enderecos/{idEndereco}/eletrodomesticos
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/enderecos/16/eletrodomesticos' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "TELEVISAO",
    "marca": "Samsung",
    "modelo": "PCC20",
    "cor": "Preta",
    "potencia": 1000,
    "voltagem": 220
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado`

```
1
```

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "voltage:não deve ser nulo;"
}
```

422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.IllegalArgumentVoltage",
    "message": "Voltagem inválida, aceito apenas '110' e '220'."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``

```
	usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location --request PUT 'http://localhost:8080/usuarios/21/eletrodomesticos/15' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Purificador de Água",
    "marca": "IBBL",
    "modelo": "FR600",
    "cor": "Branco",
    "potencia": 90,
    "voltagem": 110
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
400 - _Bad Request_

```
{
    "code": "tc.argumentNotValid",
    "message": "nome:não deve estar em branco;"
}
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``
`*Para excluir Eletrodoméstico`

```
	usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/usuarios/21/eletrodomesticos/10'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.erroAoExcluirEletrodomestico",
    "message": "ATENÇÃO: Antes de excluir o eletrodoméstico, por favor excluir suas Leituras de Consumo."
}
```

422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```
500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para busca de Eletrodoméstico`

```
	usuarios/{idUsuario}/eletrodomesticos
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/usuarios/21/eletrodomesticos?nome=Air%20Fryer&modelo=AFN&marca=mondial&potencia=1500'
```

`*Filtros disponíveis:** nome, modelo, marca, potencia.`

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
[
    {
        "id": 8,
        "nome": "Air Fryer",
        "modelo": "AFN-40-BI",
        "marca": "Mondial",
        "cor": "Preto/Inox",
        "potencia": 1500,
        "voltagem": 110,
        "endereco": {
            "id": 12
        }
    }
]
```
200 - _OK_
`- Caso o endereço não exista.`

```
[]
```


500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastrar Leitura de Consumo do Eletrodoméstico`

```
	eletrodomesticos/{id}/consumos
```

<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/eletrodomesticos/27/consumos' \
--header 'Content-Type: application/json' \
--data '{
    "consumo": 1.99
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado`

```
1
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para buscar Leitura de Consumo do Eletrodoméstico`

```
	eletrodomesticos/{id}/consumo-total-periodo
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/eletrodomesticos/10/consumo-total-periodo?dataInicio=2023-09-02T20%3A31%3A39&dataFim=2023-09-02T23%3A59%3A00'
```
`*Filtros disponíveis:** dataInicio, dataFim`

</details>

<details>
  <summary>Responses:</summary>

200 - _OK_

```
1.0 kWh
```
200 - _OK_
`- Caso o registro de consumo não exista.`

```
0.0 kWh
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
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
- Docker
- Banco de Dados MySQL

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="desafios"></a>
## 📍️ Desafios

**FASE 1**  
No desenvolvimento da primeira fase, nosso principal desafio foi criar uma estrutura que refletisse as melhores práticas utilizadas atualmente no mercado de desenvolvimento de software, indo além do foco acadêmico abordado nas aulas.

Adotamos o Clean Achitecture. 
Seguimos o princípio de separação de responsabilidades, como a divisão em camadas(Controller, UseCase, Gateway) para facilitar a manutenção e escalabilidade do sistema.

Utilizamos um interceptador de exceptions para garantir maior confiabilidade do sistema. Essa funcionalidade permite capturar e tratar exceções que ocorrem durante a execução, fornecendo respostas adequadas ao cliente e registrando informações úteis para análise posterior.

Incluímos logs nas classes utilizando a biblioteca de logging SLF4J. A utilização de logs nos permite registrar informações relevantes em diferentes níveis. Isso nos possibilita melhor visibilidade do comportamento do fluxo do sistema durante a execução. O que também facilita identificar e resolver problemas.

Adotamos o padrão Rest para expor os recursos da aplicação através da utilização de verbos HTTP apropriados. Estrutura adequada das URLs e retorno das respostas no formato JSON.


**FASE 2**  
Na segunda fase do projeto, optamos por realizar uma transição completa do código, que estava originalmente em inglês, para o português. Essa decisão visava melhorar a comunicação e a compreensão entre os membros do projeto. 
Durante essa etapa, enfrentamos um desafio central, que era estabelecer os relacionamentos entre as entidades. 
O código passou por várias iterações de refatoração para se adaptar e atender aos requisitos estabelecidos da melhor forma possível.

Para aplicar nossos conhecimentos, empregamos tanto o Criteria Builder quanto o JPQL para realizar consultas com filtros de pesquisa, garantindo assim uma abordagem eficaz na obtenção dos dados necessários para o projeto. 

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
