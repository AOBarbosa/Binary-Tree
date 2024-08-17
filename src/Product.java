public class Product {
    private int code;
    private String name;
    private int amount ;

    public Product(int code, String name, int amount) {
        if (code < 0)   throw new IllegalArgumentException("Código do produto não pode ser negativo");

        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");

        if (amount < 0) throw new IllegalArgumentException("Quantidade do produto não pode ser negativa");

        this.code = code;
        this.name = name;
        this.amount = amount;
    }

    public int getProductCode() {
        return this.code;
    }

    public String getProductName() {
        return this.name;
    }

    public int getProductAmount() {
        return this.amount;
    }

    public void setProductAmount(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Quantidade do produto não pode ser negativa");

        this.amount = amount;
    }

    public void setProductName() {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");

        this.name = name;
    }

    public void setProductCode() {
        if (code < 0)   throw new IllegalArgumentException("Código do produto não pode ser negativo");

        this.code = code;
    }
}
