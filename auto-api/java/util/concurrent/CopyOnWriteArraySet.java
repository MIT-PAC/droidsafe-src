package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.292 -0400", hash_original_field = "97282B278E5D51866F8E57204E4820E5", hash_generated_field = "CEE47592CD991F798055CF00F61D5D32")

    private CopyOnWriteArrayList<E> al;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.293 -0400", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "0FB9C3E2A709B12CF65A46E85BF7EE93")
    public  CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.293 -0400", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "C1FCB928AAC92EB24B7DBF23D7D0F786")
    public  CopyOnWriteArraySet(Collection<? extends E> c) {
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
        //al.addAllAbsent(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.293 -0400", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "79C13EF34308A328618D1F02F1AFCF4E")
    public int size() {
        int varB5D8E908B370B3A76D18BE762127F109_1966017444 = (al.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989689232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989689232;
        // ---------- Original Method ----------
        //return al.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.293 -0400", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "243A3640BF9A42F5F49E479F2FA9504A")
    public boolean isEmpty() {
        boolean varC82F559F003BF71F01647C9AB19E6431_1251878205 = (al.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780161104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780161104;
        // ---------- Original Method ----------
        //return al.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.294 -0400", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "BC2E39A7F6ADC74D9370FAA68000EA2A")
    public boolean contains(Object o) {
        boolean var4566F95F0F074F37A9867A47681034EB_1384225775 = (al.contains(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138998515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138998515;
        // ---------- Original Method ----------
        //return al.contains(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.294 -0400", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "1DE7A8E11B919528F3C0CB1A3B98B49B")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_452640592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_452640592 = al.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_452640592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_452640592;
        // ---------- Original Method ----------
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.294 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "64466652576579F35633076BA4998378")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_55477209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_55477209 = al.toArray(a);
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_55477209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_55477209;
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.295 -0400", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "51E35B8C0D9675FA92693C3EC2EACF08")
    public void clear() {
        al.clear();
        // ---------- Original Method ----------
        //al.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.295 -0400", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "015C3B0FE5F92B9BEC5E962483C83361")
    public boolean remove(Object o) {
        boolean varF5E2E94743CA5DADB9371E47BD4EC8DA_594447100 = (al.remove(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216700758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216700758;
        // ---------- Original Method ----------
        //return al.remove(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.295 -0400", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "C83FB27C9EB39CAC23BEA25B38C6B36B")
    public boolean add(E e) {
        boolean varCB9B506BC0E0022F3922F766B32CEAE6_2127231695 = (al.addIfAbsent(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310923740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310923740;
        // ---------- Original Method ----------
        //return al.addIfAbsent(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.295 -0400", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "1610153CA60AA8B9A36894A479833871")
    public boolean containsAll(Collection<?> c) {
        boolean var6CAA689E7A13F8E5F5F9520333B3CD72_1477554896 = (al.containsAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466329133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466329133;
        // ---------- Original Method ----------
        //return al.containsAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.296 -0400", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "5428FB2EC2071777A1A0676ECA34E0FC")
    public boolean addAll(Collection<? extends E> c) {
        boolean var55E31457914D4F0AACB014E3EFB97B45_39020729 = (al.addAllAbsent(c) > 0);
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992142101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992142101;
        // ---------- Original Method ----------
        //return al.addAllAbsent(c) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.296 -0400", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "3EEDE50E69587E6939D4F3C8785F2EBB")
    public boolean removeAll(Collection<?> c) {
        boolean varFDF43CC6BD5EF12644AD7C984D463698_1179362488 = (al.removeAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745467287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745467287;
        // ---------- Original Method ----------
        //return al.removeAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.296 -0400", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "83DBAFE7CBD931D6D11952431D4ECB6E")
    public boolean retainAll(Collection<?> c) {
        boolean varEE27D88D1B3F703D4FD1A281E61FD88D_1125190571 = (al.retainAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932355453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932355453;
        // ---------- Original Method ----------
        //return al.retainAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.309 -0400", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "DE23C09396BB11938113FC5625591085")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1797919996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797919996 = al.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1797919996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797919996;
        // ---------- Original Method ----------
        //return al.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.309 -0400", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "EF70DC7CA78850EA10EA5476C1FA0E47")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1683318292 = (o == this);
        } //End collapsed parenthetic
        Set<?> set;
        set = (Set<?>)(o);
        Iterator<?> it;
        it = set.iterator();
        Object[] elements;
        elements = al.getArray();
        int len;
        len = elements.length;
        boolean[] matched;
        matched = new boolean[len];
        int k;
        k = 0;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_622654224 = (it.hasNext());
            {
                Object x;
                x = it.next();
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varCFEAAB019BB9C20489C681EAD7828EB4_1626421005 = (!matched[i] && eq(x, elements[i]));
                            {
                                matched[i] = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393962442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393962442;
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

    
        private static boolean eq(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.310 -0400", hash_original_field = "40C6D58C911799600E3343B6CE6ADAFA", hash_generated_field = "456FAC1F741A24C498B0B203D0E6D676")

    private static long serialVersionUID = 5457747651344034263L;
}

