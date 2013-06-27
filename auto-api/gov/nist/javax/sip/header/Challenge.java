package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;

public class Challenge extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.756 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.756 -0400", hash_original_field = "A38FBF55660E169551EA40BA83339BC2", hash_generated_field = "3C192C96CF447535D68E25BB7C5623D6")

    protected NameValueList authParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.756 -0400", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "8B8D628BE29F284A7616E96B4E975F92")
    public  Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
        // ---------- Original Method ----------
        //authParams = new NameValueList();
        //authParams.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.759 -0400", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "508CDCD7428489D4A3C0E7880403D7FD")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_310777658 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310777658 = new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_310777658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310777658;
        // ---------- Original Method ----------
        //return new StringBuffer(scheme)
            //.append(SP)
            //.append(authParams.encode())
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.759 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "91050D042CDDF94F47EFE9E1C02DB6B1")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_2086813803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2086813803 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_2086813803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2086813803;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.765 -0400", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "5965F3D707C27F7F74F7E5EE04E7164F")
    public NameValueList getAuthParams() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_357647806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_357647806 = authParams;
        varB4EAC82CA7396A68D541C85D26508E83_357647806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_357647806;
        // ---------- Original Method ----------
        //return authParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.770 -0400", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "4EFBD328EB604A334C83F94B75EDF63D")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1267030183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1267030183 = (String) authParams.getValue(DOMAIN);
        varB4EAC82CA7396A68D541C85D26508E83_1267030183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1267030183;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(DOMAIN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.776 -0400", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "99067FF84941D416CFFD4F2D4DDE4279")
    public String getURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_653862342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_653862342 = (String) authParams.getValue(URI);
        varB4EAC82CA7396A68D541C85D26508E83_653862342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_653862342;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(URI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.778 -0400", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "E7D97030C06C800B73187304D88141FF")
    public String getOpaque() {
        String varB4EAC82CA7396A68D541C85D26508E83_171643252 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_171643252 = (String) authParams.getValue(OPAQUE);
        varB4EAC82CA7396A68D541C85D26508E83_171643252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171643252;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(OPAQUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.778 -0400", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "EE87B6E2F2BD02288C21A8B7F54BF980")
    public String getQOP() {
        String varB4EAC82CA7396A68D541C85D26508E83_1267898005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1267898005 = (String) authParams.getValue(QOP);
        varB4EAC82CA7396A68D541C85D26508E83_1267898005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1267898005;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.780 -0400", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "74070623FA579E5F537C87BDBB6B54F0")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1518686631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1518686631 = (String) authParams.getValue(ALGORITHM);
        varB4EAC82CA7396A68D541C85D26508E83_1518686631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1518686631;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(ALGORITHM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.795 -0400", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "26128B27CBDFE105681A5B4F74B1E76E")
    public String getStale() {
        String varB4EAC82CA7396A68D541C85D26508E83_927464030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_927464030 = (String) authParams.getValue(STALE);
        varB4EAC82CA7396A68D541C85D26508E83_927464030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_927464030;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(STALE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.796 -0400", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "6A2850ACFAC3D0EBB874397D23AC7872")
    public String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_1699663976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1699663976 = (String) authParams.getValue(SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_1699663976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1699663976;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNATURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.796 -0400", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "7DDA23675F5D0B0E810006D4B635D122")
    public String getSignedBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_915230000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915230000 = (String) authParams.getValue(SIGNED_BY);
        varB4EAC82CA7396A68D541C85D26508E83_915230000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915230000;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNED_BY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.797 -0400", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "9833EC281627EE9ADF445F0C62DA57E7")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_854684485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854684485 = (String) authParams.getValue(RESPONSE);
        varB4EAC82CA7396A68D541C85D26508E83_854684485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854684485;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(RESPONSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.797 -0400", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "FA06BB19131F2CDF0AA08692551C965E")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1406924468 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1406924468 = (String) authParams.getValue(REALM);
        varB4EAC82CA7396A68D541C85D26508E83_1406924468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1406924468;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(REALM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.806 -0400", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "D926638C1CAEFEE05E564F6FADDBDB34")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_568173767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_568173767 = (String) authParams.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_568173767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_568173767;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.806 -0400", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "64C37DB1EF20C862142F9910BFFC1253")
    public boolean hasParameter(String name) {
        boolean var9CDB262022BA25401DCC23F24FDB2455_1020969936 = (authParams.getNameValue(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112774182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112774182;
        // ---------- Original Method ----------
        //return authParams.getNameValue(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.808 -0400", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "C28FE3738AF45F9919825A3811A2F217")
    public boolean hasParameters() {
        boolean var98180B4D7CA2D3D9253C4DB1AD3325E9_1342433361 = (authParams.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742301732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742301732;
        // ---------- Original Method ----------
        //return authParams.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.808 -0400", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "4922F21725A5C8DE04C36B450889FE6B")
    public boolean removeParameter(String name) {
        boolean varB17796B60C8DF8AC1E0C404280083FDA_1850218654 = (authParams.delete(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080491979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080491979;
        // ---------- Original Method ----------
        //return authParams.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.808 -0400", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "4459F5A0A762415A41C07B76C3FC94F7")
    public void removeParameters() {
        authParams = new NameValueList();
        // ---------- Original Method ----------
        //authParams = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.810 -0400", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "23F4F5DD4EC369AD9501994E80DC23CB")
    public void setParameter(NameValue nv) {
        authParams.set(nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //authParams.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.810 -0400", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "44A54ADA8EFE6F94707DC70FCF165FA5")
    public void setScheme(String s) {
        scheme = s;
        // ---------- Original Method ----------
        //scheme = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.810 -0400", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "62BD294171889153A614E164F2AAC8BB")
    public void setAuthParams(NameValueList a) {
        authParams = a;
        // ---------- Original Method ----------
        //authParams = a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.812 -0400", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "ADA2AECF8BD20542BE45042373BE1957")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_132013354 = null; //Variable for return #1
        Challenge retval;
        retval = (Challenge) super.clone();
        retval.authParams = (NameValueList) this.authParams.clone();
        varB4EAC82CA7396A68D541C85D26508E83_132013354 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_132013354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_132013354;
        // ---------- Original Method ----------
        //Challenge retval = (Challenge) super.clone();
        //if (this.authParams != null)
            //retval.authParams = (NameValueList) this.authParams.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "4D0BB4F1B7A5F62BAE0586972D545170", hash_generated_field = "5723B57B3DBF2479009D6D3B1E882082")

    private static long serialVersionUID = 5944455875924336L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "78E11EC5EB66AE64A2B95E2463577A76")

    private static String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "E9916446BFADB0600378FB202B20EF35")

    private static String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "3C70F1532BAEF7757CB87A3B1702DE00")

    private static String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "0874C153365E26C97F39F1556B070049")

    private static String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "CF00A7D2B9ED61B4C939D708439BEAEB")

    private static String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "A3405C57F3C22C48D01F5F052E44B2FF")

    private static String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "BBFD446F7266827713456A338EE7CC61")

    private static String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "42D65330C8C16A68BB4020BE7AB00365")

    private static String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C526A53CD7792EE76E85F7166E823C42")

    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.814 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "C4DF7E8DFBBC37CD137736E52F4CB325")

    private static String URI = ParameterNames.URI;
}

