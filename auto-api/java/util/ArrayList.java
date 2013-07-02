package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import libcore.util.EmptyArray;

public class ArrayList<E> extends AbstractList<E> implements Cloneable, Serializable, RandomAccess {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.740 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

    int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.740 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "7675584818BEF48C593B15A4C030F967")

    transient Object[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.741 -0400", hash_original_method = "3E3801877D646C78E965A019C35437FB", hash_generated_method = "787A8AE4754B859BD998B72D9CEADBE9")
    public  ArrayList(int capacity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        array = (capacity == 0 ? EmptyArray.OBJECT : new Object[capacity]);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.741 -0400", hash_original_method = "A7503C07B95C656689F43518416554F0", hash_generated_method = "A3AEAA024802F16BF2F719D937C47F2E")
    public  ArrayList() {
        array = EmptyArray.OBJECT;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.741 -0400", hash_original_method = "AE7C60C91D4192AC5637CB5677158233", hash_generated_method = "B3572C993CB056B1131869DF236DD11E")
    public  ArrayList(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        {
            boolean var16F77EF61B9474A82FE398A385F0E9B1_1800332172 = (a.getClass() != Object[].class);
            {
                Object[] newArray = new Object[a.length];
                System.arraycopy(a, 0, newArray, 0, a.length);
                a = newArray;
            } 
        } 
        array = a;
        size = a.length;
        addTaint(collection.getTaint());
        
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.742 -0400", hash_original_method = "2E95EC775538EB90DD9A0EBE35FC856F", hash_generated_method = "6B19C09750DC20D5752674981FFA553D")
    @Override
    public boolean add(E object) {
        Object[] a = array;
        int s = size;
        {
            Object[] newArray = new Object[s +
                    (s < (MIN_CAPACITY_INCREMENT / 2) ?
                     MIN_CAPACITY_INCREMENT : s >> 1)];
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } 
        a[s] = object;
        size = s + 1;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106202584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106202584;
        
        
        
        
            
                    
                     
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.742 -0400", hash_original_method = "C5A93B072C15A6072F87F254E0F87786", hash_generated_method = "029C466B5101091FF486C6CEF8D0AA5A")
    @Override
    public void add(int index, E object) {
        Object[] a = array;
        int s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } 
        {
            System.arraycopy(a, index, a, index + 1, s - index);
        } 
        {
            Object[] newArray = new Object[newCapacity(s)];
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(a, index, newArray, index + 1, s - index);
            array = a = newArray;
        } 
        a[index] = object;
        size = s + 1;
        addTaint(index);
        addTaint(object.getTaint());
        
        
        
        
            
        
        
            
        
            
            
            
            
        
        
        
        
    }

    
    private static int newCapacity(int currentCapacity) {
        int increment = (currentCapacity < (MIN_CAPACITY_INCREMENT / 2) ?
                MIN_CAPACITY_INCREMENT : currentCapacity >> 1);
        return currentCapacity + increment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.744 -0400", hash_original_method = "C337453C40DBE6A93E9B9333DA2BDDBD", hash_generated_method = "2860AAB15B6F499915421F75703C2039")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        Object[] newPart = collection.toArray();
        int newPartSize = newPart.length;
        Object[] a = array;
        int s = size;
        int newSize = s + newPartSize;
        {
            int newCapacity = newCapacity(newSize - 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, s);
            array = a = newArray;
        } 
        System.arraycopy(newPart, 0, a, s, newPartSize);
        size = newSize;
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868093861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868093861;
        
        
        
        
            
        
        
        
        
        
            
            
            
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.745 -0400", hash_original_method = "878D1F0A34AD7389A9EB37A1AF5C813D", hash_generated_method = "5D2AFA35148E7B6A3723534D9FA27F03")
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        int s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } 
        Object[] newPart = collection.toArray();
        int newPartSize = newPart.length;
        Object[] a = array;
        int newSize = s + newPartSize;
        {
            System.arraycopy(a, index, a, index + newPartSize, s - index);
        } 
        {
            int newCapacity = newCapacity(newSize - 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(a, 0, newArray, 0, index);
            System.arraycopy(a, index, newArray, index + newPartSize, s-index);
            array = a = newArray;
        } 
        System.arraycopy(newPart, 0, a, index, newPartSize);
        size = newSize;
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106100443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106100443;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.746 -0400", hash_original_method = "C8A90352D37E56C32915D97A4B0A7D28", hash_generated_method = "32F9F0A50B6063DF0522FFBEB7BCE20A")
    @Override
    public void clear() {
        {
            Arrays.fill(array, 0, size, null);
            size = 0;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.747 -0400", hash_original_method = "B3DA051C4891B8092C007B9652169D27", hash_generated_method = "6A2F241ACE083FF2E41B4A4DF1708CAB")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1579205382 = null; 
        try 
        {
            ArrayList<?> result = (ArrayList<?>) super.clone();
            result.array = array.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1579205382 = result;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1579205382.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1579205382;
        
        
            
            
            
        
           
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.748 -0400", hash_original_method = "0AF2E3B013DB3C28C26CEAAD130BA61A", hash_generated_method = "055E85FDD38000F71256D89E425A5A32")
    public void ensureCapacity(int minimumCapacity) {
        Object[] a = array;
        {
            Object[] newArray = new Object[minimumCapacity];
            System.arraycopy(a, 0, newArray, 0, size);
            array = newArray;
        } 
        addTaint(minimumCapacity);
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.749 -0400", hash_original_method = "BE11B967A1A0587EBAE1CDD4CD567558", hash_generated_method = "F7FEDB4BC61C219FBBB70F5268934275")
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1072759632 = null; 
        {
            throwIndexOutOfBoundsException(index, size);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1072759632 = (E) array[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1072759632.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1072759632;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.749 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A62888E2AE87A57B768DEFD91FF56A7E")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109490688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109490688;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.750 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "CBEDCE47B51F66A9F4FC10042C1DD6CB")
    @Override
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106277860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106277860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.751 -0400", hash_original_method = "64966ED2F2DBD125FF02B9B2F4262D7F", hash_generated_method = "DE2BA11F9ADFB10D7C93217E244FA26C")
    @Override
    public boolean contains(Object object) {
        Object[] a = array;
        int s = size;
        {
            {
                int i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_995562683 = (object.equals(a[i]));
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
            } 
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988273749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988273749;
        
        
        
        
            
                
                    
                
            
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.752 -0400", hash_original_method = "0D1C6275419222204CF4CD7DEABF4627", hash_generated_method = "16E6BA9077A6A63A7900579DBCBD7CB6")
    @Override
    public int indexOf(Object object) {
        Object[] a = array;
        int s = size;
        {
            {
                int i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_1808828971 = (object.equals(a[i]));
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
            } 
        } 
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898892774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898892774;
        
        
        
        
            
                
                    
                
            
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.752 -0400", hash_original_method = "A33DDE97246530740ADA37CC6A9CC384", hash_generated_method = "5AB677E100121CFF863007450D8869E3")
    @Override
    public int lastIndexOf(Object object) {
        Object[] a = array;
        {
            {
                int i = size - 1;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_606546033 = (object.equals(a[i]));
                    } 
                } 
            } 
        } 
        {
            {
                int i = size - 1;
            } 
        } 
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064549278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064549278;
        
        
        
            
                
                    
                
            
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.755 -0400", hash_original_method = "A1787B19405DA1FA0654C3278265A2A8", hash_generated_method = "096963043918A1BF4B1C9C8266BDB2D3")
    @Override
    public E remove(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1238814335 = null; 
        Object[] a = array;
        int s = size;
        {
            throwIndexOutOfBoundsException(index, s);
        } 
        @SuppressWarnings("unchecked") E result = (E) a[index];
        System.arraycopy(a, index + 1, a, index, --s - index);
        a[s] = null;
        size = s;
        varB4EAC82CA7396A68D541C85D26508E83_1238814335 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1238814335.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1238814335;
        
        
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.757 -0400", hash_original_method = "C2B3C3C4D1766953FF0E432D86502585", hash_generated_method = "743EA6F2C147CD41BD70CF77F9C59BFA")
    @Override
    public boolean remove(Object object) {
        Object[] a = array;
        int s = size;
        {
            {
                int i = 0;
                {
                    {
                        boolean varA6976E8F17BE504D77EDD08C90B63DC8_237673877 = (object.equals(a[i]));
                        {
                            System.arraycopy(a, i + 1, a, i, --s - i);
                            a[s] = null;
                            size = s;
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    {
                        System.arraycopy(a, i + 1, a, i, --s - i);
                        a[s] = null;
                        size = s;
                    } 
                } 
            } 
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476113908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476113908;
        
        
        
        
            
                
                    
                    
                    
                    
                    
                
            
        
            
                
                    
                    
                    
                    
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.761 -0400", hash_original_method = "D866DECE8E8344A6C98BF327EDBE1AFF", hash_generated_method = "F5B17D63ED7A36C952D2F523C4981D32")
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        Object[] a = array;
        int s = size;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " >= size " + size);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("toIndex " + toIndex
                    + " > size " + size);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex " + fromIndex
                    + " > toIndex " + toIndex);
        } 
        System.arraycopy(a, toIndex, a, fromIndex, s - toIndex);
        int rangeSize = toIndex - fromIndex;
        Arrays.fill(a, s - rangeSize, s, null);
        size = s - rangeSize;
        addTaint(fromIndex);
        addTaint(toIndex);
        
        
            
        
        
        
        
            
                    
        
        
            
                    
        
        
            
                    
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.762 -0400", hash_original_method = "F03306481ED210492B573188BD80D78C", hash_generated_method = "0BA92AB650F40CE73D1C0F4D46DAE46B")
    @Override
    public E set(int index, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_802866259 = null; 
        Object[] a = array;
        {
            throwIndexOutOfBoundsException(index, size);
        } 
        @SuppressWarnings("unchecked") E result = (E) a[index];
        a[index] = object;
        varB4EAC82CA7396A68D541C85D26508E83_802866259 = result;
        addTaint(index);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_802866259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_802866259;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.763 -0400", hash_original_method = "52977A01663ACB51F489F59A603BA7D4", hash_generated_method = "8DF5D2FA1F8AC8286B2885409EA0C45B")
    @Override
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_180642845 = null; 
        int s = size;
        Object[] result = new Object[s];
        System.arraycopy(array, 0, result, 0, s);
        varB4EAC82CA7396A68D541C85D26508E83_180642845 = result;
        varB4EAC82CA7396A68D541C85D26508E83_180642845.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_180642845;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.764 -0400", hash_original_method = "C3B471E5DAFB04B40866B17E5BAEF530", hash_generated_method = "4F5CF3F6D000309E5C63EA5349C10D50")
    @Override
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_822784511 = null; 
        int s = size;
        {
            @SuppressWarnings("unchecked") T[] newArray = (T[]) Array.newInstance(contents.getClass().getComponentType(), s);
            contents = newArray;
        } 
        System.arraycopy(this.array, 0, contents, 0, s);
        {
            contents[s] = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_822784511 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_822784511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_822784511;
        
        
        
            
                
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.764 -0400", hash_original_method = "7330C01325C25FBEA000A4F3E32D26DF", hash_generated_method = "FBCD8BDB36CC82FFD1831842612492AB")
    public void trimToSize() {
        int s = size;
        {
            array = EmptyArray.OBJECT;
        } 
        {
            Object[] newArray = new Object[s];
            System.arraycopy(array, 0, newArray, 0, s);
            array = newArray;
        } 
        
        
        
            
        
        
            
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.765 -0400", hash_original_method = "CE193891A7B397E3A9A2EF577B10DC50", hash_generated_method = "BAFCB9DCF9A76E534A750C5BC007218B")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1438536744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1438536744 = new ArrayListIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1438536744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1438536744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.766 -0400", hash_original_method = "5DBD6A40EED7E4F643FF32288E994D2A", hash_generated_method = "4130D1696E3E241EAD2B1FC000AABDFC")
    @Override
    public int hashCode() {
        Object[] a = array;
        int hashCode = 1;
        {
            int i = 0;
            int s = size;
            {
                Object e = a[i];
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576047226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576047226;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.769 -0400", hash_original_method = "B6BBD42460E139DEDE8E165726366EA3", hash_generated_method = "230EF0E69A0B82F9A2E56DEE6562194C")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1088412628 = (o == this);
        } 
        List<?> that = (List<?>) o;
        int s = size;
        {
            boolean var6DDD04FB5A8F18C16A04CEB45843304E_1376151177 = (that.size() != s);
        } 
        Object[] a = array;
        {
            {
                int i = 0;
                {
                    Object eThis = a[i];
                    Object ethat = that.get(i);
                    {
                        {
                            boolean varEBC000A495141DDD1C176F0EB6DDFA1C_1871040136 = (!eThis.equals(ethat));
                        } 
                    } 
                } 
            } 
        } 
        {
            Iterator<?> it = that.iterator();
            {
                int i = 0;
                {
                    Object eThis = a[i];
                    Object eThat = it.next();
                    {
                        {
                            boolean var76B138E21032A28626298252682756E4_198124842 = (!eThis.equals(eThat));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658291400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658291400;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.769 -0400", hash_original_method = "291F806CA114E9A8DDD079DF7CDB05EA", hash_generated_method = "CBF0BA1C9DBB073198D2C41C7FFC5A82")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(array.length);
        {
            int i = 0;
            {
                stream.writeObject(array[i]);
            } 
        } 
        addTaint(stream.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_method = "07E10AF7F234C75E84F0879D60F4FA74", hash_generated_method = "5DAFD3C8B9D560ED83E606C14982D17B")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int cap = stream.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException(
                    "Capacity: " + cap + " < size: " + size);
        } 
        array = (cap == 0 ? EmptyArray.OBJECT : new Object[cap]);
        {
            int i = 0;
            {
                array[i] = stream.readObject();
            } 
        } 
        
        
        
        
            
                    
        
        
        
            
        
    }

    
    private class ArrayListIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_field = "D76D0FBFB93E4AF78A9BBB774A17F61B", hash_generated_field = "4C1C48D586843493C1E6DDDE251ECE70")

        private int remaining = size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_field = "9E2D0354A755F31DF2B86013A1F84ABE", hash_generated_field = "87A3426B077DEFAAD6A51D7DCC7B66F7")

        private int removalIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "70917CA63DF275E00A8791CE0E39E48E")

        private int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_method = "A2AE73C6B653383A81528A6CCE4C5FCB", hash_generated_method = "A2AE73C6B653383A81528A6CCE4C5FCB")
        public ArrayListIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.770 -0400", hash_original_method = "44DFBDD5F60969C85FF7C62CEFF63BE1", hash_generated_method = "DDDAA5294F55A7D85BE5855CEB9F9ECC")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776139192 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776139192;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.771 -0400", hash_original_method = "4E01EE32653D357535C28CF692990943", hash_generated_method = "3E799C9EC53BC0ED6076CC26AAC05FBD")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_572214113 = null; 
            ArrayList<E> ourList = ArrayList.this;
            int rem = remaining;
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            remaining = rem - 1;
            varB4EAC82CA7396A68D541C85D26508E83_572214113 = (E) ourList.array[removalIndex = ourList.size - rem];
            varB4EAC82CA7396A68D541C85D26508E83_572214113.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_572214113;
            
            
            
            
                
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.772 -0400", hash_original_method = "2CA6472AB4D5ED4AA6A79E4E390FB476", hash_generated_method = "C3E31AD74E2D9389E285D5C41BC6E8E4")
        public void remove() {
            Object[] a = array;
            int removalIdx = removalIndex;
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            System.arraycopy(a, removalIdx + 1, a, removalIdx, remaining);
            a[--size] = null;
            removalIndex = -1;
            expectedModCount = ++modCount;
            
            
            
            
                
            
            
                
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.772 -0400", hash_original_field = "F9F98993EEA9BE3997005456026F76D9", hash_generated_field = "DACDD4E45B583B8C5383B55561081E3B")

    private static final int MIN_CAPACITY_INCREMENT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.773 -0400", hash_original_field = "C1AC5D7497D25261150408B53250333D", hash_generated_field = "E089B2B162ABB353A6199922AA057C3E")

    private static final long serialVersionUID = 8683452581122892189L;
}

