import akka.actor.typed.ActorRef;
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
                .onMessageEquals("say hello", () -> {
                  System.out.println("Hello world!");
                  return this;
                })
                .onMessageEquals("who are you?", () -> {
                    System.out.println("My path is " + getContext().getSelf().path());
                    return this;
                })
                .onMessageEquals("create a child", () -> {
                    ActorRef<String> secondActor = getContext().spawn(FirstSimpleBehavior.create(), "secondActor");
                    secondActor.tell("who are you?");
                    return this;
                })
                .onAnyMessage(message -> {
                    System.out.println("I receive the message: " + message);
                    return this; // `this` refers to an instance of Behavior (FirstSimpleBehavior)
                })
                .build();
    }
}
