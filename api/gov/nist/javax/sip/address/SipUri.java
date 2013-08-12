package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.Debug;
import gov.nist.core.GenericObject;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;

import java.text.ParseException;
import java.util.Iterator;

import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.SipURI;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;






public class SipUri extends GenericURI implements javax.sip.address.SipURI, SipURIExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.242 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AD4D5BC0220CFD82443737C52505C486")

    protected Authority authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.242 -0400", hash_original_field = "3FAF7D735501DAD3EFB6210602CCAD3E", hash_generated_field = "F6A59563ED5E856D9CD91C684F4FC813")

    protected NameValueList uriParms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.242 -0400", hash_original_field = "1B6D732887C57CD3A7AFDF7A80A8AAE5", hash_generated_field = "45901905C5831FBB34F7DCD157856090")

    protected NameValueList qheaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.242 -0400", hash_original_field = "D8C88703367A716690FE5F351532E182", hash_generated_field = "486D6B81CF5C668276377979467C5D05")

    protected TelephoneNumber telephoneSubscriber;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.243 -0400", hash_original_method = "4581AC1C0AE43A94306BF80DA76A0B36", hash_generated_method = "C518F6BE6D677C49B5D373A0ADD9B73A")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.243 -0400", hash_original_method = "40F35B976B5ABD0FB641A4F1A08DC6DF", hash_generated_method = "7B8F66802877313D41C16E0FDF4D9D9D")
    public void setScheme(String scheme) {
        addTaint(scheme.getTaint());
        if(scheme.compareToIgnoreCase(SIP) != 0
            && scheme.compareToIgnoreCase(SIPS) != 0)        
        {
        IllegalArgumentException var2D5546381A5B8CD98716C54299B40BB4_487700695 = new IllegalArgumentException("bad scheme " + scheme);
        var2D5546381A5B8CD98716C54299B40BB4_487700695.addTaint(taint);
        throw var2D5546381A5B8CD98716C54299B40BB4_487700695;
        }
        this.scheme = scheme.toLowerCase();
        // ---------- Original Method ----------
        //if (scheme.compareToIgnoreCase(SIP) != 0
            //&& scheme.compareToIgnoreCase(SIPS) != 0)
            //throw new IllegalArgumentException("bad scheme " + scheme);
        //this.scheme = scheme.toLowerCase();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.244 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9C8B0057D0572D6FB1404E6006B581F0")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_136393078 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_136393078.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_136393078;
        // ---------- Original Method ----------
        //return scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.244 -0400", hash_original_method = "B97988479159B246DBD5976667FAE614", hash_generated_method = "7A913D6E89C72AB83AFFF954FFBF7CD6")
    public void clearUriParms() {
        uriParms = new NameValueList();
        // ---------- Original Method ----------
        //uriParms = new NameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.245 -0400", hash_original_method = "FDFE9380996AC8B536679A9DC84D64BE", hash_generated_method = "1BE3A8B90BA1F2C14127BA6A11C78D22")
    public void clearPassword() {
        if(this.authority != null)        
        {
            UserInfo userInfo = authority.getUserInfo();
            if(userInfo != null)            
            userInfo.clearPassword();
        } //End block
        // ---------- Original Method ----------
        //if (this.authority != null) {
            //UserInfo userInfo = authority.getUserInfo();
            //if (userInfo != null)
                //userInfo.clearPassword();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.245 -0400", hash_original_method = "92C8D5BE70E6877E725894DF3752DAAD", hash_generated_method = "4E729F182423B6C2AFD2F251A982A99E")
    public Authority getAuthority() {
Authority var5CCAD38430CC6AF5F53A9FDF4E031259_1203710205 =         this.authority;
        var5CCAD38430CC6AF5F53A9FDF4E031259_1203710205.addTaint(taint);
        return var5CCAD38430CC6AF5F53A9FDF4E031259_1203710205;
        // ---------- Original Method ----------
        //return this.authority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.245 -0400", hash_original_method = "44A5F82F772B2346E44573FA04C5E6BF", hash_generated_method = "546FDDE1F5876502A34904E6040940A2")
    public void clearQheaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.249 -0400", hash_original_method = "9EAD5694A977A9D6081FC9F5B163E148", hash_generated_method = "2CD887DDABF2D5079289E645161E63A0")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {
        addTaint(that.getTaint());
        if(that==this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_11820647 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286812718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286812718;
        }
        if(that instanceof SipURI)        
        {
            final SipURI a = this;
            final SipURI b = (SipURI) that;
            if(a.isSecure() ^ b.isSecure())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1770595475 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188997977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_188997977;
            }
            if(a.getUser()==null ^ b.getUser()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1782927024 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049470274 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049470274;
            }
            if(a.getUserPassword()==null ^ b.getUserPassword()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1773859058 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463242936 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463242936;
            }
            if(a.getUser()!=null && !RFC2396UrlDecoder.decode(a.getUser()).equals(RFC2396UrlDecoder.decode(b.getUser())))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2091496943 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894306696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_894306696;
            }
            if(a.getUserPassword()!=null && !RFC2396UrlDecoder.decode(a.getUserPassword()).equals(RFC2396UrlDecoder.decode(b.getUserPassword())))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1373384597 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765209658 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_765209658;
            }
            if(a.getHost() == null ^ b.getHost() == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1488198337 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735136724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_735136724;
            }
            if(a.getHost() != null && !a.getHost().equalsIgnoreCase(b.getHost()))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2039196809 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832508785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832508785;
            }
            if(a.getPort() != b.getPort())            
            {
            boolean var68934A3E9455FA72420237EB05902327_554868084 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752332306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_752332306;
            }
for(Iterator i = a.getParameterNames();i.hasNext();)
            {
                String pname = (String) i.next();
                String p1 = a.getParameter(pname);
                String p2 = b.getParameter(pname);
                if(p1!=null && p2!=null && !RFC2396UrlDecoder.decode(p1).equalsIgnoreCase(RFC2396UrlDecoder.decode(p2)))                
                {
                boolean var68934A3E9455FA72420237EB05902327_467096311 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591727789 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591727789;
                }
            } //End block
            if(a.getTransportParam()==null ^ b.getTransportParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_789096436 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214858336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214858336;
            }
            if(a.getUserParam()==null ^ b.getUserParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_466006552 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029850595 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029850595;
            }
            if(a.getTTLParam()==-1 ^ b.getTTLParam()==-1)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1046433068 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595851378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595851378;
            }
            if(a.getMethodParam()==null ^ b.getMethodParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1314723365 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637269761 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_637269761;
            }
            if(a.getMAddrParam()==null ^ b.getMAddrParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1842845095 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041319516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041319516;
            }
            if(a.getHeaderNames().hasNext() && !b.getHeaderNames().hasNext())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1811448584 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813545651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_813545651;
            }
            if(!a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1447096555 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301238809 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301238809;
            }
            if(a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext())            
            {
                HeaderFactory headerFactory = null;
                try 
                {
                    headerFactory = SipFactory.getInstance().createHeaderFactory();
                } //End block
                catch (PeerUnavailableException e)
                {
                    Debug.logError("Cannot get the header factory to parse the header of the sip uris to compare", e);
                    boolean var68934A3E9455FA72420237EB05902327_2009762930 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33068639 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_33068639;
                } //End block
for(Iterator i = a.getHeaderNames();i.hasNext();)
                {
                    String hname = (String) i.next();
                    String h1 = a.getHeader(hname);
                    String h2 = b.getHeader(hname);
                    if(h1 == null && h2 != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_44670634 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063173343 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063173343;
                    }
                    if(h2 == null && h1 != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_649299025 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139562936 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139562936;
                    }
                    if(h1 == null && h2 == null)                    
                    continue;
                    try 
                    {
                        Header header1 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h1));
                        Header header2 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h2));
                        if(!header1.equals(header2))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_392298514 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255673946 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255673946;
                        }
                    } //End block
                    catch (ParseException e)
                    {
                        Debug.logError("Cannot parse one of the header of the sip uris to compare " + a + " " + b, e);
                        boolean var68934A3E9455FA72420237EB05902327_2092227209 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745342825 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745342825;
                    } //End block
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1429001629 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857901235 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857901235;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_34547986 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395975497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395975497;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.250 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1EEFD2BEE38ECFD0E1DB52627C95E6F2")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1234407106 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1234407106.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1234407106;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.251 -0400", hash_original_method = "C22033B09BF680257BC2551F51CC4682", hash_generated_method = "30C91E9BA4F19B592A72100A2F09217E")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(scheme).append(COLON);
        if(authority != null)        
        authority.encode(buffer);
        if(!uriParms.isEmpty())        
        {
            buffer.append(SEMICOLON);
            uriParms.encode(buffer);
        } //End block
        if(!qheaders.isEmpty())        
        {
            buffer.append(QUESTION);
            qheaders.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_424105326 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_424105326.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_424105326;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.251 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "9081C1773A7AD0B94399561135B05042")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_331466831 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_331466831.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_331466831;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.251 -0400", hash_original_method = "000995A40BE4F62572B4CEC75CD27D06", hash_generated_method = "4B93D960BCCF286730C20875E377FF06")
    public String getUserAtHost() {
        String user = "";
        if(authority.getUserInfo() != null)        
        user = authority.getUserInfo().getUser();
        String host = authority.getHost().encode();
        StringBuffer s = null;
        if(user.equals(""))        
        {
            s = new StringBuffer();
        } //End block
        else
        {
            s = new StringBuffer(user).append(AT);
        } //End block
String var5C0D40F1B156D8DCF39E701F873150CC_705098501 =         s.append(host).toString();
        var5C0D40F1B156D8DCF39E701F873150CC_705098501.addTaint(taint);
        return var5C0D40F1B156D8DCF39E701F873150CC_705098501;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.252 -0400", hash_original_method = "6F248E410BDCE844EE042BFFA98482C9", hash_generated_method = "DB86BE3798410C9407852A53E07415BE")
    public String getUserAtHostPort() {
        String user = "";
        if(authority.getUserInfo() != null)        
        user = authority.getUserInfo().getUser();
        String host = authority.getHost().encode();
        int port = authority.getPort();
        StringBuffer s = null;
        if(user.equals(""))        
        {
            s = new StringBuffer();
        } //End block
        else
        {
            s = new StringBuffer(user).append(AT);
        } //End block
        if(port != -1)        
        {
String var795C5AA00530E2041EBCF23EF1C309FE_1249758029 =             s.append(host).append(COLON).append(port).toString();
            var795C5AA00530E2041EBCF23EF1C309FE_1249758029.addTaint(taint);
            return var795C5AA00530E2041EBCF23EF1C309FE_1249758029;
        } //End block
        else
        {
String var5C0D40F1B156D8DCF39E701F873150CC_1459404957 =         s.append(host).toString();
        var5C0D40F1B156D8DCF39E701F873150CC_1459404957.addTaint(taint);
        return var5C0D40F1B156D8DCF39E701F873150CC_1459404957;
        }
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.253 -0400", hash_original_method = "208FE04DEC7ECCEEFC5A47E5D08BA557", hash_generated_method = "4C6CEBEED2C823AE1F157CBB08AB4830")
    public Object getParm(String parmname) {
        addTaint(parmname.getTaint());
        Object obj = uriParms.getValue(parmname);
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_855883938 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_855883938.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_855883938;
        // ---------- Original Method ----------
        //Object obj = uriParms.getValue(parmname);
        //return obj;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.253 -0400", hash_original_method = "DA8D1E67518AA478AB8C96314B0F321C", hash_generated_method = "5DA385DD790395C74F333C0E3748C949")
    public String getMethod() {
String var1B3312612BAD48F52013E10EB1097F72_1282901815 =         (String) getParm(METHOD);
        var1B3312612BAD48F52013E10EB1097F72_1282901815.addTaint(taint);
        return var1B3312612BAD48F52013E10EB1097F72_1282901815;
        // ---------- Original Method ----------
        //return (String) getParm(METHOD);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.253 -0400", hash_original_method = "5EDAD210CE239248A46B40B8A7E4E067", hash_generated_method = "3FE757E489C66909DE200823B10509C0")
    public NameValueList getParameters() {
NameValueList var9389EB218FFD2B30D5D5B79C468DD3CD_389740910 =         uriParms;
        var9389EB218FFD2B30D5D5B79C468DD3CD_389740910.addTaint(taint);
        return var9389EB218FFD2B30D5D5B79C468DD3CD_389740910;
        // ---------- Original Method ----------
        //return uriParms;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.253 -0400", hash_original_method = "F23607C60777A1A36911A6FE06B11E71", hash_generated_method = "4FF98F06B904C85601629D95CCCE2CC2")
    public void removeParameters() {
        this.uriParms = new NameValueList();
        // ---------- Original Method ----------
        //this.uriParms = new NameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.254 -0400", hash_original_method = "69A77D050D6DE602ACFB758F18CE1C2E", hash_generated_method = "21A564FDA876516511F67BAEEB83EFBA")
    public NameValueList getQheaders() {
NameValueList var7CDA247EB3CC0EBDA5223EBFEFA7FB77_930956394 =         qheaders;
        var7CDA247EB3CC0EBDA5223EBFEFA7FB77_930956394.addTaint(taint);
        return var7CDA247EB3CC0EBDA5223EBFEFA7FB77_930956394;
        // ---------- Original Method ----------
        //return qheaders;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.254 -0400", hash_original_method = "C4F4158359E9C3CE01C658AE1B903AEE", hash_generated_method = "E0B8A4A85EC8432F65D7BAB71AF69641")
    public String getUserType() {
String var13B4B8D28AC37068B9C1158BE11B7BD9_1637372788 =         (String) uriParms.getValue(USER);
        var13B4B8D28AC37068B9C1158BE11B7BD9_1637372788.addTaint(taint);
        return var13B4B8D28AC37068B9C1158BE11B7BD9_1637372788;
        // ---------- Original Method ----------
        //return (String) uriParms.getValue(USER);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.254 -0400", hash_original_method = "F7BA3F65C36127DC85DBDC366FBE67EC", hash_generated_method = "491D0F97F851721C0AA0DB82C3417386")
    public String getUserPassword() {
        if(authority == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1934374060 =         null;
        var540C13E9E156B687226421B24F2DF178_1934374060.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1934374060;
        }
String varA538A2E3F096B83A4259C49C907D0D1F_755823244 =         authority.getPassword();
        varA538A2E3F096B83A4259C49C907D0D1F_755823244.addTaint(taint);
        return varA538A2E3F096B83A4259C49C907D0D1F_755823244;
        // ---------- Original Method ----------
        //if (authority == null)
            //return null;
        //return authority.getPassword();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.255 -0400", hash_original_method = "EB4E37E6319716C20DB55C1D8565711A", hash_generated_method = "305069BA63292E94235BF915303389CF")
    public void setUserPassword(String password) {
        addTaint(password.getTaint());
        if(this.authority == null)        
        this.authority = new Authority();
        authority.setPassword(password);
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //authority.setPassword(password);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.255 -0400", hash_original_method = "FBB7E1AC9741B23BB5B3EA84041A8793", hash_generated_method = "F8372F2C3663D11BB4B2B17F139B8475")
    public TelephoneNumber getTelephoneSubscriber() {
        if(telephoneSubscriber == null)        
        {
            telephoneSubscriber = new TelephoneNumber();
        } //End block
TelephoneNumber var3A51A0F2BD41089649E42A7CD484346C_456729194 =         telephoneSubscriber;
        var3A51A0F2BD41089649E42A7CD484346C_456729194.addTaint(taint);
        return var3A51A0F2BD41089649E42A7CD484346C_456729194;
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null) {
            //telephoneSubscriber = new TelephoneNumber();
        //}
        //return telephoneSubscriber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.255 -0400", hash_original_method = "B2DE769DC5E0088684B143D456F129CF", hash_generated_method = "73C01E552C6AD6A0C97EED95C57AA940")
    public HostPort getHostPort() {
        if(authority == null || authority.getHost() == null)        
        {
HostPort var540C13E9E156B687226421B24F2DF178_2008662283 =         null;
        var540C13E9E156B687226421B24F2DF178_2008662283.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2008662283;
        }
        else
        {
HostPort var78739834C43730B8FC5553B75C8085B7_939055087 =             authority.getHostPort();
            var78739834C43730B8FC5553B75C8085B7_939055087.addTaint(taint);
            return var78739834C43730B8FC5553B75C8085B7_939055087;
        } //End block
        // ---------- Original Method ----------
        //if (authority == null || authority.getHost() == null )
            //return null;
        //else {
            //return authority.getHostPort();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.256 -0400", hash_original_method = "7F780725D3A26A9FAAA917ED82465734", hash_generated_method = "2277E04048C00D441DF4848ECC49676C")
    public int getPort() {
        HostPort hp = this.getHostPort();
        if(hp == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_418061151 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1511715803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1511715803;
        }
        int var2434D0703265A5BE0ED8CB0805D507F8_80692194 = (hp.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306274969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306274969;
        // ---------- Original Method ----------
        //HostPort hp = this.getHostPort();
        //if (hp == null)
            //return -1;
        //return hp.getPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.256 -0400", hash_original_method = "40B106F658B1B0B8AE55FF744395EB77", hash_generated_method = "E96608329E9A6EF5657FD35E639BCD69")
    public String getHost() {
        if(authority == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1056795398 =         null;
        var540C13E9E156B687226421B24F2DF178_1056795398.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1056795398;
        }
        else
        if(authority.getHost() == null)        
        {
String var540C13E9E156B687226421B24F2DF178_85004333 =         null;
        var540C13E9E156B687226421B24F2DF178_85004333.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_85004333;
        }
        else
        {
String varE1F15250491F87E8943C750256671D6A_2131275740 =         authority.getHost().encode();
        varE1F15250491F87E8943C750256671D6A_2131275740.addTaint(taint);
        return varE1F15250491F87E8943C750256671D6A_2131275740;
        }
        // ---------- Original Method ----------
        //if ( authority == null) return null;
        //else if (authority.getHost() == null ) return null;
        //else return authority.getHost().encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.256 -0400", hash_original_method = "56CDDCF4149582CE88DAE7137BB51FB6", hash_generated_method = "15F82EDCEAAA11FE24506F1EBB6F87C6")
    public boolean isUserTelephoneSubscriber() {
        String usrtype = (String) uriParms.getValue(USER);
        if(usrtype == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1596994259 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568527663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568527663;
        }
        boolean varCF1F2D6D44F1EB428B4B69D9473041E3_1209509949 = (usrtype.equalsIgnoreCase(PHONE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013805980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013805980;
        // ---------- Original Method ----------
        //String usrtype = (String) uriParms.getValue(USER);
        //if (usrtype == null)
            //return false;
        //return usrtype.equalsIgnoreCase(PHONE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.257 -0400", hash_original_method = "31B2EAABC2E978FD5373BC4C4C4BC54F", hash_generated_method = "EF73F28866869BC6C83E6BEFFB8E82C6")
    public void removeTTL() {
        if(uriParms != null)        
        uriParms.delete(TTL);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TTL);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.257 -0400", hash_original_method = "26682CE55BB39CA926871319A4C06C7F", hash_generated_method = "8A952D3687D2CF17869A5717861C8299")
    public void removeMAddr() {
        if(uriParms != null)        
        uriParms.delete(MADDR);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(MADDR);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.257 -0400", hash_original_method = "17C4DDD354C5E051E7720776FDB1621B", hash_generated_method = "6F415C8392AF3B3BFCDF8F62E49829CE")
    public void removeTransport() {
        if(uriParms != null)        
        uriParms.delete(TRANSPORT);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TRANSPORT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.257 -0400", hash_original_method = "3200AD1B535820580583A49AC076B7CA", hash_generated_method = "AEC66D5A870E4B5E8003707BE0873F49")
    public void removeHeader(String name) {
        addTaint(name.getTaint());
        if(qheaders != null)        
        qheaders.delete(name);
        // ---------- Original Method ----------
        //if (qheaders != null)
            //qheaders.delete(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.257 -0400", hash_original_method = "69EBEDDBEBD5610928D56ADB554A973E", hash_generated_method = "E903C32C0E8700933F47690CE9D407A7")
    public void removeHeaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.258 -0400", hash_original_method = "4C60E3731E2F1A6A961C2EAF6730B8EA", hash_generated_method = "A86E4B7A4678B63B4EFED99FCA235A51")
    public void removeUserType() {
        if(uriParms != null)        
        uriParms.delete(USER);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(USER);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.258 -0400", hash_original_method = "A557BD8F16E39F3D746BC7787E72C291", hash_generated_method = "293540653E3C979EF343913001576563")
    public void removePort() {
        authority.removePort();
        // ---------- Original Method ----------
        //authority.removePort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.258 -0400", hash_original_method = "80293F715FFD7AE029130C857C03E1EB", hash_generated_method = "E6C83B17137B22C53FC0208B6F6C7233")
    public void removeMethod() {
        if(uriParms != null)        
        uriParms.delete(METHOD);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(METHOD);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.258 -0400", hash_original_method = "8653C52476DAA9902FEC7B8799779AA0", hash_generated_method = "612DB2F05990B720BE28472E9052A1DD")
    public void setUser(String uname) {
        addTaint(uname.getTaint());
        if(this.authority == null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.259 -0400", hash_original_method = "D79A18951B63A09462A96884D78AF17C", hash_generated_method = "4E243F3AE992330B75CE9FFE82B2DA90")
    public void removeUser() {
        this.authority.removeUserInfo();
        // ---------- Original Method ----------
        //this.authority.removeUserInfo();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.259 -0400", hash_original_method = "29256DC0D79112DA6F3456FF1FC7A4DA", hash_generated_method = "FEE8F35FE589FC57B2D783EF07218E03")
    public void setDefaultParm(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(uriParms.getValue(name) == null)        
        {
            NameValue nv = new NameValue(name, value);
            uriParms.set(nv);
        } //End block
        // ---------- Original Method ----------
        //if (uriParms.getValue(name) == null) {
            //NameValue nv = new NameValue(name, value);
            //uriParms.set(nv);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.259 -0400", hash_original_method = "8155A130BB5ECD11F95AAB0DA6526B6B", hash_generated_method = "17C5E94A9E6A70133A97A70EC4723660")
    public void setAuthority(Authority authority) {
        this.authority = authority;
        // ---------- Original Method ----------
        //this.authority = authority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.260 -0400", hash_original_method = "448F841326C9DE5F0C1061A977ECCF57", hash_generated_method = "0DA7F5B6DFDB4A2D1A673016AD597D19")
    public void setHost(Host h) {
        addTaint(h.getTaint());
        if(this.authority == null)        
        this.authority = new Authority();
        this.authority.setHost(h);
        // ---------- Original Method ----------
        //if (this.authority == null)
            //this.authority = new Authority();
        //this.authority.setHost(h);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.260 -0400", hash_original_method = "BF30B120DCA846B2AB31EE4276940CB4", hash_generated_method = "C12913C3D366050264426BFF362BC735")
    public void setUriParms(NameValueList parms) {
        uriParms = parms;
        // ---------- Original Method ----------
        //uriParms = parms;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.261 -0400", hash_original_method = "B486DF9BA471DAAE60D8533B7C47A65D", hash_generated_method = "9DE6C9050263AE0304867C6A0119C317")
    public void setUriParm(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = new NameValue(name, value);
        uriParms.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //uriParms.set(nv);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.261 -0400", hash_original_method = "3BCF6EC7FF3BBA5809384A38F15B6A45", hash_generated_method = "2E952D0669523402C7D8C7BA5EACD080")
    public void setQheaders(NameValueList parms) {
        qheaders = parms;
        // ---------- Original Method ----------
        //qheaders = parms;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.261 -0400", hash_original_method = "5C181333E4641A8C388789644A11AD43", hash_generated_method = "60898F7DE5CF83E561E57CC1B16D511D")
    public void setMAddr(String mAddr) {
        addTaint(mAddr.getTaint());
        NameValue nameValue = uriParms.getNameValue(MADDR);
        Host host = new Host();
        host.setAddress(mAddr);
        if(nameValue != null)        
        nameValue.setValueAsObject(host);
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "FBDBB9DDA2030458399AB3B5F3F4F0C6", hash_generated_method = "1AA95D1226AC15143412C988EA21B340")
    public void setUserParam(String usertype) {
        addTaint(usertype.getTaint());
        uriParms.set(USER, usertype);
        // ---------- Original Method ----------
        //uriParms.set(USER, usertype);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "4C629B888B40F45F11F6D780770DFFA5", hash_generated_method = "ACD0645156A22345F93CD0622E586D91")
    public void setMethod(String method) {
        addTaint(method.getTaint());
        uriParms.set(METHOD, method);
        // ---------- Original Method ----------
        //uriParms.set(METHOD, method);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "E57262682E1156419367692D3CFC45F4", hash_generated_method = "9C48536D30F078B5D6AB9DC14E7FC094")
    public void setIsdnSubAddress(String isdnSubAddress) {
        addTaint(isdnSubAddress.getTaint());
        if(telephoneSubscriber == null)        
        telephoneSubscriber = new TelephoneNumber();
        telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null)
            //telephoneSubscriber = new TelephoneNumber();
        //telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "988EFE784E2C119D10B2A809CB388B9F", hash_generated_method = "BABA85DAD3AFF0C47B1D5E16AE852918")
    public void setTelephoneSubscriber(TelephoneNumber tel) {
        telephoneSubscriber = tel;
        // ---------- Original Method ----------
        //telephoneSubscriber = tel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "92A3A80BC1BE07F5BFACEB6CB4FB4561", hash_generated_method = "35C64C866131F8795A169947D55EEA00")
    public void setPort(int p) {
        addTaint(p);
        if(authority == null)        
        authority = new Authority();
        authority.setPort(p);
        // ---------- Original Method ----------
        //if (authority == null)
            //authority = new Authority();
        //authority.setPort(p);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "6341E21CDA970E0B49B9800DCF1B5945", hash_generated_method = "ACA2B48D84F15C367D365EEA9BB86B0E")
    public boolean hasParameter(String name) {
        addTaint(name.getTaint());
        boolean var95ADD3D3308931E73D8E7597CB38D166_1641613138 = (uriParms.getValue(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113748330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113748330;
        // ---------- Original Method ----------
        //return uriParms.getValue(name) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "93D043490BF44801AA76F19310D9D034", hash_generated_method = "1BFDF69835D055D726277D8F6FA45D79")
    public void setQHeader(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.qheaders.set(nameValue);
        // ---------- Original Method ----------
        //this.qheaders.set(nameValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.262 -0400", hash_original_method = "CF8B8270AAB7EE0DBD09C8A6E6FE77D2", hash_generated_method = "E642A8566205961C710E2E5582C8A9E6")
    public void setUriParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.uriParms.set(nameValue);
        // ---------- Original Method ----------
        //this.uriParms.set(nameValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.263 -0400", hash_original_method = "79BAB25129164A5068BFAB9AA7EFB4C6", hash_generated_method = "34CB90FA73460EFCF1C35E28F9FFAE73")
    public boolean hasTransport() {
        boolean var63D62AFBFD62FEB78ACAAAFDDB8E558E_1346214150 = (hasParameter(TRANSPORT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474726247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474726247;
        // ---------- Original Method ----------
        //return hasParameter(TRANSPORT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.263 -0400", hash_original_method = "80DDF5AC1394722FFD3DB956063197F8", hash_generated_method = "BFA2101A01062FEB2510250DE5BBB1DA")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        uriParms.delete(name);
        // ---------- Original Method ----------
        //uriParms.delete(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.263 -0400", hash_original_method = "C8CB16861890EEF599D006A2C41B9058", hash_generated_method = "443E8EFD54A131F34387F51E05BC922A")
    public void setHostPort(HostPort hostPort) {
        addTaint(hostPort.getTaint());
        if(this.authority == null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.263 -0400", hash_original_method = "4FA40F4F8EA124691CF5F7EB5079802B", hash_generated_method = "ADED652D3F5C14DD18A9336DC2616023")
    public Object clone() {
        SipUri retval = (SipUri) super.clone();
        if(this.authority != null)        
        retval.authority = (Authority) this.authority.clone();
        if(this.uriParms != null)        
        retval.uriParms = (NameValueList) this.uriParms.clone();
        if(this.qheaders != null)        
        retval.qheaders = (NameValueList) this.qheaders.clone();
        if(this.telephoneSubscriber != null)        
        retval.telephoneSubscriber = (TelephoneNumber) this.telephoneSubscriber.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1383209467 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1383209467.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1383209467;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "D620A31F761EF988C6C51AF3A40C0F6E", hash_generated_method = "C6CD1391817114EAD7F51E983C54CE86")
    public String getHeader(String name) {
        addTaint(name.getTaint());
String var77CCD6F79AF45E9EA4EBFE393708AD56_1080550222 =         this.qheaders.getValue(name) != null
            ? this.qheaders.getValue(name).toString()
            : null;
        var77CCD6F79AF45E9EA4EBFE393708AD56_1080550222.addTaint(taint);
        return var77CCD6F79AF45E9EA4EBFE393708AD56_1080550222;
        // ---------- Original Method ----------
        //return this.qheaders.getValue(name) != null
            //? this.qheaders.getValue(name).toString()
            //: null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "4530375C3CFB28EF39A61BC561477425", hash_generated_method = "690181A2D767F38A84D183E0D1A37556")
    public Iterator<String> getHeaderNames() {
Iterator<String> var6E634D49D350130112693F1E9A8BF224_963807895 =         this.qheaders.getNames();
        var6E634D49D350130112693F1E9A8BF224_963807895.addTaint(taint);
        return var6E634D49D350130112693F1E9A8BF224_963807895;
        // ---------- Original Method ----------
        //return this.qheaders.getNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "3F7D698AA93119CDF4AD07DDC087B33E", hash_generated_method = "3C8DB579EB123229DC3D84FB5FEBB192")
    public String getLrParam() {
        boolean haslr = this.hasParameter(LR);
String varBEE9408018F3F983A14BD69629A7C528_1618660891 =         haslr ? "true" : null;
        varBEE9408018F3F983A14BD69629A7C528_1618660891.addTaint(taint);
        return varBEE9408018F3F983A14BD69629A7C528_1618660891;
        // ---------- Original Method ----------
        //boolean haslr = this.hasParameter(LR);
        //return haslr ? "true" : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "8D33CC87FEAA658432B140BA930B3AED", hash_generated_method = "F66CECD1E728F63D501F3263653B5061")
    public String getMAddrParam() {
        NameValue maddr = uriParms.getNameValue(MADDR);
        if(maddr == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1254468330 =         null;
        var540C13E9E156B687226421B24F2DF178_1254468330.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1254468330;
        }
        String host = (String) maddr.getValueAsObject();
String var872E07117C05F1A34EC24B57B694B8E3_1409377296 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1409377296.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1409377296;
        // ---------- Original Method ----------
        //NameValue maddr = uriParms.getNameValue(MADDR);
        //if (maddr == null)
            //return null;
        //String host = (String) maddr.getValueAsObject();
        //return host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "B0014A6E847FE8E425D38FE4F75F3375", hash_generated_method = "02C02912A48470FA32CCEABC6107B0F9")
    public String getMethodParam() {
String var008D3B6AD38B55A60987B086F7309F9E_1652267670 =         this.getParameter(METHOD);
        var008D3B6AD38B55A60987B086F7309F9E_1652267670.addTaint(taint);
        return var008D3B6AD38B55A60987B086F7309F9E_1652267670;
        // ---------- Original Method ----------
        //return this.getParameter(METHOD);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.264 -0400", hash_original_method = "B72E21D53820BAFF3F91285B817E8F6B", hash_generated_method = "A3271E5B4CC23663A003C7E90A4496D4")
    public String getParameter(String name) {
        addTaint(name.getTaint());
        Object val = uriParms.getValue(name);
        if(val == null)        
        {
String var540C13E9E156B687226421B24F2DF178_791946952 =         null;
        var540C13E9E156B687226421B24F2DF178_791946952.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_791946952;
        }
        if(val instanceof GenericObject)        
        {
String varF1B6C72F38290E3B9280610078FC772A_1456702869 =         ((GenericObject) val).encode();
        varF1B6C72F38290E3B9280610078FC772A_1456702869.addTaint(taint);
        return varF1B6C72F38290E3B9280610078FC772A_1456702869;
        }
        else
        {
String var38570108501B3BE2AC163FA564B07985_1656683391 =         val.toString();
        var38570108501B3BE2AC163FA564B07985_1656683391.addTaint(taint);
        return var38570108501B3BE2AC163FA564B07985_1656683391;
        }
        // ---------- Original Method ----------
        //Object val = uriParms.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.265 -0400", hash_original_method = "6E1DB232C6AA1FEC4050F87B0DECFBEC", hash_generated_method = "69BE98941C9379D2271639931822A580")
    public Iterator<String> getParameterNames() {
Iterator<String> varE900FF3BB904BD053F2C311296F497B6_64895015 =         this.uriParms.getNames();
        varE900FF3BB904BD053F2C311296F497B6_64895015.addTaint(taint);
        return varE900FF3BB904BD053F2C311296F497B6_64895015;
        // ---------- Original Method ----------
        //return this.uriParms.getNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.265 -0400", hash_original_method = "EE7A560BCE3AD39DE27697785FE9A0B4", hash_generated_method = "00EFDF55EB9B4918FC15F8907B936145")
    public int getTTLParam() {
        Integer ttl = (Integer) uriParms.getValue("ttl");
        if(ttl != null)        
        {
        int var6B00E161F829F9444EDBCA4D09949744_1562031739 = (ttl.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505623602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505623602;
        }
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_34332358 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240703515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240703515;
        }
        // ---------- Original Method ----------
        //Integer ttl = (Integer) uriParms.getValue("ttl");
        //if (ttl != null)
            //return ttl.intValue();
        //else
            //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.265 -0400", hash_original_method = "D0FE42FB772BF560666581278B9E7996", hash_generated_method = "DC09CF3A6D53CCAD88F6B2936CE5A286")
    public String getTransportParam() {
        if(uriParms != null)        
        {
String var06508F4F1791775F880FF28C12B26147_1746072044 =             (String) uriParms.getValue(TRANSPORT);
            var06508F4F1791775F880FF28C12B26147_1746072044.addTaint(taint);
            return var06508F4F1791775F880FF28C12B26147_1746072044;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_193231530 =         null;
        var540C13E9E156B687226421B24F2DF178_193231530.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_193231530;
        }
        // ---------- Original Method ----------
        //if (uriParms != null) {
            //return (String) uriParms.getValue(TRANSPORT);
        //} else
            //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.265 -0400", hash_original_method = "3B107DCD343091F4FCEB3378B44D2024", hash_generated_method = "10E63DEBB57C88F63F8984372F0ED5FC")
    public String getUser() {
String varB766A224519300F0F3A9053E67C813E9_347762781 =         authority.getUser();
        varB766A224519300F0F3A9053E67C813E9_347762781.addTaint(taint);
        return varB766A224519300F0F3A9053E67C813E9_347762781;
        // ---------- Original Method ----------
        //return authority.getUser();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.265 -0400", hash_original_method = "5246336FD52DFE5F131EDCED707C7332", hash_generated_method = "4F22F9395162E1E63F3E34CEDADBD4A6")
    public boolean isSecure() {
        boolean var0A0D0813B8B007BF2B2D88502D868F53_661408670 = (this.getScheme().equalsIgnoreCase(SIPS));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720783343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720783343;
        // ---------- Original Method ----------
        //return this.getScheme().equalsIgnoreCase(SIPS);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.266 -0400", hash_original_method = "56D579416E6E52BEF406E20E9865D4C4", hash_generated_method = "5F8E2D3D6D4F59479C2D5A155F093F4F")
    public boolean isSipURI() {
        boolean varB326B5062B2F0E69046810717534CB09_1155155934 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546468395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546468395;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.266 -0400", hash_original_method = "DE18AAB14C75B00C0640CE3E9515471C", hash_generated_method = "CBA7E516500BC2D190133145B1FF891D")
    public void setHeader(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = new NameValue(name, value);
        qheaders.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //qheaders.set(nv);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.266 -0400", hash_original_method = "8BEE64CFFA20AF8C2536A2ECB59F51EE", hash_generated_method = "EE34760D6792C0DB211E87BD94986292")
    public void setHost(String host) throws ParseException {
        addTaint(host.getTaint());
        Host h = new Host(host);
        this.setHost(h);
        // ---------- Original Method ----------
        //Host h = new Host(host);
        //this.setHost(h);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.266 -0400", hash_original_method = "DD9F3D6DD0A955FE88B26C596147A545", hash_generated_method = "FFD1D37F482D6599B51331C19EAD3783")
    public void setLrParam() {
        this.uriParms.set("lr",null);
        // ---------- Original Method ----------
        //this.uriParms.set("lr",null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.267 -0400", hash_original_method = "E9B55C57ECC7FC0F2DF8B4804D377AFB", hash_generated_method = "DF4B8BEDCEB26A8329E44D81828798E8")
    public void setMAddrParam(String maddr) throws ParseException {
        addTaint(maddr.getTaint());
        if(maddr == null)        
        {
        NullPointerException var2EB73F285C4EA4484DD188D3410363E8_1977199058 = new NullPointerException("bad maddr");
        var2EB73F285C4EA4484DD188D3410363E8_1977199058.addTaint(taint);
        throw var2EB73F285C4EA4484DD188D3410363E8_1977199058;
        }
        setParameter("maddr", maddr);
        // ---------- Original Method ----------
        //if (maddr == null)
            //throw new NullPointerException("bad maddr");
        //setParameter("maddr", maddr);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.267 -0400", hash_original_method = "378F5AA5131E869E77C4B19F60BAAC21", hash_generated_method = "F2DB4E76AB69228785A5D10D7CA28EFA")
    public void setMethodParam(String method) throws ParseException {
        addTaint(method.getTaint());
        setParameter("method", method);
        // ---------- Original Method ----------
        //setParameter("method", method);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.267 -0400", hash_original_method = "B29E45FE1B913173FAF4035EBB51958B", hash_generated_method = "65F893632F19B1E63DB4362961D5D32F")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name.equalsIgnoreCase("ttl"))        
        {
            try 
            {
                Integer.parseInt(value);
            } //End block
            catch (NumberFormatException ex)
            {
                ParseException varEE648CDED79B3B6A98DB488DFC5FC3CF_1211988305 = new ParseException("bad parameter " + value, 0);
                varEE648CDED79B3B6A98DB488DFC5FC3CF_1211988305.addTaint(taint);
                throw varEE648CDED79B3B6A98DB488DFC5FC3CF_1211988305;
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.267 -0400", hash_original_method = "93EA8C8ECDAC523AC50E68B355F469C8", hash_generated_method = "B49E07412AC75A9BCAAA2DEE1B70F25C")
    public void setSecure(boolean secure) {
        addTaint(secure);
        if(secure)        
        this.scheme = SIPS;
        else
        this.scheme = SIP;
        // ---------- Original Method ----------
        //if (secure)
            //this.scheme = SIPS;
        //else
            //this.scheme = SIP;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.268 -0400", hash_original_method = "8785DA0B69A8C30F98EFE6C5EB1879AC", hash_generated_method = "33B3DCAEA839451A693067417AC526B3")
    public void setTTLParam(int ttl) {
        addTaint(ttl);
        if(ttl <= 0)        
        {
        IllegalArgumentException varEA2B86C95CCDE96B32C43EDE30655D72_506371822 = new IllegalArgumentException("Bad ttl value");
        varEA2B86C95CCDE96B32C43EDE30655D72_506371822.addTaint(taint);
        throw varEA2B86C95CCDE96B32C43EDE30655D72_506371822;
        }
        if(uriParms != null)        
        {
            NameValue nv = new NameValue("ttl", Integer.valueOf(ttl));
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.268 -0400", hash_original_method = "D4B3823C982965112DA168F305C25048", hash_generated_method = "9553E2BD3B9161DB4F245525D3A17C7F")
    public void setTransportParam(String transport) throws ParseException {
        addTaint(transport.getTaint());
        if(transport == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1535271472 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1535271472.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1535271472;
        }
        if(transport.compareToIgnoreCase("UDP") == 0
            || transport.compareToIgnoreCase("TLS") == 0
            || transport.compareToIgnoreCase("TCP") == 0
            || transport.compareToIgnoreCase("SCTP") == 0)        
        {
            NameValue nv = new NameValue(TRANSPORT, transport.toLowerCase());
            uriParms.set(nv);
        } //End block
        else
        {
        ParseException varCE19B354336813EFA8C17F03B48DDE40_1277554922 = new ParseException("bad transport " + transport, 0);
        varCE19B354336813EFA8C17F03B48DDE40_1277554922.addTaint(taint);
        throw varCE19B354336813EFA8C17F03B48DDE40_1277554922;
        }
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.268 -0400", hash_original_method = "1E6ECA3F7C52B01B50446520797B0E33", hash_generated_method = "FDA8E10B20FF66A3FFF4D4DC8FFEEB3D")
    public String getUserParam() {
String varB34BE6EB9BFD3B21D4824A13D09FD46C_840611492 =         getParameter("user");
        varB34BE6EB9BFD3B21D4824A13D09FD46C_840611492.addTaint(taint);
        return varB34BE6EB9BFD3B21D4824A13D09FD46C_840611492;
        // ---------- Original Method ----------
        //return getParameter("user");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.269 -0400", hash_original_method = "23F3E2D78AEB517CE17DC4369118F50D", hash_generated_method = "9A933B85F61E91227E9823AC14204507")
    public boolean hasLrParam() {
        boolean varCF7A45E5A550B9334314361D8E2B5B2D_1897701638 = (uriParms.getNameValue("lr") != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121383490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121383490;
        // ---------- Original Method ----------
        //return uriParms.getNameValue("lr") != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.269 -0400", hash_original_method = "BF370972F662FF42728C27309BA84910", hash_generated_method = "38E7574C7CB287C3F6689D122325BDC7")
    public boolean hasGrParam() {
        boolean var22A521DD7FE9C23EF30C36DD35B54A9C_942509512 = (uriParms.getNameValue(GRUU) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295771039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295771039;
        // ---------- Original Method ----------
        //return uriParms.getNameValue(GRUU) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.269 -0400", hash_original_method = "80955EE8A827F28D322398606EB833AF", hash_generated_method = "F4FB5BB1B9EFF549F47CE8961D054B09")
    public void setGrParam(String value) {
        addTaint(value.getTaint());
        this.uriParms.set(GRUU, value);
        // ---------- Original Method ----------
        //this.uriParms.set(GRUU, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.269 -0400", hash_original_method = "215DF01DBB1883D8F30CF584508D27CC", hash_generated_method = "60A4C5297271BE97205D789E316E0901")
    public String getGrParam() {
String var16DF91DFF27559DC8E701100F9E8B5CE_664140099 =         (String) this.uriParms.getValue(GRUU);
        var16DF91DFF27559DC8E701100F9E8B5CE_664140099.addTaint(taint);
        return var16DF91DFF27559DC8E701100F9E8B5CE_664140099;
        // ---------- Original Method ----------
        //return (String) this.uriParms.getValue(GRUU);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.269 -0400", hash_original_field = "FBC6DFE7D1C3D17A206CDAE04B65C0AA", hash_generated_field = "2F69FD556F8E9767DDE2D2177EBF6C40")

    private static final long serialVersionUID = 7749781076218987044L;
}

