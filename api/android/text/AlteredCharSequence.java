package android.text;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AlteredCharSequence implements CharSequence, GetChars {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.092 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private int mStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.092 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private int mEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.093 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

    private char[] mChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.093 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "1DB65A9625E780B230F7C604C99C0F5D")

    private CharSequence mSource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.098 -0400", hash_original_method = "C1A67ADB666FBDE0BE16EFE2B57C9F5A", hash_generated_method = "772558D4FCF2A5CC3D1DCF0D754887B9")
    private  AlteredCharSequence(CharSequence source, char[] sub,
                                int substart, int subend) {
        mSource = source;
        mChars = sub;
        mStart = substart;
        mEnd = subend;
        // ---------- Original Method ----------
        //mSource = source;
        //mChars = sub;
        //mStart = substart;
        //mEnd = subend;
    }

    
    public static AlteredCharSequence make(CharSequence source, char[] sub,
                                           int substart, int subend) {
        if (source instanceof Spanned)
            return new AlteredSpanned(source, sub, substart, subend);
        else
            return new AlteredCharSequence(source, sub, substart, subend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.101 -0400", hash_original_method = "1FC7902EB789E6071EA22FDF8DF92DE5", hash_generated_method = "8F564F5AB76E6F44792A84BB97983956")
     void update(char[] sub, int substart, int subend) {
        mChars = sub;
        mStart = substart;
        mEnd = subend;
        // ---------- Original Method ----------
        //mChars = sub;
        //mStart = substart;
        //mEnd = subend;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.101 -0400", hash_original_method = "37BE7FFEC25E3F757ADB66C6F1A52CBB", hash_generated_method = "468CB51C478E3511B0DFB31BB7C61A88")
    public char charAt(int off) {
        addTaint(off);
        if(off >= mStart && off < mEnd)        
        {
        char varEF8112581A7A1F0CE1D72F4A539CE854_433525513 = (mChars[off - mStart]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_134875718 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_134875718;
        }
        else
        {
        char var4EBB8FD034736019976C027CA1B468FE_604558486 = (mSource.charAt(off));
                char varA87DEB01C5F539E6BDA34829C8EF2368_935762634 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_935762634;
        }
        // ---------- Original Method ----------
        //if (off >= mStart && off < mEnd)
            //return mChars[off - mStart];
        //else
            //return mSource.charAt(off);
    }

    
    @Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.103 -0400", hash_original_method = "8E527DE4EB6C1554A95561AAE7972C80", hash_generated_method = "76D503BAEDD375632A3AC202BA38F25C")
    public void getChars(int start, int end, char[] dest, int off) {
        addTaint(off);
        addTaint(dest[0]);
        addTaint(end);
        addTaint(start);
        TextUtils.getChars(mSource, start, end, dest, off);
        start = Math.max(mStart, start);
        end = Math.min(mEnd, end);
        if(start > end)        
        System.arraycopy(mChars, start - mStart, dest, off, end - start);
        // ---------- Original Method ----------
        //TextUtils.getChars(mSource, start, end, dest, off);
        //start = Math.max(mStart, start);
        //end = Math.min(mEnd, end);
        //if (start > end)
            //System.arraycopy(mChars, start - mStart, dest, off, end - start);
    }

    
    @DSModeled(DSC.SAFE)
	public String toString() {
		return new String();
	}

    
    private static class AlteredSpanned extends AlteredCharSequence implements Spanned {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.103 -0400", hash_original_field = "2A174ADD3219E7DC0B72155FF67EC4B5", hash_generated_field = "69C78554F8ABB9B2C492FD314F3ED2EE")

        private Spanned mSpanned;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.104 -0400", hash_original_method = "C72F214965B45129737A1599B1B4D92F", hash_generated_method = "9B01835712124BBD0028A80B1040D3E7")
        private  AlteredSpanned(CharSequence source, char[] sub,
                               int substart, int subend) {
            super(source, sub, substart, subend);
            addTaint(subend);
            addTaint(substart);
            addTaint(sub[0]);
            mSpanned = (Spanned) source;
            // ---------- Original Method ----------
            //mSpanned = (Spanned) source;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.105 -0400", hash_original_method = "7CE849A7A16F0CCCC619619755312E08", hash_generated_method = "59D19B5461E0DACF52E3D1E97120311E")
        public int getSpanStart(Object span) {
            addTaint(span.getTaint());
            int varB892F13BDA9F8E40EE54AB4D2BC1342A_1009882391 = (mSpanned.getSpanStart(span));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034257357 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034257357;
            // ---------- Original Method ----------
            //return mSpanned.getSpanStart(span);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.105 -0400", hash_original_method = "1F1DC02FFE47F69DB6EF73E4FCC39BE3", hash_generated_method = "B2DC2A03B037B37699FFD94A098186EB")
        public int getSpanEnd(Object span) {
            addTaint(span.getTaint());
            int var646A4E6DB5AAD9A7C5A32EB05C02655F_773763321 = (mSpanned.getSpanEnd(span));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602548802 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602548802;
            // ---------- Original Method ----------
            //return mSpanned.getSpanEnd(span);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.106 -0400", hash_original_method = "5D2DFFED867D574BA0228B8E90183DDC", hash_generated_method = "1B9A8B405F398E4C900EEC438564468D")
        public int getSpanFlags(Object span) {
            addTaint(span.getTaint());
            int var66A5FBD4FFFFE92E6EDB1F90E7360CA0_2001558399 = (mSpanned.getSpanFlags(span));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773379817 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773379817;
            // ---------- Original Method ----------
            //return mSpanned.getSpanFlags(span);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.106 -0400", hash_original_method = "7CFB314096BED579DE27CABBD0A10183", hash_generated_method = "10C9B4A5B20FF59E70022EB4309964CD")
        public int nextSpanTransition(int start, int end, Class kind) {
            addTaint(kind.getTaint());
            addTaint(end);
            addTaint(start);
            int varB6D6C35411577EBB1F60BB01F5549FF5_1265078098 = (mSpanned.nextSpanTransition(start, end, kind));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625436997 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625436997;
            // ---------- Original Method ----------
            //return mSpanned.nextSpanTransition(start, end, kind);
        }

        
    }


    
    // orphaned legacy method
    @Override
	public void getChars(int start, int end, char[] dest, int destoff) {
		// TODO Auto-generated method stub

	}
    
    // orphaned legacy method
    @Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}

