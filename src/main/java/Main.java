import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(), "firstActorSystem");

        actorSystem.tell("say hello");

        actorSystem.tell("who are you?");

        actorSystem.tell("create a child");

        actorSystem.tell("This is another message");
    }
}
