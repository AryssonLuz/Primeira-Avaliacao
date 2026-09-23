import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> produtos;
    private double total;

    public ShoppingCart() {
        produtos = new ArrayList<>();
        total = 0;
    }

    public void addItem(Product p) throws ProdutoIndisponivelException {

        if (p.getEstoque() == 0) {
            throw new ProdutoIndisponivelException(p.getNome());
        }

        produtos.add(p);
        total += p.getPreco();

        System.out.println("Produto adicionado: " + p.getNome());
    }

    public void checkout(double saldoDisponivel)
            throws SaldoInsuficienteException {

        if (total > saldoDisponivel) {

            double faltando = total - saldoDisponivel;

            throw new SaldoInsuficienteException(faltando);
        }

        System.out.println("Compra finalizada com sucesso!");
        System.out.println("Total: R$" + total);
    }

    public double getTotal() {
        return total;
    }
}