package meu.projeto;
import java.util.Scanner;

public class ProjetoAgenda {
	
	//variaveis e objetos publicos:
	public static Scanner entrada = new Scanner(System.in);
	public static String agenda[][] = new String[10][3];
	
	/*
	 * Descrição....: Este procedimento limpa a matriz
	 * Nome.........: limpar_matriz(String matriz)
	 * Tipo.........: void
	*/
	public static void limparMatriz(String matriz[][])
	{
		// Insere vazio em todas as células da matriz
		for(int l = 0; l < 10; l++)
		{
			for(int c = 0; c < 3; c++)
			{
				matriz[l][c] = "";
			}
		}
	}
	
	public static int linhaVaziaNaAgenda(String matriz[][]) {
		for (int l = 0; l < 10; l++) {
			if (matriz[l][0].equals("")) {
				//caso tenha encontrado retorna o numero da linha que esta vazia:
				return l;
			}
		}
		// -1 representa a matriz esta cheia:
		return -1;
	}
	
	public static void novoContato(String matriz[][], int l) {
		System.out.println("--------PREENCHA O NOVO CONTATO: ");
		System.out.print("Nome: ");
		matriz[l][0] = entrada.next();
		System.out.print("Celular: ");
		matriz[l][1] = entrada.next();
		System.out.print("E-mail: ");
		matriz[l][2] = entrada.next();
	}
	
	public static int pesquisarContato(String matriz[][] ,String nome) {
		for (int l = 0; l < 10; l++) {
			if (matriz[l][0].equalsIgnoreCase(nome)) {
				return l;
			}
		}
		return -1;
	}
	
	public static void exibirContato(String matriz[][] ,int l) {
		System.out.println("--------------EXIBIR CONTATO: ");
		System.out.println("Nome: " + matriz[l][0]);
		System.out.println("Celular: " + matriz[l][1]);
		System.out.println("E-mail: " + matriz[l][2]);
	}
	
	public static void editarContato(String matriz[][], int l) {
		System.out.println("------------EDITE O CONTATO: ");
		System.out.println("Nome: " + matriz[l][0]);
		System.out.print("Novo celular: ");
		matriz[l][1] = entrada.next();
		System.out.print("Novo e-mail: ");
		matriz[l][2] = entrada.next();
		System.out.println("Contato editado com sucesso!");
	}
	
	public static void listarContatos(String matriz[][]) {
		for (int l = 0; l < 10; l++) {
			if (matriz[l][0] != "") {
				exibirContato(matriz, l);
				System.out.print("----------------------------------");
			}
		}
		System.out.print("--------------FIM DA AGENDA!");
	}
	
	public static void excluirContato(String matriz[][] ,String nome) {
		int linha = pesquisarContato(matriz, nome);
		
		if (linha == -1) {
			System.out.print("Contato nao encontrado.");
		} else {
			exibirContato(agenda, linha);
			
			System.out.print("Para excluir " + nome + " digite [S]im ou [N]ao: ");
			String resposta = entrada.next();
			
			if (resposta.equalsIgnoreCase("s")) {
				matriz[linha][0] = "";
				matriz[linha][1] = "";
				matriz[linha][2] = "";
				System.out.println("Contato excluido com sucesso!");
				
			} else {
				System.out.print("Exclusao cancelada!");
			}
		}
	}
	
	public static void exibirMenu() {
		System.out.println("********** M E N U **********");
		System.out.println("1 - Adicionar novo contato");
		System.out.println("2 - Editar contato");
		System.out.println("3 - Pesquisar contado");
		System.out.println("4 - Listar contatos");
		System.out.println("5 - Apagar um contato");
		System.out.println("6 - Sair");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao, linha;
		String nome;
		
		//ao iniciar o sistema sempre é bom limpar a matriz antes:
		limparMatriz(agenda);
		
		do {
			exibirMenu();
			
			// colher a opcao do usuario:
			System.out.print("Escolha uma opçao: ");
			opcao = entrada.nextInt();
			System.out.println();
			
			switch(opcao) {
			
			case 1:
				//adicionar novo contato
				novoContato(agenda, linhaVaziaNaAgenda(agenda));
				break;
			
			case 2:
				//Editar contato
				System.out.println("----------EDITAR UM CONTATO: ");
				System.out.println("Digite o nome: ");
				nome = entrada.next();
				linha = pesquisarContato(agenda, nome);
				
				if (linha == -1) {
					System.out.print("Contato nao encontrado.");
				} else {
					exibirContato(agenda, linha);
					editarContato(agenda, linha);
				}
				break;
				
			case 3:
				//pesquisar contato:
				System.out.println("--------------PESQUISAR CONTATO: ");
				System.out.println("Digite o nome: ");
				nome = entrada.next();
				linha = pesquisarContato(agenda, nome);
				
				if (linha == -1) {
					System.out.print("Contato nao encontrado.");
				} else {
					exibirContato(agenda, linha);
				}
				break;
				
			case 4:
				//Listar todos os contatos:
				System.out.println("---------------LISTAR CONTATOS: ");
				listarContatos(agenda);
				break;
				
			case 5:
				//Apagar um contato: 
				System.out.println("---------------EXCLUIR CONTATO: ");
				System.out.println("Digite o nome: ");
				nome = entrada.next();
				excluirContato(agenda, nome);
				break;
				
			case 6:
				System.out.println("OBRIGADO POR UTILIZAR A NOSSA AGENDA :)");
			}
			System.out.println();
		} while (opcao != 6);

	}

}
