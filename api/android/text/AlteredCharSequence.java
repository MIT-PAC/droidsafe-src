package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AlteredCharSequence implements CharSequence, GetChars {
    /**
     * Create an AlteredCharSequence whose text (and possibly spans)
     * are mirrored from <code>source</code>, except that the range of
     * offsets <code>substart</code> inclusive to <code>subend</code> exclusive
     * are mirrored instead from <code>sub</code>, beginning at offset 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.840 -0500", hash_original_method = "4C9F904F92E3B879A03EABDC82FBCB21", hash_generated_method = "4C7948DBDD2398F11C16F716F301458A")
    
public static AlteredCharSequence make(CharSequence source, char[] sub,
                                           int substart, int subend) {
        if (source instanceof Spanned)
            return new AlteredSpanned(source, sub, substart, subend);
        else
            return new AlteredCharSequence(source, sub, substart, subend);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.906 -0500", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")


    private int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.911 -0500", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.915 -0500", hash_original_field = "221D78AA948575C2C408290E651B0D1C", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.920 -0500", hash_original_field = "EBB181D64752DA6F9BB9A9E1DB00BBD4", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

    private CharSequence mSource;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.845 -0500", hash_original_method = "C1A67ADB666FBDE0BE16EFE2B57C9F5A", hash_generated_method = "1DCF11D364EB377957847AE0208B2BE6")
    
private AlteredCharSequence(CharSequence source, char[] sub,
                                int substart, int subend) {
        mSource = source;
        mChars = sub;
        mStart = substart;
        mEnd = subend;
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.848 -0500", hash_original_method = "1FC7902EB789E6071EA22FDF8DF92DE5", hash_generated_method = "1FC7902EB789E6071EA22FDF8DF92DE5")
    
void update(char[] sub, int substart, int subend) {
        mChars = sub;
        mStart = substart;
        mEnd = subend;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.883 -0500", hash_original_method = "37BE7FFEC25E3F757ADB66C6F1A52CBB", hash_generated_method = "190A26A16D5CCDA3DA923FB44382D646")
    
public char charAt(int off) {
        if (off >= mStart && off < mEnd)
            return mChars[off - mStart];
        else
            return mSource.charAt(off);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.897 -0500", hash_original_method = "8E527DE4EB6C1554A95561AAE7972C80", hash_generated_method = "88CC0EBD9B4A5464D3519D909E5714E3")
    
public void getChars(int start, int end, char[] dest, int off) {
        TextUtils.getChars(mSource, start, end, dest, off);

        start = Math.max(mStart, start);
        end = Math.min(mEnd, end);

        if (start > end)
            System.arraycopy(mChars, start - mStart, dest, off, end - start);
    }

    
    @DSModeled(DSC.SAFE)
	public String toString() {
		return new String();
	}

    
    private static class AlteredSpanned extends AlteredCharSequence implements Spanned {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.876 -0500", hash_original_field = "4D9A388EBF42337B3D4B4C24F8CD74B1", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")


        private Spanned mSpanned;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.854 -0500", hash_original_method = "C72F214965B45129737A1599B1B4D92F", hash_generated_method = "E4DB70EB53548839B4C3558844CE5BC4")
        
private AlteredSpanned(CharSequence source, char[] sub,
                               int substart, int subend) {
            super(source, sub, substart, subend);
            mSpanned = (Spanned) source;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.104 -0400", hash_original_method = "7BE4975DFF2DB3C2E9D70BFA875C8A2F", hash_generated_method = "7669DB773C32284CA01F520DC1554623")
        public <T> T[] getSpans(int start, int end, Class<T> kind) {
            addTaint(kind.getTaint());
            addTaint(end);
            addTaint(start);
T[] varD00095851380FE9BCE207689FFB0CC5E_1799231042 =             mSpanned.getSpans(start, end, kind);
            varD00095851380FE9BCE207689FFB0CC5E_1799231042.addTaint(taint);
            return varD00095851380FE9BCE207689FFB0CC5E_1799231042;
            // ---------- Original Method ----------
            //return mSpanned.getSpans(start, end, kind);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.861 -0500", hash_original_method = "7CE849A7A16F0CCCC619619755312E08", hash_generated_method = "CC81E419A32EA448AB0E904496EDD572")
        
public int getSpanStart(Object span) {
            return mSpanned.getSpanStart(span);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.866 -0500", hash_original_method = "1F1DC02FFE47F69DB6EF73E4FCC39BE3", hash_generated_method = "79A562A6D6BC8C4A9A1D245360A726B6")
        
public int getSpanEnd(Object span) {
            return mSpanned.getSpanEnd(span);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.869 -0500", hash_original_method = "5D2DFFED867D574BA0228B8E90183DDC", hash_generated_method = "0029546E7662640C98BC54270C8A4701")
        
public int getSpanFlags(Object span) {
            return mSpanned.getSpanFlags(span);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.872 -0500", hash_original_method = "7CFB314096BED579DE27CABBD0A10183", hash_generated_method = "627F5A3FE68A2F4B7E1B5F2EF6A06C9E")
        
public int nextSpanTransition(int start, int end, Class kind) {
            return mSpanned.nextSpanTransition(start, end, kind);
        }

        
    }


    
    
    
}

