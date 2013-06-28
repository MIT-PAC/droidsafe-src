package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.582 -0400", hash_original_method = "E95CC14AC93438CE9E4618C927D37CA8", hash_generated_method = "8ABE5E8156F04BB347DDB529BD7F304D")
    protected  AbstractSequentialList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.583 -0400", hash_original_method = "0430D75F7F3D5E3A6D5F6B220D260C02", hash_generated_method = "ADCD8F068CFC053046B1D2F36BE325B3")
    @Override
    public void add(int location, E object) {
        listIterator(location).add(object);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //listIterator(location).add(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.583 -0400", hash_original_method = "252A37CEEA1A0797639D5FF26661E00A", hash_generated_method = "B72B8BF53F675BA49FDF0DAFF778B92F")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        ListIterator<E> it = listIterator(location);
        Iterator<? extends E> colIt = collection.iterator();
        int next = it.nextIndex();
        {
            boolean var0EE731F266911FC475127E613905BD35_88734017 = (colIt.hasNext());
            {
                it.add(colIt.next());
            } //End block
        } //End collapsed parenthetic
        boolean var484A02E1107D6B0A1CEA36362FF26CBF_976056876 = (next != it.nextIndex());
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144899190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144899190;
        // ---------- Original Method ----------
        //ListIterator<E> it = listIterator(location);
        //Iterator<? extends E> colIt = collection.iterator();
        //int next = it.nextIndex();
        //while (colIt.hasNext()) {
            //it.add(colIt.next());
        //}
        //return next != it.nextIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.585 -0400", hash_original_method = "B5F59D8654788FE80539C2042F9F3DA0", hash_generated_method = "850428BA530C1F614B0D274EB7C37E1A")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1285350242 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1285350242 = listIterator(location).next();
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1285350242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285350242;
        // ---------- Original Method ----------
        //try {
            //return listIterator(location).next();
        //} catch (NoSuchElementException e) {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.586 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "17F2ABB8D26CAC324D96FBA13E11F387")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1542819083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542819083 = listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1542819083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542819083;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @Override
public abstract ListIterator<E> listIterator(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.588 -0400", hash_original_method = "F4326C1F9DDC82196649CFA76C7956BB", hash_generated_method = "3D8E495846EE48307D1E5DF407887C95")
    @Override
    public E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_739246064 = null; //Variable for return #1
        try 
        {
            ListIterator<E> it = listIterator(location);
            E result = it.next();
            it.remove();
            varB4EAC82CA7396A68D541C85D26508E83_739246064 = result;
        } //End block
        catch (NoSuchElementException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_739246064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739246064;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.589 -0400", hash_original_method = "A0691253183890C7E0DBA0D74DD52EDC", hash_generated_method = "062D112B234EF197C0D6AB4074A0F2AA")
    @Override
    public E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_1866122686 = null; //Variable for return #1
        ListIterator<E> it = listIterator(location);
        {
            boolean varF026B59EDDFD91F5680511797C117EE1_1693941473 = (!it.hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        E result = it.next();
        it.set(object);
        varB4EAC82CA7396A68D541C85D26508E83_1866122686 = result;
        addTaint(location);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1866122686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866122686;
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

