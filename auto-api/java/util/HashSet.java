package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -5024744406713321676L;
    transient HashMap<E, HashSet<E>> backingMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.406 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "51105255FD1D1F45CB19702D8D92A453")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet() {
        this(new HashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.406 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "D3C5A9A5B3DAC3801CD8688DE6189E7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(int capacity) {
        this(new HashMap<E, HashSet<E>>(capacity));
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.406 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "9BB9B8846198EDF5A409D9C680695F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(int capacity, float loadFactor) {
        this(new HashMap<E, HashSet<E>>(capacity, loadFactor));
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "2A8311B11F7F341437DE03DADC4B8402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(Collection<? extends E> collection) {
        this(new HashMap<E, HashSet<E>>(collection.size() < 6 ? 11 : collection
                .size() * 2));
        dsTaint.addTaint(collection.dsTaint);
        {
            Iterator<? extends E> seatecAstronomy42 = collection.iterator();
            seatecAstronomy42.hasNext();
            E e = seatecAstronomy42.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "E342B4C28FF1228E645266A599B94DF9")
    @DSModeled(DSC.SAFE)
     HashSet(HashMap<E, HashSet<E>> backingMap) {
        dsTaint.addTaint(backingMap.dsTaint);
        // ---------- Original Method ----------
        //this.backingMap = backingMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "13469234005B95B45B060FD6999EEF09", hash_generated_method = "7BDE29FD03C88E8304F2D73B20A5DB9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var8C10435A54E49E00A369089D9EF8265A_193518404 = (backingMap.put(object, this) == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.put(object, this) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "11FE5BA0DA1DA371CC6C1930308D6419")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "863679A3C7BA3AE8B60B370E5B853213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        try 
        {
            HashSet<E> clone;
            clone = (HashSet<E>) super.clone();
            clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "90FEA8D4AD54A41B6A2209F1F4B62B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var8C8A172B56440FCA5388504D06A94C78_5081084 = (backingMap.containsKey(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "CC53646577E295FD850D7A5BB16A8B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_84037981 = (backingMap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "5EEA10D5A12E6AA886BD36322043CEBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var293C31D1F85E54807389D3B230374261_430144064 = (backingMap.keySet().iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "7C3C8372897DC38054171F86CF8C3C6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var98D11DCD88E6747113E0C18E00445AFD_2134369219 = (backingMap.remove(object) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "FD71F9BF3F53FD37887BE999AFF3ED10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_1269586099 = (backingMap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "CAD4A3BA3668A34F4B9B913B59752B33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(backingMap.table.length);
        stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        stream.writeInt(size());
        {
            Iterator<E> seatecAstronomy42 = this.iterator();
            seatecAstronomy42.hasNext();
            E e = seatecAstronomy42.next();
            {
                stream.writeObject(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(backingMap.table.length);
        //stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        //stream.writeInt(size());
        //for (E e : this) {
            //stream.writeObject(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "7EB46E3369E9160BD2C3A9F7A50600E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        int length;
        length = stream.readInt();
        float loadFactor;
        loadFactor = stream.readFloat();
        backingMap = createBackingMap(length, loadFactor);
        int elementCount;
        elementCount = stream.readInt();
        {
            int i;
            i = elementCount;
            {
                E key;
                key = (E) stream.readObject();
                backingMap.put(key, this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //int length = stream.readInt();
        //float loadFactor = stream.readFloat();
        //backingMap = createBackingMap(length, loadFactor);
        //int elementCount = stream.readInt();
        //for (int i = elementCount; --i >= 0;) {
            //E key = (E) stream.readObject();
            //backingMap.put(key, this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.407 -0400", hash_original_method = "A913AB5E1402F7BC175E965B0D92FA39", hash_generated_method = "D3AC150B20E2B269843203743CE65AEB")
    @DSModeled(DSC.SAFE)
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        return (HashMap<E, HashSet<E>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
}


