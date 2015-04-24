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
import java.nio.ByteBuffer;

public class UsbRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.306 -0500", hash_original_field = "0A666047707090CD02214402D36F11D4", hash_generated_field = "3C8DCB2CD5AFF3FA01F8DBE0209B4F99")

    private static final String TAG = "UsbRequest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.309 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.311 -0500", hash_original_field = "C5ED3A9B7C6D24194D51BC689B4B6561", hash_generated_field = "51493E5AC33E198B7B9441D1D3BB0C49")

    private UsbEndpoint mEndpoint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.314 -0500", hash_original_field = "FB05545F4651BAFFFA13E88DBDCA5C94", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.316 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.318 -0500", hash_original_field = "A2ADCC464AC7B6E895A87049B40001C7", hash_generated_field = "56DE82683B5639E270394910BD52C921")

    private Object mClientData;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.322 -0500", hash_original_method = "1841EBA816AAD9B3CFCC9CFB82F138AB", hash_generated_method = "29EDDA0A00AD55F3A076CC16100CFCF0")
    
public UsbRequest() {
    }

    /**
     * Initializes the request so it can read or write data on the given endpoint.
     * Whether the request allows reading or writing depends on the direction of the endpoint.
     *
     * @param endpoint the endpoint to be used for this request.
     * @return true if the request was successfully opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.324 -0500", hash_original_method = "5DC7CF12AEC4C5E9E1FB850AF7C3FB90", hash_generated_method = "AB117DFD5F544F43BDCBD699AD4AE5E4")
    
public boolean initialize(UsbDeviceConnection connection, UsbEndpoint endpoint) {
        mEndpoint = endpoint;
        return native_init(connection, endpoint.getAddress(), endpoint.getAttributes(),
                endpoint.getMaxPacketSize(), endpoint.getInterval());
    }

    /**
     * Releases all resources related to this request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.327 -0500", hash_original_method = "66833AAE0F898EE53D028F2100A5AAE5", hash_generated_method = "C0B04AAB3D76479962705FC3E15B7873")
    
public void close() {
        mEndpoint = null;
        native_close();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.329 -0500", hash_original_method = "7540A3E8E0E84BC6100A5A4AAC882F22", hash_generated_method = "37FF0A01C8FBB622D7037424FE6C4F69")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mEndpoint != null) {
                Log.v(TAG, "endpoint still open in finalize(): " + this);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    /**
     * Returns the endpoint for the request, or null if the request is not opened.
     *
     * @return the request's endpoint
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.331 -0500", hash_original_method = "11B9FE3CCFCADE645E006FF088DA13C2", hash_generated_method = "ADFFE8A8AC04ADC6B04E795AB85C6E96")
    
public UsbEndpoint getEndpoint() {
        return mEndpoint;
    }

    /**
     * Returns the client data for the request.
     * This can be used in conjunction with {@link #setClientData}
     * to associate another object with this request, which can be useful for
     * maintaining state between calls to {@link #queue} and
     * {@link android.hardware.usb.UsbDeviceConnection#requestWait}
     *
     * @return the client data for the request
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.333 -0500", hash_original_method = "B71E58093DB1269AF1945AD07DDB8F74", hash_generated_method = "DD564BC4489E431F910BDF304B9F4280")
    
public Object getClientData() {
        return mClientData;
    }

    /**
     * Sets the client data for the request.
     * This can be used in conjunction with {@link #getClientData}
     * to associate another object with this request, which can be useful for
     * maintaining state between calls to {@link #queue} and
     * {@link android.hardware.usb.UsbDeviceConnection#requestWait}
     *
     * @param data the client data for the request
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.336 -0500", hash_original_method = "D9B34A9E5333EFBBF13F29A3015D9990", hash_generated_method = "912908EFC84020B322117D9846CF03D1")
    
public void setClientData(Object data) {
        mClientData = data;
    }

    /**
     * Queues the request to send or receive data on its endpoint.
     * For OUT endpoints, the given buffer data will be sent on the endpoint.
     * For IN endpoints, the endpoint will attempt to read the given number of bytes
     * into the specified buffer.
     * If the queueing operation is successful, we return true and the result will be
     * returned via {@link android.hardware.usb.UsbDeviceConnection#requestWait}
     *
     * @param buffer the buffer containing the bytes to write, or location to store
     * the results of a read
     * @param length number of bytes to read or write
     * @return true if the queueing operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.339 -0500", hash_original_method = "0AB508D5F9E406998904FC2F468636F7", hash_generated_method = "55C23BE676606CB343FBCFD9F57A59FD")
    @DSSink({DSSinkKind.USB})
public boolean queue(ByteBuffer buffer, int length) {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        boolean result;
        if (buffer.isDirect()) {
            result = native_queue_direct(buffer, length, out);
        } else if (buffer.hasArray()) {
            result = native_queue_array(buffer.array(), length, out);
        } else {
            throw new IllegalArgumentException("buffer is not direct and has no array");
        }
        if (result) {
            // save our buffer for when the request has completed
            mBuffer = buffer;
            mLength = length;
        }
        return result;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.342 -0500", hash_original_method = "AD7D73F051931557C02FDFDEB6B3C889", hash_generated_method = "AD7D73F051931557C02FDFDEB6B3C889")
     
void dequeue() {
        boolean out = (mEndpoint.getDirection() == UsbConstants.USB_DIR_OUT);
        if (mBuffer.isDirect()) {
            native_dequeue_direct();
        } else {
            native_dequeue_array(mBuffer.array(), mLength, out);
        }
        mBuffer = null;
        mLength = 0;
    }

    /**
     * Cancels a pending queue operation.
     *
     * @return true if cancelling succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.344 -0500", hash_original_method = "C6E3D4490B2BE3A7CABB292DA8889494", hash_generated_method = "E479441811656982FFCD05CE3882A748")
    
public boolean cancel() {
        return native_cancel();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.348 -0500", hash_original_method = "088D546DD8E640FE6DF053A8179CD4B6", hash_generated_method = "96B1EC5E351A412E42A0869292B30718")
    
    private boolean native_init(UsbDeviceConnection connection, int ep_address,
                int ep_attributes, int ep_max_packet_size, int ep_interval){
    	//Formerly a native method
    	addTaint(connection.getTaint());
    	addTaint(ep_address);
    	addTaint(ep_attributes);
    	addTaint(ep_max_packet_size);
    	addTaint(ep_interval);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.352 -0500", hash_original_method = "6753B93585F19A7AC1519FB4DFF90D14", hash_generated_method = "75E92DEDBEC5DB3628B1DCB207D9511C")
    
    private void native_close(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.356 -0500", hash_original_method = "7F13ABFE9FDE97F40DC7842504BAE184", hash_generated_method = "848D1C3001A3E57AE686BC5E67E0400B")
    
    private boolean native_queue_array(byte[] buffer, int length, boolean out){
    	//Formerly a native method
    	addTaint(buffer[0]);
    	addTaint(length);
    	addTaint(out);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.360 -0500", hash_original_method = "3BDF4594393C8A1BD126F313DABD0D0F", hash_generated_method = "D07158364E2EB906374A1E3E5686864B")
    
    private void native_dequeue_array(byte[] buffer, int length, boolean out){
    	//Formerly a native method
    	addTaint(buffer[0]);
    	addTaint(length);
    	addTaint(out);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.364 -0500", hash_original_method = "E7AB577A437B8CBAAC35FF91F8C41F2B", hash_generated_method = "75F7D1CA6AB699DAF7160FBB5EC71A28")
    
    private boolean native_queue_direct(ByteBuffer buffer, int length, boolean out){
    	//Formerly a native method
    	addTaint(buffer.getTaint());
    	addTaint(length);
    	addTaint(out);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.369 -0500", hash_original_method = "558CB787B8354E17E879C85035FE4714", hash_generated_method = "A217BB589FEBA7A9BF2BFF19BE2AE436")
    
    private void native_dequeue_direct(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:51.372 -0500", hash_original_method = "EF977425574389A96D73B721035A87F5", hash_generated_method = "B3F49E05D7D870D57BD4C5FD22E181C9")
    
    private boolean native_cancel(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

}

