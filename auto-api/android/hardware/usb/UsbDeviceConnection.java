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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.251 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private UsbDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.251 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.251 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "D29F217DDACE7CAD99DBB7C07BFE803F")
    public  UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        // ---------- Original Method ----------
        //mDevice = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.252 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "FCCB792F5D6ECD023A4C284A03709D5A")
     boolean open(String name, ParcelFileDescriptor pfd) {
        boolean var285CA921394210A8A14FA5321382861D_59955513 = (native_open(name, pfd.getFileDescriptor()));
        addTaint(name.getTaint());
        addTaint(pfd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628440030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628440030;
        // ---------- Original Method ----------
        //return native_open(name, pfd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.252 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    public void close() {
        native_close();
        // ---------- Original Method ----------
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.253 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "5180E7B4C030F17449B04EF8010BF12C")
    public int getFileDescriptor() {
        int varDCF731014B54D36E839911CCA817AAEC_1670343087 = (native_get_fd());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348896022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348896022;
        // ---------- Original Method ----------
        //return native_get_fd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.253 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "E1EB993B5E267C51BC74F92BA5CA2727")
    public byte[] getRawDescriptors() {
        byte[] var3ABF97E7775A43AB3F99332CAC204E50_1616452037 = (native_get_desc());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_77488715 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_77488715;
        // ---------- Original Method ----------
        //return native_get_desc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.254 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "1D56C458FA04B47C821CDC1E48BD0477")
    public boolean claimInterface(UsbInterface intf, boolean force) {
        boolean varF72D9A92CD09EC2DFD63F512D78E45AD_1055082511 = (native_claim_interface(intf.getId(), force));
        addTaint(intf.getTaint());
        addTaint(force);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754348329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754348329;
        // ---------- Original Method ----------
        //return native_claim_interface(intf.getId(), force);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.254 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "E08E50A0661E597196193F2EAD20729E")
    public boolean releaseInterface(UsbInterface intf) {
        boolean var4079C9E4E51FF59009DDBDBCBF503A61_570557928 = (native_release_interface(intf.getId()));
        addTaint(intf.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073096924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073096924;
        // ---------- Original Method ----------
        //return native_release_interface(intf.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.330 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "058E8ECE7D67B1ECC2088BC9ADB64320")
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int var6B3ADFC6D6D7BAFC293350EE1F32F91F_162860098 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
        addTaint(requestType);
        addTaint(request);
        addTaint(value);
        addTaint(index);
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155236635 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155236635;
        // ---------- Original Method ----------
        //return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.331 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "773E308E26A331CF41C9DB3E2E43E318")
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        int varEB00138F742D7AD94CD9E8052A3D926C_96504462 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
        addTaint(endpoint.getTaint());
        addTaint(buffer[0]);
        addTaint(length);
        addTaint(timeout);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964702277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964702277;
        // ---------- Original Method ----------
        //return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.332 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "FACBB577F86617DFFEF94528B5CE8FE0")
    public UsbRequest requestWait() {
        UsbRequest varB4EAC82CA7396A68D541C85D26508E83_236116296 = null; //Variable for return #1
        UsbRequest request;
        request = native_request_wait();
        {
            request.dequeue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_236116296 = request;
        varB4EAC82CA7396A68D541C85D26508E83_236116296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_236116296;
        // ---------- Original Method ----------
        //UsbRequest request = native_request_wait();
        //if (request != null) {
            //request.dequeue();
        //}
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.342 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "4070C4D8AFCABA82C1B57107772B4A4B")
    public String getSerial() {
        String varB4EAC82CA7396A68D541C85D26508E83_20676797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_20676797 = native_get_serial();
        varB4EAC82CA7396A68D541C85D26508E83_20676797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_20676797;
        // ---------- Original Method ----------
        //return native_get_serial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.343 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "DE733AD261A75CCCF8642D70A598812D")
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439569681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439569681;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.344 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.362 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "93C75828AAE43500EA1BCD0904C83B46")
    private int native_get_fd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396182196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396182196;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.362 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "653478400229B92FA5B74334DFF7698C")
    private byte[] native_get_desc() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2009714724 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2009714724;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.363 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "5ABEE48144DBF93E0595E89D215EA230")
    private boolean native_claim_interface(int interfaceID, boolean force) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253189933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253189933;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.364 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "7195274F34B99C009034FBA4439F0B73")
    private boolean native_release_interface(int interfaceID) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719958660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719958660;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.364 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "0A80B3639A466AE7B3CC2134F4882788")
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064111845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064111845;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.364 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "DF8ECEB36E2774104815034313FD2B28")
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915365564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915365564;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.368 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "3CB7E68BF025980C89AAE00C7D02E8F5")
    private UsbRequest native_request_wait() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "ABC78903D368E3A02775041EDC3A80F9")
    private String native_get_serial() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.369 -0400", hash_original_field = "6CCCB99B62C738C90FA895B8D5FF6882", hash_generated_field = "79456E6D8C614B46AFF316B57BA70A7B")

    private static String TAG = "UsbDeviceConnection";
}

