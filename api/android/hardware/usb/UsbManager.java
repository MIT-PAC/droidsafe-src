package android.hardware.usb;

// Droidsafe Imports
import java.util.HashMap;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class UsbManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.022 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.023 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "9FD6577446058467C3BAA1A318AD88B5")

    private IUsbManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.023 -0400", hash_original_method = "68E88C1381A537FEBD5C1D01CC81CFD6", hash_generated_method = "0147BA6BA88EBD3825613E13FAA8DB75")
    public  UsbManager(Context context, IUsbManager service) {
        mContext = context;
        mService = service;
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.024 -0400", hash_original_method = "0C4F9A912AC5BE14CB67FA981035B977", hash_generated_method = "81D3B487B5641EE88D23592D602279A7")
    public HashMap<String,UsbDevice> getDeviceList() {
        Bundle bundle = new Bundle();
        try 
        {
            mService.getDeviceList(bundle);
            HashMap<String,UsbDevice> result = new HashMap<String,UsbDevice>();
for(String name : bundle.keySet())
            {
                result.put(name, (UsbDevice)bundle.get(name));
            } //End block
HashMap<String,UsbDevice> varDC838461EE2FA0CA4C9BBB70A15456B0_304295587 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_304295587.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_304295587;
        } //End block
        catch (RemoteException e)
        {
HashMap<String,UsbDevice> var540C13E9E156B687226421B24F2DF178_1735214693 =             null;
            var540C13E9E156B687226421B24F2DF178_1735214693.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1735214693;
        } //End block
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //try {
            //mService.getDeviceList(bundle);
            //HashMap<String,UsbDevice> result = new HashMap<String,UsbDevice>();
            //for (String name : bundle.keySet()) {
                //result.put(name, (UsbDevice)bundle.get(name));
            //}
            //return result;
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in getDeviceList", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.024 -0400", hash_original_method = "8D8483424EA0CFD952FF0A230CCAC549", hash_generated_method = "069612DDDE6E87E4F46448B53294F65B")
    public UsbDeviceConnection openDevice(UsbDevice device) {
        addTaint(device.getTaint());
        try 
        {
            String deviceName = device.getDeviceName();
            ParcelFileDescriptor pfd = mService.openDevice(deviceName);
            if(pfd != null)            
            {
                UsbDeviceConnection connection = new UsbDeviceConnection(device);
                boolean result = connection.open(deviceName, pfd);
                pfd.close();
                if(result)                
                {
UsbDeviceConnection var9911BB1C5F1522C1630847C40E8BC67E_767836592 =                     connection;
                    var9911BB1C5F1522C1630847C40E8BC67E_767836592.addTaint(taint);
                    return var9911BB1C5F1522C1630847C40E8BC67E_767836592;
                } //End block
            } //End block
        } //End block
        catch (Exception e)
        {
        } //End block
UsbDeviceConnection var540C13E9E156B687226421B24F2DF178_874299407 =         null;
        var540C13E9E156B687226421B24F2DF178_874299407.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_874299407;
        // ---------- Original Method ----------
        //try {
            //String deviceName = device.getDeviceName();
            //ParcelFileDescriptor pfd = mService.openDevice(deviceName);
            //if (pfd != null) {
                //UsbDeviceConnection connection = new UsbDeviceConnection(device);
                //boolean result = connection.open(deviceName, pfd);
                //pfd.close();
                //if (result) {
                    //return connection;
                //}
            //}
        //} catch (Exception e) {
            //Log.e(TAG, "exception in UsbManager.openDevice", e);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.025 -0400", hash_original_method = "1BBBF6CC2C81B72139C0D4C7AF3A1618", hash_generated_method = "6E850889236241B241D4CC268A6064E4")
    public UsbAccessory[] getAccessoryList() {
        try 
        {
            UsbAccessory accessory = mService.getCurrentAccessory();
            if(accessory == null)            
            {
UsbAccessory[] var540C13E9E156B687226421B24F2DF178_1862291767 =                 null;
                var540C13E9E156B687226421B24F2DF178_1862291767.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1862291767;
            } //End block
            else
            {
UsbAccessory[] varB854EE60877EC2A752DA2366949EA45C_67779220 =                 new UsbAccessory[] { accessory };
                varB854EE60877EC2A752DA2366949EA45C_67779220.addTaint(taint);
                return varB854EE60877EC2A752DA2366949EA45C_67779220;
            } //End block
        } //End block
        catch (RemoteException e)
        {
UsbAccessory[] var540C13E9E156B687226421B24F2DF178_681057148 =             null;
            var540C13E9E156B687226421B24F2DF178_681057148.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_681057148;
        } //End block
        // ---------- Original Method ----------
        //try {
            //UsbAccessory accessory = mService.getCurrentAccessory();
            //if (accessory == null) {
                //return null;
            //} else {
                //return new UsbAccessory[] { accessory };
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in getAccessoryList", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.026 -0400", hash_original_method = "E613A4CA88B6248C79E5606341D1D797", hash_generated_method = "D69F7ECF40F71D88BFD80FBDCBEEC47C")
    public ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        addTaint(accessory.getTaint());
        try 
        {
ParcelFileDescriptor varA3585D0D8E2D95CF3108941122D41146_1893064825 =             mService.openAccessory(accessory);
            varA3585D0D8E2D95CF3108941122D41146_1893064825.addTaint(taint);
            return varA3585D0D8E2D95CF3108941122D41146_1893064825;
        } //End block
        catch (RemoteException e)
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_532364495 =             null;
            var540C13E9E156B687226421B24F2DF178_532364495.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_532364495;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.openAccessory(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in openAccessory", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.027 -0400", hash_original_method = "BC4EEEB293CF372F4C660B9CBB978F7E", hash_generated_method = "ED083E3D9FE70F7FCD7468197A0A9DBF")
    public boolean hasPermission(UsbDevice device) {
        addTaint(device.getTaint());
        try 
        {
            boolean var65641DBFE364B36131CB0DCEEB840655_297037383 = (mService.hasDevicePermission(device));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467576044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_467576044;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2058690301 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134502720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134502720;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.hasDevicePermission(device);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.027 -0400", hash_original_method = "8C883717D72FFED5467C2C0C4FA603AB", hash_generated_method = "38B876A7A17E540F21FFA0471361120B")
    public boolean hasPermission(UsbAccessory accessory) {
        addTaint(accessory.getTaint());
        try 
        {
            boolean var01AA2DCF11FEEC0BD574C96F0D87B780_718287759 = (mService.hasAccessoryPermission(accessory));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1896041634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1896041634;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1324045883 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807453148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807453148;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.hasAccessoryPermission(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.028 -0400", hash_original_method = "0BC6C49F477F609E4761FAD93127C8B1", hash_generated_method = "D58733C2E539152C3DCE3AB311B25582")
    public void requestPermission(UsbDevice device, PendingIntent pi) {
        addTaint(pi.getTaint());
        addTaint(device.getTaint());
        try 
        {
            mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in requestPermission", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.029 -0400", hash_original_method = "FC51D136A8BB60237D8B3FCD832EDCEE", hash_generated_method = "2E24BD48E311EBE57BB2D8BC9B7EF9B1")
    public void requestPermission(UsbAccessory accessory, PendingIntent pi) {
        addTaint(pi.getTaint());
        addTaint(accessory.getTaint());
        try 
        {
            mService.requestAccessoryPermission(accessory, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.requestAccessoryPermission(accessory, mContext.getPackageName(), pi);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in requestPermission", e);
        //}
    }

    
    private static boolean propertyContainsFunction(String property, String function) {
        String functions = SystemProperties.get(property, "");
        int index = functions.indexOf(function);
        if (index < 0) return false;
        if (index > 0 && functions.charAt(index - 1) != ',') return false;
        int charAfter = index + function.length();
        if (charAfter < functions.length() && functions.charAt(charAfter) != ',') return false;
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.030 -0400", hash_original_method = "B2F7E99E5659CE0D7ECF8F6FFE68B901", hash_generated_method = "CFC6BD8D8E722BA78BEC9B71820A30AF")
    public boolean isFunctionEnabled(String function) {
        addTaint(function.getTaint());
        boolean var074588086C206A519C1C0B5BF7B12F70_1209277857 = (propertyContainsFunction("sys.usb.config", function));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138650861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138650861;
        // ---------- Original Method ----------
        //return propertyContainsFunction("sys.usb.config", function);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.031 -0400", hash_original_method = "4ECB85B34540B5A01AD76105AF55C635", hash_generated_method = "4162E419464013A1F056747ACA7DC3BA")
    public String getDefaultFunction() {
        String functions = SystemProperties.get("persist.sys.usb.config", "");
        int commaIndex = functions.indexOf(',');
        if(commaIndex > 0)        
        {
String varB1F03C09EF1517A7A07AC1EC158DB374_1526167785 =             functions.substring(0, commaIndex);
            varB1F03C09EF1517A7A07AC1EC158DB374_1526167785.addTaint(taint);
            return varB1F03C09EF1517A7A07AC1EC158DB374_1526167785;
        } //End block
        else
        {
String varA910D99B3498A5875DCE8E4786C1850C_854403506 =             functions;
            varA910D99B3498A5875DCE8E4786C1850C_854403506.addTaint(taint);
            return varA910D99B3498A5875DCE8E4786C1850C_854403506;
        } //End block
        // ---------- Original Method ----------
        //String functions = SystemProperties.get("persist.sys.usb.config", "");
        //int commaIndex = functions.indexOf(',');
        //if (commaIndex > 0) {
            //return functions.substring(0, commaIndex);
        //} else {
            //return functions;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.032 -0400", hash_original_method = "F2B908DC7033D00CDC14F7636607BD05", hash_generated_method = "643D453C0D3E1BE761C07D36B758E60C")
    public void setCurrentFunction(String function, boolean makeDefault) {
        addTaint(makeDefault);
        addTaint(function.getTaint());
        try 
        {
            mService.setCurrentFunction(function, makeDefault);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setCurrentFunction(function, makeDefault);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setCurrentFunction", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.032 -0400", hash_original_method = "4FECF17333249386DEF6A0E8A7778CCC", hash_generated_method = "9FE82B361B0E0B2E7AEB90EDC3182476")
    public void setMassStorageBackingFile(String path) {
        addTaint(path.getTaint());
        try 
        {
            mService.setMassStorageBackingFile(path);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setMassStorageBackingFile(path);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setDefaultFunction", e);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.032 -0400", hash_original_field = "45890D94A9D3A158F791D29DFB995FC2", hash_generated_field = "4E4D474696493E1958F812DD8E6C34BA")

    private static final String TAG = "UsbManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.032 -0400", hash_original_field = "FE85C6ED1D343F500734B31324429021", hash_generated_field = "81BE48BE3545B6C0AF3886FBE7E0CF93")

    public static final String ACTION_USB_STATE =
            "android.hardware.usb.action.USB_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.032 -0400", hash_original_field = "38B3568AE9A49A68E7733DF3F678EF63", hash_generated_field = "E6236838A13415D7A1993E1681A8C8EF")

    public static final String ACTION_USB_DEVICE_ATTACHED =
            "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "B8E3B862CDEAD696DCC514064954BA05", hash_generated_field = "8DD3F489A2322D15E23DF4BED81C8198")

    public static final String ACTION_USB_DEVICE_DETACHED =
            "android.hardware.usb.action.USB_DEVICE_DETACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "A96A062F4519E1C5BB610B0AAE68B740", hash_generated_field = "7F6E08CDAF99F77BA13376DDB40CD234")

    public static final String ACTION_USB_ACCESSORY_ATTACHED =
            "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "B52101A9D16158244E6D765DD62064DB", hash_generated_field = "50A1437E54F677D31B3FF8ABAA84112C")

    public static final String ACTION_USB_ACCESSORY_DETACHED =
            "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "07B06A8AC3B82A8CDC81F9002D9E0C6C", hash_generated_field = "1809508645500165607428B200A594AF")

    public static final String USB_CONNECTED = "connected";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "E28108F5148DDA6BC380D4960E4C5967", hash_generated_field = "F425ACD8DE6EC7A5ADE71CC2EF5B5AAC")

    public static final String USB_CONFIGURED = "configured";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "76E06A706AC54D5CDFAF012BE826E696", hash_generated_field = "2376762F5D369C5EC2D4531354655CAF")

    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "B63601F472EE0E89EA69769E15402C3A", hash_generated_field = "2F1148450C80C2AE92140A4CD45B1406")

    public static final String USB_FUNCTION_ADB = "adb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "DD49DFC93007354E6EE0717E199379DF", hash_generated_field = "30B363F1AC43DA79B86BA78A99E3F920")

    public static final String USB_FUNCTION_RNDIS = "rndis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "313CEFFAD8268487545B3BBAAB86F730", hash_generated_field = "80B798620CDF5853DCD2B86A3DB69844")

    public static final String USB_FUNCTION_MTP = "mtp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "40ED0E4C9C479230A0A45E6A7294A59F", hash_generated_field = "72DFF7A4506F3BA08A49DCA2E1E5EE06")

    public static final String USB_FUNCTION_PTP = "ptp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "7B55691518FF706BEA93D26E45066F29", hash_generated_field = "A650900F9A212F03E6AD3FBEEABF5A6A")

    public static final String USB_FUNCTION_ACCESSORY = "accessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "4B0AA896B6AB698DDF85873A7FA89C4F", hash_generated_field = "5B148AA6DEC965746A1892CA1FEAF53B")

    public static final String EXTRA_DEVICE = "device";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "32C13A9501C645226FE8E1A429CEF5E9", hash_generated_field = "89F4F27AA905841082E03C1C7E821929")

    public static final String EXTRA_ACCESSORY = "accessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.033 -0400", hash_original_field = "E5BD88ADBABDDDC58A5AFF99E792D620", hash_generated_field = "26FD7883E79465E111C98DF0D42770DE")

    public static final String EXTRA_PERMISSION_GRANTED = "permission";
}

