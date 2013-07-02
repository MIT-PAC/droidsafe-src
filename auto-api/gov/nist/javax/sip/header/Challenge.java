package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;

public class Challenge extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.314 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.314 -0400", hash_original_field = "A38FBF55660E169551EA40BA83339BC2", hash_generated_field = "3C192C96CF447535D68E25BB7C5623D6")

    protected NameValueList authParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.315 -0400", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "8B8D628BE29F284A7616E96B4E975F92")
    public  Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.315 -0400", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "B7025F81AC47B847CF2705DDF04219EC")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1827024628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1827024628 = new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_1827024628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1827024628;
        
        
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.316 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "76CD8EC1F4EDB1C740A2A927ACD5A4E4")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_747024416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_747024416 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_747024416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_747024416;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.316 -0400", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "D440BDCDAACAB89A0A5A39B23F9EA185")
    public NameValueList getAuthParams() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1910501683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1910501683 = authParams;
        varB4EAC82CA7396A68D541C85D26508E83_1910501683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1910501683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.317 -0400", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "A6A2453B60346DEEF1DBD96F2C4E8E20")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1683771199 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1683771199 = (String) authParams.getValue(DOMAIN);
        varB4EAC82CA7396A68D541C85D26508E83_1683771199.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1683771199;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.318 -0400", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "624E9F505E898BD71DCF728A0D688839")
    public String getURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1783013307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1783013307 = (String) authParams.getValue(URI);
        varB4EAC82CA7396A68D541C85D26508E83_1783013307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1783013307;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.320 -0400", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "5EBB0DD5E91FB3F48D027D7407CEB204")
    public String getOpaque() {
        String varB4EAC82CA7396A68D541C85D26508E83_666119757 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_666119757 = (String) authParams.getValue(OPAQUE);
        varB4EAC82CA7396A68D541C85D26508E83_666119757.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_666119757;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.321 -0400", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "2ADB62EC7215280B185AF6232FC51D07")
    public String getQOP() {
        String varB4EAC82CA7396A68D541C85D26508E83_1858396631 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1858396631 = (String) authParams.getValue(QOP);
        varB4EAC82CA7396A68D541C85D26508E83_1858396631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1858396631;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.323 -0400", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "6488C5D50E1E26BF9D4EC3C0B00F273A")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1051797655 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1051797655 = (String) authParams.getValue(ALGORITHM);
        varB4EAC82CA7396A68D541C85D26508E83_1051797655.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051797655;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.324 -0400", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "9DAC32139B0D5CFEA51F11C20A924B2C")
    public String getStale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1329330401 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1329330401 = (String) authParams.getValue(STALE);
        varB4EAC82CA7396A68D541C85D26508E83_1329330401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1329330401;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.326 -0400", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "B769912E3B9A31A622A2754EFC33D5D3")
    public String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_127589911 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_127589911 = (String) authParams.getValue(SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_127589911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_127589911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.328 -0400", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "5F078B1407A0ED1022BEF6A891348EFB")
    public String getSignedBy() {
        String varB4EAC82CA7396A68D541C85D26508E83_1067566686 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1067566686 = (String) authParams.getValue(SIGNED_BY);
        varB4EAC82CA7396A68D541C85D26508E83_1067566686.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1067566686;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.330 -0400", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "DA8E311C07712B8BBFD46D4EBAF626F9")
    public String getResponse() {
        String varB4EAC82CA7396A68D541C85D26508E83_1301893627 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1301893627 = (String) authParams.getValue(RESPONSE);
        varB4EAC82CA7396A68D541C85D26508E83_1301893627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1301893627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.333 -0400", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "F594A2240493D18ABE0917095C192F9D")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_358312133 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_358312133 = (String) authParams.getValue(REALM);
        varB4EAC82CA7396A68D541C85D26508E83_358312133.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_358312133;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.334 -0400", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "313BCAE7658AF6D65B0D5E80BC95D775")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1844734127 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1844734127 = (String) authParams.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1844734127.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1844734127;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.334 -0400", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "0ECF78515FEC5E33D606D8F4533F485B")
    public boolean hasParameter(String name) {
        boolean var9CDB262022BA25401DCC23F24FDB2455_1951238463 = (authParams.getNameValue(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060528088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060528088;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.335 -0400", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "FF4BFF541DA2F30AE2B5383219B5705A")
    public boolean hasParameters() {
        boolean var98180B4D7CA2D3D9253C4DB1AD3325E9_1204315502 = (authParams.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737524514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737524514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.335 -0400", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "9D2ECB4AE5679AE34EF489CC6C498C71")
    public boolean removeParameter(String name) {
        boolean varB17796B60C8DF8AC1E0C404280083FDA_1681795108 = (authParams.delete(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373968659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373968659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.335 -0400", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "4459F5A0A762415A41C07B76C3FC94F7")
    public void removeParameters() {
        authParams = new NameValueList();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.336 -0400", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "23F4F5DD4EC369AD9501994E80DC23CB")
    public void setParameter(NameValue nv) {
        authParams.set(nv);
        addTaint(nv.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.336 -0400", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "44A54ADA8EFE6F94707DC70FCF165FA5")
    public void setScheme(String s) {
        scheme = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.336 -0400", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "62BD294171889153A614E164F2AAC8BB")
    public void setAuthParams(NameValueList a) {
        authParams = a;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "B8E4BA065B98E7257BDC0930F95AB78F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_555459164 = null; 
        Challenge retval = (Challenge) super.clone();
        retval.authParams = (NameValueList) this.authParams.clone();
        varB4EAC82CA7396A68D541C85D26508E83_555459164 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_555459164.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_555459164;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "4D0BB4F1B7A5F62BAE0586972D545170", hash_generated_field = "11864689FB5A61F36957C7AFB5C2B569")

    private static final long serialVersionUID = 5944455875924336L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "78E11EC5EB66AE64A2B95E2463577A76")

    private static String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "E9916446BFADB0600378FB202B20EF35")

    private static String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "3C70F1532BAEF7757CB87A3B1702DE00")

    private static String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "0874C153365E26C97F39F1556B070049")

    private static String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "CF00A7D2B9ED61B4C939D708439BEAEB")

    private static String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "A3405C57F3C22C48D01F5F052E44B2FF")

    private static String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "BBFD446F7266827713456A338EE7CC61")

    private static String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "42D65330C8C16A68BB4020BE7AB00365")

    private static String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C526A53CD7792EE76E85F7166E823C42")

    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.337 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "C4DF7E8DFBBC37CD137736E52F4CB325")

    private static String URI = ParameterNames.URI;
}

