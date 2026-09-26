public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try {
            estoque.adicionarProduto(new ProdutoComum("Arroz", 25.00, 10));
            estoque.adicionarProduto(new ProdutoComum("Feijão", 8.50, 20));
            estoque.adicionarProduto(new ProdutoPerecivel("Leite", 6.00, 15, 2));
            estoque.adicionarProduto(new ProdutoPerecivel("Queijo", 30.00, 5, 10));

            System.out.println("=== PRODUTOS CADASTRADOS ===");
            estoque.listarProdutos();

            System.out.println("\n=== TESTE DE EXCEÇÃO DE CADASTRO ===");
            try {
                new ProdutoComum("Produto inválido", 10.00, -5);
            } catch (QuantidadeInvalidaException e) {
                System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
            }

            System.out.println("\n=== TESTE DE VENDA VÁLIDA ===");
            estoque.venderProduto(0, 3);
            System.out.println("Venda realizada com sucesso: 3 unidades de Arroz.");

            System.out.println("\n=== TESTE DE VENDA INVÁLIDA ===");
            try {
                estoque.venderProduto(1, 100);
            } catch (ProdutoIndisponivelException e) {
                System.out.println("ProdutoIndisponivelException capturada: " + e.getMessage());
            }

            System.out.println("\n=== VALOR TOTAL DO ESTOQUE ===");
            System.out.printf("Valor total do estoque: R$ %.2f%n",
                    estoque.calcularValorTotalEstoque());

            System.out.println("\n=== PRODUTOS APÓS A VENDA ===");
            estoque.listarProdutos();

        } catch (EstoqueException e) {
            System.out.println("Erro relacionado ao estoque: " + e.getMessage());
        }
    }
}
