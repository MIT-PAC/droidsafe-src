package gov.nist.javax.sip.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class HeaderIterator implements ListIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.627 -0400", hash_original_field = "EE2C880E2186FB7D858C0E6D8A2A35B4", hash_generated_field = "8B45939C2DCF0A4AAAC1D2D65D70A62B")

    private boolean toRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.627 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.627 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "D1F72E6C3AC858F6F50FFB2B76070DF5")

    private SIPMessage sipMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.627 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "0DC61CEBEA823ADBD35BAF3BA61B2B68")

    private SIPHeader sipHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.627 -0400", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "513E3B1158BAD913FFE0123019121598")
    protected  HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        this.sipMessage = sipMessage;
        this.sipHeader = sipHeader;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.628 -0400", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "FCEEF17B7CC13AAD36B7E06C22A86095")
    public Object next() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_333221543 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 1;
        varB4EAC82CA7396A68D541C85D26508E83_333221543 = (Object) sipHeader;
        varB4EAC82CA7396A68D541C85D26508E83_333221543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_333221543;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.629 -0400", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "997F88BCD4270899FC673DAF3D39E943")
    public Object previous() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_662525952 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        toRemove = true;
        index = 0;
        varB4EAC82CA7396A68D541C85D26508E83_662525952 = (Object) sipHeader;
        varB4EAC82CA7396A68D541C85D26508E83_662525952.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_662525952;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.629 -0400", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "41C42CFBF099FD848EAA5C44E292CD31")
    public int nextIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292667271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292667271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.630 -0400", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "1D77E3B2DD91B8A23D81862B7443AD12")
    public int previousIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858398969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858398969;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.630 -0400", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "9AA672A5BE0E25F0501D8DAD6C5511D1")
    public void set(Object header) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(header.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.630 -0400", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "BB5E2752082F2900D11DF1ECB5778D58")
    public void add(Object header) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(header.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.630 -0400", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "7D30EF14799A16D744CEA809ACAD6C47")
    public void remove() throws IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        {
            this.sipHeader = null;
            this.sipMessage.removeHeader(sipHeader.getName());
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        
        
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.631 -0400", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "17D58114F99226768E9D3C6F73C90C9D")
    public boolean hasNext() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037491560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037491560;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.631 -0400", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "F4C96C2B807E2E582019961A50E7CFA3")
    public boolean hasPrevious() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323457041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_323457041;
        
        
    }

    
}

