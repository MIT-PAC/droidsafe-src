package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.840 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.840 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    public  CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.840 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "EA0C15CE1422D9A7119B138FB9DFD0F8")
    @SuppressWarnings("unchecked")
    public  CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.841 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "5F0DE0F3745CDDE56CD0A00206594245")
    public  CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.841 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "8F7DB18A53051EEAB471F32BF38AFE9B")
    @Override
    public Object clone() {
        try 
        {
            CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1293855883 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1293855883.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1293855883;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1148118460 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1148118460.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1148118460;
        } //End block
        // ---------- Original Method ----------
        //try {
            //CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            //result.elements = result.elements.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.842 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "3609D83EF6401D571D7C1785ED626E34")
    public int size() {
        int varAE49AB49014B731648486670DE162663_1114807484 = (elements.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457298483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457298483;
        // ---------- Original Method ----------
        //return elements.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.843 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "FA9495A719D52B762D0E1191B244C2EF")
    @SuppressWarnings("unchecked")
    public E get(int index) {
        addTaint(index);
E var2A6ABA17AD43FE10CBD134001BC14638_561795045 =         (E) elements[index];
        var2A6ABA17AD43FE10CBD134001BC14638_561795045.addTaint(taint);
        return var2A6ABA17AD43FE10CBD134001BC14638_561795045;
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.844 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "A75ABB6CCA1BC7E8547E057954FEDE6B")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var9E9DDEFF9866AE959FD0A2B53DF201E0_116660796 = (indexOf(o) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057840515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057840515;
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.844 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "68CFED9AA2A88D61ADA73D9F231D8B98")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        Object[] snapshot = elements;
        boolean var9D412987724755E82DFDD399EA7E3A3A_1290437078 = (containsAll(collection, snapshot, 0, snapshot.length));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87565523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_87565523;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return containsAll(collection, snapshot, 0, snapshot.length);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.845 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "7FE47DDBF981EA9BC20177B6739C071C")
    public int indexOf(E object, int from) {
        addTaint(from);
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int varB7A00A018338BCC7D4E51BCB3CBE6033_2054181530 = (indexOf(object, snapshot, from, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617757804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617757804;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.845 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "4AFD2FC353CF9F2BCDA5EEC5E6E506D8")
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var3CBF07B54E6A1592BB3D02D6D28E9355_565947609 = (indexOf(object, snapshot, 0, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850216387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850216387;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.846 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "C2A533BFA118DE060038204FEA139294")
    public int lastIndexOf(E object, int to) {
        addTaint(to);
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var67C15C856C09C9A9358B7B2AF649D425_2026729333 = (lastIndexOf(object, snapshot, 0, to));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972338838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972338838;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.847 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "A68322C152E5143A2161FB1CA741F82A")
    public int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var3DE8457CEEFA0D8E494B41960D9124A0_485243499 = (lastIndexOf(object, snapshot, 0, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740760144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740760144;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.847 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "13715BA85C2C4A2414AF960B6B70BD74")
    public boolean isEmpty() {
        boolean var9F65D801E660F56EE6F47DFF6068BDAE_1310780612 = (elements.length == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973735276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973735276;
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.848 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "08B0D4C701F9B1E03AE40C6CF41B0CC9")
    public Iterator<E> iterator() {
        Object[] snapshot = elements;
Iterator<E> var81CF040A91E509D0554A7335D657FB7C_1330605337 =         new CowIterator<E>(snapshot, 0, snapshot.length);
        var81CF040A91E509D0554A7335D657FB7C_1330605337.addTaint(taint);
        return var81CF040A91E509D0554A7335D657FB7C_1330605337;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.848 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "688933DEFCC9CDA26B14A6B35D4FD5A5")
    public ListIterator<E> listIterator(int index) {
        addTaint(index);
        Object[] snapshot = elements;
        if(index < 0 || index > snapshot.length)        
        {
            IndexOutOfBoundsException var25B69E582540A8AF0F0764B2DCCC2F38_1879585436 = new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
            var25B69E582540A8AF0F0764B2DCCC2F38_1879585436.addTaint(taint);
            throw var25B69E582540A8AF0F0764B2DCCC2F38_1879585436;
        } //End block
        CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
ListIterator<E> varDC838461EE2FA0CA4C9BBB70A15456B0_558500071 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_558500071.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_558500071;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (index < 0 || index > snapshot.length) {
            //throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        //}
        //CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        //result.index = index;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.849 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "1B300447AA13FD427CB809C81F9562C7")
    public ListIterator<E> listIterator() {
        Object[] snapshot = elements;
ListIterator<E> var81CF040A91E509D0554A7335D657FB7C_158415343 =         new CowIterator<E>(snapshot, 0, snapshot.length);
        var81CF040A91E509D0554A7335D657FB7C_158415343.addTaint(taint);
        return var81CF040A91E509D0554A7335D657FB7C_158415343;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.849 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "6B4243079B3CD3051CA4B3B0CA858241")
    public List<E> subList(int from, int to) {
        addTaint(to);
        addTaint(from);
        Object[] snapshot = elements;
        if(from < 0 || from > to || to > snapshot.length)        
        {
            IndexOutOfBoundsException var812ECD7DEADC1977F9B113077E20F372_63517534 = new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
            var812ECD7DEADC1977F9B113077E20F372_63517534.addTaint(taint);
            throw var812ECD7DEADC1977F9B113077E20F372_63517534;
        } //End block
List<E> varBE3DE481AAAE587804C0D7FB37293CD4_1362557038 =         new CowSubList(snapshot, from, to);
        varBE3DE481AAAE587804C0D7FB37293CD4_1362557038.addTaint(taint);
        return varBE3DE481AAAE587804C0D7FB37293CD4_1362557038;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.849 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "09D5474BC89ABCADE8D4BF67206F57C3")
    public Object[] toArray() {
Object[] varE697C115FF5B77FC06FD6603F76A9CB8_626844098 =         elements.clone();
        varE697C115FF5B77FC06FD6603F76A9CB8_626844098.addTaint(taint);
        return varE697C115FF5B77FC06FD6603F76A9CB8_626844098;
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.850 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "2906A4D4D1D1A23323A06045B06FBF69")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        Object[] snapshot = elements;
        if(snapshot.length > contents.length)        
        {
T[] varAA242AD64FBF22E93B9DE930C2395AE0_337796799 =             (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
            varAA242AD64FBF22E93B9DE930C2395AE0_337796799.addTaint(taint);
            return varAA242AD64FBF22E93B9DE930C2395AE0_337796799;
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        if(snapshot.length < contents.length)        
        {
            contents[snapshot.length] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_39742848 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_39742848.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_39742848;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (snapshot.length > contents.length) {
            //return (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        //}
        //System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        //if (snapshot.length < contents.length) {
            //contents[snapshot.length] = null;
        //}
        //return contents;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.850 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "71ADEA2FC3D866CB21E6252690971009")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof CopyOnWriteArrayList)        
        {
            boolean var2875DFC1A1411E9B28FAA052637C6825_1231851550 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259226234 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259226234;
        } //End block
        else
        if(other instanceof List)        
        {
            Object[] snapshot = elements;
            Iterator<?> i = ((List<?>) other).iterator();
for(Object o : snapshot)
            {
                if(!i.hasNext() || !Objects.equal(o, i.next()))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_894132075 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700578151 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700578151;
                } //End block
            } //End block
            boolean var14D448EEE775306B2C46DAFF55575642_2063503148 = (!i.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2010142489 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2010142489;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1072058470 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668380915 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_668380915;
        } //End block
        // ---------- Original Method ----------
        //if (other instanceof CopyOnWriteArrayList) {
            //return this == other
                    //|| Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements);
        //} else if (other instanceof List) {
            //Object[] snapshot = elements;
            //Iterator<?> i = ((List<?>) other).iterator();
            //for (Object o : snapshot) {
                //if (!i.hasNext() || !Objects.equal(o, i.next())) {
                    //return false;
                //}
            //}
            //return !i.hasNext();
        //} else {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.851 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "AB88639153E60101266C9B410FE6BBC5")
    @Override
    public int hashCode() {
        int var9C53E0AE96A6FDAE21E83839DEA921C2_715090798 = (Arrays.hashCode(elements));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536705824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536705824;
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.851 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "8899B17A1B5B120FA3828BB1A0DB7EB8")
    @Override
    public String toString() {
String var3A98C504B2574DFE89DE6D5E8597BC7E_1354240504 =         Arrays.toString(elements);
        var3A98C504B2574DFE89DE6D5E8597BC7E_1354240504.addTaint(taint);
        return var3A98C504B2574DFE89DE6D5E8597BC7E_1354240504;
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.852 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "1484225948DAB6BAE7DB202BF2EB80F8")
    public synchronized boolean add(E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        boolean varB326B5062B2F0E69046810717534CB09_971219559 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963933532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963933532;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //newElements[elements.length] = e;
        //elements = newElements;
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.852 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "42E489CA4C68DE9BE7A25E1C63592408")
    public synchronized void add(int index, E e) {
        addTaint(e.getTaint());
        addTaint(index);
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        elements = newElements;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, index);
        //newElements[index] = e;
        //System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        //elements = newElements;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.853 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "EE6340C05F7F031FE57D3C2AAB8D9BCF")
    public synchronized boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean varF655D9D969A25B4637B33D24E2D52F1F_1792899196 = (addAll(elements.length, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284824440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284824440;
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.853 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "01F26047B5E38A11846C6D0A4BCB7293")
    public synchronized boolean addAll(int index, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(index);
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        System.arraycopy(elements, index,
                newElements, index + toAdd.length, elements.length - index);
        elements = newElements;
        boolean var7161E601A2396808253FEEB1F951010E_1640378582 = (toAdd.length > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109798780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109798780;
        // ---------- Original Method ----------
        //Object[] toAdd = collection.toArray();
        //Object[] newElements = new Object[elements.length + toAdd.length];
        //System.arraycopy(elements, 0, newElements, 0, index);
        //System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        //System.arraycopy(elements, index,
                //newElements, index + toAdd.length, elements.length - index);
        //elements = newElements;
        //return toAdd.length > 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.854 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "3BF6C92EE24EB73552EBF357CD688528")
    public synchronized int addAllAbsent(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        Object[] toAdd = collection.toArray();
        Object[] newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount = 0;
for(Object o : toAdd)
        {
            if(indexOf(o, newElements, 0, elements.length + addedCount) == -1)            
            {
                newElements[elements.length + addedCount++] = o;
            } //End block
        } //End block
        if(addedCount < toAdd.length)        
        {
            newElements = Arrays.copyOfRange(
                    newElements, 0, elements.length + addedCount);
        } //End block
        elements = newElements;
        int var1D9A618194A6A4CE04E0DF6178CE920E_1960158889 = (addedCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466819221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466819221;
        // ---------- Original Method ----------
        //Object[] toAdd = collection.toArray();
        //Object[] newElements = new Object[elements.length + toAdd.length];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //int addedCount = 0;
        //for (Object o : toAdd) {
            //if (indexOf(o, newElements, 0, elements.length + addedCount) == -1) {
                //newElements[elements.length + addedCount++] = o;
            //}
        //}
        //if (addedCount < toAdd.length) {
            //newElements = Arrays.copyOfRange(
                    //newElements, 0, elements.length + addedCount); 
        //}
        //elements = newElements;
        //return addedCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.855 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "3E21C46E36BA5798147A2D11A1FE4C93")
    public synchronized boolean addIfAbsent(E object) {
        addTaint(object.getTaint());
        if(contains(object))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1119439888 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21103843 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21103843;
        } //End block
        add(object);
        boolean varB326B5062B2F0E69046810717534CB09_936539376 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852922062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852922062;
        // ---------- Original Method ----------
        //if (contains(object)) {
            //return false;
        //}
        //add(object);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.855 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.855 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "260551B3ED768AD076DCEC3394197B72")
    public synchronized E remove(int index) {
        addTaint(index);
        @SuppressWarnings("unchecked") E removed = (E) elements[index];
        removeRange(index, index + 1);
E varC4DDDE029445DEB25112BA9AAF990086_1830571824 =         removed;
        varC4DDDE029445DEB25112BA9AAF990086_1830571824.addTaint(taint);
        return varC4DDDE029445DEB25112BA9AAF990086_1830571824;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked")
        //E removed = (E) elements[index];
        //removeRange(index, index + 1);
        //return removed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.856 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "D1340F570A3E9E15798DC933104F5B93")
    public synchronized boolean remove(Object o) {
        addTaint(o.getTaint());
        int index = indexOf(o);
        if(index == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1361878534 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091447334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091447334;
        } //End block
        remove(index);
        boolean varB326B5062B2F0E69046810717534CB09_863208616 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841192509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841192509;
        // ---------- Original Method ----------
        //int index = indexOf(o);
        //if (index == -1) {
            //return false;
        //}
        //remove(index);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.856 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "225B7515336A6A11B3EC00621507C67A")
    public synchronized boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var604D45ED73B68F4E75B327E8EC5D6D61_1150351237 = (removeOrRetain(collection, false, 0, elements.length) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211905851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211905851;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.856 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "1B3F77CED87153AD6B24845C706E4F21")
    public synchronized boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var10D8D61177A91438869ADD2607974C6E_422824265 = (removeOrRetain(collection, true, 0, elements.length) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445516827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445516827;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.857 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "539DA11D152D2B5A8E70753FF683356F")
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        addTaint(to);
        addTaint(from);
        addTaint(retain);
        addTaint(collection.getTaint());
for(int i = from;i < to;i++)
        {
            if(collection.contains(elements[i]) == retain)            
            {
                continue;
            } //End block
            Object[] newElements = new Object[elements.length - 1];
            System.arraycopy(elements, 0, newElements, 0, i);
            int newSize = i;
for(int j = i + 1;j < to;j++)
            {
                if(collection.contains(elements[j]) == retain)                
                {
                    newElements[newSize++] = elements[j];
                } //End block
            } //End block
            System.arraycopy(elements, to, newElements, newSize, elements.length - to);
            newSize += (elements.length - to);
            if(newSize < newElements.length)            
            {
                newElements = Arrays.copyOfRange(newElements, 0, newSize);
            } //End block
            int removed = elements.length - newElements.length;
            elements = newElements;
            int varB07286EBBB5BC7AA91CC3EAA8BC19711_2124848097 = (removed);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758570899 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758570899;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1550106699 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495380916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495380916;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.857 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "0E6FC4AB4595AA66710D186F9760169B")
    public synchronized E set(int index, E e) {
        addTaint(e.getTaint());
        addTaint(index);
        Object[] newElements = elements.clone();
        @SuppressWarnings("unchecked") E result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
E varDC838461EE2FA0CA4C9BBB70A15456B0_911881868 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_911881868.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_911881868;
        // ---------- Original Method ----------
        //Object[] newElements = elements.clone();
        //@SuppressWarnings("unchecked")
        //E result = (E) newElements[index];
        //newElements[index] = e;
        //elements = newElements;
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.858 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "3127D5EEF913DFBDCB5E1AAADE61DFEE")
    private void removeRange(int from, int to) {
        addTaint(to);
        addTaint(from);
        Object[] newElements = new Object[elements.length - (to - from)];
        System.arraycopy(elements, 0, newElements, 0, from);
        System.arraycopy(elements, to, newElements, from, elements.length - to);
        elements = newElements;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length - (to - from)];
        //System.arraycopy(elements, 0, newElements, 0, from);
        //System.arraycopy(elements, to, newElements, from, elements.length - to);
        //elements = newElements;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.859 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "3CB68E4B1960B137D4A7F31989185F5A")
    final Object[] getArray() {
Object[] varC7DFD266FBF449A638EA2377E8678BA1_651604710 =         elements;
        varC7DFD266FBF449A638EA2377E8678BA1_651604710.addTaint(taint);
        return varC7DFD266FBF449A638EA2377E8678BA1_651604710;
        // ---------- Original Method ----------
        //return elements;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.859 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "1BF6924BD29F36A9F5A749D0BE94EBD2")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        Object[] snapshot = elements;
        out.defaultWriteObject();
        out.writeInt(snapshot.length);
for(Object o : snapshot)
        {
            out.writeObject(o);
        } //End block
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //out.defaultWriteObject();
        //out.writeInt(snapshot.length);
        //for (Object o : snapshot) {
            //out.writeObject(o);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.860 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "D3977299908449FF088C13F12491A6B1")
    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        Object[] snapshot = new Object[in.readInt()];
for(int i = 0;i < snapshot.length;i++)
        {
            snapshot[i] = in.readObject();
        } //End block
        elements = snapshot;
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //Object[] snapshot = new Object[in.readInt()];
        //for (int i = 0; i < snapshot.length; i++) {
            //snapshot[i] = in.readObject();
        //}
        //elements = snapshot;
    }

    
    class CowSubList extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.860 -0400", hash_original_field = "6D52012DCA4FC77AA554F25430AEF501", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.861 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "5B199B3E4B2B392A5F281C0027899513")
        public  CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.861 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "F405847D23F3F7DE9D29B24ECA25C8A6")
        @Override
        public int size() {
            Slice slice = this.slice;
            int varCBF1451EEE5D06561D698F5233E34276_1321892496 = (slice.to - slice.from);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137373308 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137373308;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.to - slice.from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.861 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "13081F33DE2D9A816090E1709E7B8978")
        @Override
        public boolean isEmpty() {
            Slice slice = this.slice;
            boolean var259B0B64C722EA33F62907B92894126D_1890399766 = (slice.from == slice.to);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562381620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562381620;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.from == slice.to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.861 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "838C2FA024319D09EFA5C757B675C0C7")
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            addTaint(index);
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
E var40A28188D2E19E47CC35F4DCF74FECB2_508568494 =             (E) snapshot[index + slice.from];
            var40A28188D2E19E47CC35F4DCF74FECB2_508568494.addTaint(taint);
            return var40A28188D2E19E47CC35F4DCF74FECB2_508568494;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkElementIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //return (E) snapshot[index + slice.from];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.862 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "51F1004BE994A11D18AFD915852FD70D")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_1461360039 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_1461360039.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_1461360039;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.862 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "553FAEE7CB3885FB9E75D0FA72CD6E8E")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_530568518 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_530568518.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_530568518;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.862 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "588C8E1C5F8A214CE4FEBFC35F0ACA50")
        @Override
        public ListIterator<E> listIterator(int index) {
            addTaint(index);
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
ListIterator<E> varDC838461EE2FA0CA4C9BBB70A15456B0_1457544872 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1457544872.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1457544872;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkPositionIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            //result.index = slice.from + index;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.862 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "B6232822163F5E691EB83FC6BFA4EEF4")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            int varF67EC9B38489A8516C83CEC4C4EFD979_270100701 = ((result != -1) ? (result - slice.from) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727059715 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727059715;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "2B37922E253383F0CCF5290EE9E86A8A")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            int varF67EC9B38489A8516C83CEC4C4EFD979_172380950 = ((result != -1) ? (result - slice.from) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273524826 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273524826;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "DB78A5DBA96DDD9629D84850BAC1D4E0")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var81AF353AE5075728FC255155CF6F4BD5_332336803 = (indexOf(object) != -1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891788597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_891788597;
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "EEB96484935BEA1148CBC6AFA1405E44")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var109FB52A6DC6FFE4632FCD23336EF4AA_1688786818 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695386804 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695386804;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "96F55D7FEF56B2236AA72D1CCBC539C9")
        @Override
        public List<E> subList(int from, int to) {
            addTaint(to);
            addTaint(from);
            Slice slice = this.slice;
            if(from < 0 || from > to || to > size())            
            {
                IndexOutOfBoundsException varEB6DABBE3F8E9660DAF79FB099ACF2A6_1672125699 = new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                varEB6DABBE3F8E9660DAF79FB099ACF2A6_1672125699.addTaint(taint);
                throw varEB6DABBE3F8E9660DAF79FB099ACF2A6_1672125699;
            } //End block
List<E> var286563A107CA67FF157789C051305F4F_2039538372 =             new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
            var286563A107CA67FF157789C051305F4F_2039538372.addTaint(taint);
            return var286563A107CA67FF157789C051305F4F_2039538372;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "5455BA35D9E9410438FC248560D31E11")
        @Override
        public E remove(int index) {
            addTaint(index);
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                slice = new Slice(elements, slice.from, slice.to - 1);
E varC4DDDE029445DEB25112BA9AAF990086_812946215 =                 removed;
                varC4DDDE029445DEB25112BA9AAF990086_812946215.addTaint(taint);
                return varC4DDDE029445DEB25112BA9AAF990086_812946215;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                //slice = new Slice(elements, slice.from, slice.to - 1);
                //return removed;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.863 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "B241ACA32EBABC70915A1FC31D50CB77")
        @Override
        public void clear() {
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.from);
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.from);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.864 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "F48A8F8309B6627CDB2C965E49BB9668")
        @Override
        public void add(int index, E object) {
            addTaint(object.getTaint());
            addTaint(index);
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.add(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to + 1);
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.add(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to + 1);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.864 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "7FC15227DBF96792799A470287E52135")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                add(slice.to - slice.from, object);
                boolean varB326B5062B2F0E69046810717534CB09_1274590698 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277912698 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277912698;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.864 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "313ECF67A8E6C3B5A2D3CA5290C2ABA7")
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            addTaint(index);
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                int oldSize = elements.length;
                boolean result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                boolean varB4A88417B3D0170D754C647C30B7216A_280511719 = (result);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115321367 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115321367;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //int oldSize = elements.length;
                //boolean result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                //slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.864 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "C545AB9E109B4D2E0756BD11284CBD11")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                boolean var4FB93A56A9FC44DB5D2E343F5484EB74_1176913489 = (addAll(size(), collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879192436 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879192436;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.865 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "DFDB6C75ED214C112EEAEA6A12794D9E")
        @Override
        public E set(int index, E object) {
            addTaint(object.getTaint());
            addTaint(index);
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to);
E varDC838461EE2FA0CA4C9BBB70A15456B0_1731097344 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1731097344.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1731097344;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to);
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.865 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "B8B97A468722AE8AAC88F6E404553F65")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                int index = indexOf(object);
                if(index == -1)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_78762204 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56825786 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_56825786;
                } //End block
                remove(index);
                boolean varB326B5062B2F0E69046810717534CB09_1553101863 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712903626 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712903626;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //int index = indexOf(object);
                //if (index == -1) {
                    //return false;
                //}
                //remove(index);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.865 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "72BD16416C6AF3A79795EBAACC8113FC")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, false, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                boolean var4095B3DC23D4A1D71AE5CEF59B4D1878_692640930 = (removed != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880369047 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_880369047;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.866 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "7E5F25C1BED16AF00598330460BBFE20")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, true, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                boolean var4095B3DC23D4A1D71AE5CEF59B4D1878_640893254 = (removed != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765805877 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765805877;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, true, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
    }


    
    static class Slice {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.866 -0400", hash_original_field = "5DBBBEFC516616C59322E114837C83FB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private Object[] expectedElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "6056AD1FF5F186156B93AC86A3F90BBC")
          Slice(Object[] expectedElements, int from, int to) {
            this.expectedElements = expectedElements;
            this.from = from;
            this.to = to;
            // ---------- Original Method ----------
            //this.expectedElements = expectedElements;
            //this.from = from;
            //this.to = to;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "2042F088261B193B6193BF2E1258C02B")
         void checkElementIndex(int index) {
            addTaint(index);
            if(index < 0 || index >= to - from)            
            {
                IndexOutOfBoundsException var1BEE62377EDA5CB718B2828E0388A841_809535015 = new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
                var1BEE62377EDA5CB718B2828E0388A841_809535015.addTaint(taint);
                throw var1BEE62377EDA5CB718B2828E0388A841_809535015;
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index >= to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "145E3A819D3C62585EE7F8628DD1CCAA")
         void checkPositionIndex(int index) {
            addTaint(index);
            if(index < 0 || index > to - from)            
            {
                IndexOutOfBoundsException var1BEE62377EDA5CB718B2828E0388A841_1042790231 = new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
                var1BEE62377EDA5CB718B2828E0388A841_1042790231.addTaint(taint);
                throw var1BEE62377EDA5CB718B2828E0388A841_1042790231;
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index > to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.867 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "C8CF11DC5F899F891BD23D24A2538530")
         void checkConcurrentModification(Object[] snapshot) {
            addTaint(snapshot[0].getTaint());
            if(expectedElements != snapshot)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1931574507 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1931574507.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1931574507;
            } //End block
            // ---------- Original Method ----------
            //if (expectedElements != snapshot) {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_field = "C322D3DE29D2B0C5E2E011DAD5E77DF2", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private Object[] snapshot;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_field = "CB241078244A9AA790B0FC45841BA024", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "761C1CBB0EA0B2EE4578133FB46FB797")
          CowIterator(Object[] snapshot, int from, int to) {
            this.snapshot = snapshot;
            this.from = from;
            this.to = to;
            this.index = from;
            // ---------- Original Method ----------
            //this.snapshot = snapshot;
            //this.from = from;
            //this.to = to;
            //this.index = from;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.868 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "0369169086D736F81AA6FC01AF8122F1")
        public void add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1403715330 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1403715330.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1403715330;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "B5CD1B64FD8CEEB0F048FDA8725F5362")
        public boolean hasNext() {
            boolean var2EF6B62A76FA757E17C835E0C6F11672_607983693 = (index < to);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259147270 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_259147270;
            // ---------- Original Method ----------
            //return index < to;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "E9D260F960A829BCA591771AC0EE0CA4")
        public boolean hasPrevious() {
            boolean var2880A9037E6C3E2785453FB1178B5F1D_1711922012 = (index > from);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091627078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091627078;
            // ---------- Original Method ----------
            //return index > from;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "8AA7E2DD7A0198BCCDB43EC185DDDCC2")
        @SuppressWarnings("unchecked")
        public E next() {
            if(index < to)            
            {
E var63B8DFAA98A88E2191B566527D626B20_1746474924 =                 (E) snapshot[index++];
                var63B8DFAA98A88E2191B566527D626B20_1746474924.addTaint(taint);
                return var63B8DFAA98A88E2191B566527D626B20_1746474924;
            } //End block
            else
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1333773637 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1333773637.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1333773637;
            } //End block
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "E3E08C700302C553375DA0C6915F3CE6")
        public int nextIndex() {
            int var6A992D5529F459A44FEE58C733255E86_66412742 = (index);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482413286 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482413286;
            // ---------- Original Method ----------
            //return index;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "B8C932EB5CFB58E0EC1AE25C78DBCD7A")
        @SuppressWarnings("unchecked")
        public E previous() {
            if(index > from)            
            {
E var38F79E4AE1344E378A39E154F031E53F_316117513 =                 (E) snapshot[--index];
                var38F79E4AE1344E378A39E154F031E53F_316117513.addTaint(taint);
                return var38F79E4AE1344E378A39E154F031E53F_316117513;
            } //End block
            else
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_360638880 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_360638880.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_360638880;
            } //End block
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "D78636965C618E6D46976023667EF464")
        public int previousIndex() {
            int var5B425087CC12462F0B4B4AB7BD6777B5_41111611 = (index - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697936956 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697936956;
            // ---------- Original Method ----------
            //return index - 1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "0C975693A66AAF5FF01D9F7C6DFA8E25")
        public void remove() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1133144470 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1133144470.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1133144470;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.869 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "8606579DEE110EF68C189F0A19F11678")
        public void set(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1268947521 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1268947521.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1268947521;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.870 -0400", hash_original_field = "CB0A5E07D474346F2427954305CE9572", hash_generated_field = "392EFB541281482E947C8FEFEB5A2F62")

    private static final long serialVersionUID = 8673264195747942595L;
}

