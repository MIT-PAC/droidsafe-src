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

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.402 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.403 -0400", hash_original_field = "F752AC86FECEB80205687BD2EE098477", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.411 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "713D545DDA5D47E810CF2A8F6B76FB4D")
      TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.414 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    public  TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.415 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "F2832DEC7FDA6AF5CCA177510CDC1FBB")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.415 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "CFEA0A2BC2DBD194D4AE909A3DEB5CC0")
    public  TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.415 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "773E78773E252A1B54470F1019F6159E")
    public  TreeSet(SortedSet<E> set) {
        this(set.comparator());
        Iterator<E> it;
        it = set.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_481418033 = (it.hasNext());
            {
                add(it.next());
            } //End block
        } //End collapsed parenthetic
        addTaint(set.getTaint());
        // ---------- Original Method ----------
        //Iterator<E> it = set.iterator();
        //while (it.hasNext()) {
            //add(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.416 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "EEFA551D387F39D80324D33D6589B86F")
    @Override
    public boolean add(E object) {
        boolean var11FC92389CAF520FD977B83A180CD90D_1237711862 = (backingMap.put(object, Boolean.TRUE) == null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135554202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135554202;
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.417 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "D1FC699FC57EA515DCCAE18935A22900")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean varEB611C777D04833FE5AA6B71D18D3718_167950998 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1286783474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1286783474;
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.417 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.426 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "FEEEA12177F42355CE7E921C541BE7E3")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_319599426 = null; //Variable for return #1
        try 
        {
            TreeSet<E> clone;
            clone = (TreeSet<E>) super.clone();
            {
                clone.backingMap = (NavigableMap<E, Object>) ((TreeMap<E, Object>) backingMap)
                        .clone();
            } //End block
            {
                clone.backingMap = new TreeMap<E, Object>(backingMap);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_319599426 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_319599426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_319599426;
        // ---------- Original Method ----------
        //try {
            //TreeSet<E> clone = (TreeSet<E>) super.clone();
            //if (backingMap instanceof TreeMap) {
                //clone.backingMap = (NavigableMap<E, Object>) ((TreeMap<E, Object>) backingMap)
                        //.clone();
            //} else {
                //clone.backingMap = new TreeMap<E, Object>(backingMap);
            //}
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.426 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "695F1EB5A6DDF6405E9BB965EAA8EBB5")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1051060174 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1051060174 = backingMap.comparator();
        varB4EAC82CA7396A68D541C85D26508E83_1051060174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051060174;
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.427 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "4807FB1FC3AD0F8A6B51BC192ECACB00")
    @Override
    public boolean contains(Object object) {
        boolean var8C8A172B56440FCA5388504D06A94C78_2143478542 = (backingMap.containsKey(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722524376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722524376;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.427 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "1A4250C0F0B32C0424FF4600C524A50D")
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_1199999756 = (backingMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942255541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942255541;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.428 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "0208B70E3A3CCAA464B5F70BFCBD0FDA")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1252223176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1252223176 = backingMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1252223176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1252223176;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.428 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "14C71A90EEC23C20A5D51C65C649D651")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_557450725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_557450725 = descendingSet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_557450725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557450725;
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.428 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "E21D0C96A810BFF341EF99C4644D8EEE")
    @Override
    public boolean remove(Object object) {
        boolean var98D11DCD88E6747113E0C18E00445AFD_857959034 = (backingMap.remove(object) != null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108371865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108371865;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.429 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "0075EB6E2AC506092F81BDA63256492E")
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_228619949 = (backingMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487093755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487093755;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.448 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "5A72803662E6E41BDB373C0C93DCB9E4")
    public E first() {
        E varB4EAC82CA7396A68D541C85D26508E83_1279187171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1279187171 = backingMap.firstKey();
        varB4EAC82CA7396A68D541C85D26508E83_1279187171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279187171;
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.449 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "EA639EDA5EFFC2D52D8C380FF6BAFD2E")
    public E last() {
        E varB4EAC82CA7396A68D541C85D26508E83_133915584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_133915584 = backingMap.lastKey();
        varB4EAC82CA7396A68D541C85D26508E83_133915584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_133915584;
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.449 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "B65B3BF892340E973391C4748A3643EA")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_106177560 = null; //Variable for return #1
        Map.Entry<E, Object> entry;
        entry = backingMap.pollFirstEntry();
        varB4EAC82CA7396A68D541C85D26508E83_106177560 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_106177560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106177560;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.450 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "61903C36936532A4749B526C8639E1D1")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1603037594 = null; //Variable for return #1
        Map.Entry<E, Object> entry;
        entry = backingMap.pollLastEntry();
        varB4EAC82CA7396A68D541C85D26508E83_1603037594 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1603037594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603037594;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.458 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "FD498C6E929FDE3F37088807EDA7FAA1")
    public E higher(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_2080958884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2080958884 = backingMap.higherKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2080958884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2080958884;
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.459 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "A0000BB8F248BFA15CAF50A9854B4F9B")
    public E lower(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_1769269146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1769269146 = backingMap.lowerKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1769269146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1769269146;
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.459 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "4A70C8B98F862B7D1B7C175404E44804")
    public E ceiling(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_529657887 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_529657887 = backingMap.ceilingKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_529657887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_529657887;
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.460 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "6059BEC3B2F0FA3685A4A0A0C541AC5F")
    public E floor(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_54666584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_54666584 = backingMap.floorKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_54666584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_54666584;
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.461 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "CF8EBF387E08EAE033A242D6CFA04AD9")
    public NavigableSet<E> descendingSet() {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_947239776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_947239776 = (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
        varB4EAC82CA7396A68D541C85D26508E83_947239776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947239776;
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.461 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "8561EE651F4AD8AAC2B68E547D77D702")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_860978292 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        int compare;
        compare = ((Comparable<E>) start).compareTo(end);
        compare = c
                .compare(start, end);
        {
            varB4EAC82CA7396A68D541C85D26508E83_860978292 = new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(start.getTaint());
        addTaint(startInclusive);
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_860978292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_860978292;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //int compare = (c == null) ? ((Comparable<E>) start).compareTo(end) : c
                //.compare(start, end);
        //if (compare <= 0) {
            //return new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    //endInclusive));
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.478 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "F0E1C82119C2487F708BEE11FC227115")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_23733371 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) end).compareTo(end);
        } //End block
        {
            c.compare(end, end);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_23733371 = new TreeSet<E>(backingMap.headMap(end, endInclusive));
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_23733371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_23733371;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.478 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "F8C50B59727C200805E488FF7898AB6C")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_365813027 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) start).compareTo(start);
        } //End block
        {
            c.compare(start, start);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_365813027 = new TreeSet<E>(backingMap.tailMap(start, startInclusive));
        addTaint(start.getTaint());
        addTaint(startInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_365813027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_365813027;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.479 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "29F110EAE5E510608EF2DC5FF69E1A8A")
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1087577295 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1087577295 = subSet(start, true, end, false);
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1087577295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1087577295;
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.479 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "2BDCC19798BBDB57FB7624DB692D58FC")
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1847077176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1847077176 = headSet(end, false);
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1847077176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847077176;
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.480 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "E49F66C61F13BA8F9DAA0A52866D9AC0")
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_371744049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_371744049 = tailSet(start, true);
        addTaint(start.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_371744049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371744049;
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.480 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "9C5BA587DE78574EFDF45AB738EC5113")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(backingMap.comparator());
        int size;
        size = backingMap.size();
        stream.writeInt(size);
        {
            Iterator<E> it;
            it = backingMap.keySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_839690458 = (it.hasNext());
                {
                    stream.writeObject(it.next());
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeObject(backingMap.comparator());
        //int size = backingMap.size();
        //stream.writeInt(size);
        //if (size > 0) {
            //Iterator<E> it = backingMap.keySet().iterator();
            //while (it.hasNext()) {
                //stream.writeObject(it.next());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.481 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "E616F545E82DF13E7FC8A1A3BC34776E")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        TreeMap<E, Object> map;
        map = new TreeMap<E, Object>(
                (Comparator<? super E>) stream.readObject());
        int size;
        size = stream.readInt();
        {
            {
                int i;
                i = 0;
                {
                    E elem;
                    elem = (E)stream.readObject();
                    map.put(elem, Boolean.TRUE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        backingMap = map;
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //TreeMap<E, Object> map = new TreeMap<E, Object>(
                //(Comparator<? super E>) stream.readObject());
        //int size = stream.readInt();
        //if (size > 0) {
            //for (int i=0; i<size; i++) {
                //E elem = (E)stream.readObject();
                //map.put(elem, Boolean.TRUE);
            //}
        //}
        //backingMap = map;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.481 -0400", hash_original_field = "550B431A108A77E6266129D6FCEE4BC8", hash_generated_field = "1010265C6757D26185BD8C3D4EE4742E")

    private static long serialVersionUID = -2479143000061671589L;
}

