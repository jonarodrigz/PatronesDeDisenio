package patrones.creacionales.factorymethod.entity;

public class Product {
    private Long idProductos;
   private String productName;
    private double price;

    public Product(Long idProductos, String productName, double price) {
        this.idProductos = idProductos;
        this.productName = productName;
        this.price = price;
    }

    public Long getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Long idProductos) {
        this.idProductos = idProductos;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProductos=" + idProductos +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
