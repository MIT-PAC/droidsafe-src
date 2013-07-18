package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PAssertedService extends SIPHeader implements PAssertedServiceHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.080 -0400", hash_original_field = "34C97D9F858DE85BE5E1A29DBACD860B", hash_generated_field = "8B30B176BF34BEC26AF3F3FDA86A1827")

    private String subServiceIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.081 -0400", hash_original_field = "1836D1911B2C516403BCBD2A0A20CDCC", hash_generated_field = "7976ED8892ABC041E4713F4D251EC3B6")

    private String subAppIds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.081 -0400", hash_original_method = "182ECFD494AF5D51867F4CB3F9E644EB", hash_generated_method = "6A6E160BAB145753731DA292EEC0188E")
    protected  PAssertedService(String name) {
        super(NAME);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.082 -0400", hash_original_method = "AA5E567A5261831D339C7F3E134619EA", hash_generated_method = "320063B2C7D78E77D8E4F4C11712E1EC")
    public  PAssertedService() {
        super(P_ASSERTED_SERVICE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.083 -0400", hash_original_method = "13CD5B55BBBCA0548D99A959291FFE7D", hash_generated_method = "3D9A2E2AAAD82D662EBD84AF47744148")
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
String var1B324365A764C077A55854483509F4AB_57579995 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_57579995.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_57579995;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.083 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "B3C9669BDABFF20E430FAAC9AE2F8AA0")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_691746089 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_691746089.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_691746089;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.084 -0400", hash_original_method = "C9711D50FDDAB1BC6FA9D8BEA3306598", hash_generated_method = "179DA99A5E9FC67848F74A5C9039FFB6")
    public String getApplicationIdentifiers() {
        if(this.subAppIds.charAt(0)=='.')        
        {
String var7916812A23918EC204F845FC7221250B_1506880862 =             this.subAppIds.substring(1);
            var7916812A23918EC204F845FC7221250B_1506880862.addTaint(taint);
            return var7916812A23918EC204F845FC7221250B_1506880862;
        } //End block
String var0F006A3A2B361F089D6C99C0B6CF0955_1314652607 =         this.subAppIds;
        var0F006A3A2B361F089D6C99C0B6CF0955_1314652607.addTaint(taint);
        return var0F006A3A2B361F089D6C99C0B6CF0955_1314652607;
        // ---------- Original Method ----------
        //if(this.subAppIds.charAt(0)=='.')
        //{
            //return this.subAppIds.substring(1);
        //}
        //return this.subAppIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.084 -0400", hash_original_method = "A7D1F6103283AF549702A3BD8A97DA85", hash_generated_method = "5D248B7D01395ED5CD0F2CDB005B75A3")
    public String getSubserviceIdentifiers() {
        if(this.subServiceIds.charAt(0)=='.')        
        {
String var90B5AED4D7D55758FDA74DDFBC627E72_276284769 =             this.subServiceIds.substring(1);
            var90B5AED4D7D55758FDA74DDFBC627E72_276284769.addTaint(taint);
            return var90B5AED4D7D55758FDA74DDFBC627E72_276284769;
        } //End block
String varF0B426A6ADCB9A3BEC397536D0A15B1C_1280464097 =         this.subServiceIds;
        varF0B426A6ADCB9A3BEC397536D0A15B1C_1280464097.addTaint(taint);
        return varF0B426A6ADCB9A3BEC397536D0A15B1C_1280464097;
        // ---------- Original Method ----------
        //if(this.subServiceIds.charAt(0)=='.')
        //{
            //return this.subServiceIds.substring(1);
        //}
        //return this.subServiceIds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.084 -0400", hash_original_method = "0A65ED1D7958A8DC93D54B9D5172FB86", hash_generated_method = "813392CF39A94B938B1B3C7E12E815AD")
    public void setApplicationIdentifiers(String appids) {
        this.subAppIds = appids;
        // ---------- Original Method ----------
        //this.subAppIds = appids;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.085 -0400", hash_original_method = "D85C3DD3D271FDFF4F350559A8282CAD", hash_generated_method = "408F5C6315DFA9E24D9CFBD7DDC9F713")
    public void setSubserviceIdentifiers(String subservices) {
        this.subServiceIds = subservices;
        // ---------- Original Method ----------
        //this.subServiceIds = subservices;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.085 -0400", hash_original_method = "698565353F33C32BACB06EBECCB2189D", hash_generated_method = "D87A3143D225396788D058FBC37ABC4B")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varAC54CD6C0082524B853E30EB0E381537_865909654 = ((other instanceof PAssertedServiceHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683131020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683131020;
        // ---------- Original Method ----------
        //return (other instanceof PAssertedServiceHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.086 -0400", hash_original_method = "3CDC6738E06A7AFD0A34818FC063034A", hash_generated_method = "961CB9D4CC5664E7AE60E6A976AE0200")
    public Object clone() {
        PAssertedService retval = (PAssertedService) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_2041435022 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2041435022.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2041435022;
        // ---------- Original Method ----------
        //PAssertedService retval = (PAssertedService) super.clone();
        //return retval;
    }

    
}

