package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayInputStream;
import java.lang.ref.SoftReference;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

public class Signature implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.311 -0400", hash_original_field = "FC75508A279D3A4B73839B9A1CF5EE55", hash_generated_field = "82FF487F3BC72CD61B5A92D15C282FF7")

    private byte[] mSignature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.312 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.312 -0400", hash_original_field = "DA3577697B0DD709AF13F3080CF0FF14", hash_generated_field = "1E26145EC834378C0A9DBC88E0224A55")

    private boolean mHaveHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.312 -0400", hash_original_field = "1AFB5CB7071835101FAF1C82BAB11F44", hash_generated_field = "1DA2E56EBB947D41BB50077BEA325ECF")

    private SoftReference<String> mStringRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.317 -0400", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "35DC787169E2B15A0B726B2232D59558")
    public  Signature(byte[] signature) {
        mSignature = signature.clone();
        // ---------- Original Method ----------
        //mSignature = signature.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.338 -0400", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "80FAC6B9C90D0387C5F7457BB3CE39EB")
    public  Signature(String text) {
        byte[] input;
        input = text.getBytes();
        int N;
        N = input.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text size " + N + " is not even");
        } //End block
        byte[] sig;
        sig = new byte[N / 2];
        int sigIndex;
        sigIndex = 0;
        {
            int i;
            i = 0;
            {
                int hi;
                hi = parseHexDigit(input[i++]);
                int lo;
                lo = parseHexDigit(input[i++]);
                sig[sigIndex++] = (byte) ((hi << 4) | lo);
            } //End block
        } //End collapsed parenthetic
        mSignature = sig;
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //final byte[] input = text.getBytes();
        //final int N = input.length;
        //if (N % 2 != 0) {
            //throw new IllegalArgumentException("text size " + N + " is not even");
        //}
        //final byte[] sig = new byte[N / 2];
        //int sigIndex = 0;
        //for (int i = 0; i < N;) {
            //final int hi = parseHexDigit(input[i++]);
            //final int lo = parseHexDigit(input[i++]);
            //sig[sigIndex++] = (byte) ((hi << 4) | lo);
        //}
        //mSignature = sig;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.344 -0400", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "35AE48A1EC65609E4DC5E52450D21B19")
    private  Signature(Parcel source) {
        mSignature = source.createByteArray();
        // ---------- Original Method ----------
        //mSignature = source.createByteArray();
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.354 -0400", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "674725FA81B7D464FAAA3B49235F52FE")
    public char[] toChars() {
        char[] varA4185AFF435A5F9E12F848CF267BEF10_1630580236 = (toChars(null, null));
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1609390835 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1609390835;
        // ---------- Original Method ----------
        //return toChars(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.392 -0400", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "FAB60FE2D0E8973F6585DE482EFD2C6C")
    public char[] toChars(char[] existingArray, int[] outLen) {
        byte[] sig;
        sig = mSignature;
        int N;
        N = sig.length;
        int N2;
        N2 = N*2;
        char[] text;
        text = new char[N2];
        text = existingArray;
        {
            int j;
            j = 0;
            {
                byte v;
                v = sig[j];
                int d;
                d = (v>>4)&0xf;
                text[j*2] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
                d = v&0xf;
                text[j*2+1] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
            } //End block
        } //End collapsed parenthetic
        outLen[0] = N;
        addTaint(existingArray[0]);
        addTaint(outLen[0]);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1182619564 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1182619564;
        // ---------- Original Method ----------
        //byte[] sig = mSignature;
        //final int N = sig.length;
        //final int N2 = N*2;
        //char[] text = existingArray == null || N2 > existingArray.length
                //? new char[N2] : existingArray;
        //for (int j=0; j<N; j++) {
            //byte v = sig[j];
            //int d = (v>>4)&0xf;
            //text[j*2] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
            //d = v&0xf;
            //text[j*2+1] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
        //}
        //if (outLen != null) outLen[0] = N;
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.418 -0400", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "D22259EEF0EC9BC6E382D1682D7F0CBE")
    public String toCharsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1093476278 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_270974683 = null; //Variable for return #2
        String str;
        str = null;
        str = mStringRef.get();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1093476278 = str;
        } //End block
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
        varB4EAC82CA7396A68D541C85D26508E83_270974683 = str;
        String varA7E53CE21691AB073D9660D615818899_1807101722; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1807101722 = varB4EAC82CA7396A68D541C85D26508E83_1093476278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1807101722 = varB4EAC82CA7396A68D541C85D26508E83_270974683;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1807101722.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1807101722;
        // ---------- Original Method ----------
        //String str = mStringRef == null ? null : mStringRef.get();
        //if (str != null) {
            //return str;
        //}
        //str = new String(toChars());
        //mStringRef = new SoftReference<String>(str);
        //return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.420 -0400", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "C0FB45B29FE956159492921BD57B805C")
    public byte[] toByteArray() {
        byte[] bytes;
        bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_181930511 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_181930511;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[mSignature.length];
        //System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        //return bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.421 -0400", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "A295421E6B0C6C78F1AFA5C92935AF42")
    public PublicKey getPublicKey() throws CertificateException {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_879444101 = null; //Variable for return #1
        CertificateFactory certFactory;
        certFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(mSignature);
        Certificate cert;
        cert = certFactory.generateCertificate(bais);
        varB4EAC82CA7396A68D541C85D26508E83_879444101 = cert.getPublicKey();
        varB4EAC82CA7396A68D541C85D26508E83_879444101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_879444101;
        // ---------- Original Method ----------
        //final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        //final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        //final Certificate cert = certFactory.generateCertificate(bais);
        //return cert.getPublicKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.442 -0400", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "B9107A6679520F8832BEF7CF4996AD93")
    @Override
    public boolean equals(Object obj) {
        try 
        {
            {
                Signature other;
                other = (Signature)obj;
                boolean var93A7D6AE339F832ADAAF27B7F6ADCAAB_547044965 = (this == other || Arrays.equals(mSignature, other.mSignature));
            } //End block
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491092262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491092262;
        // ---------- Original Method ----------
        //try {
            //if (obj != null) {
                //Signature other = (Signature)obj;
                //return this == other || Arrays.equals(mSignature, other.mSignature);
            //}
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.450 -0400", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "7F0107A18C6CCAB98F79B5D01DD52CFB")
    @Override
    public int hashCode() {
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623393602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623393602;
        // ---------- Original Method ----------
        //if (mHaveHashCode) {
            //return mHashCode;
        //}
        //mHashCode = Arrays.hashCode(mSignature);
        //mHaveHashCode = true;
        //return mHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.451 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "248899BC7C5C73C80D05E00268E878F1")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140460938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140460938;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.452 -0400", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "F1A0DEAFEEC32F115F05764B8A85FA40")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeByteArray(mSignature);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeByteArray(mSignature);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.452 -0400", hash_original_field = "EF6321A08F8C07F931351347C004EC46", hash_generated_field = "D433CA4E2BE6EFC6C045D2BE6C7AFF6B")

    public static final Parcelable.Creator<Signature> CREATOR
            = new Parcelable.Creator<Signature>() {
        public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }

        public Signature[] newArray(int size) {
            return new Signature[size];
        }
    };
}

