package java.util;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "10E826BC31BCAB9BF3EF3CC29146C2D4")

    Comparator<? super K> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "63A9F0EA7BB98050796B649E85481845", hash_generated_field = "85295BCB9659691A12B83D4313F1A2F9")
    int size = 0;

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_field = "8626C3CD64A823DD7B97C6F5EF45A8FC", hash_generated_field = "7C38AA8724D6D8AD727BB2AB85887DF0")
    int modCount = 0;


    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.367 -0400", hash_original_method = "A79D85B768A2B786B5F2ACD3F2B9D249", hash_generated_method = "CFE342F2F41F7796DB24A93B3EC5E9D4")
    @SuppressWarnings("unchecked")
    public  TreeMap() {
        // ---------- Original Method ----------
        //this.comparator = (Comparator<? super K>) NATURAL_ORDER;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.371 -0400", hash_original_method = "FB8B1056739768AF92CF25DB3C2D30EB", hash_generated_method = "CE6AA112E1019EE80B24D939F4FE6814")
    @Override
    public Object clone() {
        if (DroidSafeAndroidRuntime.control) 
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1101679512 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1101679512.addTaint(taint);
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

    

    
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "E2F61A98BB539F90A11465C6A8354CE5", hash_generated_method = "36A8E8F7C8F1548B797F92A82E79587A")
    private SimpleImmutableEntry<K, V> immutableCopy(Entry<K, V> entry) {
        addTaint(entry.getTaint());
        SimpleImmutableEntry<K, V> var00719393D67D40742FD53C80CE0E5B0C_107891035 =         
                new SimpleImmutableEntry<K, V>(entry);
        var00719393D67D40742FD53C80CE0E5B0C_107891035.addTaint(taint);
        return var00719393D67D40742FD53C80CE0E5B0C_107891035;
        // ---------- Original Method ----------
        //return entry == null ? null : new SimpleImmutableEntry<K, V>(entry);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.384 -0400", hash_original_method = "9F2AE61C584701540103A59451B8FA45", hash_generated_method = "9609CA310A4F3C97BB9D2732B3DF52A3")
    public Entry<K, V> firstEntry() {
        return getFirstEntry();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.first());
    }

    
    @DSModeled(DSC.SAFE)
    public Entry<K, V> pollFirstEntry() {
        return removeFirstEntry();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollFirstEntry());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "B0B89D697E050FAAC6816A6E8B1E56A4", hash_generated_method = "45639CD4F8A7960AB0F76E59B3F86639")
    public K firstKey() {
        if(DroidSafeAndroidRuntime.control)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_873687230 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_873687230.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_873687230;
        } //End block
        return super.getFirstKey();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.first().getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9DDE470F0E6425136CCDC59F74FCDED6", hash_generated_method = "FBFF331DFF9FD7C7DCA0277A9F4B1F56")
    public Entry<K, V> lastEntry() {
        return super.getLastEntry();
        // ---------- Original Method ----------
        //return immutableCopy(root == null ? null : root.last());
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "5064879999AB9A13D0821F605568F112", hash_generated_method = "291B59401FC6112C81277C32A0627EF4")
    public Entry<K, V> pollLastEntry() {
        return super.removeLastEntry();
        // ---------- Original Method ----------
        //return immutableCopy(internalPollLastEntry());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9EE1928205B19C964D03E8011BB7E907", hash_generated_method = "451040275CF8B1301DAF0D1964AD3B8C")
    public K lastKey() {
        if(DroidSafeAndroidRuntime.control)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_451909438 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_451909438.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_451909438;
        } //End block
        return super.getLastKey();
        // ---------- Original Method ----------
        //if (root == null) {
            //throw new NoSuchElementException();
        //}
        //return root.last().getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "9D71F38DCAD7DBC2AA9FACCDA9CF4866", hash_generated_method = "CE49465CD0F5C880DD3A31B61D48C0EE")
    public Entry<K, V> lowerEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, LOWER));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.385 -0400", hash_original_method = "BC9464ECC7239B355BB45B80204BADD6", hash_generated_method = "3636C675780B4335E6C60C8746818D04")
    public K lowerKey(K key) {
        return lowerEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, LOWER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "5D12D4D534218428856149792C7C973A", hash_generated_method = "C7817021B619213D3EE27C4AA91BDD1F")
    public Entry<K, V> floorEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, FLOOR));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "9E3521C1E5D0BB4CA97E65B4B91FC561", hash_generated_method = "880CD88C17EE808F26C08DF26CFB2B4F")
    public K floorKey(K key) {
        addTaint(key.getTaint());
        return floorEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, FLOOR);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "14BBCA12BBBC651385215255CDF3836D", hash_generated_method = "80B3DF47CCA9DFA0A0B061B97C037B4B")
    public Entry<K, V> ceilingEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, CEILING));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "818E984E93F7F07D0C27D2493F11C2A5", hash_generated_method = "C3B24BEC20A17BBFDC65B4801AF6CF50")
    public K ceilingKey(K key) {
        addTaint(key.getTaint());
        return ceilingEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, CEILING);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.386 -0400", hash_original_method = "AC2414FDDF42A1318F8CC45C80E09BC1", hash_generated_method = "565EA84C7F7A45C75F9C561C93A2697C")
    public Entry<K, V> higherEntry(K key) {
        addTaint(key.getTaint());
        return super.getSomeEntry();
        // ---------- Original Method ----------
        //return immutableCopy(find(key, HIGHER));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.387 -0400", hash_original_method = "0C080E769BA3B62EBC93442ECCB0FC7D", hash_generated_method = "ACA38850C4D60EAECB3BEBE407172495")
    public K higherKey(K key) {
        addTaint(key.getTaint());
        return higherEntry(key).getKey();
        // ---------- Original Method ----------
        //Entry<K, V> entry = find(key, HIGHER);
        //return entry != null ? entry.getKey() : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.388 -0400", hash_original_method = "6A8618E17145F23513711DA8498038AE", hash_generated_method = "671CFE180618C227BE3F9BE8B24C616A")
    public Comparator<? super K> comparator() {
Comparator<? super K> varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911 = comparator;        
        varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911.addTaint(taint);
        return varFC8F75816E5A2BE67601D262F4DD4CC3_1185112911;
        // ---------- Original Method ----------
        //return comparator != NATURAL_ORDER ? comparator : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "016115EA38C293C7AAA8E892AEA754CA", hash_generated_method = "D88D54D5795839FF7F07BA1C52D59A51")
    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> varA3D98E595497E0937159D5BF4C5A28F3_450087542 = new KeySet();
        varA3D98E595497E0937159D5BF4C5A28F3_450087542.addTaint(getTaint());
        return varA3D98E595497E0937159D5BF4C5A28F3_450087542;
        // ---------- Original Method ----------
        //KeySet result = keySet;
        //return result != null ? result : (keySet = new KeySet());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "DA6DE2093EE8DE46EE4576501F54E528", hash_generated_method = "61AFBAA571A231CB4274E9FABA852F84")
    public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
        addTaint(toInclusive);
        addTaint(to.getTaint());
        addTaint(fromInclusive);
        addTaint(from.getTaint());
        NavigableMap<K, V> varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118 =  new BoundedMap(true, from, Bound.INCLUSIVE, to, Bound.INCLUSIVE);
        varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118.addTaint(taint);
        return varC1ADA0B077817E4E937F0AB6A4E4BFEB_326795118;
        // ---------- Original Method ----------
        //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
        //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, to, toBound);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "193BA03007E91EBBDB489C20B60BFC88", hash_generated_method = "6BB6B8CB9CBAED369CA5DF253A4EFB76")
    public SortedMap<K, V> subMap(K fromInclusive, K toExclusive) {
        addTaint(toExclusive.getTaint());
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> varD1C8F801B36255D14CED2B3CFD68DC65_688170002 =         new BoundedMap(true, fromInclusive, Bound.INCLUSIVE, toExclusive, Bound.EXCLUSIVE);
        varD1C8F801B36255D14CED2B3CFD68DC65_688170002.addTaint(taint);
        return varD1C8F801B36255D14CED2B3CFD68DC65_688170002;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "FA312E74B0C04D741489E3323E0FFDFE", hash_generated_method = "132250EB8563FF2A9194BB072FDB5222")
    public NavigableMap<K, V> headMap(K to, boolean inclusive) {
        addTaint(inclusive);
        addTaint(to.getTaint());
        Bound toBound = inclusive ? Bound.INCLUSIVE : Bound.EXCLUSIVE;
NavigableMap<K, V> varAA2AC7CD4326D49962BB154708AC9F4E_234290265 =         new BoundedMap(true, null, Bound.NO_BOUND, to, toBound);
        varAA2AC7CD4326D49962BB154708AC9F4E_234290265.addTaint(taint);
        return varAA2AC7CD4326D49962BB154708AC9F4E_234290265;
        // ---------- Original Method ----------
        //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, null, NO_BOUND, to, toBound);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "CAC178CA3C39A0AC08FB27C63F9A635C", hash_generated_method = "F115429E0CC0CEC82092193D12298EAE")
    public SortedMap<K, V> headMap(K toExclusive) {
        addTaint(toExclusive.getTaint());
SortedMap<K, V> varF36207FD347C9B8A75FD36AB250F2562_2084544995 =         new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
        varF36207FD347C9B8A75FD36AB250F2562_2084544995.addTaint(taint);
        return varF36207FD347C9B8A75FD36AB250F2562_2084544995;
        // ---------- Original Method ----------
        //return new BoundedMap(true, null, NO_BOUND, toExclusive, EXCLUSIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.389 -0400", hash_original_method = "828BC950C20B857C189141DA99499F09", hash_generated_method = "E1F799729CFB590546C7E3601ED3B253")
    public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
        addTaint(inclusive);
        addTaint(from.getTaint());
        Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
NavigableMap<K, V> var858AA4077810E3CAD30935021614C398_1172707928 =         new BoundedMap(true, from, fromBound, null, NO_BOUND);
        var858AA4077810E3CAD30935021614C398_1172707928.addTaint(taint);
        return var858AA4077810E3CAD30935021614C398_1172707928;
        // ---------- Original Method ----------
        //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
        //return new BoundedMap(true, from, fromBound, null, NO_BOUND);
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "79B47D2E0956F27B23E0B18E5FD19D6A", hash_generated_method = "F76D8B004F22DC740F898636C13D287A")
    public SortedMap<K, V> tailMap(K fromInclusive) {
        addTaint(fromInclusive.getTaint());
SortedMap<K, V> var238F6B1D3AB45506AAB3C8043B1183BA_692610858 =         new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
        var238F6B1D3AB45506AAB3C8043B1183BA_692610858.addTaint(taint);
        return var238F6B1D3AB45506AAB3C8043B1183BA_692610858;
        // ---------- Original Method ----------
        //return new BoundedMap(true, fromInclusive, INCLUSIVE, null, NO_BOUND);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "5AD6A5A37D3C9366BEF11B75DC396D31", hash_generated_method = "F6619A914F54F978F5CEFA48433AD62B")
    public NavigableMap<K, V> descendingMap() {
NavigableMap<K, V> var1294C8AE6093F28046A52F9C508EC87F_691939230 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
        var1294C8AE6093F28046A52F9C508EC87F_691939230.addTaint(taint);
        return var1294C8AE6093F28046A52F9C508EC87F_691939230;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "1207DF79B9959BCB242E95030D6177B0", hash_generated_method = "B55B98D34D1D0D4E321F3F2DE53BE34B")
    public NavigableSet<K> descendingKeySet() {
NavigableSet<K> var147103AFA753373FDDCF430FA02E998F_84879498 =         new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
        var147103AFA753373FDDCF430FA02E998F_84879498.addTaint(taint);
        return var147103AFA753373FDDCF430FA02E998F_84879498;
        // ---------- Original Method ----------
        //return new BoundedMap(false, null, NO_BOUND, null, NO_BOUND).navigableKeySet();
    }

    
    @DSModeled(DSC.SAFE)
    static int count(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.390 -0400", hash_original_method = "BF81D129CE69F9BEB40CAD27F974F3C8", hash_generated_method = "913EA14829CB66885A0D07F3ADF68B3F")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        stream.writeFields();
        stream.writeInt(size);
for(Map.Entry<K, V> entry : entrySet())
        {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //stream.putFields().put("comparator", comparator != NATURAL_ORDER ? comparator : null);
        //stream.writeFields();
        //stream.writeInt(size);
        //for (Map.Entry<K, V> entry : entrySet()) {
            //stream.writeObject(entry.getKey());
            //stream.writeObject(entry.getValue());
        //}
    }

    
        @DSModeled(DSC.BAN)
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

    
    enum Relation {
        LOWER,
        FLOOR,
        EQUAL,
        CREATE,
        CEILING,
        HIGHER;
        @DSModeled(DSC.SAFE)
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

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_field = "AAD864C939B46188F070706401E1932C", hash_generated_field = "C574FEBC92A9E5D83B951EB931304363")
    @SuppressWarnings("unchecked") private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.547 -0400", hash_original_method = "078A1DB9555D9E606EA5FF406F56B2E6", hash_generated_method = "00940CF90AFA854079CAC5C992323851")
        public int compare(Comparable a, Comparable b) {
            int varC15B2565AD7A5177ED0132648C5386D9_18628642 = (a.compareTo(b));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221955437;
            
            
        }

        
};
    
    

    
    //////////////////////////////// Inner Classes ///////////////////////////////////
     class KeySet extends HashSet<K> implements NavigableSet<K> {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.394 -0400", hash_original_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF", hash_generated_method = "8EEFEB9CAE8A4D06D5B6F35742C5D3CF")
        public KeySet ()
        {
            //Synthesized constructor
        }

        @DSModeled(DSC.SAFE)
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
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "E1A1305471DEE1FE749764F6E03BE3A0", hash_generated_method = "C7818EC65508E1FD0378C372C72437AE")
        public Comparator<? super K> comparator() {
            Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_1657680967 =             TreeMap.this.comparator();
            varEE9621AAB15522B49DAC63CE835E2941_1657680967.addTaint(taint);
            return varEE9621AAB15522B49DAC63CE835E2941_1657680967;
            // ---------- Original Method ----------
            //return TreeMap.this.comparator();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "2C1F2B80BE5099C6CC737F87CBF345EC")
        public K first() {
            K var59F2D49FC0979EFEDD893E9689C2AA6B_647562204 = firstKey();
            var59F2D49FC0979EFEDD893E9689C2AA6B_647562204.addTaint(taint);
            return var59F2D49FC0979EFEDD893E9689C2AA6B_647562204;
            // ---------- Original Method ----------
            //return firstKey();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.395 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "E83882116D9474B8DA62E987E82D7AF4")
        public K last() {
            K var9DAA79F4D4E0401E91D6AAF423D49398_687491925 = lastKey();
            var9DAA79F4D4E0401E91D6AAF423D49398_687491925.addTaint(taint);
            return var9DAA79F4D4E0401E91D6AAF423D49398_687491925;
            // ---------- Original Method ----------
            //return lastKey();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "79CE01DB5D41E90D3D1961971D6B0A44")
        public K lower(K key) {
            addTaint(key.getTaint());
K var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440 =             lowerKey(key);
            var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440.addTaint(taint);
            return var2B86BD115FCBD0ED4D0B4CB097A2C388_519970440;
            // ---------- Original Method ----------
            //return lowerKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "FC71AF77B8FE05D1A78FA69AF1E9FB2E")
        public K floor(K key) {
            addTaint(key.getTaint());
K var350534B70A929DCE92BCA350B3F7DA8E_124869356 =             floorKey(key);
            var350534B70A929DCE92BCA350B3F7DA8E_124869356.addTaint(taint);
            return var350534B70A929DCE92BCA350B3F7DA8E_124869356;
            // ---------- Original Method ----------
            //return floorKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "15DD3314DD9285CC86FFAF616F295E4A")
        public K ceiling(K key) {
            addTaint(key.getTaint());
K varC33643BEB47C1CC66B2C2CDB25527B59_1820794234 =             ceilingKey(key);
            varC33643BEB47C1CC66B2C2CDB25527B59_1820794234.addTaint(taint);
            return varC33643BEB47C1CC66B2C2CDB25527B59_1820794234;
            // ---------- Original Method ----------
            //return ceilingKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "211EEF49E9DB40A724C5B8B8EFC795AA")
        public K higher(K key) {
            addTaint(key.getTaint());
K var75CF48C4839A7AAF074C16D584CD6253_1611036069 =             higherKey(key);
            var75CF48C4839A7AAF074C16D584CD6253_1611036069.addTaint(taint);
            return var75CF48C4839A7AAF074C16D584CD6253_1611036069;
            // ---------- Original Method ----------
            //return higherKey(key);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "0E3C9584B722234668005FBA598A1EC0", hash_generated_method = "582C71EC83854437C45BD4ECAB12FC0E")
        public K pollFirst() {
            Entry<K, V> entry = getFirstEntry();
            K var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018 = entry != null ? entry.getKey() : null;
            var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018.addTaint(taint);
            return var15DE16EBAA69B0A4EA051FB5DEC39C10_1410747018;
            // ---------- Original Method ----------
            //Entry<K, V> entry = internalPollFirstEntry();
            //return entry != null ? entry.getKey() : null;
        }

        
                @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "21828DA90728B75367EF3BEE7D62C832", hash_generated_method = "2E4201D2362A504529F86E585130A331")
        public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
            addTaint(toInclusive);
            addTaint(to.getTaint());
            addTaint(fromInclusive);
            addTaint(from.getTaint());
            NavigableSet<K> var1E006BA33691F75FD5C590518669F7CF_1005058275 =             TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
            var1E006BA33691F75FD5C590518669F7CF_1005058275.addTaint(taint);
            return var1E006BA33691F75FD5C590518669F7CF_1005058275;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "B37C6130D4B0113815E317EEB111D1E9", hash_generated_method = "8EED1081530EB87C5A39D4E4ED7881AB")
        public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
            addTaint(toExclusive.getTaint());
            addTaint(fromInclusive.getTaint());
SortedSet<K> varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809 =             TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
            varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809.addTaint(taint);
            return varAEEB9B76D84A9A3D1311D62B7C8E400F_254578809;
            // ---------- Original Method ----------
            //return TreeMap.this.subMap(fromInclusive, true, toExclusive, false).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "15C518A93EE21ED6E81237BD492369B4", hash_generated_method = "A124BB0357679F203AEC92A15A76B098")
        public NavigableSet<K> headSet(K to, boolean inclusive) {
            addTaint(inclusive);
            addTaint(to.getTaint());
NavigableSet<K> var2AC6FCA4CD759F1D6886D1E522029C64_173148844 =             TreeMap.this.headMap(to, inclusive).navigableKeySet();
            var2AC6FCA4CD759F1D6886D1E522029C64_173148844.addTaint(taint);
            return var2AC6FCA4CD759F1D6886D1E522029C64_173148844;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(to, inclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.396 -0400", hash_original_method = "1E1BD4D122D1F75D80BDC2474EF32137", hash_generated_method = "E0814C0D314042BF9AFC76298E197FAA")
        public SortedSet<K> headSet(K toExclusive) {
            addTaint(toExclusive.getTaint());
SortedSet<K> var9CABB3B743BD7889D426F02DACBBE99F_972687639 =             TreeMap.this.headMap(toExclusive, false).navigableKeySet();
            var9CABB3B743BD7889D426F02DACBBE99F_972687639.addTaint(taint);
            return var9CABB3B743BD7889D426F02DACBBE99F_972687639;
            // ---------- Original Method ----------
            //return TreeMap.this.headMap(toExclusive, false).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "3007AE414049BD587DD344AEC05F7630", hash_generated_method = "98F4F8D293381E7963362222061B8105")
        public NavigableSet<K> tailSet(K from, boolean inclusive) {
            addTaint(inclusive);
            addTaint(from.getTaint());
NavigableSet<K> var119889AEAA5B3E18E2858897784D1CE7_1556931084 =             TreeMap.this.tailMap(from, inclusive).navigableKeySet();
            var119889AEAA5B3E18E2858897784D1CE7_1556931084.addTaint(taint);
            return var119889AEAA5B3E18E2858897784D1CE7_1556931084;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(from, inclusive).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_method = "4DA58A152F26E7271643C0314BDDDB69", hash_generated_method = "B8130BEB4ABD34E9261B84E5AE5F0053")
        public SortedSet<K> tailSet(K fromInclusive) {
            addTaint(fromInclusive.getTaint());
            SortedSet<K> varFF4E3FFD47F6151862E3275C1D99A159_239939253 =             TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
            varFF4E3FFD47F6151862E3275C1D99A159_239939253.addTaint(taint);
            return varFF4E3FFD47F6151862E3275C1D99A159_239939253;
            // ---------- Original Method ----------
            //return TreeMap.this.tailMap(fromInclusive, true).navigableKeySet();
        }

        
        @DSModeled(DSC.SAFE)
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
             @DSModeled(DSC.SAFE)
         @Override public String leftCap(Object from) {
                 return "[" + from;
             }
             @DSModeled(DSC.SAFE)
         @Override public String rightCap(Object to) {
                 return to + "]";
             }
         },
         EXCLUSIVE {
             @DSModeled(DSC.SAFE)
         @Override public String leftCap(Object from) {
                 return "(" + from;
             }
             @DSModeled(DSC.SAFE)
         @Override public String rightCap(Object to) {
                 return to + ")";
             }
         },
         NO_BOUND {
             @DSModeled(DSC.SAFE)
         @Override public String leftCap(Object from) {
                 return ".";
             }
             @DSModeled(DSC.SAFE)
         @Override public String rightCap(Object to) {
                 return ".";
             }
         };
         @DSModeled(DSC.SAFE)
         public abstract String leftCap(Object from);
         @DSModeled(DSC.SAFE)
         public abstract String rightCap(Object to);
     }
     
     final class BoundedMap extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "9C9AB624360885FCF93B7643C93B6748", hash_generated_field = "BC70714ECDFF7490EBA777F7B93EF439")

         private transient boolean ascending;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "EEAE90D76D5F301C983CBE52CC99E066")

         private transient K from;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "8632C30284D52AAEE2237CDB621740BD", hash_generated_field = "8ED035FAE673A429CD23C9E2219BCCAB")

         private transient Bound fromBound;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "61687A1A941C5D04AF6012AAB46409E8")

         private transient K to;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "7CA17358064D231F30EBE9DEA6953FC3", hash_generated_field = "AA1B7E444C65D0CB4426137E2FCF44C2")

         private transient Bound toBound;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "D4E06C98DBA5A687CB6C836BF538EC81", hash_generated_field = "71A92C43EAA002A1D21DF22BACB230F5")

         private transient BoundedEntrySet entrySet;
         @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.397 -0400", hash_original_field = "3E8ABCE844B6A8A95397486A3899B536", hash_generated_field = "8C5699591CBD5CFF428C3B6D5369D846")

         private transient BoundedKeySet keySet;

         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "EAF770A918D33B7B0B98CAAC01791FDE", hash_generated_method = "1ED7235088DE7EE5A250298A66834C92")
         BoundedMap(boolean ascending, K from, Bound fromBound, K to, Bound toBound) {
             if(fromBound != NO_BOUND && toBound != NO_BOUND)            
             {
                 if(comparator.compare(from, to) > 0)                
                 {
                     IllegalArgumentException var8DDE4F833C7F6DD25182F12F52D69FD0_617920333 = new IllegalArgumentException(from + " > " + to);
                     var8DDE4F833C7F6DD25182F12F52D69FD0_617920333.addTaint(taint);
                     throw var8DDE4F833C7F6DD25182F12F52D69FD0_617920333;
                 } //End block
             } //End block
             else
                 if(fromBound != NO_BOUND)            
                 {
                     comparator.compare(from, from);
                 } //End block
                 else
                     if(toBound != NO_BOUND)            
                     {
                         comparator.compare(to, to);
                     } //End block
             this.ascending = ascending;
             this.from = from;
             this.fromBound = fromBound;
             this.to = to;
             this.toBound = toBound;
             // ---------- Original Method ----------
             //if (fromBound != NO_BOUND && toBound != NO_BOUND) {
             //if (comparator.compare(from, to) > 0) {
             //throw new IllegalArgumentException(from + " > " + to);
             //}
             //} else if (fromBound != NO_BOUND) {
             //comparator.compare(from, from);
             //} else if (toBound != NO_BOUND) {
             //comparator.compare(to, to);
             //}
             //this.ascending = ascending;
             //this.from = from;
             //this.fromBound = fromBound;
             //this.to = to;
             //this.toBound = toBound;
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.398 -0400", hash_original_method = "0165FF9BE82C19127CA9F7A8EFBCC5F6", hash_generated_method = "6EB40E9077DB31978A9EF7F2CB9A6CB5")
         @Override
         public int size() {
             int var26AE06B895E339433E4D6CD04CD66FE7_1793751928 = (count(entrySet().iterator()));
             int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920932493 = getTaintInt();
             return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920932493;
             // ---------- Original Method ----------
             //return count(entrySet().iterator());
         }

         @DSModeled(DSC.BAN)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.405 -0400", hash_original_method = "CBDDB4BBE438A9DB233DEA58A1C969FA", hash_generated_method = "8EDF25B3F305EDC0E18B84933E902E62")
         @SuppressWarnings("unchecked")
         private boolean isInBounds(Object key) {
             addTaint(key.getTaint());
             return getTaintBoolean();
             // ---------- Original Method ----------
             //return isInBounds((K) key, fromBound, toBound);
         }


         @DSModeled(DSC.SAFE)
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

         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "692355E3656C196457301F91A19D5157", hash_generated_method = "A2241F9BE30C170EC93B019D26CF6CEA")
         public Entry<K, V> firstEntry() {
             return getFirstEntry();
             // ---------- Original Method ----------
             //return immutableCopy(endpoint(true));
         }


         @DSModeled(DSC.SAFE)
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


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "1DE5152AF86A2FB092CD0802BF299C85", hash_generated_method = "4F369FAFEB3839113FB78D21CF3E4E48")
         public K firstKey() {
             if (DroidSafeAndroidRuntime.control)
             {
                 NoSuchElementException var28D00AB599969908D71F102AF992D49A_1341202273 = new NoSuchElementException();
                 var28D00AB599969908D71F102AF992D49A_1341202273.addTaint(taint);
                 throw var28D00AB599969908D71F102AF992D49A_1341202273;
             } //End block
             K varE5CD6225CB16CF7AEFEC373E217B052C_347516471 = getFirstKey();
             varE5CD6225CB16CF7AEFEC373E217B052C_347516471.addTaint(taint);
             return varE5CD6225CB16CF7AEFEC373E217B052C_347516471;
             // ---------- Original Method ----------
             //Entry<K, V> entry = endpoint(true);
             //if (entry == null) {
             //throw new NoSuchElementException();
             //}
             //return entry.getKey();
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.406 -0400", hash_original_method = "3349B358C55B472B88F39549996E074C", hash_generated_method = "A78AA2AEE5BBE2BAA15204452435ACB1")
         public Entry<K, V> lastEntry() {
             Entry<K, V> varDB864FBFECFDD7EF32688DE10742D92E_84084912 =  getLastEntry();
             varDB864FBFECFDD7EF32688DE10742D92E_84084912.addTaint(taint);
             return varDB864FBFECFDD7EF32688DE10742D92E_84084912;
             // ---------- Original Method ----------
             //return immutableCopy(endpoint(false));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "4E391E55891B2D72162CA8FBBFDB8088", hash_generated_method = "CDA95D4A9FCD45FFE54B9FF98BF0CCAE")
         public Entry<K, V> pollLastEntry() {
             Entry<K, V> var6B63F11358115BF1F4CDE6AD6F400177_1564928535 =  removeLastEntry();
             var6B63F11358115BF1F4CDE6AD6F400177_1564928535.addTaint(taint);
             return var6B63F11358115BF1F4CDE6AD6F400177_1564928535;
             // ---------- Original Method ----------
             //Node<K, V> result = endpoint(false);
             //if (result != null) {
             //removeInternal(result);
             //}
             //return immutableCopy(result);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.407 -0400", hash_original_method = "394B9DCC52DC405017E9FB6F95D12436", hash_generated_method = "308C6B05EEE289F85DE7A41C5269C122")
         public K lastKey() {
             if(DroidSafeAndroidRuntime.control)
             {
                 NoSuchElementException var28D00AB599969908D71F102AF992D49A_2022465659 = new NoSuchElementException();
                 var28D00AB599969908D71F102AF992D49A_2022465659.addTaint(taint);
                 throw var28D00AB599969908D71F102AF992D49A_2022465659;
             } //End block
             K varE5CD6225CB16CF7AEFEC373E217B052C_1394501131 =  getLastKey(); 
             varE5CD6225CB16CF7AEFEC373E217B052C_1394501131.addTaint(taint);
             return varE5CD6225CB16CF7AEFEC373E217B052C_1394501131;
             // ---------- Original Method ----------
             //Entry<K, V> entry = endpoint(false);
             //if (entry == null) {
             //throw new NoSuchElementException();
             //}
             //return entry.getKey();
         }


         
         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.408 -0400", hash_original_method = "4CDC04225A960E79B8311D7465BD3125", hash_generated_method = "2B35969DD602F9C19252A5CCFE06BEC3")
         private Entry<K, V> findBounded(K key, Relation relation) {
             addTaint(relation.getTaint());
             addTaint(key.getTaint());
             relation = relation.forOrder(ascending);
             Bound fromBoundForCheck = fromBound;
             Bound toBoundForCheck = toBound;
             
             Entry<K, V> var5E7C8E05686CD046B5E518E1A524CD5B_736542112 =  getSomeEntry();
             var5E7C8E05686CD046B5E518E1A524CD5B_736542112.addTaint(taint);
             return var5E7C8E05686CD046B5E518E1A524CD5B_736542112;
             // ---------- Original Method ----------
             // Original Method Too Long, Refer to Original Implementation
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.410 -0400", hash_original_method = "BD9CF59DC295A4AE3510934F298E27E6", hash_generated_method = "800C44A75F0910ECF65DAFA4A14C589C")
         public Entry<K, V> lowerEntry(K key) {
             addTaint(key.getTaint());
             Entry<K, V> var5EEE7716674B425CEA31D7AC72A401A4_1590730262 =             immutableCopy(findBounded(key, LOWER));
             var5EEE7716674B425CEA31D7AC72A401A4_1590730262.addTaint(taint);
             return var5EEE7716674B425CEA31D7AC72A401A4_1590730262;
             // ---------- Original Method ----------
             //return immutableCopy(findBounded(key, LOWER));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.410 -0400", hash_original_method = "EBA87E3AFD9E90051DFFEBD0117773EA", hash_generated_method = "4897E67A7A0CEB95201B7CBDCF0CD284")
         public K lowerKey(K key) {
             addTaint(key.getTaint());
             Entry<K, V> entry = findBounded(key, LOWER);
             K var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905 =             entry != null ? entry.getKey() : null;
             var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905.addTaint(taint);
             return var15DE16EBAA69B0A4EA051FB5DEC39C10_1076535905;
             // ---------- Original Method ----------
             //Entry<K, V> entry = findBounded(key, LOWER);
             //return entry != null ? entry.getKey() : null;
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "581C54D570AF4193E6400C576ED95C35", hash_generated_method = "09AAD82126671121348D3AF58979D787")
         public Entry<K, V> floorEntry(K key) {
             addTaint(key.getTaint());
             Entry<K, V> varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705 =             immutableCopy(findBounded(key, FLOOR));
             varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705.addTaint(taint);
             return varC2D8288DAEE7B2AD361DAA75FC2202C3_1985893705;
             // ---------- Original Method ----------
             //return immutableCopy(findBounded(key, FLOOR));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "E92237DAC033388A5150FD58D66D705D", hash_generated_method = "0DF297046DF8ACAB33998F61AAFD5064")
         public K floorKey(K key) {
             addTaint(key.getTaint());
             Entry<K, V> entry = findBounded(key, FLOOR);
             K var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000 =             entry != null ? entry.getKey() : null;
             var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000.addTaint(taint);
             return var15DE16EBAA69B0A4EA051FB5DEC39C10_318602000;
             // ---------- Original Method ----------
             //Entry<K, V> entry = findBounded(key, FLOOR);
             //return entry != null ? entry.getKey() : null;
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "C11821BD096982DAE03E94867B2C92BE", hash_generated_method = "4BE2FEE6E92F9283260535F5A64E6A7C")
         public Entry<K, V> ceilingEntry(K key) {
             addTaint(key.getTaint());
             Entry<K, V> var4231880C2A190D7782E1F90F0F7B868D_1665266098 =             immutableCopy(findBounded(key, CEILING));
             var4231880C2A190D7782E1F90F0F7B868D_1665266098.addTaint(taint);
             return var4231880C2A190D7782E1F90F0F7B868D_1665266098;
             // ---------- Original Method ----------
             //return immutableCopy(findBounded(key, CEILING));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "01AF63D6DC81CC48D8C6B0BE37F83B4D", hash_generated_method = "C073DCA1BAFA336BC39FC830CA93D0BC")
         public K ceilingKey(K key) {
             addTaint(key.getTaint());
             Entry<K, V> entry = findBounded(key, CEILING);
             K var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763 =             entry != null ? entry.getKey() : null;
             var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763.addTaint(taint);
             return var15DE16EBAA69B0A4EA051FB5DEC39C10_1074725763;
             // ---------- Original Method ----------
             //Entry<K, V> entry = findBounded(key, CEILING);
             //return entry != null ? entry.getKey() : null;
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "4DE66AB7FA66EBE29F4E4509967D65D0", hash_generated_method = "F157BC69B199F5C52B6F2E1E17636AD0")
         public Entry<K, V> higherEntry(K key) {
             addTaint(key.getTaint());
             Entry<K, V> var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399 =             immutableCopy(findBounded(key, HIGHER));
             var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399.addTaint(taint);
             return var0D6C34F1391AD2F31A7F6610A91CE3C1_1782524399;
             // ---------- Original Method ----------
             //return immutableCopy(findBounded(key, HIGHER));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.411 -0400", hash_original_method = "47A499322D06CDAFFEC1D4DA0A079F0A", hash_generated_method = "AA2A51CC0D5D53CD767075732CB324C1")
         public K higherKey(K key) {
             addTaint(key.getTaint());
             Entry<K, V> entry = findBounded(key, HIGHER);
             K var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058 =             entry != null ? entry.getKey() : null;
             var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058.addTaint(taint);
             return var15DE16EBAA69B0A4EA051FB5DEC39C10_1504091058;
             // ---------- Original Method ----------
             //Entry<K, V> entry = findBounded(key, HIGHER);
             //return entry != null ? entry.getKey() : null;
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.414 -0400", hash_original_method = "631801B6DE22632DEACA2B547DEBE43A", hash_generated_method = "9B52C499D53D4D52AB37A4E38E7ED06C")
         public Comparator<? super K> comparator() {
             if(ascending)            
             {
                 Comparator<? super K> varEE9621AAB15522B49DAC63CE835E2941_719622732 =                 TreeMap.this.comparator();
                 varEE9621AAB15522B49DAC63CE835E2941_719622732.addTaint(taint);
                 return varEE9621AAB15522B49DAC63CE835E2941_719622732;
             } //End block
             else
             {
                 Comparator<? super K> var189BFD6654899F3ED4575521560E0DC6_171463195 =                 Collections.reverseOrder(comparator);
                 var189BFD6654899F3ED4575521560E0DC6_171463195.addTaint(taint);
                 return var189BFD6654899F3ED4575521560E0DC6_171463195;
             } //End block
             // ---------- Original Method ----------
             //if (ascending) {
             //return TreeMap.this.comparator();
             //} else {
             //return Collections.reverseOrder(comparator);
             //}
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.414 -0400", hash_original_method = "7F86A739037DCA8312EEE2819E1107F8", hash_generated_method = "1A825E07991CFBB133E661A46E7D8171")
         @Override
         public Set<Entry<K, V>> entrySet() {
             BoundedEntrySet result = entrySet;
             Set<Entry<K, V>> var7EA657578A416D0A7E3291794489838F_265723040 =             result != null ? result : (entrySet = new BoundedEntrySet());
             var7EA657578A416D0A7E3291794489838F_265723040.addTaint(taint);
             return var7EA657578A416D0A7E3291794489838F_265723040;
             // ---------- Original Method ----------
             //BoundedEntrySet result = entrySet;
             //return result != null ? result : (entrySet = new BoundedEntrySet());
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "8D1D053C1D8B0756868AB879DB7CB086", hash_generated_method = "846343F75D269EDEE1E03944A18F6A3B")
         @Override
         public Set<K> keySet() {
             Set<K> varAF7F4C03A95ED30F86359E39EFFF72E9_523440260 =             navigableKeySet();
             varAF7F4C03A95ED30F86359E39EFFF72E9_523440260.addTaint(taint);
             return varAF7F4C03A95ED30F86359E39EFFF72E9_523440260;
             // ---------- Original Method ----------
             //return navigableKeySet();
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "58209BC6FD1C6420A0C3CE4B441A6EA8", hash_generated_method = "B801D1D10C2B73017043CBBD21C17DD9")
         public NavigableSet<K> navigableKeySet() {
             BoundedKeySet result = keySet;
             NavigableSet<K> var65433A428F01D1730EDF71551397CAE5_78673603 =             result != null ? result : (keySet = new BoundedKeySet());
             var65433A428F01D1730EDF71551397CAE5_78673603.addTaint(taint);
             return var65433A428F01D1730EDF71551397CAE5_78673603;
             // ---------- Original Method ----------
             //BoundedKeySet result = keySet;
             //return result != null ? result : (keySet = new BoundedKeySet());
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "6D358EC631E9E279A9C759613AD4CBF5", hash_generated_method = "9F6656E37C26FADAA473D0005E100ED5")
         public NavigableMap<K, V> descendingMap() {
             NavigableMap<K, V> var86E3BFF502581898758F73B9E6908FAD_183492606 =             new BoundedMap(!ascending, from, fromBound, to, toBound);
             var86E3BFF502581898758F73B9E6908FAD_183492606.addTaint(taint);
             return var86E3BFF502581898758F73B9E6908FAD_183492606;
             // ---------- Original Method ----------
             //return new BoundedMap(!ascending, from, fromBound, to, toBound);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "E068C75BD35AA3BEC427F457C352E2B5", hash_generated_method = "56B1884511540FA9BC3DF7CA660342AD")
         public NavigableSet<K> descendingKeySet() {
             NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_580695088 =             new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
             varAF8103DD5E04E7E5EEF583022A60862D_580695088.addTaint(taint);
             return varAF8103DD5E04E7E5EEF583022A60862D_580695088;
             // ---------- Original Method ----------
             //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "3DC9A98D108EA5F857802D111DD4C7BC", hash_generated_method = "6BC69D98C39613DEC3DB97974813D115")
         public NavigableMap<K, V> subMap(K from, boolean fromInclusive, K to, boolean toInclusive) {
             addTaint(toInclusive);
             addTaint(to.getTaint());
             addTaint(fromInclusive);
             addTaint(from.getTaint());
             Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
             Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
             NavigableMap<K, V> var0455DF56F4615D9DE9D27B19AFAEF226_1546866907 =             subMap(from, fromBound, to, toBound);
             var0455DF56F4615D9DE9D27B19AFAEF226_1546866907.addTaint(taint);
             return var0455DF56F4615D9DE9D27B19AFAEF226_1546866907;
             // ---------- Original Method ----------
             //Bound fromBound = fromInclusive ? INCLUSIVE : EXCLUSIVE;
             //Bound toBound = toInclusive ? INCLUSIVE : EXCLUSIVE;
             //return subMap(from, fromBound, to, toBound);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.415 -0400", hash_original_method = "85C9C855FCFD7C01DE62316D427AA356", hash_generated_method = "3EC9C7E261EAB9455C49729E3FD0C80A")
         public NavigableMap<K, V> subMap(K fromInclusive, K toExclusive) {
             addTaint(toExclusive.getTaint());
             addTaint(fromInclusive.getTaint());
             NavigableMap<K, V> varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838 =             subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
             varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838.addTaint(taint);
             return varB4D2F6DE1EAD448F88B0A434FEE1794C_1876922838;
             // ---------- Original Method ----------
             //return subMap(fromInclusive, INCLUSIVE, toExclusive, EXCLUSIVE);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.418 -0400", hash_original_method = "F0BAF6F2CF2FCD82E483E31B5C869204", hash_generated_method = "1BFB2395AAD778DE8315306450FC93A0")
         public NavigableMap<K, V> headMap(K to, boolean inclusive) {
             addTaint(inclusive);
             addTaint(to.getTaint());
             Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
             NavigableMap<K, V> var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958 =             subMap(null, NO_BOUND, to, toBound);
             var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958.addTaint(taint);
             return var2AFE5CD544BBF55ECF5B05CE6BA0FAD1_688162958;
             // ---------- Original Method ----------
             //Bound toBound = inclusive ? INCLUSIVE : EXCLUSIVE;
             //return subMap(null, NO_BOUND, to, toBound);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.418 -0400", hash_original_method = "ABFE13DC9073E46E049BB999D5306953", hash_generated_method = "207215060221B14E9B528B6DA6262001")
         public NavigableMap<K, V> headMap(K toExclusive) {
             addTaint(toExclusive.getTaint());
             NavigableMap<K, V> var765BFAC84EB1A83FC3B14F73D7910B18_149610979 =             subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
             var765BFAC84EB1A83FC3B14F73D7910B18_149610979.addTaint(taint);
             return var765BFAC84EB1A83FC3B14F73D7910B18_149610979;
             // ---------- Original Method ----------
             //return subMap(null, NO_BOUND, toExclusive, EXCLUSIVE);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.419 -0400", hash_original_method = "26986665A8C827C93D404190F2752B4C", hash_generated_method = "3DC6370EE24D87AD7E85250E7FB7D926")
         public NavigableMap<K, V> tailMap(K from, boolean inclusive) {
             addTaint(inclusive);
             addTaint(from.getTaint());
             Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
             NavigableMap<K, V> var35EFA145DEE09E716468DD6B2AFF8A39_117362615 =             subMap(from, fromBound, null, NO_BOUND);
             var35EFA145DEE09E716468DD6B2AFF8A39_117362615.addTaint(taint);
             return var35EFA145DEE09E716468DD6B2AFF8A39_117362615;
             // ---------- Original Method ----------
             //Bound fromBound = inclusive ? INCLUSIVE : EXCLUSIVE;
             //return subMap(from, fromBound, null, NO_BOUND);
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.419 -0400", hash_original_method = "CF387452C0473BBA846F53D5C56CE3B2", hash_generated_method = "2862E06CB5D0DE6E59DEF56226BC36BA")
         public NavigableMap<K, V> tailMap(K fromInclusive) {
             addTaint(fromInclusive.getTaint());
             NavigableMap<K, V> varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177 =             subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
             varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177.addTaint(taint);
             return varE8FB1045162A43BFD2F2D63D6DC8CED9_2069697177;
             // ---------- Original Method ----------
             //return subMap(fromInclusive, INCLUSIVE, null, NO_BOUND);
         }


         @DSModeled(DSC.SAFE)
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
                     varAAE60559F56B2D07E4FD593449F5EA72_1154125570.addTaint(taint);
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
                     var56B3D45BCEE596AC83A0B23A3B92857C_293578796.addTaint(taint);
                     throw var56B3D45BCEE596AC83A0B23A3B92857C_293578796;
                 } //End block
             } //End block
             NavigableMap<K, V> varEC04A97C55B7258B88C9CBFBFF445575_3340594 =             new BoundedMap(ascending, from, fromBound, to, toBound);
             varEC04A97C55B7258B88C9CBFBFF445575_3340594.addTaint(taint);
             return varEC04A97C55B7258B88C9CBFBFF445575_3340594;
             // ---------- Original Method ----------
             // Original Method Too Long, Refer to Original Implementation
         }


         @DSModeled(DSC.BAN)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.439 -0400", hash_original_method = "65FB71F2A366D35F7884C2869AFAA6ED", hash_generated_method = "5D2BA88D46418ACDF68911C9EF8B0901")
         private IllegalArgumentException outOfBounds(Object value, Bound fromBound, Bound toBound) {
             addTaint(toBound.getTaint());
             addTaint(fromBound.getTaint());
             addTaint(value.getTaint());
             IllegalArgumentException varB6209D04CF3E19CAD859CC3BE52189E0_1141603753 =             new IllegalArgumentException(value + " not in range "
                     + fromBound.leftCap(from) + ".." + toBound.rightCap(to));
             varB6209D04CF3E19CAD859CC3BE52189E0_1141603753.addTaint(taint);
             return varB6209D04CF3E19CAD859CC3BE52189E0_1141603753;
             // ---------- Original Method ----------
             //return new IllegalArgumentException(value + " not in range "
             //+ fromBound.leftCap(from) + ".." + toBound.rightCap(to));
         }


         @DSModeled(DSC.SAFE)
         @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.439 -0400", hash_original_method = "9F20C8CFE1A741092D9743A31C3F8586", hash_generated_method = "83FB27AB0EB8C1109558C0AF671DF845")
         Object writeReplace() throws ObjectStreamException {
             Object var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326 = new Object(); 
             var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326.addTaint(taint);
             return var7F4944441F64C47E165D9A9EC6DB3E3C_1279999326;
             // ---------- Original Method ----------
             //return ascending
             //? new AscendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound)
             //: new DescendingSubMap<K, V>(TreeMap.this, from, fromBound, to, toBound);
         }


         

         final class BoundedEntrySet extends HashSet<Entry<K, V>> {

             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.440 -0400", hash_original_method = "6A727A04787362E0DA8C9D4EFA8450E8", hash_generated_method = "6A727A04787362E0DA8C9D4EFA8450E8")
             public BoundedEntrySet ()
             {
                 //Synthesized constructor
             }
         }



         final class BoundedKeySet extends HashSet<K> implements NavigableSet<K> {

             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.442 -0400", hash_original_method = "9AD1259E686AD3B6150FA3E61E8BAA17", hash_generated_method = "9AD1259E686AD3B6150FA3E61E8BAA17")
             public BoundedKeySet ()
             {
                 //Synthesized constructor
             }

             @DSModeled(DSC.SAFE)
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

             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "3067DEE01FBBBFD061436C7D4561F434", hash_generated_method = "CA6E4924867E4F986CF018AD08E18736")
             public K first() {
                 K var59F2D49FC0979EFEDD893E9689C2AA6B_796994586 =                 firstKey();
                 var59F2D49FC0979EFEDD893E9689C2AA6B_796994586.addTaint(taint);
                 return var59F2D49FC0979EFEDD893E9689C2AA6B_796994586;
                 // ---------- Original Method ----------
                 //return firstKey();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "4985BB63726B115899F1811F08E80BDF", hash_generated_method = "A76D072F1F4D9514A547E982458E3B81")
             public K pollFirst() {
                 Entry<K, ?> entry = pollFirstEntry();
                 K var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007 =                 entry != null ? entry.getKey() : null;
                 var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007.addTaint(taint);
                 return var15DE16EBAA69B0A4EA051FB5DEC39C10_1934134007;
                 // ---------- Original Method ----------
                 //Entry<K, ?> entry = pollFirstEntry();
                 //return entry != null ? entry.getKey() : null;
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "39C87F788E647BCD3FB86FFF34D7EF10", hash_generated_method = "72C5F9648DFB4910E387AF62C583F60B")
             public K last() {
                 K var9DAA79F4D4E0401E91D6AAF423D49398_1503771283 =                 lastKey();
                 var9DAA79F4D4E0401E91D6AAF423D49398_1503771283.addTaint(taint);
                 return var9DAA79F4D4E0401E91D6AAF423D49398_1503771283;
                 // ---------- Original Method ----------
                 //return lastKey();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "B202B1B2AAB477548F6A0AD72C9B1701", hash_generated_method = "D36D955CA2459804FDCE0EBC044D7958")
             public K pollLast() {
                 Entry<K, ?> entry = pollLastEntry();
                 K var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975 =                 entry != null ? entry.getKey() : null;
                 var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975.addTaint(taint);
                 return var15DE16EBAA69B0A4EA051FB5DEC39C10_1399037975;
                 // ---------- Original Method ----------
                 //Entry<K, ?> entry = pollLastEntry();
                 //return entry != null ? entry.getKey() : null;
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "5CFE05BF706A06BBB501067306F1B9ED", hash_generated_method = "FAE98F1170EAAAD882483873EA2AED3C")
             public K lower(K key) {
                 addTaint(key.getTaint());
                 K var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483 =                 lowerKey(key);
                 var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483.addTaint(taint);
                 return var2B86BD115FCBD0ED4D0B4CB097A2C388_1805832483;
                 // ---------- Original Method ----------
                 //return lowerKey(key);
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.446 -0400", hash_original_method = "10BABB7BB2E837824A13AAE89EE7EC6F", hash_generated_method = "EC6F459C9EB10CFEF0AD02E2AF218B03")
             public K floor(K key) {
                 addTaint(key.getTaint());
                 K var350534B70A929DCE92BCA350B3F7DA8E_472819157 =                 floorKey(key);
                 var350534B70A929DCE92BCA350B3F7DA8E_472819157.addTaint(taint);
                 return var350534B70A929DCE92BCA350B3F7DA8E_472819157;
                 // ---------- Original Method ----------
                 //return floorKey(key);
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "2AD4706A6D818B709A1E2CA64B48B4B9", hash_generated_method = "569D280400F0162F85FF8981A233FF39")
             public K ceiling(K key) {
                 addTaint(key.getTaint());
                 K varC33643BEB47C1CC66B2C2CDB25527B59_1305879380 =                 ceilingKey(key);
                 varC33643BEB47C1CC66B2C2CDB25527B59_1305879380.addTaint(taint);
                 return varC33643BEB47C1CC66B2C2CDB25527B59_1305879380;
                 // ---------- Original Method ----------
                 //return ceilingKey(key);
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "8CC63649234BFC57DB10A2387AE34DD6", hash_generated_method = "01085DCAF70DFFF2CF574521E87F2F36")
             public K higher(K key) {
                 addTaint(key.getTaint());
                 K var75CF48C4839A7AAF074C16D584CD6253_1892759944 =                 higherKey(key);
                 var75CF48C4839A7AAF074C16D584CD6253_1892759944.addTaint(taint);
                 return var75CF48C4839A7AAF074C16D584CD6253_1892759944;
                 // ---------- Original Method ----------
                 //return higherKey(key);
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "C5DD330893039070B9523799F47D2DEB", hash_generated_method = "D61C7ABC39C8C99F14398FFA25ABEF45")
             public Comparator<? super K> comparator() {
                 Comparator<? super K> varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499 =                 BoundedMap.this.comparator();
                 varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499.addTaint(taint);
                 return varBA2FE525F1D4BFB7E44CC52BEB2076A0_1544429499;
                 // ---------- Original Method ----------
                 //return BoundedMap.this.comparator();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.447 -0400", hash_original_method = "21039715CA3F916EA62F8064E71FC6CA", hash_generated_method = "4B73A791B08783F8C00BD7D56348FD51")
             public NavigableSet<K> subSet(K from, boolean fromInclusive, K to, boolean toInclusive) {
                 addTaint(toInclusive);
                 addTaint(to.getTaint());
                 addTaint(fromInclusive);
                 addTaint(from.getTaint());
                 NavigableSet<K> var81C01024AF0DDE2CDF42AA146D845866_1186551349 =     subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
                 var81C01024AF0DDE2CDF42AA146D845866_1186551349.addTaint(taint);
                 return var81C01024AF0DDE2CDF42AA146D845866_1186551349;
                 // ---------- Original Method ----------
                 //return subMap(from, fromInclusive, to, toInclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "AA0E5149ADFB9D8316CC8EA86FBC0B9E", hash_generated_method = "E078CDE4EFCB6191251DCFDA57DBD585")
             public SortedSet<K> subSet(K fromInclusive, K toExclusive) {
                 addTaint(toExclusive.getTaint());
                 addTaint(fromInclusive.getTaint());
                 SortedSet<K> var4825DD5198D9DFA934AB97460E43155A_671359139 =                 subMap(fromInclusive, toExclusive).navigableKeySet();
                 var4825DD5198D9DFA934AB97460E43155A_671359139.addTaint(taint);
                 return var4825DD5198D9DFA934AB97460E43155A_671359139;
                 // ---------- Original Method ----------
                 //return subMap(fromInclusive, toExclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "EDDD3784AC7E9834A18CCB5F2AE27346", hash_generated_method = "6A9E6EEE845B32044F26271A7C1458DE")
             public NavigableSet<K> headSet(K to, boolean inclusive) {
                 addTaint(inclusive);
                 addTaint(to.getTaint());
                 NavigableSet<K> var1DDC11FD80C467CDB58D05608701E96E_1843974992 =                 headMap(to, inclusive).navigableKeySet();
                 var1DDC11FD80C467CDB58D05608701E96E_1843974992.addTaint(taint);
                 return var1DDC11FD80C467CDB58D05608701E96E_1843974992;
                 // ---------- Original Method ----------
                 //return headMap(to, inclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "85EE899AF4D85617CB858518BA70EA12", hash_generated_method = "9B29651F19890F97ADD7AC02EDB02228")
             public SortedSet<K> headSet(K toExclusive) {
                 addTaint(toExclusive.getTaint());
                 SortedSet<K> var296570554B3647284DAA1B64FE89EA1C_1408494725 =                 headMap(toExclusive).navigableKeySet();
                 var296570554B3647284DAA1B64FE89EA1C_1408494725.addTaint(taint);
                 return var296570554B3647284DAA1B64FE89EA1C_1408494725;
                 // ---------- Original Method ----------
                 //return headMap(toExclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "B964A303D464756EDD8E9C26A8D54411", hash_generated_method = "8C93F715487CF1208CBC9B98F5655B84")
             public NavigableSet<K> tailSet(K from, boolean inclusive) {
                 addTaint(inclusive);
                 addTaint(from.getTaint());
                 NavigableSet<K> varCAB92A74D6D2084A2C4FEA91193971BF_21951347 =                 tailMap(from, inclusive).navigableKeySet();
                 varCAB92A74D6D2084A2C4FEA91193971BF_21951347.addTaint(taint);
                 return varCAB92A74D6D2084A2C4FEA91193971BF_21951347;
                 // ---------- Original Method ----------
                 //return tailMap(from, inclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "9536952691BDDFD3D8EFB20A3BD9AE85", hash_generated_method = "355E3C1D4458F32DBA78B9CB9087282D")
             public SortedSet<K> tailSet(K fromInclusive) {
                 addTaint(fromInclusive.getTaint());
                 SortedSet<K> var599DB6DD96A121671494C9C10C8AD7AE_2063971726 =                 tailMap(fromInclusive).navigableKeySet();
                 var599DB6DD96A121671494C9C10C8AD7AE_2063971726.addTaint(taint);
                 return var599DB6DD96A121671494C9C10C8AD7AE_2063971726;
                 // ---------- Original Method ----------
                 //return tailMap(fromInclusive).navigableKeySet();
             }


             @DSModeled(DSC.SAFE)
             @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.448 -0400", hash_original_method = "2BD89B2F5D5D75B5A66FC121E2BE77F9", hash_generated_method = "7F76CFA1470D7577F0F9C0089A57F78D")
             public NavigableSet<K> descendingSet() {
                 NavigableSet<K> varAF8103DD5E04E7E5EEF583022A60862D_1663713395 =                 new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
                 varAF8103DD5E04E7E5EEF583022A60862D_1663713395.addTaint(taint);
                 return varAF8103DD5E04E7E5EEF583022A60862D_1663713395;
                 // ---------- Original Method ----------
                 //return new BoundedMap(!ascending, from, fromBound, to, toBound).navigableKeySet();
             }
         }
     }

     
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.453 -0400", hash_original_field = "0CB2D400AD555324093441A5EA2C6B7E", hash_generated_field = "72B7CECA8AF68C19BE3FF8E965B18D99")
    private static final long serialVersionUID = 919286545866124006L;



    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return getEntrySet();
    }
}

