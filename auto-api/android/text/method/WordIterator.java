package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import java.text.BreakIterator;
import java.util.Locale;

public class WordIterator implements Selection.PositionIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.669 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "C0B8B41E10B6EC8767D645F51D421276")

    private String mString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.669 -0400", hash_original_field = "AAA1668480E5CC9F624C9ACFAC1E336C", hash_generated_field = "0BBD7CD100EB425800EA2CBA37261EAE")

    private int mOffsetShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.669 -0400", hash_original_field = "D0DDF189DBD48BEB487B547FA441AE98", hash_generated_field = "3FDD48BD1B9B72C0290CDC044056432E")

    private BreakIterator mIterator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.669 -0400", hash_original_method = "AB8CC8AEC36CC88806001A57825CD492", hash_generated_method = "F6A3B701594167B73AD57D2CAA166CCE")
    public  WordIterator() {
        this(Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.669 -0400", hash_original_method = "2A66FD73F959B53947CB4E0B8EDD927F", hash_generated_method = "947127AB01A128D57F4F13C6D40967B8")
    public  WordIterator(Locale locale) {
        mIterator = BreakIterator.getWordInstance(locale);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.670 -0400", hash_original_method = "2DDA1ACFC823FC1E605D540F8F620C39", hash_generated_method = "0A53779B862D2641C4F417C1B91352C6")
    public void setCharSequence(CharSequence charSequence, int start, int end) {
        mOffsetShift = Math.max(0, start - WINDOW_WIDTH);
        final int windowEnd = Math.min(charSequence.length(), end + WINDOW_WIDTH);
        {
            mString = ((SpannableStringBuilder) charSequence).substring(mOffsetShift, windowEnd);
        } 
        {
            mString = charSequence.subSequence(mOffsetShift, windowEnd).toString();
        } 
        mIterator.setText(mString);
        addTaint(end);
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.670 -0400", hash_original_method = "17B38EF0704190E954BC6997CBD1C0A2", hash_generated_method = "8DCB6F1D00E06091EF73721309830954")
    public int preceding(int offset) {
        int shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.preceding(shiftedOffset);
            {
                boolean varA0D6CF585DE1570EA7F3E44E7DD22466_226617059 = (isOnLetterOrDigit(shiftedOffset));
            } 
        } 
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491062134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491062134;
        
        
        
            
            
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.671 -0400", hash_original_method = "DA3F9C05695BD8FAB846E8868344998B", hash_generated_method = "E3EBBFF1B4EFBE5FDE2D6DE9DAC1EB26")
    public int following(int offset) {
        int shiftedOffset = offset - mOffsetShift;
        {
            shiftedOffset = mIterator.following(shiftedOffset);
            {
                boolean var1A6C2F729F39D012AD39EC3D2AA37043_1558808438 = (isAfterLetterOrDigit(shiftedOffset));
            } 
        } 
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27995869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27995869;
        
        
        
            
            
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.671 -0400", hash_original_method = "0D432F790B6324713F4FDAF5BC7F832D", hash_generated_method = "86BC9D615FD65678528E22D78DF93987")
    public int getBeginning(int offset) {
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean var286F63C1A1ACC72F5129580E231B3F19_1618911892 = (isOnLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_1623063771 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_38617935 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } 
                } 
            } 
            {
                {
                    boolean var06ADDEE422599DDFA75CE6C849AE5C97_129538177 = (isAfterLetterOrDigit(shiftedOffset));
                    {
                        int var0A2878D3CBF57DD815ED8A1F32FCD48E_1475803070 = (mIterator.preceding(shiftedOffset) + mOffsetShift);
                    } 
                } 
            } 
        } 
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111796939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111796939;
        
        
        
        
            
                
            
                
            
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.672 -0400", hash_original_method = "BDAE18DC1A45A79C9134EA83087086A0", hash_generated_method = "32F8F357A45D6F5C026790C7DACE6364")
    public int getEnd(int offset) {
        final int shiftedOffset = offset - mOffsetShift;
        checkOffsetIsValid(shiftedOffset);
        {
            boolean varD9CBCC7E3838E9931857B4F04B672176_339129779 = (isAfterLetterOrDigit(shiftedOffset));
            {
                {
                    boolean varB4B4C05081CBE63E902D225AEECF6D8B_1507385513 = (mIterator.isBoundary(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_449594299 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } 
                } 
            } 
            {
                {
                    boolean var5BE6A27E5B96D50DA4647B360B2874CE_871538301 = (isOnLetterOrDigit(shiftedOffset));
                    {
                        int varF4B4DE286A47D4A70E1CFDBAB0A64D1A_1394301044 = (mIterator.following(shiftedOffset) + mOffsetShift);
                    } 
                } 
            } 
        } 
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544765352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544765352;
        
        
        
        
            
                
            
                
            
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.673 -0400", hash_original_method = "60A45BC82DD7A1F2C5F7476F31AEBCCE", hash_generated_method = "204E70ACFD4934E4260D8AD39646CCFB")
    private boolean isAfterLetterOrDigit(int shiftedOffset) {
        {
            boolean varF5393482EF6F317B07B1C94DACFBF909_815308761 = (shiftedOffset >= 1 && shiftedOffset <= mString.length());
            {
                final int codePoint = mString.codePointBefore(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_315981015 = (Character.isLetterOrDigit(codePoint));
                } 
            } 
        } 
        addTaint(shiftedOffset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690810144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690810144;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.673 -0400", hash_original_method = "C811EDD4D225F2A549F13F257AE33EBA", hash_generated_method = "F613642293ADEA9A17A25BA2DAEFD1AA")
    private boolean isOnLetterOrDigit(int shiftedOffset) {
        {
            boolean varC25052DD31B57AC010FD859A0CFC1253_434786400 = (shiftedOffset >= 0 && shiftedOffset < mString.length());
            {
                final int codePoint = mString.codePointAt(shiftedOffset);
                {
                    boolean varD6606A5963F93B6F3C8BBCF888FAF831_1354135472 = (Character.isLetterOrDigit(codePoint));
                } 
            } 
        } 
        addTaint(shiftedOffset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256397069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256397069;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.674 -0400", hash_original_method = "715BE561E387B8F91746DB56405B0D1C", hash_generated_method = "ADCBFAED2A680B3596D23A3C0DD32376")
    private void checkOffsetIsValid(int shiftedOffset) {
        {
            boolean var07121F6B0236069059E5A0DA04661899_922813864 = (shiftedOffset < 0 || shiftedOffset > mString.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid offset: " + (shiftedOffset + mOffsetShift) +
                    ". Valid range is [" + mOffsetShift + ", " + (mString.length() + mOffsetShift) +
                    "]");
            } 
        } 
        addTaint(shiftedOffset);
        
        
            
                    
                    
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.674 -0400", hash_original_field = "BBBC6FD050DCA304328F0C35252C11AD", hash_generated_field = "F5FE4ACCABC3D0B58FEDE31DAF9A3648")

    private static final int WINDOW_WIDTH = 50;
}

