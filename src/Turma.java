import java.util.ArrayList;

public class Turma {

    public static ArrayList<Turma> turmas = new ArrayList<Turma>();
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private ArrayList<Professor> professores = new ArrayList<Professor>();

    public Turma(ArrayList<Aluno> alunos, ArrayList<Professor> professores) {
        this.alunos = alunos;
        this.professores = professores;
        this.turmas.add(this);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public void addAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void addProfessores(Professor professor) {
        this.professores.add(professor);
    }
}
