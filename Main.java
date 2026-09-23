public class Main {

    public static void main(String[] args) {

        Product produtoSemEstoque =
                new Product("Notebook", 2500.00, 0);

        Product produtoDisponivel =
                new Product("Mouse", 100.00, 10);

        ShoppingCart cart = new ShoppingCart();

        // Exceção 1: produto sem estoque
        try {

            cart.addItem(produtoSemEstoque);

        } catch (EcommerceException e) {

            System.out.println(e.getMessage());
        }

        // Adicionando produto disponível
        try {

            cart.addItem(produtoDisponivel);

        } catch (EcommerceException e) {

            System.out.println(e.getMessage());
        }

        // Exceção 2: saldo insuficiente
        try {

            cart.checkout(50.00);

        } catch (EcommerceException e) {

            System.out.println(e.getMessage());
        }
    }
}