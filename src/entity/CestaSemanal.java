package entity;

import java.util.ArrayList;
import java.util.List;

public class CestaSemanal {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {

        produtos.add(produto);
    }

    public List<Produto> getProdutos() {

        return produtos;
    }

    public void exibirCesta() {

        System.out.println("\n===== CESTA SEMANAL =====");

        for (Produto produto : produtos) {

            System.out.println(
                    "- " + produto.getQuantidade() + "x " +
                            produto.getNome() + " (" +
                            produto.getTipo() + " - " +
                            produto.getUnidadeComercial() + ")"
            );
        }
    }
}