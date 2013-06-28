package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.712 -0400", hash_original_field = "97282B278E5D51866F8E57204E4820E5", hash_generated_field = "CEE47592CD991F798055CF00F61D5D32")

    private CopyOnWriteArrayList<E> al;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.713 -0400", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "0FB9C3E2A709B12CF65A46E85BF7EE93")
    public  CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.713 -0400", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "C1FCB928AAC92EB24B7DBF23D7D0F786")
    public  CopyOnWriteArraySet(Collection<? extends E> c) {
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
        //al.addAllAbsent(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.713 -0400", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "8F77D5069F13FFBA691B5C8033BE6503")
    public int size() {
        int varB5D8E908B370B3A76D18BE762127F109_1645818506 = (al.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328582242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328582242;
        // ---------- Original Method ----------
        //return al.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.714 -0400", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "EAE5E639240ADBBC387C09C0A281E150")
    public boolean isEmpty() {
        boolean varC82F559F003BF71F01647C9AB19E6431_583125062 = (al.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578536019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578536019;
        // ---------- Original Method ----------
        //return al.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.714 -0400", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "5DDEB248AD1FDD6603C6E6312C0C6EFB")
    public boolean contains(Object o) {
        boolean var4566F95F0F074F37A9867A47681034EB_919555969 = (al.contains(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579747648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579747648;
        // ---------- Original Method ----------
        //return al.contains(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.715 -0400", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "7C0964EC6EA3FE3F31B6267ECF708BE5")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_449864222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_449864222 = al.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_449864222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449864222;
        // ---------- Original Method ----------
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.717 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "BAAB356151B734357F29F5E41230BE0D")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1151182557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1151182557 = al.toArray(a);
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1151182557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1151182557;
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.718 -0400", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "51E35B8C0D9675FA92693C3EC2EACF08")
    public void clear() {
        al.clear();
        // ---------- Original Method ----------
        //al.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.719 -0400", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "043E299E81B4687FB2F5BDCD33D7F2CE")
    public boolean remove(Object o) {
        boolean varF5E2E94743CA5DADB9371E47BD4EC8DA_1513810662 = (al.remove(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763424180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763424180;
        // ---------- Original Method ----------
        //return al.remove(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.720 -0400", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "1E4A006AC51153BB405730F02482EBB0")
    public boolean add(E e) {
        boolean varCB9B506BC0E0022F3922F766B32CEAE6_376394960 = (al.addIfAbsent(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099788281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099788281;
        // ---------- Original Method ----------
        //return al.addIfAbsent(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.720 -0400", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "37B1F94673D08FF43161063EBBA28F43")
    public boolean containsAll(Collection<?> c) {
        boolean var6CAA689E7A13F8E5F5F9520333B3CD72_642367373 = (al.containsAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762439957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762439957;
        // ---------- Original Method ----------
        //return al.containsAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.721 -0400", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "58478F1A9A3C2EE2B36E612514A05AFA")
    public boolean addAll(Collection<? extends E> c) {
        boolean var55E31457914D4F0AACB014E3EFB97B45_563458268 = (al.addAllAbsent(c) > 0);
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131512039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131512039;
        // ---------- Original Method ----------
        //return al.addAllAbsent(c) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.721 -0400", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "61D7490AB00D5B73F26F5BFDDAC74ABA")
    public boolean removeAll(Collection<?> c) {
        boolean varFDF43CC6BD5EF12644AD7C984D463698_645545321 = (al.removeAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560354909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560354909;
        // ---------- Original Method ----------
        //return al.removeAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.721 -0400", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "490020859B14B9824EAAA8090B7C6447")
    public boolean retainAll(Collection<?> c) {
        boolean varEE27D88D1B3F703D4FD1A281E61FD88D_540954403 = (al.retainAll(c));
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304255366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304255366;
        // ---------- Original Method ----------
        //return al.retainAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.722 -0400", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "4A45F1443CDE40C32F24B2564538B1A6")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_574050485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_574050485 = al.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_574050485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_574050485;
        // ---------- Original Method ----------
        //return al.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.722 -0400", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "4ED9852379F8D9D909A788EEA08AB6BC")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_357102164 = (o == this);
        } //End collapsed parenthetic
        Set<?> set = (Set<?>)(o);
        Iterator<?> it = set.iterator();
        Object[] elements = al.getArray();
        int len = elements.length;
        boolean[] matched = new boolean[len];
        int k = 0;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_225323221 = (it.hasNext());
            {
                Object x = it.next();
                {
                    int i = 0;
                    {
                        {
                            boolean varCFEAAB019BB9C20489C681EAD7828EB4_1497259919 = (!matched[i] && eq(x, elements[i]));
                            {
                                matched[i] = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138407497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138407497;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.722 -0400", hash_original_field = "40C6D58C911799600E3343B6CE6ADAFA", hash_generated_field = "B2F6A1A939754D8234C996B8AA693186")

    private static final long serialVersionUID = 5457747651344034263L;
}

