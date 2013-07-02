package android.hardware.usb;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import java.nio.ByteBuffer;

public class UsbRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.478 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.478 -0400", hash_original_field = "ECC0ED4D1C299F447FF3F773BFE4E0B1", hash_generated_field = "51493E5AC33E198B7B9441D1D3BB0C49")

    private UsbEndpoint mEndpoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.478 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.478 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.478 -0400", hash_original_field = "EB49787A57EE6314749EECBD21E3635C", hash_generated_field = "56DE82683B5639E270394910BD52C921")

    private Object mClientData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.479 -0400", hash_original_method = "1841EBA816AAD9B3CFCC9CFB82F138AB", hash_generated_method = "D0281338E705050B353DF71FF516D9F0")
    public  UsbRequest() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.479 -0400", hash_original_method = "5DC7CF12AEC4C5E9E1FB850AF7C3FB90", hash_generated_method = "1A0956B58482170AC73DA700B835BDFD")
    public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        mEndpoint = endpoint;
        boolean var8601498EC8322F3334BA813FFD278DCC_275583509 = (native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                endpoint.getMaxPacketSize(), endpoint.getInterval()));
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331877198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331877198;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.480 -0400", hash_original_method = "66833AAE0F898EE53D028F2100A5AAE5", hash_generated_method = "7AFE15C4DD8CC5F0F835F29A1858B4BC")
    public void close() {
        mEndpoint = null;
        native_close();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.480 -0400", hash_original_method = "7540A3E8E0E84BC6100A5A4AAC882F22", hash_generated_method = "470FC8AAD68305EC1F727CC92B922A1B")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                close();
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.481 -0400", hash_original_method = "11B9FE3CCFCADE645E006FF088DA13C2", hash_generated_method = "923419CC33A9029F6F745FAD31BACE72")
    public UsbEndpoint getEndpoint() {
        UsbEndpoint varB4EAC82CA7396A68D541C85D26508E83_2095759459 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2095759459 = mEndpoint;
        varB4EAC82CA7396A68D541C85D26508E83_2095759459.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2095759459;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.481 -0400", hash_original_method = "B71E58093DB1269AF1945AD07DDB8F74", hash_generated_method = "24FBECC66116DE48794529119C3ABF73")
    public Object getClientData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_580689915 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_580689915 = mClientData;
        varB4EAC82CA7396A68D541C85D26508E83_580689915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_580689915;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.482 -0400", hash_original_method = "D9B34A9E5333EFBBF13F29A3015D9990", hash_generated_method = "886F50FCD9BFB9352373280B6BF2CFC1")
    public void setClientData(Object data) {
        mClientData = data;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.482 -0400", hash_original_method = "0AB508D5F9E406998904FC2F468636F7", hash_generated_method = "12B44F83C8268AD20973E79FE35516F6")
    public boolean queue(ByteBuffer buffer, int length) {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        boolean result;
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_852516887 = (buffer.isDirect());
            {
                result = native_queue_direct(buffer, length, out);
            } 
            {
                boolean var163A4D58CA20E6744A144EA330661A7B_1710166205 = (buffer.hasArray());
                {
                    result = native_queue_array(buffer.array(), length, out);
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("buffer is not direct and has no array");
                } 
            } 
        } 
        {
            mBuffer = buffer;
            mLength = length;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562989307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562989307;
        
        
        
        
            
        
            
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.483 -0400", hash_original_method = "AD7D73F051931557C02FDFDEB6B3C889", hash_generated_method = "AA1E1E72D617A4CD6D504E072700BE50")
     void dequeue() {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        {
            boolean varEDE9E6DCD8AA8DD7B4BE6ED592B57F83_1384026586 = (mBuffer.isDirect());
            {
                native_dequeue_direct();
            } 
            {
                native_dequeue_array(mBuffer.array(), mLength, out);
            } 
        } 
        mBuffer = null;
        mLength = 0;
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.483 -0400", hash_original_method = "C6E3D4490B2BE3A7CABB292DA8889494", hash_generated_method = "56849B4946EF74D20B3B4004661ED051")
    public boolean cancel() {
        boolean var3CB2EB0BAF88869139A9E40C84501A1E_214589845 = (native_cancel());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931490212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_931490212;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.484 -0400", hash_original_method = "088D546DD8E640FE6DF053A8179CD4B6", hash_generated_method = "493ABA7F1CEF72D5EE45DFE82754DF3A")
    private boolean native_init(UsbDeviceConnection connection, int ep_address,
            int ep_attributes, int ep_max_packet_size, int ep_interval) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292615772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292615772;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.484 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.485 -0400", hash_original_method = "7F13ABFE9FDE97F40DC7842504BAE184", hash_generated_method = "FC6ABF6825A630EFD4186D869F11CE26")
    private boolean native_queue_array(byte[] buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045739494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045739494;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.486 -0400", hash_original_method = "3BDF4594393C8A1BD126F313DABD0D0F", hash_generated_method = "14C0D08C05C45945D5BFE9DE18F35A99")
    private void native_dequeue_array(byte[] buffer, int length, boolean out) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.487 -0400", hash_original_method = "E7AB577A437B8CBAAC35FF91F8C41F2B", hash_generated_method = "D423761E88F6B6665B8ACB86776E752C")
    private boolean native_queue_direct(ByteBuffer buffer, int length, boolean out) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888346133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888346133;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.487 -0400", hash_original_method = "558CB787B8354E17E879C85035FE4714", hash_generated_method = "567EC500351D45B790D82131561103CB")
    private void native_dequeue_direct() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.487 -0400", hash_original_method = "EF977425574389A96D73B721035A87F5", hash_generated_method = "8CD861A97F1C9EC125DC0E4AC4B08592")
    private boolean native_cancel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693355416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693355416;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.487 -0400", hash_original_field = "46C6F3781EF916FD2FE2F193B6C6B1FA", hash_generated_field = "3C8DCB2CD5AFF3FA01F8DBE0209B4F99")

    private static final String TAG = "UsbRequest";
}

