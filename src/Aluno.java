import java.util.ArrayList;

public class Aluno extends Usuario{

    public Aluno(String nome, int idade, String endereco) {
        super(nome, idade, endereco);
    }

    private ArrayList<Turma> turmas = new ArrayList<Turma>();
    private ArrayList<Prova> provas = new ArrayList<Prova>();

    public void calculoDeMediaPorDisciplina(Disciplina disciplina){

        for (Turma turma:
             this.turmas) {
            for (Professor professor:
                    turma.getProfessores()) {
                if (disciplina.equals(professor.getDisciplina())) {
                    int quantidadeDeProvas = 0;
                    double somaDasNotas = 0;
                    for (Prova prova:
                            this.provas) {
                        if (prova.getDisciplina().equals(professor.getDisciplina())){
                            quantidadeDeProvas++;
                            somaDasNotas += prova.getNota();
                        }
                    }
                    System.out.println("A média do aluno " + this.getNome() + " na disciplina " + professor.getDisciplina().getNome() + " é " + somaDasNotas/quantidadeDeProvas);

                }
            }
        }
    };

    public void calculoDeMedia(){

        for (Turma turma:
                this.turmas) {
            for (Professor professor:
                    turma.getProfessores()) {
                int quantidadeDeProvas = 0;
                double somaDasNotas = 0;
                for (Prova prova:
                        this.provas) {
                    if (prova.getDisciplina().equals(professor.getDisciplina())){
                        quantidadeDeProvas++;
                        somaDasNotas += prova.getNota();
                    }
                }
                System.out.println("A média do aluno " + this.getNome() + " na disciplina " + professor.getDisciplina().getNome() + " é " + somaDasNotas/quantidadeDeProvas);
            }
        }
    };

    public void addProva(Prova prova){
        this.provas.add(prova);
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
