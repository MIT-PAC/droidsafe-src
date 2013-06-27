package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.918 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.919 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "E00A38FDA04A308F301F3FA0B57088F2")
    public boolean add(E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676806398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676806398;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.919 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "272DD9BF3C0E8C1A3802ECC374692ED8")
    public boolean addAll(Collection<? extends E> collection) {
        boolean result;
        result = false;
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_734566705 = (it.hasNext());
            {
                {
                    boolean varD419FBFFD81CE0617C11B3FDBA63C9B1_1666806018 = (add(it.next()));
                    {
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891123973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891123973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.920 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "853D8BD3299C94BB3945A8FFCF1ABA40")
    public void clear() {
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_662279637 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.921 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "B88CBEC55C0F191D148A43836A3EC540")
    public boolean contains(Object object) {
        Iterator<E> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_780816262 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_550519184 = (object.equals(it.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_955366548 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1194621812 = (it.next() == null);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245515317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245515317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.921 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "81896560AEFC2D14CD2CDB9916EDF089")
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_546087733 = (it.hasNext());
            {
                {
                    boolean var94905140537842B54AABAD1F53F6C23A_800036869 = (!contains(it.next()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707817668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707817668;
        // ---------- Original Method ----------
        //Iterator<?> it = collection.iterator();
        //while (it.hasNext()) {
            //if (!contains(it.next())) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.937 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "B5175A650D5B7A547A2CBA7E0D6059CF")
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1918293391 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046512405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046512405;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.941 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "56870E014FF61FD16170E964E6BF7D11")
    public boolean remove(Object object) {
        Iterator<?> it;
        it = iterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_489937449 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1329312186 = (object.equals(it.next()));
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_807363796 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1891207995 = (it.next() == null);
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172653761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172653761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.950 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "0A6BD31C3999808443EE951A60E81C4B")
    public boolean removeAll(Collection<?> collection) {
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_819806671 = (it.hasNext());
            {
                {
                    boolean varFABBAF7AEB7E435B1B86400FCC1F643E_209455051 = (collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656079534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_656079534;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.951 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "B3E16CFAE939486C6C687ABAC8AB1F97")
    public boolean retainAll(Collection<?> collection) {
        boolean result;
        result = false;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1495760875 = (it.hasNext());
            {
                {
                    boolean varAFDC73CC335BC6A433AA6F833C7683EE_786140228 = (!collection.contains(it.next()));
                    {
                        it.remove();
                        result = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724485607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724485607;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.952 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "D0DD80218512405D07D1B42E395294BA")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_30912846 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_30912846 = array;
        varB4EAC82CA7396A68D541C85D26508E83_30912846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_30912846;
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //Iterator<?> it = iterator();
        //Object[] array = new Object[size];
        //while (index < size) {
            //array[index++] = it.next();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.965 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "1D336C0FCD21C46D80A29908D9451353")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_405477729 = null; //Variable for return #1
        int size, index;
        size = size();
        index = 0;
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        {
            Iterator<E> var4DD637D8F302C571CA469E3F9C18CCC7_1920352956 = (this).iterator();
            var4DD637D8F302C571CA469E3F9C18CCC7_1920352956.hasNext();
            E entry = var4DD637D8F302C571CA469E3F9C18CCC7_1920352956.next();
            {
                contents[index++] = (T) entry;
            } //End block
        } //End collapsed parenthetic
        {
            contents[index] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_405477729 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_405477729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_405477729;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.977 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "7099CB346D20F8FFE6200239E60632A6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1103147416 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1456030563 = null; //Variable for return #2
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_174054699 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1103147416 = "[]";
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_114362948 = (it.hasNext());
            {
                Object next;
                next = it.next();
                {
                    boolean var08F9F8C2297B25F9C15AFE43367FF4A0_652572915 = (next != this);
                    {
                        buffer.append(next);
                    } //End block
                    {
                        buffer.append("(this Collection)");
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_559642152 = (it.hasNext());
                    {
                        buffer.append(", ");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1456030563 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_1883348600; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1883348600 = varB4EAC82CA7396A68D541C85D26508E83_1103147416;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1883348600 = varB4EAC82CA7396A68D541C85D26508E83_1456030563;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1883348600.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1883348600;
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

