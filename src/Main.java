package ro.ase.acs.sql;

import ro.ase.acs.sql.classes.CreateTable;
import ro.ase.acs.sql.classes.InsertTable;
import ro.ase.acs.sql.classes.SelectTable;
import ro.ase.acs.sql.interfaces.CreateInterface;
import ro.ase.acs.sql.interfaces.InsertInterface;
import ro.ase.acs.sql.interfaces.SelectInterface;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            CreateInterface createInterface=new CreateTable();
            createInterface.createTable(connection);

            InsertInterface insertInterface=new InsertTable();
            insertInterface.insertData(connection);

            SelectInterface selectInterface=new SelectTable();
            selectInterface.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
