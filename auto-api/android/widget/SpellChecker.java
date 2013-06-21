package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private TextView mTextView;
    SpellCheckerSession mSpellCheckerSession;
    int mCookie;
    private int[] mIds;
    private SpellCheckSpan[] mSpellCheckSpans;
    private int mLength;
    private SpellParser[] mSpellParsers = new SpellParser[0];
    private int mSpanSequenceCounter = 0;
    private Locale mCurrentLocale;
    private WordIterator mWordIterator;
    private TextServicesManager mTextServicesManager;
    private Runnable mSpellRunnable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.562 -0400", hash_original_method = "EA2B38816C4BD4485D1FFEBB2CE3FE95", hash_generated_method = "E91C7A3CFAE546224B90EE0BFEADBC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellChecker(TextView textView) {
        dsTaint.addTaint(textView.dsTaint);
        int size;
        size = ArrayUtils.idealObjectArraySize(1);
        mIds = new int[size];
        mSpellCheckSpans = new SpellCheckSpan[size];
        setLocale(mTextView.getTextServicesLocale());
        mCookie = hashCode();
        // ---------- Original Method ----------
        //mTextView = textView;
        //final int size = ArrayUtils.idealObjectArraySize(1);
        //mIds = new int[size];
        //mSpellCheckSpans = new SpellCheckSpan[size];
        //setLocale(mTextView.getTextServicesLocale());
        //mCookie = hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.563 -0400", hash_original_method = "132221852F8DDF087B45024FD49A8E7F", hash_generated_method = "C8D614DF60928C5163BF3624322FF464")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetSession() {
        closeSession();
        mTextServicesManager = (TextServicesManager) mTextView.getContext().
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        {
            boolean varC2A9336C71425F40818F6B08D3000A2D_1670065472 = (!mTextServicesManager.isSpellCheckerEnabled());
            {
                mSpellCheckerSession = null;
            } //End block
            {
                mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(
                    null ,
                    mCurrentLocale, this,
                    false );
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            {
                mSpellCheckSpans[i].setSpellCheckInProgress(false);
                mIds[i] = -1;
            } //End block
        } //End collapsed parenthetic
        mLength = 0;
        mTextView.removeMisspelledSpans((Editable) mTextView.getText());
        mTextView.onLocaleChanged();
        // ---------- Original Method ----------
        //closeSession();
        //mTextServicesManager = (TextServicesManager) mTextView.getContext().
                //getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        //if (!mTextServicesManager.isSpellCheckerEnabled()) {
            //mSpellCheckerSession = null;
        //} else {
            //mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(
                    //null ,
                    //mCurrentLocale, this,
                    //false );
        //}
        //for (int i = 0; i < mLength; i++) {
            //mSpellCheckSpans[i].setSpellCheckInProgress(false);
            //mIds[i] = -1;
        //}
        //mLength = 0;
        //mTextView.removeMisspelledSpans((Editable) mTextView.getText());
        //mTextView.onLocaleChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.563 -0400", hash_original_method = "A16726E56767CB6AA7867DE749E54AF0", hash_generated_method = "7F4C82918CCE6163DE3DA05057D242D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setLocale(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        resetSession();
        mWordIterator = new WordIterator(locale);
        mTextView.onLocaleChanged();
        // ---------- Original Method ----------
        //mCurrentLocale = locale;
        //resetSession();
        //mWordIterator = new WordIterator(locale);
        //mTextView.onLocaleChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.563 -0400", hash_original_method = "7E55E284FCAD6408034DF45536DFE0B3", hash_generated_method = "723E3AAFC90C9403F8FB11DA39295747")
    @DSModeled(DSC.SAFE)
    private boolean isSessionActive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpellCheckerSession != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.563 -0400", hash_original_method = "AAA52197918C65A359451CD46304BE67", hash_generated_method = "F43F6EA67D71A5C325A8C2D086F7A2EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void closeSession() {
        {
            mSpellCheckerSession.close();
        } //End block
        int length;
        length = mSpellParsers.length;
        {
            int i;
            i = 0;
            {
                mSpellParsers[i].finish();
            } //End block
        } //End collapsed parenthetic
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } //End block
        // ---------- Original Method ----------
        //if (mSpellCheckerSession != null) {
            //mSpellCheckerSession.close();
        //}
        //final int length = mSpellParsers.length;
        //for (int i = 0; i < length; i++) {
            //mSpellParsers[i].finish();
        //}
        //if (mSpellRunnable != null) {
            //mTextView.removeCallbacks(mSpellRunnable);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.564 -0400", hash_original_method = "5D19DB78B5A2119B2E660E625690F49E", hash_generated_method = "720CCBAFA3498B9C49A277145A9FBD42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nextSpellCheckSpanIndex() {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        {
            int newSize;
            newSize = mLength * 2;
            int[] newIds;
            newIds = new int[newSize];
            SpellCheckSpan[] newSpellCheckSpans;
            newSpellCheckSpans = new SpellCheckSpan[newSize];
            System.arraycopy(mIds, 0, newIds, 0, mLength);
            System.arraycopy(mSpellCheckSpans, 0, newSpellCheckSpans, 0, mLength);
            mIds = newIds;
            mSpellCheckSpans = newSpellCheckSpans;
        } //End block
        mSpellCheckSpans[mLength] = new SpellCheckSpan();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = 0; i < mLength; i++) {
            //if (mIds[i] < 0) return i;
        //}
        //if (mLength == mSpellCheckSpans.length) {
            //final int newSize = mLength * 2;
            //int[] newIds = new int[newSize];
            //SpellCheckSpan[] newSpellCheckSpans = new SpellCheckSpan[newSize];
            //System.arraycopy(mIds, 0, newIds, 0, mLength);
            //System.arraycopy(mSpellCheckSpans, 0, newSpellCheckSpans, 0, mLength);
            //mIds = newIds;
            //mSpellCheckSpans = newSpellCheckSpans;
        //}
        //mSpellCheckSpans[mLength] = new SpellCheckSpan();
        //mLength++;
        //return mLength - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.564 -0400", hash_original_method = "A1EABCB0A317A13B5BB9A67E3EDF2F7D", hash_generated_method = "D1E273F3F2DD5938D8D8CCC5F3606E84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addSpellCheckSpan(Editable editable, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(editable.dsTaint);
        int index;
        index = nextSpellCheckSpanIndex();
        editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIds[index] = mSpanSequenceCounter++;
        // ---------- Original Method ----------
        //final int index = nextSpellCheckSpanIndex();
        //editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //mIds[index] = mSpanSequenceCounter++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.564 -0400", hash_original_method = "E45444ACDA725CE9A6A26FFAD79AE5C6", hash_generated_method = "871168F5D62FF587A421C0BC3C577FFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeSpellCheckSpan(SpellCheckSpan spellCheckSpan) {
        dsTaint.addTaint(spellCheckSpan.dsTaint);
        {
            int i;
            i = 0;
            {
                {
                    mSpellCheckSpans[i].setSpellCheckInProgress(false);
                    mIds[i] = -1;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < mLength; i++) {
            //if (mSpellCheckSpans[i] == spellCheckSpan) {
                //mSpellCheckSpans[i].setSpellCheckInProgress(false);
                //mIds[i] = -1;
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.564 -0400", hash_original_method = "91E9278A0058E0FC6383B30785A8CFA9", hash_generated_method = "D00D41525B8D7A6F78ACFD7BB33C5992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSelectionChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        spellCheck();
        // ---------- Original Method ----------
        //spellCheck();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.565 -0400", hash_original_method = "6CA87C3B81B676351D5CE260A5491025", hash_generated_method = "6141D64A2B4FDF2BC7B444171A38BEAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void spellCheck(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Locale locale;
        locale = mTextView.getTextServicesLocale();
        {
            boolean var92322F8189DB31C9BFD6B6FE90DD5EB9_57875812 = (mCurrentLocale == null || (!(mCurrentLocale.equals(locale))));
            {
                setLocale(locale);
                start = 0;
                end = mTextView.getText().length();
            } //End block
            {
                boolean spellCheckerActivated;
                spellCheckerActivated = mTextServicesManager.isSpellCheckerEnabled();
                {
                    boolean var80C3218921ED99D2ADFEA4E3A2E45C2E_701888188 = (isSessionActive() != spellCheckerActivated);
                    {
                        resetSession();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9433F5A259C3ED6B89B6B6398D504A0A_546621337 = (!isSessionActive());
        } //End collapsed parenthetic
        int length;
        length = mSpellParsers.length;
        {
            int i;
            i = 0;
            {
                SpellParser spellParser;
                spellParser = mSpellParsers[i];
                {
                    boolean var0082180255A9D08BEB76790D259BEC35_1650502984 = (spellParser.isFinished());
                    {
                        spellParser.init(start, end);
                        spellParser.parse();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        SpellParser[] newSpellParsers;
        newSpellParsers = new SpellParser[length + 1];
        System.arraycopy(mSpellParsers, 0, newSpellParsers, 0, length);
        mSpellParsers = newSpellParsers;
        SpellParser spellParser;
        spellParser = new SpellParser();
        mSpellParsers[length] = spellParser;
        spellParser.init(start, end);
        spellParser.parse();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.565 -0400", hash_original_method = "BA5B8BA52678A659BE9D822C4132A8EA", hash_generated_method = "2DCAECAA75B0D42D2CE40296A0CC0880")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void spellCheck() {
        Editable editable;
        editable = (Editable) mTextView.getText();
        int selectionStart;
        selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd;
        selectionEnd = Selection.getSelectionEnd(editable);
        TextInfo[] textInfos;
        textInfos = new TextInfo[mLength];
        int textInfosCount;
        textInfosCount = 0;
        {
            int i;
            i = 0;
            {
                SpellCheckSpan spellCheckSpan;
                spellCheckSpan = mSpellCheckSpans[i];
                {
                    boolean var8EFC4F507046E540E16E2602424A567A_46157624 = (spellCheckSpan.isSpellCheckInProgress());
                } //End collapsed parenthetic
                int start;
                start = editable.getSpanStart(spellCheckSpan);
                int end;
                end = editable.getSpanEnd(spellCheckSpan);
                {
                    String word;
                    word = ((SpannableStringBuilder) editable).substring(start, end);
                    word = editable.subSequence(start, end).toString();
                    spellCheckSpan.setSpellCheckInProgress(true);
                    textInfos[textInfosCount++] = new TextInfo(word, mCookie, mIds[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                TextInfo[] textInfosCopy;
                textInfosCopy = new TextInfo[textInfosCount];
                System.arraycopy(textInfos, 0, textInfosCopy, 0, textInfosCount);
                textInfos = textInfosCopy;
            } //End block
            mSpellCheckerSession.getSuggestions(textInfos, SuggestionSpan.SUGGESTIONS_MAX_SIZE,
                    false );
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.566 -0400", hash_original_method = "A75E28D7E7AFF4B0223DAD7BAD9E1275", hash_generated_method = "AE46C166EE918A41D1E52E1452E7916B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onGetSuggestions(SuggestionsInfo[] results) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(results[0].dsTaint);
        Editable editable;
        editable = (Editable) mTextView.getText();
        {
            int i;
            i = 0;
            {
                SuggestionsInfo suggestionsInfo;
                suggestionsInfo = results[i];
                {
                    boolean var9B514A225DEF4154DD4352971E947BA9_1143711934 = (suggestionsInfo.getCookie() != mCookie);
                } //End collapsed parenthetic
                int sequenceNumber;
                sequenceNumber = suggestionsInfo.getSequence();
                {
                    int j;
                    j = 0;
                    {
                        {
                            int attributes;
                            attributes = suggestionsInfo.getSuggestionsAttributes();
                            boolean isInDictionary;
                            isInDictionary = ((attributes & SuggestionsInfo.RESULT_ATTR_IN_THE_DICTIONARY) > 0);
                            boolean looksLikeTypo;
                            looksLikeTypo = ((attributes & SuggestionsInfo.RESULT_ATTR_LOOKS_LIKE_TYPO) > 0);
                            SpellCheckSpan spellCheckSpan;
                            spellCheckSpan = mSpellCheckSpans[j];
                            {
                                createMisspelledSuggestionSpan(editable, suggestionsInfo, spellCheckSpan);
                            } //End block
                            editable.removeSpan(spellCheckSpan);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        scheduleNewSpellCheck();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.566 -0400", hash_original_method = "57E44CFBFBBC7EE198958F01316D8781", hash_generated_method = "B7F801E753422130401D086AC51864A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void scheduleNewSpellCheck() {
        {
            mSpellRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.566 -0400", hash_original_method = "37CFD7A65FD2E81573DE2B2CB07AD40E", hash_generated_method = "B064B230B911E557C8C58563197076C0")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void run() {
                    int length;
                    length = mSpellParsers.length;
                    {
                        int i;
                        i = 0;
                        {
                            SpellParser spellParser;
                            spellParser = mSpellParsers[i];
                            {
                                boolean varAFFEFD3A7D11AB4DF09303DDD35E86D6_939479620 = (!spellParser.isFinished());
                                {
                                    spellParser.parse();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //final int length = mSpellParsers.length;
                    //for (int i = 0; i < length; i++) {
                        //final SpellParser spellParser = mSpellParsers[i];
                        //if (!spellParser.isFinished()) {
                            //spellParser.parse();
                            //break; 
                        //}
                    //}
                }
};
        } //End block
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } //End block
        mTextView.postDelayed(mSpellRunnable, SPELL_PAUSE_DURATION);
        // ---------- Original Method ----------
        //if (mSpellRunnable == null) {
            //mSpellRunnable = new Runnable() {
                //@Override
                //public void run() {
                    //final int length = mSpellParsers.length;
                    //for (int i = 0; i < length; i++) {
                        //final SpellParser spellParser = mSpellParsers[i];
                        //if (!spellParser.isFinished()) {
                            //spellParser.parse();
                            //break; 
                        //}
                    //}
                //}
            //};
        //} else {
            //mTextView.removeCallbacks(mSpellRunnable);
        //}
        //mTextView.postDelayed(mSpellRunnable, SPELL_PAUSE_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.567 -0400", hash_original_method = "7C6C5A03DA2C9F5FF814A532005DE2A2", hash_generated_method = "B2B93D2B1C1AD3A7A02EA6053047540B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo,
            SpellCheckSpan spellCheckSpan) {
        dsTaint.addTaint(spellCheckSpan.dsTaint);
        dsTaint.addTaint(editable.dsTaint);
        dsTaint.addTaint(suggestionsInfo.dsTaint);
        int start;
        start = editable.getSpanStart(spellCheckSpan);
        int end;
        end = editable.getSpanEnd(spellCheckSpan);
        SuggestionSpan[] suggestionSpans;
        suggestionSpans = editable.getSpans(start, end, SuggestionSpan.class);
        int length;
        length = suggestionSpans.length;
        {
            int i;
            i = 0;
            {
                int spanStart;
                spanStart = editable.getSpanStart(suggestionSpans[i]);
                int spanEnd;
                spanEnd = editable.getSpanEnd(suggestionSpans[i]);
                {
                    suggestionSpans[i] = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int suggestionsCount;
        suggestionsCount = suggestionsInfo.getSuggestionsCount();
        String[] suggestions;
        {
            suggestions = ArrayUtils.emptyArray(String.class);
        } //End block
        {
            int numberOfSuggestions;
            numberOfSuggestions = 0;
            suggestions = new String[suggestionsCount];
            {
                int i;
                i = 0;
                {
                    String spellSuggestion;
                    spellSuggestion = suggestionsInfo.getSuggestionAt(i);
                    boolean suggestionFound;
                    suggestionFound = false;
                    {
                        int j;
                        j = 0;
                        {
                            String[] suggests;
                            suggests = suggestionSpans[j].getSuggestions();
                            {
                                int k;
                                k = 0;
                                {
                                    {
                                        boolean var679E4D2EFFB38ED1AC184217089AEF33_1570026657 = (spellSuggestion.equals(suggests[k]));
                                        {
                                            suggestionFound = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        suggestions[numberOfSuggestions++] = spellSuggestion;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                String[] newSuggestions;
                newSuggestions = new String[numberOfSuggestions];
                System.arraycopy(suggestions, 0, newSuggestions, 0, numberOfSuggestions);
                suggestions = newSuggestions;
            } //End block
        } //End block
        SuggestionSpan suggestionSpan;
        suggestionSpan = new SuggestionSpan(mTextView.getContext(), suggestions,
                SuggestionSpan.FLAG_EASY_CORRECT | SuggestionSpan.FLAG_MISSPELLED);
        editable.setSpan(suggestionSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView.invalidateRegion(start, end, false );
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class SpellParser {
        private Object mRange = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.567 -0400", hash_original_method = "8714270D7D855591FA7FA274FED8BA3C", hash_generated_method = "8714270D7D855591FA7FA274FED8BA3C")
                public SpellParser ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.567 -0400", hash_original_method = "C4550C9FA073E61C6C7A190D43162B55", hash_generated_method = "D03B1FDA8DC8B8317FBC9DCABEE9CA29")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void init(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            ((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            // ---------- Original Method ----------
            //((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    //Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.567 -0400", hash_original_method = "86B0D995E6C3BF5225FAD4AECF9F58F6", hash_generated_method = "45B8F4A922A98FCBE98DADDE73470229")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finish() {
            ((Editable) mTextView.getText()).removeSpan(mRange);
            // ---------- Original Method ----------
            //((Editable) mTextView.getText()).removeSpan(mRange);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.568 -0400", hash_original_method = "F88808B62872052B620FE7CDA250E1D3", hash_generated_method = "D622A4A766B3A2480566DE3F5544E9EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isFinished() {
            boolean varF8782931D05D05EFA9FB95C9E3E04ED2_1572939832 = (((Editable) mTextView.getText()).getSpanStart(mRange) < 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ((Editable) mTextView.getText()).getSpanStart(mRange) < 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.568 -0400", hash_original_method = "D0FCA268222D024780345A48D1B99D28", hash_generated_method = "0AE80E049F415EC3A5996C1777F9A6F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void parse() {
            Editable editable;
            editable = (Editable) mTextView.getText();
            int start;
            start = editable.getSpanStart(mRange);
            int end;
            end = editable.getSpanEnd(mRange);
            int wordIteratorWindowEnd;
            wordIteratorWindowEnd = Math.min(end, start + WORD_ITERATOR_INTERVAL);
            mWordIterator.setCharSequence(editable, start, wordIteratorWindowEnd);
            int wordStart;
            wordStart = mWordIterator.preceding(start);
            int wordEnd;
            {
                wordEnd = mWordIterator.following(start);
                {
                    wordStart = mWordIterator.getBeginning(wordEnd);
                } //End block
            } //End block
            {
                wordEnd = mWordIterator.getEnd(wordStart);
            } //End block
            {
                editable.removeSpan(mRange);
            } //End block
            SpellCheckSpan[] spellCheckSpans;
            spellCheckSpans = editable.getSpans(start - 1, end + 1,
                    SpellCheckSpan.class);
            SuggestionSpan[] suggestionSpans;
            suggestionSpans = editable.getSpans(start - 1, end + 1,
                    SuggestionSpan.class);
            int wordCount;
            wordCount = 0;
            boolean scheduleOtherSpellCheck;
            scheduleOtherSpellCheck = false;
            {
                {
                    {
                        scheduleOtherSpellCheck = true;
                    } //End block
                    {
                        removeSpansAt(editable, start, spellCheckSpans);
                        removeSpansAt(editable, start, suggestionSpans);
                    } //End block
                    {
                        removeSpansAt(editable, end, spellCheckSpans);
                        removeSpansAt(editable, end, suggestionSpans);
                    } //End block
                    boolean createSpellCheckSpan;
                    createSpellCheckSpan = true;
                    {
                        {
                            int i;
                            i = 0;
                            {
                                int spanEnd;
                                spanEnd = editable.getSpanEnd(spellCheckSpans[i]);
                                {
                                    createSpellCheckSpan = false;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            {
                                int spanStart;
                                spanStart = editable.getSpanStart(spellCheckSpans[i]);
                                {
                                    createSpellCheckSpan = false;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        addSpellCheckSpan(editable, wordStart, wordEnd);
                    } //End block
                } //End block
                int originalWordEnd;
                originalWordEnd = wordEnd;
                wordEnd = mWordIterator.following(wordEnd);
                {
                    wordIteratorWindowEnd = Math.min(end, originalWordEnd + WORD_ITERATOR_INTERVAL);
                    mWordIterator.setCharSequence(editable, originalWordEnd, wordIteratorWindowEnd);
                    wordEnd = mWordIterator.following(originalWordEnd);
                } //End block
                wordStart = mWordIterator.getBeginning(wordEnd);
            } //End block
            {
                editable.setSpan(mRange, wordStart, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } //End block
            {
                editable.removeSpan(mRange);
            } //End block
            spellCheck();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.569 -0400", hash_original_method = "0A3768DE6F2D0EE4EDD70A588C9E13B1", hash_generated_method = "04AB7C745451A31176F67294E52FBC3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private <T> void removeSpansAt(Editable editable, int offset, T[] spans) {
            dsTaint.addTaint(spans[0].dsTaint);
            dsTaint.addTaint(offset);
            dsTaint.addTaint(editable.dsTaint);
            int length;
            length = spans.length;
            {
                int i;
                i = 0;
                {
                    T span;
                    span = spans[i];
                    int start;
                    start = editable.getSpanStart(span);
                    int end;
                    end = editable.getSpanEnd(span);
                    editable.removeSpan(span);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //final int length = spans.length;
            //for (int i = 0; i < length; i++) {
                //final T span = spans[i];
                //final int start = editable.getSpanStart(span);
                //if (start > offset) continue;
                //final int end = editable.getSpanEnd(span);
                //if (end < offset) continue;
                //editable.removeSpan(span);
            //}
        }

        
    }


    
    public static final int MAX_NUMBER_OF_WORDS = 50;
    public static final int AVERAGE_WORD_LENGTH = 7;
    public static final int WORD_ITERATOR_INTERVAL = AVERAGE_WORD_LENGTH * MAX_NUMBER_OF_WORDS;
    private final static int SPELL_PAUSE_DURATION = 400;
}

