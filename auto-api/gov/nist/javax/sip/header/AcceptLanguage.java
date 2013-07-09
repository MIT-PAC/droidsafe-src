package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import javax.sip.header.AcceptLanguageHeader;
import javax.sip.InvalidArgumentException;
import java.util.Locale;

public final class AcceptLanguage extends ParametersHeader implements AcceptLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.819 -0400", hash_original_field = "00A2E47D587E93FF949744BBD08BA7A5", hash_generated_field = "D4BB60E55436DA1436A4D43E1F9D33AD")

    protected String languageRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.820 -0400", hash_original_method = "8CFB40CB8981635645AE5871E0424817", hash_generated_method = "416AAE1C28B1E7BEC05C29FC17C2D9BD")
    public  AcceptLanguage() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.821 -0400", hash_original_method = "5C96E87F662C45E10B5AFAE4378612EB", hash_generated_method = "E81CD61607ABFA8ED94164CBE579932E")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1720256846 = null; 
        StringBuffer encoding = new StringBuffer();
        {
            encoding.append(languageRange);
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_752053704 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1720256846 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1720256846.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1720256846;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.822 -0400", hash_original_method = "BF687A0020C7B3DE806879972780BD44", hash_generated_method = "0A4CC33F464518518EE79309A1E7DC4A")
    public String getLanguageRange() {
        String varB4EAC82CA7396A68D541C85D26508E83_1100655132 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1100655132 = languageRange;
        varB4EAC82CA7396A68D541C85D26508E83_1100655132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1100655132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.823 -0400", hash_original_method = "D0BC591A7E62F9425A070C3D9F39D285", hash_generated_method = "7BA5CB684EE04A877C63D56E2C8C037C")
    public float getQValue() {
        {
            boolean var550BDB23AFCA3962D401CB66DD51CBF9_1725520278 = (!hasParameter("q"));
        } 
        float var6CBC2F2DD76D931D7B92B925A630C9BF_536453930 = (((Float) parameters.getValue("q")).floatValue());
        float var546ADE640B6EDFBC8A086EF31347E768_1710899974 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1710899974;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.824 -0400", hash_original_method = "889B57ADA5D9BFE59490AB224C7E16F7", hash_generated_method = "540F9009AA06021556356257C1BA1D31")
    public boolean hasQValue() {
        boolean var24680EDBDA260D63E05ABE91EAC744BE_414159203 = (hasParameter("q"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627599033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627599033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.824 -0400", hash_original_method = "1F181158365375850544D6C69D49DA70", hash_generated_method = "B9DF7AB862F99D0A322AF91814F06427")
    public void removeQValue() {
        removeParameter("q");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.825 -0400", hash_original_method = "666F2ACD9F04A9B6B16D40C4651940A3", hash_generated_method = "B5BE0B634C8BDC5639F2A88C87E5B85C")
    public void setLanguageRange(String languageRange) {
        this.languageRange = languageRange.trim();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.825 -0400", hash_original_method = "F0104C17C209B83128CEAC547B311B2B", hash_generated_method = "A4686E26B9FAA2CBD52151E0D5AB54B8")
    public void setQValue(float q) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        this.removeParameter("q");
        this.setParameter(new NameValue("q", Float.valueOf(q)));
        addTaint(q);
        
        
            
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.826 -0400", hash_original_method = "41F30A9CB15562B6E2AC4BEA100C59D1", hash_generated_method = "D42EB3B8084848D913AC293898AA2BAC")
    public Locale getAcceptLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_257237797 = null; 
        Locale varB4EAC82CA7396A68D541C85D26508E83_977748896 = null; 
        Locale varB4EAC82CA7396A68D541C85D26508E83_1303416798 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_257237797 = null;
        {
            int dash = languageRange.indexOf('-');
            {
                varB4EAC82CA7396A68D541C85D26508E83_977748896 = new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) );
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1303416798 = new Locale( this.languageRange );
        } 
        Locale varA7E53CE21691AB073D9660D615818899_162050626; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_162050626 = varB4EAC82CA7396A68D541C85D26508E83_257237797;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_162050626 = varB4EAC82CA7396A68D541C85D26508E83_977748896;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_162050626 = varB4EAC82CA7396A68D541C85D26508E83_1303416798;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_162050626.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_162050626;
        
        
            
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.828 -0400", hash_original_method = "8278D8A1AED5A953C4AF44E8C829B9C4", hash_generated_method = "F47B700C652637F69A9E4148CA47D87B")
    public void setAcceptLanguage(Locale language) {
        {
            boolean var2C9559255D71F9D94F44F7B3603EF33B_654813267 = ("".equals(language.getCountry()));
            {
                this.languageRange = language.getLanguage();
            } 
            {
                this.languageRange = language.getLanguage() + '-' + language.getCountry();
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.828 -0400", hash_original_field = "D2372152DD2BB6E17310F399099E0239", hash_generated_field = "C41AD91D885B8E07AB1CF99FE8C6F646")

    private static final long serialVersionUID = -4473982069737324919L;
}

