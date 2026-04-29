package entities;
import entities.enums.Status;

public class Tarefa {
	
	private int id;
	private String titulo;
	private Status status;
	
	public Tarefa(){
	}
	
	public Tarefa(int id, String titulo, Status status) {
		this.id = id;
		this.titulo = titulo;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[" + id + "] " + titulo + " - " + status;
	}
	
}
