package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements java.io.Serializable {
    private CopyOnWriteArrayList<E> al;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.511 -0400", hash_original_method = "719CF91FD15681D04C85978CBE8B39AE", hash_generated_method = "0FB9C3E2A709B12CF65A46E85BF7EE93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CopyOnWriteArraySet() {
        al = new CopyOnWriteArrayList<E>();
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.511 -0400", hash_original_method = "A905F7DF70B1EDD8621789C3C3A6CD84", hash_generated_method = "BD5506A43A3828F6B9E555D91DF36E00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CopyOnWriteArraySet(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        al = new CopyOnWriteArrayList<E>();
        al.addAllAbsent(c);
        // ---------- Original Method ----------
        //al = new CopyOnWriteArrayList<E>();
        //al.addAllAbsent(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "3CEC44303CC022BBEC9F119BC403FDBC", hash_generated_method = "6EDAE92AB4842071134547CC66355267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varB5D8E908B370B3A76D18BE762127F109_1204090987 = (al.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return al.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "3B66E92AC54A2F386067AD3C16431654", hash_generated_method = "58BAC85AB59BED4988AC54146C4A0015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varC82F559F003BF71F01647C9AB19E6431_1953045061 = (al.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "45B83D89DB9565F8F2123157436CF2DA", hash_generated_method = "FAB1EE5111034C84C6994DB0D976FDEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var4566F95F0F074F37A9867A47681034EB_1543148383 = (al.contains(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.contains(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "59659636145935A673C89066DF38E15C", hash_generated_method = "086594DCD00A3C7A29DEAF8EE4AD074A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] var367FB3FD9D449090316E00FA3AE7836B_1728217712 = (al.toArray());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "611ED93917CDC5DE1AF7714E59426D61", hash_generated_method = "96364E5E865AF661A347DAAAA11C997E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T[] toArray(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        T[] var7F840E6AFE43943720AED82374A8BF19_1207315313 = (al.toArray(a));
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return al.toArray(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "3A8225B3804E9179BE65F5C2B01036E9", hash_generated_method = "51E35B8C0D9675FA92693C3EC2EACF08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        al.clear();
        // ---------- Original Method ----------
        //al.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.512 -0400", hash_original_method = "4B916DD49AA1C881C6B40C3BB12114A0", hash_generated_method = "A3A4B4502D127619606E297960B3E2DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean varF5E2E94743CA5DADB9371E47BD4EC8DA_949292641 = (al.remove(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.remove(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "C36F2E0651BF3F93251D9AAA1075E241", hash_generated_method = "C0DB5DF472BB15FD693C4525342486DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean varCB9B506BC0E0022F3922F766B32CEAE6_243900177 = (al.addIfAbsent(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.addIfAbsent(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "BAD19EAB09738DBB9663648D63DFE74C", hash_generated_method = "9AD36F33733BC3E1BAF6A5E6D736E6F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        boolean var6CAA689E7A13F8E5F5F9520333B3CD72_1344641662 = (al.containsAll(c));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.containsAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "B7022E0CB9EF549D20482BA7616126CF", hash_generated_method = "22C54C8DA899900D165FF66325072140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        boolean var55E31457914D4F0AACB014E3EFB97B45_2146077180 = (al.addAllAbsent(c) > 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.addAllAbsent(c) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "66AA12EE71C1D65DECB2FC917ACDE24D", hash_generated_method = "FF46A68B18B01E7BA1BD38B56315C7FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        boolean varFDF43CC6BD5EF12644AD7C984D463698_648374913 = (al.removeAll(c));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.removeAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "D0A4CF23F1E9AE32CFAA8649387F142B", hash_generated_method = "061E98A01A3AE53BF2D0207A5DC44E0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean retainAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        boolean varEE27D88D1B3F703D4FD1A281E61FD88D_1546936721 = (al.retainAll(c));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return al.retainAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.513 -0400", hash_original_method = "1D191D7F570684E003696ECD55ECD643", hash_generated_method = "A9D7350B0BF70244344FA531D2A1CDA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> iterator() {
        Iterator<E> var4FD0D6C3A9F227AD1FB45D1E655F3D22_394447724 = (al.iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return al.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.514 -0400", hash_original_method = "EF3132D176498E8C292078B60C02B2A5", hash_generated_method = "D0009BE7A2EDB4FF47E2537E1358294E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_198053812 = (o == this);
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
            boolean var03729FD53960D8DCA3A41A13A0229637_21831479 = (it.hasNext());
            {
                Object x;
                x = it.next();
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varCFEAAB019BB9C20489C681EAD7828EB4_297314974 = (!matched[i] && eq(x, elements[i]));
                            {
                                matched[i] = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    private static final long serialVersionUID = 5457747651344034263L;
}

