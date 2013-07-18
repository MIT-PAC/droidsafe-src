package android.net.http;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SslCertificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_field = "903FF6B9C45D66198E077F15960795B3", hash_generated_field = "3A0F95171EDB19B88E8BBB2C224E603F")

    private DName mIssuedTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_field = "2713B57792CAFFF258018585D1078C92", hash_generated_field = "B9F29B14DA0374C383549135A8B1A6E9")

    private DName mIssuedBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_field = "9AE497B23A7516D7DC9BA9B79969A9E6", hash_generated_field = "790C1877C241C6BC4E21841CE6B9480E")

    private Date mValidNotBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_field = "CC4C7757B440A28DFA40D92FCBA7195B", hash_generated_field = "F2FF1888752CADA242EFC5AEF50063B0")

    private Date mValidNotAfter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_field = "03D448D61BEE37D4F94B5890AF3FBBB3", hash_generated_field = "537A6CC67DC1E04E8C3F9E6F30614000")

    private X509Certificate mX509Certificate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.937 -0400", hash_original_method = "C9600F8F1BB8A8C873CC4C3FEC87FEF5", hash_generated_method = "E467D64F4982973298E8C8291C303E5E")
    @Deprecated
    public  SslCertificate(
            String issuedTo, String issuedBy, String validNotBefore, String validNotAfter) {
        this(issuedTo, issuedBy, parseDate(validNotBefore), parseDate(validNotAfter), null);
        addTaint(validNotAfter.getTaint());
        addTaint(validNotBefore.getTaint());
        addTaint(issuedBy.getTaint());
        addTaint(issuedTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.938 -0400", hash_original_method = "D87F049394C2BF8E430D24ECC769A568", hash_generated_method = "2DAEC93E0C1798DCF8AD570C64F78238")
    @Deprecated
    public  SslCertificate(
            String issuedTo, String issuedBy, Date validNotBefore, Date validNotAfter) {
        this(issuedTo, issuedBy, validNotBefore, validNotAfter, null);
        addTaint(validNotAfter.getTaint());
        addTaint(validNotBefore.getTaint());
        addTaint(issuedBy.getTaint());
        addTaint(issuedTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.938 -0400", hash_original_method = "44DDC0F9828E23A0D6B9681282E4B5EC", hash_generated_method = "34D5FAB1DF1CFEF607E2022094F3199A")
    public  SslCertificate(X509Certificate certificate) {
        this(certificate.getSubjectDN().getName(),
             certificate.getIssuerDN().getName(),
             certificate.getNotBefore(),
             certificate.getNotAfter(),
             certificate);
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.939 -0400", hash_original_method = "EBF5C56E3FBE1E8BC5B0F01C28F68A19", hash_generated_method = "D5C97C2B3842B3CC6467841F292BF5A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.940 -0400", hash_original_method = "86D829D0BCD4BD19D84EADD31DD5FCE1", hash_generated_method = "789439C1347326062DC142CEA69FDF90")
    public Date getValidNotBeforeDate() {
Date var888124D2AF52A13A16838979247477EF_1880281343 =         cloneDate(mValidNotBefore);
        var888124D2AF52A13A16838979247477EF_1880281343.addTaint(taint);
        return var888124D2AF52A13A16838979247477EF_1880281343;
        // ---------- Original Method ----------
        //return cloneDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.940 -0400", hash_original_method = "E74141FEB26284E4BA15E02DC99CE923", hash_generated_method = "2D017A2144345BCF4CE0E9767DE9C8D8")
    @Deprecated
    public String getValidNotBefore() {
String var8EA6787CA3942732667A1A413F7D73D2_839497423 =         formatDate(mValidNotBefore);
        var8EA6787CA3942732667A1A413F7D73D2_839497423.addTaint(taint);
        return var8EA6787CA3942732667A1A413F7D73D2_839497423;
        // ---------- Original Method ----------
        //return formatDate(mValidNotBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.941 -0400", hash_original_method = "5976F2F67CC4D55E479FF99F5BD66B52", hash_generated_method = "261771B7FC3F862FEFC34518CB70A907")
    public Date getValidNotAfterDate() {
Date var5B80FBA32B2E5EDCBD83079545420CD6_1518830533 =         cloneDate(mValidNotAfter);
        var5B80FBA32B2E5EDCBD83079545420CD6_1518830533.addTaint(taint);
        return var5B80FBA32B2E5EDCBD83079545420CD6_1518830533;
        // ---------- Original Method ----------
        //return cloneDate(mValidNotAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.941 -0400", hash_original_method = "8855AE273E27E2CAD00A7550F7D75B05", hash_generated_method = "874E52221374AF4A47CCC51FC52157CE")
    @Deprecated
    public String getValidNotAfter() {
String var5E03B79E55F41967AD2659800720A8BE_1996141943 =         formatDate(mValidNotAfter);
        var5E03B79E55F41967AD2659800720A8BE_1996141943.addTaint(taint);
        return var5E03B79E55F41967AD2659800720A8BE_1996141943;
        // ---------- Original Method ----------
        //return formatDate(mValidNotAfter);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.941 -0400", hash_original_method = "2E4F61534C62139557AB31E5631377F2", hash_generated_method = "1942B94ABC17C78BC03D6D82F1A57584")
    public DName getIssuedTo() {
DName var78BC96B113155E7EF78A0F7019405602_563307201 =         mIssuedTo;
        var78BC96B113155E7EF78A0F7019405602_563307201.addTaint(taint);
        return var78BC96B113155E7EF78A0F7019405602_563307201;
        // ---------- Original Method ----------
        //return mIssuedTo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.942 -0400", hash_original_method = "82F93F0D2EB1DC97DAB6C30DC54F99BE", hash_generated_method = "447FA143DFFFC53FC3E4D2D3A44A5772")
    public DName getIssuedBy() {
DName var9A957C3D1EADCF1F564E726204D0B108_890394318 =         mIssuedBy;
        var9A957C3D1EADCF1F564E726204D0B108_890394318.addTaint(taint);
        return var9A957C3D1EADCF1F564E726204D0B108_890394318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.944 -0400", hash_original_method = "F16D936F6355F1722DE333F4EC7C4E06", hash_generated_method = "8C0C6305B183201BA8BB48CCA7AC1B32")
    public String toString() {
String var5BB6BFF63AB3DCE39B416D031BC3D7D9_1577345488 =         ("Issued to: " + mIssuedTo.getDName() + ";\n"
                + "Issued by: " + mIssuedBy.getDName() + ";\n");
        var5BB6BFF63AB3DCE39B416D031BC3D7D9_1577345488.addTaint(taint);
        return var5BB6BFF63AB3DCE39B416D031BC3D7D9_1577345488;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.946 -0400", hash_original_method = "D583B5DA5B2EDF3475293874A3D5A1D5", hash_generated_method = "81A4520E3B698E7E5829FCDC0A666C7D")
    public View inflateCertificateView(Context context) {
        addTaint(context.getTaint());
        LayoutInflater factory = LayoutInflater.from(context);
        View certificateView = factory.inflate(
            com.android.internal.R.layout.ssl_certificate, null);
        SslCertificate.DName issuedTo = getIssuedTo();
        if(issuedTo != null)        
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
        SslCertificate.DName issuedBy = getIssuedBy();
        if(issuedBy != null)        
        {
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_common))
                    .setText(issuedBy.getCName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org))
                    .setText(issuedBy.getOName());
            ((TextView) certificateView.findViewById(com.android.internal.R.id.by_org_unit))
                    .setText(issuedBy.getUName());
        } //End block
        String issuedOn = formatCertificateDate(context, getValidNotBeforeDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.issued_on))
                .setText(issuedOn);
        String expiresOn = formatCertificateDate(context, getValidNotAfterDate());
        ((TextView) certificateView.findViewById(com.android.internal.R.id.expires_on))
                .setText(expiresOn);
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha256_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA256"));
        ((TextView) certificateView.findViewById(com.android.internal.R.id.sha1_fingerprint))
                .setText(getDigest(mX509Certificate, "SHA1"));
View varFC33B9A8916B0D6941F38F3EDB46A4C6_2046476596 =         certificateView;
        varFC33B9A8916B0D6941F38F3EDB46A4C6_2046476596.addTaint(taint);
        return varFC33B9A8916B0D6941F38F3EDB46A4C6_2046476596;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.947 -0400", hash_original_method = "AFB9B131464BD8BEA4E9664B02B81FAF", hash_generated_method = "795EA1F1BCAB3EBD6557DCB7491A38C0")
    private String formatCertificateDate(Context context, Date certificateDate) {
        addTaint(certificateDate.getTaint());
        addTaint(context.getTaint());
        if(certificateDate == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_452604977 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_452604977.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_452604977;
        } //End block
String var6BA2A45151073C97041D6DB255D79206_69745701 =         DateFormat.getDateFormat(context).format(certificateDate);
        var6BA2A45151073C97041D6DB255D79206_69745701.addTaint(taint);
        return var6BA2A45151073C97041D6DB255D79206_69745701;
        // ---------- Original Method ----------
        //if (certificateDate == null) {
            //return "";
        //}
        //return DateFormat.getDateFormat(context).format(certificateDate);
    }

    
    public class DName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.947 -0400", hash_original_field = "5F938BBB8AFADBDC456DECCAD73D873D", hash_generated_field = "3BD097ADC1AABD13C2B47840D547843E")

        private String mDName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.947 -0400", hash_original_field = "4901BE78F34BEE7E6EE6F0BB35EB86E3", hash_generated_field = "C87DD36180CC90C09336CD9600FB7BD5")

        private String mCName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.947 -0400", hash_original_field = "5E03B3843101FD86980AFF7A10BEB95F", hash_generated_field = "626F524368BB49A1B4C2CC3A1865A29C")

        private String mOName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.947 -0400", hash_original_field = "4B7A77B73E9B144EB39C55C4A64CF181", hash_generated_field = "B3038D70C29815EB8360E3A3B8924901")

        private String mUName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_method = "E1EC1A01B7E978D9F78C671CC9D0E725", hash_generated_method = "4DE17CBE0D9CFC5AC493D83A291D565F")
        public  DName(String dName) {
            if(dName != null)            
            {
                mDName = dName;
                try 
                {
                    X509Name x509Name = new X509Name(dName);
                    Vector val = x509Name.getValues();
                    Vector oid = x509Name.getOIDs();
for(int i = 0;i < oid.size();i++)
                    {
                        if(oid.elementAt(i).equals(X509Name.CN))                        
                        {
                            mCName = (String) val.elementAt(i);
                            continue;
                        } //End block
                        if(oid.elementAt(i).equals(X509Name.O))                        
                        {
                            mOName = (String) val.elementAt(i);
                            continue;
                        } //End block
                        if(oid.elementAt(i).equals(X509Name.OU))                        
                        {
                            mUName = (String) val.elementAt(i);
                            continue;
                        } //End block
                    } //End block
                } //End block
                catch (IllegalArgumentException ex)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_method = "CA7B7457EAE364E31ECFC3E240698ADB", hash_generated_method = "6449988DBC064F922E6D9702577DED1B")
        public String getDName() {
String var0E412BB8426FC857F1D98F5ADB1C1FE8_1946877753 =             mDName != null ? mDName : "";
            var0E412BB8426FC857F1D98F5ADB1C1FE8_1946877753.addTaint(taint);
            return var0E412BB8426FC857F1D98F5ADB1C1FE8_1946877753;
            // ---------- Original Method ----------
            //return mDName != null ? mDName : "";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_method = "9443834DD976C880848529D9F73675CC", hash_generated_method = "D2A3C64DF2D73263DB5CC2B901B737A5")
        public String getCName() {
String var41CD0A3353DF8C88F8F9C93A3283E0F6_1718678830 =             mCName != null ? mCName : "";
            var41CD0A3353DF8C88F8F9C93A3283E0F6_1718678830.addTaint(taint);
            return var41CD0A3353DF8C88F8F9C93A3283E0F6_1718678830;
            // ---------- Original Method ----------
            //return mCName != null ? mCName : "";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_method = "7251BF6AE7EA38B61D97CF2E138787A6", hash_generated_method = "42098FADAF9FF366834737EC825A18CC")
        public String getOName() {
String var967E7ADD7E55EBF6EE5F55E7DF597DB1_253411408 =             mOName != null ? mOName : "";
            var967E7ADD7E55EBF6EE5F55E7DF597DB1_253411408.addTaint(taint);
            return var967E7ADD7E55EBF6EE5F55E7DF597DB1_253411408;
            // ---------- Original Method ----------
            //return mOName != null ? mOName : "";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_method = "372D1A5E33F38EEDF5C6B63F53532F1F", hash_generated_method = "7C6181E3D1055A305ADAB582BD3E3976")
        public String getUName() {
String var3435F5434D6FC903E03BAEAFBF2E316F_1360649979 =             mUName != null ? mUName : "";
            var3435F5434D6FC903E03BAEAFBF2E316F_1360649979.addTaint(taint);
            return var3435F5434D6FC903E03BAEAFBF2E316F_1360649979;
            // ---------- Original Method ----------
            //return mUName != null ? mUName : "";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_field = "0BE03CB8DBB5E43A8987BE73AB3E62E7", hash_generated_field = "796221E87930E845E5EA421C8E86DFF6")

    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.948 -0400", hash_original_field = "6038FAE9B66FC238A4A8C3BC2AA8D59D", hash_generated_field = "1FA9058DFCEB0C71DF564270AF5B6408")

    private static final String ISSUED_TO = "issued-to";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.949 -0400", hash_original_field = "33DF474EB989DECE12CA9D6AFA439E16", hash_generated_field = "450A14773231679E30D473C0C7417E49")

    private static final String ISSUED_BY = "issued-by";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.949 -0400", hash_original_field = "6CBCF566D59447EA2898EB387ECA3FAB", hash_generated_field = "FA241E5FEC8DD303C71111D6A40A9996")

    private static final String VALID_NOT_BEFORE = "valid-not-before";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.949 -0400", hash_original_field = "FD14D4EA7A8D2F254CDB884C292AA877", hash_generated_field = "E334FB13549F22C81A060A785A190C49")

    private static final String VALID_NOT_AFTER = "valid-not-after";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.949 -0400", hash_original_field = "553138DE05F5412869145C00562567A6", hash_generated_field = "F4AFCD170B64578A035371E0CFCC64E2")

    private static final String X509_CERTIFICATE = "x509-certificate";
}

