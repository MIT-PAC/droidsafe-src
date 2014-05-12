package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import static java.util.TreeMap.Relation.CEILING;
import static java.util.TreeMap.Relation.EQUAL;
import static java.util.TreeMap.Relation.FLOOR;
import static java.util.TreeMap.Relation.HIGHER;
import static java.util.TreeMap.Relation.LOWER;
import static java.util.TreeMap.Bound.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

import libcore.util.Objects;

public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V>, NavigableMap<K, V>, Cloneable, Serializable {

    /**
     * Returns the number of elements in the iteration.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.853 -0500", hash_original_method = "FF9071DA9035F09D9A096319B6A6FDA6", hash_generated_method = "7C5B4DDB15F102DFA56E66C2F3366598")
    
static int count(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "C574FEBC92A9E5D83B951EB931304363")
    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "00940CF90AFA854079CAC5C992323851")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_18628642 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.857 -0500", hash_original_field = "3CD11D9225509050B5FD3B16969A0EAC", hash_generated_field = "72B7CECA8AF68C19BE3FF8E965B18D99")

    private static final long serialVersionUID = 919286545866124006L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.256 -0500", hash_original_field = "10E826BC31BCAB9BF3EF3CC29146C2D4", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")
    int size = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.262 -0500", hash_original_field = "7C38AA8724D6D8AD727BB2AB85887DF0", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")

    int modCount = 0;
        
@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_method = "317880CC1AD8B8CC7D9C11CC941EE8C3", hash_generated_method = "C50778A3B9FF17C06EAC39C559AF87B9")
    public  TreeMap(Map<? extends K, ? extends V> copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
        for(Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet())
        {
            put(entry.getKey(), entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //for (Map.Entry<? extends K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.369 -0400", hash_original_method = "C1FE892CAD9D3780A675F5A8CA11F4FA", hash_generated_method = "39BB15B650529D91F63E90DE9C103299")
    @SuppressWarnings("unchecked")
    public  TreeMap(Comparator<? super K> comparator) {
        addTaint(comparator.getTaint());
        this.comparator = comparator;
        // ---------- Original Method ----------
        //if (comparator != null) {
            //this.comparator = comparator;
        //} else {
            //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.369 -0400", hash_original_method = "2607F9CE6A88866DC32D385287E67644", hash_generated_method = "88414D93BF999D1A507D7F23D1F831E8")
    @SuppressWarnings("unchecked")
    public  TreeMap(SortedMap<K, ? extends V> copyFrom) {
        addTaint(copyFrom.getTaint());
        Comparator<? super K> sourceComparator = copyFrom.comparator();
        this.comparator = sourceComparator;

        for(Map.Entry<K, ? extends V> entry : copyFrom.entrySet())
        {
            put(entry.getKey(), entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //Comparator<? super K> sourceComparator = copyFrom.comparator();
        //if (sourceComparator != null) {
            //this.comparator = sourceComparator;
        //} else {
            //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
        //for (Map.Entry<K, ? extends V> entry : copyFrom.entrySet()) {
            //putInternal(entry.getKey(), entry.getValue());
        //}
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.371 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "CE6AA112E1019EE80B24D939F4FE6814")
    @Override
    public Object clone() {
        if (DroidSafeAndroidRuntime.control) 
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1101679512 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1101679512.addTaint(getTaint());
            throw varA81442E36297E737EB908877E58260E8_1101679512;
        } //End block
        TreeMap<K, V> map = new TreeMap<K, V>(); 
        map.putAll(this);
        map.addTaint(getTaint());
        return map;
        // ---------- Original Method ----------
        //try {
            //@SuppressWarnings("unchecked") 
            //TreeMap<K, V> map = (TreeMap<K, V>) super.clone();
            //map.root = root != null ? root.copy(null) : null;
            //map.entrySet = null;
            //map.keySet = null;
            //return map;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "36A8E8F7C8F1548B797F92A82E79587A")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        addTaint(entry.getTaint());
        SimpleImmutableEntry<K, V> var00719393D67D40742FD53C80CE0E5B0C_107891035 =         
                new SimpleImmutableEntry<K, V>(entry);
        var00719393D67D40742FD53C80CE0E5B0C_107891035.addTaint(getTaint());
        return var00719393D67D40742FD53C80CE0E5B0C_107891035;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "9609CA310A4F3C97BB9D2732B3DF52A3")
    public Entry<K, V> firstEntry() {
        return getFirstEntry();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }
    
    public Entry<K, V> pollFirstEntry() {
        return removeFirstEntry();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "45639CD4F8A7960AB0F76E59B3F86639")
    public K firstKey() {
        if(DroidSafeAndroidRuntime.control)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_873687230 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_873687230.addTaint(getTaint());
            throw var28D00AB599969908D71F102AF992D49A_873687230;
        } //End block
        return super.getFirstKey();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "FBFF331DFF9FD7C7DCA0277A9F4B1F56")
    public Entry<K, V> lastEntry() {
        return super.getLastEntry();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "291B59401FC6112C81277C32A0627EF4")
    public Entry<K, V> pollLastEntry() {
        return super.removeLastEntry();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "451040275CF8B1301DAF0D1964AD3B8C")
    public K lastKey() {
        if(DroidSafeAndroidRuntime.control)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_451909438 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_451909438.addTaint(getTaint());
            throw var28D00AB599969908D71F102AF992D49A_451909438;
        } //End block
        return super.getLastKey();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "CE49465CD0F5C880DD3A31B61D48C0EE")
    public Entry<K, V> lowerEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "3636C675780B4335E6C60C8746818D04")
    public K lowerKey(K key) {
        return lowerEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "C7817021B619213D3EE27C4AA91BDD1F")
    public Entry<K, V> floorEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "880CD88C17EE808F26C08DF26CFB2B4F")
    public K floorKey(K key) {
        addTaint(key.getTaint());
        return floorEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "80B3DF47CCA9DFA0A0B061B97C037B4B")
    public Entry<K, V> ceilingEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "C3B24BEC20A17BBFDC65B4801AF6CF50")
    public K ceilingKey(K key) {
        addTaint(key.getTaint());
        return ceilingEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "565EA84C7F7A45C75F9C561C93A2697C")
    public Entry<K, V> higherEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.387 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "ACA38850C4D60EAECB3BEBE407172495")
    public K higherKey(K key) {
        addTaint(key.getTaint());
        return higherEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.388 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "671CFE180618C227BE3F9BE8B24C616A")
    public Comparator<? super K> comparator() {
Comparator<? super K> varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911 = comparator;        
        varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911.addTaint(getTaint());
        return varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "D88D54D5795839FF7F07BA1C52D59A51")
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> varA3D98E595497E0937159D5BF4C5A28F3_450087542 = new KeySet();
        varA3D98E595497E0937159D5BF4C5A28F3_450087542.addTaint(getTaint());
        return varA3D98E595497E0937159D5BF4C5A28F3_450087542;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "61AFBAA571A231CB4274E9FABA852F84")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        addTaint(toInclusive);
        addTaint(to.getTaint());
        addTaint(fromInclusive);
        addTaint(from.getTaint());
        NavigableMap<K, V> varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118 =  new BoundedMap(true, from, Bound.INCLUSIVE, to, Bound.INCLUSIVE);
        varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118.addTaint(getTaint());
        return varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "6BB6B8CB9CBAED369CA5DF253A4EFB76")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        addTaint(toExclusive.getTaint());
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> varD1C8F801B36255D14CED2B3CFD68DC65_688170002 =         new BoundedMap(true, fromInclusive, Bound.INCLUSIVE, toExclusive, Bound.EXCLUSIVE);
        varD1C8F801B36255D14CED2B3CFD68DC65_688170002.addTaint(getTaint());
        return varD1C8F801B36255D14CED2B3CFD68DC65_688170002;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "132250EB8563FF2A9194BB072FDB5222")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        addTaint(inclusive);
        addTaint(to.getTaint());
        Bound toBound = inclusive ? Bound.INCLUSIVE : Bound.EXCLUSIVE;
NavigableMap<K, V> varAA2AC7CD4326D49962BB154708AC9F4E_234290265 =         new BoundedMap(true, null, Bound.NO_BOUND, to, toBound);
        varAA2AC7CD4326D49962BB154708AC9F4E_234290265.addTaint(getTaint());
        return varAA2AC7CD4326D49962BB154708AC9F4E_234290265;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.403 -0500", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "5E28ACDB35448021D802883D3D598F9F")
    
public SortedMap<K, V> headMap(K toExclusive) {
        return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.405 -0500", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "2B13CB958846CACC81EBC1E8E6730CEC")
    
public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.408 -0500", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "EA4A42F6650782E4A9A36597C8F4B65D")
    
public SortedMap<K, V> tailMap(K fromInclusive) {
        return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.410 -0500", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "C5AB7E904C696E1FE5D0368B0CE4B765")
    
public NavigableMap<K, V> descendingMap() {
        return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.413 -0500", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "3BF4DBEFF754C3B7EF74F3EAA9F616AC")
    
public NavigableSet<K> descendingKeySet() {
        return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
    }
    
    enum Relation {
        LOWER,
        FLOOR,
        EQUAL,
        CREATE,
        CEILING,
        HIGHER;

        /**
         * Returns a possibly-flipped relation for use in descending views.
         *
         * @param ascending false to flip; true to return this.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.298 -0500", hash_original_method = "EFBF32CB50C452E33C63CC36D83F5183", hash_generated_method = "EFBF32CB50C452E33C63CC36D83F5183")
            
Relation forOrder(boolean ascending) {
            if (ascending) {
                return this;
            }

            switch (this) {
                case LOWER:
                    return HIGHER;
                case FLOOR:
                    return CEILING;
                case EQUAL:
                    return EQUAL;
                case CEILING:
                    return FLOOR;
                case HIGHER:
                    return LOWER;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.859 -0500", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "A9E29606C45A113F6207F7DCFE6F3B68")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
        for (Map.Entry<K, V> entry : entrySet()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }
    
    //////////////////////////////// Inner Classes ///////////////////////////////////
     class KeySet extends HashSet<K> implements NavigableSet<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "C8D968F3C5FE84BB3D2A53544A3D4B19", hash_generated_method = "DFEC2748635A9728BBC4A153F1CD9035")
        public Iterator<K> descendingIterator() {
            return super.getIterator();
            // ---------- Original Method ----------
            //return new MapIterator<K>(root == null ? null : root.last()) {
                //public K next() {
                    //return stepBackward().key;
                //}
            //};
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.545 -0500", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "CB4CD7DF0CCD2A82DD3C75AFD169557A")
        
public Comparator<? super K> comparator() {
            return TreeMap.this.comparator();
        }

        /*
         * Navigable methods.
         */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.547 -0500", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "9D4B100E64F6DF2015BCD2D7BC225D2D")
        
public K first() {
            return firstKey();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.550 -0500", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "E3D9B6CB10AAA116B32F71E6DB2B6380")
        
public K last() {
            return lastKey();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.552 -0500", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "DBDD2998AFC8CE83BEAB095ECB519E3B")
        
public K lower(K key) {
            return lowerKey(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.555 -0500", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "3D004A280E8FEB32FDB365774865D945")
        
public K floor(K key) {
            return floorKey(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.557 -0500", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "40A857219EB91A8A956BE81B880F3BBB")
        
public K ceiling(K key) {
            return ceilingKey(key);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.561 -0500", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "60A2E400BE223CD6421A6C9B6048790D")
        
public K higher(K key) {
            return higherKey(key);
        }
                
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "582C71EC83854437C45BD4ECAB12FC0E")
        public K pollFirst() {
            Entry<K, V> entry = getFirstEntry();
            K var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018 = entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018.addTaint(getTaint());
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }
                
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "ABD0A1CFCFA4D3D1F242F2375F97811C", hash_generated_method = "77E3A5EDA608877B2105AD6CB47399B4")
        public K pollLast() {
            Entry<K, V> entry = getLastEntry();
            K var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973 =             entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973.addTaint(getTaint());
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_237366973;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollLastEntry();
            //return entry != null ? entry.getKey() : null;
        }

        /*
         * View factory methods.
         */

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.568 -0500", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "1CBC0545A4B0744464984C21A2A06FAF")
        
public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.571 -0500", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "3C9FB98C9CDE6BA718A37B15A8A0C9A7")
        
public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.573 -0500", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "522522D80E484E4DDB7C59EBECE8AF05")
        
public NavigableSet<K> headSet(K to, boolean inclusive) {
            return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.576 -0500", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "313A540CF15EBBFC2A3BE6A18A5C82EF")
        
public SortedSet<K> headSet(K toExclusive) {
            return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.579 -0500", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "9259F817C33477DE413F82ADBE3D8CCA")
        
public NavigableSet<K> tailSet(K from, boolean inclusive) {
            return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.581 -0500", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "B88B298FC182BD3395F3A1BC5ECD17FE")
        
public SortedSet<K> tailSet(K fromInclusive) {
            return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "1704B63D396CC7A2877008D7CE821A20", hash_generated_method = "130374D647FE97BA9B570550A5F45882")
        public NavigableSet<K> descendingSet() {
            NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_940472183 = new KeySet();
            var147103AFA753373FDDCF430FA02E998F_940472183.addTaint(getTaint());
            return var147103AFA753373FDDCF430FA02E998F_940472183;
            // ---------- Original Method ----------
            //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        }
        
    }
     
     enum Bound {
         INCLUSIVE {
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.589 -0500", hash_original_method = "073F67B6BE29765887D1F4C089B64AA3", hash_generated_method = "AC2EA77CB933F235B97F2BDDB9FAB575")
            
@Override public String leftCap(Object from) {
                return "[" + from;
            }
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.592 -0500", hash_original_method = "C45A89AEFDBE723DEC9D021A5F83239A", hash_generated_method = "CFD54F49A4BEF216D5F57847655D3D05")
            
@Override public String rightCap(Object to) {
                return to + "]";
            }
         },
         EXCLUSIVE {
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.595 -0500", hash_original_method = "5F158415C849D224BCF53EC6117B3A13", hash_generated_method = "B2D0D090763F9920A2B8F9FB9B7AC70F")
            
@Override public String leftCap(Object from) {
                return "(" + from;
            }
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.598 -0500", hash_original_method = "20C4F08825F52F4E0E9077F40183EF52", hash_generated_method = "6175B00ADC3AD8247A2297856273B9F9")
            
@Override public String rightCap(Object to) {
                return to + ")";
            }
         },
         NO_BOUND {
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.601 -0500", hash_original_method = "CEBB04F65A03B4798F38F20D8779F352", hash_generated_method = "8B2073D5E471E82B3C606DF958F1B175")
            
@Override public String leftCap(Object from) {
                return ".";
            }
            @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.604 -0500", hash_original_method = "8951C726368107D69BE8AD997E7355B4", hash_generated_method = "D7F4B3844FA3BC289639812DAB4756AC")
            
@Override public String rightCap(Object to) {
                return ".";
            }
         };

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.607 -0500", hash_original_method = "82B3AB25225C0BF21057E47DCBEE85F5", hash_generated_method = "936FA9A0022E3D5278B0ABBBF2D8BB1E")
            
public abstract String leftCap(Object from);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.610 -0500", hash_original_method = "226CAFED1F39B46CDB4F24AC92392978", hash_generated_method = "458146A233B5DFEDB0AAF37F08805F67")
            
public abstract String rightCap(Object to);
     }
     
     final class BoundedMap extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.615 -0500", hash_original_field = "CC49B77FD1E67EDAB07E846FB3439264", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

        private  transient boolean ascending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.618 -0500", hash_original_field = "EEDA388640089211213D8EC2A77A8B42", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

        private  transient K from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.620 -0500", hash_original_field = "6B3AA8DA078A4CA2367AE7B02A4A7538", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

        private  transient Bound fromBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.623 -0500", hash_original_field = "CF41029638C40697EDA1A869E9A79A58", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

        private  transient K to;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.626 -0500", hash_original_field = "A23D1B50F69955C93C542987309F448F", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

        private  transient Bound toBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.701 -0500", hash_original_field = "7584453112B5BE241A3C7C86A887ED07", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

        private transient BoundedEntrySet entrySet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.704 -0500", hash_original_field = "205A62CE03B4069473E761A9731C1033", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

        private transient BoundedKeySet keySet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.629 -0500", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "6313C42523F4B023AF9D4685BB8E5B6A")
        
BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
            /*
             * Validate the bounds. In addition to checking that from <= to, we
             * verify that the comparator supports our bound objects.
             */
            if (fromBound != NO_BOUND && toBound != NO_BOUND) {
                if (comparator.compare(from, to) > 0) {
                    throw new IllegalArgumentException(from + " > " + to);
                }
            } else if (fromBound != NO_BOUND) {
                comparator.compare(from, from);
            } else if (toBound != NO_BOUND) {
                comparator.compare(to, to);
            }

            this.ascending = ascending;
            this.from = from;
            this.fromBound = fromBound;
            this.to = to;
            this.toBound = toBound;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.631 -0500", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "D25BB53F3C30538427F3E85787AC04C4")
        
@Override public int size() {
            return count(entrySet().iterator());
        }
         
         @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.405 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "8EDF25B3F305EDC0E18B84933E902E62")
         @SuppressWarnings("unchecked")
         private boolean isInBounds(Object key) {
             addTaint(key.getTaint());
             return getTaintBoolean();
             // ---------- Original Method ----------
             //return isInBounds((K) key, fromBound, toBound);
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "692642A6AE210FFE582C89EC91302D79", hash_generated_method = "57DB4CC0B52B6C54EEBFE21544ED143D")
         private boolean isInBounds(K key, Bound fromBound, Bound toBound) {
             addTaint(toBound.getTaint());
             addTaint(fromBound.getTaint());
             addTaint(key.getTaint());
             return getTaintBoolean();
             
             // ---------- Original Method ----------
             //if (fromBound == INCLUSIVE) {
             //if (comparator.compare(key, from) < 0) {
             //return false; 
             //}
             //} else if (fromBound == EXCLUSIVE) {
             //if (comparator.compare(key, from) <= 0) {
             //return false; 
             //}
             //}
             //if (toBound == INCLUSIVE) {
             //if (comparator.compare(key, to) > 0) {
             //return false; 
             //}
             //} else if (toBound == EXCLUSIVE) {
             //if (comparator.compare(key, to) >= 0) {
             //return false; 
             //}
             //}
             //return true;
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "A2241F9BE30C170EC93B019D26CF6CEA")
         public Entry<K, V> firstEntry() {
             return getFirstEntry();
             // ---------- Original Method ----------
             //return immutableCopy(endpoint(true));
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "3800FF04B85DB50D775ADF76A89AF0FD", hash_generated_method = "E6184055E5DF063F213F3B704CAB5DD8")
         public Entry<K, V> pollFirstEntry() {
             return removeFirstEntry();
             // ---------- Original Method ----------
             //Node<K, V> result = endpoint(true);
             //if (result != null) {
             //removeInternal(result);
             //}
             //return immutableCopy(result);
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "4F369FAFEB3839113FB78D21CF3E4E48")
         public K firstKey() {
             if (DroidSafeAndroidRuntime.control)
             {
                 NoSuchElementException var28D00AB599969908D71F102AF992D49A_1341202273 = new NoSuchElementException();
                 var28D00AB599969908D71F102AF992D49A_1341202273.addTaint(getTaint());
                 throw var28D00AB599969908D71F102AF992D49A_1341202273;
             } //End block
             K varE5CD6225CB16CF7AEFEC373E217B052C_347516471 = getFirstKey();
             varE5CD6225CB16CF7AEFEC373E217B052C_347516471.addTaint(getTaint());
             return varE5CD6225CB16CF7AEFEC373E217B052C_347516471;
             // ---------- Original Method ----------
             //Entry<K, V> entry = endpoint(true);
             //if (entry == null) {
             //throw new NoSuchElementException();
             //}
             //return entry.getKey();
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "A78AA2AEE5BBE2BAA15204452435ACB1")
         public Entry<K, V> lastEntry() {
             Entry<K, V> varDB864FBFECFDD7EF32688DE10742D92E_84084912 =  getLastEntry();
             varDB864FBFECFDD7EF32688DE10742D92E_84084912.addTaint(getTaint());
             return varDB864FBFECFDD7EF32688DE10742D92E_84084912;
             // ---------- Original Method ----------
             //return immutableCopy(endpoint(false));
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "CDA95D4A9FCD45FFE54B9FF98BF0CCAE")
         public Entry<K, V> pollLastEntry() {
             Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_1564928535 =  removeLastEntry();
             var6B63F11358115BF1F4CDE6AD6F400177_1564928535.addTaint(getTaint());
             return var6B63F11358115BF1F4CDE6AD6F400177_1564928535;
             // ---------- Original Method ----------
             //Node<K, V> result = endpoint(false);
             //if (result != null) {
             //removeInternal(result);
             //}
             //return immutableCopy(result);
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "308C6B05EEE289F85DE7A41C5269C122")
         public K lastKey() {
             if(DroidSafeAndroidRuntime.control)
             {
                 NoSuchElementException var28D00AB599969908D71F102AF992D49A_2022465659 = new NoSuchElementException();
                 var28D00AB599969908D71F102AF992D49A_2022465659.addTaint(getTaint());
                 throw var28D00AB599969908D71F102AF992D49A_2022465659;
             } //End block
             K varE5CD6225CB16CF7AEFEC373E217B052C_1394501131 =  getLastKey(); 
             varE5CD6225CB16CF7AEFEC373E217B052C_1394501131.addTaint(getTaint());
             return varE5CD6225CB16CF7AEFEC373E217B052C_1394501131;
             // ---------- Original Method ----------
             //Entry<K, V> entry = endpoint(false);
             //if (entry == null) {
             //throw new NoSuchElementException();
             //}
             //return entry.getKey();
         }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.408 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "2B35969DD602F9C19252A5CCFE06BEC3")
         private Entry<K, V> findBounded(K key, Relation relation) {
             addTaint(relation.getTaint());
             addTaint(key.getTaint());
             relation = relation.forOrder(ascending);
             Bound fromBoundForCheck = fromBound;
             Bound toBoundForCheck = toBound;
             
             Entry<K, V> var5E7C8E05686CD046B5E518E1A524CD5B_736542112 =  getSomeEntry();
             var5E7C8E05686CD046B5E518E1A524CD5B_736542112.addTaint(getTaint());
             return var5E7C8E05686CD046B5E518E1A524CD5B_736542112;
             // ---------- Original Method ----------
             // Original Method Too Long, Refer to Original Implementation
         }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.678 -0500", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "D98E0B6F52EF21ACF480B85C1FE57FC1")
        
public Entry<K, V> lowerEntry(K key) {
            return immutableCopy(findBounded(key, LOWER));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.681 -0500", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "889326647EDCB0DBE772DBAE81BD3D7C")
        
public K lowerKey(K key) {
            Entry<K, V> entry = findBounded(key, LOWER);
            return entry != null ? entry.getKey() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.683 -0500", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "FECC7D1DBD517AFC10175EDDBFB56439")
        
public Entry<K, V> floorEntry(K key) {
            return immutableCopy(findBounded(key, FLOOR));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.686 -0500", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "6996DE5E56123C4D5451574A09E0B8C4")
        
public K floorKey(K key) {
            Entry<K, V> entry = findBounded(key, FLOOR);
            return entry != null ? entry.getKey() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.689 -0500", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "009A970FDBE141CE28B00C2CA0C24213")
        
public Entry<K, V> ceilingEntry(K key) {
            return immutableCopy(findBounded(key, CEILING));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.691 -0500", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "66CA1010CEB26C1FBCC13D5DD11FDC12")
        
public K ceilingKey(K key) {
            Entry<K, V> entry = findBounded(key, CEILING);
            return entry != null ? entry.getKey() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.694 -0500", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "33217078426E0C97E4C9A21711301460")
        
public Entry<K, V> higherEntry(K key) {
            return immutableCopy(findBounded(key, HIGHER));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.696 -0500", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "9025F91FE98CB68A8B1CFFA60CD1EA47")
        
public K higherKey(K key) {
            Entry<K, V> entry = findBounded(key, HIGHER);
            return entry != null ? entry.getKey() : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.699 -0500", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "6776E935071C4D731C73BC02C3C7007F")
        
public Comparator<? super K> comparator() {
          if (ascending) {
            return TreeMap.this.comparator();
          } else {
            return Collections.reverseOrder(comparator);
          }
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.707 -0500", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "EDC4C200EEEB64F5D3A97E07F9DF937C")
        
@Override public Set<Entry<K, V>> entrySet() {
            BoundedEntrySet result = entrySet;
            return result != null ? result : (entrySet = new BoundedEntrySet());
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.709 -0500", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "AC03ABC7AB52D57C862BA24029964BFE")
        
@Override public Set<K> keySet() {
            return navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.713 -0500", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "B743C1172DEB70C6E79C2DA88DE962A3")
        
public NavigableSet<K> navigableKeySet() {
            BoundedKeySet result = keySet;
            return result != null ? result : (keySet = new BoundedKeySet());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.716 -0500", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "74706AEA3091F44DAEA178C0705BBBF9")
        
public NavigableMap<K, V> descendingMap() {
            return new BoundedMap(!ascending, from, fromBound, to, toBound);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.718 -0500", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "FF31C047AD6E2E99A613D19478B40123")
        
public NavigableSet<K> descendingKeySet() {
            return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.720 -0500", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "2EA8163F1D224E3A74F9685C702FF83B")
        
public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
            Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
            Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
            return subMap(from, fromBound, to, toBound);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.723 -0500", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "75466109B5F64DCF01801262D3E63D70")
        
public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
            return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.725 -0500", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "EB2FA4CF7151E809686E93013492597B")
        
public NavigableMap<K, V> headMap(K to, boolean inclusive) {
            Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            return subMap(null, NO_BOUND, to, toBound);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.728 -0500", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "384801E44FEE35FE6E9166D2DDC4411F")
        
public NavigableMap<K, V> headMap(K toExclusive) {
            return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.731 -0500", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "2F4DD29759936B93BF166AE9860A7116")
        
public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
            Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
            return subMap(from, fromBound, null, NO_BOUND);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.733 -0500", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "03934C77D30476E61A9013D1BFCDA77D")
        
public NavigableMap<K, V> tailMap(K fromInclusive) {
            return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
        }
         
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.730 -0400", hash_original_method = "0BE57F9811CA6209D3A6FF727B140802", hash_generated_method = "14DFB39D85A7ADED4DBBEFD0ED517DB0")
         private NavigableMap<K, V> subMap(K from, Bound fromBound, K to, Bound toBound) {
             if(!ascending)            
             {
                 K fromTmp = from;
                 Bound fromBoundTmp = fromBound;
                 from = to;
                 fromBound = toBound;
                 to = fromTmp;
                 toBound = fromBoundTmp;
             } //End block
             if(fromBound == NO_BOUND)            
             {
                 from = this.from;
                 fromBound = this.fromBound;
             } //End block
             else
             {
                 Bound fromBoundToCheck = fromBound == this.fromBound ? INCLUSIVE : this.fromBound;
                 if(!isInBounds(from, fromBoundToCheck, this.toBound))                
                 {
                     IllegalArgumentException varAAE60559F56B2D07E4FD593449F5EA72_1154125570 = outOfBounds(to, fromBoundToCheck, this.toBound);
                     varAAE60559F56B2D07E4FD593449F5EA72_1154125570.addTaint(getTaint());
                     throw varAAE60559F56B2D07E4FD593449F5EA72_1154125570;
                 } //End block
             } //End block
             if(toBound == NO_BOUND)            
             {
                 to = this.to;
                 toBound = this.toBound;
             } //End block
             else
             {
                 Bound toBoundToCheck = toBound == this.toBound ? INCLUSIVE : this.toBound;
                 if(!isInBounds(to, this.fromBound, toBoundToCheck))                
                 {
                     IllegalArgumentException var56B3D45BCEE596AC83A0B23A3B92857C_293578796 = outOfBounds(to, this.fromBound, toBoundToCheck);
                     var56B3D45BCEE596AC83A0B23A3B92857C_293578796.addTaint(getTaint());
                     throw var56B3D45BCEE596AC83A0B23A3B92857C_293578796;
                 } //End block
             } //End block
             NavigableMap<K, V> varEC04A97C55B7258B88C9CBFBFF445575_3340594 =             new BoundedMap(ascending, from, fromBound, to, toBound);
             varEC04A97C55B7258B88C9CBFBFF445575_3340594.addTaint(getTaint());
             return varEC04A97C55B7258B88C9CBFBFF445575_3340594;
             // ---------- Original Method ----------
             // Original Method Too Long, Refer to Original Implementation
         }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.739 -0500", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "2C46A7F5132D77A96CA177951CF5664D")
        
private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
            return new IllegalArgumentException(value + " not in range "
                    + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
        }
         
         @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.439 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "83FB27AB0EB8C1109558C0AF671DF845")
         Object writeReplace() throws ObjectStreamException {
             Object var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326 = new Object(); 
             var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326.addTaint(getTaint());
             return var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326;
             // ---------- Original Method ----------
             //return ascending
             //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
             //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
         }

         final class BoundedEntrySet extends HashSet<Entry<K, V>> {
             
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
             public BoundedEntrySet ()
             {
                 //Synthesized constructor
             }
         }

         final class BoundedKeySet extends HashSet<K> implements NavigableSet<K> {
             
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
             public BoundedKeySet ()
             {
                 //Synthesized constructor
             }
             
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.445 -0400", hash_original_method = "74923548E6D3A508C57DDA053BC0EE64", hash_generated_method = "61D08906757EB6C4EBA71581A3002F1B")
             public Iterator<K> descendingIterator() {
                 return super.getIterator();
                 // ---------- Original Method ----------
                 //return new BoundedIterator<K>(endpoint(false)) {
                 //public K next() {
                 //return (ascending ? stepBackward() : stepForward()).key;
                 //}
                 //};
             }

            /*
             * Navigable methods.
             */

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.798 -0500", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "9D4B100E64F6DF2015BCD2D7BC225D2D")
            
public K first() {
                return firstKey();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.801 -0500", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "83C1DF1A1D7CD78EA56D2D8CC083DD76")
            
public K pollFirst() {
                Entry<K, ?> entry = pollFirstEntry();
                return entry != null ? entry.getKey() : null;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.804 -0500", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "E3D9B6CB10AAA116B32F71E6DB2B6380")
            
public K last() {
                return lastKey();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.806 -0500", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "B754D89746FD8443A400371E3EC44F9A")
            
public K pollLast() {
                Entry<K, ?> entry = pollLastEntry();
                return entry != null ? entry.getKey() : null;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.809 -0500", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "DBDD2998AFC8CE83BEAB095ECB519E3B")
            
public K lower(K key) {
                return lowerKey(key);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.811 -0500", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "3D004A280E8FEB32FDB365774865D945")
            
public K floor(K key) {
                return floorKey(key);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.814 -0500", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "40A857219EB91A8A956BE81B880F3BBB")
            
public K ceiling(K key) {
                return ceilingKey(key);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.817 -0500", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "60A2E400BE223CD6421A6C9B6048790D")
            
public K higher(K key) {
                return higherKey(key);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.819 -0500", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "956CA89E95198F987C5A09B3A5EA4F8B")
            
public Comparator<? super K> comparator() {
                return BoundedMap.this.comparator();
            }

            /*
             * View factory methods.
             */

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.822 -0500", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "AE5BC1EF0D3505A8639D4C82E0E38FCB")
            
public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.825 -0500", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "DB0AB2662773B1656211B500A39450E0")
            
public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                return subMap(fromInclusive, toExclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.827 -0500", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "53BE5488ACDF77007061F0FA41E4CFF5")
            
public NavigableSet<K> headSet(K to, boolean inclusive) {
                return headMap(to, inclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.830 -0500", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "CE92CE666A5C5FB8D39030541435E115")
            
public SortedSet<K> headSet(K toExclusive) {
                return headMap(toExclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.833 -0500", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "D0B5D8C0FDC9530AA9196EF6E5B2E3F5")
            
public NavigableSet<K> tailSet(K from, boolean inclusive) {
                return tailMap(from, inclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.836 -0500", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "AF864BDB849192A7B82A879F0DDE8156")
            
public SortedSet<K> tailSet(K fromInclusive) {
                return tailMap(fromInclusive).navigableKeySet();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:46.839 -0500", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "E6782313B23BCF5C6B7195D598B3B610")
            
public NavigableSet<K> descendingSet() {
                return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
            }
         }
     }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "4DE82E48A11AFCCB2DCFEAE704B1F475", hash_generated_method = "14915F7022307C7DC1B494E04297B335")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        GetField fields = stream.readFields();
        comparator = (Comparator<? super K>) fields.get("comparator", null);
        if(comparator == null)        
        {
            comparator = (Comparator<? super K>) NATURAL_ORDER;
        } //End block
        int size = stream.readInt();
for(int i = 0;i < size;i++)
        {
            put((K) stream.readObject(), (V) stream.readObject());
        } //End block
        // ---------- Original Method ----------
        //GetField fields = stream.readFields();
        //comparator = (Comparator<? super K>) fields.get("comparator", null);
        //if (comparator == null) {
            //comparator = (Comparator<? super K>) NATURAL_ORDER;
        //}
        //int size = stream.readInt();
        //for (int i = 0; i < size; i++) {
            //putInternal((K) stream.readObject(), (V) stream.readObject());
        //}
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return getEntrySet();
    }
}

