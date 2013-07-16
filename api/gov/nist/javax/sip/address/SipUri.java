package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.util.*;
import java.text.ParseException;
import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.SipURI;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;

public class SipUri extends GenericURI implements javax.sip.address.SipURI, SipURIExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.266 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AD4D5BC0220CFD82443737C52505C486")

    protected Authority authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.266 -0400", hash_original_field = "3FAF7D735501DAD3EFB6210602CCAD3E", hash_generated_field = "F6A59563ED5E856D9CD91C684F4FC813")

    protected NameValueList uriParms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.266 -0400", hash_original_field = "1B6D732887C57CD3A7AFDF7A80A8AAE5", hash_generated_field = "45901905C5831FBB34F7DCD157856090")

    protected NameValueList qheaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.266 -0400", hash_original_field = "D8C88703367A716690FE5F351532E182", hash_generated_field = "486D6B81CF5C668276377979467C5D05")

    protected TelephoneNumber telephoneSubscriber;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.267 -0400", hash_original_method = "4581AC1C0AE43A94306BF80DA76A0B36", hash_generated_method = "C518F6BE6D677C49B5D373A0ADD9B73A")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.268 -0400", hash_original_method = "40F35B976B5ABD0FB641A4F1A08DC6DF", hash_generated_method = "E7EB180B9B5F647E75979C3BEC5020B2")
    public void setScheme(String scheme) {
        addTaint(scheme.getTaint());
    if(scheme.compareToIgnoreCase(SIP) != 0
            && scheme.compareToIgnoreCase(SIPS) != 0)        
        {
        IllegalArgumentException var2D5546381A5B8CD98716C54299B40BB4_1239677307 = new IllegalArgumentException("bad scheme " + scheme);
        var2D5546381A5B8CD98716C54299B40BB4_1239677307.addTaint(taint);
        throw var2D5546381A5B8CD98716C54299B40BB4_1239677307;
        }
        this.scheme = scheme.toLowerCase();
        // ---------- Original Method ----------
        //if (scheme.compareToIgnoreCase(SIP) != 0
            //&& scheme.compareToIgnoreCase(SIPS) != 0)
            //throw new IllegalArgumentException("bad scheme " + scheme);
        //this.scheme = scheme.toLowerCase();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.268 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "523A27F6C6E28235B9206161F4435FC3")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1544378345 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1544378345.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1544378345;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.269 -0400", hash_original_method = "B97988479159B246DBD5976667FAE614", hash_generated_method = "7A913D6E89C72AB83AFFF954FFBF7CD6")
    public void clearUriParms() {
        uriParms = new NameValueList();
        // ---------- Original Method ----------
        //uriParms = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.269 -0400", hash_original_method = "FDFE9380996AC8B536679A9DC84D64BE", hash_generated_method = "1BE3A8B90BA1F2C14127BA6A11C78D22")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.269 -0400", hash_original_method = "92C8D5BE70E6877E725894DF3752DAAD", hash_generated_method = "EC934D32CB4BF9CF83E4185BA460FCA4")
    public Authority getAuthority() {
Authority var5CCAD38430CC6AF5F53A9FDF4E031259_1751061486 =         this.authority;
        var5CCAD38430CC6AF5F53A9FDF4E031259_1751061486.addTaint(taint);
        return var5CCAD38430CC6AF5F53A9FDF4E031259_1751061486;
        // ---------- Original Method ----------
        //return this.authority;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.270 -0400", hash_original_method = "44A5F82F772B2346E44573FA04C5E6BF", hash_generated_method = "546FDDE1F5876502A34904E6040940A2")
    public void clearQheaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.272 -0400", hash_original_method = "9EAD5694A977A9D6081FC9F5B163E148", hash_generated_method = "D86F5027A0F351A6700D9C285B95968C")
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {
        addTaint(that.getTaint());
    if(that==this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2136558646 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226635289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226635289;
        }
    if(that instanceof SipURI)        
        {
            final SipURI a = this;
            final SipURI b = (SipURI) that;
    if(a.isSecure() ^ b.isSecure())            
            {
            boolean var68934A3E9455FA72420237EB05902327_263830949 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124503651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124503651;
            }
    if(a.getUser()==null ^ b.getUser()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1713910772 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225271529 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_225271529;
            }
    if(a.getUserPassword()==null ^ b.getUserPassword()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1007088142 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734611608 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734611608;
            }
    if(a.getUser()!=null && !RFC2396UrlDecoder.decode(a.getUser()).equals(RFC2396UrlDecoder.decode(b.getUser())))            
            {
            boolean var68934A3E9455FA72420237EB05902327_2028323280 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070603669 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070603669;
            }
    if(a.getUserPassword()!=null && !RFC2396UrlDecoder.decode(a.getUserPassword()).equals(RFC2396UrlDecoder.decode(b.getUserPassword())))            
            {
            boolean var68934A3E9455FA72420237EB05902327_163028946 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013005362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013005362;
            }
    if(a.getHost() == null ^ b.getHost() == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1367846595 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385786522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_385786522;
            }
    if(a.getHost() != null && !a.getHost().equalsIgnoreCase(b.getHost()))            
            {
            boolean var68934A3E9455FA72420237EB05902327_697504640 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162480413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162480413;
            }
    if(a.getPort() != b.getPort())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1699642249 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052948569 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052948569;
            }
for(Iterator i = a.getParameterNames();i.hasNext();)
            {
                String pname = (String) i.next();
                String p1 = a.getParameter(pname);
                String p2 = b.getParameter(pname);
    if(p1!=null && p2!=null && !RFC2396UrlDecoder.decode(p1).equalsIgnoreCase(RFC2396UrlDecoder.decode(p2)))                
                {
                boolean var68934A3E9455FA72420237EB05902327_76756159 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694424687 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694424687;
                }
            } //End block
    if(a.getTransportParam()==null ^ b.getTransportParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_121519091 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388792199 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_388792199;
            }
    if(a.getUserParam()==null ^ b.getUserParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_351752934 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784104593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_784104593;
            }
    if(a.getTTLParam()==-1 ^ b.getTTLParam()==-1)            
            {
            boolean var68934A3E9455FA72420237EB05902327_937405979 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311518435 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311518435;
            }
    if(a.getMethodParam()==null ^ b.getMethodParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_199869326 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247301678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247301678;
            }
    if(a.getMAddrParam()==null ^ b.getMAddrParam()==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_306072642 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831867996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831867996;
            }
    if(a.getHeaderNames().hasNext() && !b.getHeaderNames().hasNext())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1751551445 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_512212384 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_512212384;
            }
    if(!a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext())            
            {
            boolean var68934A3E9455FA72420237EB05902327_1726380784 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616096495 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_616096495;
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
                    boolean var68934A3E9455FA72420237EB05902327_1897050000 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829157279 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829157279;
                } //End block
for(Iterator i = a.getHeaderNames();i.hasNext();)
                {
                    String hname = (String) i.next();
                    String h1 = a.getHeader(hname);
                    String h2 = b.getHeader(hname);
    if(h1 == null && h2 != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_26627714 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197028890 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_197028890;
                    }
    if(h2 == null && h1 != null)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_506129015 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_337658836 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_337658836;
                    }
    if(h1 == null && h2 == null)                    
                    continue;
                    try 
                    {
                        Header header1 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h1));
                        Header header2 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h2));
    if(!header1.equals(header2))                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1176093765 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938550232 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_938550232;
                        }
                    } //End block
                    catch (ParseException e)
                    {
                        Debug.logError("Cannot parse one of the header of the sip uris to compare " + a + " " + b, e);
                        boolean var68934A3E9455FA72420237EB05902327_81612256 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231808550 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231808550;
                    } //End block
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1940053528 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374503621 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_374503621;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1079243248 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819424364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819424364;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.275 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "AE55E057F3BCA71E6CC7DD9CD73C64EB")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_2083940446 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_2083940446.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_2083940446;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.276 -0400", hash_original_method = "C22033B09BF680257BC2551F51CC4682", hash_generated_method = "042608C223E7E6EFE4B60CD6E1638168")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_668930664 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_668930664.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_668930664;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.277 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "7FEEB48B9D929AF4B42CDCA1025C47DB")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1505548133 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1505548133.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1505548133;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.278 -0400", hash_original_method = "000995A40BE4F62572B4CEC75CD27D06", hash_generated_method = "5F1050D3936A972F7512B21655108858")
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
String var5C0D40F1B156D8DCF39E701F873150CC_1799544899 =         s.append(host).toString();
        var5C0D40F1B156D8DCF39E701F873150CC_1799544899.addTaint(taint);
        return var5C0D40F1B156D8DCF39E701F873150CC_1799544899;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.279 -0400", hash_original_method = "6F248E410BDCE844EE042BFFA98482C9", hash_generated_method = "232A5E0AE2E4C8BED3785B05F822CB35")
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
String var795C5AA00530E2041EBCF23EF1C309FE_353877633 =             s.append(host).append(COLON).append(port).toString();
            var795C5AA00530E2041EBCF23EF1C309FE_353877633.addTaint(taint);
            return var795C5AA00530E2041EBCF23EF1C309FE_353877633;
        } //End block
        else
        {
String var5C0D40F1B156D8DCF39E701F873150CC_2022767640 =         s.append(host).toString();
        var5C0D40F1B156D8DCF39E701F873150CC_2022767640.addTaint(taint);
        return var5C0D40F1B156D8DCF39E701F873150CC_2022767640;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.279 -0400", hash_original_method = "208FE04DEC7ECCEEFC5A47E5D08BA557", hash_generated_method = "D66C1FA281C66882385C19B833C0EE27")
    public Object getParm(String parmname) {
        addTaint(parmname.getTaint());
        Object obj = uriParms.getValue(parmname);
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_1479782272 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_1479782272.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_1479782272;
        // ---------- Original Method ----------
        //Object obj = uriParms.getValue(parmname);
        //return obj;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.280 -0400", hash_original_method = "DA8D1E67518AA478AB8C96314B0F321C", hash_generated_method = "F7C578C803F548587F29CFECCD0E8F5E")
    public String getMethod() {
String var1B3312612BAD48F52013E10EB1097F72_113901792 =         (String) getParm(METHOD);
        var1B3312612BAD48F52013E10EB1097F72_113901792.addTaint(taint);
        return var1B3312612BAD48F52013E10EB1097F72_113901792;
        // ---------- Original Method ----------
        //return (String) getParm(METHOD);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.280 -0400", hash_original_method = "5EDAD210CE239248A46B40B8A7E4E067", hash_generated_method = "0220F9E71DB366D259CE6507AEDCB169")
    public NameValueList getParameters() {
NameValueList var9389EB218FFD2B30D5D5B79C468DD3CD_1721741413 =         uriParms;
        var9389EB218FFD2B30D5D5B79C468DD3CD_1721741413.addTaint(taint);
        return var9389EB218FFD2B30D5D5B79C468DD3CD_1721741413;
        // ---------- Original Method ----------
        //return uriParms;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.280 -0400", hash_original_method = "F23607C60777A1A36911A6FE06B11E71", hash_generated_method = "4FF98F06B904C85601629D95CCCE2CC2")
    public void removeParameters() {
        this.uriParms = new NameValueList();
        // ---------- Original Method ----------
        //this.uriParms = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.281 -0400", hash_original_method = "69A77D050D6DE602ACFB758F18CE1C2E", hash_generated_method = "B7C719B7A9B23041E3A096B5E9774EB4")
    public NameValueList getQheaders() {
NameValueList var7CDA247EB3CC0EBDA5223EBFEFA7FB77_1616251810 =         qheaders;
        var7CDA247EB3CC0EBDA5223EBFEFA7FB77_1616251810.addTaint(taint);
        return var7CDA247EB3CC0EBDA5223EBFEFA7FB77_1616251810;
        // ---------- Original Method ----------
        //return qheaders;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.281 -0400", hash_original_method = "C4F4158359E9C3CE01C658AE1B903AEE", hash_generated_method = "99346018280A5AA5C4F2604FC5072D91")
    public String getUserType() {
String var13B4B8D28AC37068B9C1158BE11B7BD9_737461101 =         (String) uriParms.getValue(USER);
        var13B4B8D28AC37068B9C1158BE11B7BD9_737461101.addTaint(taint);
        return var13B4B8D28AC37068B9C1158BE11B7BD9_737461101;
        // ---------- Original Method ----------
        //return (String) uriParms.getValue(USER);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.282 -0400", hash_original_method = "F7BA3F65C36127DC85DBDC366FBE67EC", hash_generated_method = "409292CE9E74A5FCA8B43D713819452E")
    public String getUserPassword() {
    if(authority == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1020950919 =         null;
        var540C13E9E156B687226421B24F2DF178_1020950919.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1020950919;
        }
String varA538A2E3F096B83A4259C49C907D0D1F_472725699 =         authority.getPassword();
        varA538A2E3F096B83A4259C49C907D0D1F_472725699.addTaint(taint);
        return varA538A2E3F096B83A4259C49C907D0D1F_472725699;
        // ---------- Original Method ----------
        //if (authority == null)
            //return null;
        //return authority.getPassword();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.283 -0400", hash_original_method = "EB4E37E6319716C20DB55C1D8565711A", hash_generated_method = "305069BA63292E94235BF915303389CF")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.283 -0400", hash_original_method = "FBB7E1AC9741B23BB5B3EA84041A8793", hash_generated_method = "E867D1091E2578CD5CFCC46AF23B1E0C")
    public TelephoneNumber getTelephoneSubscriber() {
    if(telephoneSubscriber == null)        
        {
            telephoneSubscriber = new TelephoneNumber();
        } //End block
TelephoneNumber var3A51A0F2BD41089649E42A7CD484346C_443576050 =         telephoneSubscriber;
        var3A51A0F2BD41089649E42A7CD484346C_443576050.addTaint(taint);
        return var3A51A0F2BD41089649E42A7CD484346C_443576050;
        // ---------- Original Method ----------
        //if (telephoneSubscriber == null) {
            //telephoneSubscriber = new TelephoneNumber();
        //}
        //return telephoneSubscriber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.284 -0400", hash_original_method = "B2DE769DC5E0088684B143D456F129CF", hash_generated_method = "B4CBDE2FF71F0BBE1762DAA7683F880F")
    public HostPort getHostPort() {
    if(authority == null || authority.getHost() == null)        
        {
HostPort var540C13E9E156B687226421B24F2DF178_1407869934 =         null;
        var540C13E9E156B687226421B24F2DF178_1407869934.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1407869934;
        }
        else
        {
HostPort var78739834C43730B8FC5553B75C8085B7_118492760 =             authority.getHostPort();
            var78739834C43730B8FC5553B75C8085B7_118492760.addTaint(taint);
            return var78739834C43730B8FC5553B75C8085B7_118492760;
        } //End block
        // ---------- Original Method ----------
        //if (authority == null || authority.getHost() == null )
            //return null;
        //else {
            //return authority.getHostPort();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.284 -0400", hash_original_method = "7F780725D3A26A9FAAA917ED82465734", hash_generated_method = "618E335D6E708D2BFBEFE146B8B6080F")
    public int getPort() {
        HostPort hp = this.getHostPort();
    if(hp == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2129839240 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026933176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026933176;
        }
        int var2434D0703265A5BE0ED8CB0805D507F8_600731384 = (hp.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989968035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989968035;
        // ---------- Original Method ----------
        //HostPort hp = this.getHostPort();
        //if (hp == null)
            //return -1;
        //return hp.getPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.284 -0400", hash_original_method = "40B106F658B1B0B8AE55FF744395EB77", hash_generated_method = "150FE5802C1F3DB0F09EAB8D2D5B86A1")
    public String getHost() {
    if(authority == null)        
        {
String var540C13E9E156B687226421B24F2DF178_21947385 =         null;
        var540C13E9E156B687226421B24F2DF178_21947385.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_21947385;
        }
        else
    if(authority.getHost() == null)        
        {
String var540C13E9E156B687226421B24F2DF178_409314230 =         null;
        var540C13E9E156B687226421B24F2DF178_409314230.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_409314230;
        }
        else
        {
String varE1F15250491F87E8943C750256671D6A_813552208 =         authority.getHost().encode();
        varE1F15250491F87E8943C750256671D6A_813552208.addTaint(taint);
        return varE1F15250491F87E8943C750256671D6A_813552208;
        }
        // ---------- Original Method ----------
        //if ( authority == null) return null;
        //else if (authority.getHost() == null ) return null;
        //else return authority.getHost().encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.285 -0400", hash_original_method = "56CDDCF4149582CE88DAE7137BB51FB6", hash_generated_method = "9F1FF172F99E72FF2B042552BAC1F7F2")
    public boolean isUserTelephoneSubscriber() {
        String usrtype = (String) uriParms.getValue(USER);
    if(usrtype == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1694724853 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824102954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824102954;
        }
        boolean varCF1F2D6D44F1EB428B4B69D9473041E3_1577415767 = (usrtype.equalsIgnoreCase(PHONE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400651087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400651087;
        // ---------- Original Method ----------
        //String usrtype = (String) uriParms.getValue(USER);
        //if (usrtype == null)
            //return false;
        //return usrtype.equalsIgnoreCase(PHONE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.285 -0400", hash_original_method = "31B2EAABC2E978FD5373BC4C4C4BC54F", hash_generated_method = "EF73F28866869BC6C83E6BEFFB8E82C6")
    public void removeTTL() {
    if(uriParms != null)        
        uriParms.delete(TTL);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TTL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.285 -0400", hash_original_method = "26682CE55BB39CA926871319A4C06C7F", hash_generated_method = "8A952D3687D2CF17869A5717861C8299")
    public void removeMAddr() {
    if(uriParms != null)        
        uriParms.delete(MADDR);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(MADDR);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.286 -0400", hash_original_method = "17C4DDD354C5E051E7720776FDB1621B", hash_generated_method = "6F415C8392AF3B3BFCDF8F62E49829CE")
    public void removeTransport() {
    if(uriParms != null)        
        uriParms.delete(TRANSPORT);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(TRANSPORT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.286 -0400", hash_original_method = "3200AD1B535820580583A49AC076B7CA", hash_generated_method = "AEC66D5A870E4B5E8003707BE0873F49")
    public void removeHeader(String name) {
        addTaint(name.getTaint());
    if(qheaders != null)        
        qheaders.delete(name);
        // ---------- Original Method ----------
        //if (qheaders != null)
            //qheaders.delete(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.286 -0400", hash_original_method = "69EBEDDBEBD5610928D56ADB554A973E", hash_generated_method = "E903C32C0E8700933F47690CE9D407A7")
    public void removeHeaders() {
        qheaders = new NameValueList();
        // ---------- Original Method ----------
        //qheaders = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.286 -0400", hash_original_method = "4C60E3731E2F1A6A961C2EAF6730B8EA", hash_generated_method = "A86E4B7A4678B63B4EFED99FCA235A51")
    public void removeUserType() {
    if(uriParms != null)        
        uriParms.delete(USER);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(USER);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.287 -0400", hash_original_method = "A557BD8F16E39F3D746BC7787E72C291", hash_generated_method = "293540653E3C979EF343913001576563")
    public void removePort() {
        authority.removePort();
        // ---------- Original Method ----------
        //authority.removePort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.287 -0400", hash_original_method = "80293F715FFD7AE029130C857C03E1EB", hash_generated_method = "E6C83B17137B22C53FC0208B6F6C7233")
    public void removeMethod() {
    if(uriParms != null)        
        uriParms.delete(METHOD);
        // ---------- Original Method ----------
        //if (uriParms != null)
            //uriParms.delete(METHOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.287 -0400", hash_original_method = "8653C52476DAA9902FEC7B8799779AA0", hash_generated_method = "612DB2F05990B720BE28472E9052A1DD")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.288 -0400", hash_original_method = "D79A18951B63A09462A96884D78AF17C", hash_generated_method = "4E243F3AE992330B75CE9FFE82B2DA90")
    public void removeUser() {
        this.authority.removeUserInfo();
        // ---------- Original Method ----------
        //this.authority.removeUserInfo();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.288 -0400", hash_original_method = "29256DC0D79112DA6F3456FF1FC7A4DA", hash_generated_method = "FEE8F35FE589FC57B2D783EF07218E03")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.288 -0400", hash_original_method = "8155A130BB5ECD11F95AAB0DA6526B6B", hash_generated_method = "17C5E94A9E6A70133A97A70EC4723660")
    public void setAuthority(Authority authority) {
        this.authority = authority;
        // ---------- Original Method ----------
        //this.authority = authority;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.289 -0400", hash_original_method = "448F841326C9DE5F0C1061A977ECCF57", hash_generated_method = "0DA7F5B6DFDB4A2D1A673016AD597D19")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.289 -0400", hash_original_method = "BF30B120DCA846B2AB31EE4276940CB4", hash_generated_method = "C12913C3D366050264426BFF362BC735")
    public void setUriParms(NameValueList parms) {
        uriParms = parms;
        // ---------- Original Method ----------
        //uriParms = parms;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.290 -0400", hash_original_method = "B486DF9BA471DAAE60D8533B7C47A65D", hash_generated_method = "9DE6C9050263AE0304867C6A0119C317")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.290 -0400", hash_original_method = "3BCF6EC7FF3BBA5809384A38F15B6A45", hash_generated_method = "2E952D0669523402C7D8C7BA5EACD080")
    public void setQheaders(NameValueList parms) {
        qheaders = parms;
        // ---------- Original Method ----------
        //qheaders = parms;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.291 -0400", hash_original_method = "5C181333E4641A8C388789644A11AD43", hash_generated_method = "60898F7DE5CF83E561E57CC1B16D511D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.292 -0400", hash_original_method = "FBDBB9DDA2030458399AB3B5F3F4F0C6", hash_generated_method = "1AA95D1226AC15143412C988EA21B340")
    public void setUserParam(String usertype) {
        addTaint(usertype.getTaint());
        uriParms.set(USER, usertype);
        // ---------- Original Method ----------
        //uriParms.set(USER, usertype);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.292 -0400", hash_original_method = "4C629B888B40F45F11F6D780770DFFA5", hash_generated_method = "ACD0645156A22345F93CD0622E586D91")
    public void setMethod(String method) {
        addTaint(method.getTaint());
        uriParms.set(METHOD, method);
        // ---------- Original Method ----------
        //uriParms.set(METHOD, method);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.293 -0400", hash_original_method = "E57262682E1156419367692D3CFC45F4", hash_generated_method = "9C48536D30F078B5D6AB9DC14E7FC094")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.294 -0400", hash_original_method = "988EFE784E2C119D10B2A809CB388B9F", hash_generated_method = "BABA85DAD3AFF0C47B1D5E16AE852918")
    public void setTelephoneSubscriber(TelephoneNumber tel) {
        telephoneSubscriber = tel;
        // ---------- Original Method ----------
        //telephoneSubscriber = tel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.294 -0400", hash_original_method = "92A3A80BC1BE07F5BFACEB6CB4FB4561", hash_generated_method = "35C64C866131F8795A169947D55EEA00")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.294 -0400", hash_original_method = "6341E21CDA970E0B49B9800DCF1B5945", hash_generated_method = "28166B2D99610D79DBE507F0A5EF2314")
    public boolean hasParameter(String name) {
        addTaint(name.getTaint());
        boolean var95ADD3D3308931E73D8E7597CB38D166_217430074 = (uriParms.getValue(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754745343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754745343;
        // ---------- Original Method ----------
        //return uriParms.getValue(name) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.295 -0400", hash_original_method = "93D043490BF44801AA76F19310D9D034", hash_generated_method = "1BFDF69835D055D726277D8F6FA45D79")
    public void setQHeader(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.qheaders.set(nameValue);
        // ---------- Original Method ----------
        //this.qheaders.set(nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.295 -0400", hash_original_method = "CF8B8270AAB7EE0DBD09C8A6E6FE77D2", hash_generated_method = "E642A8566205961C710E2E5582C8A9E6")
    public void setUriParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.uriParms.set(nameValue);
        // ---------- Original Method ----------
        //this.uriParms.set(nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.296 -0400", hash_original_method = "79BAB25129164A5068BFAB9AA7EFB4C6", hash_generated_method = "A0081EAD13DEA7BFAC4FCA033907F1D8")
    public boolean hasTransport() {
        boolean var63D62AFBFD62FEB78ACAAAFDDB8E558E_1910859440 = (hasParameter(TRANSPORT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826955033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826955033;
        // ---------- Original Method ----------
        //return hasParameter(TRANSPORT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.296 -0400", hash_original_method = "80DDF5AC1394722FFD3DB956063197F8", hash_generated_method = "BFA2101A01062FEB2510250DE5BBB1DA")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        uriParms.delete(name);
        // ---------- Original Method ----------
        //uriParms.delete(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.296 -0400", hash_original_method = "C8CB16861890EEF599D006A2C41B9058", hash_generated_method = "443E8EFD54A131F34387F51E05BC922A")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.297 -0400", hash_original_method = "4FA40F4F8EA124691CF5F7EB5079802B", hash_generated_method = "C1F0B89C6A5CE10968172D1812788FBC")
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
Object varF9E19AD6135C970F387F77C6F3DE4477_850204660 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_850204660.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_850204660;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.298 -0400", hash_original_method = "D620A31F761EF988C6C51AF3A40C0F6E", hash_generated_method = "77B51F77E8814D3B2F12C6CF11AE7F0C")
    public String getHeader(String name) {
        addTaint(name.getTaint());
String var77CCD6F79AF45E9EA4EBFE393708AD56_1878154530 =         this.qheaders.getValue(name) != null
            ? this.qheaders.getValue(name).toString()
            : null;
        var77CCD6F79AF45E9EA4EBFE393708AD56_1878154530.addTaint(taint);
        return var77CCD6F79AF45E9EA4EBFE393708AD56_1878154530;
        // ---------- Original Method ----------
        //return this.qheaders.getValue(name) != null
            //? this.qheaders.getValue(name).toString()
            //: null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.298 -0400", hash_original_method = "4530375C3CFB28EF39A61BC561477425", hash_generated_method = "B9092F487D39B991AAD61E06BAFECCA3")
    public Iterator<String> getHeaderNames() {
Iterator<String> var6E634D49D350130112693F1E9A8BF224_1866048136 =         this.qheaders.getNames();
        var6E634D49D350130112693F1E9A8BF224_1866048136.addTaint(taint);
        return var6E634D49D350130112693F1E9A8BF224_1866048136;
        // ---------- Original Method ----------
        //return this.qheaders.getNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.298 -0400", hash_original_method = "3F7D698AA93119CDF4AD07DDC087B33E", hash_generated_method = "A180285D1063E77639C7F8CD119E10F6")
    public String getLrParam() {
        boolean haslr = this.hasParameter(LR);
String varBEE9408018F3F983A14BD69629A7C528_897054085 =         haslr ? "true" : null;
        varBEE9408018F3F983A14BD69629A7C528_897054085.addTaint(taint);
        return varBEE9408018F3F983A14BD69629A7C528_897054085;
        // ---------- Original Method ----------
        //boolean haslr = this.hasParameter(LR);
        //return haslr ? "true" : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.299 -0400", hash_original_method = "8D33CC87FEAA658432B140BA930B3AED", hash_generated_method = "CA4FD7D5A060FDCFDE68968461CA25E3")
    public String getMAddrParam() {
        NameValue maddr = uriParms.getNameValue(MADDR);
    if(maddr == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1304401360 =         null;
        var540C13E9E156B687226421B24F2DF178_1304401360.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1304401360;
        }
        String host = (String) maddr.getValueAsObject();
String var872E07117C05F1A34EC24B57B694B8E3_1793189494 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1793189494.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1793189494;
        // ---------- Original Method ----------
        //NameValue maddr = uriParms.getNameValue(MADDR);
        //if (maddr == null)
            //return null;
        //String host = (String) maddr.getValueAsObject();
        //return host;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.300 -0400", hash_original_method = "B0014A6E847FE8E425D38FE4F75F3375", hash_generated_method = "529EB79D797447F0C0FA6EA6C35ADDA1")
    public String getMethodParam() {
String var008D3B6AD38B55A60987B086F7309F9E_1524591911 =         this.getParameter(METHOD);
        var008D3B6AD38B55A60987B086F7309F9E_1524591911.addTaint(taint);
        return var008D3B6AD38B55A60987B086F7309F9E_1524591911;
        // ---------- Original Method ----------
        //return this.getParameter(METHOD);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.300 -0400", hash_original_method = "B72E21D53820BAFF3F91285B817E8F6B", hash_generated_method = "2081673242C4DFB5D133DE2D22516285")
    public String getParameter(String name) {
        addTaint(name.getTaint());
        Object val = uriParms.getValue(name);
    if(val == null)        
        {
String var540C13E9E156B687226421B24F2DF178_282107966 =         null;
        var540C13E9E156B687226421B24F2DF178_282107966.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_282107966;
        }
    if(val instanceof GenericObject)        
        {
String varF1B6C72F38290E3B9280610078FC772A_1427407248 =         ((GenericObject) val).encode();
        varF1B6C72F38290E3B9280610078FC772A_1427407248.addTaint(taint);
        return varF1B6C72F38290E3B9280610078FC772A_1427407248;
        }
        else
        {
String var38570108501B3BE2AC163FA564B07985_280262177 =         val.toString();
        var38570108501B3BE2AC163FA564B07985_280262177.addTaint(taint);
        return var38570108501B3BE2AC163FA564B07985_280262177;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.301 -0400", hash_original_method = "6E1DB232C6AA1FEC4050F87B0DECFBEC", hash_generated_method = "E248EAA22A290A8A679909020E431835")
    public Iterator<String> getParameterNames() {
Iterator<String> varE900FF3BB904BD053F2C311296F497B6_908746801 =         this.uriParms.getNames();
        varE900FF3BB904BD053F2C311296F497B6_908746801.addTaint(taint);
        return varE900FF3BB904BD053F2C311296F497B6_908746801;
        // ---------- Original Method ----------
        //return this.uriParms.getNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.302 -0400", hash_original_method = "EE7A560BCE3AD39DE27697785FE9A0B4", hash_generated_method = "B48BD4EB10BCA58D73F9C1D8AC69D803")
    public int getTTLParam() {
        Integer ttl = (Integer) uriParms.getValue("ttl");
    if(ttl != null)        
        {
        int var6B00E161F829F9444EDBCA4D09949744_302918394 = (ttl.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300934295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300934295;
        }
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_241833782 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793325213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793325213;
        }
        // ---------- Original Method ----------
        //Integer ttl = (Integer) uriParms.getValue("ttl");
        //if (ttl != null)
            //return ttl.intValue();
        //else
            //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.302 -0400", hash_original_method = "D0FE42FB772BF560666581278B9E7996", hash_generated_method = "5080E3C3EDB555A9F761D6A5290BD3D3")
    public String getTransportParam() {
    if(uriParms != null)        
        {
String var06508F4F1791775F880FF28C12B26147_90451144 =             (String) uriParms.getValue(TRANSPORT);
            var06508F4F1791775F880FF28C12B26147_90451144.addTaint(taint);
            return var06508F4F1791775F880FF28C12B26147_90451144;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_2036765745 =         null;
        var540C13E9E156B687226421B24F2DF178_2036765745.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2036765745;
        }
        // ---------- Original Method ----------
        //if (uriParms != null) {
            //return (String) uriParms.getValue(TRANSPORT);
        //} else
            //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.303 -0400", hash_original_method = "3B107DCD343091F4FCEB3378B44D2024", hash_generated_method = "00663535846DDADAC212FDA5D3DA15E4")
    public String getUser() {
String varB766A224519300F0F3A9053E67C813E9_515843691 =         authority.getUser();
        varB766A224519300F0F3A9053E67C813E9_515843691.addTaint(taint);
        return varB766A224519300F0F3A9053E67C813E9_515843691;
        // ---------- Original Method ----------
        //return authority.getUser();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.303 -0400", hash_original_method = "5246336FD52DFE5F131EDCED707C7332", hash_generated_method = "6861184005585B927DCE57B7A83B6CC6")
    public boolean isSecure() {
        boolean var0A0D0813B8B007BF2B2D88502D868F53_1282170146 = (this.getScheme().equalsIgnoreCase(SIPS));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011277253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011277253;
        // ---------- Original Method ----------
        //return this.getScheme().equalsIgnoreCase(SIPS);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.304 -0400", hash_original_method = "56D579416E6E52BEF406E20E9865D4C4", hash_generated_method = "0E5654405358F89771D4514E018790EE")
    public boolean isSipURI() {
        boolean varB326B5062B2F0E69046810717534CB09_417201114 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709341291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709341291;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.304 -0400", hash_original_method = "DE18AAB14C75B00C0640CE3E9515471C", hash_generated_method = "CBA7E516500BC2D190133145B1FF891D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.304 -0400", hash_original_method = "8BEE64CFFA20AF8C2536A2ECB59F51EE", hash_generated_method = "EE34760D6792C0DB211E87BD94986292")
    public void setHost(String host) throws ParseException {
        addTaint(host.getTaint());
        Host h = new Host(host);
        this.setHost(h);
        // ---------- Original Method ----------
        //Host h = new Host(host);
        //this.setHost(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.305 -0400", hash_original_method = "DD9F3D6DD0A955FE88B26C596147A545", hash_generated_method = "FFD1D37F482D6599B51331C19EAD3783")
    public void setLrParam() {
        this.uriParms.set("lr",null);
        // ---------- Original Method ----------
        //this.uriParms.set("lr",null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.305 -0400", hash_original_method = "E9B55C57ECC7FC0F2DF8B4804D377AFB", hash_generated_method = "047EE40838050192BC1ECC9F73A51608")
    public void setMAddrParam(String maddr) throws ParseException {
        addTaint(maddr.getTaint());
    if(maddr == null)        
        {
        NullPointerException var2EB73F285C4EA4484DD188D3410363E8_92775057 = new NullPointerException("bad maddr");
        var2EB73F285C4EA4484DD188D3410363E8_92775057.addTaint(taint);
        throw var2EB73F285C4EA4484DD188D3410363E8_92775057;
        }
        setParameter("maddr", maddr);
        // ---------- Original Method ----------
        //if (maddr == null)
            //throw new NullPointerException("bad maddr");
        //setParameter("maddr", maddr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.305 -0400", hash_original_method = "378F5AA5131E869E77C4B19F60BAAC21", hash_generated_method = "F2DB4E76AB69228785A5D10D7CA28EFA")
    public void setMethodParam(String method) throws ParseException {
        addTaint(method.getTaint());
        setParameter("method", method);
        // ---------- Original Method ----------
        //setParameter("method", method);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.306 -0400", hash_original_method = "B29E45FE1B913173FAF4035EBB51958B", hash_generated_method = "C1D47FD3C342DD70F692492BFF7D3446")
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
                ParseException varEE648CDED79B3B6A98DB488DFC5FC3CF_2048354959 = new ParseException("bad parameter " + value, 0);
                varEE648CDED79B3B6A98DB488DFC5FC3CF_2048354959.addTaint(taint);
                throw varEE648CDED79B3B6A98DB488DFC5FC3CF_2048354959;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.306 -0400", hash_original_method = "93EA8C8ECDAC523AC50E68B355F469C8", hash_generated_method = "B49E07412AC75A9BCAAA2DEE1B70F25C")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.307 -0400", hash_original_method = "8785DA0B69A8C30F98EFE6C5EB1879AC", hash_generated_method = "D4ACEE7C131735FC6251FCD51BA57382")
    public void setTTLParam(int ttl) {
        addTaint(ttl);
    if(ttl <= 0)        
        {
        IllegalArgumentException varEA2B86C95CCDE96B32C43EDE30655D72_1715346162 = new IllegalArgumentException("Bad ttl value");
        varEA2B86C95CCDE96B32C43EDE30655D72_1715346162.addTaint(taint);
        throw varEA2B86C95CCDE96B32C43EDE30655D72_1715346162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.307 -0400", hash_original_method = "D4B3823C982965112DA168F305C25048", hash_generated_method = "A0864FE96491D74E92F0E3FA03FE34B1")
    public void setTransportParam(String transport) throws ParseException {
        addTaint(transport.getTaint());
    if(transport == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_411248405 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_411248405.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_411248405;
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
        ParseException varCE19B354336813EFA8C17F03B48DDE40_1810041951 = new ParseException("bad transport " + transport, 0);
        varCE19B354336813EFA8C17F03B48DDE40_1810041951.addTaint(taint);
        throw varCE19B354336813EFA8C17F03B48DDE40_1810041951;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.307 -0400", hash_original_method = "1E6ECA3F7C52B01B50446520797B0E33", hash_generated_method = "C5599866699D681A2978ADA8AB974D79")
    public String getUserParam() {
String varB34BE6EB9BFD3B21D4824A13D09FD46C_1925710045 =         getParameter("user");
        varB34BE6EB9BFD3B21D4824A13D09FD46C_1925710045.addTaint(taint);
        return varB34BE6EB9BFD3B21D4824A13D09FD46C_1925710045;
        // ---------- Original Method ----------
        //return getParameter("user");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.308 -0400", hash_original_method = "23F3E2D78AEB517CE17DC4369118F50D", hash_generated_method = "C0E85320B79C8C049FA88B3CDA875381")
    public boolean hasLrParam() {
        boolean varCF7A45E5A550B9334314361D8E2B5B2D_169581697 = (uriParms.getNameValue("lr") != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_828745055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_828745055;
        // ---------- Original Method ----------
        //return uriParms.getNameValue("lr") != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.308 -0400", hash_original_method = "BF370972F662FF42728C27309BA84910", hash_generated_method = "7A5B7B20E96146696C30A6BF29ED4ED4")
    public boolean hasGrParam() {
        boolean var22A521DD7FE9C23EF30C36DD35B54A9C_1436551458 = (uriParms.getNameValue(GRUU) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547915740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547915740;
        // ---------- Original Method ----------
        //return uriParms.getNameValue(GRUU) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.344 -0400", hash_original_method = "80955EE8A827F28D322398606EB833AF", hash_generated_method = "F4FB5BB1B9EFF549F47CE8961D054B09")
    public void setGrParam(String value) {
        addTaint(value.getTaint());
        this.uriParms.set(GRUU, value);
        // ---------- Original Method ----------
        //this.uriParms.set(GRUU, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.344 -0400", hash_original_method = "215DF01DBB1883D8F30CF584508D27CC", hash_generated_method = "99DC9379B090433E43DD5CD778BD9AD9")
    public String getGrParam() {
String var16DF91DFF27559DC8E701100F9E8B5CE_1136596353 =         (String) this.uriParms.getValue(GRUU);
        var16DF91DFF27559DC8E701100F9E8B5CE_1136596353.addTaint(taint);
        return var16DF91DFF27559DC8E701100F9E8B5CE_1136596353;
        // ---------- Original Method ----------
        //return (String) this.uriParms.getValue(GRUU);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.345 -0400", hash_original_field = "FBC6DFE7D1C3D17A206CDAE04B65C0AA", hash_generated_field = "2F69FD556F8E9767DDE2D2177EBF6C40")

    private static final long serialVersionUID = 7749781076218987044L;
}

