package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class HeaderIterator implements ListIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.270 -0400", hash_original_field = "EE2C880E2186FB7D858C0E6D8A2A35B4", hash_generated_field = "8B45939C2DCF0A4AAAC1D2D65D70A62B")

    private boolean toRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.270 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.270 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "D1F72E6C3AC858F6F50FFB2B76070DF5")

    private SIPMessage sipMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.270 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "0DC61CEBEA823ADBD35BAF3BA61B2B68")

    private SIPHeader sipHeader;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.271 -0400", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "513E3B1158BAD913FFE0123019121598")
    protected  HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        this.sipMessage = sipMessage;
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
        //this.sipHeader = sipHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.272 -0400", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "F56A58CB3F5F89ECD5C2F7420AC67461")
    public Object next() throws NoSuchElementException {
    if(sipHeader == null || index == 1)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1524912861 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1524912861.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1524912861;
        }
        toRemove = true;
        index = 1;
Object varEF1201B3CC1396FAA0466958889D378C_122657443 =         (Object) sipHeader;
        varEF1201B3CC1396FAA0466958889D378C_122657443.addTaint(taint);
        return varEF1201B3CC1396FAA0466958889D378C_122657443;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 1)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 1;
        //return (Object) sipHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.273 -0400", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "AF70CCDBB5A954669ED41BFBC37C0152")
    public Object previous() throws NoSuchElementException {
    if(sipHeader == null || index == 0)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_408009783 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_408009783.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_408009783;
        }
        toRemove = true;
        index = 0;
Object varEF1201B3CC1396FAA0466958889D378C_36549170 =         (Object) sipHeader;
        varEF1201B3CC1396FAA0466958889D378C_36549170.addTaint(taint);
        return varEF1201B3CC1396FAA0466958889D378C_36549170;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 0)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 0;
        //return (Object) sipHeader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.273 -0400", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "CE56A85FCB061FFFC948DBCC644A77E0")
    public int nextIndex() {
        int varC4CA4238A0B923820DCC509A6F75849B_721756427 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937212271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937212271;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.274 -0400", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "B4733EF6C27E31A150E082419AE124C9")
    public int previousIndex() {
        int varA5E8E1969D4CC21750D1B1B12E93F92A_909102837 = (index == 0 ? -1 : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56110973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56110973;
        // ---------- Original Method ----------
        //return index == 0 ? -1 : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.274 -0400", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "D94391ACF1DDDC8C6A1D63A78E307B53")
    public void set(Object header) {
        addTaint(header.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1799724856 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1799724856.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1799724856;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.275 -0400", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "6BCE55683CBCFA57DFBB61C03AFD4ABB")
    public void add(Object header) {
        addTaint(header.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_249544540 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_249544540.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_249544540;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.275 -0400", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "7D2833B84C14CB1FB4E6765D1B3E025C")
    public void remove() throws IllegalStateException {
    if(this.sipHeader == null)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_646400988 = new IllegalStateException();
        varC311A989A119B96A6232C22ABFE87C25_646400988.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_646400988;
        }
    if(toRemove)        
        {
            this.sipHeader = null;
            this.sipMessage.removeHeader(sipHeader.getName());
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2139866163 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2139866163.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2139866163;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.276 -0400", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "9BC402AE14551E98DF7889433F4B2E0E")
    public boolean hasNext() {
        boolean varF60E09BAEA3EE14084045DA7FE4E6E9E_1973188495 = (index == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057893281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057893281;
        // ---------- Original Method ----------
        //return index == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.276 -0400", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "F26AC4AD496B3738D44F7D7DFAE46A85")
    public boolean hasPrevious() {
        boolean var7E90558AD636611151144BDB114D6F75_239975645 = (index == 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810571214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810571214;
        // ---------- Original Method ----------
        //return index == 1;
    }

    
}

