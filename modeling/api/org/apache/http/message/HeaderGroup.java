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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/message/HeaderGroup.java $
 * $Revision: 659185 $
 * $Date: 2008-05-22 11:07:36 -0700 (Thu, 22 May 2008) $
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


package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class HeaderGroup implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.684 -0500", hash_original_field = "2E4A517DF74BC5A5A497BA92F88228C9", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;

    /**
     * Constructor for HeaderGroup.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.687 -0500", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "80BF1020C905672ED39C1585D02A9065")
    
public HeaderGroup() {
        this.headers = new ArrayList(16);
    }
    
    /**
     * Removes any contained headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.690 -0500", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "7069691769D07F3822B320ECD25C6539")
    
public void clear() {
        headers.clear();
    }
    
    /**
     * Adds the given header to the group.  The order in which this header was
     * added is preserved.
     * 
     * @param header the header to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.692 -0500", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "72D7D347D6291763DE249E123E7FE4E9")
    
public void addHeader(Header header) {
        if (header == null) {
            return;
        }
        headers.add(header);
    }
    
    /**
     * Removes the given header.
     *
     * @param header the header to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.694 -0500", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "A695EF67F50A2FB4C68804D7D2441400")
    
public void removeHeader(Header header) {
        if (header == null) {
            return;
        }
        headers.remove(header);
    }

    /**
     * Replaces the first occurence of the header with the same name. If no header with 
     * the same name is found the given header is added to the end of the list.
     * 
     * @param header the new header that should replace the first header with the same 
     * name if present in the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.697 -0500", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "DEEE9EFEBB86898438641885D5FFE254")
    
public void updateHeader(Header header) {
        if (header == null) {
            return;
        }
        for (int i = 0; i < this.headers.size(); i++) {
            Header current = (Header) this.headers.get(i);
            if (current.getName().equalsIgnoreCase(header.getName())) {
                this.headers.set(i, header);
                return;
            }
        }
        this.headers.add(header);
    }

    /**
     * Sets all of the headers contained within this group overriding any
     * existing headers. The headers are added in the order in which they appear
     * in the array.
     * 
     * @param headers the headers to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.700 -0500", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "1983362DCCA6E8EF783A08E5B3EAA075")
    
public void setHeaders(Header[] headers) {
        clear();
        if (headers == null) {
            return;
        }
        for (int i = 0; i < headers.length; i++) {
            this.headers.add(headers[i]);
        }
    }
    
    /**
     * Gets a header representing all of the header values with the given name.
     * If more that one header with the given name exists the values will be
     * combined with a "," as per RFC 2616.
     * 
     * <p>Header name comparison is case insensitive.
     * 
     * @param name the name of the header(s) to get
     * @return a header with a condensed value or <code>null</code> if no
     * headers by the given name are present
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.703 -0500", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "17F3700C3F9D9282BC3E697F5474C783")
    
public Header getCondensedHeader(String name) {
        Header[] headers = getHeaders(name);
        
        if (headers.length == 0) {
            return null;   
        } else if (headers.length == 1) {
            return headers[0];
        } else {
            CharArrayBuffer valueBuffer = new CharArrayBuffer(128);
            valueBuffer.append(headers[0].getValue());
            for (int i = 1; i < headers.length; i++) {
                valueBuffer.append(", ");
                valueBuffer.append(headers[i].getValue());
            }
            
            return new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
        }
    }
    
    /**
     * Gets all of the headers with the given name.  The returned array
     * maintains the relative order in which the headers were added.  
     * 
     * <p>Header name comparison is case insensitive.
     * 
     * @param name the name of the header(s) to get
     * 
     * @return an array of length >= 0
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.706 -0500", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "A9F2B5A82F6968B911F5F0EBD08FBDDB")
    
public Header[] getHeaders(String name) {
        ArrayList headersFound = new ArrayList();
        
        for (int i = 0; i < headers.size(); i++) {
            Header header = (Header) headers.get(i);
            if (header.getName().equalsIgnoreCase(name)) {
                headersFound.add(header);
            }
        }
        
        return (Header[]) headersFound.toArray(new Header[headersFound.size()]);
    }
    
    /**
     * Gets the first header with the given name.
     * 
     * <p>Header name comparison is case insensitive.
     * 
     * @param name the name of the header to get
     * @return the first header or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.709 -0500", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "F35F2A4913636C76F8DC70536FD5AF2B")
    
public Header getFirstHeader(String name) {
        for (int i = 0; i < headers.size(); i++) {
            Header header = (Header) headers.get(i);
            if (header.getName().equalsIgnoreCase(name)) {
                return header;
            }
        }
        return null;                
    }
    
    /**
     * Gets the last header with the given name.
     *
     * <p>Header name comparison is case insensitive.
     *
     * @param name the name of the header to get
     * @return the last header or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.712 -0500", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "534C6B0FE21792E4C5117DE7A0A24EFB")
    
public Header getLastHeader(String name) {
        // start at the end of the list and work backwards
        for (int i = headers.size() - 1; i >= 0; i--) {
            Header header = (Header) headers.get(i);
            if (header.getName().equalsIgnoreCase(name)) {
                return header;
            }            
        }
        
        return null;        
    }
    
    /**
     * Gets all of the headers contained within this group.
     * 
     * @return an array of length >= 0
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.715 -0500", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "3FBF8A33AF0B807B8E3CE9C8312BD52A")
    
public Header[] getAllHeaders() {
        return (Header[]) headers.toArray(new Header[headers.size()]);
    }
    
    /**
     * Tests if headers with the given name are contained within this group.
     * 
     * <p>Header name comparison is case insensitive.
     * 
     * @param name the header name to test for
     * @return <code>true</code> if at least one header with the name is
     * contained, <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.717 -0500", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "C72D96C65490338F57465927F7F16D28")
    
public boolean containsHeader(String name) {
        for (int i = 0; i < headers.size(); i++) {
            Header header = (Header) headers.get(i);
            if (header.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Returns an iterator over this group of headers.
     * 
     * @return iterator over this group of headers.
     * 
     * @since 4.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.719 -0500", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "179E52FF784C1E5BDEE0266C9CB06A11")
    
public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null); 
    }

    /**
     * Returns an iterator over the headers with a given name in this group.
     *
     * @param name      the name of the headers over which to iterate, or
     *                  <code>null</code> for all headers
     *
     * @return iterator over some headers in this group.
     * 
     * @since 4.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.722 -0500", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "1545E9812E7EBED1F33C8B8846F343C2")
    
public HeaderIterator iterator(final String name) {
        return new BasicListHeaderIterator(this.headers, name);
    }
    
    /**
     * Returns a copy of this object
     * 
     * @return copy of this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.724 -0500", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "0C39C85BC19025CB510FC9F307AE3C08")
    
public HeaderGroup copy() {
        HeaderGroup clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
        return clone;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.726 -0500", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "57896E141642EF4108BBA152F7A67F9A")
    
public Object clone() throws CloneNotSupportedException {
        HeaderGroup clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
        return clone;
    }
    
}

