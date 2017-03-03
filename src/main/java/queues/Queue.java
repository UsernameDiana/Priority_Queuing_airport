package queues;

/**
 * Contract for a Queue abstract data structure.
 * @param <T> the type of the queues items.
 * @author Marjahan Begum
 */
public interface Queue<T> {

    /**
     * Enqueue an item.
     * Add an element to the tail of the queue.
     * @param item to enqueue
     */
    void enqueue(T item);

    /**
     * Dequeue an item.
     * Removes the item at the head of the queue and returns it.
     * @return the item dequeued
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue();

    /**
     * Peek at the first item in the queue.
     * @return the item at the head of the queue
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    T peek();

    /**
     * Size of the queue.
     * @return the number of items currently in the queue.
     */
    int size();

    /**
     * Is the queue empty.
     * @return whether the queue is empty.
     */
    default boolean isEmpty() { return size() == 0 ; }
    }
