package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.AddressParametersHeader;

public class PServedUser extends AddressParametersHeader implements PServedUserHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.054 -0400", hash_original_method = "CE4E031625CF531C1B85FA453494B504", hash_generated_method = "9BF427C5F7D6858A9FE3465C4BC3EB51")
    public  PServedUser(AddressImpl address) {
        super(P_SERVED_USER);
        addTaint(address.getTaint());
        this.address = address;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.055 -0400", hash_original_method = "88679C40290AB234E035EF50535B4D0D", hash_generated_method = "9DF219AB55C86B79DEECEA502C213C52")
    public  PServedUser() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.056 -0400", hash_original_method = "060F42FFBCCB73E6969A6CFC80051047", hash_generated_method = "163D8F608BFE68ADA7321DC041B70AB4")
    public String getRegistrationState() {
String varBFDAF6B74805E26E8C7CDA2F4F0F5708_798677480 =         getParameter(ParameterNamesIms.REGISTRATION_STATE);
        varBFDAF6B74805E26E8C7CDA2F4F0F5708_798677480.addTaint(taint);
        return varBFDAF6B74805E26E8C7CDA2F4F0F5708_798677480;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.056 -0400", hash_original_method = "86F2D3309EA08C107052AE36BBC425BC", hash_generated_method = "AC86B69F8BAD46BA80819F01D68FB8FD")
    public String getSessionCase() {
String var473848B19B95BAF1BACF7CC72F827365_558301345 =         getParameter(ParameterNamesIms.SESSION_CASE);
        var473848B19B95BAF1BACF7CC72F827365_558301345.addTaint(taint);
        return var473848B19B95BAF1BACF7CC72F827365_558301345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.057 -0400", hash_original_method = "8A05E91630AB7D0557A40B65641F2C82", hash_generated_method = "640A013EBB8F1FA419D91432D9C8FAD2")
    public void setRegistrationState(String registrationState) {
        addTaint(registrationState.getTaint());
    if((registrationState!=null))        
        {
    if(registrationState.equals("reg")||registrationState.equals("unreg"))            
            {
                try 
                {
                    setParameter(ParameterNamesIms.REGISTRATION_STATE, registrationState);
                } 
                catch (ParseException e)
                {
                    e.printStackTrace();
                } 
            } 
            else
            {
                try 
                {
                    InvalidArgumentException var7BF9FD0EBAEEEF72642D9AD741F0559A_1057624294 = new InvalidArgumentException("Value can be either reg or unreg");
                    var7BF9FD0EBAEEEF72642D9AD741F0559A_1057624294.addTaint(taint);
                    throw var7BF9FD0EBAEEEF72642D9AD741F0559A_1057624294;
                } 
                catch (InvalidArgumentException e)
                {
                    e.printStackTrace();
                } 
            } 
        } 
        else
        {
            NullPointerException varAC0519D4697286A29B948606823DA531_887750286 = new NullPointerException("regstate Parameter value is null");
            varAC0519D4697286A29B948606823DA531_887750286.addTaint(taint);
            throw varAC0519D4697286A29B948606823DA531_887750286;
        } 
        
        
        
            
            
                
                    
                
                    
                
            
              
              
                  
                      
                  
                         
                    
              
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.058 -0400", hash_original_method = "B96D543F72B1B5850C059C4E8A513320", hash_generated_method = "8BB651A7FF4954F4BCFB011678EDEE4B")
    public void setSessionCase(String sessionCase) {
        addTaint(sessionCase.getTaint());
    if((sessionCase!=null))        
        {
    if((sessionCase.equals("orig"))||(sessionCase.equals("term")))            
            {
                try 
                {
                    setParameter(ParameterNamesIms.SESSION_CASE, sessionCase);
                } 
                catch (ParseException e)
                {
                    e.printStackTrace();
                } 
            } 
            else
            {
                try 
                {
                    InvalidArgumentException var257AE90AB2D38C3A3CD7D73CCAB10F69_381332301 = new InvalidArgumentException("Value can be either orig or term");
                    var257AE90AB2D38C3A3CD7D73CCAB10F69_381332301.addTaint(taint);
                    throw var257AE90AB2D38C3A3CD7D73CCAB10F69_381332301;
                } 
                catch (InvalidArgumentException e)
                {
                    e.printStackTrace();
                } 
            } 
        } 
        else
        {
            NullPointerException varB44C7F82B4A0EB05A88E16A6E952E9DA_416658402 = new NullPointerException("sess-case Parameter value is null");
            varB44C7F82B4A0EB05A88E16A6E952E9DA_416658402.addTaint(taint);
            throw varB44C7F82B4A0EB05A88E16A6E952E9DA_416658402;
        } 
        
        
        
            
            
                
                    
                
                    
                
            
              
              
                  
                    
                
                    
                
              
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.058 -0400", hash_original_method = "5C1FD3ED8946938E44DEC9CB0584970B", hash_generated_method = "C703741CBB334E9BDB35121C4316CE04")
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
String var1B324365A764C077A55854483509F4AB_674772706 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_674772706.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_674772706;
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.059 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "872DF88EF55E15209326B4B172E67851")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_2118874357 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_2118874357.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_2118874357;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.059 -0400", hash_original_method = "5DE7CF1B2BFD7CED31E376D58425CB92", hash_generated_method = "8325ABFB13715729F5090757A817D3A4")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof PServedUser)        
        {
            final PServedUserHeader psu = (PServedUserHeader)other;
            boolean var10A62859C1DC72264993359B9D54A6BF_374336532 = (this.getAddress().equals(((PServedUser) other).getAddress()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_893212122 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_893212122;
        } 
        boolean var68934A3E9455FA72420237EB05902327_2083041325 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434276130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434276130;
        
        
         
            
            
         
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.059 -0400", hash_original_method = "E31F82669EB953245AD29DB03C98C513", hash_generated_method = "FAC0AF6C5866CBEF4146E23D7A6414E3")
    public Object clone() {
        PServedUser retval = (PServedUser) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1570126051 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1570126051.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1570126051;
        
        
        
    }

    
}

