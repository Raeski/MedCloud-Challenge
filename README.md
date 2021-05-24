# MedCloud Challenge

## SOBRE O PROJETO

Criar um sistema em Java onde seja possível cadastrar pacientes, gerar arquivo XML, e gravar os dados em diferentes bancos de dados.

Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* MySQL
* JpaTest

## Instalação

### Pré requisitos

* Mysql ( Para gravar os dados ) 

* Alguma IDE que rode Java como Eclipse, Intellij... 

### Instalação

1. Pegue o link do repositório https://github.com/Raeski/MedCloud-Challenge
2. Clone o repo
   ```sh
   git clone https://github.com/Raeski/MedCloud-Challenge
   ```
3. Abra o projeto em sua IDE de prefêrencia

4. Configure o arquivo application.properties alterando o user e password (Utilize o seu usuário e senha do Mysql), quando o projeto for executado o Hiberante se encarregará de criar a tabela e suas colunas no banco de dados

5. Como padrão o arquivo xml será salvo na pasta "C:\MedCloud" (O programa se encarregara de criar a pasta caso ela não exista), caso prefira, pode ser alterado dentro do arquivo XmlService.

5. Na IDE execute o arquivo DesafioApplication

6. Após executar o main da aplicação, será solicitado no console para escolher as opções a baixo: 

```
    Quer cadastrar um paciente? Digite: 1 
    Quer consultar um paciente? Digite: 2 
    Deseja salvar uma coleção de pacientes? Digite: 3
    Para encerrar o programa digite: 4
 ```

   ```
    Caso escolha a 1° opção: Será solicitado a você novamente pelo console os dados dos pacientes, e em seguida o arquivo xml será gravado na pasta "C:\MedCloud" 
(O nome do arquivo será setado com o nome do paciente), os dados do paciente será gravado na base de dados chamada medcloud, e o nome com o timestamp será
cadastrado na base de dados medcloud2. 
    
    Caso escolha a 2° opção: Será solicitado a você novamente pelo console o nome do paciente, caso esse paciente seja encontrado ele retornara os dados dos pacientes,
caso contrário será retornado uma mensagem de erro "PATIENT NOT FOUND".
    
    Caso escolha a 3° opção: Para facilitar os pacientes já estão criados dentro da aplicação, apenas será solicitado a você o nome do arquivo xml em que será salvo
os dados dos pacientes. Os dados dos pacientes seram gravados na base de dados chamada medcloud, e o nome com o timestamp de cada um será cadastrado na base de 
dados medcloud2.
    
   ```

<!-- CONTACT -->
## Contato


<p>Feito por <b>Gustavo Raeski</b>  :octocat: | - gustavoraeski@outlook.com

<a href="https://www.linkedin.com/in/gustavo-raeski/">Entre em contato</a></p>
