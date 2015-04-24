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


package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class RequestHeaders {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.134 -0500", hash_original_field = "1154143EF3A042E6515BD6D5B42C64B6", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private  URI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.136 -0500", hash_original_field = "721E352764832BEC7D2888A7B819E7BB", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private  RawHeaders headers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.138 -0500", hash_original_field = "C359567A28AD1D5994F4F32F817A1408", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.140 -0500", hash_original_field = "8E16EB77C76FEA4C8000F125EC5F79EC", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.142 -0500", hash_original_field = "D467853CC3139B0BEDF79317911EFFF3", hash_generated_field = "CE7B115851142EB428D4DC9E717F3041")

    private int maxStaleSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.144 -0500", hash_original_field = "2877F6D78E45ABC20F47BEC1B9F534FE", hash_generated_field = "086F715250E1F43550756BC1900CA699")

    private int minFreshSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.147 -0500", hash_original_field = "969637F3249412E7FF4D53D0E10902C6", hash_generated_field = "57743485CCD77CC05F45CCC698FBC278")

    private boolean onlyIfCached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.149 -0500", hash_original_field = "8679F1797AC55B6FAED7166D5930DA43", hash_generated_field = "7ED9453D363B09CB6651EDC899592357")

    private boolean hasAuthorization;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.151 -0500", hash_original_field = "DCA513098DC932271B140492EF640274", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.153 -0500", hash_original_field = "3AD1B7A7AEDBE1A2DB22642DAB10A01F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.155 -0500", hash_original_field = "F21D32D2E9EA1AEBDAA5F5FA32483283", hash_generated_field = "88333D67CF65F12E18B2CCFFCF6A1193")

    private String userAgent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.158 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.160 -0500", hash_original_field = "8022296E52E90E64CBEABC7223F35EEE", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.163 -0500", hash_original_field = "317590FEBCBC319411AAEAA2BEFEF6A7", hash_generated_field = "EE8FD96001498BFE0A0B28028AB9D38D")

    private String acceptEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.165 -0500", hash_original_field = "EC00198C8901F4A46F11243ED4F82C3C", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.167 -0500", hash_original_field = "529EEFCC5003E4B61BB44A56E9CD03F3", hash_generated_field = "501F5A3170249BC588BDE376EE56533C")

    private String ifModifiedSince;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.169 -0500", hash_original_field = "A795FC09CE05A0A5FDE8F45A2D60BBCC", hash_generated_field = "09393A990220AB5E7CED6C5DBA647C56")

    private String ifNoneMatch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.171 -0500", hash_original_field = "B0D6F285E14A6A3D23A01859BCD3B736", hash_generated_field = "6C4DFB7A35D3B140FF1CF00900EC5F99")

    private String proxyAuthorization;
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.880 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "4674D86252DCD3882B7924CBE3BCC387")
    public  RequestHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
        HeaderParser.CacheControlHandler handler = new HeaderParser.CacheControlHandler() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.175 -0500", hash_original_method = "6F7F2A3EEBC501E81C89E55DE534AEB7", hash_generated_method = "754BE6F10DEAAF4EE45229E105C321B3")
            
@Override public void handle(String directive, String parameter) {
                if (directive.equalsIgnoreCase("no-cache")) {
                    noCache = true;
                } else if (directive.equalsIgnoreCase("max-age")) {
                    maxAgeSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("max-stale")) {
                    maxStaleSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("min-fresh")) {
                    minFreshSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("only-if-cached")) {
                    onlyIfCached = true;
                }
            }
        };
