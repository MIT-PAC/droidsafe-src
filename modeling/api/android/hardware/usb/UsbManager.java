/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.hardware.usb;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;

public class UsbManager {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.845 -0500", hash_original_method = "3527AD09EAC8F1A9B30738F109BFF0EB", hash_generated_method = "059160C4C1510BF56B72A4B251A799DF")
    
private static boolean propertyContainsFunction(String property, String function) {
        String functions = SystemProperties.get(property, "");
        int index = functions.indexOf(function);
        if (index < 0) return false;
        if (index > 0 && functions.charAt(index - 1) != ',') return false;
        int charAfter = index + function.length();
        if (charAfter < functions.length() && functions.charAt(charAfter) != ',') return false;
        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.769 -0500", hash_original_field = "BD061909A3C8481DD2178D3E5E155656", hash_generated_field = "4E4D474696493E1958F812DD8E6C34BA")

    private static final String TAG = "UsbManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.772 -0500", hash_original_field = "F1829A8539394794BA82FD2358428FFE", hash_generated_field = "81BE48BE3545B6C0AF3886FBE7E0CF93")

    public static final String ACTION_USB_STATE =
            "android.hardware.usb.action.USB_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.775 -0500", hash_original_field = "54A42952C1358EA165484F3F6140CFB6", hash_generated_field = "E6236838A13415D7A1993E1681A8C8EF")

    public static final String ACTION_USB_DEVICE_ATTACHED =
            "android.hardware.usb.action.USB_DEVICE_ATTACHED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.777 -0500", hash_original_field = "52F5ECA849789E7641DB6AD5F211B053", hash_generated_field = "8DD3F489A2322D15E23DF4BED81C8198")

    public static final String ACTION_USB_DEVICE_DETACHED =
            "android.hardware.usb.action.USB_DEVICE_DETACHED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.780 -0500", hash_original_field = "AC96EB3940164257CF52FD8DA23A6501", hash_generated_field = "7F6E08CDAF99F77BA13376DDB40CD234")

    public static final String ACTION_USB_ACCESSORY_ATTACHED =
            "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.783 -0500", hash_original_field = "D3A1FDD5E58BC162322069F9F7038ED1", hash_generated_field = "50A1437E54F677D31B3FF8ABAA84112C")

    public static final String ACTION_USB_ACCESSORY_DETACHED =
            "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.785 -0500", hash_original_field = "F8D3B281009DE7E5F6BCDA1AD1600020", hash_generated_field = "1809508645500165607428B200A594AF")

    public static final String USB_CONNECTED = "connected";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.788 -0500", hash_original_field = "680A551E7BCB96C92D53582220DAA760", hash_generated_field = "F425ACD8DE6EC7A5ADE71CC2EF5B5AAC")

    public static final String USB_CONFIGURED = "configured";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.792 -0500", hash_original_field = "BA233624D408F4B05D1F34E76DDE393B", hash_generated_field = "2376762F5D369C5EC2D4531354655CAF")

    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.794 -0500", hash_original_field = "174FF0EE94C9CFB8532C42C960F19B1B", hash_generated_field = "2F1148450C80C2AE92140A4CD45B1406")

    public static final String USB_FUNCTION_ADB = "adb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.797 -0500", hash_original_field = "42DF6480A9F6535A37245F659CD2CFAB", hash_generated_field = "30B363F1AC43DA79B86BA78A99E3F920")

    public static final String USB_FUNCTION_RNDIS = "rndis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.800 -0500", hash_original_field = "4CD3CFF6CDB8C42E1134B2FB0E0F34AA", hash_generated_field = "80B798620CDF5853DCD2B86A3DB69844")

    public static final String USB_FUNCTION_MTP = "mtp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.802 -0500", hash_original_field = "06CF7D3D07E38F8D65BA8DE64317604E", hash_generated_field = "72DFF7A4506F3BA08A49DCA2E1E5EE06")

    public static final String USB_FUNCTION_PTP = "ptp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.805 -0500", hash_original_field = "9B01C2C07ED1871F6CB18E664B823E7F", hash_generated_field = "A650900F9A212F03E6AD3FBEEABF5A6A")

    public static final String USB_FUNCTION_ACCESSORY = "accessory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.807 -0500", hash_original_field = "825B239AE18DC9730F3190D34270FCC2", hash_generated_field = "5B148AA6DEC965746A1892CA1FEAF53B")

    public static final String EXTRA_DEVICE = "device";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.810 -0500", hash_original_field = "DFA52CB4FB7EAC8C51F5368D1BBF90B4", hash_generated_field = "89F4F27AA905841082E03C1C7E821929")

    public static final String EXTRA_ACCESSORY = "accessory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.813 -0500", hash_original_field = "0018B5ACC304C4FD7EDC5FA9E7FC89D7", hash_generated_field = "26FD7883E79465E111C98DF0D42770DE")

    public static final String EXTRA_PERMISSION_GRANTED = "permission";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.815 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.818 -0500", hash_original_field = "ACA435D22738EE6933BB846E779503B1", hash_generated_field = "9FD6577446058467C3BAA1A318AD88B5")

    private  IUsbManager mService;

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.821 -0500", hash_original_method = "68E88C1381A537FEBD5C1D01CC81CFD6", hash_generated_method = "0DB4A9AC890BDC20229283F595CD970C")
    
