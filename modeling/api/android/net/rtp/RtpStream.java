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


package android.net.rtp;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketException;

public class RtpStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.423 -0500", hash_original_field = "A65A69A2ACF32E03502670189C23328B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.425 -0500", hash_original_field = "EAD0B8A875EC4CC171779134FFF1FDCE", hash_generated_field = "5C78E1023A7A1CA7A0757CCCEAB06692")

    public static final int MODE_SEND_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.427 -0500", hash_original_field = "E50B6218BC538B63AAA30AD02DF35A66", hash_generated_field = "251C5A7A5DC286AB55E869C7AB25D149")

    public static final int MODE_RECEIVE_ONLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.430 -0500", hash_original_field = "624981906D3957BB7A810D403B6D53F7", hash_generated_field = "FF9C72AD3D8D30E66745A8A195C5604C")

    private static final int MODE_LAST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.432 -0500", hash_original_field = "5AA4234E9E66795D9BCCFB1883538545", hash_generated_field = "82E160F333ECBB4C3723A32F659FDA5C")

    private  InetAddress mLocalAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.434 -0500", hash_original_field = "FAA97FDD31637F491BEDAC5FB227BAF1", hash_generated_field = "BAE743184ACBAA6741F9878C5CDE5973")

    private  int mLocalPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.436 -0500", hash_original_field = "9B5159A708B66EC0B35B900B7987F83D", hash_generated_field = "CF6A95AED4B072ED0D692D0D05C9CA47")

    private InetAddress mRemoteAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.438 -0500", hash_original_field = "22EFE1D5B3F90C2D2D5EC112FCFEC1D2", hash_generated_field = "A2AF795CC22BFE09F7BFD08F3E1E84C6")

    private int mRemotePort = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.440 -0500", hash_original_field = "19281AD4996A12CF72357927AF42A89F", hash_generated_field = "55D1610407B18FD2194387A7F965838E")

    private int mMode = MODE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.443 -0500", hash_original_field = "D883352313723F88BD080533FB82D9CF", hash_generated_field = "9DD3DA3B4DB5A1786C464E9BB7FF265B")

    private int mNative;

    /**
     * Creates a RtpStream on the given local address. Note that the local
     * port is assigned automatically to conform with RFC 3550.
     *
     * @param address The network address of the local host to bind to.
     * @throws SocketException if the address cannot be bound or a problem
     *     occurs during binding.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.445 -0500", hash_original_method = "87C78188301D65B3202299E6E894F1D3", hash_generated_method = "87C78188301D65B3202299E6E894F1D3")
    
RtpStream(InetAddress address) throws SocketException {
        mLocalPort = create(address.getHostAddress());
        mLocalAddress = address;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.449 -0500", hash_original_method = "215B56CAD65C08D01C00FD356B52B803", hash_generated_method = "2F6FCCBFB3CB44DB4FB1FDD21EF15AF2")
    
    private int create(String address) throws SocketException{
    	//Formerly a native method
    	addTaint(address.getTaint());
    	return getTaintInt();
    }

    /**
     * Returns the network address of the local host.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.451 -0500", hash_original_method = "F28BFDFF195309DBD86E5144551EE7AD", hash_generated_method = "DF44113E6B59CA44A7F42A9D99002DE1")
    
public InetAddress getLocalAddress() {
        return mLocalAddress;
    }

    /**
     * Returns the network port of the local host.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.453 -0500", hash_original_method = "7C31E9E70AC59EA03FD32B04D9A6DCA9", hash_generated_method = "2DF0EB1F58B9B44C339C90A52EA29722")
    
public int getLocalPort() {
        return mLocalPort;
    }

    /**
     * Returns the network address of the remote host or {@code null} if the
     * stream is not associated.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.461 -0500", hash_original_method = "DA9171B440EA3ADB706340063F8102C7", hash_generated_method = "9CF498C475C4F21DB4C831F5FD5926E1")
    
public InetAddress getRemoteAddress() {
        return mRemoteAddress;
    }

    /**
     * Returns the network port of the remote host or {@code -1} if the stream
     * is not associated.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.463 -0500", hash_original_method = "B0A2085CD61C2E0240384F40F555D7FA", hash_generated_method = "C29BA3E5679A16A9A5933B07EF8FAE37")
    
public int getRemotePort() {
        return mRemotePort;
    }

    /**
     * Returns {@code true} if the stream is busy. In this case most of the
     * setter methods are disabled. This method is intended to be overridden
     * by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.465 -0500", hash_original_method = "4ACBB08C3FA83B75B554974AB7F8953B", hash_generated_method = "304C1148E0363C98515A5B9BAA2924FD")
    
public boolean isBusy() {
        return false;
    }

    /**
     * Returns the current mode.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.467 -0500", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "70517447F35CFDB022215DEF7415008A")
    
public int getMode() {
        return mMode;
    }

    /**
     * Changes the current mode. It must be one of {@link #MODE_NORMAL},
     * {@link #MODE_SEND_ONLY}, and {@link #MODE_RECEIVE_ONLY}.
     *
     * @param mode The mode to change to.
     * @throws IllegalArgumentException if the mode is invalid.
     * @throws IllegalStateException if the stream is busy.
     * @see #isBusy()
     */
    @DSComment("can change to send/receive only mode")
    @DSSpec(DSCat.RTP_CALL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.469 -0500", hash_original_method = "343CDE7B48421898D79FEBC0BB9BBA38", hash_generated_method = "28774BF3C6064DA12FC00B4CBCCC590C")
    
public void setMode(int mode) {
        if (isBusy()) {
            throw new IllegalStateException("Busy");
        }
        if (mode < 0 || mode > MODE_LAST) {
            throw new IllegalArgumentException("Invalid mode");
        }
        mMode = mode;
    }

    /**
     * Associates with a remote host. This defines the destination of the
     * outgoing packets.
     *
     * @param address The network address of the remote host.
     * @param port The network port of the remote host.
     * @throws IllegalArgumentException if the address is not supported or the
     *     port is invalid.
     * @throws IllegalStateException if the stream is busy.
     * @see #isBusy()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.471 -0500", hash_original_method = "F6EBFCAAEA10AE181CE86DC5E6420909", hash_generated_method = "913C574D0D0C7F6211EFE2A26B588E71")
    
public void associate(InetAddress address, int port) {
        if (isBusy()) {
            throw new IllegalStateException("Busy");
        }
        if (!(address instanceof Inet4Address && mLocalAddress instanceof Inet4Address) &&
                !(address instanceof Inet6Address && mLocalAddress instanceof Inet6Address)) {
            throw new IllegalArgumentException("Unsupported address");
        }
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port");
        }
        mRemoteAddress = address;
        mRemotePort = port;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.475 -0500", hash_original_method = "CADBAA67E59C58F3A263DE6FDC241D82", hash_generated_method = "15F543B415AA6608CB4F386A014DD60A")
    
    synchronized int dup(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Releases allocated resources. The stream becomes inoperable after calling
     * this method.
     *
     * @throws IllegalStateException if the stream is busy.
     * @see #isBusy()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.477 -0500", hash_original_method = "A307AB09C854328394617118B8488FB4", hash_generated_method = "21D69661C156659C4711B970FA99E9E3")
    
public void release() {
        if (isBusy()) {
            throw new IllegalStateException("Busy");
        }
        close();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.481 -0500", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "68CDF1C3923748EBF018A28718461478")
    
    private synchronized void close(){
    	//Formerly a native method
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.483 -0500", hash_original_method = "2E21A04735F7B7DFBA8D51C21EAA3D5C", hash_generated_method = "478223465B2967B81B6B25A7047A7AB5")
    
@Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
    static {
        System.loadLibrary("rtp_jni");
    }
    
}

