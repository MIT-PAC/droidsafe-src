package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.address.*;

public class AddressFactoryImpl implements javax.sip.address.AddressFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.972 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    public  AddressFactoryImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.973 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "2C40ACCDBF0F75624982D6DAC278F8EE")
    public javax.sip.address.Address createAddress() {
javax.sip.address.Address var010B70F9E3862AD442F9F51590223FC7_1431192484 =         new AddressImpl();
        var010B70F9E3862AD442F9F51590223FC7_1431192484.addTaint(taint);
        return var010B70F9E3862AD442F9F51590223FC7_1431192484;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.974 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "E2169F4307C3B6C3FDE4E12AE3D34758")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        addTaint(uri.getTaint());
        addTaint(displayName.getTaint());
    if(uri == null)        
        {
        NullPointerException var76AEBB1516547CD06754B047A596D3BC_636392968 = new NullPointerException("null  URI");
        var76AEBB1516547CD06754B047A596D3BC_636392968.addTaint(taint);
        throw var76AEBB1516547CD06754B047A596D3BC_636392968;
        }
        AddressImpl addressImpl = new AddressImpl();
    if(displayName != null)        
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_1273424340 =         addressImpl;
        var546B74671DF65029CA2047A13F764E1A_1273424340.addTaint(taint);
        return var546B74671DF65029CA2047A13F764E1A_1273424340;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.975 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "676C7F5B8273171C30A45152AAE78F90")
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
        NullPointerException varCC2B4CF1D5C3A06C7F71134B2649E466_475640238 = new NullPointerException("null URI");
        varCC2B4CF1D5C3A06C7F71134B2649E466_475640238.addTaint(taint);
        throw varCC2B4CF1D5C3A06C7F71134B2649E466_475640238;
        }
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            SipUri sipUri = smp.parseSIPUrl(uri);
javax.sip.address.SipURI var3775DD8192C4A09F6897FA3E13EAEC38_1406373261 =             (SipURI) sipUri;
            var3775DD8192C4A09F6897FA3E13EAEC38_1406373261.addTaint(taint);
            return var3775DD8192C4A09F6897FA3E13EAEC38_1406373261;
        } 
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_1915924374 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_1915924374.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_1915924374;
        } 
        
        
            
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.976 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "D5C9375380820FE2D78FDC3ECCB6C28D")
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        addTaint(host.getTaint());
        addTaint(user.getTaint());
    if(host == null)        
        {
        NullPointerException varBED23021F7869113AA593D8014B02E4A_378906832 = new NullPointerException("null host");
        varBED23021F7869113AA593D8014B02E4A_378906832.addTaint(taint);
        throw varBED23021F7869113AA593D8014B02E4A_378906832;
        }
        StringBuffer uriString = new StringBuffer("sip:");
    if(user != null)        
        {
            uriString.append(user);
            uriString.append("@");
        } 
    if(host.indexOf(':') != host.lastIndexOf(':')
            && host.trim().charAt(0) != '[')        
        host = '[' + host + ']';
        uriString.append(host);
        StringMsgParser smp = new StringMsgParser();
        try 
        {
            SipUri sipUri = smp.parseSIPUrl(uriString.toString());
javax.sip.address.SipURI var2D27E8522206398314ED10B3D3A16811_184480544 =             sipUri;
            var2D27E8522206398314ED10B3D3A16811_184480544.addTaint(taint);
            return var2D27E8522206398314ED10B3D3A16811_184480544;
        } 
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_1030763436 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_1030763436.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_1030763436;
        } 
        
        
            
        
        
            
            
        
        
            
            
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.977 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "3E027815A2958196D5FBBE458EC690D5")
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
        NullPointerException var3BCCBCB0137FCC791846F0641C03BBE3_1213474615 = new NullPointerException("null url");
        var3BCCBCB0137FCC791846F0641C03BBE3_1213474615.addTaint(taint);
        throw var3BCCBCB0137FCC791846F0641C03BBE3_1213474615;
        }
        String telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
