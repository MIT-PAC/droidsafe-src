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
    private int mNativeContext;
    private UsbEndpoint mEndpoint;
    private ByteBuffer mBuffer;
    private int mLength;
    private Object mClientData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.168 -0400", hash_original_method = "1841EBA816AAD9B3CFCC9CFB82F138AB", hash_generated_method = "D0281338E705050B353DF71FF516D9F0")
    @DSModeled(DSC.SAFE)
    public UsbRequest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.169 -0400", hash_original_method = "5DC7CF12AEC4C5E9E1FB850AF7C3FB90", hash_generated_method = "3A97B1AAE96CF3DCACFF219EE622A5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(endpoint.dsTaint);
        boolean var8601498EC8322F3334BA813FFD278DCC_529856542 = (native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                endpoint.getMaxPacketSize(), endpoint.getInterval()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mEndpoint = endpoint;
        //return native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                //endpoint.getMaxPacketSize(), endpoint.getInterval());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.178 -0400", hash_original_method = "66833AAE0F898EE53D028F2100A5AAE5", hash_generated_method = "7AFE15C4DD8CC5F0F835F29A1858B4BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mEndpoint = null;
        native_close();
        // ---------- Original Method ----------
        //mEndpoint = null;
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.178 -0400", hash_original_method = "7540A3E8E0E84BC6100A5A4AAC882F22", hash_generated_method = "470FC8AAD68305EC1F727CC92B922A1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.179 -0400", hash_original_method = "11B9FE3CCFCADE645E006FF088DA13C2", hash_generated_method = "DCFBC43E7496F4C14D42A95968CE4FE2")
    @DSModeled(DSC.SAFE)
    public UsbEndpoint getEndpoint() {
        return (UsbEndpoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEndpoint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.180 -0400", hash_original_method = "B71E58093DB1269AF1945AD07DDB8F74", hash_generated_method = "06FBA9C5A90E445DD7A484130F4B3CCE")
    @DSModeled(DSC.SAFE)
    public Object getClientData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClientData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.182 -0400", hash_original_method = "D9B34A9E5333EFBBF13F29A3015D9990", hash_generated_method = "D7044C194E704ED147379A6661427195")
    @DSModeled(DSC.SAFE)
    public void setClientData(Object data) {
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //mClientData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.183 -0400", hash_original_method = "0AB508D5F9E406998904FC2F468636F7", hash_generated_method = "04EADCDF88452B3D686B2B7548412278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean queue(ByteBuffer buffer, int length) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(length);
        boolean out;
        out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        boolean result;
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_468497870 = (buffer.isDirect());
            {
                result = native_queue_direct(buffer, length, out);
            } //End block
            {
                boolean var163A4D58CA20E6744A144EA330661A7B_1813799440 = (buffer.hasArray());
                {
                    result = native_queue_array(buffer.array(), length, out);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("buffer is not direct and has no array");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.184 -0400", hash_original_method = "AD7D73F051931557C02FDFDEB6B3C889", hash_generated_method = "8D7027B9A3BDC2053D856F755227173F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dequeue() {
        boolean out;
        out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        {
            boolean varEDE9E6DCD8AA8DD7B4BE6ED592B57F83_777353966 = (mBuffer.isDirect());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.185 -0400", hash_original_method = "C6E3D4490B2BE3A7CABB292DA8889494", hash_generated_method = "CA33D8E2AF678DE7B023347F44702BD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancel() {
        boolean var3CB2EB0BAF88869139A9E40C84501A1E_1090952520 = (native_cancel());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.187 -0400", hash_original_method = "088D546DD8E640FE6DF053A8179CD4B6", hash_generated_method = "6FA8E439B9B17C6E6E2270ECFFEDDE1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_init(UsbDeviceConnection connection, int ep_address,
            int ep_attributes, int ep_max_packet_size, int ep_interval) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(ep_attributes);
        dsTaint.addTaint(ep_address);
        dsTaint.addTaint(ep_max_packet_size);
        dsTaint.addTaint(ep_interval);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.188 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.190 -0400", hash_original_method = "7F13ABFE9FDE97F40DC7842504BAE184", hash_generated_method = "41C861516CCE3931829655F987677F47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_queue_array(byte[] buffer, int length, boolean out) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(out);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.191 -0400", hash_original_method = "3BDF4594393C8A1BD126F313DABD0D0F", hash_generated_method = "26FAF5C881E50F510C34936523406486")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_dequeue_array(byte[] buffer, int length, boolean out) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.192 -0400", hash_original_method = "E7AB577A437B8CBAAC35FF91F8C41F2B", hash_generated_method = "B9AA28E33D14C3ACF030D5D15C65A347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_queue_direct(ByteBuffer buffer, int length, boolean out) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(out);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.192 -0400", hash_original_method = "558CB787B8354E17E879C85035FE4714", hash_generated_method = "567EC500351D45B790D82131561103CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_dequeue_direct() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.192 -0400", hash_original_method = "EF977425574389A96D73B721035A87F5", hash_generated_method = "0A7C576AA18C974B4CFFA082A95D330F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_cancel() {
        return dsTaint.getTaintBoolean();
    }

    
    private static final String TAG = "UsbRequest";
}

