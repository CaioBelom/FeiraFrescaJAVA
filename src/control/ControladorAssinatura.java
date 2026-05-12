package control;

import entity.Assinante;
import entity.CartaoCredito;
import entity.CestaSemanal;
import entity.EnderecoEntrega;
import entity.Pagamento;
import entity.PlanoAssinatura;
import entity.Produto;
import entity.Protocolo;
import entity.VerificacaoSMS;

import java.io.*;

public class ControladorAssinatura {

    private Assinante assinante;
    private VerificacaoSMS sms;
    private PlanoAssinatura plano;
    private CestaSemanal cesta;
    private EnderecoEntrega endereco;
    private Pagamento pagamento;
    private Protocolo protocolo;

    // BLOCO 1 — Dados iniciais + persistência

    public boolean enviarDadosIniciais(String numero, boolean aceitouTermos) {

        if (assinanteExiste(numero)) {

            System.out.println("\nJá existe uma conta cadastrada com esse número.");

            return false;
        }

        assinante = new Assinante(numero, aceitouTermos);

        salvarAssinante(numero, aceitouTermos);

        sms = new VerificacaoSMS();

        String codigo = sms.gerarCodigoSMS(numero);

        System.out.println("\nCódigo enviado: " + codigo);

        System.out.println("Celular registrado: " + assinante.getCelular());

        return true;
    }

    public void reenviarCodigoSMS() {

        String novoCodigo = sms.reenviarCodigo(assinante.getCelular());

        System.out.println("\nNovo código enviado: " + novoCodigo);
    }

    public boolean assinanteExiste(String numero) {

        try {

            File arquivo = new File("data/assinantes.txt");

            if (!arquivo.exists()) {
                return false;
            }

            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";");

                if (dados.length > 0 && dados[0].equals(numero)) {

                    leitor.close();

                    return true;
                }
            }

