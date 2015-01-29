package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.655 -0500", hash_original_field = "D265CB2C582F6826B2ACE4E396B25CCA", hash_generated_field = "BC951AA543F9E1173730CA46C12B0D8D")

    private static final long serialVersionUID = -5024744406713321676L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.658 -0500", hash_original_field = "56E00CFDFE3E1F2E083EDAE635A1D969", hash_generated_field = "99404527879A26BB1EA746B8950DD10D")

    transient HashMap<E, HashSet<E>> backingMap;
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "04DBAE4FD4D1BE6063B2C2E36A78C25F")
    public  HashSet() {
        // ---------- Original Method ----------
    }
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "0033902E8F425F3576BA1EDD3E4839F8")
    public  HashSet(int capacity) {
        this(capacity, 0);
        // ---------- Original Method ----------
    }
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "BB398DB8539410A1C6824BFFF541668C")
    public  HashSet(int capacity, float loadFactor) {
        requestCapacity(capacity);
        // ---------- Original Method ----------
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.220 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "A6086E0532F712E31587B9655BDF6775")
    public  HashSet(Collection<? extends E> collection) {
        super.addAll(collection);
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.671 -0500", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "03A7D4D479B1CF6DDF3EDEC66129252B")
    
HashSet(HashMap<E, HashSet<E>> backingMap) {
        this.backingMap = backingMap;
    }
    
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.221 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "19EB10E26D2920921BDA436E55558712")
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        if (DroidSafeAndroidRuntime.control)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_591335645 = 
                    new AssertionError(new CloneNotSupportedException());
            varA5A331D65C8C3F32D42E49D64BCF4109_591335645.addTaint(getTaint());
            throw varA5A331D65C8C3F32D42E49D64BCF4109_591335645;
        } //End block
        HashSet<E> newSet = new HashSet<E>();
        newSet.addAll(this);
        newSet.addTaint(getTaint());
        return newSet;

        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

   @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @Override
    
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return super.getIterator();
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.224 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "07AF6EC737A10200DDD2FAF359C27B81")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(size());
for(E e : this)
        {
            stream.writeObject(e);
        } //End block
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(backingMap.table.length);
        //stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        //stream.writeInt(size());
        //for (E e : this) {
            //stream.writeObject(e);
        //}
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.224 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "E8E7D5F7F203631BFBFB53FE54177525")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int length = stream.readInt();
        int elementCount = stream.readInt();
        for(int i = elementCount;--i >= 0;)
        {
            super.add((E)stream.readObject());
        } //End block
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //int length = stream.readInt();
        //float loadFactor = stream.readFloat();
        //backingMap = createBackingMap(length, loadFactor);
        //int elementCount = stream.readInt();
        //for (int i = elementCount; --i >= 0;) {
            //E key = (E) stream.readObject();
            //backingMap.put(key, this);
        //}
    }

}

