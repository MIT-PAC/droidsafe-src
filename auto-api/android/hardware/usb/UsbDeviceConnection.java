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
    private UsbDevice mDevice;
    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.111 -0400", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "4AD0BF71916400A1013A34D8221250F4")
    @DSModeled(DSC.SAFE)
    public UsbDeviceConnection(UsbDevice device) {
        dsTaint.addTaint(device.dsTaint);
        // ---------- Original Method ----------
        //mDevice = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.111 -0400", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "641833F0F33C7924755231CEAB0757B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean open(String name, ParcelFileDescriptor pfd) {
        dsTaint.addTaint(pfd.dsTaint);
        dsTaint.addTaint(name);
        boolean var285CA921394210A8A14FA5321382861D_275941250 = (native_open(name, pfd.getFileDescriptor()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_open(name, pfd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.111 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "02B7C7291AB385CA3FB44FB9C4735A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        native_close();
        // ---------- Original Method ----------
        //native_close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.111 -0400", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "CAF203F97568C62FE9071AE504CC183A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFileDescriptor() {
        int varDCF731014B54D36E839911CCA817AAEC_1058987809 = (native_get_fd());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_get_fd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.111 -0400", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "BED6A52ED16BD379A1889CB3888BB6DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getRawDescriptors() {
        byte[] var3ABF97E7775A43AB3F99332CAC204E50_228476936 = (native_get_desc());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return native_get_desc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.112 -0400", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "5D1C0B634FCA3DB3B4E3687A42DD090F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean claimInterface(UsbInterface intf, boolean force) {
        dsTaint.addTaint(force);
        dsTaint.addTaint(intf.dsTaint);
        boolean varF72D9A92CD09EC2DFD63F512D78E45AD_1371909703 = (native_claim_interface(intf.getId(), force));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_claim_interface(intf.getId(), force);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.112 -0400", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "29F4254A3A2F2A3A6F43715B9B0DF186")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean releaseInterface(UsbInterface intf) {
        dsTaint.addTaint(intf.dsTaint);
        boolean var4079C9E4E51FF59009DDBDBCBF503A61_349804025 = (native_release_interface(intf.getId()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_release_interface(intf.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.112 -0400", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "B96CC0E67AA9FE87B695DD83BF094EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(request);
        dsTaint.addTaint(length);
        dsTaint.addTaint(value);
        dsTaint.addTaint(requestType);
        dsTaint.addTaint(timeout);
        int var6B3ADFC6D6D7BAFC293350EE1F32F91F_1716451164 = (native_control_request(requestType, request, value, index, buffer, length, timeout));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.113 -0400", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "F080C9BC9EB4269B905C62DD8F73E121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(endpoint.dsTaint);
        int varEB00138F742D7AD94CD9E8052A3D926C_1662451976 = (native_bulk_request(endpoint.getAddress(), buffer, length, timeout));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.113 -0400", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "D1BEE9D62355DBDA78BC1FF8C98FC8C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UsbRequest requestWait() {
        UsbRequest request;
        request = native_request_wait();
        {
            request.dequeue();
        } //End block
        return (UsbRequest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UsbRequest request = native_request_wait();
        //if (request != null) {
            //request.dequeue();
        //}
        //return request;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.113 -0400", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "6FAB14A04125C71A082BF1D399CFFDAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSerial() {
        String var5FEDF03AF0FC08ABD1793663B9680F24_1954073938 = (native_get_serial());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return native_get_serial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.113 -0400", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "8152E98B514547EBBB3EAA6E9EAF03B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_open(String deviceName, FileDescriptor pfd) {
        dsTaint.addTaint(pfd.dsTaint);
        dsTaint.addTaint(deviceName);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.113 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "2E0BD664A18EDEE4C394D0A3A394EB28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_close() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.114 -0400", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "67481EDC383011930997628B4A2B5FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_get_fd() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.114 -0400", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "DAF848760309EB770E08E3362A732D12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] native_get_desc() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.114 -0400", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "86C7F9F1A24AD41205AF03CD2C503C1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_claim_interface(int interfaceID, boolean force) {
        dsTaint.addTaint(interfaceID);
        dsTaint.addTaint(force);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.114 -0400", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "380CB444F70302AAD11C661E48A29192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_release_interface(int interfaceID) {
        dsTaint.addTaint(interfaceID);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.114 -0400", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "937AF580CD10DB3E84E41C90FA42665E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_control_request(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(request);
        dsTaint.addTaint(length);
        dsTaint.addTaint(value);
        dsTaint.addTaint(requestType);
        dsTaint.addTaint(timeout);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.115 -0400", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "17A9894FE320C1DAA1D8D9141A55D63F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(endpoint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.115 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "CCDD95676094FB96B6E137CE1578F9EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private UsbRequest native_request_wait() {
        return (UsbRequest)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.115 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "7918AB501761C01EB4E6F66A13875D43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String native_get_serial() {
        return dsTaint.getTaintString();
    }

    
    private static final String TAG = "UsbDeviceConnection";
}

