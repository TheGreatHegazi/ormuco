package Cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
    // store keys of cache
    private Deque<Integer> elementQ;
    // store references of key in cache
    private HashSet<Integer> reference;
    // maximum capacity of cache
    private static int size;

    LRUCache(int n) {
        elementQ = new LinkedList<>();
        reference = new HashSet<>();
        size = n;
    }

    public void getFromCache(int x) {
        // if it is in the hash set we create an iterator based on the queue and find
        // the index where it is at after doing so we remove it from the queue
        // and then insert it once again renewing its usage count
        if (reference.contains(x)) {
            int position = 0, i = 0;
            Iterator<Integer> itr = elementQ.iterator();
            while (itr.hasNext()) {
                if (itr.next() == x) {
                    position = i;
                    break;
                }
                i++;
            }
            elementQ.remove(position);
        }
        // if the x is not in the hash set we take out the least recently use element
        else {
            if (elementQ.size() == size) {
                int last = elementQ.removeLast();
                reference.remove(last);
            }
        }
        elementQ.push(x);
        reference.add(x);
    }

    // display contents of cache
    public void display() {
        Iterator<Integer> itr = elementQ.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }


}