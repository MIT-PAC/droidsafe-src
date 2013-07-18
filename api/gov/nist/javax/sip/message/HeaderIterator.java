package gov.nist.javax.sip.message;

// Droidsafe Imports
import gov.nist.javax.sip.header.SIPHeader;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HeaderIterator implements ListIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.559 -0400", hash_original_field = "EE2C880E2186FB7D858C0E6D8A2A35B4", hash_generated_field = "8B45939C2DCF0A4AAAC1D2D65D70A62B")

    private boolean toRemove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.559 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.559 -0400", hash_original_field = "6637F26A1693081920A4A68C1290C2FB", hash_generated_field = "D1F72E6C3AC858F6F50FFB2B76070DF5")

    private SIPMessage sipMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.560 -0400", hash_original_field = "801C5528BD97282F366DB1FF3EE2BF49", hash_generated_field = "0DC61CEBEA823ADBD35BAF3BA61B2B68")

    private SIPHeader sipHeader;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.561 -0400", hash_original_method = "F7312950516DDC7BFFF0814D6316FA82", hash_generated_method = "513E3B1158BAD913FFE0123019121598")
    protected  HeaderIterator(SIPMessage sipMessage, SIPHeader sipHeader) {
        this.sipMessage = sipMessage;
        this.sipHeader = sipHeader;
        // ---------- Original Method ----------
        //this.sipMessage = sipMessage;
        //this.sipHeader = sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.562 -0400", hash_original_method = "6FB6963A35AF87D8C9632D10AB0BDA7B", hash_generated_method = "FC6248D5F3382DDF07A30E5DC3FE286C")
    public Object next() throws NoSuchElementException {
        if(sipHeader == null || index == 1)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_507958924 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_507958924.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_507958924;
        }
        toRemove = true;
        index = 1;
Object varEF1201B3CC1396FAA0466958889D378C_1613489786 =         (Object) sipHeader;
        varEF1201B3CC1396FAA0466958889D378C_1613489786.addTaint(taint);
        return varEF1201B3CC1396FAA0466958889D378C_1613489786;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 1)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 1;
        //return (Object) sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.563 -0400", hash_original_method = "5CEE41DECD9DF8843F0A3C73CCBAAFDA", hash_generated_method = "0B6C1D50F17B8F097D44E3B0B1DA8215")
    public Object previous() throws NoSuchElementException {
        if(sipHeader == null || index == 0)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1821927944 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1821927944.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1821927944;
        }
        toRemove = true;
        index = 0;
Object varEF1201B3CC1396FAA0466958889D378C_1026935646 =         (Object) sipHeader;
        varEF1201B3CC1396FAA0466958889D378C_1026935646.addTaint(taint);
        return varEF1201B3CC1396FAA0466958889D378C_1026935646;
        // ---------- Original Method ----------
        //if (sipHeader == null || index == 0)
            //throw new NoSuchElementException();
        //toRemove = true;
        //index = 0;
        //return (Object) sipHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.564 -0400", hash_original_method = "0B45A065656087279C8F30222D1F6A91", hash_generated_method = "C9D3454DB105D1D7AA1DEEE15E0B8E37")
    public int nextIndex() {
        int varC4CA4238A0B923820DCC509A6F75849B_1805891453 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436716584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436716584;
        // ---------- Original Method ----------
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.564 -0400", hash_original_method = "A86688C47AAA2CAB26A2462BDF3B71EF", hash_generated_method = "2644CA48D755ACD71613FF4AFAD7E404")
    public int previousIndex() {
        int varA5E8E1969D4CC21750D1B1B12E93F92A_671157012 = (index == 0 ? -1 : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544539249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544539249;
        // ---------- Original Method ----------
        //return index == 0 ? -1 : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.565 -0400", hash_original_method = "560AF6CD6614E15175ADEE44F5D56698", hash_generated_method = "2444269C54C83EEBFBE2D5698E384B70")
    public void set(Object header) {
        addTaint(header.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1392038066 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1392038066.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1392038066;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.565 -0400", hash_original_method = "37FBFD4C74D96ADCBBD0EC003E0F1550", hash_generated_method = "B8F49FF8CD7064247C2149D7E0201292")
    public void add(Object header) {
        addTaint(header.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1442995736 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1442995736.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1442995736;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.566 -0400", hash_original_method = "BDF8EE173B5DB1D3D9A7674043D7B19F", hash_generated_method = "5678E3EBBDAFF82D8DA293F4B4DF194D")
    public void remove() throws IllegalStateException {
        if(this.sipHeader == null)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1217381416 = new IllegalStateException();
        varC311A989A119B96A6232C22ABFE87C25_1217381416.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_1217381416;
        }
        if(toRemove)        
        {
            this.sipHeader = null;
            this.sipMessage.removeHeader(sipHeader.getName());
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_711185946 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_711185946.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_711185946;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.568 -0400", hash_original_method = "4022889478A9417F354658DD9E31C17D", hash_generated_method = "6981F8A007D0847143BCE70BD44F0EE9")
    public boolean hasNext() {
        boolean varF60E09BAEA3EE14084045DA7FE4E6E9E_1228259211 = (index == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423865738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423865738;
        // ---------- Original Method ----------
        //return index == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.568 -0400", hash_original_method = "F16A855901EB074320480EE478FDC075", hash_generated_method = "0C988FAC5AF4FF762D3B1D17E79AAD85")
    public boolean hasPrevious() {
        boolean var7E90558AD636611151144BDB114D6F75_1287855988 = (index == 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932924231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932924231;
        // ---------- Original Method ----------
        //return index == 1;
    }

    
}

