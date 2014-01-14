package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Array;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.android.internal.util.ArrayUtils;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable, GraphicsOperations {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.777 -0500", hash_original_method = "6E4B705F56C3BE22100FD14C8AB5330A", hash_generated_method = "83DC34C0333E4CBFD30BDA50C8F21BCD")
    
public static SpannableStringBuilder valueOf(CharSequence source) {
        if (source instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) source;
        } else {
            return new SpannableStringBuilder(source);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.880 -0500", hash_original_method = "6B7A1DDF85ADC183B3426DC1B4007521", hash_generated_method = "47901FCF4C66D2137EBF33493DFF4299")
    
private static String region(int start, int end) {
        return "(" + start + " ... " + end + ")";
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.912 -0500", hash_original_field = "8F8BB2875FCC75EB5D66BC4152125391", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.937 -0500", hash_original_field = "5576A15AD5E53DFDFD04B2077F7237D2", hash_generated_field = "C7F2D79B9AFA94FAA8193039FD601611")

    private static final int POINT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.939 -0500", hash_original_field = "E119A075AD5D169513CC4BE43025C7AF", hash_generated_field = "DAC314A52970829DE920414BCD420813")

    private static final int PARAGRAPH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.942 -0500", hash_original_field = "B057EC1C3F0DA3334DDE49EE2654C48F", hash_generated_field = "62F477B3AA465E1D6BB9002CA3207142")

    private static final int START_MASK = 0xF0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.945 -0500", hash_original_field = "EE13D9C7DA2F142A87803A3BF471C5C0", hash_generated_field = "DB23288AE0F2FDCBE5902F7D83D9C129")

    private static final int END_MASK = 0x0F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.947 -0500", hash_original_field = "B2F55F417DF258D38F3554DBD2EB984B", hash_generated_field = "6EE5967CCE475609F69D5553B70E80C8")

    private static final int START_SHIFT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.914 -0500", hash_original_field = "8C8A85521B489004093F260598DE60E3", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.916 -0500", hash_original_field = "FE2DC1C4E7D46875FA268CEDC057D0E8", hash_generated_field = "6CB0C9E6186F94D00B15A6B38EEADB93")

    private char[] mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.919 -0500", hash_original_field = "814FBC343EF399A89CC06DA8039F47C7", hash_generated_field = "40EFB69E13F0CDEFCFD23CECDA09F21F")

    private int mGapStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.921 -0500", hash_original_field = "6A4F5CBACDF19F9BE1207278678EA519", hash_generated_field = "A295E6D1722C924D1E523308C8F24CB5")

    private int mGapLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.923 -0500", hash_original_field = "CEB48CD34EDA945F7544A85E8671F5CB", hash_generated_field = "64DC9467A0917D43133A286556BA813F")

    private Object[] mSpans;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.926 -0500", hash_original_field = "CCB8DB5D1573B043ED78A6330B85E1F0", hash_generated_field = "84CB203FE2C516ED9C3D0BE9F569E2FC")

    private int[] mSpanStarts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.928 -0500", hash_original_field = "D2E4A5463E8A6AD5265E6488995C7D02", hash_generated_field = "B6B8A934A26F4A20670B5A234A93FAF3")

    private int[] mSpanEnds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.932 -0500", hash_original_field = "1D154F19747582370E0217CD18F3D7E9", hash_generated_field = "F6EC87D3CD6571312E304AA9452368CA")

    private int[] mSpanFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.934 -0500", hash_original_field = "72EED4C1552152EAD8F6596F5703265D", hash_generated_field = "BDC8CC3C9B276345952883B6B6FC3B62")

    private int mSpanCount;
    /**
     * Create a new SpannableStringBuilder with empty contents
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.768 -0500", hash_original_method = "FC61BFC3FC94A92F6E91F05B84386B00", hash_generated_method = "EE7A28C6AC161E3A60759D67AD59E395")
    
public SpannableStringBuilder() {
        this("");
    }

    /**
     * Create a new SpannableStringBuilder containing a copy of the
     * specified text, including its spans if any.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.771 -0500", hash_original_method = "9676D8694A6D1EC55F8FB5E1D9DC6D95", hash_generated_method = "03BD07DEFCF254DA0DD3FE825F1CB381")
    
public SpannableStringBuilder(CharSequence text) {
        this(text, 0, text.length());
    }

    /**
     * Create a new SpannableStringBuilder containing a copy of the
     * specified slice of the specified text, including its spans if any.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.774 -0500", hash_original_method = "D35C3B0425645BAC16D8668E04F8F0BF", hash_generated_method = "696E48EA35044F78DA5C2EF965CEEEC0")
    
public SpannableStringBuilder(CharSequence text, int start, int end) {
        int srclen = end - start;

        int len = ArrayUtils.idealCharArraySize(srclen + 1);
        mText = new char[len];
        mGapStart = srclen;
        mGapLength = len - srclen;

        TextUtils.getChars(text, start, end, mText, 0);

        mSpanCount = 0;
        int alloc = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[alloc];
        mSpanStarts = new int[alloc];
        mSpanEnds = new int[alloc];
        mSpanFlags = new int[alloc];

        if (text instanceof Spanned) {
            Spanned sp = (Spanned) text;
            Object[] spans = sp.getSpans(start, end, Object.class);

            for (int i = 0; i < spans.length; i++) {
                if (spans[i] instanceof NoCopySpan) {
                    continue;
                }
                
                int st = sp.getSpanStart(spans[i]) - start;
                int en = sp.getSpanEnd(spans[i]) - start;
                int fl = sp.getSpanFlags(spans[i]);

                if (st < 0)
                    st = 0;
                if (st > end - start)
                    st = end - start;

                if (en < 0)
                    en = 0;
                if (en > end - start)
                    en = end - start;

                setSpan(spans[i], st, en, fl);
            }
        }
    }

    /**
     * Return the char at the specified offset within the buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.780 -0500", hash_original_method = "8A39C40193810117501439EDABBFE6E5", hash_generated_method = "648001FDA029DADEC8796D207B8A9CB3")
    
public char charAt(int where) {
        int len = length();
        if (where < 0) {
            throw new IndexOutOfBoundsException("charAt: " + where + " < 0");
        } else if (where >= len) {
            throw new IndexOutOfBoundsException("charAt: " + where + " >= length " + len);
        }

        if (where >= mGapStart)
            return mText[where + mGapLength];
        else
            return mText[where];
    }
    
    @Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.785 -0500", hash_original_method = "976FC6C6553888C069C4B298C5B14B80", hash_generated_method = "6A048918BD28DC2C33A9C04D1160814B")
    
private void resizeFor(int size) {
        int newlen = ArrayUtils.idealCharArraySize(size + 1);
        char[] newtext = new char[newlen];

        int after = mText.length - (mGapStart + mGapLength);

        System.arraycopy(mText, 0, newtext, 0, mGapStart);
        System.arraycopy(mText, mText.length - after,
                         newtext, newlen - after, after);

        for (int i = 0; i < mSpanCount; i++) {
            if (mSpanStarts[i] > mGapStart)
                mSpanStarts[i] += newlen - mText.length;
            if (mSpanEnds[i] > mGapStart)
                mSpanEnds[i] += newlen - mText.length;
        }

        int oldlen = mText.length;
        mText = newtext;
        mGapLength += mText.length - oldlen;

        if (mGapLength < 1)
            new Exception("mGapLength < 1").printStackTrace();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.789 -0500", hash_original_method = "D9447594759C2324F4C84ED525D8EBA8", hash_generated_method = "611D69115DF2C3A10632F224CEC5FEF5")
    
private void moveGapTo(int where) {
        if (where == mGapStart)
            return;

        boolean atend = (where == length());

        if (where < mGapStart) {
            int overlap = mGapStart - where;

            System.arraycopy(mText, where,
                             mText, mGapStart + mGapLength - overlap, overlap);
        } else /* where > mGapStart */ {
            int overlap = where - mGapStart;

            System.arraycopy(mText, where + mGapLength - overlap,
                             mText, mGapStart, overlap);
        }

        // XXX be more clever
        for (int i = 0; i < mSpanCount; i++) {
            int start = mSpanStarts[i];
            int end = mSpanEnds[i];

            if (start > mGapStart)
                start -= mGapLength;
            if (start > where)
                start += mGapLength;
            else if (start == where) {
                int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;

                if (flag == POINT || (atend && flag == PARAGRAPH))
                    start += mGapLength;
            }

            if (end > mGapStart)
                end -= mGapLength;
            if (end > where)
                end += mGapLength;
            else if (end == where) {
                int flag = (mSpanFlags[i] & END_MASK);

                if (flag == POINT || (atend && flag == PARAGRAPH))
                    end += mGapLength;
            }

            mSpanStarts[i] = start;
            mSpanEnds[i] = end;
        }

        mGapStart = where;
    }

    // Documentation from interface
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.791 -0500", hash_original_method = "05B349B857A56AE010B814959800B44E", hash_generated_method = "2A5BC3E42E7CB674BEEAD8E38B07B85E")
    
