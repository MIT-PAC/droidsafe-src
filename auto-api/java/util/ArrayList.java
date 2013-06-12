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
    private static final int MIN_CAPACITY_INCREMENT = 12;
    int size;
    transient Object[] array;
    private static final long serialVersionUID = 8683452581122892189L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.284 -0400", hash_original_method = "3E3801877D646C78E965A019C35437FB", hash_generated_method = "7A2995C6301F827DEA567B8ABE83D22B")
    @DSModeled(DSC.SAFE)
    public ArrayList(int capacity) {
        dsTaint.addTaint(capacity);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        array = (capacity == 0 ? EmptyArray.OBJECT : new Object[capacity]);
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException();
        //}
        //array = (capacity == 0 ? EmptyArray.OBJECT : new Object[capacity]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.287 -0400", hash_original_method = "A7503C07B95C656689F43518416554F0", hash_generated_method = "AD90B9E15CF17407A56198DED73AF45B")
    @DSModeled(DSC.SAFE)
    public ArrayList() {
        array = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //array = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.295 -0400", hash_original_method = "AE7C60C91D4192AC5637CB5677158233", hash_generated_method = "F7E9834C0A6BCBC9AD631BB5F2114A1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] a;
        a = collection.toArray();
        {
            boolean var16F77EF61B9474A82FE398A385F0E9B1_214520878 = (a.getClass() != Object[].class);
            {
                Object[] newArray;
                newArray = new Object[a.length];
                System.arraycopy(a, 0, newArray, 0, a.length);
                a = newArray;
            } //End block
        } //End collapsed parenthetic
        array = a;
        size = a.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.308 -0400", hash_original_method = "2E95EC775538EB90DD9A0EBE35FC856F", hash_generated_method = "A1EB8C6F9F90682A05B8DD040A4A7600")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            Object[] newArray;
            newArray = new Object[s +
                    (s < (MIN_CAPACITY_INCREMENT / 2) ?
                     MIN_CAPACITY_INCREMENT : s >> 1)];//DSFIXME:  CODE0008: Nested ternary operator in expression
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } //End block
        a[s] = object;
        size = s + 1;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (s == a.length) {
            //Object[] newArray = new Object[s +
                    //(s < (MIN_CAPACITY_INCREMENT / 2) ?
                     //MIN_CAPACITY_INCREMENT : s >> 1)];
            //System.arraycopy(a, 0, newArray, 0, s);
            //array = a = newArray;
        //}
        //a[s] = object;
        //size = s + 1;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.323 -0400", hash_original_method = "C5A93B072C15A6072F87F254E0F87786", hash_generated_method = "D009381A66B49FF90571454A354B6A65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void add(int index, E object) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        {
            System.arraycopy(a, index, a, index + 1, s - index);
        } //End block
        {
            Object[] newArray;
            newArray = new Object[newCapacity(s)];
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(a, index, newArray, index + 1, s - index);
            array = a = newArray;
        } //End block
        a[index] = object;
        size = s + 1;
        modCount++;
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (index > s || index < 0) {
            //throwIndexOutOfBoundsException(index, s);
        //}
        //if (s < a.length) {
            //System.arraycopy(a, index, a, index + 1, s - index);
        //} else {
            //Object[] newArray = new Object[newCapacity(s)];
            //System.arraycopy(a, 0, newArray, 0, index);
            //System.arraycopy(a, index, newArray, index + 1, s - index);
            //array = a = newArray;
        //}
        //a[index] = object;
        //size = s + 1;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.333 -0400", hash_original_method = "61CF61C733A8B4DAC5325EEC5949E789", hash_generated_method = "C8308802B3A1E21392326BA991E90412")
    private static int newCapacity(int currentCapacity) {
        int increment = (currentCapacity < (MIN_CAPACITY_INCREMENT / 2) ?
                MIN_CAPACITY_INCREMENT : currentCapacity >> 1);
        return currentCapacity + increment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.339 -0400", hash_original_method = "C337453C40DBE6A93E9B9333DA2BDDBD", hash_generated_method = "1896D12F21318287106E55A45B781C0C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] newPart;
        newPart = collection.toArray();
        int newPartSize;
        newPartSize = newPart.length;
        Object[] a;
        a = array;
        int s;
        s = size;
        int newSize;
        newSize = s + newPartSize;
        {
            int newCapacity;
            newCapacity = newCapacity(newSize - 1);
            Object[] newArray;
            newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } //End block
        System.arraycopy(newPart, 0, a, s, newPartSize);
        size = newSize;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] newPart = collection.toArray();
        //int newPartSize = newPart.length;
        //if (newPartSize == 0) {
            //return false;
        //}
        //Object[] a = array;
        //int s = size;
        //int newSize = s + newPartSize;
        //if (newSize > a.length) {
            //int newCapacity = newCapacity(newSize - 1);  
            //Object[] newArray = new Object[newCapacity];
            //System.arraycopy(a, 0, newArray, 0, s);
            //array = a = newArray;
        //}
        //System.arraycopy(newPart, 0, a, s, newPartSize);
        //size = newSize;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.360 -0400", hash_original_method = "878D1F0A34AD7389A9EB37A1AF5C813D", hash_generated_method = "B14401B233AC9496D8A6F0FDEE052365")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(collection.dsTaint);
        int s;
        s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        Object[] newPart;
        newPart = collection.toArray();
        int newPartSize;
        newPartSize = newPart.length;
        Object[] a;
        a = array;
        int newSize;
        newSize = s + newPartSize;
        {
            System.arraycopy(a, index, a, index + newPartSize, s - index);
        } //End block
        {
            int newCapacity;
            newCapacity = newCapacity(newSize - 1);
            Object[] newArray;
            newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(a, index, newArray, index + newPartSize, s-index);
            array = a = newArray;
        } //End block
        System.arraycopy(newPart, 0, a, index, newPartSize);
        size = newSize;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.391 -0400", hash_original_method = "4D1AAFD088944D073F1D6AEA9907E5AD", hash_generated_method = "7B46C8F09C7254045F5048910CD6EB03")
    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.394 -0400", hash_original_method = "C8A90352D37E56C32915D97A4B0A7D28", hash_generated_method = "D5A68F52AA75340A3F5C68CFBE0401A1")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        {
            Arrays.fill(array, 0, size, null);
            size = 0;
            modCount++;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(array, 0, size, null);
            //size = 0;
            //modCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.397 -0400", hash_original_method = "B3DA051C4891B8092C007B9652169D27", hash_generated_method = "66B84275CE04589DC9FDA1A58A75A5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            ArrayList<?> result;
            result = (ArrayList<?>) super.clone();
            result.array = array.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //ArrayList<?> result = (ArrayList<?>) super.clone();
            //result.array = array.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
           //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.407 -0400", hash_original_method = "0AF2E3B013DB3C28C26CEAAD130BA61A", hash_generated_method = "C1EAED49034F3C287782D84588C3F13D")
    @DSModeled(DSC.SAFE)
    public void ensureCapacity(int minimumCapacity) {
        dsTaint.addTaint(minimumCapacity);
        Object[] a;
        a = array;
        {
            Object[] newArray;
            newArray = new Object[minimumCapacity];
            System.arraycopy(a, 0, newArray, 0, size);
            array = newArray;
            modCount++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.412 -0400", hash_original_method = "BE11B967A1A0587EBAE1CDD4CD567558", hash_generated_method = "7EC4169F21325C2842549A6883C23F9F")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        dsTaint.addTaint(index);
        {
            throwIndexOutOfBoundsException(index, size);
        } //End block
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index >= size) {
            //throwIndexOutOfBoundsException(index, size);
        //}
        //return (E) array[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.421 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D93308C9204B4F7B72696D16CFAD067E")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.428 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "F6C7B08EFA5C7EF5C4F8802990711F9E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.433 -0400", hash_original_method = "64966ED2F2DBD125FF02B9B2F4262D7F", hash_generated_method = "55EC06368CA0AF040976C06EBFC72F9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_691243546 = (object.equals(a[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (object != null) {
            //for (int i = 0; i < s; i++) {
                //if (object.equals(a[i])) {
                    //return true;
                //}
            //}
        //} else {
            //for (int i = 0; i < s; i++) {
                //if (a[i] == null) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.451 -0400", hash_original_method = "0D1C6275419222204CF4CD7DEABF4627", hash_generated_method = "333DFF4E55B981B275BF0E415FA47101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_863797638 = (object.equals(a[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (object != null) {
            //for (int i = 0; i < s; i++) {
                //if (object.equals(a[i])) {
                    //return i;
                //}
            //}
        //} else {
            //for (int i = 0; i < s; i++) {
                //if (a[i] == null) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.456 -0400", hash_original_method = "A33DDE97246530740ADA37CC6A9CC384", hash_generated_method = "D019C1066CB634FAFB04A4394BD417B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        {
            {
                int i;
                i = size - 1;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_3654200 = (object.equals(a[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = size - 1;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] a = array;
        //if (object != null) {
            //for (int i = size - 1; i >= 0; i--) {
                //if (object.equals(a[i])) {
                    //return i;
                //}
            //}
        //} else {
            //for (int i = size - 1; i >= 0; i--) {
                //if (a[i] == null) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.470 -0400", hash_original_method = "A1787B19405DA1FA0654C3278265A2A8", hash_generated_method = "5621BB04E1020E259AA59610F77BB48F")
    @DSModeled(DSC.SAFE)
    @Override
    public E remove(int index) {
        dsTaint.addTaint(index);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        @SuppressWarnings("unchecked") E result;
        result = (E) a[index];
        System.arraycopy(a, index + 1, a, index, --s - index);
        a[s] = null;
        size = s;
        modCount++;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (index >= s) {
            //throwIndexOutOfBoundsException(index, s);
        //}
        //@SuppressWarnings("unchecked") E result = (E) a[index];
        //System.arraycopy(a, index + 1, a, index, --s - index);
        //a[s] = null;
        //size = s;
        //modCount++;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.483 -0400", hash_original_method = "C2B3C3C4D1766953FF0E432D86502585", hash_generated_method = "B20462040DD1537CB83706F7A9C0B873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_65152182 = (object.equals(a[i]));
                        {
                            System.arraycopy(a, i + 1, a, i, --s - i);
                            a[s] = null;
                            size = s;
                            modCount++;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    {
                        System.arraycopy(a, i + 1, a, i, --s - i);
                        a[s] = null;
                        size = s;
                        modCount++;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int s = size;
        //if (object != null) {
            //for (int i = 0; i < s; i++) {
                //if (object.equals(a[i])) {
                    //System.arraycopy(a, i + 1, a, i, --s - i);
                    //a[s] = null;  
                    //size = s;
                    //modCount++;
                    //return true;
                //}
            //}
        //} else {
            //for (int i = 0; i < s; i++) {
                //if (a[i] == null) {
                    //System.arraycopy(a, i + 1, a, i, --s - i);
                    //a[s] = null;  
                    //size = s;
                    //modCount++;
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.498 -0400", hash_original_method = "D866DECE8E8344A6C98BF327EDBE1AFF", hash_generated_method = "3C716C63C0732C5276139A79C2564B06")
    @DSModeled(DSC.SAFE)
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
        Object[] a;
        a = array;
        int s;
        s = size;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " >= size " + size);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("toIndex " + toIndex
                    + " > size " + size);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " > toIndex " + toIndex);
        } //End block
        System.arraycopy(a, toIndex, a, fromIndex, s - toIndex);
        int rangeSize;
        rangeSize = toIndex - fromIndex;
        Arrays.fill(a, s - rangeSize, s, null);
        size = s - rangeSize;
        modCount++;
        // ---------- Original Method ----------
        //if (fromIndex == toIndex) {
            //return;
        //}
        //Object[] a = array;
        //int s = size;
        //if (fromIndex >= s) {
            //throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    //+ " >= size " + size);
        //}
        //if (toIndex > s) {
            //throw new IndexOutOfBoundsException("toIndex " + toIndex
                    //+ " > size " + size);
        //}
        //if (fromIndex > toIndex) {
            //throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    //+ " > toIndex " + toIndex);
        //}
        //System.arraycopy(a, toIndex, a, fromIndex, s - toIndex);
        //int rangeSize = toIndex - fromIndex;
        //Arrays.fill(a, s - rangeSize, s, null);
        //size = s - rangeSize;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.506 -0400", hash_original_method = "F03306481ED210492B573188BD80D78C", hash_generated_method = "6447C1F79510835CCF161B1EFAC3DB60")
    @DSModeled(DSC.SAFE)
    @Override
    public E set(int index, E object) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(object.dsTaint);
        Object[] a;
        a = array;
        {
            throwIndexOutOfBoundsException(index, size);
        } //End block
        @SuppressWarnings("unchecked") E result;
        result = (E) a[index];
        a[index] = object;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] a = array;
        //if (index >= size) {
            //throwIndexOutOfBoundsException(index, size);
        //}
        //@SuppressWarnings("unchecked") E result = (E) a[index];
        //a[index] = object;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.517 -0400", hash_original_method = "52977A01663ACB51F489F59A603BA7D4", hash_generated_method = "43E505F427D20248EA4417A6705CAA71")
    @DSModeled(DSC.SAFE)
    @Override
    public Object[] toArray() {
        int s;
        s = size;
        Object[] result;
        result = new Object[s];
        System.arraycopy(array, 0, result, 0, s);
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int s = size;
        //Object[] result = new Object[s];
        //System.arraycopy(array, 0, result, 0, s);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.522 -0400", hash_original_method = "C3B471E5DAFB04B40866B17E5BAEF530", hash_generated_method = "7D8A3AE2B3E73DF3F9F98BF02F22C86C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents[0].dsTaint);
        int s;
        s = size;
        {
            @SuppressWarnings("unchecked") T[] newArray;
            newArray = (T[]) Array.newInstance(contents.getClass().getComponentType(), s);
            contents = newArray;
        } //End block
        System.arraycopy(this.array, 0, contents, 0, s);
        {
            contents[s] = null;
        } //End block
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int s = size;
        //if (contents.length < s) {
            //@SuppressWarnings("unchecked") T[] newArray
                //= (T[]) Array.newInstance(contents.getClass().getComponentType(), s);
            //contents = newArray;
        //}
        //System.arraycopy(this.array, 0, contents, 0, s);
        //if (contents.length > s) {
            //contents[s] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.529 -0400", hash_original_method = "7330C01325C25FBEA000A4F3E32D26DF", hash_generated_method = "4844CD14BF612319B995CB783AD3E2A2")
    @DSModeled(DSC.SAFE)
    public void trimToSize() {
        int s;
        s = size;
        {
            array = EmptyArray.OBJECT;
        } //End block
        {
            Object[] newArray;
            newArray = new Object[s];
            System.arraycopy(array, 0, newArray, 0, s);
            array = newArray;
        } //End block
        modCount++;
        // ---------- Original Method ----------
        //int s = size;
        //if (s == array.length) {
            //return;
        //}
        //if (s == 0) {
            //array = EmptyArray.OBJECT;
        //} else {
            //Object[] newArray = new Object[s];
            //System.arraycopy(array, 0, newArray, 0, s);
            //array = newArray;
        //}
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.537 -0400", hash_original_method = "CE193891A7B397E3A9A2EF577B10DC50", hash_generated_method = "2B04EF50079F8A3828905567599FA4AE")
    @DSModeled(DSC.SAFE)
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ArrayListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.541 -0400", hash_original_method = "5DBD6A40EED7E4F643FF32288E994D2A", hash_generated_method = "653BE8E8A8C4E24F246244C15CBA86A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        Object[] a;
        a = array;
        int hashCode;
        hashCode = 1;
        {
            int i, s;
            i = 0;
            s = size;
            {
                Object e;
                e = a[i];
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] a = array;
        //int hashCode = 1;
        //for (int i = 0, s = size; i < s; i++) {
            //Object e = a[i];
            //hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.553 -0400", hash_original_method = "B6BBD42460E139DEDE8E165726366EA3", hash_generated_method = "73ABC1E82ACC3D5CD4987FE7A57AF560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        List<?> that;
        that = (List<?>) o;
        int s;
        s = size;
        {
            boolean var6DDD04FB5A8F18C16A04CEB45843304E_99095951 = (that.size() != s);
        } //End collapsed parenthetic
        Object[] a;
        a = array;
        {
            {
                int i;
                i = 0;
                {
                    Object eThis;
                    eThis = a[i];
                    Object ethat;
                    ethat = that.get(i);
                    {
                        {
                            boolean varEBC000A495141DDD1C176F0EB6DDFA1C_20524999 = (!eThis.equals(ethat));
                        } //End flattened ternary
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Iterator<?> it;
            it = that.iterator();
            {
                int i;
                i = 0;
                {
                    Object eThis;
                    eThis = a[i];
                    Object eThat;
                    eThat = it.next();
                    {
                        {
                            boolean var76B138E21032A28626298252682756E4_1707146815 = (!eThis.equals(eThat));
                        } //End flattened ternary
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.555 -0400", hash_original_method = "291F806CA114E9A8DDD079DF7CDB05EA", hash_generated_method = "5C46A683A0C3DA3A7E5099E117368BC4")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(array.length);
        {
            int i;
            i = 0;
            {
                stream.writeObject(array[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(array.length);
        //for (int i = 0; i < size; i++) {
            //stream.writeObject(array[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.560 -0400", hash_original_method = "07E10AF7F234C75E84F0879D60F4FA74", hash_generated_method = "B83CB510599BB758A4AF4C081A21DD10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        int cap;
        cap = stream.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException(
                    "Capacity: " + cap + " < size: " + size);
        } //End block
        array = (cap == 0 ? EmptyArray.OBJECT : new Object[cap]);
        {
            int i;
            i = 0;
            {
                array[i] = stream.readObject();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //int cap = stream.readInt();
        //if (cap < size) {
            //throw new InvalidObjectException(
                    //"Capacity: " + cap + " < size: " + size);
        //}
        //array = (cap == 0 ? EmptyArray.OBJECT : new Object[cap]);
        //for (int i = 0; i < size; i++) {
            //array[i] = stream.readObject();
        //}
    }

    
    private class ArrayListIterator implements Iterator<E> {
        private int remaining = size;
        private int removalIndex = -1;
        private int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.562 -0400", hash_original_method = "44DFBDD5F60969C85FF7C62CEFF63BE1", hash_generated_method = "3002D0D86CAEEC2D9746910659824C16")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return remaining != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.567 -0400", hash_original_method = "4E01EE32653D357535C28CF692990943", hash_generated_method = "167D2ABFEA4FBF8D74852F065BDDF4D9")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings("unchecked")
        public E next() {
            ArrayList<E> ourList;
            ourList = ArrayList.this;
            int rem;
            rem = remaining;
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            remaining = rem - 1;
            E varCE6FD74F76F723ACF6682AB3440C6406_850977820 = ((E) ourList.array[removalIndex = ourList.size - rem]);
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ArrayList<E> ourList = ArrayList.this;
            //int rem = remaining;
            //if (ourList.modCount != expectedModCount) {
                //throw new ConcurrentModificationException();
            //}
            //if (rem == 0) {
                //throw new NoSuchElementException();
            //}
            //remaining = rem - 1;
            //return (E) ourList.array[removalIndex = ourList.size - rem];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:27:39.571 -0400", hash_original_method = "2CA6472AB4D5ED4AA6A79E4E390FB476", hash_generated_method = "5AD16A5D71F291A31AFC5616C92C387D")
        @DSModeled(DSC.SAFE)
        public void remove() {
            Object[] a;
            a = array;
            int removalIdx;
            removalIdx = removalIndex;
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);
            a[--size] = null;
            removalIndex = -1;
            expectedModCount = ++modCount;
            // ---------- Original Method ----------
            //Object[] a = array;
            //int removalIdx = removalIndex;
            //if (modCount != expectedModCount) {
                //throw new ConcurrentModificationException();
            //}
            //if (removalIdx < 0) {
                //throw new IllegalStateException();
            //}
            //System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);
            //a[--size] = null;
            //removalIndex = -1;
            //expectedModCount = ++modCount;
        }

        
    }


    
}


