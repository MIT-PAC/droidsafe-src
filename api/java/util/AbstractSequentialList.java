package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.276 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "8ABE5E8156F04BB347DDB529BD7F304D")
    protected  AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.276 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "9C67BDB95B55F84EC870D9863D37F4CD")
    @Override
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        listIterator(location).add(object);
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.277 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "ED8920BF9B817FABC3A5AE390558DFDB")
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
        boolean varDCE3F59DDBDE54C7D50DC584BC9C6372_1225651380 = (next != it.nextIndex());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718573601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718573601;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.277 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "DDFA781A8D7AFEB1752EC1FA2C3D80BD")
    @Override
    public E get(int location) {
        addTaint(location);
        try 
        {
E var3BD6B1CAB81D050B781A92E41D17A2E1_1020777379 =             listIterator(location).next();
            var3BD6B1CAB81D050B781A92E41D17A2E1_1020777379.addTaint(taint);
            return var3BD6B1CAB81D050B781A92E41D17A2E1_1020777379;
        } //End block
        catch (NoSuchElementException e)
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_65958577 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_65958577.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_65958577;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.278 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "1B65F717BCE7BD23386192220177E5E3")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var68247D54D1DDB9E66659394CC1668C3F_1124698442 =         listIterator(0);
        var68247D54D1DDB9E66659394CC1668C3F_1124698442.addTaint(taint);
        return var68247D54D1DDB9E66659394CC1668C3F_1124698442;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
        @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.278 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "B26C223731AB95F5200ABD65F769FD20")
    @Override
    public E remove(int location) {
        addTaint(location);
        try 
        {
            ListIterator<E> it = listIterator(location);
            E result = it.next();
            it.remove();
E varDC838461EE2FA0CA4C9BBB70A15456B0_1549468751 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1549468751.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1549468751;
        } //End block
        catch (NoSuchElementException e)
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1681703859 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1681703859.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1681703859;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.279 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "2A6061689E7B03486B368AA77BDEB263")
    @Override
    public E set(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        ListIterator<E> it = listIterator(location);
    if(!it.hasNext())        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1550788142 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1550788142.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1550788142;
        } //End block
        E result = it.next();
        it.set(object);
E varDC838461EE2FA0CA4C9BBB70A15456B0_95333299 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_95333299.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_95333299;
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

