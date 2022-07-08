package patrones.creacionales.factorymethod;

import java.sql.Connection;

public interface IDBAdapter {
    public Connection getConecction();
}
