package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class HeaderIterator implements ListIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.733 -0400", hash_original_field = "EE2C880E2186FB7D858C0E6D8A2A35B4", hash_generated_field = "8B45939C2DCF0A4AAAC1D2D65D70A62B")

    private boolean toRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.733 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.733 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "D1F72E6C3AC858F6F50FFB2B76070DF5")

    private SIPMessage sipMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.733 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "0DC61CEBEA823ADBD35BAF3BA61B2B68")

    private SIPHeader sipHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.733 -0400", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "513E3B1158BAD913FFE0123019121598")
    protected  HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        this.sipMessage = sipMessage;
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
        //this.sipHeader = sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.735 -0400", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "2B6069BCE12FF11E6B6FE14DFEB99AA2")
    public Object next() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2042470498 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 1;
        varB4EAC82CA7396A68D541C85D26508E83_2042470498 = (Object) sipHeader;
        varB4EAC82CA7396A68D541C85D26508E83_2042470498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2042470498;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 1)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 1;
        //return (Object) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.739 -0400", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "FA5AAEE65C797D5C4B85D3CBA857CD1E")
    public Object previous() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_870108 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 0;
        varB4EAC82CA7396A68D541C85D26508E83_870108 = (Object) sipHeader;
        varB4EAC82CA7396A68D541C85D26508E83_870108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_870108;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 0)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 0;
        //return (Object) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.749 -0400", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "53525BA40358E580365FCDC626DF1438")
    public int nextIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740968691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740968691;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.749 -0400", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "AA8A0ED9892970059422A2FA86721768")
    public int previousIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394547867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394547867;
        // ---------- Original Method ----------
        //return index == 0 ? -1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.758 -0400", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "9AA672A5BE0E25F0501D8DAD6C5511D1")
    public void set(Object header) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.758 -0400", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "BB5E2752082F2900D11DF1ECB5778D58")
    public void add(Object header) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.760 -0400", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "7D30EF14799A16D744CEA809ACAD6C47")
    public void remove() throws IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        {
            this.sipHeader = null;
            this.sipMessage.removeHeader(sipHeader.getName());
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        // ---------- Original Method ----------
        //if (this.sipHeader == null)
            //throw new IllegalStateException();
        //if (toRemove) {
            //this.sipHeader = null;
            //this.sipMessage.removeHeader(sipHeader.getName());
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.761 -0400", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "A837AE066DA8168756BF4252BFC8B5E0")
    public boolean hasNext() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869771430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_869771430;
        // ---------- Original Method ----------
        //return index == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.762 -0400", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "9996408AEBF39D6AE9E80624861AD665")
    public boolean hasPrevious() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433438685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433438685;
        // ---------- Original Method ----------
        //return index == 1;
    }

    
}

