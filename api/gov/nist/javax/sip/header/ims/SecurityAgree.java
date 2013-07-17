package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.Parameters;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import gov.nist.javax.sip.header.ParametersHeader;

public abstract class SecurityAgree extends ParametersHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.419 -0400", hash_original_field = "6F427A203D04EECAF79CE90CA0A1A976", hash_generated_field = "A39B9CA7C0E64EFBAEF9BF1842BA8543")

    private String secMechanism;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.420 -0400", hash_original_method = "37860681C961C756ECC7AFD430C41B9D", hash_generated_method = "8FD81F49C9A2C9E9D825D2785A8A98DB")
    public  SecurityAgree(String name) {
        super(name);
        addTaint(name.getTaint());
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.421 -0400", hash_original_method = "0AED97FED716BE0BE4710B84F9A63527", hash_generated_method = "DE3AB21BDF30B86B04AD74FD31846F54")
    public  SecurityAgree() {
        super();
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.421 -0400", hash_original_method = "9AC5B140B15B11CFD450C965DE3EDCEF", hash_generated_method = "9DD88FE6B6F7536DAF7EF925E5E5B6E7")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(value == null)        
        {
        NullPointerException var5581ED2812AE061277296C54374A63DE_991897423 = new NullPointerException("null value");
        var5581ED2812AE061277296C54374A63DE_991897423.addTaint(taint);
        throw var5581ED2812AE061277296C54374A63DE_991897423;
        }
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        if(nv == null)        
        {
            nv = new NameValue(name, value);
            if(name.equalsIgnoreCase(ParameterNamesIms.D_VER))            
            {
                nv.setQuotedValue();
                if(value.startsWith(Separators.DOUBLE_QUOTE))                
                {
                ParseException varE60A0A92BA5CA1ED6CE0AA8D83CBF780_136793378 = new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                varE60A0A92BA5CA1ED6CE0AA8D83CBF780_136793378.addTaint(taint);
                throw varE60A0A92BA5CA1ED6CE0AA8D83CBF780_136793378;
                }
            } //End block
            super.setParameter(nv);
        } //End block
        else
        {
            nv.setValueAsObject(value);
        } //End block
        // ---------- Original Method ----------
        //if (value == null)
            //throw new NullPointerException("null value");
        //NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        //if (nv == null)
        //{
            //nv = new NameValue(name, value);
            //if (name.equalsIgnoreCase(ParameterNamesIms.D_VER))
            //{
                //nv.setQuotedValue();
                //if (value.startsWith(Separators.DOUBLE_QUOTE))
                    //throw new ParseException(value
                            //+ " : Unexpected DOUBLE_QUOTE", 0);
            //}
            //super.setParameter(nv);
        //}
        //else
        //{
            //nv.setValueAsObject(value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.422 -0400", hash_original_method = "6B925B5DF777A76390B5A8992D469F0E", hash_generated_method = "D0CE19C255A8596BFF44C0A56A5E704E")
    public String encodeBody() {
String varB363CAFDFEE7E20CD6BC0E1D20681BC7_2059111907 =         this.secMechanism + SEMICOLON + SP + parameters.encode();
        varB363CAFDFEE7E20CD6BC0E1D20681BC7_2059111907.addTaint(taint);
        return varB363CAFDFEE7E20CD6BC0E1D20681BC7_2059111907;
        // ---------- Original Method ----------
        //return this.secMechanism + SEMICOLON + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.423 -0400", hash_original_method = "26617F329EF35F53927C51BE793DE18C", hash_generated_method = "05CEC45B58BC57456F87E532737EEFBE")
    public void setSecurityMechanism(String secMech) throws ParseException {
        if(secMech == null)        
        {
        NullPointerException var1E2FE2E725583A02D321C97BD8BDEA08_584525410 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        var1E2FE2E725583A02D321C97BD8BDEA08_584525410.addTaint(taint);
        throw var1E2FE2E725583A02D321C97BD8BDEA08_584525410;
        }
        this.secMechanism = secMech;
        // ---------- Original Method ----------
        //if (secMech == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        //this.secMechanism = secMech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.423 -0400", hash_original_method = "C9B1596896385C915B9F0E305B24E414", hash_generated_method = "3CB4CA8A3A9E845B14400A910F437D1A")
    public void setEncryptionAlgorithm(String ealg) throws ParseException {
        addTaint(ealg.getTaint());
        if(ealg == null)        
        {
        NullPointerException varBB7B6B10423E58E1B7DA3BB6A1BD19ED_548492747 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        varBB7B6B10423E58E1B7DA3BB6A1BD19ED_548492747.addTaint(taint);
        throw varBB7B6B10423E58E1B7DA3BB6A1BD19ED_548492747;
        }
        setParameter(ParameterNamesIms.EALG, ealg);
        // ---------- Original Method ----------
        //if (ealg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        //setParameter(ParameterNamesIms.EALG, ealg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.423 -0400", hash_original_method = "1034CB07B31AD4B972026DDB8CD1CF5A", hash_generated_method = "B0FBCEB7490A3C6E76F535AAEDD38847")
    public void setAlgorithm(String alg) throws ParseException {
        addTaint(alg.getTaint());
        if(alg == null)        
        {
        NullPointerException var0744B72ED1E48CFCC59F8AE9F067E260_849649074 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        var0744B72ED1E48CFCC59F8AE9F067E260_849649074.addTaint(taint);
        throw var0744B72ED1E48CFCC59F8AE9F067E260_849649074;
        }
        setParameter(ParameterNamesIms.ALG, alg);
        // ---------- Original Method ----------
        //if (alg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        //setParameter(ParameterNamesIms.ALG, alg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.424 -0400", hash_original_method = "445CF41DA92D45C4C84C6BEE36D36BF6", hash_generated_method = "D540B70EC167EAAF915F66EC137EA006")
    public void setProtocol(String prot) throws ParseException {
        addTaint(prot.getTaint());
        if(prot == null)        
        {
        NullPointerException var3577919A38129F3017807BE0D76703E4_947894060 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        var3577919A38129F3017807BE0D76703E4_947894060.addTaint(taint);
        throw var3577919A38129F3017807BE0D76703E4_947894060;
        }
        setParameter(ParameterNamesIms.PROT, prot);
        // ---------- Original Method ----------
        //if (prot == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        //setParameter(ParameterNamesIms.PROT, prot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.424 -0400", hash_original_method = "E016DD00F9E773B1BC74C49DD038424A", hash_generated_method = "0DBD7BB126B6F1C6E3362FF989DFD116")
    public void setMode(String mod) throws ParseException {
        addTaint(mod.getTaint());
        if(mod == null)        
        {
        NullPointerException varFB15EAA69482AAAA66C4D696123E95B6_1135159768 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setMode(), the mode parameter is null");
        varFB15EAA69482AAAA66C4D696123E95B6_1135159768.addTaint(taint);
        throw varFB15EAA69482AAAA66C4D696123E95B6_1135159768;
        }
        setParameter(ParameterNamesIms.MOD, mod);
        // ---------- Original Method ----------
        //if (mod == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setMode(), the mode parameter is null");
        //setParameter(ParameterNamesIms.MOD, mod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.424 -0400", hash_original_method = "75DD86B518B8282C26250CE6A2B99A28", hash_generated_method = "7E35E43F64DCB8C3F0C4EBD590B6CFDA")
    public void setSPIClient(int spic) throws InvalidArgumentException {
        addTaint(spic);
        if(spic < 0)        
        {
        InvalidArgumentException varD820CC82FDE45148FE61C3EFBF95680A_1204123276 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        varD820CC82FDE45148FE61C3EFBF95680A_1204123276.addTaint(taint);
        throw varD820CC82FDE45148FE61C3EFBF95680A_1204123276;
        }
        setParameter(ParameterNamesIms.SPI_C, spic);
        // ---------- Original Method ----------
        //if (spic < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        //setParameter(ParameterNamesIms.SPI_C, spic);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.425 -0400", hash_original_method = "3C648084DC1BE07708C4C0C2C0242BDB", hash_generated_method = "DAF97306483ADD104DB526C1173B951B")
    public void setSPIServer(int spis) throws InvalidArgumentException {
        addTaint(spis);
        if(spis < 0)        
        {
        InvalidArgumentException var6BB441F3DBCD44E4D4D581E0B7C60995_1730544341 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        var6BB441F3DBCD44E4D4D581E0B7C60995_1730544341.addTaint(taint);
        throw var6BB441F3DBCD44E4D4D581E0B7C60995_1730544341;
        }
        setParameter(ParameterNamesIms.SPI_S, spis);
        // ---------- Original Method ----------
        //if (spis < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        //setParameter(ParameterNamesIms.SPI_S, spis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.425 -0400", hash_original_method = "EF3E10E5EB6E9ADB9B0EAA61EFC25272", hash_generated_method = "02AFB68084C9E8561A2527067FB9FC59")
    public void setPortClient(int portC) throws InvalidArgumentException {
        addTaint(portC);
        if(portC < 0)        
        {
        InvalidArgumentException var29010A74BC4E1EF0862DF038F331E6B3_832353291 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        var29010A74BC4E1EF0862DF038F331E6B3_832353291.addTaint(taint);
        throw var29010A74BC4E1EF0862DF038F331E6B3_832353291;
        }
        setParameter(ParameterNamesIms.PORT_C, portC);
        // ---------- Original Method ----------
        //if (portC < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        //setParameter(ParameterNamesIms.PORT_C, portC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.425 -0400", hash_original_method = "AE705CDEF098778FC0F68E357BFDF4CB", hash_generated_method = "15D78D2DB3EFA5203E2791BA973F5A25")
    public void setPortServer(int portS) throws InvalidArgumentException {
        addTaint(portS);
        if(portS < 0)        
        {
        InvalidArgumentException varB87C08B622F5F7681AB4B9ABBBF4A35E_1916888649 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        varB87C08B622F5F7681AB4B9ABBBF4A35E_1916888649.addTaint(taint);
        throw varB87C08B622F5F7681AB4B9ABBBF4A35E_1916888649;
        }
        setParameter(ParameterNamesIms.PORT_S, portS);
        // ---------- Original Method ----------
        //if (portS < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        //setParameter(ParameterNamesIms.PORT_S, portS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.426 -0400", hash_original_method = "6E802E2384BCAE9DA923A1C36DFE2987", hash_generated_method = "5F743E8E12DA77CC57529530A2B210A9")
    public void setPreference(float q) throws InvalidArgumentException {
        addTaint(q);
        if(q < 0.0f)        
        {
        InvalidArgumentException var0FE9EC0735B39A14577835889E70CE87_82879519 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        var0FE9EC0735B39A14577835889E70CE87_82879519.addTaint(taint);
        throw var0FE9EC0735B39A14577835889E70CE87_82879519;
        }
        setParameter(ParameterNamesIms.Q, q);
        // ---------- Original Method ----------
        //if (q < 0.0f)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        //setParameter(ParameterNamesIms.Q, q);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.426 -0400", hash_original_method = "B428180B0BF5EA600E8FA7F08EE496F8", hash_generated_method = "739139CC3003EF7DFE80E4C440AB257E")
    public String getSecurityMechanism() {
String var4B79C76D511B5068B7982514555BAC48_948547137 =         this.secMechanism;
        var4B79C76D511B5068B7982514555BAC48_948547137.addTaint(taint);
        return var4B79C76D511B5068B7982514555BAC48_948547137;
        // ---------- Original Method ----------
        //return this.secMechanism;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.426 -0400", hash_original_method = "E48981B0D788C9F15FB0701B5A5A9BFB", hash_generated_method = "6A811223203514A6A791795B196E5DAC")
    public String getEncryptionAlgorithm() {
String varE21C3B124DD167D3CBCA969644C356E9_548790615 =         getParameter(ParameterNamesIms.EALG);
        varE21C3B124DD167D3CBCA969644C356E9_548790615.addTaint(taint);
        return varE21C3B124DD167D3CBCA969644C356E9_548790615;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.EALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.426 -0400", hash_original_method = "10709FDAA4AFF85555E2A3D151185971", hash_generated_method = "F13754A6440F716D3BFC3A0D51DAF577")
    public String getAlgorithm() {
String var64AC57F7E5736136BB55CD7FDAB4C576_1053972961 =         getParameter(ParameterNamesIms.ALG);
        var64AC57F7E5736136BB55CD7FDAB4C576_1053972961.addTaint(taint);
        return var64AC57F7E5736136BB55CD7FDAB4C576_1053972961;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.426 -0400", hash_original_method = "D8F37ABD0A193610338515FA46330650", hash_generated_method = "A1867ED053177845EE1472CC850EF280")
    public String getProtocol() {
String var20669F26102CE364C290D5B92D0C9D90_999273073 =         getParameter(ParameterNamesIms.PROT);
        var20669F26102CE364C290D5B92D0C9D90_999273073.addTaint(taint);
        return var20669F26102CE364C290D5B92D0C9D90_999273073;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.PROT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.427 -0400", hash_original_method = "F9C1DAC229A690F6459CC03AC622A5E3", hash_generated_method = "BDEFD1EB051428B1E381F1A99039A79F")
    public String getMode() {
String varE0E61CDFF4BFF8E844EF94D263035213_260091876 =         getParameter(ParameterNamesIms.MOD);
        varE0E61CDFF4BFF8E844EF94D263035213_260091876.addTaint(taint);
        return varE0E61CDFF4BFF8E844EF94D263035213_260091876;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.MOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.427 -0400", hash_original_method = "2AA9C7181C6D09D271CB928F8ADC4E6A", hash_generated_method = "A41CAC2D1F719D4E1B8E2FE62EE4AC8B")
    public int getSPIClient() {
        int varB0D11DD358875318EF28CFAEF8204FE9_1047201295 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_C))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922733510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922733510;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.427 -0400", hash_original_method = "87F3A8BE8E0310CD1D9EAD100DF812CC", hash_generated_method = "4C8481745B351A4CB7502AA531B7EFDA")
    public int getSPIServer() {
        int var291C13EA23D446CDAE55AC60738D17B3_1732159942 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_S))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987978128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987978128;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.427 -0400", hash_original_method = "452A6BD881785C9FC11C999CB3A20207", hash_generated_method = "69CA427693FFA0F4A832A60FA55E44BA")
    public int getPortClient() {
        int var63C7374DA4C387E7AA7C73690C41B44D_1802701726 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_C))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141985044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141985044;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.428 -0400", hash_original_method = "107465724D48A961682620CCB1B6C016", hash_generated_method = "1D68A74CAB9A349AFCC2FE04AD007F59")
    public int getPortServer() {
        int varCADDEE00098FFBB341DEFD35646A4854_1562159118 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_S))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552096077 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_552096077;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.428 -0400", hash_original_method = "618486245568CF743B7149F19C0097DE", hash_generated_method = "74D0DD74891B1704310C8314543EE268")
    public float getPreference() {
        float var9B5EB94C7E7B422191F93D7C08FB45C5_1400732635 = ((Float.parseFloat(getParameter(ParameterNamesIms.Q))));
                float var546ADE640B6EDFBC8A086EF31347E768_557547435 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_557547435;
        // ---------- Original Method ----------
        //return (Float.parseFloat(getParameter(ParameterNamesIms.Q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.428 -0400", hash_original_method = "AD0CCA4E33EB4C4CCEB107F65F233D48", hash_generated_method = "20454C978F45AD222A74452FBF29C9DD")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof SecurityAgreeHeader)        
        {
            SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            boolean var1386DABBFDAD28FE5F842F13BBBD7306_989116102 = ((this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                && this.equalParameters( (Parameters) o )));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421345361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421345361;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1107439714 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672472255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672472255;
        // ---------- Original Method ----------
        //if(other instanceof SecurityAgreeHeader)
        //{
            //SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            //return (this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.429 -0400", hash_original_method = "027A143FB16239A6EF6573784EA7EAA2", hash_generated_method = "94C458CE2E6676524EE0C482D8C5229D")
    public Object clone() {
        SecurityAgree retval = (SecurityAgree) super.clone();
        if(this.secMechanism != null)        
        retval.secMechanism = this.secMechanism;
Object varF9E19AD6135C970F387F77C6F3DE4477_812410861 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_812410861.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_812410861;
        // ---------- Original Method ----------
        //SecurityAgree retval = (SecurityAgree) super.clone();
        //if (this.secMechanism != null)
            //retval.secMechanism = this.secMechanism;
        //return retval;
    }

    
}

