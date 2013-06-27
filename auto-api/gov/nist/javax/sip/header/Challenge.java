package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;

public class Challenge extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.591 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.591 -0400", hash_original_field = "A38FBF55660E169551EA40BA83339BC2", hash_generated_field = "3C192C96CF447535D68E25BB7C5623D6")

    protected NameValueList authParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.592 -0400", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "8B8D628BE29F284A7616E96B4E975F92")
    public  Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
        // ---------- Original Method ----------
        //authParams = new NameValueList();
        //authParams.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.592 -0400", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "A46C57808C8F2CA8E69A112791E876A2")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1488656182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1488656182 = new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_1488656182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1488656182;
        // ---------- Original Method ----------
        //return new StringBuffer(scheme)
            //.append(SP)
            //.append(authParams.encode())
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.593 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "CB4358AC9D193EEED6C81457C953AEB2")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_520402543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_520402543 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_520402543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_520402543;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.593 -0400", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "ED6409342CF498F46B75B0BE018091BF")
    public NameValueList getAuthParams() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1802254489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802254489 = authParams;
        varB4EAC82CA7396A68D541C85D26508E83_1802254489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802254489;
        // ---------- Original Method ----------
        //return authParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.594 -0400", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "05888049E71C0766ADF98BAD2A67C295")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_656962406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_656962406 = (String) authParams.getValue(DOMAIN);
        varB4EAC82CA7396A68D541C85D26508E83_656962406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_656962406;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(DOMAIN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.595 -0400", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "4223A92208CBDADDFB091051FD4F6E21")
    public String getURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1683195025 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683195025 = (String) authParams.getValue(URI);
        varB4EAC82CA7396A68D541C85D26508E83_1683195025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683195025;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(URI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.599 -0400", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "5DB60BE254AA318ABD8322D8302269BB")
    public String getOpaque() {
        String varB4EAC82CA7396A68D541C85D26508E83_505780606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_505780606 = (String) authParams.getValue(OPAQUE);
        varB4EAC82CA7396A68D541C85D26508E83_505780606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_505780606;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(OPAQUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.599 -0400", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "54C9C343ACA8587A179349E29CDBA7C3")
    public String getQOP() {
        String varB4EAC82CA7396A68D541C85D26508E83_558021912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_558021912 = (String) authParams.getValue(QOP);
        varB4EAC82CA7396A68D541C85D26508E83_558021912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_558021912;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.615 -0400", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "206A6B340D8CAC54306C8FEE5BDAEB89")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1571670621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1571670621 = (String) authParams.getValue(ALGORITHM);
        varB4EAC82CA7396A68D541C85D26508E83_1571670621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571670621;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(ALGORITHM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.616 -0400", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "F9BE59A8F93CBB897D2DDB87BAB8E6FB")
    public String getStale() {
        String varB4EAC82CA7396A68D541C85D26508E83_847788217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_847788217 = (String) authParams.getValue(STALE);
        varB4EAC82CA7396A68D541C85D26508E83_847788217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847788217;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(STALE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.616 -0400", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "2C3E147444335876D36277E0ADE003E6")
    public String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_1001308811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1001308811 = (String) authParams.getValue(SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_1001308811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001308811;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNATURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.620 -0400", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "222DA4139478D509DCB1C6B5614B932F")
    public String getSignedBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_2115687587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115687587 = (String) authParams.getValue(SIGNED_BY);
        varB4EAC82CA7396A68D541C85D26508E83_2115687587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115687587;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNED_BY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.621 -0400", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "459471ED1C732AD21AEA78F2D01760CA")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_836176284 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_836176284 = (String) authParams.getValue(RESPONSE);
        varB4EAC82CA7396A68D541C85D26508E83_836176284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_836176284;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(RESPONSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.621 -0400", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "B46D1DD4E1D669213360B89469EA57AA")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1546220024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1546220024 = (String) authParams.getValue(REALM);
        varB4EAC82CA7396A68D541C85D26508E83_1546220024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1546220024;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(REALM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.622 -0400", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "88711ADAA7081C5998F5FAA8BA4A1CC7")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1597170005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1597170005 = (String) authParams.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1597170005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597170005;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.622 -0400", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "3312BF4A662961A357EB6FB213C075C3")
    public boolean hasParameter(String name) {
        boolean var9CDB262022BA25401DCC23F24FDB2455_1197231640 = (authParams.getNameValue(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599029838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599029838;
        // ---------- Original Method ----------
        //return authParams.getNameValue(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.634 -0400", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "5777C21ACBA97203439B2D6636C02DF2")
    public boolean hasParameters() {
        boolean var98180B4D7CA2D3D9253C4DB1AD3325E9_1783729570 = (authParams.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1198516582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1198516582;
        // ---------- Original Method ----------
        //return authParams.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.635 -0400", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "C3CE5DC6C18103875DDAF5731AFAB5B1")
    public boolean removeParameter(String name) {
        boolean varB17796B60C8DF8AC1E0C404280083FDA_107694218 = (authParams.delete(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806449004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806449004;
        // ---------- Original Method ----------
        //return authParams.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.635 -0400", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "4459F5A0A762415A41C07B76C3FC94F7")
    public void removeParameters() {
        authParams = new NameValueList();
        // ---------- Original Method ----------
        //authParams = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.635 -0400", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "23F4F5DD4EC369AD9501994E80DC23CB")
    public void setParameter(NameValue nv) {
        authParams.set(nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //authParams.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.636 -0400", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "44A54ADA8EFE6F94707DC70FCF165FA5")
    public void setScheme(String s) {
        scheme = s;
        // ---------- Original Method ----------
        //scheme = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.636 -0400", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "62BD294171889153A614E164F2AAC8BB")
    public void setAuthParams(NameValueList a) {
        authParams = a;
        // ---------- Original Method ----------
        //authParams = a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.637 -0400", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "302831A98576A8AC4A745D4FD4BCCE85")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_490602453 = null; //Variable for return #1
        Challenge retval;
        retval = (Challenge) super.clone();
        retval.authParams = (NameValueList) this.authParams.clone();
        varB4EAC82CA7396A68D541C85D26508E83_490602453 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_490602453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_490602453;
        // ---------- Original Method ----------
        //Challenge retval = (Challenge) super.clone();
        //if (this.authParams != null)
            //retval.authParams = (NameValueList) this.authParams.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "4D0BB4F1B7A5F62BAE0586972D545170", hash_generated_field = "5723B57B3DBF2479009D6D3B1E882082")

    private static long serialVersionUID = 5944455875924336L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "78E11EC5EB66AE64A2B95E2463577A76")

    private static String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "E9916446BFADB0600378FB202B20EF35")

    private static String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "3C70F1532BAEF7757CB87A3B1702DE00")

    private static String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "0874C153365E26C97F39F1556B070049")

    private static String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "CF00A7D2B9ED61B4C939D708439BEAEB")

    private static String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "A3405C57F3C22C48D01F5F052E44B2FF")

    private static String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "BBFD446F7266827713456A338EE7CC61")

    private static String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "42D65330C8C16A68BB4020BE7AB00365")

    private static String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C526A53CD7792EE76E85F7166E823C42")

    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.641 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "C4DF7E8DFBBC37CD137736E52F4CB325")

    private static String URI = ParameterNames.URI;
}

