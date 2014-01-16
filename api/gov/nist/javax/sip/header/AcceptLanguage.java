package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;

import java.util.Locale;

import javax.sip.InvalidArgumentException;
import javax.sip.header.AcceptLanguageHeader;

public final class AcceptLanguage extends ParametersHeader implements AcceptLanguageHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.718 -0500", hash_original_field = "BD398B476901B90179098026BF8A891E", hash_generated_field = "C41AD91D885B8E07AB1CF99FE8C6F646")

    private static final long serialVersionUID = -4473982069737324919L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.720 -0500", hash_original_field = "26BEED88610FDB539E7A3450F9A32BAA", hash_generated_field = "D4BB60E55436DA1436A4D43E1F9D33AD")

    protected String languageRange;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.723 -0500", hash_original_method = "8CFB40CB8981635645AE5871E0424817", hash_generated_method = "75824B913F16BD6E58C9722BFA359007")
    
public AcceptLanguage() {
        super(NAME);
    }

    /** Encode the value of this header to a string.
     *@return  encoded header as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.727 -0500", hash_original_method = "5C96E87F662C45E10B5AFAE4378612EB", hash_generated_method = "5958670D7599BB8FAB22387E6D0811E7")
    
protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        if (languageRange != null) {
            encoding.append(languageRange);
        }
        if (!parameters.isEmpty()) {
            encoding.append(SEMICOLON).append(parameters.encode());
        }
        return encoding.toString();
    }

    /** get the LanguageRange field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.730 -0500", hash_original_method = "BF687A0020C7B3DE806879972780BD44", hash_generated_method = "2B40F1802BB45A68DF20FF45A734E79A")
    
public String getLanguageRange() {
        return languageRange;
    }

    /** get the QValue field. Return -1 if the parameter has not been
     * set.
     * @return float
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.732 -0500", hash_original_method = "D0BC591A7E62F9425A070C3D9F39D285", hash_generated_method = "296ED7F62C4FA42CD9C41A04E8EA1248")
    
public float getQValue() {
        if (!hasParameter("q"))
            return -1;
        return ((Float) parameters.getValue("q")).floatValue();
    }

    /**
     * Return true if the q value has been set.
     * @since 1.0
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.735 -0500", hash_original_method = "889B57ADA5D9BFE59490AB224C7E16F7", hash_generated_method = "A32291CA34CEFE2E8D14480FD123B643")
    
public boolean hasQValue() {
        return hasParameter("q");
    }

    /**
     * Remove the q value.
     * @since 1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.738 -0500", hash_original_method = "1F181158365375850544D6C69D49DA70", hash_generated_method = "4C88D912CF4A5C65E82F69DF5E54C385")
    
public void removeQValue() {
        removeParameter("q");
    }

    /**
     * Set the languageRange.
     *
     * @param languageRange is the language range to set.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.740 -0500", hash_original_method = "666F2ACD9F04A9B6B16D40C4651940A3", hash_generated_method = "85ACB49AB3896D56486FF4BD0EA90AAD")
    
public void setLanguageRange(String languageRange) {
        this.languageRange = languageRange.trim();
    }

    /**
     * Sets q-value for media-range in AcceptLanguageHeader. Q-values allow the
     *
     * user to indicate the relative degree of preference for that media-range,
     *
     * using the qvalue scale from 0 to 1. If no q-value is present, the
     *
     * media-range should be treated as having a q-value of 1.
     *
     *
     *
     * @param q The new float value of the q-value, a value of -1 resets
     * the qValue.
     *
     * @throws InvalidArgumentException if the q parameter value is not
     *
     * <code>-1</code> or between <code>0 and 1</code>.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.743 -0500", hash_original_method = "F0104C17C209B83128CEAC547B311B2B", hash_generated_method = "BBDE959A717E51F1373821850302CC48")
    
public void setQValue(float q) throws InvalidArgumentException {
        if (q < 0.0 || q > 1.0)
            throw new InvalidArgumentException("qvalue out of range!");
        if (q == -1)
            this.removeParameter("q");
        else
            this.setParameter(new NameValue("q", Float.valueOf(q)));
    }

    /**
     * Gets the language value of the AcceptLanguageHeader.
     *
     *
     *
     * @return the language Locale value of this AcceptLanguageHeader
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.746 -0500", hash_original_method = "41F30A9CB15562B6E2AC4BEA100C59D1", hash_generated_method = "D38F845B33CA5C0C380E01B2CC1372CB")
    
public Locale getAcceptLanguage() {
        if (this.languageRange == null)
            return null;
        else {
            int dash = languageRange.indexOf('-');
            if (dash>=0) {
                return new Locale( languageRange.substring(0,dash), languageRange.substring(dash+1) );
            } else return new Locale( this.languageRange );
        }
    }

    /**
     * Sets the language parameter of this AcceptLanguageHeader.
     *
     *
     *
     * @param language - the new Locale value of the language of
     *
     * AcceptLanguageHeader
     *
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:09.749 -0500", hash_original_method = "8278D8A1AED5A953C4AF44E8C829B9C4", hash_generated_method = "36357FB207208F3B507E411C58699198")
    
public void setAcceptLanguage(Locale language) {
        // JvB: need to take sub-tag into account
        if ( "".equals(language.getCountry())) {
            this.languageRange = language.getLanguage();
        } else {
            this.languageRange = language.getLanguage() + '-' + language.getCountry();
        }
    }
}

