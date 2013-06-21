package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import com.android.org.bouncycastle.asn1.x509.X509Name;

public class SslCertificate {
    private DName mIssuedTo;
    private DName mIssuedBy;
    private Date mValidNotBefore;
    private Date mValidNotAfter;
    private X509Certificate mX509Certificate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.105 -0400", hash_original_method = "C9600F8F1BB8A8C873CC4C3FEC87FEF5", hash_generated_method = "6AA0D123E125390C4F83597CF4BAEE99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SslCertificate(
            String issuedTo, String issuedBy, String validNotBefore, String validNotAfter) {
        this(issuedTo, issuedBy, parseDate(validNotBefore), parseDate(validNotAfter), null);
        dsTaint.addTaint(issuedTo);
        dsTaint.addTaint(validNotAfter);
        dsTaint.addTaint(issuedBy);
        dsTaint.addTaint(validNotBefore);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.105 -0400", hash_original_method = "D87F049394C2BF8E430D24ECC769A568", hash_generated_method = "EDAD87E9A306E60E372DB1411A31BF71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public SslCertificate(
            String issuedTo, String issuedBy, Date validNotBefore, Date validNotAfter) {
        this(issuedTo, issuedBy, validNotBefore, validNotAfter, null);
        dsTaint.addTaint(issuedTo);
        dsTaint.addTaint(validNotAfter.dsTaint);
        dsTaint.addTaint(issuedBy);
        dsTaint.addTaint(validNotBefore.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.105 -0400", hash_original_method = "44DDC0F9828E23A0D6B9681282E4B5EC", hash_generated_method = "36957CDEF70F5E3C36F4DAFE6D9FC6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslCertificate(X509Certificate certificate) {
        this(certificate.getSubjectDN().getName(),
             certificate.getIssuerDN().getName(),
             certificate.getNotBefore(),
             certificate.getNotAfter(),
             certificate);
        dsTaint.addTaint(certificate.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.106 -0400", hash_original_method = "EBF5C56E3FBE1E8BC5B0F01C28F68A19", hash_generated_method = "FE8F0D236F750B38643EC7D729817FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SslCertificate(
            String issuedTo, String issuedBy,
            Date validNotBefore, Date validNotAfter,
            X509Certificate x509Certificate) {
        dsTaint.addTaint(issuedTo);
        dsTaint.addTaint(x509Certificate.dsTaint);
        dsTaint.addTaint(validNotAfter.dsTaint);
        dsTaint.addTaint(issuedBy);
        dsTaint.addTaint(validNotBefore.dsTaint);
        mIssuedTo = new DName(issuedTo);
        mIssuedBy = new DName(issuedBy);
        mValidNotBefore = cloneDate(validNotBefore);
        mValidNotAfter  = cloneDate(validNotAfter);
        // ---------- Original Method ----------
        //mIssuedTo = new DName(issuedTo);
        //mIssuedBy = new DName(issuedBy);
        //mValidNotBefore = cloneDate(validNotBefore);
        //mValidNotAfter  = cloneDate(validNotAfter);
        //mX509Certificate = x509Certificate;
    }

    
        public static Bundle saveState(SslCertificate certificate) {
        if (certificate == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ISSUED_TO, certificate.getIssuedTo().getDName());
        bundle.putString(ISSUED_BY, certificate.getIssuedBy().getDName());
        bundle.putString(VALID_NOT_BEFORE, certificate.getValidNotBefore());
        bundle.putString(VALID_NOT_AFTER, certificate.getValidNotAfter());
        X509Certificate x509Certificate = certificate.mX509Certificate;
        if (x509Certificate != null) {
            try {
                bundle.putByteArray(X509_CERTIFICATE, x509Certificate.getEncoded());
            } catch (CertificateEncodingException ignored) {
            }
        }
        return bundle;
    }

    
        public static SslCertificate restoreState(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        X509Certificate x509Certificate;
        byte[] bytes = bundle.getByteArray(X509_CERTIFICATE);
        if (bytes == null) {
            x509Certificate = null;
        } else {
            try {
                CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
                Certificate cert = certFactory.generateCertificate(new ByteArrayInputStream(bytes));
                x509Certificate = (X509Certificate) cert;
            } catch (CertificateException e) {
                x509Certificate = null;
            }
        }
        return new SslCertificate(bundle.getString(ISSUED_TO),
                                  bundle.getString(ISSUED_BY),
                                  parseDate(bundle.getString(VALID_NOT_BEFORE)),
                                  parseDate(bundle.getString(VALID_NOT_AFTER)),
                                  x509Certificate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.106 -0400", hash_original_method = "86D829D0BCD4BD19D84EADD31DD5FCE1", hash_generated_method = "A6E4E9AF618955D475B8A43F0AB330B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getValidNotBeforeDate() {
        Date var87D83E0D1DDB0FE5D8C71669FE42FC7D_147628105 = (cloneDate(mValidNotBefore));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cloneDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.106 -0400", hash_original_method = "E74141FEB26284E4BA15E02DC99CE923", hash_generated_method = "CEBAA5D42FFC3563538250F84E520D78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String getValidNotBefore() {
        String var098AA743534228DDB6A047A0CCF18192_756929452 = (formatDate(mValidNotBefore));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return formatDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.107 -0400", hash_original_method = "5976F2F67CC4D55E479FF99F5BD66B52", hash_generated_method = "4AF9AB1A06568176AEF107221D4BE5A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getValidNotAfterDate() {
        Date var8E2650C162C314FA81186FF148D4EB60_19963542 = (cloneDate(mValidNotAfter));
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cloneDate(mValidNotAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.107 -0400", hash_original_method = "8855AE273E27E2CAD00A7550F7D75B05", hash_generated_method = "009224AA7404A43B3D8BD745AD6D77D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String getValidNotAfter() {
        String var876CE80D1AFA49AB02B93B7A2B18544F_629228948 = (formatDate(mValidNotAfter));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return formatDate(mValidNotAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.107 -0400", hash_original_method = "2E4F61534C62139557AB31E5631377F2", hash_generated_method = "27BB95870F5F049625B181B4545C67E3")
    @DSModeled(DSC.SAFE)
    public DName getIssuedTo() {
        return (DName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIssuedTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.107 -0400", hash_original_method = "82F93F0D2EB1DC97DAB6C30DC54F99BE", hash_generated_method = "993018F1A798C115D5154E953B1DEC20")
    @DSModeled(DSC.SAFE)
    public DName getIssuedBy() {
        return (DName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIssuedBy;
    }

    
        private static String getSerialNumber(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            return "";
        }
        BigInteger serialNumber = x509Certificate.getSerialNumber();
        if (serialNumber == null) {
            return "";
        }
        return fingerprint(serialNumber.toByteArray());
    }

    
        private static String getDigest(X509Certificate x509Certificate, String algorithm) {
        if (x509Certificate == null) {
            return "";
        }
        try {
            byte[] bytes = x509Certificate.getEncoded();
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] digest = md.digest(bytes);
            return fingerprint(digest);
        } catch (CertificateEncodingException ignored) {
            return "";
        } catch (NoSuchAlgorithmException ignored) {
            return "";
        }
    }

    
        private static final String fingerprint(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            IntegralToString.appendByteAsHex(sb, b, true);
            if (i+1 != bytes.length) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.108 -0400", hash_original_method = "F16D936F6355F1722DE333F4EC7C4E06", hash_generated_method = "E9D8BBD3BD96091B90BC4EA7073552AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varEE06B277718283D58269F206D2074150_823859163 = (("Issued to: " + mIssuedTo.getDName() + ";\n"
                + "Issued by: " + mIssuedBy.getDName() + ";\n"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ("Issued to: " + mIssuedTo.getDName() + ";\n"
                //+ "Issued by: " + mIssuedBy.getDName() + ";\n");
    }

    
        private static Date parseDate(String string) {
        try {
            return new SimpleDateFormat(ISO_8601_DATE_FORMAT).parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    
        private static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(ISO_8601_DATE_FORMAT).format(date);
    }

    
        private static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.109 -0400", hash_original_method = "D583B5DA5B2EDF3475293874A3D5A1D5", hash_generated_method = "7AC9993ADBE6430BF38FD0CDE1A25B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View inflateCertificateView(Context context) {
        dsTaint.addTaint(context.dsTaint);
        LayoutInflater factory;
        factory = LayoutInflater.from(context);
        View certificateView;
        certificateView = factory.inflate(
            com.android.internal.R.layout.ssl_certificate, null);
        SslCertificate.DName issuedTo;
        issuedTo = getIssuedTo();
        {
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_common))
                    .setText(issuedTo.getCName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_org))
                    .setText(issuedTo.getOName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_org_unit))
                    .setText(issuedTo.getUName());
        } //End block
        ((TextView) certificateView.findViewById(com.android.internal.R.id.serial_number))
                .setText(getSerialNumber(mX509Certificate));
        SslCertificate.DName issuedBy;
        issuedBy = getIssuedBy();
        {
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_common))
                    .setText(issuedBy.getCName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org))
                    .setText(issuedBy.getOName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org_unit))
                    .setText(issuedBy.getUName());
        } //End block
        String issuedOn;
        issuedOn = formatCertificateDate(context, getValidNotBeforeDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.issued_on))
                .setText(issuedOn);
        String expiresOn;
        expiresOn = formatCertificateDate(context, getValidNotAfterDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.expires_on))
                .setText(expiresOn);
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha256_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA256"));
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha1_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA1"));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.110 -0400", hash_original_method = "AFB9B131464BD8BEA4E9664B02B81FAF", hash_generated_method = "6A3EFC561225006750F58B2A814292B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String formatCertificateDate(Context context, Date certificateDate) {
        dsTaint.addTaint(certificateDate.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        String varC400BE7FB114A1D851965B1C95B81FFA_2111071704 = (DateFormat.getDateFormat(context).format(certificateDate));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (certificateDate == null) {
            //return "";
        //}
        //return DateFormat.getDateFormat(context).format(certificateDate);
    }

    
    public class DName {
        private String mDName;
        private String mCName;
        private String mOName;
        private String mUName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.110 -0400", hash_original_method = "E1EC1A01B7E978D9F78C671CC9D0E725", hash_generated_method = "26905E6A4DFF12C5FCCC9686EAF84E6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DName(String dName) {
            dsTaint.addTaint(dName);
            {
                try 
                {
                    X509Name x509Name;
                    x509Name = new X509Name(dName);
                    Vector val;
                    val = x509Name.getValues();
                    Vector oid;
                    oid = x509Name.getOIDs();
                    {
                        int i;
                        i = 0;
                        boolean var81398A3258B14BF4B3BCED5C96BDA2E4_399425594 = (i < oid.size());
                        {
                            {
                                boolean var0C6F0BE758D98D60EBB9B16537698F57_1637438448 = (oid.elementAt(i).equals(X509Name.CN));
                                {
                                    mCName = (String) val.elementAt(i);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var06E8299BDF4B0086B47388185FF81940_1861851222 = (oid.elementAt(i).equals(X509Name.O));
                                {
                                    mOName = (String) val.elementAt(i);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var66A9551431E1DEC1988477609E15738C_285907294 = (oid.elementAt(i).equals(X509Name.OU));
                                {
                                    mUName = (String) val.elementAt(i);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (IllegalArgumentException ex)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.111 -0400", hash_original_method = "CA7B7457EAE364E31ECFC3E240698ADB", hash_generated_method = "5037F12E6886F4FE801B44F742B9FC8B")
        @DSModeled(DSC.SAFE)
        public String getDName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mDName != null ? mDName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.111 -0400", hash_original_method = "9443834DD976C880848529D9F73675CC", hash_generated_method = "4360F043035733FEE3A0FF6DF70F7E24")
        @DSModeled(DSC.SAFE)
        public String getCName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mCName != null ? mCName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.111 -0400", hash_original_method = "7251BF6AE7EA38B61D97CF2E138787A6", hash_generated_method = "25C4256795E84073332EB25FA9A7F168")
        @DSModeled(DSC.SAFE)
        public String getOName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mOName != null ? mOName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.111 -0400", hash_original_method = "372D1A5E33F38EEDF5C6B63F53532F1F", hash_generated_method = "393427BA873D9B1FD4FE3CCE13F11C95")
        @DSModeled(DSC.SAFE)
        public String getUName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mUName != null ? mUName : "";
        }

        
    }


    
    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    private static final String ISSUED_TO = "issued-to";
    private static final String ISSUED_BY = "issued-by";
    private static final String VALID_NOT_BEFORE = "valid-not-before";
    private static final String VALID_NOT_AFTER = "valid-not-after";
    private static final String X509_CERTIFICATE = "x509-certificate";
}

