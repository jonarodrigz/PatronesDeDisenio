package patrones.creacionales.factorymethod;

import patrones.creacionales.factorymethod.dao.ProductDAO;
import patrones.creacionales.factorymethod.entity.Product;

import java.util.List;

public class FactoryMain {
    public static void main(String[] args) {

        Product proA = new Product(3L, "ProductoA", 100);
        Product proB = new Product(4L, "ProductoB", 100);

        ProductDAO pdao = new ProductDAO();

        pdao.saveProduct(proA);
        pdao.saveProduct(proB);

        List<Product> list = pdao.findAllProducts();
        System.out.println("Producto SIZE ==>" + list.size());
        for(Product product : list){
            System.out.println(product);
        }
    }
}