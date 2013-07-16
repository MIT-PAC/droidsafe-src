package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.115 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "D904B48F1A1A3F19ECDEE2D75BF7C70B")

    protected transient int modCount;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.115 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "C2512795C4B4D09B5344EF8EABF2A19D")
    protected  AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.116 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "538B91CA8BBC8C0B5686ADCCA4D22410")
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1512330546 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1512330546.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1512330546;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.116 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "EB7F6791804AAE31DE7F15C301EC5CC1")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        add(size(), object);
        boolean varB326B5062B2F0E69046810717534CB09_483737424 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936248711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936248711;
        // ---------- Original Method ----------
        //add(size(), object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.116 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "ABAA72899EE6A060E01BE4BB47EC3B0B")
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(location);
        Iterator<? extends E> it = collection.iterator();
        while
(it.hasNext())        
        {
            add(location++, it.next());
        } //End block
        boolean varE79DF77F19DD1F1F6B53F87ADB408DD7_27403561 = (!collection.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295832630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295832630;
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.117 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.117 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "0E8895AB82B41B2948F782CA6FCB7C24")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_65289531 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091202057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091202057;
        } //End block
    if(object instanceof List)        
        {
            List<?> list = (List<?>) object;
    if(list.size() != size())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1771328480 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475603966 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475603966;
            } //End block
            Iterator<?> it1 = iterator();
            Iterator<?> it2 = list.iterator();
            while
