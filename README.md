# RestAPI-2ibi
Representational State Transfer (REST), em português Transferência Representacional de Estado, é um estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services (serviços Web). Os Web services que estão em conformidade com o estilo arquitetural REST, denominados Web services RESTful, fornecem interoperabilidade entre sistemas de computadores na Internet.
Os Web services RESTful permitem que os sistemas solicitantes acessem e manipulem representações textuais de recursos da Web usando um conjunto uniforme e predefinido de operações sem estado. Outros tipos de Web services, como Web services SOAP, expõem seus próprios conjuntos de operações arbitrários.

# Objectivos
Desenvolver uma API RESTful que permita gerenciar as informações das propriedades dos países (identificador – gerado automaticamente, nome, capital, região, sub-região, área).

* Deve ser possível criar um novo país a partir da API criada com todas as suas propriedades;
* Deve ser possível listar todos os países anteriormente criados;
* Deve ser possível modificar os dados de um país anteriormente criado;
* Deve ser possível eliminar um país anteriormente criado;
* Deve ser possível ordenar a lista dos países por qualquer uma das suas propriedades.

# Requisitos
1. Java 8
2. JDK 1.8
3. Tomcat 8
4. Mysql

# Instalação
1. Clone o repositório
```
  git clone https://github.com/Guirande/RestAPI-2ibi.git
```
2. Altere as propriedades do ficheiro `db.properties` do pacote `tk.meceap.db.dao` para a conexao com a base de dados.
    *A aplicação se encarregará de criar a base de dados e respetivas tabelas;*
3. Faça a implantação/deploy da aplicação clonada para testes locais;
4. Faça (limpar e construir)/(clean and building) para obter o arquivo `.war`, arquivo que será usado no gerenciador de servidor tomcat em ambiente de produção;
5. Faça o upload do arquivo `.war` da pasta `/dist` do projecto para o servidor tomcat.

# Teste da aplicação
Para testes encontra-se disponível os seguintes endereços:

**Exposed REST End Point's**
```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/
http://meceap.tk:8084/RestAPI-2ibi/api/pais/
```

## Region

### GET List Of All Regions (GET)
```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/all
```

#### Response
```
[
  {
    "id": 1,
    "nome": "África",
    "descricao": "Continente situado no centro do planeta"
  },
  {
    "id": 2,
    "nome": "Ásia",
    "descricao": "Continente situado no sudeste do planeta"
  },
  {
    "id": 4,
    "nome": "Europa",
    "descricao": "Continente situado no sudeste do planeta"
  }
]
```

### GET a Region (GET)

```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/{id}
```

#### Response
```
{
  "id": 1,
  "nome": "África",
  "descricao": "Continente situado no centro do planeta"
}
```

### Add a Region (POST)

```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/
```

#### Request Body
```
{
    "nome": "Europa",
    "descricao": "Continente situado no sudeste do planeta"
}
```

#### Response
```
{
    "id": 1,
    "nome": "Europa",
    "descricao": "Continente situado no sudeste do planeta"
}
```

### Update a Region (PUT)

```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/{id}
```

#### Request Body
```
{
    "id": 1,
    "nome": "Europas",
    "descricao": "Continente situado no sudeste do planeta"
}
```

#### Response
```
{
  "status": "true"
}
```

### Delete a Region (DELETE)

```
http://meceap.tk:8084/RestAPI-2ibi/api/regiao/{id}
```

#### Response
```
{
  "status": "true"
}
```


## Sub Region

### GET List Of All Sub Regions (GET)
```
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/all
```

