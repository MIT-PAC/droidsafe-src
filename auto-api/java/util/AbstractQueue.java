package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.252 -0400", hash_original_method = "898E1AC4CE228AED7FA804DCD29D86E1", hash_generated_method = "BA28E44BB32CE28A4E02FA17DE6E4457")
    protected  AbstractQueue() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.253 -0400", hash_original_method = "1A50CFE77F83A9D61A2F23666507E72F", hash_generated_method = "5E4E74674AB41AD2AD5855CF0C7E8959")
    public boolean add(E e) {
        {
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_863231912 = (offer(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908246757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908246757;
        // ---------- Original Method ----------
        //if (offer(e))
            //return true;
        //else
            //throw new IllegalStateException("Queue full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.254 -0400", hash_original_method = "9DCDFDCD4BD0DA1BA6AE29C07F6D5161", hash_generated_method = "471781B58661284BE31E5AC14B1240E5")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_210429406 = null; //Variable for return #1
        E x;
        x = poll();
        varB4EAC82CA7396A68D541C85D26508E83_210429406 = x;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_210429406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_210429406;
        // ---------- Original Method ----------
        //E x = poll();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.255 -0400", hash_original_method = "25B2B6020E0E758714C2C5A3E37A85D5", hash_generated_method = "9A7DDA81F344B756051342CF8295AFFF")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_767569963 = null; //Variable for return #1
        E x;
        x = peek();
        varB4EAC82CA7396A68D541C85D26508E83_767569963 = x;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_767569963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767569963;
        // ---------- Original Method ----------
        //E x = peek();
        //if (x != null)
            //return x;
        //else
            //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.255 -0400", hash_original_method = "01DAFC6C5F0E6FF4922B6201FE3DA7B9", hash_generated_method = "56BE263FC12F3E82DF9ABBBBF7589B76")
    public void clear() {
        {
            boolean var007FB331E0C46D4AB9B8C49B89596626_98215835 = (poll() != null);
            ;
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (poll() != null)
            //;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.270 -0400", hash_original_method = "E3DD503D765939306C71AF759AB54F6B", hash_generated_method = "2EEA4A9F98E2FD3BC1FA010479F69E8D")
    public boolean addAll(Collection<? extends E> c) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_95872653 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        boolean modified;
        modified = false;
        {
            Iterator<E> var334ED49EB23041C8D120547C1BB713D2_694490035 = (c).iterator();
            var334ED49EB23041C8D120547C1BB713D2_694490035.hasNext();
            E e = var334ED49EB23041C8D120547C1BB713D2_694490035.next();
            {
                boolean var1194B013A262CF6972087B946B7624B7_221337736 = (add(e));
                modified = true;
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033439913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033439913;
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

