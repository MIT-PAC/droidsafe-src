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
    private boolean toRemove;
    private int index;
    private SIPMessage sipMessage;
    private SIPHeader sipHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.679 -0400", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "679A83343EF8D329F308D01AD4120BA7")
    @DSModeled(DSC.SAFE)
    protected HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        dsTaint.addTaint(sipHeader.dsTaint);
        dsTaint.addTaint(sipMessage.dsTaint);
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
        //this.sipHeader = sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.680 -0400", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "4247177D48ABBED2458E10802A1B4B66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object next() throws NoSuchElementException {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 1;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 1)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 1;
        //return (Object) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.680 -0400", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "9232347A619A96FE59986B8222FA6440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object previous() throws NoSuchElementException {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 0;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 0)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 0;
        //return (Object) sipHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.680 -0400", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "17789BAA269FDAB9EA68C9DCCE1AC18D")
    @DSModeled(DSC.SAFE)
    public int nextIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.680 -0400", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "473E0D36DA965088790223065A96C647")
    @DSModeled(DSC.SAFE)
    public int previousIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return index == 0 ? -1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.680 -0400", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "207A966CAB5CB8DB0B9162A4577034FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(Object header) {
        dsTaint.addTaint(header.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.681 -0400", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "826286CB0F35104D79B968DECB4910B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(Object header) {
        dsTaint.addTaint(header.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.681 -0400", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "7D30EF14799A16D744CEA809ACAD6C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.681 -0400", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "4B84C8A300442BCE3B71293D9E8E6C35")
    @DSModeled(DSC.SAFE)
    public boolean hasNext() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return index == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.681 -0400", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "E1B4D1D9705193D56F724366892D7776")
    @DSModeled(DSC.SAFE)
    public boolean hasPrevious() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return index == 1;
    }

    
}

