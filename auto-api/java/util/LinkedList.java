package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.072 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "073488151E86FC108C1C096E75333D8B")

    transient int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.072 -0400", hash_original_field = "6C73C6B87FF2058988CE8C8EDB3429F0", hash_generated_field = "42E74DE51E61A92C4317D76844761684")

    transient Link<E> voidLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.073 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    public  LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.073 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "AC19F03332B19D11288983929D1CF7F0")
    public  LinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
        addTaint(collection.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.073 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "452B289A224249407553E0A2F0EEA2B0")
    @Override
    public void add(int location, E object) {
        {
            Link<E> link = voidLink;
            {
                {
                    int i = 0;
                    {
                        link = link.next;
                    } 
                } 
            } 
            {
                {
                    int i = size;
                    {
                        link = link.previous;
                    } 
                } 
            } 
            Link<E> previous = link.previous;
            Link<E> newLink = new Link<E>(object, previous, link);
            previous.next = newLink;
            link.previous = newLink;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        addTaint(location);
        addTaint(object.getTaint());
        
        
            
            
                
                    
                
            
                
                    
                
            
            
            
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.073 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "F0195224716DD4CC97923F6E68BE2EDF")
    @Override
    public boolean add(E object) {
        boolean var471407E29FACACFF33C18CE3EA47D39B_533490824 = (addLastImpl(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737857855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737857855;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.074 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "183B4A3BAE0141996C06BCEF07EC239F")
    private boolean addLastImpl(E object) {
        Link<E> oldLast = voidLink.previous;
        Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648859301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648859301;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.088 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "CC6D0375A2910AB20106F5FC67463586")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        int adding = collection.size();
        Collection<? extends E> elements;
        boolean var92E505E88442E11C36215AFDE9C5C198_136502666 = ((collection == this));
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous = voidLink;
        {
            {
                int i = 0;
                {
                    previous = previous.next;
                } 
            } 
        } 
        {
            {
                int i = size;
                {
                    previous = previous.previous;
                } 
            } 
        } 
        Link<E> next = previous.next;
        {
            Iterator<? extends E> var561DB81069E26BF25CD542D342D4C6DE_885552474 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_885552474.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_885552474.next();
            {
                Link<E> newLink = new Link<E>(e, previous, null);
                previous.next = newLink;
                previous = newLink;
            } 
        } 
        previous.next = next;
        next.previous = previous;
        size += adding;
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109221873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109221873;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.098 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "E0EEA5527BAEBB44326EFB8DC225BD09")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        int adding = collection.size();
        Collection<? extends E> elements;
        boolean var92E505E88442E11C36215AFDE9C5C198_2144287128 = ((collection == this));
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous = voidLink.previous;
        {
            Iterator<? extends E> var561DB81069E26BF25CD542D342D4C6DE_18717397 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_18717397.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_18717397.next();
            {
                Link<E> newLink = new Link<E>(e, previous, null);
                previous.next = newLink;
                previous = newLink;
            } 
        } 
        previous.next = voidLink;
        voidLink.previous = previous;
        size += adding;
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556861028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556861028;
        
        
        
            
        
        
                
        
        
            
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.102 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "9DCD568A7260257AF3A07EEE903FBDCB")
    public void addFirst(E object) {
        addFirstImpl(object);
        addTaint(object.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.102 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "5D251F532F38FCE1785EF76C35FF1186")
    private boolean addFirstImpl(E object) {
        Link<E> oldFirst = voidLink.next;
        Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325322935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_325322935;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.102 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "AC09CC797ECC1C6010850BBCF757682C")
    public void addLast(E object) {
        addLastImpl(object);
        addTaint(object.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.102 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "D053313FADC6AFD02128C0FBBDD81B2D")
    @Override
    public void clear() {
        {
            size = 0;
            voidLink.next = voidLink;
            voidLink.previous = voidLink;
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.103 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "6370F5093083393C11F5C22D26D4E642")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_376865452 = null; 
        try 
        {
            LinkedList<E> l = (LinkedList<E>) super.clone();
            l.size = 0;
            l.voidLink = new Link<E>(null, null, null);
            l.voidLink.previous = l.voidLink;
            l.voidLink.next = l.voidLink;
            l.addAll(this);
            varB4EAC82CA7396A68D541C85D26508E83_376865452 = l;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_376865452.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_376865452;
        
        
            
            
            
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.103 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "8BF755B4CAA36E8A93E0DA6B93A404A5")
    @Override
    public boolean contains(Object object) {
        Link<E> link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1901779140 = (object.equals(link.data));
                } 
                link = link.next;
            } 
        } 
        {
            {
                link = link.next;
            } 
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134723854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134723854;
        
        
        
            
                
                    
                
                
            
        
            
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.104 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "85C0DE65BF75533C2B51E807EBF0CFD9")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1328305870 = null; 
        {
            Link<E> link = voidLink;
            {
                {
                    int i = 0;
                    {
                        link = link.next;
                    } 
                } 
            } 
            {
                {
                    int i = size;
                    {
                        link = link.previous;
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1328305870 = link.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1328305870.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1328305870;
        
        
            
            
                
                    
                
            
                
                    
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.105 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "C23318BABC25A00C5A9CF51D3F601E9E")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_555527628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_555527628 = getFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_555527628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_555527628;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.106 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "CBBE97B63E111DF387D21CB42DC855D7")
    private E getFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_878634086 = null; 
        Link<E> first = voidLink.next;
        {
            varB4EAC82CA7396A68D541C85D26508E83_878634086 = first.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_878634086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_878634086;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.109 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "A9D311F5EAC003298399009FE0C34504")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1100601374 = null; 
        Link<E> last = voidLink.previous;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1100601374 = last.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1100601374.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1100601374;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.109 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "6AED28F6F438507A40589488894BC7D3")
    @Override
    public int indexOf(Object object) {
        int pos = 0;
        Link<E> link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1643661590 = (object.equals(link.data));
                } 
                link = link.next;
            } 
        } 
        {
            {
                link = link.next;
            } 
        } 
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153166566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153166566;
        
        
        
        
            
                
                    
                
                
                
            
        
            
                
                    
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.110 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "82DEB90210536614A5032B451490ED10")
    @Override
    public int lastIndexOf(Object object) {
        int pos = size;
        Link<E> link = voidLink.previous;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1676677141 = (object.equals(link.data));
                } 
                link = link.previous;
            } 
        } 
        {
            {
                link = link.previous;
            } 
        } 
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302206633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302206633;
        
        
        
        
            
                
                
                    
                
                
            
        
            
                
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.110 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "627D597BAE5B205C6F505AF2A15FD842")
    @Override
    public ListIterator<E> listIterator(int location) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1050603255 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1050603255 = new LinkIterator<E>(this, location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1050603255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1050603255;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.111 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "005C1A15822B004E63679BAFD67A18FA")
    @Override
    public E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_294975301 = null; 
        {
            Link<E> link = voidLink;
            {
                {
                    int i = 0;
                    {
                        link = link.next;
                    } 
                } 
            } 
            {
                {
                    int i = size;
                    {
                        link = link.previous;
                    } 
                } 
            } 
            Link<E> previous = link.previous;
            Link<E> next = link.next;
            previous.next = next;
            next.previous = previous;
            varB4EAC82CA7396A68D541C85D26508E83_294975301 = link.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_294975301.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_294975301;
        
        
            
            
                
                    
                
            
                
                    
                
            
            
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.111 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "67EDAF51AF93E8D2B1B11B56EA654FE4")
    @Override
    public boolean remove(Object object) {
        boolean varD9AA6A5988D1CD4CF0EC501538EC1CB9_342561452 = (removeFirstOccurrenceImpl(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031267314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031267314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.112 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "504437D80D29C248A71723743F66325D")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_2073362887 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2073362887 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_2073362887.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2073362887;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.112 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "CA1059CE7AD1304C4C58C79CC70036E4")
    private E removeFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_1786495759 = null; 
        Link<E> first = voidLink.next;
        {
            Link<E> next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
            varB4EAC82CA7396A68D541C85D26508E83_1786495759 = first.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1786495759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1786495759;
        
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.113 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "0E4F16EFCB973A383C84CD52DD8A76F1")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1332353547 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1332353547 = removeLastImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1332353547.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1332353547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.113 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "FA7D3FA08019071732FA31BF6FCBEA8B")
    private E removeLastImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_159374636 = null; 
        Link<E> last = voidLink.previous;
        {
            Link<E> previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
            varB4EAC82CA7396A68D541C85D26508E83_159374636 = last.data;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_159374636.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_159374636;
        
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.114 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "8E64DE383D6562C690014A63E2CAB3C1")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1824327325 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1824327325 = new ReverseLinkIterator<E>(this);
        varB4EAC82CA7396A68D541C85D26508E83_1824327325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1824327325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.114 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "1D999907E80B97B83F058543191AEC88")
    public boolean offerFirst(E e) {
        boolean var76B72DE79F3E513315008517C001461F_1780762759 = (addFirstImpl(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1583870968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1583870968;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.114 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "BA71A2877740C1040348ECCE453896D5")
    public boolean offerLast(E e) {
        boolean var5D8D8C0594128842346FC018CF7B2C46_1157907933 = (addLastImpl(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344651447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_344651447;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.115 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "21A1AE31637CBBB7BBD6C03B8DE9AFBC")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_690657513 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_690657513 = peekFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_690657513.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_690657513;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.115 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "8E705C08A876A94E97976E701AED0796")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_993376163 = null; 
        Link<E> last = voidLink.previous;
        varB4EAC82CA7396A68D541C85D26508E83_993376163 = (last == voidLink) ? null : last.data;
        varB4EAC82CA7396A68D541C85D26508E83_993376163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_993376163;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.116 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "1A8E4A28FECF8BFEC14DA4CF8E5E7630")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_39995238 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_39995238 = (size == 0) ? null : removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_39995238.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_39995238;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.116 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "7554B2F08C19F77967A572958027C438")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1944154562 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1944154562 = (size == 0) ? null : removeLastImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1944154562.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1944154562;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.116 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "44142594C1B53D8A15EC583B45055DB8")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_647775973 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_647775973 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_647775973.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_647775973;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.117 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "85C4F27701BBA7205966B41B91B341D2")
    public void push(E e) {
        addFirstImpl(e);
        addTaint(e.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.117 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "F2A6FADCF26D728089AFCACFE420E302")
    public boolean removeFirstOccurrence(Object o) {
        boolean var3B40CEECB1B8A1766358BB718B996E93_420048630 = (removeFirstOccurrenceImpl(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289093025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_289093025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.117 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "C9FF2A102F3B963EB546A900C9CCAAF4")
    public boolean removeLastOccurrence(Object o) {
        Iterator<E> iter = new ReverseLinkIterator<E>(this);
        boolean var818715EE81985F60936C283DBC275E04_756633688 = (removeOneOccurrence(o, iter));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927984148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927984148;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.118 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "E37FCE044D67455E546C1223F520D9F7")
    private boolean removeFirstOccurrenceImpl(Object o) {
        Iterator<E> iter = new LinkIterator<E>(this, 0);
        boolean var818715EE81985F60936C283DBC275E04_420136718 = (removeOneOccurrence(o, iter));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60837495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_60837495;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.118 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "5542BC735B94F3D7177F65817712226F")
    private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1315874103 = (iter.hasNext());
            {
                E element = iter.next();
                {
                    {
                        boolean varF1A27543F856253D406E948E1C7D5139_1527969130 = (o.equals(element));
                    } 
                    {
                        iter.remove();
                    } 
                } 
            } 
        } 
        addTaint(o.getTaint());
        addTaint(iter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405942156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405942156;
        
        
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.119 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "8DD290042CD7EAD9555FD8B919D2D591")
    @Override
    public E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_207789910 = null; 
        {
            Link<E> link = voidLink;
            {
                {
                    int i = 0;
                    {
                        link = link.next;
                    } 
                } 
            } 
            {
                {
                    int i = size;
                    {
                        link = link.previous;
                    } 
                } 
            } 
            E result = link.data;
            link.data = object;
            varB4EAC82CA7396A68D541C85D26508E83_207789910 = result;
        } 
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_207789910.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_207789910;
        
        
            
            
                
                    
                
            
                
                    
                
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.119 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "E9DE897986DCCF275D53DE878DF317DC")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582756381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582756381;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.120 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "CF7B61DA55E072991A64B7120609188B")
    public boolean offer(E o) {
        boolean var0DC980F474C0D58B2EC0CD83E9314E01_1212946536 = (addLastImpl(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778550272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_778550272;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.120 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "12E6660DF7D6DCEAA207BE66242F57C0")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1678323527 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1678323527 = size == 0 ? null : removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1678323527.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1678323527;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.121 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "95ADEC1438F178A44E5D474A5B6A2C9F")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_1702991527 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1702991527 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1702991527.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1702991527;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.122 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "869644025218E961FE5184666263C7C5")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1464338014 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1464338014 = peekFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1464338014.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1464338014;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.123 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "C8AA39220DA5FED1257BD103A05EA2FF")
    private E peekFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_592208128 = null; 
        Link<E> first = voidLink.next;
        varB4EAC82CA7396A68D541C85D26508E83_592208128 = first == voidLink ? null : first.data;
        varB4EAC82CA7396A68D541C85D26508E83_592208128.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_592208128;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.124 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "0066E6E9E36C2E99D2B47ED15785EEDB")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1997277516 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1997277516 = getFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1997277516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1997277516;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.124 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "D990628BB000ECA78536DB7223A735D6")
    @Override
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_2096093951 = null; 
        int index = 0;
        Object[] contents = new Object[size];
        Link<E> link = voidLink.next;
        {
            contents[index++] = link.data;
            link = link.next;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2096093951 = contents;
        varB4EAC82CA7396A68D541C85D26508E83_2096093951.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2096093951;
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.126 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "7F54B811F63AE255061974C8FA006857")
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1244059328 = null; 
        int index = 0;
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } 
        Link<E> link = voidLink.next;
        {
            contents[index++] = (T) link.data;
            link = link.next;
        } 
        {
            contents[index] = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1244059328 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1244059328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1244059328;
        
        
        
            
            
        
        
        
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.127 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "1C7C9F0630E5C7F974251AC5866BE238")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<E> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1764488972 = (it.hasNext());
            {
                stream.writeObject(it.next());
            } 
        } 
        addTaint(stream.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.127 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "05B3F965D44011586C64C0CDA8F668F5")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        size = stream.readInt();
        voidLink = new Link<E>(null, null, null);
        Link<E> link = voidLink;
        {
            int i = size;
            {
                Link<E> nextLink = new Link<E>((E) stream.readObject(), link, null);
                link.next = nextLink;
                link = nextLink;
            } 
        } 
        link.next = voidLink;
        voidLink.previous = link;
        
        
        
        
        
        
            
            
            
        
        
        
    }

    
    private static final class Link<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.128 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B3480F581DDA17D478907EC9EE768C50")

        ET data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.128 -0400", hash_original_field = "2327346E833EFCD6B2E7B3F0A4DF8EBB", hash_generated_field = "45A046E5D1D7F8BD1511ED0837170D9B")

        Link<ET> previous;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.128 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "99500FE4EDB0AA48BDE52F63DB34B10F")

        Link<ET> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.129 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "FF7F178B4230792375EA8BB041BC2BA6")
          Link(ET o, Link<ET> p, Link<ET> n) {
            data = o;
            previous = p;
            next = n;
            
            
            
            
        }

        
    }


    
    private static final class LinkIterator<ET> implements ListIterator<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.130 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

        int pos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.130 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.130 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "52794B45189EFF95B13E35D799B9BD43")

        LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.130 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "F851AA6845CD2B23EE54FB486DA1D214")

        Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.130 -0400", hash_original_field = "1A533DA437F86DDD82B433DEC7C72599", hash_generated_field = "ACB4020CEB7749245E32063C8F282FD3")

        Link<ET> lastLink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.132 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "C41DC6DC40DF0B75D11AFBC0C90814C7")
          LinkIterator(LinkedList<ET> object, int location) {
            list = object;
            expectedModCount = list.modCount;
            {
                link = list.voidLink;
                {
                    {
                        pos = -1;
                        {
                            link = link.next;
                        } 
                    } 
                } 
                {
                    {
                        pos = list.size;
                        {
                            link = link.previous;
                        } 
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } 
            addTaint(location);
            
            
            
            
                
                
                    
                        
                    
                
                    
                        
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.134 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "DDA6262BB4DE942BD5F35DF8C4AB59E9")
        public void add(ET object) {
            {
                Link<ET> next = link.next;
                Link<ET> newLink = new Link<ET>(object, link, next);
                link.next = newLink;
                next.previous = newLink;
                link = newLink;
                lastLink = null;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            addTaint(object.getTaint());
            
            
                
                
                
                
                
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.135 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "B740970C4C0CF822E0D0CFD9249DAAAD")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217743366 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217743366;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.135 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "6FB0273C741EAD3889C16584AF9C1E57")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732794658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732794658;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.136 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "DB055D5D952B059436250593C6907056")
        public ET next() {
            ET varB4EAC82CA7396A68D541C85D26508E83_1386107566 = null; 
            {
                LinkedList.Link<ET> next = link.next;
                {
                    lastLink = link = next;
                    varB4EAC82CA7396A68D541C85D26508E83_1386107566 = link.data;
                } 
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1386107566.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1386107566;
            
            
                
                
                    
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.137 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "E307D3796B7AA665C796F1F567758A5F")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772971743 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772971743;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.139 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "53BE18A4BC8148FCC891BCA8DA14A124")
        public ET previous() {
            ET varB4EAC82CA7396A68D541C85D26508E83_1495252404 = null; 
            {
                {
                    lastLink = link;
                    link = link.previous;
                    varB4EAC82CA7396A68D541C85D26508E83_1495252404 = lastLink.data;
                } 
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1495252404.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1495252404;
            
            
                
                    
                    
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.139 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "1973128A90D151FB0CE59A7C6918396D")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210243071 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210243071;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.140 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "E2B7E79A0EC65DA4C8102E80559AAB43")
        public void remove() {
            {
                {
                    Link<ET> next = lastLink.next;
                    Link<ET> previous = lastLink.previous;
                    next.previous = previous;
                    previous.next = next;
                    link = previous;
                    lastLink = null;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            
            
                
                    
                    
                    
                    
                    
                        
                    
                    
                    
                    
                    
                    
                
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.142 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "B9649A1C9A6D6D4E3E8E9153286971D0")
        public void set(ET object) {
            {
                {
                    lastLink.data = object;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } 
            
            
                
                    
                
                    
                
            
                
            
        }

        
    }


    
    private class ReverseLinkIterator<ET> implements Iterator<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.142 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.142 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "D1EC04877DB93B65C0C16B144052AC71")

        private LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.142 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "C029ECB4203CCD8751E5C756F40C32AD")

        private Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.142 -0400", hash_original_field = "7385E778E1358730CFB4F236AF9FF24A", hash_generated_field = "C01834E3EF87C859E7B00C0837E2E4D3")

        private boolean canRemove;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.143 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "98C036A6F3260A1B3893C647A1DF0F6C")
          ReverseLinkIterator(LinkedList<ET> linkedList) {
            list = linkedList;
            expectedModCount = list.modCount;
            link = list.voidLink;
            canRemove = false;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.144 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "437BA48BE100A169BF1E4213E8764544")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841680363 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841680363;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.145 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "31255D506EAE45F7B19E13CB7F37D6E5")
        public ET next() {
            ET varB4EAC82CA7396A68D541C85D26508E83_1419031839 = null; 
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_2037196332 = (hasNext());
                    {
                        link = link.previous;
                        canRemove = true;
                        varB4EAC82CA7396A68D541C85D26508E83_1419031839 = link.data;
                    } 
                } 
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1419031839.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1419031839;
            
            
                
                    
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.146 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "90DE0F14DCB4C90DCDD3ED6A7028394A")
        public void remove() {
            {
                {
                    Link<ET> next = link.previous;
                    Link<ET> previous = link.next;
                    next.next = previous;
                    previous.previous = next;
                    link = previous;
                    canRemove = false;
                } 
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            
            
                
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.146 -0400", hash_original_field = "A91BB42ABDC7657C70EC735A482E86B5", hash_generated_field = "5F23BECC14072AFC76D2F21910086550")

    private static final long serialVersionUID = 876323262645176354L;
}

