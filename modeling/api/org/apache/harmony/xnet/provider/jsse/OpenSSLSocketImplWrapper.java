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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class OpenSSLSocketImplWrapper extends OpenSSLSocketImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.921 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.923 -0500", hash_original_method = "AE2ACFC3381FF02B6F42819ACFB99347", hash_generated_method = "8BDA538BD3961C8AF9706BD8798186A3")
    
protected OpenSSLSocketImplWrapper(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        super(socket, host, port, autoClose, sslParameters);
        if (!socket.isConnected()) {
            throw new SocketException("Socket is not connected.");
        }
        this.socket = socket;
    }
    
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.926 -0500", hash_original_method = "00D15638ACD466799C761D85B34B76D1", hash_generated_method = "318B16BF8497A493582ED5394CA2D122")
    
@Override
    public void connect(SocketAddress sockaddr, int timeout)
        throws IOException {
        throw new IOException("Underlying socket is already connected.");
    }
    
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.928 -0500", hash_original_method = "EAF5C6F0CD11B02972408C1904067F09", hash_generated_method = "5AB26808CFD3AAFCE9C50BE8E4832631")
    
@Override
    public void connect(SocketAddress sockaddr) throws IOException {
        throw new IOException("Underlying socket is already connected.");
    }
    
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.930 -0500", hash_original_method = "7A09B0BAD685B79E09A501FC300262C5", hash_generated_method = "4641B5E3CF42BCCB903380F0F6DB8DB3")
    
@Override
    public void bind(SocketAddress sockaddr) throws IOException {
        throw new IOException("Underlying socket is already connected.");
    }

    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.933 -0500", hash_original_method = "3943DC2A7B0758DBF52393C8C56EA577", hash_generated_method = "C040EF3FF2D307F2C379CD6A1919BD79")
    
@Override
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.935 -0500", hash_original_method = "8FA3564BB5CFB45123B15A784733B246", hash_generated_method = "4D7E8AC3029FC63D94BBD7C15D05C71B")
    
@Override
    public SocketAddress getLocalSocketAddress() {
        return socket.getLocalSocketAddress();
    }

    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.937 -0500", hash_original_method = "FA66787E9EF6408AFBBAC830990D81DD", hash_generated_method = "0DED15F899B7565F50B31AD8F52F97D2")
    
@Override
    public InetAddress getLocalAddress() {
        return socket.getLocalAddress();
    }

    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.940 -0500", hash_original_method = "7C5B0DF8424BA5B1A7E73E96C6697260", hash_generated_method = "4AAC50E14DA9595E4F76424EB06A06AE")
    
