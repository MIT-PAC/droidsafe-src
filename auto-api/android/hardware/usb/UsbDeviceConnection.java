package android.hardware.usb;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;

public class UsbDeviceConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.327 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private UsbDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.327 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.328 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "D29F217DDACE7CAD99DBB7C07BFE803F")
    public  UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.329 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "EBC645C57F307FE0101B17D2A72C2E72")
     boolean open(String name, ParcelFileDescriptor pfd) {
        boolean var285CA921394210A8A14FA5321382861D_490555944 = (native_open(name, pfd.getFileDescriptor()));
        addTaint(name.getTaint());
        addTaint(pfd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109875339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109875339;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.331 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    public void close() {
        native_close();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.332 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "D68B633203544291333119228AA1367B")
    public int getFileDescriptor() {
        int varDCF731014B54D36E839911CCA817AAEC_631022485 = (native_get_fd());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578036358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578036358;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.333 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "99668D7A1B42CA3BB42995A8E5D8D230")
    public byte[] getRawDescriptors() {
        byte[] var3ABF97E7775A43AB3F99332CAC204E50_1840664904 = (native_get_desc());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1976483552 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1976483552;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.334 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "531926248826D6A9C0AE8F6FFE55B22D")
    public boolean claimInterface(UsbInterface intf, boolean force) {
        boolean varF72D9A92CD09EC2DFD63F512D78E45AD_1787749317 = (native_claim_interface(intf.getId(), force));
        addTaint(intf.getTaint());
        addTaint(force);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61769915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61769915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.335 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "A0670165B75B98451417ED24C1CF89B4")
    public boolean releaseInterface(UsbInterface intf) {
        boolean var4079C9E4E51FF59009DDBDBCBF503A61_1308189301 = (native_release_interface(intf.getId()));
        addTaint(intf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782618503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_782618503;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.336 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "1295B205DDB0EC95E362F30E2356B5DC")
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int var6B3ADFC6D6D7BAFC293350EE1F32F91F_1739074176 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
        addTaint(requestType);
        addTaint(request);
        addTaint(value);
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522815967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522815967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.337 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "1FAA1C2028FEE88F8CFE0F97B956E704")
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        int varEB00138F742D7AD94CD9E8052A3D926C_1792770588 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
        addTaint(endpoint.getTaint());
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705955870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705955870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.340 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "5A6E14325946D85F5C783F880D1955F6")
    public UsbRequest requestWait() {
        UsbRequest varB4EAC82CA7396A68D541C85D26508E83_832827619 = null; 
        UsbRequest request = native_request_wait();
        {
            request.dequeue();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_832827619 = request;
        varB4EAC82CA7396A68D541C85D26508E83_832827619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_832827619;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.344 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "59B55353FBA303D191CEE42EE80E95FD")
    public String getSerial() {
        String varB4EAC82CA7396A68D541C85D26508E83_420404998 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_420404998 = native_get_serial();
        varB4EAC82CA7396A68D541C85D26508E83_420404998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_420404998;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.345 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "2375F1F6976CB7021E9FFA1A979500D3")
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651611843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_651611843;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.345 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.346 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "B7DDBE81393343A4F2116894E704F6BC")
    private int native_get_fd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008924712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008924712;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.347 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "BAEB35B0FB12C153B83C339698A2B043")
    private byte[] native_get_desc() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1259264284 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1259264284;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.348 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "3E75F5C5D09900971478DEF8BD12B2CB")
    private boolean native_claim_interface(int interfaceID, boolean force) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652440848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652440848;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.350 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "7068D165BD82E402894AD00FA4E32922")
    private boolean native_release_interface(int interfaceID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40136050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40136050;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.352 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "1E92127F9A675787A3ACC21276CCA3C5")
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961875869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961875869;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.353 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "41D59253531284C6033EF59CD19FBA65")
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395408171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395408171;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "3CB7E68BF025980C89AAE00C7D02E8F5")
    private UsbRequest native_request_wait() {
    	return new UsbRequest();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "ABC78903D368E3A02775041EDC3A80F9")
    private String native_get_serial() {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.355 -0400", hash_original_field = "6CCCB99B62C738C90FA895B8D5FF6882", hash_generated_field = "4D3562CD13C810BE38422BD8716B9B6F")

    private static final String TAG = "UsbDeviceConnection";
}

