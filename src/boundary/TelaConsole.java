package boundary;

import java.util.Scanner;

public class TelaConsole {

    private Scanner sc = new Scanner(System.in);

    public String informarNumero() {
        System.out.print("Digite o número de celular: ");
        return sc.nextLine();
    }

    public boolean aceitarTermos() {
        System.out.print("Aceita os termos? (true/false): ");
        boolean aceitou = sc.nextBoolean();
        sc.nextLine(); // limpa o buffer
        return aceitou;
    }

    public String informarCodigoSMS() {

        System.out.println("\nDigite o código SMS recebido");
        System.out.println("ou digite R para reenviar o código.");

        System.out.print("Código: ");

        return sc.nextLine();
    }

    public int escolherPlano() {

        System.out.println("\n===== PLANOS DISPONÍVEIS =====\n");

        System.out.println("1 - BÁSICO");
        System.out.println("Ideal para 1-2 pessoas.");
        System.out.println("Receba frutas, legumes e verduras frescas toda semana.");
        System.out.println("R$ 89.90/semana");
        System.out.println("• Até 2 tipos de frutas");
        System.out.println("• Até 4 tipos de legumes");
        System.out.println("• Até 4 tipos de verduras");
        System.out.println("• Entrega semanal grátis\n");

        System.out.println("2 - PADRÃO (Mais Vendido)");
        System.out.println("Perfeito para famílias.");
        System.out.println("Maior variedade e quantidade de produtos.");
        System.out.println("R$ 119.90/semana");
        System.out.println("• Até 4 tipos de frutas");
        System.out.println("• Até 4 tipos de legumes");
        System.out.println("• Até 6 tipos de verduras");
        System.out.println("• Entrega semanal grátis\n");

        System.out.println("3 - FAMÍLIA");
        System.out.println("Perfeito para famílias.");
        System.out.println("Receba frutas, legumes e verduras frescas toda semana.");
        System.out.println("R$ 159.90/semana");
        System.out.println("• Até 6 tipos de frutas");
        System.out.println("• Até 7 tipos de legumes");
        System.out.println("• Até 6 tipos de verduras");
        System.out.println("• Entrega semanal grátis\n");

        System.out.print("Escolha um plano: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // limpa o buffer
        return opcao;
    }

    public int[][] selecionarProdutosPorPlano(int limiteFrutas, int limiteLegumes, int limiteVerduras) {

        int[][] escolhas = new int[3][];

        escolhas[0] = selecionarCategoria(
                "FRUTAS",
                new String[]{"Maçã", "Banana", "Morango", "Laranja", "Abacaxi", "Uva", "Manga", "Ameixa", "Limão"},
                limiteFrutas
        );

        escolhas[1] = selecionarCategoria(
                "LEGUMES",
                new String[]{"Cebola", "Tomate", "Batata", "Cenoura", "Alho", "Pimentão", "Pepino", "Beterraba", "Brócolis", "Mandioquinha"},
                limiteLegumes
        );

        escolhas[2] = selecionarCategoria(
                "VERDURAS",
                new String[]{"Alface", "Espinafre", "Couve", "Rúcula", "Salsinha", "Coentro", "Cebolinha", "Agrião"},
                limiteVerduras
        );

        return escolhas;
    }

    private int[] selecionarCategoria(String categoria, String[] itens, int limite) {

        System.out.println("\n===== " + categoria + " DISPONÍVEIS =====");

        for (int i = 0; i < itens.length; i++) {
            System.out.println((i + 1) + " - " + itens[i]);
        }

        System.out.println("\nVocê pode selecionar até " + limite + " unidades nesta categoria.");
        System.out.println("Digite 0 para parar antes do limite.");

        int[] escolhas = new int[limite * 2];
        int totalSelecionado = 0;
        int posicao = 0;

        while (totalSelecionado < limite) {

            System.out.print("\nEscolha a opção: ");
            int opcao = sc.nextInt();

            if (opcao == 0) {
                break;
            }

            if (opcao < 1 || opcao > itens.length) {
                System.out.println("Opção inválida.");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida.");
                continue;
            }

            if (totalSelecionado + quantidade > limite) {
                System.out.println("Quantidade ultrapassa o limite do plano.");
                System.out.println("Você ainda pode selecionar " + (limite - totalSelecionado) + " unidade(s).");
                continue;
            }

            escolhas[posicao] = opcao;
            escolhas[posicao + 1] = quantidade;

            totalSelecionado += quantidade;
            posicao += 2;

            System.out.println("Total selecionado em " + categoria + ": " + totalSelecionado + "/" + limite);
        }

        sc.nextLine(); // limpa o buffer
        return escolhas;
    }

    public String[] informarEndereco() {

        System.out.println("\n===== ENDEREÇO DE ENTREGA =====");

        System.out.print("Logradouro: ");
        String logradouro = sc.nextLine();

        System.out.print("Número: ");
        String numero = sc.nextLine();

        System.out.print("Bairro: ");
        String bairro = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Estado: ");
        String estado = sc.nextLine();

        System.out.print("CEP: ");
        String cep = sc.nextLine();

        return new String[]{logradouro, numero, bairro, cidade, estado, cep};
    }

    public String[] informarDadosCartao() {

        System.out.println("\n===== PAGAMENTO =====");

        System.out.print("Nome do titular: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Número do cartão: ");
        String numeroCartao = sc.nextLine();

        System.out.print("Validade: ");
        String validade = sc.nextLine();

        System.out.print("CVV: ");
        String cvv = sc.nextLine();

        return new String[]{nomeTitular, numeroCartao, validade, cvv};
    }
}