package Cache;

public class Main {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.getFromCache(15);
        lruCache.display();
        lruCache.getFromCache(35);
        lruCache.display();
        lruCache.getFromCache(32);
        lruCache.display();
        lruCache.getFromCache(15);
        lruCache.display();
        lruCache.getFromCache(80);
        lruCache.display();
        lruCache.getFromCache(102);
        lruCache.display();
    }
}