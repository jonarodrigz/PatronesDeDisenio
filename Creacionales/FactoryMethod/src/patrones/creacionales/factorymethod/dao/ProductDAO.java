package patrones.creacionales.factorymethod.dao;

import patrones.creacionales.factorymethod.DBFactory;
import patrones.creacionales.factorymethod.IDBAdapter;
import patrones.creacionales.factorymethod.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private IDBAdapter idbAdapter;

    public ProductDAO() {
        this.idbAdapter = DBFactory.getDefaultDBAdapter();
    }

    public List<Product> findAllProducts(){
        Connection con = idbAdapter.getConecction();
        List<Product> productList = new ArrayList<>();

        try{
            PreparedStatement statement = con.prepareStatement("Select * from productos");
            ResultSet results = statement.executeQuery();
            while (results.next()){
                productList.add(new Product(results.getLong(1),results.getString(2),results.getDouble(3)));
            }
            return productList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                con.close();
            }catch (Exception e){}
        }
    }

    public boolean saveProduct(Product product){
        Connection connection = idbAdapter.getConecction();

        try{
            PreparedStatement statement = connection.prepareStatement("Insert into productos (idProductos, productname,productprice) values (?,?,?)");
            statement.setLong(1,product.getIdProductos());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try{
                connection.close();
            }catch (Exception e){}
        }
    }
}
