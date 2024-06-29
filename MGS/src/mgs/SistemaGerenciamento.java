package mgs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class SistemaGerenciamento {
    private List<Funcionario> funcionarios;
    String caminhoArquivo = "d:funcionarios.dat";

    public SistemaGerenciamento() {
        this.funcionarios = carregarListaFuncionarios(caminhoArquivo);
        if (this.funcionarios == null) {
        		this.funcionarios = new ArrayList<>();
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }
    public static void salvarListaFuncionarios(String filePath, List<Funcionario> listaFuncionarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(listaFuncionarios);
            System.out.println("Lista de funcionários salva com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Buscar Funcionário por ID");
            System.out.println("3. Adicionar Funcionário Saudável");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
            	case 1:
            		adicionarFuncionarioMenu(scanner);
            		break;
            	case 2:
            		buscarFuncionarioMenu(scanner);
            		break;
            	case 3:
            		adicionarFuncionarioSaudavelMenu(scanner);
            		break;
            	case 4:
                    System.out.println("Saindo...");
                    salvarListaFuncionarios(caminhoArquivo, funcionarios);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarFuncionarioMenu(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Funcionario funcionario = new Funcionario(id, nome);
        adicionarFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private void buscarFuncionarioMenu(Scanner scanner) {
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        Funcionario funcionario = buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
    
    private void adicionarFuncionarioSaudavelMenu(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Alergias: ");
        String alergias = scanner.nextLine();

        System.out.print("Problemas Médicos: ");
        String problemasMedicos = scanner.nextLine();

        System.out.print("Telefone de Contato: ");
        String telefoneContato = scanner.nextLine();

        System.out.print("Email de Contato: ");
        String emailContato = scanner.nextLine();

        FuncionarioSaudavel funcionario = new FuncionarioSaudavel(id, nome, alergias, problemasMedicos, telefoneContato, emailContato);
        adicionarFuncionario(funcionario);
        System.out.println("Funcionário Saudável adicionado com sucesso!");
    }
    

    public static List<Funcionario> carregarListaFuncionarios(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
    	SistemaGerenciamento sistema = new SistemaGerenciamento();
    	sistema.exibirMenu();
    }
}
