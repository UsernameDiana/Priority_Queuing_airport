package queues;

// we fill out a tree from left to right
// A heap has big O(n log n)

import domain.Passenger;

public class PassengerHeap implements PriorityQueue<Passenger> {

   private Passenger[] data;
   public int size = 0;
     
   public PassengerHeap (int capacity) {
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
            swap(p, pp);
            p = pp;
        }
    }

    // a swap method, to swap the position of n and m
    public void swap(int n, int m)
    {
        data[0] = data[m];
        data[m] = data[n];
        data[n] = data[0];
    }
    
    // removing from queue, taking last element and removing
    public Passenger dequeue() {
        if (size == 0) {
            // throw exception NO SUCH ELEMENT Ex!
        }
        Passenger result = data[1];
        swap(1, size--);
        
        // This is borrowed from an integer dequeue!!! Might cost us some problems
         int n = 1;
         int c = 0;
         do{
            int l = leftOf(n);
            int r = rightOf(n);

            if (l > size) return result;
            if (r > size) c =  l;
            else if (data[l].compareTo(data[r]) < 0) c =  l;
            else c = r;

            if (data[n].compareTo(data[c]) > 0)
            {
               swap(n, c);
               n = c;
            }
            else return result;
         }while(true);
    }


    @Override
    public Passenger peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() { return size; }
}