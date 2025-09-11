Follow-up Discussion Points


1. How to Handle Concurrency (Multiple Sessions)
Problems:

a) Race conditions when multiple users add same item simultaneously

b) Stock inconsistency

c)  Cart state corruption
 
```
// Approach 1: Synchronized Methods
public synchronized void addItem(String productId, int quantity) throws CartException {
    // Implementation remains same
}


