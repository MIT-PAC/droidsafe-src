package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;

public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_field = "6822EEC83D34666203ADF86CD4795A4B", hash_generated_field = "5E7FFC1430A937FAE7142DC53FF509E3")

    private HttpTransportMetrics inTransportMetric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_field = "015FD81AC1C2BCF4F973EA119A300F2F", hash_generated_field = "E0CF3516DB504D120AC5067342FFBE5B")

    private HttpTransportMetrics outTransportMetric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_field = "9904602F1CD234C22E56F67C97F2829F", hash_generated_field = "E64367A4A2744D7BF24173280744FB29")

    private long requestCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_field = "A02B2875C1620BF8A8BE5C32ED1B3FFB", hash_generated_field = "B3F5EE8BBDC21205901D7F5CC0623BD3")

    private long responseCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_field = "ED8830D60E5E0FF91374C0065042E56C", hash_generated_field = "35CE0AFB7B28C5484196533A0F45BD0A")

    private HashMap metricsCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.723 -0400", hash_original_method = "EB78748E734AA82D49A26B08553276D7", hash_generated_method = "1070D6D321B4F77C662C526E44D5FF12")
    public  HttpConnectionMetricsImpl(
            final HttpTransportMetrics inTransportMetric,
            final HttpTransportMetrics outTransportMetric) {
        super();
        this.inTransportMetric = inTransportMetric;
        this.outTransportMetric = outTransportMetric;
        // ---------- Original Method ----------
        //this.inTransportMetric = inTransportMetric;
        //this.outTransportMetric = outTransportMetric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.724 -0400", hash_original_method = "1EBAB3737DE9FB9DF9CC42BB4FE509FE", hash_generated_method = "4D9C9C21BBACBAC4DF276A5D5E517212")
    public long getReceivedBytesCount() {
        {
            long varA283B784B7FE9BFC0569F40A60B46342_1849541468 = (this.inTransportMetric.getBytesTransferred());
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1475313798 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1475313798;
        // ---------- Original Method ----------
        //if (this.inTransportMetric != null) {
            //return this.inTransportMetric.getBytesTransferred();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.724 -0400", hash_original_method = "F08F23EEAF6902947D0550EC2D19F62A", hash_generated_method = "804F2C94F55D346C3F9365AD6B532138")
    public long getSentBytesCount() {
        {
            long var90735343CB9DA2D0369C240F6C47331E_265952300 = (this.outTransportMetric.getBytesTransferred());
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1523867014 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1523867014;
        // ---------- Original Method ----------
        //if (this.outTransportMetric != null) {
            //return this.outTransportMetric.getBytesTransferred();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.724 -0400", hash_original_method = "B8865720333D029C5CF85A9B740C8D79", hash_generated_method = "8AACACB0BC2E784CB360BC54D1BDC115")
    public long getRequestCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1090015363 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1090015363;
        // ---------- Original Method ----------
        //return this.requestCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.724 -0400", hash_original_method = "6C45A6D8B86DB0070BDE4B1C1CEA64D7", hash_generated_method = "4BCF63E7C4DD947BD3DAA974233584E9")
    public void incrementRequestCount() {
        // ---------- Original Method ----------
        //this.requestCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.725 -0400", hash_original_method = "49B98A48C56AB67D4EF8CDF6CC198706", hash_generated_method = "D84EEF59E81EC533060E25B0C2800C99")
    public long getResponseCount() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_364164760 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_364164760;
        // ---------- Original Method ----------
        //return this.responseCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.725 -0400", hash_original_method = "6B43C475A149C70A7E71BE6915C4E68E", hash_generated_method = "486B4FDA9D1AED4176A5CF3EA04DF9FE")
    public void incrementResponseCount() {
        // ---------- Original Method ----------
        //this.responseCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.726 -0400", hash_original_method = "6C49AD7310EA65AFC750C659BF89235C", hash_generated_method = "29DF78FF1D6BE48E53EFD7F07CD7207B")
    public Object getMetric(final String metricName) {
        Object varB4EAC82CA7396A68D541C85D26508E83_285249122 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_255061120 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1726844002 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1306160527 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_1442667317 = null; //Variable for return #5
        Object value = null;
        {
            value = this.metricsCache.get(metricName);
        } //End block
        {
            {
                boolean var721E85E55F36049DF388518E19C906EB_1746966068 = (REQUEST_COUNT.equals(metricName));
                {
                    value = new Long(requestCount);
                } //End block
                {
                    boolean var45256D08B5E5B6B974A64AB355A357C9_1619764545 = (RESPONSE_COUNT.equals(metricName));
                    {
                        value = new Long(responseCount);
                    } //End block
                    {
                        boolean varBA0B5171C62B543B1C7290A6E41E9B56_61210257 = (RECEIVED_BYTES_COUNT.equals(metricName));
                        {
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_285249122 = new Long(this.inTransportMetric.getBytesTransferred());
                            } //End block
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_255061120 = null;
                            } //End block
                        } //End block
                        {
                            boolean var49C09C5820A124542F071CB2D3F2AD07_739554877 = (SENT_BYTES_COUNT.equals(metricName));
                            {
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1726844002 = new Long(this.outTransportMetric.getBytesTransferred());
                                } //End block
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1306160527 = null;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1442667317 = value;
        addTaint(metricName.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_843111538; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_843111538 = varB4EAC82CA7396A68D541C85D26508E83_285249122;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_843111538 = varB4EAC82CA7396A68D541C85D26508E83_255061120;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_843111538 = varB4EAC82CA7396A68D541C85D26508E83_1726844002;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_843111538 = varB4EAC82CA7396A68D541C85D26508E83_1306160527;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_843111538 = varB4EAC82CA7396A68D541C85D26508E83_1442667317;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_843111538.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_843111538;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.727 -0400", hash_original_method = "26808D4CB461BECF2D0D215CD6E44153", hash_generated_method = "C24E520C16E04C795F9EA9EE4BE46570")
    public void setMetric(final String metricName, Object obj) {
        {
            this.metricsCache = new HashMap();
        } //End block
        this.metricsCache.put(metricName, obj);
        addTaint(metricName.getTaint());
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //if (this.metricsCache == null) {
            //this.metricsCache = new HashMap();
        //}
        //this.metricsCache.put(metricName, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.728 -0400", hash_original_method = "547EC11D83367AF05AC108A4083E6A6D", hash_generated_method = "AE06DD6F24E693566367F909278FD230")
    public void reset() {
        {
            this.outTransportMetric.reset();
        } //End block
        {
            this.inTransportMetric.reset();
        } //End block
        this.requestCount = 0;
        this.responseCount = 0;
        this.metricsCache = null;
        // ---------- Original Method ----------
        //if (this.outTransportMetric != null) {
            //this.outTransportMetric.reset();
        //}
        //if (this.inTransportMetric != null) {
            //this.inTransportMetric.reset();
        //}
        //this.requestCount = 0;
        //this.responseCount = 0;
        //this.metricsCache = null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.728 -0400", hash_original_field = "6587977FADDB732B3E509EDAE6C43F78", hash_generated_field = "373C413BA4311AB7E96D795A72AF73FA")

    public static final String REQUEST_COUNT = "http.request-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.728 -0400", hash_original_field = "E95B179B6F12E0BB933F82AFC66EAAA0", hash_generated_field = "AE2EB040A380B4F9C814EC5336AEF175")

    public static final String RESPONSE_COUNT = "http.response-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.728 -0400", hash_original_field = "8B59AE6197A659AD6DE7D0A07C7AAC08", hash_generated_field = "3373448E7FDB972B7AF2E3C2C6208A09")

    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.728 -0400", hash_original_field = "F77C8CFCDDD4962E86567A5B37739313", hash_generated_field = "C6B8E1F0F125F7C9B7EC8A6EAC31E20B")

    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
}

