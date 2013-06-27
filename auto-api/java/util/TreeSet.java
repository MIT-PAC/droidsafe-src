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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.583 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.583 -0400", hash_original_field = "F752AC86FECEB80205687BD2EE098477", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.583 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "713D545DDA5D47E810CF2A8F6B76FB4D")
      TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.583 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    public  TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.584 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "F2832DEC7FDA6AF5CCA177510CDC1FBB")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.584 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "CFEA0A2BC2DBD194D4AE909A3DEB5CC0")
    public  TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.585 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "6A77DAC0BAF269578E005E4A249CAA65")
    public  TreeSet(SortedSet<E> set) {
        this(set.comparator());
        Iterator<E> it;
        it = set.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2081529030 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.585 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "6D740130C51E529D65BE0115E5ED9CB7")
    @Override
    public boolean add(E object) {
        boolean var11FC92389CAF520FD977B83A180CD90D_596751227 = (backingMap.put(object, Boolean.TRUE) == null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141813824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141813824;
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.585 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "F8693DA1166432344291F132A2066E9D")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean varEB611C777D04833FE5AA6B71D18D3718_467767506 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142116664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142116664;
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.585 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.586 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "09C5C338C550FEC413932886F3F9558E")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_536596128 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_536596128 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_536596128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_536596128;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.601 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "78AE051FBBA68C1424D7536015C74957")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1217263997 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1217263997 = backingMap.comparator();
        varB4EAC82CA7396A68D541C85D26508E83_1217263997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217263997;
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.602 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "F78FB189AEB2E317890B0A6303B2FBAC")
    @Override
    public boolean contains(Object object) {
        boolean var8C8A172B56440FCA5388504D06A94C78_723859642 = (backingMap.containsKey(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002784002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002784002;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.602 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "ADC775D5377EA2CE5CABD9735D77C8B8")
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_1636874818 = (backingMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794553320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_794553320;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.603 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "9534E35A9F7F36348A2F5C2C72F37304")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_155210701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_155210701 = backingMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_155210701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_155210701;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.604 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "09D039772D5CBEC7E78F96EE8E15F8F0")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_678798980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_678798980 = descendingSet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_678798980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_678798980;
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.604 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "10AD2E6B1B7B0C6693C9E5847C0C7E44")
    @Override
    public boolean remove(Object object) {
        boolean var98D11DCD88E6747113E0C18E00445AFD_86813257 = (backingMap.remove(object) != null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109687898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109687898;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.620 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "43A372C74BA35342AEAB7EDED7DCE957")
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_1904434502 = (backingMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514771793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514771793;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.620 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "1055C19F991A52ED81AF87045DE5DB55")
    public E first() {
        E varB4EAC82CA7396A68D541C85D26508E83_1403643755 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1403643755 = backingMap.firstKey();
        varB4EAC82CA7396A68D541C85D26508E83_1403643755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1403643755;
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.621 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "45CAB2AFA6DCA51E34C0F4C5049D8E3C")
    public E last() {
        E varB4EAC82CA7396A68D541C85D26508E83_1814171275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1814171275 = backingMap.lastKey();
        varB4EAC82CA7396A68D541C85D26508E83_1814171275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1814171275;
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.621 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "2904E95EE3057672E3C88E249F7CC0D1")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1628242663 = null; //Variable for return #1
        Map.Entry<E, Object> entry;
        entry = backingMap.pollFirstEntry();
        varB4EAC82CA7396A68D541C85D26508E83_1628242663 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1628242663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1628242663;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.622 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "C8B3427D449F7485C614453844A2F32A")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_219921531 = null; //Variable for return #1
        Map.Entry<E, Object> entry;
        entry = backingMap.pollLastEntry();
        varB4EAC82CA7396A68D541C85D26508E83_219921531 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_219921531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_219921531;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.626 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "A9E33A62F18A839F5FF5F66F3914514D")
    public E higher(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_689921455 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_689921455 = backingMap.higherKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_689921455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_689921455;
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.627 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "4CF64EA1AFBCB46887AC8DEA9EC16EDC")
    public E lower(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_1867448949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1867448949 = backingMap.lowerKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1867448949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1867448949;
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.628 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "ACE01032C7A38FC2E3F03DC28B7EFA56")
    public E ceiling(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_1542964572 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542964572 = backingMap.ceilingKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1542964572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542964572;
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.644 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "EFE10ED055564386F476A5588CEA656B")
    public E floor(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_1798369647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798369647 = backingMap.floorKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1798369647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798369647;
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.645 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "24DDECF1248A4ECE7F4A421FADFA1CD6")
    public NavigableSet<E> descendingSet() {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_1134296734 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1134296734 = (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
        varB4EAC82CA7396A68D541C85D26508E83_1134296734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1134296734;
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.645 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "E58EF85C5BC575B36E63583919D3C7DC")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_1056626528 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        int compare;
        compare = ((Comparable<E>) start).compareTo(end);
        compare = c
                .compare(start, end);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1056626528 = new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(start.getTaint());
        addTaint(startInclusive);
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1056626528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1056626528;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.651 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "40043317911C2508934F9FCC27D563C0")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_1174820476 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) end).compareTo(end);
        } //End block
        {
            c.compare(end, end);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1174820476 = new TreeSet<E>(backingMap.headMap(end, endInclusive));
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1174820476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174820476;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.676 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "8C5F1ED3CE1146909853F56F977C3BB5")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_592383532 = null; //Variable for return #1
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) start).compareTo(start);
        } //End block
        {
            c.compare(start, start);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_592383532 = new TreeSet<E>(backingMap.tailMap(start, startInclusive));
        addTaint(start.getTaint());
        addTaint(startInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_592383532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592383532;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.677 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "6E1C634291427D3C0D7A505679E5B68F")
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1613845385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1613845385 = subSet(start, true, end, false);
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1613845385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613845385;
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.678 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "AEFCC8C692994D4528AAF7299C17083D")
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1435223309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1435223309 = headSet(end, false);
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1435223309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1435223309;
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.678 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "55E12BBC0998E2DA8BB59F8FCE762F7D")
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1933502514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1933502514 = tailSet(start, true);
        addTaint(start.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1933502514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933502514;
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.682 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "E2FB8D9B193AB620DE80A1E3A05CCC2F")
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1196790025 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.682 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "E616F545E82DF13E7FC8A1A3BC34776E")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.682 -0400", hash_original_field = "550B431A108A77E6266129D6FCEE4BC8", hash_generated_field = "1010265C6757D26185BD8C3D4EE4742E")

    private static long serialVersionUID = -2479143000061671589L;
}

