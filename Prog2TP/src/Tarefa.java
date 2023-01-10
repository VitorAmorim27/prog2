import java.io.Serializable;
import java.time.LocalDateTime;

public class Tarefa implements Serializable {
    private String nome;
    private String descricao;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String nomeProjeto;
    private double PrecoHora;
    private boolean done = false;


    public Tarefa() {
    }

    public Tarefa(String nome, String descricao, LocalDateTime startDateTime,double PrecoHora) {
        this.nome = nome;
        this.descricao = descricao;
        this.startDateTime = startDateTime;
        this.PrecoHora = PrecoHora;
    }

    public void setDone(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public double getPrecoHora() {
        return PrecoHora;
    }

    public void setPrecoHora(double precoHora) {
        PrecoHora = precoHora;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    String projeto;
    public void associarProjeto(String nomeProjeto) {
        this.projeto = nomeProjeto;
    }
}
