package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Array;

public abstract class AbstractCollection<E> implements Collection<E> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.047 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.047 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "A114617378D32729BFE7D1C819C15DF3")
    public boolean add(E object) {
        addTaint(object.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1460897719 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1460897719.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1460897719;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.048 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "70A3798F0B73EF4C2435D51F579FFF1D")
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean result = false;
        Iterator<? extends E> it = collection.iterator();
        while
(it.hasNext())        
        {
    if(add(it.next()))            
            {
                result = true;
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_13280711 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207794772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207794772;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.048 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "94B53645345716ACF0F00CE71C5A8EA8")
    public void clear() {
        Iterator<E> it = iterator();
        while
(it.hasNext())        
        {
            it.next();
            it.remove();
        } //End block
        // ---------- Original Method ----------
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
            //it.next();
            //it.remove();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.049 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "637418171667F96BDEF9382693524FB2")
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        Iterator<E> it = iterator();
    if(object != null)        
        {
            while
(it.hasNext())            
            {
    if(object.equals(it.next()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_700658365 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316397136 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316397136;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
    if(it.next() == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1082852125 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478593683 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_478593683;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1483979425 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86940558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86940558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.050 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "FC1E369372E1EB517DCC93DB82651263")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        Iterator<?> it = collection.iterator();
        while
(it.hasNext())        
        {
    if(!contains(it.next()))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1988492340 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135794869 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135794869;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1740847927 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116367607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116367607;
        // ---------- Original Method ----------
        //Iterator<?> it = collection.iterator();
        //while (it.hasNext()) {
            //if (!contains(it.next())) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.050 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "477EA4B527BCCFE5782FABA6CAC8C711")
    public boolean isEmpty() {
        boolean var5BD3446419BAE72903C4742BF777F0E0_295279526 = (size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807861197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807861197;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    public abstract Iterator<E> iterator();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.051 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "5E9E4A49FB4A959E58C9DA17674F23A0")
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        Iterator<?> it = iterator();
    if(object != null)        
        {
            while
(it.hasNext())            
            {
    if(object.equals(it.next()))                
                {
                    it.remove();
                    boolean varB326B5062B2F0E69046810717534CB09_1772053647 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223974704 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223974704;
                } //End block
            } //End block
        } //End block
        else
        {
            while
(it.hasNext())            
            {
    if(it.next() == null)                
                {
                    it.remove();
                    boolean varB326B5062B2F0E69046810717534CB09_1850678216 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473487660 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473487660;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1278571816 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070136214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070136214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.052 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "08CD40785EAA51B2F60539092E3ADDE6")
    public boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean result = false;
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
    if(collection.contains(it.next()))            
            {
                it.remove();
                result = true;
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_109866880 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213035906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213035906;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.052 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "5038FC3BAD581737B87256D522D17328")
    public boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean result = false;
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
    if(!collection.contains(it.next()))            
            {
                it.remove();
                result = true;
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1021871721 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1673770210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1673770210;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.053 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "0AA4F87D074615A07B366AB245BE2216")
    public Object[] toArray() {
        int size = size();
        int index = 0;
        Iterator<?> it = iterator();
        Object[] array = new Object[size];
        while
(index < size)        
        {
            array[index++] = it.next();
        } //End block
Object[] var1270D5B74B756F17D644A15D775499D9_1751470086 =         array;
        var1270D5B74B756F17D644A15D775499D9_1751470086.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_1751470086;
        // ---------- Original Method ----------
        //int size = size(), index = 0;
        //Iterator<?> it = iterator();
        //Object[] array = new Object[size];
        //while (index < size) {
            //array[index++] = it.next();
        //}
        //return array;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.053 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "40078E6FA41D90A0787717335A7627BD")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        addTaint(contents[0].getTaint());
        int size = size();
        int index = 0;
    if(size > contents.length)        
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
for(E entry : this)
        {
            contents[index++] = (T) entry;
        } //End block
    if(index < contents.length)        
        {
            contents[index] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_1564238356 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_1564238356.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_1564238356;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.054 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "939C6603D1775F2DC0196C175FC77A69")
    @Override
    public String toString() {
    if(isEmpty())        
        {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_8866396 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_8866396.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_8866396;
        } //End block
        StringBuilder buffer = new StringBuilder(size() * 16);
        buffer.append('[');
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
            Object next = it.next();
    if(next != this)            
            {
                buffer.append(next);
            } //End block
            else
            {
                buffer.append("(this Collection)");
            } //End block
    if(it.hasNext())            
            {
                buffer.append(", ");
            } //End block
        } //End block
        buffer.append(']');
String varD03843288D33B9E1D3062E25339ECF6D_119997437 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_119997437.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_119997437;
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

