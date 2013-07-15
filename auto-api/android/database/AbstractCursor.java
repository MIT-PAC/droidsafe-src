package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "6D0681B9CC29887CCBA4001347A5783B")

    DataSetObservable mDataSetObservable = new DataSetObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "4EE77521C699348F360614CCB598F0DA", hash_generated_field = "6BF9678DA09BCADC073486531F473877")

    ContentObservable mContentObservable = new ContentObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "A883CF36228E5D5BEE104578CFD98D1A", hash_generated_field = "C259FC89DCF7616DD34FCE80BA674482")

    Bundle mExtras = Bundle.EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "FF57DF1F147EFE36452B72FECC7EA001", hash_generated_field = "3262CD6FF716DCC93EF350DE915E82F7")

    @Deprecated protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "8F16E846503942495A4C2CEC2ACC3981", hash_generated_field = "CAA7A11E9EDD8A3053C8B09C2CE51748")

    protected int mRowIdColumnIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "2D6A6141DF728852DF640B9043726CFE")

    protected int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "A1AA4D3A92944F498D58CCE725E457D2", hash_generated_field = "E8ADE6CE335E3FD73301A59B91CA2D26")

    protected Long mCurrentRowID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "2EC8D863DD9B1C7F06ECE8C6EB85D0AC")

    protected ContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "8DFE2F79489A890EB2125D534844CFA4")

    protected boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "B5B1B3CC4B02696F21C074282A970F7B", hash_generated_field = "03B2ABC109B716AB445FFCE8068B3A63")

    private Uri mNotifyUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.520 -0400", hash_original_field = "9E8762D4BFD04D3E9CD66C55B4E9A39B", hash_generated_field = "9F5E7AC4133D8487455601C9F96E1A3C")

    private ContentObserver mSelfObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.521 -0400", hash_original_field = "87455A359B1A9ED854BD5AE788E48D3E", hash_generated_field = "03530B7D8955F293722169CC4394987C")

    final private Object mSelfObserverLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.521 -0400", hash_original_field = "01A6D38D51886A1F7EA04036058C5E65", hash_generated_field = "4ADE0DF6292D7C36DC52F0723F9E0950")

    private boolean mSelfObserverRegistered;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.521 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "3B5E09C25C600EDC4F66CDCD37507170")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.524 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "2CB3C810892890834251F3CC8D72BF22")
    public int getType(int column) {
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461143234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461143234;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.524 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "ACCD7EF624436EB59A39189DD02A2281")
    public byte[] getBlob(int column) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("getBlob is not supported");
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_988034211 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_988034211;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.525 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "0029F0F0E1123928D21EAF9DDC845DF3")
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_2144457490 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2144457490 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2144457490.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2144457490;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.525 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "A4AE50FCF2902150AF2CED1E30D6E94B")
    public int getColumnCount() {
        int varE598DA0DE038A65D9C059A044E9E4C36_335498766 = (getColumnNames().length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548575106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548575106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.526 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "17FE726C99E84E75E28F21C8A3D0BF8F")
    public void deactivate() {
        onDeactivateOrClose();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.526 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "1A88E5AE7EDDB03D758D160469F2BE50")
    protected void onDeactivateOrClose() {
        
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        } 
        mDataSetObservable.notifyInvalidated();
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.526 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "E7CDC3E741E20E7FF78A160C2AA9FF7A")
    public boolean requery() {
        {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } 
        mDataSetObservable.notifyChanged();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246784834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246784834;
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.527 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "CD4327318B9B9216F6971BCD64798A9B")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194471006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194471006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.527 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "2BF4E0E42FFFCB99FDCE632E9C0D4D96")
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.528 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "540E7B9EE06F399D3ABDB057B294BCBB")
    public boolean onMove(int oldPosition, int newPosition) {
        
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562385171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562385171;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.528 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "3E9A472639D9F9D9A1BB57E9327CCE2C")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        String result = getString(columnIndex);
        {
            char[] data = buffer.data;
            {
                boolean varB3C493CCA0A5FEEBFBA4E5B6E1AC0832_308335083 = (data == null || data.length < result.length());
                {
                    buffer.data = result.toCharArray();
                } 
                {
                    result.getChars(0, result.length(), data, 0);
                } 
            } 
            buffer.sizeCopied = result.length();
        } 
        {
            buffer.sizeCopied = 0;
        } 
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        
        
        
            
            
                
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.528 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "B69101A25C043194A0A821A53FF0529E")
    public final int getPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067460837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067460837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.529 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "747C1075C28B75FDFB367000881A7AAB")
    public final boolean moveToPosition(int position) {
        final int count = getCount();
        {
            mPos = count;
        } 
        {
            mPos = -1;
        } 
        boolean result = onMove(mPos, position);
        {
            mPos = -1;
        } 
        {
            mPos = position;
            {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437541915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437541915;
        
        
        
            
            
        
        
            
            
        
        
            
        
        
        
            
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.529 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "F3F1A8E4F0039670932F69218A3019CF")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        DatabaseUtils.cursorFillWindow(this, position, window);
        addTaint(position);
        addTaint(window.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.530 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "16E0207275AB38B4C8595C7C68551447")
    public final boolean move(int offset) {
        boolean varA63C7CEC1F816BE1838C38173C94CB20_587774835 = (moveToPosition(mPos + offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626499277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_626499277;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.530 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "32BCE58F35F40E86C7CF97090262EAC4")
    public final boolean moveToFirst() {
        boolean var7169217BA523AE68C1F7B0C7563B6D2F_232431613 = (moveToPosition(0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382688873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382688873;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.530 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "C94C981C2C3E9F6463CF715186BF3A37")
    public final boolean moveToLast() {
        boolean var883322E63C74EFF5BA3E9BBFA1EB0817_1933743639 = (moveToPosition(getCount() - 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558467374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558467374;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.531 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "776DDA65F5CBB96601A3050A1F729560")
    public final boolean moveToNext() {
        boolean var6557A178A7D0E5B123127618582893AA_1131403106 = (moveToPosition(mPos + 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244859947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244859947;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.531 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "7BD5274E07C484D7DBEDD2ABC61571C1")
    public final boolean moveToPrevious() {
        boolean var62DFA72D2B670D9088C02CC6B3B7A7B4_819719835 = (moveToPosition(mPos - 1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670696892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_670696892;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.531 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "5274A6851198DD2A280EB90E59820904")
    public final boolean isFirst() {
        boolean varADB2B3DA6A35A98BE1B5E66B40FE6B61_1947428708 = (mPos == 0 && getCount() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939890895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939890895;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.532 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "2563CD00373A035A3E450B38C0AA8926")
    public final boolean isLast() {
        int cnt = getCount();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764831979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764831979;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.532 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "C32955F8AB80D059FC40E5CB972A96F4")
    public final boolean isBeforeFirst() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_1607916210 = (getCount() == 0);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_14207149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_14207149;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.532 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "45944C7EA7823B14D72A67D3D8C612CD")
    public final boolean isAfterLast() {
        {
            boolean var1E308F1B2924DF35832B0C6653D5399D_23749991 = (getCount() == 0);
        } 
        boolean var0FABA7953C222ACDE339B5487276FBD9_1212909233 = (mPos == getCount());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324209790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324209790;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.534 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "B69FE47005E2E09DA63FB6D579713FC3")
    public int getColumnIndex(String columnName) {
        final int periodIndex = columnName.lastIndexOf('.');
        {
            Exception e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } 
        String columnNames[] = getColumnNames();
        int length = columnNames.length;
        {
            int i = 0;
            {
                {
                    boolean var8A92D03C059C3C4A74106A947683F96E_1454553795 = (columnNames[i].equalsIgnoreCase(columnName));
                } 
            } 
        } 
        {
            {
                boolean varFC53D64D8090E12EDE66C4B1525878D8_1131452274 = (getCount() > 0);
            } 
        } 
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1860836977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1860836977;
        
        
        
            
            
            
        
        
        
        
            
                
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.534 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "AE3A9EBDB7403320CFD7A9B20F6EDD02")
    public int getColumnIndexOrThrow(String columnName) {
        final int index = getColumnIndex(columnName);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        } 
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491753246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491753246;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.536 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "E8DE333B065FB2BEC6E522662398DC1F")
    public String getColumnName(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1349733038 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1349733038 = getColumnNames()[columnIndex];
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1349733038.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1349733038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.537 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "AEFA561A03BB5A433531253EF2321E96")
    public void registerContentObserver(ContentObserver observer) {
        
        mContentObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.537 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "81BB786F388406F395DE8392F002749E")
    public void unregisterContentObserver(ContentObserver observer) {
        {
            mContentObservable.unregisterObserver(observer);
        } 
        addTaint(observer.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.538 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "362A8921CADC3161CC20FD83BD5E4602")
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.539 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "7FA1F01B6B8C82295C0802EA56CC00F7")
    protected DataSetObservable getDataSetObservable() {
        DataSetObservable varB4EAC82CA7396A68D541C85D26508E83_1069310559 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1069310559 = mDataSetObservable;
        varB4EAC82CA7396A68D541C85D26508E83_1069310559.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1069310559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.539 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.539 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.540 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "C9F66A0A4C719B0A7060BD7592750D7C")
    protected void onChange(boolean selfChange) {
        
        {
            mContentObservable.dispatchChange(selfChange);
            {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            } 
        } 
        addTaint(selfChange);
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.540 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "E3AB4642C1A122863411A22FBA701D35")
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        {
            mNotifyUri = notifyUri;
            mContentResolver = cr;
            {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            } 
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } 
        
        
            
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.541 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "CA0058844C2468EAFED73F3EBCC11E94")
    public Uri getNotificationUri() {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1181710834 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1181710834 = mNotifyUri;
        varB4EAC82CA7396A68D541C85D26508E83_1181710834.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1181710834;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.542 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "C9C9D89B2483FEA67800DDB570D20673")
    public boolean getWantsAllOnMoveCalls() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287267999 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287267999;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.542 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "598746C945848452E29BDC82DB3737FA")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.543 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "859F1D4A65D1757E58CBAD4911110C77")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1118957285 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1118957285 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_1118957285.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1118957285;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.544 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "738D94E5FA67E7280E53B5131DF36FDD")
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_591538936 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_591538936 = Bundle.EMPTY;
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_591538936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_591538936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.544 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "F4FFD4FE1B38D038D318BBDDC648D34B")
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2122364848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2122364848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.546 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "588AD344A56845C38727697D6B56F797")
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2090095006 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2090095006 = null;
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_2090095006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2090095006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.547 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "C53E38A1C3EB6F46ED9BB660901CA248")
    protected void checkPosition() {
        {
            boolean var63B4E4AC12944E47003AF0905D5ED5FF_1386939175 = (-1 == mPos || getCount() == mPos);
            {
                if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException(mPos, getCount());
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.547 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "527FAC0CAA846B70BB6AE3177A20EE40")
    @Override
    protected void finalize() {
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        } 
        
        
            
        
    }

    
    protected static class SelfContentObserver extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.547 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "703A671C4ACC07BD23149F0A5FD18BB7")

        WeakReference<AbstractCursor> mCursor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.548 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "1C8FE0B53CDA67BB2D5E07BFD3F83569")
        public  SelfContentObserver(AbstractCursor cursor) {
            super(null);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.548 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "D17A3F2E88211FB5CD9B9134EDD68432")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836105500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836105500;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.548 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "94FD59BEE507E9F39D5C73388FF51137")
        @Override
        public void onChange(boolean selfChange) {
            
            AbstractCursor cursor = mCursor.get();
            {
                cursor.onChange(false);
            } 
            addTaint(selfChange);
            
            
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.549 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
}

