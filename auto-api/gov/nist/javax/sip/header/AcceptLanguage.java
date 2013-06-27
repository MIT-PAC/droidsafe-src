package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import javax.sip.header.AcceptLanguageHeader;
import javax.sip.InvalidArgumentException;
import java.util.Locale;

public final class AcceptLanguage extends ParametersHeader implements AcceptLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.110 -0400", hash_original_field = "00A2E47D587E93FF949744BBD08BA7A5", hash_generated_field = "D4BB60E55436DA1436A4D43E1F9D33AD")

    protected String languageRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.120 -0400", hash_original_method = "8CFB40CB8981635645AE5871E0424817", hash_generated_method = "416AAE1C28B1E7BEC05C29FC17C2D9BD")
    public  AcceptLanguage() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.121 -0400", hash_original_method = "5C96E87F662C45E10B5AFAE4378612EB", hash_generated_method = "BB4CC6B5CBEACFDECA825CF3866B4055")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_50289003 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            encoding.append(languageRange);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_198436092 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_50289003 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_50289003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_50289003;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (languageRange != null) {
            //encoding.append(languageRange);
        //}
        //if (!parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.122 -0400", hash_original_method = "BF687A0020C7B3DE806879972780BD44", hash_generated_method = "06B22DB226D79BA1E4C4659EB064D3C7")
    public String getLanguageRange() {
        String varB4EAC82CA7396A68D541C85D26508E83_2043434330 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2043434330 = languageRange;
        varB4EAC82CA7396A68D541C85D26508E83_2043434330.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2043434330;
        // ---------- Original Method ----------
        //return languageRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.123 -0400", hash_original_method = "D0BC591A7E62F9425A070C3D9F39D285", hash_generated_method = "AE490C4753AD5072CDDDECA529D7D036")
    public float getQValue() {
        {
            boolean var550BDB23AFCA3962D401CB66DD51CBF9_1214483635 = (!hasParameter("q"));
        } //End collapsed parenthetic
        float var6CBC2F2DD76D931D7B92B925A630C9BF_1436382186 = (((Float) parameters.getValue("q")).floatValue());
        float var546ADE640B6EDFBC8A086EF31347E768_2064051577 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2064051577;
        // ---------- Original Method ----------
        //if (!hasParameter("q"))
            //return -1;
        //return ((Float) parameters.getValue("q")).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.123 -0400", hash_original_method = "889B57ADA5D9BFE59490AB224C7E16F7", hash_generated_method = "0820D5ABAA45F1905FF04D455973CC74")
    public boolean hasQValue() {
        boolean var24680EDBDA260D63E05ABE91EAC744BE_392580494 = (hasParameter("q"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715544494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715544494;
        // ---------- Original Method ----------
        //return hasParameter("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.123 -0400", hash_original_method = "1F181158365375850544D6C69D49DA70", hash_generated_method = "B9DF7AB862F99D0A322AF91814F06427")
    public void removeQValue() {
        removeParameter("q");
        // ---------- Original Method ----------
        //removeParameter("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.147 -0400", hash_original_method = "666F2ACD9F04A9B6B16D40C4651940A3", hash_generated_method = "B5BE0B634C8BDC5639F2A88C87E5B85C")
    public void setLanguageRange(String languageRange) {
        this.languageRange = languageRange.trim();
        // ---------- Original Method ----------
        //this.languageRange = languageRange.trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.149 -0400", hash_original_method = "F0104C17C209B83128CEAC547B311B2B", hash_generated_method = "A4686E26B9FAA2CBD52151E0D5AB54B8")
    public void setQValue(float q) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        this.removeParameter("q");
        this.setParameter(new NameValue("q", Float.valueOf(q)));
        addTaint(q);
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //if (q == -1)
            //this.removeParameter("q");
        //else
            //this.setParameter(new NameValue("q", Float.valueOf(q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.150 -0400", hash_original_method = "41F30A9CB15562B6E2AC4BEA100C59D1", hash_generated_method = "926EBFF0262FE40F32E0B84C040A8630")
    public Locale getAcceptLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_992490275 = null; //Variable for return #1
        Locale varB4EAC82CA7396A68D541C85D26508E83_1995277580 = null; //Variable for return #2
        Locale varB4EAC82CA7396A68D541C85D26508E83_2028132712 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_992490275 = null;
        {
            int dash;
            dash = languageRange.indexOf('-');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1995277580 = new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) );
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2028132712 = new Locale( this.languageRange );
        } //End block
        Locale varA7E53CE21691AB073D9660D615818899_415084546; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_415084546 = varB4EAC82CA7396A68D541C85D26508E83_992490275;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_415084546 = varB4EAC82CA7396A68D541C85D26508E83_1995277580;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_415084546 = varB4EAC82CA7396A68D541C85D26508E83_2028132712;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_415084546.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_415084546;
        // ---------- Original Method ----------
        //if (this.languageRange == null)
            //return null;
        //else {
            //int dash = languageRange.indexOf('-');
            //if (dash>=0) {
                //return new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) );
            //} else return new Locale( this.languageRange );
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.150 -0400", hash_original_method = "8278D8A1AED5A953C4AF44E8C829B9C4", hash_generated_method = "F6D87F8FB2E2A78239249E97C4E01659")
    public void setAcceptLanguage(Locale language) {
        {
            boolean var2C9559255D71F9D94F44F7B3603EF33B_423315949 = ("".equals(language.getCountry()));
            {
                this.languageRange = language.getLanguage();
            } //End block
            {
                this.languageRange = language.getLanguage() + '-' + language.getCountry();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ( "".equals(language.getCountry())) {
            //this.languageRange = language.getLanguage();
        //} else {
            //this.languageRange = language.getLanguage() + '-' + language.getCountry();
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.151 -0400", hash_original_field = "D2372152DD2BB6E17310F399099E0239", hash_generated_field = "264B293AA803F5092EA856D5D1D41EF3")

    private static long serialVersionUID = -4473982069737324919L;
}

