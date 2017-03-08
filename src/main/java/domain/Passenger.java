package domain;

// implements comparable, so we can compare the categories and boarding time

public class Passenger implements Comparable<Passenger>{
  private final int id;
  private final Time arrivalTime;
  private final Plane plane;
  private Category category;
  private Status status = Status.Waiting;
  
  public Passenger(int id, Time arrivalTime, Category category, Plane plane) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.category = category;
    this.plane = plane;
    }
   
  public int getId() { return id; }
  
  public Time getArrivalTime() { return arrivalTime; }
  
  public Plane getPlane() { return plane; }
  
  public Category getCategory() { return category; }

  public Status getStatus() {
    return status;
    }

  public void setStatus(Status status) {
    this.status = status;
    }
  
  @Override
  public int compareTo(Passenger other) {
    if (this.category.compareTo(other.category) != 0)
        return this.category.compareTo(other.category);
    return this.arrivalTime.compareTo(other.arrivalTime);
    }

  }
