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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/util/ByteArrayBuffer.java $
 * $Revision: 496070 $
 * $Date: 2007-01-14 04:18:34 -0800 (Sun, 14 Jan 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class ByteArrayBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.882 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")
    
    private byte[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.884 -0500", hash_original_field = "EF721EE4D9006031C7456130341457B7", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.887 -0500", hash_original_method = "8E5F8B5095E051129F22BA678563CC37", hash_generated_method = "1C0CA7641CCD8A7A514F44812E2347BD")
    
public ByteArrayBuffer(int capacity) {
        super();
        if (capacity < 0) {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        }
        this.buffer = new byte[capacity]; 
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.889 -0500", hash_original_method = "00DB8B6A06284480D1470563C3051457", hash_generated_method = "A4A97010213E22BCC2359D1D030D23C9")
    
private void expand(int newlen) {
        byte newbuffer[] = new byte[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.891 -0500", hash_original_method = "DA5D0A844C4E68710DCEFB64AE959C3F", hash_generated_method = "38D4ED0A4753B181AA305AF19A32EA00")
    
public void append(final byte[] b, int off, int len) {
        if (b == null) {
            return;
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        int newlen = this.len + len;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        System.arraycopy(b, off, this.buffer, this.len, len);
        this.len = newlen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.893 -0500", hash_original_method = "2CBB81D0688F751ED507CC2CFBAC1CFC", hash_generated_method = "F5FBC68CFFC0021393156AA4FF265B63")
    
public void append(int b) {
        int newlen = this.len + 1;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        this.buffer[this.len] = (byte)b;
        this.len = newlen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.896 -0500", hash_original_method = "46C6F4F43DFE7BB1741326F0CDCC6C04", hash_generated_method = "AB70F533A8A856205574AAFC6DA1C30D")
    
public void append(final char[] b, int off, int len) {
        if (b == null) {
            return;
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        int oldlen = this.len;
        int newlen = oldlen + len;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        for (int i1 = off, i2 = oldlen; i2 < newlen; i1++, i2++) {
            this.buffer[i2] = (byte) b[i1];
        }
        this.len = newlen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.898 -0500", hash_original_method = "2B44500918C17771D87A9839758DBEB3", hash_generated_method = "6B594799A05BD8BDBC195A1558EE6FA4")
    
public void append(final CharArrayBuffer b, int off, int len) {
        if (b == null) {
            return;
        }
        append(b.buffer(), off, len);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.901 -0500", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "CE31F0CC9AFD628B5E4DF48E00CAC375")
    
public void clear() {
        this.len = 0;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.903 -0500", hash_original_method = "1D2E8B5D0002EFCBEC9528FA90BDCD1E", hash_generated_method = "4BE9C0A1CB6703C8061E10B7DEE0AC8F")
    
public byte[] toByteArray() {
        byte[] b = new byte[this.len]; 
        if (this.len > 0) {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        }
        return b;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.905 -0500", hash_original_method = "613A69635B934E492B5C1ACCF6550798", hash_generated_method = "6E65B54FA28120B2CF771B6C78AD3391")
    
public int byteAt(int i) {
        return this.buffer[i];
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.907 -0500", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "092E1610504C66CDED9F24489B6076B3")
    
public int capacity() {
        return this.buffer.length;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.909 -0500", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "7EA025E4C882E2E54C2E95609A3483C0")
    
public int length() {
        return this.len;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.912 -0500", hash_original_method = "7FCD7FDEC66BB92B19CC1167E6D11C2F", hash_generated_method = "BA10C71EE899852EAB3F7B8D5857311F")
    
public byte[] buffer() {
        return this.buffer;
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.914 -0500", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "08BC6C46EBB3779A91B976883B1A5775")
    
public void setLength(int len) {
        if (len < 0 || len > this.buffer.length) {
            throw new IndexOutOfBoundsException();
        }
        this.len = len;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.916 -0500", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "59620F2F45A22D898CF0EBE3C374D8DD")
    
public boolean isEmpty() {
        return this.len == 0; 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.918 -0500", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "D2F9936ECE69C1BB3A0668781B1D8E7E")
    
public boolean isFull() {
        return this.len == this.buffer.length; 
    }
    
}

