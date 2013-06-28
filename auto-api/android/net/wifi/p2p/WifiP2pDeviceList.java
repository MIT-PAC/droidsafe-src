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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.737 -0400", hash_original_field = "3179B13FAAD5C0029CA9A9DDFE363FE9", hash_generated_field = "DD90A9525404352AE853B3D0A4AC59A5")

    private Collection<WifiP2pDevice> mDevices;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.738 -0400", hash_original_method = "711A9A33382FDEBAFBD29DC2083BF3E5", hash_generated_method = "AF6F1060F4608D0AAC43BEC895BFBC7B")
    public  WifiP2pDeviceList() {
        mDevices = new ArrayList<WifiP2pDevice>();
        // ---------- Original Method ----------
        //mDevices = new ArrayList<WifiP2pDevice>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.738 -0400", hash_original_method = "41227E772CD15F31E5452F0B2CEC5C6F", hash_generated_method = "5FDC69EC9A76EDC62CDEE7E78EAC99BE")
    public  WifiP2pDeviceList(WifiP2pDeviceList source) {
        {
            mDevices = source.getDeviceList();
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mDevices = source.getDeviceList();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.740 -0400", hash_original_method = "A6AECDF562D4D05BB14FD089AEB17F29", hash_generated_method = "1D44B49AFD77C21DCC17384B240D61C7")
    public  WifiP2pDeviceList(ArrayList<WifiP2pDevice> devices) {
        mDevices = new ArrayList<WifiP2pDevice>();
        {
            Iterator<WifiP2pDevice> var71A11393AB5AEBB385983FA17616D9BC_207187334 = (devices).iterator();
            var71A11393AB5AEBB385983FA17616D9BC_207187334.hasNext();
            WifiP2pDevice device = var71A11393AB5AEBB385983FA17616D9BC_207187334.next();
            {
                mDevices.add(device);
            } //End block
        } //End collapsed parenthetic
        addTaint(devices.getTaint());
        // ---------- Original Method ----------
        //mDevices = new ArrayList<WifiP2pDevice>();
        //for (WifiP2pDevice device : devices) {
            //mDevices.add(device);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.741 -0400", hash_original_method = "70CE399D4AEC1ED49C7E7903137A1A02", hash_generated_method = "B0C6DED21CE56441EFC7103AA3640A4B")
    public boolean clear() {
        {
            boolean varAA2278BE0A4E7DF2EDAB65F1A740F279_33987939 = (mDevices.isEmpty());
        } //End collapsed parenthetic
        mDevices.clear();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761375713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761375713;
        // ---------- Original Method ----------
        //if (mDevices.isEmpty()) return false;
        //mDevices.clear();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.745 -0400", hash_original_method = "FB31C2BA18EF767553E65099D683D802", hash_generated_method = "23A38E9E187801670D367100D5FC9B29")
    public void update(WifiP2pDevice device) {
        {
            Iterator<WifiP2pDevice> var9012B7A3EB9B74EA2FF8C69458CC7781_1973720873 = (mDevices).iterator();
            var9012B7A3EB9B74EA2FF8C69458CC7781_1973720873.hasNext();
            WifiP2pDevice d = var9012B7A3EB9B74EA2FF8C69458CC7781_1973720873.next();
            {
                {
                    boolean varFAF6937B8D18A1134023B51A3F4F0520_1438186809 = (d.equals(device));
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
        addTaint(device.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.745 -0400", hash_original_method = "020B85F823F552419F9C1AF8A2509846", hash_generated_method = "BECB323BCA5FE864DF5BB57CA3784893")
    public boolean remove(WifiP2pDevice device) {
        boolean var8B29D053D2683E89B3275232DD0D4693_1313325019 = (mDevices.remove(device));
        addTaint(device.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309385866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_309385866;
        // ---------- Original Method ----------
        //if (device == null) return false;
        //return mDevices.remove(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.746 -0400", hash_original_method = "AF7D82D1BB8BCC5F50496B9C85783B3A", hash_generated_method = "A378A4ED3F7CAE93D5E1E64AC4F1B555")
    public Collection<WifiP2pDevice> getDeviceList() {
        Collection<WifiP2pDevice> varB4EAC82CA7396A68D541C85D26508E83_451566479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_451566479 = Collections.unmodifiableCollection(mDevices);
        varB4EAC82CA7396A68D541C85D26508E83_451566479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451566479;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mDevices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.749 -0400", hash_original_method = "5A8D6CF28770F332159DA6A027ABEE59", hash_generated_method = "8EC4053BF2AFA0EE0DD268F208914939")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_108589758 = null; //Variable for return #1
        StringBuffer sbuf = new StringBuffer();
        {
            Iterator<WifiP2pDevice> var4354658A1BB6AAA014FD651E49BED88E_140234678 = (mDevices).iterator();
            var4354658A1BB6AAA014FD651E49BED88E_140234678.hasNext();
            WifiP2pDevice device = var4354658A1BB6AAA014FD651E49BED88E_140234678.next();
            {
                sbuf.append("\n").append(device);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_108589758 = sbuf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_108589758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108589758;
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //for (WifiP2pDevice device : mDevices) {
            //sbuf.append("\n").append(device);
        //}
        //return sbuf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.749 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FACF29648CBB9BAE15BCD96B59128D1A")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970066716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970066716;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.754 -0400", hash_original_method = "55D2541614C0B12A14CA5FB457FCECCC", hash_generated_method = "786154C5DF01617703DFDC9CB343E818")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mDevices.size());
        {
            Iterator<WifiP2pDevice> var4354658A1BB6AAA014FD651E49BED88E_1715288543 = (mDevices).iterator();
            var4354658A1BB6AAA014FD651E49BED88E_1715288543.hasNext();
            WifiP2pDevice device = var4354658A1BB6AAA014FD651E49BED88E_1715288543.next();
            {
                dest.writeParcelable(device, flags);
            } //End block
        } //End collapsed parenthetic
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mDevices.size());
        //for(WifiP2pDevice device : mDevices) {
            //dest.writeParcelable(device, flags);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.754 -0400", hash_original_field = "4A218AAA8D9C30DA3D56C41E5779AA21", hash_generated_field = "028C774B60D3FC71D12C3B348A35124D")

    public static final Creator<WifiP2pDeviceList> CREATOR =
        new Creator<WifiP2pDeviceList>() {
            public WifiP2pDeviceList createFromParcel(Parcel in) {
                WifiP2pDeviceList deviceList = new WifiP2pDeviceList();

                int deviceCount = in.readInt();
                for (int i = 0; i < deviceCount; i++) {
                    deviceList.update((WifiP2pDevice)in.readParcelable(null));
                }
                return deviceList;
            }

            public WifiP2pDeviceList[] newArray(int size) {
                return new WifiP2pDeviceList[size];
            }
        };
    // orphaned legacy method
    public WifiP2pDeviceList createFromParcel(Parcel in) {
                WifiP2pDeviceList deviceList = new WifiP2pDeviceList();

                int deviceCount = in.readInt();
                for (int i = 0; i < deviceCount; i++) {
                    deviceList.update((WifiP2pDevice)in.readParcelable(null));
                }
                return deviceList;
            }
    
    // orphaned legacy method
    public WifiP2pDeviceList[] newArray(int size) {
                return new WifiP2pDeviceList[size];
            }
    
}

