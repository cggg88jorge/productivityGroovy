package com.mymapmanager

class SimpleQueryTest extends GroovyTestCase {

  void testConnect(){
    def query = "select 2+2 as SUMA"
    DB.instance.withSqlInstance { sql ->
      assert sql.firstRow(query)[0] == 4
    }
  }

}