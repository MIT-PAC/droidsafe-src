package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.229 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "BA28E44BB32CE28A4E02FA17DE6E4457")
    protected  AbstractQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.229 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "F539BB72FAAE440FF52DAF7C3BAB0A3C")
    public boolean add(E e) {
        {
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_332229014 = (offer(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038220898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038220898;
        // ---------- Original Method ----------
        //if (offer(e))
            //return true;
        //else
            //throw new IllegalStateException("Queue full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.240 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "290FBFD9869D51B0BC00D84C30376D9A")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_1485256689 = null; //Variable for return #1
        E x;
        x = poll();
        varB4EAC82CA7396A68D541C85D26508E83_1485256689 = x;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1485256689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1485256689;
        // ---------- Original Method ----------
        //E x = poll();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.241 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "9CE064C6347FB0E923F4526B892B3274")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1721926993 = null; //Variable for return #1
        E x;
        x = peek();
        varB4EAC82CA7396A68D541C85D26508E83_1721926993 = x;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1721926993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1721926993;
        // ---------- Original Method ----------
        //E x = peek();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.241 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "FF3AFB1EAE08261111A5574E2E97FD39")
    public void clear() {
        {
            boolean var007FB331E0C46D4AB9B8C49B89596626_593302855 = (poll() != null);
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (poll() != null)
            //;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.274 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "D564F5147207BBE61E5065A515AE269C")
    public boolean addAll(Collection<? extends E> c) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1508495210 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        boolean modified;
        modified = false;
        {
            Iterator<E> var334ED49EB23041C8D120547C1BB713D2_870127557 = (c).iterator();
            var334ED49EB23041C8D120547C1BB713D2_870127557.hasNext();
            E e = var334ED49EB23041C8D120547C1BB713D2_870127557.next();
            {
                boolean var1194B013A262CF6972087B946B7624B7_259319473 = (add(e));
                modified = true;
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136038372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_136038372;
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

