Question C
At Ormuco, we want to optimize every bits of software we write.
 Your goal is to write a new library that can be integrated to the Ormuco stack. 
Dealing with network issues everyday, latency is our biggest problem. 
Thus, your challenge is to write a new Geo Distributed LRU (Least Recently Used) cache with time expiration. 
This library will be used extensively by many of our services so it needs to meet the following criteria:
 
    1 - Simplicity. Integration needs to be dead simple.
    2 - Resilient to network failures or crashes.
    3 - Near real time replication of data across Geolocation. Writes need to be in real time.
    4 - Data consistency across regions
    5 - Locality of reference, data should almost always be available from the closest region
    6 - Flexible Schema
    7 - Cache can expire 

Inside this file is the implementation of an LRU cache. The cache takes out the least recently used items first.
This implementation is uses a hashset to store the data ( in this case they are just assumed to be 
but can be generalized to other data structures) and a double queue to keep track of "time elements are in the cache".

The implementation runs in big O(n) since it utilizes the hashset and a double queue, it is actually more optimized
then big O(n) because of the use of iterators to go through the queue. 

Distribution: 
It is quite unclear what the situation is, more information would be required to know which distribution strategy
should be taken. 

Depending on the current case and amount of users of the cache, Master/slave strategy can be used. In this case the 1 cache 
is the master of many different slaves and when the master changes all slaves changes as well. This is not very scalable 
but can be useful when it comes to data integrity and security. 

Another version would be gossip, this means that all caches are connected to each other and when one changes then it starts 
telling the other caches to update one by one but as the caches update they ask other caches to update as well and so on. This
strategy is also useful as it can be very quick when used on large databases but the problem is data redundency. The caches would
have try to update when they are already  update quite frequently and this is not desired in a caching system but can still be used 
when having a small database and will yeild better results than master/slave on small data bases. 

