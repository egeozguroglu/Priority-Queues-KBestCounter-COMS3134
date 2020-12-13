Columbia University - Data Structures in Java (COMS3134) - Programming Project 4, Part 2- Fall 2020

## K-Best Values - 30 points

Find the k-best (i.e. largest) values in a set of data. Assume you are given a sequence of values, one value at a time. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
```KBestCounter<T extends Comparable<? super T>> implements KBest<T>``` that keeps track of the k-largest elements seen so far in a sequence of data. The class should have two methods and a constructor:

* ```public KBestCounter(int k)``` - This is your constructor.  It should take in an int k that indicates the amount of largest elements you want to return. The constructor isn't explicitly specified in the KBest interface, but you must have it exactly like this for your program to be graded.

* ```public void count(T x)``` - process the next element in the set of data. This operation must run in at worst `O(log k)` time.

* ```public List<T> kbest()``` - return a sorted (smallest to largest) list of the k-largest elements. This must run in at worst `O(k log k)` time. The method must not clobber the state of your class. This means that if you run this method twice in a row, it should return the same values.

Your `KBestCounter.java` class must implement the provided interface `KBest.java`.

Use a priority queue to implement this functionality. We suggest using the built-in `java.util.PriorityQueue`.

As always, feel free to implement your own tester file to ensure proper functionality.
