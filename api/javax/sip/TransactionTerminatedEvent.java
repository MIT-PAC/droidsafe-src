package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class TransactionTerminatedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.320 -0400", hash_original_field = "6ACF489AEE760F5E0FEB87D6474D4D18", hash_generated_field = "3875027DABF1E19F66E817463ADDFE1C")

    private boolean mIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.320 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.321 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.322 -0400", hash_original_method = "632867B97B2B335D37FE735387619A6D", hash_generated_method = "E223BFFC5D433C6F0C87C8B4DAE48C68")
    public  TransactionTerminatedEvent(
            Object source, ServerTransaction serverTransaction) {
        super(source);
        addTaint(source.getTaint());
        mServerTransaction = serverTransaction;
        mIsServerTransaction = true;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.323 -0400", hash_original_method = "7DFFD669F06BABDE586831D790DBAADB", hash_generated_method = "841084CE3757419B762B97051F9CDAFC")
    public  TransactionTerminatedEvent(
            Object source, ClientTransaction clientTransaction) {
        super(source);
        addTaint(source.getTaint());
        mClientTransaction = clientTransaction;
        mIsServerTransaction = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.323 -0400", hash_original_method = "13475C47047839CF10BE5B5662BF4F2D", hash_generated_method = "D46251921A43D9233889AA4C1CFDF409")
    public boolean isServerTransaction() {
        boolean var6ACF489AEE760F5E0FEB87D6474D4D18_1324033812 = (mIsServerTransaction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042602667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042602667;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.323 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "C3EF7905C236543F1F912829DAC7D45D")
    public ClientTransaction getClientTransaction() {
ClientTransaction var587920336DC1FA6D7B04509C85CB0821_964876917 =         mClientTransaction;
        var587920336DC1FA6D7B04509C85CB0821_964876917.addTaint(taint);
        return var587920336DC1FA6D7B04509C85CB0821_964876917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.323 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "0300E748A4E90785E8713478423576E9")
    public ServerTransaction getServerTransaction() {
ServerTransaction var546EC97A1EBD7D325ADA7242D87121A0_1964162748 =         mServerTransaction;
        var546EC97A1EBD7D325ADA7242D87121A0_1964162748.addTaint(taint);
        return var546EC97A1EBD7D325ADA7242D87121A0_1964162748;
        
        
    }

    
}