            leitor.close();

        } catch (Exception e) {

            System.out.println("Erro ao verificar assinantes.");
        }

        return false;
    }

    public void salvarAssinante(String numero, boolean aceitouTermos) {

        try {

            FileWriter escritor = new FileWriter("data/assinantes.txt", true);

            escritor.write(numero + ";" + aceitouTermos + "\n");

            escritor.close();

        } catch (Exception e) {

            System.out.println("Erro ao salvar assinante.");
        }
    }

    // BLOCO 2 — Validação SMS

    public boolean enviarCodigo(String codigo) {

        boolean valido = sms.validarCodigo(codigo);

        if (valido) {

            System.out.println("\nCódigo validado com sucesso!");

        } else {

            System.out.println("\nCódigo inválido.");
        }

        return valido;
    }

    // BLOCO 3 — Seleção de plano

    public void selecionarPlano(int opcao) {

        switch (opcao) {

            case 1:

                plano = new PlanoAssinatura(
                        "Básico",
                        89.90,
                        2,
                        4,
                        4,
                        "Ideal para 1-2 pessoas."
                );

                break;

            case 2:

                plano = new PlanoAssinatura(
                        "Padrão",
                        119.90,
                        4,
                        4,
                        6,
                        "Maior variedade e quantidade de produtos."
                );

                break;

            case 3:

                plano = new PlanoAssinatura(
                        "Família",
                        159.90,
                        6,
                        7,
                        6,
                        "Plano ideal para famílias."
                );

                break;

            default:

                System.out.println("Plano inválido.");

                return;
        }

        System.out.println("\n===== PLANO SELECIONADO =====");

        System.out.println("Plano: " + plano.getNomePlano());

        System.out.println("Valor semanal: R$ " + plano.getValorSemanal());

        System.out.println("Frutas permitidas: " + plano.getQtdFrutas());

        System.out.println("Legumes permitidos: " + plano.getQtdLegumes());

        System.out.println("Verduras permitidas: " + plano.getQtdVerduras());
    }

    // BLOCO 4 — Seleção de produtos

    public void selecionarProdutos(int[][] escolhas) {

        cesta = new CestaSemanal();

        adicionarProdutosDaCategoria(escolhas[0], "Fruta");

        adicionarProdutosDaCategoria(escolhas[1], "Legume");

        adicionarProdutosDaCategoria(escolhas[2], "Verdura");

        cesta.exibirCesta();
    }

    private void adicionarProdutosDaCategoria(int[] escolhas, String tipo) {

        for (int i = 0; i < escolhas.length; i += 2) {

            int opcao = escolhas[i];

            int quantidade = escolhas[i + 1];

            if (opcao == 0) {
                break;
            }

            Produto produto = buscarProdutoPorOpcao(opcao, tipo, quantidade);

            if (produto != null) {

                cesta.adicionarProduto(produto);
            }
        }
    }

    private Produto buscarProdutoPorOpcao(int opcao, String tipo, int quantidade) {

        // FRUTAS

        if (tipo.equals("Fruta")) {

            switch (opcao) {

                case 1:
                    return new Produto("Maçã", "Fruta", "unidade", quantidade);

                case 2:
                    return new Produto("Banana", "Fruta", "cacho", quantidade);

                case 3:
                    return new Produto("Morango", "Fruta", "bandeja", quantidade);

                case 4:
                    return new Produto("Laranja", "Fruta", "kg", quantidade);

                case 5:
                    return new Produto("Abacaxi", "Fruta", "unidade", quantidade);

                case 6:
                    return new Produto("Uva", "Fruta", "bandeja", quantidade);

                case 7:
                    return new Produto("Manga", "Fruta", "kg", quantidade);

                case 8:
                    return new Produto("Ameixa", "Fruta", "kg", quantidade);

                case 9:
                    return new Produto("Limão", "Fruta", "kg", quantidade);
            }
        }

        // LEGUMES

        if (tipo.equals("Legume")) {

            switch (opcao) {

                case 1:
                    return new Produto("Cebola", "Legume", "kg", quantidade);

                case 2:
                    return new Produto("Tomate", "Legume", "kg", quantidade);

                case 3:
                    return new Produto("Batata", "Legume", "kg", quantidade);

                case 4:
                    return new Produto("Cenoura", "Legume", "kg", quantidade);

                case 5:
                    return new Produto("Alho", "Legume", "cabeça", quantidade);

                case 6:
                    return new Produto("Pimentão", "Legume", "unidade", quantidade);

                case 7:
                    return new Produto("Pepino", "Legume", "unidade", quantidade);

                case 8:
                    return new Produto("Beterraba", "Legume", "kg", quantidade);

                case 9:
                    return new Produto("Brócolis", "Legume", "unidade", quantidade);

                case 10:
                    return new Produto("Mandioquinha", "Legume", "kg", quantidade);
            }
        }

        // VERDURAS

        if (tipo.equals("Verdura")) {

            switch (opcao) {

                case 1:
                    return new Produto("Alface", "Verdura", "maço", quantidade);

                case 2:
                    return new Produto("Espinafre", "Verdura", "maço", quantidade);

                case 3:
                    return new Produto("Couve", "Verdura", "maço", quantidade);

                case 4:
                    return new Produto("Rúcula", "Verdura", "maço", quantidade);

                case 5:
                    return new Produto("Salsinha", "Verdura", "maço", quantidade);

                case 6:
                    return new Produto("Coentro", "Verdura", "maço", quantidade);

                case 7:
                    return new Produto("Cebolinha", "Verdura", "maço", quantidade);

                case 8:
                    return new Produto("Agrião", "Verdura", "maço", quantidade);
            }
        }

        System.out.println("Produto inválido.");

        return null;
    }

    // BLOCO 5 — Endereço

    public void registrarEndereco(String[] dadosEndereco) {

        endereco = new EnderecoEntrega(
                dadosEndereco[0],
                dadosEndereco[1],
                dadosEndereco[2],
                dadosEndereco[3],
                dadosEndereco[4],
                dadosEndereco[5]
        );

        System.out.println("\nEndereço registrado:");

        System.out.println(endereco.getEnderecoCompleto());
    }

    // BLOCO 6 — Pagamento + protocolo

    public boolean processarPagamento(String[] dadosCartao) {

        CartaoCredito cartao = new CartaoCredito(
                dadosCartao[0],
                dadosCartao[1],
                dadosCartao[2],
                dadosCartao[3]
        );

        pagamento = new Pagamento(plano.getValorSemanal());

        boolean pagamentoConfirmado = pagamento.processarPagamento(cartao);

        if (pagamentoConfirmado) {

            System.out.println("\nPagamento confirmado!");

            System.out.println("Valor pago: R$ " + pagamento.getValorPago());

            System.out.println("Cartão: " + cartao.getNumeroMascarado());

            protocolo = new Protocolo();

            System.out.println("\n===== ASSINATURA CONFIRMADA =====");

            System.out.println("Protocolo: " + protocolo.getNumeroProtocolo());

            System.out.println("Plano: " + plano.getNomePlano());

            System.out.println("Entrega semanal registrada com sucesso.");

            salvarAssinaturaCompleta();

            System.out.println("Assinatura salva no arquivo.");

            return true;
        }

        System.out.println("\nPagamento recusado.");

        return false;
    }

    // PERSISTÊNCIA FINAL

    public void salvarAssinaturaCompleta() {

        try {

            FileWriter escritor = new FileWriter("data/assinaturas.txt", true);

            escritor.write("===== ASSINATURA FEIRA FRESCA =====\n");

            escritor.write("Celular: " + assinante.getCelular() + "\n");

            escritor.write("Plano: " + plano.getNomePlano() + "\n");

            escritor.write("Valor semanal: R$ " + plano.getValorSemanal() + "\n");

            escritor.write("Endereço: " + endereco.getEnderecoCompleto() + "\n");

            escritor.write("Pagamento: " + pagamento.getStatusPagamento() + "\n");

            escritor.write("Protocolo: " + protocolo.getNumeroProtocolo() + "\n");

            escritor.write("-----------------------------------\n\n");

            escritor.close();

        } catch (Exception e) {

            System.out.println("Erro ao salvar assinatura completa.");
        }
    }

    // GETTERS

    public PlanoAssinatura getPlano() {

        return plano;
    }
}