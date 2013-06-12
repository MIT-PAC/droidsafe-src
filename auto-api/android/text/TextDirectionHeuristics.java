package android.text;

// Droidsafe Imports
import android.util.LocaleUtil;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class TextDirectionHeuristics {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.371 -0400", hash_original_method = "752EA957CA9ED0F2290DA6CA047E5538", hash_generated_method = "51C0AB5FAFE47421AB195FD369FF0AA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "2BBF7E97F24E7C203261C928D65397D1", hash_generated_method = "C9DF7C3593B3BB3AF0E2006D5A209844")
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
        private final TextDirectionAlgorithm mAlgorithm;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "78BC1D5C61B057EE1329E0F2DC6F9F5C", hash_generated_method = "4028D082EF5CB2F6B2D5E891E3CE6D13")
        @DSModeled(DSC.SAFE)
        public TextDirectionHeuristicImpl(TextDirectionAlgorithm algorithm) {
            dsTaint.addTaint(algorithm.dsTaint);
            mAlgorithm = algorithm;
            // ---------- Original Method ----------
            //mAlgorithm = algorithm;
        }

        
        abstract protected boolean defaultIsRtl();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "B61CE3C920740D11C38763E0606997ED", hash_generated_method = "AB70FB5548BA8EA25098A32A4B307FF1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isRtl(char[] chars, int start, int count) {
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            {
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_1885842205 = (defaultIsRtl());
            } //End block
            boolean var52B8FCB11F0767F7A8336B3C22B330D0_429103095 = (doCheck(chars, start, count));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "F9BBF1A80AA076481C35E4EEAF375E25", hash_generated_method = "2C44EAA486359F507EFCB612989CA298")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean doCheck(char[] chars, int start, int count) {
            dsTaint.addTaint(count);
            dsTaint.addTaint(start);
            dsTaint.addTaint(chars);
            {
                Object varDAB1BEF91BEF70B802203A689C42106C_329211561 = (mAlgorithm.checkRtl(chars, start, count));
                //Begin case default 
                boolean var325265FB9B90A3A9C3A7CE2178D0DFEC_1614308311 = (defaultIsRtl());
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
        private final boolean mDefaultIsRtl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "DF39989E195592DC6431878B17C9155B", hash_generated_method = "CBD9251EBD8364D85034F938869341E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private TextDirectionHeuristicInternal(TextDirectionAlgorithm algorithm,
                boolean defaultIsRtl) {
            super(algorithm);
            dsTaint.addTaint(defaultIsRtl);
            dsTaint.addTaint(algorithm.dsTaint);
            mDefaultIsRtl = defaultIsRtl;
            // ---------- Original Method ----------
            //mDefaultIsRtl = defaultIsRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "F33559B09616EA1059BD515D9BD28DCA", hash_generated_method = "1C4BF00F7997EB553FBD2644B81B3D6E")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean defaultIsRtl() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDefaultIsRtl;
        }

        
    }


    
    public static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE = new FirstStrong();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "77800305F201A2CE86A750D63435A8FC", hash_generated_method = "817D5E88AAA0E8663B921757760096EE")
        @DSModeled(DSC.SAFE)
        private FirstStrong() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.372 -0400", hash_original_method = "B12778B9891AAFECC2CB8B0C655200C4", hash_generated_method = "C3BCDAC1CB5F78538272ED185854F7C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            dsTaint.addTaint(text);
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

        
    }


    
    public static class AnyStrong implements TextDirectionAlgorithm {
        private final boolean mLookForRtl;
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.373 -0400", hash_original_method = "CE1C7FC082B7BD7DCEB5DEACBA006400", hash_generated_method = "4875B0FC18B51AC1C7CA042672D0BA91")
        @DSModeled(DSC.SAFE)
        private AnyStrong(boolean lookForRtl) {
            dsTaint.addTaint(lookForRtl);
            this.mLookForRtl = lookForRtl;
            // ---------- Original Method ----------
            //this.mLookForRtl = lookForRtl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.373 -0400", hash_original_method = "2D65014765DBEAE21140F9644F3DEE55", hash_generated_method = "FD6E3168A2EAB76F290227BD41DE2EC9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TriState checkRtl(char[] text, int start, int count) {
            dsTaint.addTaint(text);
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
                        Object var0E539409CB864CE634AA444548E96C1F_940482394 = (isRtlText(Character.getDirectionality(text[i])));
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

        
    }


    
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale INSTANCE =
                new TextDirectionHeuristicLocale();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.373 -0400", hash_original_method = "CBB334D6CA70EC7E7043C3529CC3BCF6", hash_generated_method = "E04F01B1A89200548CEB611D16EA11F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TextDirectionHeuristicLocale() {
            super(null);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.373 -0400", hash_original_method = "CD13B75E835D71E46C5AAA6D1CEDF13D", hash_generated_method = "FB6D1B504936D6DB1DD919D236142E6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean defaultIsRtl() {
            final int dir;
            dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final int dir = LocaleUtil.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
            //return (dir == LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE);
        }

        
    }


    
    public static interface TextDirectionAlgorithm {
        
        TriState checkRtl(char[] text, int start, int count);
    }
    
}


