package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PServedUser extends AddressParametersHeader implements PServedUserHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.284 -0400", hash_original_method = "CE4E031625CF531C1B85FA453494B504", hash_generated_method = "9BF427C5F7D6858A9FE3465C4BC3EB51")
    public  PServedUser(AddressImpl address) {
        super(P_SERVED_USER);
        addTaint(address.getTaint());
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.285 -0400", hash_original_method = "88679C40290AB234E035EF50535B4D0D", hash_generated_method = "9DF219AB55C86B79DEECEA502C213C52")
    public  PServedUser() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.285 -0400", hash_original_method = "060F42FFBCCB73E6969A6CFC80051047", hash_generated_method = "2D0EF5057F6AE8952FD25126F876D7F4")
    public String getRegistrationState() {
String varBFDAF6B74805E26E8C7CDA2F4F0F5708_633198051 =         getParameter(ParameterNamesIms.REGISTRATION_STATE);
        varBFDAF6B74805E26E8C7CDA2F4F0F5708_633198051.addTaint(taint);
        return varBFDAF6B74805E26E8C7CDA2F4F0F5708_633198051;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.REGISTRATION_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.285 -0400", hash_original_method = "86F2D3309EA08C107052AE36BBC425BC", hash_generated_method = "FECDB82F7D6E24E51703A2A125E1D0BC")
    public String getSessionCase() {
String var473848B19B95BAF1BACF7CC72F827365_1266415076 =         getParameter(ParameterNamesIms.SESSION_CASE);
        var473848B19B95BAF1BACF7CC72F827365_1266415076.addTaint(taint);
        return var473848B19B95BAF1BACF7CC72F827365_1266415076;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.SESSION_CASE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.286 -0400", hash_original_method = "8A05E91630AB7D0557A40B65641F2C82", hash_generated_method = "269B067FEAEC03B2F96B7B687988F745")
    public void setRegistrationState(String registrationState) {
        addTaint(registrationState.getTaint());
        if((registrationState!=null))        
        {
            if(registrationState.equals("reg")||registrationState.equals("unreg"))            
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
            else
            {
                try 
                {
                    InvalidArgumentException var7BF9FD0EBAEEEF72642D9AD741F0559A_727565037 = new InvalidArgumentException("Value can be either reg or unreg");
                    var7BF9FD0EBAEEEF72642D9AD741F0559A_727565037.addTaint(taint);
                    throw var7BF9FD0EBAEEEF72642D9AD741F0559A_727565037;
                } //End block
                catch (InvalidArgumentException e)
                {
                    e.printStackTrace();
                } //End block
            } //End block
        } //End block
        else
        {
            NullPointerException varAC0519D4697286A29B948606823DA531_833047085 = new NullPointerException("regstate Parameter value is null");
            varAC0519D4697286A29B948606823DA531_833047085.addTaint(taint);
            throw varAC0519D4697286A29B948606823DA531_833047085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.287 -0400", hash_original_method = "B96D543F72B1B5850C059C4E8A513320", hash_generated_method = "B2CEA0CF2EBF442CCDB337A971BF90D4")
    public void setSessionCase(String sessionCase) {
        addTaint(sessionCase.getTaint());
        if((sessionCase!=null))        
        {
            if((sessionCase.equals("orig"))||(sessionCase.equals("term")))            
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
            else
            {
                try 
                {
                    InvalidArgumentException var257AE90AB2D38C3A3CD7D73CCAB10F69_509068291 = new InvalidArgumentException("Value can be either orig or term");
                    var257AE90AB2D38C3A3CD7D73CCAB10F69_509068291.addTaint(taint);
                    throw var257AE90AB2D38C3A3CD7D73CCAB10F69_509068291;
                } //End block
                catch (InvalidArgumentException e)
                {
                    e.printStackTrace();
                } //End block
            } //End block
        } //End block
        else
        {
            NullPointerException varB44C7F82B4A0EB05A88E16A6E952E9DA_1911524150 = new NullPointerException("sess-case Parameter value is null");
            varB44C7F82B4A0EB05A88E16A6E952E9DA_1911524150.addTaint(taint);
            throw varB44C7F82B4A0EB05A88E16A6E952E9DA_1911524150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.288 -0400", hash_original_method = "5C1FD3ED8946938E44DEC9CB0584970B", hash_generated_method = "470DE98F2F9B006921FE1F2CA5DF3C79")
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
String var1B324365A764C077A55854483509F4AB_1733757118 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1733757118.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1733757118;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.289 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "1759F21EB763CCF029E05891777BAD5F")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_836876268 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_836876268.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_836876268;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.289 -0400", hash_original_method = "5DE7CF1B2BFD7CED31E376D58425CB92", hash_generated_method = "D49FE7DB80DF402BA99ECF63C4B4B576")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof PServedUser)        
        {
            final PServedUserHeader psu = (PServedUserHeader)other;
            boolean var10A62859C1DC72264993359B9D54A6BF_1547801876 = (this.getAddress().equals(((PServedUser) other).getAddress()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233684599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233684599;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1177027943 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971990028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971990028;
        // ---------- Original Method ----------
        //if(other instanceof PServedUser)
         //{
            //final PServedUserHeader psu = (PServedUserHeader)other;
            //return this.getAddress().equals(((PServedUser) other).getAddress());
         //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.290 -0400", hash_original_method = "E31F82669EB953245AD29DB03C98C513", hash_generated_method = "CEADEF459DF3863E7CB92E305A805E4C")
    public Object clone() {
        PServedUser retval = (PServedUser) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1449720132 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1449720132.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1449720132;
        // ---------- Original Method ----------
        //PServedUser retval = (PServedUser) super.clone();
        //return retval;
    }

    
}

