package DBConfigurazione;

import java.sql.*;


public class DBConnection {
	
	private  Connection conn = null;
	private static DBConnection instance; //Riferimento all'stanza della connessione al db
	
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://192.168.1.150/magazzino";
    //  Database credentials
    static final String USER = "magazziniere";
    static final String PASS = "password";
    
    /*Costruttore privato per effettuare una sola connesione al DB*/
    private DBConnection() throws SQLException {
    	
       

        try {
            //STEP 2: Register JDBC driver
        	Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connessione al database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connession effettuata correttamente");
            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            System.out.println("Errore nel caricamento del DRIVER JDBC per MariaDB.");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            System.out.println("Mancanza del Driver JDBC");
        }

    }
    
    /*Ritorno la connessione*/
    public Connection getConnection() {
        return conn;
    }
    
    public static DBConnection getInstance() throws SQLException {
    	//Se la connessione non esiste la creo
        if (instance == null)
        {
            instance = new DBConnection();
        }
        else
        	//Se la connessione esite ed è chiusa la creo di nuovo
            if (instance.getConnection().isClosed())
            {
                instance = new DBConnection();
            }

        return instance;
    }
    



}
