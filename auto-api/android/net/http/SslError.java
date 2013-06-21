package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.cert.X509Certificate;

public class SslError {
    int mErrors;
    SslCertificate mCertificate;
    String mUrl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.122 -0400", hash_original_method = "E54E1790034E06C2564EA8F8D322C604", hash_generated_method = "06666DDA12C58220115816FBBB767D8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SslError(int error, SslCertificate certificate) {
        this(error, certificate, "");
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.124 -0400", hash_original_method = "D4D6A5236E4F49764789FE2E4242FD0D", hash_generated_method = "9AE21BDBD5A897295A5930A78546BF33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SslError(int error, X509Certificate certificate) {
        this(error, certificate, "");
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.125 -0400", hash_original_method = "85B2ECB0DBC9283B8022F29E2B26DB48", hash_generated_method = "738B8B26993B730E3E6DF46332287854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslError(int error, SslCertificate certificate, String url) {
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(error);
        dsTaint.addTaint(url);
        addError(error);
        // ---------- Original Method ----------
        //assert certificate != null;
        //assert url != null;
        //addError(error);
        //mCertificate = certificate;
        //mUrl = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.125 -0400", hash_original_method = "3533EE541F404B8ADD4D4E5426E464A7", hash_generated_method = "24CABFEF0550F4DCEA7EF7E758E569BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslError(int error, X509Certificate certificate, String url) {
        this(error, new SslCertificate(certificate), url);
        dsTaint.addTaint(certificate.dsTaint);
        dsTaint.addTaint(error);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.125 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "03490D52664B267137090C9B7935E84B")
    @DSModeled(DSC.SAFE)
    public SslCertificate getCertificate() {
        return (SslCertificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.126 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "ACFE25042C24F54739138D52C59239EC")
    @DSModeled(DSC.SAFE)
    public String getUrl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.126 -0400", hash_original_method = "AE664F52BD7226DBAA3D1D1034C9653E", hash_generated_method = "7D583AA408E728BCA13095DD53E3900E")
    @DSModeled(DSC.SAFE)
    public boolean addError(int error) {
        dsTaint.addTaint(error);
        boolean rval;
        rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        {
            mErrors |= (0x1 << error);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        //if (rval) {
            //mErrors |= (0x1 << error);
        //}
        //return rval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.126 -0400", hash_original_method = "B3A224AA064D57107491E8991A407E79", hash_generated_method = "5BB4B98D4A7735B5088A683529C1EF8A")
    @DSModeled(DSC.SAFE)
    public boolean hasError(int error) {
        dsTaint.addTaint(error);
        boolean rval;
        rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        {
            rval = ((mErrors & (0x1 << error)) != 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean rval = (0 <= error && error < SslError.SSL_MAX_ERROR);
        //if (rval) {
            //rval = ((mErrors & (0x1 << error)) != 0);
        //}
        //return rval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.126 -0400", hash_original_method = "3A5499989FF366B2E4D135ECA3891E4C", hash_generated_method = "06FDDF42EBA3A28AE164F7C9D1D4A0F3")
    @DSModeled(DSC.SAFE)
    public int getPrimaryError() {
        {
            {
                int error;
                error = SslError.SSL_MAX_ERROR - 1;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mErrors != 0) {
            //for (int error = SslError.SSL_MAX_ERROR - 1; error >= 0; --error) {
                //if ((mErrors & (0x1 << error)) != 0) {
                    //return error;
                //}
            //}
            //assert false;
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.127 -0400", hash_original_method = "18A0C6CD1FD66E60B7FF0A9F205CF54C", hash_generated_method = "BEE25D5DE86E5E598BAB07AAA63DD42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var0007610F53DB80390B2AF70CC8C616B2_1402181370 = ("primary error: " + getPrimaryError() +
                " certificate: " + getCertificate() +
                " on URL: " + getUrl());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "primary error: " + getPrimaryError() +
                //" certificate: " + getCertificate() +
                //" on URL: " + getUrl();
    }

    
    public static final int SSL_NOTYETVALID = 0;
    public static final int SSL_EXPIRED = 1;
    public static final int SSL_IDMISMATCH = 2;
    public static final int SSL_UNTRUSTED = 3;
    public static final int SSL_DATE_INVALID = 4;
    public static final int SSL_INVALID = 5;
    @Deprecated public static final int SSL_MAX_ERROR = 6;
}

