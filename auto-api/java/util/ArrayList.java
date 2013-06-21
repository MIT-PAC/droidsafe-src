package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import libcore.util.EmptyArray;

public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
    int size;
    transient Object[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.940 -0400", hash_original_method = "3E3801877D646C78E965A019C35437FB", hash_generated_method = "D3B01496D9193658FCC8B4830541B9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.940 -0400", hash_original_method = "A7503C07B95C656689F43518416554F0", hash_generated_method = "A3AEAA024802F16BF2F719D937C47F2E")
    @DSModeled(DSC.SAFE)
    public ArrayList() {
        array = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //array = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.940 -0400", hash_original_method = "AE7C60C91D4192AC5637CB5677158233", hash_generated_method = "08160C317C5AD92DD6EF1D541420F3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] a;
        a = collection.toArray();
        {
            boolean var16F77EF61B9474A82FE398A385F0E9B1_100052516 = (a.getClass() != Object[].class);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.941 -0400", hash_original_method = "2E95EC775538EB90DD9A0EBE35FC856F", hash_generated_method = "2DCC2B61FBFD6ACFE1D28D9B911398CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.941 -0400", hash_original_method = "C5A93B072C15A6072F87F254E0F87786", hash_generated_method = "66B7F13D45104D3BC34979762B5EF7A7")
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

    
        private static int newCapacity(int currentCapacity) {
        int increment = (currentCapacity < (MIN_CAPACITY_INCREMENT / 2) ?
                MIN_CAPACITY_INCREMENT : currentCapacity >> 1);
        return currentCapacity + increment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.941 -0400", hash_original_method = "C337453C40DBE6A93E9B9333DA2BDDBD", hash_generated_method = "A043B239FC2E4FA467353F290435E10A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.942 -0400", hash_original_method = "878D1F0A34AD7389A9EB37A1AF5C813D", hash_generated_method = "6B29E5EA954C61761A78C28CBAEA89C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.942 -0400", hash_original_method = "C8A90352D37E56C32915D97A4B0A7D28", hash_generated_method = "32F9F0A50B6063DF0522FFBEB7BCE20A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        {
            Arrays.fill(array, 0, size, null);
            size = 0;
        } //End block
        // ---------- Original Method ----------
        //if (size != 0) {
            //Arrays.fill(array, 0, size, null);
            //size = 0;
            //modCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.942 -0400", hash_original_method = "B3DA051C4891B8092C007B9652169D27", hash_generated_method = "AF4D3CDCCD315B11E3E5118AE4451F55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.943 -0400", hash_original_method = "0AF2E3B013DB3C28C26CEAAD130BA61A", hash_generated_method = "6EE9F94253220D3FE0CE8A1E0A508F1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ensureCapacity(int minimumCapacity) {
        dsTaint.addTaint(minimumCapacity);
        Object[] a;
        a = array;
        {
            Object[] newArray;
            newArray = new Object[minimumCapacity];
            System.arraycopy(a, 0, newArray, 0, size);
            array = newArray;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.943 -0400", hash_original_method = "BE11B967A1A0587EBAE1CDD4CD567558", hash_generated_method = "A549CD25297EEE705268D99D646B9F31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.943 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.943 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4BEC7A3919A556BE19BE40EE7160C52B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.944 -0400", hash_original_method = "64966ED2F2DBD125FF02B9B2F4262D7F", hash_generated_method = "F93ED80762E09B52AFE1E4CBCB0877E1")
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
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_1837892383 = (object.equals(a[i]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.944 -0400", hash_original_method = "0D1C6275419222204CF4CD7DEABF4627", hash_generated_method = "7F2529FE924361773092641BE6F9B551")
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
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_858890655 = (object.equals(a[i]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.944 -0400", hash_original_method = "A33DDE97246530740ADA37CC6A9CC384", hash_generated_method = "1AEEF26A65F8C9F447A2EDBB66949C04")
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
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_1762776462 = (object.equals(a[i]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.945 -0400", hash_original_method = "A1787B19405DA1FA0654C3278265A2A8", hash_generated_method = "196118BE1DBFAA9DDACC4216656F198E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.945 -0400", hash_original_method = "C2B3C3C4D1766953FF0E432D86502585", hash_generated_method = "CDA90E846CE7C9571D053F644AAA32A6")
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
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_338842624 = (object.equals(a[i]));
                        {
                            System.arraycopy(a, i + 1, a, i, --s - i);
                            a[s] = null;
                            size = s;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.945 -0400", hash_original_method = "D866DECE8E8344A6C98BF327EDBE1AFF", hash_generated_method = "2835E180A7020A51E827B3707E2D471D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.946 -0400", hash_original_method = "F03306481ED210492B573188BD80D78C", hash_generated_method = "EDC57A9050A915B4B7571FB652D719E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.946 -0400", hash_original_method = "52977A01663ACB51F489F59A603BA7D4", hash_generated_method = "D952BD1FC52F4F79BF1F96ABFEA296B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.946 -0400", hash_original_method = "C3B471E5DAFB04B40866B17E5BAEF530", hash_generated_method = "226AEC55019186B0CBF373B1A5BE1B26")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.946 -0400", hash_original_method = "7330C01325C25FBEA000A4F3E32D26DF", hash_generated_method = "647A3F4DBD2005BD55EDFEAA28693BFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.947 -0400", hash_original_method = "CE193891A7B397E3A9A2EF577B10DC50", hash_generated_method = "9E1A83D67C9C708987D590DEBDBD0A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varA4AAFEB17694AFB4C7DE9B9FDFB72025_1886940195 = (new ArrayListIterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ArrayListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.947 -0400", hash_original_method = "5DBD6A40EED7E4F643FF32288E994D2A", hash_generated_method = "F4F115F70277C81596ECE4925FBA7F6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.948 -0400", hash_original_method = "B6BBD42460E139DEDE8E165726366EA3", hash_generated_method = "38660AF1B99E6E1FEFC5B49D9E7E38E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_884722199 = (o == this);
        } //End collapsed parenthetic
        List<?> that;
        that = (List<?>) o;
        int s;
        s = size;
        {
            boolean var6DDD04FB5A8F18C16A04CEB45843304E_1517146024 = (that.size() != s);
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
                            boolean varEBC000A495141DDD1C176F0EB6DDFA1C_1784981435 = (!eThis.equals(ethat));
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
                            boolean var76B138E21032A28626298252682756E4_318460799 = (!eThis.equals(eThat));
                        } //End flattened ternary
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.949 -0400", hash_original_method = "291F806CA114E9A8DDD079DF7CDB05EA", hash_generated_method = "B0A75A75DE4A55F36E784D9046036487")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.949 -0400", hash_original_method = "07E10AF7F234C75E84F0879D60F4FA74", hash_generated_method = "852C01F52C33409816E5CC32C0758BF8")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.949 -0400", hash_original_method = "4A04DAB3D5434D2DCC30DD9E7A7A71D6", hash_generated_method = "4A04DAB3D5434D2DCC30DD9E7A7A71D6")
                public ArrayListIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.950 -0400", hash_original_method = "44DFBDD5F60969C85FF7C62CEFF63BE1", hash_generated_method = "6DD18856E3D7C12C768B32380B04C79D")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return remaining != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.950 -0400", hash_original_method = "4E01EE32653D357535C28CF692990943", hash_generated_method = "12972470A7EAEAFE29516E3DE481EB68")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            E varCE6FD74F76F723ACF6682AB3440C6406_785379084 = ((E) ourList.array[removalIndex = ourList.size - rem]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.951 -0400", hash_original_method = "2CA6472AB4D5ED4AA6A79E4E390FB476", hash_generated_method = "5640C775C14A8753D9585C1BE4ADE039")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final int MIN_CAPACITY_INCREMENT = 12;
    private static final long serialVersionUID = 8683452581122892189L;
}

