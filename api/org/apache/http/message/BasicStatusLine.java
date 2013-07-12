package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class BasicStatusLine implements StatusLine, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.662 -0400", hash_original_field = "23DDB025C27B126E5417C36D02A9A056", hash_generated_field = "72E55365A74A797579CAA53A070680F8")

    private ProtocolVersion protoVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.662 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.662 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "6AD67BCB7682DA68E3445B9AD0549128")

    private String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.663 -0400", hash_original_method = "E6F861CC92981BDB285C9E8C86704EF5", hash_generated_method = "EA837694C13BD64A4AC86EBEB4905B8B")
    public  BasicStatusLine(final ProtocolVersion version, int statusCode,
                           final String reasonPhrase) {
        super();
    if(version == null)        
        {
            IllegalArgumentException var9E55573212623D8B3852E07B321C31F8_2019357014 = new IllegalArgumentException
                ("Protocol version may not be null.");
            var9E55573212623D8B3852E07B321C31F8_2019357014.addTaint(taint);
            throw var9E55573212623D8B3852E07B321C31F8_2019357014;
        } //End block
    if(statusCode < 0)        
        {
            IllegalArgumentException varDA3DDF68291263B6E3A833A5816B3876_1243167295 = new IllegalArgumentException
                ("Status code may not be negative.");
            varDA3DDF68291263B6E3A833A5816B3876_1243167295.addTaint(taint);
            throw varDA3DDF68291263B6E3A833A5816B3876_1243167295;
        } //End block
        this.protoVersion = version;
        this.statusCode   = statusCode;
        this.reasonPhrase = reasonPhrase;
        // ---------- Original Method ----------
        //if (version == null) {
            //throw new IllegalArgumentException
                //("Protocol version may not be null.");
        //}
        //if (statusCode < 0) {
            //throw new IllegalArgumentException
                //("Status code may not be negative.");
        //}
        //this.protoVersion = version;
        //this.statusCode   = statusCode;
        //this.reasonPhrase = reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.664 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "0A6437E78D25077C59FFB7387246C57D")
    public int getStatusCode() {
        int var6AEDBE53EDA06912FBCF8CC9CFD94E96_223893870 = (this.statusCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973857293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973857293;
        // ---------- Original Method ----------
        //return this.statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.664 -0400", hash_original_method = "428750DB8A2FD05AED2F69E1D46A4B0B", hash_generated_method = "6CCF638E6086894A076A11ADED2C5D4F")
    public ProtocolVersion getProtocolVersion() {
ProtocolVersion var9CA79ECA22894C81CCBA1F9D5B17FA49_1326406996 =         this.protoVersion;
        var9CA79ECA22894C81CCBA1F9D5B17FA49_1326406996.addTaint(taint);
        return var9CA79ECA22894C81CCBA1F9D5B17FA49_1326406996;
        // ---------- Original Method ----------
        //return this.protoVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.665 -0400", hash_original_method = "F68F7EAA9CC529FF206693909CBAA2FE", hash_generated_method = "E170025586A4289F806366EACE7CC0F5")
    public String getReasonPhrase() {
String var32C07A996FD67A2B69DAABC149FA7447_1292232546 =         this.reasonPhrase;
        var32C07A996FD67A2B69DAABC149FA7447_1292232546.addTaint(taint);
        return var32C07A996FD67A2B69DAABC149FA7447_1292232546;
        // ---------- Original Method ----------
        //return this.reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.665 -0400", hash_original_method = "B124288BE18B40A8DA205B6ACD4ADD5F", hash_generated_method = "F9D6B9011A2E688DF27CC46E3BAB24D4")
    public String toString() {
String var5F94FEC01AE9C71FD9724E389BAEB8E0_1358838343 =         BasicLineFormatter.DEFAULT
            .formatStatusLine(null, this).toString();
        var5F94FEC01AE9C71FD9724E389BAEB8E0_1358838343.addTaint(taint);
        return var5F94FEC01AE9C71FD9724E389BAEB8E0_1358838343;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatStatusLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.665 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "F3663D4FC78E270809F55D051E426AED")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1121696156 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1121696156.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1121696156;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

