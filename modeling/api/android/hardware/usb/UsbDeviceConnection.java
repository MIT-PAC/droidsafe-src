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
 * Copyright (C) 2011 The Android Open Source Project
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
import droidsafe.annotations.*;
import java.io.FileDescriptor;

import android.os.ParcelFileDescriptor;

import droidsafe.helpers.DSUtils;

public class UsbDeviceConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.069 -0500", hash_original_field = "0C663A0453FFCA73CBAF02CA4F25527B", hash_generated_field = "4D3562CD13C810BE38422BD8716B9B6F")

    private static final String TAG = "UsbDeviceConnection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.073 -0500", hash_original_field = "96CF9DCB0700F4F17C2B20B3728B381A", hash_generated_field = "70928665C1B6A300CDA8094BC826C018")

    private  UsbDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.076 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;

    /**
     * UsbDevice should only be instantiated by UsbService implementation
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.079 -0500", hash_original_method = "890EADCD61ADE223E295BF032157EE11", hash_generated_method = "C5803FF78AE2719195D1DC69971E9931")
    
public UsbDeviceConnection(UsbDevice device) {
        mDevice = device;
        addTaint(device.getTaint());
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.081 -0500", hash_original_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF", hash_generated_method = "F5372DEAC10FA7FD7870C2FF0E38F2EF")
    
boolean open(String name, ParcelFileDescriptor pfd) {
        return native_open(name, pfd.getFileDescriptor());
    }

    /**
     * Releases all system resources related to the device.
     * Once the object is closed it cannot be used again.
     * The client must call {@link UsbManager#openDevice} again
     * to retrieve a new instance to reestablish communication with the device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.083 -0500", hash_original_method = "5F783EAAF9B610A42120DC63BC101285", hash_generated_method = "9257A400E80B3398D82DE45E753ECB2C")
    
public void close() {
        native_close();
    }

    /**
     * Returns the native file descriptor for the device, or
     * -1 if the device is not opened.
     * This is intended for passing to native code to access the device.
     *
     * @return the native file descriptor
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.086 -0500", hash_original_method = "60A97EE86A4E90019B43CF20671154F6", hash_generated_method = "D1AFDC3E572AC08C800BDCCFD464C4B5")
    
public int getFileDescriptor() {
        return native_get_fd();
    }

    /**
     * Returns the raw USB descriptors for the device.
     * This can be used to access descriptors not supported directly
     * via the higher level APIs.
     *
     * @return raw USB descriptors
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.088 -0500", hash_original_method = "C038534F3EE98DEDE0B2FBB8841C177D", hash_generated_method = "E506C17EE9482F4A7FEE53DA20E123B8")
    
public byte[] getRawDescriptors() {
        return native_get_desc();
    }

    /**
     * Claims exclusive access to a {@link android.hardware.usb.UsbInterface}.
     * This must be done before sending or receiving data on any
     * {@link android.hardware.usb.UsbEndpoint}s belonging to the interface.
     *
     * @param intf the interface to claim
     * @param force true to disconnect kernel driver if necessary
     * @return true if the interface was successfully claimed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.092 -0500", hash_original_method = "D71499ECC8620176973E88D08B964E3F", hash_generated_method = "68A5C818784255C557663E724D6F9B0D")
    
public boolean claimInterface(UsbInterface intf, boolean force) {
        //intf.addTaint(getTaint());
        //return intf.getTaintBoolean();
        return native_claim_interface(intf.getId(), force);
    }

    /**
     * Releases exclusive access to a {@link android.hardware.usb.UsbInterface}.
     *
     * @return true if the interface was successfully released
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.095 -0500", hash_original_method = "74FDC63F26CB41DAB86083310901B59F", hash_generated_method = "6C9ED174316CDF155C29E7307DCA1E88")
    
public boolean releaseInterface(UsbInterface intf) {
        return native_release_interface(intf.getId());
    }

    /**
     * Performs a control transaction on endpoint zero for this device.
     * The direction of the transfer is determined by the request type.
     * If requestType & {@link UsbConstants#USB_ENDPOINT_DIR_MASK} is
     * {@link UsbConstants#USB_DIR_OUT}, then the transfer is a write,
     * and if it is {@link UsbConstants#USB_DIR_IN}, then the transfer
     * is a read.
     *
     * @param requestType request type for this transaction
     * @param request request ID for this transaction
     * @param value value field for this transaction
     * @param index index field for this transaction
     * @param buffer buffer for data portion of transaction,
     * or null if no data needs to be sent or received
     * @param length the length of the data to send or receive
     * @param timeout in milliseconds
     * @return length of data transferred (or zero) for success,
     * or negative value for failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.099 -0500", hash_original_method = "287C316117341FB52A3A40CE5C499D4B", hash_generated_method = "CE61F0C638961A5D4F378D03E7A5F968")
    @DSSink(DSSinkKind.USB)
public int controlTransfer(int requestType, int request, int value,
            int index, byte[] buffer, int length, int timeout) {
        return native_control_request(requestType, request, value, index, buffer, length, timeout);
    }

    /**
     * Performs a bulk transaction on the given endpoint.
     * The direction of the transfer is determined by the direction of the endpoint
     *
     * @param endpoint the endpoint for this transaction
     * @param buffer buffer for data to send or receive,
     * @param length the length of the data to send or receive
     * @param timeout in milliseconds
     * @return length of data transferred (or zero) for success,
     * or negative value for failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.102 -0500", hash_original_method = "3B16B20932FC06A1773A3617B4E26D41", hash_generated_method = "D5B0FFEC51ADE550873498514BC5E299")
    @DSSink(DSSinkKind.USB)
public int bulkTransfer(UsbEndpoint endpoint, byte[] buffer, int length, int timeout) {
        return native_bulk_request(endpoint.getAddress(), buffer, length, timeout);
    }

    /**
     * Waits for the result of a {@link android.hardware.usb.UsbRequest#queue} operation
     * Note that this may return requests queued on multiple 
     * {@link android.hardware.usb.UsbEndpoint}s.
     * When multiple endpoints are in use, {@link android.hardware.usb.UsbRequest#getEndpoint} and
     * {@link android.hardware.usb.UsbRequest#getClientData} can be useful in determining
     * how to process the result of this function.
     *
     * @return a completed USB request, or null if an error occurred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.104 -0500", hash_original_method = "5A7C23F6CB3FDC4E6440FEB4EA7749FE", hash_generated_method = "05F936B2991D6F7B534B28AFE283CE34")
    
public UsbRequest requestWait() {
        UsbRequest request = native_request_wait();
        if (request != null) {
            request.dequeue();
        }
        return request;
    }

    /**
     * Returns the serial number for the device.
     * This will return null if the device has not been opened.
     *
     * @return the device serial number
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.107 -0500", hash_original_method = "4F2DA9C2985F5A00889FEF441508C01D", hash_generated_method = "F9BAFD5263D02D037A5EBA14281ADB38")
    
public String getSerial() {
        return native_get_serial();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.112 -0500", hash_original_method = "9E62342DA92A170CFD59DE9144D49504", hash_generated_method = "8CB5F8D9B5EB05A61C61E034D75C67F5")
    
    private boolean native_open(String deviceName, FileDescriptor pfd){
    	//Formerly a native method
    	addTaint(deviceName.getTaint());
    	addTaint(pfd.getTaint());
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.116 -0500", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "75E92DEDBEC5DB3628B1DCB207D9511C")
    
    private void native_close(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.121 -0500", hash_original_method = "A13B1C2D71E358422B30B2068556F978", hash_generated_method = "8B72AFBCBF44300893A5227B6BD7856C")
    
    private int native_get_fd(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.125 -0500", hash_original_method = "6CA261B8E8A3305819062B147F5E1387", hash_generated_method = "C6A6B8E359B6F087548C8B30EA48B374")
    
    private byte[] native_get_desc(){
    	//Formerly a native method
    	return new byte[]{getTaintByte(),};
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.129 -0500", hash_original_method = "391F7A5C89801BBAF6BA75AC34FFB355", hash_generated_method = "97638E79E50C39579ACC41895D412928")
    
    private boolean native_claim_interface(int interfaceID, boolean force){
    	//Formerly a native method
    	addTaint(interfaceID);
    	addTaint(force);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.134 -0500", hash_original_method = "0891BD3C52B455B725F54E6AE146CA4B", hash_generated_method = "2A6230FC45A4FE9E939E5E08D8207806")
    
    private boolean native_release_interface(int interfaceID){
    	//Formerly a native method
    	addTaint(interfaceID);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.138 -0500", hash_original_method = "F086403F8994814C82D251244C9D0D13", hash_generated_method = "5AA2AFAA78DB3704B6ED0871646E6400")
    
    private int native_control_request(int requestType, int request, int value,
                int index, byte[] buffer, int length, int timeout){
    	//Formerly a native method
    	addTaint(requestType);
    	addTaint(request);
    	addTaint(value);
    	addTaint(index);
    	addTaint(buffer[0]);
    	addTaint(length);
    	addTaint(timeout);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.143 -0500", hash_original_method = "BF7603948EC97A6C2A6FF162EAFF5EC5", hash_generated_method = "7FFF791DC0F6219145A9D508B19CE03E")
    
    private int native_bulk_request(int endpoint, byte[] buffer, int length, int timeout){
    	//Formerly a native method
    	addTaint(endpoint);
    	addTaint(buffer[0]);
    	addTaint(length);
    	addTaint(timeout);
    	return getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "88959A018189FD60E12A8554B278AF72", hash_generated_method = "3CB7E68BF025980C89AAE00C7D02E8F5")
    private UsbRequest native_request_wait() {
        UsbRequest request = new UsbRequest();
        request.addTaint(getTaint());
        return request;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.960 -0400", hash_original_method = "7798A12605DD56CE252D35CCA7400682", hash_generated_method = "ABC78903D368E3A02775041EDC3A80F9")
    private String native_get_serial() {
        String str = new String();
        str.addTaint(getTaint());
    	return str;
    }
}

