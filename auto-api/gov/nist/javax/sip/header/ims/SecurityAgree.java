package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.Parameters;
import gov.nist.core.NameValue;
import gov.nist.core.Separators;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;
import gov.nist.javax.sip.header.ParametersHeader;

public abstract class SecurityAgree extends ParametersHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.513 -0400", hash_original_field = "6F427A203D04EECAF79CE90CA0A1A976", hash_generated_field = "A39B9CA7C0E64EFBAEF9BF1842BA8543")

    private String secMechanism;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.513 -0400", hash_original_method = "37860681C961C756ECC7AFD430C41B9D", hash_generated_method = "FBF79F606B5DC0193EBB2EAA62DFBB9F")
    public  SecurityAgree(String name) {
        super(name);
        parameters.setSeparator(Separators.SEMICOLON);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.514 -0400", hash_original_method = "0AED97FED716BE0BE4710B84F9A63527", hash_generated_method = "DE3AB21BDF30B86B04AD74FD31846F54")
    public  SecurityAgree() {
        super();
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.514 -0400", hash_original_method = "9AC5B140B15B11CFD450C965DE3EDCEF", hash_generated_method = "D9B3CF7F2A2DAEA1BB5E460AFBD6B010")
    public void setParameter(String name, String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null value");
        NameValue nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean varAADB1C896C96EA4346C25C9269FC83C9_1284125739 = (name.equalsIgnoreCase(ParameterNamesIms.D_VER));
                {
                    nv.setQuotedValue();
                    {
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_864850196 = (value.startsWith(Separators.DOUBLE_QUOTE));
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(value
                            + " : Unexpected DOUBLE_QUOTE", 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            super.setParameter(nv);
        } //End block
        {
            nv.setValueAsObject(value);
        } //End block
        addTaint(name.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.515 -0400", hash_original_method = "6B925B5DF777A76390B5A8992D469F0E", hash_generated_method = "BDF01F764DE1FBC917C1B6ABE3A2F242")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2053411003 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2053411003 = this.secMechanism + SEMICOLON + SP + parameters.encode();
        varB4EAC82CA7396A68D541C85D26508E83_2053411003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053411003;
        // ---------- Original Method ----------
        //return this.secMechanism + SEMICOLON + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.515 -0400", hash_original_method = "26617F329EF35F53927C51BE793DE18C", hash_generated_method = "BE2080A67F7444921D960FF90A720F12")
    public void setSecurityMechanism(String secMech) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        this.secMechanism = secMech;
        // ---------- Original Method ----------
        //if (secMech == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        //this.secMechanism = secMech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.516 -0400", hash_original_method = "C9B1596896385C915B9F0E305B24E414", hash_generated_method = "7826E67B4FB332A82AA83B5E88758DA8")
    public void setEncryptionAlgorithm(String ealg) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        setParameter(ParameterNamesIms.EALG, ealg);
        addTaint(ealg.getTaint());
        // ---------- Original Method ----------
        //if (ealg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        //setParameter(ParameterNamesIms.EALG, ealg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.517 -0400", hash_original_method = "1034CB07B31AD4B972026DDB8CD1CF5A", hash_generated_method = "C5F72494DD6DB46CE5FA45C7EB379B8B")
    public void setAlgorithm(String alg) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        setParameter(ParameterNamesIms.ALG, alg);
        addTaint(alg.getTaint());
        // ---------- Original Method ----------
        //if (alg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        //setParameter(ParameterNamesIms.ALG, alg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.517 -0400", hash_original_method = "445CF41DA92D45C4C84C6BEE36D36BF6", hash_generated_method = "C43370806C310A6DB96A9BC551F29C55")
    public void setProtocol(String prot) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        setParameter(ParameterNamesIms.PROT, prot);
        addTaint(prot.getTaint());
        // ---------- Original Method ----------
        //if (prot == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        //setParameter(ParameterNamesIms.PROT, prot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.518 -0400", hash_original_method = "E016DD00F9E773B1BC74C49DD038424A", hash_generated_method = "78F08221ED2A89FCFD08642FD49FB397")
    public void setMode(String mod) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setMode(), the mode parameter is null");
        setParameter(ParameterNamesIms.MOD, mod);
        addTaint(mod.getTaint());
        // ---------- Original Method ----------
        //if (mod == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setMode(), the mode parameter is null");
        //setParameter(ParameterNamesIms.MOD, mod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.518 -0400", hash_original_method = "75DD86B518B8282C26250CE6A2B99A28", hash_generated_method = "4AF17F8B4E13D363CF1B76BA0A1D2F22")
    public void setSPIClient(int spic) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        setParameter(ParameterNamesIms.SPI_C, spic);
        addTaint(spic);
        // ---------- Original Method ----------
        //if (spic < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        //setParameter(ParameterNamesIms.SPI_C, spic);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.519 -0400", hash_original_method = "3C648084DC1BE07708C4C0C2C0242BDB", hash_generated_method = "C4DD0727B66EE2088AA6E42D1EE9E2CE")
    public void setSPIServer(int spis) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        setParameter(ParameterNamesIms.SPI_S, spis);
        addTaint(spis);
        // ---------- Original Method ----------
        //if (spis < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        //setParameter(ParameterNamesIms.SPI_S, spis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.519 -0400", hash_original_method = "EF3E10E5EB6E9ADB9B0EAA61EFC25272", hash_generated_method = "3D68831CC3DF9C455FA24209A39D2B59")
    public void setPortClient(int portC) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        setParameter(ParameterNamesIms.PORT_C, portC);
        addTaint(portC);
        // ---------- Original Method ----------
        //if (portC < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        //setParameter(ParameterNamesIms.PORT_C, portC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.520 -0400", hash_original_method = "AE705CDEF098778FC0F68E357BFDF4CB", hash_generated_method = "EDA3620F2E7D6950D41F0FD64CF1900A")
    public void setPortServer(int portS) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        setParameter(ParameterNamesIms.PORT_S, portS);
        addTaint(portS);
        // ---------- Original Method ----------
        //if (portS < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        //setParameter(ParameterNamesIms.PORT_S, portS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.520 -0400", hash_original_method = "6E802E2384BCAE9DA923A1C36DFE2987", hash_generated_method = "3D380E19147A29B415C7EF2AC19BC40A")
    public void setPreference(float q) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        setParameter(ParameterNamesIms.Q, q);
        addTaint(q);
        // ---------- Original Method ----------
        //if (q < 0.0f)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        //setParameter(ParameterNamesIms.Q, q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.521 -0400", hash_original_method = "B428180B0BF5EA600E8FA7F08EE496F8", hash_generated_method = "E08C5D2ED37DAE72C045E92CA0DB4C44")
    public String getSecurityMechanism() {
        String varB4EAC82CA7396A68D541C85D26508E83_2012856206 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012856206 = this.secMechanism;
        varB4EAC82CA7396A68D541C85D26508E83_2012856206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012856206;
        // ---------- Original Method ----------
        //return this.secMechanism;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.521 -0400", hash_original_method = "E48981B0D788C9F15FB0701B5A5A9BFB", hash_generated_method = "7E43A442E5D0D4DBCED7FF2A6C2DAB0A")
    public String getEncryptionAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_213725471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_213725471 = getParameter(ParameterNamesIms.EALG);
        varB4EAC82CA7396A68D541C85D26508E83_213725471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_213725471;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.EALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.522 -0400", hash_original_method = "10709FDAA4AFF85555E2A3D151185971", hash_generated_method = "E907C35828F087946E4EEF0D670999E4")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_488093104 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_488093104 = getParameter(ParameterNamesIms.ALG);
        varB4EAC82CA7396A68D541C85D26508E83_488093104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_488093104;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.523 -0400", hash_original_method = "D8F37ABD0A193610338515FA46330650", hash_generated_method = "B7A68C8DC6121EF6E8AC667649F31073")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_2105372494 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2105372494 = getParameter(ParameterNamesIms.PROT);
        varB4EAC82CA7396A68D541C85D26508E83_2105372494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2105372494;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.PROT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.523 -0400", hash_original_method = "F9C1DAC229A690F6459CC03AC622A5E3", hash_generated_method = "D69ABCF4AB1A3912261DE100B5B1B90D")
    public String getMode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1249605438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1249605438 = getParameter(ParameterNamesIms.MOD);
        varB4EAC82CA7396A68D541C85D26508E83_1249605438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249605438;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.MOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.524 -0400", hash_original_method = "2AA9C7181C6D09D271CB928F8ADC4E6A", hash_generated_method = "3BACA4A5B97B7D8F1267CF5552FC79E4")
    public int getSPIClient() {
        int var2FBF46137E6C5425FD51A5EC500023DB_304896426 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_C))));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256644557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256644557;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.524 -0400", hash_original_method = "87F3A8BE8E0310CD1D9EAD100DF812CC", hash_generated_method = "BC057B00CB838A202CB49E35306AEA6C")
    public int getSPIServer() {
        int varD8EFEAAB649E1EBD7C01F0A239292FB1_1137789592 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_S))));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808223705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808223705;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.524 -0400", hash_original_method = "452A6BD881785C9FC11C999CB3A20207", hash_generated_method = "EE897B1819E17DC3C3DA68F49A7D76A1")
    public int getPortClient() {
        int var86F6BA90D8A367099944E93075F20B47_1843127922 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_C))));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317161175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317161175;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.525 -0400", hash_original_method = "107465724D48A961682620CCB1B6C016", hash_generated_method = "427EEB7D294C913C4E8DE13263765EB4")
    public int getPortServer() {
        int varFCF1DCCE4518F7F775E16F46D28A507A_87510388 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_S))));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952330623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952330623;
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.525 -0400", hash_original_method = "618486245568CF743B7149F19C0097DE", hash_generated_method = "26B1287EE1FB98A301162AA379B4AFCA")
    public float getPreference() {
        float var120E9066AD7BA7698D4A5584C2E50605_2139703201 = ((Float.parseFloat(getParameter(ParameterNamesIms.Q))));
        float var546ADE640B6EDFBC8A086EF31347E768_1855782099 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1855782099;
        // ---------- Original Method ----------
        //return (Float.parseFloat(getParameter(ParameterNamesIms.Q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.525 -0400", hash_original_method = "AD0CCA4E33EB4C4CCEB107F65F233D48", hash_generated_method = "E3CCC2880F216BBE413372974AD53117")
    public boolean equals(Object other) {
        {
            SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            boolean varD505F08F0C2013D6020DA93B5191404A_1187057861 = ((this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                && this.equalParameters( (Parameters) o )));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114629945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114629945;
        // ---------- Original Method ----------
        //if(other instanceof SecurityAgreeHeader)
        //{
            //SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            //return (this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.526 -0400", hash_original_method = "027A143FB16239A6EF6573784EA7EAA2", hash_generated_method = "E7B09993D37B841F4EEA578523F2C1ED")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1397101343 = null; //Variable for return #1
        SecurityAgree retval = (SecurityAgree) super.clone();
        retval.secMechanism = this.secMechanism;
        varB4EAC82CA7396A68D541C85D26508E83_1397101343 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1397101343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397101343;
        // ---------- Original Method ----------
        //SecurityAgree retval = (SecurityAgree) super.clone();
        //if (this.secMechanism != null)
            //retval.secMechanism = this.secMechanism;
        //return retval;
    }

    
}

