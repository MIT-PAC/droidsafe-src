package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "6D0681B9CC29887CCBA4001347A5783B")

    DataSetObservable mDataSetObservable = new DataSetObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "4EE77521C699348F360614CCB598F0DA", hash_generated_field = "6BF9678DA09BCADC073486531F473877")

    ContentObservable mContentObservable = new ContentObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "A883CF36228E5D5BEE104578CFD98D1A", hash_generated_field = "C259FC89DCF7616DD34FCE80BA674482")

    Bundle mExtras = Bundle.EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "FF57DF1F147EFE36452B72FECC7EA001", hash_generated_field = "3262CD6FF716DCC93EF350DE915E82F7")

    @Deprecated protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "8F16E846503942495A4C2CEC2ACC3981", hash_generated_field = "CAA7A11E9EDD8A3053C8B09C2CE51748")

    protected int mRowIdColumnIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.872 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "2D6A6141DF728852DF640B9043726CFE")

    protected int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "A1AA4D3A92944F498D58CCE725E457D2", hash_generated_field = "E8ADE6CE335E3FD73301A59B91CA2D26")

    protected Long mCurrentRowID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "2EC8D863DD9B1C7F06ECE8C6EB85D0AC")

    protected ContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "8DFE2F79489A890EB2125D534844CFA4")

    protected boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "B5B1B3CC4B02696F21C074282A970F7B", hash_generated_field = "03B2ABC109B716AB445FFCE8068B3A63")

    private Uri mNotifyUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "9E8762D4BFD04D3E9CD66C55B4E9A39B", hash_generated_field = "9F5E7AC4133D8487455601C9F96E1A3C")

    private ContentObserver mSelfObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "87455A359B1A9ED854BD5AE788E48D3E", hash_generated_field = "03530B7D8955F293722169CC4394987C")

    final private Object mSelfObserverLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.873 -0400", hash_original_field = "01A6D38D51886A1F7EA04036058C5E65", hash_generated_field = "4ADE0DF6292D7C36DC52F0723F9E0950")

    private boolean mSelfObserverRegistered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.874 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "3B5E09C25C600EDC4F66CDCD37507170")
    public  AbstractCursor() {
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap<Long, Map<String, Object>>();
        
        
        
        
        
    }

    
    abstract public int getCount();

    
    abstract public String[] getColumnNames();

    
    abstract public String getString(int column);

    
    abstract public short getShort(int column);

    
    abstract public int getInt(int column);

    
    abstract public long getLong(int column);

    
    abstract public float getFloat(int column);

    
    abstract public double getDouble(int column);

    
    abstract public boolean isNull(int column);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.876 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "46F960E0D362652E459F551F3A7AD9BA")
    public int getType(int column) {
        addTaint(column);
        int varCD4D37420CABA5D6803D080E13C29447_557903054 = (FIELD_TYPE_STRING);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133961581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133961581;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.877 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "5514DA9601CBF50353664B30557CCF4F")
    public byte[] getBlob(int column) {
        addTaint(column);
        UnsupportedOperationException var09EFD1834B709ADA4AD8035EA41DDFC6_1019867047 = new UnsupportedOperationException("getBlob is not supported");
        var09EFD1834B709ADA4AD8035EA41DDFC6_1019867047.addTaint(taint);
        throw var09EFD1834B709ADA4AD8035EA41DDFC6_1019867047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.877 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "4CB3805856A4BC01D4B949080991E519")
    public CursorWindow getWindow() {
CursorWindow var540C13E9E156B687226421B24F2DF178_991102409 =         null;
        var540C13E9E156B687226421B24F2DF178_991102409.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_991102409;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.877 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "753CF932EFA143C48DF081512CA59546")
    public int getColumnCount() {
        int var6955B3DABD12007579C3EA0FED8494D8_335868400 = (getColumnNames().length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800697181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800697181;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.877 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "17FE726C99E84E75E28F21C8A3D0BF8F")
    public void deactivate() {
        onDeactivateOrClose();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.878 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "74E4CAB50C46EC8E9A050BD6E92262EB")
    protected void onDeactivateOrClose() {
        
    if(mSelfObserver != null)        
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        } 
        mDataSetObservable.notifyInvalidated();
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.878 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "B8991F174FC3B8FE1DE676EC521F72F5")
    public boolean requery() {
    if(mSelfObserver != null && mSelfObserverRegistered == false)        
        {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } 
        mDataSetObservable.notifyChanged();
        boolean varB326B5062B2F0E69046810717534CB09_249537384 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946322508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946322508;
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.879 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "4FABB4FD53D652ADA6C65CE8F0CC0929")
    public boolean isClosed() {
        boolean varC15A1B081B66F38188E926501ED5F8A7_1671730822 = (mClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073592286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073592286;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.879 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "2BF4E0E42FFFCB99FDCE632E9C0D4D96")
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.879 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "260D689E553B68F87451D2687C0B737C")
    public boolean onMove(int oldPosition, int newPosition) {
        
        addTaint(newPosition);
        addTaint(oldPosition);
        boolean varB326B5062B2F0E69046810717534CB09_1080042008 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933847782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933847782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.880 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "267807C38A32BA7662C98257A0E84A5E")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(columnIndex);
        String result = getString(columnIndex);
    if(result != null)        
        {
            char[] data = buffer.data;
    if(data == null || data.length < result.length())            
            {
                buffer.data = result.toCharArray();
            } 
            else
            {
                result.getChars(0, result.length(), data, 0);
            } 
            buffer.sizeCopied = result.length();
        } 
        else
        {
            buffer.sizeCopied = 0;
        } 
        
        
        
            
            
                
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.881 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "8103C5C5265E91ADC5BFA2F6F92E7C88")
    public final int getPosition() {
        int varA8470CE6E0050B0E832FDE52720C7250_1622093623 = (mPos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911288760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911288760;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.882 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "E0903B555F29C0D18B6C4E9104DCDBF1")
    public final boolean moveToPosition(int position) {
        final int count = getCount();
    if(position >= count)        
        {
            mPos = count;
            boolean var68934A3E9455FA72420237EB05902327_550677766 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549951840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549951840;
        } 
    if(position < 0)        
        {
            mPos = -1;
            boolean var68934A3E9455FA72420237EB05902327_41168844 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347223694 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_347223694;
        } 
    if(position == mPos)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_360926110 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598828914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598828914;
        } 
        boolean result = onMove(mPos, position);
    if(result == false)        
        {
            mPos = -1;
        } 
        else
        {
            mPos = position;
    if(mRowIdColumnIndex != -1)            
            {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            } 
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_1904771332 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171235702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171235702;
        
        
        
            
            
        
        
            
            
        
        
            
        
        
        
            
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.883 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "C9AB4782AFFC5741ECE30CB5FBA887AB")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        addTaint(window.getTaint());
        addTaint(position);
        DatabaseUtils.cursorFillWindow(this, position, window);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.883 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "2BA2730130C125249D5F24986FCBB78F")
    public final boolean move(int offset) {
        addTaint(offset);
        boolean var5639527511D2759A163683E3514CD590_770813730 = (moveToPosition(mPos + offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864809606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864809606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.884 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "D22284120275916A45D5067A836F4E04")
    public final boolean moveToFirst() {
        boolean varAEEF8432B85CCEC90B9B26EB4EFF64FA_1173032738 = (moveToPosition(0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394921268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394921268;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.884 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "8565B6A5F852A1ED4F1A483E3A32B394")
    public final boolean moveToLast() {
        boolean var368CE5FA6A853F7DC3CA02823887F219_1796107156 = (moveToPosition(getCount() - 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780737551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780737551;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.885 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "1999924F20D4B35EE0F5B6C91B1D37A3")
    public final boolean moveToNext() {
        boolean var8F4EB11AE5AB0BA8075D29C285AB95F0_256653011 = (moveToPosition(mPos + 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936024765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936024765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.885 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "502187807E0EAFCD515CA836F58998CF")
    public final boolean moveToPrevious() {
        boolean var6FB55EA4982A1F8EA081C2589F5CBD0A_1674179301 = (moveToPosition(mPos - 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318408143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_318408143;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.885 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "5EB705690DC0A5B2941BA5D7C53844C0")
    public final boolean isFirst() {
        boolean var3994D119F7C2C3B6496FDE34F6E9264A_1152719806 = (mPos == 0 && getCount() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882222140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882222140;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.886 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "3D322DC91DA827BE9F8544E0155E27D6")
    public final boolean isLast() {
        int cnt = getCount();
        boolean var1FBF8592AC46CA262B8D99683684E86B_355663988 = (mPos == (cnt - 1) && cnt != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961533447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961533447;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.886 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "FF3965BE51DABC5333156EA1B57E58DD")
    public final boolean isBeforeFirst() {
    if(getCount() == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_716290808 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971225254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_971225254;
        } 
        boolean varB0B6D7E4BBA587B0BDCC1E6D21ADB26E_1903730102 = (mPos == -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920747005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920747005;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.887 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "901CCB172C605BB9EBC5959D54D9AC99")
    public final boolean isAfterLast() {
    if(getCount() == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_679268891 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567058773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567058773;
        } 
        boolean var236F89968F93020AADFB2BDC2D4C314A_2023624410 = (mPos == getCount());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546712476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546712476;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.888 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "22643189A7E6DE878FC6AF1906A20F3A")
    public int getColumnIndex(String columnName) {
        addTaint(columnName.getTaint());
        final int periodIndex = columnName.lastIndexOf('.');
    if(periodIndex != -1)        
        {
            Exception e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } 
        String columnNames[] = getColumnNames();
        int length = columnNames.length;
for(int i = 0;i < length;i++)
        {
    if(columnNames[i].equalsIgnoreCase(columnName))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1943677810 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655796239 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655796239;
            } 
        } 
    if(false)        
        {
    if(getCount() > 0)            
            {
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1318911445 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170698461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170698461;
        
        
        
            
            
            
        
        
        
        
            
                
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.888 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "55A1562370C3A97C72F9A1285CFA9BCA")
    public int getColumnIndexOrThrow(String columnName) {
        addTaint(columnName.getTaint());
        final int index = getColumnIndex(columnName);
    if(index < 0)        
        {
            IllegalArgumentException var7039CB46A0568776CDECCAA797E7DDCC_962490991 = new IllegalArgumentException("column '" + columnName + "' does not exist");
            var7039CB46A0568776CDECCAA797E7DDCC_962490991.addTaint(taint);
            throw var7039CB46A0568776CDECCAA797E7DDCC_962490991;
        } 
        int var6A992D5529F459A44FEE58C733255E86_1272815588 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134372360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134372360;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.889 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "3CD6156778485BEFCA87E14BCA75E1ED")
    public String getColumnName(int columnIndex) {
        addTaint(columnIndex);
String var8C8536068CF525DD3D9E0466509BC4FE_229196354 =         getColumnNames()[columnIndex];
        var8C8536068CF525DD3D9E0466509BC4FE_229196354.addTaint(taint);
        return var8C8536068CF525DD3D9E0466509BC4FE_229196354;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.890 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "2F19079B245FB75FEE69BB0661B190D4")
    public void registerContentObserver(ContentObserver observer) {
        
        addTaint(observer.getTaint());
        mContentObservable.registerObserver(observer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.890 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "76942AB1F52C13F494BA0272FD320EEE")
    public void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
    if(!mClosed)        
        {
            mContentObservable.unregisterObserver(observer);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.891 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "362A8921CADC3161CC20FD83BD5E4602")
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.892 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "0630F40A2FC1B1EC0A30BBC8E3203B9E")
    protected DataSetObservable getDataSetObservable() {
DataSetObservable var1889C2832C6671EE87AE3F20070859ED_1542523885 =         mDataSetObservable;
        var1889C2832C6671EE87AE3F20070859ED_1542523885.addTaint(taint);
        return var1889C2832C6671EE87AE3F20070859ED_1542523885;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.892 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.893 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.893 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "C7BA7FDB3F1829479AB25371BD894C19")
    protected void onChange(boolean selfChange) {
        
        addTaint(selfChange);
        synchronized
(mSelfObserverLock)        {
            mContentObservable.dispatchChange(selfChange);
    if(mNotifyUri != null && selfChange)            
            {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.894 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "72C120B621C25D60AEDC8284D77430A2")
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        synchronized
(mSelfObserverLock)        {
            mNotifyUri = notifyUri;
            mContentResolver = cr;
    if(mSelfObserver != null)            
            {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            } 
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } 
        
        
            
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.895 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "1FEBEB55E6D1A73BE94ED49A1F70CCA5")
    public Uri getNotificationUri() {
Uri var2BA43AFCFCD662CAFF1EE24368377DEE_103648325 =         mNotifyUri;
        var2BA43AFCFCD662CAFF1EE24368377DEE_103648325.addTaint(taint);
        return var2BA43AFCFCD662CAFF1EE24368377DEE_103648325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.895 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "DE2CEC75338893B2540B56AA81506222")
    public boolean getWantsAllOnMoveCalls() {
        boolean var68934A3E9455FA72420237EB05902327_95922441 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148536523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148536523;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.896 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "598746C945848452E29BDC82DB3737FA")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.896 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "E72B3B2F0F4B75DD3132306F3F638C0C")
    public Bundle getExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_882016659 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_882016659.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_882016659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.897 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "164E90232EE8B9B8A4EDE31F857B7841")
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
Bundle var998437625BBF03281B97467174D26383_724232825 =         Bundle.EMPTY;
        var998437625BBF03281B97467174D26383_724232825.addTaint(taint);
        return var998437625BBF03281B97467174D26383_724232825;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.897 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "DEC1E9146101EFED54746354CEE62C22")
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        addTaint(columnIndex);
        boolean var68934A3E9455FA72420237EB05902327_1243562593 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772558570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772558570;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.898 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "2E4ABAF8025F9AF7E45526A11D15585F")
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        addTaint(columnIndex);
Object var540C13E9E156B687226421B24F2DF178_541370056 =         null;
        var540C13E9E156B687226421B24F2DF178_541370056.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_541370056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.898 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "CF799F38DA55E9F0EE3282F3C6A33223")
    protected void checkPosition() {
    if(-1 == mPos || getCount() == mPos)        
        {
            CursorIndexOutOfBoundsException var9505B20468EA036B4AD8C6EC0D2E4CFE_853191688 = new CursorIndexOutOfBoundsException(mPos, getCount());
            var9505B20468EA036B4AD8C6EC0D2E4CFE_853191688.addTaint(taint);
            throw var9505B20468EA036B4AD8C6EC0D2E4CFE_853191688;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.899 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "3CAA66883E12BA7CD7932F65BFCD8226")
    @Override
    protected void finalize() {
    if(mSelfObserver != null && mSelfObserverRegistered == true)        
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        } 
        
        
            
        
    }

    
    protected static class SelfContentObserver extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.899 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "703A671C4ACC07BD23149F0A5FD18BB7")

        WeakReference<AbstractCursor> mCursor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.900 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "1C8FE0B53CDA67BB2D5E07BFD3F83569")
        public  SelfContentObserver(AbstractCursor cursor) {
            super(null);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.900 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "2FF7200D8D693D8F75AA015BBD870EAB")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var68934A3E9455FA72420237EB05902327_1032718065 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418666863 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418666863;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.900 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "2A497B7AE559C826E71E1842C4EE3B27")
        @Override
        public void onChange(boolean selfChange) {
            
            addTaint(selfChange);
            AbstractCursor cursor = mCursor.get();
    if(cursor != null)            
            {
                cursor.onChange(false);
            } 
            
            
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.901 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
}

