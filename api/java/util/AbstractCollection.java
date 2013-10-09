package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.lang.reflect.Array;





public abstract class AbstractCollection<E> implements Collection<E> {
    
    protected E[] collectionData = (E[])new Object[1]; 
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.345 -0400", hash_original_method = "2CD999E5665A4C31F4601D44982C7C04", hash_generated_method = "80ABF1E4206482266414E558C3C72331")
    protected  AbstractCollection() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.345 -0400", hash_original_method = "1E7EFCC2BAD401EE702FAECD906F0B57", hash_generated_method = "8275414EBF339E8E1A38339518310828")
    public boolean add(E object) {
        collectionData[0] = object;
        addTaint(object.getTaint());
        return getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "906569C65C760B9885981A6BAAEC834D", hash_generated_method = "3A9BC82846A9A65648AEDC64EA165A5D")
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean result = false;
        Iterator<? extends E> it = collection.iterator();
        add(it.next());
        
        return getTaintBoolean();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.346 -0400", hash_original_method = "2F749DB5FEA27C5D543B69C11E8665E6", hash_generated_method = "94B53645345716ACF0F00CE71C5A8EA8")
    public void clear() {
        collectionData[0] = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.347 -0400", hash_original_method = "9D755B12CFAC53130BB68496AAAEDB9E", hash_generated_method = "AB29316BF38F2A7F7FF285294AD0586B")
    public boolean contains(Object object) {
        Object retObj = new Object();
        retObj.addTaint(getTaintBoolean());
        retObj.addTaint(object.getTaint());
        return retObj.getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "5E0F818F4852B6FE376F87B40084BB49", hash_generated_method = "D9488CE0E9092353E75E56A47831CB4C")
    public boolean containsAll(Collection<?> collection) {
        Object retObj = new Object();
        retObj.addTaint(getTaintBoolean());
        retObj.addTaint(collection.getTaint());
        return retObj.getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.348 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "8CE042654B5192EFCE000048B14B8C75")
    public boolean isEmpty() {
            return getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Iterator<E> iterator();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.349 -0400", hash_original_method = "CCD29C39CF9628BFB1346470270188CD", hash_generated_method = "FCC356F1E2BB914CD3D0E5867CDC0F78")
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        return getTaintBoolean();
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.351 -0400", hash_original_method = "5FB46A3D49E2925CCD326CF5A4A19DE1", hash_generated_method = "F4694D15E6EF1ADFE917C25C5B193155")
    public boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        return getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.352 -0400", hash_original_method = "AD8A452252ABBE37E452278A3F0D2AEC", hash_generated_method = "750649923756B11C00466003C8100284")
    public boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        return getTaintBoolean();
    }

    
    @DSModeled(DSC.SAFE)
    public int size() {
        return getTaintInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.354 -0400", hash_original_method = "678F4AFF67E7BF51A720327536D164F3", hash_generated_method = "C6CD7F0B998F77F8945194CAF8E4BBFE")
    public Object[] toArray() {
        int size = size();
        int index = 0;
        Iterator<?> it = iterator();
        Object[] array = new Object[1];
        array[0] = it.next();
        
        return array;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.356 -0400", hash_original_method = "A29AB27B8881BCEC42B6770CA33A7C59", hash_generated_method = "97B4512438CD40845A961D9D17114AEE")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {

        contents.addTaint(getTaint());

        int size = size();
        int index = 0;

        contents[0] = (T)collectionData[0];
        return contents; 
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

    @DSModeled(DSC.BAN)
    protected E getElement(int index) {
        if (DroidSafeAndroidRuntime.control) {
            return null;
        }

        collectionData[0].addTaint(index);
        return collectionData[0];
    }
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.357 -0400", hash_original_method = "A06C3538162F748E28317896970387BE", hash_generated_method = "22C4F41EBA3A6ACE287F6D60148ADCF8")
    @Override
    public String toString() {
        String retStr = new String("[]");
        retStr.addTaint(getTaint());
        return retStr;
    }

    
}

