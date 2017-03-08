package queues;

// we fill out a tree from left to right
public class PersonHeap implements PriorityQueue<Person> {

    private Person[] data = new Person[capacity];
    public int size = 0;

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
    public void enqueue(Person person) {
        int p = ++size;
        data[p] = person;
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
    public Person dequeue() {
        if (size == 0) {
            // throw exception NO SUCH ELEMENT!
        }
        Person result = data[1];
    }

    Person(int capacity) {
        data = new Person[capacity];
    }
}
