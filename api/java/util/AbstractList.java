package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    
    public static List newSimpleList() {
        return new SubAbstractList();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.837 -0500", hash_original_field = "52F3DED7388D6DA42BC9C902075440B5", hash_generated_field = "D904B48F1A1A3F19ECDEE2D75BF7C70B")

    protected transient int modCount;

    /**
     * Constructs a new instance of this AbstractList.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.970 -0500", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "D2CD754E0F115F288E42249DC6A8FBE4")
    
protected AbstractList() {
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.420 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "A01914328316F1F0C4A33E8F194581C9")
    public void add(int location, E object) {
        super.addElementAt(location, object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.421 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "0127629B0B8F67B14192AFA72258FAC0")
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(location);
        addTaint(collection.getTaint());
        for ( E elem: collection) {
            addElementAt(location++, elem);
        }
        return true;
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.422 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    @Override
    public void clear() {
        super.clear();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.423 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "204F4D2CFDFE31B104EBE1269CE6D370")
    @Override
    public boolean equals(Object object) {
        return super.isEqualTo(object);
    }

    /**
     * Returns the element at the specified location in this list.
     *
     * @param location
     *            the index of the element to return.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException
     *             if {@code location < 0 || >= size()}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.985 -0500", hash_original_method = "028843ECC72155B435F1914365BF5067", hash_generated_method = "FA43A5DF06AE806D1B6BA7C7E16F414D")
    
public abstract E get(int location);
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.425 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "2B7B72A53AC9827A4DC99ACE39920C7D")
    @Override
    public int hashCode() {
        return getTaintInt();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.426 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "5A11134C6788D386CFD7B275F903E2FC")
    public int indexOf(Object object) {
        return super.getIndexOf(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.427 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "FC74168216C4ED32DCE073889FCFFA54")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var98A17F5C644EE571B50E8AB722E91624_1992156947 = getIterator();        
        var98A17F5C644EE571B50E8AB722E91624_1992156947.addTaint(getTaint());
        return var98A17F5C644EE571B50E8AB722E91624_1992156947;
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.428 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "BD972CB256E1A2D2ADAD81413FB3F434")
    public int lastIndexOf(Object object) {
        return getLastIndexOf(object);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.429 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "0DFFD4ED180C1039DAC197DE7ED416B7")
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.430 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "A397E522795A04A37957E6B7762430ED")
    public ListIterator<E> listIterator(int location) {
        ListIterator<E> varA850735745ADA094DBCC6D2BBBE0CA4F_935962105 = getListIterator(location);
        varA850735745ADA094DBCC6D2BBBE0CA4F_935962105.addTaint(getTaint());
        varA850735745ADA094DBCC6D2BBBE0CA4F_935962105.addTaint(location);
        return varA850735745ADA094DBCC6D2BBBE0CA4F_935962105;
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.430 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "8139D75C3BDD16E15FDC1C3ADC818304")
    public E remove(int location) {
        return removeElementAt(location);
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.431 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "6D6A2347514B81060D28B96CAA380E0C")
    protected void removeRange(int start, int end) {
        for (int i = end; i >= start; i--)
            removeElementAt(i);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.431 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "EB4F57E538448BBB2DB9DEE7C42586D7")
    public E set(int location, E object) {
        setElementAt(location, object);
        return getElementAt(location);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.432 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "62FDF1A14BB0C18C80410F837219FFFC")
    public List<E> subList(int start, int end) {
        if(start >= 0 && end <= size())        
        {
            if(start <= end)            
            {
                List<E> elemList;
                
                elemList = new SubAbstractList<E>(this, start, end);
                elemList.addTaint(getTaint());
                elemList.addTaint(end);
                elemList.addTaint(start);
                return elemList;
            } //End block
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_130481627 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_130481627.addTaint(getTaint());
            var5783EF97022AA508B74A1E3EA38534AF_130481627.addTaint(start); 
            var5783EF97022AA508B74A1E3EA38534AF_130481627.addTaint(end); 
            throw var5783EF97022AA508B74A1E3EA38534AF_130481627;
        }
        else {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229.addTaint(getTaint());
            varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229.addTaint(start);
            varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229.addTaint(end);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1336418229;
        }
    }
    
    /***********************************************************************
     *  Simplify all inner classes
     ***********************************************************************/
    public final static class SubAbstractList<E> extends AbstractList<E> {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        public SubAbstractList() {
            
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        public SubAbstractList(AbstractList original, int start, int end) {
            for (int i = start; i <= end; i++)
                add((E)original.getElementAt(i));
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @Override
        
        public E get(int location) {
            // TODO Auto-generated method stub
            return getElementAt(location);
        }
        
    }

}

