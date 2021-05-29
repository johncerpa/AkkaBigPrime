import akka.actor.typed.ActorSystem;

public class MainBigPrime {
    public static void main(String[] args) {
        ActorSystem<ManagerBehavior.Command> actorSystem = ActorSystem.create(ManagerBehavior.create(), "bigPrimeSystem");
        actorSystem.tell(new ManagerBehavior.InstructionCommand("start"));
    }
}
