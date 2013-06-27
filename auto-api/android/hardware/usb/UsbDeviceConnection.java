package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;

public class UsbDeviceConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.876 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private UsbDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.876 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.876 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "D29F217DDACE7CAD99DBB7C07BFE803F")
    public  UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        // ---------- Original Method ----------
        //mDevice = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.877 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "CEF4B9857A9DB93ECFB66025418B2F5D")
     boolean open(String name, ParcelFileDescriptor pfd) {
        boolean var285CA921394210A8A14FA5321382861D_1678385347 = (native_open(name, pfd.getFileDescriptor()));
        addTaint(name.getTaint());
        addTaint(pfd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50920298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50920298;
        // ---------- Original Method ----------
        //return native_open(name, pfd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.879 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    public void close() {
        native_close();
        // ---------- Original Method ----------
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.879 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "34B415FCA791F405B3152E8A87475F73")
    public int getFileDescriptor() {
        int varDCF731014B54D36E839911CCA817AAEC_1171528784 = (native_get_fd());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472289697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472289697;
        // ---------- Original Method ----------
        //return native_get_fd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.895 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "EB5BD45BBCCE426FF7123C02D241416C")
    public byte[] getRawDescriptors() {
        byte[] var3ABF97E7775A43AB3F99332CAC204E50_736871230 = (native_get_desc());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_512255072 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_512255072;
        // ---------- Original Method ----------
        //return native_get_desc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.913 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "9B6DF9CD554C2777058D6A0E58689B03")
    public boolean claimInterface(UsbInterface intf, boolean force) {
        boolean varF72D9A92CD09EC2DFD63F512D78E45AD_377156721 = (native_claim_interface(intf.getId(), force));
        addTaint(intf.getTaint());
        addTaint(force);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663286758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663286758;
        // ---------- Original Method ----------
        //return native_claim_interface(intf.getId(), force);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.914 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "B05EFD58F04E865461FF6659A5EB9763")
    public boolean releaseInterface(UsbInterface intf) {
        boolean var4079C9E4E51FF59009DDBDBCBF503A61_314371395 = (native_release_interface(intf.getId()));
        addTaint(intf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463646964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463646964;
        // ---------- Original Method ----------
        //return native_release_interface(intf.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.918 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "BDFD19BF905C01A28452E68DC4A5F329")
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int var6B3ADFC6D6D7BAFC293350EE1F32F91F_1800997200 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
        addTaint(requestType);
        addTaint(request);
        addTaint(value);
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287552877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287552877;
        // ---------- Original Method ----------
        //return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.919 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "76168BB4415704A0BF5426EC08BC2625")
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        int varEB00138F742D7AD94CD9E8052A3D926C_1591175104 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
        addTaint(endpoint.getTaint());
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675081513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675081513;
        // ---------- Original Method ----------
        //return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.934 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "CA320FBE35F605247E2BCD85853912EE")
    public UsbRequest requestWait() {
        UsbRequest varB4EAC82CA7396A68D541C85D26508E83_753431416 = null; //Variable for return #1
        UsbRequest request;
        request = native_request_wait();
        {
            request.dequeue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_753431416 = request;
        varB4EAC82CA7396A68D541C85D26508E83_753431416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_753431416;
        // ---------- Original Method ----------
        //UsbRequest request = native_request_wait();
        //if (request != null) {
            //request.dequeue();
        //}
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.935 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "C3D0FB54DF19E1D5CF9CE5089BD9076B")
    public String getSerial() {
        String varB4EAC82CA7396A68D541C85D26508E83_243891007 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_243891007 = native_get_serial();
        varB4EAC82CA7396A68D541C85D26508E83_243891007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243891007;
        // ---------- Original Method ----------
        //return native_get_serial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.935 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "5E32C82CE61DFDF21BAF4612AED8B9A3")
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111677638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_111677638;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.936 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.936 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "CEAD51D9B98E557D97C00455DBAFFA94")
    private int native_get_fd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354448399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354448399;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.954 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "A6BF7D7553F3065BB29771991E22B853")
    private byte[] native_get_desc() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1499806790 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1499806790;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.954 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "CD6F0ABA18529722A98E73F5818C890A")
    private boolean native_claim_interface(int interfaceID, boolean force) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209261164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_209261164;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.955 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "07AD521334A3B6796C07B7E03DB65AD1")
    private boolean native_release_interface(int interfaceID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515565778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515565778;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.959 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "35D32EA535C99497531702CCAEFA22B7")
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892049459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892049459;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "56A7A03CD4D35CD51E6091B51EF3B1CD")
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863524447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863524447;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "3CB7E68BF025980C89AAE00C7D02E8F5")
    private UsbRequest native_request_wait() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "ABC78903D368E3A02775041EDC3A80F9")
    private String native_get_serial() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_field = "6CCCB99B62C738C90FA895B8D5FF6882", hash_generated_field = "79456E6D8C614B46AFF316B57BA70A7B")

    private static String TAG = "UsbDeviceConnection";
}

