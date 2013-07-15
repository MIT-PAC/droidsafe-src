package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;

public class UsbDeviceConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.876 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private UsbDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.876 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.877 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "D29F217DDACE7CAD99DBB7C07BFE803F")
    public  UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        // ---------- Original Method ----------
        //mDevice = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.878 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "4668D3F2EA5D3974ECF52CFE7E3882CC")
     boolean open(String name, ParcelFileDescriptor pfd) {
        addTaint(pfd.getTaint());
        addTaint(name.getTaint());
        boolean varEA6F7C6AA25D64763666034AA8C1A110_736455179 = (native_open(name, pfd.getFileDescriptor()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103874995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103874995;
        // ---------- Original Method ----------
        //return native_open(name, pfd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.878 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    public void close() {
        native_close();
        // ---------- Original Method ----------
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.879 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "2D7054AC526BEA95A2AE9F41E4D8C6D0")
    public int getFileDescriptor() {
        int var146D2C80FFCD3E9CDD655A43248E972A_44559960 = (native_get_fd());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713864684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713864684;
        // ---------- Original Method ----------
        //return native_get_fd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.879 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "22721BAE89633781D3CBAB44ADAADF5C")
    public byte[] getRawDescriptors() {
        byte[] varD09739513A6279AA0B9EB08AD5AEB185_988206589 = (native_get_desc());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1387448232 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1387448232;
        // ---------- Original Method ----------
        //return native_get_desc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.880 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "564EDE78195D5DB2AC7E33341CB06CA5")
    public boolean claimInterface(UsbInterface intf, boolean force) {
        addTaint(force);
        addTaint(intf.getTaint());
        boolean var201587C0056AB9C10E81B98F9EDA0933_2109645433 = (native_claim_interface(intf.getId(), force));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001320437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001320437;
        // ---------- Original Method ----------
        //return native_claim_interface(intf.getId(), force);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.880 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "AB74F978E53F4ED70253104E5DDAE837")
    public boolean releaseInterface(UsbInterface intf) {
        addTaint(intf.getTaint());
        boolean varCDC0280562D323B2ABB08EBDC5FF73FB_1725807064 = (native_release_interface(intf.getId()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673340634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673340634;
        // ---------- Original Method ----------
        //return native_release_interface(intf.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.881 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "886BF0DC6E809D585795268EE09A0485")
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        addTaint(timeout);
        addTaint(length);
        addTaint(buffer[0]);
        addTaint(index);
        addTaint(value);
        addTaint(request);
        addTaint(requestType);
        int var31A50C600220D6BFC984CA860632D8CB_136712427 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930431496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930431496;
        // ---------- Original Method ----------
        //return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.882 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "636741C0D1F83A45303239E3B5136F3A")
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        addTaint(timeout);
        addTaint(length);
        addTaint(buffer[0]);
        addTaint(endpoint.getTaint());
        int varF6116850FFE379DB0FD51163181563EE_1137531435 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773510776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773510776;
        // ---------- Original Method ----------
        //return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.882 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "928271C4442DD2CE163A510C4A87A87D")
    public UsbRequest requestWait() {
        UsbRequest request = native_request_wait();
    if(request != null)        
        {
            request.dequeue();
        } //End block
UsbRequest varCA5195E6E15F740103A7066F05C33A8B_1794990895 =         request;
        varCA5195E6E15F740103A7066F05C33A8B_1794990895.addTaint(taint);
        return varCA5195E6E15F740103A7066F05C33A8B_1794990895;
        // ---------- Original Method ----------
        //UsbRequest request = native_request_wait();
        //if (request != null) {
            //request.dequeue();
        //}
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.882 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "66CED1D60647308B4333B8292BC85297")
    public String getSerial() {
String var270454DF88BA715612072DB600947C1B_366208449 =         native_get_serial();
        var270454DF88BA715612072DB600947C1B_366208449.addTaint(taint);
        return var270454DF88BA715612072DB600947C1B_366208449;
        // ---------- Original Method ----------
        //return native_get_serial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.883 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "F25C7FBF73687F22D3B62400BA6FCAA6")
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744334464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744334464;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.883 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.883 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "8106B7C97B2B6EF56D6535503EBA8406")
    private int native_get_fd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904822628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904822628;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.884 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "66BF7F48493BA215A0C61CE99101B4D9")
    private byte[] native_get_desc() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_316093389 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_316093389;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.884 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "C548CBDB0273776B28AC1FDC5356F1AE")
    private boolean native_claim_interface(int interfaceID, boolean force) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513444057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513444057;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.884 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "ADBAEE3E3B37969E399D9325BDCEA2AD")
    private boolean native_release_interface(int interfaceID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924936843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924936843;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.885 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "F97803B3733F587F00CA056B694200B8")
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489907019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489907019;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.886 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "8D743285A1F0306A7EC376367096BA14")
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889414584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889414584;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.887 -0400", hash_original_field = "6CCCB99B62C738C90FA895B8D5FF6882", hash_generated_field = "4D3562CD13C810BE38422BD8716B9B6F")

    private static final String TAG = "UsbDeviceConnection";
}

