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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.174 -0400", hash_original_field = "6F427A203D04EECAF79CE90CA0A1A976", hash_generated_field = "A39B9CA7C0E64EFBAEF9BF1842BA8543")

    private String secMechanism;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.174 -0400", hash_original_method = "37860681C961C756ECC7AFD430C41B9D", hash_generated_method = "8FD81F49C9A2C9E9D825D2785A8A98DB")
    public  SecurityAgree(String name) {
        super(name);
        addTaint(name.getTaint());
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.174 -0400", hash_original_method = "0AED97FED716BE0BE4710B84F9A63527", hash_generated_method = "DE3AB21BDF30B86B04AD74FD31846F54")
    public  SecurityAgree() {
        super();
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.175 -0400", hash_original_method = "9AC5B140B15B11CFD450C965DE3EDCEF", hash_generated_method = "313557ACBB88AC9F557E50E95F452A22")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(value == null)        
        {
        NullPointerException var5581ED2812AE061277296C54374A63DE_1529669148 = new NullPointerException("null value");
        var5581ED2812AE061277296C54374A63DE_1529669148.addTaint(taint);
        throw var5581ED2812AE061277296C54374A63DE_1529669148;
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
                ParseException varE60A0A92BA5CA1ED6CE0AA8D83CBF780_788616129 = new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                varE60A0A92BA5CA1ED6CE0AA8D83CBF780_788616129.addTaint(taint);
                throw varE60A0A92BA5CA1ED6CE0AA8D83CBF780_788616129;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.182 -0400", hash_original_method = "6B925B5DF777A76390B5A8992D469F0E", hash_generated_method = "6AB151607CDF455E0BC8A3662685FA1F")
    public String encodeBody() {
String varB363CAFDFEE7E20CD6BC0E1D20681BC7_165365972 =         this.secMechanism + SEMICOLON + SP + parameters.encode();
        varB363CAFDFEE7E20CD6BC0E1D20681BC7_165365972.addTaint(taint);
        return varB363CAFDFEE7E20CD6BC0E1D20681BC7_165365972;
        // ---------- Original Method ----------
        //return this.secMechanism + SEMICOLON + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.182 -0400", hash_original_method = "26617F329EF35F53927C51BE793DE18C", hash_generated_method = "13B32E4681EBCAB484981644E88B4278")
    public void setSecurityMechanism(String secMech) throws ParseException {
    if(secMech == null)        
        {
        NullPointerException var1E2FE2E725583A02D321C97BD8BDEA08_733001472 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        var1E2FE2E725583A02D321C97BD8BDEA08_733001472.addTaint(taint);
        throw var1E2FE2E725583A02D321C97BD8BDEA08_733001472;
        }
        this.secMechanism = secMech;
        // ---------- Original Method ----------
        //if (secMech == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        //this.secMechanism = secMech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.182 -0400", hash_original_method = "C9B1596896385C915B9F0E305B24E414", hash_generated_method = "10886B0B2A26C2E6CE8D4692DDF9011C")
    public void setEncryptionAlgorithm(String ealg) throws ParseException {
        addTaint(ealg.getTaint());
    if(ealg == null)        
        {
        NullPointerException varBB7B6B10423E58E1B7DA3BB6A1BD19ED_2066662062 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        varBB7B6B10423E58E1B7DA3BB6A1BD19ED_2066662062.addTaint(taint);
        throw varBB7B6B10423E58E1B7DA3BB6A1BD19ED_2066662062;
        }
        setParameter(ParameterNamesIms.EALG, ealg);
        // ---------- Original Method ----------
        //if (ealg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        //setParameter(ParameterNamesIms.EALG, ealg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "1034CB07B31AD4B972026DDB8CD1CF5A", hash_generated_method = "75404AB3EA9D9E1D259925AF8940E464")
    public void setAlgorithm(String alg) throws ParseException {
        addTaint(alg.getTaint());
    if(alg == null)        
        {
        NullPointerException var0744B72ED1E48CFCC59F8AE9F067E260_1641988463 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        var0744B72ED1E48CFCC59F8AE9F067E260_1641988463.addTaint(taint);
        throw var0744B72ED1E48CFCC59F8AE9F067E260_1641988463;
        }
        setParameter(ParameterNamesIms.ALG, alg);
        // ---------- Original Method ----------
        //if (alg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        //setParameter(ParameterNamesIms.ALG, alg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "445CF41DA92D45C4C84C6BEE36D36BF6", hash_generated_method = "EA6C638FFF3D4975CAF3A767F1F38D5F")
    public void setProtocol(String prot) throws ParseException {
        addTaint(prot.getTaint());
    if(prot == null)        
        {
        NullPointerException var3577919A38129F3017807BE0D76703E4_1929740040 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        var3577919A38129F3017807BE0D76703E4_1929740040.addTaint(taint);
        throw var3577919A38129F3017807BE0D76703E4_1929740040;
        }
        setParameter(ParameterNamesIms.PROT, prot);
        // ---------- Original Method ----------
        //if (prot == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        //setParameter(ParameterNamesIms.PROT, prot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "E016DD00F9E773B1BC74C49DD038424A", hash_generated_method = "85FBB64FB30D8FDC187200C720F0862B")
    public void setMode(String mod) throws ParseException {
        addTaint(mod.getTaint());
    if(mod == null)        
        {
        NullPointerException varFB15EAA69482AAAA66C4D696123E95B6_620025953 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setMode(), the mode parameter is null");
        varFB15EAA69482AAAA66C4D696123E95B6_620025953.addTaint(taint);
        throw varFB15EAA69482AAAA66C4D696123E95B6_620025953;
        }
        setParameter(ParameterNamesIms.MOD, mod);
        // ---------- Original Method ----------
        //if (mod == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setMode(), the mode parameter is null");
        //setParameter(ParameterNamesIms.MOD, mod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "75DD86B518B8282C26250CE6A2B99A28", hash_generated_method = "4313B7397FD7320A491943BD59DD204C")
    public void setSPIClient(int spic) throws InvalidArgumentException {
        addTaint(spic);
    if(spic < 0)        
        {
        InvalidArgumentException varD820CC82FDE45148FE61C3EFBF95680A_420346828 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        varD820CC82FDE45148FE61C3EFBF95680A_420346828.addTaint(taint);
        throw varD820CC82FDE45148FE61C3EFBF95680A_420346828;
        }
        setParameter(ParameterNamesIms.SPI_C, spic);
        // ---------- Original Method ----------
        //if (spic < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        //setParameter(ParameterNamesIms.SPI_C, spic);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "3C648084DC1BE07708C4C0C2C0242BDB", hash_generated_method = "1BC562FC88B9AC7B53D1035E16415A3C")
    public void setSPIServer(int spis) throws InvalidArgumentException {
        addTaint(spis);
    if(spis < 0)        
        {
        InvalidArgumentException var6BB441F3DBCD44E4D4D581E0B7C60995_295891518 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        var6BB441F3DBCD44E4D4D581E0B7C60995_295891518.addTaint(taint);
        throw var6BB441F3DBCD44E4D4D581E0B7C60995_295891518;
        }
        setParameter(ParameterNamesIms.SPI_S, spis);
        // ---------- Original Method ----------
        //if (spis < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        //setParameter(ParameterNamesIms.SPI_S, spis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.183 -0400", hash_original_method = "EF3E10E5EB6E9ADB9B0EAA61EFC25272", hash_generated_method = "08989DB7C42EEC470C52D01D2A2033D6")
    public void setPortClient(int portC) throws InvalidArgumentException {
        addTaint(portC);
    if(portC < 0)        
        {
        InvalidArgumentException var29010A74BC4E1EF0862DF038F331E6B3_1719819513 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        var29010A74BC4E1EF0862DF038F331E6B3_1719819513.addTaint(taint);
        throw var29010A74BC4E1EF0862DF038F331E6B3_1719819513;
        }
        setParameter(ParameterNamesIms.PORT_C, portC);
        // ---------- Original Method ----------
        //if (portC < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        //setParameter(ParameterNamesIms.PORT_C, portC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "AE705CDEF098778FC0F68E357BFDF4CB", hash_generated_method = "34920CB0E7393711227034B444DEA3A8")
    public void setPortServer(int portS) throws InvalidArgumentException {
        addTaint(portS);
    if(portS < 0)        
        {
        InvalidArgumentException varB87C08B622F5F7681AB4B9ABBBF4A35E_1938448142 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        varB87C08B622F5F7681AB4B9ABBBF4A35E_1938448142.addTaint(taint);
        throw varB87C08B622F5F7681AB4B9ABBBF4A35E_1938448142;
        }
        setParameter(ParameterNamesIms.PORT_S, portS);
        // ---------- Original Method ----------
        //if (portS < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        //setParameter(ParameterNamesIms.PORT_S, portS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "6E802E2384BCAE9DA923A1C36DFE2987", hash_generated_method = "3F2228E0B005D91454E5C78F07639241")
    public void setPreference(float q) throws InvalidArgumentException {
        addTaint(q);
    if(q < 0.0f)        
        {
        InvalidArgumentException var0FE9EC0735B39A14577835889E70CE87_1934226208 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        var0FE9EC0735B39A14577835889E70CE87_1934226208.addTaint(taint);
        throw var0FE9EC0735B39A14577835889E70CE87_1934226208;
        }
        setParameter(ParameterNamesIms.Q, q);
        // ---------- Original Method ----------
        //if (q < 0.0f)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        //setParameter(ParameterNamesIms.Q, q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "B428180B0BF5EA600E8FA7F08EE496F8", hash_generated_method = "7B82C4CB6E5963F86CF6FF60F52DA7CD")
    public String getSecurityMechanism() {
String var4B79C76D511B5068B7982514555BAC48_1592392380 =         this.secMechanism;
        var4B79C76D511B5068B7982514555BAC48_1592392380.addTaint(taint);
        return var4B79C76D511B5068B7982514555BAC48_1592392380;
        // ---------- Original Method ----------
        //return this.secMechanism;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "E48981B0D788C9F15FB0701B5A5A9BFB", hash_generated_method = "529058DAE58EE18A33949910C07787C1")
    public String getEncryptionAlgorithm() {
String varE21C3B124DD167D3CBCA969644C356E9_297899858 =         getParameter(ParameterNamesIms.EALG);
        varE21C3B124DD167D3CBCA969644C356E9_297899858.addTaint(taint);
        return varE21C3B124DD167D3CBCA969644C356E9_297899858;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.EALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "10709FDAA4AFF85555E2A3D151185971", hash_generated_method = "9028E33E2817F7AD5266BD3AC7294579")
    public String getAlgorithm() {
String var64AC57F7E5736136BB55CD7FDAB4C576_1503554783 =         getParameter(ParameterNamesIms.ALG);
        var64AC57F7E5736136BB55CD7FDAB4C576_1503554783.addTaint(taint);
        return var64AC57F7E5736136BB55CD7FDAB4C576_1503554783;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "D8F37ABD0A193610338515FA46330650", hash_generated_method = "F02669A24ED4291297BA1A255978C688")
    public String getProtocol() {
String var20669F26102CE364C290D5B92D0C9D90_1856357934 =         getParameter(ParameterNamesIms.PROT);
        var20669F26102CE364C290D5B92D0C9D90_1856357934.addTaint(taint);
        return var20669F26102CE364C290D5B92D0C9D90_1856357934;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.PROT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "F9C1DAC229A690F6459CC03AC622A5E3", hash_generated_method = "C9456619EF6C4CB3E094CAFD6DBC4F58")
    public String getMode() {
String varE0E61CDFF4BFF8E844EF94D263035213_301420539 =         getParameter(ParameterNamesIms.MOD);
        varE0E61CDFF4BFF8E844EF94D263035213_301420539.addTaint(taint);
        return varE0E61CDFF4BFF8E844EF94D263035213_301420539;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.MOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "2AA9C7181C6D09D271CB928F8ADC4E6A", hash_generated_method = "4EAC8ABCA2BDAD1C7249D5614EDB12E3")
    public int getSPIClient() {
        int varB0D11DD358875318EF28CFAEF8204FE9_866159748 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_C))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882779542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882779542;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.184 -0400", hash_original_method = "87F3A8BE8E0310CD1D9EAD100DF812CC", hash_generated_method = "880634C7CBCC4E3C5B81B3840C80E75A")
    public int getSPIServer() {
        int var291C13EA23D446CDAE55AC60738D17B3_1524342749 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_S))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487678867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487678867;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.185 -0400", hash_original_method = "452A6BD881785C9FC11C999CB3A20207", hash_generated_method = "EA77D3C46EDE5368C678E59EFF0EE325")
    public int getPortClient() {
        int var63C7374DA4C387E7AA7C73690C41B44D_1164146057 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_C))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733642476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733642476;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.185 -0400", hash_original_method = "107465724D48A961682620CCB1B6C016", hash_generated_method = "28AEE55397E44848B1F54479DA2AC5AE")
    public int getPortServer() {
        int varCADDEE00098FFBB341DEFD35646A4854_1566818148 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_S))));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833528516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833528516;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.185 -0400", hash_original_method = "618486245568CF743B7149F19C0097DE", hash_generated_method = "9B8F3FB1CF8C5CFBC0C7CF52B4A4F1E7")
    public float getPreference() {
        float var9B5EB94C7E7B422191F93D7C08FB45C5_286156013 = ((Float.parseFloat(getParameter(ParameterNamesIms.Q))));
                float var546ADE640B6EDFBC8A086EF31347E768_804448468 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_804448468;
        // ---------- Original Method ----------
        //return (Float.parseFloat(getParameter(ParameterNamesIms.Q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.185 -0400", hash_original_method = "AD0CCA4E33EB4C4CCEB107F65F233D48", hash_generated_method = "43FDD09C463B20E125F8884B3D7E9F15")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof SecurityAgreeHeader)        
        {
            SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            boolean var1386DABBFDAD28FE5F842F13BBBD7306_2141106973 = ((this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                && this.equalParameters( (Parameters) o )));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664844755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_664844755;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1018512516 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608808691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608808691;
        // ---------- Original Method ----------
        //if(other instanceof SecurityAgreeHeader)
        //{
            //SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            //return (this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.185 -0400", hash_original_method = "027A143FB16239A6EF6573784EA7EAA2", hash_generated_method = "343641385BB6E3D80BA6DF2924AD9F69")
    public Object clone() {
        SecurityAgree retval = (SecurityAgree) super.clone();
    if(this.secMechanism != null)        
        retval.secMechanism = this.secMechanism;
Object varF9E19AD6135C970F387F77C6F3DE4477_1930480422 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1930480422.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1930480422;
        // ---------- Original Method ----------
        //SecurityAgree retval = (SecurityAgree) super.clone();
        //if (this.secMechanism != null)
            //retval.secMechanism = this.secMechanism;
        //return retval;
    }

    
}

