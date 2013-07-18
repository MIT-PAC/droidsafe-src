package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MediaRange extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.558 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.558 -0400", hash_original_field = "2E282B0D23D6EC55185CAEB87B41C0E0", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.558 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    public  MediaRange() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.558 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "D319866DE8C791EF0D0AFBD978A30A99")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_121088234 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_121088234.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_121088234;
        // ---------- Original Method ----------
        //return type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.559 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "DF3405E011314E98CA712B8864BF8B1C")
    public String getSubtype() {
String var169367A745E19D18DAC62A70AF6FE5E6_1824045942 =         subtype;
        var169367A745E19D18DAC62A70AF6FE5E6_1824045942.addTaint(taint);
        return var169367A745E19D18DAC62A70AF6FE5E6_1824045942;
        // ---------- Original Method ----------
        //return subtype;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.559 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "3A963E148C8DEA20E44FBC8909AF4438")
    public void setType(String t) {
        type = t;
        // ---------- Original Method ----------
        //type = t;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.559 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "8F25E54D9A9BC590C1B963D060DAD10B")
    public void setSubtype(String s) {
        subtype = s;
        // ---------- Original Method ----------
        //subtype = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.560 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "32CBEC93F11926AA87894840FA7AD0A4")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_373674053 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_373674053.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_373674053;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.560 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "6557B5E76D80AC6954D67C2673457EFC")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var822120F89FBBB5C4CFE72BFE3775D311_1945228262 =         buffer.append(type)
                .append(SLASH)
                .append(subtype);
        var822120F89FBBB5C4CFE72BFE3775D311_1945228262.addTaint(taint);
        return var822120F89FBBB5C4CFE72BFE3775D311_1945228262;
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.560 -0400", hash_original_field = "28543EEEEEA7165D9CAE0C91318BC23B", hash_generated_field = "3BDB1FA41CCA61D52855E12BDAC970C8")

    private static final long serialVersionUID = -6297125815438079210L;
}

