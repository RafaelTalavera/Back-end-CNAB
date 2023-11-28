# Back-end-CNAB
Processamento de Arquivo CNAB com Spring Batch


Este projeto faz parte de um sistema que lida com arquivos CNAB (Comprovante Nacional de Arquivos Bancários) em um ambiente de back-end usando tecnologias Spring e Spring Batch.

## Principais Funcionalidades
1. Upload de Arquivos CNAB
O controlador CnabController gerencia o upload de arquivos CNAB. Ele usa um endpoint POST para processar e armazenar as informações do arquivo CNAB.

### Exemplo de Uso:
bash
Copy code
curl -X POST -F "file=@caminho/do/arquivo.cnab" http://localhost:porta/cnab/upload
2. Consulta de Transações
O controlador TransacaoController permite consultar totais de transações por nome da loja. Ele usa um endpoint GET para obter as informações.

### Exemplo de Uso:
bash
Copy code
curl http://localhost:porta/transacoes
Estrutura do Projeto
O projeto está organizado em vários pacotes que contêm controladores, entidades, configurações de lote (batch), serviços e mais. Abaixo, são descritos brevemente alguns dos pacotes e arquivos-chave:

controllers: Contém controladores que lidam com as solicitações HTTP.
entity: Contém as entidades que representam os dados do domínio.
job: Configuração para o trabalho em lote usando o Spring Batch.
repository: Repositório de dados para acessar o banco de dados.
service: Serviços para a lógica de negócios.

## Configuração
O projeto utiliza um arquivo application.properties para configurar propriedades como a URL do banco de dados, o diretório de upload de arquivos e mais.

Requisitos do Sistema
Java 8 ou superior
Banco de dados PostgreSQL
...
## Configuração do Desenvolvimento
Clonar este repositório.
Configurar o banco de dados e outros parâmetros no application.properties.
Executar a aplicação.
bash
Copy code
./mvnw spring-boot:run
## Contribuições
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver melhorias, por favor, abra um problema ou envie uma solicitação de pull.
