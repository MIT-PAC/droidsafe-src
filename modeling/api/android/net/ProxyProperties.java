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


package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetSocketAddress;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ProxyProperties implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.167 -0400", hash_original_field = "8C1BCA5A763B1D293459FDC94947A9DA", hash_generated_field = "37B61C5F5B74C5B267912D84DAC98E0A")

    public static final Creator<ProxyProperties> CREATOR =
        new Creator<ProxyProperties>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.188 -0500", hash_original_method = "A76B576B418A59DA79A74A0B4EFE2DF1", hash_generated_method = "02E09D2E48F74DDE3B43A8B05AED4246")
        
public ProxyProperties createFromParcel(Parcel in) {
                String host = null;
                int port = 0;
                if (in.readByte() == 1) {
                    host = in.readString();
                    port = in.readInt();
                }
                String exclList = in.readString();
                String[] parsedExclList = in.readStringArray();
                ProxyProperties proxyProperties =
                        new ProxyProperties(host, port, exclList, parsedExclList);
                return proxyProperties;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.191 -0500", hash_original_method = "059EE23B2C7F4EFFECDBB1A455F1E783", hash_generated_method = "7D53614EFA25EB917500C04D8C1820A7")
        
public ProxyProperties[] newArray(int size) {
                return new ProxyProperties[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.143 -0500", hash_original_field = "608081BE7A68D9B383C7D78BD9FDC0E8", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.145 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.147 -0500", hash_original_field = "294F8E0791BC4CF3BC6010ED7953612B", hash_generated_field = "69C381CAD09CE31D3079B1694FAFB726")

    private String mExclusionList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.149 -0500", hash_original_field = "5AE72752093122F11C3673E753F97365", hash_generated_field = "44474F4F446275AD736304F48293F55B")

    private String[] mParsedExclusionList;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.152 -0500", hash_original_method = "54A7DBB96A42C21C9A34864E71BDFD9B", hash_generated_method = "B96A7EA211E6D30F41F9A2645420C917")
    
public ProxyProperties(String host, int port, String exclList) {
        mHost = host;
        mPort = port;
        setExclusionList(exclList);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.155 -0500", hash_original_method = "BC11E2D42BFC71E7CE241ADFD4F8685E", hash_generated_method = "5AA9D72C7F68D0B185D400832B376459")
    
private ProxyProperties(String host, int port, String exclList, String[] parsedExclList) {
        mHost = host;
        mPort = port;
        mExclusionList = exclList;
        mParsedExclusionList = parsedExclList;
    }

    // copy constructor instead of clone
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.157 -0500", hash_original_method = "A69C6CB2998D1D9E29343274F58FCABE", hash_generated_method = "13FB23308502E826F90390941971E3C1")
    
public ProxyProperties(ProxyProperties source) {
        if (source != null) {
            mHost = source.getHost();
            mPort = source.getPort();
            mExclusionList = source.getExclusionList();
            mParsedExclusionList = source.mParsedExclusionList;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.159 -0500", hash_original_method = "207ACF10C117D35BCDF8E06D043E3E5B", hash_generated_method = "7B7AADB70ACF5CF7CA7C38E0754108F7")
    
public InetSocketAddress getSocketAddress() {
        InetSocketAddress inetSocketAddress = null;
        try {
            inetSocketAddress = new InetSocketAddress(mHost, mPort);
        } catch (IllegalArgumentException e) { }
        return inetSocketAddress;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.161 -0500", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "6A355E9CFD8CF295DC08D3692B6B0773")
    
public String getHost() {
        return mHost;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.163 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
    
public int getPort() {
        return mPort;
    }

    // comma separated
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.165 -0500", hash_original_method = "A9FE56F63855512203F6AE795614409C", hash_generated_method = "1F8C84F141B71D9D0D4DA10181CF7E55")
    
public String getExclusionList() {
        return mExclusionList;
    }

    // comma separated
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.167 -0500", hash_original_method = "BEF68745D535D943EDDB2DD96C1B6EA8", hash_generated_method = "D460AA957E1FB8B20D0706165938EBBF")
    
private void setExclusionList(String exclusionList) {
        mExclusionList = exclusionList;
        if (mExclusionList == null) {
            mParsedExclusionList = new String[0];
        } else {
            String splitExclusionList[] = exclusionList.toLowerCase().split(",");
            mParsedExclusionList = new String[splitExclusionList.length * 2];
            for (int i = 0; i < splitExclusionList.length; i++) {
                String s = splitExclusionList[i].trim();
                if (s.startsWith(".")) s = s.substring(1);
                mParsedExclusionList[i*2] = s;
                mParsedExclusionList[(i*2)+1] = "." + s;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.171 -0500", hash_original_method = "72D2F326AF1444346066F9053B4FD5C0", hash_generated_method = "42E725F6EF9444F6FE31A3C20A682180")
    
public boolean isExcluded(String url) {
        if (TextUtils.isEmpty(url) || mParsedExclusionList == null ||
                mParsedExclusionList.length == 0) return false;

        Uri u = Uri.parse(url);
        String urlDomain = u.getHost();
        if (urlDomain == null) return false;
        for (int i = 0; i< mParsedExclusionList.length; i+=2) {
            if (urlDomain.equals(mParsedExclusionList[i]) ||
                    urlDomain.endsWith(mParsedExclusionList[i+1])) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.173 -0500", hash_original_method = "FF3E8127D15D936B6F66AB217E4EB9BA", hash_generated_method = "79121ACC2E822F43DD4556530F40CA77")
    
public java.net.Proxy makeProxy() {
        java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
        if (mHost != null) {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(mHost, mPort);
                proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetSocketAddress);
            } catch (IllegalArgumentException e) {
            }
        }
        return proxy;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.176 -0500", hash_original_method = "FE9AE719D0C3E87A445C3CEFBF6B38D6", hash_generated_method = "13F84EC863E76509FB5B964AED6DD5E5")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (mHost != null) {
            sb.append("[");
            sb.append(mHost);
            sb.append("] ");
            sb.append(Integer.toString(mPort));
            if (mExclusionList != null) {
                    sb.append(" xl=").append(mExclusionList);
            }
        } else {
            sb.append("[ProxyProperties.mHost == null]");
        }
        return sb.toString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.178 -0500", hash_original_method = "16EB0AD501F97CC03F0A85B7200F0E73", hash_generated_method = "C077A537133FB7AA320FB0C73C48E363")
    
@Override
    public boolean equals(Object o) {
        if (!(o instanceof ProxyProperties)) return false;
        ProxyProperties p = (ProxyProperties)o;
        if (mExclusionList != null && !mExclusionList.equals(p.getExclusionList())) return false;
        if (mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false) {
            return false;
        }
        if (mHost != null && p.mHost == null) return false;
        if (mHost == null && p.mHost != null) return false;
        if (mPort != p.mPort) return false;
        return true;
    }

    /**
     * Implement the Parcelable interface
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.180 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.183 -0500", hash_original_method = "AD2D5515FEDCF9B25A708B71445DFAB4", hash_generated_method = "476FF62E2D90EF00E7AD44AA6164EA37")
    
@Override
    /*
     * generate hashcode based on significant fields
     */
    public int hashCode() {
        return ((null == mHost) ? 0 : mHost.hashCode())
        + ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        + mPort;
    }

    /**
     * Implement the Parcelable interface.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:18.185 -0500", hash_original_method = "038CE78D7B15BBF2D949EA22EA3CF00F", hash_generated_method = "8CB802138D26B533B0BAF7DCC442BB43")
    
public void writeToParcel(Parcel dest, int flags) {
        if (mHost != null) {
            dest.writeByte((byte)1);
            dest.writeString(mHost);
            dest.writeInt(mPort);
        } else {
            dest.writeByte((byte)0);
        }
        dest.writeString(mExclusionList);
        dest.writeStringArray(mParsedExclusionList);
    }
    // orphaned legacy method
    public ProxyProperties createFromParcel(Parcel in) {
                String host = null;
                int port = 0;
                if (in.readByte() == 1) {
                    host = in.readString();
                    port = in.readInt();
                }
                String exclList = in.readString();
                String[] parsedExclList = in.readStringArray();
                ProxyProperties proxyProperties =
                        new ProxyProperties(host, port, exclList, parsedExclList);
                return proxyProperties;
            }
    
    // orphaned legacy method
    public ProxyProperties[] newArray(int size) {
                return new ProxyProperties[size];
            }
    
}

