import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.routing.RoundRobinRouter

object ActorSample {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val router = system.actorOf(Props[HelloActor].withRouter(RoundRobinRouter(4)))

    router ! "Hello"

    system.shutdown
  }
}

class HelloActor extends Actor {

  def receive = {
    case "Hello" => println("Hello World!!")
    case _ => println("Bad World!!")
  }

}

