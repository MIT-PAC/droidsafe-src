package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

public class CoderResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.626 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.627 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.628 -0400", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "D851FBA0928E192998BF1AF90BB4D1C7")
    private  CoderResult(int type, int length) {
        this.type = type;
        this.length = length;
        // ---------- Original Method ----------
        //this.type = type;
        //this.length = length;
    }

    
    public static synchronized CoderResult malformedForLength(int length) throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_malformedErrors) {
                CoderResult r = _malformedErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_MALFORMED_INPUT, length);
                    _malformedErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }

    
    public static synchronized CoderResult unmappableForLength(int length) throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_unmappableErrors) {
                CoderResult r = _unmappableErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_UNMAPPABLE_CHAR, length);
                    _unmappableErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.629 -0400", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "EAD8704E39E7267B9787B6A0BB4FA257")
    public boolean isUnderflow() {
        boolean var199C46FD26760D2F597FADB518575C49_639723440 = (this.type == TYPE_UNDERFLOW);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780852607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780852607;
        // ---------- Original Method ----------
        //return this.type == TYPE_UNDERFLOW;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.630 -0400", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "162A8682013C3342BA4C623003C88DB0")
    public boolean isError() {
        boolean varB8B82089CC11F3579FBA3CE7896EA15E_1736853928 = (this.type == TYPE_MALFORMED_INPUT
                || this.type == TYPE_UNMAPPABLE_CHAR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090707263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090707263;
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT
                //|| this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.631 -0400", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "35B06FB8BDB1C4CAF5E3CF8790E977E8")
    public boolean isMalformed() {
        boolean varDD3233C41C713B9066D93354948FC49E_442391104 = (this.type == TYPE_MALFORMED_INPUT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902887938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902887938;
        // ---------- Original Method ----------
        //return this.type == TYPE_MALFORMED_INPUT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.631 -0400", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "F4AA6ADB384A73684108E2D032ADCCAB")
    public boolean isOverflow() {
        boolean varE5ABA22019AFE03E2FC80214B2DEAA0E_1461041346 = (this.type == TYPE_OVERFLOW);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101736193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101736193;
        // ---------- Original Method ----------
        //return this.type == TYPE_OVERFLOW;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.631 -0400", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "C7A222496159C598AD3506D4E5338AF8")
    public boolean isUnmappable() {
        boolean var52B287FE15C090F89BAACCEA5B469454_792646151 = (this.type == TYPE_UNMAPPABLE_CHAR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191049976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191049976;
        // ---------- Original Method ----------
        //return this.type == TYPE_UNMAPPABLE_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.632 -0400", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "D606862810A1E68EBE01265E0FC4443B")
    public int length() throws UnsupportedOperationException {
        if(this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR)        
        {
            int varB9E8DC303FCECCA10418D2C0EA295E0F_607552547 = (this.length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691179402 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691179402;
        } //End block
        UnsupportedOperationException varDFA7339E20F7A5B1CB7B49318CBDEFC4_1634878321 = new UnsupportedOperationException("length meaningless for " + toString());
        varDFA7339E20F7A5B1CB7B49318CBDEFC4_1634878321.addTaint(taint);
        throw varDFA7339E20F7A5B1CB7B49318CBDEFC4_1634878321;
        // ---------- Original Method ----------
        //if (this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR) {
            //return this.length;
        //}
        //throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.632 -0400", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "6965410F1F783CF3875ADF465ADC6E62")
    public void throwException() throws BufferUnderflowException,
            BufferOverflowException, UnmappableCharacterException,
            MalformedInputException, CharacterCodingException {
switch(this.type){
        case TYPE_UNDERFLOW:
        BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_473744048 = new BufferUnderflowException();
        var77B0EAE3DCF68E57AAEF834AFBC7D762_473744048.addTaint(taint);
        throw var77B0EAE3DCF68E57AAEF834AFBC7D762_473744048;
        case TYPE_OVERFLOW:
        BufferOverflowException var773478A23217201B18B531915D367F31_65682066 = new BufferOverflowException();
        var773478A23217201B18B531915D367F31_65682066.addTaint(taint);
        throw var773478A23217201B18B531915D367F31_65682066;
        case TYPE_UNMAPPABLE_CHAR:
        UnmappableCharacterException varEEE3E9A56DC3C659CDE91DC4C7C3AEBD_1938435038 = new UnmappableCharacterException(this.length);
        varEEE3E9A56DC3C659CDE91DC4C7C3AEBD_1938435038.addTaint(taint);
        throw varEEE3E9A56DC3C659CDE91DC4C7C3AEBD_1938435038;
        case TYPE_MALFORMED_INPUT:
        MalformedInputException var1D54390A22E1B3B0331C174592E2EA89_230722315 = new MalformedInputException(this.length);
        var1D54390A22E1B3B0331C174592E2EA89_230722315.addTaint(taint);
        throw var1D54390A22E1B3B0331C174592E2EA89_230722315;
        default:
        CharacterCodingException varCDD38155BBAC05DABCCABFD20A3EDDFE_684784684 = new CharacterCodingException();
        varCDD38155BBAC05DABCCABFD20A3EDDFE_684784684.addTaint(taint);
        throw varCDD38155BBAC05DABCCABFD20A3EDDFE_684784684;
}
        // ---------- Original Method ----------
        //switch (this.type) {
            //case TYPE_UNDERFLOW:
                //throw new BufferUnderflowException();
            //case TYPE_OVERFLOW:
                //throw new BufferOverflowException();
            //case TYPE_UNMAPPABLE_CHAR:
                //throw new UnmappableCharacterException(this.length);
            //case TYPE_MALFORMED_INPUT:
                //throw new MalformedInputException(this.length);
            //default:
                //throw new CharacterCodingException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "FD884154715B12A9A14B6221F9D056AC")
    @Override
    public String toString() {
        String dsc = null;
switch(this.type){
        case TYPE_UNDERFLOW:
        dsc = "UNDERFLOW error";
        break;
        case TYPE_OVERFLOW:
        dsc = "OVERFLOW error";
        break;
        case TYPE_UNMAPPABLE_CHAR:
        dsc = "Unmappable-character error with erroneous input length "
                        + this.length;
        break;
        case TYPE_MALFORMED_INPUT:
        dsc = "Malformed-input error with erroneous input length "
                        + this.length;
        break;
        default:
        dsc = "";
        break;
}String varABCB20B7FF8451810E3A6D6380893900_507805026 =         getClass().getName() + "[" + dsc + "]";
        varABCB20B7FF8451810E3A6D6380893900_507805026.addTaint(taint);
        return varABCB20B7FF8451810E3A6D6380893900_507805026;
        // ---------- Original Method ----------
        //String dsc = null;
        //switch (this.type) {
            //case TYPE_UNDERFLOW:
                //dsc = "UNDERFLOW error";
                //break;
            //case TYPE_OVERFLOW:
                //dsc = "OVERFLOW error";
                //break;
            //case TYPE_UNMAPPABLE_CHAR:
                //dsc = "Unmappable-character error with erroneous input length "
                        //+ this.length;
                //break;
            //case TYPE_MALFORMED_INPUT:
                //dsc = "Malformed-input error with erroneous input length "
                        //+ this.length;
                //break;
            //default:
                //dsc = "";
                //break;
        //}
        //return getClass().getName() + "[" + dsc + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_field = "03C7B4AF933F2D6A5DC38128ED384A7F", hash_generated_field = "5686A0817753AB01F5538639E94A3DB2")

    private static final int TYPE_UNDERFLOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_field = "AA19E78578F65F6E4154CA9CA90F8A18", hash_generated_field = "B613814D9EB59828D84474AB56824F80")

    private static final int TYPE_OVERFLOW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_field = "095E81878478A77975586FED87B54B03", hash_generated_field = "CEE082D95D99A5E2E7B86BB6C60A7BA8")

    private static final int TYPE_MALFORMED_INPUT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_field = "D840678E9B4F7C36570C32A907A5301B", hash_generated_field = "257A8E9EEAB537C120C9FA5C89913FBC")

    private static final int TYPE_UNMAPPABLE_CHAR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.634 -0400", hash_original_field = "B6A5F62DD485012C170A1DF7064B9894", hash_generated_field = "CED3245C886E68DD4C6FB67AC5FE6EEB")

    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.635 -0400", hash_original_field = "AAB07B6D0921816A706E308D4C7DF8C8", hash_generated_field = "17DE0F56BB1CAD86851E26DC64EBFBED")

    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.635 -0400", hash_original_field = "FFF836352D82A42A049116351B8E49BD", hash_generated_field = "154F7BAB5D229D86020DFDB6943A833A")

    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.635 -0400", hash_original_field = "76575679E1B34545FAB2DD4443B63583", hash_generated_field = "4A3051E3D68AB1D3FECCCF1B94957C66")

    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
}

