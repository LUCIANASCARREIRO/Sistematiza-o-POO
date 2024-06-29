# SistematizacaoPOO

Sistema de Gerenciamento de Funcionários

Visão Geral

O Sistema de Gerenciamento de Funcionários é uma solução abrangente projetada para gerenciar dados de funcionários em uma empresa. Além das funcionalidades básicas de adição e busca de funcionários, o sistema se destaca ao permitir a inclusão de informações médicas críticas para funcionários, garantindo que as empresas estejam preparadas para responder rapidamente em situações de emergência.

Benefícios para a Empresa

- Melhor Preparação para Emergências: Com informações médicas acessíveis, a empresa pode responder de forma mais eficaz a emergências médicas.
- Cumprimento de Normas de Segurança: A manutenção de registros médicos pode ajudar a empresa a cumprir regulamentos e normas de segurança no trabalho.
- Maior Cuidado com os Funcionários: Demonstrar preocupação com a saúde e o bem-estar dos funcionários pode melhorar a moral e a retenção de talentos.

Funcionalidades Principais

1. Adição de Funcionários:
   - Permite adicionar novos funcionários com informações básicas (ID e nome).
   
2. Busca de Funcionários:
   - Permite buscar funcionários por ID para visualizar suas informações.
   
3. Adição de Funcionários Saudáveis:
   - Permite adicionar informações médicas adicionais (alergias, problemas médicos, contato de emergência).

Conceitos Utilizados

Herança

O conceito de herança é utilizado para criar uma hierarquia de classes. No projeto, temos a classe `Funcionario`, que é a classe base, e a classe `FuncionarioSaudavel`, que herda de `Funcionario`. A herança permite que `FuncionarioSaudavel` utilize todos os atributos e métodos da classe `Funcionario`, além de adicionar atributos e métodos específicos.

public class Funcionario implements Serializable {
    // Atributos e métodos da classe Funcionario
}

public class FuncionarioSaudavel extends Funcionario {
    // Atributos e métodos adicionais da classe FuncionarioSaudavel
}

Polimorfismo

O polimorfismo é utilizado para tratar objetos de diferentes classes de maneira uniforme. No nosso sistema, a lista funcionarios pode conter objetos tanto da classe Funcionario quanto da classe FuncionarioSaudavel. Isso é possível porque FuncionarioSaudavel herda de Funcionario.

List<Funcionario> funcionarios = new ArrayList<>();
funcionarios.add(new Funcionario(1, "João"));
funcionarios.add(new FuncionarioSaudavel(2, "Maria", "Nenhuma", "Nenhum", "(61) 98765-4321", "maria@empresa.com"));

Listas

As listas são utilizadas para armazenar e gerenciar a coleção de funcionários. A classe ArrayList é usada para implementar a lista de funcionários, permitindo adicionar, buscar e listar funcionários de forma eficiente.
private List<Funcionario> funcionarios;

public SistemaGerenciamento() {
    this.funcionarios = new ArrayList<>();
}

Persistência dos Dados

Para garantir que os dados dos funcionários sejam mantidos mesmo após o fechamento do programa, utilizamos a serialização. Os dados são salvos em um arquivo (funcionarios.dat) e carregados na inicialização do sistema. Isso garante que nenhuma informação seja perdida entre execuções.
public static void salvarListaFuncionarios(String filePath, List<Funcionario> listaFuncionarios) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        oos.writeObject(listaFuncionarios);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static List<Funcionario> carregarListaFuncionarios(String filePath) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
        return (List<Funcionario>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        return null;
    }
}

Instalação

Pré-requisitos

•	Java Development Kit (JDK) 8 ou superior
•	Um editor de texto ou IDE como IntelliJ IDEA ou Eclipse
Passos para Instalação
1.	Clone o repositório:
git clone https://github.com/usuario/sistema-gerenciamento-funcionarios.git
2.	Navegue até o diretório do projeto:
cd sistema-gerenciamento-funcionarios
3.	Compile o projeto:
javac -d bin src/mgs/*.java
4.	Execute o projeto:
java -cp bin mgs.SistemaGerenciamento

Uso

Menu Principal

•	1. Adicionar Funcionário:
o	Insira o ID e o nome do funcionário quando solicitado.
•	2. Buscar Funcionário por ID:
o	Insira o ID do funcionário para buscar suas informações.
•	3. Adicionar Funcionário Saudável:
o	Insira o ID, nome, alergias, problemas médicos, telefone de contato e email de contato do funcionário quando solicitado.
•	4. Sair:
o	Salva a lista de funcionários em um arquivo e encerra o programa.

Fluxo de Trabalho

1.	Adicionar um Funcionário Saudável:
o	Selecione a opção "3. Adicionar Funcionário Saudável".
o	Insira as informações solicitadas: ID, nome, alergias, problemas médicos, telefone de contato e email de contato.
2.	Buscar Funcionário por ID:
o	Selecione a opção "2. Buscar Funcionário por ID".
o	Insira o ID do funcionário para visualizar suas informações completas, incluindo dados médicos se disponíveis.
3.	Salvar e Sair:
o	Ao selecionar "4. Sair", todas as informações são salvas em um arquivo, garantindo que nenhum dado seja perdido.

Exemplo de Uso
1. Adicionar Funcionário
2. Buscar Funcionário por ID
3. Adicionar Funcionário Saudável
4. Sair
Escolha uma opção: 3

ID: 101
Nome: João Silva
Alergias: Nenhuma
Problemas Médicos: Nenhum
Telefone de Contato: (61) 98765-4321
Email de Contato: joao.silva@empresa.com

Funcionário Saudável adicionado com sucesso!

Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:
1.	Faça um fork do projeto.
2.	Crie uma branch para sua funcionalidade (git checkout -b feature/nova-funcionalidade).
3.	Faça commit das suas alterações (git commit -m 'Adiciona nova funcionalidade').
4.	Faça push para a branch (git push origin feature/nova-funcionalidade).
5.	Abra um Pull Request.
	
Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.

Contatos

Para obter ajuda ou fazer perguntas, você pode entrar em contato comigo em:
•	Email: Luciana.carreiro@sempreceub.com
•	LinkedIn: LucianaCarreiro

Notas Adicionais

•	Segurança de Dados: Todas as informações dos funcionários são armazenadas de forma segura e podem ser facilmente acessadas ou atualizadas conforme necessário.
•	Flexibilidade: O sistema pode ser facilmente integrado com outras ferramentas e sistemas usados pela empresa.
•	Escalabilidade: Pode ser ampliado para incluir mais funcionalidades conforme as necessidades da empresa crescem.
Se você tiver alguma dúvida ou encontrar problemas, por favor, abra uma issue no repositório.
Este README fornece uma visão mais detalhada do projeto, destacando conceitos importantes como polimorfismo, herança, listas e persistência dos dados, 
além de enfatizar os benefícios do sistema para uma empresa que precisa gerenciar informações médicas de seus funcionários.
