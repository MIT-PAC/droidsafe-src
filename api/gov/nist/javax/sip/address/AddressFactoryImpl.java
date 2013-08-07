package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.parser.StringMsgParser;
import gov.nist.javax.sip.parser.URLParser;

import java.text.ParseException;

import javax.sip.address.SipURI;
import javax.sip.address.TelURL;





public class AddressFactoryImpl implements javax.sip.address.AddressFactory {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.913 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    public  AddressFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.914 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "3AE1EAFA4741EEA140E014066588DBBA")
    public javax.sip.address.Address createAddress() {
javax.sip.address.Address var010B70F9E3862AD442F9F51590223FC7_11950313 =         new AddressImpl();
        var010B70F9E3862AD442F9F51590223FC7_11950313.addTaint(taint);
        return var010B70F9E3862AD442F9F51590223FC7_11950313;
        // ---------- Original Method ----------
        //return new AddressImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.915 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "E14AC5D7305633200153845BFFFB4C28")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        addTaint(uri.getTaint());
        addTaint(displayName.getTaint());
        if(uri == null)        
        {
        NullPointerException var76AEBB1516547CD06754B047A596D3BC_39107575 = new NullPointerException("null  URI");
        var76AEBB1516547CD06754B047A596D3BC_39107575.addTaint(taint);
        throw var76AEBB1516547CD06754B047A596D3BC_39107575;
        }
        AddressImpl addressImpl = new AddressImpl();
        if(displayName != null)        
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_1443799908 =         addressImpl;
        var546B74671DF65029CA2047A13F764E1A_1443799908.addTaint(taint);
        return var546B74671DF65029CA2047A13F764E1A_1443799908;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null  URI");
        //AddressImpl addressImpl = new AddressImpl();
        //if (displayName != null)
            //addressImpl.setDisplayName(displayName);
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.915 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "A6650AF35989A7CF3EFCE6DB6688E8C8")
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
        NullPointerException varCC2B4CF1D5C3A06C7F71134B2649E466_1966388007 = new NullPointerException("null URI");
        varCC2B4CF1D5C3A06C7F71134B2649E466_1966388007.addTaint(taint);
        throw varCC2B4CF1D5C3A06C7F71134B2649E466_1966388007;
        }
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            SipUri sipUri = smp.parseSIPUrl(uri);
javax.sip.address.SipURI var3775DD8192C4A09F6897FA3E13EAEC38_1311078006 =             (SipURI) sipUri;
            var3775DD8192C4A09F6897FA3E13EAEC38_1311078006.addTaint(taint);
            return var3775DD8192C4A09F6897FA3E13EAEC38_1311078006;
        } //End block
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_948001786 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_948001786.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_948001786;
        } //End block
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null URI");
        //try {
            //StringMsgParser smp = new StringMsgParser();
            //SipUri sipUri = smp.parseSIPUrl(uri);
            //return (SipURI) sipUri;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.917 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "B1A2CE7F74052FD66F8F416467B71DED")
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        addTaint(host.getTaint());
        addTaint(user.getTaint());
        if(host == null)        
        {
        NullPointerException varBED23021F7869113AA593D8014B02E4A_1209814184 = new NullPointerException("null host");
        varBED23021F7869113AA593D8014B02E4A_1209814184.addTaint(taint);
        throw varBED23021F7869113AA593D8014B02E4A_1209814184;
        }
        StringBuffer uriString = new StringBuffer("sip:");
        if(user != null)        
        {
            uriString.append(user);
            uriString.append("@");
        } //End block
        if(host.indexOf(':') != host.lastIndexOf(':')
            && host.trim().charAt(0) != '[')        
        host = '[' + host + ']';
        uriString.append(host);
        StringMsgParser smp = new StringMsgParser();
        try 
        {
            SipUri sipUri = smp.parseSIPUrl(uriString.toString());
javax.sip.address.SipURI var2D27E8522206398314ED10B3D3A16811_783382693 =             sipUri;
            var2D27E8522206398314ED10B3D3A16811_783382693.addTaint(taint);
            return var2D27E8522206398314ED10B3D3A16811_783382693;
        } //End block
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_1601409127 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_1601409127.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_1601409127;
        } //End block
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException("null host");
        //StringBuffer uriString = new StringBuffer("sip:");
        //if (user != null) {
            //uriString.append(user);
            //uriString.append("@");
        //}
        //if (host.indexOf(':') != host.lastIndexOf(':')
            //&& host.trim().charAt(0) != '[')
            //host = '[' + host + ']';
        //uriString.append(host);
        //StringMsgParser smp = new StringMsgParser();
        //try {
            //SipUri sipUri = smp.parseSIPUrl(uriString.toString());
            //return sipUri;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.918 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "03FE909551E8C94432641D3BA9A0E9A8")
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
        NullPointerException var3BCCBCB0137FCC791846F0641C03BBE3_2055145674 = new NullPointerException("null url");
        var3BCCBCB0137FCC791846F0641C03BBE3_2055145674.addTaint(taint);
        throw var3BCCBCB0137FCC791846F0641C03BBE3_2055145674;
        }
        String telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
