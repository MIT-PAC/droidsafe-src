package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "D9194793393393DFA066BFA75444BC1B", hash_generated_field = "39E84A66981E43B1DC94949150BE2F63")

    SpellCheckerSession mSpellCheckerSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "17C86C09C6C4D7B6E875B4525EC536C5")

    int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "36CC87084E26172DAC189652DC599476", hash_generated_field = "E0098EAD32D043C9D60259B28F8B564F")

    private int[] mIds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "6510E39ECA8928F2250B891717F5A8CC", hash_generated_field = "2D5AC40BAC78409DC57ABE64923C6BFA")

    private SpellCheckSpan[] mSpellCheckSpans;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "1097136F397CF7E42037BCA6B5CF711D", hash_generated_field = "2B6FC6E38D9EBF03FD604200798A54CA")

    private SpellParser[] mSpellParsers = new SpellParser[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "AC9339910CAE8FD97505663E478C0899", hash_generated_field = "2AB80C042BBE999CBCF902D21883708D")

    private int mSpanSequenceCounter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "435FE0944C142BE50AF524B687A36B73", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "8CEE743DC82226DD3EB73C8E69CF1A2D", hash_generated_field = "1086F1F56F0517EEEF9DAE1810CF3039")

    private TextServicesManager mTextServicesManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_field = "FFBFF259536F365D8C4815480679E9AD", hash_generated_field = "C12CAE036558C1FAAF23655B9A008A09")

    private Runnable mSpellRunnable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.809 -0400", hash_original_method = "EA2B38816C4BD4485D1FFEBB2CE3FE95", hash_generated_method = "88E46BA7978A9979E678090F13EBF845")
    public  SpellChecker(TextView textView) {
        mTextView = textView;
        final int size = ArrayUtils.idealObjectArraySize(1);
        mIds = new int[size];
        mSpellCheckSpans = new SpellCheckSpan[size];
        setLocale(mTextView.getTextServicesLocale());
        mCookie = hashCode();
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.810 -0400", hash_original_method = "132221852F8DDF087B45024FD49A8E7F", hash_generated_method = "A2C4CFB9F2E54D41A9E35F776448E78C")
    private void resetSession() {
        closeSession();
        mTextServicesManager = (TextServicesManager) mTextView.getContext().
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
    if(!mTextServicesManager.isSpellCheckerEnabled())        
        {
            mSpellCheckerSession = null;
        } 
        else
        {
            mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(
                    null ,
                    mCurrentLocale, this,
                    false );
        } 
for(int i = 0;i < mLength;i++)
        {
            mSpellCheckSpans[i].setSpellCheckInProgress(false);
            mIds[i] = -1;
        } 
        mLength = 0;
        mTextView.removeMisspelledSpans((Editable) mTextView.getText());
        mTextView.onLocaleChanged();
        
        
        
                
        
            
        
            
                    
                    
                    
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.810 -0400", hash_original_method = "A16726E56767CB6AA7867DE749E54AF0", hash_generated_method = "AD73757F5DEB354F3D13B9B46E22B6D0")
    private void setLocale(Locale locale) {
        mCurrentLocale = locale;
        resetSession();
        mWordIterator = new WordIterator(locale);
        mTextView.onLocaleChanged();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.810 -0400", hash_original_method = "7E55E284FCAD6408034DF45536DFE0B3", hash_generated_method = "8B3A8307ED24F8C3C27EE61508CF14CF")
    private boolean isSessionActive() {
        boolean varB694535CC8119906BC8E325AD31D84D9_667023224 = (mSpellCheckerSession != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361033334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361033334;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.810 -0400", hash_original_method = "AAA52197918C65A359451CD46304BE67", hash_generated_method = "DE31D3C66C7C0F2ED014193375664D5E")
    public void closeSession() {
    if(mSpellCheckerSession != null)        
        {
            mSpellCheckerSession.close();
        } 
        final int length = mSpellParsers.length;
for(int i = 0;i < length;i++)
        {
            mSpellParsers[i].finish();
        } 
    if(mSpellRunnable != null)        
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } 
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.811 -0400", hash_original_method = "5D19DB78B5A2119B2E660E625690F49E", hash_generated_method = "F170F20738CAB7CC795C828A965B1E1F")
    private int nextSpellCheckSpanIndex() {
for(int i = 0;i < mLength;i++)
        {
    if(mIds[i] < 0)            
            {
            int var865C0C0B4AB0E063E5CAA3387C1A8741_645094292 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889037781 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889037781;
            }
        } 
    if(mLength == mSpellCheckSpans.length)        
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
        mLength++;
        int var6D42D696176FEED1A0FD1C14D7B43005_338395244 = (mLength - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093906259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093906259;
        
        
            
        
        
            
            
            
            
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.811 -0400", hash_original_method = "A1EABCB0A317A13B5BB9A67E3EDF2F7D", hash_generated_method = "31041C1BE68105820FB3E19596D9CB39")
    private void addSpellCheckSpan(Editable editable, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(editable.getTaint());
        final int index = nextSpellCheckSpanIndex();
        editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIds[index] = mSpanSequenceCounter++;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.811 -0400", hash_original_method = "E45444ACDA725CE9A6A26FFAD79AE5C6", hash_generated_method = "7E4901173F980EF2C24E314503A8DB3E")
    public void removeSpellCheckSpan(SpellCheckSpan spellCheckSpan) {
        addTaint(spellCheckSpan.getTaint());
for(int i = 0;i < mLength;i++)
        {
    if(mSpellCheckSpans[i] == spellCheckSpan)            
            {
                mSpellCheckSpans[i].setSpellCheckInProgress(false);
                mIds[i] = -1;
                return;
            } 
        } 
        
        
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.811 -0400", hash_original_method = "91E9278A0058E0FC6383B30785A8CFA9", hash_generated_method = "D00D41525B8D7A6F78ACFD7BB33C5992")
    public void onSelectionChanged() {
        
        spellCheck();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.812 -0400", hash_original_method = "6CA87C3B81B676351D5CE260A5491025", hash_generated_method = "9EB558F4EC5C9E5B0C744066A3010CD5")
    public void spellCheck(int start, int end) {
        addTaint(end);
        addTaint(start);
        final Locale locale = mTextView.getTextServicesLocale();
    if(mCurrentLocale == null || (!(mCurrentLocale.equals(locale))))        
        {
            setLocale(locale);
            start = 0;
            end = mTextView.getText().length();
        } 
        else
        {
            final boolean spellCheckerActivated = mTextServicesManager.isSpellCheckerEnabled();
    if(isSessionActive() != spellCheckerActivated)            
            {
                resetSession();
            } 
        } 
    if(!isSessionActive())        
        return;
        final int length = mSpellParsers.length;
for(int i = 0;i < length;i++)
        {
            final SpellParser spellParser = mSpellParsers[i];
    if(spellParser.isFinished())            
            {
                spellParser.init(start, end);
                spellParser.parse();
                return;
            } 
        } 
        SpellParser[] newSpellParsers = new SpellParser[length + 1];
        System.arraycopy(mSpellParsers, 0, newSpellParsers, 0, length);
        mSpellParsers = newSpellParsers;
        SpellParser spellParser = new SpellParser();
        mSpellParsers[length] = spellParser;
        spellParser.init(start, end);
        spellParser.parse();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.812 -0400", hash_original_method = "BA5B8BA52678A659BE9D822C4132A8EA", hash_generated_method = "AB67BCC5A01FBF8BEA03192F0BA7FF3B")
    private void spellCheck() {
    if(mSpellCheckerSession == null)        
        return;
        Editable editable = (Editable) mTextView.getText();
        final int selectionStart = Selection.getSelectionStart(editable);
        final int selectionEnd = Selection.getSelectionEnd(editable);
        TextInfo[] textInfos = new TextInfo[mLength];
        int textInfosCount = 0;
for(int i = 0;i < mLength;i++)
        {
            final SpellCheckSpan spellCheckSpan = mSpellCheckSpans[i];
    if(spellCheckSpan.isSpellCheckInProgress())            
            continue;
            final int start = editable.getSpanStart(spellCheckSpan);
            final int end = editable.getSpanEnd(spellCheckSpan);
    if(start >= 0 && end > start && (selectionEnd < start || selectionStart > end))            
            {
                final String word = (editable instanceof SpannableStringBuilder) ?
                        ((SpannableStringBuilder) editable).substring(start, end) :
                        editable.subSequence(start, end).toString();
                spellCheckSpan.setSpellCheckInProgress(true);
                textInfos[textInfosCount++] = new TextInfo(word, mCookie, mIds[i]);
            } 
        } 
    if(textInfosCount > 0)        
        {
    if(textInfosCount < textInfos.length)            
            {
                TextInfo[] textInfosCopy = new TextInfo[textInfosCount];
                System.arraycopy(textInfos, 0, textInfosCopy, 0, textInfosCount);
                textInfos = textInfosCopy;
            } 
            mSpellCheckerSession.getSuggestions(textInfos, SuggestionSpan.SUGGESTIONS_MAX_SIZE,
                    false );
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.812 -0400", hash_original_method = "A75E28D7E7AFF4B0223DAD7BAD9E1275", hash_generated_method = "A68988C4E715293F9680F78AE3674700")
    @Override
    public void onGetSuggestions(SuggestionsInfo[] results) {
        
        addTaint(results[0].getTaint());
        Editable editable = (Editable) mTextView.getText();
for(int i = 0;i < results.length;i++)
        {
            SuggestionsInfo suggestionsInfo = results[i];
    if(suggestionsInfo.getCookie() != mCookie)            
            continue;
            final int sequenceNumber = suggestionsInfo.getSequence();
for(int j = 0;j < mLength;j++)
            {
    if(sequenceNumber == mIds[j])                
                {
                    final int attributes = suggestionsInfo.getSuggestionsAttributes();
                    boolean isInDictionary = ((attributes & SuggestionsInfo.RESULT_ATTR_IN_THE_DICTIONARY) > 0);
                    boolean looksLikeTypo = ((attributes & SuggestionsInfo.RESULT_ATTR_LOOKS_LIKE_TYPO) > 0);
                    SpellCheckSpan spellCheckSpan = mSpellCheckSpans[j];
    if(!isInDictionary && looksLikeTypo)                    
                    {
                        createMisspelledSuggestionSpan(editable, suggestionsInfo, spellCheckSpan);
                    } 
                    editable.removeSpan(spellCheckSpan);
                    break;
                } 
            } 
        } 
        scheduleNewSpellCheck();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.813 -0400", hash_original_method = "57E44CFBFBBC7EE198958F01316D8781", hash_generated_method = "66F759D6DADD3AAD44AF4ADB176A8F39")
    private void scheduleNewSpellCheck() {
    if(mSpellRunnable == null)        
        {
            mSpellRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.813 -0400", hash_original_method = "37CFD7A65FD2E81573DE2B2CB07AD40E", hash_generated_method = "8841ED9AF94770C1BE99C58E4934974F")
        @Override
        public void run() {
            final int length = mSpellParsers.length;
for(int i = 0;i < length;i++)
            {
                final SpellParser spellParser = mSpellParsers[i];
    if(!spellParser.isFinished())                
                {
                    spellParser.parse();
                    break;
                } 
            } 
            
            
            
                        
                        
                            
                            
                        
                    
        }
};
        } 
        else
        {
            mTextView.removeCallbacks(mSpellRunnable);
        } 
        mTextView.postDelayed(mSpellRunnable, SPELL_PAUSE_DURATION);
        
        
            
                
                
                    
                    
                        
                        
                            
                            
                        
                    
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_method = "7C6C5A03DA2C9F5FF814A532005DE2A2", hash_generated_method = "0D61409EFEB7B30B8914D0A7C9130108")
    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo,
            SpellCheckSpan spellCheckSpan) {
        addTaint(spellCheckSpan.getTaint());
        addTaint(suggestionsInfo.getTaint());
        addTaint(editable.getTaint());
        final int start = editable.getSpanStart(spellCheckSpan);
        final int end = editable.getSpanEnd(spellCheckSpan);
    if(start < 0 || end <= start)        
        return;
        SuggestionSpan[] suggestionSpans = editable.getSpans(start, end, SuggestionSpan.class);
        final int length = suggestionSpans.length;
for(int i = 0;i < length;i++)
        {
            final int spanStart = editable.getSpanStart(suggestionSpans[i]);
            final int spanEnd = editable.getSpanEnd(suggestionSpans[i]);
    if(spanStart != start || spanEnd != end)            
            {
                suggestionSpans[i] = null;
            } 
        } 
        final int suggestionsCount = suggestionsInfo.getSuggestionsCount();
        String[] suggestions;
    if(suggestionsCount <= 0)        
        {
            suggestions = ArrayUtils.emptyArray(String.class);
        } 
        else
        {
            int numberOfSuggestions = 0;
            suggestions = new String[suggestionsCount];
for(int i = 0;i < suggestionsCount;i++)
            {
                final String spellSuggestion = suggestionsInfo.getSuggestionAt(i);
    if(spellSuggestion == null)                
                break;
                boolean suggestionFound = false;
for(int j = 0;j < length && !suggestionFound;j++)
                {
    if(suggestionSpans[j] == null)                    
                    break;
                    String[] suggests = suggestionSpans[j].getSuggestions();
for(int k = 0;k < suggests.length;k++)
                    {
    if(spellSuggestion.equals(suggests[k]))                        
                        {
                            suggestionFound = true;
                            break;
                        } 
                    } 
                } 
    if(!suggestionFound)                
                {
                    suggestions[numberOfSuggestions++] = spellSuggestion;
                } 
            } 
    if(numberOfSuggestions != suggestionsCount)            
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
        
        
    }

    
    private class SpellParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_field = "1F59510816481BF077F1395F9F3EA574", hash_generated_field = "82F647CE25A38C36E8A5E280A1933D4B")

        private Object mRange = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_method = "A0F09AC113A054694810A2E52D3EE82C", hash_generated_method = "A0F09AC113A054694810A2E52D3EE82C")
        public SpellParser ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_method = "C4550C9FA073E61C6C7A190D43162B55", hash_generated_method = "EE40AEFCD5DE794FC439BF1E12203269")
        public void init(int start, int end) {
            addTaint(end);
            addTaint(start);
            ((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_method = "86B0D995E6C3BF5225FAD4AECF9F58F6", hash_generated_method = "45B8F4A922A98FCBE98DADDE73470229")
        public void finish() {
            ((Editable) mTextView.getText()).removeSpan(mRange);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.814 -0400", hash_original_method = "F88808B62872052B620FE7CDA250E1D3", hash_generated_method = "ADF4B615A1BB595C56C0FEFB8FE28B1E")
        public boolean isFinished() {
            boolean varBAB72613879D558AA251DE010CEEF9CF_368948667 = (((Editable) mTextView.getText()).getSpanStart(mRange) < 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098868339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098868339;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.815 -0400", hash_original_method = "D0FCA268222D024780345A48D1B99D28", hash_generated_method = "1366A12354143EC0EFA97A9D3F6A86CD")
        public void parse() {
            Editable editable = (Editable) mTextView.getText();
            final int start = editable.getSpanStart(mRange);
            final int end = editable.getSpanEnd(mRange);
            int wordIteratorWindowEnd = Math.min(end, start + WORD_ITERATOR_INTERVAL);
            mWordIterator.setCharSequence(editable, start, wordIteratorWindowEnd);
            int wordStart = mWordIterator.preceding(start);
            int wordEnd;
    if(wordStart == BreakIterator.DONE)            
            {
                wordEnd = mWordIterator.following(start);
    if(wordEnd != BreakIterator.DONE)                
                {
                    wordStart = mWordIterator.getBeginning(wordEnd);
                } 
            } 
            else
            {
                wordEnd = mWordIterator.getEnd(wordStart);
            } 
    if(wordEnd == BreakIterator.DONE)            
            {
                editable.removeSpan(mRange);
                return;
            } 
            SpellCheckSpan[] spellCheckSpans = editable.getSpans(start - 1, end + 1,
                    SpellCheckSpan.class);
            SuggestionSpan[] suggestionSpans = editable.getSpans(start - 1, end + 1,
                    SuggestionSpan.class);
            int wordCount = 0;
            boolean scheduleOtherSpellCheck = false;
            while
(wordStart <= end)            
            {
    if(wordEnd >= start && wordEnd > wordStart)                
                {
    if(wordCount >= MAX_NUMBER_OF_WORDS)                    
                    {
                        scheduleOtherSpellCheck = true;
                        break;
                    } 
    if(wordStart < start && wordEnd > start)                    
                    {
                        removeSpansAt(editable, start, spellCheckSpans);
                        removeSpansAt(editable, start, suggestionSpans);
                    } 
    if(wordStart < end && wordEnd > end)                    
                    {
                        removeSpansAt(editable, end, spellCheckSpans);
                        removeSpansAt(editable, end, suggestionSpans);
                    } 
                    boolean createSpellCheckSpan = true;
    if(wordEnd == start)                    
                    {
for(int i = 0;i < spellCheckSpans.length;i++)
                        {
                            final int spanEnd = editable.getSpanEnd(spellCheckSpans[i]);
    if(spanEnd == start)                            
                            {
                                createSpellCheckSpan = false;
                                break;
                            } 
                        } 
                    } 
    if(wordStart == end)                    
                    {
for(int i = 0;i < spellCheckSpans.length;i++)
                        {
                            final int spanStart = editable.getSpanStart(spellCheckSpans[i]);
    if(spanStart == end)                            
                            {
                                createSpellCheckSpan = false;
                                break;
                            } 
                        } 
                    } 
    if(createSpellCheckSpan)                    
                    {
                        addSpellCheckSpan(editable, wordStart, wordEnd);
                    } 
                    wordCount++;
                } 
                int originalWordEnd = wordEnd;
                wordEnd = mWordIterator.following(wordEnd);
    if((wordIteratorWindowEnd < end) &&
                        (wordEnd == BreakIterator.DONE || wordEnd >= wordIteratorWindowEnd))                
                {
                    wordIteratorWindowEnd = Math.min(end, originalWordEnd + WORD_ITERATOR_INTERVAL);
                    mWordIterator.setCharSequence(editable, originalWordEnd, wordIteratorWindowEnd);
                    wordEnd = mWordIterator.following(originalWordEnd);
                } 
    if(wordEnd == BreakIterator.DONE)                
                break;
                wordStart = mWordIterator.getBeginning(wordEnd);
    if(wordStart == BreakIterator.DONE)                
                {
                    break;
                } 
            } 
    if(scheduleOtherSpellCheck)            
            {
                editable.setSpan(mRange, wordStart, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } 
            else
            {
                editable.removeSpan(mRange);
            } 
            spellCheck();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.816 -0400", hash_original_method = "0A3768DE6F2D0EE4EDD70A588C9E13B1", hash_generated_method = "F826D98320B305250B98F56F203BB81E")
        private <T> void removeSpansAt(Editable editable, int offset, T[] spans) {
            addTaint(spans[0].getTaint());
            addTaint(offset);
            addTaint(editable.getTaint());
            final int length = spans.length;
for(int i = 0;i < length;i++)
            {
                final T span = spans[i];
                final int start = editable.getSpanStart(span);
    if(start > offset)                
                continue;
                final int end = editable.getSpanEnd(span);
    if(end < offset)                
                continue;
                editable.removeSpan(span);
            } 
            
            
            
                
                
                
                
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.816 -0400", hash_original_field = "F54A9A9D5F3DB132CD381555457FE23E", hash_generated_field = "19C90C4CA2F594AB68B25F39910E16CF")

    public static final int MAX_NUMBER_OF_WORDS = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.816 -0400", hash_original_field = "860CBBA9CF833D356947E61516BCDFA0", hash_generated_field = "9616A9FABFCF7FC4A279A90FE83B0503")

    public static final int AVERAGE_WORD_LENGTH = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.816 -0400", hash_original_field = "E8C87E2933CBC193D2BB9358B267D7D9", hash_generated_field = "F089F91FA7DF5EB2F9DE5091AC7123A4")

    public static final int WORD_ITERATOR_INTERVAL = AVERAGE_WORD_LENGTH * MAX_NUMBER_OF_WORDS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.816 -0400", hash_original_field = "EE40FF3FDA56574BAC5273E1B9CA3CD5", hash_generated_field = "D13721220D50A86AF8557E9EE89E4674")

    private final static int SPELL_PAUSE_DURATION = 400;
}

