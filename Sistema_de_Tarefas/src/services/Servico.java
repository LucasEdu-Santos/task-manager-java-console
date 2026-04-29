package services;

import java.util.ArrayList;
import java.util.List;

import entities.Tarefa;
import entities.enums.Status;

public class Servico {

    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public void criarTarefa(String titulo) 
    {
        tarefas.add(new Tarefa(proximoId++, titulo, Status.NAO_INICIADA));
        System.out.println("\nTarefa criada com sucesso!\n");
    }

    public void listarTarefas() 
    {
        int quantConc = 0,
        	quantPend = 0, 
        	quantNIni = 0;

        for (Tarefa t : tarefas) 
        {
            System.out.println(t);

            switch (t.getStatus()) 
            {
                case NAO_INICIADA: quantNIni++;
                	break;
                case PENDENTE: quantPend++;
                	break;
                case CONCLUIDA: quantConc++;
                	break;
            }
        }

        System.out.println("\nTotal: " + tarefas.size());
        System.out.println("Concluídas: " + quantConc);
        System.out.println("Pendentes: " + quantPend);
        System.out.println("Não iniciadas: " + quantNIni + "\n");
    }

    public Tarefa buscarPorId(int id) 
    {
        for (Tarefa t : tarefas) 
        {
            if (t.getId() == id) 
            	return t;
        }
        	return null;
    }

    public boolean atualizarTitulo(int id, String novoTitulo) 
    {
        Tarefa t = buscarPorId(id);

        if (t == null) 
        	return false;

        novoTitulo = novoTitulo.trim();
        if (novoTitulo.isEmpty()) 
        	return false;

        t.setTitulo(novoTitulo);
        	return true;
    }

    public boolean atualizarStatus(int id, Status status) 
    {
        Tarefa t = buscarPorId(id);

        if (t == null) 
        	return false;

        t.setStatus(status);
        	return true;
    }

    public boolean deletarTarefa(int id) 
    {
        Tarefa t = buscarPorId(id);

        if (t == null) 
        	return false;

        tarefas.remove(t);
        	return true;
    }
}