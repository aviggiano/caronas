package utils;

import java.sql.*;

public class Transacao {

    // connection data

    
  static final String ODBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
  static final String DSN = "jdbc:odbc:caronusp";
  static final String USER = "pmrsi";
  static final String PWD = "pmrsi";
    
    /*
    static final String MYSQL_USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    static final String MYSQL_PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    static final String MYSQL_DATABASE_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String MYSQL_DATABASE_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String MYSQL_DATABASE_NAME = "caron";
    static final String MYSQL_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    static String url = "";*/
    
    
    
    
    private Connection _conexao = null;
    private boolean _readOnly = false;

    public void begin() throws Exception {
        Class.forName(ODBC_DRIVER).newInstance();
                
        /*url = "jdbc:mysql://" + MYSQL_DATABASE_HOST + ":" + MYSQL_DATABASE_PORT + "/" + MYSQL_DATABASE_NAME;
        _conexao = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
        */
        
        _conexao = DriverManager.getConnection(DSN, USER, PWD);
        _conexao.setAutoCommit(false);
        _readOnly = false;
    } // begin

    public void beginReadOnly() throws Exception {
        Class.forName(ODBC_DRIVER).newInstance();
        //_conexao = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
        
        _conexao = DriverManager.getConnection(DSN, USER, PWD);
        _readOnly = true;
    } // begin

    public void commit() throws Exception {
        if (!_readOnly) {
            _conexao.commit();
        }
        _conexao.close();
    } // commit

    public void rollback() throws Exception {
        if (!_readOnly) {
            _conexao.rollback();
        }
        _conexao.close();
    } // rollback

    public Connection obterConexao() {
        return _conexao;
    } // obterConexao
} // Transacao