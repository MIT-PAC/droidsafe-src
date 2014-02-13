package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

import libcore.util.EmptyArray;

public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {

    /**
     * This method was extracted to encourage VM to inline callers.
     * TODO: when we have a VM that can actually inline, move the test in here too!
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.923 -0500", hash_original_method = "4D1AAFD088944D073F1D6AEA9907E5AD", hash_generated_method = "7B46C8F09C7254045F5048910CD6EB03")
    
static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.994 -0500", hash_original_field = "3AA5C0C0296B47F3F0330027910A6EB1", hash_generated_field = "E089B2B162ABB353A6199922AA057C3E")

    private static final long serialVersionUID = 8683452581122892189L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.898 -0500", hash_original_field = "3E4C52F6F0428C39E4E692D20A9AA9AA", hash_generated_field = "7675584818BEF48C593B15A4C030F967")

    transient Object[] array;
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.819 -0400", hash_original_method = "3E3801877D646C78E965A019C35437FB", hash_generated_method = "E5A14EE03FC08BF10B9F1780BA42710D")
    public  ArrayList(int capacity) {
        if(capacity < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_866917787 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_866917787.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_866917787;
        } //End block
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.820 -0400", hash_original_method = "A7503C07B95C656689F43518416554F0", hash_generated_method = "A3AEAA024802F16BF2F719D937C47F2E")
    public  ArrayList() {
        array = collectionData;
        // ---------- Original Method ----------
        //array = EmptyArray.OBJECT;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.820 -0400", hash_original_method = "AE7C60C91D4192AC5637CB5677158233", hash_generated_method = "D918CF514940FBDA5D9A59D94625E26F")
    public  ArrayList(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        super.addAll(collection);
        
        // ---------- Original Method ----------
        //Object[] a = collection.toArray();
        //if (a.getClass() != Object[].class) {
            //Object[] newArray = new Object[a.length];
            //System.arraycopy(a, 0, newArray, 0, a.length);
            //a = newArray;
        //}
        //array = a;
        //size = a.length;
    }

    /**
     * Returns a new {@code ArrayList} with the same elements, the same size and
     * the same capacity as this {@code ArrayList}.
     *
     * @return a shallow copy of this {@code ArrayList}
     * @see java.lang.Cloneable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.928 -0500", hash_original_method = "B3DA051C4891B8092C007B9652169D27", hash_generated_method = "A66D91953438B3767055934DA3E96394")
    
@Override public Object clone() {
        try {
            ArrayList<?> result = (ArrayList<?>) super.clone();
            result.array = array.clone();
            return result;
        } catch (CloneNotSupportedException e) {
           throw new AssertionError();
        }
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.827 -0400", hash_original_method = "0AF2E3B013DB3C28C26CEAAD130BA61A", hash_generated_method = "8998FC02A06EB07E3D275DF69BC11A86")
    public void ensureCapacity(int minimumCapacity) {
        addTaint(minimumCapacity);
        Object[] a = collectionData;
        if(a.length < minimumCapacity)        
        {
            Object[] newArray = new Object[minimumCapacity];
            System.arraycopy(a, 0, newArray, 0, size());
            collectionData = (E[])newArray;
        } //End block
        // ---------- Original Method ----------
        //Object[] a = array;
        //if (a.length < minimumCapacity) {
            //Object[] newArray = new Object[minimumCapacity];
            //System.arraycopy(a, 0, newArray, 0, size);
            //array = newArray;
            //modCount++;
        //}
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.828 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "0ABC8B8351EE3042A7F1E1EBEB6EC6D1")
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.835 -0400", hash_original_method = "7330C01325C25FBEA000A4F3E32D26DF", hash_generated_method = "35C199892565BFAF814A1B11E3CF926D")
    public void trimToSize() {
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.836 -0400", hash_original_method = "5DBD6A40EED7E4F643FF32288E994D2A", hash_generated_method = "0AAE6C1E71A08E82CD075C5ACA4F4AC3")
    @Override
    public int hashCode() {
        Object[] a = collectionData;
        int hashCode = 1;
        for(int i = 0, s = size();i < s;i++)
        {
            Object e = a[i];
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_519419567 = (hashCode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497678346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497678346;
        // ---------- Original Method ----------
        //Object[] a = array;
        //int hashCode = 1;
        //for (int i = 0, s = size; i < s; i++) {
            //Object e = a[i];
            //hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        //}
        //return hashCode;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.837 -0400", hash_original_method = "B6BBD42460E139DEDE8E165726366EA3", hash_generated_method = "D4C09056C6EE738803BED4E24FA86358")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
            return true;
        
        if (o instanceof AbstractCollection)
            return isEqualTo(o);
        return getTaintBoolean();
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.838 -0400", hash_original_method = "291F806CA114E9A8DDD079DF7CDB05EA", hash_generated_method = "5F8684799088AA1AFC2FFB96C7FF18A5")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(size());
        for(int i = 0;i < size();i++)
        {
            stream.writeObject(getElementAt(i));
        } //End block
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(array.length);
        //for (int i = 0; i < size; i++) {
            //stream.writeObject(array[i]);
        //}
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.838 -0400", hash_original_method = "07E10AF7F234C75E84F0879D60F4FA74", hash_generated_method = "DA922EE1034AA093E4D9526E4E5FE819")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int cap = stream.readInt();

        if (DroidSafeAndroidRuntime.control)
        {
            InvalidObjectException var273D26CAC01DC448104B1EC1CDD9496E_2047464109 = new InvalidObjectException(
                    "Capacity: " + cap + " < size: ");
            var273D26CAC01DC448104B1EC1CDD9496E_2047464109.addTaint(taint);
            throw var273D26CAC01DC448104B1EC1CDD9496E_2047464109;
        } //End block
        for(int i = 0;i < cap;i++)
        {
            add((E)stream.readObject());
        } //End block
        // ---------- Original Method ----------
    }

   @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    
    public E get(int location) {
        // TODO Auto-generated method stub
        return getElementAt(location);
    }
    
}

