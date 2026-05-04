package application;

import entities.Task;
import entities.enums.Status;
import java.util.Scanner;
import services.Service;

public class Program 
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int choice = 5, id = 1;
		char answer;
		
		Service service = new Service();
		
		System.out.println("Task manager started  \n");
		while (choice != 0) 
		{
			
			System.out.println("Available actions ->");
			System.out.println("1 - Create task \n2 - List tasks \n3 - Update task \n4 - Delete task \n0 - Exit\n");
			System.out.print("Enter a value to perform an action: ");
			choice = sc.nextInt();
			System.out.println();
			
			switch (choice) 
			{
				case 1 :
					
					System.out.print("Enter the task's title: ");
					sc.nextLine();
					String title = sc.nextLine().trim();

					while (title.isEmpty()) 
					{
					    System.out.print("Invalid title! Try again: ");
					    title = sc.nextLine().trim();
					}

					service.createTask(title);
					break;
			
				case 2 :
					
					service.listTasks();
					break;
				
				case 3 :
					
					System.out.println("Enter the task ID : ");
					int typedID = sc.nextInt();

					Task t = service.findById(typedID);

					if (t == null) 
					{
					    System.out.println("Task not found!");
					} 
					else 
					{
					    System.out.println("Task found:");
					    System.out.println(t);

					    System.out.print("Do you want to change the title? (y/n): ");
					    answer = sc.next().charAt(0);

					    if (answer == 'y') 
					    {
					        sc.nextLine();
					        System.out.print("Enter new title: ");
					        title = sc.nextLine().trim();

					        while (title.isEmpty()) 
					        {
					            System.out.print("Invalid title! Try again: ");
					            title = sc.nextLine().trim();
					        }

					        service.updateTitle(typedID, title);
					    }
					    
					    System.out.print("Do you want to change the status? (y/n): ");
					    answer = sc.next().charAt(0);
					    
					    if (answer == 'y') 
					    {
					    	System.out.println("Available options: ");
					        System.out.println("1 - NOT STARTED");
					        System.out.println("2 - PENDING");
					        System.out.println("3 - COMPLETED");
					    	System.out.print("Enter the number of the desired option: ");

					        int statusOption = sc.nextInt();
					        
					        Status newStatus = null;

					        switch (statusOption) 
					        {
					            case 1:
					                newStatus = Status.NOT_STARTED;
					                break;
					            case 2:
					                newStatus = Status.PENDING;
					                break;
					            case 3:
					                newStatus = Status.COMPLETED;
					                break;
					            default:
					                System.out.println("Invalid option!");					   
					        }
					        
					        if (newStatus != null) {
					            service.updateStatus(typedID, newStatus);
					        }
					    }
					}
					break;
					
				case 4 :
					
					System.out.print("Enter the task ID: ");
					id = sc.nextInt();

					t = service.findById(id);

					if (t == null) {
					    System.out.println("Task not found!");
					} else {
					    System.out.println("Tasks found:");
					    System.out.println(t);

					    System.out.print("Are you sure? (y/n): ");
					    answer = sc.next().charAt(0);

					    if (answer == 'y') {
					        service.deleteTask(id);
					        System.out.println("Task deleted!");
					    }
					}
					break;
					
				case 0 :
					
					System.out.print("Exiting...");
					break;
				
				default:
					System.out.println("Invalid option!");
			}
		}
		
		System.out.println("\nProgram closed.");
		
		sc.close();
	}
}
