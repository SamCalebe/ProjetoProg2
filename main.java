import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DiarioNotas diario = new DiarioNotas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE DIÁRIO DE NOTAS =====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Adicionar nota");
            System.out.println("3. Calcular média de um aluno");
            System.out.println("4. Gerar boletim");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Matrícula do aluno: ");
                    String matricula = scanner.nextLine();
                    Aluno aluno = new Aluno(nome, matricula);
                    diario.cadastrarAluno(aluno);
                    break;
                case 2:
                    System.out.print("Matrícula do aluno: ");
                    String matNota = scanner.nextLine();
                    System.out.print("Nota a adicionar: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // consumir quebra de linha
                    diario.adicionarNota(matNota, nota);
                    break;
                case 3:
                    System.out.print("Matrícula do aluno: ");
                    String matMedia = scanner.nextLine();
                    double media = diario.calcularMedia(matMedia);
                    System.out.printf("Média do aluno: %.2f%n", media);
                    break;
                case 4:
                    diario.gerarBoletim();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}


