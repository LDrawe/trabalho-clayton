
# Trabalho de Dados Climáticos
### Exercício avaliativo - Projetos de Sistemas de Software - COM10508
> Atividade para complemento de nota e aprendizado usando padrões de projeto - 2024-1
>
> Professor orientador: Clayton Vieira Fraga Filho
>
> Dupla: Talles Henrique Teófilo dos Santos & Eduardo de Mello Portilho

Este projeto é um aplicativo para gerenciamento de dados climáticos, desenvolvido em Java usando o padrão de arquitetura MVP (Model-View-Presenter). O sistema permite a inserção, visualização e remoção de dados de temperatura, umidade, pressão e data, além de oferecer funcionalidades de log em formatos JSON e XML.

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

- **Model**: Contém as classes de modelo que representam os dados do sistema.
- **View**: Contém as classes de interface gráfica para interação com o usuário.
- **Presenter**: Contém as classes que mediam a comunicação entre a View e o Model, implementando a lógica de negócio.
- **Log**: Contém as classes responsáveis por registrar as operações realizadas no sistema em arquivos de log.

## Funcionalidades

1. **Inserção de Dados Climáticos**: Permite inserir dados de temperatura, umidade, pressão e data.
2. **Visualização de Dados**: Permite visualizar os dados inseridos em uma tabela.
3. **Visualização da Média dos Dados**: Permite visualizar a média de todos dados inseridos no tempo de execução.
4. **Visualização de Máximas e Mínimas**: Permite visualizar em um gráfico os maiores e menores dados inseridos.
5. **Visualização da Última Inserção**: É possível acompanhar o último dado inserido e quantos dados tem inseridos atualmente.
6. **Remoção de Dados**: Permite remover dados específicos.
7. **Configuração de Log**: Permite selecionar o formato do log (JSON ou XML) e salvar as operações em arquivos específicos.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada.
- **Swing**: Biblioteca para a criação da interface gráfica.
- **Gson**: Biblioteca para serialização e desserialização de JSON.
- **JAXB**: Biblioteca para serialização e desserialização de XML.
- **JFreeChart**: Biblioteca para inserção do gráfico.

## Protótipo Inicial

![image](https://github.com/user-attachments/assets/8fa8e1b2-3a47-4829-87d1-3587e8d28459)

## Entrega Final

![image](https://github.com/user-attachments/assets/b84aef75-5ba0-45fc-95ca-8049a8655128)

## Como Executar

1. **Clonar o Repositório**

   ```bash
   git clone https://github.com/LDrawe/trabalho-clayton.git
   cd trabalho-clayton
   ```

2. **Compilar o Projeto**

   Certifique-se de ter o Maven instalado. Para compilar o projeto, execute:

   ```bash
   mvn clean compile
   ```

3. **Executar o Projeto**

   ```bash
   mvn exec:java -Dexec.mainClass="com.ufes.trabalhodadosclima.Main"
   ```

## Configuração de Log

O sistema permite que você selecione o formato do log (JSON ou XML) através de uma interface gráfica. Para isso:

1. Acesse a tela de configurações.
2. Selecione o formato desejado no combo box.
3. Salve as configurações.

Os arquivos de log serão salvos no diretório raiz do projeto com os nomes `dados_climaticos.json` ou `dados_climaticos.xml`.

## Contribuição

Contribuições são bem-vindas! Se você encontrar problemas ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto é licenciado sob os termos da licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

## Contato

Para mais informações, entre em contato com os desenvolvedores: [talles0h@gmail.com](mailto:talles0h@gmail.com) [eduardo.portilho@edu.ufes.br](mailto:eduardo.portilho@edu.ufes.br)
