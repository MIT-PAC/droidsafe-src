package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.cert.X509Certificate;

public class SslError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.808 -0400", hash_original_field = "D750EAC634DEAED12CF378E4BA272A33", hash_generated_field = "A1A4B77C81BB0C0C3F4262BD3992D7FD")

    int mErrors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.808 -0400", hash_original_field = "1229A917B4D1D7ED185029644D045D14", hash_generated_field = "8722B9770017213537D317FB65A9919D")

    SslCertificate mCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.808 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

    String mUrl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.809 -0400", hash_original_method = "E54E1790034E06C2564EA8F8D322C604", hash_generated_method = "3D671E82DE6A5AE89E8DA32585619560")
    @Deprecated
    public  SslError(int error, SslCertificate certificate) {
        this(error, certificate, "");
        addTaint(certificate.getTaint());
        addTaint(error);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.809 -0400", hash_original_method = "D4D6A5236E4F49764789FE2E4242FD0D", hash_generated_method = "782A48579A4C55E97370E08735BD0EB4")
    @Deprecated
    public  SslError(int error, X509Certificate certificate) {
        this(error, certificate, "");
        addTaint(certificate.getTaint());
        addTaint(error);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.810 -0400", hash_original_method = "85B2ECB0DBC9283B8022F29E2B26DB48", hash_generated_method = "BB7DF187F8D4A61FE74736054EC8EE30")
    public  SslError(int error, SslCertificate certificate, String url) {
        addTaint(error);
        addError(error);
        mCertificate = certificate;
        mUrl = url;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.810 -0400", hash_original_method = "3533EE541F404B8ADD4D4E5426E464A7", hash_generated_method = "25D754A30D03BA1F327CFA910071D185")
    public  SslError(int error, X509Certificate certificate, String url) {
        this(error, new SslCertificate(certificate), url);
        addTaint(url.getTaint());
        addTaint(certificate.getTaint());
        addTaint(error);
        
    }

    
        @DSModeled(DSC.SPEC)
    public static SslError SslErrorFromChromiumErrorCode(
            int error, SslCertificate cert, String url) {
        assert (error >= -299 && error <= -200);
        if (error == -200)
            return new SslError(SSL_IDMISMATCH, cert, url);
        if (error == -201)
            return new SslError(SSL_DATE_INVALID, cert, url);
        if (error == -202)
            return new SslError(SSL_UNTRUSTED, cert, url);
        return new SslError(SSL_INVALID, cert, url);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.811 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "031F5FC7C19644C0D7A4C9AEDDDCCCE0")
    public SslCertificate getCertificate() {
SslCertificate varAD9FB3E799180A1D9497E2C35C2EA89C_2139500250 =         mCertificate;
        varAD9FB3E799180A1D9497E2C35C2EA89C_2139500250.addTaint(taint);
        return varAD9FB3E799180A1D9497E2C35C2EA89C_2139500250;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.811 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "4F73251B30B9870152CE36B7A22B5FFA")
    public String getUrl() {
String varF1E91891753CD7C4305CCDECB60B9DDF_281831255 =         mUrl;
        varF1E91891753CD7C4305CCDECB60B9DDF_281831255.addTaint(taint);
        return varF1E91891753CD7C4305CCDECB60B9DDF_281831255;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.812 -0400", hash_original_method = "AE664F52BD7226DBAA3D1D1034C9653E", hash_generated_method = "B3E2D1F822ACD4D469F7A5F1254517F8")
    public boolean addError(int error) {
        boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
    if(rval)        
        {
            mErrors |= (0x1 << error);
        } 
        boolean var3AA2A96AAA4B6F394E95B854076343B9_6138154 = (rval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868869287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868869287;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.812 -0400", hash_original_method = "B3A224AA064D57107491E8991A407E79", hash_generated_method = "131BC50BB901EDA1A725DD6ED624F22F")
    public boolean hasError(int error) {
        addTaint(error);
        boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
    if(rval)        
        {
            rval = ((mErrors & (0x1 << error)) != 0);
        } 
        boolean var3AA2A96AAA4B6F394E95B854076343B9_767264573 = (rval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504990507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504990507;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.813 -0400", hash_original_method = "3A5499989FF366B2E4D135ECA3891E4C", hash_generated_method = "1461CF298C6D64F7B48FC0ACC915F3CA")
    public int getPrimaryError() {
    if(mErrors != 0)        
        {
for(int error = SslError.SSL_MAX_ERROR - 1;error >= 0;--error)
            {
    if((mErrors & (0x1 << error)) != 0)                
                {
                    int varCB5E100E5A9A3E7F6D1FD97512215282_58982203 = (error);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002637801 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002637801;
                } 
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_201957424 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331731567 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331731567;
        
        
            
                
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_method = "18A0C6CD1FD66E60B7FF0A9F205CF54C", hash_generated_method = "8F1495F34C85BAE1546D55E7872D196F")
    public String toString() {
String varBC2B8F20611E6C15A9DE58D1BABCFAD6_2140568190 =         "primary error: " + getPrimaryError() +
                " certificate: " + getCertificate() +
                " on URL: " + getUrl();
        varBC2B8F20611E6C15A9DE58D1BABCFAD6_2140568190.addTaint(taint);
        return varBC2B8F20611E6C15A9DE58D1BABCFAD6_2140568190;
        
        
                
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "D2EA2C10F5328BED16ECA1B1C3232857", hash_generated_field = "41D8CEB3ECE7A9944FA4156476889EAF")

    public static final int SSL_NOTYETVALID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "E3090C974939AF365323AF4AB9F65BB8", hash_generated_field = "BAAD9CBD08CD0D2093B10402B8464A98")

    public static final int SSL_EXPIRED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "9B753F19A5B24F8D81CE7F53EB7231DB", hash_generated_field = "13B7485113DA8A602D91A2F53C58C15F")

    public static final int SSL_IDMISMATCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "A972E47F33ED55CA475DE44DDF17D784", hash_generated_field = "0E952E7AEE36B79768B89A0EECDF70AB")

    public static final int SSL_UNTRUSTED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "E39EE78A32105F7C1CEDD9EFE4B572F8", hash_generated_field = "7A71850528D1C5A05BCC2F8DAA5B23B9")

    public static final int SSL_DATE_INVALID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.814 -0400", hash_original_field = "5BB142B47414CD2F616DDAF6DC30267F", hash_generated_field = "37C2C751255A73F019D90F63D8AA6D24")

    public static final int SSL_INVALID = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.815 -0400", hash_original_field = "088EEB373D581113C76F39764FE6E168", hash_generated_field = "751C3F66A9B17BB4E0BF7C23C8DBFC0A")

    @Deprecated
    public static final int SSL_MAX_ERROR = 6;
}

