package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.316 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "5F4C3A792A1DEBADF6983559A94E2F39")
    @DSModeled(DSC.SAFE)
    protected AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.339 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "88D059D94C1CE07E27B70D19D0F88095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        listIterator(location).add(object);
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.371 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "FB29C0708614AB04265DC9C4337F414F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(collection.dsTaint);
        ListIterator<E> it;
        it = listIterator(location);
        Iterator<? extends E> colIt;
        colIt = collection.iterator();
        int next;
        next = it.nextIndex();
        {
            boolean var0EE731F266911FC475127E613905BD35_1909641112 = (colIt.hasNext());
            {
                it.add(colIt.next());
            } //End block
        } //End collapsed parenthetic
        boolean var484A02E1107D6B0A1CEA36362FF26CBF_324716954 = (next != it.nextIndex());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.391 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "DE4EFE37E760B2D33F737306793EBC4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public E get(int location) {
        dsTaint.addTaint(location);
        try 
        {
            E var0ABA720A477921A27C74FA604442724D_1652631119 = (listIterator(location).next());
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.409 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "E0D8D598A1BA44CB5EA7CAD0889F66E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var7D4BA5CF674C03655AF029B888825291_1143849148 = (listIterator(0));
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
        @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.421 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "1C1054EFAFA5886B47B2DDA54B1BDC0B")
    @DSModeled(DSC.SAFE)
    @Override
    public E remove(int location) {
        dsTaint.addTaint(location);
        try 
        {
            ListIterator<E> it;
            it = listIterator(location);
            E result;
            result = it.next();
            it.remove();
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return (E)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:17:42.441 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "911FF02BBB9DA4DBC0E1214248714191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public E set(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        ListIterator<E> it;
        it = listIterator(location);
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_1518174929 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        E result;
        result = it.next();
        it.set(object);
        return (E)dsTaint.getTaint();
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


