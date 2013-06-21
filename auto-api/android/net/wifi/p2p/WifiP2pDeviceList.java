package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.wifi.p2p.WifiP2pDevice;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WifiP2pDeviceList implements Parcelable {
    private Collection<WifiP2pDevice> mDevices;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.711 -0400", hash_original_method = "711A9A33382FDEBAFBD29DC2083BF3E5", hash_generated_method = "AF6F1060F4608D0AAC43BEC895BFBC7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pDeviceList() {
        mDevices = new ArrayList<WifiP2pDevice>();
        // ---------- Original Method ----------
        //mDevices = new ArrayList<WifiP2pDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.711 -0400", hash_original_method = "41227E772CD15F31E5452F0B2CEC5C6F", hash_generated_method = "D16C5228FCC21BB576E408543EDBAD8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pDeviceList(WifiP2pDeviceList source) {
        dsTaint.addTaint(source.dsTaint);
        {
            mDevices = source.getDeviceList();
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mDevices = source.getDeviceList();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.712 -0400", hash_original_method = "A6AECDF562D4D05BB14FD089AEB17F29", hash_generated_method = "D703A5B71BE22B794D249E415AD511D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pDeviceList(ArrayList<WifiP2pDevice> devices) {
        dsTaint.addTaint(devices.dsTaint);
        mDevices = new ArrayList<WifiP2pDevice>();
        {
            Iterator<WifiP2pDevice> var71A11393AB5AEBB385983FA17616D9BC_1895873278 = (devices).iterator();
            var71A11393AB5AEBB385983FA17616D9BC_1895873278.hasNext();
            WifiP2pDevice device = var71A11393AB5AEBB385983FA17616D9BC_1895873278.next();
            {
                mDevices.add(device);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mDevices = new ArrayList<WifiP2pDevice>();
        //for (WifiP2pDevice device : devices) {
            //mDevices.add(device);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.712 -0400", hash_original_method = "70CE399D4AEC1ED49C7E7903137A1A02", hash_generated_method = "E0BB232F9C0E2D8FB7070D42C2876073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clear() {
        {
            boolean varAA2278BE0A4E7DF2EDAB65F1A740F279_959645105 = (mDevices.isEmpty());
        } //End collapsed parenthetic
        mDevices.clear();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mDevices.isEmpty()) return false;
        //mDevices.clear();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.718 -0400", hash_original_method = "FB31C2BA18EF767553E65099D683D802", hash_generated_method = "5BB2716455A1FD8281DDF1EB63F96DDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(WifiP2pDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            Iterator<WifiP2pDevice> var9012B7A3EB9B74EA2FF8C69458CC7781_812543065 = (mDevices).iterator();
            var9012B7A3EB9B74EA2FF8C69458CC7781_812543065.hasNext();
            WifiP2pDevice d = var9012B7A3EB9B74EA2FF8C69458CC7781_812543065.next();
            {
                {
                    boolean varFAF6937B8D18A1134023B51A3F4F0520_501240556 = (d.equals(device));
                    {
                        d.deviceName = device.deviceName;
                        d.primaryDeviceType = device.primaryDeviceType;
                        d.secondaryDeviceType = device.secondaryDeviceType;
                        d.wpsConfigMethodsSupported = device.wpsConfigMethodsSupported;
                        d.deviceCapability = device.deviceCapability;
                        d.groupCapability = device.groupCapability;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mDevices.add(device);
        // ---------- Original Method ----------
        //if (device == null) return;
        //for (WifiP2pDevice d : mDevices) {
            //if (d.equals(device)) {
                //d.deviceName = device.deviceName;
                //d.primaryDeviceType = device.primaryDeviceType;
                //d.secondaryDeviceType = device.secondaryDeviceType;
                //d.wpsConfigMethodsSupported = device.wpsConfigMethodsSupported;
                //d.deviceCapability = device.deviceCapability;
                //d.groupCapability = device.groupCapability;
                //return;
            //}
        //}
        //mDevices.add(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.719 -0400", hash_original_method = "020B85F823F552419F9C1AF8A2509846", hash_generated_method = "F38B8FDF2821C4C816B2EFA94E87AB7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(WifiP2pDevice device) {
        dsTaint.addTaint(device.dsTaint);
        boolean var8B29D053D2683E89B3275232DD0D4693_827077332 = (mDevices.remove(device));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (device == null) return false;
        //return mDevices.remove(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.719 -0400", hash_original_method = "AF7D82D1BB8BCC5F50496B9C85783B3A", hash_generated_method = "4743FB93584F0273E48E97BB5757FFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<WifiP2pDevice> getDeviceList() {
        Collection<WifiP2pDevice> var6CDFE18424FD8E9D91876ADF6ACDC3E0_481059164 = (Collections.unmodifiableCollection(mDevices));
        return (Collection<WifiP2pDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDevices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.722 -0400", hash_original_method = "5A8D6CF28770F332159DA6A027ABEE59", hash_generated_method = "49BF719A1A9FC5275DED4CD2105C92FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuffer sbuf;
        sbuf = new StringBuffer();
        {
            Iterator<WifiP2pDevice> var4354658A1BB6AAA014FD651E49BED88E_771013368 = (mDevices).iterator();
            var4354658A1BB6AAA014FD651E49BED88E_771013368.hasNext();
            WifiP2pDevice device = var4354658A1BB6AAA014FD651E49BED88E_771013368.next();
            {
                sbuf.append("\n").append(device);
            } //End block
        } //End collapsed parenthetic
        String var0826C75FB1499484A6621049C9E9DB4E_1926854475 = (sbuf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //for (WifiP2pDevice device : mDevices) {
            //sbuf.append("\n").append(device);
        //}
        //return sbuf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.723 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.726 -0400", hash_original_method = "55D2541614C0B12A14CA5FB457FCECCC", hash_generated_method = "475B3866051E96CDE43F1332CCE2C45C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mDevices.size());
        {
            Iterator<WifiP2pDevice> var4354658A1BB6AAA014FD651E49BED88E_325379585 = (mDevices).iterator();
            var4354658A1BB6AAA014FD651E49BED88E_325379585.hasNext();
            WifiP2pDevice device = var4354658A1BB6AAA014FD651E49BED88E_325379585.next();
            {
                dest.writeParcelable(device, flags);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //dest.writeInt(mDevices.size());
        //for(WifiP2pDevice device : mDevices) {
            //dest.writeParcelable(device, flags);
        //}
    }

    
    public static final Creator<WifiP2pDeviceList> CREATOR = new Creator<WifiP2pDeviceList>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.726 -0400", hash_original_method = "899194FDFB13E2439E0712865745CEA1", hash_generated_method = "10072633E94017E3C68A6AB659397B7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pDeviceList createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiP2pDeviceList deviceList;
            deviceList = new WifiP2pDeviceList();
            int deviceCount;
            deviceCount = in.readInt();
            {
                int i;
                i = 0;
                {
                    deviceList.update((WifiP2pDevice)in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            return (WifiP2pDeviceList)dsTaint.getTaint();
            // ---------- Original Method ----------
            //WifiP2pDeviceList deviceList = new WifiP2pDeviceList();
            //int deviceCount = in.readInt();
            //for (int i = 0; i < deviceCount; i++) {
                    //deviceList.update((WifiP2pDevice)in.readParcelable(null));
                //}
            //return deviceList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.727 -0400", hash_original_method = "F919F24B2CB73D8D3F9E4AF1E7014246", hash_generated_method = "B640B22826AA026069A1BF261D526852")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pDeviceList[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiP2pDeviceList[] var7EFD39A878516B6D7EEA751B68CED60A_957028283 = (new WifiP2pDeviceList[size]);
            return (WifiP2pDeviceList[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiP2pDeviceList[size];
        }

        
}; //Transformed anonymous class
}

