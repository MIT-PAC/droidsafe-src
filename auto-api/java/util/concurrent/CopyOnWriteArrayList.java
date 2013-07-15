package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import libcore.util.EmptyArray;
import libcore.util.Objects;

public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.634 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.634 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    public  CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.634 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "EA0C15CE1422D9A7119B138FB9DFD0F8")
    @SuppressWarnings("unchecked")
    public  CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        addTaint(collection.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.634 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "5F0DE0F3745CDDE56CD0A00206594245")
    public  CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.635 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "817BA723545825B4E4B8A2E921677A3A")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_509821681 = null; 
        try 
        {
            CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
            varB4EAC82CA7396A68D541C85D26508E83_509821681 = result;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_509821681.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_509821681;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.635 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "5636B47E316EA73316D63EE8C0B3CE1E")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941256154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941256154;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.635 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "81B1216D891B1B6C101A3C8D608C336B")
    @SuppressWarnings("unchecked")
    public E get(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_2136711438 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2136711438 = (E) elements[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2136711438.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2136711438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.636 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "3AA0CF347B1B7325A77829FD6849CABE")
    public boolean contains(Object o) {
        boolean var2580C065AD3F25FA806E0EC1F5491D61_1110950756 = (indexOf(o) != -1);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834190768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834190768;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.636 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "630F33DF7E4C9CAD2F7C97C18B59EA3F")
    public boolean containsAll(Collection<?> collection) {
        Object[] snapshot = elements;
        boolean varB51CD127B94D30044743FDBEC427798E_1380932296 = (containsAll(collection, snapshot, 0, snapshot.length));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601547335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601547335;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static boolean containsAll(Collection<?> collection, Object[] snapshot, int from, int to) {
        for (Object o : collection) {
            if (indexOf(o, snapshot, from, to) == -1) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.636 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "65268FDD50E1C59DB6724FEA86B3F95B")
    public int indexOf(E object, int from) {
        Object[] snapshot = elements;
        int var3F4FFEA1DA0968D7F475C5A4D1C4F62D_100185811 = (indexOf(object, snapshot, from, snapshot.length));
        addTaint(object.getTaint());
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093689848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093689848;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.637 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "DB3FD7DE0EDE4EAA2B3F90AEA0B4F093")
    public int indexOf(Object object) {
        Object[] snapshot = elements;
        int varF95830349FA4633C99755E2E13FD61DA_1853386421 = (indexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537741965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537741965;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.638 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "7DB60CE7DB39F919C200D2928C25C65E")
    public int lastIndexOf(E object, int to) {
        Object[] snapshot = elements;
        int var044750AB099D388AF4C1D65CC717289C_1298112635 = (lastIndexOf(object, snapshot, 0, to));
        addTaint(object.getTaint());
        addTaint(to);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458438649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458438649;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.638 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "2E1AF87BC57C228E5224CC06320F8752")
    public int lastIndexOf(Object object) {
        Object[] snapshot = elements;
        int var363578769FBDCE20799A418E17F6DBCF_1440797679 = (lastIndexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169974342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169974342;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.639 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "77FD9CE943FD96319B781CAD38BDFBAC")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397137766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_397137766;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.639 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "1ADA08AAB51C76E70BA87B5E9524169C")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_454440093 = null; 
        Object[] snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_454440093 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_454440093.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_454440093;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.640 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "9DB54EE0B9F9796497E5DB5B6B012D7D")
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1019693240 = null; 
        Object[] snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        } 
        CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
        varB4EAC82CA7396A68D541C85D26508E83_1019693240 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1019693240.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1019693240;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.640 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "4FF2C989003E1EBEBD7BB41C9862B5A1")
    public ListIterator<E> listIterator() {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_32436349 = null; 
        Object[] snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_32436349 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_32436349.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32436349;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.641 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "E56D3A2CA894D88BC266D19878650BA3")
    public List<E> subList(int from, int to) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_284197204 = null; 
        Object[] snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_284197204 = new CowSubList(snapshot, from, to);
        addTaint(from);
        addTaint(to);
        varB4EAC82CA7396A68D541C85D26508E83_284197204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_284197204;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.641 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "867B64B7428DC1F828B260A3FB15F592")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1339937962 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1339937962 = elements.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1339937962.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1339937962;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.642 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "92AA47A0CA464040F510934786E9E366")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1714328680 = null; 
        T[] varB4EAC82CA7396A68D541C85D26508E83_707244537 = null; 
        Object[] snapshot = elements;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1714328680 = (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        } 
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        {
            contents[snapshot.length] = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_707244537 = contents;
        addTaint(contents[0].getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_1836533659; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1836533659 = varB4EAC82CA7396A68D541C85D26508E83_1714328680;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1836533659 = varB4EAC82CA7396A68D541C85D26508E83_707244537;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1836533659.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1836533659;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.647 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "914844B2BD8D718F83A3E555A9283CE5")
    @Override
    public boolean equals(Object other) {
        {
            boolean var8E510C77A3CC00EDD5D5105BB9594676_1589103414 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
        } 
        {
            Object[] snapshot = elements;
            Iterator<?> i = ((List<?>) other).iterator();
            {
                Object o = snapshot[0];
                {
                    {
                        boolean var6D2C6F2C90F31B26BD0BC8B4289F0FA4_1836160 = (!i.hasNext() || !Objects.equal(o, i.next()));
                    } 
                } 
            } 
            boolean varCC7204A921FEC5763B81E50426A88D00_138417984 = (!i.hasNext());
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396233707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396233707;
        
        
            
                    
        
            
            
            
                
                    
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.647 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "2FA48B28B3A12F15B11CE492C8DB97C0")
    @Override
    public int hashCode() {
        int varCAF3CD69EA8DECAF9471B49B185EF8B7_1960491418 = (Arrays.hashCode(elements));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668309246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668309246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.648 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "BD95894B2A1A9E59DAD6C6D7814E11FD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_229739153 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_229739153 = Arrays.toString(elements);
        varB4EAC82CA7396A68D541C85D26508E83_229739153.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_229739153;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.648 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "6CC8A703530E3899ECDE0991490406C8")
    public synchronized boolean add(E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617001782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_617001782;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.648 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "9693980F86D82110F0F75987F308B893")
    public synchronized void add(int index, E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        elements = newElements;
        addTaint(index);
        addTaint(e.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.649 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "3B2F0F6A3B35B4F8B47D8B6782FA7653")
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var0159BD59FAEB520B52C0A163D95FA273_801971703 = (addAll(elements.length, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477859086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477859086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.649 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "99124A66D0581A01CDD9E2615FE10958")
    public synchronized boolean addAll(int index, Collection<? extends E> collection) {
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        System.arraycopy(elements, index,
                newElements, index + toAdd.length, elements.length - index);
        elements = newElements;
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378503761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378503761;
        
        
        
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.657 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "F92534298DCFC7F974CC481BFF7AF9AF")
    public synchronized int addAllAbsent(Collection<? extends E> collection) {
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount = 0;
        {
            Object o = toAdd[0];
            {
                {
                    boolean var4BB4DD0650713F3AD6499B5BB3CF0F9C_787187110 = (indexOf(o, newElements, 0, elements.length + addedCount) == -1);
                    {
                        newElements[elements.length + addedCount++] = o;
                    } 
                } 
            } 
        } 
        {
            newElements = Arrays.copyOfRange(
                    newElements, 0, elements.length + addedCount);
        } 
        elements = newElements;
        addTaint(collection.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310055774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310055774;
        
        
        
        
        
        
            
                
            
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.657 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "EB3018D78F43D6BB1F5AD1805F1E372E")
    public synchronized boolean addIfAbsent(E object) {
        {
            boolean var9432A920D7B842B924EF8D1C9DF16F5D_1042337711 = (contains(object));
        } 
        add(object);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247464907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247464907;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.657 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.658 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "5823800CB9193DAD5E6E15F591B81F10")
    public synchronized E remove(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_621445649 = null; 
        @SuppressWarnings("unchecked") E removed = (E) elements[index];
        removeRange(index, index + 1);
        varB4EAC82CA7396A68D541C85D26508E83_621445649 = removed;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_621445649.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_621445649;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.659 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "B1F6D06E62B6328DF11A19BF7F5D6C0C")
    public synchronized boolean remove(Object o) {
        int index = indexOf(o);
        remove(index);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667327740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667327740;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.659 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "C04B5CDABDB7A3A4D141569BBB2A2294")
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean varB4080136E4414D738D63F3764F6FBFEE_2030735864 = (removeOrRetain(collection, false, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081076312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081076312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.660 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "00E8BE47CE5ABCEF4E877FBE9ED9B6D5")
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var9149E6DF8FB33323D0296E3F070EADBC_1252642688 = (removeOrRetain(collection, true, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139179201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139179201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.661 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "3FE1C7CB33A224B25350A7EF90FD18CC")
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        {
            int i = from;
            {
                {
                    boolean varC6BA4CD1BE642A29C15190B0FCD2F50D_1485696684 = (collection.contains(elements[i]) == retain);
                } 
                Object[] newElements = new Object[elements.length - 1];
                System.arraycopy(elements, 0, newElements, 0, i);
                int newSize = i;
                {
                    int j = i + 1;
                    {
                        {
                            boolean varEA71BBF34A922A67A0C66E1F44121158_564437459 = (collection.contains(elements[j]) == retain);
                            {
                                newElements[newSize++] = elements[j];
                            } 
                        } 
                    } 
                } 
                System.arraycopy(elements, to, newElements, newSize, elements.length - to);
                newSize += (elements.length - to);
                {
                    newElements = Arrays.copyOfRange(newElements, 0, newSize);
                } 
                int removed = elements.length - newElements.length;
                elements = newElements;
            } 
        } 
        addTaint(collection.getTaint());
        addTaint(retain);
        addTaint(from);
        addTaint(to);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328919052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328919052;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.661 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "8BB91B7D1FFC0122A5437B5AEB76AD22")
    public synchronized E set(int index, E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_384865564 = null; 
        Object[] newElements = elements.clone();
        @SuppressWarnings("unchecked") E result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
        varB4EAC82CA7396A68D541C85D26508E83_384865564 = result;
        addTaint(index);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_384865564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_384865564;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.662 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "7D88388DDDE000E8672153D1CD9B633D")
    private void removeRange(int from, int to) {
        Object[] newElements = new Object[elements.length - (to - from)];
        System.arraycopy(elements, 0, newElements, 0, from);
        System.arraycopy(elements, to, newElements, from, elements.length - to);
        elements = newElements;
        addTaint(from);
        addTaint(to);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static int lastIndexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = to - 1; i >= from; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = to - 1; i >= from; i--) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    
    @DSModeled(DSC.SAFE)
    static int indexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = from; i < to; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = from; i < to; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.663 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "1A347443303A48CAD4499890F9A2E81A")
    final Object[] getArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_2110049968 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2110049968 = elements;
        varB4EAC82CA7396A68D541C85D26508E83_2110049968.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2110049968;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.672 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "8B9FCD375D99390D334ACF3D8BA7C03F")
    private void writeObject(ObjectOutputStream out) throws IOException {
        Object[] snapshot = elements;
        out.defaultWriteObject();
        out.writeInt(snapshot.length);
        {
            Object o = snapshot[0];
            {
                out.writeObject(o);
            } 
        } 
        addTaint(out.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.672 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "A6A7C1FE28CC279AB67B5C81BE3DE897")
    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Object[] snapshot = new Object[in.readInt()];
        {
            int i = 0;
            {
                snapshot[i] = in.readObject();
            } 
        } 
        elements = snapshot;
        addTaint(in.getTaint());
        
        
        
        
            
        
        
    }

    
    class CowSubList extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.673 -0400", hash_original_field = "6D52012DCA4FC77AA554F25430AEF501", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.673 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "5B199B3E4B2B392A5F281C0027899513")
        public  CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.674 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "DFDB2532E9C623C094759EE5A854A8F4")
        @Override
        public int size() {
            Slice slice = this.slice;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337321782 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337321782;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.675 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "309F8ECD15485BCB229569E5311ED988")
        @Override
        public boolean isEmpty() {
            Slice slice = this.slice;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111153458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_111153458;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.676 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "5E554B03BD0161963DE3BB62C9A2EEB7")
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_2052161894 = null; 
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
            varB4EAC82CA7396A68D541C85D26508E83_2052161894 = (E) snapshot[index + slice.from];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2052161894.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2052161894;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.677 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "8AA786C9D84FEB9D7E4FAC30CFC374B9")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_454991409 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_454991409 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_454991409.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_454991409;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.677 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "D240345CE3CD5FABF322D77534B8ACA8")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1224397302 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1224397302 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1224397302.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1224397302;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.678 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "65E924EC8A2C5740633F0454CDB2F92D")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_51812762 = null; 
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
            varB4EAC82CA7396A68D541C85D26508E83_51812762 = result;
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_51812762.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_51812762;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.678 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "A426F09B626F28E9FD90C123C036F147")
        @Override
        public int indexOf(Object object) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674999524 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674999524;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.678 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "DD62CAD83C4F2C45CC367DEAB49B8840")
        @Override
        public int lastIndexOf(Object object) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435123349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435123349;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.679 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "40A6C78DC4E45C7948E409665490F5BC")
        @Override
        public boolean contains(Object object) {
            boolean var1CBE8A280A6EF98EBEBE6D4C530DF78D_202525803 = (indexOf(object) != -1);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154863389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154863389;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.679 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "28F89C4EE3203F59F92D83387743906E")
        @Override
        public boolean containsAll(Collection<?> collection) {
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var34F8E2D032BDFD9A299807B37CDBBDC9_1069851889 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852462301 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852462301;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.680 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "C86AD0144D7924E50A22FDBCCD52A4E9")
        @Override
        public List<E> subList(int from, int to) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_577587876 = null; 
            Slice slice = this.slice;
            {
                boolean var8B44CCFE67682F7E890DAC0190AAF2EF_414723625 = (from < 0 || from > to || to > size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_577587876 = new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
            addTaint(from);
            addTaint(to);
            varB4EAC82CA7396A68D541C85D26508E83_577587876.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_577587876;
            
            
            
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.680 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "8F229703B42BB1E432DC1A127F83551A")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_1911211876 = null; 
            {
                Object var0414760F989879E00EA455A9A86D73CF_1842103183 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                    slice = new Slice(elements, slice.from, slice.to - 1);
                    varB4EAC82CA7396A68D541C85D26508E83_1911211876 = removed;
                } 
            } 
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1911211876.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1911211876;
            
            
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.681 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "E60F1BCEBFDC189335DE3F9B5E47B885")
        @Override
        public void clear() {
            {
                Object var0414760F989879E00EA455A9A86D73CF_195249742 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.from);
                } 
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.681 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "A0DEA0764F2079D686A3713D9E6F8A05")
        @Override
        public void add(int index, E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_170511702 = (CopyOnWriteArrayList.this);
                {
                    slice.checkPositionIndex(index);
                    slice.checkConcurrentModification(elements);
                    CopyOnWriteArrayList.this.add(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to + 1);
                } 
            } 
            addTaint(index);
            addTaint(object.getTaint());
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.682 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "33B95C0EA409958E86C50F12FD539249")
        @Override
        public boolean add(E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1826203342 = (CopyOnWriteArrayList.this);
                {
                    add(slice.to - slice.from, object);
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309460847 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309460847;
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.682 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "85CE15276FD0A42E9C1E1611C8B27EB5")
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_724692369 = (CopyOnWriteArrayList.this);
                {
                    slice.checkPositionIndex(index);
                    slice.checkConcurrentModification(elements);
                    int oldSize = elements.length;
                    boolean result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                    slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                } 
            } 
            addTaint(index);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628873518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628873518;
            
            
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.683 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "CECA81701C242B37B121AACDB49956C2")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_666772345 = (CopyOnWriteArrayList.this);
                {
                    boolean var74E51E10D11DF48379CEFE0A325D5F6E_24710650 = (addAll(size(), collection));
                } 
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114735602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_114735602;
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.685 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "7D7D5EBDDE2A1ADFDD923D05F9BCCFDB")
        @Override
        public E set(int index, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_509860840 = null; 
            {
                Object var0414760F989879E00EA455A9A86D73CF_75141142 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to);
                    varB4EAC82CA7396A68D541C85D26508E83_509860840 = result;
                } 
            } 
            addTaint(index);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_509860840.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_509860840;
            
            
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.686 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "C1672DBD4093C3C3E9767360417FFF14")
        @Override
        public boolean remove(Object object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_969051960 = (CopyOnWriteArrayList.this);
                {
                    int index = indexOf(object);
                    remove(index);
                } 
            } 
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236154317 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_236154317;
            
            
                
                
                    
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.686 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "F8B08BB4F00BC4D90F560A9095BB2CCC")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_93101997 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed = removeOrRetain(collection, false, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } 
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992407138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_992407138;
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.687 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "F9D93CF8CA0C5EC8F3ACDFCF9F765206")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_617796947 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed = removeOrRetain(collection, true, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } 
            } 
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327632883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_327632883;
            
            
                
                
                
                
            
        }

        
    }


    
    static class Slice {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.687 -0400", hash_original_field = "5DBBBEFC516616C59322E114837C83FB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private Object[] expectedElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.687 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.687 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.688 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "6056AD1FF5F186156B93AC86A3F90BBC")
          Slice(Object[] expectedElements, int from, int to) {
            this.expectedElements = expectedElements;
            this.from = from;
            this.to = to;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.688 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "CD2CA17E534A100BB92056382E13D4CA")
         void checkElementIndex(int index) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } 
            addTaint(index);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.688 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "3064D546FBACD8749E7130231FBB73C7")
         void checkPositionIndex(int index) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } 
            addTaint(index);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "F9C340591E59B66F4BFBA6ED2CDFB0F3")
         void checkConcurrentModification(Object[] snapshot) {
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            addTaint(snapshot[0].getTaint());
            
            
                
            
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_field = "C322D3DE29D2B0C5E2E011DAD5E77DF2", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private Object[] snapshot;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_field = "CB241078244A9AA790B0FC45841BA024", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.689 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "761C1CBB0EA0B2EE4578133FB46FB797")
          CowIterator(Object[] snapshot, int from, int to) {
            this.snapshot = snapshot;
            this.from = from;
            this.to = to;
            this.index = from;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.690 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "7078F39A7BE4B1A66C0E863B971864AD")
        public void add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.690 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "F1E31BD6E904F181FC6A68E7A450D149")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179636994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_179636994;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.690 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "EEE6BF4CE20253EB430F0578409D98A4")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599968437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_599968437;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.691 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "75E146A8F9EDCF8394C842D46D7F9AF7")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_2126101248 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2126101248 = (E) snapshot[index++];
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2126101248.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2126101248;
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.692 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "F79AA19A8D54D1E1D17BCC80FAF594D0")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417337105 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417337105;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.693 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "842C6C4CB580DA7DF912A8D7BA4F3601")
        @SuppressWarnings("unchecked")
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_459168843 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_459168843 = (E) snapshot[--index];
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_459168843.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_459168843;
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.694 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "BDF0A77A8D7208EF13AB1532CB2BD292")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005176286 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005176286;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.694 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.695 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "F7AE59885F055C425C0440CAC4D1CE97")
        public void set(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.695 -0400", hash_original_field = "CB0A5E07D474346F2427954305CE9572", hash_generated_field = "392EFB541281482E947C8FEFEB5A2F62")

    private static final long serialVersionUID = 8673264195747942595L;
}

