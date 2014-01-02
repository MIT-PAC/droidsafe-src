package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import org.bouncycastle.asn1.x509.X509Name;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;





public class SslCertificate {

    /**
     * Saves the certificate state to a bundle
     * @param certificate The SSL certificate to store
     * @return A bundle with the certificate stored in it or null if fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.438 -0500", hash_original_method = "880873CE7B63CF2F24561F719FB04003", hash_generated_method = "C0608A76EC65887A30B994AFF34FBFF5")
    
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

    /**
     * Restores the certificate stored in the bundle
     * @param bundle The bundle with the certificate state stored in it
     * @return The SSL certificate stored in the bundle or null if fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.441 -0500", hash_original_method = "8A489CB2A393053F8EB365921E8E5602", hash_generated_method = "D822D24219EEE37C20EBA54E6F6E3402")
    
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

    /**
     * Convenience for UI presentation, not intended as public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.467 -0500", hash_original_method = "F4854410C533ABCAFE3E1FF72047B328", hash_generated_method = "DA3146E2C36FF4265B9905515FBC3F07")
    
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

    /**
     * Convenience for UI presentation, not intended as public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.470 -0500", hash_original_method = "BB04971521798A4AB8A6BF219B43860B", hash_generated_method = "4E7893166AF4B5CC778CD2AEB13E54AF")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.472 -0500", hash_original_method = "4FD92B21057EB8E2D86E0A29786F7A27", hash_generated_method = "B76B5A4B6D6CF46D1637D9A6AB60D36D")
    
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

    /**
     * Parse an ISO 8601 date converting ParseExceptions to a null result;
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.476 -0500", hash_original_method = "580FA0F575468574C9336A7B61DF15D7", hash_generated_method = "83E62F628230CD0C38EF31224B3A998E")
    
private static Date parseDate(String string) {
        try {
            return new SimpleDateFormat(ISO_8601_DATE_FORMAT).parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Format a date as an ISO 8601 string, return "" for a null date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.478 -0500", hash_original_method = "5B5085E306AF53459A7AE9C0247F607B", hash_generated_method = "70ECBC4221D6F322FDFBB4F7F717F9B3")
    
private static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(ISO_8601_DATE_FORMAT).format(date);
    }

    /**
     * Clone a possibly null Date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.481 -0500", hash_original_method = "601D82D104A095ABBA912C73F2E0F835", hash_generated_method = "A56786C9EEC3E634CDD3B76C435F31F8")
    
private static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.412 -0500", hash_original_field = "3A03BD11558931F3C8C2427DA6F56E85", hash_generated_field = "796221E87930E845E5EA421C8E86DFF6")

    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.426 -0500", hash_original_field = "8213CD9AD53DB34E9FD857488C5F77E4", hash_generated_field = "1FA9058DFCEB0C71DF564270AF5B6408")

    private static final String ISSUED_TO = "issued-to";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.428 -0500", hash_original_field = "B76AE029169D753C8F279713C3F0225D", hash_generated_field = "450A14773231679E30D473C0C7417E49")

    private static final String ISSUED_BY = "issued-by";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.430 -0500", hash_original_field = "9C995B1DCB9453A29E3C184DE5A773C6", hash_generated_field = "FA241E5FEC8DD303C71111D6A40A9996")

    private static final String VALID_NOT_BEFORE = "valid-not-before";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.433 -0500", hash_original_field = "525C6F836675CC7A0AFCA552C3E74A84", hash_generated_field = "E334FB13549F22C81A060A785A190C49")

    private static final String VALID_NOT_AFTER = "valid-not-after";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.436 -0500", hash_original_field = "625FDA23CC623824BE81F8294AE316F8", hash_generated_field = "F4AFCD170B64578A035371E0CFCC64E2")

    private static final String X509_CERTIFICATE = "x509-certificate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.414 -0500", hash_original_field = "B90BAFE9C066D7D59C27FE4D2F86B742", hash_generated_field = "3A0F95171EDB19B88E8BBB2C224E603F")

    private  DName mIssuedTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.416 -0500", hash_original_field = "7276D3406C1924D0DCAF9CE1477114E6", hash_generated_field = "B9F29B14DA0374C383549135A8B1A6E9")

    private  DName mIssuedBy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.419 -0500", hash_original_field = "03A97BEFCF5B61973DDB2E10D4FB0D24", hash_generated_field = "790C1877C241C6BC4E21841CE6B9480E")

    private  Date mValidNotBefore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.421 -0500", hash_original_field = "A22296AC60A8E2C5B5E68B78FE579B64", hash_generated_field = "F2FF1888752CADA242EFC5AEF50063B0")

    private  Date mValidNotAfter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.424 -0500", hash_original_field = "90D7868B32A2EB1E0860ABF51F6643DF", hash_generated_field = "537A6CC67DC1E04E8C3F9E6F30614000")

    private  X509Certificate mX509Certificate;

    /**
     * Creates a new SSL certificate object
     * @param issuedTo The entity this certificate is issued to
     * @param issuedBy The entity that issued this certificate
     * @param validNotBefore The not-before date from the certificate
     *     validity period in ISO 8601 format
     * @param validNotAfter The not-after date from the certificate
     *     validity period in ISO 8601 format
     * @deprecated Use {@link #SslCertificate(X509Certificate)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.444 -0500", hash_original_method = "C9600F8F1BB8A8C873CC4C3FEC87FEF5", hash_generated_method = "5678E8178F7A23A79FE55C21B97D7D2C")
    
@Deprecated
    public SslCertificate(
            String issuedTo, String issuedBy, String validNotBefore, String validNotAfter) {
        this(issuedTo, issuedBy, parseDate(validNotBefore), parseDate(validNotAfter), null);
    }

    /**
     * Creates a new SSL certificate object
     * @param issuedTo The entity this certificate is issued to
     * @param issuedBy The entity that issued this certificate
     * @param validNotBefore The not-before date from the certificate validity period
     * @param validNotAfter The not-after date from the certificate validity period
     * @deprecated Use {@link #SslCertificate(X509Certificate)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.446 -0500", hash_original_method = "D87F049394C2BF8E430D24ECC769A568", hash_generated_method = "61AF8612D360F90362D60222BA9E9E82")
    
@Deprecated
    public SslCertificate(
            String issuedTo, String issuedBy, Date validNotBefore, Date validNotAfter) {
        this(issuedTo, issuedBy, validNotBefore, validNotAfter, null);
    }

    /**
     * Creates a new SSL certificate object from an X509 certificate
     * @param certificate X509 certificate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.449 -0500", hash_original_method = "44DDC0F9828E23A0D6B9681282E4B5EC", hash_generated_method = "AE6DFFDB6AA401EAA4F30704D5CBB4A7")
    
public SslCertificate(X509Certificate certificate) {
        this(certificate.getSubjectDN().getName(),
             certificate.getIssuerDN().getName(),
             certificate.getNotBefore(),
             certificate.getNotAfter(),
             certificate);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.451 -0500", hash_original_method = "EBF5C56E3FBE1E8BC5B0F01C28F68A19", hash_generated_method = "908E7D0B7E70B6EB951D6E0B3C81E092")
    
private SslCertificate(
            String issuedTo, String issuedBy,
            Date validNotBefore, Date validNotAfter,
            X509Certificate x509Certificate) {
        mIssuedTo = new DName(issuedTo);
        mIssuedBy = new DName(issuedBy);
        mValidNotBefore = cloneDate(validNotBefore);
        mValidNotAfter  = cloneDate(validNotAfter);
        mX509Certificate = x509Certificate;
    }

    /**
     * @return Not-before date from the certificate validity period or
     * "" if none has been set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.453 -0500", hash_original_method = "86D829D0BCD4BD19D84EADD31DD5FCE1", hash_generated_method = "6B745589B48C817901A3E984E81A2750")
    
public Date getValidNotBeforeDate() {
        return cloneDate(mValidNotBefore);
    }

    /**
     * @return Not-before date from the certificate validity period in
     * ISO 8601 format or "" if none has been set
     *
     * @deprecated Use {@link #getValidNotBeforeDate()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.456 -0500", hash_original_method = "E74141FEB26284E4BA15E02DC99CE923", hash_generated_method = "906469760EC9FF7EC54CC2F5572802B4")
    
@Deprecated
    public String getValidNotBefore() {
        return formatDate(mValidNotBefore);
    }

    /**
     * @return Not-after date from the certificate validity period or
     * "" if none has been set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.458 -0500", hash_original_method = "5976F2F67CC4D55E479FF99F5BD66B52", hash_generated_method = "C93E018667540B41F134F29638AC0187")
    
public Date getValidNotAfterDate() {
        return cloneDate(mValidNotAfter);
    }

    
    public class DName {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.484 -0500", hash_original_field = "0A1AE598F4DE402F5AB1E2786E227934", hash_generated_field = "3BD097ADC1AABD13C2B47840D547843E")

        private String mDName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.486 -0500", hash_original_field = "C527F77D690D42AEBC8FE07AA4F17617", hash_generated_field = "C87DD36180CC90C09336CD9600FB7BD5")

        private String mCName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.488 -0500", hash_original_field = "883E238D9313B55D073A4ECE1D256E39", hash_generated_field = "626F524368BB49A1B4C2CC3A1865A29C")

        private String mOName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.490 -0500", hash_original_field = "E1BB5771432A611607D86ED6102603C8", hash_generated_field = "B3038D70C29815EB8360E3A3B8924901")

        private String mUName;

        /**
         * Creates a new distinguished name
         * @param dName The distinguished name
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.494 -0500", hash_original_method = "E1EC1A01B7E978D9F78C671CC9D0E725", hash_generated_method = "DE63C5442C0359B728ECA78D386297FA")
        
public DName(String dName) {
            if (dName != null) {
                mDName = dName;
                try {
                    X509Name x509Name = new X509Name(dName);

                    Vector val = x509Name.getValues();
                    Vector oid = x509Name.getOIDs();

                    for (int i = 0; i < oid.size(); i++) {
                        if (oid.elementAt(i).equals(X509Name.CN)) {
                            mCName = (String) val.elementAt(i);
                            continue;
                        }

                        if (oid.elementAt(i).equals(X509Name.O)) {
                            mOName = (String) val.elementAt(i);
                            continue;
                        }

                        if (oid.elementAt(i).equals(X509Name.OU)) {
                            mUName = (String) val.elementAt(i);
                            continue;
                        }
                    }
                } catch (IllegalArgumentException ex) {
                    // thrown if there is an error parsing the string
                }
            }
        }

        /**
         * @return The distinguished name (normally includes CN, O, and OU names)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.496 -0500", hash_original_method = "CA7B7457EAE364E31ECFC3E240698ADB", hash_generated_method = "608CAB9EC6484E5B39AD95AC3D10630E")
        
public String getDName() {
            return mDName != null ? mDName : "";
        }

        /**
         * @return The Common-name (CN) component of this name
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.498 -0500", hash_original_method = "9443834DD976C880848529D9F73675CC", hash_generated_method = "992C984B3D4EDE2D411418A1EBF2206A")
        
public String getCName() {
            return mCName != null ? mCName : "";
        }

        /**
         * @return The Organization (O) component of this name
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.500 -0500", hash_original_method = "7251BF6AE7EA38B61D97CF2E138787A6", hash_generated_method = "5ECD8CC7AC40046231E5BBD69A55A303")
        
public String getOName() {
            return mOName != null ? mOName : "";
        }

        /**
         * @return The Organizational Unit (OU) component of this name
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.502 -0500", hash_original_method = "372D1A5E33F38EEDF5C6B63F53532F1F", hash_generated_method = "522403B9925D9707FF9DEAFA8F56DC47")
        
public String getUName() {
            return mUName != null ? mUName : "";
        }

        
    }

    /**
     * @return Not-after date from the certificate validity period in
     * ISO 8601 format or "" if none has been set
     *
     * @deprecated Use {@link #getValidNotAfterDate()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.460 -0500", hash_original_method = "8855AE273E27E2CAD00A7550F7D75B05", hash_generated_method = "1A425A9CBA12924BA92645C35800760F")
    
@Deprecated
    public String getValidNotAfter() {
        return formatDate(mValidNotAfter);
    }

    /**
     * @return Issued-to distinguished name or null if none has been set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.462 -0500", hash_original_method = "2E4F61534C62139557AB31E5631377F2", hash_generated_method = "1BF26945FDDA44EA2BDEF45FC202106C")
    
public DName getIssuedTo() {
        return mIssuedTo;
    }

    /**
     * @return Issued-by distinguished name or null if none has been set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.464 -0500", hash_original_method = "82F93F0D2EB1DC97DAB6C30DC54F99BE", hash_generated_method = "B435466601289B58F6AC680736130DAD")
    
public DName getIssuedBy() {
        return mIssuedBy;
    }

    /**
     * @return A string representation of this certificate for debugging
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.474 -0500", hash_original_method = "F16D936F6355F1722DE333F4EC7C4E06", hash_generated_method = "F210421EBD3B1173ECF5FC877FC82B3E")
    
public String toString() {
        return ("Issued to: " + mIssuedTo.getDName() + ";\n"
                + "Issued by: " + mIssuedBy.getDName() + ";\n");
    }

    /**
     * Inflates the SSL certificate view (helper method).
     * @return The resultant certificate view with issued-to, issued-by,
     * issued-on, expires-on, and possibly other fields set.
     *
     * @hide Used by Browser and Settings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.508 -0500", hash_original_method = "D583B5DA5B2EDF3475293874A3D5A1D5", hash_generated_method = "BEF78A8054F61184E0951917CE78475B")
    
public View inflateCertificateView(Context context) {
        LayoutInflater factory = LayoutInflater.from(context);

        View certificateView = factory.inflate(
            com.android.internal.R.layout.ssl_certificate, null);

        // issued to:
        SslCertificate.DName issuedTo = getIssuedTo();
        if (issuedTo != null) {
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_common))
                    .setText(issuedTo.getCName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_org))
                    .setText(issuedTo.getOName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.to_org_unit))
                    .setText(issuedTo.getUName());
        }
        // serial number:
        ((TextView) certificateView.findViewById(com.android.internal.R.id.serial_number))
                .setText(getSerialNumber(mX509Certificate));

        // issued by:
        SslCertificate.DName issuedBy = getIssuedBy();
        if (issuedBy != null) {
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_common))
                    .setText(issuedBy.getCName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org))
                    .setText(issuedBy.getOName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org_unit))
                    .setText(issuedBy.getUName());
        }

        // issued on:
        String issuedOn = formatCertificateDate(context, getValidNotBeforeDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.issued_on))
                .setText(issuedOn);

        // expires on:
        String expiresOn = formatCertificateDate(context, getValidNotAfterDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.expires_on))
                .setText(expiresOn);

        // fingerprints:
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha256_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA256"));
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha1_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA1"));

        return certificateView;
    }

    /**
     * Formats the certificate date to a properly localized date string.
     * @return Properly localized version of the certificate date string and
     * the "" if it fails to localize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.511 -0500", hash_original_method = "AFB9B131464BD8BEA4E9664B02B81FAF", hash_generated_method = "A6CDB5BE793C81EFAEC5214801083006")
    
private String formatCertificateDate(Context context, Date certificateDate) {
        if (certificateDate == null) {
            return "";
        }
        return DateFormat.getDateFormat(context).format(certificateDate);
    }
}

