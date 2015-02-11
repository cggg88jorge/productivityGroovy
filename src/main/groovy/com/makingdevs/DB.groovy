package com.makingdevs

import groovy.sql.*
import com.makingdevs.config.ConfigApplication
import org.apache.commons.dbcp2.BasicDataSource

@Singleton(strict=false) 
class DB{

  def sqlExample

  def config = ConfigApplication.instance.config

  private DB() {
    BasicDataSource origin = new BasicDataSource(config.dataSource)
    sqlExample = Sql.newInstance(origin)
  }

  def withSqlInstance(closure){
    closure(sqlExample)
  }

}