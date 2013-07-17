package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.883 -0400", hash_original_field = "97282B278E5D51866F8E57204E4820E5", hash_generated_field = "CEE47592CD991F798055CF00F61D5D32")

    private CopyOnWriteArrayList<E> al;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.883 -0400", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "0FB9C3E2A709B12CF65A46E85BF7EE93")
    public  CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.884 -0400", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "AF148E3BB9B3105E752B2DF2ECA0FF4B")
    public  CopyOnWriteArraySet(Collection<? extends E> c) {
        addTaint(c.getTaint());
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
        //al.addAllAbsent(c);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.884 -0400", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "24F0E9BEFBF29FEB51E3BC34810A1E78")
    public int size() {
        int varC60094971D0DC1BA2308A4430FB51AA2_2134750737 = (al.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40705464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40705464;
        // ---------- Original Method ----------
        //return al.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.884 -0400", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "31BD6A1CE89FDD9C1715F0FBE0BC5310")
    public boolean isEmpty() {
        boolean var0C66FAF77C910DA93FC2B96790B002D0_69691409 = (al.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448378199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448378199;
        // ---------- Original Method ----------
        //return al.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.884 -0400", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "1AB94E50FB100DCA9E4C592EF8C64526")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var6CC85BAC674B259C2EF2EBE6F8C28AF8_399921594 = (al.contains(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022410695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022410695;
        // ---------- Original Method ----------
        //return al.contains(o);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.885 -0400", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "829E15619F86BD785759BA7EE3AC730A")
    public Object[] toArray() {
Object[] varEE356BC8028D35EDB407C2CD6F5C7F86_487859408 =         al.toArray();
        varEE356BC8028D35EDB407C2CD6F5C7F86_487859408.addTaint(taint);
        return varEE356BC8028D35EDB407C2CD6F5C7F86_487859408;
        // ---------- Original Method ----------
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.885 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "A97A508A6AB1C24B6FB5FCF21A879F6C")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
T[] varAA44379FEF6B0261A49B4F9151CB856C_1385790034 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_1385790034.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_1385790034;
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.885 -0400", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "51E35B8C0D9675FA92693C3EC2EACF08")
    public void clear() {
        al.clear();
        // ---------- Original Method ----------
        //al.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.886 -0400", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "D6D3B2B7CF73BE0E6165574CC3247069")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean varA0832791B6D86DC5E5F406EFEDF6B6D8_823254350 = (al.remove(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542238460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542238460;
        // ---------- Original Method ----------
        //return al.remove(o);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.886 -0400", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "52CC5896B6583E1D9F5F3584637BA501")
    public boolean add(E e) {
        addTaint(e.getTaint());
        boolean varC6A63B1CC1DD782DDF71404353CCFD6B_697257112 = (al.addIfAbsent(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983375977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983375977;
        // ---------- Original Method ----------
        //return al.addIfAbsent(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.886 -0400", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "6E768E546926F759CD87326459A7B1F5")
    public boolean containsAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varD3954A30DF241B5F6E071253B71B5A71_1422513629 = (al.containsAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382278266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382278266;
        // ---------- Original Method ----------
        //return al.containsAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.886 -0400", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "9085EE0B27DBF76AF74D496066CFC56E")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
        boolean varBACC16A49891C46F713717A8C731DCC0_170126722 = (al.addAllAbsent(c) > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42917663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42917663;
        // ---------- Original Method ----------
        //return al.addAllAbsent(c) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.886 -0400", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "DEE13E6E5D254B0A1AC1815A569D941E")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varEEFB2908DC005B9DB13B8A91A265ED5B_1520978487 = (al.removeAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1595863439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1595863439;
        // ---------- Original Method ----------
        //return al.removeAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.887 -0400", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "514123490E166B00AB7F08BBFD6A17AB")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varA845A13020D2C49250FEC58E2C803A10_194591381 = (al.retainAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959384226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959384226;
        // ---------- Original Method ----------
        //return al.retainAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.887 -0400", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "22156E87E644851A7EDF50146C5059B3")
    public Iterator<E> iterator() {
Iterator<E> var9170DAE396001991D3A16AF07A4247B9_536686804 =         al.iterator();
        var9170DAE396001991D3A16AF07A4247B9_536686804.addTaint(taint);
        return var9170DAE396001991D3A16AF07A4247B9_536686804;
        // ---------- Original Method ----------
        //return al.iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.888 -0400", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "4E37D36BECCCC0146A752B2D26B3E55C")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2019028790 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696819073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696819073;
        }
        if(!(o instanceof Set))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1778227948 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060908123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060908123;
        }
        Set<?> set = (Set<?>)(o);
        Iterator<?> it = set.iterator();
        Object[] elements = al.getArray();
        int len = elements.length;
        boolean[] matched = new boolean[len];
        int k = 0;
        outer        :
        while
(it.hasNext())        
        {
            if(++k > len)            
            {
            boolean var68934A3E9455FA72420237EB05902327_659510232 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514906103 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_514906103;
            }
            Object x = it.next();
for(int i = 0;i < len;++i)
            {
                if(!matched[i] && eq(x, elements[i]))                
                {
                    matched[i] = true;
                    continue outer;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_388012493 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_441696639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_441696639;
        } //End block
        boolean var39D746AF77FCD02D26104C8EF542DC68_955939839 = (k == len);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177944074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177944074;
        // ---------- Original Method ----------
        //if (o == this)
            //return true;
        //if (!(o instanceof Set))
            //return false;
        //Set<?> set = (Set<?>)(o);
        //Iterator<?> it = set.iterator();
        //Object[] elements = al.getArray();
        //int len = elements.length;
        //boolean[] matched = new boolean[len];
        //int k = 0;
        //outer: while (it.hasNext()) {
            //if (++k > len)
                //return false;
            //Object x = it.next();
            //for (int i = 0; i < len; ++i) {
                //if (!matched[i] && eq(x, elements[i])) {
                    //matched[i] = true;
                    //continue outer;
                //}
            //}
            //return false;
        //}
        //return k == len;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean eq(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.889 -0400", hash_original_field = "40C6D58C911799600E3343B6CE6ADAFA", hash_generated_field = "B2F6A1A939754D8234C996B8AA693186")

    private static final long serialVersionUID = 5457747651344034263L;
}

