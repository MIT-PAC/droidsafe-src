package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.790 -0400", hash_original_field = "97282B278E5D51866F8E57204E4820E5", hash_generated_field = "CEE47592CD991F798055CF00F61D5D32")

    private CopyOnWriteArrayList<E> al;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.791 -0400", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "0FB9C3E2A709B12CF65A46E85BF7EE93")
    public  CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.791 -0400", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "AF148E3BB9B3105E752B2DF2ECA0FF4B")
    public  CopyOnWriteArraySet(Collection<? extends E> c) {
        addTaint(c.getTaint());
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
        //al.addAllAbsent(c);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.792 -0400", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "00673E6958626F19B6E28259BE2A2A3A")
    public int size() {
        int varC60094971D0DC1BA2308A4430FB51AA2_285598330 = (al.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648603499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648603499;
        // ---------- Original Method ----------
        //return al.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.792 -0400", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "9BB18B3CD817661D6C4B66CAA7CFD2C4")
    public boolean isEmpty() {
        boolean var0C66FAF77C910DA93FC2B96790B002D0_186075429 = (al.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294500830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294500830;
        // ---------- Original Method ----------
        //return al.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.792 -0400", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "3F97F18F070A2C5BE6008495DB23DF9C")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var6CC85BAC674B259C2EF2EBE6F8C28AF8_840309900 = (al.contains(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136645839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136645839;
        // ---------- Original Method ----------
        //return al.contains(o);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.793 -0400", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "9EC2145155B4E544BE72B9CF05E8C1AA")
    public Object[] toArray() {
Object[] varEE356BC8028D35EDB407C2CD6F5C7F86_1752199058 =         al.toArray();
        varEE356BC8028D35EDB407C2CD6F5C7F86_1752199058.addTaint(taint);
        return varEE356BC8028D35EDB407C2CD6F5C7F86_1752199058;
        // ---------- Original Method ----------
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.793 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "F451361170E31A2DB8AEC9063170D4B4")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
T[] varAA44379FEF6B0261A49B4F9151CB856C_1997563438 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_1997563438.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_1997563438;
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.793 -0400", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "51E35B8C0D9675FA92693C3EC2EACF08")
    public void clear() {
        al.clear();
        // ---------- Original Method ----------
        //al.clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.794 -0400", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "7E112A54CD2102576CB1D973C4922A22")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean varA0832791B6D86DC5E5F406EFEDF6B6D8_1397893012 = (al.remove(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903797562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903797562;
        // ---------- Original Method ----------
        //return al.remove(o);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.794 -0400", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "1D5A13303C02083E1979E878394E9297")
    public boolean add(E e) {
        addTaint(e.getTaint());
        boolean varC6A63B1CC1DD782DDF71404353CCFD6B_225869419 = (al.addIfAbsent(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459251474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459251474;
        // ---------- Original Method ----------
        //return al.addIfAbsent(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.795 -0400", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "F518EBD6AFDD025ABF59DC095F2897A9")
    public boolean containsAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varD3954A30DF241B5F6E071253B71B5A71_1186493262 = (al.containsAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282507573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_282507573;
        // ---------- Original Method ----------
        //return al.containsAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.795 -0400", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "1783AB4EBA39A5EB1421FAA2B19354D3")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
        boolean varBACC16A49891C46F713717A8C731DCC0_2098849965 = (al.addAllAbsent(c) > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385528616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_385528616;
        // ---------- Original Method ----------
        //return al.addAllAbsent(c) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.795 -0400", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "AC353CC81E2B217C8360BB599C0BCF0D")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varEEFB2908DC005B9DB13B8A91A265ED5B_872312308 = (al.removeAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265009064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265009064;
        // ---------- Original Method ----------
        //return al.removeAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.796 -0400", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "042D8C8B0F8CDAD596DFC9E0B0698F43")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean varA845A13020D2C49250FEC58E2C803A10_514128583 = (al.retainAll(c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097060865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097060865;
        // ---------- Original Method ----------
        //return al.retainAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.796 -0400", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "F320FC2E768583035857F90E17591491")
    public Iterator<E> iterator() {
Iterator<E> var9170DAE396001991D3A16AF07A4247B9_1715885084 =         al.iterator();
        var9170DAE396001991D3A16AF07A4247B9_1715885084.addTaint(taint);
        return var9170DAE396001991D3A16AF07A4247B9_1715885084;
        // ---------- Original Method ----------
        //return al.iterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.797 -0400", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "DB5E8194C0B3A1EB643D0A5FF7BF0D99")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_838954756 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900420973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900420973;
        }
    if(!(o instanceof Set))        
        {
        boolean var68934A3E9455FA72420237EB05902327_851580414 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618779113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618779113;
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
            boolean var68934A3E9455FA72420237EB05902327_207455027 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364730846 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_364730846;
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
            boolean var68934A3E9455FA72420237EB05902327_300114712 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660650544 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660650544;
        } //End block
        boolean var39D746AF77FCD02D26104C8EF542DC68_810559935 = (k == len);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789215448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789215448;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.798 -0400", hash_original_field = "40C6D58C911799600E3343B6CE6ADAFA", hash_generated_field = "B2F6A1A939754D8234C996B8AA693186")

    private static final long serialVersionUID = 5457747651344034263L;
}

