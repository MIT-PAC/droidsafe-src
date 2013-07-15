package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import android.util.LocaleUtil;

public class TextDirectionHeuristics {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.976 -0400", hash_original_method = "58EF974DE9597127C18BC29D51581A83", hash_generated_method = "58EF974DE9597127C18BC29D51581A83")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.976 -0400", hash_original_field = "F6E257862B80390CD13E2E0129E87947", hash_generated_field = "E3D2FDC0F5F8FA77A83B5258D585AD07")

        private TextDirectionAlgorithm mAlgorithm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.977 -0400", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "05B6DD8753C7F8E313E2DF2F8649E7E1")
        public  TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            mAlgorithm = algorithm;
            // ---------- Original Method ----------
            //mAlgorithm = algorithm;
        }

        
        abstract protected boolean defaultIsRtl();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.977 -0400", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "295DA5860A6B286AF777F76F7AB2A5F6")
        @Override
        public boolean isRtl(char[] chars, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(chars[0]);
    if(chars == null || start < 0 || count < 0 || chars.length - count < start)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_654940527 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_654940527.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_654940527;
            } //End block
    if(mAlgorithm == null)            
            {
                boolean varBB32C4C1D36B053EEEB61EF2C9BEE2EA_1692387017 = (defaultIsRtl());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87377116 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_87377116;
            } //End block
            boolean var531FF2B696A577BD7DBE83F7CFAD64F3_1664504507 = (doCheck(chars, start, count));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253075872 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_253075872;
            // ---------- Original Method ----------
            //if (chars == null || start < 0 || count < 0 || chars.length - count < start) {
                //throw new IllegalArgumentException();
            //}
            //if (mAlgorithm == null) {
                //return defaultIsRtl();
            //}
            //return doCheck(chars, start, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.978 -0400", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "8D06C4AAF47848CDE583D77BDC8D5434")
        private boolean doCheck(char[] chars, int start, int count) {
            addTaint(count);
            addTaint(start);
            addTaint(chars[0]);
switch(mAlgorithm.checkRtl(chars, start, count)){
            case TRUE:
            boolean varB326B5062B2F0E69046810717534CB09_488572493 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489564277 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_489564277;
            case FALSE:
            boolean var68934A3E9455FA72420237EB05902327_1906856133 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851353205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851353205;
            default:
            boolean varBB32C4C1D36B053EEEB61EF2C9BEE2EA_619092923 = (defaultIsRtl());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668942094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668942094;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.978 -0400", hash_original_field = "9BDDA11E4292E9F50844540E81ABF998", hash_generated_field = "E35325D3CC72CD89F5834771DD655801")

        private boolean mDefaultIsRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.979 -0400", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "1C0C94CAFACB26E5AAF7AB15601AF2EB")
        private  TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            mDefaultIsRtl = defaultIsRtl;
            // ---------- Original Method ----------
            //mDefaultIsRtl = defaultIsRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.979 -0400", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "A4D175FDB5770CED5042A49F17B86302")
        @Override
        protected boolean defaultIsRtl() {
            boolean var9BDDA11E4292E9F50844540E81ABF998_214047573 = (mDefaultIsRtl);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253550316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253550316;
            // ---------- Original Method ----------
            //return mDefaultIsRtl;
        }

        
    }


    
    public static class FirstStrong implements TextDirectionAlgorithm {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.980 -0400", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "BD69D77294A463FBAD983B34950F9BCE")
        private  FirstStrong() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.981 -0400", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "D5032320E851005AFB921B955C336DB7")
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
TriState varDC838461EE2FA0CA4C9BBB70A15456B0_1592231245 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1592231245.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1592231245;
            // ---------- Original Method ----------
            //TriState result = TriState.UNKNOWN;
            //for (int i = start, e = start + count; i < e && result == TriState.UNKNOWN; ++i) {
                //result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            //}
            //return result;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.981 -0400", hash_original_field = "B7169C7C8B5B3672DE3844F17769F964", hash_generated_field = "E0B2FB089B175E1E869ABC9E4BB92E5B")

        public static final FirstStrong INSTANCE = new FirstStrong();
    }


    
    public static class AnyStrong implements TextDirectionAlgorithm {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.982 -0400", hash_original_field = "E86A07DD9C9BFE9688C9FAEE4BE688D7", hash_generated_field = "407F935E47F07BDB50023430051DDAEC")

        private boolean mLookForRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.982 -0400", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "FBA640D39B46307F538717C3F8D5574E")
        private  AnyStrong(boolean lookForRtl) {
            this.mLookForRtl = lookForRtl;
            // ---------- Original Method ----------
            //this.mLookForRtl = lookForRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.984 -0400", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "BB4743F5F3CEBAD21D45E2579F50270D")
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
TriState varD972E7D14CF2543E1174427420693D1A_1567402759 =                     TriState.TRUE;
                    varD972E7D14CF2543E1174427420693D1A_1567402759.addTaint(taint);
                    return varD972E7D14CF2543E1174427420693D1A_1567402759;
                } //End block
                haveUnlookedFor = true;
                break;
                case FALSE:
    if(!mLookForRtl)                
                {
TriState varCD0CFCF9CEBCBA1E3C29E021CD05E467_485496051 =                     TriState.FALSE;
                    varCD0CFCF9CEBCBA1E3C29E021CD05E467_485496051.addTaint(taint);
                    return varCD0CFCF9CEBCBA1E3C29E021CD05E467_485496051;
                } //End block
                haveUnlookedFor = true;
                break;
                default:
                break;
}
            } //End block
    if(haveUnlookedFor)            
            {
TriState var23A9CE6815D15B54439EE059A44514CB_1314163906 =                 mLookForRtl ? TriState.FALSE : TriState.TRUE;
                var23A9CE6815D15B54439EE059A44514CB_1314163906.addTaint(taint);
                return var23A9CE6815D15B54439EE059A44514CB_1314163906;
            } //End block
