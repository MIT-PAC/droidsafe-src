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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/routing/HttpRoute.java $
 * $Revision: 653041 $
 * $Date: 2008-05-03 03:39:28 -0700 (Sat, 03 May 2008) $
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


package org.apache.http.conn.routing;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;

import org.apache.http.HttpHost;

public final class HttpRoute implements RouteInfo, Cloneable {

    /**
     * Helper to convert a proxy to a proxy chain.
     *
     * @param proxy     the only proxy in the chain, or <code>null</code>
     *
     * @return  a proxy chain array, or <code>null</code>
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.821 -0500", hash_original_method = "1F6E08AD78395DDC36B17C9725479A05", hash_generated_method = "1CB58370D9C0D265BF2B44F328DE8743")
    
private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null)
            return null;

        return new HttpHost[]{ proxy };
    }

    /**
     * Helper to duplicate and check a proxy chain.
     * An empty proxy chain is converted to <code>null</code>.
     *
     * @param proxies   the proxy chain to duplicate, or <code>null</code>
     *
     * @return  a new proxy chain array, or <code>null</code>
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.824 -0500", hash_original_method = "19BAC4EB9F0AC75365ACA9BCF61634EC", hash_generated_method = "5A47858CE58A0A9E5B3CA3FC60A78C82")
    
private static HttpHost[] toChain(HttpHost[] proxies) {
        if ((proxies == null) || (proxies.length < 1))
            return null;

        for (HttpHost proxy : proxies) {
            if (proxy == null)
                throw new IllegalArgumentException
                        ("Proxy chain may not contain null elements.");
        }

        // copy the proxy chain, the traditional way
        HttpHost[] result = new HttpHost[proxies.length];
        System.arraycopy(proxies, 0, result, 0, proxies.length);

        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.791 -0500", hash_original_field = "905C01B4FE2157113AE81815E13AB5AC", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private  HttpHost targetHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.793 -0500", hash_original_field = "6D0817E97781DDC5DCC8C96F35E70EDB", hash_generated_field = "10EEA7EDCC69FFFCA8BA704DF8B9F4B1")

    private  InetAddress localAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.795 -0500", hash_original_field = "C347087C6B3C58ACC349324C1DD767B1", hash_generated_field = "9682DC3432E3E3ED390A25A380BAA9D2")

    private  HttpHost[] proxyChain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.798 -0500", hash_original_field = "57EDF877C937AB638E451F146941127D", hash_generated_field = "E015AA325755E4410D4EEEB2DE5795E3")

    private  TunnelType tunnelled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.800 -0500", hash_original_field = "5333F91ABB8C106413CA644E1B704E25", hash_generated_field = "54A65546030D5940821BF07A848F0902")

    private  LayerType layered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.802 -0500", hash_original_field = "63DC6869FF37EDAA23661806B080C4ED", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private  boolean secure;

    /**
     * Internal, fully-specified constructor.
     * This constructor does <i>not</i> clone the proxy chain array,
     * nor test it for <code>null</code> elements. This conversion and
     * check is the responsibility of the public constructors.
     * The order of arguments here is different from the similar public
     * constructor, as required by Java.
     *
     * @param local     the local address to route from, or
     *                  <code>null</code> for the default
     * @param target    the host to which to route
     * @param proxies   the proxy chain to use, or
     *                  <code>null</code> for a direct route
     * @param secure    <code>true</code> if the route is (to be) secure,
     *                  <code>false</code> otherwise
     * @param tunnelled the tunnel type of this route, or
     *                  <code>null</code> for PLAIN
     * @param layered   the layering type of this route, or
     *                  <code>null</code> for PLAIN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.806 -0500", hash_original_method = "5CB4C66072DE9146913D6ADB77CB6362", hash_generated_method = "AA3DC1BFB5F421605CC4690C29A41FD1")
    
private HttpRoute(InetAddress local,
                      HttpHost target, HttpHost[] proxies,
                      boolean secure,
                      TunnelType tunnelled, LayerType layered) {
        if (target == null) {
            throw new IllegalArgumentException
                ("Target host may not be null.");
        }
        if ((tunnelled == TunnelType.TUNNELLED) && (proxies == null)) {
            throw new IllegalArgumentException
                ("Proxy required if tunnelled.");
        }

        // tunnelled is already checked above, that is in line with the default
        if (tunnelled == null)
            tunnelled = TunnelType.PLAIN;
        if (layered == null)
            layered = LayerType.PLAIN;

        this.targetHost   = target;
        this.localAddress = local;
        this.proxyChain   = proxies;
        this.secure       = secure;
        this.tunnelled    = tunnelled;
        this.layered      = layered;
    }

    /**
     * Creates a new route with all attributes specified explicitly.
     *
     * @param target    the host to which to route
     * @param local     the local address to route from, or
     *                  <code>null</code> for the default
     * @param proxies   the proxy chain to use, or
     *                  <code>null</code> for a direct route
     * @param secure    <code>true</code> if the route is (to be) secure,
     *                  <code>false</code> otherwise
     * @param tunnelled the tunnel type of this route
     * @param layered   the layering type of this route
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.808 -0500", hash_original_method = "552F6B1597CA5ECF686CDEE0458B0DC7", hash_generated_method = "65EA165C625CAA01135A48B79EA80832")
    
public HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxies), secure, tunnelled, layered);
    }

    /**
     * Creates a new route with at most one proxy.
     *
     * @param target    the host to which to route
     * @param local     the local address to route from, or
     *                  <code>null</code> for the default
     * @param proxy     the proxy to use, or
     *                  <code>null</code> for a direct route
     * @param secure    <code>true</code> if the route is (to be) secure,
     *                  <code>false</code> otherwise
     * @param tunnelled <code>true</code> if the route is (to be) tunnelled
     *                  via the proxy,
     *                  <code>false</code> otherwise
     * @param layered   <code>true</code> if the route includes a
     *                  layered protocol,
     *                  <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.811 -0500", hash_original_method = "65CC9974914C583AD70C403F8621F2C0", hash_generated_method = "FCF10A1E6C0ABE4B35D15076302CD2C3")
    
public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure, TunnelType tunnelled, LayerType layered) {
        this(local, target, toChain(proxy), secure, tunnelled, layered);
    }

    /**
     * Creates a new direct route.
     * That is a route without a proxy.
     *
     * @param target    the host to which to route
     * @param local     the local address to route from, or
     *                  <code>null</code> for the default
     * @param secure    <code>true</code> if the route is (to be) secure,
     *                  <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.813 -0500", hash_original_method = "76AC245ADF42DED69B554EDA9FD556DE", hash_generated_method = "8E31E6F75E82C3AA40CE537898BC3EF1")
    
public HttpRoute(HttpHost target, InetAddress local, boolean secure) {
        this(local, target, null, secure, TunnelType.PLAIN, LayerType.PLAIN);
    }

    /**
     * Creates a new direct insecure route.
     *
     * @param target    the host to which to route
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.816 -0500", hash_original_method = "30B1C0BF43231AE18DB893662C2E010C", hash_generated_method = "D4B4E300345CCB1924DE632578D218C1")
    
public HttpRoute(HttpHost target) {
        this(null, target, null, false, TunnelType.PLAIN, LayerType.PLAIN);
    }

    /**
     * Creates a new route through a proxy.
     * When using this constructor, the <code>proxy</code> MUST be given.
     * For convenience, it is assumed that a secure connection will be
     * layered over a tunnel through the proxy.
     *
     * @param target    the host to which to route
     * @param local     the local address to route from, or
     *                  <code>null</code> for the default
     * @param proxy     the proxy to use
     * @param secure    <code>true</code> if the route is (to be) secure,
     *                  <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.818 -0500", hash_original_method = "BFF1075A3FB2A926B1AAFF01869C54BF", hash_generated_method = "06A2CAA2CE94CEEBEEC08F34ECDDFA86")
    
public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy,
                     boolean secure) {
        this(local, target, toChain(proxy), secure,
             secure ? TunnelType.TUNNELLED : TunnelType.PLAIN,
             secure ? LayerType.LAYERED    : LayerType.PLAIN);
        if (proxy == null) {
            throw new IllegalArgumentException
                ("Proxy host may not be null.");
        }
    }

    // non-JavaDoc, see interface RouteInfo
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.826 -0500", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "3CF09B50D9FFB38E80EC0DF2754F3C7C")
    
public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    // non-JavaDoc, see interface RouteInfo
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.828 -0500", hash_original_method = "28495B9032685860E947A62701D0E919", hash_generated_method = "B1EF19B51880E604C3C8A9B2EC317276")
    
public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    // non-JavaDoc, see interface RouteInfo
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.832 -0500", hash_original_method = "8A1F6C82C6946ABA9036325DB5D1093A", hash_generated_method = "4DD0D1204FDBDD220E5D25DF25995F28")
    
public final int getHopCount() {
        return (proxyChain == null) ? 1 : (proxyChain.length+1);
    }

    // non-JavaDoc, see interface RouteInfo
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.834 -0500", hash_original_method = "6FAF652E1C9EAABAB417C8ED32D41F4A", hash_generated_method = "F5EC67181BAC871CE373A5E2083C59AF")
    
public final HttpHost getHopTarget(int hop) {
        if (hop < 0)
            throw new IllegalArgumentException
                ("Hop index must not be negative: " + hop);
        final int hopcount = getHopCount();
        if (hop >= hopcount)
            throw new IllegalArgumentException
                ("Hop index " + hop +
                 " exceeds route length " + hopcount);

        HttpHost result = null;
        if (hop < hopcount-1)
            result = this.proxyChain[hop];
        else
            result = this.targetHost;

        return result;
    }

    // non-JavaDoc, see interface RouteInfo
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.836 -0500", hash_original_method = "E9E1E8AC6D9C2477F7E0F63BF0C4ED60", hash_generated_method = "30E7E8E67A319853D2C851FAF279DA52")
    
public final HttpHost getProxyHost() {
        return (this.proxyChain == null) ? null : this.proxyChain[0];
    }

    // non-JavaDoc, see interface RouteInfo
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.839 -0500", hash_original_method = "350E5C2EB4A104FE6F444729C8CD5444", hash_generated_method = "34D96FF8C8A24960212FD51CCBD1FAE7")
    
public final TunnelType getTunnelType() {
        return this.tunnelled;
    }

    // non-JavaDoc, see interface RouteInfo
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.841 -0500", hash_original_method = "5CD3D72A708D2B06B9BD542F01F3D0EE", hash_generated_method = "9C3F884A327393840A81C20C66CDA5A9")
    
public final boolean isTunnelled() {
        return (this.tunnelled == TunnelType.TUNNELLED);
    }

    // non-JavaDoc, see interface RouteInfo
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.843 -0500", hash_original_method = "24DDB6A6987422E004B186B027F8E19E", hash_generated_method = "16B0A69A0FDF7D043EE16E0E25CFF1F6")
    
public final LayerType getLayerType() {
        return this.layered;
    }

    // non-JavaDoc, see interface RouteInfo
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.845 -0500", hash_original_method = "90484F935FB331F087FF42A42BD08719", hash_generated_method = "C6CAA6739334D47F3B176C5B89C711DE")
    
public final boolean isLayered() {
        return (this.layered == LayerType.LAYERED);
    }

    // non-JavaDoc, see interface RouteInfo
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.848 -0500", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "D63F92E2829B7A464F6073C5CB36443A")
    
public final boolean isSecure() {
        return this.secure;
    }

    /**
     * Compares this route to another.
     *
     * @param o         the object to compare with
     *
     * @return  <code>true</code> if the argument is the same route,
     *          <code>false</code>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.851 -0500", hash_original_method = "3549831666270A81F0B6433F4C19950E", hash_generated_method = "B688937FF1E04A248504EC0F44AFDA76")
    
@Override
    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HttpRoute))
            return false;

        HttpRoute that = (HttpRoute) o;
        boolean equal = this.targetHost.equals(that.targetHost);
        equal &=
            ( this.localAddress == that.localAddress) ||
            ((this.localAddress != null) &&
              this.localAddress.equals(that.localAddress));
        equal &=
            ( this.proxyChain        == that.proxyChain) ||
            ((this.proxyChain        != null) &&
             (that.proxyChain        != null) &&
             (this.proxyChain.length == that.proxyChain.length));
        // comparison of actual proxies follows below
        equal &=
            (this.secure    == that.secure) &&
            (this.tunnelled == that.tunnelled) &&
            (this.layered   == that.layered);

        // chain length has been compared above, now check the proxies
        if (equal && (this.proxyChain != null)) {
            for (int i=0; equal && (i<this.proxyChain.length); i++)
                equal = this.proxyChain[i].equals(that.proxyChain[i]);
        }

        return equal;
    }

    /**
     * Generates a hash code for this route.
     *
     * @return  the hash code
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.854 -0500", hash_original_method = "BE36FC25647C071258E2596D1C885DDC", hash_generated_method = "E7DD5E17E9CF2A6AA642736E4B8EFE55")
    
@Override
    public final int hashCode() {

        int hc = this.targetHost.hashCode();

        if (this.localAddress != null)
            hc ^= localAddress.hashCode();
        if (this.proxyChain != null) {
            hc ^= proxyChain.length;
            for (HttpHost aProxyChain : proxyChain) hc ^= aProxyChain.hashCode();
        }

        if (this.secure)
            hc ^= 0x11111111;

        hc ^= this.tunnelled.hashCode();
        hc ^= this.layered.hashCode();

        return hc;
    }

    /**
     * Obtains a description of this route.
     *
     * @return  a human-readable representation of this route
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.856 -0500", hash_original_method = "ED2086285AC52BF0F96F27196507174B", hash_generated_method = "9D5086139D65F6BC1FBFA408C4EC6E59")
    
@Override
    public final String toString() {
        StringBuilder cab = new StringBuilder(50 + getHopCount()*30);

        cab.append("HttpRoute[");
        if (this.localAddress != null) {
            cab.append(this.localAddress);
            cab.append("->");
        }
        cab.append('{');
        if (this.tunnelled == TunnelType.TUNNELLED)
            cab.append('t');
        if (this.layered == LayerType.LAYERED)
            cab.append('l');
        if (this.secure)
            cab.append('s');
        cab.append("}->");
        if (this.proxyChain != null) {
            for (HttpHost aProxyChain : this.proxyChain) {
                cab.append(aProxyChain);
                cab.append("->");
            }
        }
        cab.append(this.targetHost);
        cab.append(']');

        return cab.toString();
    }

    // default implementation of clone() is sufficient
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.858 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "49055EB107CA2B05DED5ACBCE67DF575")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}

