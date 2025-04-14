import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ListaDinamica listaDinamica = new ListaDinamica(null);

        int opcao = -1;

        while (opcao != 10) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Olá, bem-vindo ao sistema!!");
            System.out.println(
                    "1 - Inserir elemento" +
                            "\n2 - Inserir vários elementos em sequência" +
                            "\n3 - Remover elemento" +
                            "\n4 - Remover vários elementos em sequência" +
                            "\n5 - Remover todas as ocorrências de um elemento" +
                            "\n6 - Ordenar elementos de forma crescente" +
                            "\n7 - Ordenar elementos de forma decrescente" +
                            "\n8 - Limpar a lista inteira" +
                            "\n9 - Mostrar a lista" +
                            "\n10 - Encerrar o sistema"
            );
            System.out.println("-----------------------------------------");
            System.out.print("Por gentileza, escolha uma das opções para operar o sistema:");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    Object valor = scanner.nextLine();
                    listaDinamica.inserirElemento(valor);
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    Object[] valores = new Object[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Digite o elemento " + (i + 1) + ": ");
                        valores[i] = scanner.nextLine();
                    }
                    listaDinamica.inserirSequencia(valores);
                    break;

                case 3:
                    System.out.print("Digite o elemento a ser removido: ");
                    Object elemRemover = scanner.nextLine();
                    listaDinamica.removerElemento(elemRemover);
                    break;

                case 4:
                    System.out.print("Quantos elementos deseja remover? ");
                    int qtdRemover = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    Object[] removerSeq = new Object[qtdRemover];
                    for (int i = 0; i < qtdRemover; i++) {
                        System.out.print("Digite o elemento " + (i + 1) + ": ");
                        removerSeq[i] = scanner.nextLine();
                    }
                    listaDinamica.removerSequencia(removerSeq);
                    break;

                case 5:
                    System.out.print("Digite o elemento para remover em todas as ocorrências: ");
                    Object todasOcorrencias = scanner.next();
                    listaDinamica.removerTodasOcorrencias(todasOcorrencias);
                    break;

                case 6:
                    System.out.println("Ordenando em ordem crescente...");
                    listaDinamica.ordenarCrescente();
                    break;

                case 7:
                    System.out.println("Ordenando em ordem decrescente...");
                    listaDinamica.ordenarDecrescente();
                    break;

                case 8:
                    listaDinamica.limpar();
                    break;

                case 9:
                    listaDinamica.exibir();
                    break;

                case 10:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