(it1.hasNext())            
            {
                Object e1 = it1.next();
                Object e2 = it2.next();
    if(!(e1 == null ? e2 == null : e1.equals(e2)))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1212388183 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1612497649 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1612497649;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1827450424 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987114677 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_987114677;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_70834694 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536131054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536131054;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof List) {
            //List<?> list = (List<?>) object;
            //if (list.size() != size()) {
                //return false;
            //}
            //Iterator<?> it1 = iterator(), it2 = list.iterator();
            //while (it1.hasNext()) {
                //Object e1 = it1.next(), e2 = it2.next();
                //if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                    //return false;
                //}
            //}
            //return true;
        //}
        //return false;
    }

    
    public abstract E get(int location);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.118 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "67287E27C3F5F4E402B45DE40BF38B62")
    @Override
    public int hashCode() {
        int result = 1;
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
            Object object = it.next();
            result = (31 * result) + (object == null ? 0 : object.hashCode());
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_753152343 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124706850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124706850;
        // ---------- Original Method ----------
        //int result = 1;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object object = it.next();
            //result = (31 * result) + (object == null ? 0 : object.hashCode());
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.119 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "596E791499AE4A35E1A9DD575B028A49")
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        ListIterator<?> it = listIterator();
    if(object != null)        
        {
            while
(it.hasNext())            
            {
    if(object.equals(it.next()))                
                {
                    int var33BF225344C2DED44373E8C083BED386_1854481085 = (it.previousIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782872207 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782872207;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
    if(it.next() == null)                
                {
                    int var33BF225344C2DED44373E8C083BED386_2107632756 = (it.previousIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240318143 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240318143;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1523018230 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126555861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126555861;
        // ---------- Original Method ----------
        //ListIterator<?> it = listIterator();
        //if (object != null) {
            //while (it.hasNext()) {
                //if (object.equals(it.next())) {
                    //return it.previousIndex();
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next() == null) {
                    //return it.previousIndex();
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.120 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "32853AA7CFE47CFA96562FA12AA26A1A")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var98A17F5C644EE571B50E8AB722E91624_657998174 =         new SimpleListIterator();
        var98A17F5C644EE571B50E8AB722E91624_657998174.addTaint(taint);
        return var98A17F5C644EE571B50E8AB722E91624_657998174;
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.120 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "A062C475A4C84EF79C0D19A776488387")
    public int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        ListIterator<?> it = listIterator(size());
    if(object != null)        
        {
            while
(it.hasPrevious())            
            {
    if(object.equals(it.previous()))                
                {
                    int varDF19B7939EE3E8ABC829FDBB0D9E1BDA_965719878 = (it.nextIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655330772 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655330772;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasPrevious())            
            {
    if(it.previous() == null)                
                {
                    int varDF19B7939EE3E8ABC829FDBB0D9E1BDA_1755463700 = (it.nextIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676868044 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676868044;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1452435985 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217340688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217340688;
        // ---------- Original Method ----------
        //ListIterator<?> it = listIterator(size());
        //if (object != null) {
            //while (it.hasPrevious()) {
                //if (object.equals(it.previous())) {
                    //return it.nextIndex();
                //}
            //}
        //} else {
            //while (it.hasPrevious()) {
                //if (it.previous() == null) {
                    //return it.nextIndex();
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.121 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "497FB8C76FA406B2BC4FCF9026817E39")
    public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_1126882828 =         listIterator(0);
        var68247D54D1DDB9E66659394CC1668C3F_1126882828.addTaint(taint);
        return var68247D54D1DDB9E66659394CC1668C3F_1126882828;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.121 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "096DB0E047322A9374A590E50D666D5E")
    public ListIterator<E> listIterator(int location) {
        addTaint(location);
ListIterator<E> varA850735745ADA094DBCC6D2BBBE0CA4F_1219493974 =         new FullListIterator(location);
        varA850735745ADA094DBCC6D2BBBE0CA4F_1219493974.addTaint(taint);
        return varA850735745ADA094DBCC6D2BBBE0CA4F_1219493974;
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.121 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "17C1721C71607264C066CA3A330BE723")
    public E remove(int location) {
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1222505699 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1222505699.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1222505699;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.122 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "6D6A2347514B81060D28B96CAA380E0C")
    protected void removeRange(int start, int end) {
        addTaint(end);
        addTaint(start);
        Iterator<?> it = listIterator(start);
for(int i = start;i < end;i++)
        {
            it.next();
            it.remove();
        } //End block
        // ---------- Original Method ----------
        //Iterator<?> it = listIterator(start);
        //for (int i = start; i < end; i++) {
            //it.next();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.122 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "6F2B929CF2A16C67BB524FF67C4B6BD2")
    public E set(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2043364943 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2043364943.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2043364943;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.123 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "838E4E2E8613233FF927378F2D42E8E5")
    public List<E> subList(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start >= 0 && end <= size())        
        {
    if(start <= end)            
            {
    if(this instanceof RandomAccess)                
                {
List<E> var21D5C34678B5990E6FC59B29CAC52CEA_269738487 =                     new SubAbstractListRandomAccess<E>(this, start, end);
                    var21D5C34678B5990E6FC59B29CAC52CEA_269738487.addTaint(taint);
                    return var21D5C34678B5990E6FC59B29CAC52CEA_269738487;
                } //End block
List<E> var9E0FEF79CE79E4D53BC7ACDCF4F364A1_1454434323 =                 new SubAbstractList<E>(this, start, end);
                var9E0FEF79CE79E4D53BC7ACDCF4F364A1_1454434323.addTaint(taint);
                return var9E0FEF79CE79E4D53BC7ACDCF4F364A1_1454434323;
            } //End block
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2102391898 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2102391898.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2102391898;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_53042837 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_53042837.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_53042837;
        // ---------- Original Method ----------
        //if (start >= 0 && end <= size()) {
            //if (start <= end) {
                //if (this instanceof RandomAccess) {
                    //return new SubAbstractListRandomAccess<E>(this, start, end);
                //}
                //return new SubAbstractList<E>(this, start, end);
            //}
            //throw new IllegalArgumentException();
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    private class SimpleListIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.123 -0400", hash_original_field = "01BCDD4702E06493BD386DC95FBAF612", hash_generated_field = "9DBA99389B1E561A787ED19695A15CE3")

        int pos = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.123 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.123 -0400", hash_original_field = "8F224EBDBA035312E97D20DDD1BA3431", hash_generated_field = "576334B50B797BC1B6FEA5BF5FD6A2E8")

        int lastPosition = -1;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.124 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "521DE0FD8E86B0B1E4563974AFB0BE5F")
          SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.124 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "A1C4995F0CB9D3C0A644EDC2FC5AFEA7")
        public boolean hasNext() {
            boolean varEDD3AC44D37300E88D8459F78FCEAE5A_1218211374 = (pos + 1 < size());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1050752382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1050752382;
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.124 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "2A260BD7E330648BC5EAF45D62A42241")
        public E next() {
    if(expectedModCount == modCount)            
            {
                try 
                {
                    E result = get(pos + 1);
                    lastPosition = ++pos;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1534174057 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1534174057.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1534174057;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1253122136 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1253122136.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1253122136;
                } //End block
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_389481187 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_389481187.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_389481187;
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //E result = get(pos + 1);
                    //lastPosition = ++pos;
                    //return result;
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.125 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "F5CB1CFAF17DEFFCE91783E1D1FB328E")
        public void remove() {
    if(this.lastPosition == -1)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1661624403 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_1661624403.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_1661624403;
            } //End block
    if(expectedModCount != modCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_158127266 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_158127266.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_158127266;
            } //End block
            try 
            {
                AbstractList.this.remove(lastPosition);
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_127837634 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_127837634.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_127837634;
            } //End block
            expectedModCount = modCount;
    if(pos == lastPosition)            
            {
                pos--;
            } //End block
            lastPosition = -1;
            // ---------- Original Method ----------
            //if (this.lastPosition == -1) {
                //throw new IllegalStateException();
            //}
            //if (expectedModCount != modCount) {
                //throw new ConcurrentModificationException();
            //}
            //try {
                //AbstractList.this.remove(lastPosition);
            //} catch (IndexOutOfBoundsException e) {
                //throw new ConcurrentModificationException();
            //}
            //expectedModCount = modCount;
            //if (pos == lastPosition) {
                //pos--;
            //}
            //lastPosition = -1;
        }

        
    }


    
    private final class FullListIterator extends SimpleListIterator implements ListIterator<E> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.126 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "B6D20F2733A2D3B521BD12FE7F649CF9")
          FullListIterator(int start) {
            addTaint(start);
    if(start >= 0 && start <= size())            
            {
                pos = start - 1;
            } //End block
            else
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_936049458 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_936049458.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_936049458;
            } //End block
            // ---------- Original Method ----------
            //if (start >= 0 && start <= size()) {
                //pos = start - 1;
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.127 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "3315233A4B86A59B004E4E9228269DB1")
        public void add(E object) {
            addTaint(object.getTaint());
    if(expectedModCount == modCount)            
            {
                try 
                {
                    AbstractList.this.add(pos + 1, object);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1875539083 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1875539083.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1875539083;
                } //End block
                pos++;
                lastPosition = -1;
    if(modCount != expectedModCount)                
                {
                    expectedModCount = modCount;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1723426690 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1723426690.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1723426690;
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //AbstractList.this.add(pos + 1, object);
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
                //pos++;
                //lastPosition = -1;
                //if (modCount != expectedModCount) {
                    //expectedModCount = modCount;
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.127 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "CBBBC0A7F7B8021869A19A5DB5F09291")
        public boolean hasPrevious() {
            boolean var716A4D992467E57E8EC4184695D584B8_1067398531 = (pos >= 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213401545 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213401545;
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.127 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "5977224826A5C2880FAC6FA6DE9CE73D")
        public int nextIndex() {
            int varF9B06598B7E41FEBC3492F881D35DA6D_1152113754 = (pos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99822351 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99822351;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.128 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "C4455CAB35D4D20DCFC12A7595A9400D")
        public E previous() {
    if(expectedModCount == modCount)            
            {
                try 
                {
                    E result = get(pos);
                    lastPosition = pos;
                    pos--;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1679428623 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1679428623.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1679428623;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1498726188 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1498726188.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1498726188;
                } //End block
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1249145853 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1249145853.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1249145853;
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //E result = get(pos);
                    //lastPosition = pos;
                    //pos--;
                    //return result;
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.128 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "3A98FE066B33FCF746F0494BDF97CE51")
        public int previousIndex() {
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_910777287 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617496970 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617496970;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.129 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "4AAF92740C2C49C6D0CF59D3A80E5FBF")
        public void set(E object) {
            addTaint(object.getTaint());
    if(expectedModCount == modCount)            
            {
                try 
                {
                    AbstractList.this.set(lastPosition, object);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1679188100 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1679188100.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1679188100;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_772160981 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_772160981.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_772160981;
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //AbstractList.this.set(lastPosition, object);
                //} catch (IndexOutOfBoundsException e) {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    private static final class SubAbstractListRandomAccess<E> extends SubAbstractList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.129 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "6B7B76F5C18BE79DC74610147357D3EB")
          SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
            super(list, start, end);
            addTaint(end);
            addTaint(start);
            addTaint(list.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class SubAbstractList<E> extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.129 -0400", hash_original_field = "8905032EB1CDF77831923571A781EEC0", hash_generated_field = "C1379C832D8AED55354E52703E5CFF3D")

        private AbstractList<E> fullList;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.130 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.130 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.130 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "1AB05E7BE46F8223923A52968D13AFBB")
          SubAbstractList(AbstractList<E> list, int start, int end) {
            fullList = list;
            modCount = fullList.modCount;
            offset = start;
            size = end - start;
            // ---------- Original Method ----------
            //fullList = list;
            //modCount = fullList.modCount;
            //offset = start;
            //size = end - start;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.131 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "9271AECE0DD06EB41328D1997EF57D11")
        @Override
        public void add(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location <= size)                
                {
                    fullList.add(location + offset, object);
                    size++;
                    modCount = fullList.modCount;
                } //End block
                else
                {
                    IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1851606777 = new IndexOutOfBoundsException();
                    varE4A00D3DB3B35ED0F12562B8AA17377A_1851606777.addTaint(taint);
                    throw varE4A00D3DB3B35ED0F12562B8AA17377A_1851606777;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1630319442 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1630319442.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1630319442;
            } //End block
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //fullList.add(location + offset, object);
                    //size++;
                    //modCount = fullList.modCount;
                //} else {
                    //throw new IndexOutOfBoundsException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.132 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "8D91138C8C7F9E8790CDEF2B19247ABF")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location <= size)                
                {
                    boolean result = fullList.addAll(location + offset,
                            collection);
    if(result)                    
                    {
                        size += collection.size();
                        modCount = fullList.modCount;
                    } //End block
                    boolean varB4A88417B3D0170D754C647C30B7216A_1890240043 = (result);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060478521 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060478521;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1246053953 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1246053953.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1246053953;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_697573375 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_697573375.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_697573375;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //boolean result = fullList.addAll(location + offset,
                            //collection);
                    //if (result) {
                        //size += collection.size();
                        //modCount = fullList.modCount;
                    //}
                    //return result;
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.133 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "02B827181809D01229061FA2F79EC54C")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
    if(modCount == fullList.modCount)            
            {
                boolean result = fullList.addAll(offset + size, collection);
    if(result)                
                {
                    size += collection.size();
                    modCount = fullList.modCount;
                } //End block
                boolean varB4A88417B3D0170D754C647C30B7216A_2081379821 = (result);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483841294 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_483841294;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2116242960 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_2116242960.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_2116242960;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //boolean result = fullList.addAll(offset + size, collection);
                //if (result) {
                    //size += collection.size();
                    //modCount = fullList.modCount;
                //}
                //return result;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.133 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "4291D09B5ECBD63F8163161D90A7E91C")
        @Override
        public E get(int location) {
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location < size)                
                {
E var766ACCB0072F190CABC18A57CF6D40BA_1737257189 =                     fullList.get(location + offset);
                    var766ACCB0072F190CABC18A57CF6D40BA_1737257189.addTaint(taint);
                    return var766ACCB0072F190CABC18A57CF6D40BA_1737257189;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_78477243 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_78477243.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_78477243;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_918269761 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_918269761.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_918269761;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.get(location + offset);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.133 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "8B739B1CBA76CDD17DB8AFBD701E942F")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_1782679809 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_1782679809.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_1782679809;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.134 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "D04D8587B78A30B7738056F10A6C52E3")
        @Override
        public ListIterator<E> listIterator(int location) {
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location <= size)                
                {
ListIterator<E> varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_503979359 =                     new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size);
                    varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_503979359.addTaint(taint);
                    return varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_503979359;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1103053149 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1103053149.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1103053149;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_451875398 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_451875398.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_451875398;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //return new SubAbstractListIterator<E>(fullList
                            //.listIterator(location + offset), this, offset,
                            //size);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.135 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "40D3EC43412C199DC0F64BE4054517BF")
        @Override
        public E remove(int location) {
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location < size)                
                {
                    E result = fullList.remove(location + offset);
                    size--;
                    modCount = fullList.modCount;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1832923235 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1832923235.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1832923235;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2122227656 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_2122227656.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_2122227656;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1624277930 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1624277930.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1624277930;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //E result = fullList.remove(location + offset);
                    //size--;
                    //modCount = fullList.modCount;
                    //return result;
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.135 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "BB230B76A9A97CECEEBE6932E355BDEC")
        @Override
        protected void removeRange(int start, int end) {
    if(start != end)            
            {
    if(modCount == fullList.modCount)                
                {
                    fullList.removeRange(start + offset, end + offset);
                    size -= end - start;
                    modCount = fullList.modCount;
                } //End block
                else
                {
                    ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_173700580 = new ConcurrentModificationException();
                    var779BA6969BD29E5F2D0448781C543B65_173700580.addTaint(taint);
                    throw var779BA6969BD29E5F2D0448781C543B65_173700580;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (start != end) {
                //if (modCount == fullList.modCount) {
                    //fullList.removeRange(start + offset, end + offset);
                    //size -= end - start;
                    //modCount = fullList.modCount;
                //} else {
                    //throw new ConcurrentModificationException();
                //}
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.136 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "7F5CDC1AA1E835DA5D3A8B528875ADEB")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
    if(modCount == fullList.modCount)            
            {
    if(location >= 0 && location < size)                
                {
E var95CF0C14865F4C7BC0EBAE627CB27751_1760887204 =                     fullList.set(location + offset, object);
                    var95CF0C14865F4C7BC0EBAE627CB27751_1760887204.addTaint(taint);
                    return var95CF0C14865F4C7BC0EBAE627CB27751_1760887204;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_282089428 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_282089428.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_282089428;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_617960047 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_617960047.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_617960047;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.set(location + offset, object);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.136 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "DDF026A3EBCCFEF18E9F1D5CAF01924B")
        @Override
        public int size() {
    if(modCount == fullList.modCount)            
            {
                int varF7BD60B75B29D79B660A2859395C1A24_1540133779 = (size);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981086032 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981086032;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_927162320 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_927162320.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_927162320;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //return size;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.137 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "9CDE73BCB1714573BB8FFEB74FFC6CC6")
         void sizeChanged(boolean increment) {
            addTaint(increment);
    if(increment)            
            {
                size++;
            } //End block
            else
            {
                size--;
            } //End block
            modCount = fullList.modCount;
            // ---------- Original Method ----------
            //if (increment) {
                //size++;
            //} else {
                //size--;
            //}
            //modCount = fullList.modCount;
        }

        
        private static final class SubAbstractListIterator<E> implements ListIterator<E> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.137 -0400", hash_original_field = "A8F4783570FDF0AC561E9E4720394F13", hash_generated_field = "96B7492BED9C5CEFD9531AA61E07E6FD")

            private SubAbstractList<E> subList;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.137 -0400", hash_original_field = "420CEC00303CF5FF3EE30BF824FC1427", hash_generated_field = "962F6323627A99A953BE0EC69102D478")

            private ListIterator<E> iterator;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.138 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

            private int start;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.138 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.138 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "886B422BF688C0301EEB349912A714E7")
              SubAbstractListIterator(ListIterator<E> it,
                    SubAbstractList<E> list, int offset, int length) {
                iterator = it;
                subList = list;
                start = offset;
                end = start + length;
                // ---------- Original Method ----------
                //iterator = it;
                //subList = list;
                //start = offset;
                //end = start + length;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.139 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "FDDF48BD0D23DC6A3C793D54A20B5C2A")
            public void add(E object) {
                addTaint(object.getTaint());
                iterator.add(object);
                subList.sizeChanged(true);
                end++;
                // ---------- Original Method ----------
                //iterator.add(object);
                //subList.sizeChanged(true);
                //end++;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.139 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "68506959AC6732170BFBB1A52633FA52")
            public boolean hasNext() {
                boolean var9795C4C630380B412A0C598E1FF40E06_713945979 = (iterator.nextIndex() < end);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101865990 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101865990;
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.139 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "CD484E13B2B70D6D2F9DBE95DC171837")
            public boolean hasPrevious() {
                boolean varCE4946704927622E8B6F55CBCF1F309D_1649447700 = (iterator.previousIndex() >= start);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288371242 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_288371242;
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.140 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "380C301F509E9F1E277C6A42A04764F6")
            public E next() {
    if(iterator.nextIndex() < end)                
                {
E var862BD85102BDD28E8A3902D84E203428_1845457169 =                     iterator.next();
                    var862BD85102BDD28E8A3902D84E203428_1845457169.addTaint(taint);
                    return var862BD85102BDD28E8A3902D84E203428_1845457169;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_7896256 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_7896256.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_7896256;
                // ---------- Original Method ----------
                //if (iterator.nextIndex() < end) {
                    //return iterator.next();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.140 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "4E39721EBDCB425E6BFA8292C33EDFEC")
            public int nextIndex() {
                int var8CB4CF713F171A10EB813B23DAFB77B0_1263700363 = (iterator.nextIndex() - start);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524329782 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524329782;
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.141 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "0E31CF0F50BE280DAA95153FDAD76208")
            public E previous() {
    if(iterator.previousIndex() >= start)                
                {
E var31413FEE771C499A1C4BF17C156DB014_1490393510 =                     iterator.previous();
                    var31413FEE771C499A1C4BF17C156DB014_1490393510.addTaint(taint);
                    return var31413FEE771C499A1C4BF17C156DB014_1490393510;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_747728422 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_747728422.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_747728422;
                // ---------- Original Method ----------
                //if (iterator.previousIndex() >= start) {
                    //return iterator.previous();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.141 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "1277DB16256FB9AACF2CCA4F4C500BD9")
            public int previousIndex() {
                int previous = iterator.previousIndex();
    if(previous >= start)                
                {
                    int var14BA67E0E85B96CD715DE8413CDF52DE_1466335523 = (previous - start);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706989265 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706989265;
                } //End block
                int var6BB61E3B7BCE0931DA574D19D1D82C88_264848395 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590044125 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590044125;
                // ---------- Original Method ----------
                //int previous = iterator.previousIndex();
                //if (previous >= start) {
                    //return previous - start;
                //}
                //return -1;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.141 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "4E909FDAFF72D7CD3EED9C952C544510")
            public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                end--;
                // ---------- Original Method ----------
                //iterator.remove();
                //subList.sizeChanged(false);
                //end--;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.142 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "B7375D0F4260A93892540E19D5B301F5")
            public void set(E object) {
                addTaint(object.getTaint());
                iterator.set(object);
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}

