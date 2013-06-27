package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.762 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.763 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "4E549085A3512997229A13655EC72533")
    public boolean add(E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752073159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752073159;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.764 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "37F6032CBD5AC2CB21A6872CEAB07421")
    public boolean addAll(Collection<? extends E> collection) {
        boolean result;
        result = false;
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_142021679 = (it.hasNext());
            {
                {
                    boolean varD419FBFFD81CE0617C11B3FDBA63C9B1_1588652980 = (add(it.next()));
                    {
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708585947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708585947;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.764 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "682499D1029C9D62742A970A4364A085")
    public void clear() {
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1773691604 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.777 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "BACE32990F1AC1A5E70B85C75B6F3349")
    public boolean contains(Object object) {
        Iterator<E> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2078617462 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_842862923 = (object.equals(it.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_527162665 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_993961753 = (it.next() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23194246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_23194246;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.779 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "01DA5D5CA564E10995FFFAB0854B65E2")
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_136110505 = (it.hasNext());
            {
                {
                    boolean var94905140537842B54AABAD1F53F6C23A_1552113513 = (!contains(it.next()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359566975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_359566975;
        // ---------- Original Method ----------
        //Iterator<?> it = collection.iterator();
        //while (it.hasNext()) {
            //if (!contains(it.next())) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.779 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "19BF4537B547DFD345468893B9841305")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1289019022 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125147879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125147879;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.787 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "7250A47F62381DD5AD6D9F35D4FE49C2")
    public boolean remove(Object object) {
        Iterator<?> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1108831166 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1673159240 = (object.equals(it.next()));
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2036719250 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_61736776 = (it.next() == null);
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607277631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_607277631;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.788 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "0AF4457EEA012D35295AEE0CDEB9D865")
    public boolean removeAll(Collection<?> collection) {
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_288678319 = (it.hasNext());
            {
                {
                    boolean varFABBAF7AEB7E435B1B86400FCC1F643E_1256044811 = (collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692273307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692273307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.788 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "D611145A92FE6D19D2E02E5961CC29EF")
    public boolean retainAll(Collection<?> collection) {
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1571759571 = (it.hasNext());
            {
                {
                    boolean varAFDC73CC335BC6A433AA6F833C7683EE_1063690794 = (!collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33318122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33318122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.804 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "71AF553E81FD6E047AD9B0C178E348D3")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1654483264 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1654483264 = array;
        varB4EAC82CA7396A68D541C85D26508E83_1654483264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1654483264;
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //Iterator<?> it = iterator();
        //Object[] array = new Object[size];
        //while (index < size) {
            //array[index++] = it.next();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.807 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "ACD33677E85A0DBD2E99B5412A5CB166")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_591275597 = null; //Variable for return #1
        int size, index;
        size = size();
        index = 0;
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        {
            Iterator<E> var4DD637D8F302C571CA469E3F9C18CCC7_91803674 = (this).iterator();
            var4DD637D8F302C571CA469E3F9C18CCC7_91803674.hasNext();
            E entry = var4DD637D8F302C571CA469E3F9C18CCC7_91803674.next();
            {
                contents[index++] = (T) entry;
            } //End block
        } //End collapsed parenthetic
        {
            contents[index] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_591275597 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_591275597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_591275597;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.812 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "FB814F6AA69CC5DE53D6B821F1F8B5C2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1452012722 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1601961081 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_30100006 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1452012722 = "[]";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2099177371 = (it.hasNext());
            {
                Object next;
                next = it.next();
                {
                    boolean var08F9F8C2297B25F9C15AFE43367FF4A0_2085107594 = (next != this);
                    {
                        buffer.append(next);
                    } //End block
                    {
                        buffer.append("(this Collection)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_970939706 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1601961081 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_1881864547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1881864547 = varB4EAC82CA7396A68D541C85D26508E83_1452012722;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1881864547 = varB4EAC82CA7396A68D541C85D26508E83_1601961081;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1881864547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1881864547;
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

