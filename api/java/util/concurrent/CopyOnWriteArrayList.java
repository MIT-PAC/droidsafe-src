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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.747 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.748 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    public  CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.748 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "EA0C15CE1422D9A7119B138FB9DFD0F8")
    @SuppressWarnings("unchecked")
    public  CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.748 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "5F0DE0F3745CDDE56CD0A00206594245")
    public  CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.749 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "E7A3661A418DEAAE1787B639284CDBDF")
    @Override
    public Object clone() {
        try 
        {
            CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
Object varDC838461EE2FA0CA4C9BBB70A15456B0_600136168 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_600136168.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_600136168;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_2056351122 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_2056351122.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_2056351122;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.749 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "4537BF7FC78BD7AE125AEE59230F1917")
    public int size() {
        int varAE49AB49014B731648486670DE162663_990068678 = (elements.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859175336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859175336;
        // ---------- Original Method ----------
        //return elements.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.749 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "4C369043DD7953B6662D9FF45485E31C")
    @SuppressWarnings("unchecked")
    public E get(int index) {
        addTaint(index);
E var2A6ABA17AD43FE10CBD134001BC14638_393597513 =         (E) elements[index];
        var2A6ABA17AD43FE10CBD134001BC14638_393597513.addTaint(taint);
        return var2A6ABA17AD43FE10CBD134001BC14638_393597513;
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.750 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "A05F0D250A471880705C8A20BE6D6988")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var9E9DDEFF9866AE959FD0A2B53DF201E0_1944236453 = (indexOf(o) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490841752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490841752;
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.750 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "2F26F40C47617E3376D60E26D6825BB4")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        Object[] snapshot = elements;
        boolean var9D412987724755E82DFDD399EA7E3A3A_685263635 = (containsAll(collection, snapshot, 0, snapshot.length));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926529031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926529031;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return containsAll(collection, snapshot, 0, snapshot.length);
    }

    
        static boolean containsAll(Collection<?> collection, Object[] snapshot, int from, int to) {
        for (Object o : collection) {
            if (indexOf(o, snapshot, from, to) == -1) {
                return false;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.750 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "3A90E56D644B166A7723B1A502C5F701")
    public int indexOf(E object, int from) {
        addTaint(from);
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int varB7A00A018338BCC7D4E51BCB3CBE6033_225937781 = (indexOf(object, snapshot, from, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801148821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801148821;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.751 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "16655A43948A88827B05DC06422119C8")
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var3CBF07B54E6A1592BB3D02D6D28E9355_1230276923 = (indexOf(object, snapshot, 0, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444308798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444308798;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.751 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "E3D3C0134D543A9BA5C8762CF3858484")
    public int lastIndexOf(E object, int to) {
        addTaint(to);
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var67C15C856C09C9A9358B7B2AF649D425_205505833 = (lastIndexOf(object, snapshot, 0, to));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231299518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231299518;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.752 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "9A85F0E704FD15BFCEE12CDE10B4C188")
    public int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        Object[] snapshot = elements;
        int var3DE8457CEEFA0D8E494B41960D9124A0_172230080 = (lastIndexOf(object, snapshot, 0, snapshot.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120320619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120320619;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.752 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "9BEDCDC571305680E70BFF78A2BBC01F")
    public boolean isEmpty() {
        boolean var9F65D801E660F56EE6F47DFF6068BDAE_1954800729 = (elements.length == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007824843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007824843;
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.752 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "CF8AFD69EF608989DA0B89FB2DB9DD7F")
    public Iterator<E> iterator() {
        Object[] snapshot = elements;
Iterator<E> var81CF040A91E509D0554A7335D657FB7C_475645191 =         new CowIterator<E>(snapshot, 0, snapshot.length);
        var81CF040A91E509D0554A7335D657FB7C_475645191.addTaint(taint);
        return var81CF040A91E509D0554A7335D657FB7C_475645191;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.753 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "4AADDDA2E008D353776ADE27679D5E91")
    public ListIterator<E> listIterator(int index) {
        addTaint(index);
        Object[] snapshot = elements;
    if(index < 0 || index > snapshot.length)        
        {
            IndexOutOfBoundsException var25B69E582540A8AF0F0764B2DCCC2F38_1445129769 = new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
            var25B69E582540A8AF0F0764B2DCCC2F38_1445129769.addTaint(taint);
            throw var25B69E582540A8AF0F0764B2DCCC2F38_1445129769;
        } //End block
        CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
ListIterator<E> varDC838461EE2FA0CA4C9BBB70A15456B0_1771465818 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1771465818.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1771465818;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (index < 0 || index > snapshot.length) {
            //throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        //}
        //CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        //result.index = index;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.753 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "41293977D6C1FE3DE90085DCFA06E8C3")
    public ListIterator<E> listIterator() {
        Object[] snapshot = elements;
ListIterator<E> var81CF040A91E509D0554A7335D657FB7C_1315876428 =         new CowIterator<E>(snapshot, 0, snapshot.length);
        var81CF040A91E509D0554A7335D657FB7C_1315876428.addTaint(taint);
        return var81CF040A91E509D0554A7335D657FB7C_1315876428;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.754 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "5B79335AAB3AC5D91A971212C80853DF")
    public List<E> subList(int from, int to) {
        addTaint(to);
        addTaint(from);
        Object[] snapshot = elements;
    if(from < 0 || from > to || to > snapshot.length)        
        {
            IndexOutOfBoundsException var812ECD7DEADC1977F9B113077E20F372_1120437616 = new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
            var812ECD7DEADC1977F9B113077E20F372_1120437616.addTaint(taint);
            throw var812ECD7DEADC1977F9B113077E20F372_1120437616;
        } //End block
List<E> varBE3DE481AAAE587804C0D7FB37293CD4_1061920400 =         new CowSubList(snapshot, from, to);
        varBE3DE481AAAE587804C0D7FB37293CD4_1061920400.addTaint(taint);
        return varBE3DE481AAAE587804C0D7FB37293CD4_1061920400;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.754 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "FE3D43AD1F78B8611F18D599AE118066")
    public Object[] toArray() {
Object[] varE697C115FF5B77FC06FD6603F76A9CB8_2050309368 =         elements.clone();
        varE697C115FF5B77FC06FD6603F76A9CB8_2050309368.addTaint(taint);
        return varE697C115FF5B77FC06FD6603F76A9CB8_2050309368;
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.754 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "1F5971B22BDE39086A69A0718E7D14EA")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        Object[] snapshot = elements;
    if(snapshot.length > contents.length)        
        {
T[] varAA242AD64FBF22E93B9DE930C2395AE0_1880090400 =             (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
            varAA242AD64FBF22E93B9DE930C2395AE0_1880090400.addTaint(taint);
            return varAA242AD64FBF22E93B9DE930C2395AE0_1880090400;
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
    if(snapshot.length < contents.length)        
        {
            contents[snapshot.length] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_220677532 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_220677532.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_220677532;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.755 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "434DA2ACEB6BD320761CFEF0C988CECD")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof CopyOnWriteArrayList)        
        {
            boolean var2875DFC1A1411E9B28FAA052637C6825_800568108 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207551586 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_207551586;
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
                    boolean var68934A3E9455FA72420237EB05902327_867751741 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302299591 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_302299591;
                } //End block
            } //End block
            boolean var14D448EEE775306B2C46DAFF55575642_456471491 = (!i.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283535259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283535259;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2093738020 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213188644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_213188644;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.755 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "3C1175CDCFC4CA7DA44D2ECFE9811FD8")
    @Override
    public int hashCode() {
        int var9C53E0AE96A6FDAE21E83839DEA921C2_335428243 = (Arrays.hashCode(elements));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885011747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885011747;
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.755 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "B1138B41262DE030E80C4128AF651A5F")
    @Override
    public String toString() {
String var3A98C504B2574DFE89DE6D5E8597BC7E_452593898 =         Arrays.toString(elements);
        var3A98C504B2574DFE89DE6D5E8597BC7E_452593898.addTaint(taint);
        return var3A98C504B2574DFE89DE6D5E8597BC7E_452593898;
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.756 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "E21B0309FF495D775A3F44D01F0ABB27")
    public synchronized boolean add(E e) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        boolean varB326B5062B2F0E69046810717534CB09_1192168604 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467637044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467637044;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //newElements[elements.length] = e;
        //elements = newElements;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.756 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "42E489CA4C68DE9BE7A25E1C63592408")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.757 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "DF61BF93869F55210AB7B44D5433ABC3")
    public synchronized boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean varF655D9D969A25B4637B33D24E2D52F1F_2139297945 = (addAll(elements.length, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443487931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443487931;
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.757 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "15D511E76E1900F2F108D904E5AF48E5")
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
        boolean var7161E601A2396808253FEEB1F951010E_2005858944 = (toAdd.length > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25517284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25517284;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.758 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "BEEEF0404E61427B8FCACBB97624774D")
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
        int var1D9A618194A6A4CE04E0DF6178CE920E_1205422171 = (addedCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550472037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550472037;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.758 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "A9AFE04D87071ACBA502AF81AFA6A84A")
    public synchronized boolean addIfAbsent(E object) {
        addTaint(object.getTaint());
    if(contains(object))        
        {
            boolean var68934A3E9455FA72420237EB05902327_669776120 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675271500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675271500;
        } //End block
        add(object);
        boolean varB326B5062B2F0E69046810717534CB09_1713885959 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704711118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704711118;
        // ---------- Original Method ----------
        //if (contains(object)) {
            //return false;
        //}
        //add(object);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.759 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.759 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "25B60B4C324F21AA5E8D1DE94E432141")
    public synchronized E remove(int index) {
        addTaint(index);
        @SuppressWarnings("unchecked") E removed = (E) elements[index];
        removeRange(index, index + 1);
E varC4DDDE029445DEB25112BA9AAF990086_917687187 =         removed;
        varC4DDDE029445DEB25112BA9AAF990086_917687187.addTaint(taint);
        return varC4DDDE029445DEB25112BA9AAF990086_917687187;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked")
        //E removed = (E) elements[index];
        //removeRange(index, index + 1);
        //return removed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.759 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "BB18260AEA44B34E03DDD10C3E59FB97")
    public synchronized boolean remove(Object o) {
        addTaint(o.getTaint());
        int index = indexOf(o);
    if(index == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_944364268 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369814241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369814241;
        } //End block
        remove(index);
        boolean varB326B5062B2F0E69046810717534CB09_1677168393 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114988712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114988712;
        // ---------- Original Method ----------
        //int index = indexOf(o);
        //if (index == -1) {
            //return false;
        //}
        //remove(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.759 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "8D85FE6D593C7D3B8266B597FF29C7C7")
    public synchronized boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var604D45ED73B68F4E75B327E8EC5D6D61_1141637383 = (removeOrRetain(collection, false, 0, elements.length) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224308424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224308424;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.760 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "861BF8D8737011414906E4686B92C0CC")
    public synchronized boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var10D8D61177A91438869ADD2607974C6E_2097492316 = (removeOrRetain(collection, true, 0, elements.length) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642544908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642544908;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.761 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "059DA9178CCC24A274191704FB0B76B6")
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
            int varB07286EBBB5BC7AA91CC3EAA8BC19711_1972707717 = (removed);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33888152 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33888152;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2081495804 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408171090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408171090;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.761 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "9F44057C981AE12C8CC4D0E88C197523")
    public synchronized E set(int index, E e) {
        addTaint(e.getTaint());
        addTaint(index);
        Object[] newElements = elements.clone();
        @SuppressWarnings("unchecked") E result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
E varDC838461EE2FA0CA4C9BBB70A15456B0_220112057 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_220112057.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_220112057;
        // ---------- Original Method ----------
        //Object[] newElements = elements.clone();
        //@SuppressWarnings("unchecked")
        //E result = (E) newElements[index];
        //newElements[index] = e;
        //elements = newElements;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.762 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "3127D5EEF913DFBDCB5E1AAADE61DFEE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.763 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "E41A9026DFCCFDDE4E99DD3E624C5EC1")
    final Object[] getArray() {
Object[] varC7DFD266FBF449A638EA2377E8678BA1_213696440 =         elements;
        varC7DFD266FBF449A638EA2377E8678BA1_213696440.addTaint(taint);
        return varC7DFD266FBF449A638EA2377E8678BA1_213696440;
        // ---------- Original Method ----------
        //return elements;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.763 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "1BF6924BD29F36A9F5A749D0BE94EBD2")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.764 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "D3977299908449FF088C13F12491A6B1")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.764 -0400", hash_original_field = "6D52012DCA4FC77AA554F25430AEF501", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.764 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "5B199B3E4B2B392A5F281C0027899513")
        public  CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.765 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "E929A00B6B6A5F14226A659C4EE48E0B")
        @Override
        public int size() {
            Slice slice = this.slice;
            int varCBF1451EEE5D06561D698F5233E34276_1814698889 = (slice.to - slice.from);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025311015 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025311015;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.to - slice.from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.765 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "C296A85E331A5496689CE5ACC0AF748B")
        @Override
        public boolean isEmpty() {
            Slice slice = this.slice;
            boolean var259B0B64C722EA33F62907B92894126D_741670322 = (slice.from == slice.to);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1066745507 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1066745507;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.from == slice.to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.765 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "0AB520EFABA70CADECACDCC4A4E693D6")
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            addTaint(index);
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
E var40A28188D2E19E47CC35F4DCF74FECB2_903487371 =             (E) snapshot[index + slice.from];
            var40A28188D2E19E47CC35F4DCF74FECB2_903487371.addTaint(taint);
            return var40A28188D2E19E47CC35F4DCF74FECB2_903487371;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkElementIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //return (E) snapshot[index + slice.from];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.765 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "F6815EB5E27457680E589E470150C4C4")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_1940075304 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_1940075304.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_1940075304;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.766 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "28A5D13DAD7CABD9B519053FC3C204C4")
        @Override
        public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_366732122 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_366732122.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_366732122;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.766 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "F34687F45C26877758D7E43C19F4FC82")
        @Override
        public ListIterator<E> listIterator(int index) {
            addTaint(index);
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
ListIterator<E> varDC838461EE2FA0CA4C9BBB70A15456B0_1535132576 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1535132576.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1535132576;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkPositionIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            //result.index = slice.from + index;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.766 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "74F469CF26F6C8752E08AF9AC50FF70C")
        @Override
        public int indexOf(Object object) {
            addTaint(object.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            int varF67EC9B38489A8516C83CEC4C4EFD979_999622812 = ((result != -1) ? (result - slice.from) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23622329 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23622329;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.767 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "800E9EAC91A5B59B0BA27A6F10263536")
        @Override
        public int lastIndexOf(Object object) {
            addTaint(object.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            int varF67EC9B38489A8516C83CEC4C4EFD979_1062858397 = ((result != -1) ? (result - slice.from) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814207264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814207264;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.767 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "12E9190DF06CD808F44338D1ACB5517E")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean var81AF353AE5075728FC255155CF6F4BD5_891938473 = (indexOf(object) != -1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180575993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180575993;
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.767 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "E707DA4E21F5D6634ECE5A5492AA03DE")
        @Override
        public boolean containsAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            Slice slice = this.slice;
            Object[] snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var109FB52A6DC6FFE4632FCD23336EF4AA_688013583 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288468873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288468873;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.768 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "C986C36E0C24BA0EF2C94D4136FEBA80")
        @Override
        public List<E> subList(int from, int to) {
            addTaint(to);
            addTaint(from);
            Slice slice = this.slice;
    if(from < 0 || from > to || to > size())            
            {
                IndexOutOfBoundsException varEB6DABBE3F8E9660DAF79FB099ACF2A6_687434283 = new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                varEB6DABBE3F8E9660DAF79FB099ACF2A6_687434283.addTaint(taint);
                throw varEB6DABBE3F8E9660DAF79FB099ACF2A6_687434283;
            } //End block
List<E> var286563A107CA67FF157789C051305F4F_1073558117 =             new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
            var286563A107CA67FF157789C051305F4F_1073558117.addTaint(taint);
            return var286563A107CA67FF157789C051305F4F_1073558117;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.768 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "0CD3E308E9F8FC98A5236C098DB1396C")
        @Override
        public E remove(int index) {
            addTaint(index);
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                slice = new Slice(elements, slice.from, slice.to - 1);
E varC4DDDE029445DEB25112BA9AAF990086_1938115452 =                 removed;
                varC4DDDE029445DEB25112BA9AAF990086_1938115452.addTaint(taint);
                return varC4DDDE029445DEB25112BA9AAF990086_1938115452;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.768 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "B241ACA32EBABC70915A1FC31D50CB77")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.769 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "F48A8F8309B6627CDB2C965E49BB9668")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.769 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "FC0849733244FC3821EC8FF37050CA0C")
        @Override
        public boolean add(E object) {
            addTaint(object.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                add(slice.to - slice.from, object);
                boolean varB326B5062B2F0E69046810717534CB09_1568839035 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546737131 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_546737131;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.770 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "906E61A67D93276B47B99B41B54FFE4A")
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
                boolean varB4A88417B3D0170D754C647C30B7216A_1073404850 = (result);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870960957 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870960957;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.770 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "0E556917B54D5E835CD3A80B8E722331")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                boolean var4FB93A56A9FC44DB5D2E343F5484EB74_1215537330 = (addAll(size(), collection));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602100875 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_602100875;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.770 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "00A118D6DD7EA44E958DDD64E25076A5")
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
E varDC838461EE2FA0CA4C9BBB70A15456B0_239440636 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_239440636.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_239440636;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.771 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "4CFC8C1853118088E9471084393D2472")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                int index = indexOf(object);
    if(index == -1)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_113752483 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543157846 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_543157846;
                } //End block
                remove(index);
                boolean varB326B5062B2F0E69046810717534CB09_1209519267 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610922848 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_610922848;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.771 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "1515094D6C8E39D9DD9DE6FEA20C5919")
        @Override
        public boolean removeAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, false, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                boolean var4095B3DC23D4A1D71AE5CEF59B4D1878_723888701 = (removed != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229781361 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_229781361;
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.772 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "DC725B5090A5A13E83FE9E66E4952E3E")
        @Override
        public boolean retainAll(Collection<?> collection) {
            addTaint(collection.getTaint());
            synchronized
(CopyOnWriteArrayList.this)            {
                slice.checkConcurrentModification(elements);
                int removed = removeOrRetain(collection, true, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
                boolean var4095B3DC23D4A1D71AE5CEF59B4D1878_2114996496 = (removed != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749449990 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749449990;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.772 -0400", hash_original_field = "5DBBBEFC516616C59322E114837C83FB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private Object[] expectedElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.772 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.772 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.773 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "6056AD1FF5F186156B93AC86A3F90BBC")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.773 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "4FBE219AF578C750FB0355FBCAB5387F")
         void checkElementIndex(int index) {
            addTaint(index);
    if(index < 0 || index >= to - from)            
            {
                IndexOutOfBoundsException var1BEE62377EDA5CB718B2828E0388A841_1573875039 = new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
                var1BEE62377EDA5CB718B2828E0388A841_1573875039.addTaint(taint);
                throw var1BEE62377EDA5CB718B2828E0388A841_1573875039;
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index >= to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "8987D843801B3BED30850F85A25D7D6D")
         void checkPositionIndex(int index) {
            addTaint(index);
    if(index < 0 || index > to - from)            
            {
                IndexOutOfBoundsException var1BEE62377EDA5CB718B2828E0388A841_2145093170 = new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
                var1BEE62377EDA5CB718B2828E0388A841_2145093170.addTaint(taint);
                throw var1BEE62377EDA5CB718B2828E0388A841_2145093170;
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index > to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "2262F87C52D8E33D462F8ADCC6C1ED77")
         void checkConcurrentModification(Object[] snapshot) {
            addTaint(snapshot[0].getTaint());
    if(expectedElements != snapshot)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_559122372 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_559122372.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_559122372;
            } //End block
            // ---------- Original Method ----------
            //if (expectedElements != snapshot) {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_field = "C322D3DE29D2B0C5E2E011DAD5E77DF2", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private Object[] snapshot;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.774 -0400", hash_original_field = "CB241078244A9AA790B0FC45841BA024", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.775 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "761C1CBB0EA0B2EE4578133FB46FB797")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.775 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "7FB9DA2E5C83B42B500E29198D78495F")
        public void add(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_343382577 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_343382577.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_343382577;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.776 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "959172862DEB9816443AD55F9FB9E67A")
        public boolean hasNext() {
            boolean var2EF6B62A76FA757E17C835E0C6F11672_1476724629 = (index < to);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812565894 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812565894;
            // ---------- Original Method ----------
            //return index < to;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.776 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "1E36DBF5A8A219A2905AB30EF4EB1832")
        public boolean hasPrevious() {
            boolean var2880A9037E6C3E2785453FB1178B5F1D_943665263 = (index > from);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417158648 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417158648;
            // ---------- Original Method ----------
            //return index > from;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.776 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "3EB67470BF763CB0F1B8754682885345")
        @SuppressWarnings("unchecked")
        public E next() {
    if(index < to)            
            {
E var63B8DFAA98A88E2191B566527D626B20_1188188283 =                 (E) snapshot[index++];
                var63B8DFAA98A88E2191B566527D626B20_1188188283.addTaint(taint);
                return var63B8DFAA98A88E2191B566527D626B20_1188188283;
            } //End block
            else
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1883606815 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1883606815.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1883606815;
            } //End block
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.776 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "2CC32FF2867B0487628B727AB5CFFE0B")
        public int nextIndex() {
            int var6A992D5529F459A44FEE58C733255E86_1066924286 = (index);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815421526 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815421526;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.777 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "CB4913A41994BE4908EF776664E57959")
        @SuppressWarnings("unchecked")
        public E previous() {
    if(index > from)            
            {
E var38F79E4AE1344E378A39E154F031E53F_173410984 =                 (E) snapshot[--index];
                var38F79E4AE1344E378A39E154F031E53F_173410984.addTaint(taint);
                return var38F79E4AE1344E378A39E154F031E53F_173410984;
            } //End block
            else
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1663758800 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1663758800.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1663758800;
            } //End block
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.777 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "4F09092AD2D887943D3507C663692ACB")
        public int previousIndex() {
            int var5B425087CC12462F0B4B4AB7BD6777B5_28672216 = (index - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218662279 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218662279;
            // ---------- Original Method ----------
            //return index - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.777 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "C3CF030512E666AE3E5BAB6602EECBB1")
        public void remove() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_717754403 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_717754403.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_717754403;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.777 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "2F12B9AC6BDB87A7A659F57D913E27E0")
        public void set(E object) {
            addTaint(object.getTaint());
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1982772755 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1982772755.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1982772755;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.778 -0400", hash_original_field = "CB0A5E07D474346F2427954305CE9572", hash_generated_field = "392EFB541281482E947C8FEFEB5A2F62")

    private static final long serialVersionUID = 8673264195747942595L;
}

