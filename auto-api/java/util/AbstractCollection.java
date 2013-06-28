package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.327 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.328 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E3FBA751A18FDE8B5CBBFB18A489CDE9")
    public boolean add(E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1420803939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1420803939;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.329 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "51C1990F1C436B8FE895831E247C973C")
    public boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        Iterator<? extends E> it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1817793558 = (it.hasNext());
            {
                {
                    boolean varD419FBFFD81CE0617C11B3FDBA63C9B1_1158209036 = (add(it.next()));
                    {
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503080846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503080846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.330 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "203A7FC22BB6B2E2B0B01AD0DB3DAA21")
    public void clear() {
        Iterator<E> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_900327432 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.330 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "E161D962C2B5D5008588E59B3F5EE7A8")
    public boolean contains(Object object) {
        Iterator<E> it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1801220057 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1054872672 = (object.equals(it.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1981619841 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1559197691 = (it.next() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737700431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737700431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.331 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "4C75DD4F65525CDB1936370A12C55236")
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1431003220 = (it.hasNext());
            {
                {
                    boolean var94905140537842B54AABAD1F53F6C23A_443701398 = (!contains(it.next()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286249222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286249222;
        // ---------- Original Method ----------
        //Iterator<?> it = collection.iterator();
        //while (it.hasNext()) {
            //if (!contains(it.next())) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.331 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "A991F464BEB10F7043188DAC13E83B03")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1739090739 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309342896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_309342896;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.332 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "9D064DFDC56E990EE3078684BCC1B8AC")
    public boolean remove(Object object) {
        Iterator<?> it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1030313192 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_2133717253 = (object.equals(it.next()));
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1141545301 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1672728831 = (it.next() == null);
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724735633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724735633;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.333 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "25602DEDD7A7313AEBF38A22D784209B")
    public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1242794088 = (it.hasNext());
            {
                {
                    boolean varFABBAF7AEB7E435B1B86400FCC1F643E_842278815 = (collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83554716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83554716;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.333 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "FA7072E998E2F08E970126FE85D7173E")
    public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        Iterator<?> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1540329169 = (it.hasNext());
            {
                {
                    boolean varAFDC73CC335BC6A433AA6F833C7683EE_244964115 = (!collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142338090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142338090;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.334 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "4CA37FA1FB1864A5BB3B73374BD3274B")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_237806684 = null; //Variable for return #1
        int size = size();
        int index = 0;
        Iterator<?> it = iterator();
        Object[] array = new Object[size];
        {
            array[index++] = it.next();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_237806684 = array;
        varB4EAC82CA7396A68D541C85D26508E83_237806684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_237806684;
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //Iterator<?> it = iterator();
        //Object[] array = new Object[size];
        //while (index < size) {
            //array[index++] = it.next();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.337 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "279433C71232125912C9A8AA4F257035")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1275894718 = null; //Variable for return #1
        int size = size();
        int index = 0;
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        {
            Iterator<E> var4DD637D8F302C571CA469E3F9C18CCC7_1102421319 = (this).iterator();
            var4DD637D8F302C571CA469E3F9C18CCC7_1102421319.hasNext();
            E entry = var4DD637D8F302C571CA469E3F9C18CCC7_1102421319.next();
            {
                contents[index++] = (T) entry;
            } //End block
        } //End collapsed parenthetic
        {
            contents[index] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1275894718 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1275894718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1275894718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.338 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "D8F8A09E4ECF415A9FCD30E6D9398960")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1211760087 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_567565447 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_1506394618 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1211760087 = "[]";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_472443946 = (it.hasNext());
            {
                Object next = it.next();
                {
                    boolean var08F9F8C2297B25F9C15AFE43367FF4A0_2118435352 = (next != this);
                    {
                        buffer.append(next);
                    } //End block
                    {
                        buffer.append("(this Collection)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1711324260 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_567565447 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_596863818; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_596863818 = varB4EAC82CA7396A68D541C85D26508E83_1211760087;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_596863818 = varB4EAC82CA7396A68D541C85D26508E83_567565447;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_596863818.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_596863818;
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

