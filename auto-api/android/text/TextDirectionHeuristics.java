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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.613 -0400", hash_original_method = "2A87426FBEF2D38046B88F05CCEC7F58", hash_generated_method = "2A87426FBEF2D38046B88F05CCEC7F58")
        public TextDirectionHeuristics ()
    {
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
        private TextDirectionAlgorithm mAlgorithm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.614 -0400", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "D8A322B470B43A39FF15BE9B02CF110A")
        @DSModeled(DSC.SAFE)
        public TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            dsTaint.addTaint(algorithm.dsTaint);
            // ---------- Original Method ----------
            //mAlgorithm = algorithm;
        }

        
        abstract protected boolean defaultIsRtl();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.614 -0400", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "D1B4A2E9C138725331CF99AB721B4F15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isRtl(char[] chars, int start, int count) {
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars[0]);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            {
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_958754120 = (defaultIsRtl());
            } //End block
            boolean var52B8FCB11F0767F7A8336B3C22B330D0_420324049 = (doCheck(chars, start, count));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (chars == null || start < 0 || count < 0 || chars.length - count < start) {
                //throw new IllegalArgumentException();
            //}
            //if (mAlgorithm == null) {
                //return defaultIsRtl();
            //}
            //return doCheck(chars, start, count);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.615 -0400", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "616C4B45F94977793E765ABE3D27DA18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean doCheck(char[] chars, int start, int count) {
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars[0]);
            {
                Object varDAB1BEF91BEF70B802203A689C42106C_318736414 = (mAlgorithm.checkRtl(chars, start, count));
                //Begin case default 
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_1603712153 = (defaultIsRtl());
                //End case default 
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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
        private boolean mDefaultIsRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.615 -0400", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "B92A855B50D03858441228C5F3897F5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            dsTaint.addTaint(defaultIsRtl);
            dsTaint.addTaint(algorithm.dsTaint);
            // ---------- Original Method ----------
            //mDefaultIsRtl = defaultIsRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.615 -0400", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "0D6E83CD3736765077C0C08B92D34D6E")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean defaultIsRtl() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDefaultIsRtl;
        }

        
    }


    
    public static class FirstStrong implements TextDirectionAlgorithm {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.615 -0400", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "BD69D77294A463FBAD983B34950F9BCE")
        @DSModeled(DSC.SAFE)
        private FirstStrong() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.616 -0400", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "03AC53ED5D152A90949D058F8C3C4316")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            dsTaint.addTaint(text[0]);
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
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
            return (TriState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //TriState result = TriState.UNKNOWN;
            //for (int i = start, e = start + count; i < e && result == TriState.UNKNOWN; ++i) {
                //result = isRtlTextOrFormat(Character.getDirectionality(text[i]));
            //}
            //return result;
        }

        
        public static final FirstStrong INSTANCE = new FirstStrong();
    }


    
    public static class AnyStrong implements TextDirectionAlgorithm {
        private boolean mLookForRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.616 -0400", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "3BB6E34973E0B442714FBC583D5F194A")
        @DSModeled(DSC.SAFE)
        private AnyStrong(boolean lookForRtl) {
            dsTaint.addTaint(lookForRtl);
            // ---------- Original Method ----------
            //this.mLookForRtl = lookForRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.617 -0400", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "B88D1EEBEEEF49C4D40878316E23267F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            dsTaint.addTaint(text[0]);
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
            boolean haveUnlookedFor;
            haveUnlookedFor = false;
            {
                int i, e;
                i = start;
                e = start + count;
                {
                    {
                        Object var0E539409CB864CE634AA444548E96C1F_2034506930 = (isRtlText(Character.getDirectionality(text[i])));
                        //Begin case TRUE 
                        haveUnlookedFor = true;
                        //End case TRUE 
                        //Begin case FALSE 
                        haveUnlookedFor = true;
                        //End case FALSE 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (TriState)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    }


    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.617 -0400", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "58F00443FB0688075F58A0CB5CD3BD72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TextDirectionHeuristicLocale() {
            super(null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.617 -0400", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "DE24FFFF05A027173E88D41B3D09FAD8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean defaultIsRtl() {
            int dir;
            dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            //return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }

        
        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
    }


    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
    
    public static final TextDirectionHeuristic LTR =
        new TextDirectionHeuristicInternal(null , false);
    public static final TextDirectionHeuristic RTL =
        new TextDirectionHeuristicInternal(null , true);
    public static final TextDirectionHeuristic FIRSTSTRONG_LTR =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    public static final TextDirectionHeuristic FIRSTSTRONG_RTL =
        new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    public static final TextDirectionHeuristic ANYRTL_LTR =
        new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;
}

