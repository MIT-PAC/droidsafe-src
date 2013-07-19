package java.util;

// Droidsafe Imports
import java.lang.reflect.Array;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractCollection<E> implements Collection<E> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.345 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.345 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "8275414EBF339E8E1A38339518310828")
    public boolean add(E object) {
        addTaint(object.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1984333619 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1984333619.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1984333619;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "3A9BC82846A9A65648AEDC64EA165A5D")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_648585465 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193761576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193761576;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "94B53645345716ACF0F00CE71C5A8EA8")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.347 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "AB29316BF38F2A7F7FF285294AD0586B")
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
                    boolean varB326B5062B2F0E69046810717534CB09_1244161483 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535261946 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535261946;
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
                    boolean varB326B5062B2F0E69046810717534CB09_143276630 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802963202 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802963202;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_427685386 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626408242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626408242;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "D9488CE0E9092353E75E56A47831CB4C")
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        Iterator<?> it = collection.iterator();
        while
(it.hasNext())        
        {
            if(!contains(it.next()))            
            {
                boolean var68934A3E9455FA72420237EB05902327_282273095 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27235130 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_27235130;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_396343774 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572878122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572878122;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "8CE042654B5192EFCE000048B14B8C75")
    public boolean isEmpty() {
        boolean var5BD3446419BAE72903C4742BF777F0E0_1712269304 = (size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478885786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_478885786;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Iterator<E> iterator();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.349 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "FCC356F1E2BB914CD3D0E5867CDC0F78")
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
                    boolean varB326B5062B2F0E69046810717534CB09_1976910338 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332761911 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_332761911;
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
                    boolean varB326B5062B2F0E69046810717534CB09_375563078 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536357291 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536357291;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1099241442 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375029888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375029888;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.351 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "F4694D15E6EF1ADFE917C25C5B193155")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_474719917 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461171683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461171683;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.352 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "750649923756B11C00466003C8100284")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_1063039215 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649675719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649675719;
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

    
    @DSModeled(DSC.SAFE)
    public abstract int size();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.354 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "C6CD7F0B998F77F8945194CAF8E4BBFE")
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
Object[] var1270D5B74B756F17D644A15D775499D9_462919410 =         array;
        var1270D5B74B756F17D644A15D775499D9_462919410.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_462919410;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.356 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "97B4512438CD40845A961D9D17114AEE")
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
T[] var5DC9C33EDB9F81CF1216538024B770BE_1118308226 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_1118308226.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_1118308226;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.357 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "22C4F41EBA3A6ACE287F6D60148ADCF8")
    @Override
    public String toString() {
        if(isEmpty())        
        {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_1514229682 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_1514229682.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_1514229682;
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
String varD03843288D33B9E1D3062E25339ECF6D_11347575 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_11347575.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_11347575;
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

