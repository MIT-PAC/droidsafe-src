package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.lang.ref.SoftReference;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

import android.os.Parcel;
import android.os.Parcelable;

public class Signature implements Parcelable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.800 -0500", hash_original_method = "2EFDF66421CB71AEE738679CD64484B1", hash_generated_method = "2CC9D14C5DECE3F63B13E21D77780F06")
    
private static final int parseHexDigit(int nibble) {
        if ('0' <= nibble && nibble <= '9') {
            return nibble - '0';
        } else if ('a' <= nibble && nibble <= 'f') {
            return nibble - 'a' + 10;
        } else if ('A' <= nibble && nibble <= 'F') {
            return nibble - 'A' + 10;
        } else {
            throw new IllegalArgumentException("Invalid character " + nibble + " in hex string");
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.791 -0400", hash_original_field = "EF6321A08F8C07F931351347C004EC46", hash_generated_field = "D433CA4E2BE6EFC6C045D2BE6C7AFF6B")

    public static final Parcelable.Creator<Signature> CREATOR
            = new Parcelable.Creator<Signature>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.828 -0500", hash_original_method = "59AB50688ABB8B89A247E93F4C76880C", hash_generated_method = "94463D2ECA0FB0B4DCCBF0065392C4B9")
        
public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.830 -0500", hash_original_method = "910E548F13237BE241520EC845542C7B", hash_generated_method = "DB7610611C892942AB430B2B71C70D0E")
        
public Signature[] newArray(int size) {
            return new Signature[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.788 -0500", hash_original_field = "E63712AB53701E0642EF9DDDC3898081", hash_generated_field = "82FF487F3BC72CD61B5A92D15C282FF7")

    private  byte[] mSignature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.790 -0500", hash_original_field = "A13152B9FE22A291FA8BF7E71C005049", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.792 -0500", hash_original_field = "674DB2511805B4D68885D7E4A8D1301D", hash_generated_field = "1E26145EC834378C0A9DBC88E0224A55")

    private boolean mHaveHashCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.794 -0500", hash_original_field = "C7B071430DEF8FE92B374A177870100E", hash_generated_field = "1DA2E56EBB947D41BB50077BEA325ECF")

    private SoftReference<String> mStringRef;

    /**
     * Create Signature from an existing raw byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.797 -0500", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "9D9F09BCA00ADEF6E37839FEA4228DCD")
    
public Signature(byte[] signature) {
        mSignature = signature.clone();
    }

    /**
     * Create Signature from a text representation previously returned by
     * {@link #toChars} or {@link #toCharsString()}. Signatures are expected to
     * be a hex-encoded ASCII string.
     *
     * @param text hex-encoded string representing the signature
     * @throws IllegalArgumentException when signature is odd-length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.803 -0500", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "1F26B13FDD2424B6CCB41EE17BFFBB2E")
    
public Signature(String text) {
        final byte[] input = text.getBytes();
        final int N = input.length;

        if (N % 2 != 0) {
            throw new IllegalArgumentException("text size " + N + " is not even");
        }

        final byte[] sig = new byte[N / 2];
        int sigIndex = 0;

        for (int i = 0; i < N;) {
            final int hi = parseHexDigit(input[i++]);
            final int lo = parseHexDigit(input[i++]);
            sig[sigIndex++] = (byte) ((hi << 4) | lo);
        }

        mSignature = sig;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.834 -0500", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "60EE1FF730337042BFF564400F648ED1")
    
private Signature(Parcel source) {
        mSignature = source.createByteArray();
    }

    /**
     * Encode the Signature as ASCII text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.805 -0500", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "0CEDB44E2ECF4C1E1C864C156289461C")
    
public char[] toChars() {
        return toChars(null, null);
    }

    /**
     * Encode the Signature as ASCII text in to an existing array.
     *
     * @param existingArray Existing char array or null.
     * @param outLen Output parameter for the number of characters written in
     * to the array.
     * @return Returns either <var>existingArray</var> if it was large enough
     * to hold the ASCII representation, or a newly created char[] array if
     * needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.807 -0500", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "FA79E3433392288203339D438AD103C4")
    
public char[] toChars(char[] existingArray, int[] outLen) {
        byte[] sig = mSignature;
        final int N = sig.length;
        final int N2 = N*2;
        char[] text = existingArray == null || N2 > existingArray.length
                ? new char[N2] : existingArray;
        for (int j=0; j<N; j++) {
            byte v = sig[j];
            int d = (v>>4)&0xf;
            text[j*2] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
            d = v&0xf;
            text[j*2+1] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
        }
        if (outLen != null) outLen[0] = N;
        return text;
    }

    /**
     * Return the result of {@link #toChars()} as a String.
     */
    @DSComment("nothing useful out of signature")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.810 -0500", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "CF08BA09345112F19780B30497196162")
    
public String toCharsString() {
        String str = mStringRef == null ? null : mStringRef.get();
        if (str != null) {
            return str;
        }
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
        return str;
    }

    /**
     * @return the contents of this signature as a byte array.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.812 -0500", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "06EEAF99EBA8544F9705EB43B42F11CC")
    
public byte[] toByteArray() {
        byte[] bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        return bytes;
    }

    /**
     * Returns the public key for this signature.
     *
     * @throws CertificateException when Signature isn't a valid X.509
     *             certificate; shouldn't happen.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.815 -0500", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "CAEEC1672220C2BD4280F7D0DA8400F4")
    
public PublicKey getPublicKey() throws CertificateException {
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        final Certificate cert = certFactory.generateCertificate(bais);
        return cert.getPublicKey();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.817 -0500", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "D6FD3B0353D1CDA901DCA0F4761C00F6")
    
@Override
    public boolean equals(Object obj) {
        try {
            if (obj != null) {
                Signature other = (Signature)obj;
                return toTaintBoolean(getTaintInt() + other.getTaintInt() + 
                                     mSignature.getTaintInt() + other.mSignature.getTaintInt());
                //return this == other || Arrays.equals(mSignature, other.mSignature);
            }
        } catch (ClassCastException e) {
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.820 -0500", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "E1E055FCA73BA1F4A7886CB254AA07A2")
    
@Override
    public int hashCode() {
        if (mHaveHashCode) {
            return mHashCode;
        }
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        return mHashCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.822 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:44.824 -0500", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "3F8350DF19398779906AB017C7EBA0BD")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeByteArray(mSignature);
    }
    // orphaned legacy method
    public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }
    
    // orphaned legacy method
    public Signature[] newArray(int size) {
            return new Signature[size];
        }
    
}