javax.sip.address.TelURL varF8A4163C88152127E4816DEA07C7EB20_1361010559 =             (TelURL) timp;
            varF8A4163C88152127E4816DEA07C7EB20_1361010559.addTaint(taint);
            return varF8A4163C88152127E4816DEA07C7EB20_1361010559;
        } 
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_653815981 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_653815981.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_653815981;
        } 
        
        
            
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.978 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "C19A05128ABD9C0EBC90AC0B21160AB5")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_404210361 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_404210361.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_404210361;
        }
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_1670492938 =         addressImpl;
        var546B74671DF65029CA2047A13F764E1A_1670492938.addTaint(taint);
        return var546B74671DF65029CA2047A13F764E1A_1670492938;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.978 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "9035B2DB5FDF37FB52EED6D5ABA1DFCB")
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        addTaint(address.getTaint());
    if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_1553249107 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_1553249107.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_1553249107;
        }
    if(address.equals("*"))        
        {
            AddressImpl addressImpl = new AddressImpl();
            addressImpl.setAddressType(AddressImpl.WILD_CARD);
            SipURI uri = new SipUri();
            uri.setUser("*");
            addressImpl.setURI( uri );
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_1706731790 =             addressImpl;
            var546B74671DF65029CA2047A13F764E1A_1706731790.addTaint(taint);
            return var546B74671DF65029CA2047A13F764E1A_1706731790;
        } 
        else
        {
            StringMsgParser smp = new StringMsgParser();
javax.sip.address.Address var1787EF378EF1BC952CDDC5A12DE28236_1786205412 =             smp.parseAddress(address);
            var1787EF378EF1BC952CDDC5A12DE28236_1786205412.addTaint(taint);
            return var1787EF378EF1BC952CDDC5A12DE28236_1786205412;
        } 
        
        
            
        
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.979 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "A08282C09043FC61A6633D1F1C608154")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1905341447 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1905341447.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_1905341447;
        }
        try 
        {
            URLParser urlParser = new URLParser(uri);
            String scheme = urlParser.peekScheme();
    if(scheme == null)            
            {
            ParseException var0B6651D68A70436C5664748F518DDC4C_945058002 = new ParseException("bad scheme", 0);
            var0B6651D68A70436C5664748F518DDC4C_945058002.addTaint(taint);
            throw var0B6651D68A70436C5664748F518DDC4C_945058002;
            }
    if(scheme.equalsIgnoreCase("sip"))            
            {
javax.sip.address.URI var50FBB4223FBDFAE492653F801DFE2923_2132825803 =                 (javax.sip.address.URI) urlParser.sipURL(true);
                var50FBB4223FBDFAE492653F801DFE2923_2132825803.addTaint(taint);
                return var50FBB4223FBDFAE492653F801DFE2923_2132825803;
            } 
            else
    if(scheme.equalsIgnoreCase("sips"))            
            {
javax.sip.address.URI var50FBB4223FBDFAE492653F801DFE2923_2101981785 =                 (javax.sip.address.URI) urlParser.sipURL(true);
                var50FBB4223FBDFAE492653F801DFE2923_2101981785.addTaint(taint);
                return var50FBB4223FBDFAE492653F801DFE2923_2101981785;
            } 
            else
    if(scheme.equalsIgnoreCase("tel"))            
            {
javax.sip.address.URI varD306A6305D09D74991CE6B3C9C464A94_1608536290 =                 (javax.sip.address.URI) urlParser.telURL(true);
                varD306A6305D09D74991CE6B3C9C464A94_1608536290.addTaint(taint);
                return varD306A6305D09D74991CE6B3C9C464A94_1608536290;
            } 
        } 
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_1219068058 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_1219068058.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_1219068058;
        } 
javax.sip.address.URI varCC505F770BF08B03C031A33F12373928_362758589 =         new gov.nist.javax.sip.address.GenericURI(uri);
        varCC505F770BF08B03C031A33F12373928_362758589.addTaint(taint);
        return varCC505F770BF08B03C031A33F12373928_362758589;
        
        
    }

    
}

