package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Observable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.589 -0500", hash_original_field = "41AF525BC2711909B8EC72BCD38DAB21", hash_generated_field = "41AF525BC2711909B8EC72BCD38DAB21")


    List<Observer> observers = new ArrayList<Observer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.591 -0500", hash_original_field = "86D4CFFA7EBA3EB225296DE0D42F7D11", hash_generated_field = "86D4CFFA7EBA3EB225296DE0D42F7D11")


    boolean changed = false;

    /**
     * Constructs a new {@code Observable} object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.594 -0500", hash_original_method = "88DD44E29F0E251AC2213FB1D624DCBA", hash_generated_method = "5E773864FBF02F62D708D93F9DBCDF62")
    
public Observable() {
    }

    /**
     * Adds the specified observer to the list of observers. If it is already
     * registered, it is not added a second time.
     *
     * @param observer
     *            the Observer to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.597 -0500", hash_original_method = "7F4B810E9804FBBDFC86C2FF467D8B0D", hash_generated_method = "8B1F59C259D35D31F112C0FD4763D4E1")
    
public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        synchronized (this) {
            if (!observers.contains(observer))
                observers.add(observer);
        }
    }

    /**
     * Clears the changed flag for this {@code Observable}. After calling
     * {@code clearChanged()}, {@code hasChanged()} will return {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.600 -0500", hash_original_method = "410A33FBB0A048736175F5104AE7D39A", hash_generated_method = "F78F4C590DC7E1416A1121EC8F8C019C")
    
protected void clearChanged() {
        changed = false;
    }

    /**
     * Returns the number of observers registered to this {@code Observable}.
     *
     * @return the number of observers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.603 -0500", hash_original_method = "CFCBAA05968B3A0ECDA4D23DDF121D1B", hash_generated_method = "0CD87132BA95204888843AC71A11DAE3")
    
public int countObservers() {
        return observers.size();
    }

    /**
     * Removes the specified observer from the list of observers. Passing null
     * won't do anything.
     *
     * @param observer
     *            the observer to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.605 -0500", hash_original_method = "37D0CFFA6009C52C8BE86CC33940023B", hash_generated_method = "4E14BD5B4577205A399E1A6905E22394")
    
public synchronized void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Removes all observers from the list of observers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.608 -0500", hash_original_method = "FC084068D16B3C6E3AABFF0B17369D5A", hash_generated_method = "516AD3A9AF46A80686B3853FFB23ECAF")
    
public synchronized void deleteObservers() {
        observers.clear();
    }

    /**
     * Returns the changed flag for this {@code Observable}.
     *
     * @return {@code true} when the changed flag for this {@code Observable} is
     *         set, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.610 -0500", hash_original_method = "CA74254130B5D4534FA6EDAB1417F30F", hash_generated_method = "94F9BB4FA2505C9C6C0E2397225D1BE7")
    
public boolean hasChanged() {
        return changed;
    }

    /**
     * If {@code hasChanged()} returns {@code true}, calls the {@code update()}
     * method for every observer in the list of observers using null as the
     * argument. Afterwards, calls {@code clearChanged()}.
     * <p>
     * Equivalent to calling {@code notifyObservers(null)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.613 -0500", hash_original_method = "5B2E81F3B40545D89DF9F8469B767022", hash_generated_method = "8460C65420F7AF281D5B0F32A151A40F")
    
public void notifyObservers() {
        notifyObservers(null);
    }

    /**
     * If {@code hasChanged()} returns {@code true}, calls the {@code update()}
     * method for every Observer in the list of observers using the specified
     * argument. Afterwards calls {@code clearChanged()}.
     *
     * @param data
     *            the argument passed to {@code update()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.616 -0500", hash_original_method = "4CD1425B7C28EDF2D5ACE30F9808C0D0", hash_generated_method = "EC7C67FD5E895F7D590D66488785653C")
    
@SuppressWarnings("unchecked")
    public void notifyObservers(Object data) {
        int size = 0;
        Observer[] arrays = null;
        synchronized (this) {
            if (hasChanged()) {
                clearChanged();
                size = observers.size();
                arrays = new Observer[size];
                observers.toArray(arrays);
            }
        }
        if (arrays != null) {
            for (Observer observer : arrays) {
                observer.update(this, data);
            }
        }
    }

    /**
     * Sets the changed flag for this {@code Observable}. After calling
     * {@code setChanged()}, {@code hasChanged()} will return {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.619 -0500", hash_original_method = "87048075CC64F75CF8DABD03B4BB9693", hash_generated_method = "3A50DCFBE1B72568E1E93A13984B5DAF")
    
protected void setChanged() {
        changed = true;
    }

    
}

