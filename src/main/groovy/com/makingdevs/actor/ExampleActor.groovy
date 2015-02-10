package com.makingdevs.actor

import groovyx.gpars.actor.Actor
import groovyx.gpars.actor.DefaultActor
import com.makingdevs.service.*
import com.makingdevs.service.impl.*
import groovy.util.logging.*

@Singleton
@Log4j
class ExampleActor extends DefaultActor{

  UserServiceImpl userService = UserServiceImpl.instance

  void act(){
    loop{
      react { username -> 
        try {
          log.debug "debug"
          log.error "error"
          def user = userService.getUser(username)
          if (user)
            log.debug "Se encontro el usuario ${username}"
          else
            log.debug "No se  encontro el usuario ${username}"
        }catch(e){
          log.error e.message
        }
      }
    }
  }
}