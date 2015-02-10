package com.makingdevs

import groovy.sql.*
import org.apache.commons.dbcp2.BasicDataSource

@Singleton(strict=false) 
class DB{

  def sqlExample

  private DB() {
    BasicDataSource origin = new BasicDataSource(
      url : "jdbc:mysql://localhost:3306/groovy_example",
      username : "root",
      password : "",
      driverClassName : "com.mysql.jdbc.Driver",
      initialSize : 5,
      maxTotal : 50,
      minIdle : 5,
      maxIdle : 25,
      maxWaitMillis : 10000,
      timeBetweenEvictionRunsMillis : 5000,
      minEvictableIdleTimeMillis : 60000,
      validationQuery : "SELECT 1",
      validationQueryTimeout : 3)
    sqlExample = Sql.newInstance(origin)
  }

  def withSqlInstance(closure){
    closure(sqlExample)
  }

}