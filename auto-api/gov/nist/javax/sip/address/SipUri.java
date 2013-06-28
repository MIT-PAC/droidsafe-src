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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AD4D5BC0220CFD82443737C52505C486")

    protected Authority authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_field = "3FAF7D735501DAD3EFB6210602CCAD3E", hash_generated_field = "F6A59563ED5E856D9CD91C684F4FC813")

    protected NameValueList uriParms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_field = "1B6D732887C57CD3A7AFDF7A80A8AAE5", hash_generated_field = "45901905C5831FBB34F7DCD157856090")

    protected NameValueList qheaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_field = "D8C88703367A716690FE5F351532E182", hash_generated_field = "486D6B81CF5C668276377979467C5D05")

    protected TelephoneNumber telephoneSubscriber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_method = "4581AC1C0AE43A94306BF80DA76A0B36", hash_generated_method = "C518F6BE6D677C49B5D373A0ADD9B73A")
    public  SipUri() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.440 -0400", hash_original_method = "40F35B976B5ABD0FB641A4F1A08DC6DF", hash_generated_method = "91FFA3F741E663115BDA241F52D7A966")
    public void setScheme(String scheme) {
        {
            boolean var97AD44F10E926B94254CAE8B4A864B93_281314641 = (scheme.compareToIgnoreCase(SIP) != 0
            && scheme.compareToIgnoreCase(SIPS) != 0);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bad scheme " + scheme);
        } //End collapsed parenthetic
        this.scheme = scheme.toLowerCase();
        addTaint(scheme.getTaint());
        // ---------- Original Method ----------
        //if (scheme.compareToIgnoreCase(SIP) != 0
            //&& scheme.compareToIgnoreCase(SIPS) != 0)
            //throw new IllegalArgumentException("bad scheme " + scheme);
        //this.scheme = scheme.toLowerCase();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.441 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "846338EFD1F897F35E639E276A401888")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_100784101 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_100784101 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_100784101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100784101;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.441 -0400", hash_original_method = "B97988479159B246DBD5976667FAE614", hash_generated_method = "7A913D6E89C72AB83AFFF954FFBF7CD6")
    public void clearUriParms() {
        uriParms = new NameValueList();
        // ---------- Original Method ----------
        //uriParms = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.442 -0400", hash_original_method = "FDFE9380996AC8B536679A9DC84D64BE", hash_generated_method = "BEE81F9F009BF7D2E345699D37674D48")
    public void clearPassword() {
        {
            UserInfo userInfo = authority.getUserInfo();
            userInfo.clearPassword();
        } //End block
        // ---------- Original Method ----------
        //if (this.authority != null) {
            //UserInfo userInfo = authority.getUserInfo();
            //if (userInfo != null)
                //userInfo.clearPassword();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.442 -0400", hash_original_method = "92C8D5BE70E6877E725894DF3752DAAD", hash_generated_method = "AD1777046D6452C253DB4280634841AA")
    public Authority getAuthority() {
        Authority varB4EAC82CA7396A68D541C85D26508E83_579929749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_579929749 = this.authority;
        varB4EAC82CA7396A68D541C85D26508E83_579929749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579929749;
        // ---------- Original Method ----------
        //return this.authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.442 -0400", hash_original_method = "44A5F82F772B2346E44573FA04C5E6BF", hash_generated_method = "546FDDE1F5876502A34904E6040940A2")
    public void clearQheaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.444 -0400", hash_original_method = "9EAD5694A977A9D6081FC9F5B163E148", hash_generated_method = "E7C7B250D49FA8E8757A405C9B200B3F")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {
        {
            boolean var808EFC10B8F4455D1156A05691BEC636_52653428 = (that==this);
        } //End collapsed parenthetic
        {
            final SipURI a = this;
            final SipURI b = (SipURI) that;
            {
                boolean var3DAD500499FBDCF2474A0DD7D6A43FB0_1290474973 = (a.isSecure() ^ b.isSecure());
            } //End collapsed parenthetic
            {
                boolean var704E29857B9D24BE4B1B80701D880A80_685962327 = (a.getUser()==null ^ b.getUser()==null);
            } //End collapsed parenthetic
            {
                boolean varC58E713B7450E3011557684C96505C39_432428792 = (a.getUserPassword()==null ^ b.getUserPassword()==null);
            } //End collapsed parenthetic
            {
                boolean varD6ACDEEED2B014C2CE240A5BB9A6408C_1557864856 = (a.getUser()!=null && !RFC2396UrlDecoder.decode(a.getUser()).equals(RFC2396UrlDecoder.decode(b.getUser())));
            } //End collapsed parenthetic
            {
                boolean var729E26EDB58F2750945DC0B0CD69C74F_297278374 = (a.getUserPassword()!=null && !RFC2396UrlDecoder.decode(a.getUserPassword()).equals(RFC2396UrlDecoder.decode(b.getUserPassword())));
            } //End collapsed parenthetic
            {
                boolean varB2AE7DAFE4D623C36619676A1F26C655_1651544575 = (a.getHost() == null ^ b.getHost() == null);
            } //End collapsed parenthetic
            {
                boolean var548B93FB59C3C5854AF23CB4EDE37087_1853560068 = (a.getHost() != null && !a.getHost().equalsIgnoreCase(b.getHost()));
            } //End collapsed parenthetic
            {
                boolean varC7F2A707C749FADCBCA7E25C56790F40_1683187983 = (a.getPort() != b.getPort());
            } //End collapsed parenthetic
            {
                Iterator i = a.getParameterNames();
                boolean varD8B5E52A597500CBD863E52A46B42708_2119156402 = (i.hasNext());
                {
                    String pname = (String) i.next();
                    String p1 = a.getParameter(pname);
                    String p2 = b.getParameter(pname);
                    {
                        boolean var2A429907F6E3B98686BBD2EA978AFFE6_502973507 = (p1!=null && p2!=null && !RFC2396UrlDecoder.decode(p1).equalsIgnoreCase(RFC2396UrlDecoder.decode(p2)));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var427C16ABDA4EB8D3C9C9EF9935340458_620500919 = (a.getTransportParam()==null ^ b.getTransportParam()==null);
            } //End collapsed parenthetic
            {
                boolean var5E48CD8F2CB1AFB3852FB9CE3A7FEF19_509491199 = (a.getUserParam()==null ^ b.getUserParam()==null);
            } //End collapsed parenthetic
            {
                boolean var1CAD38A75018FA486465431324399EDE_326051183 = (a.getTTLParam()==-1 ^ b.getTTLParam()==-1);
            } //End collapsed parenthetic
            {
                boolean var35B18F7355EA9EA4D1DC7ED18518C2A1_609230078 = (a.getMethodParam()==null ^ b.getMethodParam()==null);
            } //End collapsed parenthetic
            {
                boolean varB4CA52932B1771A9881F31D72005C84C_1192914733 = (a.getMAddrParam()==null ^ b.getMAddrParam()==null);
            } //End collapsed parenthetic
            {
                boolean var45DA844974FC5013184143BF0E5C0B99_1594763129 = (a.getHeaderNames().hasNext() && !b.getHeaderNames().hasNext());
            } //End collapsed parenthetic
            {
                boolean varBFB76F3DFF7FD2223F8A22D958B17BF9_1664334149 = (!a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext());
            } //End collapsed parenthetic
            {
                boolean var73D441E8E3A4F6FA3DA2FD2716437D95_205680746 = (a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext());
                {
                    HeaderFactory headerFactory = null;
                    try 
                    {
                        headerFactory = SipFactory.getInstance().createHeaderFactory();
                    } //End block
                    catch (PeerUnavailableException e)
                    {
                        Debug.logError("Cannot get the header factory to parse the header of the sip uris to compare", e);
                    } //End block
                    {
                        Iterator i = a.getHeaderNames();
                        boolean var5A904445088E8F340E730368D637913B_631689711 = (i.hasNext());
                        {
                            String hname = (String) i.next();
                            String h1 = a.getHeader(hname);
                            String h2 = b.getHeader(hname);
                            try 
                            {
                                Header header1 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h1));
                                Header header2 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h2));
                                {
                                    boolean varD5C1E0445459D68D145CA90087C85616_1473612610 = (!header1.equals(header2));
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
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582037000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_582037000;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.445 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "6FD0756B4676656A7835E6AA4EB9DC10")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1202421628 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202421628 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1202421628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202421628;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.446 -0400", hash_original_method = "C22033B09BF680257BC2551F51CC4682", hash_generated_method = "FC93B28E68B4608921E8E967E14630D1")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_174378161 = null; //Variable for return #1
        buffer.append(scheme).append(COLON);
        authority.encode(buffer);
        {
            boolean varF56D09C2F80594AA787675634C167937_1963153848 = (!uriParms.isEmpty());
            {
                buffer.append(SEMICOLON);
                uriParms.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var456BAFF324BFA7394EA2AF8E00095090_1712744362 = (!qheaders.isEmpty());
            {
                buffer.append(QUESTION);
                qheaders.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_174378161 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_174378161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_174378161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.446 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "C82936CD347E32AF52590FCA1777A7F3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1225217639 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1225217639 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1225217639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1225217639;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.447 -0400", hash_original_method = "000995A40BE4F62572B4CEC75CD27D06", hash_generated_method = "D0E9D4AB9899C38D1C170B6835CE2F95")
    public String getUserAtHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_492747312 = null; //Variable for return #1
        String user = "";
        {
            boolean var2E19B47438D44DE246325E874206758A_566043195 = (authority.getUserInfo() != null);
            user = authority.getUserInfo().getUser();
        } //End collapsed parenthetic
        String host = authority.getHost().encode();
        StringBuffer s = null;
        {
            boolean varD68E445BC0FFF6B8A1FF5F6BFB1F4754_1848613616 = (user.equals(""));
            {
                s = new StringBuffer();
            } //End block
            {
                s = new StringBuffer(user).append(AT);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_492747312 = s.append(host).toString();
        varB4EAC82CA7396A68D541C85D26508E83_492747312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492747312;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.447 -0400", hash_original_method = "6F248E410BDCE844EE042BFFA98482C9", hash_generated_method = "7EC198F641F786F7B01384B5FF1DAE7C")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_245114094 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1880616211 = null; //Variable for return #2
        String user = "";
        {
            boolean var2E19B47438D44DE246325E874206758A_496746445 = (authority.getUserInfo() != null);
            user = authority.getUserInfo().getUser();
        } //End collapsed parenthetic
        String host = authority.getHost().encode();
        int port = authority.getPort();
        StringBuffer s = null;
        {
            boolean varD68E445BC0FFF6B8A1FF5F6BFB1F4754_144512878 = (user.equals(""));
            {
                s = new StringBuffer();
            } //End block
            {
                s = new StringBuffer(user).append(AT);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_245114094 = s.append(host).append(COLON).append(port).toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1880616211 = s.append(host).toString();
        String varA7E53CE21691AB073D9660D615818899_823738721; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_823738721 = varB4EAC82CA7396A68D541C85D26508E83_245114094;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_823738721 = varB4EAC82CA7396A68D541C85D26508E83_1880616211;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_823738721.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_823738721;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.448 -0400", hash_original_method = "208FE04DEC7ECCEEFC5A47E5D08BA557", hash_generated_method = "0E4352E58B22D13979EDDF3128C30B60")
    public Object getParm(String parmname) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1193111341 = null; //Variable for return #1
        Object obj = uriParms.getValue(parmname);
        varB4EAC82CA7396A68D541C85D26508E83_1193111341 = obj;
        addTaint(parmname.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1193111341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1193111341;
        // ---------- Original Method ----------
        //Object obj = uriParms.getValue(parmname);
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.449 -0400", hash_original_method = "DA8D1E67518AA478AB8C96314B0F321C", hash_generated_method = "DB2615D3E5E0215BB3131F76C3AB4316")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_221782637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_221782637 = (String) getParm(METHOD);
        varB4EAC82CA7396A68D541C85D26508E83_221782637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_221782637;
        // ---------- Original Method ----------
        //return (String) getParm(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.449 -0400", hash_original_method = "5EDAD210CE239248A46B40B8A7E4E067", hash_generated_method = "2F638F6EC433D6E535C94524173CB46C")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1076337941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1076337941 = uriParms;
        varB4EAC82CA7396A68D541C85D26508E83_1076337941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076337941;
        // ---------- Original Method ----------
        //return uriParms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.449 -0400", hash_original_method = "F23607C60777A1A36911A6FE06B11E71", hash_generated_method = "4FF98F06B904C85601629D95CCCE2CC2")
    public void removeParameters() {
        this.uriParms = new NameValueList();
        // ---------- Original Method ----------
        //this.uriParms = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.449 -0400", hash_original_method = "69A77D050D6DE602ACFB758F18CE1C2E", hash_generated_method = "465FEA75AF69A33407FC4ED3CF92FAEE")
    public NameValueList getQheaders() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_612123722 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_612123722 = qheaders;
        varB4EAC82CA7396A68D541C85D26508E83_612123722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_612123722;
        // ---------- Original Method ----------
        //return qheaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.450 -0400", hash_original_method = "C4F4158359E9C3CE01C658AE1B903AEE", hash_generated_method = "30B81733855DCD5C5AF677DBB1F05986")
    public String getUserType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1080741828 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1080741828 = (String) uriParms.getValue(USER);
        varB4EAC82CA7396A68D541C85D26508E83_1080741828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1080741828;
        // ---------- Original Method ----------
        //return (String) uriParms.getValue(USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.450 -0400", hash_original_method = "F7BA3F65C36127DC85DBDC366FBE67EC", hash_generated_method = "6E1A6843195356DB73B8AFDE48B80EFE")
    public String getUserPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_1892336562 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_143417629 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1892336562 = null;
        varB4EAC82CA7396A68D541C85D26508E83_143417629 = authority.getPassword();
        String varA7E53CE21691AB073D9660D615818899_1042779983; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1042779983 = varB4EAC82CA7396A68D541C85D26508E83_1892336562;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1042779983 = varB4EAC82CA7396A68D541C85D26508E83_143417629;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1042779983.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1042779983;
        // ---------- Original Method ----------
        //if (authority == null)
            //return null;
        //return authority.getPassword();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.451 -0400", hash_original_method = "EB4E37E6319716C20DB55C1D8565711A", hash_generated_method = "F5E931F9FD4E29B837D54B7AA0A0DA04")
    public void setUserPassword(String password) {
        this.authority = new Authority();
        authority.setPassword(password);
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //authority.setPassword(password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.451 -0400", hash_original_method = "FBB7E1AC9741B23BB5B3EA84041A8793", hash_generated_method = "B6B5E93003CB81F9518D1469349C0EAF")
    public TelephoneNumber getTelephoneSubscriber() {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1432245134 = null; //Variable for return #1
        {
            telephoneSubscriber = new TelephoneNumber();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1432245134 = telephoneSubscriber;
        varB4EAC82CA7396A68D541C85D26508E83_1432245134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432245134;
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null) {
            //telephoneSubscriber = new TelephoneNumber();
        //}
        //return telephoneSubscriber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.451 -0400", hash_original_method = "B2DE769DC5E0088684B143D456F129CF", hash_generated_method = "89C38D0ED9E6F4A2FBB3D68062038A70")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1205696905 = null; //Variable for return #1
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1205797569 = null; //Variable for return #2
        {
            boolean varA35D3DDB12550A696B0F3B18AECFDF7F_881361796 = (authority == null || authority.getHost() == null);
            varB4EAC82CA7396A68D541C85D26508E83_1205696905 = null;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1205797569 = authority.getHostPort();
            } //End block
        } //End collapsed parenthetic
        HostPort varA7E53CE21691AB073D9660D615818899_1352155401; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1352155401 = varB4EAC82CA7396A68D541C85D26508E83_1205696905;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1352155401 = varB4EAC82CA7396A68D541C85D26508E83_1205797569;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1352155401.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1352155401;
        // ---------- Original Method ----------
        //if (authority == null || authority.getHost() == null )
            //return null;
        //else {
            //return authority.getHostPort();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.452 -0400", hash_original_method = "7F780725D3A26A9FAAA917ED82465734", hash_generated_method = "8AA29B885B699C611EF90FB985B14A92")
    public int getPort() {
        HostPort hp = this.getHostPort();
        int var367395E2945B2A27F48B64C482E41962_911928604 = (hp.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143771069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143771069;
        // ---------- Original Method ----------
        //HostPort hp = this.getHostPort();
        //if (hp == null)
            //return -1;
        //return hp.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.452 -0400", hash_original_method = "40B106F658B1B0B8AE55FF744395EB77", hash_generated_method = "ACD8B5DF875DF2CC5DAEB68AF3CD4027")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_152423791 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_377811726 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1440757482 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_152423791 = null;
        {
            boolean varE82FD8B166FEACA8671C68F1E3F7834A_750201719 = (authority.getHost() == null);
            varB4EAC82CA7396A68D541C85D26508E83_377811726 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1440757482 = authority.getHost().encode();
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_366929118; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_366929118 = varB4EAC82CA7396A68D541C85D26508E83_152423791;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_366929118 = varB4EAC82CA7396A68D541C85D26508E83_377811726;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_366929118 = varB4EAC82CA7396A68D541C85D26508E83_1440757482;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_366929118.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_366929118;
        // ---------- Original Method ----------
        //if ( authority == null) return null;
        //else if (authority.getHost() == null ) return null;
        //else return authority.getHost().encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.453 -0400", hash_original_method = "56CDDCF4149582CE88DAE7137BB51FB6", hash_generated_method = "A68ABC743A443B31859BFC1507EC8683")
    public boolean isUserTelephoneSubscriber() {
        String usrtype = (String) uriParms.getValue(USER);
        boolean var18C173688EA6508503FB97650EB726B4_482917514 = (usrtype.equalsIgnoreCase(PHONE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582528206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582528206;
        // ---------- Original Method ----------
        //String usrtype = (String) uriParms.getValue(USER);
        //if (usrtype == null)
            //return false;
        //return usrtype.equalsIgnoreCase(PHONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.453 -0400", hash_original_method = "31B2EAABC2E978FD5373BC4C4C4BC54F", hash_generated_method = "1227094E9C88A68A3BC242D7DFA776A0")
    public void removeTTL() {
        uriParms.delete(TTL);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.453 -0400", hash_original_method = "26682CE55BB39CA926871319A4C06C7F", hash_generated_method = "42A21207916C3DD5BD4C91F489951F56")
    public void removeMAddr() {
        uriParms.delete(MADDR);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(MADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.453 -0400", hash_original_method = "17C4DDD354C5E051E7720776FDB1621B", hash_generated_method = "3DB3C2691C9A776C9BCE08501618026C")
    public void removeTransport() {
        uriParms.delete(TRANSPORT);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TRANSPORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.454 -0400", hash_original_method = "3200AD1B535820580583A49AC076B7CA", hash_generated_method = "B486C697E1F7AB0E8753152ADA454D0A")
    public void removeHeader(String name) {
        qheaders.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (qheaders != null)
            //qheaders.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.454 -0400", hash_original_method = "69EBEDDBEBD5610928D56ADB554A973E", hash_generated_method = "E903C32C0E8700933F47690CE9D407A7")
    public void removeHeaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.455 -0400", hash_original_method = "4C60E3731E2F1A6A961C2EAF6730B8EA", hash_generated_method = "9631DAE8EDE2B7E14FB3CA0D0675F806")
    public void removeUserType() {
        uriParms.delete(USER);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(USER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.455 -0400", hash_original_method = "A557BD8F16E39F3D746BC7787E72C291", hash_generated_method = "293540653E3C979EF343913001576563")
    public void removePort() {
        authority.removePort();
        // ---------- Original Method ----------
        //authority.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.455 -0400", hash_original_method = "80293F715FFD7AE029130C857C03E1EB", hash_generated_method = "530ED0384F1CE09160F46AB15F133C0D")
    public void removeMethod() {
        uriParms.delete(METHOD);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.456 -0400", hash_original_method = "8653C52476DAA9902FEC7B8799779AA0", hash_generated_method = "DCB78FFFD93A3E8B29CCF7C5C550934F")
    public void setUser(String uname) {
        {
            this.authority = new Authority();
        } //End block
        this.authority.setUser(uname);
        addTaint(uname.getTaint());
        // ---------- Original Method ----------
        //if (this.authority == null) {
            //this.authority = new Authority();
        //}
        //this.authority.setUser(uname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.456 -0400", hash_original_method = "D79A18951B63A09462A96884D78AF17C", hash_generated_method = "4E243F3AE992330B75CE9FFE82B2DA90")
    public void removeUser() {
        this.authority.removeUserInfo();
        // ---------- Original Method ----------
        //this.authority.removeUserInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.456 -0400", hash_original_method = "29256DC0D79112DA6F3456FF1FC7A4DA", hash_generated_method = "E49BEB6B705AD38B59633251D0FA5ECE")
    public void setDefaultParm(String name, Object value) {
        {
            boolean varEEDC3DA8F3C9D16787FACF86B73B8464_1720120402 = (uriParms.getValue(name) == null);
            {
                NameValue nv = new NameValue(name, value);
                uriParms.set(nv);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (uriParms.getValue(name) == null) {
            //NameValue nv = new NameValue(name, value);
            //uriParms.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.457 -0400", hash_original_method = "8155A130BB5ECD11F95AAB0DA6526B6B", hash_generated_method = "17C5E94A9E6A70133A97A70EC4723660")
    public void setAuthority(Authority authority) {
        this.authority = authority;
        // ---------- Original Method ----------
        //this.authority = authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.457 -0400", hash_original_method = "448F841326C9DE5F0C1061A977ECCF57", hash_generated_method = "D46A75EE3955F4C1627CEAEAD415D2A5")
    public void setHost(Host h) {
        this.authority = new Authority();
        this.authority.setHost(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //this.authority.setHost(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.457 -0400", hash_original_method = "BF30B120DCA846B2AB31EE4276940CB4", hash_generated_method = "C12913C3D366050264426BFF362BC735")
    public void setUriParms(NameValueList parms) {
        uriParms = parms;
        // ---------- Original Method ----------
        //uriParms = parms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.458 -0400", hash_original_method = "B486DF9BA471DAAE60D8533B7C47A65D", hash_generated_method = "E8C20C9AE77FA0672FD51ED4EA8DBC2F")
    public void setUriParm(String name, Object value) {
        NameValue nv = new NameValue(name, value);
        uriParms.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //uriParms.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.458 -0400", hash_original_method = "3BCF6EC7FF3BBA5809384A38F15B6A45", hash_generated_method = "2E952D0669523402C7D8C7BA5EACD080")
    public void setQheaders(NameValueList parms) {
        qheaders = parms;
        // ---------- Original Method ----------
        //qheaders = parms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.458 -0400", hash_original_method = "5C181333E4641A8C388789644A11AD43", hash_generated_method = "59AA600E5CB0261C95611B7E502B8CB0")
    public void setMAddr(String mAddr) {
        NameValue nameValue = uriParms.getNameValue(MADDR);
        Host host = new Host();
        host.setAddress(mAddr);
        nameValue.setValueAsObject(host);
        {
            nameValue = new NameValue(MADDR, host);
            uriParms.set(nameValue);
        } //End block
        addTaint(mAddr.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.458 -0400", hash_original_method = "FBDBB9DDA2030458399AB3B5F3F4F0C6", hash_generated_method = "8A044051CDE50DF66DB5F4919A9ADDF7")
    public void setUserParam(String usertype) {
        uriParms.set(USER, usertype);
        addTaint(usertype.getTaint());
        // ---------- Original Method ----------
        //uriParms.set(USER, usertype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.459 -0400", hash_original_method = "4C629B888B40F45F11F6D780770DFFA5", hash_generated_method = "E2EBAC1E3401C791ECBA5CEE723607E2")
    public void setMethod(String method) {
        uriParms.set(METHOD, method);
        addTaint(method.getTaint());
        // ---------- Original Method ----------
        //uriParms.set(METHOD, method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.459 -0400", hash_original_method = "E57262682E1156419367692D3CFC45F4", hash_generated_method = "DB9468C4181DF24CB8F081CB6186D3E0")
    public void setIsdnSubAddress(String isdnSubAddress) {
        telephoneSubscriber = new TelephoneNumber();
        telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
        addTaint(isdnSubAddress.getTaint());
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null)
            //telephoneSubscriber = new TelephoneNumber();
        //telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.459 -0400", hash_original_method = "988EFE784E2C119D10B2A809CB388B9F", hash_generated_method = "BABA85DAD3AFF0C47B1D5E16AE852918")
    public void setTelephoneSubscriber(TelephoneNumber tel) {
        telephoneSubscriber = tel;
        // ---------- Original Method ----------
        //telephoneSubscriber = tel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.459 -0400", hash_original_method = "92A3A80BC1BE07F5BFACEB6CB4FB4561", hash_generated_method = "3793BCB7810C3202E6B13D91190A0A2B")
    public void setPort(int p) {
        authority = new Authority();
        authority.setPort(p);
        addTaint(p);
        // ---------- Original Method ----------
        //if (authority == null)
            //authority = new Authority();
        //authority.setPort(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.460 -0400", hash_original_method = "6341E21CDA970E0B49B9800DCF1B5945", hash_generated_method = "A26DA2D97C1FB2B19FE192FA7E4BBE1C")
    public boolean hasParameter(String name) {
        boolean varB53C0EC17E72D2114C17362E1819E2C4_436715169 = (uriParms.getValue(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607013358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607013358;
        // ---------- Original Method ----------
        //return uriParms.getValue(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.460 -0400", hash_original_method = "93D043490BF44801AA76F19310D9D034", hash_generated_method = "BF4D0D2CB253412BAB319C980743780D")
    public void setQHeader(NameValue nameValue) {
        this.qheaders.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.qheaders.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.460 -0400", hash_original_method = "CF8B8270AAB7EE0DBD09C8A6E6FE77D2", hash_generated_method = "B8F16E478C579B57B60FBBC42CEE55B9")
    public void setUriParameter(NameValue nameValue) {
        this.uriParms.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.uriParms.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.460 -0400", hash_original_method = "79BAB25129164A5068BFAB9AA7EFB4C6", hash_generated_method = "B0E046C72D8CD53B339A0EB258B71D76")
    public boolean hasTransport() {
        boolean varC32CA468A2BD885B87AC82DBE3CF5DE6_1873177317 = (hasParameter(TRANSPORT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1783495491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1783495491;
        // ---------- Original Method ----------
        //return hasParameter(TRANSPORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.461 -0400", hash_original_method = "80DDF5AC1394722FFD3DB956063197F8", hash_generated_method = "3B89554476663CECA1D605EAC55152BF")
    public void removeParameter(String name) {
        uriParms.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //uriParms.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.461 -0400", hash_original_method = "C8CB16861890EEF599D006A2C41B9058", hash_generated_method = "CF18EFCB3C18971A4A747BF76C2D1EC2")
    public void setHostPort(HostPort hostPort) {
        {
            this.authority = new Authority();
        } //End block
        authority.setHostPort(hostPort);
        addTaint(hostPort.getTaint());
        // ---------- Original Method ----------
        //if (this.authority == null) {
            //this.authority = new Authority();
        //}
        //authority.setHostPort(hostPort);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.461 -0400", hash_original_method = "4FA40F4F8EA124691CF5F7EB5079802B", hash_generated_method = "5A0A6A30FFA0A576BCD80D05D4F474BF")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1519638591 = null; //Variable for return #1
        SipUri retval = (SipUri) super.clone();
        retval.authority = (Authority) this.authority.clone();
        retval.uriParms = (NameValueList) this.uriParms.clone();
        retval.qheaders = (NameValueList) this.qheaders.clone();
        retval.telephoneSubscriber = (TelephoneNumber) this.telephoneSubscriber.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1519638591 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1519638591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519638591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.462 -0400", hash_original_method = "D620A31F761EF988C6C51AF3A40C0F6E", hash_generated_method = "9B1E099CD3E6C452333CEB2A464F30EF")
    public String getHeader(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_321466827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_321466827 = this.qheaders.getValue(name) != null
            ? this.qheaders.getValue(name).toString()
            : null;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_321466827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_321466827;
        // ---------- Original Method ----------
        //return this.qheaders.getValue(name) != null
            //? this.qheaders.getValue(name).toString()
            //: null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.463 -0400", hash_original_method = "4530375C3CFB28EF39A61BC561477425", hash_generated_method = "E08DF4126DFE13DC10CA6C47C8183299")
    public Iterator<String> getHeaderNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1909090653 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1909090653 = this.qheaders.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_1909090653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909090653;
        // ---------- Original Method ----------
        //return this.qheaders.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.463 -0400", hash_original_method = "3F7D698AA93119CDF4AD07DDC087B33E", hash_generated_method = "55395BDFE5240E9C4B82B2387B25239E")
    public String getLrParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1012258469 = null; //Variable for return #1
        boolean haslr = this.hasParameter(LR);
        varB4EAC82CA7396A68D541C85D26508E83_1012258469 = haslr ? "true" : null;
        varB4EAC82CA7396A68D541C85D26508E83_1012258469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1012258469;
        // ---------- Original Method ----------
        //boolean haslr = this.hasParameter(LR);
        //return haslr ? "true" : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.464 -0400", hash_original_method = "8D33CC87FEAA658432B140BA930B3AED", hash_generated_method = "46652147D54757FA1A5E59E97A15F584")
    public String getMAddrParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1673296067 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_379405493 = null; //Variable for return #2
        NameValue maddr = uriParms.getNameValue(MADDR);
        varB4EAC82CA7396A68D541C85D26508E83_1673296067 = null;
        String host = (String) maddr.getValueAsObject();
        varB4EAC82CA7396A68D541C85D26508E83_379405493 = host;
        String varA7E53CE21691AB073D9660D615818899_1211806542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1211806542 = varB4EAC82CA7396A68D541C85D26508E83_1673296067;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1211806542 = varB4EAC82CA7396A68D541C85D26508E83_379405493;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1211806542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1211806542;
        // ---------- Original Method ----------
        //NameValue maddr = uriParms.getNameValue(MADDR);
        //if (maddr == null)
            //return null;
        //String host = (String) maddr.getValueAsObject();
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.464 -0400", hash_original_method = "B0014A6E847FE8E425D38FE4F75F3375", hash_generated_method = "2D3D0DF08458E0B2B9912260184D6028")
    public String getMethodParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1219073302 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1219073302 = this.getParameter(METHOD);
        varB4EAC82CA7396A68D541C85D26508E83_1219073302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219073302;
        // ---------- Original Method ----------
        //return this.getParameter(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.465 -0400", hash_original_method = "B72E21D53820BAFF3F91285B817E8F6B", hash_generated_method = "FA8D64F2F3173DE43DCB5B5B9DA257F3")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1423797483 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2047696784 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1406265462 = null; //Variable for return #3
        Object val = uriParms.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_1423797483 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2047696784 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_1406265462 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1692616273; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692616273 = varB4EAC82CA7396A68D541C85D26508E83_1423797483;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1692616273 = varB4EAC82CA7396A68D541C85D26508E83_2047696784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692616273 = varB4EAC82CA7396A68D541C85D26508E83_1406265462;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692616273.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692616273;
        // ---------- Original Method ----------
        //Object val = uriParms.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.465 -0400", hash_original_method = "6E1DB232C6AA1FEC4050F87B0DECFBEC", hash_generated_method = "EA00A2AFE1B14CFE7C889063034B2B25")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1602599543 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1602599543 = this.uriParms.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_1602599543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1602599543;
        // ---------- Original Method ----------
        //return this.uriParms.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.465 -0400", hash_original_method = "EE7A560BCE3AD39DE27697785FE9A0B4", hash_generated_method = "9F812F0D6B9C18F0C735257AE7D1F7D4")
    public int getTTLParam() {
        Integer ttl = (Integer) uriParms.getValue("ttl");
        int var0029DDF5A04E39C38FDA3213BBFAF36E_1922731728 = (ttl.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188299036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188299036;
        // ---------- Original Method ----------
        //Integer ttl = (Integer) uriParms.getValue("ttl");
        //if (ttl != null)
            //return ttl.intValue();
        //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.466 -0400", hash_original_method = "D0FE42FB772BF560666581278B9E7996", hash_generated_method = "B63B5C0E542F0D99D1F17570A497A5E7")
    public String getTransportParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_961130329 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1345590292 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_961130329 = (String) uriParms.getValue(TRANSPORT);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1345590292 = null;
        String varA7E53CE21691AB073D9660D615818899_1390628672; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1390628672 = varB4EAC82CA7396A68D541C85D26508E83_961130329;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1390628672 = varB4EAC82CA7396A68D541C85D26508E83_1345590292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1390628672.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1390628672;
        // ---------- Original Method ----------
        //if (uriParms != null) {
            //return (String) uriParms.getValue(TRANSPORT);
        //} else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.466 -0400", hash_original_method = "3B107DCD343091F4FCEB3378B44D2024", hash_generated_method = "35D5EA249AF6195CB94FDED5F9F9B0ED")
    public String getUser() {
        String varB4EAC82CA7396A68D541C85D26508E83_730632941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_730632941 = authority.getUser();
        varB4EAC82CA7396A68D541C85D26508E83_730632941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730632941;
        // ---------- Original Method ----------
        //return authority.getUser();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.467 -0400", hash_original_method = "5246336FD52DFE5F131EDCED707C7332", hash_generated_method = "A9CE29A6368317C47BFB77F86DCDE87A")
    public boolean isSecure() {
        boolean var680FB1BE27E0E163E02145271CF1265C_345637676 = (this.getScheme().equalsIgnoreCase(SIPS));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_998819409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_998819409;
        // ---------- Original Method ----------
        //return this.getScheme().equalsIgnoreCase(SIPS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.467 -0400", hash_original_method = "56D579416E6E52BEF406E20E9865D4C4", hash_generated_method = "D26CC0EDAFE95046F9146F606202CDEB")
    public boolean isSipURI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274772323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274772323;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.468 -0400", hash_original_method = "DE18AAB14C75B00C0640CE3E9515471C", hash_generated_method = "3F9CCC0DBA0B0D0CA6C0790095709D8F")
    public void setHeader(String name, String value) {
        NameValue nv = new NameValue(name, value);
        qheaders.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //qheaders.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.468 -0400", hash_original_method = "8BEE64CFFA20AF8C2536A2ECB59F51EE", hash_generated_method = "C467BD37FE772727E6E6AF916D7A3749")
    public void setHost(String host) throws ParseException {
        Host h = new Host(host);
        this.setHost(h);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
        //Host h = new Host(host);
        //this.setHost(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.469 -0400", hash_original_method = "DD9F3D6DD0A955FE88B26C596147A545", hash_generated_method = "FFD1D37F482D6599B51331C19EAD3783")
    public void setLrParam() {
        this.uriParms.set("lr",null);
        // ---------- Original Method ----------
        //this.uriParms.set("lr",null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.469 -0400", hash_original_method = "E9B55C57ECC7FC0F2DF8B4804D377AFB", hash_generated_method = "569B601566D9B38CDC6FB956D8DF0BE2")
    public void setMAddrParam(String maddr) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("bad maddr");
        setParameter("maddr", maddr);
        addTaint(maddr.getTaint());
        // ---------- Original Method ----------
        //if (maddr == null)
            //throw new NullPointerException("bad maddr");
        //setParameter("maddr", maddr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.471 -0400", hash_original_method = "378F5AA5131E869E77C4B19F60BAAC21", hash_generated_method = "5B68A84013478C390B9A397B6961FE4E")
    public void setMethodParam(String method) throws ParseException {
        setParameter("method", method);
        addTaint(method.getTaint());
        // ---------- Original Method ----------
        //setParameter("method", method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.473 -0400", hash_original_method = "B29E45FE1B913173FAF4035EBB51958B", hash_generated_method = "7205F39C8A0E50F76E5E9A93CB9A6EED")
    public void setParameter(String name, String value) throws ParseException {
        {
            boolean varFD8BA5FD35E31C0558A23A7937239A52_631223062 = (name.equalsIgnoreCase("ttl"));
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
        addTaint(name.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.474 -0400", hash_original_method = "93EA8C8ECDAC523AC50E68B355F469C8", hash_generated_method = "7A589808ED7E6C2BFD87AB94EB76C43A")
    public void setSecure(boolean secure) {
        this.scheme = SIPS;
        this.scheme = SIP;
        addTaint(secure);
        // ---------- Original Method ----------
        //if (secure)
            //this.scheme = SIPS;
        //else
            //this.scheme = SIP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.475 -0400", hash_original_method = "8785DA0B69A8C30F98EFE6C5EB1879AC", hash_generated_method = "992BE2E133A2903153169F2C05DA253E")
    public void setTTLParam(int ttl) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad ttl value");
        {
            NameValue nv = new NameValue("ttl", Integer.valueOf(ttl));
            uriParms.set(nv);
        } //End block
        addTaint(ttl);
        // ---------- Original Method ----------
        //if (ttl <= 0)
            //throw new IllegalArgumentException("Bad ttl value");
        //if (uriParms != null) {
            //NameValue nv = new NameValue("ttl", Integer.valueOf(ttl));
            //uriParms.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.477 -0400", hash_original_method = "D4B3823C982965112DA168F305C25048", hash_generated_method = "836BC20BF3DE2920137959B5AE8943B3")
    public void setTransportParam(String transport) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        {
            boolean varD52FB728B1D6488FBD6394869977AA12_172107408 = (transport.compareToIgnoreCase("UDP") == 0
            || transport.compareToIgnoreCase("TLS") == 0
            || transport.compareToIgnoreCase("TCP") == 0
            || transport.compareToIgnoreCase("SCTP") == 0);
            {
                NameValue nv = new NameValue(TRANSPORT, transport.toLowerCase());
                uriParms.set(nv);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad transport " + transport, 0);
        } //End collapsed parenthetic
        addTaint(transport.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.478 -0400", hash_original_method = "1E6ECA3F7C52B01B50446520797B0E33", hash_generated_method = "EA4477BB51CB8214CF4134B953CB7BCA")
    public String getUserParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1625276568 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1625276568 = getParameter("user");
        varB4EAC82CA7396A68D541C85D26508E83_1625276568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1625276568;
        // ---------- Original Method ----------
        //return getParameter("user");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.479 -0400", hash_original_method = "23F3E2D78AEB517CE17DC4369118F50D", hash_generated_method = "542DA9148B0DFD516B4598BA40C13FF2")
    public boolean hasLrParam() {
        boolean varFC6FB6D38ED03C2B27CF94B4AD499E80_1631422331 = (uriParms.getNameValue("lr") != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763279810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763279810;
        // ---------- Original Method ----------
        //return uriParms.getNameValue("lr") != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.480 -0400", hash_original_method = "BF370972F662FF42728C27309BA84910", hash_generated_method = "E0128E888988F9DFC818EA0F45DD7D24")
    public boolean hasGrParam() {
        boolean varFA89BEA4AFAFBB589EEA15E98039438D_1094568928 = (uriParms.getNameValue(GRUU) != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679762237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679762237;
        // ---------- Original Method ----------
        //return uriParms.getNameValue(GRUU) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.481 -0400", hash_original_method = "80955EE8A827F28D322398606EB833AF", hash_generated_method = "0216168731AF3B946D7ACA4A469ABEC3")
    public void setGrParam(String value) {
        this.uriParms.set(GRUU, value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.uriParms.set(GRUU, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.482 -0400", hash_original_method = "215DF01DBB1883D8F30CF584508D27CC", hash_generated_method = "5474A7211E7A5FE9D7849E5DAD23484F")
    public String getGrParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_158394638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_158394638 = (String) this.uriParms.getValue(GRUU);
        varB4EAC82CA7396A68D541C85D26508E83_158394638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_158394638;
        // ---------- Original Method ----------
        //return (String) this.uriParms.getValue(GRUU);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.482 -0400", hash_original_field = "FBC6DFE7D1C3D17A206CDAE04B65C0AA", hash_generated_field = "2F69FD556F8E9767DDE2D2177EBF6C40")

    private static final long serialVersionUID = 7749781076218987044L;
}

