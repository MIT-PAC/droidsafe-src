package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.419 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "D904B48F1A1A3F19ECDEE2D75BF7C70B")

    protected transient int modCount;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.419 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "C2512795C4B4D09B5344EF8EABF2A19D")
    protected  AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.420 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "A01914328316F1F0C4A33E8F194581C9")
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1207719110 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1207719110.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1207719110;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.421 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "D9D0CC495BB2B1429BF0FAFFEE6FF9AF")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        add(size(), object);
        boolean varB326B5062B2F0E69046810717534CB09_425975833 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509681342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509681342;
        // ---------- Original Method ----------
        //add(size(), object);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.421 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "0127629B0B8F67B14192AFA72258FAC0")
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(location);
        Iterator<? extends E> it = collection.iterator();
        while
(it.hasNext())        
        {
            add(location++, it.next());
        } //End block
        boolean varE79DF77F19DD1F1F6B53F87ADB408DD7_2079412012 = (!collection.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001520312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001520312;
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.422 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.423 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "204F4D2CFDFE31B104EBE1269CE6D370")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1736386575 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1096323161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1096323161;
        } //End block
        if(object instanceof List)        
        {
            List<?> list = (List<?>) object;
            if(list.size() != size())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1798178610 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105805938 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105805938;
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
                    boolean var68934A3E9455FA72420237EB05902327_1440221034 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966030503 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966030503;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1410067843 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310441146 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310441146;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_701465241 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467423209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467423209;
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

    
    @DSModeled(DSC.SAFE)
    public abstract E get(int location);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.425 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "2B7B72A53AC9827A4DC99ACE39920C7D")
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
        int varB4A88417B3D0170D754C647C30B7216A_1532767736 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160446279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160446279;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.426 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "5A11134C6788D386CFD7B275F903E2FC")
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
                    int var33BF225344C2DED44373E8C083BED386_1069743445 = (it.previousIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517733120 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517733120;
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
                    int var33BF225344C2DED44373E8C083BED386_224075881 = (it.previousIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139133738 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139133738;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1620140467 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862220558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862220558;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.427 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "FC74168216C4ED32DCE073889FCFFA54")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var98A17F5C644EE571B50E8AB722E91624_1992156947 =         new SimpleListIterator();
        var98A17F5C644EE571B50E8AB722E91624_1992156947.addTaint(taint);
        return var98A17F5C644EE571B50E8AB722E91624_1992156947;
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.428 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "BD972CB256E1A2D2ADAD81413FB3F434")
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
                    int varDF19B7939EE3E8ABC829FDBB0D9E1BDA_721920819 = (it.nextIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061238425 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061238425;
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
                    int varDF19B7939EE3E8ABC829FDBB0D9E1BDA_1800240404 = (it.nextIndex());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598769250 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598769250;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1236848536 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377108532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377108532;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.429 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "0DFFD4ED180C1039DAC197DE7ED416B7")
    public ListIterator<E> listIterator() {
ListIterator<E> var68247D54D1DDB9E66659394CC1668C3F_1868311428 =         listIterator(0);
        var68247D54D1DDB9E66659394CC1668C3F_1868311428.addTaint(taint);
        return var68247D54D1DDB9E66659394CC1668C3F_1868311428;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.430 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "A397E522795A04A37957E6B7762430ED")
    public ListIterator<E> listIterator(int location) {
        addTaint(location);
ListIterator<E> varA850735745ADA094DBCC6D2BBBE0CA4F_935962105 =         new FullListIterator(location);
        varA850735745ADA094DBCC6D2BBBE0CA4F_935962105.addTaint(taint);
        return varA850735745ADA094DBCC6D2BBBE0CA4F_935962105;
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.430 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "8139D75C3BDD16E15FDC1C3ADC818304")
    public E remove(int location) {
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_369555199 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_369555199.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_369555199;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.431 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "6D6A2347514B81060D28B96CAA380E0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.431 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "EB4F57E538448BBB2DB9DEE7C42586D7")
    public E set(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_826873218 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_826873218.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_826873218;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.432 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "62FDF1A14BB0C18C80410F837219FFFC")
    public List<E> subList(int start, int end) {
        addTaint(end);
        addTaint(start);
        if(start >= 0 && end <= size())        
        {
            if(start <= end)            
            {
                if(this instanceof RandomAccess)                
                {
List<E> var21D5C34678B5990E6FC59B29CAC52CEA_1215162304 =                     new SubAbstractListRandomAccess<E>(this, start, end);
                    var21D5C34678B5990E6FC59B29CAC52CEA_1215162304.addTaint(taint);
                    return var21D5C34678B5990E6FC59B29CAC52CEA_1215162304;
                } //End block
List<E> var9E0FEF79CE79E4D53BC7ACDCF4F364A1_570652865 =                 new SubAbstractList<E>(this, start, end);
                var9E0FEF79CE79E4D53BC7ACDCF4F364A1_570652865.addTaint(taint);
                return var9E0FEF79CE79E4D53BC7ACDCF4F364A1_570652865;
            } //End block
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_130481627 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_130481627.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_130481627;
        } //End block
        IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229 = new IndexOutOfBoundsException();
        varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229.addTaint(taint);
        throw varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.433 -0400", hash_original_field = "01BCDD4702E06493BD386DC95FBAF612", hash_generated_field = "9DBA99389B1E561A787ED19695A15CE3")

        int pos = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.433 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.433 -0400", hash_original_field = "8F224EBDBA035312E97D20DDD1BA3431", hash_generated_field = "576334B50B797BC1B6FEA5BF5FD6A2E8")

        int lastPosition = -1;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.433 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "521DE0FD8E86B0B1E4563974AFB0BE5F")
          SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.434 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "563086F58812C8DA195AC1B8A3890FB5")
        public boolean hasNext() {
            boolean varEDD3AC44D37300E88D8459F78FCEAE5A_1979772365 = (pos + 1 < size());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082016730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082016730;
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.434 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "05987522E46A7267DDF7C336BE87A131")
        public E next() {
            if(expectedModCount == modCount)            
            {
                try 
                {
                    E result = get(pos + 1);
                    lastPosition = ++pos;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1553946836 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1553946836.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1553946836;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1381153892 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1381153892.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1381153892;
                } //End block
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2105245686 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_2105245686.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_2105245686;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.436 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "E44FD099A0E69CDF691E5E89382404F2")
        public void remove() {
            if(this.lastPosition == -1)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_290857454 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_290857454.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_290857454;
            } //End block
            if(expectedModCount != modCount)            
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_732808124 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_732808124.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_732808124;
            } //End block
            try 
            {
                AbstractList.this.remove(lastPosition);
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_224891883 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_224891883.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_224891883;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.437 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "FCB46A27825758C61A072AD3245829E3")
          FullListIterator(int start) {
            addTaint(start);
            if(start >= 0 && start <= size())            
            {
                pos = start - 1;
            } //End block
            else
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1565012145 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1565012145.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1565012145;
            } //End block
            // ---------- Original Method ----------
            //if (start >= 0 && start <= size()) {
                //pos = start - 1;
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.439 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "27CFD88E9F5CEB31014C301B2C89DB13")
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
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_2060155683 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_2060155683.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_2060155683;
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
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1984128342 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_1984128342.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_1984128342;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.439 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "DC64338703DAFC5D3681B0CE98898D95")
        public boolean hasPrevious() {
            boolean var716A4D992467E57E8EC4184695D584B8_689492862 = (pos >= 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872452412 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872452412;
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.440 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "C7FB5C50D5A7DE59EB2823E679B1AD79")
        public int nextIndex() {
            int varF9B06598B7E41FEBC3492F881D35DA6D_1335097008 = (pos + 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179550013 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179550013;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.441 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "1680C874984CF4DDF6E3DA5FE5E8B5D4")
        public E previous() {
            if(expectedModCount == modCount)            
            {
                try 
                {
                    E result = get(pos);
                    lastPosition = pos;
                    pos--;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1816913652 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1816913652.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1816913652;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1100152132 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1100152132.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1100152132;
                } //End block
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2076290306 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_2076290306.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_2076290306;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.442 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "365C12BE8A10E11C949799058446A835")
        public int previousIndex() {
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_1005029596 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362298532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362298532;
            // ---------- Original Method ----------
            //return pos;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.443 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "1AB3A3CDD81A14B3532CE5B15641F0CD")
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
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1268997674 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1268997674.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1268997674;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_336730254 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_336730254.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_336730254;
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
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.444 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "6B7B76F5C18BE79DC74610147357D3EB")
          SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
            super(list, start, end);
            addTaint(end);
            addTaint(start);
            addTaint(list.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class SubAbstractList<E> extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.445 -0400", hash_original_field = "8905032EB1CDF77831923571A781EEC0", hash_generated_field = "C1379C832D8AED55354E52703E5CFF3D")

        private AbstractList<E> fullList;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.445 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.445 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.446 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "1AB05E7BE46F8223923A52968D13AFBB")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.446 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "A3451CCC325A6954A2DA4AF97DFE6D6A")
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
                    IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_991953431 = new IndexOutOfBoundsException();
                    varE4A00D3DB3B35ED0F12562B8AA17377A_991953431.addTaint(taint);
                    throw varE4A00D3DB3B35ED0F12562B8AA17377A_991953431;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_312340173 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_312340173.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_312340173;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.447 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "16020E29E75D11C35320005635BDD2D7")
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
                    boolean varB4A88417B3D0170D754C647C30B7216A_1080240190 = (result);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350599986 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350599986;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_679105590 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_679105590.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_679105590;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1103994350 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1103994350.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1103994350;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.448 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "BB17679978ADBD1E5EB825EDA66C855F")
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
                boolean varB4A88417B3D0170D754C647C30B7216A_649431792 = (result);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089269973 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089269973;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1945704776 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1945704776.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1945704776;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.449 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "6D977157F092965F5DA70043A2763785")
        @Override
        public E get(int location) {
            addTaint(location);
            if(modCount == fullList.modCount)            
            {
                if(location >= 0 && location < size)                
                {
E var766ACCB0072F190CABC18A57CF6D40BA_1237569008 =                     fullList.get(location + offset);
                    var766ACCB0072F190CABC18A57CF6D40BA_1237569008.addTaint(taint);
                    return var766ACCB0072F190CABC18A57CF6D40BA_1237569008;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_443605925 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_443605925.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_443605925;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1777440182 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1777440182.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1777440182;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.get(location + offset);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.449 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "3B4DBE71A5AC4AE1C29159EDA63E2458")
        @Override
        public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_648577415 =             listIterator(0);
            var68247D54D1DDB9E66659394CC1668C3F_648577415.addTaint(taint);
            return var68247D54D1DDB9E66659394CC1668C3F_648577415;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.449 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "5AD41752A29263265B18FD12D9F53563")
        @Override
        public ListIterator<E> listIterator(int location) {
            addTaint(location);
            if(modCount == fullList.modCount)            
            {
                if(location >= 0 && location <= size)                
                {
ListIterator<E> varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_1408186847 =                     new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size);
                    varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_1408186847.addTaint(taint);
                    return varB9B1B3D6EADC76A9BB5951AEEBCC5ACB_1408186847;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2138660915 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_2138660915.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_2138660915;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_435185622 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_435185622.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_435185622;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.450 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "728235220D2BEFBBB04F78CF59EEE389")
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
E varDC838461EE2FA0CA4C9BBB70A15456B0_1989159725 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1989159725.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1989159725;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_951404197 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_951404197.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_951404197;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1912515637 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1912515637.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1912515637;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.451 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "9CFD84AFE1F50D07E641CB6A9B7FD0F1")
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
                    ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_259880465 = new ConcurrentModificationException();
                    var779BA6969BD29E5F2D0448781C543B65_259880465.addTaint(taint);
                    throw var779BA6969BD29E5F2D0448781C543B65_259880465;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.452 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "45D6147676C0B76280FD4638529A9D83")
        @Override
        public E set(int location, E object) {
            addTaint(object.getTaint());
            addTaint(location);
            if(modCount == fullList.modCount)            
            {
                if(location >= 0 && location < size)                
                {
E var95CF0C14865F4C7BC0EBAE627CB27751_662668506 =                     fullList.set(location + offset, object);
                    var95CF0C14865F4C7BC0EBAE627CB27751_662668506.addTaint(taint);
                    return var95CF0C14865F4C7BC0EBAE627CB27751_662668506;
                } //End block
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1498926180 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1498926180.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1498926180;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1399457177 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1399457177.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1399457177;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.452 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "7493116AD71848D793139D24D9DBC1D4")
        @Override
        public int size() {
            if(modCount == fullList.modCount)            
            {
                int varF7BD60B75B29D79B660A2859395C1A24_2007969862 = (size);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805642266 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805642266;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_870817432 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_870817432.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_870817432;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //return size;
            //}
            //throw new ConcurrentModificationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.452 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "9CDE73BCB1714573BB8FFEB74FFC6CC6")
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_field = "A8F4783570FDF0AC561E9E4720394F13", hash_generated_field = "96B7492BED9C5CEFD9531AA61E07E6FD")

            private SubAbstractList<E> subList;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_field = "420CEC00303CF5FF3EE30BF824FC1427", hash_generated_field = "962F6323627A99A953BE0EC69102D478")

            private ListIterator<E> iterator;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

            private int start;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "886B422BF688C0301EEB349912A714E7")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "FDDF48BD0D23DC6A3C793D54A20B5C2A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "53476846B69E22E39C9423A1A5E015DD")
            public boolean hasNext() {
                boolean var9795C4C630380B412A0C598E1FF40E06_211107453 = (iterator.nextIndex() < end);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710559993 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_710559993;
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.453 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "357FE3DC614A437F7E9987307DEB67F5")
            public boolean hasPrevious() {
                boolean varCE4946704927622E8B6F55CBCF1F309D_566319745 = (iterator.previousIndex() >= start);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174733509 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_174733509;
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.454 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "C8A25D14A626FFEB51F9B7AB8BDAC97F")
            public E next() {
                if(iterator.nextIndex() < end)                
                {
E var862BD85102BDD28E8A3902D84E203428_2021847492 =                     iterator.next();
                    var862BD85102BDD28E8A3902D84E203428_2021847492.addTaint(taint);
                    return var862BD85102BDD28E8A3902D84E203428_2021847492;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_34121121 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_34121121.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_34121121;
                // ---------- Original Method ----------
                //if (iterator.nextIndex() < end) {
                    //return iterator.next();
                //}
                //throw new NoSuchElementException();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.454 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "8947D39F3C03A7B019936B440168D630")
            public int nextIndex() {
                int var8CB4CF713F171A10EB813B23DAFB77B0_719552098 = (iterator.nextIndex() - start);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850622891 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850622891;
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.454 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "F4CB79E21EC18956A908C6B255B1C077")
            public E previous() {
                if(iterator.previousIndex() >= start)                
                {
E var31413FEE771C499A1C4BF17C156DB014_1022083744 =                     iterator.previous();
                    var31413FEE771C499A1C4BF17C156DB014_1022083744.addTaint(taint);
                    return var31413FEE771C499A1C4BF17C156DB014_1022083744;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_933252670 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_933252670.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_933252670;
                // ---------- Original Method ----------
                //if (iterator.previousIndex() >= start) {
                    //return iterator.previous();
                //}
                //throw new NoSuchElementException();
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.454 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "2A59A88A005B661129C5FC9E3240C87C")
            public int previousIndex() {
                int previous = iterator.previousIndex();
                if(previous >= start)                
                {
                    int var14BA67E0E85B96CD715DE8413CDF52DE_1710247156 = (previous - start);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205814094 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205814094;
                } //End block
                int var6BB61E3B7BCE0931DA574D19D1D82C88_797672244 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792799138 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792799138;
                // ---------- Original Method ----------
                //int previous = iterator.previousIndex();
                //if (previous >= start) {
                    //return previous - start;
                //}
                //return -1;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.455 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "4E909FDAFF72D7CD3EED9C952C544510")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.455 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "B7375D0F4260A93892540E19D5B301F5")
            public void set(E object) {
                addTaint(object.getTaint());
                iterator.set(object);
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}

