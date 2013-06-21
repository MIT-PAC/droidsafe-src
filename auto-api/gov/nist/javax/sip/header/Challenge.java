package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;

public class Challenge extends SIPObject {
    protected String scheme;
    protected NameValueList authParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.865 -0400", hash_original_method = "8BBE6E62DECF2D10899FEF6115E55B0A", hash_generated_method = "8B8D628BE29F284A7616E96B4E975F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Challenge() {
        authParams = new NameValueList();
        authParams.setSeparator(COMMA);
        // ---------- Original Method ----------
        //authParams = new NameValueList();
        //authParams.setSeparator(COMMA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.865 -0400", hash_original_method = "31A296A1CA9C2500AE4E208A72C83C52", hash_generated_method = "1EEB60FE5F99E7B65B96324C31A3BDB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String var9BA2AFDDB064047C488D6C30F7D0E3D9_2113739708 = (new StringBuffer(scheme)
            .append(SP)
            .append(authParams.encode())
            .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new StringBuffer(scheme)
            //.append(SP)
            //.append(authParams.encode())
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "7AB044197F27131A6F832759E545093F", hash_generated_method = "3FFDD92251E1DD8464E7D5E7274D92EE")
    @DSModeled(DSC.SAFE)
    public NameValueList getAuthParams() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return authParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "524CBE86F5CB0851551BD8D9CE41050E", hash_generated_method = "C24977F2160339CA24FF3E0AFDEBCAB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDomain() {
        String var69AF42697DA6F4024BFCCD26D4045A0C_2117965674 = ((String) authParams.getValue(DOMAIN));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(DOMAIN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "BE9B31EF9F34CC2717C92C00E671086A", hash_generated_method = "B9FE7FA693AEE1AEA5F9609E18525EBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getURI() {
        String var4E5983530338D9E01F7156BCF2194331_1727150609 = ((String) authParams.getValue(URI));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(URI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "E73B00719536CCDE494138AC7E39B883", hash_generated_method = "7E40B76FAC11FEDD21AF08456CD0EC00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOpaque() {
        String varFDD1EA365AAF8367611762065369C433_290943042 = ((String) authParams.getValue(OPAQUE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(OPAQUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "F3682063DCD7F1CD4155E38D853E5DBB", hash_generated_method = "BFC2D0199FFA4765C2FB024C9AB16806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQOP() {
        String varD2919B50A88473B47023D99AD1D013E4_1029475328 = ((String) authParams.getValue(QOP));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(QOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.866 -0400", hash_original_method = "CCB0E42EBD2B55CEF1C50D8E85A69BA0", hash_generated_method = "FC7884D770A668E0A2D5E1253CF3F3FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAlgorithm() {
        String varAB2D7DCBDB5FCE0125284EE40C901F41_1728617795 = ((String) authParams.getValue(ALGORITHM));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(ALGORITHM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "1B871D910B9E0136E877D688BCC83CE6", hash_generated_method = "B8416538A2741849A0D3D42ADC941000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getStale() {
        String var185D9FB5EF62344EE4DDB7BF0012D8E0_592329564 = ((String) authParams.getValue(STALE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(STALE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "255DD7DBA22AF99FB411A52085D76836", hash_generated_method = "BC32689A1F1D0C22394AA83EA7680EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSignature() {
        String varFD7075A47EDA7EDDEFA5FF5CC9D57FF2_162376395 = ((String) authParams.getValue(SIGNATURE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNATURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "FB9E11AAE433D181FA345FD8C6B7C434", hash_generated_method = "B5DAAD4C81774FE041CA4ECE8319B046")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSignedBy() {
        String var2CD5C3CD6C2DCD3815C0FC2C4EB09947_558016386 = ((String) authParams.getValue(SIGNED_BY));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(SIGNED_BY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "630101C0FEA93ACE37620C1431253BDE", hash_generated_method = "BC06C2AF0A6B66742F42C788C8DDBD14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResponse() {
        String var840A33FB30B1AAFE7A6A93BCBFD8E458_593393769 = ((String) authParams.getValue(RESPONSE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(RESPONSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "2BDBFC5CD9055A8A53440AACCEEECF63", hash_generated_method = "544610129EEA10379BC0BAE048978E66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRealm() {
        String varF750CC321F3769CFEA2A3116764B80A9_2117172418 = ((String) authParams.getValue(REALM));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(REALM);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "99F64D67B14B37266543A349C4B21B53", hash_generated_method = "292E7F2FBBA50BDF88033E3FB489DB9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        String var90FE18915E6BD36186B73383634703EF_1993745649 = ((String) authParams.getValue(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) authParams.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.867 -0400", hash_original_method = "2E34AAE119CD850D1B253E2693552FEB", hash_generated_method = "35FCD354CA223FF5E7853A8380E5900E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParameter(String name) {
        dsTaint.addTaint(name);
        boolean var9CDB262022BA25401DCC23F24FDB2455_917413004 = (authParams.getNameValue(name) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return authParams.getNameValue(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "B5F8473E1F8564D0A56C45C190B84DBB", hash_generated_method = "A7A2CC6BDCDCB83C6FE3A1DD0DBD1169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParameters() {
        boolean var98180B4D7CA2D3D9253C4DB1AD3325E9_1288119604 = (authParams.size() != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return authParams.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "18ADB44A3B024567153A6DCCF4159539", hash_generated_method = "1B4D8BD4A056217FBF6EF19453F6E4CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeParameter(String name) {
        dsTaint.addTaint(name);
        boolean varB17796B60C8DF8AC1E0C404280083FDA_2076865814 = (authParams.delete(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return authParams.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "75751EE68232240DE115414D89F9922B", hash_generated_method = "4459F5A0A762415A41C07B76C3FC94F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameters() {
        authParams = new NameValueList();
        // ---------- Original Method ----------
        //authParams = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "6C2AF9C154AE46C371A5DD84DFA39C4F", hash_generated_method = "BA05BF7B01A15D2DE58C97D13F1E8A81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(NameValue nv) {
        dsTaint.addTaint(nv.dsTaint);
        authParams.set(nv);
        // ---------- Original Method ----------
        //authParams.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "E1049E827E0E0A74C671FFCF89FB5B30", hash_generated_method = "E928B4569CAF3EB7051584FF542268BD")
    @DSModeled(DSC.SAFE)
    public void setScheme(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //scheme = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "82B720F7CD11140D4D4B228FFF7C7395", hash_generated_method = "D00BA30ACE101D3FF67AF6E48C6A0EC7")
    @DSModeled(DSC.SAFE)
    public void setAuthParams(NameValueList a) {
        dsTaint.addTaint(a.dsTaint);
        // ---------- Original Method ----------
        //authParams = a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.868 -0400", hash_original_method = "BDAE145DB99173579ABC594BFE585895", hash_generated_method = "44E531F9DBF36FC213D7BAD7626EB5BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Challenge retval;
        retval = (Challenge) super.clone();
        retval.authParams = (NameValueList) this.authParams.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Challenge retval = (Challenge) super.clone();
        //if (this.authParams != null)
            //retval.authParams = (NameValueList) this.authParams.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = 5944455875924336L;
    private static String DOMAIN = ParameterNames.DOMAIN;
    private static String REALM = ParameterNames.REALM;
    private static String OPAQUE = ParameterNames.OPAQUE;
    private static String ALGORITHM = ParameterNames.ALGORITHM;
    private static String QOP = ParameterNames.QOP;
    private static String STALE = ParameterNames.STALE;
    private static String SIGNATURE = ParameterNames.SIGNATURE;
    private static String RESPONSE = ParameterNames.RESPONSE;
    private static String SIGNED_BY = ParameterNames.SIGNED_BY;
    private static String URI = ParameterNames.URI;
}

