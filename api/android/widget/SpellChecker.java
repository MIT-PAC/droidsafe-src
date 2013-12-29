package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.BreakIterator;
import java.util.Locale;

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






public class SpellChecker implements SpellCheckerSessionListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:46.263 -0500", hash_original_field = "885BF3DCBEF5B9869B7208E79D6F77BF", hash_generated_field = "D3567E0D42B1F2B16C44D79D7255FBDE")

    // lock of the UI thread
    public static final int MAX_NUMBER_OF_WORDS = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.449 -0500", hash_original_field = "A322E4D596F08CA26B3F221C3E348DDE", hash_generated_field = "9616A9FABFCF7FC4A279A90FE83B0503")

    public static final int AVERAGE_WORD_LENGTH = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.450 -0500", hash_original_field = "39B47971F9073D527236E3D02A319A4A", hash_generated_field = "F089F91FA7DF5EB2F9DE5091AC7123A4")

    public static final int WORD_ITERATOR_INTERVAL = AVERAGE_WORD_LENGTH * MAX_NUMBER_OF_WORDS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.451 -0500", hash_original_field = "2BED8B4FF04A0E625A3063484F76CBA1", hash_generated_field = "D13721220D50A86AF8557E9EE89E4674")

    private final static int SPELL_PAUSE_DURATION = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.452 -0500", hash_original_field = "49AF0A2A014C0E7F98E27CA30429A8B6", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")


    private  TextView mTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.452 -0500", hash_original_field = "39E84A66981E43B1DC94949150BE2F63", hash_generated_field = "39E84A66981E43B1DC94949150BE2F63")


    SpellCheckerSession mSpellCheckerSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.453 -0500", hash_original_field = "17C86C09C6C4D7B6E875B4525EC536C5", hash_generated_field = "17C86C09C6C4D7B6E875B4525EC536C5")

     int mCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:46.269 -0500", hash_original_field = "E819B465C38B8028BC46AB427A1B0B56", hash_generated_field = "B26223675FF2DA144F321C4A47028400")

    // SpellCheckSpan has been recycled and can be-reused.
    // Contains null SpellCheckSpans after index mLength.
    private int[] mIds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.455 -0500", hash_original_field = "279CA5BFBFFF33D04CAC46085FC2324E", hash_generated_field = "2D5AC40BAC78409DC57ABE64923C6BFA")

    private SpellCheckSpan[] mSpellCheckSpans;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.455 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.456 -0500", hash_original_field = "FD9B68DA1535379B80DC53861496016F", hash_generated_field = "2B6FC6E38D9EBF03FD604200798A54CA")

    private SpellParser[] mSpellParsers = new SpellParser[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.457 -0500", hash_original_field = "8AC04DAD49EFCDE7727923F9CA94D728", hash_generated_field = "2AB80C042BBE999CBCF902D21883708D")


    private int mSpanSequenceCounter = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.458 -0500", hash_original_field = "0400C5C553DC4CBF37271C21855854A7", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")


    private Locale mCurrentLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:46.274 -0500", hash_original_field = "134C3C55F24C618FDDF57AD7DFB984D3", hash_generated_field = "6EF78397FF3909122D4E310EEBAF175E")

    // concurrently due to the asynchronous nature of onGetSuggestions.
    private WordIterator mWordIterator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.459 -0500", hash_original_field = "AF1217F2A0F182C8990DD16B7F790980", hash_generated_field = "1086F1F56F0517EEEF9DAE1810CF3039")


    private TextServicesManager mTextServicesManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.460 -0500", hash_original_field = "75D02CC5817A00C181F6E3BB0386AC2C", hash_generated_field = "C12CAE036558C1FAAF23655B9A008A09")


    private Runnable mSpellRunnable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.461 -0500", hash_original_method = "EA2B38816C4BD4485D1FFEBB2CE3FE95", hash_generated_method = "A1777576DC8FB19C1753F129AB340773")
    public SpellChecker(TextView textView) {
        mTextView = textView;

        // Arbitrary: these arrays will automatically double their sizes on demand
        final int size = ArrayUtils.idealObjectArraySize(1);
        mIds = new int[size];
        mSpellCheckSpans = new SpellCheckSpan[size];

        setLocale(mTextView.getTextServicesLocale());

        mCookie = hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.462 -0500", hash_original_method = "132221852F8DDF087B45024FD49A8E7F", hash_generated_method = "874D74E2A6EAC44D5D7DD5EBF9EE82F4")
    private void resetSession() {
        closeSession();

        mTextServicesManager = (TextServicesManager) mTextView.getContext().
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        if (!mTextServicesManager.isSpellCheckerEnabled()) {
            mSpellCheckerSession = null;
        } else {
            mSpellCheckerSession = mTextServicesManager.newSpellCheckerSession(
                    null /* Bundle not currently used by the textServicesManager */,
                    mCurrentLocale, this,
                    false /* means any available languages from current spell checker */);
        }

        // Restore SpellCheckSpans in pool
        for (int i = 0; i < mLength; i++) {
            mSpellCheckSpans[i].setSpellCheckInProgress(false);
            mIds[i] = -1;
        }
        mLength = 0;

        // Remove existing misspelled SuggestionSpans
        mTextView.removeMisspelledSpans((Editable) mTextView.getText());

        // This class is the listener for locale change: warn other locale-aware objects
        mTextView.onLocaleChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.463 -0500", hash_original_method = "A16726E56767CB6AA7867DE749E54AF0", hash_generated_method = "C2AC1BCDCC534DDE13B503F20343074A")
    private void setLocale(Locale locale) {
        mCurrentLocale = locale;

        resetSession();

        // Change SpellParsers' wordIterator locale
        mWordIterator = new WordIterator(locale);

        // This class is the listener for locale change: warn other locale-aware objects
        mTextView.onLocaleChanged();
    }

    /**
     * @return true if a spell checker session has successfully been created. Returns false if not,
     * for instance when spell checking has been disabled in settings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.463 -0500", hash_original_method = "7E55E284FCAD6408034DF45536DFE0B3", hash_generated_method = "3959D9B7D5E3D4B0CC84A9F9A6A35570")
    private boolean isSessionActive() {
        return mSpellCheckerSession != null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.464 -0500", hash_original_method = "AAA52197918C65A359451CD46304BE67", hash_generated_method = "3B2333A1FA87B3C96FD696DF0B2E5B9D")
    public void closeSession() {
        if (mSpellCheckerSession != null) {
            mSpellCheckerSession.close();
        }

        final int length = mSpellParsers.length;
        for (int i = 0; i < length; i++) {
            mSpellParsers[i].finish();
        }

        if (mSpellRunnable != null) {
            mTextView.removeCallbacks(mSpellRunnable);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.465 -0500", hash_original_method = "5D19DB78B5A2119B2E660E625690F49E", hash_generated_method = "D8C7D81FC65DEC567EFD212E697734D5")
    private int nextSpellCheckSpanIndex() {
        for (int i = 0; i < mLength; i++) {
            if (mIds[i] < 0) return i;
        }

        if (mLength == mSpellCheckSpans.length) {
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
        return mLength - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.466 -0500", hash_original_method = "A1EABCB0A317A13B5BB9A67E3EDF2F7D", hash_generated_method = "C327F612C55552BDFD2DBB5DB1090639")
    private void addSpellCheckSpan(Editable editable, int start, int end) {
        final int index = nextSpellCheckSpanIndex();
        editable.setSpan(mSpellCheckSpans[index], start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIds[index] = mSpanSequenceCounter++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.467 -0500", hash_original_method = "E45444ACDA725CE9A6A26FFAD79AE5C6", hash_generated_method = "83AC9CD89B9E97F7624DE52BE3D11E50")
    public void removeSpellCheckSpan(SpellCheckSpan spellCheckSpan) {
        for (int i = 0; i < mLength; i++) {
            if (mSpellCheckSpans[i] == spellCheckSpan) {
                mSpellCheckSpans[i].setSpellCheckInProgress(false);
                mIds[i] = -1;
                return;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.468 -0500", hash_original_method = "91E9278A0058E0FC6383B30785A8CFA9", hash_generated_method = "0D86C590074977C0FA8C9A59497291FD")
    public void onSelectionChanged() {
        spellCheck();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.469 -0500", hash_original_method = "6CA87C3B81B676351D5CE260A5491025", hash_generated_method = "AC71EBD0F54C610A0D436EF5FC3218EE")
    public void spellCheck(int start, int end) {
        final Locale locale = mTextView.getTextServicesLocale();
        if (mCurrentLocale == null || (!(mCurrentLocale.equals(locale)))) {
            setLocale(locale);
            // Re-check the entire text
            start = 0;
            end = mTextView.getText().length();
        } else {
            final boolean spellCheckerActivated = mTextServicesManager.isSpellCheckerEnabled();
            if (isSessionActive() != spellCheckerActivated) {
                // Spell checker has been turned of or off since last spellCheck
                resetSession();
            }
        }

        if (!isSessionActive()) return;

        final int length = mSpellParsers.length;
        for (int i = 0; i < length; i++) {
            final SpellParser spellParser = mSpellParsers[i];
            if (spellParser.isFinished()) {
                spellParser.init(start, end);
                spellParser.parse();
                return;
            }
        }

        // No available parser found in pool, create a new one
        SpellParser[] newSpellParsers = new SpellParser[length + 1];
        System.arraycopy(mSpellParsers, 0, newSpellParsers, 0, length);
        mSpellParsers = newSpellParsers;

        SpellParser spellParser = new SpellParser();
        mSpellParsers[length] = spellParser;
        spellParser.init(start, end);
        spellParser.parse();
    }

    
    private class SpellParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.476 -0500", hash_original_field = "676EE99A9776F8AE5800DDACE6182261", hash_generated_field = "82F647CE25A38C36E8A5E280A1933D4B")

        private Object mRange = new Object();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.312 -0400", hash_original_method = "A0F09AC113A054694810A2E52D3EE82C", hash_generated_method = "A0F09AC113A054694810A2E52D3EE82C")
        public SpellParser ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.477 -0500", hash_original_method = "C4550C9FA073E61C6C7A190D43162B55", hash_generated_method = "17019D136E335D7DF9D5CDDA854DF509")
        public void init(int start, int end) {
            ((Editable) mTextView.getText()).setSpan(mRange, start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.478 -0500", hash_original_method = "86B0D995E6C3BF5225FAD4AECF9F58F6", hash_generated_method = "8C5169334B2CED8718993DB2C895318E")
        public void finish() {
            ((Editable) mTextView.getText()).removeSpan(mRange);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.479 -0500", hash_original_method = "F88808B62872052B620FE7CDA250E1D3", hash_generated_method = "09970B19A3C69898E5AB0DFDF452706A")
        public boolean isFinished() {
            return ((Editable) mTextView.getText()).getSpanStart(mRange) < 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.480 -0500", hash_original_method = "D0FCA268222D024780345A48D1B99D28", hash_generated_method = "F0BA33A32DEDC9976D55844F54E1FEAE")
        public void parse() {
            Editable editable = (Editable) mTextView.getText();
            // Iterate over the newly added text and schedule new SpellCheckSpans
            final int start = editable.getSpanStart(mRange);
            final int end = editable.getSpanEnd(mRange);

            int wordIteratorWindowEnd = Math.min(end, start + WORD_ITERATOR_INTERVAL);
            mWordIterator.setCharSequence(editable, start, wordIteratorWindowEnd);

            // Move back to the beginning of the current word, if any
            int wordStart = mWordIterator.preceding(start);
            int wordEnd;
            if (wordStart == BreakIterator.DONE) {
                wordEnd = mWordIterator.following(start);
                if (wordEnd != BreakIterator.DONE) {
                    wordStart = mWordIterator.getBeginning(wordEnd);
                }
            } else {
                wordEnd = mWordIterator.getEnd(wordStart);
            }
            if (wordEnd == BreakIterator.DONE) {
                editable.removeSpan(mRange);
                return;
            }

            // We need to expand by one character because we want to include the spans that
            // end/start at position start/end respectively.
            SpellCheckSpan[] spellCheckSpans = editable.getSpans(start - 1, end + 1,
                    SpellCheckSpan.class);
            SuggestionSpan[] suggestionSpans = editable.getSpans(start - 1, end + 1,
                    SuggestionSpan.class);

            int wordCount = 0;
            boolean scheduleOtherSpellCheck = false;

            while (wordStart <= end) {
                if (wordEnd >= start && wordEnd > wordStart) {
                    if (wordCount >= MAX_NUMBER_OF_WORDS) {
                        scheduleOtherSpellCheck = true;
                        break;
                    }

                    // A new word has been created across the interval boundaries with this edit.
                    // Previous spans (ended on start / started on end) removed, not valid anymore
                    if (wordStart < start && wordEnd > start) {
                        removeSpansAt(editable, start, spellCheckSpans);
                        removeSpansAt(editable, start, suggestionSpans);
                    }

                    if (wordStart < end && wordEnd > end) {
                        removeSpansAt(editable, end, spellCheckSpans);
                        removeSpansAt(editable, end, suggestionSpans);
                    }

                    // Do not create new boundary spans if they already exist
                    boolean createSpellCheckSpan = true;
                    if (wordEnd == start) {
                        for (int i = 0; i < spellCheckSpans.length; i++) {
                            final int spanEnd = editable.getSpanEnd(spellCheckSpans[i]);
                            if (spanEnd == start) {
                                createSpellCheckSpan = false;
                                break;
                            }
                        }
                    }

                    if (wordStart == end) {
                        for (int i = 0; i < spellCheckSpans.length; i++) {
                            final int spanStart = editable.getSpanStart(spellCheckSpans[i]);
                            if (spanStart == end) {
                                createSpellCheckSpan = false;
                                break;
                            }
                        }
                    }

                    if (createSpellCheckSpan) {
                        addSpellCheckSpan(editable, wordStart, wordEnd);
                    }
                    wordCount++;
                }

                // iterate word by word
                int originalWordEnd = wordEnd;
                wordEnd = mWordIterator.following(wordEnd);
                if ((wordIteratorWindowEnd < end) &&
                        (wordEnd == BreakIterator.DONE || wordEnd >= wordIteratorWindowEnd)) {
                    wordIteratorWindowEnd = Math.min(end, originalWordEnd + WORD_ITERATOR_INTERVAL);
                    mWordIterator.setCharSequence(editable, originalWordEnd, wordIteratorWindowEnd);
                    wordEnd = mWordIterator.following(originalWordEnd);
                }
                if (wordEnd == BreakIterator.DONE) break;
                wordStart = mWordIterator.getBeginning(wordEnd);
                if (wordStart == BreakIterator.DONE) {
                    break;
                }
            }

            if (scheduleOtherSpellCheck) {
                editable.setSpan(mRange, wordStart, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                editable.removeSpan(mRange);
            }

            spellCheck();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.317 -0400", hash_original_method = "0A3768DE6F2D0EE4EDD70A588C9E13B1", hash_generated_method = "F826D98320B305250B98F56F203BB81E")
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
            } //End block
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.470 -0500", hash_original_method = "BA5B8BA52678A659BE9D822C4132A8EA", hash_generated_method = "3B0A69FB79C0002C486606C5FA6464C1")
    private void spellCheck() {
        if (mSpellCheckerSession == null) return;

        Editable editable = (Editable) mTextView.getText();
        final int selectionStart = Selection.getSelectionStart(editable);
        final int selectionEnd = Selection.getSelectionEnd(editable);

        TextInfo[] textInfos = new TextInfo[mLength];
        int textInfosCount = 0;

        for (int i = 0; i < mLength; i++) {
            final SpellCheckSpan spellCheckSpan = mSpellCheckSpans[i];
            if (spellCheckSpan.isSpellCheckInProgress()) continue;

            final int start = editable.getSpanStart(spellCheckSpan);
            final int end = editable.getSpanEnd(spellCheckSpan);

            // Do not check this word if the user is currently editing it
            if (start >= 0 && end > start && (selectionEnd < start || selectionStart > end)) {
                final String word = (editable instanceof SpannableStringBuilder) ?
                        ((SpannableStringBuilder) editable).substring(start, end) :
                        editable.subSequence(start, end).toString();
                spellCheckSpan.setSpellCheckInProgress(true);
                textInfos[textInfosCount++] = new TextInfo(word, mCookie, mIds[i]);
            }
        }

        if (textInfosCount > 0) {
            if (textInfosCount < textInfos.length) {
                TextInfo[] textInfosCopy = new TextInfo[textInfosCount];
                System.arraycopy(textInfos, 0, textInfosCopy, 0, textInfosCount);
                textInfos = textInfosCopy;
            }

            mSpellCheckerSession.getSuggestions(textInfos, SuggestionSpan.SUGGESTIONS_MAX_SIZE,
                    false /* TODO Set sequentialWords to true for initial spell check */);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.471 -0500", hash_original_method = "A75E28D7E7AFF4B0223DAD7BAD9E1275", hash_generated_method = "E142F685AEC6AAFFA634E822368B910A")
    @Override
public void onGetSuggestions(SuggestionsInfo[] results) {
        Editable editable = (Editable) mTextView.getText();

        for (int i = 0; i < results.length; i++) {
            SuggestionsInfo suggestionsInfo = results[i];
            if (suggestionsInfo.getCookie() != mCookie) continue;
            final int sequenceNumber = suggestionsInfo.getSequence();

            for (int j = 0; j < mLength; j++) {
                if (sequenceNumber == mIds[j]) {
                    final int attributes = suggestionsInfo.getSuggestionsAttributes();
                    boolean isInDictionary =
                            ((attributes & SuggestionsInfo.RESULT_ATTR_IN_THE_DICTIONARY) > 0);
                    boolean looksLikeTypo =
                            ((attributes & SuggestionsInfo.RESULT_ATTR_LOOKS_LIKE_TYPO) > 0);

                    SpellCheckSpan spellCheckSpan = mSpellCheckSpans[j];

                    if (!isInDictionary && looksLikeTypo) {
                        createMisspelledSuggestionSpan(editable, suggestionsInfo, spellCheckSpan);
                    }

                    editable.removeSpan(spellCheckSpan);
                    break;
                }
            }
        }

        scheduleNewSpellCheck();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.473 -0500", hash_original_method = "57E44CFBFBBC7EE198958F01316D8781", hash_generated_method = "017CA6AFA78AFCB595024AED85E0B8CB")
    private void scheduleNewSpellCheck() {
        if (mSpellRunnable == null) {
            mSpellRunnable = new Runnable() {
                @Override
                public void run() {
                    final int length = mSpellParsers.length;
                    for (int i = 0; i < length; i++) {
                        final SpellParser spellParser = mSpellParsers[i];
                        if (!spellParser.isFinished()) {
                            spellParser.parse();
                            break; // run one spell parser at a time to bound running time
                        }
                    }
                }
            };
        } else {
            mTextView.removeCallbacks(mSpellRunnable);
        }

        mTextView.postDelayed(mSpellRunnable, SPELL_PAUSE_DURATION);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:12.475 -0500", hash_original_method = "7C6C5A03DA2C9F5FF814A532005DE2A2", hash_generated_method = "9A8F1F8948434327F1D57C9AC94A3B27")
    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo,
            SpellCheckSpan spellCheckSpan) {
        final int start = editable.getSpanStart(spellCheckSpan);
        final int end = editable.getSpanEnd(spellCheckSpan);
        if (start < 0 || end <= start) return; // span was removed in the meantime

        // Other suggestion spans may exist on that region, with identical suggestions, filter
        // them out to avoid duplicates.
        SuggestionSpan[] suggestionSpans = editable.getSpans(start, end, SuggestionSpan.class);
        final int length = suggestionSpans.length;
        for (int i = 0; i < length; i++) {
            final int spanStart = editable.getSpanStart(suggestionSpans[i]);
            final int spanEnd = editable.getSpanEnd(suggestionSpans[i]);
            if (spanStart != start || spanEnd != end) {
                // Nulled (to avoid new array allocation) if not on that exact same region
                suggestionSpans[i] = null;
            }
        }

        final int suggestionsCount = suggestionsInfo.getSuggestionsCount();
        String[] suggestions;
        if (suggestionsCount <= 0) {
            // A negative suggestion count is possible
            suggestions = ArrayUtils.emptyArray(String.class);
        } else {
            int numberOfSuggestions = 0;
            suggestions = new String[suggestionsCount];

            for (int i = 0; i < suggestionsCount; i++) {
                final String spellSuggestion = suggestionsInfo.getSuggestionAt(i);
                if (spellSuggestion == null) break;
                boolean suggestionFound = false;

                for (int j = 0; j < length && !suggestionFound; j++) {
                    if (suggestionSpans[j] == null) break;

                    String[] suggests = suggestionSpans[j].getSuggestions();
                    for (int k = 0; k < suggests.length; k++) {
                        if (spellSuggestion.equals(suggests[k])) {
                            // The suggestion is already provided by an other SuggestionSpan
                            suggestionFound = true;
                            break;
                        }
                    }
                }

                if (!suggestionFound) {
                    suggestions[numberOfSuggestions++] = spellSuggestion;
                }
            }

            if (numberOfSuggestions != suggestionsCount) {
                String[] newSuggestions = new String[numberOfSuggestions];
                System.arraycopy(suggestions, 0, newSuggestions, 0, numberOfSuggestions);
                suggestions = newSuggestions;
            }
        }

        SuggestionSpan suggestionSpan = new SuggestionSpan(mTextView.getContext(), suggestions,
                SuggestionSpan.FLAG_EASY_CORRECT | SuggestionSpan.FLAG_MISSPELLED);
        editable.setSpan(suggestionSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.invalidateRegion(start, end, false /* No cursor involved */);
    }
}

