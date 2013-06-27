package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.nio.ByteBuffer;

public class UsbRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.446 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.446 -0400", hash_original_field = "ECC0ED4D1C299F447FF3F773BFE4E0B1", hash_generated_field = "51493E5AC33E198B7B9441D1D3BB0C49")

    private UsbEndpoint mEndpoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.446 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.446 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.446 -0400", hash_original_field = "EB49787A57EE6314749EECBD21E3635C", hash_generated_field = "56DE82683B5639E270394910BD52C921")

    private Object mClientData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.463 -0400", hash_original_method = "1841EBA816AAD9B3CFCC9CFB82F138AB", hash_generated_method = "D0281338E705050B353DF71FF516D9F0")
    public  UsbRequest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.464 -0400", hash_original_method = "5DC7CF12AEC4C5E9E1FB850AF7C3FB90", hash_generated_method = "8718FA88D1F908597A4C37FF0B627633")
    public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        mEndpoint = endpoint;
        boolean var8601498EC8322F3334BA813FFD278DCC_1125192359 = (native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                endpoint.getMaxPacketSize(), endpoint.getInterval()));
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738188847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738188847;
        // ---------- Original Method ----------
        //mEndpoint = endpoint;
        //return native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                //endpoint.getMaxPacketSize(), endpoint.getInterval());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.465 -0400", hash_original_method = "66833AAE0F898EE53D028F2100A5AAE5", hash_generated_method = "7AFE15C4DD8CC5F0F835F29A1858B4BC")
    public void close() {
        mEndpoint = null;
        native_close();
        // ---------- Original Method ----------
        //mEndpoint = null;
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.466 -0400", hash_original_method = "7540A3E8E0E84BC6100A5A4AAC882F22", hash_generated_method = "470FC8AAD68305EC1F727CC92B922A1B")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                close();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mEndpoint != null) {
                //Log.v(TAG, "endpoint still open in finalize(): " + this);
                //close();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.474 -0400", hash_original_method = "11B9FE3CCFCADE645E006FF088DA13C2", hash_generated_method = "6C58ADB597CBE4CAF7D805F014BF4924")
    public UsbEndpoint getEndpoint() {
        UsbEndpoint varB4EAC82CA7396A68D541C85D26508E83_1798273675 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798273675 = mEndpoint;
        varB4EAC82CA7396A68D541C85D26508E83_1798273675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798273675;
        // ---------- Original Method ----------
        //return mEndpoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.490 -0400", hash_original_method = "B71E58093DB1269AF1945AD07DDB8F74", hash_generated_method = "41EBAB0DA339092D5B660FDA08514C79")
    public Object getClientData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1304267666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1304267666 = mClientData;
        varB4EAC82CA7396A68D541C85D26508E83_1304267666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1304267666;
        // ---------- Original Method ----------
        //return mClientData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.490 -0400", hash_original_method = "D9B34A9E5333EFBBF13F29A3015D9990", hash_generated_method = "886F50FCD9BFB9352373280B6BF2CFC1")
    public void setClientData(Object data) {
        mClientData = data;
        // ---------- Original Method ----------
        //mClientData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.507 -0400", hash_original_method = "0AB508D5F9E406998904FC2F468636F7", hash_generated_method = "1815A06993A13A5069ECCC8B759E9CAF")
    public boolean queue(ByteBuffer buffer, int length) {
        boolean out;
        out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        boolean result;
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_459908230 = (buffer.isDirect());
            {
                result = native_queue_direct(buffer, length, out);
            } //End block
            {
                boolean var163A4D58CA20E6744A144EA330661A7B_1359819859 = (buffer.hasArray());
                {
                    result = native_queue_array(buffer.array(), length, out);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("buffer is not direct and has no array");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            mBuffer = buffer;
            mLength = length;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139890805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139890805;
        // ---------- Original Method ----------
        //boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        //boolean result;
        //if (buffer.isDirect()) {
            //result = native_queue_direct(buffer, length, out);
        //} else if (buffer.hasArray()) {
            //result = native_queue_array(buffer.array(), length, out);
        //} else {
            //throw new IllegalArgumentException("buffer is not direct and has no array");
        //}
        //if (result) {
            //mBuffer = buffer;
            //mLength = length;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.508 -0400", hash_original_method = "AD7D73F051931557C02FDFDEB6B3C889", hash_generated_method = "6C403D945B5B5DA852FD459EF7C3E45E")
     void dequeue() {
        boolean out;
        out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        {
            boolean varEDE9E6DCD8AA8DD7B4BE6ED592B57F83_1541166221 = (mBuffer.isDirect());
            {
                native_dequeue_direct();
            } //End block
            {
                native_dequeue_array(mBuffer.array(), mLength, out);
            } //End block
        } //End collapsed parenthetic
        mBuffer = null;
        mLength = 0;
        // ---------- Original Method ----------
        //boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        //if (mBuffer.isDirect()) {
            //native_dequeue_direct();
        //} else {
            //native_dequeue_array(mBuffer.array(), mLength, out);
        //}
        //mBuffer = null;
        //mLength = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.513 -0400", hash_original_method = "C6E3D4490B2BE3A7CABB292DA8889494", hash_generated_method = "1C72BC565DCA59D42A77134610DF7BB4")
    public boolean cancel() {
        boolean var3CB2EB0BAF88869139A9E40C84501A1E_1240597246 = (native_cancel());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_420493212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_420493212;
        // ---------- Original Method ----------
        //return native_cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.513 -0400", hash_original_method = "088D546DD8E640FE6DF053A8179CD4B6", hash_generated_method = "96DFBB5DD2365C954F8CD80CDB522DFA")
    private boolean native_init(UsbDeviceConnection connection, int ep_address,
            int ep_attributes, int ep_max_packet_size, int ep_interval) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993699145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993699145;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.514 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.514 -0400", hash_original_method = "7F13ABFE9FDE97F40DC7842504BAE184", hash_generated_method = "B660381D79341693F018B3AC66DB7AA0")
    private boolean native_queue_array(byte[] buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618903159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618903159;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.515 -0400", hash_original_method = "3BDF4594393C8A1BD126F313DABD0D0F", hash_generated_method = "14C0D08C05C45945D5BFE9DE18F35A99")
    private void native_dequeue_array(byte[] buffer, int length, boolean out) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.531 -0400", hash_original_method = "E7AB577A437B8CBAAC35FF91F8C41F2B", hash_generated_method = "C8F3D59FDFF95B31FEED73D322D6A9F3")
    private boolean native_queue_direct(ByteBuffer buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809341451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809341451;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.531 -0400", hash_original_method = "558CB787B8354E17E879C85035FE4714", hash_generated_method = "567EC500351D45B790D82131561103CB")
    private void native_dequeue_direct() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.532 -0400", hash_original_method = "EF977425574389A96D73B721035A87F5", hash_generated_method = "5BA4F1E5B46B4BA5816457484C82C836")
    private boolean native_cancel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975843815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975843815;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.532 -0400", hash_original_field = "46C6F3781EF916FD2FE2F193B6C6B1FA", hash_generated_field = "AD17A0E975579201B461FF34BCD7496E")

    private static String TAG = "UsbRequest";
}