TriState var485D0EAC5426E5CF6B2DFC2FF63C06FB_2134636751 =             TriState.UNKNOWN;
            var485D0EAC5426E5CF6B2DFC2FF63C06FB_2134636751.addTaint(taint);
            return var485D0EAC5426E5CF6B2DFC2FF63C06FB_2134636751;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.985 -0400", hash_original_field = "AC9EF564648DAA5541D919C29D6FDF92", hash_generated_field = "816BE95EB8392CC0E9496A4A3A0FD859")

        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.985 -0400", hash_original_field = "AA7B41081238CEFD92491FFA97F665D8", hash_generated_field = "0C39513C6CBA973C236E9D8F6EB932D3")

        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    }


    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.985 -0400", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "58F00443FB0688075F58A0CB5CD3BD72")
        public  TextDirectionHeuristicLocale() {
            super(null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.986 -0400", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "35735203557D6B6E3E9A2DCC5F12F6D6")
        @Override
        protected boolean defaultIsRtl() {
            final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            boolean varE79FF023BBA8C12CAF58E0246B1CDA30_591909818 = ((dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386203663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_386203663;
            // ---------- Original Method ----------
            //final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            //return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.986 -0400", hash_original_field = "7ABF1BD9117D0D4BE56238CC555DFFF3", hash_generated_field = "69EA35186DB990277D8AF9B472E41E71")

        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
    }


    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "BDE40E8AF5BF161643A7B05F7DAF93D6", hash_generated_field = "7788A380E799C032FC116D4B90B74577")

    public static final TextDirectionHeuristic LTR =
        new TextDirectionHeuristicInternal(null , false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "75688D5B3344E94CCD5F6019B4218434", hash_generated_field = "B3047D91C0433367D339C9AE025D70B2")

    public static final TextDirectionHeuristic RTL =
        new TextDirectionHeuristicInternal(null , true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "C6D3046BCA0CD9B3F315C6C0ED4981FF", hash_generated_field = "FB19007988632662E44B0BD2939BDCF4")

    public static final TextDirectionHeuristic FIRSTSTRONG_LTR =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "ACDBB8BF04B215BB127765C04E28BB37", hash_generated_field = "2A6F08FF0743B6D3EED006E185E1C41F")

    public static final TextDirectionHeuristic FIRSTSTRONG_RTL =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "70CF25ED4801AE2D4DA8433DFF61788C", hash_generated_field = "A67ED36ACE0121EC842BF4F8BE348FCA")

    public static final TextDirectionHeuristic ANYRTL_LTR =
        new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.987 -0400", hash_original_field = "97DF110BB6609B7CB4462011AC34948E", hash_generated_field = "F0612598BFF1E67595D8ACA39D00E56D")

    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;
}

