package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class Require extends SIPHeader implements RequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.901 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.901 -0400", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "FB2DC2E91D950F6C620B24801FE2D28F")
    public  Require() {
        super(REQUIRE);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.902 -0400", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "575C009F91F2FEFD0A3860B3360F0E6E")
    public  Require(String s) {
        super(REQUIRE);
        optionTag = s;
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.902 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "96488E7615F0A3A6808A7A96819D073A")
    public String encodeBody() {
String var05FAD6E650FDF64778D62F7CDA67F749_165706876 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_165706876.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_165706876;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.902 -0400", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "A225F546232E61842E90D5B7CE358459")
    public void setOptionTag(String optionTag) throws ParseException {
    if(optionTag == null)        
        {
        NullPointerException var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_2122686928 = new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_2122686928.addTaint(taint);
        throw var54CA8AA76FFE1CAD7D4CF5082ADD2EE4_2122686928;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.903 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "348B9977DEC800074FEF7121E6E0E6F1")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_1482068010 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_1482068010.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_1482068010;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.903 -0400", hash_original_field = "F3891BC8B68B30AE726482A3676916A5", hash_generated_field = "771FB76C670B9496D76C78920521C071")

    private static final long serialVersionUID = -3743425404884053281L;
}

