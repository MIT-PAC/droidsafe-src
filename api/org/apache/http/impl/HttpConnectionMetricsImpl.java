package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;






public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.321 -0500", hash_original_field = "40C24447C4B2008549DA71E385969FB8", hash_generated_field = "373C413BA4311AB7E96D795A72AF73FA")

    
    public static final String REQUEST_COUNT = "http.request-count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.322 -0500", hash_original_field = "706CAFD10D21451E23A6E7F0380297E9", hash_generated_field = "AE2EB040A380B4F9C814EC5336AEF175")

    public static final String RESPONSE_COUNT = "http.response-count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.323 -0500", hash_original_field = "DC2AFDDC99A8E70A23F0987B2B584231", hash_generated_field = "3373448E7FDB972B7AF2E3C2C6208A09")

    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.324 -0500", hash_original_field = "B1D325B3D75932FA3D4CC1857B981B78", hash_generated_field = "C6B8E1F0F125F7C9B7EC8A6EAC31E20B")

    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.324 -0500", hash_original_field = "EE84EBCFDB0A371B6875A78B0D715130", hash_generated_field = "5E7FFC1430A937FAE7142DC53FF509E3")

    
    private  HttpTransportMetrics inTransportMetric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.325 -0500", hash_original_field = "3BEEA86C6993F429AB8022406BD0E777", hash_generated_field = "E0CF3516DB504D120AC5067342FFBE5B")

    private  HttpTransportMetrics outTransportMetric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.326 -0500", hash_original_field = "5BACDA08FFD1D5E821AFE6CF98AC8CBE", hash_generated_field = "E64367A4A2744D7BF24173280744FB29")

    private long requestCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.327 -0500", hash_original_field = "D96E15D3039155D541F737D82263B6AB", hash_generated_field = "B3F5EE8BBDC21205901D7F5CC0623BD3")

    private long responseCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.327 -0500", hash_original_field = "82B64F3B1080228ABC4D1395897C68CD", hash_generated_field = "35CE0AFB7B28C5484196533A0F45BD0A")

    private HashMap metricsCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.328 -0500", hash_original_method = "EB78748E734AA82D49A26B08553276D7", hash_generated_method = "1421D2D7D75E3D6538DA8144431F3F68")
    public HttpConnectionMetricsImpl(
            final HttpTransportMetrics inTransportMetric,
            final HttpTransportMetrics outTransportMetric) {
        super();
        this.inTransportMetric = inTransportMetric;
        this.outTransportMetric = outTransportMetric;
    }
    
    /* ------------------  Public interface method -------------------------- */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.329 -0500", hash_original_method = "1EBAB3737DE9FB9DF9CC42BB4FE509FE", hash_generated_method = "A8C47F55825E6BBABEA20C2E9F2878EB")
    public long getReceivedBytesCount() {
        if (this.inTransportMetric != null) {
            return this.inTransportMetric.getBytesTransferred();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.330 -0500", hash_original_method = "F08F23EEAF6902947D0550EC2D19F62A", hash_generated_method = "C99F1A11515DFC820B1078EC7251BE19")
    public long getSentBytesCount() {
        if (this.outTransportMetric != null) {
            return this.outTransportMetric.getBytesTransferred();
        } else {
            return -1;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.331 -0500", hash_original_method = "B8865720333D029C5CF85A9B740C8D79", hash_generated_method = "DFD6B91E7A0034F59509AA7E28C3050A")
    public long getRequestCount() {
        return this.requestCount;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.331 -0500", hash_original_method = "6C45A6D8B86DB0070BDE4B1C1CEA64D7", hash_generated_method = "0B71AE8DF056BD048B9C03073F52E85A")
    public void incrementRequestCount() {
        this.requestCount++;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.332 -0500", hash_original_method = "49B98A48C56AB67D4EF8CDF6CC198706", hash_generated_method = "370EAAE7314730F894D698A3FD339160")
    public long getResponseCount() {
        return this.responseCount;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.333 -0500", hash_original_method = "6B43C475A149C70A7E71BE6915C4E68E", hash_generated_method = "3493A1397B84F79F7E5B6D756264B446")
    public void incrementResponseCount() {
        this.responseCount++;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.334 -0500", hash_original_method = "6C49AD7310EA65AFC750C659BF89235C", hash_generated_method = "9CD3E41FB4CE78EEABA2C52DB955172D")
    public Object getMetric(final String metricName) {
        Object value = null;
        if (this.metricsCache != null) {
            value = this.metricsCache.get(metricName);
        }
        if (value == null) {
            if (REQUEST_COUNT.equals(metricName)) {
                value = new Long(requestCount);
            } else if (RESPONSE_COUNT.equals(metricName)) {
                value = new Long(responseCount);
            } else if (RECEIVED_BYTES_COUNT.equals(metricName)) {
                if (this.inTransportMetric != null) {
                    return new Long(this.inTransportMetric.getBytesTransferred());
                } else {
                    return null;
                }
            } else if (SENT_BYTES_COUNT.equals(metricName)) {
                if (this.outTransportMetric != null) {
                    return new Long(this.outTransportMetric.getBytesTransferred());
                } else {
                    return null;
                }
            }
        }
        return value;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.335 -0500", hash_original_method = "26808D4CB461BECF2D0D215CD6E44153", hash_generated_method = "D68A862E04BDC14E1782DD0AB816ED7F")
    public void setMetric(final String metricName, Object obj) {
        if (this.metricsCache == null) {
            this.metricsCache = new HashMap();
        }
        this.metricsCache.put(metricName, obj);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.336 -0500", hash_original_method = "547EC11D83367AF05AC108A4083E6A6D", hash_generated_method = "DF19281F42246960633D86B62BEAFA79")
    public void reset() {
        if (this.outTransportMetric != null) {
            this.outTransportMetric.reset();
        }
        if (this.inTransportMetric != null) {
            this.inTransportMetric.reset();
        }
        this.requestCount = 0;
        this.responseCount = 0;
        this.metricsCache = null;
    }
}

