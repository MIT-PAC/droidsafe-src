package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.nio.ByteBuffer;

public class UsbRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.003 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.003 -0400", hash_original_field = "ECC0ED4D1C299F447FF3F773BFE4E0B1", hash_generated_field = "51493E5AC33E198B7B9441D1D3BB0C49")

    private UsbEndpoint mEndpoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.003 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.004 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.004 -0400", hash_original_field = "EB49787A57EE6314749EECBD21E3635C", hash_generated_field = "56DE82683B5639E270394910BD52C921")

    private Object mClientData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.004 -0400", hash_original_method = "1841EBA816AAD9B3CFCC9CFB82F138AB", hash_generated_method = "D0281338E705050B353DF71FF516D9F0")
    public  UsbRequest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.004 -0400", hash_original_method = "5DC7CF12AEC4C5E9E1FB850AF7C3FB90", hash_generated_method = "BA18A20C688297E5C6F991DD19ED169B")
    public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        addTaint(connection.getTaint());
        mEndpoint = endpoint;
        boolean varD19EFC446A549B98DFCF75FF60DF8AA3_1064917824 = (native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                endpoint.getMaxPacketSize(), endpoint.getInterval()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807688294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807688294;
        // ---------- Original Method ----------
        //mEndpoint = endpoint;
        //return native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                //endpoint.getMaxPacketSize(), endpoint.getInterval());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.005 -0400", hash_original_method = "66833AAE0F898EE53D028F2100A5AAE5", hash_generated_method = "7AFE15C4DD8CC5F0F835F29A1858B4BC")
    public void close() {
        mEndpoint = null;
        native_close();
        // ---------- Original Method ----------
        //mEndpoint = null;
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.005 -0400", hash_original_method = "7540A3E8E0E84BC6100A5A4AAC882F22", hash_generated_method = "FA7FF91424CDAC7ED2DF62AFF0BE5B53")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(mEndpoint != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.005 -0400", hash_original_method = "11B9FE3CCFCADE645E006FF088DA13C2", hash_generated_method = "3FC196492185F1ED2C4F4BA77840B6EE")
    public UsbEndpoint getEndpoint() {
UsbEndpoint var1E2C04928ABBA6D082564726F43A8D42_1699042542 =         mEndpoint;
        var1E2C04928ABBA6D082564726F43A8D42_1699042542.addTaint(taint);
        return var1E2C04928ABBA6D082564726F43A8D42_1699042542;
        // ---------- Original Method ----------
        //return mEndpoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.006 -0400", hash_original_method = "B71E58093DB1269AF1945AD07DDB8F74", hash_generated_method = "316C2B2C476165A0146FA9370DA4F324")
    public Object getClientData() {
Object varB655F44450C96892E9EC7109124959C6_357653487 =         mClientData;
        varB655F44450C96892E9EC7109124959C6_357653487.addTaint(taint);
        return varB655F44450C96892E9EC7109124959C6_357653487;
        // ---------- Original Method ----------
        //return mClientData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.006 -0400", hash_original_method = "D9B34A9E5333EFBBF13F29A3015D9990", hash_generated_method = "886F50FCD9BFB9352373280B6BF2CFC1")
    public void setClientData(Object data) {
        mClientData = data;
        // ---------- Original Method ----------
        //mClientData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.007 -0400", hash_original_method = "0AB508D5F9E406998904FC2F468636F7", hash_generated_method = "2A7DFF34691ED6BBC395F2AD25D6E307")
    public boolean queue(ByteBuffer buffer, int length) {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        boolean result;
    if(buffer.isDirect())        
        {
            result = native_queue_direct(buffer, length, out);
        } //End block
        else
    if(buffer.hasArray())        
        {
            result = native_queue_array(buffer.array(), length, out);
        } //End block
        else
        {
            IllegalArgumentException var4868514B85AD74F9465F0720468F9153_386939822 = new IllegalArgumentException("buffer is not direct and has no array");
            var4868514B85AD74F9465F0720468F9153_386939822.addTaint(taint);
            throw var4868514B85AD74F9465F0720468F9153_386939822;
        } //End block
    if(result)        
        {
            mBuffer = buffer;
            mLength = length;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_117301944 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541624494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541624494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.008 -0400", hash_original_method = "AD7D73F051931557C02FDFDEB6B3C889", hash_generated_method = "2A87DE7AAA38E7AEBE82880953197730")
     void dequeue() {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
    if(mBuffer.isDirect())        
        {
            native_dequeue_direct();
        } //End block
        else
        {
            native_dequeue_array(mBuffer.array(), mLength, out);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.008 -0400", hash_original_method = "C6E3D4490B2BE3A7CABB292DA8889494", hash_generated_method = "E1CECF6F0DB091ED3E9FF484C5408131")
    public boolean cancel() {
        boolean var3571E4E039B5EC80F104C97C37B6B351_314458084 = (native_cancel());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450545851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450545851;
        // ---------- Original Method ----------
        //return native_cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.009 -0400", hash_original_method = "088D546DD8E640FE6DF053A8179CD4B6", hash_generated_method = "56188DB14972BC281FC1E4C398F01052")
    private boolean native_init(UsbDeviceConnection connection, int ep_address,
            int ep_attributes, int ep_max_packet_size, int ep_interval) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422764056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422764056;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.009 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.010 -0400", hash_original_method = "7F13ABFE9FDE97F40DC7842504BAE184", hash_generated_method = "223F7D2E4DE0D0972C1CAB01DB2CE644")
    private boolean native_queue_array(byte[] buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405346445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405346445;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.010 -0400", hash_original_method = "3BDF4594393C8A1BD126F313DABD0D0F", hash_generated_method = "14C0D08C05C45945D5BFE9DE18F35A99")
    private void native_dequeue_array(byte[] buffer, int length, boolean out) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.011 -0400", hash_original_method = "E7AB577A437B8CBAAC35FF91F8C41F2B", hash_generated_method = "18C208A9A06AD1C0A5B744E1C49BAD72")
    private boolean native_queue_direct(ByteBuffer buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382933643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382933643;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.011 -0400", hash_original_method = "558CB787B8354E17E879C85035FE4714", hash_generated_method = "567EC500351D45B790D82131561103CB")
    private void native_dequeue_direct() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.011 -0400", hash_original_method = "EF977425574389A96D73B721035A87F5", hash_generated_method = "4754C703378575CE3879B18193E524E2")
    private boolean native_cancel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_542075696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_542075696;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.011 -0400", hash_original_field = "46C6F3781EF916FD2FE2F193B6C6B1FA", hash_generated_field = "3C8DCB2CD5AFF3FA01F8DBE0209B4F99")

    private static final String TAG = "UsbRequest";
}

