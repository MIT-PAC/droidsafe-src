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
    private Context mContext;
    private IUsbManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.148 -0400", hash_original_method = "68E88C1381A537FEBD5C1D01CC81CFD6", hash_generated_method = "A7E4E033FA3C86E6BAFC6A886385A9EF")
    @DSModeled(DSC.SAFE)
    public UsbManager(Context context, IUsbManager service) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.158 -0400", hash_original_method = "0C4F9A912AC5BE14CB67FA981035B977", hash_generated_method = "FFC7017CEBD21B49D3D4C21D0DE7C66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HashMap<String,UsbDevice> getDeviceList() {
        Bundle bundle;
        bundle = new Bundle();
        try 
        {
            mService.getDeviceList(bundle);
            HashMap<String,UsbDevice> result;
            result = new HashMap<String,UsbDevice>();
            {
                Iterator<String> varE476B9C75625B551CC58862C2792B0A3_800374978 = (bundle.keySet()).iterator();
                varE476B9C75625B551CC58862C2792B0A3_800374978.hasNext();
                String name = varE476B9C75625B551CC58862C2792B0A3_800374978.next();
                {
                    result.put(name, (UsbDevice)bundle.get(name));
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        return (HashMap<String,UsbDevice>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.159 -0400", hash_original_method = "8D8483424EA0CFD952FF0A230CCAC549", hash_generated_method = "141C07F413AAD577EAA7106C257A6450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UsbDeviceConnection openDevice(UsbDevice device) {
        dsTaint.addTaint(device.dsTaint);
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
            } //End block
        } //End block
        catch (Exception e)
        { }
        return (UsbDeviceConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.160 -0400", hash_original_method = "1BBBF6CC2C81B72139C0D4C7AF3A1618", hash_generated_method = "4C1CE83524E6E1C23E49F25A6DD88C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UsbAccessory[] getAccessoryList() {
        try 
        {
            UsbAccessory accessory;
            accessory = mService.getCurrentAccessory();
            {
                UsbAccessory[] varB55AAD8484BCAE034531963194ADD525_257606579 = (new UsbAccessory[] { accessory });
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        return (UsbAccessory[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.161 -0400", hash_original_method = "E613A4CA88B6248C79E5606341D1D797", hash_generated_method = "5EF35CA6A0324D1787A343B33D3832D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        dsTaint.addTaint(accessory.dsTaint);
        try 
        {
            ParcelFileDescriptor varC35F2EDAA1A0AD66D2638B9B7719EEDD_387589104 = (mService.openAccessory(accessory));
        } //End block
        catch (RemoteException e)
        { }
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.openAccessory(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in openAccessory", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.162 -0400", hash_original_method = "BC4EEEB293CF372F4C660B9CBB978F7E", hash_generated_method = "6C0894E8493423032ED16C14CD1063C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPermission(UsbDevice device) {
        dsTaint.addTaint(device.dsTaint);
        try 
        {
            boolean var2ACEC4A457A9C7E23A21275302CE7190_1019238936 = (mService.hasDevicePermission(device));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.hasDevicePermission(device);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.163 -0400", hash_original_method = "8C883717D72FFED5467C2C0C4FA603AB", hash_generated_method = "92DB612DDE54330E96FD40A92EF79B70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPermission(UsbAccessory accessory) {
        dsTaint.addTaint(accessory.dsTaint);
        try 
        {
            boolean varB7BA06AF2876C5D51590BCC07BDF4600_642491305 = (mService.hasAccessoryPermission(accessory));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.hasAccessoryPermission(accessory);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in hasPermission", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.163 -0400", hash_original_method = "0BC6C49F477F609E4761FAD93127C8B1", hash_generated_method = "627C274CC1E09C2B7C9DE200FF6851AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestPermission(UsbDevice device, PendingIntent pi) {
        dsTaint.addTaint(device.dsTaint);
        dsTaint.addTaint(pi.dsTaint);
        try 
        {
            mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in requestPermission", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.163 -0400", hash_original_method = "FC51D136A8BB60237D8B3FCD832EDCEE", hash_generated_method = "461F4153F55F4515A5AE862491734BC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestPermission(UsbAccessory accessory, PendingIntent pi) {
        dsTaint.addTaint(accessory.dsTaint);
        dsTaint.addTaint(pi.dsTaint);
        try 
        {
            mService.requestAccessoryPermission(accessory, mContext.getPackageName(), pi);
        } //End block
        catch (RemoteException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.164 -0400", hash_original_method = "B2F7E99E5659CE0D7ECF8F6FFE68B901", hash_generated_method = "2553A308B2D229255B2AD7D1B9E31E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFunctionEnabled(String function) {
        dsTaint.addTaint(function);
        boolean varD65D352761ED522FACBF7743A13AD1F5_301724639 = (propertyContainsFunction("sys.usb.config", function));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return propertyContainsFunction("sys.usb.config", function);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.164 -0400", hash_original_method = "4ECB85B34540B5A01AD76105AF55C635", hash_generated_method = "3AE470F9A015650B7B0829CBAE4BB2D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDefaultFunction() {
        String functions;
        functions = SystemProperties.get("persist.sys.usb.config", "");
        int commaIndex;
        commaIndex = functions.indexOf(',');
        {
            String varEA2C45096A07CFBC70770D115A5C73DA_1373491294 = (functions.substring(0, commaIndex));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String functions = SystemProperties.get("persist.sys.usb.config", "");
        //int commaIndex = functions.indexOf(',');
        //if (commaIndex > 0) {
            //return functions.substring(0, commaIndex);
        //} else {
            //return functions;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.165 -0400", hash_original_method = "F2B908DC7033D00CDC14F7636607BD05", hash_generated_method = "F9E2407F86AC4373766E3919831D263A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrentFunction(String function, boolean makeDefault) {
        dsTaint.addTaint(makeDefault);
        dsTaint.addTaint(function);
        try 
        {
            mService.setCurrentFunction(function, makeDefault);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setCurrentFunction(function, makeDefault);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setCurrentFunction", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.165 -0400", hash_original_method = "4FECF17333249386DEF6A0E8A7778CCC", hash_generated_method = "AFB24A9E236C72DAAEAC0D957098516D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMassStorageBackingFile(String path) {
        dsTaint.addTaint(path);
        try 
        {
            mService.setMassStorageBackingFile(path);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setMassStorageBackingFile(path);
        //} catch (RemoteException e) {
            //Log.e(TAG, "RemoteException in setDefaultFunction", e);
        //}
    }

    
    private static final String TAG = "UsbManager";
    public static final String ACTION_USB_STATE =
            "android.hardware.usb.action.USB_STATE";
    public static final String ACTION_USB_DEVICE_ATTACHED =
            "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    public static final String ACTION_USB_DEVICE_DETACHED =
            "android.hardware.usb.action.USB_DEVICE_DETACHED";
    public static final String ACTION_USB_ACCESSORY_ATTACHED =
            "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    public static final String ACTION_USB_ACCESSORY_DETACHED =
            "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    public static final String USB_CONNECTED = "connected";
    public static final String USB_CONFIGURED = "configured";
    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
    public static final String USB_FUNCTION_ADB = "adb";
    public static final String USB_FUNCTION_RNDIS = "rndis";
    public static final String USB_FUNCTION_MTP = "mtp";
    public static final String USB_FUNCTION_PTP = "ptp";
    public static final String USB_FUNCTION_ACCESSORY = "accessory";
    public static final String EXTRA_DEVICE = "device";
    public static final String EXTRA_ACCESSORY = "accessory";
    public static final String EXTRA_PERMISSION_GRANTED = "permission";
}

