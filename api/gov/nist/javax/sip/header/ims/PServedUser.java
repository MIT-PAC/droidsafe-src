package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public class PServedUser extends AddressParametersHeader implements PServedUserHeader, SIPHeaderNamesIms, ExtensionHeader {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.077 -0500", hash_original_method = "CE4E031625CF531C1B85FA453494B504", hash_generated_method = "B48AD27966E1B7DFFE9B9527CA54130B")
    
public PServedUser(AddressImpl address)
    {
        super(P_SERVED_USER);
        this.address = address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.081 -0500", hash_original_method = "88679C40290AB234E035EF50535B4D0D", hash_generated_method = "3B3C32F8BB1AD7CD5066F4FD57F1F670")
    
public PServedUser()
    {
        super(NAME);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.084 -0500", hash_original_method = "060F42FFBCCB73E6969A6CFC80051047", hash_generated_method = "3EDCBB4A0986777CC326DD7386B37CA4")
    
public String getRegistrationState() {

        return getParameter(ParameterNamesIms.REGISTRATION_STATE);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.088 -0500", hash_original_method = "86F2D3309EA08C107052AE36BBC425BC", hash_generated_method = "4C67BA0A73478BE61CD4959EE1C4A1C9")
    
public String getSessionCase() {

        return getParameter(ParameterNamesIms.SESSION_CASE);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.092 -0500", hash_original_method = "8A05E91630AB7D0557A40B65641F2C82", hash_generated_method = "9379BA2EE62D17A86403365445475E84")
    
public void setRegistrationState(String registrationState) {

        if((registrationState!=null))
        {
            if(registrationState.equals("reg")||registrationState.equals("unreg"))
            {
                try {
                    setParameter(ParameterNamesIms.REGISTRATION_STATE, registrationState);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
              else
              {
                  try {
                      throw new InvalidArgumentException("Value can be either reg or unreg");
                  } catch (InvalidArgumentException e) {
                         e.printStackTrace();
                    }
              }

        }
        else
        {
            throw new NullPointerException("regstate Parameter value is null");
        }

    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.096 -0500", hash_original_method = "B96D543F72B1B5850C059C4E8A513320", hash_generated_method = "6A89C6E9836237AB0C7C99F13AEF7E83")
    
public void setSessionCase(String sessionCase) {

        if((sessionCase!=null))
        {
            if((sessionCase.equals("orig"))||(sessionCase.equals("term")))
            {
                try {
                    setParameter(ParameterNamesIms.SESSION_CASE, sessionCase);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
              else
              {
                  try {
                    throw new InvalidArgumentException("Value can be either orig or term");
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();
                }

              }
        }
        else
        {
            throw new NullPointerException("sess-case Parameter value is null");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.101 -0500", hash_original_method = "5C1FD3ED8946938E44DEC9CB0584970B", hash_generated_method = "FE4E2B6B85A934B63A498F0FB24596D5")
    
@Override
    protected String encodeBody() {

        StringBuffer retval = new StringBuffer();

        retval.append(address.encode());

        if(parameters.containsKey(ParameterNamesIms.REGISTRATION_STATE))
            retval.append(SEMICOLON).append(ParameterNamesIms.REGISTRATION_STATE).append(EQUALS)
            .append(this.getRegistrationState());

        if(parameters.containsKey(ParameterNamesIms.SESSION_CASE))
            retval.append(SEMICOLON).append(ParameterNamesIms.SESSION_CASE).append(EQUALS)
            .append(this.getSessionCase());

        return retval.toString();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.104 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.108 -0500", hash_original_method = "5DE7CF1B2BFD7CED31E376D58425CB92", hash_generated_method = "6059CEECB96C99BCC3C7E3DFCDF9DD19")
    
public boolean equals(Object other)
    {
         if(other instanceof PServedUser)
         {
            final PServedUserHeader psu = (PServedUserHeader)other;
            return this.getAddress().equals(((PServedUser) other).getAddress());
         }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.112 -0500", hash_original_method = "E31F82669EB953245AD29DB03C98C513", hash_generated_method = "82762806E627604FD622076C83B6858B")
    
public Object clone() {
        PServedUser retval = (PServedUser) super.clone();
        return retval;
    }
    
}