public UsbManager(Context context, IUsbManager service) {
        mContext = context;
        mService = service;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.023 -0400", hash_original_method = "68E88C1381A537FEBD5C1D01CC81CFD6", hash_generated_method = "0147BA6BA88EBD3825613E13FAA8DB75")
    public  UsbManager(Context context){
        mContext = context;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = service;
    }

    /**
     * Returns a HashMap containing all USB devices currently attached.
     * USB device name is the key for the returned HashMap.
     * The result will be empty if no devices are attached, or if
     * USB host mode is inactive or unsupported.
     *
     * @return HashMap containing all connected USB devices.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.824 -0500", hash_original_method = "0C4F9A912AC5BE14CB67FA981035B977", hash_generated_method = "C3819C284A1846A974ABF59020995526")
    
public HashMap<String,UsbDevice> getDeviceList() {
        Bundle bundle = new Bundle();
        try {
            mService.getDeviceList(bundle);
            HashMap<String,UsbDevice> result = new HashMap<String,UsbDevice>();
            for (String name : bundle.keySet()) {
                result.put(name, (UsbDevice)bundle.get(name));
            }
            return result;
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getDeviceList", e);
            return null;
        }
    }

    /**
     * Opens the device so it can be used to send and receive
     * data using {@link android.hardware.usb.UsbRequest}.
     *
     * @param device the device to open
     * @return true if we successfully opened the device
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.826 -0500", hash_original_method = "8D8483424EA0CFD952FF0A230CCAC549", hash_generated_method = "B53D5A9E8934D850302B0FEB181A8863")
    
public UsbDeviceConnection openDevice(UsbDevice device) {
        try {
            String deviceName = device.getDeviceName();
            ParcelFileDescriptor pfd = mService.openDevice(deviceName);
            if (pfd != null) {
                UsbDeviceConnection connection = new UsbDeviceConnection(device);
                boolean result = connection.open(deviceName, pfd);
                pfd.close();
                if (result) {
                    return connection;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "exception in UsbManager.openDevice", e);
        }
        return null;
    }

    /**
     * Returns a list of currently attached USB accessories.
     * (in the current implementation there can be at most one)
     *
     * @return list of USB accessories, or null if none are attached.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.829 -0500", hash_original_method = "1BBBF6CC2C81B72139C0D4C7AF3A1618", hash_generated_method = "8AE4C903E8B822CEB6B3A1FC83A6DA3B")
    
public UsbAccessory[] getAccessoryList() {
        try {
            UsbAccessory accessory = mService.getCurrentAccessory();
            if (accessory == null) {
                return null;
            } else {
                return new UsbAccessory[] { accessory };
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getAccessoryList", e);
            return null;
        }
    }

    /**
     * Opens a file descriptor for reading and writing data to the USB accessory.
     *
     * @param accessory the USB accessory to open
     * @return file descriptor, or null if the accessor could not be opened.
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.831 -0500", hash_original_method = "E613A4CA88B6248C79E5606341D1D797", hash_generated_method = "96BFC0D30548295B2B07F5B529143609")
    
public ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        try {
            return mService.openAccessory(accessory);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in openAccessory", e);
            return null;
        }
    }

    /**
     * Returns true if the caller has permission to access the device.
     * Permission might have been granted temporarily via
     * {@link #requestPermission(UsbDevice, PendingIntent)} or
     * by the user choosing the caller as the default application for the device.
     *
     * @param device to check permissions for
     * @return true if caller has permission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.834 -0500", hash_original_method = "BC4EEEB293CF372F4C660B9CBB978F7E", hash_generated_method = "05D807889F4347873B5237BB829C9771")
    
public boolean hasPermission(UsbDevice device) {
        try {
            return mService.hasDevicePermission(device);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in hasPermission", e);
            return false;
        }
    }

    /**
     * Returns true if the caller has permission to access the accessory.
     * Permission might have been granted temporarily via
     * {@link #requestPermission(UsbAccessory, PendingIntent)} or
     * by the user choosing the caller as the default application for the accessory.
     *
     * @param accessory to check permissions for
     * @return true if caller has permission
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.837 -0500", hash_original_method = "8C883717D72FFED5467C2C0C4FA603AB", hash_generated_method = "2FDAF74B987B21484225B9A96BEC9A05")
    
public boolean hasPermission(UsbAccessory accessory) {
        try {
            return mService.hasAccessoryPermission(accessory);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in hasPermission", e);
            return false;
        }
    }

    /**
     * Requests temporary permission for the given package to access the device.
     * This may result in a system dialog being displayed to the user
     * if permission had not already been granted.
     * Success or failure is returned via the {@link android.app.PendingIntent} pi.
     * If successful, this grants the caller permission to access the device only
     * until the device is disconnected.
     *
     * The following extras will be added to pi:
     * <ul>
     * <li> {@link #EXTRA_DEVICE} containing the device passed into this call
     * <li> {@link #EXTRA_PERMISSION_GRANTED} containing boolean indicating whether
     * permission was granted by the user
     * </ul>
     *
     * @param device to request permissions for
     * @param pi PendingIntent for returning result
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.840 -0500", hash_original_method = "0BC6C49F477F609E4761FAD93127C8B1", hash_generated_method = "DEA1EB5714DF66F497738D332D386D87")
    
public void requestPermission(UsbDevice device, PendingIntent pi) {
        try {
            mService.requestDevicePermission(device, mContext.getPackageName(), pi);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in requestPermission", e);
        }
    }

    /**
     * Requests temporary permission for the given package to access the accessory.
     * This may result in a system dialog being displayed to the user
     * if permission had not already been granted.
     * Success or failure is returned via the {@link android.app.PendingIntent} pi.
     * If successful, this grants the caller permission to access the accessory only
     * until the device is disconnected.
     *
     * The following extras will be added to pi:
     * <ul>
     * <li> {@link #EXTRA_ACCESSORY} containing the accessory passed into this call
     * <li> {@link #EXTRA_PERMISSION_GRANTED} containing boolean indicating whether
     * permission was granted by the user
     * </ul>
     *
     * @param accessory to request permissions for
     * @param pi PendingIntent for returning result
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.843 -0500", hash_original_method = "FC51D136A8BB60237D8B3FCD832EDCEE", hash_generated_method = "EC40362E955169299877CC20784D06D3")
    
public void requestPermission(UsbAccessory accessory, PendingIntent pi) {
        try {
            mService.requestAccessoryPermission(accessory, mContext.getPackageName(), pi);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in requestPermission", e);
        }
    }

    /**
     * Returns true if the specified USB function is currently enabled.
     *
     * @param function name of the USB function
     * @return true if the USB function is enabled.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.847 -0500", hash_original_method = "B2F7E99E5659CE0D7ECF8F6FFE68B901", hash_generated_method = "7A856CD3563648732364FDA9AD6EC849")
    
public boolean isFunctionEnabled(String function) {
        return propertyContainsFunction("sys.usb.config", function);
    }

    /**
     * Returns the current default USB function.
     *
     * @return name of the default function.
     *
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.850 -0500", hash_original_method = "4ECB85B34540B5A01AD76105AF55C635", hash_generated_method = "E1BD1ECDEE3FC8FBA55FA007ED057722")
    
public String getDefaultFunction() {
        String functions = SystemProperties.get("persist.sys.usb.config", "");
        int commaIndex = functions.indexOf(',');
        if (commaIndex > 0) {
            return functions.substring(0, commaIndex);
        } else {
            return functions;
        }
    }

    /**
     * Sets the current USB function.
     * If function is null, then the current function is set to the default function.
     *
     * @param function name of the USB function, or null to restore the default function
     * @param makeDefault true if the function should be set as the new default function
     *
     * {@hide}
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.852 -0500", hash_original_method = "F2B908DC7033D00CDC14F7636607BD05", hash_generated_method = "4C84ADE51EAE7591BCDB7D4ADCD66F94")
    
public void setCurrentFunction(String function, boolean makeDefault) {
        try {
            mService.setCurrentFunction(function, makeDefault);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setCurrentFunction", e);
        }
    }

    /**
     * Sets the file path for USB mass storage backing file.
     *
     * @param path backing file path
     *
     * {@hide}
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:50.855 -0500", hash_original_method = "4FECF17333249386DEF6A0E8A7778CCC", hash_generated_method = "CB6CB90A8AFCD1A94FFB84CAFEC78556")
    
public void setMassStorageBackingFile(String path) {
        try {
            mService.setMassStorageBackingFile(path);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setDefaultFunction", e);
        }
    }
}

