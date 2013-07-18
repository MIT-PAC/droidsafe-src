package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

import libcore.util.EmptyArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.819 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

    int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.819 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "7675584818BEF48C593B15A4C030F967")

    transient Object[] array;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.819 -0400", hash_original_method = "3E3801877D646C78E965A019C35437FB", hash_generated_method = "E5A14EE03FC08BF10B9F1780BA42710D")
    public  ArrayList(int capacity) {
        if(capacity < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_866917787 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_866917787.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_866917787;
        } //End block
        array = (capacity == 0 ? EmptyArray.OBJECT : new Object[capacity]);
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException();
        //}
        //array = (capacity == 0 ? EmptyArray.OBJECT : new Object[capacity]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.820 -0400", hash_original_method = "A7503C07B95C656689F43518416554F0", hash_generated_method = "A3AEAA024802F16BF2F719D937C47F2E")
    public  ArrayList() {
        array = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //array = EmptyArray.OBJECT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.820 -0400", hash_original_method = "AE7C60C91D4192AC5637CB5677158233", hash_generated_method = "D918CF514940FBDA5D9A59D94625E26F")
    public  ArrayList(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        Object[] a = collection.toArray();
        if(a.getClass() != Object[].class)        
        {
            Object[] newArray = new Object[a.length];
            System.arraycopy(a, 0, newArray, 0, a.length);
            a = newArray;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.821 -0400", hash_original_method = "2E95EC775538EB90DD9A0EBE35FC856F", hash_generated_method = "6CD9E83BF4E1B9A9FC575BCC6DC75615")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        Object[] a = array;
        int s = size;
        if(s == a.length)        
        {
            Object[] newArray = new Object[s +
                    (s < (MIN_CAPACITY_INCREMENT / 2) ?
                     MIN_CAPACITY_INCREMENT : s >> 1)];
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } //End block
        a[s] = object;
        size = s + 1;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_729763718 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395374857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395374857;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.822 -0400", hash_original_method = "C5A93B072C15A6072F87F254E0F87786", hash_generated_method = "289598F66BD58A4CDF183A31DF8FD020")
    @Override
    public void add(int index, E object) {
        addTaint(object.getTaint());
        addTaint(index);
        Object[] a = array;
        int s = size;
        if(index > s || index < 0)        
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        if(s < a.length)        
        {
            System.arraycopy(a, index, a, index + 1, s - index);
        } //End block
        else
        {
            Object[] newArray = new Object[newCapacity(s)];
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

    
    @DSModeled(DSC.SAFE)
    private static int newCapacity(int currentCapacity) {
        int increment = (currentCapacity < (MIN_CAPACITY_INCREMENT / 2) ?
                MIN_CAPACITY_INCREMENT : currentCapacity >> 1);
        return currentCapacity + increment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.824 -0400", hash_original_method = "C337453C40DBE6A93E9B9333DA2BDDBD", hash_generated_method = "20A59E59027690AFC4C3395BFC95F78E")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        Object[] newPart = collection.toArray();
        int newPartSize = newPart.length;
        if(newPartSize == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1969168435 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975904626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975904626;
        } //End block
        Object[] a = array;
        int s = size;
        int newSize = s + newPartSize;
        if(newSize > a.length)        
        {
            int newCapacity = newCapacity(newSize - 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } //End block
        System.arraycopy(newPart, 0, a, s, newPartSize);
        size = newSize;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_729949222 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368882097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368882097;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.825 -0400", hash_original_method = "878D1F0A34AD7389A9EB37A1AF5C813D", hash_generated_method = "4837DB10CDA4AB28A7EB015962898B0F")
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(index);
        int s = size;
        if(index > s || index < 0)        
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        Object[] newPart = collection.toArray();
        int newPartSize = newPart.length;
        if(newPartSize == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1453114772 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704055831 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_704055831;
        } //End block
        Object[] a = array;
        int newSize = s + newPartSize;
        if(newSize <= a.length)        
        {
            System.arraycopy(a, index, a, index + newPartSize, s - index);
        } //End block
        else
        {
            int newCapacity = newCapacity(newSize - 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(a, index, newArray, index + newPartSize, s-index);
            array = a = newArray;
        } //End block
        System.arraycopy(newPart, 0, a, index, newPartSize);
        size = newSize;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_664245320 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208574292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208574292;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.826 -0400", hash_original_method = "C8A90352D37E56C32915D97A4B0A7D28", hash_generated_method = "150C6269EC2C3F0E9FA5720F0C7ABF3E")
    @Override
    public void clear() {
        if(size != 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.827 -0400", hash_original_method = "B3DA051C4891B8092C007B9652169D27", hash_generated_method = "FA92824A0A4AC99EF172A7C6DB1ECC56")
    @Override
    public Object clone() {
        try 
        {
            ArrayList<?> result = (ArrayList<?>) super.clone();
            result.array = array.clone();
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1640159609 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1640159609.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1640159609;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1898656167 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1898656167.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1898656167;
        } //End block
        // ---------- Original Method ----------
        //try {
            //ArrayList<?> result = (ArrayList<?>) super.clone();
            //result.array = array.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
           //throw new AssertionError();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.827 -0400", hash_original_method = "0AF2E3B013DB3C28C26CEAAD130BA61A", hash_generated_method = "8998FC02A06EB07E3D275DF69BC11A86")
    public void ensureCapacity(int minimumCapacity) {
        addTaint(minimumCapacity);
        Object[] a = array;
        if(a.length < minimumCapacity)        
        {
            Object[] newArray = new Object[minimumCapacity];
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.827 -0400", hash_original_method = "BE11B967A1A0587EBAE1CDD4CD567558", hash_generated_method = "ED9D51839C95A1B687BA396236BE81E5")
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        addTaint(index);
        if(index >= size)        
        {
            throwIndexOutOfBoundsException(index, size);
        } //End block
E var8F8B973ECC70876B70681A85A3D8E710_574449422 =         (E) array[index];
        var8F8B973ECC70876B70681A85A3D8E710_574449422.addTaint(taint);
        return var8F8B973ECC70876B70681A85A3D8E710_574449422;
        // ---------- Original Method ----------
        //if (index >= size) {
            //throwIndexOutOfBoundsException(index, size);
        //}
        //return (E) array[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.828 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "351FCA2FD26B310E1D7B01723049CBE1")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1583349159 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309419205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309419205;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.828 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "0ABC8B8351EE3042A7F1E1EBEB6EC6D1")
    @Override
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_951390804 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_5900970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_5900970;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.828 -0400", hash_original_method = "64966ED2F2DBD125FF02B9B2F4262D7F", hash_generated_method = "445002FED77BBB4D0F66B2FA99FF4F10")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        Object[] a = array;
        int s = size;
        if(object != null)        
        {
for(int i = 0;i < s;i++)
            {
                if(object.equals(a[i]))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1552508509 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206656539 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_206656539;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < s;i++)
            {
                if(a[i] == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1815385606 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762956817 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762956817;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1206288487 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890989663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890989663;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.829 -0400", hash_original_method = "0D1C6275419222204CF4CD7DEABF4627", hash_generated_method = "63A07F120249FC242B6ECD7F8B6D3184")
    @Override
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        Object[] a = array;
        int s = size;
        if(object != null)        
        {
for(int i = 0;i < s;i++)
            {
                if(object.equals(a[i]))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1898319754 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263732561 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263732561;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < s;i++)
            {
                if(a[i] == null)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_2121544605 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284845353 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284845353;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_566605765 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747564578 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747564578;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.830 -0400", hash_original_method = "A33DDE97246530740ADA37CC6A9CC384", hash_generated_method = "23FB7356E7A734908D202325C2196DF8")
    @Override
    public int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        Object[] a = array;
        if(object != null)        
        {
for(int i = size - 1;i >= 0;i--)
            {
                if(object.equals(a[i]))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_380010439 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929422245 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929422245;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = size - 1;i >= 0;i--)
            {
                if(a[i] == null)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_884140468 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507157398 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507157398;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1892435646 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712597063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712597063;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.831 -0400", hash_original_method = "A1787B19405DA1FA0654C3278265A2A8", hash_generated_method = "3101E502F25B057945008CFA27955322")
    @Override
    public E remove(int index) {
        addTaint(index);
        Object[] a = array;
        int s = size;
        if(index >= s)        
        {
            throwIndexOutOfBoundsException(index, s);
        } //End block
        @SuppressWarnings("unchecked") E result = (E) a[index];
        System.arraycopy(a, index + 1, a, index, --s - index);
        a[s] = null;
        size = s;
        modCount++;
E varDC838461EE2FA0CA4C9BBB70A15456B0_638814118 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_638814118.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_638814118;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.832 -0400", hash_original_method = "C2B3C3C4D1766953FF0E432D86502585", hash_generated_method = "87DEBCA5C7A3C02538F1DB90EAA45E15")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        Object[] a = array;
        int s = size;
        if(object != null)        
        {
for(int i = 0;i < s;i++)
            {
                if(object.equals(a[i]))                
                {
                    System.arraycopy(a, i + 1, a, i, --s - i);
                    a[s] = null;
                    size = s;
                    modCount++;
                    boolean varB326B5062B2F0E69046810717534CB09_212528381 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103401448 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103401448;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < s;i++)
            {
                if(a[i] == null)                
                {
                    System.arraycopy(a, i + 1, a, i, --s - i);
                    a[s] = null;
                    size = s;
                    modCount++;
                    boolean varB326B5062B2F0E69046810717534CB09_1694520895 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259023 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259023;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1921341481 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174323231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174323231;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.833 -0400", hash_original_method = "D866DECE8E8344A6C98BF327EDBE1AFF", hash_generated_method = "0BD88C1C0977D40F10E53313FACF5398")
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        if(fromIndex == toIndex)        
        {
            return;
        } //End block
        Object[] a = array;
        int s = size;
        if(fromIndex >= s)        
        {
            IndexOutOfBoundsException varD09620C5B8EEFE2FBAA8F3DEEEC047D5_2139706464 = new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " >= size " + size);
            varD09620C5B8EEFE2FBAA8F3DEEEC047D5_2139706464.addTaint(taint);
            throw varD09620C5B8EEFE2FBAA8F3DEEEC047D5_2139706464;
        } //End block
        if(toIndex > s)        
        {
            IndexOutOfBoundsException varA4E09801CE838603376DC4663E4D6361_964486812 = new IndexOutOfBoundsException("toIndex " + toIndex
                    + " > size " + size);
            varA4E09801CE838603376DC4663E4D6361_964486812.addTaint(taint);
            throw varA4E09801CE838603376DC4663E4D6361_964486812;
        } //End block
        if(fromIndex > toIndex)        
        {
            IndexOutOfBoundsException varCB4AF2B6E3F9C39096F2CD3B9C1A391D_1799536307 = new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " > toIndex " + toIndex);
            varCB4AF2B6E3F9C39096F2CD3B9C1A391D_1799536307.addTaint(taint);
            throw varCB4AF2B6E3F9C39096F2CD3B9C1A391D_1799536307;
        } //End block
        System.arraycopy(a, toIndex, a, fromIndex, s - toIndex);
        int rangeSize = toIndex - fromIndex;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.834 -0400", hash_original_method = "F03306481ED210492B573188BD80D78C", hash_generated_method = "EB740921F2B43160AEBBDB94408D1632")
    @Override
    public E set(int index, E object) {
        addTaint(object.getTaint());
        addTaint(index);
        Object[] a = array;
        if(index >= size)        
        {
            throwIndexOutOfBoundsException(index, size);
        } //End block
        @SuppressWarnings("unchecked") E result = (E) a[index];
        a[index] = object;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1075580835 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1075580835.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1075580835;
        // ---------- Original Method ----------
        //Object[] a = array;
        //if (index >= size) {
            //throwIndexOutOfBoundsException(index, size);
        //}
        //@SuppressWarnings("unchecked") E result = (E) a[index];
        //a[index] = object;
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.834 -0400", hash_original_method = "52977A01663ACB51F489F59A603BA7D4", hash_generated_method = "77596ED49B5DC2F6436167BA664AFA2A")
    @Override
    public Object[] toArray() {
        int s = size;
        Object[] result = new Object[s];
        System.arraycopy(array, 0, result, 0, s);
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_1596224699 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1596224699.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1596224699;
        // ---------- Original Method ----------
        //int s = size;
        //Object[] result = new Object[s];
        //System.arraycopy(array, 0, result, 0, s);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.835 -0400", hash_original_method = "C3B471E5DAFB04B40866B17E5BAEF530", hash_generated_method = "1D38964E1232042ED0C7D9CD5CD457F8")
    @Override
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        int s = size;
        if(contents.length < s)        
        {
            @SuppressWarnings("unchecked") T[] newArray = (T[]) Array.newInstance(contents.getClass().getComponentType(), s);
            contents = newArray;
        } //End block
        System.arraycopy(this.array, 0, contents, 0, s);
        if(contents.length > s)        
        {
            contents[s] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_1924233504 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_1924233504.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_1924233504;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.835 -0400", hash_original_method = "7330C01325C25FBEA000A4F3E32D26DF", hash_generated_method = "35C199892565BFAF814A1B11E3CF926D")
    public void trimToSize() {
        int s = size;
        if(s == array.length)        
        {
            return;
        } //End block
        if(s == 0)        
        {
            array = EmptyArray.OBJECT;
        } //End block
        else
        {
            Object[] newArray = new Object[s];
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.835 -0400", hash_original_method = "CE193891A7B397E3A9A2EF577B10DC50", hash_generated_method = "E531D25B39714CA249D8FB196B93C188")
    @Override
    public Iterator<E> iterator() {
Iterator<E> varB25DE541A12249BCC347B42FD21E8BF9_1717178800 =         new ArrayListIterator();
        varB25DE541A12249BCC347B42FD21E8BF9_1717178800.addTaint(taint);
        return varB25DE541A12249BCC347B42FD21E8BF9_1717178800;
        // ---------- Original Method ----------
        //return new ArrayListIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.836 -0400", hash_original_method = "5DBD6A40EED7E4F643FF32288E994D2A", hash_generated_method = "0AAE6C1E71A08E82CD075C5ACA4F4AC3")
    @Override
    public int hashCode() {
        Object[] a = array;
        int hashCode = 1;
for(int i = 0, s = size;i < s;i++)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.837 -0400", hash_original_method = "B6BBD42460E139DEDE8E165726366EA3", hash_generated_method = "D4C09056C6EE738803BED4E24FA86358")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_464519359 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398498772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_398498772;
        } //End block
        if(!(o instanceof List))        
        {
            boolean var68934A3E9455FA72420237EB05902327_768566037 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210593543 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210593543;
        } //End block
        List<?> that = (List<?>) o;
        int s = size;
        if(that.size() != s)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1089532185 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333632658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333632658;
        } //End block
        Object[] a = array;
        if(that instanceof RandomAccess)        
        {
for(int i = 0;i < s;i++)
            {
                Object eThis = a[i];
                Object ethat = that.get(i);
                if(eThis == null ? ethat != null : !eThis.equals(ethat))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_62155676 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807685684 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807685684;
                } //End block
            } //End block
        } //End block
        else
        {
            Iterator<?> it = that.iterator();
for(int i = 0;i < s;i++)
            {
                Object eThis = a[i];
                Object eThat = it.next();
                if(eThis == null ? eThat != null : !eThis.equals(eThat))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1924051105 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594046249 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594046249;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_683221326 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068649209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068649209;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.838 -0400", hash_original_method = "291F806CA114E9A8DDD079DF7CDB05EA", hash_generated_method = "5F8684799088AA1AFC2FFB96C7FF18A5")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(array.length);
for(int i = 0;i < size;i++)
        {
            stream.writeObject(array[i]);
        } //End block
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(array.length);
        //for (int i = 0; i < size; i++) {
            //stream.writeObject(array[i]);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.838 -0400", hash_original_method = "07E10AF7F234C75E84F0879D60F4FA74", hash_generated_method = "DA922EE1034AA093E4D9526E4E5FE819")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int cap = stream.readInt();
        if(cap < size)        
        {
            InvalidObjectException var273D26CAC01DC448104B1EC1CDD9496E_2047464109 = new InvalidObjectException(
                    "Capacity: " + cap + " < size: " + size);
            var273D26CAC01DC448104B1EC1CDD9496E_2047464109.addTaint(taint);
            throw var273D26CAC01DC448104B1EC1CDD9496E_2047464109;
        } //End block
        array = (cap == 0 ? EmptyArray.OBJECT : new Object[cap]);
for(int i = 0;i < size;i++)
        {
            array[i] = stream.readObject();
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_field = "D76D0FBFB93E4AF78A9BBB774A17F61B", hash_generated_field = "4C1C48D586843493C1E6DDDE251ECE70")

        private int remaining = size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_field = "9E2D0354A755F31DF2B86013A1F84ABE", hash_generated_field = "87A3426B077DEFAAD6A51D7DCC7B66F7")

        private int removalIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "70917CA63DF275E00A8791CE0E39E48E")

        private int expectedModCount = modCount;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_method = "A2AE73C6B653383A81528A6CCE4C5FCB", hash_generated_method = "A2AE73C6B653383A81528A6CCE4C5FCB")
        public ArrayListIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_method = "44DFBDD5F60969C85FF7C62CEFF63BE1", hash_generated_method = "60F7CBDC8ABC5BBB2692FFFFE38903BF")
        public boolean hasNext() {
            boolean var5D5C25692EDEDA7CF573C3A16EB5C7B1_1031018463 = (remaining != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999100805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_999100805;
            // ---------- Original Method ----------
            //return remaining != 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.839 -0400", hash_original_method = "4E01EE32653D357535C28CF692990943", hash_generated_method = "4CDFC72C7C5B590935552E9DDEA3A710")
        @SuppressWarnings("unchecked")
        public E next() {
            ArrayList<E> ourList = ArrayList.this;
            int rem = remaining;
            if(ourList.modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1271470041 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1271470041.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1271470041;
            } //End block
            if(rem == 0)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_529162602 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_529162602.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_529162602;
            } //End block
            remaining = rem - 1;
E var3DD0F0FCD302CDCF1356101DE87082ED_2122454298 =             (E) ourList.array[removalIndex = ourList.size - rem];
            var3DD0F0FCD302CDCF1356101DE87082ED_2122454298.addTaint(taint);
            return var3DD0F0FCD302CDCF1356101DE87082ED_2122454298;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.840 -0400", hash_original_method = "2CA6472AB4D5ED4AA6A79E4E390FB476", hash_generated_method = "397CB85DDF76CD4282804A5A062139AE")
        public void remove() {
            Object[] a = array;
            int removalIdx = removalIndex;
            if(modCount != expectedModCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1419578157 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1419578157.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1419578157;
            } //End block
            if(removalIdx < 0)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_600325945 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_600325945.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_600325945;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.840 -0400", hash_original_field = "F9F98993EEA9BE3997005456026F76D9", hash_generated_field = "DACDD4E45B583B8C5383B55561081E3B")

    private static final int MIN_CAPACITY_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.840 -0400", hash_original_field = "C1AC5D7497D25261150408B53250333D", hash_generated_field = "E089B2B162ABB353A6199922AA057C3E")

    private static final long serialVersionUID = 8683452581122892189L;
}

