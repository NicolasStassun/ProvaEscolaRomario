import java.util.ArrayList;

public class Secretario extends Usuario{

    public Secretario(String nome, int idade, String endereco) {
        super(nome, idade, endereco);
    }

    private int quantidadeDeBoletinsGerados;

    public void criaTurma(ArrayList<Aluno> alunos, ArrayList<Professor> professores){
        Turma turma = new Turma(alunos,professores);
            for (Aluno aluno :
                    turma.getAlunos()) {
                aluno.getTurmas().add(turma);
            }
            for (Professor professor :
                    turma.getProfessores()) {
                professor.getTurmas().add(turma);
            }
    }

    public void gerarBoletins(Turma turma){

        for (Aluno aluno:
                turma.getAlunos()) {
            aluno.calculoDeMedia();
            this.quantidadeDeBoletinsGerados++;
        }

    }

    public void atribuirDisciplinas(Professor professor, Disciplina disciplina){
        professor.setDisciplina(disciplina);
    }

    public int getQuantidadeDeBoletinsGerados() {
        return quantidadeDeBoletinsGerados;
    }

    public void setQuantidadeDeBoletinsGerados(int quantidadeDeBoletinsGerados) {
        this.quantidadeDeBoletinsGerados = quantidadeDeBoletinsGerados;
    }
}
