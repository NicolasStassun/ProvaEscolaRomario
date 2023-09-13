import java.util.ArrayList;

public class Usuario {

    private String nome;
    private int idade;
    private String endereco;
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        cadastrarUsuario(this);
    }

    public void cadastrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
