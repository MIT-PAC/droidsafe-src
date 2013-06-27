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
import org.bouncycastle.asn1.x509.X509Name;

public class SslCertificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.081 -0400", hash_original_field = "903FF6B9C45D66198E077F15960795B3", hash_generated_field = "3A0F95171EDB19B88E8BBB2C224E603F")

    private DName mIssuedTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.081 -0400", hash_original_field = "2713B57792CAFFF258018585D1078C92", hash_generated_field = "B9F29B14DA0374C383549135A8B1A6E9")

    private DName mIssuedBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.081 -0400", hash_original_field = "9AE497B23A7516D7DC9BA9B79969A9E6", hash_generated_field = "790C1877C241C6BC4E21841CE6B9480E")

    private Date mValidNotBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.082 -0400", hash_original_field = "CC4C7757B440A28DFA40D92FCBA7195B", hash_generated_field = "F2FF1888752CADA242EFC5AEF50063B0")

    private Date mValidNotAfter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.082 -0400", hash_original_field = "03D448D61BEE37D4F94B5890AF3FBBB3", hash_generated_field = "537A6CC67DC1E04E8C3F9E6F30614000")

    private X509Certificate mX509Certificate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.089 -0400", hash_original_method = "C9600F8F1BB8A8C873CC4C3FEC87FEF5", hash_generated_method = "4F0AE3F10D2E9283B0CB56186B377EC4")
    @Deprecated
    public  SslCertificate(
            String issuedTo, String issuedBy, String validNotBefore, String validNotAfter) {
        this(issuedTo, issuedBy, parseDate(validNotBefore), parseDate(validNotAfter), null);
        addTaint(issuedTo.getTaint());
        addTaint(issuedBy.getTaint());
        addTaint(validNotBefore.getTaint());
        addTaint(validNotAfter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.090 -0400", hash_original_method = "D87F049394C2BF8E430D24ECC769A568", hash_generated_method = "B2101149C72350DFE70939A2556607EB")
    @Deprecated
    public  SslCertificate(
            String issuedTo, String issuedBy, Date validNotBefore, Date validNotAfter) {
        this(issuedTo, issuedBy, validNotBefore, validNotAfter, null);
        addTaint(issuedTo.getTaint());
        addTaint(issuedBy.getTaint());
        addTaint(validNotBefore.getTaint());
        addTaint(validNotAfter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.090 -0400", hash_original_method = "44DDC0F9828E23A0D6B9681282E4B5EC", hash_generated_method = "34D5FAB1DF1CFEF607E2022094F3199A")
    public  SslCertificate(X509Certificate certificate) {
        this(certificate.getSubjectDN().getName(),
             certificate.getIssuerDN().getName(),
             certificate.getNotBefore(),
             certificate.getNotAfter(),
             certificate);
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.092 -0400", hash_original_method = "EBF5C56E3FBE1E8BC5B0F01C28F68A19", hash_generated_method = "D5C97C2B3842B3CC6467841F292BF5A7")
    private  SslCertificate(
            String issuedTo, String issuedBy,
            Date validNotBefore, Date validNotAfter,
            X509Certificate x509Certificate) {
        mIssuedTo = new DName(issuedTo);
        mIssuedBy = new DName(issuedBy);
        mValidNotBefore = cloneDate(validNotBefore);
        mValidNotAfter  = cloneDate(validNotAfter);
        mX509Certificate = x509Certificate;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.106 -0400", hash_original_method = "86D829D0BCD4BD19D84EADD31DD5FCE1", hash_generated_method = "269C4F55D5A50197E75205A0578A7ACB")
    public Date getValidNotBeforeDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_996791791 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_996791791 = cloneDate(mValidNotBefore);
        varB4EAC82CA7396A68D541C85D26508E83_996791791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996791791;
        // ---------- Original Method ----------
        //return cloneDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.126 -0400", hash_original_method = "E74141FEB26284E4BA15E02DC99CE923", hash_generated_method = "DBE6A1C45F205FEF96A311970A89C672")
    @Deprecated
    public String getValidNotBefore() {
        String varB4EAC82CA7396A68D541C85D26508E83_1167486033 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1167486033 = formatDate(mValidNotBefore);
        varB4EAC82CA7396A68D541C85D26508E83_1167486033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167486033;
        // ---------- Original Method ----------
        //return formatDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.127 -0400", hash_original_method = "5976F2F67CC4D55E479FF99F5BD66B52", hash_generated_method = "ACBB1C2157473DA53E6BCDAC347F060C")
    public Date getValidNotAfterDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1718030789 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1718030789 = cloneDate(mValidNotAfter);
        varB4EAC82CA7396A68D541C85D26508E83_1718030789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1718030789;
        // ---------- Original Method ----------
        //return cloneDate(mValidNotAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.128 -0400", hash_original_method = "8855AE273E27E2CAD00A7550F7D75B05", hash_generated_method = "5C35F5B47CE3D78BFE826B7A98A7FC65")
    @Deprecated
    public String getValidNotAfter() {
        String varB4EAC82CA7396A68D541C85D26508E83_601090700 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_601090700 = formatDate(mValidNotAfter);
        varB4EAC82CA7396A68D541C85D26508E83_601090700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_601090700;
        // ---------- Original Method ----------
        //return formatDate(mValidNotAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.142 -0400", hash_original_method = "2E4F61534C62139557AB31E5631377F2", hash_generated_method = "ECAB3D2E0E19DCC822731962A7A2F4F9")
    public DName getIssuedTo() {
        DName varB4EAC82CA7396A68D541C85D26508E83_1014037865 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1014037865 = mIssuedTo;
        varB4EAC82CA7396A68D541C85D26508E83_1014037865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014037865;
        // ---------- Original Method ----------
        //return mIssuedTo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.142 -0400", hash_original_method = "82F93F0D2EB1DC97DAB6C30DC54F99BE", hash_generated_method = "45138566620465AB72A4D4FEC1ED192F")
    public DName getIssuedBy() {
        DName varB4EAC82CA7396A68D541C85D26508E83_855786842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_855786842 = mIssuedBy;
        varB4EAC82CA7396A68D541C85D26508E83_855786842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855786842;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.144 -0400", hash_original_method = "F16D936F6355F1722DE333F4EC7C4E06", hash_generated_method = "3252BE4819D8D61FA21F47465004700E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_345008584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345008584 = ("Issued to: " + mIssuedTo.getDName() + ";\n"
                + "Issued by: " + mIssuedBy.getDName() + ";\n");
        varB4EAC82CA7396A68D541C85D26508E83_345008584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345008584;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.177 -0400", hash_original_method = "D583B5DA5B2EDF3475293874A3D5A1D5", hash_generated_method = "758ADD0122AB08CD9A16BA67C01FC060")
    public View inflateCertificateView(Context context) {
        View varB4EAC82CA7396A68D541C85D26508E83_624719122 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_624719122 = certificateView;
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_624719122.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_624719122;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.190 -0400", hash_original_method = "AFB9B131464BD8BEA4E9664B02B81FAF", hash_generated_method = "393BCCEBBC6D11D73545BC0473747F26")
    private String formatCertificateDate(Context context, Date certificateDate) {
        String varB4EAC82CA7396A68D541C85D26508E83_2033622309 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1429395703 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2033622309 = "";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1429395703 = DateFormat.getDateFormat(context).format(certificateDate);
        addTaint(context.getTaint());
        addTaint(certificateDate.getTaint());
        String varA7E53CE21691AB073D9660D615818899_704181463; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_704181463 = varB4EAC82CA7396A68D541C85D26508E83_2033622309;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_704181463 = varB4EAC82CA7396A68D541C85D26508E83_1429395703;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_704181463.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_704181463;
        // ---------- Original Method ----------
        //if (certificateDate == null) {
            //return "";
        //}
        //return DateFormat.getDateFormat(context).format(certificateDate);
    }

    
    public class DName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.190 -0400", hash_original_field = "5F938BBB8AFADBDC456DECCAD73D873D", hash_generated_field = "3BD097ADC1AABD13C2B47840D547843E")

        private String mDName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.190 -0400", hash_original_field = "4901BE78F34BEE7E6EE6F0BB35EB86E3", hash_generated_field = "C87DD36180CC90C09336CD9600FB7BD5")

        private String mCName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.190 -0400", hash_original_field = "5E03B3843101FD86980AFF7A10BEB95F", hash_generated_field = "626F524368BB49A1B4C2CC3A1865A29C")

        private String mOName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.190 -0400", hash_original_field = "4B7A77B73E9B144EB39C55C4A64CF181", hash_generated_field = "B3038D70C29815EB8360E3A3B8924901")

        private String mUName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.192 -0400", hash_original_method = "E1EC1A01B7E978D9F78C671CC9D0E725", hash_generated_method = "9203FDCE64B80A5482414D1896E6D48E")
        public  DName(String dName) {
            {
                mDName = dName;
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
                        boolean var81398A3258B14BF4B3BCED5C96BDA2E4_1371990580 = (i < oid.size());
                        {
                            {
                                boolean var0C6F0BE758D98D60EBB9B16537698F57_720466630 = (oid.elementAt(i).equals(X509Name.CN));
                                {
                                    mCName = (String) val.elementAt(i);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var06E8299BDF4B0086B47388185FF81940_1646014518 = (oid.elementAt(i).equals(X509Name.O));
                                {
                                    mOName = (String) val.elementAt(i);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var66A9551431E1DEC1988477609E15738C_898003599 = (oid.elementAt(i).equals(X509Name.OU));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.204 -0400", hash_original_method = "CA7B7457EAE364E31ECFC3E240698ADB", hash_generated_method = "17A0FB7D03CFC745964D0F58FBEF7356")
        public String getDName() {
            String varB4EAC82CA7396A68D541C85D26508E83_760556113 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_760556113 = mDName != null ? mDName : "";
            varB4EAC82CA7396A68D541C85D26508E83_760556113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_760556113;
            // ---------- Original Method ----------
            //return mDName != null ? mDName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.205 -0400", hash_original_method = "9443834DD976C880848529D9F73675CC", hash_generated_method = "A6D6BEC10EE78426D2128FB0742ED267")
        public String getCName() {
            String varB4EAC82CA7396A68D541C85D26508E83_695203280 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_695203280 = mCName != null ? mCName : "";
            varB4EAC82CA7396A68D541C85D26508E83_695203280.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_695203280;
            // ---------- Original Method ----------
            //return mCName != null ? mCName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.206 -0400", hash_original_method = "7251BF6AE7EA38B61D97CF2E138787A6", hash_generated_method = "3577B6DBFAFEE04E6C00EE8EEA40CABE")
        public String getOName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1437351575 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1437351575 = mOName != null ? mOName : "";
            varB4EAC82CA7396A68D541C85D26508E83_1437351575.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1437351575;
            // ---------- Original Method ----------
            //return mOName != null ? mOName : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.207 -0400", hash_original_method = "372D1A5E33F38EEDF5C6B63F53532F1F", hash_generated_method = "542040E85F52DBC1C827CC85292D071E")
        public String getUName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1302084843 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1302084843 = mUName != null ? mUName : "";
            varB4EAC82CA7396A68D541C85D26508E83_1302084843.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1302084843;
            // ---------- Original Method ----------
            //return mUName != null ? mUName : "";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "0BE03CB8DBB5E43A8987BE73AB3E62E7", hash_generated_field = "796221E87930E845E5EA421C8E86DFF6")

    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "6038FAE9B66FC238A4A8C3BC2AA8D59D", hash_generated_field = "6730EC664F44D63E119029567A876A34")

    private static String ISSUED_TO = "issued-to";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "33DF474EB989DECE12CA9D6AFA439E16", hash_generated_field = "FFDA12CF5E4F2639561DD43F428EEC1F")

    private static String ISSUED_BY = "issued-by";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "6CBCF566D59447EA2898EB387ECA3FAB", hash_generated_field = "C2413397A4A8A785C97D61866D461ABC")

    private static String VALID_NOT_BEFORE = "valid-not-before";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "FD14D4EA7A8D2F254CDB884C292AA877", hash_generated_field = "70CAEB90865E5B42B5EE54CEE6E25A27")

    private static String VALID_NOT_AFTER = "valid-not-after";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.215 -0400", hash_original_field = "553138DE05F5412869145C00562567A6", hash_generated_field = "FB265D58B2072BC2EC06F86AC1A9A348")

    private static String X509_CERTIFICATE = "x509-certificate";
}

