package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.314 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "8ABE5E8156F04BB347DDB529BD7F304D")
    protected  AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.315 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "ADCD8F068CFC053046B1D2F36BE325B3")
    @Override
    public void add(int location, E object) {
        listIterator(location).add(object);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.325 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "B8BB42D2E15C3581EE40B8C883B2A5AB")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        ListIterator<E> it;
        it = listIterator(location);
        Iterator<? extends E> colIt;
        colIt = collection.iterator();
        int next;
        next = it.nextIndex();
        {
            boolean var0EE731F266911FC475127E613905BD35_423082217 = (colIt.hasNext());
            {
                it.add(colIt.next());
            } //End block
        } //End collapsed parenthetic
        boolean var484A02E1107D6B0A1CEA36362FF26CBF_1623889076 = (next != it.nextIndex());
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873429562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873429562;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.326 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "1CD5815CB3D616ED7F6AA079E8619400")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_2126663940 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2126663940 = listIterator(location).next();
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_2126663940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2126663940;
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.326 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "A92467391EEFF25BBF6FBCCC92251231")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1980721645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1980721645 = listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1980721645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980721645;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
        @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.335 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "3AFAF41728F26D787C1DDAE4ED705882")
    @Override
    public E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_247412440 = null; //Variable for return #1
        try 
        {
            ListIterator<E> it;
            it = listIterator(location);
            E result;
            result = it.next();
            it.remove();
            varB4EAC82CA7396A68D541C85D26508E83_247412440 = result;
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_247412440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_247412440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.335 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "8CAE425DF00EDB58639F87C8B8A8B89E")
    @Override
    public E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_444855040 = null; //Variable for return #1
        ListIterator<E> it;
        it = listIterator(location);
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_1673591706 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        E result;
        result = it.next();
        it.set(object);
        varB4EAC82CA7396A68D541C85D26508E83_444855040 = result;
        addTaint(location);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_444855040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_444855040;
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

