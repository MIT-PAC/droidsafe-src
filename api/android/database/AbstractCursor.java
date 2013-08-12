package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;





public abstract class AbstractCursor implements CrossProcessCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.362 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "6D0681B9CC29887CCBA4001347A5783B")

    DataSetObservable mDataSetObservable = new DataSetObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.362 -0400", hash_original_field = "4EE77521C699348F360614CCB598F0DA", hash_generated_field = "6BF9678DA09BCADC073486531F473877")

    ContentObservable mContentObservable = new ContentObservable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.362 -0400", hash_original_field = "A883CF36228E5D5BEE104578CFD98D1A", hash_generated_field = "C259FC89DCF7616DD34FCE80BA674482")

    Bundle mExtras = Bundle.EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.362 -0400", hash_original_field = "FF57DF1F147EFE36452B72FECC7EA001", hash_generated_field = "3262CD6FF716DCC93EF350DE915E82F7")

    @Deprecated protected HashMap<Long, Map<String, Object>> mUpdatedRows;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "8F16E846503942495A4C2CEC2ACC3981", hash_generated_field = "CAA7A11E9EDD8A3053C8B09C2CE51748")

    protected int mRowIdColumnIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "2D6A6141DF728852DF640B9043726CFE")

    protected int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "A1AA4D3A92944F498D58CCE725E457D2", hash_generated_field = "E8ADE6CE335E3FD73301A59B91CA2D26")

    protected Long mCurrentRowID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "2EC8D863DD9B1C7F06ECE8C6EB85D0AC")

    protected ContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "8DFE2F79489A890EB2125D534844CFA4")

    protected boolean mClosed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "B5B1B3CC4B02696F21C074282A970F7B", hash_generated_field = "03B2ABC109B716AB445FFCE8068B3A63")

    private Uri mNotifyUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "9E8762D4BFD04D3E9CD66C55B4E9A39B", hash_generated_field = "9F5E7AC4133D8487455601C9F96E1A3C")

    private ContentObserver mSelfObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.363 -0400", hash_original_field = "87455A359B1A9ED854BD5AE788E48D3E", hash_generated_field = "03530B7D8955F293722169CC4394987C")

    final private Object mSelfObserverLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.364 -0400", hash_original_field = "01A6D38D51886A1F7EA04036058C5E65", hash_generated_field = "4ADE0DF6292D7C36DC52F0723F9E0950")

    private boolean mSelfObserverRegistered;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.366 -0400", hash_original_method = "F60281D0CC7516E8B7AB1E4DD5850BC4", hash_generated_method = "3B5E09C25C600EDC4F66CDCD37507170")
    public  AbstractCursor() {
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap<Long, Map<String, Object>>();
        // ---------- Original Method ----------
        //mPos = -1;
        //mRowIdColumnIndex = -1;
        //mCurrentRowID = null;
        //mUpdatedRows = new HashMap<Long, Map<String, Object>>();
    }

    
    @DSModeled(DSC.SAFE)
    abstract public int getCount();

    
    @DSModeled(DSC.SAFE)
    abstract public String[] getColumnNames();

    
    @DSModeled(DSC.SAFE)
    abstract public String getString(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public short getShort(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public int getInt(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public long getLong(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public float getFloat(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public double getDouble(int column);

    
    @DSModeled(DSC.SAFE)
    abstract public boolean isNull(int column);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.370 -0400", hash_original_method = "DA5F8C1E79CBE35B90A3C92DA2B8F28D", hash_generated_method = "22BB631B4EB966AF5AC325611E31CBC4")
    public int getType(int column) {
        addTaint(column);
        int varCD4D37420CABA5D6803D080E13C29447_1185224352 = (FIELD_TYPE_STRING);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729282248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729282248;
        // ---------- Original Method ----------
        //return FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.372 -0400", hash_original_method = "5BC3F93BAD50F14F34AFA39612F89CC6", hash_generated_method = "550932354BCA5DE82E273B9A761E90D6")
    public byte[] getBlob(int column) {
        addTaint(column);
        UnsupportedOperationException var09EFD1834B709ADA4AD8035EA41DDFC6_1438734670 = new UnsupportedOperationException("getBlob is not supported");
        var09EFD1834B709ADA4AD8035EA41DDFC6_1438734670.addTaint(taint);
        throw var09EFD1834B709ADA4AD8035EA41DDFC6_1438734670;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("getBlob is not supported");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.372 -0400", hash_original_method = "DD0E28415E6C930BA9DBA04095F3A7EA", hash_generated_method = "54FE8F79FF5B5675DC46AD41C9389095")
    public CursorWindow getWindow() {
CursorWindow var540C13E9E156B687226421B24F2DF178_1566267824 =         null;
        var540C13E9E156B687226421B24F2DF178_1566267824.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1566267824;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.373 -0400", hash_original_method = "97CA757ED7462ACFFD2DF70EB3327BE9", hash_generated_method = "4127976E717C07E54B2B6FC9F7E42D94")
    public int getColumnCount() {
        int var6955B3DABD12007579C3EA0FED8494D8_1207793915 = (getColumnNames().length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104078358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104078358;
        // ---------- Original Method ----------
        //return getColumnNames().length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.373 -0400", hash_original_method = "FE85B15F7B4AB77AD59F907B33A4DE11", hash_generated_method = "17FE726C99E84E75E28F21C8A3D0BF8F")
    public void deactivate() {
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //onDeactivateOrClose();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.374 -0400", hash_original_method = "5696E4CEEE521AD3C05FDA1D1F1B30F5", hash_generated_method = "74E4CAB50C46EC8E9A050BD6E92262EB")
    protected void onDeactivateOrClose() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mSelfObserver != null)        
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        } //End block
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //if (mSelfObserver != null) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
            //mSelfObserverRegistered = false;
        //}
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.374 -0400", hash_original_method = "6C342ADEDDD7EC7E0C1CE765BD80D8D1", hash_generated_method = "B6A2C7A493519036471229B3009C8D8D")
    public boolean requery() {
        if(mSelfObserver != null && mSelfObserverRegistered == false)        
        {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        mDataSetObservable.notifyChanged();
        boolean varB326B5062B2F0E69046810717534CB09_1304457892 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909652109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909652109;
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == false) {
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
        //mDataSetObservable.notifyChanged();
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.375 -0400", hash_original_method = "B825EEA007B34E9E28068D61BE8C7018", hash_generated_method = "E5D66EB5BAA8D0AC55986117277BAB37")
    public boolean isClosed() {
        boolean varC15A1B081B66F38188E926501ED5F8A7_449560937 = (mClosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111771572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111771572;
        // ---------- Original Method ----------
        //return mClosed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.376 -0400", hash_original_method = "75E7685835D22353FA19EABDEF4435E7", hash_generated_method = "2BF4E0E42FFFCB99FDCE632E9C0D4D96")
    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
        // ---------- Original Method ----------
        //mClosed = true;
        //mContentObservable.unregisterAll();
        //onDeactivateOrClose();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.376 -0400", hash_original_method = "316C43B210EB72CE31C6D4E542FB15C5", hash_generated_method = "986E189CE86CC5A7504FF6C30156AF45")
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newPosition);
        addTaint(oldPosition);
        boolean varB326B5062B2F0E69046810717534CB09_1203860468 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283040204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283040204;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.378 -0400", hash_original_method = "8CF2CB9941A08AAA09DBF5869325E31C", hash_generated_method = "267807C38A32BA7662C98257A0E84A5E")
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
            } //End block
            else
            {
                result.getChars(0, result.length(), data, 0);
            } //End block
            buffer.sizeCopied = result.length();
        } //End block
        else
        {
            buffer.sizeCopied = 0;
        } //End block
        // ---------- Original Method ----------
        //String result = getString(columnIndex);
        //if (result != null) {
            //char[] data = buffer.data;
            //if (data == null || data.length < result.length()) {
                //buffer.data = result.toCharArray();
            //} else {
                //result.getChars(0, result.length(), data, 0);
            //}
            //buffer.sizeCopied = result.length();
        //} else {
            //buffer.sizeCopied = 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.379 -0400", hash_original_method = "EC88CAE72DCB37222F19A173793DEE6F", hash_generated_method = "6EFFB8BC8B148D7D8FC438BABD54D4CB")
    public final int getPosition() {
        int varA8470CE6E0050B0E832FDE52720C7250_620811109 = (mPos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057245261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057245261;
        // ---------- Original Method ----------
        //return mPos;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.382 -0400", hash_original_method = "65BBCEF155E9F61984647ADC3CD9D8D5", hash_generated_method = "883799C1E91B44D82D6CC2CD6EFC4ACC")
    public final boolean moveToPosition(int position) {
        final int count = getCount();
        if(position >= count)        
        {
            mPos = count;
            boolean var68934A3E9455FA72420237EB05902327_394492591 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137960284 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137960284;
        } //End block
        if(position < 0)        
        {
            mPos = -1;
            boolean var68934A3E9455FA72420237EB05902327_1462072483 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432828271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432828271;
        } //End block
        if(position == mPos)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_500006044 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016083861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016083861;
        } //End block
        boolean result = onMove(mPos, position);
        if(result == false)        
        {
            mPos = -1;
        } //End block
        else
        {
            mPos = position;
            if(mRowIdColumnIndex != -1)            
            {
                mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1620279377 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997616619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997616619;
        // ---------- Original Method ----------
        //final int count = getCount();
        //if (position >= count) {
            //mPos = count;
            //return false;
        //}
        //if (position < 0) {
            //mPos = -1;
            //return false;
        //}
        //if (position == mPos) {
            //return true;
        //}
        //boolean result = onMove(mPos, position);
        //if (result == false) {
            //mPos = -1;
        //} else {
            //mPos = position;
            //if (mRowIdColumnIndex != -1) {
                //mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.384 -0400", hash_original_method = "6FC66EDC6A2293E690F6FEA8028519D4", hash_generated_method = "C9AB4782AFFC5741ECE30CB5FBA887AB")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        addTaint(window.getTaint());
        addTaint(position);
        DatabaseUtils.cursorFillWindow(this, position, window);
        // ---------- Original Method ----------
        //DatabaseUtils.cursorFillWindow(this, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.384 -0400", hash_original_method = "389B6720AF899474C54E777E5A800C06", hash_generated_method = "BE4D4CC68CF1E1CD8EB625A762866559")
    public final boolean move(int offset) {
        addTaint(offset);
        boolean var5639527511D2759A163683E3514CD590_83167020 = (moveToPosition(mPos + offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740529124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740529124;
        // ---------- Original Method ----------
        //return moveToPosition(mPos + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.385 -0400", hash_original_method = "B3EA5CAC0D9EF5BCE0C71FFF26BBF7DF", hash_generated_method = "F2981833A2E2D41CFD1C55C29C5B7B5E")
    public final boolean moveToFirst() {
        boolean varAEEF8432B85CCEC90B9B26EB4EFF64FA_659045585 = (moveToPosition(0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858847360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858847360;
        // ---------- Original Method ----------
        //return moveToPosition(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.385 -0400", hash_original_method = "A0FD9DA9666B94596708F3F8CB94A387", hash_generated_method = "9963947E6FB48B1ED0F3B57BC9E382E6")
    public final boolean moveToLast() {
        boolean var368CE5FA6A853F7DC3CA02823887F219_1562958778 = (moveToPosition(getCount() - 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514467703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514467703;
        // ---------- Original Method ----------
        //return moveToPosition(getCount() - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.386 -0400", hash_original_method = "44D940C3A0E42253110DBD8C1211FDCC", hash_generated_method = "1FFA683BC08E4BEAB2484088DD672BEA")
    public final boolean moveToNext() {
        boolean var8F4EB11AE5AB0BA8075D29C285AB95F0_1969702927 = (moveToPosition(mPos + 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910341660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910341660;
        // ---------- Original Method ----------
        //return moveToPosition(mPos + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.387 -0400", hash_original_method = "70B7D1CBA52F6D8A8ABC528A78C51C39", hash_generated_method = "3191C3C0D738A06F10CD3975ABAB1BD2")
    public final boolean moveToPrevious() {
        boolean var6FB55EA4982A1F8EA081C2589F5CBD0A_2022888414 = (moveToPosition(mPos - 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959354719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959354719;
        // ---------- Original Method ----------
        //return moveToPosition(mPos - 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.387 -0400", hash_original_method = "9906FDA9BB1856CC0A1F7D5381F7AEF7", hash_generated_method = "5BFBEF5A2B918373C6586DB11CB7C6EB")
    public final boolean isFirst() {
        boolean var3994D119F7C2C3B6496FDE34F6E9264A_262151052 = (mPos == 0 && getCount() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951595997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951595997;
        // ---------- Original Method ----------
        //return mPos == 0 && getCount() != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.388 -0400", hash_original_method = "5D098944D57453F70DEC79DF938E50E8", hash_generated_method = "388412F80B707C1F5B368BF1D3BA479B")
    public final boolean isLast() {
        int cnt = getCount();
        boolean var1FBF8592AC46CA262B8D99683684E86B_270071044 = (mPos == (cnt - 1) && cnt != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_234286412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_234286412;
        // ---------- Original Method ----------
        //int cnt = getCount();
        //return mPos == (cnt - 1) && cnt != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.388 -0400", hash_original_method = "BEAF42FFABF4F6277016BED9CE1900CE", hash_generated_method = "30E0D24AB121C5A81A2475E3989A2597")
    public final boolean isBeforeFirst() {
        if(getCount() == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1495117545 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339196065 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339196065;
        } //End block
        boolean varB0B6D7E4BBA587B0BDCC1E6D21ADB26E_433398678 = (mPos == -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536534128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536534128;
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.389 -0400", hash_original_method = "EBC209D2038AD2122CD62927CB78B2F3", hash_generated_method = "2649A0E29188AEED76A35729F8EC4826")
    public final boolean isAfterLast() {
        if(getCount() == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1012127512 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483716560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_483716560;
        } //End block
        boolean var236F89968F93020AADFB2BDC2D4C314A_2057991602 = (mPos == getCount());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452280635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452280635;
        // ---------- Original Method ----------
        //if (getCount() == 0) {
            //return true;
        //}
        //return mPos == getCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.390 -0400", hash_original_method = "1BC2DDCF2F027B280B5593E829676223", hash_generated_method = "AF8EE748E0B3DA0E125D7DA51DC514C2")
    public int getColumnIndex(String columnName) {
        addTaint(columnName.getTaint());
        final int periodIndex = columnName.lastIndexOf('.');
        if(periodIndex != -1)        
        {
            Exception e = new Exception();
            columnName = columnName.substring(periodIndex + 1);
        } //End block
        String columnNames[] = getColumnNames();
        int length = columnNames.length;
for(int i = 0;i < length;i++)
        {
            if(columnNames[i].equalsIgnoreCase(columnName))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1340901202 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799956266 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799956266;
            } //End block
        } //End block
        if(false)        
        {
            if(getCount() > 0)            
            {
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1697672956 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295270213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295270213;
        // ---------- Original Method ----------
        //final int periodIndex = columnName.lastIndexOf('.');
        //if (periodIndex != -1) {
            //Exception e = new Exception();
            //Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            //columnName = columnName.substring(periodIndex + 1);
        //}
        //String columnNames[] = getColumnNames();
        //int length = columnNames.length;
        //for (int i = 0; i < length; i++) {
            //if (columnNames[i].equalsIgnoreCase(columnName)) {
                //return i;
            //}
        //}
        //if (false) {
            //if (getCount() > 0) {
                //Log.w("AbstractCursor", "Unknown column " + columnName);
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.391 -0400", hash_original_method = "7BAA81DCDF7699C82AB2A31918E9C0C1", hash_generated_method = "A5F76447CB0C901033352D48111F2CC4")
    public int getColumnIndexOrThrow(String columnName) {
        addTaint(columnName.getTaint());
        final int index = getColumnIndex(columnName);
        if(index < 0)        
        {
            IllegalArgumentException var7039CB46A0568776CDECCAA797E7DDCC_322986267 = new IllegalArgumentException("column '" + columnName + "' does not exist");
            var7039CB46A0568776CDECCAA797E7DDCC_322986267.addTaint(taint);
            throw var7039CB46A0568776CDECCAA797E7DDCC_322986267;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_1789122991 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723874710 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723874710;
        // ---------- Original Method ----------
        //final int index = getColumnIndex(columnName);
        //if (index < 0) {
            //throw new IllegalArgumentException("column '" + columnName + "' does not exist");
        //}
        //return index;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.392 -0400", hash_original_method = "2C8B9F57D7BABEC67595057D4A416343", hash_generated_method = "3B102FEFFD4FA34021378BC65CEF4B46")
    public String getColumnName(int columnIndex) {
        addTaint(columnIndex);
String var8C8536068CF525DD3D9E0466509BC4FE_1398613511 =         getColumnNames()[columnIndex];
        var8C8536068CF525DD3D9E0466509BC4FE_1398613511.addTaint(taint);
        return var8C8536068CF525DD3D9E0466509BC4FE_1398613511;
        // ---------- Original Method ----------
        //return getColumnNames()[columnIndex];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.392 -0400", hash_original_method = "969C8D7FAD299958455EEA8274658457", hash_generated_method = "2F19079B245FB75FEE69BB0661B190D4")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mContentObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mContentObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.393 -0400", hash_original_method = "0986E51B80B8DF6AE5336EB6410DC9C5", hash_generated_method = "76942AB1F52C13F494BA0272FD320EEE")
    public void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
        if(!mClosed)        
        {
            mContentObservable.unregisterObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (!mClosed) {
            //mContentObservable.unregisterObserver(observer);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.393 -0400", hash_original_method = "C09BE1AB0F1EB5BF63EC2A314B1EC0E8", hash_generated_method = "362A8921CADC3161CC20FD83BD5E4602")
    protected void notifyDataSetChange() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.394 -0400", hash_original_method = "9CE71984FA039D61518575C1361CCA79", hash_generated_method = "B19699EA932930F5D24E429E21429FF5")
    protected DataSetObservable getDataSetObservable() {
DataSetObservable var1889C2832C6671EE87AE3F20070859ED_1280497981 =         mDataSetObservable;
        var1889C2832C6671EE87AE3F20070859ED_1280497981.addTaint(taint);
        return var1889C2832C6671EE87AE3F20070859ED_1280497981;
        // ---------- Original Method ----------
        //return mDataSetObservable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.394 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.396 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.397 -0400", hash_original_method = "46E00F9025A0D5563AEDF0BD12648840", hash_generated_method = "C7BA7FDB3F1829479AB25371BD894C19")
    protected void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(selfChange);
        synchronized
(mSelfObserverLock)        {
            mContentObservable.dispatchChange(selfChange);
            if(mNotifyUri != null && selfChange)            
            {
                mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mContentObservable.dispatchChange(selfChange);
            //if (mNotifyUri != null && selfChange) {
                //mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
            //}
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.398 -0400", hash_original_method = "265F32C67EE2A711D5C4BAD496137660", hash_generated_method = "72C120B621C25D60AEDC8284D77430A2")
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        synchronized
(mSelfObserverLock)        {
            mNotifyUri = notifyUri;
            mContentResolver = cr;
            if(mSelfObserver != null)            
            {
                mContentResolver.unregisterContentObserver(mSelfObserver);
            } //End block
            mSelfObserver = new SelfContentObserver(this);
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSelfObserverLock) {
            //mNotifyUri = notifyUri;
            //mContentResolver = cr;
            //if (mSelfObserver != null) {
                //mContentResolver.unregisterContentObserver(mSelfObserver);
            //}
            //mSelfObserver = new SelfContentObserver(this);
            //mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            //mSelfObserverRegistered = true;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.399 -0400", hash_original_method = "DDB9421669E815EA51C0F68469B23471", hash_generated_method = "26E2B2E43A85BE11E8C50645619E010A")
    public Uri getNotificationUri() {
Uri var2BA43AFCFCD662CAFF1EE24368377DEE_1842729680 =         mNotifyUri;
        var2BA43AFCFCD662CAFF1EE24368377DEE_1842729680.addTaint(taint);
        return var2BA43AFCFCD662CAFF1EE24368377DEE_1842729680;
        // ---------- Original Method ----------
        //return mNotifyUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.399 -0400", hash_original_method = "95EB5F956072F4428350A5713DB4F16C", hash_generated_method = "E5832CBB49DDBE5FFE136B87D4179CB6")
    public boolean getWantsAllOnMoveCalls() {
        boolean var68934A3E9455FA72420237EB05902327_794146025 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88961933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88961933;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.400 -0400", hash_original_method = "FFD927D835EC033CA0D5789154520D3B", hash_generated_method = "598746C945848452E29BDC82DB3737FA")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? Bundle.EMPTY : extras;
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? Bundle.EMPTY : extras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.400 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "7B9F8E1E1F232FC2B6650C4200648FCB")
    public Bundle getExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_2079816450 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_2079816450.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_2079816450;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.401 -0400", hash_original_method = "0DCA3EA5579BB07DA7E61D916C230104", hash_generated_method = "2AB742C784AAE2DB4B645EB5283A2E97")
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
Bundle var998437625BBF03281B97467174D26383_82310328 =         Bundle.EMPTY;
        var998437625BBF03281B97467174D26383_82310328.addTaint(taint);
        return var998437625BBF03281B97467174D26383_82310328;
        // ---------- Original Method ----------
        //return Bundle.EMPTY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.401 -0400", hash_original_method = "038210FB7F6D7350A83F25D9DA43B6B8", hash_generated_method = "070DFB159F379D798E1C44CFA9C7571F")
    @Deprecated
    protected boolean isFieldUpdated(int columnIndex) {
        addTaint(columnIndex);
        boolean var68934A3E9455FA72420237EB05902327_986664853 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265251946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265251946;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.401 -0400", hash_original_method = "C12342D6451FF7A0A51B2EFC9932FDFD", hash_generated_method = "8797107698FD70949C8550DC54CFFD09")
    @Deprecated
    protected Object getUpdatedField(int columnIndex) {
        addTaint(columnIndex);
Object var540C13E9E156B687226421B24F2DF178_196464022 =         null;
        var540C13E9E156B687226421B24F2DF178_196464022.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_196464022;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.402 -0400", hash_original_method = "D69CAFAFBC9C61DD3802AD1DC7C32FD3", hash_generated_method = "80582907896F474B9244A88212ED5E6F")
    protected void checkPosition() {
        if(-1 == mPos || getCount() == mPos)        
        {
            CursorIndexOutOfBoundsException var9505B20468EA036B4AD8C6EC0D2E4CFE_1631508890 = new CursorIndexOutOfBoundsException(mPos, getCount());
            var9505B20468EA036B4AD8C6EC0D2E4CFE_1631508890.addTaint(taint);
            throw var9505B20468EA036B4AD8C6EC0D2E4CFE_1631508890;
        } //End block
        // ---------- Original Method ----------
        //if (-1 == mPos || getCount() == mPos) {
            //throw new CursorIndexOutOfBoundsException(mPos, getCount());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.402 -0400", hash_original_method = "F26D041066C4F03E188153BABFEE500A", hash_generated_method = "3CAA66883E12BA7CD7932F65BFCD8226")
    @Override
    protected void finalize() {
        if(mSelfObserver != null && mSelfObserverRegistered == true)        
        {
            mContentResolver.unregisterContentObserver(mSelfObserver);
        } //End block
        // ---------- Original Method ----------
        //if (mSelfObserver != null && mSelfObserverRegistered == true) {
            //mContentResolver.unregisterContentObserver(mSelfObserver);
        //}
    }

    
    protected static class SelfContentObserver extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.403 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "703A671C4ACC07BD23149F0A5FD18BB7")

        WeakReference<AbstractCursor> mCursor;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.403 -0400", hash_original_method = "F9E51D895511CEE60B782983BAF87140", hash_generated_method = "1C8FE0B53CDA67BB2D5E07BFD3F83569")
        public  SelfContentObserver(AbstractCursor cursor) {
            super(null);
            mCursor = new WeakReference<AbstractCursor>(cursor);
            // ---------- Original Method ----------
            //mCursor = new WeakReference<AbstractCursor>(cursor);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.404 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "ACDAB2122BE2982F1B7A913CCA7F30D6")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var68934A3E9455FA72420237EB05902327_225939514 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000569107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000569107;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.405 -0400", hash_original_method = "DA6E4383047955D7231484890E1F062B", hash_generated_method = "2A497B7AE559C826E71E1842C4EE3B27")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
            AbstractCursor cursor = mCursor.get();
            if(cursor != null)            
            {
                cursor.onChange(false);
            } //End block
            // ---------- Original Method ----------
            //AbstractCursor cursor = mCursor.get();
            //if (cursor != null) {
                //cursor.onChange(false);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.406 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
}

