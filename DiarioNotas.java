import java.util.*;

public class DiarioNotas {
    private Set<Aluno> alunos;
    private Map<Aluno, List<Double>> notas;

    public DiarioNotas() {
        alunos = new HashSet<>();
        notas = new HashMap<>();
    }

    public boolean cadastrarAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            System.out.println("Aluno com matrícula já existente: " + aluno.getMatricula());
            return false;
        }
        alunos.add(aluno);
        notas.put(aluno, new ArrayList<>());
        return true;
    }

    public void adicionarNota(String matricula, double nota) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            notas.get(aluno).add(nota);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public double calcularMedia(String matricula) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            List<Double> notasAluno = notas.get(aluno);
            if (notasAluno.isEmpty()) return 0;
            double soma = 0;
            for (double nota : notasAluno) {
                soma += nota;
            }
            return soma / notasAluno.size();
        }
        return 0;
    }

    public void gerarBoletim() {
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno);
            List<Double> notasAluno = notas.get(aluno);
            if (notasAluno.isEmpty()) {
                System.out.println("  Nenhuma nota registrada.");
            } else {
                System.out.println("  Notas: " + notasAluno);
                System.out.printf("  Média: %.2f%n", calcularMedia(aluno.getMatricula()));
            }
            System.out.println("------------------------------");
        }
    }

    private Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
}


