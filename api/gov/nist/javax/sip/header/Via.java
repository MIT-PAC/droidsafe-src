package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.stack.HopImpl;
import javax.sip.InvalidArgumentException;
import javax.sip.address.Hop;
import javax.sip.header.ViaHeader;
import java.text.ParseException;

public class Via extends ParametersHeader implements javax.sip.header.ViaHeader, ViaHeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.614 -0400", hash_original_field = "610A766B3E0567396106CE73CA862AB1", hash_generated_field = "5B51F01BA670CB6A7B4E1A02DEB8A619")

    protected Protocol sentProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.615 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "0B1CBB926459AD49C5AAB0F0CD26CCCF")

    protected HostPort sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.615 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.615 -0400", hash_original_field = "53C8339148B638BBC1C40E3CA26CBA08", hash_generated_field = "2352712DCFC5BA30D0234B4D1AC22071")

    private boolean rPortFlag = false;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.615 -0400", hash_original_method = "7D07E05C0BEE96603D98F8B1E7A2E317", hash_generated_method = "05BCC6515CD84F16CEE1E054ED6F0504")
    public  Via() {
        super(NAME);
        sentProtocol = new Protocol();
        // ---------- Original Method ----------
        //sentProtocol = new Protocol();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.616 -0400", hash_original_method = "6B6D36FD3A79EE403682FF6F25A822A5", hash_generated_method = "DB2C65FD095E7438BE75E0EF382D8EF8")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other==this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_692052844 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904171855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904171855;
        }
    if(other instanceof ViaHeader)        
        {
            final ViaHeader o = (ViaHeader) other;
            boolean var0CA2D156F16A33AF97CFF7D9D8988B5B_2012070594 = (getProtocol().equalsIgnoreCase( o.getProtocol() )
                && getTransport().equalsIgnoreCase( o.getTransport() )
                && getHost().equalsIgnoreCase( o.getHost() )
                && getPort() == o.getPort()
                && equalParameters( o ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267057288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267057288;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_135639967 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567795769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567795769;
        // ---------- Original Method ----------
        //if (other==this) return true;
        //if (other instanceof ViaHeader) {
            //final ViaHeader o = (ViaHeader) other;
            //return getProtocol().equalsIgnoreCase( o.getProtocol() )
                //&& getTransport().equalsIgnoreCase( o.getTransport() )
                //&& getHost().equalsIgnoreCase( o.getHost() )
                //&& getPort() == o.getPort()
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.617 -0400", hash_original_method = "F03A2761E3B9AF6DF371EC359829DB1F", hash_generated_method = "7153F8A2CA39312273F7F342EB242C48")
    public String getProtocolVersion() {
    if(sentProtocol == null)        
        {
String var540C13E9E156B687226421B24F2DF178_544755801 =         null;
        var540C13E9E156B687226421B24F2DF178_544755801.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_544755801;
        }
        else
        {
String var505B13876BB7CD8660BEDE49C5EB5211_477123595 =         sentProtocol.getProtocolVersion();
        var505B13876BB7CD8660BEDE49C5EB5211_477123595.addTaint(taint);
        return var505B13876BB7CD8660BEDE49C5EB5211_477123595;
        }
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //else
            //return sentProtocol.getProtocolVersion();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.617 -0400", hash_original_method = "07C91BB13E357235D0646F9B1302A813", hash_generated_method = "1AD34AB8AEAB7867CE763BA9E9A2AE90")
    public Protocol getSentProtocol() {
Protocol var9D4561C36AE0432AEB20F790E858EE37_2019413824 =         sentProtocol;
        var9D4561C36AE0432AEB20F790E858EE37_2019413824.addTaint(taint);
        return var9D4561C36AE0432AEB20F790E858EE37_2019413824;
        // ---------- Original Method ----------
        //return sentProtocol;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.617 -0400", hash_original_method = "834E4BBD7298D05AE3719FD543779099", hash_generated_method = "2BB438E030C1DA4835AEB72B02D4C455")
    public HostPort getSentBy() {
HostPort var35EEFCD5058EE5760A269A485D13D2CB_1016978995 =         sentBy;
        var35EEFCD5058EE5760A269A485D13D2CB_1016978995.addTaint(taint);
        return var35EEFCD5058EE5760A269A485D13D2CB_1016978995;
        // ---------- Original Method ----------
        //return sentBy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.618 -0400", hash_original_method = "D671032CD8E13BB36667C287933AFA1D", hash_generated_method = "DF24B82B6576F8ED93301A77EC10B124")
    public Hop getHop() {
        HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                sentBy.getPort(),sentProtocol.getTransport());
Hop varCF598A87F121766CA237EE82036D5763_1542971951 =         hop;
        varCF598A87F121766CA237EE82036D5763_1542971951.addTaint(taint);
        return varCF598A87F121766CA237EE82036D5763_1542971951;
        // ---------- Original Method ----------
        //HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                //sentBy.getPort(),sentProtocol.getTransport());
        //return hop;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.618 -0400", hash_original_method = "50080B5B5AC1614DCB7B006B51F53E3F", hash_generated_method = "ED1BCE691E489E201619A7B33DD43871")
    public NameValueList getViaParms() {
NameValueList var3CB0A38B794BDEDADB1F50256E0AE35B_779907554 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_779907554.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_779907554;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.618 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "86D72AD3BB869038184AED3B9A752822")
    public String getComment() {
String var20FC6A677850B0D1A8135B6A0BB12A1F_1589371683 =         comment;
        var20FC6A677850B0D1A8135B6A0BB12A1F_1589371683.addTaint(taint);
        return var20FC6A677850B0D1A8135B6A0BB12A1F_1589371683;
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.618 -0400", hash_original_method = "60E8CE9FCECD3622E03D9910A9625801", hash_generated_method = "FF266450A55B1A0EC3809425865D6BD0")
    public boolean hasPort() {
        boolean var31A6535678119DC18E99965FEF9FF16B_1628740817 = ((getSentBy()).hasPort());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600581419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600581419;
        // ---------- Original Method ----------
        //return (getSentBy()).hasPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.619 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "CE03AFF30170E5000DA697A485DAB411")
    public boolean hasComment() {
        boolean varE97A402AF2F516ADC47A295F69DB4C37_1138009257 = (comment != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663718213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663718213;
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.619 -0400", hash_original_method = "944AB7146038DECB09A155E81BB22663", hash_generated_method = "79CD3AAB4B019027F3580A1A1672D020")
    public void removePort() {
        sentBy.removePort();
        // ---------- Original Method ----------
        //sentBy.removePort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.620 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.620 -0400", hash_original_method = "EAF98E914AE1C4A3745B20F70C227AC7", hash_generated_method = "0FC961F517088BD610BF32CCCF197355")
    public void setProtocolVersion(String protocolVersion) {
        addTaint(protocolVersion.getTaint());
    if(sentProtocol == null)        
        sentProtocol = new Protocol();
        sentProtocol.setProtocolVersion(protocolVersion);
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocolVersion(protocolVersion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.621 -0400", hash_original_method = "DC556AA065BEAF9D4C2B976D57E39DA8", hash_generated_method = "3D94784F5EBA63D6281DF1412C27AA50")
    public void setHost(Host host) {
        addTaint(host.getTaint());
    if(sentBy == null)        
        {
            sentBy = new HostPort();
        } //End block
        sentBy.setHost(host);
        // ---------- Original Method ----------
        //if (sentBy == null) {
            //sentBy = new HostPort();
        //}
        //sentBy.setHost(host);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.622 -0400", hash_original_method = "F4FB101A445D5E49EE8B10DCE47E32FC", hash_generated_method = "5256462B357CC08BC06E273F7E8B63C4")
    public void setSentProtocol(Protocol s) {
        sentProtocol = s;
        // ---------- Original Method ----------
        //sentProtocol = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.622 -0400", hash_original_method = "543B4EA18E4F8858630BB59B262697DA", hash_generated_method = "63DB9B02D21F6151DDBE43BA55FA92E9")
    public void setSentBy(HostPort s) {
        sentBy = s;
        // ---------- Original Method ----------
        //sentBy = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.623 -0400", hash_original_method = "DE8908B9CA5447E854A0D06D0B1B9195", hash_generated_method = "23ECBD58C40560F298AA32A25976DB82")
    public void setComment(String c) {
        comment = c;
        // ---------- Original Method ----------
        //comment = c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.623 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BE522D6A069BAA4687A5768A55D3E040")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1123753188 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1123753188.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1123753188;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.624 -0400", hash_original_method = "C937D3FA4F8C32F6B76B74CD5C9B4805", hash_generated_method = "FDD4313A795F7DBE02896B28413C0028")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        sentProtocol.encode(buffer);
        buffer.append(SP);
        sentBy.encode(buffer);
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
    if(comment != null)        
        {
            buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        } //End block
    if(rPortFlag)        
        buffer.append(";rport");
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_806187957 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_806187957.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_806187957;
        // ---------- Original Method ----------
        //sentProtocol.encode(buffer);
        //buffer.append(SP);
        //sentBy.encode(buffer);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //if (comment != null) {
            //buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        //}
        //if (rPortFlag) buffer.append(";rport");
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.624 -0400", hash_original_method = "A6610C3C674AD8475435D641E21474E9", hash_generated_method = "70EC96B4311CA9B7E6D01EACAC06A964")
    public void setHost(String host) throws ParseException {
        addTaint(host.getTaint());
    if(sentBy == null)        
        sentBy = new HostPort();
        try 
        {
            Host h = new Host(host);
            sentBy.setHost(h);
        } //End block
        catch (Exception e)
        {
            NullPointerException var4DBB13729867D2C42BC1B31136201C3C_221408896 = new NullPointerException(" host parameter is null");
            var4DBB13729867D2C42BC1B31136201C3C_221408896.addTaint(taint);
            throw var4DBB13729867D2C42BC1B31136201C3C_221408896;
        } //End block
        // ---------- Original Method ----------
        //if (sentBy == null)
            //sentBy = new HostPort();
        //try {
            //Host h = new Host(host);
            //sentBy.setHost(h);
        //} catch (Exception e) {
            //throw new NullPointerException(" host parameter is null");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.625 -0400", hash_original_method = "C40590C8092ADD61F2FE2F813826D182", hash_generated_method = "6B64EC91878E2537E7C038751C44B006")
    public String getHost() {
    if(sentBy == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2074109600 =         null;
        var540C13E9E156B687226421B24F2DF178_2074109600.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2074109600;
        }
        else
        {
            Host host = sentBy.getHost();
    if(host == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1526954003 =             null;
            var540C13E9E156B687226421B24F2DF178_1526954003.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1526954003;
            }
            else
            {
String varD7AF899F7490F0961E1F5ED19DF8B6A4_1710712581 =             host.getHostname();
            varD7AF899F7490F0961E1F5ED19DF8B6A4_1710712581.addTaint(taint);
            return varD7AF899F7490F0961E1F5ED19DF8B6A4_1710712581;
            }
        } //End block
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return null;
        //else {
            //Host host = sentBy.getHost();
            //if (host == null)
                //return null;
            //else
                //return host.getHostname();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.625 -0400", hash_original_method = "3BFDF83597585B440A29B8E314A4320F", hash_generated_method = "1DF967E29DF670058676C4424AD04BC4")
    public void setPort(int port) throws InvalidArgumentException {
        addTaint(port);
    if(port!=-1 && (port<1 || port>65535))        
        {
            InvalidArgumentException varCA98E02F78AB6EAD4CAA625E2F17A7B6_1745841101 = new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
            varCA98E02F78AB6EAD4CAA625E2F17A7B6_1745841101.addTaint(taint);
            throw varCA98E02F78AB6EAD4CAA625E2F17A7B6_1745841101;
        } //End block
    if(sentBy == null)        
        sentBy = new HostPort();
        sentBy.setPort(port);
        // ---------- Original Method ----------
        //if ( port!=-1 && (port<1 || port>65535)) {
            //throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        //}
        //if (sentBy == null)
            //sentBy = new HostPort();
        //sentBy.setPort(port);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.626 -0400", hash_original_method = "524778E64DA2B969E2ED4D2BD7E92B55", hash_generated_method = "7B6A17B05EF5967791C55E81D8F72366")
    public void setRPort() {
        rPortFlag = true;
        // ---------- Original Method ----------
        //rPortFlag = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.626 -0400", hash_original_method = "E4A7E9B0C37CC00BF245A9AEF6038FD8", hash_generated_method = "D96EAF4FCBE5C64835FB905D68AB1AAF")
    public int getPort() {
    if(sentBy == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1623945449 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316647280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316647280;
        }
        int var6D909B34FB85D9F6DF01F203656B84DF_376408270 = (sentBy.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844226148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844226148;
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return -1;
        //return sentBy.getPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.626 -0400", hash_original_method = "8F51D2BD996E5077EFE382EF5CCB28F7", hash_generated_method = "A9E9E4C009B9A6FC5FE5F5CDDAE4F120")
    public int getRPort() {
        String strRport = getParameter(ParameterNames.RPORT);
    if(strRport != null && ! strRport.equals(""))        
        {
        int var5A4A7AA3BF3B61AA5D7CE9DB89244879_2085457475 = (Integer.valueOf(strRport).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099882565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099882565;
        }
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1980767978 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364848571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364848571;
        }
        // ---------- Original Method ----------
        //String strRport = getParameter(ParameterNames.RPORT);
        //if (strRport != null && ! strRport.equals(""))
            //return Integer.valueOf(strRport).intValue();
         //else
            //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.627 -0400", hash_original_method = "2C7D6CB162F307BBDEA3C529EA37600B", hash_generated_method = "EF38DD5EA48ACE628D5576941737B005")
    public String getTransport() {
    if(sentProtocol == null)        
        {
String var540C13E9E156B687226421B24F2DF178_234643286 =         null;
        var540C13E9E156B687226421B24F2DF178_234643286.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_234643286;
        }
String var672CCB2CF5D1564832066A1D15319102_1023493696 =         sentProtocol.getTransport();
        var672CCB2CF5D1564832066A1D15319102_1023493696.addTaint(taint);
        return var672CCB2CF5D1564832066A1D15319102_1023493696;
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.627 -0400", hash_original_method = "DA10FBD3B27193627F0BF00A97E141AB", hash_generated_method = "7A1B52EFDB7872DF3C14A0CC3365ED48")
    public void setTransport(String transport) throws ParseException {
        addTaint(transport.getTaint());
    if(transport == null)        
        {
        NullPointerException var84370065E6F91547A22B7704824C9F52_181527299 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setTransport(), the transport parameter is null.");
        var84370065E6F91547A22B7704824C9F52_181527299.addTaint(taint);
        throw var84370065E6F91547A22B7704824C9F52_181527299;
        }
    if(sentProtocol == null)        
        sentProtocol = new Protocol();
        sentProtocol.setTransport(transport);
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setTransport(), the transport parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setTransport(transport);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.628 -0400", hash_original_method = "076253ECD4074E0CF94E6CAE84ACD031", hash_generated_method = "D13DC909B6119586F39AB62FE90E3B85")
    public String getProtocol() {
    if(sentProtocol == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1294451375 =         null;
        var540C13E9E156B687226421B24F2DF178_1294451375.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1294451375;
        }
String var4FF5522CA14AB124C62113BDA3B2D3C5_1478935028 =         sentProtocol.getProtocol();
        var4FF5522CA14AB124C62113BDA3B2D3C5_1478935028.addTaint(taint);
        return var4FF5522CA14AB124C62113BDA3B2D3C5_1478935028;
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getProtocol();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.629 -0400", hash_original_method = "983A1DB4807CBA4F5F74F526664C05F9", hash_generated_method = "C11B80733C49AFDE0D086B096443DFC2")
    public void setProtocol(String protocol) throws ParseException {
        addTaint(protocol.getTaint());
    if(protocol == null)        
        {
        NullPointerException var9F319EB84991D5C07B35E89300368299_45507792 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setProtocol(), the protocol parameter is null.");
        var9F319EB84991D5C07B35E89300368299_45507792.addTaint(taint);
        throw var9F319EB84991D5C07B35E89300368299_45507792;
        }
    if(sentProtocol == null)        
        sentProtocol = new Protocol();
        sentProtocol.setProtocol(protocol);
        // ---------- Original Method ----------
        //if (protocol == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setProtocol(), the protocol parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocol(protocol);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.629 -0400", hash_original_method = "AB2BF7863E6929FA549276BF1FCB8F41", hash_generated_method = "5F72A2E762664C4C8F60CEEA6CDD567E")
    public int getTTL() {
        int ttl = getParameterAsInt(ParameterNames.TTL);
        int varC431A4425BC56080C868435C8D910F83_1339877484 = (ttl);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036915611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036915611;
        // ---------- Original Method ----------
        //int ttl = getParameterAsInt(ParameterNames.TTL);
        //return ttl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.630 -0400", hash_original_method = "275C0FDDD82C74D9D06FF2EBDF31F802", hash_generated_method = "1384884EFDCA6BFA9593AF7FD613C41B")
    public void setTTL(int ttl) throws InvalidArgumentException {
        addTaint(ttl);
    if(ttl < 0 && ttl != -1)        
        {
        InvalidArgumentException var94583BA7443F2DDBCC0B8D389D3941B7_1445810097 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", Via, setTTL(), the ttl parameter is < 0");
        var94583BA7443F2DDBCC0B8D389D3941B7_1445810097.addTaint(taint);
        throw var94583BA7443F2DDBCC0B8D389D3941B7_1445810097;
        }
        setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
        // ---------- Original Method ----------
        //if (ttl < 0 && ttl != -1)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", Via, setTTL(), the ttl parameter is < 0");
        //setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.630 -0400", hash_original_method = "BA8497BF19C86E6498457C19F33C2BB1", hash_generated_method = "0B3FEBCAA0DB67EE62F7E3381C9FDD1C")
    public String getMAddr() {
String var263683D8C54210DA6F9BEB369F769CD4_1311745736 =         getParameter(ParameterNames.MADDR);
        var263683D8C54210DA6F9BEB369F769CD4_1311745736.addTaint(taint);
        return var263683D8C54210DA6F9BEB369F769CD4_1311745736;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.MADDR);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.630 -0400", hash_original_method = "6AB0C98EE8B2466C821195A9A73846A0", hash_generated_method = "A198AE941C082DA228D5920EE9D45F1B")
    public void setMAddr(String mAddr) throws ParseException {
        addTaint(mAddr.getTaint());
    if(mAddr == null)        
        {
        NullPointerException var4223FF9A4395D661CCBB3A80191E742A_834955622 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setMAddr(), the mAddr parameter is null.");
        var4223FF9A4395D661CCBB3A80191E742A_834955622.addTaint(taint);
        throw var4223FF9A4395D661CCBB3A80191E742A_834955622;
        }
        Host host = new Host();
        host.setAddress(mAddr);
        NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        setParameter(nameValue);
        // ---------- Original Method ----------
        //if (mAddr == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setMAddr(), the mAddr parameter is null.");
        //Host host = new Host();
        //host.setAddress(mAddr);
        //NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        //setParameter(nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.631 -0400", hash_original_method = "25AF7C33721E5D780684174C5845DEAD", hash_generated_method = "9E55E580FFAF53AE87431EAEA1B94C14")
    public String getReceived() {
String varC5797504D66622D5091EB38348E03560_954271969 =         getParameter(ParameterNames.RECEIVED);
        varC5797504D66622D5091EB38348E03560_954271969.addTaint(taint);
        return varC5797504D66622D5091EB38348E03560_954271969;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.RECEIVED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.631 -0400", hash_original_method = "F727BD69B2536BBCBA80253D70F95056", hash_generated_method = "966CEA66ED9E87987425A3AEA5E5584B")
    public void setReceived(String received) throws ParseException {
        addTaint(received.getTaint());
    if(received == null)        
        {
        NullPointerException var53F2F644A510B43A9F45AF762C4C2ECC_485228883 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setReceived(), the received parameter is null.");
        var53F2F644A510B43A9F45AF762C4C2ECC_485228883.addTaint(taint);
        throw var53F2F644A510B43A9F45AF762C4C2ECC_485228883;
        }
        setParameter(ParameterNames.RECEIVED, received);
        // ---------- Original Method ----------
        //if (received == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setReceived(), the received parameter is null.");
        //setParameter(ParameterNames.RECEIVED, received);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.631 -0400", hash_original_method = "9A958EF7B290CF5A27A4EB96F15158F0", hash_generated_method = "CEA4A15BA5A0954A099240C5DBD48D1C")
    public String getBranch() {
String var5A4516AB3A9CF1E9689C3940D299FD8B_854110881 =         getParameter(ParameterNames.BRANCH);
        var5A4516AB3A9CF1E9689C3940D299FD8B_854110881.addTaint(taint);
        return var5A4516AB3A9CF1E9689C3940D299FD8B_854110881;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.BRANCH);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.632 -0400", hash_original_method = "5A56F4FACEB17A95A8FCAD93BB83EA63", hash_generated_method = "3DA9CBB5F30D1300DCE821F4286D6AB5")
    public void setBranch(String branch) throws ParseException {
        addTaint(branch.getTaint());
    if(branch == null || branch.length()==0)        
        {
        NullPointerException var58473D87EA66098D648F42AF2E5719EE_175862814 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setBranch(), the branch parameter is null or length 0.");
        var58473D87EA66098D648F42AF2E5719EE_175862814.addTaint(taint);
        throw var58473D87EA66098D648F42AF2E5719EE_175862814;
        }
        setParameter(ParameterNames.BRANCH, branch);
        // ---------- Original Method ----------
        //if (branch == null || branch.length()==0)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setBranch(), the branch parameter is null or length 0.");
        //setParameter(ParameterNames.BRANCH, branch);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.632 -0400", hash_original_method = "252C53006150044E4EBAAC8A002E65B1", hash_generated_method = "43C6927446314157E8902030FA68658D")
    public Object clone() {
        Via retval = (Via) super.clone();
    if(this.sentProtocol != null)        
        retval.sentProtocol = (Protocol) this.sentProtocol.clone();
    if(this.sentBy != null)        
        retval.sentBy = (HostPort) this.sentBy.clone();
    if(this.getRPort() != -1)        
        retval.setParameter(RPORT,this.getRPort());
Object varF9E19AD6135C970F387F77C6F3DE4477_847796583 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_847796583.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_847796583;
        // ---------- Original Method ----------
        //Via retval = (Via) super.clone();
        //if (this.sentProtocol != null)
            //retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        //if (this.sentBy != null)
            //retval.sentBy = (HostPort) this.sentBy.clone();
        //if ( this.getRPort() != -1)
            //retval.setParameter(RPORT,this.getRPort());
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_method = "5347FDDA2C7AAC95D7D1D2F666800B71", hash_generated_method = "167982A67A909D0FD17FA68D9DDCD4B4")
    public String getSentByField() {
    if(sentBy != null)        
        {
String varA2FDAF9052AB8A0DE7E94E7BF9E7ECBD_1869396102 =         sentBy.encode();
        varA2FDAF9052AB8A0DE7E94E7BF9E7ECBD_1869396102.addTaint(taint);
        return varA2FDAF9052AB8A0DE7E94E7BF9E7ECBD_1869396102;
        }
String var540C13E9E156B687226421B24F2DF178_164616325 =         null;
        var540C13E9E156B687226421B24F2DF178_164616325.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_164616325;
        // ---------- Original Method ----------
        //if(sentBy != null)
            //return sentBy.encode();
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_method = "128FFEF5D307451BA5388B5193A6BF26", hash_generated_method = "56E5CEEEA7373AE6820104EDBA351117")
    public String getSentProtocolField() {
    if(sentProtocol != null)        
        {
String varBB876D047D1B0E4E74198E1FAA58122F_281398808 =         sentProtocol.encode();
        varBB876D047D1B0E4E74198E1FAA58122F_281398808.addTaint(taint);
        return varBB876D047D1B0E4E74198E1FAA58122F_281398808;
        }
String var540C13E9E156B687226421B24F2DF178_641663637 =         null;
        var540C13E9E156B687226421B24F2DF178_641663637.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_641663637;
        // ---------- Original Method ----------
        //if(sentProtocol != null)
            //return sentProtocol.encode();
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_field = "0179E78CAC3DA14C2FFC9A7D61106327", hash_generated_field = "44E58998010CA4EBABA566C0FB985DB3")

    private static final long serialVersionUID = 5281728373401351378L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_field = "EEAA4D02BE43B89B52AFD8DC453B4BFD", hash_generated_field = "22327A98EDD3D141225105CEAD3ABB13")

    public static final String BRANCH = ParameterNames.BRANCH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_field = "9B0F9FB69328D59E52F3C0D780928331", hash_generated_field = "4D8C5F2DB4C0964744FED89BE27D1A75")

    public static final String RECEIVED = ParameterNames.RECEIVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.633 -0400", hash_original_field = "0C3EC7D99BD0916DCE7C7A2913106895", hash_generated_field = "4AA8F81F93B467DE58E70654B3136851")

    public static final String MADDR = ParameterNames.MADDR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.634 -0400", hash_original_field = "A27202196DCCEEDEB9F7293943B39842", hash_generated_field = "EAB3FB3A2E323EFD5528878B03366C28")

    public static final String TTL = ParameterNames.TTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.634 -0400", hash_original_field = "B1E3516AD1F9BEC949E47B776969F649", hash_generated_field = "180F648B89D676D4D5F0240DFDFE1D7D")

    public static final String RPORT = ParameterNames.RPORT;
}

