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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.cert.X509Certificate;

public class SslError {

    /**
     * Creates an SslError object from a chromium error code.
     * @param error The chromium error code
     * @param certificate The associated SSL certificate
     * @param url The associated URL.
     * @hide  chromium error codes only available inside the framework
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.924 -0500", hash_original_method = "716CBCE4AB0F7ADAAF42E1058B3670D3", hash_generated_method = "7F7D7D86D524AAD7E8C66FE00232F9B6")
    
public static SslError SslErrorFromChromiumErrorCode(
            int error, SslCertificate cert, String url) {
        // The chromium error codes are in:
        // external/chromium/net/base/net_error_list.h
        assert (error >= -299 && error <= -200);
        if (error == -200)
            return new SslError(SSL_IDMISMATCH, cert, url);
        if (error == -201)
            return new SslError(SSL_DATE_INVALID, cert, url);
        if (error == -202)
            return new SslError(SSL_UNTRUSTED, cert, url);
        // Map all other codes to SSL_INVALID.
        return new SslError(SSL_INVALID, cert, url);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.891 -0500", hash_original_field = "DBF573717E17662ED7925EFDD2206892", hash_generated_field = "98A5DE4C552BB718DC28B549CC1CEF0F")

    /**
     * The certificate is not yet valid
     */
    public static final int SSL_NOTYETVALID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.893 -0500", hash_original_field = "DCD670B10C02ADFF9D7A790AEF5B4C18", hash_generated_field = "BAAD9CBD08CD0D2093B10402B8464A98")

    public static final int SSL_EXPIRED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.895 -0500", hash_original_field = "7671F305F52F8898C557BE3397CDAD4C", hash_generated_field = "13B7485113DA8A602D91A2F53C58C15F")

    public static final int SSL_IDMISMATCH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.898 -0500", hash_original_field = "88C32EEB61154412B7C94580A3FC70A1", hash_generated_field = "0E952E7AEE36B79768B89A0EECDF70AB")

    public static final int SSL_UNTRUSTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.900 -0500", hash_original_field = "97C5CA17151004AE59B377B7F1DBD362", hash_generated_field = "7A71850528D1C5A05BCC2F8DAA5B23B9")

    public static final int SSL_DATE_INVALID = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.902 -0500", hash_original_field = "342BE1889DB7D0012D0638358C7F19B2", hash_generated_field = "37C2C751255A73F019D90F63D8AA6D24")

    public static final int SSL_INVALID = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.905 -0500", hash_original_field = "FFBD4193E7D552FA254F19C7BD95ADF9", hash_generated_field = "05536199E2FB1590243D805B1451A024")

    // Update if you add a new SSL error!!!
    @Deprecated
    public static final int SSL_MAX_ERROR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.907 -0500", hash_original_field = "A1A4B77C81BB0C0C3F4262BD3992D7FD", hash_generated_field = "A1A4B77C81BB0C0C3F4262BD3992D7FD")

    int mErrors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.909 -0500", hash_original_field = "8722B9770017213537D317FB65A9919D", hash_generated_field = "8722B9770017213537D317FB65A9919D")

     SslCertificate mCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.912 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

     String mUrl;

