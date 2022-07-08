package patrones.creacionales.factorymethod.impl;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import oracle.jdbc.OracleDriver;
import patrones.creacionales.factorymethod.IDBAdapter;
import patrones.creacionales.factorymethod.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLDBAdapter implements IDBAdapter {
    private static final String DB_PROPERTIES = "META-INF/DBMySQL.properties";

    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        try{
            new com.mysql.jdbc.Driver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConecction() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("Connection class ==> "+ connection.getClass().getName());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password;
        System.out.println("Connection String ===>  "+connectionString);

        return connectionString;
    }
}
