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
    protected String languageRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.642 -0400", hash_original_method = "8CFB40CB8981635645AE5871E0424817", hash_generated_method = "416AAE1C28B1E7BEC05C29FC17C2D9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptLanguage() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.642 -0400", hash_original_method = "5C96E87F662C45E10B5AFAE4378612EB", hash_generated_method = "DDD34BA9D380757BD49F97FE5EF09F24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            encoding.append(languageRange);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2095679366 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_1886839400 = (encoding.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.642 -0400", hash_original_method = "BF687A0020C7B3DE806879972780BD44", hash_generated_method = "02E98387FD2A53DD5127F50E6252A0BA")
    @DSModeled(DSC.SAFE)
    public String getLanguageRange() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return languageRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.642 -0400", hash_original_method = "D0BC591A7E62F9425A070C3D9F39D285", hash_generated_method = "4B19E59B2388CA6A24C9FE4DBF85410E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getQValue() {
        {
            boolean var550BDB23AFCA3962D401CB66DD51CBF9_53022172 = (!hasParameter("q"));
        } //End collapsed parenthetic
        float var6CBC2F2DD76D931D7B92B925A630C9BF_1689828578 = (((Float) parameters.getValue("q")).floatValue());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (!hasParameter("q"))
            //return -1;
        //return ((Float) parameters.getValue("q")).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.642 -0400", hash_original_method = "889B57ADA5D9BFE59490AB224C7E16F7", hash_generated_method = "6FE2CA2E8CD7624D57614F8C4F95D79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasQValue() {
        boolean var24680EDBDA260D63E05ABE91EAC744BE_197624430 = (hasParameter("q"));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParameter("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.643 -0400", hash_original_method = "1F181158365375850544D6C69D49DA70", hash_generated_method = "B9DF7AB862F99D0A322AF91814F06427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeQValue() {
        removeParameter("q");
        // ---------- Original Method ----------
        //removeParameter("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.643 -0400", hash_original_method = "666F2ACD9F04A9B6B16D40C4651940A3", hash_generated_method = "8B235C2F730AB114BE89BBDF65E12674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLanguageRange(String languageRange) {
        dsTaint.addTaint(languageRange);
        this.languageRange = languageRange.trim();
        // ---------- Original Method ----------
        //this.languageRange = languageRange.trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.643 -0400", hash_original_method = "F0104C17C209B83128CEAC547B311B2B", hash_generated_method = "33B9EC9E288474CB6A71D62D8E6347D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQValue(float q) throws InvalidArgumentException {
        dsTaint.addTaint(q);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        this.removeParameter("q");
        this.setParameter(new NameValue("q", Float.valueOf(q)));
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //if (q == -1)
            //this.removeParameter("q");
        //else
            //this.setParameter(new NameValue("q", Float.valueOf(q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.643 -0400", hash_original_method = "41F30A9CB15562B6E2AC4BEA100C59D1", hash_generated_method = "5204A6B15940BBAFDAC86C16A17B8D12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale getAcceptLanguage() {
        {
            int dash;
            dash = languageRange.indexOf('-');
            {
                Locale var4F6C69EB6F399B9EB0A54CDFDE6644F1_77842637 = (new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) ));
            } //End block
            Locale var9C057304FA65FC0D7D0048BA08A64B28_1651256266 = (new Locale( this.languageRange ));
        } //End block
        return (Locale)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.643 -0400", hash_original_method = "8278D8A1AED5A953C4AF44E8C829B9C4", hash_generated_method = "8669BFB98586F48ED0F51FA75DE9A71A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAcceptLanguage(Locale language) {
        dsTaint.addTaint(language.dsTaint);
        {
            boolean var2C9559255D71F9D94F44F7B3603EF33B_819684518 = ("".equals(language.getCountry()));
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

    
    private static final long serialVersionUID = -4473982069737324919L;
}

