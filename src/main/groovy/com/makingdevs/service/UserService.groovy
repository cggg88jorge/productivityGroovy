package com.makingdevs.service

interface UserService{

  def getUser(username)

  def insertUser(user)

  def getUsers()

  def deleteUser(username)

}