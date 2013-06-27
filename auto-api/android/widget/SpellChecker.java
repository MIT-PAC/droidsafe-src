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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "D9194793393393DFA066BFA75444BC1B", hash_generated_field = "39E84A66981E43B1DC94949150BE2F63")

    SpellCheckerSession mSpellCheckerSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "17C86C09C6C4D7B6E875B4525EC536C5")

    int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "36CC87084E26172DAC189652DC599476", hash_generated_field = "E0098EAD32D043C9D60259B28F8B564F")

    private int[] mIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "6510E39ECA8928F2250B891717F5A8CC", hash_generated_field = "2D5AC40BAC78409DC57ABE64923C6BFA")

    private SpellCheckSpan[] mSpellCheckSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "1097136F397CF7E42037BCA6B5CF711D", hash_generated_field = "2B6FC6E38D9EBF03FD604200798A54CA")

    private SpellParser[] mSpellParsers = new SpellParser[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "AC9339910CAE8FD97505663E478C0899", hash_generated_field = "2AB80C042BBE999CBCF902D21883708D")

    private int mSpanSequenceCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "8CEE743DC82226DD3EB73C8E69CF1A2D", hash_generated_field = "1086F1F56F0517EEEF9DAE1810CF3039")

    private TextServicesManager mTextServicesManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.750 -0400", hash_original_field = "FFBFF259536F365D8C4815480679E9AD", hash_generated_field = "C12CAE036558C1FAAF23655B9A008A09")

    private Runnable mSpellRunnable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.751 -0400", hash_original_method = "EA2B38816C4BD4485D1FFEBB2CE3FE95", hash_generated_method = "7876A9B256C0DC0053E8420DCA26896A")
    public  SpellChecker(TextView textView) {
        mTextView = textView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.752 -0400", hash_original_method = "132221852F8DDF087B45024FD49A8E7F", hash_generated_method = "17E4BB46A66C9112D6133F8B12F53F6D")
    private void resetSession() {
        closeSession();
        mTextServicesManager = (TextServicesManager) mTextView.getContext().
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        {
            boolean varC2A9336C71425F40818F6B08D3000A2D_238510737 = (!mTextServicesManager.isSpellCheckerEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.752 -0400", hash_original_method = "A16726E56767CB6AA7867DE749E54AF0", hash_generated_method = "AD73757F5DEB354F3D13B9B46E22B6D0")
    private void setLocale(Locale locale) {
        mCurrentLocale = locale;
        resetSession();
        mWordIterator = new WordIterator(locale);
        mTextView.onLocaleChanged();
        // ---------- Original Method ----------
        //mCurrentLocale = locale;
        //resetSession();
        //mWordIterator = new WordIterator(locale);
        //mTextView.onLocaleChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.752 -0400", hash_original_method = "7E55E284FCAD6408034DF45536DFE0B3", hash_generated_method = "DE8B98D2F44F7D896A9C46EC2C5A7A3A")
    private boolean isSessionActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930362131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930362131;
        // ---------- Original Method ----------
        //return mSpellCheckerSession != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.753 -0400", hash_original_method = "AAA52197918C65A359451CD46304BE67", hash_generated_method = "F43F6EA67D71A5C325A8C2D086F7A2EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.757 -0400", hash_original_method = "5D19DB78B5A2119B2E660E625690F49E", hash_generated_method = "D303CAEB3AAAA2D6B26363D2E62F08E8")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470281935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470281935;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.758 -0400", hash_original_method = "A1EABCB0A317A13B5BB9A67E3EDF2F7D", hash_generated_method = "0D0F0394E26C08F3B14D0EB114D4B67F")
    private void addSpellCheckSpan(Editable editable, int start, int end) {
        int index;
        index = nextSpellCheckSpanIndex();
        editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIds[index] = mSpanSequenceCounter++;
        addTaint(editable.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //final int index = nextSpellCheckSpanIndex();
        //editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //mIds[index] = mSpanSequenceCounter++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.758 -0400", hash_original_method = "E45444ACDA725CE9A6A26FFAD79AE5C6", hash_generated_method = "3A8541D5E8F4D9635B409C3D21D9319B")
    public void removeSpellCheckSpan(SpellCheckSpan spellCheckSpan) {
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
        addTaint(spellCheckSpan.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i < mLength; i++) {
            //if (mSpellCheckSpans[i] == spellCheckSpan) {
                //mSpellCheckSpans[i].setSpellCheckInProgress(false);
                //mIds[i] = -1;
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.765 -0400", hash_original_method = "91E9278A0058E0FC6383B30785A8CFA9", hash_generated_method = "D00D41525B8D7A6F78ACFD7BB33C5992")
    public void onSelectionChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        spellCheck();
        // ---------- Original Method ----------
        //spellCheck();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.766 -0400", hash_original_method = "6CA87C3B81B676351D5CE260A5491025", hash_generated_method = "423A983F249EADDBF95BE7D058227030")
    public void spellCheck(int start, int end) {
        Locale locale;
        locale = mTextView.getTextServicesLocale();
        {
            boolean var92322F8189DB31C9BFD6B6FE90DD5EB9_1652785455 = (mCurrentLocale == null || (!(mCurrentLocale.equals(locale))));
            {
                setLocale(locale);
                start = 0;
                end = mTextView.getText().length();
            } //End block
            {
                boolean spellCheckerActivated;
                spellCheckerActivated = mTextServicesManager.isSpellCheckerEnabled();
                {
                    boolean var80C3218921ED99D2ADFEA4E3A2E45C2E_1877664215 = (isSessionActive() != spellCheckerActivated);
                    {
                        resetSession();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9433F5A259C3ED6B89B6B6398D504A0A_671195803 = (!isSessionActive());
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
                    boolean var0082180255A9D08BEB76790D259BEC35_1238955716 = (spellParser.isFinished());
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
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.779 -0400", hash_original_method = "BA5B8BA52678A659BE9D822C4132A8EA", hash_generated_method = "DB6645E19457C83F2CF50EA1F085329E")
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
                    boolean var8EFC4F507046E540E16E2602424A567A_505317743 = (spellCheckSpan.isSpellCheckInProgress());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.780 -0400", hash_original_method = "A75E28D7E7AFF4B0223DAD7BAD9E1275", hash_generated_method = "D65C0E28BE786B9D6C4F133F2DBF9382")
    @Override
    public void onGetSuggestions(SuggestionsInfo[] results) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Editable editable;
        editable = (Editable) mTextView.getText();
        {
            int i;
            i = 0;
            {
                SuggestionsInfo suggestionsInfo;
                suggestionsInfo = results[i];
                {
                    boolean var9B514A225DEF4154DD4352971E947BA9_502479508 = (suggestionsInfo.getCookie() != mCookie);
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
        addTaint(results[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.795 -0400", hash_original_method = "57E44CFBFBBC7EE198958F01316D8781", hash_generated_method = "D7FEB1CCB03A36E4811DD97D753A90E7")
    private void scheduleNewSpellCheck() {
        {
            mSpellRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.794 -0400", hash_original_method = "37CFD7A65FD2E81573DE2B2CB07AD40E", hash_generated_method = "D23E6EAED620CCC4592F719C2923A3A1")
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
                                boolean varAFFEFD3A7D11AB4DF09303DDD35E86D6_1771898346 = (!spellParser.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.807 -0400", hash_original_method = "7C6C5A03DA2C9F5FF814A532005DE2A2", hash_generated_method = "8FDF5C39EB6317EFA253CF939054C441")
    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo,
            SpellCheckSpan spellCheckSpan) {
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
                                        boolean var679E4D2EFFB38ED1AC184217089AEF33_1003505494 = (spellSuggestion.equals(suggests[k]));
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
        addTaint(editable.getTaint());
        addTaint(suggestionsInfo.getTaint());
        addTaint(spellCheckSpan.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class SpellParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.807 -0400", hash_original_field = "1F59510816481BF077F1395F9F3EA574", hash_generated_field = "82F647CE25A38C36E8A5E280A1933D4B")

        private Object mRange = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.807 -0400", hash_original_method = "A0F09AC113A054694810A2E52D3EE82C", hash_generated_method = "A0F09AC113A054694810A2E52D3EE82C")
        public SpellParser ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.808 -0400", hash_original_method = "C4550C9FA073E61C6C7A190D43162B55", hash_generated_method = "CE2CFEE7F96E3CBA5EBB3F5842E634C0")
        public void init(int start, int end) {
            ((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            addTaint(start);
            addTaint(end);
            // ---------- Original Method ----------
            //((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    //Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.808 -0400", hash_original_method = "86B0D995E6C3BF5225FAD4AECF9F58F6", hash_generated_method = "45B8F4A922A98FCBE98DADDE73470229")
        public void finish() {
            ((Editable) mTextView.getText()).removeSpan(mRange);
            // ---------- Original Method ----------
            //((Editable) mTextView.getText()).removeSpan(mRange);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.818 -0400", hash_original_method = "F88808B62872052B620FE7CDA250E1D3", hash_generated_method = "258B09F898827CCF0A236609F1A17310")
        public boolean isFinished() {
            boolean varF8782931D05D05EFA9FB95C9E3E04ED2_1015008866 = (((Editable) mTextView.getText()).getSpanStart(mRange) < 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949042890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_949042890;
            // ---------- Original Method ----------
            //return ((Editable) mTextView.getText()).getSpanStart(mRange) < 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.820 -0400", hash_original_method = "D0FCA268222D024780345A48D1B99D28", hash_generated_method = "0AE80E049F415EC3A5996C1777F9A6F5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.822 -0400", hash_original_method = "0A3768DE6F2D0EE4EDD70A588C9E13B1", hash_generated_method = "BBFEC9A2E56EBBBF31DE811344DA9189")
        private <T> void removeSpansAt(Editable editable, int offset, T[] spans) {
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
            addTaint(editable.getTaint());
            addTaint(offset);
            addTaint(spans[0].getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.822 -0400", hash_original_field = "F54A9A9D5F3DB132CD381555457FE23E", hash_generated_field = "19C90C4CA2F594AB68B25F39910E16CF")

    public static final int MAX_NUMBER_OF_WORDS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.822 -0400", hash_original_field = "860CBBA9CF833D356947E61516BCDFA0", hash_generated_field = "9616A9FABFCF7FC4A279A90FE83B0503")

    public static final int AVERAGE_WORD_LENGTH = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.822 -0400", hash_original_field = "E8C87E2933CBC193D2BB9358B267D7D9", hash_generated_field = "F089F91FA7DF5EB2F9DE5091AC7123A4")

    public static final int WORD_ITERATOR_INTERVAL = AVERAGE_WORD_LENGTH * MAX_NUMBER_OF_WORDS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.822 -0400", hash_original_field = "EE40FF3FDA56574BAC5273E1B9CA3CD5", hash_generated_field = "C2E6F9B6D5035F78047D11E762E022FD")

    private static int SPELL_PAUSE_DURATION = 400;
}

