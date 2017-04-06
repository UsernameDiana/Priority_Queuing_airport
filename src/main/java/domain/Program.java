package domain;

import queues.NotPrioritisingPassengerArrayQueue;
import queues.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Program {

    private static List<Plane> planes = new ArrayList<>();
    private static PassengerProducer producer;
    private static PassengerConsumer consumer;
    private static PriorityQueue<Passenger> queue;
    private static Clock clock;

    private static void setup() {
        for (int hour = 7; hour <= 22; hour++) {
            planes.add(new Plane(new Time(hour, 00, 00))); // creating planes per hour
        }

        queue = new NotPrioritisingPassengerArrayQueue(100); // CHANGE WITH OUR OWN QUEUE!!!!
        producer = new PassengerProducer(planes, queue); // creates new producer
        consumer = new PassengerConsumer(planes, queue);
        clock = new Clock(producer, consumer, new Time(05, 00, 00)); // clock has producer and consumer and time to start
    }

    public static void main(String[] args) {
        setup();
        System.out.println("Hello Airport");
        new Thread(clock).start(); // starting clock, comment in when to run
    }
}
