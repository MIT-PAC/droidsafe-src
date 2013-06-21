package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.680 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    @DSModeled(DSC.SAFE)
    protected AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.681 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "730BA02FE922492A93F90D5EB9404E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.681 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "ACD94AB9C24066A20D5D35E806FB34FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_337647273 = (it.hasNext());
            {
                {
                    boolean varD419FBFFD81CE0617C11B3FDBA63C9B1_16948547 = (add(it.next()));
                    {
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //if (add(it.next())) {
                //result = true;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.685 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "3CA9006DDF3FA3C53CA376EBC65D2A9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1356985489 = (it.hasNext());
            {
                it.next();
                it.remove();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
            //it.next();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.686 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "C3833959EF2CDEAB4A8AAAA95B3B24E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Iterator<E> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_123796974 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_647902059 = (object.equals(it.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_886455495 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_71926614 = (it.next() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<E> it = iterator();
        //if (object != null) {
            //while (it.hasNext()) {
                //if (object.equals(it.next())) {
                    //return true;
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next() == null) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.687 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "5E3863DB4CD81CB69C7660F492395F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Iterator<?> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1931333535 = (it.hasNext());
            {
                {
                    boolean var94905140537842B54AABAD1F53F6C23A_199409302 = (!contains(it.next()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<?> it = collection.iterator();
        //while (it.hasNext()) {
            //if (!contains(it.next())) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.687 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "464B1693EA9F1C39869A8FC5F0291E0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_454403020 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.688 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "2A9DA8A7505EB5EE3747A3D65FED3F8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Iterator<?> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1061465393 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1589683337 = (object.equals(it.next()));
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_175464396 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_549870980 = (it.next() == null);
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<?> it = iterator();
        //if (object != null) {
            //while (it.hasNext()) {
                //if (object.equals(it.next())) {
                    //it.remove();
                    //return true;
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next() == null) {
                    //it.remove();
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.689 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "62D960978386B0BF154D64B2D33D0839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2137068258 = (it.hasNext());
            {
                {
                    boolean varFABBAF7AEB7E435B1B86400FCC1F643E_872332856 = (collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //if (collection.contains(it.next())) {
                //it.remove();
                //result = true;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.690 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "6DAE98B40BE41146A8221A6DBCA9E26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1964835249 = (it.hasNext());
            {
                {
                    boolean varAFDC73CC335BC6A433AA6F833C7683EE_1409567838 = (!collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //if (!collection.contains(it.next())) {
                //it.remove();
                //result = true;
            //}
        //}
        //return result;
    }

    
    public abstract int size();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.691 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "57D2058E1C771943BC7E73C728452401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        int size, index;
        size = size();
        index = 0;
        Iterator<?> it;
        it = iterator();
        Object[] array;
        array = new Object[size];
        {
            array[index++] = it.next();
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //Iterator<?> it = iterator();
        //Object[] array = new Object[size];
        //while (index < size) {
            //array[index++] = it.next();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.692 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "0E413B41C298478BA50C88BC89630711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents[0].dsTaint);
        int size, index;
        size = size();
        index = 0;
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        {
            Iterator<E> var4DD637D8F302C571CA469E3F9C18CCC7_314106595 = (this).iterator();
            var4DD637D8F302C571CA469E3F9C18CCC7_314106595.hasNext();
            E entry = var4DD637D8F302C571CA469E3F9C18CCC7_314106595.next();
            {
                contents[index++] = (T) entry;
            } //End block
        } //End collapsed parenthetic
        {
            contents[index] = null;
        } //End block
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //if (size > contents.length) {
            //Class<?> ct = contents.getClass().getComponentType();
            //contents = (T[]) Array.newInstance(ct, size);
        //}
        //for (E entry : this) {
            //contents[index++] = (T) entry;
        //}
        //if (index < contents.length) {
            //contents[index] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.692 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "0CB1CDD36FD492AD3CC0B33692DA55B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_168468518 = (isEmpty());
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_203380014 = (it.hasNext());
            {
                Object next;
                next = it.next();
                {
                    boolean var08F9F8C2297B25F9C15AFE43367FF4A0_1637272816 = (next != this);
                    {
                        buffer.append(next);
                    } //End block
                    {
                        buffer.append("(this Collection)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1757300558 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        String varAD28D02EB1C6982A5710D014292E1955_972632184 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isEmpty()) {
            //return "[]";
        //}
        //StringBuilder buffer = new StringBuilder(size() * 16);
        //buffer.append('[');
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object next = it.next();
            //if (next != this) {
                //buffer.append(next);
            //} else {
                //buffer.append("(this Collection)");
            //}
            //if (it.hasNext()) {
                //buffer.append(", ");
            //}
        //}
        //buffer.append(']');
        //return buffer.toString();
    }

    
}

