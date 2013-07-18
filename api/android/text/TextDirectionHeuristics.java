package android.text;

// Droidsafe Imports
import android.util.LocaleUtil;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TextDirectionHeuristics {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.745 -0400", hash_original_method = "58EF974DE9597127C18BC29D51581A83", hash_generated_method = "58EF974DE9597127C18BC29D51581A83")
    public TextDirectionHeuristics ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.745 -0400", hash_original_field = "F6E257862B80390CD13E2E0129E87947", hash_generated_field = "E3D2FDC0F5F8FA77A83B5258D585AD07")

        private TextDirectionAlgorithm mAlgorithm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.746 -0400", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "05B6DD8753C7F8E313E2DF2F8649E7E1")
        public  TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            mAlgorithm = algorithm;
            // ---------- Original Method ----------
            //mAlgorithm = algorithm;
        }

        
        @DSModeled(DSC.SAFE)
        abstract protected boolean defaultIsRtl();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.747 -0400", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "9D33E584F0529D0307B0980BAB99DDD4")
        @Override
        public boolean isRtl(char[] chars, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(chars[0]);
            if(chars == null || start < 0 || count < 0 || chars.length - count < start)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_845167777 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_845167777.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_845167777;
            } //End block
            if(mAlgorithm == null)            
            {
                boolean varBB32C4C1D36B053EEEB61EF2C9BEE2EA_451427832 = (defaultIsRtl());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982444301 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982444301;
            } //End block
            boolean var531FF2B696A577BD7DBE83F7CFAD64F3_424938159 = (doCheck(chars, start, count));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750810186 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_750810186;
            // ---------- Original Method ----------
            //if (chars == null || start < 0 || count < 0 || chars.length - count < start) {
                //throw new IllegalArgumentException();
            //}
            //if (mAlgorithm == null) {
                //return defaultIsRtl();
            //}
            //return doCheck(chars, start, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.748 -0400", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "FC340C4380C8AA584FE79B3381C89BC1")
        private boolean doCheck(char[] chars, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(chars[0]);
switch(mAlgorithm.checkRtl(chars, start, count)){
            case TRUE:
            boolean varB326B5062B2F0E69046810717534CB09_386265562 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989286468 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_989286468;
            case FALSE:
            boolean var68934A3E9455FA72420237EB05902327_2113927090 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225247352 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_225247352;
            default:
            boolean varBB32C4C1D36B053EEEB61EF2C9BEE2EA_64355537 = (defaultIsRtl());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16995811 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_16995811;
}
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.748 -0400", hash_original_field = "9BDDA11E4292E9F50844540E81ABF998", hash_generated_field = "E35325D3CC72CD89F5834771DD655801")

        private boolean mDefaultIsRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.749 -0400", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "1C0C94CAFACB26E5AAF7AB15601AF2EB")
        private  TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            mDefaultIsRtl = defaultIsRtl;
            // ---------- Original Method ----------
            //mDefaultIsRtl = defaultIsRtl;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.750 -0400", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "3B84FEBF18F0D69B3FB54637BCA36559")
        @Override
        protected boolean defaultIsRtl() {
            boolean var9BDDA11E4292E9F50844540E81ABF998_1747676578 = (mDefaultIsRtl);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933561685 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933561685;
            // ---------- Original Method ----------
            //return mDefaultIsRtl;
        }

        
    }


    
    public static class FirstStrong implements TextDirectionAlgorithm {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.750 -0400", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "BD69D77294A463FBAD983B34950F9BCE")
        private  FirstStrong() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.752 -0400", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "92389B9C7D97F347A96EA58121CA61BA")
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(text[0]);
            TriState result = TriState.UNKNOWN;
for(int i = start, e = start + count;i < e && result == TriState.UNKNOWN;++i)
            {
                result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            } //End block
TriState varDC838461EE2FA0CA4C9BBB70A15456B0_770460623 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_770460623.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_770460623;
            // ---------- Original Method ----------
            //TriState result = TriState.UNKNOWN;
            //for (int i = start, e = start + count; i < e && result == TriState.UNKNOWN; ++i) {
                //result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            //}
            //return result;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.752 -0400", hash_original_field = "B7169C7C8B5B3672DE3844F17769F964", hash_generated_field = "E0B2FB089B175E1E869ABC9E4BB92E5B")

        public static final FirstStrong INSTANCE = new FirstStrong();
    }


    
    public static class AnyStrong implements TextDirectionAlgorithm {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.752 -0400", hash_original_field = "E86A07DD9C9BFE9688C9FAEE4BE688D7", hash_generated_field = "407F935E47F07BDB50023430051DDAEC")

        private boolean mLookForRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.753 -0400", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "FBA640D39B46307F538717C3F8D5574E")
        private  AnyStrong(boolean lookForRtl) {
            this.mLookForRtl = lookForRtl;
            // ---------- Original Method ----------
            //this.mLookForRtl = lookForRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.754 -0400", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "B9BE5531E3CBFFE0FC50DCAF4B38B105")
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(text[0]);
            boolean haveUnlookedFor = false;
for(int i = start, e = start + count;i < e;++i)
            {
switch(isRtlText(Character.getDirectionality(text[i]))){
                case TRUE:
                if(mLookForRtl)                
                {
TriState varD972E7D14CF2543E1174427420693D1A_1491872053 =                     TriState.TRUE;
                    varD972E7D14CF2543E1174427420693D1A_1491872053.addTaint(taint);
                    return varD972E7D14CF2543E1174427420693D1A_1491872053;
                } //End block
                haveUnlookedFor = true;
                break;
                case FALSE:
                if(!mLookForRtl)                
                {
TriState varCD0CFCF9CEBCBA1E3C29E021CD05E467_878276583 =                     TriState.FALSE;
                    varCD0CFCF9CEBCBA1E3C29E021CD05E467_878276583.addTaint(taint);
                    return varCD0CFCF9CEBCBA1E3C29E021CD05E467_878276583;
                } //End block
                haveUnlookedFor = true;
                break;
                default:
                break;
}
            } //End block
            if(haveUnlookedFor)            
            {
TriState var23A9CE6815D15B54439EE059A44514CB_1752625752 =                 mLookForRtl ? TriState.FALSE : TriState.TRUE;
                var23A9CE6815D15B54439EE059A44514CB_1752625752.addTaint(taint);
                return var23A9CE6815D15B54439EE059A44514CB_1752625752;
            } //End block
TriState var485D0EAC5426E5CF6B2DFC2FF63C06FB_1452865964 =             TriState.UNKNOWN;
            var485D0EAC5426E5CF6B2DFC2FF63C06FB_1452865964.addTaint(taint);
            return var485D0EAC5426E5CF6B2DFC2FF63C06FB_1452865964;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.755 -0400", hash_original_field = "AC9EF564648DAA5541D919C29D6FDF92", hash_generated_field = "816BE95EB8392CC0E9496A4A3A0FD859")

        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.755 -0400", hash_original_field = "AA7B41081238CEFD92491FFA97F665D8", hash_generated_field = "0C39513C6CBA973C236E9D8F6EB932D3")

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    }


    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.755 -0400", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "58F00443FB0688075F58A0CB5CD3BD72")
        public  TextDirectionHeuristicLocale() {
            super(null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.756 -0400", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "895ACB0F9FE7ED48F9C92F1749A85710")
        @Override
        protected boolean defaultIsRtl() {
            final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            boolean varE79FF023BBA8C12CAF58E0246B1CDA30_1486071648 = ((dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855587261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855587261;
            // ---------- Original Method ----------
            //final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            //return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.756 -0400", hash_original_field = "7ABF1BD9117D0D4BE56238CC555DFFF3", hash_generated_field = "69EA35186DB990277D8AF9B472E41E71")

        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
    }


    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.756 -0400", hash_original_field = "BDE40E8AF5BF161643A7B05F7DAF93D6", hash_generated_field = "7788A380E799C032FC116D4B90B74577")

    public static final TextDirectionHeuristic LTR =
        new TextDirectionHeuristicInternal(null , false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.757 -0400", hash_original_field = "75688D5B3344E94CCD5F6019B4218434", hash_generated_field = "B3047D91C0433367D339C9AE025D70B2")

    public static final TextDirectionHeuristic RTL =
        new TextDirectionHeuristicInternal(null , true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.757 -0400", hash_original_field = "C6D3046BCA0CD9B3F315C6C0ED4981FF", hash_generated_field = "FB19007988632662E44B0BD2939BDCF4")

    public static final TextDirectionHeuristic FIRSTSTRONG_LTR =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.757 -0400", hash_original_field = "ACDBB8BF04B215BB127765C04E28BB37", hash_generated_field = "2A6F08FF0743B6D3EED006E185E1C41F")

    public static final TextDirectionHeuristic FIRSTSTRONG_RTL =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.757 -0400", hash_original_field = "70CF25ED4801AE2D4DA8433DFF61788C", hash_generated_field = "A67ED36ACE0121EC842BF4F8BE348FCA")

    public static final TextDirectionHeuristic ANYRTL_LTR =
        new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.757 -0400", hash_original_field = "97DF110BB6609B7CB4462011AC34948E", hash_generated_field = "F0612598BFF1E67595D8ACA39D00E56D")

    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;
}

