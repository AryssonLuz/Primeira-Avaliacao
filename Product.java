public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade)
            throws QuantidadeInvalidaException {
        if (preco < 0 || quantidade < 0)
            throw new QuantidadeInvalidaException("Preço e quantidade não podem ser negativos.");
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format("Nome: %s | Preço: R$ %.2f | Quantidade: %d",
                nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada <= 0)
            throw new ProdutoIndisponivelException("A quantidade de venda deve ser maior que zero.");
        if (quantidadeDesejada > quantidade)
            throw new ProdutoIndisponivelException("Quantidade indisponível para o produto: " + nome);
        quantidade -= quantidadeDesejada;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100)
            throw new IllegalArgumentException("O percentual deve estar entre 0 e 100.");
        preco -= preco * percentual / 100.0;
    }

    public void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual < 0 || descontoMaximo < 0)
            throw new IllegalArgumentException("Os valores de desconto não podem ser negativos.");
        aplicarDesconto(Math.min(percentual, descontoMaximo));
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
}
