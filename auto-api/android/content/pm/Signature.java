package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.230 -0400", hash_original_field = "FC75508A279D3A4B73839B9A1CF5EE55", hash_generated_field = "82FF487F3BC72CD61B5A92D15C282FF7")

    private byte[] mSignature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.230 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.230 -0400", hash_original_field = "DA3577697B0DD709AF13F3080CF0FF14", hash_generated_field = "1E26145EC834378C0A9DBC88E0224A55")

    private boolean mHaveHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.230 -0400", hash_original_field = "1AFB5CB7071835101FAF1C82BAB11F44", hash_generated_field = "1DA2E56EBB947D41BB50077BEA325ECF")

    private SoftReference<String> mStringRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.231 -0400", hash_original_method = "D6836B125607EB452687B13BDE6808A1", hash_generated_method = "35DC787169E2B15A0B726B2232D59558")
    public  Signature(byte[] signature) {
        mSignature = signature.clone();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.233 -0400", hash_original_method = "D3C2556D1F2D5F06D4836CF4CB37FB62", hash_generated_method = "7FD7C16D2B31394DB852B90B81F51A22")
    public  Signature(String text) {
        final byte[] input = text.getBytes();
        final int N = input.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text size " + N + " is not even");
        } 
        final byte[] sig = new byte[N / 2];
        int sigIndex = 0;
        {
            int i = 0;
            {
                final int hi = parseHexDigit(input[i++]);
                final int lo = parseHexDigit(input[i++]);
                sig[sigIndex++] = (byte) ((hi << 4) | lo);
            } 
        } 
        mSignature = sig;
        addTaint(text.getTaint());
        
        
        
        
            
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.234 -0400", hash_original_method = "BBC65E3379EE4CCA92F27F7F3813E8E5", hash_generated_method = "35AE48A1EC65609E4DC5E52450D21B19")
    private  Signature(Parcel source) {
        mSignature = source.createByteArray();
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.235 -0400", hash_original_method = "01DD3741CD8E2948231CA6DA5A86A75B", hash_generated_method = "B59D0E6C8A4A03FBB5D0F49A6B340F2B")
    public char[] toChars() {
        char[] varA4185AFF435A5F9E12F848CF267BEF10_1257836511 = (toChars(null, null));
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_625864098 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_625864098;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.236 -0400", hash_original_method = "AD9B978BF103416C8AF045B7D5E010A1", hash_generated_method = "5FBEEA6DAAFEB3D0E9440C2072444266")
    public char[] toChars(char[] existingArray, int[] outLen) {
        byte[] sig = mSignature;
        final int N = sig.length;
        final int N2 = N*2;
        char[] text;
        text = new char[N2];
        text = existingArray;
        {
            int j = 0;
            {
                byte v = sig[j];
                int d = (v>>4)&0xf;
                text[j*2] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
                d = v&0xf;
                text[j*2+1] = (char)(d >= 10 ? ('a' + d - 10) : ('0' + d));
            } 
        } 
        outLen[0] = N;
        addTaint(existingArray[0]);
        addTaint(outLen[0]);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1878889557 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1878889557;
        
        
        
        
        
                
        
            
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.237 -0400", hash_original_method = "29DBF4766A3C463CDC6A362C590D645B", hash_generated_method = "25BA0D55CEF079B6B2E0D8FCE2692DF8")
    public String toCharsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1320810963 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1456814845 = null; 
        String str;
        str = null;
        str = mStringRef.get();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1320810963 = str;
        } 
        str = new String(toChars());
        mStringRef = new SoftReference<String>(str);
        varB4EAC82CA7396A68D541C85D26508E83_1456814845 = str;
        String varA7E53CE21691AB073D9660D615818899_587777180; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_587777180 = varB4EAC82CA7396A68D541C85D26508E83_1320810963;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_587777180 = varB4EAC82CA7396A68D541C85D26508E83_1456814845;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_587777180.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_587777180;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.238 -0400", hash_original_method = "4CD6431E4EA3D105FB97D345441783A7", hash_generated_method = "97DA6E01A64E6458EF1B4860E75CAECD")
    public byte[] toByteArray() {
        byte[] bytes = new byte[mSignature.length];
        System.arraycopy(mSignature, 0, bytes, 0, mSignature.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1922351980 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1922351980;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.239 -0400", hash_original_method = "E5DE629FEFDBE513EC2140BEFF8592A6", hash_generated_method = "6669522F19E9FB1FA206F952901F8021")
    public PublicKey getPublicKey() throws CertificateException {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_1643823705 = null; 
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final ByteArrayInputStream bais = new ByteArrayInputStream(mSignature);
        final Certificate cert = certFactory.generateCertificate(bais);
        varB4EAC82CA7396A68D541C85D26508E83_1643823705 = cert.getPublicKey();
        varB4EAC82CA7396A68D541C85D26508E83_1643823705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1643823705;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.240 -0400", hash_original_method = "F079A32CA15CD362613DEDB149309CFC", hash_generated_method = "5F0C51FBFA6959E20EE6F089F8FB0FFB")
    @Override
    public boolean equals(Object obj) {
        try 
        {
            {
                Signature other = (Signature)obj;
                boolean var93A7D6AE339F832ADAAF27B7F6ADCAAB_1518274113 = (this == other || Arrays.equals(mSignature, other.mSignature));
            } 
        } 
        catch (ClassCastException e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084666306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084666306;
        
        
            
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.241 -0400", hash_original_method = "372447AEF502550B73E14443F4E70970", hash_generated_method = "7C0C2C489D2AB135781EFC0142792B7C")
    @Override
    public int hashCode() {
        mHashCode = Arrays.hashCode(mSignature);
        mHaveHashCode = true;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503209455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503209455;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.243 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "23D83FD945077D03046F2A22201B746E")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663365846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663365846;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.244 -0400", hash_original_method = "0B8B8E5420BBB8BD8CE54CF326578D2C", hash_generated_method = "F1A0DEAFEEC32F115F05764B8A85FA40")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeByteArray(mSignature);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.244 -0400", hash_original_field = "EF6321A08F8C07F931351347C004EC46", hash_generated_field = "D433CA4E2BE6EFC6C045D2BE6C7AFF6B")

    public static final Parcelable.Creator<Signature> CREATOR
            = new Parcelable.Creator<Signature>() {
        public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }

        public Signature[] newArray(int size) {
            return new Signature[size];
        }
    };
    
    public Signature createFromParcel(Parcel source) {
            return new Signature(source);
        }
    
    
    public Signature[] newArray(int size) {
            return new Signature[size];
        }
    
}

