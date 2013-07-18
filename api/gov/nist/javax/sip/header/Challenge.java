package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Challenge extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.171 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.171 -0400", hash_original_field = "A38FBF55660E169551EA40BA83339BC2", hash_generated_field = "3C192C96CF447535D68E25BB7C5623D6")

    protected NameValueList authParams;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.171 -0400", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "8B8D628BE29F284A7616E96B4E975F92")
    public  Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
        // ---------- Original Method ----------
        //authParams = new NameValueList();
        //authParams.setSeparator(COMMA);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.172 -0400", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "32B0B4BCA2AAB6F37E95BF542B201D0C")
    public String encode() {
String var81E644D530FBAA60F722AFDF7427147A_589926344 =         new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString();
        var81E644D530FBAA60F722AFDF7427147A_589926344.addTaint(taint);
        return var81E644D530FBAA60F722AFDF7427147A_589926344;
        // ---------- Original Method ----------
        //return new StringBuffer(scheme)
            //.append(SP)
            //.append(authParams.encode())
            //.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.172 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "507867E15C5CB72B04F6C65D8608D7D5")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1884420663 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1884420663.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1884420663;
        // ---------- Original Method ----------
        //return scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.172 -0400", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "524B097AEA352C376897EFCFDE94768B")
    public NameValueList getAuthParams() {
NameValueList var7530A533CDFE9A20139868FA83C46D38_936724729 =         authParams;
        var7530A533CDFE9A20139868FA83C46D38_936724729.addTaint(taint);
        return var7530A533CDFE9A20139868FA83C46D38_936724729;
        // ---------- Original Method ----------
        //return authParams;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.172 -0400", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "F6C721E4717BBE5A52896CBEB9922774")
    public String getDomain() {
String var323C4164EC09E43369B946797DEC0AD5_1847819663 =         (String) authParams.getValue(DOMAIN);
        var323C4164EC09E43369B946797DEC0AD5_1847819663.addTaint(taint);
        return var323C4164EC09E43369B946797DEC0AD5_1847819663;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(DOMAIN);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.173 -0400", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "7EFB5315C8A58279806BD54191326A23")
    public String getURI() {
String var14A98DB78BE03854BBFB949569C97E0B_1555411151 =         (String) authParams.getValue(URI);
        var14A98DB78BE03854BBFB949569C97E0B_1555411151.addTaint(taint);
        return var14A98DB78BE03854BBFB949569C97E0B_1555411151;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(URI);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.173 -0400", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "136CA1D38FE6FB9648A7139879CB44BA")
    public String getOpaque() {
String var4706C06AEAD540B3A147DE9CC3AE9E35_554460300 =         (String) authParams.getValue(OPAQUE);
        var4706C06AEAD540B3A147DE9CC3AE9E35_554460300.addTaint(taint);
        return var4706C06AEAD540B3A147DE9CC3AE9E35_554460300;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(OPAQUE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.173 -0400", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "50D812E096EB350D5FAFD287646B40ED")
    public String getQOP() {
String varBAD0EA0A7E39D2CD1D6FC9D24ECEAC72_774896397 =         (String) authParams.getValue(QOP);
        varBAD0EA0A7E39D2CD1D6FC9D24ECEAC72_774896397.addTaint(taint);
        return varBAD0EA0A7E39D2CD1D6FC9D24ECEAC72_774896397;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(QOP);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.173 -0400", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "A95CC74FB5754592FBBEFBEB28E4AC4D")
    public String getAlgorithm() {
String varDFFCE8F20F53930CD01780EF43732F81_1881490905 =         (String) authParams.getValue(ALGORITHM);
        varDFFCE8F20F53930CD01780EF43732F81_1881490905.addTaint(taint);
        return varDFFCE8F20F53930CD01780EF43732F81_1881490905;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(ALGORITHM);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.174 -0400", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "DFC3F9CEFEF4889E4EA68814D0D6DAA2")
    public String getStale() {
String var50D1EF17F8A3C33C8F6299FE9729DFA3_497020947 =         (String) authParams.getValue(STALE);
        var50D1EF17F8A3C33C8F6299FE9729DFA3_497020947.addTaint(taint);
        return var50D1EF17F8A3C33C8F6299FE9729DFA3_497020947;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(STALE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "ED7AB58FCC588D304B750093F8171B79")
    public String getSignature() {
String var7DE1E28B090108A481587F11848D5F67_518257522 =         (String) authParams.getValue(SIGNATURE);
        var7DE1E28B090108A481587F11848D5F67_518257522.addTaint(taint);
        return var7DE1E28B090108A481587F11848D5F67_518257522;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNATURE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "4B38CCF12EF39974EF32A6543923BDAC")
    public String getSignedBy() {
String varEA916D53A888454A08B1D62BD6E07BE8_1860541236 =         (String) authParams.getValue(SIGNED_BY);
        varEA916D53A888454A08B1D62BD6E07BE8_1860541236.addTaint(taint);
        return varEA916D53A888454A08B1D62BD6E07BE8_1860541236;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNED_BY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "FC51161DDAD11F3455123DAB6329FE79")
    public String getResponse() {
String var1CF446FEFB6B758679DF50B50BF10547_1340876986 =         (String) authParams.getValue(RESPONSE);
        var1CF446FEFB6B758679DF50B50BF10547_1340876986.addTaint(taint);
        return var1CF446FEFB6B758679DF50B50BF10547_1340876986;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(RESPONSE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "44D3F6A740585AE4F088137841681987")
    public String getRealm() {
String var8121A1AC7F2F2C1B7AE9AFCFF2D85AB4_575849564 =         (String) authParams.getValue(REALM);
        var8121A1AC7F2F2C1B7AE9AFCFF2D85AB4_575849564.addTaint(taint);
        return var8121A1AC7F2F2C1B7AE9AFCFF2D85AB4_575849564;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(REALM);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "ED8726564191705B6E6ED91DD6312145")
    public String getParameter(String name) {
        addTaint(name.getTaint());
String var7873516F8E33FDDF3B5D55F9B8E1A819_300934997 =         (String) authParams.getValue(name);
        var7873516F8E33FDDF3B5D55F9B8E1A819_300934997.addTaint(taint);
        return var7873516F8E33FDDF3B5D55F9B8E1A819_300934997;
        // ---------- Original Method ----------
        //return (String) authParams.getValue(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.175 -0400", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "36CAF5E50C642BD1CD1E34668C9BD305")
    public boolean hasParameter(String name) {
        addTaint(name.getTaint());
        boolean var8E6AF0E29BD41B38E3B7DDF834433D61_927742989 = (authParams.getNameValue(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768223638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_768223638;
        // ---------- Original Method ----------
        //return authParams.getNameValue(name) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.177 -0400", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "2C68C5C1755440846FC24696D669D501")
    public boolean hasParameters() {
        boolean var6C033DADAE487B20B2EFB460A71247CE_810988662 = (authParams.size() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737678283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737678283;
        // ---------- Original Method ----------
        //return authParams.size() != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.177 -0400", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "9BD249509FE7D870041A816E80A8D259")
    public boolean removeParameter(String name) {
        addTaint(name.getTaint());
        boolean var7F19C67423C8799E6FACA8792A97BCE0_1038184148 = (authParams.delete(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068453380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068453380;
        // ---------- Original Method ----------
        //return authParams.delete(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.178 -0400", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "4459F5A0A762415A41C07B76C3FC94F7")
    public void removeParameters() {
        authParams = new NameValueList();
        // ---------- Original Method ----------
        //authParams = new NameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.178 -0400", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "61C93055332CA2730D33BB5DA935D97B")
    public void setParameter(NameValue nv) {
        addTaint(nv.getTaint());
        authParams.set(nv);
        // ---------- Original Method ----------
        //authParams.set(nv);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.178 -0400", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "44A54ADA8EFE6F94707DC70FCF165FA5")
    public void setScheme(String s) {
        scheme = s;
        // ---------- Original Method ----------
        //scheme = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.178 -0400", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "62BD294171889153A614E164F2AAC8BB")
    public void setAuthParams(NameValueList a) {
        authParams = a;
        // ---------- Original Method ----------
        //authParams = a;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "DE0AE8BCC357FC84E8D9891EC1C1BA4A")
    public Object clone() {
        Challenge retval = (Challenge) super.clone();
        if(this.authParams != null)        
        retval.authParams = (NameValueList) this.authParams.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1614871387 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1614871387.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1614871387;
        // ---------- Original Method ----------
        //Challenge retval = (Challenge) super.clone();
        //if (this.authParams != null)
            //retval.authParams = (NameValueList) this.authParams.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "4D0BB4F1B7A5F62BAE0586972D545170", hash_generated_field = "11864689FB5A61F36957C7AFB5C2B569")

    private static final long serialVersionUID = 5944455875924336L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "8EA6824DECB34BBB28AF57DA1BD44556", hash_generated_field = "78E11EC5EB66AE64A2B95E2463577A76")

    private static String DOMAIN = ParameterNames.DOMAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "325F1559352A464A1E158DD837DDDFFD", hash_generated_field = "E9916446BFADB0600378FB202B20EF35")

    private static String REALM = ParameterNames.REALM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "32AF92216F761892309F2484D9599F85", hash_generated_field = "3C70F1532BAEF7757CB87A3B1702DE00")

    private static String OPAQUE = ParameterNames.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "387ECB8BF04D60A1AA8960CB95599A70", hash_generated_field = "0874C153365E26C97F39F1556B070049")

    private static String ALGORITHM = ParameterNames.ALGORITHM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "2FEC3D8481A5227CB9A0976878ED1C7F", hash_generated_field = "CF00A7D2B9ED61B4C939D708439BEAEB")

    private static String QOP = ParameterNames.QOP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "AA2E389C514F12E972C6C8138CDD1C39", hash_generated_field = "A3405C57F3C22C48D01F5F052E44B2FF")

    private static String STALE = ParameterNames.STALE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "9C7D39594CCE4AEFD7118E8CC94BB922", hash_generated_field = "BBFD446F7266827713456A338EE7CC61")

    private static String SIGNATURE = ParameterNames.SIGNATURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "7B89B294179070C91183135FB34FD821", hash_generated_field = "42D65330C8C16A68BB4020BE7AB00365")

    private static String RESPONSE = ParameterNames.RESPONSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "8FEE41F5075F893BC04D7D6FC601113D", hash_generated_field = "C526A53CD7792EE76E85F7166E823C42")

    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.179 -0400", hash_original_field = "4553EB1B3D114F3FE3896A3C28387C8B", hash_generated_field = "C4DF7E8DFBBC37CD137736E52F4CB325")

    private static String URI = ParameterNames.URI;
}

