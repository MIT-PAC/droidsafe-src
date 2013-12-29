package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.util.ListIterator;
import java.util.NoSuchElementException;






public class HeaderIterator implements ListIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.990 -0500", hash_original_field = "3C93204531B7E90EE919CA293E960B6C", hash_generated_field = "8B45939C2DCF0A4AAAC1D2D65D70A62B")

    private boolean toRemove;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.991 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.992 -0500", hash_original_field = "788242283F58A2359ABCFCC146D1CC65", hash_generated_field = "D1F72E6C3AC858F6F50FFB2B76070DF5")

    private SIPMessage sipMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.992 -0500", hash_original_field = "EC37AFF31FBF9EE8C49132F07EB0F32A", hash_generated_field = "0DC61CEBEA823ADBD35BAF3BA61B2B68")

    private SIPHeader sipHeader;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.993 -0500", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "AF2DC62A4912416378E10A60227F8C27")
    protected HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        this.sipMessage = sipMessage;
        this.sipHeader = sipHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.994 -0500", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "EA23CD685AE3030BB57C56A459B29DDB")
    public Object next() throws NoSuchElementException {
        if (sipHeader == null || index == 1)
            throw new NoSuchElementException();
        toRemove = true;
        index = 1;
        return (Object) sipHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.996 -0500", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "0825DA7BA34946EDD4256F5B3A45AAE6")
    public Object previous() throws NoSuchElementException {
        if (sipHeader == null || index == 0)
            throw new NoSuchElementException();
        toRemove = true;
        index = 0;
        return (Object) sipHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.996 -0500", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "7EB6864BAFA0113F01B3B33A28CD242F")
    public int nextIndex() {
        return 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.997 -0500", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "9A450C524EF3508D3D63D74565377335")
    public int previousIndex() {
        return index == 0 ? -1 : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.998 -0500", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "19B69DB3617938FB59CD656369AEAE99")
    public void set(Object header) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.999 -0500", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "03D954965B5B1EBC0CCD7D9DB9596DBA")
    public void add(Object header) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.000 -0500", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "9C60AD9F7F88C8B53704DB627FA91A9A")
    public void remove() throws IllegalStateException {
        if (this.sipHeader == null)
            throw new IllegalStateException();
        if (toRemove) {
            this.sipHeader = null;
            this.sipMessage.removeHeader(sipHeader.getName());
        } else {
            throw new IllegalStateException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.000 -0500", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "F4CEF0BA549C4836311517E1B518CBA4")
    public boolean hasNext() {
        return index == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:06.001 -0500", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "E8398FF7E2BBB56190B82CB0A85304F0")
    public boolean hasPrevious() {
        return index == 1;
    }

    
}

