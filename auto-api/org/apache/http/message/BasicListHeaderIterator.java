package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

public class BasicListHeaderIterator implements HeaderIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.223 -0400", hash_original_field = "70C9DAFA949FAFF76AD7BDC73045BC73", hash_generated_field = "3B804EE90FB805BB2F9B41892E7AB9CC")

    protected List allHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.223 -0400", hash_original_field = "4BD5A8B788F2E9E58294F9371A3CF365", hash_generated_field = "888ED00F76573C33F42FD289758C6753")

    protected int currentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.223 -0400", hash_original_field = "6F2EE54DDE3DC60F4A41E7DFB940851A", hash_generated_field = "7984FA65CEAD27AA9A0B68B55B2F3751")

    protected int lastIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.223 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.232 -0400", hash_original_method = "2D091C8CAFC19B749551E2F1187B6105", hash_generated_method = "664522D9B910BE9FA4BA35E835262E95")
    public  BasicListHeaderIterator(List headers, String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header list must not be null.");
        } //End block
        this.allHeaders = headers;
        this.headerName = name;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
        // ---------- Original Method ----------
        //if (headers == null) {
            //throw new IllegalArgumentException
                //("Header list must not be null.");
        //}
        //this.allHeaders = headers;
        //this.headerName = name;
        //this.currentIndex = findNext(-1);
        //this.lastIndex = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.234 -0400", hash_original_method = "AE89C08F08BB3F2E2361D882A86E08E6", hash_generated_method = "159B0EBF19863D11C2576683BE119417")
    protected int findNext(int from) {
        int to;
        to = this.allHeaders.size()-1;
        boolean found;
        found = false;
        {
            found = filterHeader(from);
        } //End block
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986747455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986747455;
        // ---------- Original Method ----------
        //if (from < -1)
            //return -1;
        //final int to = this.allHeaders.size()-1;
        //boolean found = false;
        //while (!found && (from < to)) {
            //from++;
            //found = filterHeader(from);
        //}
        //return found ? from : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.246 -0400", hash_original_method = "DC309B64F8D7236BD3D5DA9945B2E659", hash_generated_method = "0B9908967242D01973EA155B71706B88")
    protected boolean filterHeader(int index) {
        String name;
        name = ((Header)this.allHeaders.get(index)).getName();
        boolean varAA28A86572AC03E911F9B720B6C47A87_1729447277 = (this.headerName.equalsIgnoreCase(name));
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370091748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370091748;
        // ---------- Original Method ----------
        //if (this.headerName == null)
            //return true;
        //final String name = ((Header)this.allHeaders.get(index)).getName();
        //return this.headerName.equalsIgnoreCase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.246 -0400", hash_original_method = "A999EE5BCD06DCC7730AAD5F8A866DB2", hash_generated_method = "46E67712E1A4E29803BA7B25FC3F5380")
    public boolean hasNext() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335376785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335376785;
        // ---------- Original Method ----------
        //return (this.currentIndex >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.247 -0400", hash_original_method = "8B480335A0C8328D28D73B9B4CAA13A8", hash_generated_method = "C1EAEFF3456DDF9C29470EE6FF905E9B")
    public Header nextHeader() throws NoSuchElementException {
        Header varB4EAC82CA7396A68D541C85D26508E83_673936170 = null; //Variable for return #1
        int current;
        current = this.currentIndex;
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException("Iteration already finished.");
        } //End block
        this.lastIndex    = current;
        this.currentIndex = findNext(current);
        varB4EAC82CA7396A68D541C85D26508E83_673936170 = (Header) this.allHeaders.get(current);
        varB4EAC82CA7396A68D541C85D26508E83_673936170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_673936170;
        // ---------- Original Method ----------
        //final int current = this.currentIndex;
        //if (current < 0) {
            //throw new NoSuchElementException("Iteration already finished.");
        //}
        //this.lastIndex    = current;
        //this.currentIndex = findNext(current);
        //return (Header) this.allHeaders.get(current);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.248 -0400", hash_original_method = "52795801AD2FF0B406EF0189CBA87E8B", hash_generated_method = "5AEAE693FA4579E73600201B6D0E2C0F")
    public final Object next() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1480647153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1480647153 = nextHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1480647153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1480647153;
        // ---------- Original Method ----------
        //return nextHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.248 -0400", hash_original_method = "38E9BF9964D831A9048EA81D99CFEC10", hash_generated_method = "D11EF3EEB5C33AF27D17E21AD8CB25BA")
    public void remove() throws UnsupportedOperationException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No header to remove.");
        } //End block
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        // ---------- Original Method ----------
        //if (this.lastIndex < 0) {
            //throw new IllegalStateException("No header to remove.");
        //}
        //this.allHeaders.remove(this.lastIndex);
        //this.lastIndex = -1;
        //this.currentIndex--;
    }

    
}

