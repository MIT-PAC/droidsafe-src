package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.456 -0400", hash_original_field = "FC75508A279D3A4B73839B9A1CF5EE55", hash_generated_field = "82FF487F3BC72CD61B5A92D15C282FF7")

    private byte[] mSignature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.456 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.456 -0400", hash_original_field = "DA3577697B0DD709AF13F3080CF0FF14", hash_generated_field = "1E26145EC834378C0A9DBC88E0224A55")

    private boolean mHaveHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.456 -0400", hash_original_field = "1AFB5CB7071835101FAF1C82BAB11F44", hash_generated_field = "1DA2E56EBB947D41BB50077BEA325ECF")

    private SoftReference<String> mStringRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.457 -0400", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "35DC787169E2B15A0B726B2232D59558")
    public  Signature(byte[] signature) {
        mSignature = signature.clone();
        // ---------- Original Method ----------
        //mSignature = signature.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.458 -0400", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "C4F7ABF9E0217E0F7AA5580D3AA1AC6A")
    public  Signature(String text) {
        addTaint(text.getTaint());
        final byte[] input = text.getBytes();
        final int N = input.length;
    if(N % 2 != 0)        
        {
            IllegalArgumentException var3B5C36E1FC09BEF735F75708F17C09C4_1563628872 = new IllegalArgumentException("text size " + N + " is not even");
            var3B5C36E1FC09BEF735F75708F17C09C4_1563628872.addTaint(taint);
            throw var3B5C36E1FC09BEF735F75708F17C09C4_1563628872;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.459 -0400", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "35AE48A1EC65609E4DC5E52450D21B19")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.460 -0400", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "179C5DC39055777A424FB93293041072")
    public char[] toChars() {
        char[] varA9A9F483CB373090D5BB0F27CF6C4953_33395975 = (toChars(null, null));
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_758363970 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_758363970;
        // ---------- Original Method ----------
        //return toChars(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.461 -0400", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "2DCDFA8E016D3AE7A6C6E9E247E18F9A")
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
        char[] var1CB251EC0D568DE6A929B520C4AED8D1_1169648215 = (text);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_620273361 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_620273361;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.462 -0400", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "3C85CDED9B008B946136635704BDDAF6")
    public String toCharsString() {
        String str = mStringRef == null ? null : mStringRef.get();
    if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_136704496 =             str;
            var061B89662D09DE43FE2A2D88636258A2_136704496.addTaint(taint);
            return var061B89662D09DE43FE2A2D88636258A2_136704496;
        } //End block
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
String var061B89662D09DE43FE2A2D88636258A2_50394357 =         str;
        var061B89662D09DE43FE2A2D88636258A2_50394357.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_50394357;
        // ---------- Original Method ----------
        //String str = mStringRef == null ? null : mStringRef.get();
        //if (str != null) {
            //return str;
        //}
        //str = new String(toChars());
        //mStringRef = new SoftReference<String>(str);
        //return str;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.463 -0400", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "92737C2FDB3CE0F24B9C8A705C86BEA9")
    public byte[] toByteArray() {
        byte[] bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_134193613 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1843201350 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1843201350;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[mSignature.length];
        //System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        //return bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.464 -0400", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "B88E0F8917D7A405CA2D901A436B402F")
    public PublicKey getPublicKey() throws CertificateException {
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        final Certificate cert = certFactory.generateCertificate(bais);
PublicKey varA6AF97A9DA9E3D7762300A5338BFE054_1874153363 =         cert.getPublicKey();
        varA6AF97A9DA9E3D7762300A5338BFE054_1874153363.addTaint(taint);
        return varA6AF97A9DA9E3D7762300A5338BFE054_1874153363;
        // ---------- Original Method ----------
        //final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        //final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        //final Certificate cert = certFactory.generateCertificate(bais);
        //return cert.getPublicKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.465 -0400", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "1826C04BB3E4A302B4834BE47AAEDB58")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        try 
        {
    if(obj != null)            
            {
                Signature other = (Signature)obj;
                boolean varBFDC6F780CE574735A86284B8F5A6E60_755877925 = (this == other || Arrays.equals(mSignature, other.mSignature));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275796432 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275796432;
            } //End block
        } //End block
        catch (ClassCastException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_692889069 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925302717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925302717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.466 -0400", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "6DE67BB71E9FA24CEB880E94446C2BBF")
    @Override
    public int hashCode() {
    if(mHaveHashCode)        
        {
            int varD1324C907E3C733CA9E17C8F90836F79_857125486 = (mHashCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645447429 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645447429;
        } //End block
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        int varD1324C907E3C733CA9E17C8F90836F79_1847671142 = (mHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142087697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142087697;
        // ---------- Original Method ----------
        //if (mHaveHashCode) {
            //return mHashCode;
        //}
        //mHashCode = Arrays.hashCode(mSignature);
        //mHaveHashCode = true;
        //return mHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.466 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DCBB7B83DF7B36A9CD7824239021DFB3")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2066040353 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066110158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066110158;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.467 -0400", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "57A6EA668242881AD29276DD3365E2FC")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeByteArray(mSignature);
        // ---------- Original Method ----------
        //dest.writeByteArray(mSignature);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.467 -0400", hash_original_field = "EF6321A08F8C07F931351347C004EC46", hash_generated_field = "D433CA4E2BE6EFC6C045D2BE6C7AFF6B")

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

