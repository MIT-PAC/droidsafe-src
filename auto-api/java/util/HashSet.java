package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.053 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "99404527879A26BB1EA746B8950DD10D")

    transient HashMap<E, HashSet<E>> backingMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.059 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "04DBAE4FD4D1BE6063B2C2E36A78C25F")
    public  HashSet() {
        this(new HashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.059 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "0033902E8F425F3576BA1EDD3E4839F8")
    public  HashSet(int capacity) {
        this(new HashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.063 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "335DAFDCA9305BA5897EE09A4F78D44A")
    public  HashSet(int capacity, float loadFactor) {
        this(new HashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(capacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.066 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "303D188713E7D9EAD554E3BBE0BBC6D1")
    public  HashSet(Collection<? extends E> collection) {
        this(new HashMap<E, HashSet<E>>(collection.size() < 6 ? 11 : collection
                .size() * 2));
        {
            Iterator<E> var6348CF19B474F5ACF72F267EFA7F4363_788156328 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_788156328.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_788156328.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.067 -0400", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "D7B41D5A1CE8285E2C28BDFFB6A190DA")
      HashSet(HashMap<E, HashSet<E>> backingMap) {
        this.backingMap = backingMap;
        // ---------- Original Method ----------
        //this.backingMap = backingMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.067 -0400", hash_original_method = "13469234005B95B45B060FD6999EEF09", hash_generated_method = "D890331E75755B9319D0470148152620")
    @Override
    public boolean add(E object) {
        boolean var8C10435A54E49E00A369089D9EF8265A_1893901854 = (backingMap.put(object, this) == null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368489940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368489940;
        // ---------- Original Method ----------
        //return backingMap.put(object, this) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.067 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.068 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "29CADA406337CCC2FE80F1468C55C205")
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1404980067 = null; //Variable for return #1
        try 
        {
            HashSet<E> clone;
            clone = (HashSet<E>) super.clone();
            clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1404980067 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1404980067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1404980067;
        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.068 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "97FDFF2B73A04C3FF6E632ACE7B9EBF8")
    @Override
    public boolean contains(Object object) {
        boolean var8C8A172B56440FCA5388504D06A94C78_1993838490 = (backingMap.containsKey(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_137527274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_137527274;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.082 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "EB3D0EAB982CA029CE883C7EFE719EEB")
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_233720499 = (backingMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809275352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809275352;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.083 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "E935D5844F85649102F1F60B23B110AA")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_646884469 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_646884469 = backingMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_646884469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646884469;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.083 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "F976512E0905E771FE4A4B7FB8A97DB3")
    @Override
    public boolean remove(Object object) {
        boolean var98D11DCD88E6747113E0C18E00445AFD_1262992727 = (backingMap.remove(object) != null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473075589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473075589;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.089 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "9C0D63D8208D5CAFC02EFC8883329EFC")
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_128191937 = (backingMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143112233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143112233;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.104 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "50339D8CCE769146CE638E5697846B18")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(backingMap.table.length);
        stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        stream.writeInt(size());
        {
            Iterator<E> varF53DB431B37C2EB2948461201BCC5EF5_493900253 = (this).iterator();
            varF53DB431B37C2EB2948461201BCC5EF5_493900253.hasNext();
            E e = varF53DB431B37C2EB2948461201BCC5EF5_493900253.next();
            {
                stream.writeObject(e);
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(backingMap.table.length);
        //stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        //stream.writeInt(size());
        //for (E e : this) {
            //stream.writeObject(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.115 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "D975DF21C06E9315E811BE7884643227")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        int length;
        length = stream.readInt();
        float loadFactor;
        loadFactor = stream.readFloat();
        backingMap = createBackingMap(length, loadFactor);
        int elementCount;
        elementCount = stream.readInt();
        {
            int i;
            i = elementCount;
            {
                E key;
                key = (E) stream.readObject();
                backingMap.put(key, this);
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.119 -0400", hash_original_method = "A913AB5E1402F7BC175E965B0D92FA39", hash_generated_method = "AE9130CD5581F955058332A0F8E0E6B6")
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        HashMap<E, HashSet<E>> varB4EAC82CA7396A68D541C85D26508E83_2081492184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2081492184 = new HashMap<E, HashSet<E>>(capacity, loadFactor);
        addTaint(capacity);
        addTaint(loadFactor);
        varB4EAC82CA7396A68D541C85D26508E83_2081492184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081492184;
        // ---------- Original Method ----------
        //return new HashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.119 -0400", hash_original_field = "4D66001BAF5FE309F557CB508088A454", hash_generated_field = "6FF1E6F69A9C336166B177237CF37B80")

    private static long serialVersionUID = -5024744406713321676L;
}

