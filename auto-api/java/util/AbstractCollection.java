package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.238 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "400E6B1B9CB7E5D415E5EB2C1F7F2665")
    @DSModeled(DSC.SAFE)
    protected AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.238 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E0512E7C2DEDDEDC8B6D20436A44D793")
    @DSModeled(DSC.SAFE)
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
        	throw new UnsupportedOperationException();
        }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "414D6259AC58B8033C33AF5C85738E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_564019102 = (it.hasNext());
            {
                {
                    boolean varD419FBFFD81CE0617C11B3FDBA63C9B1_579882662 = (add(it.next()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "8082EBFCFA51D6C9FE528B345C851DAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1276552283 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "2E7845912BEB97D3712F1932BAD31435")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Iterator<E> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1668160795 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_324359052 = (object.equals(it.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_394780768 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1555061478 = (it.next() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "C91ECCE463F9BF6A8AAB2C6F08BC1C28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Iterator<?> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_136755552 = (it.hasNext());
            {
                {
                    boolean var94905140537842B54AABAD1F53F6C23A_566945397 = (!contains(it.next()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "5CD604CBF389CC61986E3D2D6AE76D8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_144676049 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "D5FAAC7C4FFB576319955D02F7BEBBDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Iterator<?> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_142712593 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1678849990 = (object.equals(it.next()));
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1202668624 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1355340257 = (it.next() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "F3080E6449A8027BAF48272BB6E66105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1910738725 = (it.hasNext());
            {
                {
                    boolean varFABBAF7AEB7E435B1B86400FCC1F643E_627920995 = (collection.contains(it.next()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "F2A0825FA581E4E287AB7578B42F727D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1435596676 = (it.hasNext());
            {
                {
                    boolean varAFDC73CC335BC6A433AA6F833C7683EE_1385543782 = (!collection.contains(it.next()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.239 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "CE1AE55D1C71A6242DA244E2333DB9CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.240 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "24AFE903A81422EEDB18DCE247588FC3")
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
            Iterator<E> seatecAstronomy42 = this.iterator();
            seatecAstronomy42.hasNext();
            E entry = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.240 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "63973E54D1A77058F38A7E69DE0A06E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_829322968 = (isEmpty());
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_364571335 = (it.hasNext());
            {
                Object next;
                next = it.next();
                {
                    buffer.append(next);
                } //End block
                {
                    buffer.append("(this Collection)");
                } //End block
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1465308870 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        String varAD28D02EB1C6982A5710D014292E1955_1255599408 = (buffer.toString());
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


