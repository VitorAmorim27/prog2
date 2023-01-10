import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password;
    private String nome;
    private int horasDiarias;
    private Tipo tipo;

    public User(){

    }
    public User(String username, String password, String nome, int horasDiarias, Tipo tipo) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.horasDiarias = horasDiarias;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasDiarias() {
        return horasDiarias;
    }

    public void setHorasDiarias(int horasDiarias) {
        this.horasDiarias = horasDiarias;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
