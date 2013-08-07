package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.RequireHeader;






public class Require extends SIPHeader implements RequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.930 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.930 -0400", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "FB2DC2E91D950F6C620B24801FE2D28F")
    public  Require() {
        super(REQUIRE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.930 -0400", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "575C009F91F2FEFD0A3860B3360F0E6E")
    public  Require(String s) {
        super(REQUIRE);
        optionTag = s;
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.931 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "D1F892F2380523E9B60FAEAAE4742128")
    public String encodeBody() {
String var05FAD6E650FDF64778D62F7CDA67F749_1003334319 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_1003334319.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_1003334319;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.931 -0400", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "28EECFA8B16F5FDD9E41AEBEA2CB3E64")
    public void setOptionTag(String optionTag) throws ParseException {
        if(optionTag == null)        
        {
        NullPointerException var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_1379500006 = new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_1379500006.addTaint(taint);
        throw var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_1379500006;
        }
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Require, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.931 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "E56813B9E6C8C4456A96C1D80494F8F8")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_489959616 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_489959616.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_489959616;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.931 -0400", hash_original_field = "F3891BC8B68B30AE726482A3676916A5", hash_generated_field = "771FB76C670B9496D76C78920521C071")

    private static final long serialVersionUID = -3743425404884053281L;
}

