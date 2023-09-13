import java.util.ArrayList;

public class Professor extends Usuario{

    public Professor(String nome, int idade, String endereco) {
        super(nome, idade, endereco);
    }

    private Disciplina disciplina;
    private ArrayList<Turma> turmas = new ArrayList<Turma>();
    private ArrayList<Prova> provas = new ArrayList<Prova>();

    public void calculoDeMedia(){
        for (Turma turma:
             turmas) {

            System.out.println("Turma: " + turmas.indexOf(turma)+1);

            for (Aluno aluno:
                 turma.getAlunos()) {

                aluno.calculoDeMediaPorDisciplina(this.disciplina);

            }
        }
    }

    public void addProva(Prova prova){
        this.provas.add(prova);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        turmas = turmas;
    }

    public ArrayList<Prova> getProvas() {
        return provas;
    }

    public void setProvas(ArrayList<Prova> provas) {
        provas = provas;
    }
}
