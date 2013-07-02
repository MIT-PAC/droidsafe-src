package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.WordIterator;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionSpan;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import com.android.internal.util.ArrayUtils;
import java.text.BreakIterator;
import java.util.Locale;

public class SpellChecker implements SpellCheckerSessionListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "D9194793393393DFA066BFA75444BC1B", hash_generated_field = "39E84A66981E43B1DC94949150BE2F63")

    SpellCheckerSession mSpellCheckerSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "17C86C09C6C4D7B6E875B4525EC536C5")

    int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "36CC87084E26172DAC189652DC599476", hash_generated_field = "E0098EAD32D043C9D60259B28F8B564F")

    private int[] mIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "6510E39ECA8928F2250B891717F5A8CC", hash_generated_field = "2D5AC40BAC78409DC57ABE64923C6BFA")

    private SpellCheckSpan[] mSpellCheckSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "1097136F397CF7E42037BCA6B5CF711D", hash_generated_field = "2B6FC6E38D9EBF03FD604200798A54CA")

    private SpellParser[] mSpellParsers = new SpellParser[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "AC9339910CAE8FD97505663E478C0899", hash_generated_field = "2AB80C042BBE999CBCF902D21883708D")

    private int mSpanSequenceCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "8CEE743DC82226DD3EB73C8E69CF1A2D", hash_generated_field = "1086F1F56F0517EEEF9DAE1810CF3039")

    private TextServicesManager mTextServicesManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.923 -0400", hash_original_field = "FFBFF259536F365D8C4815480679E9AD", hash_generated_field = "C12CAE036558C1FAAF23655B9A008A09")

    private Runnable mSpellRunnable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.924 -0400", hash_original_method = "EA2B38816C4BD4485D1FFEBB2CE3FE95", hash_generated_method = "88E46BA7978A9979E678090F13EBF845")
    public  SpellChecker(TextView textView) {
        mTextView = textView;
        final int size = ArrayUtils.idealObjectArraySize(1);
        mIds = new int[size];
        mSpellCheckSpans = new SpellCheckSpan[size];
        setLocale(mTextView.getTextServicesLocale());
        mCookie = hashCode();
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.924 -0400", hash_original_method = "132221852F8DDF087B45024FD49A8E7F", hash_generated_method = "6C43DFD324501EEE21B0F208381FBF79")
    private void resetSession() {
        closeSession();
        mTextServicesManager = (TextServicesManager) mTextView.getContext().
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        {
            boolean varC2A9336C71425F40818F6B08D3000A2D_1229819344 = (!mTextServicesManager.isSpellCheckerEnabled());
            {
                mSpellCheckerSession = null;
            } 
            {
                mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(
                    null ,
                    mCurrentLocale, this,
                    false );
            } 
        } 
        {
            int i = 0;
            {
                mSpellCheckSpans[i].setSpellCheckInProgress(false);
                mIds[i] = -1;
            } 
        } 
        mLength = 0;
        mTextView.removeMisspelledSpans((Editable) mTextView.getText());
        mTextView.onLocaleChanged();
        
        
        
                
        
            
        
            
                    
                    
                    
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.925 -0400", hash_original_method = "A16726E56767CB6AA7867DE749E54AF0", hash_generated_method = "AD73757F5DEB354F3D13B9B46E22B6D0")
    private void setLocale(Locale locale) {
        mCurrentLocale = locale;
        resetSession();
        mWordIterator = new WordIterator(locale);
        mTextView.onLocaleChanged();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.925 -0400", hash_original_method = "7E55E284FCAD6408034DF45536DFE0B3", hash_generated_method = "1CCC94473E2ABB1800494E7FC2DDBCF6")
    private boolean isSessionActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410476229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410476229;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.926 -0400", hash_original_method = "AAA52197918C65A359451CD46304BE67", hash_generated_method = "F7E30CC4A85879898F1C90003ACAC975")
    public void closeSession() {
        {
            mSpellCheckerSession.close();
        } 
        final int length = mSpellParsers.length;
        {
            int i = 0;
            {
                mSpellParsers[i].finish();
            } 
        } 
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } 
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.927 -0400", hash_original_method = "5D19DB78B5A2119B2E660E625690F49E", hash_generated_method = "ED344F1A6836392EA2FCBFC7C978B35C")
    private int nextSpellCheckSpanIndex() {
        {
            int i = 0;
        } 
        {
            final int newSize = mLength * 2;
            int[] newIds = new int[newSize];
            SpellCheckSpan[] newSpellCheckSpans = new SpellCheckSpan[newSize];
            System.arraycopy(mIds, 0, newIds, 0, mLength);
            System.arraycopy(mSpellCheckSpans, 0, newSpellCheckSpans, 0, mLength);
            mIds = newIds;
            mSpellCheckSpans = newSpellCheckSpans;
        } 
        mSpellCheckSpans[mLength] = new SpellCheckSpan();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546028531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546028531;
        
        
            
        
        
            
            
            
            
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.927 -0400", hash_original_method = "A1EABCB0A317A13B5BB9A67E3EDF2F7D", hash_generated_method = "790462279705707937983750CDE0B364")
    private void addSpellCheckSpan(Editable editable, int start, int end) {
        final int index = nextSpellCheckSpanIndex();
        editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIds[index] = mSpanSequenceCounter++;
        addTaint(editable.getTaint());
        addTaint(start);
        addTaint(end);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.928 -0400", hash_original_method = "E45444ACDA725CE9A6A26FFAD79AE5C6", hash_generated_method = "FA2E36D3E9C5283EB5726CF3239FA5D2")
    public void removeSpellCheckSpan(SpellCheckSpan spellCheckSpan) {
        {
            int i = 0;
            {
                {
                    mSpellCheckSpans[i].setSpellCheckInProgress(false);
                    mIds[i] = -1;
                } 
            } 
        } 
        addTaint(spellCheckSpan.getTaint());
        
        
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.928 -0400", hash_original_method = "91E9278A0058E0FC6383B30785A8CFA9", hash_generated_method = "D00D41525B8D7A6F78ACFD7BB33C5992")
    public void onSelectionChanged() {
        
        spellCheck();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.929 -0400", hash_original_method = "6CA87C3B81B676351D5CE260A5491025", hash_generated_method = "73AB3E9283B5617CE91F79F4D69F3C9D")
    public void spellCheck(int start, int end) {
        final Locale locale = mTextView.getTextServicesLocale();
        {
            boolean var92322F8189DB31C9BFD6B6FE90DD5EB9_214689034 = (mCurrentLocale == null || (!(mCurrentLocale.equals(locale))));
            {
                setLocale(locale);
                start = 0;
                end = mTextView.getText().length();
            } 
            {
                final boolean spellCheckerActivated = mTextServicesManager.isSpellCheckerEnabled();
                {
                    boolean var80C3218921ED99D2ADFEA4E3A2E45C2E_627891817 = (isSessionActive() != spellCheckerActivated);
                    {
                        resetSession();
                    } 
                } 
            } 
        } 
        {
            boolean var9433F5A259C3ED6B89B6B6398D504A0A_2063922914 = (!isSessionActive());
        } 
        final int length = mSpellParsers.length;
        {
            int i = 0;
            {
                final SpellParser spellParser = mSpellParsers[i];
                {
                    boolean var0082180255A9D08BEB76790D259BEC35_1736453929 = (spellParser.isFinished());
                    {
                        spellParser.init(start, end);
                        spellParser.parse();
                    } 
                } 
            } 
        } 
        SpellParser[] newSpellParsers = new SpellParser[length + 1];
        System.arraycopy(mSpellParsers, 0, newSpellParsers, 0, length);
        mSpellParsers = newSpellParsers;
        SpellParser spellParser = new SpellParser();
        mSpellParsers[length] = spellParser;
        spellParser.init(start, end);
        spellParser.parse();
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.930 -0400", hash_original_method = "BA5B8BA52678A659BE9D822C4132A8EA", hash_generated_method = "43D8C06933101C0FB2B0825077A5DD9C")
    private void spellCheck() {
        Editable editable = (Editable) mTextView.getText();
        final int selectionStart = Selection.getSelectionStart(editable);
        final int selectionEnd = Selection.getSelectionEnd(editable);
        TextInfo[] textInfos = new TextInfo[mLength];
        int textInfosCount = 0;
        {
            int i = 0;
            {
                final SpellCheckSpan spellCheckSpan = mSpellCheckSpans[i];
                {
                    boolean var8EFC4F507046E540E16E2602424A567A_976868566 = (spellCheckSpan.isSpellCheckInProgress());
                } 
                final int start = editable.getSpanStart(spellCheckSpan);
                final int end = editable.getSpanEnd(spellCheckSpan);
                {
                    String word;
                    word = ((SpannableStringBuilder) editable).substring(start, end);
                    word = editable.subSequence(start, end).toString();
                    spellCheckSpan.setSpellCheckInProgress(true);
                    textInfos[textInfosCount++] = new TextInfo(word, mCookie, mIds[i]);
                } 
            } 
        } 
        {
            {
                TextInfo[] textInfosCopy = new TextInfo[textInfosCount];
                System.arraycopy(textInfos, 0, textInfosCopy, 0, textInfosCount);
                textInfos = textInfosCopy;
            } 
            mSpellCheckerSession.getSuggestions(textInfos, SuggestionSpan.SUGGESTIONS_MAX_SIZE,
                    false );
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.930 -0400", hash_original_method = "A75E28D7E7AFF4B0223DAD7BAD9E1275", hash_generated_method = "13F5EF54BBA0E4BEFC823A5986A7E523")
    @Override
    public void onGetSuggestions(SuggestionsInfo[] results) {
        
        Editable editable = (Editable) mTextView.getText();
        {
            int i = 0;
            {
                SuggestionsInfo suggestionsInfo = results[i];
                {
                    boolean var9B514A225DEF4154DD4352971E947BA9_5449215 = (suggestionsInfo.getCookie() != mCookie);
                } 
                final int sequenceNumber = suggestionsInfo.getSequence();
                {
                    int j = 0;
                    {
                        {
                            final int attributes = suggestionsInfo.getSuggestionsAttributes();
                            boolean isInDictionary = ((attributes & SuggestionsInfo.RESULT_ATTR_IN_THE_DICTIONARY) > 0);
                            boolean looksLikeTypo = ((attributes & SuggestionsInfo.RESULT_ATTR_LOOKS_LIKE_TYPO) > 0);
                            SpellCheckSpan spellCheckSpan = mSpellCheckSpans[j];
                            {
                                createMisspelledSuggestionSpan(editable, suggestionsInfo, spellCheckSpan);
                            } 
                            editable.removeSpan(spellCheckSpan);
                        } 
                    } 
                } 
            } 
        } 
        scheduleNewSpellCheck();
        addTaint(results[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.931 -0400", hash_original_method = "57E44CFBFBBC7EE198958F01316D8781", hash_generated_method = "DFCFFC8615D57D752D0CBC87B3FC2FC4")
    private void scheduleNewSpellCheck() {
        {
            mSpellRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.931 -0400", hash_original_method = "37CFD7A65FD2E81573DE2B2CB07AD40E", hash_generated_method = "0C4068161CBFC694A8257C5EC0C754D8")
                @Override
                public void run() {
                    final int length = mSpellParsers.length;
                    {
                        int i = 0;
                        {
                            final SpellParser spellParser = mSpellParsers[i];
                            {
                                boolean varAFFEFD3A7D11AB4DF09303DDD35E86D6_166303356 = (!spellParser.isFinished());
                                {
                                    spellParser.parse();
                                } 
                            } 
                        } 
                    } 
                    
                    
                    
                        
                        
                            
                            
                        
                    
                }
};
        } 
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } 
        mTextView.postDelayed(mSpellRunnable, SPELL_PAUSE_DURATION);
        
        
            
                
                
                    
                    
                        
                        
                            
                            
                        
                    
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.932 -0400", hash_original_method = "7C6C5A03DA2C9F5FF814A532005DE2A2", hash_generated_method = "9BE9DF137937FF2AA0D000E58C036918")
    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo,
            SpellCheckSpan spellCheckSpan) {
        final int start = editable.getSpanStart(spellCheckSpan);
        final int end = editable.getSpanEnd(spellCheckSpan);
        SuggestionSpan[] suggestionSpans = editable.getSpans(start, end, SuggestionSpan.class);
        final int length = suggestionSpans.length;
        {
            int i = 0;
            {
                final int spanStart = editable.getSpanStart(suggestionSpans[i]);
                final int spanEnd = editable.getSpanEnd(suggestionSpans[i]);
                {
                    suggestionSpans[i] = null;
                } 
            } 
        } 
        final int suggestionsCount = suggestionsInfo.getSuggestionsCount();
        String[] suggestions;
        {
            suggestions = ArrayUtils.emptyArray(String.class);
        } 
        {
            int numberOfSuggestions = 0;
            suggestions = new String[suggestionsCount];
            {
                int i = 0;
                {
                    final String spellSuggestion = suggestionsInfo.getSuggestionAt(i);
                    boolean suggestionFound = false;
                    {
                        int j = 0;
                        {
                            String[] suggests = suggestionSpans[j].getSuggestions();
                            {
                                int k = 0;
                                {
                                    {
                                        boolean var679E4D2EFFB38ED1AC184217089AEF33_1632792335 = (spellSuggestion.equals(suggests[k]));
                                        {
                                            suggestionFound = true;
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        suggestions[numberOfSuggestions++] = spellSuggestion;
                    } 
                } 
            } 
            {
                String[] newSuggestions = new String[numberOfSuggestions];
                System.arraycopy(suggestions, 0, newSuggestions, 0, numberOfSuggestions);
                suggestions = newSuggestions;
            } 
        } 
        SuggestionSpan suggestionSpan = new SuggestionSpan(mTextView.getContext(), suggestions,
                SuggestionSpan.FLAG_EASY_CORRECT | SuggestionSpan.FLAG_MISSPELLED);
        editable.setSpan(suggestionSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView.invalidateRegion(start, end, false );
        addTaint(editable.getTaint());
        addTaint(suggestionsInfo.getTaint());
        addTaint(spellCheckSpan.getTaint());
        
        
    }

    
    private class SpellParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.932 -0400", hash_original_field = "1F59510816481BF077F1395F9F3EA574", hash_generated_field = "82F647CE25A38C36E8A5E280A1933D4B")

        private Object mRange = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.932 -0400", hash_original_method = "A0F09AC113A054694810A2E52D3EE82C", hash_generated_method = "A0F09AC113A054694810A2E52D3EE82C")
        public SpellParser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.933 -0400", hash_original_method = "C4550C9FA073E61C6C7A190D43162B55", hash_generated_method = "CE2CFEE7F96E3CBA5EBB3F5842E634C0")
        public void init(int start, int end) {
            ((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            addTaint(start);
            addTaint(end);
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.933 -0400", hash_original_method = "86B0D995E6C3BF5225FAD4AECF9F58F6", hash_generated_method = "45B8F4A922A98FCBE98DADDE73470229")
        public void finish() {
            ((Editable) mTextView.getText()).removeSpan(mRange);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.933 -0400", hash_original_method = "F88808B62872052B620FE7CDA250E1D3", hash_generated_method = "9F229A5066675932187477DF7D83A2AD")
        public boolean isFinished() {
            boolean varF8782931D05D05EFA9FB95C9E3E04ED2_1624035864 = (((Editable) mTextView.getText()).getSpanStart(mRange) < 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167525552 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167525552;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.934 -0400", hash_original_method = "D0FCA268222D024780345A48D1B99D28", hash_generated_method = "4C50F7FA9F932C131568D4CDC1E683E6")
        public void parse() {
            Editable editable = (Editable) mTextView.getText();
            final int start = editable.getSpanStart(mRange);
            final int end = editable.getSpanEnd(mRange);
            int wordIteratorWindowEnd = Math.min(end, start + WORD_ITERATOR_INTERVAL);
            mWordIterator.setCharSequence(editable, start, wordIteratorWindowEnd);
            int wordStart = mWordIterator.preceding(start);
            int wordEnd;
            {
                wordEnd = mWordIterator.following(start);
                {
                    wordStart = mWordIterator.getBeginning(wordEnd);
                } 
            } 
            {
                wordEnd = mWordIterator.getEnd(wordStart);
            } 
            {
                editable.removeSpan(mRange);
            } 
            SpellCheckSpan[] spellCheckSpans = editable.getSpans(start - 1, end + 1,
                    SpellCheckSpan.class);
            SuggestionSpan[] suggestionSpans = editable.getSpans(start - 1, end + 1,
                    SuggestionSpan.class);
            int wordCount = 0;
            boolean scheduleOtherSpellCheck = false;
            {
                {
                    {
                        scheduleOtherSpellCheck = true;
                    } 
                    {
                        removeSpansAt(editable, start, spellCheckSpans);
                        removeSpansAt(editable, start, suggestionSpans);
                    } 
                    {
                        removeSpansAt(editable, end, spellCheckSpans);
                        removeSpansAt(editable, end, suggestionSpans);
                    } 
                    boolean createSpellCheckSpan = true;
                    {
                        {
                            int i = 0;
                            {
                                final int spanEnd = editable.getSpanEnd(spellCheckSpans[i]);
                                {
                                    createSpellCheckSpan = false;
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            int i = 0;
                            {
                                final int spanStart = editable.getSpanStart(spellCheckSpans[i]);
                                {
                                    createSpellCheckSpan = false;
                                } 
                            } 
                        } 
                    } 
                    {
                        addSpellCheckSpan(editable, wordStart, wordEnd);
                    } 
                } 
                int originalWordEnd = wordEnd;
                wordEnd = mWordIterator.following(wordEnd);
                {
                    wordIteratorWindowEnd = Math.min(end, originalWordEnd + WORD_ITERATOR_INTERVAL);
                    mWordIterator.setCharSequence(editable, originalWordEnd, wordIteratorWindowEnd);
                    wordEnd = mWordIterator.following(originalWordEnd);
                } 
                wordStart = mWordIterator.getBeginning(wordEnd);
            } 
            {
                editable.setSpan(mRange, wordStart, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } 
            {
                editable.removeSpan(mRange);
            } 
            spellCheck();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.935 -0400", hash_original_method = "0A3768DE6F2D0EE4EDD70A588C9E13B1", hash_generated_method = "5BD05A7436DDF23ED3A24A43C8A5CA7B")
        private <T> void removeSpansAt(Editable editable, int offset, T[] spans) {
            final int length = spans.length;
            {
                int i = 0;
                {
                    final T span = spans[i];
                    final int start = editable.getSpanStart(span);
                    final int end = editable.getSpanEnd(span);
                    editable.removeSpan(span);
                } 
            } 
            addTaint(editable.getTaint());
            addTaint(offset);
            addTaint(spans[0].getTaint());
            
            
            
                
                
                
                
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.935 -0400", hash_original_field = "F54A9A9D5F3DB132CD381555457FE23E", hash_generated_field = "19C90C4CA2F594AB68B25F39910E16CF")

    public static final int MAX_NUMBER_OF_WORDS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.935 -0400", hash_original_field = "860CBBA9CF833D356947E61516BCDFA0", hash_generated_field = "9616A9FABFCF7FC4A279A90FE83B0503")

    public static final int AVERAGE_WORD_LENGTH = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.935 -0400", hash_original_field = "E8C87E2933CBC193D2BB9358B267D7D9", hash_generated_field = "F089F91FA7DF5EB2F9DE5091AC7123A4")

    public static final int WORD_ITERATOR_INTERVAL = AVERAGE_WORD_LENGTH * MAX_NUMBER_OF_WORDS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.935 -0400", hash_original_field = "EE40FF3FDA56574BAC5273E1B9CA3CD5", hash_generated_field = "D13721220D50A86AF8557E9EE89E4674")

    private final static int SPELL_PAUSE_DURATION = 400;
}

