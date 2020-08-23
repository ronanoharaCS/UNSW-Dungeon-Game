/**
 *
 */
package unsw.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of Set that uses an ArrayList to store the elements.
 *
 * @invariant All e in elements occur only once
 *
 * @author Robert Clifton-Everest
 *
 */
public class ArrayListSet<E> implements Set<E> {

    private ArrayList<E> elements;

    public ArrayListSet() {
        elements = new ArrayList<>();
    }

    @Override
    public void add(E e) {
        // Add an element to the set. Set unchanged if it already contains element.
        if (elements.contains(e) == true) {
            // element already in set
            return;
        }
        // add new element to set
        elements.add(e);
    }

    @Override
    public void remove(E e) {
        elements.remove(e);
    }

    @Override
    public boolean contains(Object e) {
        return elements.contains(e);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean subsetOf(Set<?> other) {
        // Determine if this set is a subset of another set.
        for (E element : this.elements) {
            // check every element of this set is in other
			if (!other.contains(element)) {
				return false;
			}
		}
		return true;
    }

    @Override
    public Iterator<E> iterator() {
        // return an iterator for the collection
        return elements.iterator();
    }

    @Override
    public Set<E> union(Set<? extends E> other) {
        // Return a new set that is the union of this set and the given set
        ArrayListSet<E> unionSet = new ArrayListSet<E>();
        // make sure you get all the elements from both sets
        // using the add() method avoid repetitions in intersection
        for (E element : this.elements) {
			unionSet.add(element);
		}
		for (E element : other) {
			unionSet.add(element);
		}
		return unionSet;
    }

    @Override
    public Set<E> intersection(Set<? extends E> other) {
        // Return a new set that is the intersection of this set and the given set
        ArrayListSet<E> intersectingSet = new ArrayListSet<E>();
        // only add the elements in common
        for (E element : this.elements) {
			if (other.contains(element)) {
				intersectingSet.add(element);
			}
		}
		return intersectingSet;
    }

    /**
     * For this method, it should be possible to compare all other possible sets
     * for equality with this set. For example, if an ArrayListSet<Fruit> and a
     * LinkedListSet<Fruit> both contain the same elements they are equal.
     * Similarly, if a Set<Apple> contains the same elements as a Set<Fruit>
     * they are also equal.
     */
    @Override
    public boolean equals(Object other) {
        
        // check other is an non null Set
        if (other == null || !(other instanceof Set)){
			return false;
        }
        // is it the same object
		if (other == this) {
			return true;
        }
        
		// eliminate objects of the wrong size
		if (this.size() != ((Set<?>)other).size()) {
			return false;
		}
        // if its the same size -- then subset tests for same elements
        // therefore determines if they are the same
		if (!this.subsetOf((Set<?>)other) || !((Set<?>)other).subsetOf(this)) {
			return false;
		}

        // if it makes it this far it is an equal (but not identical) Set
		return true;
    }

}
