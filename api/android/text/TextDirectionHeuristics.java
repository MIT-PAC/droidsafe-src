package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.LocaleUtil;

public class TextDirectionHeuristics {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.369 -0500", hash_original_method = "752EA957CA9ED0F2290DA6CA047E5538", hash_generated_method = "51C0AB5FAFE47421AB195FD369FF0AA8")
    
private static TriState isRtlText(int directionality) {
        switch (directionality) {
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
                return TriState.FALSE;
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
                return TriState.TRUE;
            default:
                return TriState.UNKNOWN;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.372 -0500", hash_original_method = "2BBF7E97F24E7C203261C928D65397D1", hash_generated_method = "C9DF7C3593B3BB3AF0E2006D5A209844")
    
private static TriState isRtlTextOrFormat(int directionality) {
        switch (directionality) {
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING:
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE:
                return TriState.FALSE;
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE:
                return TriState.TRUE;
            default:
                return TriState.UNKNOWN;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.320 -0500", hash_original_field = "CF62CD3795E24E5EDB0F2DB8E3337418", hash_generated_field = "F96A5945E9017421B25B4D4FEB4BC014")

    public static final TextDirectionHeuristic LTR =
        new TextDirectionHeuristicInternal(null /* no algorithm */, false);
    
    private static enum TriState {
        TRUE, FALSE, UNKNOWN;
    }
    
    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristic {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.341 -0500", hash_original_field = "AC6A49EC5BD80FA8E4AC700D6D739531", hash_generated_field = "E3D2FDC0F5F8FA77A83B5258D585AD07")

        private  TextDirectionAlgorithm mAlgorithm;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.344 -0500", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "835E7045F765BB58E91223FA73DA9C25")
        
public TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            mAlgorithm = algorithm;
        }

        /**
         * Return true if the default text direction is rtl.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.347 -0500", hash_original_method = "6996B95EE8A602CD6D77610A0A9C1C36", hash_generated_method = "D128DA54F5CDD559D1B53B9FB923BF61")
        
abstract protected boolean defaultIsRtl();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.350 -0500", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "D36FD9B83932913BC0AA2827912C4191")
        
@Override
        public boolean isRtl(char[] chars, int start, int count) {
            if (chars == null || start < 0 || count < 0 || chars.length - count < start) {
                throw new IllegalArgumentException();
            }
            if (mAlgorithm == null) {
                return defaultIsRtl();
            }
            return doCheck(chars, start, count);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.353 -0500", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "A33829D1716C7146D006AEA226146E9C")
        
private boolean doCheck(char[] chars, int start, int count) {
            switch(mAlgorithm.checkRtl(chars, start, count)) {
                case TRUE:
                    return true;
                case FALSE:
                    return false;
                default:
                    return defaultIsRtl();
            }
        }
        
    }
    
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.358 -0500", hash_original_field = "13EAD5D249DED3E29B625E1E15162FB5", hash_generated_field = "E35325D3CC72CD89F5834771DD655801")

        private  boolean mDefaultIsRtl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.361 -0500", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "C205829268BA5A70B1D8D2BF6B5B02CD")
        
private TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            mDefaultIsRtl = defaultIsRtl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.364 -0500", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "60FED547FA85A8E4EEE847D941A20138")
        
@Override
        protected boolean defaultIsRtl() {
            return mDefaultIsRtl;
        }
        
    }
    
    public static class FirstStrong implements TextDirectionAlgorithm {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.385 -0500", hash_original_field = "3EE67EB44D7BAB4F1CE4D811DC35F490", hash_generated_field = "E0B2FB089B175E1E869ABC9E4BB92E5B")

        public static final FirstStrong INSTANCE = new FirstStrong();

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.381 -0500", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "1022AB52D2F89377DB2D7E24719DC90E")
        
private FirstStrong() {
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.378 -0500", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "E1AF42036FC6A8E6C748F37056819EA6")
        
@Override
        public TriState checkRtl(char[] text, int start, int count) {
            TriState result = TriState.UNKNOWN;
            for (int i = start, e = start + count; i < e && result == TriState.UNKNOWN; ++i) {
                result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            }
            return result;
        }
    }
    
    public static class AnyStrong implements TextDirectionAlgorithm {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.400 -0500", hash_original_field = "30FABEF1DCD8CA88BE3EF33E8E0639C2", hash_generated_field = "816BE95EB8392CC0E9496A4A3A0FD859")

        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.403 -0500", hash_original_field = "3A6421B9E017B1B953572DE1404CD4A8", hash_generated_field = "0C39513C6CBA973C236E9D8F6EB932D3")

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.390 -0500", hash_original_field = "4CD883064B23F0C9AED5C499F64B4BCF", hash_generated_field = "407F935E47F07BDB50023430051DDAEC")

        private  boolean mLookForRtl;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.397 -0500", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "B3AF76681B7B3EDA504A86B9C505345F")
        
private AnyStrong(boolean lookForRtl) {
            this.mLookForRtl = lookForRtl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.394 -0500", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "7A6689A2EC5553ADC2B2F96B6C356267")
        
@Override
        public TriState checkRtl(char[] text, int start, int count) {
            boolean haveUnlookedFor = false;
            for (int i = start, e = start + count; i < e; ++i) {
                switch (isRtlText(Character.getDirectionality(text[i]))) {
                    case TRUE:
                        if (mLookForRtl) {
                            return TriState.TRUE;
                        }
                        haveUnlookedFor = true;
                        break;
                    case FALSE:
                        if (!mLookForRtl) {
                            return TriState.FALSE;
                        }
                        haveUnlookedFor = true;
                        break;
                    default:
                        break;
                }
            }
            if (haveUnlookedFor) {
                return mLookForRtl ? TriState.FALSE : TriState.TRUE;
            }
            return TriState.UNKNOWN;
        }
    }
    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.415 -0500", hash_original_field = "C7D4E73351A56400CDCDFB799F49907D", hash_generated_field = "69EA35186DB990277D8AF9B472E41E71")

        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.409 -0500", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "1187609E76BC4A6D7EC2495E32911E26")
        
public TextDirectionHeuristicLocale() {
            super(null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.411 -0500", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "8094082888A6A7BFA8C6D84CB53C8E91")
        
@Override
        protected boolean defaultIsRtl() {
            final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }
    }
    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.323 -0500", hash_original_field = "6A6BA95E363B72C9B2697C9029D2F43F", hash_generated_field = "EDCE2C95226AB1016DB66CB22F146B52")

    public static final TextDirectionHeuristic RTL =
        new TextDirectionHeuristicInternal(null /* no algorithm */, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.326 -0500", hash_original_field = "3696F32B662DD695B8BC5E7B3F191876", hash_generated_field = "FB19007988632662E44B0BD2939BDCF4")

    public static final TextDirectionHeuristic FIRSTSTRONG_LTR =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.329 -0500", hash_original_field = "6EF0C5EE7B505DBBFCF88CF6F52ADECA", hash_generated_field = "2A6F08FF0743B6D3EED006E185E1C41F")

    public static final TextDirectionHeuristic FIRSTSTRONG_RTL =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.332 -0500", hash_original_field = "5985D8E61AD738E8764D3F1F761DCA6B", hash_generated_field = "A67ED36ACE0121EC842BF4F8BE348FCA")

    public static final TextDirectionHeuristic ANYRTL_LTR =
        new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.335 -0500", hash_original_field = "F90A25A29820EB47E2CB4844A5E3E650", hash_generated_field = "F0612598BFF1E67595D8ACA39D00E56D")

    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.745 -0400", hash_original_method = "58EF974DE9597127C18BC29D51581A83", hash_generated_method = "58EF974DE9597127C18BC29D51581A83")
    public TextDirectionHeuristics ()
    {
        //Synthesized constructor
    }
}

