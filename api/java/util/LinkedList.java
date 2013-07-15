package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.137 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "073488151E86FC108C1C096E75333D8B")

    transient int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.137 -0400", hash_original_field = "6C73C6B87FF2058988CE8C8EDB3429F0", hash_generated_field = "42E74DE51E61A92C4317D76844761684")

    transient Link<E> voidLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.138 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    public  LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        // ---------- Original Method ----------
        //voidLink = new Link<E>(null, null, null);
        //voidLink.previous = voidLink;
        //voidLink.next = voidLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.138 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "C5AA269F9975EBBFEE953030F41D5191")
    public  LinkedList(Collection<? extends E> collection) {
        this();
        addTaint(collection.getTaint());
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.139 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "8768A4E07C1E105728E6DEE2B80DDC30")
    @Override
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
    if(location >= 0 && location <= size)        
        {
            Link<E> link = voidLink;
    if(location < (size / 2))            
            {
for(int i = 0;i <= location;i++)
                {
                    link = link.next;
                } //End block
            } //End block
            else
            {
for(int i = size;i > location;i--)
                {
                    link = link.previous;
                } //End block
            } //End block
            Link<E> previous = link.previous;
            Link<E> newLink = new Link<E>(object, previous, link);
            previous.next = newLink;
            link.previous = newLink;
            size++;
            modCount++;
        } //End block
        else
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1385374363 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1385374363.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1385374363;
        } //End block
        // ---------- Original Method ----------
        //if (location >= 0 && location <= size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //Link<E> previous = link.previous;
            //Link<E> newLink = new Link<E>(object, previous, link);
            //previous.next = newLink;
            //link.previous = newLink;
            //size++;
            //modCount++;
        //} else {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.140 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "ED75B62542D28DF2623CD5B3C1A340E0")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        boolean varCF3A1FB654444BBD2951772DE0522D74_1669171090 = (addLastImpl(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387741720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387741720;
        // ---------- Original Method ----------
        //return addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.140 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "92CE42B6EA81E132F9F2EA3EA47DB4E4")
    private boolean addLastImpl(E object) {
        addTaint(object.getTaint());
        Link<E> oldLast = voidLink.previous;
        Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        size++;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_699732985 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562323651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562323651;
        // ---------- Original Method ----------
        //Link<E> oldLast = voidLink.previous;
        //Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        //voidLink.previous = newLink;
        //oldLast.next = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.142 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "B8A862F22D11DFC97BABD98EA99B280B")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(location);
    if(location < 0 || location > size)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1983567318 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1983567318.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1983567318;
        } //End block
        int adding = collection.size();
    if(adding == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1190387335 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426430309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426430309;
        } //End block
        Collection<? extends E> elements = (collection == this) ?
                new ArrayList<E>(collection) : collection;
        Link<E> previous = voidLink;
    if(location < (size / 2))        
        {
for(int i = 0;i < location;i++)
            {
                previous = previous.next;
            } //End block
        } //End block
        else
        {
for(int i = size;i >= location;i--)
            {
                previous = previous.previous;
            } //End block
        } //End block
        Link<E> next = previous.next;
for(E e : elements)
        {
            Link<E> newLink = new Link<E>(e, previous, null);
            previous.next = newLink;
            previous = newLink;
        } //End block
        previous.next = next;
        next.previous = previous;
        size += adding;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_648920263 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436905868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436905868;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.143 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "FBAC042128A83D7E97D256F8FB33636E")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        int adding = collection.size();
    if(adding == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_503410527 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217810522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_217810522;
        } //End block
        Collection<? extends E> elements = (collection == this) ?
                new ArrayList<E>(collection) : collection;
        Link<E> previous = voidLink.previous;
