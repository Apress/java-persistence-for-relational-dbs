package com.apress.javapersist.chapter06.facade;

import java.sql.*;

public interface ResultSetMap {
  public Object convert( ResultSet resultSet ) throws SQLException;
}
