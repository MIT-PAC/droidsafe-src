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
    private String secMechanism;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.646 -0400", hash_original_method = "37860681C961C756ECC7AFD430C41B9D", hash_generated_method = "9701E2562A5571BE8DBAFA3B4D48CAE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityAgree(String name) {
        super(name);
        dsTaint.addTaint(name);
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.646 -0400", hash_original_method = "0AED97FED716BE0BE4710B84F9A63527", hash_generated_method = "DE3AB21BDF30B86B04AD74FD31846F54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityAgree() {
        super();
        parameters.setSeparator(Separators.SEMICOLON);
        // ---------- Original Method ----------
        //parameters.setSeparator(Separators.SEMICOLON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.646 -0400", hash_original_method = "9AC5B140B15B11CFD450C965DE3EDCEF", hash_generated_method = "DD2FAC5DA021652657ED296DF4D53218")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null value");
        NameValue nv;
        nv = super.parameters.getNameValue(name.toLowerCase());
        {
            nv = new NameValue(name, value);
            {
                boolean varAADB1C896C96EA4346C25C9269FC83C9_1282167914 = (name.equalsIgnoreCase(ParameterNamesIms.D_VER));
                {
                    nv.setQuotedValue();
                    {
                        boolean var70C8EC7D8BEB5B9BD994AE9EBC9ED9CD_1357136144 = (value.startsWith(Separators.DOUBLE_QUOTE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.646 -0400", hash_original_method = "6B925B5DF777A76390B5A8992D469F0E", hash_generated_method = "F76DEE78623E8FBC92F1ACC9E27E48A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var6934D3C9B5299B8A80CE219B6A6866DA_454024854 = (this.secMechanism + SEMICOLON + SP + parameters.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.secMechanism + SEMICOLON + SP + parameters.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.647 -0400", hash_original_method = "26617F329EF35F53927C51BE793DE18C", hash_generated_method = "8882A210AF2DF80D021202B7939EA178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSecurityMechanism(String secMech) throws ParseException {
        dsTaint.addTaint(secMech);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        // ---------- Original Method ----------
        //if (secMech == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityAgree, setSecurityMechanism(), the sec-mechanism parameter is null");
        //this.secMechanism = secMech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.647 -0400", hash_original_method = "C9B1596896385C915B9F0E305B24E414", hash_generated_method = "9670EB3AC50FD386D607DE3936F3D14C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncryptionAlgorithm(String ealg) throws ParseException {
        dsTaint.addTaint(ealg);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        setParameter(ParameterNamesIms.EALG, ealg);
        // ---------- Original Method ----------
        //if (ealg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setEncryptionAlgorithm(), the encryption-algorithm parameter is null");
        //setParameter(ParameterNamesIms.EALG, ealg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.647 -0400", hash_original_method = "1034CB07B31AD4B972026DDB8CD1CF5A", hash_generated_method = "60C26040EF4289B616938C3F95186D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlgorithm(String alg) throws ParseException {
        dsTaint.addTaint(alg);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        setParameter(ParameterNamesIms.ALG, alg);
        // ---------- Original Method ----------
        //if (alg == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setAlgorithm(), the algorithm parameter is null");
        //setParameter(ParameterNamesIms.ALG, alg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.647 -0400", hash_original_method = "445CF41DA92D45C4C84C6BEE36D36BF6", hash_generated_method = "C3E3142C7397238E69713891AFB35E0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProtocol(String prot) throws ParseException {
        dsTaint.addTaint(prot);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        setParameter(ParameterNamesIms.PROT, prot);
        // ---------- Original Method ----------
        //if (prot == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setProtocol(), the protocol parameter is null");
        //setParameter(ParameterNamesIms.PROT, prot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.647 -0400", hash_original_method = "E016DD00F9E773B1BC74C49DD038424A", hash_generated_method = "C088341E39B10E5E57AE5B1BD72B3887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(String mod) throws ParseException {
        dsTaint.addTaint(mod);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setMode(), the mode parameter is null");
        setParameter(ParameterNamesIms.MOD, mod);
        // ---------- Original Method ----------
        //if (mod == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setMode(), the mode parameter is null");
        //setParameter(ParameterNamesIms.MOD, mod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.648 -0400", hash_original_method = "75DD86B518B8282C26250CE6A2B99A28", hash_generated_method = "159A6E76CD4C8F7159DCDCC1A2444549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSPIClient(int spic) throws InvalidArgumentException {
        dsTaint.addTaint(spic);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        setParameter(ParameterNamesIms.SPI_C, spic);
        // ---------- Original Method ----------
        //if (spic < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIClient(), the spi-c parameter is <0");
        //setParameter(ParameterNamesIms.SPI_C, spic);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.648 -0400", hash_original_method = "3C648084DC1BE07708C4C0C2C0242BDB", hash_generated_method = "28C458F7740419DF0342902965644D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSPIServer(int spis) throws InvalidArgumentException {
        dsTaint.addTaint(spis);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        setParameter(ParameterNamesIms.SPI_S, spis);
        // ---------- Original Method ----------
        //if (spis < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setSPIServer(), the spi-s parameter is <0");
        //setParameter(ParameterNamesIms.SPI_S, spis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.648 -0400", hash_original_method = "EF3E10E5EB6E9ADB9B0EAA61EFC25272", hash_generated_method = "A932500BAC71B005D976D98174AFFFAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPortClient(int portC) throws InvalidArgumentException {
        dsTaint.addTaint(portC);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        setParameter(ParameterNamesIms.PORT_C, portC);
        // ---------- Original Method ----------
        //if (portC < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortClient(), the port-c parameter is <0");
        //setParameter(ParameterNamesIms.PORT_C, portC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.648 -0400", hash_original_method = "AE705CDEF098778FC0F68E357BFDF4CB", hash_generated_method = "3E451D6A19CFEED9C5979F4A137E276A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPortServer(int portS) throws InvalidArgumentException {
        dsTaint.addTaint(portS);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        setParameter(ParameterNamesIms.PORT_S, portS);
        // ---------- Original Method ----------
        //if (portS < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPortServer(), the port-s parameter is <0");
        //setParameter(ParameterNamesIms.PORT_S, portS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "6E802E2384BCAE9DA923A1C36DFE2987", hash_generated_method = "3632754719ACD7CD9BCCA491C696B98B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPreference(float q) throws InvalidArgumentException {
        dsTaint.addTaint(q);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        setParameter(ParameterNamesIms.Q, q);
        // ---------- Original Method ----------
        //if (q < 0.0f)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SecurityClient, setPreference(), the preference (q) parameter is <0");
        //setParameter(ParameterNamesIms.Q, q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "B428180B0BF5EA600E8FA7F08EE496F8", hash_generated_method = "15C5EDCD1E00A5644E99DCD0111588A1")
    @DSModeled(DSC.SAFE)
    public String getSecurityMechanism() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.secMechanism;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "E48981B0D788C9F15FB0701B5A5A9BFB", hash_generated_method = "458D9BCD542806917DC25A865B7CDCEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEncryptionAlgorithm() {
        String varCD11D8FC00DB5070D7359D545963EB3A_144793119 = (getParameter(ParameterNamesIms.EALG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.EALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "10709FDAA4AFF85555E2A3D151185971", hash_generated_method = "2624B16AB61B05D627CDDFE79568AFD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAlgorithm() {
        String varFF7A53BB75DFCA39FB2A069FDFE4FFDC_1257983843 = (getParameter(ParameterNamesIms.ALG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ALG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "D8F37ABD0A193610338515FA46330650", hash_generated_method = "AAFB561107437D3F4D82F409F3DB1714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProtocol() {
        String var01EA4A59B11F0856B8306A8A8FBB5C29_987049537 = (getParameter(ParameterNamesIms.PROT));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.PROT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.649 -0400", hash_original_method = "F9C1DAC229A690F6459CC03AC622A5E3", hash_generated_method = "BCAAAF2F4CB1A013B59654804727E360")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMode() {
        String var8CFC8955F196C92A976A6DCB27668883_52076340 = (getParameter(ParameterNamesIms.MOD));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.MOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.650 -0400", hash_original_method = "2AA9C7181C6D09D271CB928F8ADC4E6A", hash_generated_method = "DF7A2C1373710C0EFB68EF09A0F9C311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSPIClient() {
        int var2FBF46137E6C5425FD51A5EC500023DB_1624145717 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_C))));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.650 -0400", hash_original_method = "87F3A8BE8E0310CD1D9EAD100DF812CC", hash_generated_method = "B6718B0B38D0400EC11F15EB50AA44FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSPIServer() {
        int varD8EFEAAB649E1EBD7C01F0A239292FB1_1279817282 = ((Integer.parseInt(getParameter(ParameterNamesIms.SPI_S))));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.SPI_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.650 -0400", hash_original_method = "452A6BD881785C9FC11C999CB3A20207", hash_generated_method = "6B1D0CB10B449B40CB969BEAF5CDD23C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPortClient() {
        int var86F6BA90D8A367099944E93075F20B47_2011005959 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_C))));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_C)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.650 -0400", hash_original_method = "107465724D48A961682620CCB1B6C016", hash_generated_method = "58B2EF758FA61CF9327DF949B257CBCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPortServer() {
        int varFCF1DCCE4518F7F775E16F46D28A507A_472720431 = ((Integer.parseInt(getParameter(ParameterNamesIms.PORT_S))));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (Integer.parseInt(getParameter(ParameterNamesIms.PORT_S)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.650 -0400", hash_original_method = "618486245568CF743B7149F19C0097DE", hash_generated_method = "674D64B1DAC9CC57BA423702904A01B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getPreference() {
        float var120E9066AD7BA7698D4A5584C2E50605_987347844 = ((Float.parseFloat(getParameter(ParameterNamesIms.Q))));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (Float.parseFloat(getParameter(ParameterNamesIms.Q)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.651 -0400", hash_original_method = "AD0CCA4E33EB4C4CCEB107F65F233D48", hash_generated_method = "ED84958E94ECFA336C959ED9AB151145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            SecurityAgreeHeader o;
            o = (SecurityAgreeHeader) other;
            boolean varD505F08F0C2013D6020DA93B5191404A_584067547 = ((this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                && this.equalParameters( (Parameters) o )));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if(other instanceof SecurityAgreeHeader)
        //{
            //SecurityAgreeHeader o = (SecurityAgreeHeader) other;
            //return (this.getSecurityMechanism().equals( o.getSecurityMechanism() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.652 -0400", hash_original_method = "027A143FB16239A6EF6573784EA7EAA2", hash_generated_method = "734AF53457248D31404BF7ECA22FFD16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SecurityAgree retval;
        retval = (SecurityAgree) super.clone();
        retval.secMechanism = this.secMechanism;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityAgree retval = (SecurityAgree) super.clone();
        //if (this.secMechanism != null)
            //retval.secMechanism = this.secMechanism;
        //return retval;
    }

    
}

