package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import android.util.LocaleUtil;

public class TextDirectionHeuristics {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.549 -0400", hash_original_method = "58EF974DE9597127C18BC29D51581A83", hash_generated_method = "58EF974DE9597127C18BC29D51581A83")
    public TextDirectionHeuristics ()
    {
        //Synthesized constructor
    }


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

    
    private static enum TriState {
        TRUE, FALSE, UNKNOWN;
    }

    
    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristic {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.557 -0400", hash_original_field = "F6E257862B80390CD13E2E0129E87947", hash_generated_field = "E3D2FDC0F5F8FA77A83B5258D585AD07")

        private TextDirectionAlgorithm mAlgorithm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.557 -0400", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "05B6DD8753C7F8E313E2DF2F8649E7E1")
        public  TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            mAlgorithm = algorithm;
            // ---------- Original Method ----------
            //mAlgorithm = algorithm;
        }

        
        abstract protected boolean defaultIsRtl();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.558 -0400", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "744878D1237585303C464234CF479292")
        @Override
        public boolean isRtl(char[] chars, int start, int count) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            {
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_185211179 = (defaultIsRtl());
            } //End block
            boolean var52B8FCB11F0767F7A8336B3C22B330D0_424290661 = (doCheck(chars, start, count));
            addTaint(chars[0]);
            addTaint(start);
            addTaint(count);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172021081 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_172021081;
            // ---------- Original Method ----------
            //if (chars == null || start < 0 || count < 0 || chars.length - count < start) {
                //throw new IllegalArgumentException();
            //}
            //if (mAlgorithm == null) {
                //return defaultIsRtl();
            //}
            //return doCheck(chars, start, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.558 -0400", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "890ED232481C1BE2E965068DC9DD41FA")
        private boolean doCheck(char[] chars, int start, int count) {
            {
                Object varDAB1BEF91BEF70B802203A689C42106C_1859936027 = (mAlgorithm.checkRtl(chars, start, count));
                //Begin case default 
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_465410778 = (defaultIsRtl());
                //End case default 
            } //End collapsed parenthetic
            addTaint(chars[0]);
            addTaint(start);
            addTaint(count);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700927243 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700927243;
            // ---------- Original Method ----------
            //switch(mAlgorithm.checkRtl(chars, start, count)) {
                //case TRUE:
                    //return true;
                //case FALSE:
                    //return false;
                //default:
                    //return defaultIsRtl();
            //}
        }

        
    }


    
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.562 -0400", hash_original_field = "9BDDA11E4292E9F50844540E81ABF998", hash_generated_field = "E35325D3CC72CD89F5834771DD655801")

        private boolean mDefaultIsRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.563 -0400", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "8D55E615DA878B55F2D31AB59AB5B8AB")
        private  TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            mDefaultIsRtl = defaultIsRtl;
            addTaint(algorithm.getTaint());
            // ---------- Original Method ----------
            //mDefaultIsRtl = defaultIsRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.563 -0400", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "DB2B72F6C55F0563ED7836871AC09A71")
        @Override
        protected boolean defaultIsRtl() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963686727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963686727;
            // ---------- Original Method ----------
            //return mDefaultIsRtl;
        }

        
    }


    
    public static class FirstStrong implements TextDirectionAlgorithm {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.563 -0400", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "BD69D77294A463FBAD983B34950F9BCE")
        private  FirstStrong() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.564 -0400", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "85DBE382458CA617AA37ADB03BE4ECC5")
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            TriState varB4EAC82CA7396A68D541C85D26508E83_950712788 = null; //Variable for return #1
            TriState result;
            result = TriState.UNKNOWN;
            {
                int i, e;
                i = start;
                e = start + count;
                {
                    result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_950712788 = result;
            addTaint(text[0]);
            addTaint(start);
            addTaint(count);
            varB4EAC82CA7396A68D541C85D26508E83_950712788.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_950712788;
            // ---------- Original Method ----------
            //TriState result = TriState.UNKNOWN;
            //for (int i = start, e = start + count; i < e && result == TriState.UNKNOWN; ++i) {
                //result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            //}
            //return result;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.564 -0400", hash_original_field = "B7169C7C8B5B3672DE3844F17769F964", hash_generated_field = "E0B2FB089B175E1E869ABC9E4BB92E5B")

        public static final FirstStrong INSTANCE = new FirstStrong();
    }


    
    public static class AnyStrong implements TextDirectionAlgorithm {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.579 -0400", hash_original_field = "E86A07DD9C9BFE9688C9FAEE4BE688D7", hash_generated_field = "407F935E47F07BDB50023430051DDAEC")

        private boolean mLookForRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.580 -0400", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "FBA640D39B46307F538717C3F8D5574E")
        private  AnyStrong(boolean lookForRtl) {
            this.mLookForRtl = lookForRtl;
            // ---------- Original Method ----------
            //this.mLookForRtl = lookForRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.588 -0400", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "FA81DFAAF7967342958D911813228DF6")
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            TriState varB4EAC82CA7396A68D541C85D26508E83_1837176174 = null; //Variable for return #1
            TriState varB4EAC82CA7396A68D541C85D26508E83_979546056 = null; //Variable for return #2
            TriState varB4EAC82CA7396A68D541C85D26508E83_324593822 = null; //Variable for return #3
            TriState varB4EAC82CA7396A68D541C85D26508E83_30749048 = null; //Variable for return #4
            boolean haveUnlookedFor;
            haveUnlookedFor = false;
            {
                int i, e;
                i = start;
                e = start + count;
                {
                    {
                        Object var0E539409CB864CE634AA444548E96C1F_918899141 = (isRtlText(Character.getDirectionality(text[i])));
                        //Begin case TRUE 
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1837176174 = TriState.TRUE;
                        } //End block
                        //End case TRUE 
                        //Begin case TRUE 
                        haveUnlookedFor = true;
                        //End case TRUE 
                        //Begin case FALSE 
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_979546056 = TriState.FALSE;
                        } //End block
                        //End case FALSE 
                        //Begin case FALSE 
                        haveUnlookedFor = true;
                        //End case FALSE 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_324593822 = mLookForRtl ? TriState.FALSE : TriState.TRUE;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_30749048 = TriState.UNKNOWN;
            addTaint(text[0]);
            addTaint(start);
            addTaint(count);
            TriState varA7E53CE21691AB073D9660D615818899_963490290; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_963490290 = varB4EAC82CA7396A68D541C85D26508E83_1837176174;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_963490290 = varB4EAC82CA7396A68D541C85D26508E83_979546056;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_963490290 = varB4EAC82CA7396A68D541C85D26508E83_324593822;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_963490290 = varB4EAC82CA7396A68D541C85D26508E83_30749048;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_963490290.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_963490290;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.589 -0400", hash_original_field = "AC9EF564648DAA5541D919C29D6FDF92", hash_generated_field = "816BE95EB8392CC0E9496A4A3A0FD859")

        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.589 -0400", hash_original_field = "AA7B41081238CEFD92491FFA97F665D8", hash_generated_field = "0C39513C6CBA973C236E9D8F6EB932D3")

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    }


    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "58F00443FB0688075F58A0CB5CD3BD72")
        public  TextDirectionHeuristicLocale() {
            super(null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "06F1C373AB63003514255DACC0DAD8A0")
        @Override
        protected boolean defaultIsRtl() {
            int dir;
            dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843629302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_843629302;
            // ---------- Original Method ----------
            //final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            //return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_field = "7ABF1BD9117D0D4BE56238CC555DFFF3", hash_generated_field = "69EA35186DB990277D8AF9B472E41E71")

        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
    }


    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_field = "BDE40E8AF5BF161643A7B05F7DAF93D6", hash_generated_field = "7788A380E799C032FC116D4B90B74577")

    public static final TextDirectionHeuristic LTR =
        new TextDirectionHeuristicInternal(null , false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_field = "75688D5B3344E94CCD5F6019B4218434", hash_generated_field = "B3047D91C0433367D339C9AE025D70B2")

    public static final TextDirectionHeuristic RTL =
        new TextDirectionHeuristicInternal(null , true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_field = "C6D3046BCA0CD9B3F315C6C0ED4981FF", hash_generated_field = "FB19007988632662E44B0BD2939BDCF4")

    public static final TextDirectionHeuristic FIRSTSTRONG_LTR =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.590 -0400", hash_original_field = "ACDBB8BF04B215BB127765C04E28BB37", hash_generated_field = "2A6F08FF0743B6D3EED006E185E1C41F")

    public static final TextDirectionHeuristic FIRSTSTRONG_RTL =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.591 -0400", hash_original_field = "70CF25ED4801AE2D4DA8433DFF61788C", hash_generated_field = "A67ED36ACE0121EC842BF4F8BE348FCA")

    public static final TextDirectionHeuristic ANYRTL_LTR =
        new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.591 -0400", hash_original_field = "97DF110BB6609B7CB4462011AC34948E", hash_generated_field = "F0612598BFF1E67595D8ACA39D00E56D")

    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;
}

