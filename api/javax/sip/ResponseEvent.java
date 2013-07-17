package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;
import javax.sip.message.Response;

public class ResponseEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.296 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.296 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "357A96A988CEB8869E67EAB0CC1CA73C")

    private Response mResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.296 -0400", hash_original_field = "C0EE02CC55392CBD06E928953A0AD9C5", hash_generated_field = "A2FE03B3287159BF06762C26E990AE5E")

    private ClientTransaction mClientTransaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.298 -0400", hash_original_method = "F99FD2C7A85B9DCBE0AD9A9C8BE9081F", hash_generated_method = "87B9627EF5E7E8F159809DBCE4923C48")
    public  ResponseEvent(Object source, ClientTransaction clientTransaction,
            Dialog dialog, Response response) {
        super(source);
        addTaint(source.getTaint());
        mDialog = dialog;
        mResponse = response;
        mClientTransaction = clientTransaction;
        // ---------- Original Method ----------
        //mDialog = dialog;
        //mResponse = response;
        //mClientTransaction = clientTransaction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.299 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "652F6E548C1DEF2886D25505A20B0034")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_946736730 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_946736730.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_946736730;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.299 -0400", hash_original_method = "00292A90D159CA5BE7BB594CFFCF61C9", hash_generated_method = "D6F095CEFC5682DE138738A6AB149F51")
    public Response getResponse() {
Response var9877D6D2C0C7E462961573FA67FD4378_1350147890 =         mResponse;
        var9877D6D2C0C7E462961573FA67FD4378_1350147890.addTaint(taint);
        return var9877D6D2C0C7E462961573FA67FD4378_1350147890;
        // ---------- Original Method ----------
        //return mResponse;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.300 -0400", hash_original_method = "00896F7299BD9459656811B60B06B2C6", hash_generated_method = "E672D64BE48ED77A5C81254A17CD6AEC")
    public ClientTransaction getClientTransaction() {
ClientTransaction var587920336DC1FA6D7B04509C85CB0821_255843025 =         mClientTransaction;
        var587920336DC1FA6D7B04509C85CB0821_255843025.addTaint(taint);
        return var587920336DC1FA6D7B04509C85CB0821_255843025;
        // ---------- Original Method ----------
        //return mClientTransaction;
    }

    
}

