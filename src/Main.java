import boundary.TelaConsole;
import control.ControladorAssinatura;

public class Main {

  public static void main(String[] args) {

    TelaConsole tela = new TelaConsole();

    ControladorAssinatura controlador = new ControladorAssinatura();

    // BLOCO 1 — Cadastro inicial

    boolean cadastroRealizado = false;

    while (!cadastroRealizado) {

      String numero = tela.informarNumero();

      boolean aceitou = false;

      while (!aceitou) {

        aceitou = tela.aceitarTermos();

        if (!aceitou) {

          System.out.println("\nÉ preciso aceitar os termos para continuar.");
        }
      }

      cadastroRealizado = controlador.enviarDadosIniciais(numero, true);

      if (!cadastroRealizado) {

        System.out.println("Digite outro número para continuar.\n");
      }
    }

    // BLOCO 2 — Validação SMS

    boolean codigoValido = false;

    while (!codigoValido) {

      String codigo = tela.informarCodigoSMS();

      if (codigo.equalsIgnoreCase("R")) {

        controlador.reenviarCodigoSMS();

        continue;
      }

      codigoValido = controlador.enviarCodigo(codigo);

      if (!codigoValido) {

        System.out.println("Digite o código novamente.\n");
      }
    }

    // BLOCO 3 — Escolha do plano

    int opcaoPlano = tela.escolherPlano();

    controlador.selecionarPlano(opcaoPlano);

    // BLOCO 4 — Seleção de produtos

    int[][] produtosEscolhidos = tela.selecionarProdutosPorPlano(
            controlador.getPlano().getQtdFrutas(),
            controlador.getPlano().getQtdLegumes(),
            controlador.getPlano().getQtdVerduras()
    );

    controlador.selecionarProdutos(produtosEscolhidos);

    // BLOCO 5 — Endereço

    String[] dadosEndereco = tela.informarEndereco();

    controlador.registrarEndereco(dadosEndereco);

    // BLOCO 6 — Pagamento + confirmação

    String[] dadosCartao = tela.informarDadosCartao();

    controlador.processarPagamento(dadosCartao);
  }
}