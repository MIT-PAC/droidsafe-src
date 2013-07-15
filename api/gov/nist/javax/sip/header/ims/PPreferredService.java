package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.SIPHeader;

public class PPreferredService extends SIPHeader implements PPreferredServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.021 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.021 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.022 -0400", hash_original_method = "2FB8EC7339BBF3197572778DF84B2394", hash_generated_method = "FCCB9A4D9BB589A3DB266620467C2216")
    protected  PPreferredService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.022 -0400", hash_original_method = "80DD74DB52B5BA3BF0297E04ECC509FE", hash_generated_method = "8906F3091D6728D0A2DF3027DBEFD55A")
    public  PPreferredService() {
        super(P_PREFERRED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.022 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "51A371A1A6960951AD91DE86824F0B27")
    @Override
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();
        retval.append(ParameterNamesIms.SERVICE_ID);
    if(this.subServiceIds!=null)        
        {
            retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            retval.append(this.getSubserviceIdentifiers());
        } //End block
        else
    if(this.subAppIds!=null)        
        {
            retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
            retval.append(this.getApplicationIdentifiers());
        } //End block
String var1B324365A764C077A55854483509F4AB_1546702187 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1546702187.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1546702187;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //retval.append(ParameterNamesIms.SERVICE_ID);
        //if(this.subServiceIds!=null)
            //{
                //retval.append(ParameterNamesIms.SERVICE_ID_LABEL).append(".");
            //retval.append(this.getSubserviceIdentifiers());
            //}
            //else if(this.subAppIds!=null)
            //{
                //retval.append(ParameterNamesIms.APPLICATION_ID_LABEL).append(".");
                //retval.append(this.getApplicationIdentifiers());
            //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.023 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "9B50A205735F4AB0729B0AA94D34BC91")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1968668122 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1968668122.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1968668122;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.024 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "808482714326051BC08F1D74ADCB7D2B")
    public String getApplicationIdentifiers() {
    if(this.subAppIds.charAt(0)=='.')        
        {
String var7916812A23918EC204F845FC7221250B_1142861027 =             this.subAppIds.substring(1);
            var7916812A23918EC204F845FC7221250B_1142861027.addTaint(taint);
            return var7916812A23918EC204F845FC7221250B_1142861027;
        } //End block
String var0F006A3A2B361F089D6C99C0B6CF0955_188389155 =         this.subAppIds;
        var0F006A3A2B361F089D6C99C0B6CF0955_188389155.addTaint(taint);
        return var0F006A3A2B361F089D6C99C0B6CF0955_188389155;
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.024 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "9A8606ADD386E25ABB7593EE58EE7BB7")
    public String getSubserviceIdentifiers() {
    if(this.subServiceIds.charAt(0)=='.')        
        {
String var90B5AED4D7D55758FDA74DDFBC627E72_623404191 =             this.subServiceIds.substring(1);
            var90B5AED4D7D55758FDA74DDFBC627E72_623404191.addTaint(taint);
            return var90B5AED4D7D55758FDA74DDFBC627E72_623404191;
        } //End block
String varF0B426A6ADCB9A3BEC397536D0A15B1C_402281982 =         this.subServiceIds;
        varF0B426A6ADCB9A3BEC397536D0A15B1C_402281982.addTaint(taint);
        return varF0B426A6ADCB9A3BEC397536D0A15B1C_402281982;
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.024 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.025 -0400", hash_original_method = "86174BD2B9F1F7BE8C26F06288A88EF6", hash_generated_method = "B3E4B360308281668CC193B4B051E180")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = ".".concat(subservices);
        // ---------- Original Method ----------
        //this.subServiceIds = ".".concat(subservices);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.025 -0400", hash_original_method = "C4B8C9C88189BDF3DAB8E362AE1162B5", hash_generated_method = "5FD4D51E128650E2660703A1F0AC23CE")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varECBACA7859FEC45A936465DB764EE263_1823974809 = ((other instanceof PPreferredServiceHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978483400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978483400;
        // ---------- Original Method ----------
        //return (other instanceof PPreferredServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.025 -0400", hash_original_method = "924DF1F04CF6C30DB3A78FE0D39487E9", hash_generated_method = "124DFDE438D8D23DDE1FF031E3EB4A72")
    public Object clone() {
        PPreferredService retval = (PPreferredService) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1331902949 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1331902949.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1331902949;
        // ---------- Original Method ----------
        //PPreferredService retval = (PPreferredService) super.clone();
        //return retval;
    }

    
}

