package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.265 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "8ABE5E8156F04BB347DDB529BD7F304D")
    protected  AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.265 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "ADCD8F068CFC053046B1D2F36BE325B3")
    @Override
    public void add(int location, E object) {
        listIterator(location).add(object);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.265 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "363C093CF047AE1CD5BB2F884CF4DF3E")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        ListIterator<E> it;
        it = listIterator(location);
        Iterator<? extends E> colIt;
        colIt = collection.iterator();
        int next;
        next = it.nextIndex();
        {
            boolean var0EE731F266911FC475127E613905BD35_725000328 = (colIt.hasNext());
            {
                it.add(colIt.next());
            } //End block
        } //End collapsed parenthetic
        boolean var484A02E1107D6B0A1CEA36362FF26CBF_1959916869 = (next != it.nextIndex());
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923339379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923339379;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.266 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "9F2C41CE4C96424BA21A3CCE437E2A10")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_696907650 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_696907650 = listIterator(location).next();
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_696907650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_696907650;
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.266 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "707DF8A180C826768207D6D77C00DC89")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1403542661 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1403542661 = listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1403542661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1403542661;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
        @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.267 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "B811B1E9A3C0804C65ECBA8AE4BF021A")
    @Override
    public E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_522141473 = null; //Variable for return #1
        try 
        {
            ListIterator<E> it;
            it = listIterator(location);
            E result;
            result = it.next();
            it.remove();
            varB4EAC82CA7396A68D541C85D26508E83_522141473 = result;
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_522141473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_522141473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.285 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "D6D55AB5FA9E2DD5F73BA16000B8B8FE")
    @Override
    public E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_709210024 = null; //Variable for return #1
        ListIterator<E> it;
        it = listIterator(location);
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_1879990106 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        E result;
        result = it.next();
        it.set(object);
        varB4EAC82CA7396A68D541C85D26508E83_709210024 = result;
        addTaint(location);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_709210024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_709210024;
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

