package idao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import java.sql.Connection;


/**
 *
 * @author ABDELLAH DIDI
 */
public class mysqlconnection {
     public static Connection  getConnexion (){
    try {
            File xmlFile = new File("env.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();
            String dbHost = rootElement.getAttribute("DB_HOST");
            String dbPort = rootElement.getAttribute("DB_PORT");
            String dbDatabase = rootElement.getAttribute("DB_DATABASE");
            String dbUsername = rootElement.getAttribute("DB_USERNAME");
            String dbPassword = rootElement.getAttribute("DB_PASSWORD");

            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?zeroDateTimeBehavior=convertToNull",
                    dbHost, dbPort, dbDatabase);

            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL(jdbcUrl);
            ds.setUser(dbUsername);
            ds.setPassword(dbPassword);

            Connection cnx = ds.getConnection();
            System.out.println("Connexion établie \n");
            return cnx;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    
}
