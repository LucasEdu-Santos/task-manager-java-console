package dao;

import db.Connector;
import entities.Task;
import entities.enums.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO 
{

    public void insert(Task task) // criar tasks na tabela
    {
        String sql = "INSERT INTO tasks (title, status) VALUES (?, ?)";

        try (Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setString(1, task.getTitle());
                stmt.setString(2, task.getStatus().name());
                
                stmt.executeUpdate();
                System.out.println("Task created successfully!");
            }
        catch (SQLException e) {
            System.out.println("Error creating task: " + e.getMessage());
        }
    }

    public List<Task> findAll() // lista todas as tasks no console
    {
        String sql = "SELECT * FROM tasks";
        List<Task> list = new ArrayList<>();

        try (Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while (rs.next())
                {
                    Task task = new Task (rs.getInt("id"),
                    rs.getString("title"),
                    Status.valueOf(rs.getString("status"))
                    );
                    list.add(task);
                }
        } catch (SQLException e) {
            System.out.println("Error fetching tasks: " + e.getMessage());
        }
        return list;
    }

    public void update(Task task) // atualiza uma task selecionada
    {
        String sql = "UPDATE tasks SET title = ?, status = ? WHERE id = ?";

        try (Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
            {
                stmt.setString(1, task.getTitle());
                stmt.setString(2, task.getStatus().name());
                stmt.setInt(3, task.getId());

                stmt.executeUpdate();
                System.out.println("Task updated successfully!");
            }
            catch (SQLException e) {
                System.out.println("Error updating task: " + e.getMessage());
            }
    }

    public void delete(int id) // deleta uma task 
    {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Task deleted successfully!");
            }
        catch (SQLException e) {
            System.out.println("Error deleting tasks: " + e.getMessage());
        }
    }

    public Task findByID (int id) // pesquisar por ID
    {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        Task task = null;

        try (Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next()) 
                    {
                    task = new Task(rs.getInt("id"),
                                rs.getString("title"),
                                Status.valueOf(rs.getString("status")));
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error fetching task: " +  e.getMessage());
        }

        return task;
    }
}
