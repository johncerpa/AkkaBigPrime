import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(), "firstActorSystem");
        actorSystem.tell("Hello, are you there fellow actor?");
    }
}
