/*
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

package android.mtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.os.ParcelFileDescriptor;
import android.util.Log;

/**
 * This class represents an MTP or PTP device connected on the USB host bus. An application can
 * instantiate an object of this type, by referencing an attached {@link
 * android.hardware.usb.UsbDevice} and then use methods in this class to get information about the
 * device and objects stored on it, as well as open the connection and transfer data.
 */
public final class MtpDevice {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.430 -0400", hash_original_field = "C77B36D2C4420AD6F3DEC49267C035C6", hash_generated_field = "00047F8033BCA338610A18BB362B350D")

    private static final String TAG = "MtpDevice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.432 -0400", hash_original_field = "96CF9DCB0700F4F17C2B20B3728B381A", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private  UsbDevice mDevice;

    static {
        System.loadLibrary("media_jni");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.463 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;

    /**
     * MtpClient constructor
     *
     * @param device the {@link android.hardware.usb.UsbDevice} for the MTP or PTP device
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.434 -0400", hash_original_method = "C92A66158E18F9717673C0A4C403F48C", hash_generated_method = "691451D74D3F5EB13AA2684C072DD65D")
    
public MtpDevice(UsbDevice device) {
        mDevice = device;
    }

    /**
     * Opens the MTP device.  Once the device is open it takes ownership of the
     * {@link android.hardware.usb.UsbDeviceConnection}.  
     * The connection will be closed when you call {@link #close()}
     * The connection will also be closed if this method fails.
     *
     * @param connection an open {@link android.hardware.usb.UsbDeviceConnection} for the device
     * @return true if the device was successfully opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.435 -0400", hash_original_method = "8E894CD463789E81489C792B17B9F961", hash_generated_method = "94DCE6FD8954FDFC13F44B26B3A0EEAA")
    
public boolean open(UsbDeviceConnection connection) {
        boolean result = native_open(mDevice.getDeviceName(), connection.getFileDescriptor());
        if (!result) {
            connection.close();
        }
        return result;
    }

    /**
     * Closes all resources related to the MtpDevice object.
     * After this is called, the object can not be used until {@link #open} is called again
     * with a new {@link android.hardware.usb.UsbDeviceConnection}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.437 -0400", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "9257A400E80B3398D82DE45E753ECB2C")
    
public void close() {
        native_close();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.439 -0400", hash_original_method = "6E8A804E48C277661FFB4A5BE2408D94", hash_generated_method = "891FA77FB12D216F0324B2EF3DF11386")
    
@Override
    protected void finalize() throws Throwable {
        try {
            native_close();
        } finally {
            super.finalize();
        }
    }

    /**
     * Returns the name of the USB device
     * This returns the same value as {@link android.hardware.usb.UsbDevice#getDeviceName}
     * for the device's {@link android.hardware.usb.UsbDevice}
     *
     * @return the device name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.440 -0400", hash_original_method = "5D12F43113A973386A1C09CC9DDA6F05", hash_generated_method = "A2E08BBF188A96F6112C20EB1CA9D7C5")
    
public String getDeviceName() {
        return mDevice.getDeviceName();
    }

    /**
     * Returns the USB ID of the USB device.
     * This returns the same value as {@link android.hardware.usb.UsbDevice#getDeviceId}
     * for the device's {@link android.hardware.usb.UsbDevice}
     *
     * @return the device ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.442 -0400", hash_original_method = "19E18A6A588036FD630F5AC991FA0440", hash_generated_method = "7FE7879EB750D90A1E203CB816FCC21B")
    
public int getDeviceId() {
        return mDevice.getDeviceId();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.443 -0400", hash_original_method = "F4DD983E12FB02EC6DEE02788BABE0BF", hash_generated_method = "86F0CFCF2F498259BDB3C3874964F44D")
    
@Override
    public String toString() {
        return mDevice.getDeviceName();
    }

    /**
     * Returns the {@link MtpDeviceInfo} for this device
     *
     * @return the device info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.445 -0400", hash_original_method = "86794511E1C05EB1912D2D6C8C7877C7", hash_generated_method = "9E7330E0DD24D0DFEBC29384DFA95947")
    
public MtpDeviceInfo getDeviceInfo() {
        return native_get_device_info();
    }

    /**
     * Returns the list of IDs for all storage units on this device
     * Information about each storage unit can be accessed via {@link #getStorageInfo}.
     *
     * @return the list of storage IDs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.448 -0400", hash_original_method = "0848DFAA51E992BF70F3CE7A68E745A9", hash_generated_method = "6819B96AC6BB19FCA97D08DEBF6CBF09")
    
public int[] getStorageIds() {
        return native_get_storage_ids();
    }

    /**
     * Returns the list of object handles for all objects on the given storage unit,
     * with the given format and parent.
     * Information about each object can be accessed via {@link #getObjectInfo}.
     *
     * @param storageId the storage unit to query
     * @param format the format of the object to return, or zero for all formats
     * @param objectHandle the parent object to query, or zero for the storage root
     * @return the object handles
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.449 -0400", hash_original_method = "93BAD429C46685F3BCA7BF13D7A90D48", hash_generated_method = "BBBBB871A5E79C254C0F231D502CE318")
    
public int[] getObjectHandles(int storageId, int format, int objectHandle) {
        return native_get_object_handles(storageId, format, objectHandle);
    }

    /**
     * Returns the data for an object as a byte array.
     * This call may block for an arbitrary amount of time depending on the size
     * of the data and speed of the devices.
     *
     * @param objectHandle handle of the object to read
     * @param objectSize the size of the object (this should match
     *      {@link MtpObjectInfo#getCompressedSize}
     * @return the object's data, or null if reading fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.451 -0400", hash_original_method = "50398050A47337B631A5A021F26EFD0A", hash_generated_method = "3FB3BD15A0E2F7EB06B26F7D1057D6B4")
    
public byte[] getObject(int objectHandle, int objectSize) {
        return native_get_object(objectHandle, objectSize);
    }

    /**
     * Returns the thumbnail data for an object as a byte array.
     * The size and format of the thumbnail data can be determined via
     * {@link MtpObjectInfo#getThumbCompressedSize} and
     * {@link MtpObjectInfo#getThumbFormat}.
     * For typical devices the format is JPEG.
     *
     * @param objectHandle handle of the object to read
     * @return the object's thumbnail, or null if reading fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.453 -0400", hash_original_method = "95D27B585D5DBB96845217B7264E023C", hash_generated_method = "94E40CCD0C5E44F2FBC7FF00EDE758BE")
    
public byte[] getThumbnail(int objectHandle) {
        return native_get_thumbnail(objectHandle);
    }

    /**
     * Retrieves the {@link MtpStorageInfo} for a storage unit.
     *
     * @param storageId the ID of the storage unit
     * @return the MtpStorageInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.454 -0400", hash_original_method = "DF9A43FC7A30E60DE3F5BB99655887EE", hash_generated_method = "7F57BB8AF488209B420C9EB2F477E621")
    
public MtpStorageInfo getStorageInfo(int storageId) {
        return native_get_storage_info(storageId);
    }

    /**
     * Retrieves the {@link MtpObjectInfo} for an object.
     *
     * @param objectHandle the handle of the object
     * @return the MtpObjectInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.456 -0400", hash_original_method = "4925460C0BD66C758760EB717F134F32", hash_generated_method = "8E7955C9490D0DF821CC89FBE1A223CF")
    
public MtpObjectInfo getObjectInfo(int objectHandle) {
        return native_get_object_info(objectHandle);
    }

    /**
     * Deletes an object on the device.  This call may block, since
     * deleting a directory containing many files may take a long time
     * on some devices.
     *
     * @param objectHandle handle of the object to delete
     * @return true if the deletion succeeds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.458 -0400", hash_original_method = "1BB17701717D2715ABA5BCDFA9DA2DF9", hash_generated_method = "319C5DAABFD8107C01F48A7BC435DD5E")
    
public boolean deleteObject(int objectHandle) {
        return native_delete_object(objectHandle);
    }

    /**
     * Retrieves the object handle for the parent of an object on the device.
     *
     * @param objectHandle handle of the object to query
     * @return the parent's handle, or zero if it is in the root of the storage
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.459 -0400", hash_original_method = "BF197007D8BAFAB02E9B3F55E140F956", hash_generated_method = "E8447DBA34D7063A80D2EBE1A49F1B5C")
    
public long getParent(int objectHandle) {
        return native_get_parent(objectHandle);
    }

    /**
     * Retrieves the ID of the storage unit containing the given object on the device.
     *
     * @param objectHandle handle of the object to query
     * @return the object's storage unit ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.460 -0400", hash_original_method = "6B95CCB0258908ABF933691F9FAABAAF", hash_generated_method = "838B1514A2FFF0D3FFE1575423C504C5")
    
public long getStorageId(int objectHandle) {
        return native_get_storage_id(objectHandle);
    }

    /**
     * Copies the data for an object to a file in external storage.
     * This call may block for an arbitrary amount of time depending on the size
     * of the data and speed of the devices.
     *
     * @param objectHandle handle of the object to read
     * @param destPath path to destination for the file transfer.
     *      This path should be in the external storage as defined by
     *      {@link android.os.Environment#getExternalStorageDirectory}
     * @return true if the file transfer succeeds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.462 -0400", hash_original_method = "F0050DB3C23864EC2EC73B2F8ADFE920", hash_generated_method = "EB7EF1851021BB80B98A26BB23902B4B")
    
public boolean importFile(int objectHandle, String destPath) {
        return native_import_file(objectHandle, destPath);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.353 -0400", hash_original_method = "CD4F9C9EF8A48BB8427F548656B19C3D", hash_generated_method = "6D148476D33BCF3FEE7990D9DE46550A")
    
    private boolean native_open(String deviceName, int fd){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += deviceName.getTaintInt();
    	taintDouble += fd;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:04.782 -0400", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "75E92DEDBEC5DB3628B1DCB207D9511C")
    
    private void native_close(){
    	//Formerly a native method
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:53.257 -0400", hash_original_method = "C1C3C8489F84A0AACF590B133AA8A1DD", hash_generated_method = "EA5D00C12A36D80E9E9F17E88D94B00F")
    
    private MtpDeviceInfo native_get_device_info(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	MtpDeviceInfo retObj = new MtpDeviceInfo(DSOnlyType.DONTCARE); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:53.259 -0400", hash_original_method = "770A62AA7D7C88A082CAFF8DEC72E28C", hash_generated_method = "7BB3EBA4DA2881D8F25547B05D2FAC7F")
    
    private int[] native_get_storage_ids(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.367 -0400", hash_original_method = "F46AD5A2EF2BE531C039B2DBE8A02AD0", hash_generated_method = "92A95F6CE6A79944F5EECBD1DF30D71F")
    
    private MtpStorageInfo native_get_storage_info(int storageId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += storageId;
    	addTaint(taintDouble);
    
    	MtpStorageInfo retObj = new MtpStorageInfo(DSOnlyType.DONTCARE); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.371 -0400", hash_original_method = "9501B5A80704E597A9364A356236771D", hash_generated_method = "F4F055217FDA91AC2034595D3B95BAAA")
    
    private int[] native_get_object_handles(int storageId, int format, int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += storageId;
    	taintDouble += format;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.374 -0400", hash_original_method = "07503E709352379051B8BE5CF99ECC23", hash_generated_method = "FD2994A373A029F6573573C91E78201E")
    
    private MtpObjectInfo native_get_object_info(int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	MtpObjectInfo retObj = new MtpObjectInfo(DSOnlyType.DONTCARE); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.378 -0400", hash_original_method = "6AA002B90D8EEC684BB20499A081E5BD", hash_generated_method = "DACCB5AE2BF3F5F976665ED4B1912007")
    
    private byte[] native_get_object(int objectHandle, int objectSize){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	taintDouble += objectSize;
    	addTaint(taintDouble);
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.381 -0400", hash_original_method = "43A1C341F130D0810BB0FE7B22BA9E74", hash_generated_method = "82BD6771CA7337B46AA45F5A537AE101")
    
    private byte[] native_get_thumbnail(int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.385 -0400", hash_original_method = "40F6B557D08B1B3BC0D6E45526D8B160", hash_generated_method = "17F4C2FF7A2781CFDBB4AE3E5A0631DD")
    
    private boolean native_delete_object(int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.388 -0400", hash_original_method = "A7969E9F341EBBA0BCDA58E96E692FDD", hash_generated_method = "876BD8DDDE08B9480F240AB2771C27CD")
    
    private long native_get_parent(int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.391 -0400", hash_original_method = "300580C7F80802CA595C51F1F4FCFD9D", hash_generated_method = "15C4C90FBACBF047AC1C85FCC3FB5E14")
    
    private long native_get_storage_id(int objectHandle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:31.395 -0400", hash_original_method = "44FB9A8FA837EE6EDFA29756D7DF0A36", hash_generated_method = "9A1BE04AC9C2833910FD21DCAC1D1643")
    
    private boolean native_import_file(int objectHandle, String destPath){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += objectHandle;
    	taintDouble += destPath.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

}
