package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MediaRange extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.586 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "07EA10A7183817BDD507DF1E4B45BF61")

    protected String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.586 -0400", hash_original_field = "2E282B0D23D6EC55185CAEB87B41C0E0", hash_generated_field = "D2D46B7267A80714A8F9897271A241D8")

    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.586 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    public  MediaRange() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.587 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "03C4BC840CD7879BBD89D4711B7437EB")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_2139309576 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_2139309576.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_2139309576;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.587 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "D8242A5EFF21ADC9C97149F9CD5FC90C")
    public String getSubtype() {
String var169367A745E19D18DAC62A70AF6FE5E6_1733474077 =         subtype;
        var169367A745E19D18DAC62A70AF6FE5E6_1733474077.addTaint(taint);
        return var169367A745E19D18DAC62A70AF6FE5E6_1733474077;
        // ---------- Original Method ----------
        //return subtype;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.588 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "3A963E148C8DEA20E44FBC8909AF4438")
    public void setType(String t) {
        type = t;
        // ---------- Original Method ----------
        //type = t;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.588 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "8F25E54D9A9BC590C1B963D060DAD10B")
    public void setSubtype(String s) {
        subtype = s;
        // ---------- Original Method ----------
        //subtype = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.588 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "C03560A705EC85667355BFA875CB47C8")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1594453312 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1594453312.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1594453312;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.589 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "CF32242B2D5502384C1C3FAA09E76439")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var822120F89FBBB5C4CFE72BFE3775D311_386495497 =         buffer.append(type)
                .append(SLASH)
                .append(subtype);
        var822120F89FBBB5C4CFE72BFE3775D311_386495497.addTaint(taint);
        return var822120F89FBBB5C4CFE72BFE3775D311_386495497;
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.589 -0400", hash_original_field = "28543EEEEEA7165D9CAE0C91318BC23B", hash_generated_field = "3BDB1FA41CCA61D52855E12BDAC970C8")

    private static final long serialVersionUID = -6297125815438079210L;
}

