package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PServedUser extends AddressParametersHeader implements PServedUserHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.607 -0400", hash_original_method = "CE4E031625CF531C1B85FA453494B504", hash_generated_method = "19F6017AC68AEC82790D1F046CCF9D89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PServedUser(AddressImpl address) {
        super(P_SERVED_USER);
        dsTaint.addTaint(address.dsTaint);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.607 -0400", hash_original_method = "88679C40290AB234E035EF50535B4D0D", hash_generated_method = "9DF219AB55C86B79DEECEA502C213C52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PServedUser() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.607 -0400", hash_original_method = "060F42FFBCCB73E6969A6CFC80051047", hash_generated_method = "F7D62E40701BA39487CD3B6307921311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRegistrationState() {
        String var056C44914D7B69DCBA85CFE3E75CA14C_593316026 = (getParameter(ParameterNamesIms.REGISTRATION_STATE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.REGISTRATION_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.607 -0400", hash_original_method = "86F2D3309EA08C107052AE36BBC425BC", hash_generated_method = "F7842B5C7B6A5D9AA265DF8D0937CC23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSessionCase() {
        String var2C79C1FAE5E7917ED22CD3B51C9B3BB8_755611008 = (getParameter(ParameterNamesIms.SESSION_CASE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.SESSION_CASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.608 -0400", hash_original_method = "8A05E91630AB7D0557A40B65641F2C82", hash_generated_method = "09B7FF8D627FB8F89224B9DE5FD16BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRegistrationState(String registrationState) {
        dsTaint.addTaint(registrationState);
        {
            {
                boolean varBA8681E7A138FDBF12BDB0A2B4AEE0BD_1235963610 = (registrationState.equals("reg")||registrationState.equals("unreg"));
                {
                    try 
                    {
                        setParameter(ParameterNamesIms.REGISTRATION_STATE, registrationState);
                    } //End block
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
                {
                    try 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value can be either reg or unreg");
                    } //End block
                    catch (InvalidArgumentException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("regstate Parameter value is null");
        } //End block
        // ---------- Original Method ----------
        //if((registrationState!=null))
        //{
            //if(registrationState.equals("reg")||registrationState.equals("unreg"))
            //{
                //try {
                    //setParameter(ParameterNamesIms.REGISTRATION_STATE, registrationState);
                //} catch (ParseException e) {
                    //e.printStackTrace();
                //}
            //}
              //else
              //{
                  //try {
                      //throw new InvalidArgumentException("Value can be either reg or unreg");
                  //} catch (InvalidArgumentException e) {
                         //e.printStackTrace();
                    //}
              //}
        //}
        //else
        //{
            //throw new NullPointerException("regstate Parameter value is null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.608 -0400", hash_original_method = "B96D543F72B1B5850C059C4E8A513320", hash_generated_method = "1C137BF4E0A539DAAF36FC4C85752EFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSessionCase(String sessionCase) {
        dsTaint.addTaint(sessionCase);
        {
            {
                boolean var06E6B3A3543F32AF4A1823DD7B4D6730_1022772493 = ((sessionCase.equals("orig"))||(sessionCase.equals("term")));
                {
                    try 
                    {
                        setParameter(ParameterNamesIms.SESSION_CASE, sessionCase);
                    } //End block
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
                {
                    try 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value can be either orig or term");
                    } //End block
                    catch (InvalidArgumentException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("sess-case Parameter value is null");
        } //End block
        // ---------- Original Method ----------
        //if((sessionCase!=null))
        //{
            //if((sessionCase.equals("orig"))||(sessionCase.equals("term")))
            //{
                //try {
                    //setParameter(ParameterNamesIms.SESSION_CASE, sessionCase);
                //} catch (ParseException e) {
                    //e.printStackTrace();
                //}
            //}
              //else
              //{
                  //try {
                    //throw new InvalidArgumentException("Value can be either orig or term");
                //} catch (InvalidArgumentException e) {
                    //e.printStackTrace();
                //}
              //}
        //}
        //else
        //{
            //throw new NullPointerException("sess-case Parameter value is null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.608 -0400", hash_original_method = "5C1FD3ED8946938E44DEC9CB0584970B", hash_generated_method = "EDFE7A05A6C50341E0F3274046CC335C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        retval.append(address.encode());
        {
            boolean varD3C027666130F10CDC2A85B288EA20D6_1777933096 = (parameters.containsKey(ParameterNamesIms.REGISTRATION_STATE));
            retval.append(SEMICOLON).append(ParameterNamesIms.REGISTRATION_STATE).append(EQUALS)
            .append(this.getRegistrationState());
        } //End collapsed parenthetic
        {
            boolean var441A52915CCC05FB5E68369C7AE68912_1913413263 = (parameters.containsKey(ParameterNamesIms.SESSION_CASE));
            retval.append(SEMICOLON).append(ParameterNamesIms.SESSION_CASE).append(EQUALS)
            .append(this.getSessionCase());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1199691755 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //retval.append(address.encode());
        //if(parameters.containsKey(ParameterNamesIms.REGISTRATION_STATE))
            //retval.append(SEMICOLON).append(ParameterNamesIms.REGISTRATION_STATE).append(EQUALS)
            //.append(this.getRegistrationState());
        //if(parameters.containsKey(ParameterNamesIms.SESSION_CASE))
            //retval.append(SEMICOLON).append(ParameterNamesIms.SESSION_CASE).append(EQUALS)
            //.append(this.getSessionCase());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.609 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.609 -0400", hash_original_method = "5DE7CF1B2BFD7CED31E376D58425CB92", hash_generated_method = "F465F40E8B062F2B253B118CBB34A5B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            PServedUserHeader psu;
            psu = (PServedUserHeader)other;
            boolean varD89FCAB86EA829CE7D9EF46AFDFD7F15_125743780 = (this.getAddress().equals(((PServedUser) other).getAddress()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if(other instanceof PServedUser)
         //{
            //final PServedUserHeader psu = (PServedUserHeader)other;
            //return this.getAddress().equals(((PServedUser) other).getAddress());
         //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.609 -0400", hash_original_method = "E31F82669EB953245AD29DB03C98C513", hash_generated_method = "7EA98330B69D0E098C4248EFB91A44B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PServedUser retval;
        retval = (PServedUser) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PServedUser retval = (PServedUser) super.clone();
        //return retval;
    }

    
}

