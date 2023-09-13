import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Usuario usuarioLogado;

    public static void main(String[] args) {
        Disciplina disciplina1 = new Disciplina(3, "Programação Java", 340);
        Disciplina disciplina2 = new Disciplina(2, " Programação Orientada a Objetos", 100);
        Disciplina disciplina3 = new Disciplina(1, "Lógica de Programação", 160);

        int repeticao;
        do {
            repeticao = menuInicial();
        } while (repeticao != 3);

    }

    public static int menuInicial() {
        int opcao = 0;
        System.out.println("""
                1 - Cadastrar usuário
                2 - Login
                3 - Sair
                """);
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                int opcaoCadastro;
                do {
                    opcaoCadastro = cadastrarUsuario();
                } while (opcaoCadastro != 4);
                cadastrarUsuario();
                return opcao;
            case 2:
                boolean logado = false;
                do {
                    logado = login();
                } while (logado);
                login();
                return opcao;
            case 3:
                System.out.println("Saindo...");
                return opcao;
            default:
                System.out.println("Opção inválida");
                return opcao;
        }
    }

    public static int cadastrarUsuario() {
        int opcao = 0;
        do {
            System.out.println("""
                    1 - Aluno
                    2 - Professor
                    3 - Secretário
                    4 - Sair
                    """);

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de aluno");
                    System.out.println("Informe seu nome: ");
                    String nome = sc.next();
                    System.out.println("Informe sua idade: ");
                    int idade = sc.nextInt();
                    System.out.println("Informe seu endereço: ");
                    String endereco = sc.next();
                    Aluno aluno = new Aluno(nome, idade, endereco);
                    return opcao;
                case 2:
                    System.out.println("Cadastro de Professor");
                    System.out.println("Informe seu nome: ");
                    String nomeProfessor = sc.next();
                    System.out.println("Informe sua idade: ");
                    int idadeProfessor = sc.nextInt();
                    System.out.println("Informe seu endereço: ");
                    String enderecoProfessor = sc.next();
                    Professor professor = new Professor(nomeProfessor, idadeProfessor, enderecoProfessor);
                    return opcao;
                case 3:
                    System.out.println("Cadastro de Secretário");
                    System.out.println("Informe seu nome: ");
                    String nomeSecretario = sc.next();
                    System.out.println("Informe sua idade: ");
                    int idadeSecretario = sc.nextInt();
                    System.out.println("Informe seu endereço: ");
                    String enderecoSecretario = sc.next();
                    Secretario secretario = new Secretario(nomeSecretario, idadeSecretario, enderecoSecretario);
                    return opcao;
                case 4:
                    System.out.println("Cadastro cancelado...");
                    return opcao;
                default:
                    System.out.println("Opção inválida");
                    return opcao;
            }
        } while (opcao == 4);

    }

    public static boolean login() {
        boolean logado = false;
        do {
            System.out.println("Login");
            System.out.println("Informe seu nome para entrar: ");
            String nome = sc.next();
            for (Usuario usuario :
                    Usuario.usuarios) {
                if (usuario.getNome().equals(nome)) {
                    System.out.println("Usuário encontrado");
                    logado = true;
                    usuarioLogado = usuario;
                    menuDoUsuario(usuarioLogado);
                }
            }
            System.out.println("Usuário não encontrado");
            return logado;
        } while (logado == false);
    }

    public static void cadastraProva(Turma turma, Professor professor) {
        for (Turma turmaProfessor :
                professor.getTurmas()) {
            if (turmaProfessor == turma) {
                for (Aluno aluno :
                        turma.getAlunos()) {
                    Prova prova = new Prova();
                    prova.setDisciplina(professor.getDisciplina());
                    System.out.println("Informe a nota do aluno " + aluno.getNome() + ": ");
                    double nota = sc.nextDouble();
                    prova.setNota(nota);
                    prova.setNomeDoAluno(aluno.getNome());
                    professor.addProva(prova);
                    aluno.addProva(prova);
                }
            }
        }
    }

    public static boolean menuDoUsuario(Usuario usuario) {
        boolean logado = true;
        do {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                logado = true;

                int opcoes = 0;
                do {
                    System.out.println("""
                            1 - Calcular a média
                            2 - Sair
                            """);
                    opcoes = sc.nextInt();
                    switch (opcoes) {
                        case 1:
                            aluno.calculoDeMedia();
                            return logado;
                        case 2:
                            System.out.println("Saindo...");
                            logado = false;
                            return logado;
                        default:
                            System.out.println("Opção inválida");
                            return logado;
                    }

                } while (opcoes == 2);
            }
            if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                logado = true;

                int opcoes = 0;
                do {
                    System.out.println("""
                            1 - Calcular dos alunos na sua matéria
                            2 - Cadastrar prova
                            3 - Sair
                            """);
                    opcoes = sc.nextInt();
                    switch (opcoes) {
                        case 1:
                            professor.calculoDeMedia();
                            return logado;

                        case 2:
                            for (Turma turma :
                                    professor.getTurmas()) {
                                System.out.println("Turma " + professor.getTurmas().indexOf(turma));
                            }
                            System.out.println("Informe o numero da turma: ");
                            int indexDaTurma = sc.nextInt();
                            cadastraProva(professor.getTurmas().get(indexDaTurma), professor);

                            return logado;
                        case 3:
                            System.out.println("Saindo...");
                            logado = false;
                            return logado;
                        default:
                            System.out.println("Opção inválida");
                            return logado;
                    }

                } while (opcoes != 3);

            }
            if (usuario instanceof Secretario) {
                Secretario secretario = (Secretario) usuario;
                logado = true;

                int opcoes = 0;
                do {
                    System.out.println("""
                            1 - Cria uma turma
                            2 - Gera boletins
                            3 - Adiciona disciplina a professor
                            4 - Sair
                            """);
                    opcoes = sc.nextInt();
                    switch (opcoes) {
                        case 1:
                            ArrayList<Aluno> alunos = new ArrayList<>();
                            ArrayList<Professor> professores = new ArrayList<>();
                            System.out.println("Você está cadastrando alunos a uma turma");
                            int opcAlunosTurma = 0;
                            do {
                                for (Usuario usuario1 :
                                        Usuario.usuarios) {
                                    if (usuario1 instanceof Aluno) {
                                        System.out.println(usuario1.getNome() + " " + Usuario.usuarios.indexOf(usuario1));
                                    }
                                }
                                System.out.println("""
                                        1 - Adicionar aluno
                                        2 - Parar de adicionar alunos
                                        """);
                                opcAlunosTurma = sc.nextInt();
                                switch (opcAlunosTurma) {
                                    case 1:
                                        System.out.println("Informe o número do aluno: ");
                                        int indexAluno = sc.nextInt();
                                        alunos.add((Aluno) Usuario.usuarios.get(indexAluno));
                                        break;
                                    case 2:
                                        System.out.println("Parando de adicionar alunos...");
                                        break;
                                }
                            } while (opcAlunosTurma != 2);
                            System.out.println("Você está cadastrando professores a uma turma");
                            int opcProfessoresTurma = 0;
                            do {
                                for (Usuario usuario1 :
                                        Usuario.usuarios) {
                                    if (usuario1 instanceof Professor) {
                                        System.out.println(usuario1.getNome() + " " + Usuario.usuarios.indexOf(usuario1));
                                    }
                                }
                                System.out.println("""
                                        1 - Adicionar professor
                                        2 - Parar de adicionar professores
                                        """);
                                opcProfessoresTurma = sc.nextInt();
                                switch (opcProfessoresTurma) {
                                    case 1:
                                        System.out.println("Informe o número do professor: ");
                                        int indexProfessor = sc.nextInt();
                                        professores.add((Professor) Usuario.usuarios.get(indexProfessor));
                                        break;
                                    case 2:
                                        System.out.println("Parando de adicionar professores...");
                                        break;
                                }
                            } while (opcProfessoresTurma != 2);
                            secretario.criaTurma(alunos, professores);

                            return logado;
                        case 2:
                            for (Turma turma :
                                    Turma.turmas) {
                                System.out.println("Turma" + Turma.turmas.indexOf(turma));
                            }
                            System.out.println("Escolha a turma que deseja gerar os boletins: ");
                            int indexTurma = sc.nextInt();
                            Turma turmaBoletins = Turma.turmas.get(indexTurma);
                            secretario.gerarBoletins(turmaBoletins);
                            return logado;
                        case 3:
                            for (Disciplina disciplina :
                                    Disciplina.disciplinas) {
                                System.out.println("Disciplina:  " + disciplina.getCodigo() + " - " + disciplina.getNome());
                            }
                            System.out.println("Informe o código da disciplina: ");
                            int codigoDisciplina = sc.nextInt();
                            Disciplina disciplinaEsolhida = null;
                            for (Disciplina disciplina :
                                    Disciplina.disciplinas) {
                                if (disciplina.getCodigo() == codigoDisciplina) {
                                    disciplinaEsolhida = disciplina;
                                }
                            }
                            for (Usuario usuario1 :
                                    Usuario.usuarios) {
                                if (usuario1 instanceof Professor) {
                                    System.out.println(usuario1.getNome() + " " + Usuario.usuarios.indexOf(usuario1));
                                }
                            }
                            System.out.println("Informe o código do professor: ");
                            int codigoDoProfessor = sc.nextInt();
                            Professor professorEscolhido = (Professor) Usuario.usuarios.get(codigoDoProfessor);

                            professorEscolhido.setDisciplina(disciplinaEsolhida);

                            logado = true;
                            return logado;
                        case 4:
                            System.out.println("Saindo...");
                            logado = false;
                            return logado;
                        default:
                            System.out.println("Opção inválida");
                            return logado;
                    }

                } while (opcoes != 3);
            }

            return logado;
        } while (logado == false);

    }
}

