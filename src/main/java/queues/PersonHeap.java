package queues;

// we fill out a tree from left to right

import domain.Passenger;

public class PersonHeap implements PriorityQueue<Passenger> {

    private Passenger[] data;
    public int size = 0;

     
   public PersonHeap (int capacity) {
        data = new Passenger[capacity];
    }
    
    // finding positions to left and right side
    private int leftOf(int p) {
        return 2 * p;
    }

    private int rightOf(int p) {
        return 2 * p + 1;
    }

    // finding new elements position
    private int parentOf(int position) {
        return position / 2;
    }

    // adding to queue
    public void enqueue(Passenger passenger) {
        int p = ++size;
        data[p] = passenger;
        while (true) {
            int pp = parentOf(p);
            if (pp == 0 || data[p].compareTo(data[pp]) > 0) {
                return;
            }
            data[0] = data[pp];
            data[pp] = data[p];
            data[p] = data[0];
            p = pp;
        }
    }

    // removing from queue, taking last element and removing
    public Passenger dequeue() {
        if (size == 0) {
            // throw exception NO SUCH ELEMENT!
        }
        Passenger result = data[1];
        return result;
    }


    @Override
    public Passenger peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
