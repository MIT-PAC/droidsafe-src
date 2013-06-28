package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class TransactionTerminatedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.128 -0400", hash_original_field = "6ACF489AEE760F5E0FEB87D6474D4D18", hash_generated_field = "3875027DABF1E19F66E817463ADDFE1C")

    private boolean mIsServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.128 -0400", hash_original_field = "9512BFD2351AA348680BC0368D1B6879", hash_generated_field = "FF9951F95B61CCF65F36CC4EF2056786")

    private ServerTransaction mServerTransaction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.128 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.129 -0400", hash_original_method = "632867B97B2B335D37FE735387619A6D", hash_generated_method = "6AD30E80BB38A3A4D1B7DAFFEA061D9A")
    public  TransactionTerminatedEvent(
            Object source, ServerTransaction serverTransaction) {
        super(source);
        mServerTransaction = serverTransaction;
        mIsServerTransaction = true;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //mServerTransaction = serverTransaction;
        //mIsServerTransaction = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.129 -0400", hash_original_method = "7DFFD669F06BABDE586831D790DBAADB", hash_generated_method = "774602283843F7545BCB056F5E90EA55")
    public  TransactionTerminatedEvent(
            Object source, ClientTransaction clientTransaction) {
        super(source);
        mClientTransaction = clientTransaction;
        mIsServerTransaction = false;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //mClientTransaction = clientTransaction;
        //mIsServerTransaction = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.130 -0400", hash_original_method = "13475C47047839CF10BE5B5662BF4F2D", hash_generated_method = "E8E0D7EE44AA1152190F7497556E667B")
    public boolean isServerTransaction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248778380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248778380;
        // ---------- Original Method ----------
        //return mIsServerTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.131 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "17C2A14382613463FDC6580508C62C1B")
    public ClientTransaction getClientTransaction() {
        ClientTransaction varB4EAC82CA7396A68D541C85D26508E83_2077657396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2077657396 = mClientTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_2077657396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2077657396;
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.131 -0400", hash_original_method = "8D21BCE8DC60E722EE457FD9027E91F0", hash_generated_method = "18DEF6D606B4D97F632379D5F97BA2C6")
    public ServerTransaction getServerTransaction() {
        ServerTransaction varB4EAC82CA7396A68D541C85D26508E83_1698987274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1698987274 = mServerTransaction;
        varB4EAC82CA7396A68D541C85D26508E83_1698987274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698987274;
        // ---------- Original Method ----------
        //return mServerTransaction;
    }

    
}

