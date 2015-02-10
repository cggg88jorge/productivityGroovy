package com.makingdevs.service.impl

import com.makingdevs.service.UserService
import com.makingdevs.DB

@Singleton
class UserServiceImpl implements UserService {

  def getUser(username){
    def query = "select * from user where username = ?"
    DB.instance.withSqlInstance { sql ->
      sql.rows(query,[username])
    }
  }

  def insertUser(user){
    DB.instance.withSqlInstance { sql ->
      def dataSet = sql.dataSet('user')
      dataSet.add user
    }
  }

  def getUsers(){
    def query = "select * from user"
    DB.instance.withSqlInstance { sql ->
      sql.rows(query)
    }
  }

  def deleteUser(username){
    def query = "delete from user where username = ?"
    DB.instance.withSqlInstance { sql ->
      sql.execute(query,[username])
    }
  }

}