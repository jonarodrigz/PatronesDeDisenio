package patrones.creacionales.factorymethod;

import patrones.creacionales.factorymethod.impl.MySQLDBAdapter;
import patrones.creacionales.factorymethod.impl.OracleDBAdapter;
import patrones.creacionales.factorymethod.util.PropertiesUtil;

import java.util.Properties;

public class DBFactory {

    private static final String DB_FACTORY_PROPERTY_URL="META-INF/DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP="defaultDBClass";

    public static IDBAdapter getDBAdapter(DBType dbType){
        switch (dbType){
            case MySQL:
                return new MySQLDBAdapter();
            case Oracle:
                return new OracleDBAdapter();
            default:
                throw new IllegalArgumentException("No Soportado");
        }
    }

    public static IDBAdapter getDefaultDBAdapter(){
        try{
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBCLass ===>  "+defaultDBClass);
            return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
         }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