@Override
    public InetAddress getInetAddress() {
        return socket.getInetAddress();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.942 -0500", hash_original_method = "20064C2DA65D137C2E5BEE76E0D7F046", hash_generated_method = "415179180B4BE9CF500075793507191E")
    
@Override
    public String toString() {
        return "SSL socket over " + socket.toString();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.945 -0500", hash_original_method = "BA6A863821CC6E272D69FAD304054330", hash_generated_method = "CF295742065C95EF4C2291A2441BD2F4")
    
@Override
    public void setSoLinger(boolean on, int linger) throws SocketException {
        socket.setSoLinger(on, linger);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.947 -0500", hash_original_method = "6AD7B97F2FA9AF7B8D3F27597107B2BF", hash_generated_method = "E38CDAC51F0AE0D04C06CC4C93C73513")
    
@Override
    public void setTcpNoDelay(boolean on) throws SocketException {
        socket.setTcpNoDelay(on);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.949 -0500", hash_original_method = "D83D710E6441AF70333DBDC9EA6830A9", hash_generated_method = "35FC2FB42C15753AC682F54F0D8B59D0")
    
@Override
    public void setReuseAddress(boolean on) throws SocketException {
        socket.setReuseAddress(on);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.952 -0500", hash_original_method = "42F0A197FBCF742A135D89D6FE12DB15", hash_generated_method = "9371CDAA7E0118D8AB30BE4A5C849E31")
    
@Override
    public void setKeepAlive(boolean on) throws SocketException {
        socket.setKeepAlive(on);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.954 -0500", hash_original_method = "F7B57673F6A99B49112F94E152729E53", hash_generated_method = "22708E19EE5AF8B482DC858685469DC3")
    
@Override
    public void setTrafficClass(int tos) throws SocketException {
        socket.setTrafficClass(tos);
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSSpec(DSCat.INTERNET)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.956 -0500", hash_original_method = "C6CB523E9BEBBF3CF2CBCDA94ED50C2A", hash_generated_method = "6BA461BD87F4524E979F9BB5555D0B75")
    
@Override
    public void setSoTimeout(int to) throws SocketException {
        socket.setSoTimeout(to);
        super.setSoTimeout(to);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.958 -0500", hash_original_method = "A6ECFC0810DB8197115B82176EC6BB66", hash_generated_method = "354E312C641E673D0E268A306BF64632")
    
@Override
    public void setSendBufferSize(int size) throws SocketException {
        socket.setSendBufferSize(size);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.961 -0500", hash_original_method = "D35B240A928EE0976B61520D6F633EA5", hash_generated_method = "E5A4E7DE32456ABBE48BA105746391DD")
    
@Override
    public void setReceiveBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.963 -0500", hash_original_method = "39F09AC39D817ADEB5123B039A643360", hash_generated_method = "DE2685EB07F5D5643B3890F295EBB028")
    
@Override
    public boolean getTcpNoDelay() throws SocketException {
        return socket.getTcpNoDelay();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.965 -0500", hash_original_method = "58E21075EC516F7123DEFDBD3078B712", hash_generated_method = "771935077B0D9AD9B783C1E37C61ABB5")
    
@Override
    public boolean getReuseAddress() throws SocketException {
        return socket.getReuseAddress();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.969 -0500", hash_original_method = "9B8ADFEACD0A0CF83F6F88016C1BFEBF", hash_generated_method = "6761AD68BAD9126901355D30D8848E5F")
    
@Override
    public boolean getOOBInline() throws SocketException {
        return socket.getOOBInline();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.971 -0500", hash_original_method = "DBBF1E3C1E2C35CEF53EE178C75A5FA3", hash_generated_method = "2E488E44381FC451701DAADC3C51C17D")
    
@Override
    public boolean getKeepAlive() throws SocketException {
        return socket.getKeepAlive();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.973 -0500", hash_original_method = "CA06E10BC8D1A46A5EC1742C20A8F3A9", hash_generated_method = "CBF8A7D2175521421252307F39165038")
    
@Override
    public int getTrafficClass() throws SocketException {
        return socket.getTrafficClass();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.975 -0500", hash_original_method = "010C724B642A1F7D7909AEF3BDB55CFF", hash_generated_method = "C0B0350003A3FA81B582358EAB00E8F7")
    
@Override
    public int getSoTimeout() throws SocketException {
        return socket.getSoTimeout();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.978 -0500", hash_original_method = "8ECD41C257976189A03EEB5A2F2A2061", hash_generated_method = "FEB351F213C6127D77EC949582DC6B4E")
    
@Override
    public int getSoLinger() throws SocketException {
        return socket.getSoLinger();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.980 -0500", hash_original_method = "6DB456EA6159E594EA1D8C2937517626", hash_generated_method = "B4E809A914848714055AAA2DFA94C2B9")
    
@Override
    public int getSendBufferSize() throws SocketException {
        return socket.getSendBufferSize();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.982 -0500", hash_original_method = "093818CB55F5B0F2E1248EF2E19EB4D0", hash_generated_method = "7D51F58C3EF83D84E517ACC1FFDBEEB7")
    
@Override
    public int getReceiveBufferSize() throws SocketException {
        return socket.getReceiveBufferSize();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.984 -0500", hash_original_method = "EC1EF38CAA1E7F260C803E9C132BF1AD", hash_generated_method = "735FCD6800F8A33427A0AEFB6211123E")
    
@Override
    public boolean isConnected() {
        return socket.isConnected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.986 -0500", hash_original_method = "F9546A6C2D000DC4C97CDD10C3014895", hash_generated_method = "E4681B6D5608E9CECACF6C58056522E0")
    
@Override
    public boolean isClosed() {
        return socket.isClosed();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.989 -0500", hash_original_method = "8EA49BE4F5DCAEDF32C6C22D5F856F5E", hash_generated_method = "356C68768A8C8FF42FED03E152362829")
    
@Override
    public boolean isBound() {
        return socket.isBound();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.991 -0500", hash_original_method = "51808AB98F30ED89EC1017AD205567F5", hash_generated_method = "0BC3B4A0728A8C43FC0305D661B1DEEA")
    
@Override
    public boolean isOutputShutdown() {
        return socket.isOutputShutdown();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.993 -0500", hash_original_method = "28A9E9140AE8CAAEAFACC4EC7AFA7A9E", hash_generated_method = "8BAC13764309E0ABE21ACE9733537F39")
    
@Override
    public boolean isInputShutdown() {
        return socket.isInputShutdown();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.996 -0500", hash_original_method = "9202DEAEF4A83D1AC2B8E9A1BC72C67F", hash_generated_method = "11F0C724DD23B8BB7B6229DE2ECA83E3")
    
@Override
    public int getPort() {
        return socket.getPort();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:08.999 -0500", hash_original_method = "8F87ED59A6F41F0CC7A13A5B3C7FF765", hash_generated_method = "A845AF79A94301585E8921CDCEB23C13")
    
@Override
    public int getLocalPort() {
        return socket.getLocalPort();
    }
    
}

