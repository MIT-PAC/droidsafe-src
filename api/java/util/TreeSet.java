package java.util;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_field = "DC179BC931E5CE19266490D4C791F6F9", hash_generated_field = "C78575AC49DB698118FD5EA7F65EAFD3")

    private transient NavigableMap<E, Object> backingMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_field = "F752AC86FECEB80205687BD2EE098477", hash_generated_field = "71D5DD9C91D04D73018803CC77A3333A")

    private transient NavigableSet<E> descendingSet;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_method = "B468A43994310DE7D91A1366853F3908", hash_generated_method = "713D545DDA5D47E810CF2A8F6B76FB4D")
      TreeSet(NavigableMap<E, Object> map) {
        backingMap = map;
        // ---------- Original Method ----------
        //backingMap = map;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_method = "A94A461A61DAB692596F2C820B79ED22", hash_generated_method = "A6C5D84D9A701B6CDF74CA290070974E")
    public  TreeSet() {
        backingMap = new TreeMap<E, Object>();
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.545 -0400", hash_original_method = "98B2B75BFA703DD0E35ED82DE7014603", hash_generated_method = "9295DFAB1B2A4F093CB6CC0F48F4D93E")
    public  TreeSet(Collection<? extends E> collection) {
        this();
        addTaint(collection.getTaint());
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.546 -0400", hash_original_method = "8C746452C9FB7802CDFBFB3337D39F4C", hash_generated_method = "CFEA0A2BC2DBD194D4AE909A3DEB5CC0")
    public  TreeSet(Comparator<? super E> comparator) {
        backingMap = new TreeMap<E, Object>(comparator);
        // ---------- Original Method ----------
        //backingMap = new TreeMap<E, Object>(comparator);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.546 -0400", hash_original_method = "A9811B2E808509DC9D16313E2A4EF959", hash_generated_method = "8579ACDFD797832733E22A12F5CADD5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.546 -0400", hash_original_method = "9B08B54403475306A5EA9675D1E7EABA", hash_generated_method = "AC2D71B7CD43141208112FB4D74207EA")
    @Override
    public boolean add(E object) {
        addTaint(object.getTaint());
        boolean varD60CB9740AF9ADF1C1738457341FC387_498259844 = (backingMap.put(object, Boolean.TRUE) == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692877677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692877677;
        // ---------- Original Method ----------
        //return backingMap.put(object, Boolean.TRUE) == null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.547 -0400", hash_original_method = "1BB1690ADD81CF07967EA6BF52306E20", hash_generated_method = "599CB330DFCA58CE4EDF5DCEF03A6B22")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean varB2042CE01B55200C7258CBFA6D7E5E4D_423629502 = (super.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062431094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062431094;
        // ---------- Original Method ----------
        //return super.addAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.547 -0400", hash_original_method = "D1F4FC32E5186C24AE3390A47EF5E437", hash_generated_method = "CF81A1C669460918C76387BC42D2377A")
    @Override
    public void clear() {
        backingMap.clear();
        // ---------- Original Method ----------
        //backingMap.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.548 -0400", hash_original_method = "BDDE8348BEC59AA11A27D7FE3ECB76D9", hash_generated_method = "037128A946DAF3846E141644E35E59AD")
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
Object var3DE52045BFD3C1BF3742F994ED6139AD_1057165913 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_1057165913.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_1057165913;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1900183531 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1900183531.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1900183531;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.548 -0400", hash_original_method = "15725AB8DA5A973CA6D3756CF495713E", hash_generated_method = "AC2CCB2E1CBF3EE1A2CA3B0AF0832D9C")
    public Comparator<? super E> comparator() {
Comparator<? super E> var0DBA3D9CD77859DED745A0BFA4F2ACEF_1105889057 =         backingMap.comparator();
        var0DBA3D9CD77859DED745A0BFA4F2ACEF_1105889057.addTaint(taint);
        return var0DBA3D9CD77859DED745A0BFA4F2ACEF_1105889057;
        // ---------- Original Method ----------
        //return backingMap.comparator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "AD711C882942D0735888BB68CE9E534B", hash_generated_method = "EFE3CD0FB59A607EA89A69AFD680A82E")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        boolean varCF24D41E57936BE41D5FE9FB10A983AA_2039221783 = (backingMap.containsKey(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556609161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556609161;
        // ---------- Original Method ----------
        //return backingMap.containsKey(object);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "F7F7DD28C713C48E265211D2C1797222", hash_generated_method = "70AAEC7A82688B0D3CDBCC4299C57239")
    @Override
    public boolean isEmpty() {
        boolean var7BD8146BDE90DE51E94F2CB6ADD61030_1014760180 = (backingMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752151424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752151424;
        // ---------- Original Method ----------
        //return backingMap.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "B45AC88DE7B9594C8371B21B65FAB594", hash_generated_method = "861FF20C39960260BA63816D3660E6B9")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var286E0827A1FF5574E4CA8F3B053AEA56_1494551388 =         backingMap.keySet().iterator();
        var286E0827A1FF5574E4CA8F3B053AEA56_1494551388.addTaint(taint);
        return var286E0827A1FF5574E4CA8F3B053AEA56_1494551388;
        // ---------- Original Method ----------
        //return backingMap.keySet().iterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.549 -0400", hash_original_method = "5A7C74B47E5E24EDAEF18CEBD56ECC34", hash_generated_method = "985B1000856FE0C2D90F59DE62A312F9")
    public Iterator<E> descendingIterator() {
Iterator<E> varD3454307C396409E194901FB5FF7ED83_1681334023 =         descendingSet().iterator();
        varD3454307C396409E194901FB5FF7ED83_1681334023.addTaint(taint);
        return varD3454307C396409E194901FB5FF7ED83_1681334023;
        // ---------- Original Method ----------
        //return descendingSet().iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "F3CD9B8F3305DC4B74C3868451BADF13", hash_generated_method = "E7F5C4E0D8A52F2DCE2E5CE0B3DE43A6")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean varB16028B3BA82A3A21D2A6955BEBAAB22_3292248 = (backingMap.remove(object) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628742507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628742507;
        // ---------- Original Method ----------
        //return backingMap.remove(object) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "F79E6854B97378719F36DC505CE23018", hash_generated_method = "7E222C8299864A2524007FE778F85B5C")
    @Override
    public int size() {
        int var6EE8E77D231E7BE340B3674D400AE2A8_367864712 = (backingMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26043421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26043421;
        // ---------- Original Method ----------
        //return backingMap.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "4513FA2253D64848D60CCD34F380731F", hash_generated_method = "326AB076421601A1FA7897EB46E26059")
    public E first() {
E var8DB841A69B1D735980AF64DA2B78D0EC_1081754691 =         backingMap.firstKey();
        var8DB841A69B1D735980AF64DA2B78D0EC_1081754691.addTaint(taint);
        return var8DB841A69B1D735980AF64DA2B78D0EC_1081754691;
        // ---------- Original Method ----------
        //return backingMap.firstKey();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.550 -0400", hash_original_method = "4FE03970533DF6513B3C509D55D59969", hash_generated_method = "59265760E3EF80DCF16FAD0ABADA19DF")
    public E last() {
E var2C2B2EBC96908803319022A0DEF6CB15_126691990 =         backingMap.lastKey();
        var2C2B2EBC96908803319022A0DEF6CB15_126691990.addTaint(taint);
        return var2C2B2EBC96908803319022A0DEF6CB15_126691990;
        // ---------- Original Method ----------
        //return backingMap.lastKey();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.551 -0400", hash_original_method = "C4703F0CB955C02A45F56DAC0B50011B", hash_generated_method = "430FC412772ED928A0B8CBF86430BEE9")
    public E pollFirst() {
        Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
E varAAB8B0B77C6EA53269B891049D031A51_200037358 =         (entry == null) ? null : entry.getKey();
        varAAB8B0B77C6EA53269B891049D031A51_200037358.addTaint(taint);
        return varAAB8B0B77C6EA53269B891049D031A51_200037358;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollFirstEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.551 -0400", hash_original_method = "F4F5E61D6851DE05B80C97EFA1D29318", hash_generated_method = "EC62C48804D72E4F44AACF87C1322107")
    public E pollLast() {
        Map.Entry<E, Object> entry = backingMap.pollLastEntry();
E varAAB8B0B77C6EA53269B891049D031A51_436828406 =         (entry == null) ? null : entry.getKey();
        varAAB8B0B77C6EA53269B891049D031A51_436828406.addTaint(taint);
        return varAAB8B0B77C6EA53269B891049D031A51_436828406;
        // ---------- Original Method ----------
        //Map.Entry<E, Object> entry = backingMap.pollLastEntry();
        //return (entry == null) ? null : entry.getKey();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.551 -0400", hash_original_method = "255C56AF04920CEFFC0E8FF16D0886BA", hash_generated_method = "1FE6574B8B2F4540656DF2C68AE28FC9")
    public E higher(E e) {
        addTaint(e.getTaint());
E varC6C81EAEF2C464D73BE5EA1C987CA06B_493800358 =         backingMap.higherKey(e);
        varC6C81EAEF2C464D73BE5EA1C987CA06B_493800358.addTaint(taint);
        return varC6C81EAEF2C464D73BE5EA1C987CA06B_493800358;
        // ---------- Original Method ----------
        //return backingMap.higherKey(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.552 -0400", hash_original_method = "2923D8AB0DD9211CCF8AD13865FD4B03", hash_generated_method = "EA1021FDCAF32271A8A5815A11C735B8")
    public E lower(E e) {
        addTaint(e.getTaint());
E var2DDBCD2256760211E3C0FF2C55B1D44F_1613524895 =         backingMap.lowerKey(e);
        var2DDBCD2256760211E3C0FF2C55B1D44F_1613524895.addTaint(taint);
        return var2DDBCD2256760211E3C0FF2C55B1D44F_1613524895;
        // ---------- Original Method ----------
        //return backingMap.lowerKey(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.552 -0400", hash_original_method = "F02A103FC86BCAE7229665056FB74739", hash_generated_method = "BF01B0884FB603DBD3DD5B2891C9AD7F")
    public E ceiling(E e) {
        addTaint(e.getTaint());
E var9543504692B376FEAF1B79BFE5FAB480_1165801296 =         backingMap.ceilingKey(e);
        var9543504692B376FEAF1B79BFE5FAB480_1165801296.addTaint(taint);
        return var9543504692B376FEAF1B79BFE5FAB480_1165801296;
        // ---------- Original Method ----------
        //return backingMap.ceilingKey(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.552 -0400", hash_original_method = "09066F58D542F9425C5670329C148EFE", hash_generated_method = "B69AD9BD7FBB8E773F357F1DDD4AD23E")
    public E floor(E e) {
        addTaint(e.getTaint());
E var1BCF47557897205FD48AB0A73F410791_1417494054 =         backingMap.floorKey(e);
        var1BCF47557897205FD48AB0A73F410791_1417494054.addTaint(taint);
        return var1BCF47557897205FD48AB0A73F410791_1417494054;
        // ---------- Original Method ----------
        //return backingMap.floorKey(e);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.553 -0400", hash_original_method = "A6CC6F36D568F252AE741D0349E41073", hash_generated_method = "DD83900825108D4E442830D3999352EE")
    public NavigableSet<E> descendingSet() {
NavigableSet<E> varBE5ABA3BE0A68913A56946E2DC797D44_1158308659 =         (descendingSet != null) ? descendingSet
                : (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
        varBE5ABA3BE0A68913A56946E2DC797D44_1158308659.addTaint(taint);
        return varBE5ABA3BE0A68913A56946E2DC797D44_1158308659;
        // ---------- Original Method ----------
        //return (descendingSet != null) ? descendingSet
                //: (descendingSet = new TreeSet<E>(backingMap.descendingMap()));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.553 -0400", hash_original_method = "ED81F074F474A876A14D172DD54F12F1", hash_generated_method = "6EE2F8493B1393AB0F36589D523F5D04")
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
NavigableSet<E> varDC3CDC9203794F796454BC9DF4EF62E9_315077516 =             new TreeSet<E>(backingMap.subMap(start, startInclusive, end,
                    endInclusive));
            varDC3CDC9203794F796454BC9DF4EF62E9_315077516.addTaint(taint);
            return varDC3CDC9203794F796454BC9DF4EF62E9_315077516;
        } //End block
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1689598663 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1689598663.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1689598663;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.554 -0400", hash_original_method = "F84D7A45054DBC97192AC73FC2432832", hash_generated_method = "1881FA7FCDACC7CDCD408DAD6506257F")
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
NavigableSet<E> varE70D8A145633D64A8635027DBE800D01_249483838 =         new TreeSet<E>(backingMap.headMap(end, endInclusive));
        varE70D8A145633D64A8635027DBE800D01_249483838.addTaint(taint);
        return varE70D8A145633D64A8635027DBE800D01_249483838;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) end).compareTo(end);
        //} else {
            //c.compare(end, end);
        //}
        //return new TreeSet<E>(backingMap.headMap(end, endInclusive));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.554 -0400", hash_original_method = "663A99D3FA4C192D3A7FF25E6DB9D983", hash_generated_method = "C365C88D8A0503D2D14EE4F8A8C21ECB")
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
NavigableSet<E> varC3FFFEAE2889574A248CD2F5AEC2B9B2_1432877098 =         new TreeSet<E>(backingMap.tailMap(start, startInclusive));
        varC3FFFEAE2889574A248CD2F5AEC2B9B2_1432877098.addTaint(taint);
        return varC3FFFEAE2889574A248CD2F5AEC2B9B2_1432877098;
        // ---------- Original Method ----------
        //Comparator<? super E> c = backingMap.comparator();
        //if (c == null) {
            //((Comparable<E>) start).compareTo(start);
        //} else {
            //c.compare(start, start);
        //}
        //return new TreeSet<E>(backingMap.tailMap(start, startInclusive));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.555 -0400", hash_original_method = "C92358BB1651ED2C24F4D6C79CD951E7", hash_generated_method = "941198C1AC9B2102D8AB2D5193E4A392")
    @SuppressWarnings("unchecked")
    public SortedSet<E> subSet(E start, E end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
SortedSet<E> varA297EA4DB647E5B963067A175A15005C_186712647 =         subSet(start, true, end, false);
        varA297EA4DB647E5B963067A175A15005C_186712647.addTaint(taint);
        return varA297EA4DB647E5B963067A175A15005C_186712647;
        // ---------- Original Method ----------
        //return subSet(start, true, end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.555 -0400", hash_original_method = "B22F87137AF3AAA5F7ECED16F7688B46", hash_generated_method = "40EFB949E91F34523542B9651E0D2032")
    @SuppressWarnings("unchecked")
    public SortedSet<E> headSet(E end) {
        addTaint(end.getTaint());
SortedSet<E> var7C238F126E56EB43F3B9FF21E31CFC21_2079646081 =         headSet(end, false);
        var7C238F126E56EB43F3B9FF21E31CFC21_2079646081.addTaint(taint);
        return var7C238F126E56EB43F3B9FF21E31CFC21_2079646081;
        // ---------- Original Method ----------
        //return headSet(end, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.556 -0400", hash_original_method = "D9366E253CBE1FE1D040B6F98C30B4A1", hash_generated_method = "26E22240DE8B3585E8DE49CEB71A0B28")
    @SuppressWarnings("unchecked")
    public SortedSet<E> tailSet(E start) {
        addTaint(start.getTaint());
SortedSet<E> var7589F3441938F46E6B7F60EEE098D2C9_925001063 =         tailSet(start, true);
        var7589F3441938F46E6B7F60EEE098D2C9_925001063.addTaint(taint);
        return var7589F3441938F46E6B7F60EEE098D2C9_925001063;
        // ---------- Original Method ----------
        //return tailSet(start, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.556 -0400", hash_original_method = "99C17ADAEB11E32F56AB0674B65B4A86", hash_generated_method = "940DF24CEADDE5B85FB9004AE02DD3F0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.558 -0400", hash_original_method = "675A9075CC9828201778F15727C38572", hash_generated_method = "89ACA855706A3BF26CB57C84BA9D9FF8")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.559 -0400", hash_original_field = "550B431A108A77E6266129D6FCEE4BC8", hash_generated_field = "31AEFE2A50D43E7000DE1CE15A90AC24")

    private static final long serialVersionUID = -2479143000061671589L;
}