javax.sip.address.TelURL varF8A4163C88152127E4816DEA07C7EB20_951843361 =             (TelURL) timp;
            varF8A4163C88152127E4816DEA07C7EB20_951843361.addTaint(taint);
            return varF8A4163C88152127E4816DEA07C7EB20_951843361;
        } //End block
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_1775318071 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_1775318071.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_1775318071;
        } //End block
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null url");
        //String telUrl = "tel:" + uri;
        //try {
            //StringMsgParser smp = new StringMsgParser();
            //TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
            //return (TelURL) timp;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.919 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "826A447E7EA0FC8B072051354CE3889D")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_1335702815 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_1335702815.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_1335702815;
        }
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_1863038550 =         addressImpl;
        var546B74671DF65029CA2047A13F764E1A_1863038550.addTaint(taint);
        return var546B74671DF65029CA2047A13F764E1A_1863038550;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null address");
        //AddressImpl addressImpl = new AddressImpl();
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.920 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "E67723FA6145C93FBABC55D7EEF0399C")
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        addTaint(address.getTaint());
        if(address == null)        
        {
        NullPointerException var3DC5AE26648CEFA4BB39A1606DD56EB1_269365966 = new NullPointerException("null address");
        var3DC5AE26648CEFA4BB39A1606DD56EB1_269365966.addTaint(taint);
        throw var3DC5AE26648CEFA4BB39A1606DD56EB1_269365966;
        }
        if(address.equals("*"))        
        {
            AddressImpl addressImpl = new AddressImpl();
            addressImpl.setAddressType(AddressImpl.WILD_CARD);
            SipURI uri = new SipUri();
            uri.setUser("*");
            addressImpl.setURI( uri );
javax.sip.address.Address var546B74671DF65029CA2047A13F764E1A_180637106 =             addressImpl;
            var546B74671DF65029CA2047A13F764E1A_180637106.addTaint(taint);
            return var546B74671DF65029CA2047A13F764E1A_180637106;
        } //End block
        else
        {
            StringMsgParser smp = new StringMsgParser();
javax.sip.address.Address var1787EF378EF1BC952CDDC5A12DE28236_599260479 =             smp.parseAddress(address);
            var1787EF378EF1BC952CDDC5A12DE28236_599260479.addTaint(taint);
            return var1787EF378EF1BC952CDDC5A12DE28236_599260479;
        } //End block
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //if (address.equals("*")) {
            //AddressImpl addressImpl = new AddressImpl();
            //addressImpl.setAddressType(AddressImpl.WILD_CARD);
            //SipURI uri = new SipUri();
            //uri.setUser("*");
            //addressImpl.setURI( uri );
            //return addressImpl;
        //} else {
            //StringMsgParser smp = new StringMsgParser();
            //return smp.parseAddress(address);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.921 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "A51BCF5694003AAADB15E26707E90AE4")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_421626754 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_421626754.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_421626754;
        }
        try 
        {
            URLParser urlParser = new URLParser(uri);
            String scheme = urlParser.peekScheme();
            if(scheme == null)            
            {
            ParseException var0B6651D68A70436C5664748F518DDC4C_1303873193 = new ParseException("bad scheme", 0);
            var0B6651D68A70436C5664748F518DDC4C_1303873193.addTaint(taint);
            throw var0B6651D68A70436C5664748F518DDC4C_1303873193;
            }
            if(scheme.equalsIgnoreCase("sip"))            
            {
javax.sip.address.URI var50FBB4223FBDFAE492653F801DFE2923_364245740 =                 (javax.sip.address.URI) urlParser.sipURL(true);
                var50FBB4223FBDFAE492653F801DFE2923_364245740.addTaint(taint);
                return var50FBB4223FBDFAE492653F801DFE2923_364245740;
            } //End block
            else
            if(scheme.equalsIgnoreCase("sips"))            
            {
javax.sip.address.URI var50FBB4223FBDFAE492653F801DFE2923_513083392 =                 (javax.sip.address.URI) urlParser.sipURL(true);
                var50FBB4223FBDFAE492653F801DFE2923_513083392.addTaint(taint);
                return var50FBB4223FBDFAE492653F801DFE2923_513083392;
            } //End block
            else
            if(scheme.equalsIgnoreCase("tel"))            
            {
javax.sip.address.URI varD306A6305D09D74991CE6B3C9C464A94_861952667 =                 (javax.sip.address.URI) urlParser.telURL(true);
                varD306A6305D09D74991CE6B3C9C464A94_861952667.addTaint(taint);
                return varD306A6305D09D74991CE6B3C9C464A94_861952667;
            } //End block
        } //End block
        catch (ParseException ex)
        {
            ParseException var21D65009E368EF6F303875AAD856F1DB_335358560 = new ParseException(ex.getMessage(), 0);
            var21D65009E368EF6F303875AAD856F1DB_335358560.addTaint(taint);
            throw var21D65009E368EF6F303875AAD856F1DB_335358560;
        } //End block
javax.sip.address.URI varCC505F770BF08B03C031A33F12373928_631830568 =         new gov.nist.javax.sip.address.GenericURI(uri);
        varCC505F770BF08B03C031A33F12373928_631830568.addTaint(taint);
        return varCC505F770BF08B03C031A33F12373928_631830568;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

