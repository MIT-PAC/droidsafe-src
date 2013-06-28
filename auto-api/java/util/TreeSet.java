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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.610 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.610 -0400", hash_original_field = "F752AC86FECEB80205687BD2EE098477", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.611 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "713D545DDA5D47E810CF2A8F6B76FB4D")
      TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.611 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    public  TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.611 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "F2832DEC7FDA6AF5CCA177510CDC1FBB")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.611 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "CFEA0A2BC2DBD194D4AE909A3DEB5CC0")
    public  TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.612 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "89C30F8EED34AF07C5D86E132347ED5C")
    public  TreeSet(SortedSet<E> set) {
        this(set.comparator());
        Iterator<E> it = set.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1203503047 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.612 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "5CE247091802CF3F07D5C3BBE2BCD28C")
    @Override
    public boolean add(E object) {
        boolean var11FC92389CAF520FD977B83A180CD90D_1746034061 = (backingMap.put(object, Boolean.TRUE) == null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995881587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_995881587;
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.612 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "722E479E6868F71BB0DE3C625C71E31C")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean varEB611C777D04833FE5AA6B71D18D3718_1504909848 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130572036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130572036;
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.612 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.613 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "AB6AC2129DE6694373023935F51729AB")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_585100115 = null; //Variable for return #1
        try 
        {
            TreeSet<E> clone = (TreeSet<E>) super.clone();
            {
                clone.backingMap = (NavigableMap<E, Object>) ((TreeMap<E, Object>) backingMap)
                        .clone();
            } //End block
            {
                clone.backingMap = new TreeMap<E, Object>(backingMap);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_585100115 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_585100115.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585100115;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.614 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "14DBB9E46FDEE2BC372DA272C52E97A9")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_838329305 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838329305 = backingMap.comparator();
        varB4EAC82CA7396A68D541C85D26508E83_838329305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838329305;
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.615 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "14C0AB0DF9186789F04476C089768864")
    @Override
    public boolean contains(Object object) {
        boolean var8C8A172B56440FCA5388504D06A94C78_198722944 = (backingMap.containsKey(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835562779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835562779;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.615 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "1C82A31B7A165730E81BA311F2E5399A")
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_1200487350 = (backingMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045563782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045563782;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.616 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "6BAA731513DC6172571E64211D794863")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_600859065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_600859065 = backingMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_600859065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_600859065;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.616 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "AED0B1693CF216307FF9454E456609AC")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_185284656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_185284656 = descendingSet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_185284656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185284656;
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.616 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "44F1C395E9731C802E2EEB6DADC1BD5B")
    @Override
    public boolean remove(Object object) {
        boolean var98D11DCD88E6747113E0C18E00445AFD_1418767377 = (backingMap.remove(object) != null);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136410846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136410846;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.617 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "9D3158DBE90225FA324C01DD62084068")
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_246206447 = (backingMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244265646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244265646;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.617 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "AEFC462D48D933A38BBFC98C37F63716")
    public E first() {
        E varB4EAC82CA7396A68D541C85D26508E83_253824266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_253824266 = backingMap.firstKey();
        varB4EAC82CA7396A68D541C85D26508E83_253824266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_253824266;
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.617 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "9492E55FFC5E90B8E0A5213804FFCF4C")
    public E last() {
        E varB4EAC82CA7396A68D541C85D26508E83_1657277277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1657277277 = backingMap.lastKey();
        varB4EAC82CA7396A68D541C85D26508E83_1657277277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1657277277;
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.618 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "8A9799B018C91EBC1E67DCAB6150C75A")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_302553876 = null; //Variable for return #1
        Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        varB4EAC82CA7396A68D541C85D26508E83_302553876 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_302553876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_302553876;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.618 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "D668A837345A112BE4B8FE4AE4C55745")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1514492786 = null; //Variable for return #1
        Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        varB4EAC82CA7396A68D541C85D26508E83_1514492786 = (entry == null) ? null : entry.getKey();
        varB4EAC82CA7396A68D541C85D26508E83_1514492786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514492786;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.619 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "AF8834D50357E6D43CBA4D8CCFDF84F6")
    public E higher(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_2010152399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2010152399 = backingMap.higherKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2010152399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010152399;
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.619 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "7FC04A0231BF23C2FC53801CC4AF5E6C")
    public E lower(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_2123793889 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2123793889 = backingMap.lowerKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2123793889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2123793889;
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.619 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "3441CD9FE441FF5446D2816FA2391F08")
    public E ceiling(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_367817579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_367817579 = backingMap.ceilingKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_367817579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_367817579;
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.620 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "C881E515A02A70632260737B5DE056D7")
    public E floor(E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_438437353 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_438437353 = backingMap.floorKey(e);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_438437353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_438437353;
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.620 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "0CF5BCAE6A0073227C68E7D841D4ACC8")
    public NavigableSet<E> descendingSet() {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_964252592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_964252592 = (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
        varB4EAC82CA7396A68D541C85D26508E83_964252592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964252592;
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.621 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "C6E60360F2D3B37949DF4FC6288B6D39")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_1769407734 = null; //Variable for return #1
        Comparator<? super E> c = backingMap.comparator();
        int compare;
        compare = ((Comparable<E>) start).compareTo(end);
        compare = c
                .compare(start, end);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1769407734 = new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(start.getTaint());
        addTaint(startInclusive);
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_1769407734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1769407734;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.621 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "882511C1F6B173CB38EA7884F5C53E58")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_2127069566 = null; //Variable for return #1
        Comparator<? super E> c = backingMap.comparator();
        {
            ((Comparable<E>) end).compareTo(end);
        } //End block
        {
            c.compare(end, end);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2127069566 = new TreeSet<E>(backingMap.headMap(end, endInclusive));
        addTaint(end.getTaint());
        addTaint(endInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_2127069566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2127069566;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.622 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "F492422C6023238739D6362C36D6EEA1")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        NavigableSet<E> varB4EAC82CA7396A68D541C85D26508E83_861834273 = null; //Variable for return #1
        Comparator<? super E> c = backingMap.comparator();
        {
            ((Comparable<E>) start).compareTo(start);
        } //End block
        {
            c.compare(start, start);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_861834273 = new TreeSet<E>(backingMap.tailMap(start, startInclusive));
        addTaint(start.getTaint());
        addTaint(startInclusive);
        varB4EAC82CA7396A68D541C85D26508E83_861834273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861834273;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.622 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "CB5D9EC2129C05C44BBE069FA68C81CD")
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1595544572 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1595544572 = subSet(start, true, end, false);
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1595544572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1595544572;
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.622 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "02CD67114F1347ACEA9D594E0AF14892")
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1398849861 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1398849861 = headSet(end, false);
        addTaint(end.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1398849861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1398849861;
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.623 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "E527018432836262C62B1CA3D372F755")
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        SortedSet<E> varB4EAC82CA7396A68D541C85D26508E83_1308720091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1308720091 = tailSet(start, true);
        addTaint(start.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1308720091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1308720091;
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.623 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "4138316B009BD2BB1BA6BA1CC7C24F98")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(backingMap.comparator());
        int size = backingMap.size();
        stream.writeInt(size);
        {
            Iterator<E> it = backingMap.keySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_798488573 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.624 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "0E5CA6B2368F9CB25CE43BE7C60DB9DC")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        stream.defaultReadObject();
        TreeMap<E, Object> map = new TreeMap<E, Object>(
                (Comparator<? super E>) stream.readObject());
        int size = stream.readInt();
        {
            {
                int i = 0;
                {
                    E elem = (E)stream.readObject();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.624 -0400", hash_original_field = "550B431A108A77E6266129D6FCEE4BC8", hash_generated_field = "31AEFE2A50D43E7000DE1CE15A90AC24")

    private static final long serialVersionUID = -2479143000061671589L;
}

