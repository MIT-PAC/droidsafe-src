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
    private transient NavigableMap<E, Object> backingMap;
    private transient NavigableSet<E> descendingSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.135 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "A8CB59258E6A52251309E9A581B1561F")
    @DSModeled(DSC.SAFE)
     TreeSet(NavigableMap<E, Object> map) {
        dsTaint.addTaint(map.dsTaint);
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.136 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.136 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "F7EBD0663C71A584A3588871A3D3FEC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeSet(Collection<? extends E> collection) {
        this();
        dsTaint.addTaint(collection.dsTaint);
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.136 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "9EDEFE2052944B4F5101C0A53868A950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeSet(Comparator<? super E> comparator) {
        dsTaint.addTaint(comparator.dsTaint);
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.136 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "E00339A91A80049B894BC319A3E62656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TreeSet(SortedSet<E> set) {
        this(set.comparator());
        dsTaint.addTaint(set.dsTaint);
        Iterator<E> it;
        it = set.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1765623966 = (it.hasNext());
            {
                add(it.next());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<E> it = set.iterator();
        //while (it.hasNext()) {
            //add(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.136 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "F19B92025F4579FB6860BB16F112060F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var11FC92389CAF520FD977B83A180CD90D_1262403300 = (backingMap.put(object, Boolean.TRUE) == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.137 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "36456CE32F44A18E53AAC1D60DA83AAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varEB611C777D04833FE5AA6B71D18D3718_1996736574 = (super.addAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.137 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.137 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "61A82D266CE446DA764588A24F026686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
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
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.137 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "79CFF9152C3F4C91D0A4578AC0BB129F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Comparator<? super E> comparator() {
        Comparator<? super E> var2C52CFFDBFF417863D2B0516C954CCA1_54466677 = (backingMap.comparator());
        return (Comparator<? super E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.137 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "68B5F6F1C2E60D7F42E526F487A3F7C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var8C8A172B56440FCA5388504D06A94C78_1525161340 = (backingMap.containsKey(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "DCFA3670CB0C6ECD06F214266CDFA03A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        boolean var464ACE96CC0DD3CAECB5B8FB8B604A65_80383866 = (backingMap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "26D09AE16E9B937ABEB6B54F7A0A2A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var293C31D1F85E54807389D3B230374261_997375996 = (backingMap.keySet().iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "95494E8DAE68500E99A2C0FA16561389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> descendingIterator() {
        Iterator<E> varCBD4BA1D5309F305A5CC3D9E3B2B195E_1466943032 = (descendingSet().iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "CCFB74F25FCDEA423CB6709847510563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var98D11DCD88E6747113E0C18E00445AFD_1998708078 = (backingMap.remove(object) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "3DA1A1365C7243F0CCA28C3C2FDEB904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int size() {
        int var032620A97F2DD5F1797DCEF9404A5B27_487863786 = (backingMap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.138 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "90CC8DF38B4175CD61EA7BB450F25BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E first() {
        E var1337B2912AF9E0F03DC9987135CFCC72_1332724786 = (backingMap.firstKey());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.139 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "C6A68DB2A865C24E483AC775ACB6F7B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E last() {
        E var1694F4A53C0C73655F23A80C8C9923ED_2120248784 = (backingMap.lastKey());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.139 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "329B583F2D5184D6398CB5FB2947C75D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollFirst() {
        Map.Entry<E, Object> entry;
        entry = backingMap.pollFirstEntry();
        {
            Object var4B8D962F1524E92662DE034798AAC65A_2053439930 = (entry.getKey());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.139 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "E6C57083C6020742A73759049D265BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollLast() {
        Map.Entry<E, Object> entry;
        entry = backingMap.pollLastEntry();
        {
            Object var4B8D962F1524E92662DE034798AAC65A_1297083414 = (entry.getKey());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.139 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "8C5B79A6CFF2858C4BD04794965D2E45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E higher(E e) {
        dsTaint.addTaint(e.dsTaint);
        E var1E851E5F7C80CF273E9AD4BCF8E807AD_1039788138 = (backingMap.higherKey(e));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.140 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "FFB64C9360563A80B73CE09DCD02D582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E lower(E e) {
        dsTaint.addTaint(e.dsTaint);
        E var4BE1C4997B9F79E6C761F531DCF46446_1030985526 = (backingMap.lowerKey(e));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.140 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "9C53A57784680D6F630A8A2AA8034DDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E ceiling(E e) {
        dsTaint.addTaint(e.dsTaint);
        E var769E5CF3432270C1CD1406B49F4399F0_2035345072 = (backingMap.ceilingKey(e));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.140 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "ECB14DA11232AA1D01D148AC94D2F428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E floor(E e) {
        dsTaint.addTaint(e.dsTaint);
        E var093581435BDE76C4D5B47B3B84C8AC57_2000540512 = (backingMap.floorKey(e));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.140 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "3C93A5917A202F9AECB2853DBD85705B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NavigableSet<E> descendingSet() {
        {
            Object varB2E6B1CFE3CE98F59BCC5D0A939459F8_178482227 = ((descendingSet = new TreeSet<E>(backingMap.descendingMap())));
        } //End flattened ternary
        return (NavigableSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.140 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "EEE3E9FBEFF1BC6242A57B29298CA33A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        dsTaint.addTaint(endInclusive);
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(startInclusive);
        dsTaint.addTaint(end.dsTaint);
        Comparator<? super E> c;
        c = backingMap.comparator();
        int compare;
        compare = ((Comparable<E>) start).compareTo(end);
        compare = c
                .compare(start, end);
        {
            NavigableSet<E> var374B6B62F482C2FD99139D7EA0ABF569_1162592639 = (new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive)));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        return (NavigableSet<E>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.141 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "B0DF9D61B7149C6EC62DD20799D19436")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        dsTaint.addTaint(endInclusive);
        dsTaint.addTaint(end.dsTaint);
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) end).compareTo(end);
        } //End block
        {
            c.compare(end, end);
        } //End block
        NavigableSet<E> varDB97F5A59C78E001B567E9060FAD22ED_893440519 = (new TreeSet<E>(backingMap.headMap(end, endInclusive)));
        return (NavigableSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.141 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "B980F631DC0D8DF9D305227F17083584")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(startInclusive);
        Comparator<? super E> c;
        c = backingMap.comparator();
        {
            ((Comparable<E>) start).compareTo(start);
        } //End block
        {
            c.compare(start, start);
        } //End block
        NavigableSet<E> var228AA69F9737335F5ACE0A13FF7239E6_1376737881 = (new TreeSet<E>(backingMap.tailMap(start, startInclusive)));
        return (NavigableSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.141 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "9DFE87AFFD43A64F6E95FCF832F723C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(end.dsTaint);
        SortedSet<E> var6E7530F06FB10DCFDE2B84E408446E41_664155597 = (subSet(start, true, end, false));
        return (SortedSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.141 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "2C5D689E3405F83CAC54E453AD15E91F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        dsTaint.addTaint(end.dsTaint);
        SortedSet<E> varAD84437A04E0128FFE459401371600E4_280433234 = (headSet(end, false));
        return (SortedSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.141 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "03C94AA820B01812962647814DB81E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        dsTaint.addTaint(start.dsTaint);
        SortedSet<E> varE75B02EC0CB12C355F9C47CA563BFBCF_1191222464 = (tailSet(start, true));
        return (SortedSet<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.142 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "584B7FE9E4BFBCE89A1201C1D3A9D8A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeObject(backingMap.comparator());
        int size;
        size = backingMap.size();
        stream.writeInt(size);
        {
            Iterator<E> it;
            it = backingMap.keySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1562569512 = (it.hasNext());
                {
                    stream.writeObject(it.next());
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.142 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "29B64701C5D22E42FF673967BF47B6AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
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

    
    private static final long serialVersionUID = -2479143000061671589L;
}

