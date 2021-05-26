import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class FirstSimpleBehavior extends AbstractBehavior<String> {
    private FirstSimpleBehavior(ActorContext<String> context) {
        super(context);
    }

    /*
        We create a static method so that we can obtain the ActorContext object
        that we need to instantiate an AbstractBehavior, in this case FirstSimpleBehavior
     */
    public static Behavior<String> create() {
        return Behaviors.setup(FirstSimpleBehavior::new);
    }

    /*
        Handles the receiving of messages, for this type of actors
        What actions must be done after receiving a message?
     */
    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onAnyMessage(message -> {
                    System.out.println("I received the following message: " + message);
                    return this; // `this` refers to an instance of Behavior (FirstSimpleBehavior)
                })
                .build();
    }
}
