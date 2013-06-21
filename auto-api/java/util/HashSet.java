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
    transient HashMap<E, HashSet<E>> backingMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.403 -0400", hash_original_method = "E33F776FDE5FB34265D051C43B067D53", hash_generated_method = "04DBAE4FD4D1BE6063B2C2E36A78C25F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet() {
        this(new HashMap<E, HashSet<E>>());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.403 -0400", hash_original_method = "99449DF656D31D85FA19BFCB5BF76454", hash_generated_method = "888B76EEA0744EFC7A1401D8F26AAF22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(int capacity) {
        this(new HashMap<E, HashSet<E>>(capacity));
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.403 -0400", hash_original_method = "200669CE849E0E6EB4D645D70DC42C60", hash_generated_method = "291DB41A001E0E8FCC9463BECC5785A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(int capacity, float loadFactor) {
        this(new HashMap<E, HashSet<E>>(capacity, loadFactor));
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.404 -0400", hash_original_method = "B287B339899074AD24911C01E3E019EA", hash_generated_method = "EC7CA0F29F4C634DCDB1CF52227C19D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashSet(Collection<? extends E> collection) {
        this(new HashMap<E, HashSet<E>>(collection.size() < 6 ? 11 : collection
                .size() * 2));
        dsTaint.addTaint(collection.dsTaint);
        {
            Iterator<E> var6348CF19B474F5ACF72F267EFA7F4363_1744024759 = (collection).iterator();
            var6348CF19B474F5ACF72F267EFA7F4363_1744024759.hasNext();
            E e = var6348CF19B474F5ACF72F267EFA7F4363_1744024759.next();
            {
                add(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (E e : collection) {
            //add(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.404 -0400", hash_original_method = "03A7D4D479B1CF6DDF3EDEC66129252B", hash_generated_method = "A10E7F3F6A94184D1D4A27D62DC765BB")
    @DSModeled(DSC.SAFE)
     HashSet(HashMap<E, HashSet<E>> backingMap) {
        dsTaint.addTaint(backingMap.dsTaint);
        // ---------- Original Method ----------
        //this.backingMap = backingMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.404 -0400", hash_original_method = "13469234005B95B45B060FD6999EEF09", hash_generated_method = "0BA24F0770E4DFA1B1BAF792F48AEE6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var8C10435A54E49E00A369089D9EF8265A_1062052117 = (backingMap.put(object, this) == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.put(object, this) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.405 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.405 -0400", hash_original_method = "955CE9C49A99D547E9A8BE3B956E5B23", hash_generated_method = "76189558960F20C467E2497652B62621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        try 
        {
            HashSet<E> clone;
            clone = (HashSet<E>) super.clone();
            clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //HashSet<E> clone = (HashSet<E>) super.clone();
            //clone.backingMap = (HashMap<E, HashSet<E>>) backingMap.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.405 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "B02379D88CA1FF159D3F5655E96BDC96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var8C8A172B56440FCA5388504D06A94C78_2023029952 = (backingMap.containsKey(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.405 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "B040A9AC81CC60853EABF9BED37FC5AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_1306249455 = (backingMap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.405 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "B64AF4FF6A208E669887505865946D62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var293C31D1F85E54807389D3B230374261_2130590745 = (backingMap.keySet().iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.406 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "AA80DB7280F877A356306324C9B666B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var98D11DCD88E6747113E0C18E00445AFD_35469892 = (backingMap.remove(object) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.406 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "123AB0C34E89E1DFABA0AFD7C78D9958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_1984528820 = (backingMap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.408 -0400", hash_original_method = "338B1A875F3BC7E4991A09D0F5CEB0AA", hash_generated_method = "5513E6164DA5E62887B4628AEF828721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(backingMap.table.length);
        stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        stream.writeInt(size());
        {
            Iterator<E> varF53DB431B37C2EB2948461201BCC5EF5_16741309 = (this).iterator();
            varF53DB431B37C2EB2948461201BCC5EF5_16741309.hasNext();
            E e = varF53DB431B37C2EB2948461201BCC5EF5_16741309.next();
            {
                stream.writeObject(e);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(backingMap.table.length);
        //stream.writeFloat(HashMap.DEFAULT_LOAD_FACTOR);
        //stream.writeInt(size());
        //for (E e : this) {
            //stream.writeObject(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.408 -0400", hash_original_method = "A3FDF0D301AE73958000FBEC5434608A", hash_generated_method = "DCAA552B0DC92EFB8FE68679F75C3835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.408 -0400", hash_original_method = "A913AB5E1402F7BC175E965B0D92FA39", hash_generated_method = "F3A2A7D2E76EAB5C335F72BA6A04CDEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HashMap<E, HashSet<E>> createBackingMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
        HashMap<E, HashSet<E>> var5535FDCE499C2A28ABFFAC80BC632CAB_1828331611 = (new HashMap<E, HashSet<E>>(capacity, loadFactor));
        return (HashMap<E, HashSet<E>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HashMap<E, HashSet<E>>(capacity, loadFactor);
    }

    
    private static final long serialVersionUID = -5024744406713321676L;
}

