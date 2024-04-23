package synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafeArrayList<E> {
    private final List<E> list;

    public SafeArrayList() {
        // Use synchronized list to make all operations thread-safe
        list = Collections.synchronizedList(new ArrayList<>());
    }

    // Synchronized method to add an element to the collection
    public synchronized void addElement(E element) {
        list.add(element);
    }

    // Synchronized method to query the size of the collection
    public synchronized int getSize() {
        return list.size();
    }

    // Synchronized method to remove an element from the collection
    public synchronized void removeElement(E element) {
        list.remove(element);
    }
}
