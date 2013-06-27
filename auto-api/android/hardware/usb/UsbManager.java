package android.hardware.usb;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import java.util.HashMap;

public class UsbManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.049 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.049 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "9FD6577446058467C3BAA1A318AD88B5")

    private IUsbManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.050 -0400", hash_original_method = "68E88C1381A537FEBD5C1D01CC81CFD6", hash_generated_method = "0147BA6BA88EBD3825613E13FAA8DB75")
    public  UsbManager(Context context, IUsbManager service) {
        mContext = context;
        mService = service;
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.084 -0400", hash_original_method = "0C4F9A912AC5BE14CB67FA981035B977", hash_generated_method = "F1DEC110B2EB17B0824AB85249E6C629")
    public HashMap<String,UsbDevice> getDeviceList() {
        HashMap<String,UsbDevice> varB4EAC82CA7396A68D541C85D26508E83_75168803 = null; //Variable for return #1
        HashMap<String,UsbDevice> varB4EAC82CA7396A68D541C85D26508E83_282903956 = null; //Variable for return #2
        Bundle bundle;
        bundle = new Bundle();
        try 
        {
            mService.getDeviceList(bundle);
            HashMap<String,UsbDevice> result;
            result = new HashMap<String,UsbDevice>();
            {
                Iterator<String> varE476B9C75625B551CC58862C2792B0A3_1873922796 = (bundle.keySet()).iterator();
                varE476B9C75625B551CC58862C2792B0A3_1873922796.hasNext();
                String name = varE476B9C75625B551CC58862C2792B0A3_1873922796.next();
                {
                    result.put(name, (UsbDevice)bundle.get(name));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_75168803 = result;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_282903956 = null;
        } //End block
        HashMap<String,UsbDevice> varA7E53CE21691AB073D9660D615818899_649561344; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_649561344 = varB4EAC82CA7396A68D541C85D26508E83_75168803;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_649561344 = varB4EAC82CA7396A68D541C85D26508E83_282903956;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_649561344.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_649561344;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.089 -0400", hash_original_method = "8D8483424EA0CFD952FF0A230CCAC549", hash_generated_method = "7823595D8F1AC5B96D81C6648BB2B841")
    public UsbDeviceConnection openDevice(UsbDevice device) {
        UsbDeviceConnection varB4EAC82CA7396A68D541C85D26508E83_1041996891 = null; //Variable for return #1
        UsbDeviceConnection varB4EAC82CA7396A68D541C85D26508E83_1665753421 = null; //Variable for return #2
        try 
        {
            String deviceName;
            deviceName = device.getDeviceName();
            ParcelFileDescriptor pfd;
            pfd = mService.openDevice(deviceName);
            {
                UsbDeviceConnection connection;
                connection = new UsbDeviceConnection(device);
                boolean result;
                result = connection.open(deviceName, pfd);
                pfd.close();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1041996891 = connection;
                } //End block
            } //End block
        } //End block
        catch (Exception e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1665753421 = null;
        addTaint(device.getTaint());
        UsbDeviceConnection varA7E53CE21691AB073D9660D615818899_1007001976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1007001976 = varB4EAC82CA7396A68D541C85D26508E83_1041996891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1007001976 = varB4EAC82CA7396A68D541C85D26508E83_1665753421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1007001976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1007001976;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.108 -0400", hash_original_method = "1BBBF6CC2C81B72139C0D4C7AF3A1618", hash_generated_method = "B67E63262A52130D35BEBE3F5290EBF9")
    public UsbAccessory[] getAccessoryList() {
        UsbAccessory[] varB4EAC82CA7396A68D541C85D26508E83_97841191 = null; //Variable for return #1
        UsbAccessory[] varB4EAC82CA7396A68D541C85D26508E83_1953438538 = null; //Variable for return #2
        UsbAccessory[] varB4EAC82CA7396A68D541C85D26508E83_1955039320 = null; //Variable for return #3
        try 
        {
            UsbAccessory accessory;
            accessory = mService.getCurrentAccessory();
            {
                varB4EAC82CA7396A68D541C85D26508E83_97841191 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1953438538 = new UsbAccessory[] { accessory };
            } //End block
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1955039320 = null;
        } //End block
        UsbAccessory[] varA7E53CE21691AB073D9660D615818899_1081984640; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1081984640 = varB4EAC82CA7396A68D541C85D26508E83_97841191;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1081984640 = varB4EAC82CA7396A68D541C85D26508E83_1953438538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1081984640 = varB4EAC82CA7396A68D541C85D26508E83_1955039320;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1081984640.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1081984640;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.110 -0400", hash_original_method = "E613A4CA88B6248C79E5606341D1D797", hash_generated_method = "C4D873E49026E9769CBD619B148A97F4")
    public ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1057094356 = null; //Variable for return #1
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_953031332 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1057094356 = mService.openAccessory(accessory);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_953031332 = null;
        } //End block
        addTaint(accessory.getTaint());
        ParcelFileDescriptor varA7E53CE21691AB073D9660D615818899_382772499; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_382772499 = varB4EAC82CA7396A68D541C85D26508E83_1057094356;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_382772499 = varB4EAC82CA7396A68D541C85D26508E83_953031332;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_382772499.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_382772499;
        // ---------- Original Method ----------
        //try {
            //return mService.openAccessory(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in openAccessory", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.115 -0400", hash_original_method = "BC4EEEB293CF372F4C660B9CBB978F7E", hash_generated_method = "0D45677CBF1281561F391A0D7F6B98B7")
    public boolean hasPermission(UsbDevice device) {
        try 
        {
            boolean var2ACEC4A457A9C7E23A21275302CE7190_698360769 = (mService.hasDevicePermission(device));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(device.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940156294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940156294;
        // ---------- Original Method ----------
        //try {
            //return mService.hasDevicePermission(device);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.116 -0400", hash_original_method = "8C883717D72FFED5467C2C0C4FA603AB", hash_generated_method = "066FE90D4FE9A9A718F4128F69F4565A")
    public boolean hasPermission(UsbAccessory accessory) {
        try 
        {
            boolean varB7BA06AF2876C5D51590BCC07BDF4600_1153126388 = (mService.hasAccessoryPermission(accessory));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(accessory.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322764095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322764095;
        // ---------- Original Method ----------
        //try {
            //return mService.hasAccessoryPermission(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.130 -0400", hash_original_method = "0BC6C49F477F609E4761FAD93127C8B1", hash_generated_method = "9BCF153C6B83B2B9516842FF9DC8CA0D")
    public void requestPermission(UsbDevice device, PendingIntent pi) {
        try 
        {
            mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(device.getTaint());
        addTaint(pi.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in requestPermission", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.139 -0400", hash_original_method = "FC51D136A8BB60237D8B3FCD832EDCEE", hash_generated_method = "6CB2CBBAFAF782F00A98AD72ECCAEF0A")
    public void requestPermission(UsbAccessory accessory, PendingIntent pi) {
        try 
        {
            mService.requestAccessoryPermission(accessory, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(accessory.getTaint());
        addTaint(pi.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.156 -0400", hash_original_method = "B2F7E99E5659CE0D7ECF8F6FFE68B901", hash_generated_method = "54C8EA73AFC29077EBCF6DEC2A06151F")
    public boolean isFunctionEnabled(String function) {
        boolean varD65D352761ED522FACBF7743A13AD1F5_487849435 = (propertyContainsFunction("sys.usb.config", function));
        addTaint(function.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792193850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792193850;
        // ---------- Original Method ----------
        //return propertyContainsFunction("sys.usb.config", function);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.157 -0400", hash_original_method = "4ECB85B34540B5A01AD76105AF55C635", hash_generated_method = "CE97AD48614F08DCF732BAB3C431C966")
    public String getDefaultFunction() {
        String varB4EAC82CA7396A68D541C85D26508E83_1884391474 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_547444543 = null; //Variable for return #2
        String functions;
        functions = SystemProperties.get("persist.sys.usb.config", "");
        int commaIndex;
        commaIndex = functions.indexOf(',');
        {
            varB4EAC82CA7396A68D541C85D26508E83_1884391474 = functions.substring(0, commaIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_547444543 = functions;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1757097770; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1757097770 = varB4EAC82CA7396A68D541C85D26508E83_1884391474;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1757097770 = varB4EAC82CA7396A68D541C85D26508E83_547444543;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1757097770.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1757097770;
        // ---------- Original Method ----------
        //String functions = SystemProperties.get("persist.sys.usb.config", "");
        //int commaIndex = functions.indexOf(',');
        //if (commaIndex > 0) {
            //return functions.substring(0, commaIndex);
        //} else {
            //return functions;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.158 -0400", hash_original_method = "F2B908DC7033D00CDC14F7636607BD05", hash_generated_method = "472333D6A7E4BB34260FF15C477AB3F3")
    public void setCurrentFunction(String function, boolean makeDefault) {
        try 
        {
            mService.setCurrentFunction(function, makeDefault);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(function.getTaint());
        addTaint(makeDefault);
        // ---------- Original Method ----------
        //try {
            //mService.setCurrentFunction(function, makeDefault);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setCurrentFunction", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.158 -0400", hash_original_method = "4FECF17333249386DEF6A0E8A7778CCC", hash_generated_method = "9F9B95094B237A6721710CD9FA1FDA52")
    public void setMassStorageBackingFile(String path) {
        try 
        {
            mService.setMassStorageBackingFile(path);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.setMassStorageBackingFile(path);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setDefaultFunction", e);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "45890D94A9D3A158F791D29DFB995FC2", hash_generated_field = "7A0E6327A4C7EDFF6234B627AF5BC43A")

    private static String TAG = "UsbManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "FE85C6ED1D343F500734B31324429021", hash_generated_field = "81BE48BE3545B6C0AF3886FBE7E0CF93")

    public static final String ACTION_USB_STATE =
            "android.hardware.usb.action.USB_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "38B3568AE9A49A68E7733DF3F678EF63", hash_generated_field = "E6236838A13415D7A1993E1681A8C8EF")

    public static final String ACTION_USB_DEVICE_ATTACHED =
            "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "B8E3B862CDEAD696DCC514064954BA05", hash_generated_field = "8DD3F489A2322D15E23DF4BED81C8198")

    public static final String ACTION_USB_DEVICE_DETACHED =
            "android.hardware.usb.action.USB_DEVICE_DETACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "A96A062F4519E1C5BB610B0AAE68B740", hash_generated_field = "7F6E08CDAF99F77BA13376DDB40CD234")

    public static final String ACTION_USB_ACCESSORY_ATTACHED =
            "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "B52101A9D16158244E6D765DD62064DB", hash_generated_field = "50A1437E54F677D31B3FF8ABAA84112C")

    public static final String ACTION_USB_ACCESSORY_DETACHED =
            "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "07B06A8AC3B82A8CDC81F9002D9E0C6C", hash_generated_field = "1809508645500165607428B200A594AF")

    public static final String USB_CONNECTED = "connected";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "E28108F5148DDA6BC380D4960E4C5967", hash_generated_field = "F425ACD8DE6EC7A5ADE71CC2EF5B5AAC")

    public static final String USB_CONFIGURED = "configured";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "76E06A706AC54D5CDFAF012BE826E696", hash_generated_field = "2376762F5D369C5EC2D4531354655CAF")

    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.159 -0400", hash_original_field = "B63601F472EE0E89EA69769E15402C3A", hash_generated_field = "2F1148450C80C2AE92140A4CD45B1406")

    public static final String USB_FUNCTION_ADB = "adb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "DD49DFC93007354E6EE0717E199379DF", hash_generated_field = "30B363F1AC43DA79B86BA78A99E3F920")

    public static final String USB_FUNCTION_RNDIS = "rndis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "313CEFFAD8268487545B3BBAAB86F730", hash_generated_field = "80B798620CDF5853DCD2B86A3DB69844")

    public static final String USB_FUNCTION_MTP = "mtp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "40ED0E4C9C479230A0A45E6A7294A59F", hash_generated_field = "72DFF7A4506F3BA08A49DCA2E1E5EE06")

    public static final String USB_FUNCTION_PTP = "ptp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "7B55691518FF706BEA93D26E45066F29", hash_generated_field = "A650900F9A212F03E6AD3FBEEABF5A6A")

    public static final String USB_FUNCTION_ACCESSORY = "accessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "4B0AA896B6AB698DDF85873A7FA89C4F", hash_generated_field = "5B148AA6DEC965746A1892CA1FEAF53B")

    public static final String EXTRA_DEVICE = "device";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "32C13A9501C645226FE8E1A429CEF5E9", hash_generated_field = "89F4F27AA905841082E03C1C7E821929")

    public static final String EXTRA_ACCESSORY = "accessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.160 -0400", hash_original_field = "E5BD88ADBABDDDC58A5AFF99E792D620", hash_generated_field = "26FD7883E79465E111C98DF0D42770DE")

    public static final String EXTRA_PERMISSION_GRANTED = "permission";
}

