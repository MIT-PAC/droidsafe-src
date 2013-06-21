package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.util.*;
import java.text.ParseException;
import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.SipURI;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;

public class SipUri extends GenericURI implements javax.sip.address.SipURI, SipURIExt {
    protected Authority authority;
    protected NameValueList uriParms;
    protected NameValueList qheaders;
    protected TelephoneNumber telephoneSubscriber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.471 -0400", hash_original_method = "4581AC1C0AE43A94306BF80DA76A0B36", hash_generated_method = "C518F6BE6D677C49B5D373A0ADD9B73A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipUri() {
        this.scheme = SIP;
        this.uriParms = new NameValueList();
        this.qheaders = new NameValueList();
        this.qheaders.setSeparator("&");
        // ---------- Original Method ----------
        //this.scheme = SIP;
        //this.uriParms = new NameValueList();
        //this.qheaders = new NameValueList();
        //this.qheaders.setSeparator("&");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.471 -0400", hash_original_method = "40F35B976B5ABD0FB641A4F1A08DC6DF", hash_generated_method = "B5F72682AF959E1BCF63239855CA1BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScheme(String scheme) {
        dsTaint.addTaint(scheme);
        {
            boolean var97AD44F10E926B94254CAE8B4A864B93_1834529560 = (scheme.compareToIgnoreCase(SIP) != 0
            && scheme.compareToIgnoreCase(SIPS) != 0);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad scheme " + scheme);
        } //End collapsed parenthetic
        this.scheme = scheme.toLowerCase();
        // ---------- Original Method ----------
        //if (scheme.compareToIgnoreCase(SIP) != 0
            //&& scheme.compareToIgnoreCase(SIPS) != 0)
            //throw new IllegalArgumentException("bad scheme " + scheme);
        //this.scheme = scheme.toLowerCase();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.472 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.472 -0400", hash_original_method = "B97988479159B246DBD5976667FAE614", hash_generated_method = "7A913D6E89C72AB83AFFF954FFBF7CD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearUriParms() {
        uriParms = new NameValueList();
        // ---------- Original Method ----------
        //uriParms = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.472 -0400", hash_original_method = "FDFE9380996AC8B536679A9DC84D64BE", hash_generated_method = "2A7ADE04855C8852A0651183D844B50B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearPassword() {
        {
            UserInfo userInfo;
            userInfo = authority.getUserInfo();
            userInfo.clearPassword();
        } //End block
        // ---------- Original Method ----------
        //if (this.authority != null) {
            //UserInfo userInfo = authority.getUserInfo();
            //if (userInfo != null)
                //userInfo.clearPassword();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.472 -0400", hash_original_method = "92C8D5BE70E6877E725894DF3752DAAD", hash_generated_method = "1A29A28FFB77DEEB89287792CBA25DDA")
    @DSModeled(DSC.SAFE)
    public Authority getAuthority() {
        return (Authority)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.472 -0400", hash_original_method = "44A5F82F772B2346E44573FA04C5E6BF", hash_generated_method = "546FDDE1F5876502A34904E6040940A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearQheaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.473 -0400", hash_original_method = "9EAD5694A977A9D6081FC9F5B163E148", hash_generated_method = "AEAB39D7743C68882324480BF8E13994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        {
            boolean var808EFC10B8F4455D1156A05691BEC636_2050824361 = (that==this);
        } //End collapsed parenthetic
        {
            SipURI a;
            a = this;
            SipURI b;
            b = (SipURI) that;
            {
                boolean var3DAD500499FBDCF2474A0DD7D6A43FB0_1880456816 = (a.isSecure() ^ b.isSecure());
            } //End collapsed parenthetic
            {
                boolean var704E29857B9D24BE4B1B80701D880A80_611680138 = (a.getUser()==null ^ b.getUser()==null);
            } //End collapsed parenthetic
            {
                boolean varC58E713B7450E3011557684C96505C39_1532097870 = (a.getUserPassword()==null ^ b.getUserPassword()==null);
            } //End collapsed parenthetic
            {
                boolean varD6ACDEEED2B014C2CE240A5BB9A6408C_1266491809 = (a.getUser()!=null && !RFC2396UrlDecoder.decode(a.getUser()).equals(RFC2396UrlDecoder.decode(b.getUser())));
            } //End collapsed parenthetic
            {
                boolean var729E26EDB58F2750945DC0B0CD69C74F_700593316 = (a.getUserPassword()!=null && !RFC2396UrlDecoder.decode(a.getUserPassword()).equals(RFC2396UrlDecoder.decode(b.getUserPassword())));
            } //End collapsed parenthetic
            {
                boolean varB2AE7DAFE4D623C36619676A1F26C655_981811445 = (a.getHost() == null ^ b.getHost() == null);
            } //End collapsed parenthetic
            {
                boolean var548B93FB59C3C5854AF23CB4EDE37087_1804388029 = (a.getHost() != null && !a.getHost().equalsIgnoreCase(b.getHost()));
            } //End collapsed parenthetic
            {
                boolean varC7F2A707C749FADCBCA7E25C56790F40_995999170 = (a.getPort() != b.getPort());
            } //End collapsed parenthetic
            {
                Iterator i;
                i = a.getParameterNames();
                boolean varD8B5E52A597500CBD863E52A46B42708_570048678 = (i.hasNext());
                {
                    String pname;
                    pname = (String) i.next();
                    String p1;
                    p1 = a.getParameter(pname);
                    String p2;
                    p2 = b.getParameter(pname);
                    {
                        boolean var2A429907F6E3B98686BBD2EA978AFFE6_1810991257 = (p1!=null && p2!=null && !RFC2396UrlDecoder.decode(p1).equalsIgnoreCase(RFC2396UrlDecoder.decode(p2)));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var427C16ABDA4EB8D3C9C9EF9935340458_97582283 = (a.getTransportParam()==null ^ b.getTransportParam()==null);
            } //End collapsed parenthetic
            {
                boolean var5E48CD8F2CB1AFB3852FB9CE3A7FEF19_1338454900 = (a.getUserParam()==null ^ b.getUserParam()==null);
            } //End collapsed parenthetic
            {
                boolean var1CAD38A75018FA486465431324399EDE_890955114 = (a.getTTLParam()==-1 ^ b.getTTLParam()==-1);
            } //End collapsed parenthetic
            {
                boolean var35B18F7355EA9EA4D1DC7ED18518C2A1_1487227638 = (a.getMethodParam()==null ^ b.getMethodParam()==null);
            } //End collapsed parenthetic
            {
                boolean varB4CA52932B1771A9881F31D72005C84C_1326433067 = (a.getMAddrParam()==null ^ b.getMAddrParam()==null);
            } //End collapsed parenthetic
            {
                boolean var45DA844974FC5013184143BF0E5C0B99_1623498456 = (a.getHeaderNames().hasNext() && !b.getHeaderNames().hasNext());
            } //End collapsed parenthetic
            {
                boolean varBFB76F3DFF7FD2223F8A22D958B17BF9_674958671 = (!a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext());
            } //End collapsed parenthetic
            {
                boolean var73D441E8E3A4F6FA3DA2FD2716437D95_1194651526 = (a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext());
                {
                    HeaderFactory headerFactory;
                    headerFactory = null;
                    try 
                    {
                        headerFactory = SipFactory.getInstance().createHeaderFactory();
                    } //End block
                    catch (PeerUnavailableException e)
                    {
                        Debug.logError("Cannot get the header factory to parse the header of the sip uris to compare", e);
                    } //End block
                    {
                        Iterator i;
                        i = a.getHeaderNames();
                        boolean var5A904445088E8F340E730368D637913B_312520372 = (i.hasNext());
                        {
                            String hname;
                            hname = (String) i.next();
                            String h1;
                            h1 = a.getHeader(hname);
                            String h2;
                            h2 = b.getHeader(hname);
                            try 
                            {
                                Header header1;
                                header1 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h1));
                                Header header2;
                                header2 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h2));
                                {
                                    boolean varD5C1E0445459D68D145CA90087C85616_1230027053 = (!header1.equals(header2));
                                } //End collapsed parenthetic
                            } //End block
                            catch (ParseException e)
                            {
                                Debug.logError("Cannot parse one of the header of the sip uris to compare " + a + " " + b, e);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.474 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "7FFB5E6E6CD83C08E2D367BBED329908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1862632084 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.474 -0400", hash_original_method = "C22033B09BF680257BC2551F51CC4682", hash_generated_method = "05E7EABF500DFDD4CAE6C6C995BDD5AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(scheme).append(COLON);
        authority.encode(buffer);
        {
            boolean varF56D09C2F80594AA787675634C167937_1019765276 = (!uriParms.isEmpty());
            {
                buffer.append(SEMICOLON);
                uriParms.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var456BAFF324BFA7394EA2AF8E00095090_28455183 = (!qheaders.isEmpty());
            {
                buffer.append(QUESTION);
                qheaders.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(scheme).append(COLON);
        //if (authority != null)
            //authority.encode(buffer);
        //if (!uriParms.isEmpty()) {
            //buffer.append(SEMICOLON);
            //uriParms.encode(buffer);
        //}
        //if (!qheaders.isEmpty()) {
            //buffer.append(QUESTION);
            //qheaders.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.474 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "EF0FCC59BED623625FEDC92BADC89DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_1447373224 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.475 -0400", hash_original_method = "000995A40BE4F62572B4CEC75CD27D06", hash_generated_method = "5D2DE8178B555E4AA9736F095EB7CFB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserAtHost() {
        String user;
        user = "";
        {
            boolean var2E19B47438D44DE246325E874206758A_160804642 = (authority.getUserInfo() != null);
            user = authority.getUserInfo().getUser();
        } //End collapsed parenthetic
        String host;
        host = authority.getHost().encode();
        StringBuffer s;
        s = null;
        {
            boolean varD68E445BC0FFF6B8A1FF5F6BFB1F4754_371586433 = (user.equals(""));
            {
                s = new StringBuffer();
            } //End block
            {
                s = new StringBuffer(user).append(AT);
            } //End block
        } //End collapsed parenthetic
        String var1DB94B6BED33EB35A596EC4B3E253DEF_1582657032 = (s.append(host).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String user = "";
        //if (authority.getUserInfo() != null)
            //user = authority.getUserInfo().getUser();
        //String host = authority.getHost().encode();
        //StringBuffer s = null;
        //if (user.equals("")) {
            //s = new StringBuffer();
        //} else {
            //s = new StringBuffer(user).append(AT);
        //}
        //return s.append(host).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.475 -0400", hash_original_method = "6F248E410BDCE844EE042BFFA98482C9", hash_generated_method = "10275911E16B99ACF85D048E83555E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserAtHostPort() {
        String user;
        user = "";
        {
            boolean var2E19B47438D44DE246325E874206758A_1113118895 = (authority.getUserInfo() != null);
            user = authority.getUserInfo().getUser();
        } //End collapsed parenthetic
        String host;
        host = authority.getHost().encode();
        int port;
        port = authority.getPort();
        StringBuffer s;
        s = null;
        {
            boolean varD68E445BC0FFF6B8A1FF5F6BFB1F4754_635790873 = (user.equals(""));
            {
                s = new StringBuffer();
            } //End block
            {
                s = new StringBuffer(user).append(AT);
            } //End block
        } //End collapsed parenthetic
        {
            String var652B83F0301E3C39DBB4E7A41DAF5F07_2088421760 = (s.append(host).append(COLON).append(port).toString());
        } //End block
        String var1DB94B6BED33EB35A596EC4B3E253DEF_1337653095 = (s.append(host).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String user = "";
        //if (authority.getUserInfo() != null)
            //user = authority.getUserInfo().getUser();
        //String host = authority.getHost().encode();
        //int port = authority.getPort();
        //StringBuffer s = null;
        //if (user.equals("")) {
            //s = new StringBuffer();
        //} else {
            //s = new StringBuffer(user).append(AT);
        //}
        //if (port != -1) {
            //return s.append(host).append(COLON).append(port).toString();
        //} else
            //return s.append(host).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.475 -0400", hash_original_method = "208FE04DEC7ECCEEFC5A47E5D08BA557", hash_generated_method = "60C31C46C12B8196D930FDB7D90A6A33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getParm(String parmname) {
        dsTaint.addTaint(parmname);
        Object obj;
        obj = uriParms.getValue(parmname);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object obj = uriParms.getValue(parmname);
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.475 -0400", hash_original_method = "DA8D1E67518AA478AB8C96314B0F321C", hash_generated_method = "07FF01F367988D81759E891254EF436C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMethod() {
        String var2F5E014C709BBE35F4DBED1EDA645175_1843488483 = ((String) getParm(METHOD));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) getParm(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.475 -0400", hash_original_method = "5EDAD210CE239248A46B40B8A7E4E067", hash_generated_method = "242CDDC2FFDCB810799BE797E876BF7E")
    @DSModeled(DSC.SAFE)
    public NameValueList getParameters() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return uriParms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "F23607C60777A1A36911A6FE06B11E71", hash_generated_method = "4FF98F06B904C85601629D95CCCE2CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameters() {
        this.uriParms = new NameValueList();
        // ---------- Original Method ----------
        //this.uriParms = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "69A77D050D6DE602ACFB758F18CE1C2E", hash_generated_method = "A181DCCE8F71A8DF0854BFFF7325B2B1")
    @DSModeled(DSC.SAFE)
    public NameValueList getQheaders() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return qheaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "C4F4158359E9C3CE01C658AE1B903AEE", hash_generated_method = "53CD996D388E965D03B2254F14828AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserType() {
        String var83E0078BDBCAC07FD3A05143E451DC08_1012237814 = ((String) uriParms.getValue(USER));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) uriParms.getValue(USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "F7BA3F65C36127DC85DBDC366FBE67EC", hash_generated_method = "ED5A81FB187F8DCBA26BAF316913C064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserPassword() {
        String var83584E48C2783EBC75FB769D5BB286F5_1435515982 = (authority.getPassword());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (authority == null)
            //return null;
        //return authority.getPassword();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "EB4E37E6319716C20DB55C1D8565711A", hash_generated_method = "0C86C6A6208C9A0520B0E13E276975E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserPassword(String password) {
        dsTaint.addTaint(password);
        this.authority = new Authority();
        authority.setPassword(password);
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //authority.setPassword(password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.476 -0400", hash_original_method = "FBB7E1AC9741B23BB5B3EA84041A8793", hash_generated_method = "1EB8A5ADADB979950DDA13FBFCB5C630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TelephoneNumber getTelephoneSubscriber() {
        {
            telephoneSubscriber = new TelephoneNumber();
        } //End block
        return (TelephoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null) {
            //telephoneSubscriber = new TelephoneNumber();
        //}
        //return telephoneSubscriber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.477 -0400", hash_original_method = "B2DE769DC5E0088684B143D456F129CF", hash_generated_method = "FB11DFD034D976C2BE5DF4D897CAC7A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        {
            boolean varA35D3DDB12550A696B0F3B18AECFDF7F_1194829632 = (authority == null || authority.getHost() == null);
            {
                HostPort varBD9D9E6D33BDC7F5ACA5D5AF1E23BCA4_1366912928 = (authority.getHostPort());
            } //End block
        } //End collapsed parenthetic
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (authority == null || authority.getHost() == null )
            //return null;
        //else {
            //return authority.getHostPort();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.477 -0400", hash_original_method = "7F780725D3A26A9FAAA917ED82465734", hash_generated_method = "6E4D973AF91E3A7499F2629C1F92996F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        HostPort hp;
        hp = this.getHostPort();
        int var367395E2945B2A27F48B64C482E41962_816310249 = (hp.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //HostPort hp = this.getHostPort();
        //if (hp == null)
            //return -1;
        //return hp.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.477 -0400", hash_original_method = "40B106F658B1B0B8AE55FF744395EB77", hash_generated_method = "2753F794D5AA3E1DF985BF3BBB97C4E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        {
            boolean varE82FD8B166FEACA8671C68F1E3F7834A_2015917140 = (authority.getHost() == null);
            String var532706CB4159B858F6111B2F9DB7F340_1471662496 = (authority.getHost().encode());
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if ( authority == null) return null;
        //else if (authority.getHost() == null ) return null;
        //else return authority.getHost().encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.477 -0400", hash_original_method = "56CDDCF4149582CE88DAE7137BB51FB6", hash_generated_method = "5271B6000F7B093F19385690CF86A47B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUserTelephoneSubscriber() {
        String usrtype;
        usrtype = (String) uriParms.getValue(USER);
        boolean var18C173688EA6508503FB97650EB726B4_1471283267 = (usrtype.equalsIgnoreCase(PHONE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String usrtype = (String) uriParms.getValue(USER);
        //if (usrtype == null)
            //return false;
        //return usrtype.equalsIgnoreCase(PHONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.477 -0400", hash_original_method = "31B2EAABC2E978FD5373BC4C4C4BC54F", hash_generated_method = "1227094E9C88A68A3BC242D7DFA776A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTTL() {
        uriParms.delete(TTL);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.478 -0400", hash_original_method = "26682CE55BB39CA926871319A4C06C7F", hash_generated_method = "42A21207916C3DD5BD4C91F489951F56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMAddr() {
        uriParms.delete(MADDR);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(MADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.478 -0400", hash_original_method = "17C4DDD354C5E051E7720776FDB1621B", hash_generated_method = "3DB3C2691C9A776C9BCE08501618026C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTransport() {
        uriParms.delete(TRANSPORT);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TRANSPORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.478 -0400", hash_original_method = "3200AD1B535820580583A49AC076B7CA", hash_generated_method = "716B878794D1E1ABA2EBE30AA5F68BC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeHeader(String name) {
        dsTaint.addTaint(name);
        qheaders.delete(name);
        // ---------- Original Method ----------
        //if (qheaders != null)
            //qheaders.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.478 -0400", hash_original_method = "69EBEDDBEBD5610928D56ADB554A973E", hash_generated_method = "E903C32C0E8700933F47690CE9D407A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeHeaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.478 -0400", hash_original_method = "4C60E3731E2F1A6A961C2EAF6730B8EA", hash_generated_method = "9631DAE8EDE2B7E14FB3CA0D0675F806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUserType() {
        uriParms.delete(USER);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "A557BD8F16E39F3D746BC7787E72C291", hash_generated_method = "293540653E3C979EF343913001576563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePort() {
        authority.removePort();
        // ---------- Original Method ----------
        //authority.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "80293F715FFD7AE029130C857C03E1EB", hash_generated_method = "530ED0384F1CE09160F46AB15F133C0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMethod() {
        uriParms.delete(METHOD);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "8653C52476DAA9902FEC7B8799779AA0", hash_generated_method = "285DA5E81A8B96A54D0EE86BB991B888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUser(String uname) {
        dsTaint.addTaint(uname);
        {
            this.authority = new Authority();
        } //End block
        this.authority.setUser(uname);
        // ---------- Original Method ----------
        //if (this.authority == null) {
            //this.authority = new Authority();
        //}
        //this.authority.setUser(uname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "D79A18951B63A09462A96884D78AF17C", hash_generated_method = "4E243F3AE992330B75CE9FFE82B2DA90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeUser() {
        this.authority.removeUserInfo();
        // ---------- Original Method ----------
        //this.authority.removeUserInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "29256DC0D79112DA6F3456FF1FC7A4DA", hash_generated_method = "209A98274ACE1ECB1AA7FD8CB9DC3866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDefaultParm(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            boolean varEEDC3DA8F3C9D16787FACF86B73B8464_915838468 = (uriParms.getValue(name) == null);
            {
                NameValue nv;
                nv = new NameValue(name, value);
                uriParms.set(nv);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (uriParms.getValue(name) == null) {
            //NameValue nv = new NameValue(name, value);
            //uriParms.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.479 -0400", hash_original_method = "8155A130BB5ECD11F95AAB0DA6526B6B", hash_generated_method = "4B7350B3CEA217D1647184531F707547")
    @DSModeled(DSC.SAFE)
    public void setAuthority(Authority authority) {
        dsTaint.addTaint(authority.dsTaint);
        // ---------- Original Method ----------
        //this.authority = authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "448F841326C9DE5F0C1061A977ECCF57", hash_generated_method = "B0E0E82A1B2605777E42919D3A27EA81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(Host h) {
        dsTaint.addTaint(h.dsTaint);
        this.authority = new Authority();
        this.authority.setHost(h);
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //this.authority.setHost(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "BF30B120DCA846B2AB31EE4276940CB4", hash_generated_method = "F239594C47927AC3224E05047828AFC9")
    @DSModeled(DSC.SAFE)
    public void setUriParms(NameValueList parms) {
        dsTaint.addTaint(parms.dsTaint);
        // ---------- Original Method ----------
        //uriParms = parms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "B486DF9BA471DAAE60D8533B7C47A65D", hash_generated_method = "BFAC987182B3E83FE554F5146A67B9F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUriParm(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        NameValue nv;
        nv = new NameValue(name, value);
        uriParms.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //uriParms.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "3BCF6EC7FF3BBA5809384A38F15B6A45", hash_generated_method = "39678384AFE39EAD15AD68C89E659893")
    @DSModeled(DSC.SAFE)
    public void setQheaders(NameValueList parms) {
        dsTaint.addTaint(parms.dsTaint);
        // ---------- Original Method ----------
        //qheaders = parms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "5C181333E4641A8C388789644A11AD43", hash_generated_method = "677381DB1A48A2D8D224FFBD2B3247D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMAddr(String mAddr) {
        dsTaint.addTaint(mAddr);
        NameValue nameValue;
        nameValue = uriParms.getNameValue(MADDR);
        Host host;
        host = new Host();
        host.setAddress(mAddr);
        nameValue.setValueAsObject(host);
        {
            nameValue = new NameValue(MADDR, host);
            uriParms.set(nameValue);
        } //End block
        // ---------- Original Method ----------
        //NameValue nameValue = uriParms.getNameValue(MADDR);
        //Host host = new Host();
        //host.setAddress(mAddr);
        //if (nameValue != null)
            //nameValue.setValueAsObject(host);
        //else {
            //nameValue = new NameValue(MADDR, host);
            //uriParms.set(nameValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.480 -0400", hash_original_method = "FBDBB9DDA2030458399AB3B5F3F4F0C6", hash_generated_method = "C31086744B362B99B96D8B79578570A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserParam(String usertype) {
        dsTaint.addTaint(usertype);
        uriParms.set(USER, usertype);
        // ---------- Original Method ----------
        //uriParms.set(USER, usertype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.481 -0400", hash_original_method = "4C629B888B40F45F11F6D780770DFFA5", hash_generated_method = "1DA01AC97ED6670BF134CFA432A85AFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethod(String method) {
        dsTaint.addTaint(method);
        uriParms.set(METHOD, method);
        // ---------- Original Method ----------
        //uriParms.set(METHOD, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.481 -0400", hash_original_method = "E57262682E1156419367692D3CFC45F4", hash_generated_method = "2E0E96E637C910E0782CF3D51009E648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsdnSubAddress(String isdnSubAddress) {
        dsTaint.addTaint(isdnSubAddress);
        telephoneSubscriber = new TelephoneNumber();
        telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null)
            //telephoneSubscriber = new TelephoneNumber();
        //telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.481 -0400", hash_original_method = "988EFE784E2C119D10B2A809CB388B9F", hash_generated_method = "1E5C5E6947552CC526E5C10EBA34D865")
    @DSModeled(DSC.SAFE)
    public void setTelephoneSubscriber(TelephoneNumber tel) {
        dsTaint.addTaint(tel.dsTaint);
        // ---------- Original Method ----------
        //telephoneSubscriber = tel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.481 -0400", hash_original_method = "92A3A80BC1BE07F5BFACEB6CB4FB4561", hash_generated_method = "E6915C67882B1590247E324C62826898")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPort(int p) {
        dsTaint.addTaint(p);
        authority = new Authority();
        authority.setPort(p);
        // ---------- Original Method ----------
        //if (authority == null)
            //authority = new Authority();
        //authority.setPort(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.481 -0400", hash_original_method = "6341E21CDA970E0B49B9800DCF1B5945", hash_generated_method = "66C3BA554E32F0DB4FE62A4D04AF973B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParameter(String name) {
        dsTaint.addTaint(name);
        boolean varB53C0EC17E72D2114C17362E1819E2C4_80276415 = (uriParms.getValue(name) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return uriParms.getValue(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.482 -0400", hash_original_method = "93D043490BF44801AA76F19310D9D034", hash_generated_method = "43338B3A46EBF2CD2677697B4C8F1AC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQHeader(NameValue nameValue) {
        dsTaint.addTaint(nameValue.dsTaint);
        this.qheaders.set(nameValue);
        // ---------- Original Method ----------
        //this.qheaders.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.482 -0400", hash_original_method = "CF8B8270AAB7EE0DBD09C8A6E6FE77D2", hash_generated_method = "BCA90F3C02BC0F9E5D3B12595E1D6293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUriParameter(NameValue nameValue) {
        dsTaint.addTaint(nameValue.dsTaint);
        this.uriParms.set(nameValue);
        // ---------- Original Method ----------
        //this.uriParms.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.482 -0400", hash_original_method = "79BAB25129164A5068BFAB9AA7EFB4C6", hash_generated_method = "8CAEE22408DD639FBC5FC508EE63D394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasTransport() {
        boolean varC32CA468A2BD885B87AC82DBE3CF5DE6_2122602176 = (hasParameter(TRANSPORT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParameter(TRANSPORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.482 -0400", hash_original_method = "80DDF5AC1394722FFD3DB956063197F8", hash_generated_method = "4045911A25CBD59B565FC790A62122E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String name) {
        dsTaint.addTaint(name);
        uriParms.delete(name);
        // ---------- Original Method ----------
        //uriParms.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.482 -0400", hash_original_method = "C8CB16861890EEF599D006A2C41B9058", hash_generated_method = "4CE0A16EC57B027604DF3D0A9007721F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHostPort(HostPort hostPort) {
        dsTaint.addTaint(hostPort.dsTaint);
        {
            this.authority = new Authority();
        } //End block
        authority.setHostPort(hostPort);
        // ---------- Original Method ----------
        //if (this.authority == null) {
            //this.authority = new Authority();
        //}
        //authority.setHostPort(hostPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.483 -0400", hash_original_method = "4FA40F4F8EA124691CF5F7EB5079802B", hash_generated_method = "6527ACD3136B4A088B545412E740B1F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SipUri retval;
        retval = (SipUri) super.clone();
        retval.authority = (Authority) this.authority.clone();
        retval.uriParms = (NameValueList) this.uriParms.clone();
        retval.qheaders = (NameValueList) this.qheaders.clone();
        retval.telephoneSubscriber = (TelephoneNumber) this.telephoneSubscriber.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SipUri retval = (SipUri) super.clone();
        //if (this.authority != null)
            //retval.authority = (Authority) this.authority.clone();
        //if (this.uriParms != null)
            //retval.uriParms = (NameValueList) this.uriParms.clone();
        //if (this.qheaders != null)
            //retval.qheaders = (NameValueList) this.qheaders.clone();
        //if (this.telephoneSubscriber != null)
            //retval.telephoneSubscriber = (TelephoneNumber) this.telephoneSubscriber.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.483 -0400", hash_original_method = "D620A31F761EF988C6C51AF3A40C0F6E", hash_generated_method = "3F9CDBC88C21A0520EC2BFB3E841061B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHeader(String name) {
        dsTaint.addTaint(name);
        {
            boolean varA976053CFE18017FFEA0B798B9148200_2775148 = (this.qheaders.getValue(name) != null);
            Object varEA2E2E9E99D538F4B6F4AE8F35E3B678_1393425541 = (this.qheaders.getValue(name).toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.qheaders.getValue(name) != null
            //? this.qheaders.getValue(name).toString()
            //: null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.483 -0400", hash_original_method = "4530375C3CFB28EF39A61BC561477425", hash_generated_method = "92E5981C6C12B7226D71293C49A5C4A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getHeaderNames() {
        Iterator<String> var80B4FADA54A84344739C62F74A7F349E_192958545 = (this.qheaders.getNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.qheaders.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.483 -0400", hash_original_method = "3F7D698AA93119CDF4AD07DDC087B33E", hash_generated_method = "C4E6F47DE6321C4D2B2DCCAF92F68152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLrParam() {
        boolean haslr;
        haslr = this.hasParameter(LR);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //boolean haslr = this.hasParameter(LR);
        //return haslr ? "true" : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.484 -0400", hash_original_method = "8D33CC87FEAA658432B140BA930B3AED", hash_generated_method = "6400890E1AAD6831F04096684340AF4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMAddrParam() {
        NameValue maddr;
        maddr = uriParms.getNameValue(MADDR);
        String host;
        host = (String) maddr.getValueAsObject();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //NameValue maddr = uriParms.getNameValue(MADDR);
        //if (maddr == null)
            //return null;
        //String host = (String) maddr.getValueAsObject();
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.484 -0400", hash_original_method = "B0014A6E847FE8E425D38FE4F75F3375", hash_generated_method = "29096676A2144047660A89760677E203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMethodParam() {
        String varC83A770E353D0EC72DE869688B9C70E2_226066587 = (this.getParameter(METHOD));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.484 -0400", hash_original_method = "B72E21D53820BAFF3F91285B817E8F6B", hash_generated_method = "41FF1217C73BA31831BCE47F899BA1F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        Object val;
        val = uriParms.getValue(name);
        String var95441B18ED228B9E74BF37F54C5F5827_1695518332 = (((GenericObject) val).encode());
        String var1256D27AA7319A7570F46BC6DF2B0099_126982463 = (val.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object val = uriParms.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "6E1DB232C6AA1FEC4050F87B0DECFBEC", hash_generated_method = "1594E087D3AB585A68A525767814FF18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getParameterNames() {
        Iterator<String> var9054231EBB448A02C74A7FC4114B38B5_217767937 = (this.uriParms.getNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.uriParms.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "EE7A560BCE3AD39DE27697785FE9A0B4", hash_generated_method = "BE8F7050459646529C185D74D83FAD70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTTLParam() {
        Integer ttl;
        ttl = (Integer) uriParms.getValue("ttl");
        int var0029DDF5A04E39C38FDA3213BBFAF36E_413140416 = (ttl.intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Integer ttl = (Integer) uriParms.getValue("ttl");
        //if (ttl != null)
            //return ttl.intValue();
        //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "D0FE42FB772BF560666581278B9E7996", hash_generated_method = "5CBE4A045AE2F26E784FBBBA49E49A0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTransportParam() {
        {
            String varC5DDEA1104C1175021CBF7D7B9AB08C6_358750017 = ((String) uriParms.getValue(TRANSPORT));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (uriParms != null) {
            //return (String) uriParms.getValue(TRANSPORT);
        //} else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "3B107DCD343091F4FCEB3378B44D2024", hash_generated_method = "7B3980336520A718A6EE507A45F0A285")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUser() {
        String var5962E8A64EFD7A77CBBBDAEF3D5E0680_1929672846 = (authority.getUser());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return authority.getUser();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "5246336FD52DFE5F131EDCED707C7332", hash_generated_method = "187D504915D81061B47010A4AD3F5BF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSecure() {
        boolean var680FB1BE27E0E163E02145271CF1265C_251438411 = (this.getScheme().equalsIgnoreCase(SIPS));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.getScheme().equalsIgnoreCase(SIPS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.485 -0400", hash_original_method = "56D579416E6E52BEF406E20E9865D4C4", hash_generated_method = "1EC287B5ECAA8A4CF7D918DE4BE7229F")
    @DSModeled(DSC.SAFE)
    public boolean isSipURI() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.486 -0400", hash_original_method = "DE18AAB14C75B00C0640CE3E9515471C", hash_generated_method = "6468832D93011C3521FEC178539ECEE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHeader(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = new NameValue(name, value);
        qheaders.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //qheaders.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.486 -0400", hash_original_method = "8BEE64CFFA20AF8C2536A2ECB59F51EE", hash_generated_method = "6DFA033E9B72A9B1B2A6F44CDE2D20F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(String host) throws ParseException {
        dsTaint.addTaint(host);
        Host h;
        h = new Host(host);
        this.setHost(h);
        // ---------- Original Method ----------
        //Host h = new Host(host);
        //this.setHost(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.486 -0400", hash_original_method = "DD9F3D6DD0A955FE88B26C596147A545", hash_generated_method = "FFD1D37F482D6599B51331C19EAD3783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLrParam() {
        this.uriParms.set("lr",null);
        // ---------- Original Method ----------
        //this.uriParms.set("lr",null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.486 -0400", hash_original_method = "E9B55C57ECC7FC0F2DF8B4804D377AFB", hash_generated_method = "144E72E6BA985B04E10D681483F5B4E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMAddrParam(String maddr) throws ParseException {
        dsTaint.addTaint(maddr);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad maddr");
        setParameter("maddr", maddr);
        // ---------- Original Method ----------
        //if (maddr == null)
            //throw new NullPointerException("bad maddr");
        //setParameter("maddr", maddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.487 -0400", hash_original_method = "378F5AA5131E869E77C4B19F60BAAC21", hash_generated_method = "09F46395B52DCEFFD79B6FEF51870AF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMethodParam(String method) throws ParseException {
        dsTaint.addTaint(method);
        setParameter("method", method);
        // ---------- Original Method ----------
        //setParameter("method", method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.487 -0400", hash_original_method = "B29E45FE1B913173FAF4035EBB51958B", hash_generated_method = "502FF089EA8D1C0C49106F26BC7A966D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            boolean varFD8BA5FD35E31C0558A23A7937239A52_1804098921 = (name.equalsIgnoreCase("ttl"));
            {
                try 
                {
                    Integer.parseInt(value);
                } //End block
                catch (NumberFormatException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("bad parameter " + value, 0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        uriParms.set(name,value);
        // ---------- Original Method ----------
        //if (name.equalsIgnoreCase("ttl")) {
            //try {
                //Integer.parseInt(value);
            //} catch (NumberFormatException ex) {
                //throw new ParseException("bad parameter " + value, 0);
            //}
        //}
        //uriParms.set(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.487 -0400", hash_original_method = "93EA8C8ECDAC523AC50E68B355F469C8", hash_generated_method = "FDCBDB3F1A8BAF623A24909A418EEFE5")
    @DSModeled(DSC.SAFE)
    public void setSecure(boolean secure) {
        dsTaint.addTaint(secure);
        this.scheme = SIPS;
        this.scheme = SIP;
        // ---------- Original Method ----------
        //if (secure)
            //this.scheme = SIPS;
        //else
            //this.scheme = SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.487 -0400", hash_original_method = "8785DA0B69A8C30F98EFE6C5EB1879AC", hash_generated_method = "78A089E17F8015656D4968B367E3B554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTTLParam(int ttl) {
        dsTaint.addTaint(ttl);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad ttl value");
        {
            NameValue nv;
            nv = new NameValue("ttl", Integer.valueOf(ttl));
            uriParms.set(nv);
        } //End block
        // ---------- Original Method ----------
        //if (ttl <= 0)
            //throw new IllegalArgumentException("Bad ttl value");
        //if (uriParms != null) {
            //NameValue nv = new NameValue("ttl", Integer.valueOf(ttl));
            //uriParms.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.487 -0400", hash_original_method = "D4B3823C982965112DA168F305C25048", hash_generated_method = "3A2DD9525B1341FAC4F4E9F09D54EDDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransportParam(String transport) throws ParseException {
        dsTaint.addTaint(transport);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        {
            boolean varD52FB728B1D6488FBD6394869977AA12_1290418968 = (transport.compareToIgnoreCase("UDP") == 0
            || transport.compareToIgnoreCase("TLS") == 0
            || transport.compareToIgnoreCase("TCP") == 0
            || transport.compareToIgnoreCase("SCTP") == 0);
            {
                NameValue nv;
                nv = new NameValue(TRANSPORT, transport.toLowerCase());
                uriParms.set(nv);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad transport " + transport, 0);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException("null arg");
        //if (transport.compareToIgnoreCase("UDP") == 0
            //|| transport.compareToIgnoreCase("TLS") == 0
            //|| transport.compareToIgnoreCase("TCP") == 0
            //|| transport.compareToIgnoreCase("SCTP") == 0) {
            //NameValue nv = new NameValue(TRANSPORT, transport.toLowerCase());
            //uriParms.set(nv);
        //} else
            //throw new ParseException("bad transport " + transport, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.488 -0400", hash_original_method = "1E6ECA3F7C52B01B50446520797B0E33", hash_generated_method = "39FE20DA24CC3A25A77E3087003B915B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserParam() {
        String varBE15B96B59FF88E1D98B6AAE93006A18_1571579981 = (getParameter("user"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter("user");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.488 -0400", hash_original_method = "23F3E2D78AEB517CE17DC4369118F50D", hash_generated_method = "E0CD69F60269616872E6D868E8141D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasLrParam() {
        boolean varFC6FB6D38ED03C2B27CF94B4AD499E80_1814976799 = (uriParms.getNameValue("lr") != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return uriParms.getNameValue("lr") != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.488 -0400", hash_original_method = "BF370972F662FF42728C27309BA84910", hash_generated_method = "6C7BCEAC69A32C20A5BD81B7779D96ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasGrParam() {
        boolean varFA89BEA4AFAFBB589EEA15E98039438D_1994125109 = (uriParms.getNameValue(GRUU) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return uriParms.getNameValue(GRUU) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.488 -0400", hash_original_method = "80955EE8A827F28D322398606EB833AF", hash_generated_method = "FB0724276A56E6AD926BE6C88DB48B00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGrParam(String value) {
        dsTaint.addTaint(value);
        this.uriParms.set(GRUU, value);
        // ---------- Original Method ----------
        //this.uriParms.set(GRUU, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.488 -0400", hash_original_method = "215DF01DBB1883D8F30CF584508D27CC", hash_generated_method = "2631EF3FDE411109D0416D3688E5BB29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getGrParam() {
        String var078443C45ED664C1AD56B05A930F1F48_1964451347 = ((String) this.uriParms.getValue(GRUU));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) this.uriParms.getValue(GRUU);
    }

    
    private static final long serialVersionUID = 7749781076218987044L;
}