for(int i = 0;i < headers.length();i++)
        {
            String fieldName = headers.getFieldName(i);
            String value = headers.getValue(i);
            if("Cache-Control".equalsIgnoreCase(fieldName))            
            {
                HeaderParser.parseCacheControl(value, handler);
            } //End block
            else
            if("Pragma".equalsIgnoreCase(fieldName))            
            {
                if(value.equalsIgnoreCase("no-cache"))                
                {
                    noCache = true;
                } //End block
            } //End block
            else
            if("If-None-Match".equalsIgnoreCase(fieldName))            
            {
                ifNoneMatch = value;
            } //End block
            else
            if("If-Modified-Since".equalsIgnoreCase(fieldName))            
            {
                ifModifiedSince = value;
            } //End block
            else
            if("Authorization".equalsIgnoreCase(fieldName))            
            {
                hasAuthorization = true;
            } //End block
            else
            if("Content-Length".equalsIgnoreCase(fieldName))            
            {
                try 
                {
                    contentLength = Integer.parseInt(value);
                } //End block
                catch (NumberFormatException ignored)
                {
                } //End block
            } //End block
            else
            if("Transfer-Encoding".equalsIgnoreCase(fieldName))            
            {
                transferEncoding = value;
            } //End block
            else
            if("User-Agent".equalsIgnoreCase(fieldName))            
            {
                userAgent = value;
            } //End block
            else
            if("Host".equalsIgnoreCase(fieldName))            
            {
                host = value;
            } //End block
            else
            if("Connection".equalsIgnoreCase(fieldName))            
            {
                connection = value;
            } //End block
            else
            if("Accept-Encoding".equalsIgnoreCase(fieldName))            
            {
                acceptEncoding = value;
            } //End block
            else
            if("Content-Type".equalsIgnoreCase(fieldName))            
            {
                contentType = value;
            } //End block
            else
            if("Proxy-Authorization".equalsIgnoreCase(fieldName))            
            {
                proxyAuthorization = value;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.180 -0500", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "729C893AD1C21AE18D4F12D29D1C61DA")
    
public boolean isChunked() {
        return "chunked".equalsIgnoreCase(transferEncoding);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.182 -0500", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "EC0E49DCEE398A593CFEE12404E07E77")
    
public boolean hasConnectionClose() {
        return "close".equalsIgnoreCase(connection);
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.184 -0500", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "60830F5EFD10217EDDCE0C85CD9D74A2")
    
public URI getUri() {
        return uri;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.186 -0500", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "6022E25C4F7FF0168ED06357F484B603")
    
public RawHeaders getHeaders() {
        return headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.188 -0500", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "F80B03F9D6A493EAD09B6933DD20850A")
    
public boolean isNoCache() {
        return noCache;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.191 -0500", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "F01A0136F83C79BFF39A10D41A61EBE7")
    
public int getMaxAgeSeconds() {
        return maxAgeSeconds;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.193 -0500", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "86A83DB39FF22D5ADDA6C2BCC93CE878")
    
public int getMaxStaleSeconds() {
        return maxStaleSeconds;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.195 -0500", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "A61F2369E63AED5C6F4FDECF9D52FCF3")
    
public int getMinFreshSeconds() {
        return minFreshSeconds;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.197 -0500", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "1ECC5941349E38863134F286E839064A")
    
public boolean isOnlyIfCached() {
        return onlyIfCached;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.200 -0500", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "0DD9072814EFA702CF20EE823F5EDFB5")
    
public boolean hasAuthorization() {
        return hasAuthorization;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.202 -0500", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "3EA641A4B2840232F93FE75B9CA26F40")
    
public int getContentLength() {
        return contentLength;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.205 -0500", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "66B23E5D844DF1240B1DC45BCF36C41A")
    
public String getTransferEncoding() {
        return transferEncoding;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.207 -0500", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "28A0963E8AF0ECB01F681AB64F696163")
    
public String getUserAgent() {
        return userAgent;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.209 -0500", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1B655222E0C0F88C57DF58BCA9BFA498")
    
public String getHost() {
        return host;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.211 -0500", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "78E1AA902D6B9D44AB023C3342795437")
    
public String getConnection() {
        return connection;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.213 -0500", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "D81BB03FB5555355719FC5ED97C7A976")
    
public String getAcceptEncoding() {
        return acceptEncoding;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.215 -0500", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "EEA92DBFF9A08C9297BF00D5675DE8A3")
    
public String getContentType() {
        return contentType;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.218 -0500", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "63DD434B7E2F37A7FAB057677D72D1DF")
    
public String getIfModifiedSince() {
        return ifModifiedSince;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.220 -0500", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "31DD42931F72EEF7C1E22FE1E0A92867")
    
public String getIfNoneMatch() {
        return ifNoneMatch;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.222 -0500", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "C61EB23F27BDDD3E8F08F1B27D521313")
    
public String getProxyAuthorization() {
        return proxyAuthorization;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.224 -0500", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "2D1F17CFEF9C5C665121AFBF341E7604")
    
public void setChunked() {
        if (this.transferEncoding != null) {
            headers.removeAll("Transfer-Encoding");
        }
        headers.add("Transfer-Encoding", "chunked");
        this.transferEncoding = "chunked";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.226 -0500", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "2AAC8B9B9BCFC7791965ABB6174E5030")
    
public void setContentLength(int contentLength) {
        if (this.contentLength != -1) {
            headers.removeAll("Content-Length");
        }
        headers.add("Content-Length", Integer.toString(contentLength));
        this.contentLength = contentLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.229 -0500", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "D0CF80C62E7B0341D4AD1DF3C7A01F8C")
    
public void setUserAgent(String userAgent) {
        if (this.userAgent != null) {
            headers.removeAll("User-Agent");
        }
        headers.add("User-Agent", userAgent);
        this.userAgent = userAgent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.231 -0500", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "61AABCE69CEB06D0DFA6626FA3E54B4C")
    
public void setHost(String host) {
        if (this.host != null) {
            headers.removeAll("Host");
        }
        headers.add("Host", host);
        this.host = host;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.233 -0500", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "43AAB62D13C275634A7186830AA7CDAF")
    
public void setConnection(String connection) {
        if (this.connection != null) {
            headers.removeAll("Connection");
        }
        headers.add("Connection", connection);
        this.connection = connection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.236 -0500", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "A1C65592D8A331808626291A8C547AD7")
    
public void setAcceptEncoding(String acceptEncoding) {
        if (this.acceptEncoding != null) {
            headers.removeAll("Accept-Encoding");
        }
        headers.add("Accept-Encoding", acceptEncoding);
        this.acceptEncoding = acceptEncoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.239 -0500", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "910504F9523748CA782D5387BDEF6068")
    
public void setContentType(String contentType) {
        if (this.contentType != null) {
            headers.removeAll("Content-Type");
        }
        headers.add("Content-Type", contentType);
        this.contentType = contentType;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.241 -0500", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "D1D108407DC0499C6FE970583D628966")
    
public void setIfModifiedSince(Date date) {
        if (ifModifiedSince != null) {
            headers.removeAll("If-Modified-Since");
        }
        String formattedDate = HttpDate.format(date);
        headers.add("If-Modified-Since", formattedDate);
        ifModifiedSince = formattedDate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.243 -0500", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "BEB5BB25D507FB57597E63C03C10E08E")
    
public void setIfNoneMatch(String ifNoneMatch) {
        if (this.ifNoneMatch != null) {
            headers.removeAll("If-None-Match");
        }
        headers.add("If-None-Match", ifNoneMatch);
        this.ifNoneMatch = ifNoneMatch;
    }

    /**
     * Returns true if the request contains conditions that save the server from
     * sending a response that the client has locally. When the caller adds
     * conditions, this cache won't participate in the request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.245 -0500", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "54D55286371F9536EBD7253B98ACC56B")
    
public boolean hasConditions() {
        return ifModifiedSince != null || ifNoneMatch != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.248 -0500", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "BB96DD8820082EE3159F803CB671C5FB")
    
public void addCookies(Map<String, List<String>> allCookieHeaders) {
        for (Map.Entry<String, List<String>> entry : allCookieHeaders.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                headers.addAll(key, entry.getValue());
            }
        }
    }
    
}

