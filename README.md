# RestAPI-2ibi
Representational State Transfer (REST), em português Transferência Representacional de Estado, é um estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services (serviços Web). Os Web services que estão em conformidade com o estilo arquitetural REST, denominados Web services RESTful, fornecem interoperabilidade entre sistemas de computadores na Internet.
Os Web services RESTful permitem que os sistemas solicitantes acessem e manipulem representações textuais de recursos da Web usando um conjunto uniforme e predefinido de operações sem estado. Outros tipos de Web services, como Web services SOAP, expõem seus próprios conjuntos de operações arbitrários.

## Jersey Overview
Developing RESTful Web services that seamlessly support exposing your data in a variety of representation media types and abstract away the low-level details of the client-server communication is not an easy task without a good toolkit. In order to simplify development of RESTful Web services and their clients in Java, a standard and portable JAX-RS API has been designed. Jersey RESTful Web Services framework is open source, production quality, framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs and serves as a JAX-RS (JSR 311 & JSR 339) Reference Implementation.


## Setting Up Application Server(Apache Tomcat)

Before going to configure Tomcat Server on your system donwload latest version of it and extract files from. [Click here to donwload latest version of Tomcat 9.0.x](http://mirrors.estointernet.in/apache/tomcat/tomcat-9/v9.0.27/bin/apache-tomcat-9.0.27.tar.gz)

**Go To IntelliJ Welcome screen and click On Configure**

1. Open the Settings/Preferences dialog Ctrl+Alt+S
2. In the left-hand pane, in the Build, Execution, Deployment category, select Application Servers.
3. Select the server that you are going to use( Choose Tomcat Server for now).
4. Put the path of tomcat server installation directory under Tomcat_Home or just browse to select it.

### Creating a run/debug configuration

1. Open the Run/Debug Configurations dialog (for example, Run | Edit Configurations).
2. Click + , select the server of interest (for example, Tomcat Server) and, if available, select Local
3. Choose the Deployment tab, clicking “+”, and choosing Artifact…
4. Select Artifact listed then choose Apply and finally OK.


#Run Application

**Exposed REST End Point's**
```
http://localhost:8080/RestAPI-2ibi/api/regiao/
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/
http://localhost:8080/RestAPI-2ibi/api/pais/
```

##Region
**GET List Of All Regions (GET)**
```
http://localhost:8080/RestAPI-2ibi/api/regiao/all
```

**Response**
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

**GET a Region (GET)**

```
http://localhost:8080/RestAPI-2ibi/api/regiao/{id}
```

**Response**
```
{
  "id": 1,
  "nome": "África",
  "descricao": "Continente situado no centro do planeta"
}
```

**Add a Region (POST)**

```
http://localhost:8080/RestAPI-2ibi/api/regiao/
```

**Request Body**
```
{
    "nome": "Europa",
    "descricao": "Continente situado no sudeste do planeta"
}
```

**Response**
```
{
    "id": 1,
    "nome": "Europa",
    "descricao": "Continente situado no sudeste do planeta"
}
```

**Update a Region (PUT)**

```
http://localhost:8080/RestAPI-2ibi/api/regiao/{id}
```

**Request Body**
```
{
    "id": 1,
    "nome": "Europas",
    "descricao": "Continente situado no sudeste do planeta"
}
```

**Response**
```
{
  "id": "true"
}
```

**Delete a Region (DELETE)**

```
http://localhost:8080/RestAPI-2ibi/api/regiao/{id}
```

**Response**
```
{
  "id": "true"
}
```


##Sub Region
**GET List Of All Sub Regions (GET)**
```
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/all
```

**Response**
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

**GET a Region (GET)**

```
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/{id}
```

**Response**
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

**Add a Region (POST)**

```
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/
```

**Request Body**
```
{
  "regiaoId": 1,
  "nome": "África Austral",
  "descricao": "Região de sul da África"
}
```

**Response**
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

**Update a Region (PUT)**

```
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/{id}
```

**Request Body**
```
{
    "id": 1,
    "regiaoId": 1,
    "nome": "África Austral",
    "descricao": "Região de sul da África"
}
```

**Response**
```
{
  "id": "true"
}
```

**Delete a Region (DELETE)**

```
http://localhost:8080/RestAPI-2ibi/api/sub-regiao/{id}
```

**Response**
```
{
  "id": "true"
}
```



##Region
**GET List Of All Regions (GET)**
```
http://localhost:8080/RestAPI-2ibi/api/regiao/all
```

**Response**
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

**GET a Country (GET)**

```
http://localhost:8080/RestAPI-2ibi/api/regiao/{id}
```

**Response**
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

**Add a Country (POST)**

```
http://localhost:8080/RestAPI-2ibi/api/pais/
```

**Request Body**
```
{
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Maputo",
  "area": 2938.43
}
```

**Response**
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

**Update a Country (PUT)**

```
http://localhost:8080/RestAPI-2ibi/api/pais/{id}
```

**Request Body**
```
{
  "subRegiaoId": 1,
  "nome": "Mozambique",
  "capital": "Chimoio",
  "area": 2938.43
}
```

**Response**
```
{
  "status": "true"
}
```

**Delete a Country (DELETE)**

```
http://localhost:8080/RestAPI-2ibi/api/pais/{id}
```

**Response**
```
{
  "status": "true"
}
```
