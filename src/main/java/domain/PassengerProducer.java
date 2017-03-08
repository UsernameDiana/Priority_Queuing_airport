package domain;

import queues.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

// producing passengers arriving in airport, uses clock to produce intervals for arrivals

public class PassengerProducer {
  private final List<Plane> planes;
  private final PriorityQueue<Passenger> queue;
  
  public PassengerProducer(List<Plane> planes, PriorityQueue<Passenger> queue) {
    this.planes = planes;
    this.queue = queue;
    }
  
  public void tick(Clock clock) {
    throw new UnsupportedOperationException("No support");
    }
  
  
  }
