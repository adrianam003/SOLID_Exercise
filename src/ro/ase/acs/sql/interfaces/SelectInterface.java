package ro.ase.acs.sql.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface SelectInterface {
    void readData(Connection connection) throws SQLException;
}
