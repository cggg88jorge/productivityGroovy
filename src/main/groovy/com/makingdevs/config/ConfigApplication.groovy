package com.makingdevs.config

@Singleton
class ConfigApplication {

  def getConfig(){
    String externalConfigurationPath = "${System.getProperty('user.home')}/.exampleGroovy/configApplication.groovy"
    File externalConfigurationFile = new File(externalConfigurationPath)
    if(!externalConfigurationFile.exists())
      throw new RuntimeException("""
        You must create a external file in USER_HOME/.exampleGroovy/configApplication.groovy
      """)
    new ConfigSlurper().parse(externalConfigurationFile.toURL())
  }

}
