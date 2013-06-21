package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.856 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "BA28E44BB32CE28A4E02FA17DE6E4457")
    @DSModeled(DSC.SAFE)
    protected AbstractQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.856 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "1919B548D201516961BEF092F240CF69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        {
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_1970961301 = (offer(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (offer(e))
            //return true;
        //else
            //throw new IllegalStateException("Queue full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.857 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "EB431478199A07397843C8F0188C6062")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove() {
        E x;
        x = poll();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = poll();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.857 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "2C7439E89B4B52320384B51CAD195D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E element() {
        E x;
        x = peek();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = peek();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.857 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "532C1C671175C8BC1792168B92D69106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        {
            boolean var007FB331E0C46D4AB9B8C49B89596626_1379218366 = (poll() != null);
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (poll() != null)
            //;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.861 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "01F39F30B48BAB0901E60E92DE8025DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_178430427 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        boolean modified;
        modified = false;
        {
            Iterator<E> var334ED49EB23041C8D120547C1BB713D2_1598521891 = (c).iterator();
            var334ED49EB23041C8D120547C1BB713D2_1598521891.hasNext();
            E e = var334ED49EB23041C8D120547C1BB713D2_1598521891.next();
            {
                boolean var1194B013A262CF6972087B946B7624B7_762571777 = (add(e));
                modified = true;
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (c == null)
            //throw new NullPointerException();
        //if (c == this)
            //throw new IllegalArgumentException();
        //boolean modified = false;
        //for (E e : c)
            //if (add(e))
                //modified = true;
        //return modified;
    }

    
}

