package services;

import dao.TaskDAO;
import entities.Task;
import entities.enums.Status;
import java.util.List;

public class Service {

    private TaskDAO dao = new TaskDAO();

    public void createTask(String title) 
    {
        Task task = new Task(0, title, Status.NOT_STARTED);
        dao.insert(task);
    }

    public void listTasks()
    {
        List<Task> tasks = dao.findAll();

        int quantComp = 0,
            quantPend = 0, 
            quantNSta = 0;

        for (Task t : tasks) 
        {
            System.out.println(t);

            switch (t.getStatus()) 
            {
                case NOT_STARTED: quantNSta++;
                break;
            
                case PENDING: quantPend++;
                break;
            
                case COMPLETED: quantComp++;
                break;
            }
        }

        System.out.println("\nTotal: " + tasks.size());
        System.out.println("Completed: " + quantComp);
        System.out.println("Pending: " + quantPend);
        System.out.println("Not started: " + quantNSta + "\n");
    }

    public Task findById(int id) {
        	return dao.findByID(id);
    }

    public boolean updateTitle(int id, String newTitle) 
    {
        Task task = dao.findByID(id);

        if (task == null) 
        	return false;

        if (newTitle.isEmpty()) 
        	return false;

        task.setTitle(newTitle);
        dao.update(task);	
        return true;
    }

    public boolean updateStatus(int id, Status status) 
    {
        Task task = dao.findByID(id);

        if (task == null) 
        	return false;

        task.setStatus(status);
        dao.update(task);
        return true;
    }

    public boolean deleteTask(int id) 
    {
        Task task = dao.findByID(id);

        if (task == null) 
        	return false;

        dao.delete(id);
        return true;
    }
}