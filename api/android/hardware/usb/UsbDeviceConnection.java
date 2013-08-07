package android.hardware.usb;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;

import android.os.ParcelFileDescriptor;




import droidsafe.helpers.DSUtils;

public class UsbDeviceConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.933 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private UsbDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.934 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.934 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "D29F217DDACE7CAD99DBB7C07BFE803F")
    public  UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        // ---------- Original Method ----------
        //mDevice = device;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.935 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "05B68FBA6CB06C90BC5F0933054ACDD5")
     boolean open(String name, ParcelFileDescriptor pfd) {
        addTaint(pfd.getTaint());
        addTaint(name.getTaint());
        boolean varEA6F7C6AA25D64763666034AA8C1A110_540385424 = (native_open(name, pfd.getFileDescriptor()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411038704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411038704;
        // ---------- Original Method ----------
        //return native_open(name, pfd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.936 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    public void close() {
        native_close();
        // ---------- Original Method ----------
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.936 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "D0C1E55F2254AD3B56D0685F94FA43DC")
    public int getFileDescriptor() {
        int var146D2C80FFCD3E9CDD655A43248E972A_1730772704 = (native_get_fd());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342212641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342212641;
        // ---------- Original Method ----------
        //return native_get_fd();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.936 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "D24125442E8F952DDE721EBFA04FC96B")
    public byte[] getRawDescriptors() {
        byte[] varD09739513A6279AA0B9EB08AD5AEB185_314300017 = (native_get_desc());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_215350129 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_215350129;
        // ---------- Original Method ----------
        //return native_get_desc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.937 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "80B216C30A6BE32C22580190759D4B0F")
    public boolean claimInterface(UsbInterface intf, boolean force) {
        addTaint(force);
        addTaint(intf.getTaint());
        boolean var201587C0056AB9C10E81B98F9EDA0933_12015891 = (native_claim_interface(intf.getId(), force));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081085832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081085832;
        // ---------- Original Method ----------
        //return native_claim_interface(intf.getId(), force);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.938 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "7E499AA38DB3A5FB99750C9986BAE490")
    public boolean releaseInterface(UsbInterface intf) {
        addTaint(intf.getTaint());
        boolean varCDC0280562D323B2ABB08EBDC5FF73FB_432656141 = (native_release_interface(intf.getId()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894624060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894624060;
        // ---------- Original Method ----------
        //return native_release_interface(intf.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.939 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "DAE9A2F3E971C01C6FBCD20A50B77BE7")
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        addTaint(timeout);
        addTaint(length);
        addTaint(buffer[0]);
        addTaint(index);
        addTaint(value);
        addTaint(request);
        addTaint(requestType);
        int var31A50C600220D6BFC984CA860632D8CB_914078208 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502085964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502085964;
        // ---------- Original Method ----------
        //return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.940 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "512A5F7023E841912173487F7FA6ED0F")
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        addTaint(timeout);
        addTaint(length);
        addTaint(buffer[0]);
        addTaint(endpoint.getTaint());
        int varF6116850FFE379DB0FD51163181563EE_1352470988 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422624946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422624946;
        // ---------- Original Method ----------
        //return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.940 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "A1BA8A8715831C424E11AC3E7AE52B7B")
    public UsbRequest requestWait() {
        UsbRequest request = native_request_wait();
        if(request != null)        
        {
            request.dequeue();
        } //End block
UsbRequest varCA5195E6E15F740103A7066F05C33A8B_697725926 =         request;
        varCA5195E6E15F740103A7066F05C33A8B_697725926.addTaint(taint);
        return varCA5195E6E15F740103A7066F05C33A8B_697725926;
        // ---------- Original Method ----------
        //UsbRequest request = native_request_wait();
        //if (request != null) {
            //request.dequeue();
        //}
        //return request;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "36BD21046B5384A678B87FE288CB62C5")
    public String getSerial() {
String var270454DF88BA715612072DB600947C1B_1679448533 =         native_get_serial();
        var270454DF88BA715612072DB600947C1B_1679448533.addTaint(taint);
        return var270454DF88BA715612072DB600947C1B_1679448533;
        // ---------- Original Method ----------
        //return native_get_serial();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "F26B0E6DBCCE17028078CDAF8519B854")
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867855313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867855313;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "4D624980AAE5242F9DB49CE6920F9E85")
    private int native_get_fd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928834685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928834685;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "F0F87480A0649C01542A418C62739E81")
    private byte[] native_get_desc() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1128802255 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1128802255;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.961 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "F8D36DDF2AB0F4CF702247060BCF6927")
    private boolean native_claim_interface(int interfaceID, boolean force) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1783819979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1783819979;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.962 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "01ADF6D6594565F6ABCF8B017F89CDFB")
    private boolean native_release_interface(int interfaceID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700223433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700223433;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.962 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "8AADE8183F50538C2B31F5FAC608F8B8")
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492761879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492761879;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.962 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "31E47830DF17F79F059CDFE155AF87F5")
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630567492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630567492;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "3CB7E68BF025980C89AAE00C7D02E8F5")
    private UsbRequest native_request_wait() {
    	return new UsbRequest();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "ABC78903D368E3A02775041EDC3A80F9")
    private String native_get_serial() {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.962 -0400", hash_original_field = "6CCCB99B62C738C90FA895B8D5FF6882", hash_generated_field = "4D3562CD13C810BE38422BD8716B9B6F")

    private static final String TAG = "UsbDeviceConnection";
}

