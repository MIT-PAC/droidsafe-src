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
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/
/*******************************************************************************
 * Product of NIST/ITL Advanced Networking Technologies Division (ANTD).        *
 *******************************************************************************/

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public final class HopImpl extends Object implements javax.sip.address.Hop, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.500 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.503 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.506 -0500", hash_original_field = "852FD1938B4FCA59C0635E9D670A8D0B", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.508 -0500", hash_original_field = "F3E57CC0F4AB52C671E49FF0AA34F97D", hash_generated_field = "507947F99EFE636A32340E3AA843BB3D")

    protected boolean defaultRoute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.511 -0500", hash_original_field = "23977287DDC38735EB863B08ABDBBD4E", hash_generated_field = "F6D3A083A27E3AA80C885284DEF016AB")

    protected boolean uriRoute;

    /**
     * Create new hop given host, port and transport.
     * @param hostName hostname
     * @param portNumber port
     * @param trans transport
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.517 -0500", hash_original_method = "0B5C776E3038172CE320CE66ECCB4725", hash_generated_method = "F1E8DD31974A88EA2B2A7C28D7F65EC3")
    
public HopImpl(String hostName, int portNumber, String trans) {
        host = hostName;

        // Added by Daniel J. Martinez Manzano <dani@dif.um.es>
        // for correct management of IPv6 addresses.
        if(host.indexOf(":") >= 0)
            if(host.indexOf("[") < 0)
                host = "[" + host + "]";

        port = portNumber;
        transport = trans;
    }

    /**
     * Creates new Hop
     * @param hop is a hop string in the form of host:port/Transport
     * @throws IllegalArgument exception if string is not properly formatted or null.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.521 -0500", hash_original_method = "54879B5E9B62042FEEDC1EE4ADCFBB66", hash_generated_method = "019781F3234A40E57E115A2ACF307C37")
    
HopImpl(String hop) throws IllegalArgumentException {

        if (hop == null)
            throw new IllegalArgumentException("Null arg!");

        // System.out.println("hop = " + hop);
        int brack = hop.indexOf(']');
        int colon = hop.indexOf(':',brack);
        int slash = hop.indexOf('/',colon);

        if (colon>0) {
            this.host = hop.substring(0,colon);
            String portstr;
            if (slash>0) {
                portstr = hop.substring(colon+1,slash);
                this.transport = hop.substring(slash+1);
            } else {
                portstr = hop.substring(colon+1);
                this.transport = "UDP";
            }
            try {
                port = Integer.parseInt(portstr);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Bad port spec");
            }
        } else {
            if (slash>0) {
                this.host = hop.substring(0,slash);
                this.transport = hop.substring(slash+1);
                this.port = transport.equalsIgnoreCase("TLS") ? 5061 : 5060;
            } else {
                this.host = hop;
                this.transport = "UDP";
                this.port = 5060;
            }
        }

        // Validate it
        if (host == null || host.length() == 0)
            throw new IllegalArgumentException("no host!");

        // normalize
        this.host = this.host.trim();
        this.transport = this.transport.trim();

        if ((brack>0) && host.charAt(0)!='[') {
            throw new IllegalArgumentException("Bad IPv6 reference spec");
        }

        if (transport.compareToIgnoreCase("UDP") != 0
            && transport.compareToIgnoreCase("TLS") != 0
            && transport.compareToIgnoreCase("TCP") != 0) {
            System.err.println("Bad transport string " + transport);
            throw new IllegalArgumentException(hop);
        }
    } // This is extracted from the requestURI.

    /**
     * Debugging println.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.513 -0500", hash_original_method = "E930BE940ED709A9E92F64EC28520C28", hash_generated_method = "1DACE3572478DC85AF10A7AB44445DA6")
    
public String toString() {
        return host + ":" + port + "/" + transport;
    }

    /**
     * Retruns the host string.
     * @return host String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.524 -0500", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1B655222E0C0F88C57DF58BCA9BFA498")
    
public String getHost() {
        return host;
    }

    /**
     * Returns the port.
     * @return port integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.528 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /** returns the transport string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.530 -0500", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "00BA105A025E226F3C987987A5F86CDE")
    
public String getTransport() {
        return transport;
    }

    /** Return true if this is uriRoute
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.533 -0500", hash_original_method = "7B7F5CA7C760A6206185BE96F86E54F2", hash_generated_method = "A35E3DDDC5BAEC620248E657DBB8D9F5")
    
public boolean isURIRoute() {
        return uriRoute;
    }

    /** Set the URIRoute flag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:12.536 -0500", hash_original_method = "4D177A2C7A5E9A8C62FF46DC5D4CFB65", hash_generated_method = "176A878D304771B2B25F8A3AEA362701")
    
public void setURIRouteFlag() {
        uriRoute = true;
    }
    
}

