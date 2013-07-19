package org.apache.http.impl;

// Droidsafe Imports
import java.util.HashMap;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.346 -0400", hash_original_field = "6822EEC83D34666203ADF86CD4795A4B", hash_generated_field = "5E7FFC1430A937FAE7142DC53FF509E3")

    private HttpTransportMetrics inTransportMetric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.346 -0400", hash_original_field = "015FD81AC1C2BCF4F973EA119A300F2F", hash_generated_field = "E0CF3516DB504D120AC5067342FFBE5B")

    private HttpTransportMetrics outTransportMetric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.346 -0400", hash_original_field = "9904602F1CD234C22E56F67C97F2829F", hash_generated_field = "E64367A4A2744D7BF24173280744FB29")

    private long requestCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.346 -0400", hash_original_field = "A02B2875C1620BF8A8BE5C32ED1B3FFB", hash_generated_field = "B3F5EE8BBDC21205901D7F5CC0623BD3")

    private long responseCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_field = "ED8830D60E5E0FF91374C0065042E56C", hash_generated_field = "35CE0AFB7B28C5484196533A0F45BD0A")

    private HashMap metricsCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "EB78748E734AA82D49A26B08553276D7", hash_generated_method = "1070D6D321B4F77C662C526E44D5FF12")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "1EBAB3737DE9FB9DF9CC42BB4FE509FE", hash_generated_method = "6AF4181ED45907D0406E9C990D8CA19C")
    public long getReceivedBytesCount() {
        if(this.inTransportMetric != null)        
        {
            long var7E118042866A58A54266CF958BEFAB75_666881019 = (this.inTransportMetric.getBytesTransferred());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_80452762 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_80452762;
        } //End block
        else
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1670300147 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_589433720 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_589433720;
        } //End block
        // ---------- Original Method ----------
        //if (this.inTransportMetric != null) {
            //return this.inTransportMetric.getBytesTransferred();
        //} else {
            //return -1;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "F08F23EEAF6902947D0550EC2D19F62A", hash_generated_method = "FA2441152660FEABF93E04D92470D4AF")
    public long getSentBytesCount() {
        if(this.outTransportMetric != null)        
        {
            long var67E44C905CF13806ED7E799CD4128F35_881187975 = (this.outTransportMetric.getBytesTransferred());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1893209084 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1893209084;
        } //End block
        else
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1537390987 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1859007870 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1859007870;
        } //End block
        // ---------- Original Method ----------
        //if (this.outTransportMetric != null) {
            //return this.outTransportMetric.getBytesTransferred();
        //} else {
            //return -1;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "B8865720333D029C5CF85A9B740C8D79", hash_generated_method = "B9E832286A391D6180E200357E074C00")
    public long getRequestCount() {
        long var52BCD8BC519E2419C41F2221E8CD2C21_1677354697 = (this.requestCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_150928057 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_150928057;
        // ---------- Original Method ----------
        //return this.requestCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "6C45A6D8B86DB0070BDE4B1C1CEA64D7", hash_generated_method = "3FF2330648BA9878926F9513C5534AA2")
    public void incrementRequestCount() {
        this.requestCount++;
        // ---------- Original Method ----------
        //this.requestCount++;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "49B98A48C56AB67D4EF8CDF6CC198706", hash_generated_method = "7EBCA4489AA887EEDFC32798C2382D0C")
    public long getResponseCount() {
        long varFDE43E7631F2A4B976D4D2C63818DCA9_753423422 = (this.responseCount);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1569587410 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1569587410;
        // ---------- Original Method ----------
        //return this.responseCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.347 -0400", hash_original_method = "6B43C475A149C70A7E71BE6915C4E68E", hash_generated_method = "63F8C7EA0DD134C52DA013884539A5E8")
    public void incrementResponseCount() {
        this.responseCount++;
        // ---------- Original Method ----------
        //this.responseCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_method = "6C49AD7310EA65AFC750C659BF89235C", hash_generated_method = "0BFB5F02CC994B64BCEE58DE20889621")
    public Object getMetric(final String metricName) {
        addTaint(metricName.getTaint());
        Object value = null;
        if(this.metricsCache != null)        
        {
            value = this.metricsCache.get(metricName);
        } //End block
        if(value == null)        
        {
            if(REQUEST_COUNT.equals(metricName))            
            {
                value = new Long(requestCount);
            } //End block
            else
            if(RESPONSE_COUNT.equals(metricName))            
            {
                value = new Long(responseCount);
            } //End block
            else
            if(RECEIVED_BYTES_COUNT.equals(metricName))            
            {
                if(this.inTransportMetric != null)                
                {
Object varD14589BBF7814F9F9D2F5823E634E586_561187370 =                     new Long(this.inTransportMetric.getBytesTransferred());
                    varD14589BBF7814F9F9D2F5823E634E586_561187370.addTaint(taint);
                    return varD14589BBF7814F9F9D2F5823E634E586_561187370;
                } //End block
                else
                {
Object var540C13E9E156B687226421B24F2DF178_1272192335 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1272192335.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1272192335;
                } //End block
            } //End block
            else
            if(SENT_BYTES_COUNT.equals(metricName))            
            {
                if(this.outTransportMetric != null)                
                {
Object var0F2E3FD3EF4D66A57F54C57BAA06F23A_1610635735 =                     new Long(this.outTransportMetric.getBytesTransferred());
                    var0F2E3FD3EF4D66A57F54C57BAA06F23A_1610635735.addTaint(taint);
                    return var0F2E3FD3EF4D66A57F54C57BAA06F23A_1610635735;
                } //End block
                else
                {
Object var540C13E9E156B687226421B24F2DF178_340185503 =                     null;
                    var540C13E9E156B687226421B24F2DF178_340185503.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_340185503;
                } //End block
            } //End block
        } //End block
Object varAF280DA2BC37D8BE783D8499160168DE_2078990382 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_2078990382.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_2078990382;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_method = "26808D4CB461BECF2D0D215CD6E44153", hash_generated_method = "463BBAE14B8F9BBB88FD3392AE74F998")
    public void setMetric(final String metricName, Object obj) {
        addTaint(obj.getTaint());
        addTaint(metricName.getTaint());
        if(this.metricsCache == null)        
        {
            this.metricsCache = new HashMap();
        } //End block
        this.metricsCache.put(metricName, obj);
        // ---------- Original Method ----------
        //if (this.metricsCache == null) {
            //this.metricsCache = new HashMap();
        //}
        //this.metricsCache.put(metricName, obj);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_method = "547EC11D83367AF05AC108A4083E6A6D", hash_generated_method = "796E64656D41F316DDE95E34B60C2132")
    public void reset() {
        if(this.outTransportMetric != null)        
        {
            this.outTransportMetric.reset();
        } //End block
        if(this.inTransportMetric != null)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_field = "6587977FADDB732B3E509EDAE6C43F78", hash_generated_field = "373C413BA4311AB7E96D795A72AF73FA")

    public static final String REQUEST_COUNT = "http.request-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_field = "E95B179B6F12E0BB933F82AFC66EAAA0", hash_generated_field = "AE2EB040A380B4F9C814EC5336AEF175")

    public static final String RESPONSE_COUNT = "http.response-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_field = "8B59AE6197A659AD6DE7D0A07C7AAC08", hash_generated_field = "3373448E7FDB972B7AF2E3C2C6208A09")

    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.348 -0400", hash_original_field = "F77C8CFCDDD4962E86567A5B37739313", hash_generated_field = "C6B8E1F0F125F7C9B7EC8A6EAC31E20B")

    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
}

