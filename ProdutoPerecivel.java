public class ProdutoPerecivel extends Product {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer)
            throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        if (diasParaVencer < 0)
            throw new QuantidadeInvalidaException("Os dias para vencer não podem ser negativos.");
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double total = getPreco() * getQuantidade();
        if (diasParaVencer <= 3) total *= 0.80;
        return total;
    }

    @Override
    public String getDescricao() {
        return String.format("%s | Dias para vencer: %d",
                super.getDescricao(), diasParaVencer);
    }

    public int getDiasParaVencer() { return diasParaVencer; }
}
