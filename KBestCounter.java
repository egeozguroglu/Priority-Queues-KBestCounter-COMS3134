import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
    
    private int k;
    private PriorityQueue<T> minHeap;
    
    public KBestCounter(int k){
        // if the k value is negative, report an exception and terminate the program.
        if(k < 0){
            System.err.println("Exception: the specified k value is negative.");
            System.exit(-1);
        }
        this.k = k;
        minHeap = new PriorityQueue<T>();
    }
    // keeps track of the k largest elements that pass through.
    // strategy: if minHeap's size is less than k, just add.
    // if minHeap's size >= k, and if x > minimum, remove the minimum (poll), 
    // then add x (i.e., replace the minimum with x).
    // worst case complexity: O(log k) time (due to the insert into the PQ)
    public void count(T x){
        if(minHeap.size() < k){
            minHeap.add(x);
        }
        else if((minHeap.size() >= k) && (k > 0)){
            T minimum = minHeap.peek();
            if(x.compareTo(minimum) > 0){
                minHeap.poll();
                minHeap.add(x);
            }
        }
    }
    // returns a sorted (smallest to largest) list of the k-largest elements. 
    // worst case time complexity: O(k log k) 
    // This is due to k deleteMin (poll) operations, each of which is O(log k).
    public List<T> kbest(){
        LinkedList<T> kBest = new LinkedList<T>();
        // if the k value is 0, return an empty list:
        if(k == 0){
            return kBest;
        }
        for(int i = 0; i < k; i++){
            if(minHeap.peek() != null){
                // linkedList.add is O(1) time, adds at at the end of the linkedList. 
                kBest.add(minHeap.poll()); 
            }    
        }
        // restore the minHeap so that the method doesn't clobber the state of the class.
        for(T item : kBest){
            minHeap.add(item);
        }
        return kBest;
    }  
}