package application;

import java.util.Scanner;

import entities.Tarefa;
import entities.enums.Status;
import services.Servico;

public class Program 
{
	public static void main (String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		int escolha = 5, id = 1;
		char resp;
		
		Servico servico = new Servico();
		
		System.out.println("Sistema de Tarefas iniciado  \n");
		while (escolha != 0) 
		{
			
			System.out.println("Ações disponíveis ->");
			System.out.println("1 - Criar tarefa \n2 - Listar tarefa \n3 - Atualizar tarefa \n4 - Deletar tarefa \n0 - Sair\n");
			System.out.print("Digite um valor para realizar a determinada ação: ");
			escolha = sc.nextInt();
			System.out.println();
			
			switch (escolha) 
			{
				case 1 :
					
					System.out.print("Digite o título da tarefa: ");
					sc.nextLine();
					String titulo = sc.nextLine().trim();

					while (titulo.isEmpty()) 
					{
					    System.out.print("Título inválido! Digite novamente: ");
					    titulo = sc.nextLine().trim();
					}

					servico.criarTarefa(titulo);
					break;
			
				case 2 :
					
					servico.listarTarefas();
					break;
				
				case 3 :
					
					System.out.println("Digite o ID da ta tarefa: ");
					int idDigitado = sc.nextInt();

					Tarefa t = servico.buscarPorId(idDigitado);

					if (t == null) 
					{
					    System.out.println("Tarefa não encontrada!");
					} 
					else 
					{
					    System.out.println("Tarefa encontrada:");
					    System.out.println(t);

					    System.out.print("Deseja alterar o título? (s/n): ");
					    resp = sc.next().charAt(0);

					    if (resp == 's') 
					    {
					        sc.nextLine();
					        System.out.print("Digite o novo título: ");
					        titulo = sc.nextLine().trim();

					        while (titulo.isEmpty()) 
					        {
					            System.out.print("Título inválido! Digite novamente: ");
					            titulo = sc.nextLine().trim();
					        }

					        servico.atualizarTitulo(idDigitado, titulo);
					    }
					    
					    System.out.print("Deseja alterar o status? (s/n): ");
					    resp = sc.next().charAt(0);
					    
					    if (resp == 's') 
					    {
					    	System.out.println("Opções disponíveis: ");
					        System.out.println("1 - NÃO INICIADA");
					        System.out.println("2 - PENDENTE");
					        System.out.println("3 - CONCLUÍDA");
					    	System.out.print("Digite o número da opção desejada: ");

					        int opcaoStatus = sc.nextInt();
					        
					        Status novoStatus = null;

					        switch (opcaoStatus) 
					        {
					            case 1:
					                novoStatus = Status.NAO_INICIADA;
					                break;
					            case 2:
					                novoStatus = Status.PENDENTE;
					                break;
					            case 3:
					                novoStatus = Status.CONCLUIDA;
					                break;
					            default:
					                System.out.println("Opção inválida!");					   
					        }
					        
					        if (novoStatus != null) {
					            servico.atualizarStatus(idDigitado, novoStatus);
					        }
					    }
					}
					break;
					
				case 4 :
					
					System.out.print("Digite o ID da tarefa: ");
					id = sc.nextInt();

					t = servico.buscarPorId(id);

					if (t == null) {
					    System.out.println("Tarefa não encontrada!");
					} else {
					    System.out.println("Tarefa encontrada:");
					    System.out.println(t);

					    System.out.print("Tem certeza? (s/n): ");
					    resp = sc.next().charAt(0);

					    if (resp == 's') {
					        servico.deletarTarefa(id);
					        System.out.println("Tarefa deletada!");
					    }
					}
					break;
					
				case 0 :
					
					System.out.print("Saindo...");
					break;
				
				default:
					System.out.println("Opção inválida!");
			}
		}
		
		System.out.println("\nPrograma encerrado");
		
		sc.close();
	}
}
