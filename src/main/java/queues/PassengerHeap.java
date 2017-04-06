package queues;

// we fill out a tree from left to right
// A heap has big O(n log n)
import domain.Category;
import domain.Passenger;
import domain.Plane;
import domain.Time;
import java.util.Date;

public class PassengerHeap implements PriorityQueue<Passenger> {

    private Passenger[] data;
    public int size = 0;

    public static void main(String[] args) {
        PassengerHeap ph = new PassengerHeap(100); // creating passengers
        for (int i = 0; i < 10; i++) {
            ph.enqueue(new Passenger(i, new Time(new Date().getTime()), ph.random(), new Plane(new Time(new Date().getTime()))));
        }
        ph.printQueue();
        for (int i = 0; i < 10; i++) {
            System.out.println(ph.dequeue().getCategory());
            System.out.println("");
        }
    }

    public PassengerHeap(int capacity) {
        data = new Passenger[capacity + 1];
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
    public void swap(int n, int m) {
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
        do {
            int l = leftOf(n);
            int r = rightOf(n);

            if (l > size) {
                return result;
            }
            if (r > size) {
                c = l;
            } else if (data[l].compareTo(data[r]) < 0) {
                c = l;
            } else {
                c = r;
            }

            if (data[n].compareTo(data[c]) > 0) {
                swap(n, c);
                n = c;
            } else {
                return result;
            }
        } while (true);
    }

    @Override
    public Passenger peek() {
        return data[0];
    }

    @Override
    public int size() {
        return size;
    }

    private Category random() {
        int rand = (int) (Math.random() * 5);
        if (rand == 0) {
            return Category.Monkey;
        }
        if (rand == 1) {
            return Category.Disabled;
        }
        if (rand == 2) {
            return Category.Family;
        }
        if (rand == 3) {
            return Category.BusinessClass;
        }
        return Category.LateToFlight;
    }

    private void printQueue() {
        if (true) {
            return;
        }
        String line = "";
        int waitingInLine = 1;
        for (int i = 1; i < size; i++) {
            if (i == waitingInLine) {
                line += System.lineSeparator();
                waitingInLine *= 2;
            }
            for (int j = 0; j < size / (waitingInLine); j++) {
                line += "  ";
            }
            line += data[i].getCategory();
            for (int j = 0; j < size / (waitingInLine); j++) {
                line += "  ";
            }
        }
        System.out.println(line);
    }
}
