package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import javax.sip.header.AcceptLanguageHeader;
import javax.sip.InvalidArgumentException;
import java.util.Locale;

public final class AcceptLanguage extends ParametersHeader implements AcceptLanguageHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.678 -0400", hash_original_field = "00A2E47D587E93FF949744BBD08BA7A5", hash_generated_field = "D4BB60E55436DA1436A4D43E1F9D33AD")

    protected String languageRange;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.678 -0400", hash_original_method = "8CFB40CB8981635645AE5871E0424817", hash_generated_method = "416AAE1C28B1E7BEC05C29FC17C2D9BD")
    public  AcceptLanguage() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.679 -0400", hash_original_method = "5C96E87F662C45E10B5AFAE4378612EB", hash_generated_method = "0ED0E1393DE476333F616AA9242E7C43")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
    if(languageRange != null)        
        {
            encoding.append(languageRange);
        } //End block
    if(!parameters.isEmpty())        
        {
            encoding.append(SEMICOLON).append(parameters.encode());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1949796331 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1949796331.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1949796331;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.680 -0400", hash_original_method = "BF687A0020C7B3DE806879972780BD44", hash_generated_method = "D6F61AA75E7512C6ACC69A7FFA784B86")
    public String getLanguageRange() {
String varEDB5666D43B62B5FC936F611A2EEF981_1146629187 =         languageRange;
        varEDB5666D43B62B5FC936F611A2EEF981_1146629187.addTaint(taint);
        return varEDB5666D43B62B5FC936F611A2EEF981_1146629187;
        // ---------- Original Method ----------
        //return languageRange;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.680 -0400", hash_original_method = "D0BC591A7E62F9425A070C3D9F39D285", hash_generated_method = "935EAFA824F9E6DB87E89D2F6AE81993")
    public float getQValue() {
    if(!hasParameter("q"))        
        {
        float var6BB61E3B7BCE0931DA574D19D1D82C88_1874436469 = (-1);
                float var546ADE640B6EDFBC8A086EF31347E768_2113964931 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2113964931;
        }
        float varE54294F0FFE03113B62F9A0B91676873_880898351 = (((Float) parameters.getValue("q")).floatValue());
                float var546ADE640B6EDFBC8A086EF31347E768_272791565 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_272791565;
        // ---------- Original Method ----------
        //if (!hasParameter("q"))
            //return -1;
        //return ((Float) parameters.getValue("q")).floatValue();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.681 -0400", hash_original_method = "889B57ADA5D9BFE59490AB224C7E16F7", hash_generated_method = "2A8ED22DAE8E3C39B050EF12AF6CBB96")
    public boolean hasQValue() {
        boolean var303355EC85ECD757D595EAFF79E661E0_2131612956 = (hasParameter("q"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713573831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713573831;
        // ---------- Original Method ----------
        //return hasParameter("q");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.681 -0400", hash_original_method = "1F181158365375850544D6C69D49DA70", hash_generated_method = "B9DF7AB862F99D0A322AF91814F06427")
    public void removeQValue() {
        removeParameter("q");
        // ---------- Original Method ----------
        //removeParameter("q");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.682 -0400", hash_original_method = "666F2ACD9F04A9B6B16D40C4651940A3", hash_generated_method = "B5BE0B634C8BDC5639F2A88C87E5B85C")
    public void setLanguageRange(String languageRange) {
        this.languageRange = languageRange.trim();
        // ---------- Original Method ----------
        //this.languageRange = languageRange.trim();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.682 -0400", hash_original_method = "F0104C17C209B83128CEAC547B311B2B", hash_generated_method = "A5C5EE14CFB52341983E8F34D11E6154")
    public void setQValue(float q) throws InvalidArgumentException {
        addTaint(q);
    if(q < 0.0 || q > 1.0)        
        {
        InvalidArgumentException var9B8565E3F346FBBBFE76E5273CB2EE74_603598519 = new InvalidArgumentException("qvalue out of range!");
        var9B8565E3F346FBBBFE76E5273CB2EE74_603598519.addTaint(taint);
        throw var9B8565E3F346FBBBFE76E5273CB2EE74_603598519;
        }
    if(q == -1)        
        this.removeParameter("q");
        else
        this.setParameter(new NameValue("q", Float.valueOf(q)));
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //if (q == -1)
            //this.removeParameter("q");
        //else
            //this.setParameter(new NameValue("q", Float.valueOf(q)));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.683 -0400", hash_original_method = "41F30A9CB15562B6E2AC4BEA100C59D1", hash_generated_method = "36CE8091FF963B7703158F26156C5304")
    public Locale getAcceptLanguage() {
    if(this.languageRange == null)        
        {
Locale var540C13E9E156B687226421B24F2DF178_1818894649 =         null;
        var540C13E9E156B687226421B24F2DF178_1818894649.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1818894649;
        }
        else
        {
            int dash = languageRange.indexOf('-');
    if(dash>=0)            
            {
Locale var9EDF09E7F0F4764876CC56A4FC512E82_586101755 =                 new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) );
                var9EDF09E7F0F4764876CC56A4FC512E82_586101755.addTaint(taint);
                return var9EDF09E7F0F4764876CC56A4FC512E82_586101755;
            } //End block
            else
            {
Locale var8CDF80AA28E3FBEFF1789486242BBD33_1537675196 =             new Locale( this.languageRange );
            var8CDF80AA28E3FBEFF1789486242BBD33_1537675196.addTaint(taint);
            return var8CDF80AA28E3FBEFF1789486242BBD33_1537675196;
            }
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.684 -0400", hash_original_method = "8278D8A1AED5A953C4AF44E8C829B9C4", hash_generated_method = "B0E6575791DB94BF9F696E456C973E01")
    public void setAcceptLanguage(Locale language) {
    if("".equals(language.getCountry()))        
        {
            this.languageRange = language.getLanguage();
        } //End block
        else
        {
            this.languageRange = language.getLanguage() + '-' + language.getCountry();
        } //End block
        // ---------- Original Method ----------
        //if ( "".equals(language.getCountry())) {
            //this.languageRange = language.getLanguage();
        //} else {
            //this.languageRange = language.getLanguage() + '-' + language.getCountry();
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.685 -0400", hash_original_field = "D2372152DD2BB6E17310F399099E0239", hash_generated_field = "C41AD91D885B8E07AB1CF99FE8C6F646")

    private static final long serialVersionUID = -4473982069737324919L;
}

