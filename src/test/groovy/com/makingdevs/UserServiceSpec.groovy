package com.makingdevs

import com.makingdevs.service.impl.UserServiceImpl
import spock.lang.*

class UserServiceSpec extends Specification {

  UserServiceImpl userService = UserServiceImpl.instance

  def "Buscar un usuario por su username"(){
    given: "Un username del usuario a buscar"
      def username = "jorge@makingdevs.com"
    when: "Nostros tratamos de obtener el username"
      def user = userService.getUser(username)
    then: "La busqueda tuvo un resultado diferente a nulo"
      assert user
  }

  def "insertar un usuario nuevo"(){
    given: "Los datos necesarios para crear el usuario"
      def user = [
        username: "algo@makingdevs.com",
        name: "algo mas algo",
        date_created: new Date()
      ]
    when: "Tratamos de insertar el nuevo usuario"
      userService.insertUser(user)
    then: "Buscamos el usuario nuevo insertado"
      assert userService.getUser(user.username)
    cleanup: "Borramos el usuario creado"
      userService.deleteUser(user.username)
  }

  def "Buscar todos los usuarios de la base"(){
    when: "Tratamos de buscar todos los usuarios"
      def users = userService.getUsers()
    then: "La cantidad de usuarios debe de coincidir"
      users.size ==  1
  }

}
