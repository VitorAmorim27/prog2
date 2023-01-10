import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Projeto implements Serializable {
    private String nome;
    private String nomeCliente;
    private double preçoHora;
    private Tarefa tarefas;
    private User users;
    private List<Projeto> projetos;

    public Projeto() {
        projetos = new ArrayList<Projeto>();
    }

    public Projeto(String nome, String nomeCliente, double preçoHora) {
        this.nome = nome;
        this.nomeCliente = nomeCliente;
        this.preçoHora = preçoHora;
        this.users = users;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getnomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getPreçoHora() {
        return preçoHora;
    }

    public void setPreçoHora(double preçoHora) {
        this.preçoHora = preçoHora;
    }

    public Tarefa getTarefas() {
        return tarefas;
    }

    public void setTarefas(Tarefa tarefas) {
        this.tarefas = tarefas;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public void addUser(ArrayList<User> user) {
            user.add(users);
        }

    public void removeUser(ArrayList<User> user) {
        user.remove(users);
    }

    public void addTarefa(ArrayList<Tarefa> tarefa) {
        tarefa.add(tarefas);
    }

    public void removeTarefa(ArrayList<Tarefa> tarefa) {
        tarefa.remove(tarefas);
    }

    public void removeTodasTarefas(ArrayList<Tarefa> tarefa) {
        tarefa.clear();
    }
}




