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
    private byte[] mSignature;
    private int mHashCode;
    private boolean mHaveHashCode;
    private SoftReference<String> mStringRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.973 -0400", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "7ABB01D9845D572B894AFC033D3FC924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Signature(byte[] signature) {
        dsTaint.addTaint(signature[0]);
        mSignature = signature.clone();
        // ---------- Original Method ----------
        //mSignature = signature.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.973 -0400", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "E2B528320C9F8107B4BE78F91CBD4FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Signature(String text) {
        dsTaint.addTaint(text);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.974 -0400", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "F39AFB2EA6E0D628DD581DEA20C2C263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Signature(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.974 -0400", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "6BD483063A9E6ECD2C7B4F20C2953E5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] toChars() {
        char[] varA4185AFF435A5F9E12F848CF267BEF10_361677796 = (toChars(null, null));
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return toChars(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.975 -0400", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "253DF2C9B89B0C538CBBCB90CF8EE201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] toChars(char[] existingArray, int[] outLen) {
        dsTaint.addTaint(outLen[0]);
        dsTaint.addTaint(existingArray[0]);
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
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.975 -0400", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "502516074E6561E7F9A90293DEC02EAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toCharsString() {
        String str;
        str = null;
        str = mStringRef.get();
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mStringRef == null ? null : mStringRef.get();
        //if (str != null) {
            //return str;
        //}
        //str = new String(toChars());
        //mStringRef = new SoftReference<String>(str);
        //return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.975 -0400", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "EEF5220A22BD5B5B0E7DFD2E23C08183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] toByteArray() {
        byte[] bytes;
        bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[mSignature.length];
        //System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        //return bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.976 -0400", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "BD09D2D3E40F30943163F60DFD50E2C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PublicKey getPublicKey() throws CertificateException {
        CertificateFactory certFactory;
        certFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(mSignature);
        Certificate cert;
        cert = certFactory.generateCertificate(bais);
        PublicKey var0EF176211D141EA8A03A77FB9CD669E5_695903360 = (cert.getPublicKey());
        return (PublicKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        //final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        //final Certificate cert = certFactory.generateCertificate(bais);
        //return cert.getPublicKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.976 -0400", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "79A783C41BAE711B1532DAEDAA1BC828")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        try 
        {
            {
                Signature other;
                other = (Signature)obj;
                boolean var93A7D6AE339F832ADAAF27B7F6ADCAAB_1463705162 = (this == other || Arrays.equals(mSignature, other.mSignature));
            } //End block
        } //End block
        catch (ClassCastException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.976 -0400", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "EA24D37ED178514F14FBAFF31915489B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mHaveHashCode) {
            //return mHashCode;
        //}
        //mHashCode = Arrays.hashCode(mSignature);
        //mHaveHashCode = true;
        //return mHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.976 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.977 -0400", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "927D2AE5892E93E637D56A51BD56DAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeByteArray(mSignature);
        // ---------- Original Method ----------
        //dest.writeByteArray(mSignature);
    }

    
    public static final Parcelable.Creator<Signature> CREATOR = new Parcelable.Creator<Signature>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.977 -0400", hash_original_method = "59AB50688ABB8B89A247E93F4C76880C", hash_generated_method = "2335ABE38510F9F63B23ED0956B89E21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Signature createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            Signature var56BA3AE71DAEEFAA30CD0531591BFD02_1606504921 = (new Signature(source));
            return (Signature)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Signature(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.977 -0400", hash_original_method = "910E548F13237BE241520EC845542C7B", hash_generated_method = "8B63D3788DBF007CBC4DAF0545A0C137")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Signature[] newArray(int size) {
            dsTaint.addTaint(size);
            Signature[] var58595B1D34FA575816F52D62548F24E1_1332869516 = (new Signature[size]);
            return (Signature[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Signature[size];
        }

        
}; //Transformed anonymous class
}

