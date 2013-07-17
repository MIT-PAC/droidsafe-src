package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class TransactionTerminatedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.380 -0400", hash_original_field = "6ACF489AEE760F5E0FEB87D6474D4D18", hash_generated_field = "3875027DABF1E19F66E817463ADDFE1C")

    private boolean mIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.380 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.380 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.381 -0400", hash_original_method = "632867B97B2B335D37FE735387619A6D", hash_generated_method = "E223BFFC5D433C6F0C87C8B4DAE48C68")
    public  TransactionTerminatedEvent(
            Object source, ServerTransaction serverTransaction) {
        super(source);
        addTaint(source.getTaint());
        mServerTransaction = serverTransaction;
        mIsServerTransaction = true;
        // ---------- Original Method ----------
        //mServerTransaction = serverTransaction;
        //mIsServerTransaction = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.381 -0400", hash_original_method = "7DFFD669F06BABDE586831D790DBAADB", hash_generated_method = "841084CE3757419B762B97051F9CDAFC")
    public  TransactionTerminatedEvent(
            Object source, ClientTransaction clientTransaction) {
        super(source);
        addTaint(source.getTaint());
        mClientTransaction = clientTransaction;
        mIsServerTransaction = false;
        // ---------- Original Method ----------
        //mClientTransaction = clientTransaction;
        //mIsServerTransaction = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.382 -0400", hash_original_method = "13475C47047839CF10BE5B5662BF4F2D", hash_generated_method = "A7AB93DDCFC7CCAAAAC52C1E40C4F4E1")
    public boolean isServerTransaction() {
        boolean var6ACF489AEE760F5E0FEB87D6474D4D18_569881343 = (mIsServerTransaction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512323475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_512323475;
        // ---------- Original Method ----------
        //return mIsServerTransaction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.382 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "41168527E14FDC9BC334F3B8C0C76701")
    public ClientTransaction getClientTransaction() {
ClientTransaction var587920336DC1FA6D7B04509C85CB0821_246673298 =         mClientTransaction;
        var587920336DC1FA6D7B04509C85CB0821_246673298.addTaint(taint);
        return var587920336DC1FA6D7B04509C85CB0821_246673298;
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.382 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "088C466A1F7FF45D3C71D6830B2BF567")
    public ServerTransaction getServerTransaction() {
ServerTransaction var546EC97A1EBD7D325ADA7242D87121A0_1178886527 =         mServerTransaction;
        var546EC97A1EBD7D325ADA7242D87121A0_1178886527.addTaint(taint);
        return var546EC97A1EBD7D325ADA7242D87121A0_1178886527;
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

