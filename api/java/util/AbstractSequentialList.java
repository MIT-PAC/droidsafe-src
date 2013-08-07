package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;




public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.631 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "8ABE5E8156F04BB347DDB529BD7F304D")
    protected  AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.632 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "9C67BDB95B55F84EC870D9863D37F4CD")
    @Override
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        listIterator(location).add(object);
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.632 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "C3024FF8B2DE78D612245FBB0350EA9B")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        addTaint(location);
        ListIterator<E> it = listIterator(location);
        Iterator<? extends E> colIt = collection.iterator();
        int next = it.nextIndex();
        while
(colIt.hasNext())        
        {
            it.add(colIt.next());
        } //End block
        boolean varDCE3F59DDBDE54C7D50DC584BC9C6372_1798186496 = (next != it.nextIndex());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165173218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_165173218;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.633 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "087643CA6EA6B1EA72D80081D2A89C4C")
    @Override
    public E get(int location) {
        addTaint(location);
        try 
        {
E var3BD6B1CAB81D050B781A92E41D17A2E1_2038932364 =             listIterator(location).next();
            var3BD6B1CAB81D050B781A92E41D17A2E1_2038932364.addTaint(taint);
            return var3BD6B1CAB81D050B781A92E41D17A2E1_2038932364;
        } //End block
        catch (NoSuchElementException e)
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_219268406 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_219268406.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_219268406;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.634 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "E785298B8A14C9DC01552686D975F906")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_1413572110 =         listIterator(0);
        var68247D54D1DDB9E66659394CC1668C3F_1413572110.addTaint(taint);
        return var68247D54D1DDB9E66659394CC1668C3F_1413572110;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.636 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "ABF8AC975A2BC38A032E085B01E4493E")
    @Override
    public E remove(int location) {
        addTaint(location);
        try 
        {
            ListIterator<E> it = listIterator(location);
            E result = it.next();
            it.remove();
E varDC838461EE2FA0CA4C9BBB70A15456B0_135400814 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_135400814.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_135400814;
        } //End block
        catch (NoSuchElementException e)
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1828681207 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1828681207.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1828681207;
        } //End block
        // ---------- Original Method ----------
        //try {
            //ListIterator<E> it = listIterator(location);
            //E result = it.next();
            //it.remove();
            //return result;
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.637 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "05EAB8E681A115C0D35616F8D89680FF")
    @Override
    public E set(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        ListIterator<E> it = listIterator(location);
        if(!it.hasNext())        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2043079306 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_2043079306.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_2043079306;
        } //End block
        E result = it.next();
        it.set(object);
E varDC838461EE2FA0CA4C9BBB70A15456B0_1745257710 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1745257710.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1745257710;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //if (!it.hasNext()) {
            //throw new IndexOutOfBoundsException();
        //}
        //E result = it.next();
        //it.set(object);
        //return result;
    }

    
}