#### Response
```
[
  {
    "id": 1,
    "regiaoId": 1,
    "nome": "África Austral",
    "descricao": "Região de sul da África",
    "regiao": {
      "id": 1,
      "nome": "Áfricas",
      "descricao": "Continente situado no centro do planeta"
    }
  },
  {
    "id": 2,
    "regiaoId": 2,
    "nome": "Chinna",
    "descricao": "Regiao de sul da Asia",
    "regiao": {
      "id": 2,
      "nome": "Ásia",
      "descricao": "Continente situado no sudeste do planeta"
    }
  },
  {
    "id": 4,
    "regiaoId": 2,
    "nome": "Paises baixos",
    "descricao": "Regiao de sul da Europa",
    "regiao": {
      "id": 2,
      "nome": "Ásia",
      "descricao": "Continente situado no sudeste do planeta"
    }
  }
]
```

### GET a sub Region (GET)

```
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/{id}
```

#### Response
```
{
  "id": 1,
  "regiaoId": 1,
  "nome": "África Austral",
  "descricao": "Região de sul da África",
  "regiao": {
    "id": 1,
    "nome": "Áfricas",
    "descricao": "Continente situado no centro do planeta"
  }
}
```

### Add a sub Region (POST)

```
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/
```

#### Request Body
```
{
  "regiaoId": 1,
  "nome": "África Austral",
  "descricao": "Região de sul da África"
}
```

#### Response
```
{
  "id": 1,
  "regiaoId": 1,
  "nome": "África Austral",
  "descricao": "Região de sul da África",
  "regiao": {
    "id": 1,
    "nome": "Áfricas",
    "descricao": "Continente situado no centro do planeta"
  }
}
```

### Update a sub Region (PUT)

```
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/{id}
```

#### Request Body
```
{
    "id": 1,
    "regiaoId": 1,
    "nome": "África Austral",
    "descricao": "Região de sul da África"
}
```

#### Response
```
{
  "id": "true"
}
```

### Delete a sub Region (DELETE)

```
http://meceap.tk:8084/RestAPI-2ibi/api/sub-regiao/{id}
```

#### Response
```
{
  "status": "true"
}
```

## Country
### GET List Of All Country (GET)
```
http://meceap.tk:8084/RestAPI-2ibi/api/pais/all
```

#### Response
```
[
  {
    "id": 1,
    "subRegiaoId": 1,
    "nome": "Mozambique",
    "capital": "Chimoio",
    "area": 2938.43,
    "subRegiao": {
      "id": 1,
      "regiaoId": 1,
      "nome": "África Austral",
      "descricao": "Região de sul da África",
      "regiao": {
        "id": 1,
        "nome": "Áfricas",
        "descricao": "Continente situado no centro do planeta"
      }
    }
  }
]
```

### GET a Country (GET)

```
http://meceap.tk:8084/RestAPI-2ibi/api/pais/{id}
```

#### Response
```
{
  "id": 1,
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Maputo",
  "area": 2938.43,
  "subRegiao": {
    "id": 1,
    "regiaoId": 1,
    "nome": "África Austral",
    "descricao": "Região de sul da África",
    "regiao": {
      "id": 1,
      "nome": "Áfricas",
      "descricao": "Continente situado no centro do planeta"
    }
  }
}
```

### Add a Country (POST)

```
http://meceap.tk:8084/RestAPI-2ibi/api/pais/
```

#### Request Body
```
{
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Maputo",
  "area": 2938.43
}
```

#### Response
```
{
  "id": 1,
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Maputo",
  "area": 2938.43,
  "subRegiao": {
    "id": 1,
    "regiaoId": 1,
    "nome": "África Austral",
    "descricao": "Região de sul da África",
    "regiao": {
      "id": 1,
      "nome": "Áfricas",
      "descricao": "Continente situado no centro do planeta"
    }
  }
}
```

### Update a Country (PUT)

```
http://meceap.tk:8084/RestAPI-2ibi/api/pais/{id}
```

#### Request Body
```
{
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Chimoio",
  "area": 2938.43
}
```

#### Response
```
{
  "status": "true"
}
```

### Delete a Country (DELETE)

```
http://meceap.tk:8084/RestAPI-2ibi/api/pais/{id}
```

#### Response
```
{
  "status": "true"
}
```
