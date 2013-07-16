package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.802 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.802 -0400", hash_original_field = "F752AC86FECEB80205687BD2EE098477", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.802 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "713D545DDA5D47E810CF2A8F6B76FB4D")
      TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.802 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    public  TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.803 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "9295DFAB1B2A4F093CB6CC0F48F4D93E")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addTaint(collection.getTaint());
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.803 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "CFEA0A2BC2DBD194D4AE909A3DEB5CC0")
    public  TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.803 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "8579ACDFD797832733E22A12F5CADD5D")
    public  TreeSet(SortedSet<E> set) {
        this(set.comparator());
        addTaint(set.getTaint());
        Iterator<E> it = set.iterator();
        while
(it.hasNext())        
        {
            add(it.next());
        } //End block
        // ---------- Original Method ----------
        //Iterator<E> it = set.iterator();
        //while (it.hasNext()) {
            //add(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.804 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "6F8DD97DDCC066EEC63172928CEDCAC7")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        boolean varD60CB9740AF9ADF1C1738457341FC387_75558498 = (backingMap.put(object, Boolean.TRUE) == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204266452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_204266452;
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.804 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "70DE8F4B9A3909B1297D920D44B9A2D2")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean varB2042CE01B55200C7258CBFA6D7E5E4D_795773201 = (super.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476920029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476920029;
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.805 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.805 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "A401B57B6B54FD7232EE62C432E460DC")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        try 
        {
            TreeSet<E> clone = (TreeSet<E>) super.clone();
    if(backingMap instanceof TreeMap)            
            {
                clone.backingMap = (NavigableMap<E, Object>) ((TreeMap<E, Object>) backingMap)
                        .clone();
            } //End block
            else
            {
                clone.backingMap = new TreeMap<E, Object>(backingMap);
            } //End block
Object var3DE52045BFD3C1BF3742F994ED6139AD_637856886 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_637856886.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_637856886;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1250626491 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1250626491.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1250626491;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.806 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "20B91727CAB937581AB8A51C230A52BA")
    public Comparator<? super E> comparator() {
Comparator<? super E> var0DBA3D9CD77859DED745A0BFA4F2ACEF_1623227004 =         backingMap.comparator();
        var0DBA3D9CD77859DED745A0BFA4F2ACEF_1623227004.addTaint(taint);
        return var0DBA3D9CD77859DED745A0BFA4F2ACEF_1623227004;
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.806 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "1E60747369B3E57CAED1D73121A6F030")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        boolean varCF24D41E57936BE41D5FE9FB10A983AA_824604061 = (backingMap.containsKey(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076176653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076176653;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.806 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "1B4EE553B1845866A3993350940D8884")
    @Override
    public boolean isEmpty() {
        boolean var7BD8146BDE90DE51E94F2CB6ADD61030_224948036 = (backingMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532494570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532494570;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.807 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "D443CF63BA615D6F84481287DD6AF7D0")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var286E0827A1FF5574E4CA8F3B053AEA56_2017070029 =         backingMap.keySet().iterator();
        var286E0827A1FF5574E4CA8F3B053AEA56_2017070029.addTaint(taint);
        return var286E0827A1FF5574E4CA8F3B053AEA56_2017070029;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.807 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "1C1BDA3E6A1926F70E7E978F1BB3D971")
    public Iterator<E> descendingIterator() {
Iterator<E> varD3454307C396409E194901FB5FF7ED83_1302659798 =         descendingSet().iterator();
        varD3454307C396409E194901FB5FF7ED83_1302659798.addTaint(taint);
        return varD3454307C396409E194901FB5FF7ED83_1302659798;
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.807 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "0A2C6B1D2748C6D8DB982DCF2F662DEC")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean varB16028B3BA82A3A21D2A6955BEBAAB22_1122633421 = (backingMap.remove(object) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925120873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925120873;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.807 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "27F5E3BE09D41B13EB782BEAF52C682C")
    @Override
    public int size() {
        int var6EE8E77D231E7BE340B3674D400AE2A8_605228609 = (backingMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899551384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899551384;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.808 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "0BA6B0A0F8C1096C0F6F8520ABE3DC1A")
    public E first() {
E var8DB841A69B1D735980AF64DA2B78D0EC_1824334429 =         backingMap.firstKey();
        var8DB841A69B1D735980AF64DA2B78D0EC_1824334429.addTaint(taint);
        return var8DB841A69B1D735980AF64DA2B78D0EC_1824334429;
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.808 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "ABAD470F7110BC794453EEBDD11D2072")
    public E last() {
E var2C2B2EBC96908803319022A0DEF6CB15_1083319558 =         backingMap.lastKey();
        var2C2B2EBC96908803319022A0DEF6CB15_1083319558.addTaint(taint);
        return var2C2B2EBC96908803319022A0DEF6CB15_1083319558;
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.808 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "2540FED7E3C8FCF6B7D8D94F0724A5DE")
    public E pollFirst() {
        Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
E varAAB8B0B77C6EA53269B891049D031A51_1194621196 =         (entry == null) ? null : entry.getKey();
        varAAB8B0B77C6EA53269B891049D031A51_1194621196.addTaint(taint);
        return varAAB8B0B77C6EA53269B891049D031A51_1194621196;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.809 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "BBEBAAD61D9D05FB2EE0C2DB5816F3F7")
    public E pollLast() {
        Map.Entry<E, Object> entry = backingMap.pollLastEntry();
E varAAB8B0B77C6EA53269B891049D031A51_339854002 =         (entry == null) ? null : entry.getKey();
        varAAB8B0B77C6EA53269B891049D031A51_339854002.addTaint(taint);
        return varAAB8B0B77C6EA53269B891049D031A51_339854002;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.809 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "03DE1B6D0EC0E362622E2301A81404BD")
    public E higher(E e) {
        addTaint(e.getTaint());
E varC6C81EAEF2C464D73BE5EA1C987CA06B_342089204 =         backingMap.higherKey(e);
        varC6C81EAEF2C464D73BE5EA1C987CA06B_342089204.addTaint(taint);
        return varC6C81EAEF2C464D73BE5EA1C987CA06B_342089204;
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.809 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "E34205D624EADE6ED942978F6401FF61")
    public E lower(E e) {
        addTaint(e.getTaint());
E var2DDBCD2256760211E3C0FF2C55B1D44F_1863948877 =         backingMap.lowerKey(e);
        var2DDBCD2256760211E3C0FF2C55B1D44F_1863948877.addTaint(taint);
        return var2DDBCD2256760211E3C0FF2C55B1D44F_1863948877;
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.810 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "E8A316D3D23FA0ABD4095F9FC546BFA9")
    public E ceiling(E e) {
        addTaint(e.getTaint());
E var9543504692B376FEAF1B79BFE5FAB480_1290282709 =         backingMap.ceilingKey(e);
        var9543504692B376FEAF1B79BFE5FAB480_1290282709.addTaint(taint);
        return var9543504692B376FEAF1B79BFE5FAB480_1290282709;
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.810 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "37EE6DE7E4886ACD8D1401A5DC818BD9")
    public E floor(E e) {
        addTaint(e.getTaint());
E var1BCF47557897205FD48AB0A73F410791_977425230 =         backingMap.floorKey(e);
        var1BCF47557897205FD48AB0A73F410791_977425230.addTaint(taint);
        return var1BCF47557897205FD48AB0A73F410791_977425230;
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.810 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "D61913BF578DCF380779A9A15A5D51DB")
    public NavigableSet<E> descendingSet() {
NavigableSet<E> varBE5ABA3BE0A68913A56946E2DC797D44_1728038624 =         (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
        varBE5ABA3BE0A68913A56946E2DC797D44_1728038624.addTaint(taint);
        return varBE5ABA3BE0A68913A56946E2DC797D44_1728038624;
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.811 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "865F11593DC977ECCB1E46017CC285D7")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> subSet(E start, boolean startInclusive, E end,
            boolean endInclusive) {
        addTaint(endInclusive);
        addTaint(end.getTaint());
        addTaint(startInclusive);
        addTaint(start.getTaint());
        Comparator<? super E> c = backingMap.comparator();
        int compare = (c == null) ? ((Comparable<E>) start).compareTo(end) : c
                .compare(start, end);
    if(compare <= 0)        
        {
NavigableSet<E> varDC3CDC9203794F796454BC9DF4EF62E9_1680170164 =             new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
            varDC3CDC9203794F796454BC9DF4EF62E9_1680170164.addTaint(taint);
            return varDC3CDC9203794F796454BC9DF4EF62E9_1680170164;
        } //End block
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1045362708 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1045362708.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1045362708;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.811 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "7FFA45B81D5B7F07C64BF75F19DB7CD3")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> headSet(E end, boolean endInclusive) {
        addTaint(endInclusive);
        addTaint(end.getTaint());
        Comparator<? super E> c = backingMap.comparator();
    if(c == null)        
        {
            ((Comparable<E>) end).compareTo(end);
        } //End block
        else
        {
            c.compare(end, end);
        } //End block
NavigableSet<E> varE70D8A145633D64A8635027DBE800D01_1842941522 =         new TreeSet<E>(backingMap.headMap(end, endInclusive));
        varE70D8A145633D64A8635027DBE800D01_1842941522.addTaint(taint);
        return varE70D8A145633D64A8635027DBE800D01_1842941522;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.812 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "ECE4E1E3A8B3143ADD65ACB276FEE81C")
    @SuppressWarnings("unchecked")
    public NavigableSet<E> tailSet(E start, boolean startInclusive) {
        addTaint(startInclusive);
        addTaint(start.getTaint());
        Comparator<? super E> c = backingMap.comparator();
    if(c == null)        
        {
            ((Comparable<E>) start).compareTo(start);
        } //End block
        else
        {
            c.compare(start, start);
        } //End block
NavigableSet<E> varC3FFFEAE2889574A248CD2F5AEC2B9B2_1870377889 =         new TreeSet<E>(backingMap.tailMap(start, startInclusive));
        varC3FFFEAE2889574A248CD2F5AEC2B9B2_1870377889.addTaint(taint);
        return varC3FFFEAE2889574A248CD2F5AEC2B9B2_1870377889;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.813 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "E15BA2A217214B44973351641D640384")
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
SortedSet<E> varA297EA4DB647E5B963067A175A15005C_1155946692 =         subSet(start, true, end, false);
        varA297EA4DB647E5B963067A175A15005C_1155946692.addTaint(taint);
        return varA297EA4DB647E5B963067A175A15005C_1155946692;
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.813 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "1A184C987B566F1568064236AFF33996")
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        addTaint(end.getTaint());
SortedSet<E> var7C238F126E56EB43F3B9FF21E31CFC21_2124932924 =         headSet(end, false);
        var7C238F126E56EB43F3B9FF21E31CFC21_2124932924.addTaint(taint);
        return var7C238F126E56EB43F3B9FF21E31CFC21_2124932924;
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.813 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "6A49142DF6E3093354A4E44535051139")
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        addTaint(start.getTaint());
SortedSet<E> var7589F3441938F46E6B7F60EEE098D2C9_1292173341 =         tailSet(start, true);
        var7589F3441938F46E6B7F60EEE098D2C9_1292173341.addTaint(taint);
        return var7589F3441938F46E6B7F60EEE098D2C9_1292173341;
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.814 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "940DF24CEADDE5B85FB9004AE02DD3F0")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeObject(backingMap.comparator());
        int size = backingMap.size();
        stream.writeInt(size);
    if(size > 0)        
        {
            Iterator<E> it = backingMap.keySet().iterator();
            while
(it.hasNext())            
            {
                stream.writeObject(it.next());
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.814 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "89ACA855706A3BF26CB57C84BA9D9FF8")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        TreeMap<E, Object> map = new TreeMap<E, Object>(
                (Comparator<? super E>) stream.readObject());
        int size = stream.readInt();
    if(size > 0)        
        {
for(int i=0;i<size;i++)
            {
                E elem = (E)stream.readObject();
                map.put(elem, Boolean.TRUE);
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.814 -0400", hash_original_field = "550B431A108A77E6266129D6FCEE4BC8", hash_generated_field = "31AEFE2A50D43E7000DE1CE15A90AC24")

    private static final long serialVersionUID = -2479143000061671589L;
}

