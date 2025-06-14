<h1 align="center"> Sistema de Gestão de Ordem de Serviço - AutoGyn 🚗 </h1>

<p align="center">
Sistema completo para gerenciamento de ordens de serviço de uma oficina mecânica. Desenvolvido como projeto acadêmico integrador utilizando Java com Spring Boot no backend e Angular no frontend.<br/>
O sistema permite o cadastro de clientes, veículos, controle de estoque de peças, execução e pagamento de ordens de serviço, com geração de relatórios em PDF e aplicação de conceitos de compiladores para filtros avançados.<br/>
</p>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-como-executar-localmente">Como executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-estrutura-do-projeto">Estrutura</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-guia-de-contribuicaot">Guia de Contribuição</a>
</p>

<br>

<p align="center">
  <img alt="Imagem do Sistema" src="/img/iniciar.png" width="100%">
  <img alt="Imagem do Sistema" src="/img/homePage.png" width="100%">
</p>

## 🎓 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java 17
- Spring Boot
- Angular 17
- Banco de dados H2
- Git e GitHub
- Figma

## 📔 Projeto

O sistema desenvolvido visa atender as demandas da AutoGyn para controle de ordens de serviço e estoque de peças.

### Funcionalidades:
- Cadastro de veículos
- Cadastro de clientes (Pessoa Física e Jurídica)
- Gerenciamento das ordens de serviço
- Controle de peças e estoque
- Execução e pagamento das OS
- Geração de relatórios gerenciais em PDF
- Filtros personalizados com analisador léxico e sintático

### Aplicação de conhecimentos em compiladores:
- Uso de **gramáticas formais** e **expressões regulares** para validação:
  - Formato de placas: `AAA1A11`
  - CPF e CNPJ
  - Códigos de peças e OS
- Implementação de um **autômato finito** para validação de entradas
- **Simulação de análise léxica** para filtros personalizados:
  - Exemplo: `cliente.status = "em aberto" AND veiculo.tipo = "carro"`

### Padrões de Projeto Aplicados:
- **Singleton**: aplicado na configuração da conexão com o banco de dados H2
-
-
-
-

## 🚀 Como executar localmente

### Backend (Spring Boot)
1. Clone o repositório:
   ```bash
   git clone https://github.com/Isaluh/autoGyn
2. Acesse a pasta do backend
3. Execute o projeto

### Frontend (Angular)
1. Acesse a pasta do frontend Angular
2. Instale as dependências com npm install
3. Rode com `ng serve`

## 📁 Estrutura do Projeto

```
/autoGyn
├── APIAutoGyn
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/bamboobyte/APIAutoGyn
│   │   │   │   ├── APIAutoGyn
│   │   │   │   │   ├── Controllers
│   │   │   │   │   ├── DTO
│   │   │   │   │   ├── Entities
│   │   │   │   │   ├── Repositories
│   │   │   │   │   ├── Services
│   │   │   │   │   ├── Validacoes
│   │   │   │   │   └── ApiAutoGynApplication.java
│   │   │   │   ├── Config
│   │   │   │   │   └── ConexaoBD.java
│   │   │   └── resources
│   │   └── test
│   └── pom.xml
├── UIAutoGyn
│   ├── src
│    │   ├── app
│    │   │   ├── Components
│    │   │   ├── Layouts
│    │   │   ├── Models
│    │   │   ├── Services
│    │   │   └── Views
└── README.md
```

## 🤝 Guia de Contribuição
1. Faça um fork do projeto
2. Crie uma branch para sua feature: `git checkout -b minha-feature`
3. Commit suas mudanças: `git commit -m 'Adiciona minha feature'`
4. Push para a branch: `git push origin minha-feature`
5. Crie um Pull Request

---

<h4 align="center">By: Heloisa - feat: Augusto Lobo</h4>




