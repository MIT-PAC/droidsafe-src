package android.net.wifi.p2p;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.wifi.p2p.WifiP2pDevice;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WifiP2pDeviceList implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.169 -0400", hash_original_field = "3179B13FAAD5C0029CA9A9DDFE363FE9", hash_generated_field = "DD90A9525404352AE853B3D0A4AC59A5")

    private Collection<WifiP2pDevice> mDevices;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.169 -0400", hash_original_method = "711A9A33382FDEBAFBD29DC2083BF3E5", hash_generated_method = "AF6F1060F4608D0AAC43BEC895BFBC7B")
    public  WifiP2pDeviceList() {
        mDevices = new ArrayList<WifiP2pDevice>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.169 -0400", hash_original_method = "41227E772CD15F31E5452F0B2CEC5C6F", hash_generated_method = "F8D304725A4E70D2122CA2605B2E531F")
    public  WifiP2pDeviceList(WifiP2pDeviceList source) {
    if(source != null)        
        {
            mDevices = source.getDeviceList();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.170 -0400", hash_original_method = "A6AECDF562D4D05BB14FD089AEB17F29", hash_generated_method = "ACFD9ABDDD28805B0DD4E8C386740AC9")
    public  WifiP2pDeviceList(ArrayList<WifiP2pDevice> devices) {
        addTaint(devices.getTaint());
        mDevices = new ArrayList<WifiP2pDevice>();
for(WifiP2pDevice device : devices)
        {
            mDevices.add(device);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.170 -0400", hash_original_method = "70CE399D4AEC1ED49C7E7903137A1A02", hash_generated_method = "8C9D98D9CCA0C9F4462EAEB7CBBE9F82")
    public boolean clear() {
    if(mDevices.isEmpty())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1001917177 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757767728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757767728;
        }
        mDevices.clear();
        boolean varB326B5062B2F0E69046810717534CB09_262734597 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682739893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682739893;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.172 -0400", hash_original_method = "FB31C2BA18EF767553E65099D683D802", hash_generated_method = "1AED31CC1566F70613E5F3DC95D56E51")
    public void update(WifiP2pDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        return;
for(WifiP2pDevice d : mDevices)
        {
    if(d.equals(device))            
            {
                d.deviceName = device.deviceName;
                d.primaryDeviceType = device.primaryDeviceType;
                d.secondaryDeviceType = device.secondaryDeviceType;
                d.wpsConfigMethodsSupported = device.wpsConfigMethodsSupported;
                d.deviceCapability = device.deviceCapability;
                d.groupCapability = device.groupCapability;
                return;
            } 
        } 
        mDevices.add(device);
        
        
        
            
                
                
                
                
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.172 -0400", hash_original_method = "020B85F823F552419F9C1AF8A2509846", hash_generated_method = "6DFD27631035B871FE7A1CBF55DF8958")
    public boolean remove(WifiP2pDevice device) {
        addTaint(device.getTaint());
    if(device == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_347610568 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704472373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704472373;
        }
        boolean var99F301CA5E32C87FD42E6FB2D7903621_733648488 = (mDevices.remove(device));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281849103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281849103;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.173 -0400", hash_original_method = "AF7D82D1BB8BCC5F50496B9C85783B3A", hash_generated_method = "79ED04FEBC30A30247CC0E2CBD95E2AC")
    public Collection<WifiP2pDevice> getDeviceList() {
Collection<WifiP2pDevice> var24D252EDC5D3BF4B65D91841154ED408_585846280 =         Collections.unmodifiableCollection(mDevices);
        var24D252EDC5D3BF4B65D91841154ED408_585846280.addTaint(taint);
        return var24D252EDC5D3BF4B65D91841154ED408_585846280;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.173 -0400", hash_original_method = "5A8D6CF28770F332159DA6A027ABEE59", hash_generated_method = "D9BBF8A956B8F62E0F2E3C041669B20E")
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
for(WifiP2pDevice device : mDevices)
        {
            sbuf.append("\n").append(device);
        } 
String var69222FFA45D1268AEE1923C5558B0BD5_1064448395 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_1064448395.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_1064448395;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.174 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FE52C75D140E40F238491F9E60C0B684")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_40360739 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169335102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169335102;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.174 -0400", hash_original_method = "55D2541614C0B12A14CA5FB457FCECCC", hash_generated_method = "6C3ED0490005A9549B0D6D84E7FACC22")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mDevices.size());
for(WifiP2pDevice device : mDevices)
        {
            dest.writeParcelable(device, flags);
        } 
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.174 -0400", hash_original_field = "4A218AAA8D9C30DA3D56C41E5779AA21", hash_generated_field = "028C774B60D3FC71D12C3B348A35124D")

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
    
}

