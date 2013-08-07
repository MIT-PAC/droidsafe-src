package android.content.pm;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.778 -0400", hash_original_field = "FC75508A279D3A4B73839B9A1CF5EE55", hash_generated_field = "82FF487F3BC72CD61B5A92D15C282FF7")

    private byte[] mSignature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.779 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.779 -0400", hash_original_field = "DA3577697B0DD709AF13F3080CF0FF14", hash_generated_field = "1E26145EC834378C0A9DBC88E0224A55")

    private boolean mHaveHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.779 -0400", hash_original_field = "1AFB5CB7071835101FAF1C82BAB11F44", hash_generated_field = "1DA2E56EBB947D41BB50077BEA325ECF")

    private SoftReference<String> mStringRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.780 -0400", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "35DC787169E2B15A0B726B2232D59558")
    public  Signature(byte[] signature) {
        mSignature = signature.clone();
        // ---------- Original Method ----------
        //mSignature = signature.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.782 -0400", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "DF481BF54252713D3854BD502773F2F6")
    public  Signature(String text) {
        addTaint(text.getTaint());
        final byte[] input = text.getBytes();
        final int N = input.length;
        if(N % 2 != 0)        
        {
            IllegalArgumentException var3B5C36E1FC09BEF735F75708F17C09C4_688732983 = new IllegalArgumentException("text size " + N + " is not even");
            var3B5C36E1FC09BEF735F75708F17C09C4_688732983.addTaint(taint);
            throw var3B5C36E1FC09BEF735F75708F17C09C4_688732983;
        } //End block
        final byte[] sig = new byte[N / 2];
        int sigIndex = 0;
for(int i = 0;i < N;)
        {
            final int hi = parseHexDigit(input[i++]);
            final int lo = parseHexDigit(input[i++]);
            sig[sigIndex++] = (byte) ((hi << 4) | lo);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.783 -0400", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "35AE48A1EC65609E4DC5E52450D21B19")
    private  Signature(Parcel source) {
        mSignature = source.createByteArray();
        // ---------- Original Method ----------
        //mSignature = source.createByteArray();
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.783 -0400", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "BCE1899B981D98890C1F03F1398774BA")
    public char[] toChars() {
        char[] varA9A9F483CB373090D5BB0F27CF6C4953_893377789 = (toChars(null, null));
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1074015769 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1074015769;
        // ---------- Original Method ----------
        //return toChars(null, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.785 -0400", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "958693913D80C6303A57CB06C71DCE45")
    public char[] toChars(char[] existingArray, int[] outLen) {
        addTaint(outLen[0]);
        addTaint(existingArray[0]);
        byte[] sig = mSignature;
        final int N = sig.length;
        final int N2 = N*2;
        char[] text = existingArray == null || N2 > existingArray.length
                ? new char[N2] : existingArray;
for(int j=0;j<N;j++)
        {
            byte v = sig[j];
            int d = (v>>4)&0xf;
            text[j*2] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
            d = v&0xf;
            text[j*2+1] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
        } //End block
        if(outLen != null)        
        outLen[0] = N;
        char[] var1CB251EC0D568DE6A929B520C4AED8D1_1798391351 = (text);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1672071256 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1672071256;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.787 -0400", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "9C8E54EBDD24E8E5922F44CCD763471D")
    public String toCharsString() {
        String str = mStringRef == null ? null : mStringRef.get();
        if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_1487349253 =             str;
            var061B89662D09DE43FE2A2D88636258A2_1487349253.addTaint(taint);
            return var061B89662D09DE43FE2A2D88636258A2_1487349253;
        } //End block
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
String var061B89662D09DE43FE2A2D88636258A2_1993221826 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1993221826.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1993221826;
        // ---------- Original Method ----------
        //String str = mStringRef == null ? null : mStringRef.get();
        //if (str != null) {
            //return str;
        //}
        //str = new String(toChars());
        //mStringRef = new SoftReference<String>(str);
        //return str;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.788 -0400", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "9FF2A6A9D7BB62FB35D30F8216DE2775")
    public byte[] toByteArray() {
        byte[] bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_570047818 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2007663486 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2007663486;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[mSignature.length];
        //System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        //return bytes;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.788 -0400", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "F4C64CE033CAE4BD3C3302C2A96294BC")
    public PublicKey getPublicKey() throws CertificateException {
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        final Certificate cert = certFactory.generateCertificate(bais);
PublicKey varA6AF97A9DA9E3D7762300A5338BFE054_416831250 =         cert.getPublicKey();
        varA6AF97A9DA9E3D7762300A5338BFE054_416831250.addTaint(taint);
        return varA6AF97A9DA9E3D7762300A5338BFE054_416831250;
        // ---------- Original Method ----------
        //final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        //final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        //final Certificate cert = certFactory.generateCertificate(bais);
        //return cert.getPublicKey();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.789 -0400", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "A163271D48A24BA730DE8CA3D2F4B4EE")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        try 
        {
            if(obj != null)            
            {
                Signature other = (Signature)obj;
                boolean varBFDC6F780CE574735A86284B8F5A6E60_1903809408 = (this == other || Arrays.equals(mSignature, other.mSignature));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255845186 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_255845186;
            } //End block
        } //End block
        catch (ClassCastException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1873767597 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_563119207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_563119207;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.790 -0400", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "365BBF68C5856EC460B48D50DB6D36E7")
    @Override
    public int hashCode() {
        if(mHaveHashCode)        
        {
            int varD1324C907E3C733CA9E17C8F90836F79_1352839989 = (mHashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623334980 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623334980;
        } //End block
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        int varD1324C907E3C733CA9E17C8F90836F79_337779109 = (mHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669556337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669556337;
        // ---------- Original Method ----------
        //if (mHaveHashCode) {
            //return mHashCode;
        //}
        //mHashCode = Arrays.hashCode(mSignature);
        //mHaveHashCode = true;
        //return mHashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.791 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "199323A6BF0E4D015DB36BA65F264877")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_129976923 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84068659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84068659;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.791 -0400", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "57A6EA668242881AD29276DD3365E2FC")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeByteArray(mSignature);
        // ---------- Original Method ----------
        //dest.writeByteArray(mSignature);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.791 -0400", hash_original_field = "EF6321A08F8C07F931351347C004EC46", hash_generated_field = "D433CA4E2BE6EFC6C045D2BE6C7AFF6B")

    public static final Parcelable.Creator<Signature> CREATOR
            = new Parcelable.Creator<Signature>() {
        public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }

        public Signature[] newArray(int size) {
            return new Signature[size];
        }
    };
    // orphaned legacy method
    public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }
    
    // orphaned legacy method
    public Signature[] newArray(int size) {
            return new Signature[size];
        }
    
}

