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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.112 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "99404527879A26BB1EA746B8950DD10D")

    transient HashMap<E, HashSet<E>> backingMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.122 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "04DBAE4FD4D1BE6063B2C2E36A78C25F")
    public  HashSet() {
        this(new HashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.129 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "0033902E8F425F3576BA1EDD3E4839F8")
    public  HashSet(int capacity) {
        this(new HashMap<E, HashSet<E>>(capacity));
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.133 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "335DAFDCA9305BA5897EE09A4F78D44A")
    public  HashSet(int capacity, float loadFactor) {
        this(new HashMap<E, HashSet<E>>(capacity, loadFactor));
        addTaint(capacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.149 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "04FA3283DD048E44B630EFD785EDADD7")
    public  HashSet(Collection<? extends E> collection) {
        this(new HashMap<E, HashSet<E>>(collection.size() < 6 ? 11 : collection
                .size() * 2));
        {
            Iterator<E> var6348CF19B474F5ACF72F267EFA7F4363_713636677 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_713636677.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_713636677.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.156 -0400", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "D7B41D5A1CE8285E2C28BDFFB6A190DA")
      HashSet(HashMap<E, HashSet<E>> backingMap) {
        this.backingMap = backingMap;
        // ---------- Original Method ----------
        //this.backingMap = backingMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.157 -0400", hash_original_method = "13469234005B95B45B060FD6999EEF09", hash_generated_method = "720E4A40C187F21E200A35AD2CEA9BC4")
    @Override
    public boolean add(E object) {
        boolean var8C10435A54E49E00A369089D9EF8265A_608738394 = (backingMap.put(object, this) == null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211582922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211582922;
        // ---------- Original Method ----------
        //return backingMap.put(object, this) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.157 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.167 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "8D68FA5F93715873D4A788C892D634C5")
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_67232622 = null; //Variable for return #1
        try 
        {
            HashSet<E> clone;
            clone = (HashSet<E>) super.clone();
            clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            varB4EAC82CA7396A68D541C85D26508E83_67232622 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_67232622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_67232622;
        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.167 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "E21B7223EE8B5A9C9AAC7A13BE2DC78F")
    @Override
    public boolean contains(Object object) {
        boolean var8C8A172B56440FCA5388504D06A94C78_1011055376 = (backingMap.containsKey(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489072014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489072014;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.168 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "B4BE33E7B6DC7A9C9CD8B15AD2AC6F39")
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_629049238 = (backingMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575774064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575774064;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.191 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "B92FDA46B223FB5C5A24AEF510A07506")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2114428853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114428853 = backingMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_2114428853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114428853;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.192 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "DB8F6036B17F16BE9B31ED956C702E84")
    @Override
    public boolean remove(Object object) {
        boolean var98D11DCD88E6747113E0C18E00445AFD_1484896731 = (backingMap.remove(object) != null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859584682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859584682;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.193 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "6252F1A5856ECAB6FAA45F64828807C6")
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_1303249575 = (backingMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133027448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133027448;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.217 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "5D299D62501FFE8E16AA6BD25E6C33EE")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(backingMap.table.length);
        stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        stream.writeInt(size());
        {
            Iterator<E> varF53DB431B37C2EB2948461201BCC5EF5_161328739 = (this).iterator();
            varF53DB431B37C2EB2948461201BCC5EF5_161328739.hasNext();
            E e = varF53DB431B37C2EB2948461201BCC5EF5_161328739.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.219 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "D975DF21C06E9315E811BE7884643227")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.219 -0400", hash_original_method = "A913AB5E1402F7BC175E965B0D92FA39", hash_generated_method = "14CD0741AB935DD7C31D9933A50A5F17")
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        HashMap<E, HashSet<E>> varB4EAC82CA7396A68D541C85D26508E83_2025864555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025864555 = new HashMap<E, HashSet<E>>(capacity, loadFactor);
        addTaint(capacity);
        addTaint(loadFactor);
        varB4EAC82CA7396A68D541C85D26508E83_2025864555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025864555;
        // ---------- Original Method ----------
        //return new HashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:51.219 -0400", hash_original_field = "4D66001BAF5FE309F557CB508088A454", hash_generated_field = "6FF1E6F69A9C336166B177237CF37B80")

    private static long serialVersionUID = -5024744406713321676L;
}

