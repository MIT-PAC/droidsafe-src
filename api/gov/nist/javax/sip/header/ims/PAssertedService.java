package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.header.ExtensionHeader;

public class PAssertedService extends SIPHeader implements PAssertedServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.879 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.879 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.880 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "6A6E160BAB145753731DA292EEC0188E")
    protected  PAssertedService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.880 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    public  PAssertedService() {
        super(P_ASSERTED_SERVICE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.882 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "1BF2FAAA9656B3A0E0247B76449C5C72")
    @Override
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();
        retval.append(ParameterNamesIms.SERVICE_ID);
    if(this.subServiceIds!=null)        
        {
            retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            retval.append(this.getSubserviceIdentifiers());
        } 
        else
    if(this.subAppIds!=null)        
        {
            retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
            retval.append(this.getApplicationIdentifiers());
        } 
String var1B324365A764C077A55854483509F4AB_1380885051 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1380885051.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1380885051;
        
        
        
        
            
                
            
            
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.882 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "DE930329D7FD80C4CC30586479E30B28")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_810705195 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_810705195.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_810705195;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.883 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "83068C3393566019EACF474290868F2B")
    public String getApplicationIdentifiers() {
    if(this.subAppIds.charAt(0)=='.')        
        {
String var7916812A23918EC204F845FC7221250B_1589838255 =             this.subAppIds.substring(1);
            var7916812A23918EC204F845FC7221250B_1589838255.addTaint(taint);
            return var7916812A23918EC204F845FC7221250B_1589838255;
        } 
String var0F006A3A2B361F089D6C99C0B6CF0955_117643129 =         this.subAppIds;
        var0F006A3A2B361F089D6C99C0B6CF0955_117643129.addTaint(taint);
        return var0F006A3A2B361F089D6C99C0B6CF0955_117643129;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.883 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "1D8A6F518AA2C71619E9201546131407")
    public String getSubserviceIdentifiers() {
    if(this.subServiceIds.charAt(0)=='.')        
        {
String var90B5AED4D7D55758FDA74DDFBC627E72_624595144 =             this.subServiceIds.substring(1);
            var90B5AED4D7D55758FDA74DDFBC627E72_624595144.addTaint(taint);
            return var90B5AED4D7D55758FDA74DDFBC627E72_624595144;
        } 
String varF0B426A6ADCB9A3BEC397536D0A15B1C_1149991489 =         this.subServiceIds;
        varF0B426A6ADCB9A3BEC397536D0A15B1C_1149991489.addTaint(taint);
        return varF0B426A6ADCB9A3BEC397536D0A15B1C_1149991489;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.884 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.884 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "408F5C6315DFA9E24D9CFBD7DDC9F713")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.885 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "0D8333B883302857B81C3B9A81D2A357")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varAC54CD6C0082524B853E30EB0E381537_1520513974 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882228588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882228588;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.885 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "E97D8635F572705290F398F99132D97D")
    public Object clone() {
        PAssertedService retval = (PAssertedService) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1521048309 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1521048309.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1521048309;
        
        
        
    }

    
}