for(E e : elements)
        {
            Link<E> newLink = new Link<E>(e, previous, null);
            previous.next = newLink;
            previous = newLink;
        } //End block
        previous.next = voidLink;
        voidLink.previous = previous;
        size += adding;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_353726081 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399091182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399091182;
        // ---------- Original Method ----------
        //int adding = collection.size();
        //if (adding == 0) {
            //return false;
        //}
        //Collection<? extends E> elements = (collection == this) ?
                //new ArrayList<E>(collection) : collection;
        //Link<E> previous = voidLink.previous;
        //for (E e : elements) {
            //Link<E> newLink = new Link<E>(e, previous, null);
            //previous.next = newLink;
            //previous = newLink;
        //}
        //previous.next = voidLink;
        //voidLink.previous = previous;
        //size += adding;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.144 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "5A556DD598DD4B7AE272E66D69A80C0F")
    public void addFirst(E object) {
        addTaint(object.getTaint());
        addFirstImpl(object);
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.144 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "04725DB2030DE283005B795E22609102")
    private boolean addFirstImpl(E object) {
        addTaint(object.getTaint());
        Link<E> oldFirst = voidLink.next;
        Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        size++;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_482570588 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730617515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730617515;
        // ---------- Original Method ----------
        //Link<E> oldFirst = voidLink.next;
        //Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        //voidLink.next = newLink;
        //oldFirst.previous = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.145 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "5E57D6CF03EA15D68138243087D069FE")
    public void addLast(E object) {
        addTaint(object.getTaint());
        addLastImpl(object);
        // ---------- Original Method ----------
        //addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.145 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "8DEF4216863EAF1EF004538968BFEB12")
    @Override
    public void clear() {
    if(size > 0)        
        {
            size = 0;
            voidLink.next = voidLink;
            voidLink.previous = voidLink;
            modCount++;
        } //End block
        // ---------- Original Method ----------
        //if (size > 0) {
            //size = 0;
            //voidLink.next = voidLink;
            //voidLink.previous = voidLink;
            //modCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.146 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "229853188A8BE753D07D6D68FD09452D")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        try 
        {
            LinkedList<E> l = (LinkedList<E>) super.clone();
            l.size = 0;
            l.voidLink = new Link<E>(null, null, null);
            l.voidLink.previous = l.voidLink;
            l.voidLink.next = l.voidLink;
            l.addAll(this);
Object var792FD495AAD83D144D2F19BF9BB22987_444036679 =             l;
            var792FD495AAD83D144D2F19BF9BB22987_444036679.addTaint(taint);
            return var792FD495AAD83D144D2F19BF9BB22987_444036679;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_783418754 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_783418754.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_783418754;
        } //End block
        // ---------- Original Method ----------
        //try {
            //LinkedList<E> l = (LinkedList<E>) super.clone();
            //l.size = 0;
            //l.voidLink = new Link<E>(null, null, null);
            //l.voidLink.previous = l.voidLink;
            //l.voidLink.next = l.voidLink;
            //l.addAll(this);
            //return l;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.147 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "41133C010069BFE2BA35A24C340CBB66")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        Link<E> link = voidLink.next;
    if(object != null)        
        {
            while
(link != voidLink)            
            {
    if(object.equals(link.data))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_111632648 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149610872 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_149610872;
                } //End block
                link = link.next;
            } //End block
        } //End block
        else
        {
            while
(link != voidLink)            
            {
    if(link.data == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1286119891 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895144633 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895144633;
                } //End block
                link = link.next;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1714122100 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792417620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792417620;
        // ---------- Original Method ----------
        //Link<E> link = voidLink.next;
        //if (object != null) {
            //while (link != voidLink) {
                //if (object.equals(link.data)) {
                    //return true;
                //}
                //link = link.next;
            //}
        //} else {
            //while (link != voidLink) {
                //if (link.data == null) {
                    //return true;
                //}
                //link = link.next;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.148 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "15934EF70C758ED843C2F3EC7828CB91")
    @Override
    public E get(int location) {
        addTaint(location);
    if(location >= 0 && location < size)        
        {
            Link<E> link = voidLink;
    if(location < (size / 2))            
            {
for(int i = 0;i <= location;i++)
                {
                    link = link.next;
                } //End block
            } //End block
            else
            {
for(int i = size;i > location;i--)
                {
                    link = link.previous;
                } //End block
            } //End block
E var3CF301EF1455302B1A7564AEE107BC17_1815463061 =             link.data;
            var3CF301EF1455302B1A7564AEE107BC17_1815463061.addTaint(taint);
            return var3CF301EF1455302B1A7564AEE107BC17_1815463061;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1847441768 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_1847441768.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_1847441768;
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //return link.data;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.148 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "CD09E61FB50867259D416004514E7DC8")
    public E getFirst() {
E var47B6E8AF818F6390E3E49621F01F780F_1665189721 =         getFirstImpl();
        var47B6E8AF818F6390E3E49621F01F780F_1665189721.addTaint(taint);
        return var47B6E8AF818F6390E3E49621F01F780F_1665189721;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.149 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "6E6961445EF4507370DD142099BC2E09")
    private E getFirstImpl() {
        Link<E> first = voidLink.next;
    if(first != voidLink)        
        {
E var32190092A31795B8431D755C5C48DC21_1443691860 =             first.data;
            var32190092A31795B8431D755C5C48DC21_1443691860.addTaint(taint);
            return var32190092A31795B8431D755C5C48DC21_1443691860;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_928297091 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_928297091.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_928297091;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.149 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "FBF98369EA7234A78F862686B19D201D")
    public E getLast() {
        Link<E> last = voidLink.previous;
    if(last != voidLink)        
        {
E varB1F122C9C1AAC8A4CFF306CF36360451_413687342 =             last.data;
            varB1F122C9C1AAC8A4CFF306CF36360451_413687342.addTaint(taint);
            return varB1F122C9C1AAC8A4CFF306CF36360451_413687342;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_329310089 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_329310089.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_329310089;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.150 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "7D8275B08F501A500774D6A1D9DE9AC7")
    @Override
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        int pos = 0;
        Link<E> link = voidLink.next;
    if(object != null)        
        {
            while
(link != voidLink)            
            {
    if(object.equals(link.data))                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1160818344 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373793674 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373793674;
                } //End block
                link = link.next;
                pos++;
            } //End block
        } //End block
        else
        {
            while
(link != voidLink)            
            {
    if(link.data == null)                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1235126192 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645325442 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645325442;
                } //End block
                link = link.next;
                pos++;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_633021797 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924354143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924354143;
        // ---------- Original Method ----------
        //int pos = 0;
        //Link<E> link = voidLink.next;
        //if (object != null) {
            //while (link != voidLink) {
                //if (object.equals(link.data)) {
                    //return pos;
                //}
                //link = link.next;
                //pos++;
            //}
        //} else {
            //while (link != voidLink) {
                //if (link.data == null) {
                    //return pos;
                //}
                //link = link.next;
                //pos++;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.151 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "50DD51D1457B97DEF566E82A3E477DD4")
    @Override
    public int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        int pos = size;
        Link<E> link = voidLink.previous;
    if(object != null)        
        {
            while
(link != voidLink)            
            {
                pos--;
    if(object.equals(link.data))                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_2061566777 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249015396 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249015396;
                } //End block
                link = link.previous;
            } //End block
        } //End block
        else
        {
            while
(link != voidLink)            
            {
                pos--;
    if(link.data == null)                
                {
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1998410349 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018196895 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018196895;
                } //End block
                link = link.previous;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1860824897 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376634203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376634203;
        // ---------- Original Method ----------
        //int pos = size;
        //Link<E> link = voidLink.previous;
        //if (object != null) {
            //while (link != voidLink) {
                //pos--;
                //if (object.equals(link.data)) {
                    //return pos;
                //}
                //link = link.previous;
            //}
        //} else {
            //while (link != voidLink) {
                //pos--;
                //if (link.data == null) {
                    //return pos;
                //}
                //link = link.previous;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.152 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "F81B5BE9CDD586C1EFEB2C1262D4A892")
    @Override
    public ListIterator<E> listIterator(int location) {
        addTaint(location);
ListIterator<E> varF5869D7C478B5AD13C9F94EE40954182_37759800 =         new LinkIterator<E>(this, location);
        varF5869D7C478B5AD13C9F94EE40954182_37759800.addTaint(taint);
        return varF5869D7C478B5AD13C9F94EE40954182_37759800;
        // ---------- Original Method ----------
        //return new LinkIterator<E>(this, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.152 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "6D861CC061E883706F22FF128CAB3C66")
    @Override
    public E remove(int location) {
        addTaint(location);
    if(location >= 0 && location < size)        
        {
            Link<E> link = voidLink;
    if(location < (size / 2))            
            {
for(int i = 0;i <= location;i++)
                {
                    link = link.next;
                } //End block
            } //End block
            else
            {
for(int i = size;i > location;i--)
                {
                    link = link.previous;
                } //End block
            } //End block
            Link<E> previous = link.previous;
            Link<E> next = link.next;
            previous.next = next;
            next.previous = previous;
            size--;
            modCount++;
E var3CF301EF1455302B1A7564AEE107BC17_257217871 =             link.data;
            var3CF301EF1455302B1A7564AEE107BC17_257217871.addTaint(taint);
            return var3CF301EF1455302B1A7564AEE107BC17_257217871;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_357976353 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_357976353.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_357976353;
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //Link<E> previous = link.previous;
            //Link<E> next = link.next;
            //previous.next = next;
            //next.previous = previous;
            //size--;
            //modCount++;
            //return link.data;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.153 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "5EA15F1B208B20BE26FA4101580D18B0")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean var36088FA245EBE6875E99FB01345160D0_411633239 = (removeFirstOccurrenceImpl(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790471098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790471098;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.153 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "F1BEA4DEF94088A98EEC6699A5BEF2FD")
    public E removeFirst() {
E varAD3301876DF8721CEF17AFAABE29CC10_415190754 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_415190754.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_415190754;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.154 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "717C0447C3687630A16B37BFA55A0614")
    private E removeFirstImpl() {
        Link<E> first = voidLink.next;
    if(first != voidLink)        
        {
            Link<E> next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
            size--;
            modCount++;
E var32190092A31795B8431D755C5C48DC21_1805736002 =             first.data;
            var32190092A31795B8431D755C5C48DC21_1805736002.addTaint(taint);
            return var32190092A31795B8431D755C5C48DC21_1805736002;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1634376294 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1634376294.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1634376294;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //Link<E> next = first.next;
            //voidLink.next = next;
            //next.previous = voidLink;
            //size--;
            //modCount++;
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.154 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "66B52BAB4E3F760E39BD578C2480D481")
    public E removeLast() {
E var9B185E513539753A1568AE8CD0F09784_337914097 =         removeLastImpl();
        var9B185E513539753A1568AE8CD0F09784_337914097.addTaint(taint);
        return var9B185E513539753A1568AE8CD0F09784_337914097;
        // ---------- Original Method ----------
        //return removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.155 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "0DE20CBE8C971A08A623F09B7DC2A752")
    private E removeLastImpl() {
        Link<E> last = voidLink.previous;
    if(last != voidLink)        
        {
            Link<E> previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
            size--;
            modCount++;
E varB1F122C9C1AAC8A4CFF306CF36360451_412724213 =             last.data;
            varB1F122C9C1AAC8A4CFF306CF36360451_412724213.addTaint(taint);
            return varB1F122C9C1AAC8A4CFF306CF36360451_412724213;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1411486751 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1411486751.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1411486751;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //Link<E> previous = last.previous;
            //voidLink.previous = previous;
            //previous.next = voidLink;
            //size--;
            //modCount++;
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.155 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "FAFDD1FC77121B428110F257A3C75388")
    public Iterator<E> descendingIterator() {
Iterator<E> var3C0C25881C2D4E8C7AFB7E0B8222F14B_495129282 =         new ReverseLinkIterator<E>(this);
        var3C0C25881C2D4E8C7AFB7E0B8222F14B_495129282.addTaint(taint);
        return var3C0C25881C2D4E8C7AFB7E0B8222F14B_495129282;
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.156 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "5530FE6A2C999DA6690C669E4446505F")
    public boolean offerFirst(E e) {
        addTaint(e.getTaint());
        boolean var859A5F6C4110FD060308B4761657EBA7_2142746220 = (addFirstImpl(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764566900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764566900;
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.156 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "9CA46188E8AB55C86514C5AF6DCF57C6")
    public boolean offerLast(E e) {
        addTaint(e.getTaint());
        boolean var61B56F913C2670389CAB1654F5BA1D28_604773610 = (addLastImpl(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704423274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704423274;
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.156 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "A36191230E39C619B3132A41A2C139B1")
    public E peekFirst() {
E varC5D6CF62AE624C33AEE3FCED2C6BFAA2_368856789 =         peekFirstImpl();
        varC5D6CF62AE624C33AEE3FCED2C6BFAA2_368856789.addTaint(taint);
        return varC5D6CF62AE624C33AEE3FCED2C6BFAA2_368856789;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.156 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "A196C845875E24E6BE4A161855A47227")
    public E peekLast() {
        Link<E> last = voidLink.previous;
E var97150CAA35F90974D4775F30988DD726_1409479672 =         (last == voidLink) ? null : last.data;
        var97150CAA35F90974D4775F30988DD726_1409479672.addTaint(taint);
        return var97150CAA35F90974D4775F30988DD726_1409479672;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.157 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "63D8290369BAE358FAA34C70AEFCD8BE")
    public E pollFirst() {
E var76EAE988EE17492C661288638E6F6F40_90204101 =         (size == 0) ? null : removeFirstImpl();
        var76EAE988EE17492C661288638E6F6F40_90204101.addTaint(taint);
        return var76EAE988EE17492C661288638E6F6F40_90204101;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.157 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "668A480FE6A4F78BC362C55AF54154F2")
    public E pollLast() {
E var53B0A53ED6225EB3767DD5FE637D8E88_1358413712 =         (size == 0) ? null : removeLastImpl();
        var53B0A53ED6225EB3767DD5FE637D8E88_1358413712.addTaint(taint);
        return var53B0A53ED6225EB3767DD5FE637D8E88_1358413712;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.157 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "286526C499C25D7584E8225A4747DC61")
    public E pop() {
E varAD3301876DF8721CEF17AFAABE29CC10_1663817210 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_1663817210.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_1663817210;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.158 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "8E3E5AB8C2EFDDF648D93DCEA06B9D05")
    public void push(E e) {
        addTaint(e.getTaint());
        addFirstImpl(e);
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.158 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "D82E9401E0B969C3EA2432E1790373E1")
    public boolean removeFirstOccurrence(Object o) {
        addTaint(o.getTaint());
        boolean var8F395D378673FF03D3E905BD5760116F_2089798133 = (removeFirstOccurrenceImpl(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020211660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020211660;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.158 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "9DCDD3F568A26D0BB5297516AD073829")
    public boolean removeLastOccurrence(Object o) {
        addTaint(o.getTaint());
        Iterator<E> iter = new ReverseLinkIterator<E>(this);
        boolean var3365F736CE3B87EEC5D86CE6612A84A0_806559445 = (removeOneOccurrence(o, iter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174537166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174537166;
        // ---------- Original Method ----------
        //Iterator<E> iter = new ReverseLinkIterator<E>(this);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.159 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "78FFCAC407211BAC87E50727F861A96A")
    private boolean removeFirstOccurrenceImpl(Object o) {
        addTaint(o.getTaint());
        Iterator<E> iter = new LinkIterator<E>(this, 0);
        boolean var3365F736CE3B87EEC5D86CE6612A84A0_1129444699 = (removeOneOccurrence(o, iter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586096473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_586096473;
        // ---------- Original Method ----------
        //Iterator<E> iter = new LinkIterator<E>(this, 0);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.159 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "FD2BF1B12081747FB8C40ED50EFCBAD1")
    private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        addTaint(iter.getTaint());
        addTaint(o.getTaint());
        while
(iter.hasNext())        
        {
            E element = iter.next();
    if(o == null ? element == null : o.equals(element))            
            {
                iter.remove();
                boolean varB326B5062B2F0E69046810717534CB09_490682183 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057582344 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057582344;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_643909519 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864390018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864390018;
        // ---------- Original Method ----------
        //while (iter.hasNext()) {
            //E element = iter.next();
            //if (o == null ? element == null : o.equals(element)) {
                //iter.remove();
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.160 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "BA14E8B876064E5B1FAED525CC73A9A3")
    @Override
    public E set(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
    if(location >= 0 && location < size)        
        {
            Link<E> link = voidLink;
    if(location < (size / 2))            
            {
for(int i = 0;i <= location;i++)
                {
                    link = link.next;
                } //End block
            } //End block
            else
            {
for(int i = size;i > location;i--)
                {
                    link = link.previous;
                } //End block
            } //End block
            E result = link.data;
            link.data = object;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1249774029 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1249774029.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1249774029;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1707239958 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_1707239958.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_1707239958;
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //E result = link.data;
            //link.data = object;
            //return result;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.161 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "C688996896AC3945036F5DAAC84A44DE")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_351808335 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487476198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487476198;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.161 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "EFA55C5D8B49768C2A8500447DC6F309")
    public boolean offer(E o) {
        addTaint(o.getTaint());
        boolean var29D0A13D767EBEC9C1FE76208DE66DF4_151973312 = (addLastImpl(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527803030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527803030;
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.161 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "88C11E76065B2680D95951FF75EBDAF1")
    public E poll() {
E varBD3DE60B97A4CAE572BB184D74D72321_427491331 =         size == 0 ? null : removeFirst();
        varBD3DE60B97A4CAE572BB184D74D72321_427491331.addTaint(taint);
        return varBD3DE60B97A4CAE572BB184D74D72321_427491331;
        // ---------- Original Method ----------
        //return size == 0 ? null : removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.162 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "33402FA3BE94A6E6998C329028531623")
    public E remove() {
E varAD3301876DF8721CEF17AFAABE29CC10_334140247 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_334140247.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_334140247;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.162 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "6861603666B9B31699EDC0DEF72413B8")
    public E peek() {
E varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1397068295 =         peekFirstImpl();
        varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1397068295.addTaint(taint);
        return varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1397068295;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.162 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "68AB7D670D1E4E282B1D785231C36313")
    private E peekFirstImpl() {
        Link<E> first = voidLink.next;
E varCFFADB90EC8B0C6958D9CAB391DA534D_2521820 =         first == voidLink ? null : first.data;
        varCFFADB90EC8B0C6958D9CAB391DA534D_2521820.addTaint(taint);
        return varCFFADB90EC8B0C6958D9CAB391DA534D_2521820;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //return first == voidLink ? null : first.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.162 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "ABD1E82EE0D5B8DB80E40AA721207ADC")
    public E element() {
E var47B6E8AF818F6390E3E49621F01F780F_1431351391 =         getFirstImpl();
        var47B6E8AF818F6390E3E49621F01F780F_1431351391.addTaint(taint);
        return var47B6E8AF818F6390E3E49621F01F780F_1431351391;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.163 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "BFDF9E54CF7BB4C625564E37DF37D00C")
    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] contents = new Object[size];
        Link<E> link = voidLink.next;
        while
(link != voidLink)        
        {
            contents[index++] = link.data;
            link = link.next;
        } //End block
Object[] var5DC9C33EDB9F81CF1216538024B770BE_1705126076 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_1705126076.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_1705126076;
        // ---------- Original Method ----------
        //int index = 0;
        //Object[] contents = new Object[size];
        //Link<E> link = voidLink.next;
        //while (link != voidLink) {
            //contents[index++] = link.data;
            //link = link.next;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.164 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "394386C30CC1C2F36A5856E4F4632D5E")
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        int index = 0;
    if(size > contents.length)        
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        Link<E> link = voidLink.next;
        while
(link != voidLink)        
        {
            contents[index++] = (T) link.data;
            link = link.next;
        } //End block
    if(index < contents.length)        
        {
            contents[index] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_1304057653 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_1304057653.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_1304057653;
        // ---------- Original Method ----------
        //int index = 0;
        //if (size > contents.length) {
            //Class<?> ct = contents.getClass().getComponentType();
            //contents = (T[]) Array.newInstance(ct, size);
        //}
        //Link<E> link = voidLink.next;
        //while (link != voidLink) {
            //contents[index++] = (T) link.data;
            //link = link.next;
        //}
        //if (index < contents.length) {
            //contents[index] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.164 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "15C731CFA7712C533369F8FFD15F051E")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<E> it = iterator();
        while
(it.hasNext())        
        {
            stream.writeObject(it.next());
        } //End block
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(size);
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
            //stream.writeObject(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.165 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "581C710E4AAE3D3860B5F9D074085890")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        size = stream.readInt();
        voidLink = new Link<E>(null, null, null);
        Link<E> link = voidLink;
for(int i = size;--i >= 0;)
        {
            Link<E> nextLink = new Link<E>((E) stream.readObject(), link, null);
            link.next = nextLink;
            link = nextLink;
        } //End block
        link.next = voidLink;
        voidLink.previous = link;
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //size = stream.readInt();
        //voidLink = new Link<E>(null, null, null);
        //Link<E> link = voidLink;
        //for (int i = size; --i >= 0;) {
            //Link<E> nextLink = new Link<E>((E) stream.readObject(), link, null);
            //link.next = nextLink;
            //link = nextLink;
        //}
        //link.next = voidLink;
        //voidLink.previous = link;
    }

    
    private static final class Link<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.166 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B3480F581DDA17D478907EC9EE768C50")

        ET data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.166 -0400", hash_original_field = "2327346E833EFCD6B2E7B3F0A4DF8EBB", hash_generated_field = "45A046E5D1D7F8BD1511ED0837170D9B")

        Link<ET> previous;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.166 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "99500FE4EDB0AA48BDE52F63DB34B10F")

        Link<ET> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.166 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "FF7F178B4230792375EA8BB041BC2BA6")
          Link(ET o, Link<ET> p, Link<ET> n) {
            data = o;
            previous = p;
            next = n;
            // ---------- Original Method ----------
            //data = o;
            //previous = p;
            //next = n;
        }

        
    }


    
    private static final class LinkIterator<ET> implements ListIterator<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.167 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

        int pos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.167 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.167 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "52794B45189EFF95B13E35D799B9BD43")

        LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.167 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "F851AA6845CD2B23EE54FB486DA1D214")

        Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.167 -0400", hash_original_field = "1A533DA437F86DDD82B433DEC7C72599", hash_generated_field = "ACB4020CEB7749245E32063C8F282FD3")

        Link<ET> lastLink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.168 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "1D25C49F6E33D6024620DB37567727EE")
          LinkIterator(LinkedList<ET> object, int location) {
            addTaint(location);
            list = object;
            expectedModCount = list.modCount;
    if(location >= 0 && location <= list.size)            
            {
                link = list.voidLink;
    if(location < list.size / 2)                
                {
for(pos = -1;pos + 1 < location;pos++)
                    {
                        link = link.next;
                    } //End block
                } //End block
                else
                {
for(pos = list.size;pos >= location;pos--)
                    {
                        link = link.previous;
                    } //End block
                } //End block
            } //End block
            else
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1335887839 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1335887839.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1335887839;
            } //End block
            // ---------- Original Method ----------
            //list = object;
            //expectedModCount = list.modCount;
            //if (location >= 0 && location <= list.size) {
                //link = list.voidLink;
                //if (location < list.size / 2) {
                    //for (pos = -1; pos + 1 < location; pos++) {
                        //link = link.next;
                    //}
                //} else {
                    //for (pos = list.size; pos >= location; pos--) {
                        //link = link.previous;
                    //}
                //}
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.169 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "0120E596FEF7DDC375923E45293637E0")
        public void add(ET object) {
            addTaint(object.getTaint());
    if(expectedModCount == list.modCount)            
            {
                Link<ET> next = link.next;
                Link<ET> newLink = new Link<ET>(object, link, next);
                link.next = newLink;
                next.previous = newLink;
                link = newLink;
                lastLink = null;
                pos++;
                expectedModCount++;
                list.size++;
                list.modCount++;
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1115869234 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1115869234.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1115869234;
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //Link<ET> next = link.next;
                //Link<ET> newLink = new Link<ET>(object, link, next);
                //link.next = newLink;
                //next.previous = newLink;
                //link = newLink;
                //lastLink = null;
                //pos++;
                //expectedModCount++;
                //list.size++;
                //list.modCount++;
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.170 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "8A312B8563946FEB2D390CD4A97139C7")
        public boolean hasNext() {
            boolean varAD6FE720EFC75BB0F476FCE3EDA7D791_35824225 = (link.next != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974906675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_974906675;
            // ---------- Original Method ----------
            //return link.next != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.170 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "F10E054B031362561CC9C093F1CB4BBB")
        public boolean hasPrevious() {
            boolean var7402B0DEA06103F10127D3EB592F398E_354738054 = (link != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846610712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846610712;
            // ---------- Original Method ----------
            //return link != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.170 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "5EAD7EB4D7902614B78B236639DB47BE")
        public ET next() {
    if(expectedModCount == list.modCount)            
            {
                LinkedList.Link<ET> next = link.next;
    if(next != list.voidLink)                
                {
                    lastLink = link = next;
                    pos++;
ET var3CF301EF1455302B1A7564AEE107BC17_591142894 =                     link.data;
                    var3CF301EF1455302B1A7564AEE107BC17_591142894.addTaint(taint);
                    return var3CF301EF1455302B1A7564AEE107BC17_591142894;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1607848910 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1607848910.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1607848910;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2124777599 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_2124777599.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_2124777599;
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //LinkedList.Link<ET> next = link.next;
                //if (next != list.voidLink) {
                    //lastLink = link = next;
                    //pos++;
                    //return link.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.171 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "AFC31DBE5517D772461190DD9EEE3203")
        public int nextIndex() {
            int varF9B06598B7E41FEBC3492F881D35DA6D_840699141 = (pos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061226192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061226192;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.171 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "9669EC9514F9800E67AF9473E1977E13")
        public ET previous() {
    if(expectedModCount == list.modCount)            
            {
    if(link != list.voidLink)                
                {
                    lastLink = link;
                    link = link.previous;
                    pos--;
ET var31C1257716FF314002B1C1E06C0E652A_854666762 =                     lastLink.data;
                    var31C1257716FF314002B1C1E06C0E652A_854666762.addTaint(taint);
                    return var31C1257716FF314002B1C1E06C0E652A_854666762;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_179155651 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_179155651.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_179155651;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1726398932 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1726398932.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1726398932;
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (link != list.voidLink) {
                    //lastLink = link;
                    //link = link.previous;
                    //pos--;
                    //return lastLink.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.172 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "2D85E66FBF167453577DFF508BACE2D7")
        public int previousIndex() {
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_719298862 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786161184 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786161184;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.172 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "D79A7E3A024CF86F278F7B147B899284")
        public void remove() {
    if(expectedModCount == list.modCount)            
            {
    if(lastLink != null)                
                {
                    Link<ET> next = lastLink.next;
                    Link<ET> previous = lastLink.previous;
                    next.previous = previous;
                    previous.next = next;
    if(lastLink == link)                    
                    {
                        pos--;
                    } //End block
                    link = previous;
                    lastLink = null;
                    expectedModCount++;
                    list.size--;
                    list.modCount++;
                } //End block
                else
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1784566709 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1784566709.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1784566709;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_775469462 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_775469462.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_775469462;
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (lastLink != null) {
                    //Link<ET> next = lastLink.next;
                    //Link<ET> previous = lastLink.previous;
                    //next.previous = previous;
                    //previous.next = next;
                    //if (lastLink == link) {
                        //pos--;
                    //}
                    //link = previous;
                    //lastLink = null;
                    //expectedModCount++;
                    //list.size--;
                    //list.modCount++;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.173 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "36FFD991FB6F260260DA17D1AB62BAB3")
        public void set(ET object) {
    if(expectedModCount == list.modCount)            
            {
    if(lastLink != null)                
                {
                    lastLink.data = object;
                } //End block
                else
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1049309281 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1049309281.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1049309281;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_373780927 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_373780927.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_373780927;
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (lastLink != null) {
                    //lastLink.data = object;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    private class ReverseLinkIterator<ET> implements Iterator<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.174 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.174 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "D1EC04877DB93B65C0C16B144052AC71")

        private LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.174 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "C029ECB4203CCD8751E5C756F40C32AD")

        private Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.174 -0400", hash_original_field = "7385E778E1358730CFB4F236AF9FF24A", hash_generated_field = "C01834E3EF87C859E7B00C0837E2E4D3")

        private boolean canRemove;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.175 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "98C036A6F3260A1B3893C647A1DF0F6C")
          ReverseLinkIterator(LinkedList<ET> linkedList) {
            list = linkedList;
            expectedModCount = list.modCount;
            link = list.voidLink;
            canRemove = false;
            // ---------- Original Method ----------
            //list = linkedList;
            //expectedModCount = list.modCount;
            //link = list.voidLink;
            //canRemove = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.175 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "532D70150E0D69E4284DF666CE2FA31D")
        public boolean hasNext() {
            boolean var3FF1ABEDF980308C41F7F499B74280AE_400027452 = (link.previous != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529916138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529916138;
            // ---------- Original Method ----------
            //return link.previous != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.175 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "89C3BCCE6050CEF6E439B25A65BC3254")
        public ET next() {
    if(expectedModCount == list.modCount)            
            {
    if(hasNext())                
                {
                    link = link.previous;
                    canRemove = true;
ET var3CF301EF1455302B1A7564AEE107BC17_440829307 =                     link.data;
                    var3CF301EF1455302B1A7564AEE107BC17_440829307.addTaint(taint);
                    return var3CF301EF1455302B1A7564AEE107BC17_440829307;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_2118222095 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_2118222095.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_2118222095;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1487658398 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1487658398.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1487658398;
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (hasNext()) {
                    //link = link.previous;
                    //canRemove = true;
                    //return link.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.176 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "A259816A94BD7624299C47DC497F37FC")
        public void remove() {
    if(expectedModCount == list.modCount)            
            {
    if(canRemove)                
                {
                    Link<ET> next = link.previous;
                    Link<ET> previous = link.next;
                    next.next = previous;
                    previous.previous = next;
                    link = previous;
                    list.size--;
                    list.modCount++;
                    expectedModCount++;
                    canRemove = false;
                    return;
                } //End block
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_401848687 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_401848687.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_401848687;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_283121275 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_283121275.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_283121275;
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (canRemove) {
                    //Link<ET> next = link.previous;
                    //Link<ET> previous = link.next;
                    //next.next = previous;
                    //previous.previous = next;
                    //link = previous;
                    //list.size--;
                    //list.modCount++;
                    //expectedModCount++;
                    //canRemove = false;
                    //return;
                //}
                //throw new IllegalStateException();
            //}
            //throw new ConcurrentModificationException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.177 -0400", hash_original_field = "A91BB42ABDC7657C70EC735A482E86B5", hash_generated_field = "5F23BECC14072AFC76D2F21910086550")

    private static final long serialVersionUID = 876323262645176354L;
}

