# 🍳 Recipe Chat AI

API REST desenvolvida com Spring Boot para geração de receitas culinárias a partir dos ingredientes informados pelo usuário.

O projeto foi criado com foco no aprendizado de Inteligência Artificial Generativa, arquitetura em camadas, injeção de dependência, documentação com JavaDoc e testes unitários utilizando JUnit 5 e Mockito.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring AI
- OpenAI
- Maven
- JUnit 5
- Mockito
- MockMvc

---

## 📌 Objetivo do Projeto

Permitir que usuários informem ingredientes e recebam receitas geradas pela aplicação através de uma arquitetura desacoplada baseada em serviços de Inteligência Artificial.

Durante o desenvolvimento foram praticados conceitos como:

- Arquitetura em Camadas
- Injeção de Dependência
- Interfaces e Desacoplamento
- Integração com IA utilizando Spring AI
- Testes Unitários
- Documentação com JavaDoc

Atualmente o fluxo principal utiliza uma implementação mock da IA para permitir testes e desenvolvimento local sem depender de chamadas reais para APIs externas.

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```text
GenerativeAIController
          ↓
     RecipeService
          ↓
       AIService
          ↓
    MockAIService
```

### Responsabilidades

#### GenerativeAIController

Responsável por receber as requisições HTTP da aplicação e retornar as respostas para o cliente.

#### RecipeService

Camada de negócio responsável pela criação das receitas.

#### AIService

Interface que define o contrato para geração de receitas utilizando Inteligência Artificial.

#### MockAIService

Implementação mock da interface `AIService`, utilizada para testes e desenvolvimento local.

#### ChatService

Serviço responsável por demonstrar a integração com modelos de linguagem através do Spring AI.

---

## 🔄 Implementação Mock

Durante o desenvolvimento foi utilizada uma implementação mock da interface `AIService`.

### Motivos

- Evitar consumo de tokens da OpenAI
- Permitir testes locais
- Facilitar o desenvolvimento offline
- Reduzir dependência de serviços externos

Essa abordagem é bastante utilizada em projetos profissionais para simular integrações externas durante o desenvolvimento.

---

## 🤖 Integração com IA

O projeto possui a classe `ChatService`, responsável por demonstrar a comunicação com modelos de linguagem através do Spring AI.

### Funcionalidades

- Envio de prompts para a IA
- Configuração de parâmetros do modelo
- Controle da temperatura das respostas
- Processamento do retorno gerado pela IA

### Exemplo de chamada simples

```java
chatModel.call(prompt);
```

### Exemplo de chamada configurada

```java
new Prompt(
    prompt,
    ChatOptions.builder()
        .temperature(0.4)
        .build()
);
```

### Temperatura

A temperatura controla o nível de criatividade das respostas.

| Valor | Comportamento |
|---------|---------|
| 0.0 | Respostas mais previsíveis |
| 0.4 | Equilíbrio entre precisão e criatividade |
| 1.0 | Respostas mais criativas |

Neste projeto foi utilizada temperatura **0.4**.

---

## 📡 Endpoint Disponível

### Gerar Receita

```http
GET /api/recipes/recipe-creator
```

### Query Parameters

| Parâmetro | Obrigatório | Descrição |
|------------|------------|------------|
| ingredients | Sim | Ingredientes utilizados na receita |
| cuisine | Não | Tipo de culinária desejada |
| dietaryRestrictions | Não | Restrições alimentares |

### Valores Padrão

```text
cuisine = any
dietaryRestrictions = none
```

### Exemplo de Requisição

```http
GET /api/recipes/recipe-creator?ingredients=tomate,queijo
```

### Exemplo de Resposta

```json
{
  "recipe": "Receita Gerada (MOCK): ..."
}
```

---

## 🧪 Testes Unitários

O projeto possui testes unitários utilizando:

- JUnit 5
- Mockito
- MockMvc

### Classes de Teste

```text
RecipeServiceTest
ChatServiceTest
ChatServiceOptionsTest
GenerativeAIControllerTest
```

### Objetivos dos Testes

- Validar regras de negócio
- Garantir a comunicação entre camadas
- Testar endpoints REST
- Simular dependências externas com mocks
- Validar retornos esperados

---

## 📚 Documentação

O projeto utiliza JavaDoc para documentar:

- Interfaces
- Services
- Controllers
- Métodos principais

Exemplo:

```java
/**
 * Serviço responsável pela comunicação com o modelo
 * de inteligência artificial utilizando Spring AI.
 */
```

---

## ▶️ Como Executar

### Clonar o repositório

```bash
git clone https://github.com/seu-usuario/recipe-chat-ai.git
```

### Acessar a pasta do projeto

```bash
cd recipe-chat-ai
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

---

## 🎯 Conceitos Praticados

- Java 21
- Spring Boot
- Spring AI
- OpenAI
- REST API
- Arquitetura em Camadas
- Injeção de Dependência
- Interfaces e Desacoplamento
- JavaDoc
- JUnit 5
- Mockito
- MockMvc

---

## 👨‍💻 Autor

Projeto desenvolvido para estudos de Java, Spring Boot, Inteligência Artificial Generativa e boas práticas de desenvolvimento de software.
