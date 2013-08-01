package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "99404527879A26BB1EA746B8950DD10D")

    transient HashMap<E, HashSet<E>> backingMap;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "04DBAE4FD4D1BE6063B2C2E36A78C25F")
    public  HashSet() {
        this(new HashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "0033902E8F425F3576BA1EDD3E4839F8")
    public  HashSet(int capacity) {
        this(new HashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.219 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "BB398DB8539410A1C6824BFFF541668C")
    public  HashSet(int capacity, float loadFactor) {
        this(new HashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(loadFactor);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.220 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "A6086E0532F712E31587B9655BDF6775")
    public  HashSet(Collection<? extends E> collection) {
        this(new HashMap<E, HashSet<E>>(collection.size() < 6 ? 11 : collection
                .size() * 2));
        addTaint(collection.getTaint());
for(E e : collection)
        {
            add(e);
        } //End block
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.220 -0400", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "D7B41D5A1CE8285E2C28BDFFB6A190DA")
      HashSet(HashMap<E, HashSet<E>> backingMap) {
        this.backingMap = backingMap;
        // ---------- Original Method ----------
        //this.backingMap = backingMap;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.220 -0400", hash_original_method = "13469234005B95B45B060FD6999EEF09", hash_generated_method = "E5E5F92C2A0579C7CB77AEAF55E8408D")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        boolean varB37ED058D94FA6058F37722FFE9EDE85_1165535556 = (backingMap.put(object, this) == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1505654864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1505654864;
        // ---------- Original Method ----------
        //return backingMap.put(object, this) == null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.221 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.221 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "19EB10E26D2920921BDA436E55558712")
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        try 
        {
            HashSet<E> clone = (HashSet<E>) super.clone();
            clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_1471403832 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_1471403832.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_1471403832;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_591335645 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_591335645.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_591335645;
        } //End block
        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.222 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "3AD948D84603C57E67B6EDC59D8DE05C")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        boolean varCF24D41E57936BE41D5FE9FB10A983AA_2040148243 = (backingMap.containsKey(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2088412944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2088412944;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.222 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "52065E8B6A8D605D72A2B0E9497CA115")
    @Override
    public boolean isEmpty() {
        boolean var7BD8146BDE90DE51E94F2CB6ADD61030_1800170717 = (backingMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845034422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845034422;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.222 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "299D67C2421138B7C16C9D2BB5FC64BA")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var286E0827A1FF5574E4CA8F3B053AEA56_1723938179 =         backingMap.keySet().iterator();
        var286E0827A1FF5574E4CA8F3B053AEA56_1723938179.addTaint(taint);
        return var286E0827A1FF5574E4CA8F3B053AEA56_1723938179;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.223 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "19D968250F896BACBBF4F3532F232338")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean varB16028B3BA82A3A21D2A6955BEBAAB22_2136022144 = (backingMap.remove(object) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_419597098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_419597098;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.223 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "370967D43C6365E9EBA3BE42D91138F7")
    @Override
    public int size() {
        int var6EE8E77D231E7BE340B3674D400AE2A8_1934951283 = (backingMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308181530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308181530;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.224 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "07AF6EC737A10200DDD2FAF359C27B81")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeInt(backingMap.table.length);
        stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.224 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "E8E7D5F7F203631BFBFB53FE54177525")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        int length = stream.readInt();
        float loadFactor = stream.readFloat();
        backingMap = createBackingMap(length, loadFactor);
        int elementCount = stream.readInt();
for(int i = elementCount;--i >= 0;)
        {
            E key = (E) stream.readObject();
            backingMap.put(key, this);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.225 -0400", hash_original_method = "A913AB5E1402F7BC175E965B0D92FA39", hash_generated_method = "E9EDCB8FA21CB01CE2C6E9762136EF19")
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        addTaint(loadFactor);
        addTaint(capacity);
HashMap<E, HashSet<E>> var85C66807696EE1875C9DA1403A9E294E_877747071 =         new HashMap<E, HashSet<E>>(capacity, loadFactor);
        var85C66807696EE1875C9DA1403A9E294E_877747071.addTaint(taint);
        return var85C66807696EE1875C9DA1403A9E294E_877747071;
        // ---------- Original Method ----------
        //return new HashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.225 -0400", hash_original_field = "4D66001BAF5FE309F557CB508088A454", hash_generated_field = "BC951AA543F9E1173730CA46C12B0D8D")

    private static final long serialVersionUID = -5024744406713321676L;
}

