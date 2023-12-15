![logo](https://github.com/tomasiamussuri/SistemaGestaoEstoque_EletroTech/blob/main/img/logo_eletrotech.png)


## Sistema de Controle de Estoque da EletroTech
Projeto de criação de um sistema para controle de estoque para a EletroTech monitorar e gerenciar seu estoque de forma eficaz, garantindo o equilibrio adequado entre a ferta e demanda.</br>

### Links úteis

### Características
• Rastreamento Preciso de Estoque: Manter uma visão clara e atualizada do estoque disponível. </br>
• Gestão Eficiente de Fornecedores: Melhorar as relações com fornecedores e otimizar o processo de reabastecimento. </br>
• Análise de Dados para Tomada de Decisões: Utilizar os dados coletados para tomar decisões informadas sobre compras e vendas. </br>
• Melhoria da Experiência do Cliente: Assegurar que os produtos mais procurados estejam sempre disponíveis, melhorando assim a satisfação do cliente. </br>

### Tecnologias Utilizadas
• As tecnologias e ferramentas utilizadas no desenvolvimento do projeto são Java e SQLite. </br>

### Estrutura do Banco de Dados
• O sistema será estruturado em permitir um controle preciso sobre o fluxo de produtos, desde o recebimento à movimentação de saída, controlados por  quatro cadastros principais: </br>
1. Fornecedor: Mantendo informações sobre os fornecedores.</br>
2. Produtos: Detalhando as principais informações de cada produto, com informações abrangentes.</br>
3. Fornecedor_Produto: MTabela de associação que conecta produtos aos seus respectivos fornecedores, permitindo à empresa identificar rapidamente de onde os produtos estão vindo e para onde estão indo, o que é essencial para a gestão da cadeia de suprimentos e para negociações de compra.</br>
3. Movimentações de Estoque: Registrando todas as entradas e saídas de produtos, fornecendo dados em tempo real sobre a disponibilidade, custos, validade.</br>

O projeto descrito é um sistema de banco de dados relacional projetado para gerenciar as operações de inventário e as relações com fornecedores de uma empresa. A seguir, detalho a estrutura do banco de dados e a finalidade de cada uma das tabelas propostas:
-- Criação da tabela de Fornecedores
CREATE TABLE FORNECEDOR (
    Id INT PRIMARY KEY,
    CNPJ_CPF VARCHAR(18),
    Razao_Social VARCHAR(50),
    Nome VARCHAR(50)
);

-- Criação da tabela de Produtos
CREATE TABLE PRODUTO (
    Id INT PRIMARY KEY,
    Nome VARCHAR(30),
    Descricao VARCHAR(100),
    Categoria VARCHAR(50)
);

-- Criação da tabela de Movimentação de Estoque
CREATE TABLE MOVIMENTACAO_ESTOQUE (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Data DATE,
    Quantidade REAL,
    Tipo_Movimentacao VARCHAR(30),
    Custo REAL,
    Lote INT,
    Validade DATE,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id)
);

-- Criação da tabela de associação entre Fornecedores e Produtos
CREATE TABLE FORNECEDOR_PRODUTO (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Fornecedor_Id INT,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id),
    FOREIGN KEY (Fornecedor_Id) REFERENCES FORNECEDOR(Id)
);


### Configuração do Projeto
Pré-Requisitos: 
• Instalação do Java JDK; </br>
• SQLite Studio; </br>

Instalação e Execução: Um passo a passo detalhando como clonar o repositório, configurar o ambiente e executar o projeto.</br>

### Uso
• Uma explicação de como usar o sistema uma vez que esteja em funcionamento, descrevendo as operações de CRUD e outras funcionalidades. </br>

### Contribuições
• Diretrizes sobre como contribuir para o projeto, incluindo como fazer fork, criar branches, fazer commits, e abrir Pull Requests. </br>

A implementação deste projeto será realizada em fases, começando com o design do banco de dados, seguido pela integração com os sistemas existentes da EletroTech, e finalmente, a implantação e o treinamento dos funcionários para o uso eficiente do sistema.
Este projeto é um passo crucial para a EletroTech no caminho para uma gestão de estoque mais inteligente e eficiente, capacitando a
empresa a atender melhor seus clientes e a se adaptar dinamicamente às mudanças do mercado.

### Licença
• Informações sobre a licença sob a qual o projeto é distribuído, geralmente a licença MIT para projetos de código aberto. </br>

### Contato
• Detalhes de contato do autor ou mantenedor do projeto, incluindo nome, e-mail, e link para o repositório do projeto no GitHub. Esta estrutura fornece um guia claro para criar um README informativo e eficaz para o projeto do Sistema de Gestão de Estoque EletroTech, facilitando para os usuários entenderem rapidamente o propósito do projeto e como ele pode ser configurado e utilizado. </br>
