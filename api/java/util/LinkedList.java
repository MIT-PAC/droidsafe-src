package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;






public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.113 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "073488151E86FC108C1C096E75333D8B")

    transient int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.113 -0400", hash_original_field = "6C73C6B87FF2058988CE8C8EDB3429F0", hash_generated_field = "42E74DE51E61A92C4317D76844761684")

    transient Link<E> voidLink;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.114 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    public  LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        // ---------- Original Method ----------
        //voidLink = new Link<E>(null, null, null);
        //voidLink.previous = voidLink;
        //voidLink.next = voidLink;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.115 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "C5AA269F9975EBBFEE953030F41D5191")
    public  LinkedList(Collection<? extends E> collection) {
        this();
        addTaint(collection.getTaint());
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.116 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "B786963055FE6BB03F4506D7C1BC039C")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1003915613 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1003915613.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1003915613;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.116 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "35086E6FF5626BDD8EFD96D6F8815382")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        boolean varCF3A1FB654444BBD2951772DE0522D74_1105997162 = (addLastImpl(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797634809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797634809;
        // ---------- Original Method ----------
        //return addLastImpl(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.117 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "E975E3493848BD70FB48EA720F1B3370")
    private boolean addLastImpl(E object) {
        addTaint(object.getTaint());
        Link<E> oldLast = voidLink.previous;
        Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        size++;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_2047539751 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497696269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497696269;
        // ---------- Original Method ----------
        //Link<E> oldLast = voidLink.previous;
        //Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        //voidLink.previous = newLink;
        //oldLast.next = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.120 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "D4CE4E2F1FE709675A6C51A8B58D83B0")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(location);
        if(location < 0 || location > size)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_795891673 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_795891673.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_795891673;
        } //End block
        int adding = collection.size();
        if(adding == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_133682305 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953828824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953828824;
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
        boolean varB326B5062B2F0E69046810717534CB09_542371844 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996564741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996564741;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.121 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "113CC20BF8FFA66267C06E9B1A0EAB55")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        int adding = collection.size();
        if(adding == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_988385051 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099435564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099435564;
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
        boolean varB326B5062B2F0E69046810717534CB09_61049276 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310622308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310622308;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.121 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "5A556DD598DD4B7AE272E66D69A80C0F")
    public void addFirst(E object) {
        addTaint(object.getTaint());
        addFirstImpl(object);
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.122 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "E806FF4180242C81D0508B65C7824DB1")
    private boolean addFirstImpl(E object) {
        addTaint(object.getTaint());
        Link<E> oldFirst = voidLink.next;
        Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        size++;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_863755401 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_396252300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_396252300;
        // ---------- Original Method ----------
        //Link<E> oldFirst = voidLink.next;
        //Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        //voidLink.next = newLink;
        //oldFirst.previous = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.122 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "5E57D6CF03EA15D68138243087D069FE")
    public void addLast(E object) {
        addTaint(object.getTaint());
        addLastImpl(object);
        // ---------- Original Method ----------
        //addLastImpl(object);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.123 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "8DEF4216863EAF1EF004538968BFEB12")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.124 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "2078156C30F179FF53C16F4B21073FEB")
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
Object var792FD495AAD83D144D2F19BF9BB22987_1928323188 =             l;
            var792FD495AAD83D144D2F19BF9BB22987_1928323188.addTaint(taint);
            return var792FD495AAD83D144D2F19BF9BB22987_1928323188;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_841861649 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_841861649.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_841861649;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.124 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "FD95D1C82A72E5A70D734AFC979D0681")
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
                    boolean varB326B5062B2F0E69046810717534CB09_102278790 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073723501 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073723501;
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
                    boolean varB326B5062B2F0E69046810717534CB09_1716284572 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010990467 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010990467;
                } //End block
                link = link.next;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1438195996 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683677479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683677479;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.125 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "56982C02CBBFACACA0073A75DE618943")
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
E var3CF301EF1455302B1A7564AEE107BC17_1535512027 =             link.data;
            var3CF301EF1455302B1A7564AEE107BC17_1535512027.addTaint(taint);
            return var3CF301EF1455302B1A7564AEE107BC17_1535512027;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1686209273 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_1686209273.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_1686209273;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.126 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "82AD0E2AD0C962DA96A1294602E8A14B")
    public E getFirst() {
E var47B6E8AF818F6390E3E49621F01F780F_453290605 =         getFirstImpl();
        var47B6E8AF818F6390E3E49621F01F780F_453290605.addTaint(taint);
        return var47B6E8AF818F6390E3E49621F01F780F_453290605;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.126 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "2C9CCC75F9378A6298872353447EFF34")
    private E getFirstImpl() {
        Link<E> first = voidLink.next;
        if(first != voidLink)        
        {
E var32190092A31795B8431D755C5C48DC21_793608491 =             first.data;
            var32190092A31795B8431D755C5C48DC21_793608491.addTaint(taint);
            return var32190092A31795B8431D755C5C48DC21_793608491;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_370313966 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_370313966.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_370313966;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.126 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "879D570AE8E3EA434CCC92636D7DC4AE")
    public E getLast() {
        Link<E> last = voidLink.previous;
        if(last != voidLink)        
        {
E varB1F122C9C1AAC8A4CFF306CF36360451_262941152 =             last.data;
            varB1F122C9C1AAC8A4CFF306CF36360451_262941152.addTaint(taint);
            return varB1F122C9C1AAC8A4CFF306CF36360451_262941152;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1562898767 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1562898767.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1562898767;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.127 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "14E184305C935AC7BA9BDA89C7D90C6F")
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
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_604404489 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401219446 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401219446;
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
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1362213238 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936251766 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936251766;
                } //End block
                link = link.next;
                pos++;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_256872932 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586365468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586365468;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.128 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "5E6174B4CB6EE24332958A2B07E85752")
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
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1694881054 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693829465 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693829465;
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
                    int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1279213394 = (pos);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005241490 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005241490;
                } //End block
                link = link.previous;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1926408241 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639752285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639752285;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.129 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "E0D7343773012BD00436BBFD57259933")
    @Override
    public ListIterator<E> listIterator(int location) {
        addTaint(location);
ListIterator<E> varF5869D7C478B5AD13C9F94EE40954182_78747046 =         new LinkIterator<E>(this, location);
        varF5869D7C478B5AD13C9F94EE40954182_78747046.addTaint(taint);
        return varF5869D7C478B5AD13C9F94EE40954182_78747046;
        // ---------- Original Method ----------
        //return new LinkIterator<E>(this, location);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.130 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "354B996B85BE92C0410D42290FCFEAFB")
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
E var3CF301EF1455302B1A7564AEE107BC17_412404245 =             link.data;
            var3CF301EF1455302B1A7564AEE107BC17_412404245.addTaint(taint);
            return var3CF301EF1455302B1A7564AEE107BC17_412404245;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_806446160 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_806446160.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_806446160;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.130 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "190F7D8F1F2CA28E8230A9319E3F7898")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean var36088FA245EBE6875E99FB01345160D0_885726564 = (removeFirstOccurrenceImpl(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759500360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_759500360;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.131 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "1E330664B0192718A87C4DDD29426DDB")
    public E removeFirst() {
E varAD3301876DF8721CEF17AFAABE29CC10_1516239400 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_1516239400.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_1516239400;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.132 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "A3AD6573FA66D4943D34DE0167E79C17")
    private E removeFirstImpl() {
        Link<E> first = voidLink.next;
        if(first != voidLink)        
        {
            Link<E> next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
            size--;
            modCount++;
E var32190092A31795B8431D755C5C48DC21_110291833 =             first.data;
            var32190092A31795B8431D755C5C48DC21_110291833.addTaint(taint);
            return var32190092A31795B8431D755C5C48DC21_110291833;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1181569334 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1181569334.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1181569334;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.132 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "F8BCF0B3E87B2775ED83E22680730DFF")
    public E removeLast() {
E var9B185E513539753A1568AE8CD0F09784_1241050536 =         removeLastImpl();
        var9B185E513539753A1568AE8CD0F09784_1241050536.addTaint(taint);
        return var9B185E513539753A1568AE8CD0F09784_1241050536;
        // ---------- Original Method ----------
        //return removeLastImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "2E80457A777DCE17FF5AA858247AD9B8")
    private E removeLastImpl() {
        Link<E> last = voidLink.previous;
        if(last != voidLink)        
        {
            Link<E> previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
            size--;
            modCount++;
E varB1F122C9C1AAC8A4CFF306CF36360451_1402362349 =             last.data;
            varB1F122C9C1AAC8A4CFF306CF36360451_1402362349.addTaint(taint);
            return varB1F122C9C1AAC8A4CFF306CF36360451_1402362349;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_896552576 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_896552576.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_896552576;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "5BFD32313DD750C7CA5760471E7BA36B")
    public Iterator<E> descendingIterator() {
Iterator<E> var3C0C25881C2D4E8C7AFB7E0B8222F14B_168146712 =         new ReverseLinkIterator<E>(this);
        var3C0C25881C2D4E8C7AFB7E0B8222F14B_168146712.addTaint(taint);
        return var3C0C25881C2D4E8C7AFB7E0B8222F14B_168146712;
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "78D7639AE5EBC21A98948F5640215680")
    public boolean offerFirst(E e) {
        addTaint(e.getTaint());
        boolean var859A5F6C4110FD060308B4761657EBA7_1612036868 = (addFirstImpl(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421322830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421322830;
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.133 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "1E07379150837DD74ABC9481EE0631B5")
    public boolean offerLast(E e) {
        addTaint(e.getTaint());
        boolean var61B56F913C2670389CAB1654F5BA1D28_1162745764 = (addLastImpl(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388533516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388533516;
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "22691D0470A83276A2325A7168F7857B")
    public E peekFirst() {
E varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1126685807 =         peekFirstImpl();
        varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1126685807.addTaint(taint);
        return varC5D6CF62AE624C33AEE3FCED2C6BFAA2_1126685807;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "024A9E03091FFAC89C64A05EB8A81FCD")
    public E peekLast() {
        Link<E> last = voidLink.previous;
E var97150CAA35F90974D4775F30988DD726_1008714890 =         (last == voidLink) ? null : last.data;
        var97150CAA35F90974D4775F30988DD726_1008714890.addTaint(taint);
        return var97150CAA35F90974D4775F30988DD726_1008714890;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "1A057191B4C5100708D2FBE5065E8D57")
    public E pollFirst() {
E var76EAE988EE17492C661288638E6F6F40_1501534422 =         (size == 0) ? null : removeFirstImpl();
        var76EAE988EE17492C661288638E6F6F40_1501534422.addTaint(taint);
        return var76EAE988EE17492C661288638E6F6F40_1501534422;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "D8A7FF381D9EC211AEFBBB90A4CAA3B0")
    public E pollLast() {
E var53B0A53ED6225EB3767DD5FE637D8E88_1608417291 =         (size == 0) ? null : removeLastImpl();
        var53B0A53ED6225EB3767DD5FE637D8E88_1608417291.addTaint(taint);
        return var53B0A53ED6225EB3767DD5FE637D8E88_1608417291;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "B11AB0C013FCB9A8E3C22E5318684A99")
    public E pop() {
E varAD3301876DF8721CEF17AFAABE29CC10_850774123 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_850774123.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_850774123;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "8E3E5AB8C2EFDDF648D93DCEA06B9D05")
    public void push(E e) {
        addTaint(e.getTaint());
        addFirstImpl(e);
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "6F4E8A748C546CBF7A9F3CDA57E3F37A")
    public boolean removeFirstOccurrence(Object o) {
        addTaint(o.getTaint());
        boolean var8F395D378673FF03D3E905BD5760116F_449760660 = (removeFirstOccurrenceImpl(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320014900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320014900;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.134 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "732CCFFDB97E0915B522A631347B728D")
    public boolean removeLastOccurrence(Object o) {
        addTaint(o.getTaint());
        Iterator<E> iter = new ReverseLinkIterator<E>(this);
        boolean var3365F736CE3B87EEC5D86CE6612A84A0_984970524 = (removeOneOccurrence(o, iter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34516140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34516140;
        // ---------- Original Method ----------
        //Iterator<E> iter = new ReverseLinkIterator<E>(this);
        //return removeOneOccurrence(o, iter);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "A4CD8E9CE52EDFC0F6FE76A2F5BB744C")
    private boolean removeFirstOccurrenceImpl(Object o) {
        addTaint(o.getTaint());
        Iterator<E> iter = new LinkIterator<E>(this, 0);
        boolean var3365F736CE3B87EEC5D86CE6612A84A0_1392544000 = (removeOneOccurrence(o, iter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521631934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_521631934;
        // ---------- Original Method ----------
        //Iterator<E> iter = new LinkIterator<E>(this, 0);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "9DDC0B1D5E05429D7358050E932B03D0")
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
                boolean varB326B5062B2F0E69046810717534CB09_513971781 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041370075 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041370075;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_175531948 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226030117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226030117;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "4B7F1FC2E5A15E374F7D6D3106C583FC")
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
E varDC838461EE2FA0CA4C9BBB70A15456B0_1661647823 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1661647823.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1661647823;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1880852709 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_1880852709.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_1880852709;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "8BAB2ADB6D64DE1433A60C245FD85A7D")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1357867933 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272467679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272467679;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "DCC9F2A6A9C30329E761FE33538AF32F")
    public boolean offer(E o) {
        addTaint(o.getTaint());
        boolean var29D0A13D767EBEC9C1FE76208DE66DF4_762929650 = (addLastImpl(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467710243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467710243;
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.135 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "4F808C3914D5953ED32384E74C14C1ED")
    public E poll() {
E varBD3DE60B97A4CAE572BB184D74D72321_67659051 =         size == 0 ? null : removeFirst();
        varBD3DE60B97A4CAE572BB184D74D72321_67659051.addTaint(taint);
        return varBD3DE60B97A4CAE572BB184D74D72321_67659051;
        // ---------- Original Method ----------
        //return size == 0 ? null : removeFirst();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "4D9B6E58041F68E73A123755B0BF1FA7")
    public E remove() {
E varAD3301876DF8721CEF17AFAABE29CC10_50921633 =         removeFirstImpl();
        varAD3301876DF8721CEF17AFAABE29CC10_50921633.addTaint(taint);
        return varAD3301876DF8721CEF17AFAABE29CC10_50921633;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "8BE067080E0634A1915D1ADE92056E6F")
    public E peek() {
E varC5D6CF62AE624C33AEE3FCED2C6BFAA2_307761504 =         peekFirstImpl();
        varC5D6CF62AE624C33AEE3FCED2C6BFAA2_307761504.addTaint(taint);
        return varC5D6CF62AE624C33AEE3FCED2C6BFAA2_307761504;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "2109240B66C06D8D490456571A332FE1")
    private E peekFirstImpl() {
        Link<E> first = voidLink.next;
E varCFFADB90EC8B0C6958D9CAB391DA534D_1673473532 =         first == voidLink ? null : first.data;
        varCFFADB90EC8B0C6958D9CAB391DA534D_1673473532.addTaint(taint);
        return varCFFADB90EC8B0C6958D9CAB391DA534D_1673473532;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //return first == voidLink ? null : first.data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "C5FBCDBEC4241ACA2F00E674FB83707A")
    public E element() {
E var47B6E8AF818F6390E3E49621F01F780F_19877978 =         getFirstImpl();
        var47B6E8AF818F6390E3E49621F01F780F_19877978.addTaint(taint);
        return var47B6E8AF818F6390E3E49621F01F780F_19877978;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "8B65E8C8F7019A3808A51D5C4FEFAB05")
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
Object[] var5DC9C33EDB9F81CF1216538024B770BE_644427220 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_644427220.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_644427220;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.136 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "E4D251C7F68E09A48A0967C866CFCA6D")
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
T[] var5DC9C33EDB9F81CF1216538024B770BE_875582466 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_875582466.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_875582466;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "15C731CFA7712C533369F8FFD15F051E")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "581C710E4AAE3D3860B5F9D074085890")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B3480F581DDA17D478907EC9EE768C50")

        ET data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "2327346E833EFCD6B2E7B3F0A4DF8EBB", hash_generated_field = "45A046E5D1D7F8BD1511ED0837170D9B")

        Link<ET> previous;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "99500FE4EDB0AA48BDE52F63DB34B10F")

        Link<ET> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "FF7F178B4230792375EA8BB041BC2BA6")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

        int pos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "52794B45189EFF95B13E35D799B9BD43")

        LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "F851AA6845CD2B23EE54FB486DA1D214")

        Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.137 -0400", hash_original_field = "1A533DA437F86DDD82B433DEC7C72599", hash_generated_field = "ACB4020CEB7749245E32063C8F282FD3")

        Link<ET> lastLink;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.138 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "039F545C1AA00B63231EF17115673688")
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
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_513454772 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_513454772.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_513454772;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.138 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "1EBFC05B08D2E356FC21FB0667D6B7FD")
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
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1413742695 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1413742695.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1413742695;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.138 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "54082B48DA2B7A78BBBCEA6F5312DF4B")
        public boolean hasNext() {
            boolean varAD6FE720EFC75BB0F476FCE3EDA7D791_1280759525 = (link.next != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835254829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835254829;
            // ---------- Original Method ----------
            //return link.next != list.voidLink;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.138 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "F1BAC4C0DCCDD6553A80E25BD918993F")
        public boolean hasPrevious() {
            boolean var7402B0DEA06103F10127D3EB592F398E_1677520388 = (link != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549571788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549571788;
            // ---------- Original Method ----------
            //return link != list.voidLink;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.139 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "646388F0B322C1303B90362565991D16")
        public ET next() {
            if(expectedModCount == list.modCount)            
            {
                LinkedList.Link<ET> next = link.next;
                if(next != list.voidLink)                
                {
                    lastLink = link = next;
                    pos++;
ET var3CF301EF1455302B1A7564AEE107BC17_1529720788 =                     link.data;
                    var3CF301EF1455302B1A7564AEE107BC17_1529720788.addTaint(taint);
                    return var3CF301EF1455302B1A7564AEE107BC17_1529720788;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1200694794 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1200694794.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1200694794;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_693934861 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_693934861.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_693934861;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.139 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "F5312BB7946EC5BAB048F2AF398555FF")
        public int nextIndex() {
            int varF9B06598B7E41FEBC3492F881D35DA6D_1131131315 = (pos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839477372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839477372;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.139 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "3B513FF17DC59BD94AF25711E36488E1")
        public ET previous() {
            if(expectedModCount == list.modCount)            
            {
                if(link != list.voidLink)                
                {
                    lastLink = link;
                    link = link.previous;
                    pos--;
ET var31C1257716FF314002B1C1E06C0E652A_971858761 =                     lastLink.data;
                    var31C1257716FF314002B1C1E06C0E652A_971858761.addTaint(taint);
                    return var31C1257716FF314002B1C1E06C0E652A_971858761;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_177033754 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_177033754.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_177033754;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1802393432 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1802393432.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1802393432;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.139 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "954D90884E43AA6BB756F9ED34CE645E")
        public int previousIndex() {
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1491736672 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128803281 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128803281;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.140 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "A9D02D12878BF377CE4B3061F9926208")
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
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_308798891 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_308798891.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_308798891;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_492227465 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_492227465.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_492227465;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.140 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "DEDA5763CBB4CF8DC41CAEFA226D1F53")
        public void set(ET object) {
            if(expectedModCount == list.modCount)            
            {
                if(lastLink != null)                
                {
                    lastLink.data = object;
                } //End block
                else
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_6441799 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_6441799.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_6441799;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_961319590 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_961319590.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_961319590;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.140 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.140 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "D1EC04877DB93B65C0C16B144052AC71")

        private LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.140 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "C029ECB4203CCD8751E5C756F40C32AD")

        private Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.141 -0400", hash_original_field = "7385E778E1358730CFB4F236AF9FF24A", hash_generated_field = "C01834E3EF87C859E7B00C0837E2E4D3")

        private boolean canRemove;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.141 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "98C036A6F3260A1B3893C647A1DF0F6C")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.141 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "E33135C06A08BDA038C99253F55E8259")
        public boolean hasNext() {
            boolean var3FF1ABEDF980308C41F7F499B74280AE_864087004 = (link.previous != list.voidLink);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590837027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590837027;
            // ---------- Original Method ----------
            //return link.previous != list.voidLink;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.142 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "08385DB3F8840F442D16D61C6924E354")
        public ET next() {
            if(expectedModCount == list.modCount)            
            {
                if(hasNext())                
                {
                    link = link.previous;
                    canRemove = true;
ET var3CF301EF1455302B1A7564AEE107BC17_943474047 =                     link.data;
                    var3CF301EF1455302B1A7564AEE107BC17_943474047.addTaint(taint);
                    return var3CF301EF1455302B1A7564AEE107BC17_943474047;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_590268245 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_590268245.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_590268245;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1013148445 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1013148445.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1013148445;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.142 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "D9441B8B996130B7C38862C8270574C8")
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
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2082741836 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_2082741836.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_2082741836;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1085214783 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1085214783.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1085214783;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.142 -0400", hash_original_field = "A91BB42ABDC7657C70EC735A482E86B5", hash_generated_field = "5F23BECC14072AFC76D2F21910086550")

    private static final long serialVersionUID = 876323262645176354L;
}