public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        return replace(where, where, tb, start, end);
    }

    // Documentation from interface
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.794 -0500", hash_original_method = "8FF3D73D08A9AFA2B9C652CF8F4F615D", hash_generated_method = "9A3545162A2E1B09EF19F1A8F8FF88A9")
    
public SpannableStringBuilder insert(int where, CharSequence tb) {
        return replace(where, where, tb, 0, tb.length());
    }

    // Documentation from interface
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.797 -0500", hash_original_method = "CCAFF8AC74D86E62008C289B374BD199", hash_generated_method = "EE1B67175238DA30775E7B85500A64C9")
    
public SpannableStringBuilder delete(int start, int end) {
        SpannableStringBuilder ret = replace(start, end, "", 0, 0);

        if (mGapLength > 2 * length())
            resizeFor(length());
        
        return ret; // == this
    }
    
    @Override
	public void clear() {
		// TODO Auto-generated method stub
	}
    
    @Override
	public void clearSpans() {
		// TODO Auto-generated method stub
	}
    
    @Override
	public Editable append(CharSequence text) {
		// TODO Auto-generated method stub
		return null;
	}
    
    @Override
	public Editable append(CharSequence text, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
    
    @Override
	public Editable append(char text) {
		// TODO Auto-generated method stub
		return null;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.812 -0500", hash_original_method = "3C715BB6E3D7DD6490206A10C6A892D0", hash_generated_method = "D7B4185EE0026162CD749FD69F649C81")
    
private int change(int start, int end, CharSequence tb, int tbstart, int tbend) {
        return change(true, start, end, tb, tbstart, tbend);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.817 -0500", hash_original_method = "84DCE273834998C04B3160C57E76984B", hash_generated_method = "4807F0586C1EC2267048F63D9E9C7BBB")
    
private int change(boolean notify, int start, int end,
                       CharSequence tb, int tbstart, int tbend) {
        checkRange("replace", start, end);
        int ret = tbend - tbstart;
        TextWatcher[] recipients = null;

        if (notify) {
            recipients = sendTextWillChange(start, end - start, tbend - tbstart);
        }

        for (int i = mSpanCount - 1; i >= 0; i--) {
            if ((mSpanFlags[i] & SPAN_PARAGRAPH) == SPAN_PARAGRAPH) {
                int st = mSpanStarts[i];
                if (st > mGapStart)
                    st -= mGapLength;

                int en = mSpanEnds[i];
                if (en > mGapStart)
                    en -= mGapLength;

                int ost = st;
                int oen = en;
                int clen = length();

                if (st > start && st <= end) {
                    for (st = end; st < clen; st++)
                        if (st > end && charAt(st - 1) == '\n')
                            break;
                }

                if (en > start && en <= end) {
                    for (en = end; en < clen; en++)
                        if (en > end && charAt(en - 1) == '\n')
                            break;
                }

                if (st != ost || en != oen)
                    setSpan(mSpans[i], st, en, mSpanFlags[i]);
            }
        }

        moveGapTo(end);

        // Can be negative
        final int nbNewChars = (tbend - tbstart) - (end - start);

        if (nbNewChars >= mGapLength) {
            resizeFor(mText.length + nbNewChars - mGapLength);
        }

        mGapStart += nbNewChars;
        mGapLength -= nbNewChars;

        if (mGapLength < 1)
            new Exception("mGapLength < 1").printStackTrace();

        TextUtils.getChars(tb, tbstart, tbend, mText, start);

        if (tb instanceof Spanned) {
            Spanned sp = (Spanned) tb;
            Object[] spans = sp.getSpans(tbstart, tbend, Object.class);

            for (int i = 0; i < spans.length; i++) {
                int st = sp.getSpanStart(spans[i]);
                int en = sp.getSpanEnd(spans[i]);

                if (st < tbstart)
                    st = tbstart;
                if (en > tbend)
                    en = tbend;

                if (getSpanStart(spans[i]) < 0) {
                    setSpan(false, spans[i],
                            st - tbstart + start,
                            en - tbstart + start,
                            sp.getSpanFlags(spans[i]));
                }
            }
        }

        // no need for span fixup on pure insertion
        if (tbend > tbstart && end - start == 0) {
            if (notify) {
                sendTextChange(recipients, start, end - start, tbend - tbstart);
                sendTextHasChanged(recipients);
            }

            return ret;
        }

        boolean atend = (mGapStart + mGapLength == mText.length);

        for (int i = mSpanCount - 1; i >= 0; i--) {
            if (mSpanStarts[i] >= start &&
                mSpanStarts[i] < mGapStart + mGapLength) {
                int flag = (mSpanFlags[i] & START_MASK) >> START_SHIFT;

                if (flag == POINT || (flag == PARAGRAPH && atend))
                    mSpanStarts[i] = mGapStart + mGapLength;
                else
                    mSpanStarts[i] = start;
            }

            if (mSpanEnds[i] >= start &&
                mSpanEnds[i] < mGapStart + mGapLength) {
                int flag = (mSpanFlags[i] & END_MASK);

                if (flag == POINT || (flag == PARAGRAPH && atend))
                    mSpanEnds[i] = mGapStart + mGapLength;
                else
                    mSpanEnds[i] = start;
            }

            // remove 0-length SPAN_EXCLUSIVE_EXCLUSIVE
            if (mSpanEnds[i] < mSpanStarts[i]) {
                removeSpan(i);
            }
        }

        if (notify) {
            sendTextChange(recipients, start, end - start, tbend - tbstart);
            sendTextHasChanged(recipients);
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.820 -0500", hash_original_method = "5F40E5580DD9B6C8070DDBE86036D0A0", hash_generated_method = "9364AC549E7A123E8F1376E1430245A0")
    
private void removeSpan(int i) {
        Object object = mSpans[i];

        int start = mSpanStarts[i];
        int end = mSpanEnds[i];

        if (start > mGapStart) start -= mGapLength;
        if (end > mGapStart) end -= mGapLength;

        int count = mSpanCount - (i + 1);
        System.arraycopy(mSpans, i + 1, mSpans, i, count);
        System.arraycopy(mSpanStarts, i + 1, mSpanStarts, i, count);
        System.arraycopy(mSpanEnds, i + 1, mSpanEnds, i, count);
        System.arraycopy(mSpanFlags, i + 1, mSpanFlags, i, count);

        mSpanCount--;

        mSpans[mSpanCount] = null;

        sendSpanRemoved(object, start, end);
    }

    // Documentation from interface
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.823 -0500", hash_original_method = "F007284EC0E266D0B466C6FB60440DED", hash_generated_method = "77C79B68B302FE1DE97B168BF29FC276")
    
public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        return replace(start, end, tb, 0, tb.length());
    }

    // Documentation from interface
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.827 -0500", hash_original_method = "653147CE10EC22F15BE8C423BD65FA32", hash_generated_method = "3DABA23248A3CE7C0F1874570C59E1FA")
    
public SpannableStringBuilder replace(final int start, final int end,
                        CharSequence tb, int tbstart, int tbend) {
        int filtercount = mFilters.length;
        for (int i = 0; i < filtercount; i++) {
            CharSequence repl = mFilters[i].filter(tb, tbstart, tbend,
                                                   this, start, end);

            if (repl != null) {
                tb = repl;
                tbstart = 0;
                tbend = repl.length();
            }
        }

        if (end == start && tbstart == tbend) {
            return this;
        }

        if (end == start || tbstart == tbend) {
            change(start, end, tb, tbstart, tbend);
        } else {
            int selstart = Selection.getSelectionStart(this);
            int selend = Selection.getSelectionEnd(this);

            // XXX just make the span fixups in change() do the right thing
            // instead of this madness!

            checkRange("replace", start, end);
            moveGapTo(end);
            TextWatcher[] recipients;

            int origlen = end - start;

            recipients = sendTextWillChange(start, origlen, tbend - tbstart);

            if (mGapLength < 2)
                resizeFor(length() + 1);

            for (int i = mSpanCount - 1; i >= 0; i--) {
                if (mSpanStarts[i] == mGapStart)
                    mSpanStarts[i]++;

                if (mSpanEnds[i] == mGapStart)
                    mSpanEnds[i]++;
            }

            mText[mGapStart] = ' ';
            mGapStart++;
            mGapLength--;

            if (mGapLength < 1) {
                new Exception("mGapLength < 1").printStackTrace();
            }

            int inserted = change(false, start + 1, start + 1, tb, tbstart, tbend);
            change(false, start, start + 1, "", 0, 0);
            change(false, start + inserted, start + inserted + origlen, "", 0, 0);

            /*
             * Special case to keep the cursor in the same position
             * if it was somewhere in the middle of the replaced region.
             * If it was at the start or the end or crossing the whole
             * replacement, it should already be where it belongs.
             * TODO: Is there some more general mechanism that could
             * accomplish this?
             */
            if (selstart > start && selstart < end) {
                long off = selstart - start;

                off = off * inserted / (end - start);
                selstart = (int) off + start;

                setSpan(false, Selection.SELECTION_START, selstart, selstart,
                        Spanned.SPAN_POINT_POINT);
            }
            if (selend > start && selend < end) {
                long off = selend - start;

                off = off * inserted / (end - start);
                selend = (int) off + start;

                setSpan(false, Selection.SELECTION_END, selend, selend, Spanned.SPAN_POINT_POINT);
            }
            sendTextChange(recipients, start, origlen, inserted);
            sendTextHasChanged(recipients);
        }

        return this; 
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public void setSpan(Object what, int start, int end, int flags) {
		// TODO Auto-generated method stub
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.833 -0500", hash_original_method = "2D459893E2DC729F5693ABCD511FCC18", hash_generated_method = "B925D0EE1F9FF7EC27B80C692B7D7AF1")
    
private void setSpan(boolean send, Object what, int start, int end, int flags) {
        int nstart = start;
        int nend = end;

        checkRange("setSpan", start, end);

        if ((flags & START_MASK) == (PARAGRAPH << START_SHIFT)) {
            if (start != 0 && start != length()) {
                char c = charAt(start - 1);

                if (c != '\n')
                    throw new RuntimeException("PARAGRAPH span must start at paragraph boundary");
            }
        }

        if ((flags & END_MASK) == PARAGRAPH) {
            if (end != 0 && end != length()) {
                char c = charAt(end - 1);

                if (c != '\n')
                    throw new RuntimeException("PARAGRAPH span must end at paragraph boundary");
            }
        }

        if (start > mGapStart) {
            start += mGapLength;
        } else if (start == mGapStart) {
            int flag = (flags & START_MASK) >> START_SHIFT;

            if (flag == POINT || (flag == PARAGRAPH && start == length()))
                start += mGapLength;
        }

        if (end > mGapStart) {
            end += mGapLength;
        } else if (end == mGapStart) {
            int flag = (flags & END_MASK);

            if (flag == POINT || (flag == PARAGRAPH && end == length()))
                end += mGapLength;
        }

        int count = mSpanCount;
        Object[] spans = mSpans;

        for (int i = 0; i < count; i++) {
            if (spans[i] == what) {
                int ostart = mSpanStarts[i];
                int oend = mSpanEnds[i];

                if (ostart > mGapStart)
                    ostart -= mGapLength;
                if (oend > mGapStart)
                    oend -= mGapLength;

                mSpanStarts[i] = start;
                mSpanEnds[i] = end;
                mSpanFlags[i] = flags;

                if (send) 
                    sendSpanChanged(what, ostart, oend, nstart, nend);

                return;
            }
        }

        if (mSpanCount + 1 >= mSpans.length) {
            int newsize = ArrayUtils.idealIntArraySize(mSpanCount + 1);
            Object[] newspans = new Object[newsize];
            int[] newspanstarts = new int[newsize];
            int[] newspanends = new int[newsize];
            int[] newspanflags = new int[newsize];

            System.arraycopy(mSpans, 0, newspans, 0, mSpanCount);
            System.arraycopy(mSpanStarts, 0, newspanstarts, 0, mSpanCount);
            System.arraycopy(mSpanEnds, 0, newspanends, 0, mSpanCount);
            System.arraycopy(mSpanFlags, 0, newspanflags, 0, mSpanCount);

            mSpans = newspans;
            mSpanStarts = newspanstarts;
            mSpanEnds = newspanends;
            mSpanFlags = newspanflags;
        }

        mSpans[mSpanCount] = what;
        mSpanStarts[mSpanCount] = start;
        mSpanEnds[mSpanCount] = end;
        mSpanFlags[mSpanCount] = flags;
        mSpanCount++;

        if (send)
            sendSpanAdded(what, nstart, nend);
    }
    
    @Override
	public void removeSpan(Object what) {
		// TODO Auto-generated method stub
	}

    /**
     * Return the buffer offset of the beginning of the specified
     * markup object, or -1 if it is not attached to this buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.839 -0500", hash_original_method = "DD4C166AC7D5C475EE46AC767DBD33EB", hash_generated_method = "D57039BB89705C38EEC76A5F0188763A")
    
public int getSpanStart(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                int where = mSpanStarts[i];

                if (where > mGapStart)
                    where -= mGapLength;

                return where;
            }
        }

        return -1;
    }

    /**
     * Return the buffer offset of the end of the specified
     * markup object, or -1 if it is not attached to this buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.842 -0500", hash_original_method = "1CAC5A6045B202B1FC928510B17AEEDD", hash_generated_method = "37B0998B57691BB4CF884757474F4BED")
    
public int getSpanEnd(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                int where = mSpanEnds[i];

                if (where > mGapStart)
                    where -= mGapLength;

                return where;
            }
        }

        return -1;
    }

    /**
     * Return the flags of the end of the specified
     * markup object, or 0 if it is not attached to this buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.844 -0500", hash_original_method = "DA0589F2510DDCCEED97B90C9189C1B9", hash_generated_method = "373D3AB510B3D543F644EE8A3B45B838")
    
public int getSpanFlags(Object what) {
        int count = mSpanCount;
        Object[] spans = mSpans;

        for (int i = count - 1; i >= 0; i--) {
            if (spans[i] == what) {
                return mSpanFlags[i];
            }
        }

        return 0; 
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.053 -0400", hash_original_method = "5CF7F75C8FAF8266A003E04C7C47A211", hash_generated_method = "F368E210A8A158B84C6EA5269A715CDD")
    @SuppressWarnings("unchecked")
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        addTaint(kind.getTaint());
        addTaint(queryEnd);
        addTaint(queryStart);
        if(kind == null)        
        {
T[] var9D4CC3533B24DD61A73D38EC233FFA92_1168608204 =         ArrayUtils.emptyArray(kind);
        var9D4CC3533B24DD61A73D38EC233FFA92_1168608204.addTaint(taint);
        return var9D4CC3533B24DD61A73D38EC233FFA92_1168608204;
        }
        int spanCount = mSpanCount;
        Object[] spans = mSpans;
        int[] starts = mSpanStarts;
        int[] ends = mSpanEnds;
        int[] flags = mSpanFlags;
        int gapstart = mGapStart;
        int gaplen = mGapLength;
        int count = 0;
        T[] ret = null;
        T ret1 = null;
for(int i = 0;i < spanCount;i++)
        {
            int spanStart = starts[i];
            if(spanStart > gapstart)            
            {
                spanStart -= gaplen;
            } //End block
            if(spanStart > queryEnd)            
            {
                continue;
            } //End block
            int spanEnd = ends[i];
            if(spanEnd > gapstart)            
            {
                spanEnd -= gaplen;
            } //End block
            if(spanEnd < queryStart)            
            {
                continue;
            } //End block
            if(spanStart != spanEnd && queryStart != queryEnd)            
            {
                if(spanStart == queryEnd)                
                continue;
                if(spanEnd == queryStart)                
                continue;
            } //End block
            if(!kind.isInstance(spans[i]))            
            continue;
            if(count == 0)            
            {
                ret1 = (T) spans[i];
                count++;
            } //End block
            else
            {
                if(count == 1)                
                {
                    ret = (T[]) Array.newInstance(kind, spanCount - i + 1);
                    ret[0] = ret1;
                } //End block
                int prio = flags[i] & SPAN_PRIORITY;
                if(prio != 0)                
                {
                    int j;
for(j = 0;j < count;j++)
                    {
                        int p = getSpanFlags(ret[j]) & SPAN_PRIORITY;
                        if(prio > p)                        
                        {
                            break;
                        } //End block
                    } //End block
                    System.arraycopy(ret, j, ret, j + 1, count - j);
                    ret[j] = (T) spans[i];
                    count++;
                } //End block
                else
                {
                    ret[count++] = (T) spans[i];
                } //End block
            } //End block
        } //End block
        if(count == 0)        
        {
T[] var9D4CC3533B24DD61A73D38EC233FFA92_674511624 =             ArrayUtils.emptyArray(kind);
            var9D4CC3533B24DD61A73D38EC233FFA92_674511624.addTaint(taint);
            return var9D4CC3533B24DD61A73D38EC233FFA92_674511624;
        } //End block
        if(count == 1)        
        {
            ret = (T[]) Array.newInstance(kind, 1);
            ret[0] = ret1;
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2021125999;
        } //End block
        if(count == ret.length)        
        {
T[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1094619637;
        } //End block
        T[] nret = (T[]) Array.newInstance(kind, count);
        System.arraycopy(ret, 0, nret, 0, count);
T[] var785F7C6C4DBBD240B854AFDE8D881E30_290589019 =         nret;
        var785F7C6C4DBBD240B854AFDE8D881E30_290589019.addTaint(taint);
        return var785F7C6C4DBBD240B854AFDE8D881E30_290589019;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Return the next offset after <code>start</code> but less than or
     * equal to <code>limit</code> where a span of the specified type
     * begins or ends.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.851 -0500", hash_original_method = "AC3B57A902A92307655B10B6A320F4FA", hash_generated_method = "08EF0D2A48EFF10756158651773C6BD1")
    
public int nextSpanTransition(int start, int limit, Class kind) {
        int count = mSpanCount;
        Object[] spans = mSpans;
        int[] starts = mSpanStarts;
        int[] ends = mSpanEnds;
        int gapstart = mGapStart;
        int gaplen = mGapLength;

        if (kind == null) {
            kind = Object.class;
        }

        for (int i = 0; i < count; i++) {
            int st = starts[i];
            int en = ends[i];

            if (st > gapstart)
                st -= gaplen;
            if (en > gapstart)
                en -= gaplen;

            if (st > start && st < limit && kind.isInstance(spans[i]))
                limit = st;
            if (en > start && en < limit && kind.isInstance(spans[i]))
                limit = en;
        }

        return limit;
    }
    
    @Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
    
    @Override
	public void getChars(int start, int end, char[] dest, int destoff) {
		// TODO Auto-generated method stub
	}
    
    @Override
	
	public String toString() {
		return new String();
	}

    /**
     * Return a String containing a copy of the chars in this buffer, limited to the
     * [start, end[ range.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.862 -0500", hash_original_method = "5E2755BFE298194FA4E39DBC872CF6D4", hash_generated_method = "CC06C753E8140A21D9D985E65F2F5230")
    
public String substring(int start, int end) {
        char[] buf = new char[end - start];
        getChars(start, end, buf, 0);
        return new String(buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.864 -0500", hash_original_method = "9EEE5F03C950DBDA8CD631C0E0A3B78A", hash_generated_method = "5C9748C0B437FC8674F47C7A9443FC7B")
    
private TextWatcher[] sendTextWillChange(int start, int before, int after) {
        TextWatcher[] recip = getSpans(start, start + before, TextWatcher.class);
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].beforeTextChanged(this, start, before, after);
        }

        return recip;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.867 -0500", hash_original_method = "B0F46C63F0D82B2972BAF2786F5024B6", hash_generated_method = "AFAA8E9BE07B166E1333098013CF609C")
    
private void sendTextChange(TextWatcher[] recip, int start, int before, int after) {
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].onTextChanged(this, start, before, after);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.869 -0500", hash_original_method = "B7AEF4E180417D3A92FE965B8D29719A", hash_generated_method = "5883A705572BE249EB4C077E99892A28")
    
private void sendTextHasChanged(TextWatcher[] recip) {
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].afterTextChanged(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.872 -0500", hash_original_method = "39DD82D37A3679E95040612AC2A4CD5D", hash_generated_method = "11589EF1504003C29FEA8ED0CAFCA936")
    
private void sendSpanAdded(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].onSpanAdded(this, what, start, end);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.875 -0500", hash_original_method = "8451F34A8F8537B6F36684962116E358", hash_generated_method = "B287D730E88000F87F502F960F74DD0B")
    
private void sendSpanRemoved(Object what, int start, int end) {
        SpanWatcher[] recip = getSpans(start, end, SpanWatcher.class);
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].onSpanRemoved(this, what, start, end);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.877 -0500", hash_original_method = "89C4871AB16E570ACF45A07B8EFEFB25", hash_generated_method = "F8CD917E2FFAF1F96D44C826A8AC3A0B")
    
private void sendSpanChanged(Object what, int s, int e, int st, int en) {
        SpanWatcher[] recip = getSpans(Math.min(s, st), Math.max(e, en), SpanWatcher.class);
        int n = recip.length;

        for (int i = 0; i < n; i++) {
            recip[i].onSpanChanged(this, what, s, e, st, en);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.883 -0500", hash_original_method = "70C480F1BBBBF461E174788F8B29326C", hash_generated_method = "A599E02D51122E6540797E709E0B7A7A")
    
private void checkRange(final String operation, int start, int end) {
        if (end < start) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " has end before start");
        }

        int len = length();

        if (start > len || end > len) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " ends beyond length " + len);
        }

        if (start < 0 || end < 0) {
            throw new IndexOutOfBoundsException(operation + " " +
                                                region(start, end) +
                                                " starts before 0");
        }
    }
    
    @Override
	public void drawText(Canvas c, int start, int end, float x, float y, Paint p) {
		// TODO Auto-generated method stub
	}
    
    @Override
	public void drawTextRun(Canvas c, int start, int end, int contextStart,
			int contextEnd, float x, float y, int flags, Paint p) {
		// TODO Auto-generated method stub
	}
    
    @Override
	public float measureText(int start, int end, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public int getTextWidths(int start, int end, float[] widths, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * Don't call this yourself -- exists for Paint to use internally.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.898 -0500", hash_original_method = "FE2235DDEA2C6A2285ED2D1196CDD9B2", hash_generated_method = "4E70B087F887AB1B09F50C3199F56F78")
    
public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p) {

        float ret;

        int contextLen = contextEnd - contextStart;
        int len = end - start;

        if (end <= mGapStart) {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos);
        } else if (start >= mGapStart) {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos);
        } else {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos);
            TextUtils.recycle(buf);
        }

        return ret;
    }

    /**
     * Don't call this yourself -- exists for Paint to use internally.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.901 -0500", hash_original_method = "C231D32FAB37A7BF2DFD000F849A602C", hash_generated_method = "FA844BE046CE27D6A5F085CBB05D4797")
    
public float getTextRunAdvances(int start, int end, int contextStart, int contextEnd, int flags,
            float[] advances, int advancesPos, Paint p, int reserved) {

        float ret;

        int contextLen = contextEnd - contextStart;
        int len = end - start;

        if (end <= mGapStart) {
            ret = p.getTextRunAdvances(mText, start, len, contextStart, contextLen,
                    flags, advances, advancesPos, reserved);
        } else if (start >= mGapStart) {
            ret = p.getTextRunAdvances(mText, start + mGapLength, len,
                    contextStart + mGapLength, contextLen, flags, advances, advancesPos, reserved);
        } else {
            char[] buf = TextUtils.obtain(contextLen);
            getChars(contextStart, contextEnd, buf, 0);
            ret = p.getTextRunAdvances(buf, start - contextStart, len,
                    0, contextLen, flags, advances, advancesPos, reserved);
            TextUtils.recycle(buf);
        }

        return ret;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public int getTextRunCursor(int contextStart, int contextEnd, int flags,
			int offset, int cursorOpt, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    @Override
	public void setFilters(InputFilter[] filters) {
		// TODO Auto-generated method stub
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public InputFilter[] getFilters() {
		// TODO Auto-generated method stub
		return null;
	}
    
}

