import com.makingdevs.actor.ExampleActor
import javax.servlet.http.HttpServletResponse 

ExampleActor actor = ExampleActor.instance

try {

if(headers['Content-Type'] != "application/json")
  throw new RuntimeException("Please use 'application/json' header")

if(!params.username)
  throw new RuntimeException("Params username is required")

if(!actor.isActive())
  actor.start()

actor.send params.username

}

catch(e) {
  response.contentType = 'application/json'
  response.setStatus(HttpServletResponse.SC_BAD_REQUEST, e.message)
  println e.message
}


