package domain;

import queues.PriorityQueue;
import java.util.List;

// removes customers from Prioraty Queue
public class PassengerConsumer {

    private final List<Plane> planes;
    private final PriorityQueue<Passenger> queue;
    private int processingTicksLeft = 0;
    // Passenger being processed
    private Passenger passenger; // passenger beeing processed

    public PassengerConsumer(List<Plane> planes, PriorityQueue<Passenger> queue) {
        this.planes = planes;
        this.queue = queue;
    }

    public void tick(Clock clock) {
        if (processingTicksLeft > 0) {
            processingTicksLeft--;
            return;
        }
        if (passenger != null) {
            Time now = clock.getTime();
            if (passenger.getPlane().getDepartureTime().compareTo(now) < 0) {
                passenger.setStatus(Status.MissedPlane);
                System.out.println("Passenger " + passenger.getId() + " missed the plane");
            } else {
                passenger.setStatus(Status.Boarded);
                System.out.println("Passenger " + passenger.getId() + " has boarded");
            }
        }

        if (queue.isEmpty()) {
            return;
        }

        passenger = queue.dequeue(); // takes next passenger from queue
        switch (passenger.getCategory()) {
            case LateToFlight:
                processingTicksLeft = 60;
                break;
            case BusinessClass:
                processingTicksLeft = 60;
                break;
            case Disabled:
                processingTicksLeft = 180;
                break;
            case Family:
                processingTicksLeft = 180;
                break;
            case Monkey:
                processingTicksLeft = 60;
                break;

        }

    }

}