    /**
     * Creates a new SslError object using the supplied error and certificate.
     * The URL will be set to the empty string.
     * @param error The SSL error
     * @param certificate The associated SSL certificate
     * @deprecated Use {@link #SslError(int, SslCertificate, String)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.915 -0500", hash_original_method = "E54E1790034E06C2564EA8F8D322C604", hash_generated_method = "4A4D6596F1AA464E59CD29757B0A54BF")
    
@Deprecated
    public SslError(int error, SslCertificate certificate) {
        this(error, certificate, "");
    }

    /**
     * Creates a new SslError object using the supplied error and certificate.
     * The URL will be set to the empty string.
     * @param error The SSL error
     * @param certificate The associated SSL certificate
     * @deprecated Use {@link #SslError(int, X509Certificate, String)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.917 -0500", hash_original_method = "D4D6A5236E4F49764789FE2E4242FD0D", hash_generated_method = "6FE3E50244FC16A4647325ADA5662A76")
    
@Deprecated
    public SslError(int error, X509Certificate certificate) {
        this(error, certificate, "");
    }

    /**
     * Creates a new SslError object using the supplied error, certificate and
     * URL.
     * @param error The SSL error
     * @param certificate The associated SSL certificate
     * @param url The associated URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.919 -0500", hash_original_method = "85B2ECB0DBC9283B8022F29E2B26DB48", hash_generated_method = "A8122BC610EA1EF78595F1EE0935AEEF")
    
public SslError(int error, SslCertificate certificate, String url) {
        assert certificate != null;
        assert url != null;
        addError(error);
        mCertificate = certificate;
        mUrl = url;
    }

    /**
     * Creates a new SslError object using the supplied error, certificate and
     * URL.
     * @param error The SSL error
     * @param certificate The associated SSL certificate
     * @param url The associated URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.922 -0500", hash_original_method = "3533EE541F404B8ADD4D4E5426E464A7", hash_generated_method = "7D9B5E9F1FEE696689A666EB95FD65F5")
    
public SslError(int error, X509Certificate certificate, String url) {
        this(error, new SslCertificate(certificate), url);
    }

    /**
     * Gets the SSL certificate associated with this object.
     * @return The SSL certificate, non-null.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.927 -0500", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "2A53C857BC2F74C73D597759713CC1E0")
    
public SslCertificate getCertificate() {
        return mCertificate;
    }

    /**
     * Gets the URL associated with this object.
     * @return The URL, non-null.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.929 -0500", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "B64A7CF604F22C84E5CFF07E83B9389F")
    
public String getUrl() {
        return mUrl;
    }

    /**
     * Adds the supplied SSL error to the set.
     * @param error The SSL error to add
     * @return True if the error being added is a known SSL error, otherwise
     *         false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.931 -0500", hash_original_method = "AE664F52BD7226DBAA3D1D1034C9653E", hash_generated_method = "40AF093ECF595321C0D30F523CF4A847")
    
public boolean addError(int error) {
        boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        if (rval) {
            mErrors |= (0x1 << error);
        }

        return rval;
    }

    /**
     * Determines whether this object includes the supplied error.
     * @param error The SSL error to check for
     * @return True if this object includes the error, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.933 -0500", hash_original_method = "B3A224AA064D57107491E8991A407E79", hash_generated_method = "B17AB845B2A2BD4BDE544034E2666B99")
    
public boolean hasError(int error) {
        boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        if (rval) {
            rval = ((mErrors & (0x1 << error)) != 0);
        }

        return rval;
    }

    /**
     * Gets the most severe SSL error in this object's set of errors.
     * Returns -1 if the set is empty.
     * @return The most severe SSL error, or -1 if the set is empty.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.936 -0500", hash_original_method = "3A5499989FF366B2E4D135ECA3891E4C", hash_generated_method = "270D5F33BC3111844A7C6690511A252A")
    
public int getPrimaryError() {
        if (mErrors != 0) {
            // go from the most to the least severe errors
            for (int error = SslError.SSL_MAX_ERROR - 1; error >= 0; --error) {
                if ((mErrors & (0x1 << error)) != 0) {
                    return error;
                }
            }
            // mErrors should never be set to an invalid value.
            assert false;
        }

        return -1;
    }

    /**
     * Returns a string representation of this object.
     * @return A String representation of this object.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.938 -0500", hash_original_method = "18A0C6CD1FD66E60B7FF0A9F205CF54C", hash_generated_method = "B5384DD3FDF574EF210A93042D49C1B6")
    
public String toString() {
        return "primary error: " + getPrimaryError() +
                " certificate: " + getCertificate() +
                " on URL: " + getUrl();
    }
}

