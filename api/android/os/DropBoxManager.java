package android.os;

// Droidsafe Imports
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import com.android.internal.os.IDropBoxManagerService;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DropBoxManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.032 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "FF673E933014905FBCDFD4D8541297A4")

    private IDropBoxManagerService mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.032 -0400", hash_original_method = "04B0A4DBB2EAE135AA112A8CAA9647B1", hash_generated_method = "56807A840D421C3846696C198899DDB8")
    public  DropBoxManager(IDropBoxManagerService service) {
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.033 -0400", hash_original_method = "E688A3A6CCC118BEDB51FAABD6872F4D", hash_generated_method = "1D2825C63C164429C45D67692FE8B561")
    protected  DropBoxManager() {
        mService = null;
        // ---------- Original Method ----------
        //mService = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.033 -0400", hash_original_method = "B6329499D071F8AC982F0B19B7FB97DF", hash_generated_method = "AC389ED0CA5C981E6BDFE990EAE31A10")
    public void addText(String tag, String data) {
        addTaint(data.getTaint());
        addTaint(tag.getTaint());
        try 
        {
            mService.add(new Entry(tag, 0, data));
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try { mService.add(new Entry(tag, 0, data)); } catch (RemoteException e) {}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.034 -0400", hash_original_method = "7BD48A32860AA6BD88FDC639FDB6D7D8", hash_generated_method = "DC301D2AD656C82005D88253CA9D918D")
    public void addData(String tag, byte[] data, int flags) {
        addTaint(flags);
        addTaint(data[0]);
        addTaint(tag.getTaint());
        if(data == null)        
        {
        NullPointerException var74B21EB75FD6AF39BBA1AA66BBDF99D7_1191529315 = new NullPointerException("data == null");
        var74B21EB75FD6AF39BBA1AA66BBDF99D7_1191529315.addTaint(taint);
        throw var74B21EB75FD6AF39BBA1AA66BBDF99D7_1191529315;
        }
        try 
        {
            mService.add(new Entry(tag, 0, data, flags));
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (data == null) throw new NullPointerException("data == null");
        //try { mService.add(new Entry(tag, 0, data, flags)); } catch (RemoteException e) {}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.034 -0400", hash_original_method = "BF97B72EB64F4DB129C9C48237659777", hash_generated_method = "62E05222B4F5E171B5DF4886DD1A09B7")
    public void addFile(String tag, File file, int flags) throws IOException {
        addTaint(flags);
        addTaint(file.getTaint());
        addTaint(tag.getTaint());
        if(file == null)        
        {
        NullPointerException var34C654CB6A962C169433BF5C5405377F_1794759895 = new NullPointerException("file == null");
        var34C654CB6A962C169433BF5C5405377F_1794759895.addTaint(taint);
        throw var34C654CB6A962C169433BF5C5405377F_1794759895;
        }
        Entry entry = new Entry(tag, 0, file, flags);
        try 
        {
            mService.add(entry);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        finally 
        {
            entry.close();
        } //End block
        // ---------- Original Method ----------
        //if (file == null) throw new NullPointerException("file == null");
        //Entry entry = new Entry(tag, 0, file, flags);
        //try {
            //mService.add(entry);
        //} catch (RemoteException e) {
        //} finally {
            //entry.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_method = "0FE06F2CE6966672337D3755F0FF0CD0", hash_generated_method = "87BC025C4CC66EEA3F330C5CC0FDA0C3")
    public boolean isTagEnabled(String tag) {
        addTaint(tag.getTaint());
        try 
        {
            boolean var1F15D573D13DB13668AD61D7F6DD4BF7_1319784499 = (mService.isTagEnabled(tag));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927603978 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_927603978;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_781994892 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060326967 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060326967;
        } //End block
        // ---------- Original Method ----------
        //try { return mService.isTagEnabled(tag); } catch (RemoteException e) { return false; }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_method = "A691D94F864449A091C30E093C0F46CD", hash_generated_method = "D86CD1BE18054C5CF282E83D2E5883C6")
    public Entry getNextEntry(String tag, long msec) {
        addTaint(msec);
        addTaint(tag.getTaint());
        try 
        {
Entry varC35DB0DF9A7A1174D79EA076F0F0C7C9_1271928249 =             mService.getNextEntry(tag, msec);
            varC35DB0DF9A7A1174D79EA076F0F0C7C9_1271928249.addTaint(taint);
            return varC35DB0DF9A7A1174D79EA076F0F0C7C9_1271928249;
        } //End block
        catch (RemoteException e)
        {
Entry var540C13E9E156B687226421B24F2DF178_963383853 =             null;
            var540C13E9E156B687226421B24F2DF178_963383853.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_963383853;
        } //End block
        // ---------- Original Method ----------
        //try { return mService.getNextEntry(tag, msec); } catch (RemoteException e) { return null; }
    }

    
    public static class Entry implements Parcelable, Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_field = "6F3BEB4D53F7C410F1DAD4C6334EE882", hash_generated_field = "753DEC84E9370E35F2BD26C6679E5DA4")

        private long mTimeMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

        private byte[] mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.035 -0400", hash_original_field = "D118306A98C1E7C12AA828417A60A6F6", hash_generated_field = "2EB80060CD9954C0E91A29E7A228F077")

        private ParcelFileDescriptor mFileDescriptor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.036 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

        private int mFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.036 -0400", hash_original_method = "59D4C7A828654550E9A00289F418A41B", hash_generated_method = "277FA671F5567AB767047A183CEA7FC0")
        public  Entry(String tag, long millis) {
            if(tag == null)            
            {
            NullPointerException var1E85E553B95480EC9A469302FEAE89B0_43122538 = new NullPointerException("tag == null");
            var1E85E553B95480EC9A469302FEAE89B0_43122538.addTaint(taint);
            throw var1E85E553B95480EC9A469302FEAE89B0_43122538;
            }
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = null;
            mFlags = IS_EMPTY;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = null;
            //mFlags = IS_EMPTY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.036 -0400", hash_original_method = "3040DA05407F13E8561F02C468A7DEB4", hash_generated_method = "44AA3F8C70992E6FB3BBAEEB57F12ED6")
        public  Entry(String tag, long millis, String text) {
            if(tag == null)            
            {
            NullPointerException var1E85E553B95480EC9A469302FEAE89B0_1180912258 = new NullPointerException("tag == null");
            var1E85E553B95480EC9A469302FEAE89B0_1180912258.addTaint(taint);
            throw var1E85E553B95480EC9A469302FEAE89B0_1180912258;
            }
            if(text == null)            
            {
            NullPointerException var2094F8EFC3209DC9F4F6CC1688697D1B_2094871343 = new NullPointerException("text == null");
            var2094F8EFC3209DC9F4F6CC1688697D1B_2094871343.addTaint(taint);
            throw var2094F8EFC3209DC9F4F6CC1688697D1B_2094871343;
            }
            mTag = tag;
            mTimeMillis = millis;
            mData = text.getBytes();
            mFileDescriptor = null;
            mFlags = IS_TEXT;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (text == null) throw new NullPointerException("text == null");
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = text.getBytes();
            //mFileDescriptor = null;
            //mFlags = IS_TEXT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.037 -0400", hash_original_method = "182B4976A5D069A0C2E90B74F50A592D", hash_generated_method = "EE98EF299EEA1498C70B895F77723A1E")
        public  Entry(String tag, long millis, byte[] data, int flags) {
            if(tag == null)            
            {
            NullPointerException var1E85E553B95480EC9A469302FEAE89B0_362477758 = new NullPointerException("tag == null");
            var1E85E553B95480EC9A469302FEAE89B0_362477758.addTaint(taint);
            throw var1E85E553B95480EC9A469302FEAE89B0_362477758;
            }
            if(((flags & IS_EMPTY) != 0) != (data == null))            
            {
                IllegalArgumentException varF750588A09C5E75412D313969A5EB532_752147089 = new IllegalArgumentException("Bad flags: " + flags);
                varF750588A09C5E75412D313969A5EB532_752147089.addTaint(taint);
                throw varF750588A09C5E75412D313969A5EB532_752147089;
            } //End block
            mTag = tag;
            mTimeMillis = millis;
            mData = data;
            mFileDescriptor = null;
            mFlags = flags;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (((flags & IS_EMPTY) != 0) != (data == null)) {
                //throw new IllegalArgumentException("Bad flags: " + flags);
            //}
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = data;
            //mFileDescriptor = null;
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.037 -0400", hash_original_method = "98F6B6C49553AC4D3032798198FC694A", hash_generated_method = "6B44542747411EB65E01F53682BF9ECE")
        public  Entry(String tag, long millis, ParcelFileDescriptor data, int flags) {
            if(tag == null)            
            {
            NullPointerException var1E85E553B95480EC9A469302FEAE89B0_689125001 = new NullPointerException("tag == null");
            var1E85E553B95480EC9A469302FEAE89B0_689125001.addTaint(taint);
            throw var1E85E553B95480EC9A469302FEAE89B0_689125001;
            }
            if(((flags & IS_EMPTY) != 0) != (data == null))            
            {
                IllegalArgumentException varF750588A09C5E75412D313969A5EB532_79248766 = new IllegalArgumentException("Bad flags: " + flags);
                varF750588A09C5E75412D313969A5EB532_79248766.addTaint(taint);
                throw varF750588A09C5E75412D313969A5EB532_79248766;
            } //End block
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = data;
            mFlags = flags;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if (((flags & IS_EMPTY) != 0) != (data == null)) {
                //throw new IllegalArgumentException("Bad flags: " + flags);
            //}
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = data;
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.037 -0400", hash_original_method = "102E401D4541F654441520BE506818C4", hash_generated_method = "5D48FF598988DE615EEECAC52C7E2A0E")
        public  Entry(String tag, long millis, File data, int flags) throws IOException {
            if(tag == null)            
            {
            NullPointerException var1E85E553B95480EC9A469302FEAE89B0_545724826 = new NullPointerException("tag == null");
            var1E85E553B95480EC9A469302FEAE89B0_545724826.addTaint(taint);
            throw var1E85E553B95480EC9A469302FEAE89B0_545724826;
            }
            if((flags & IS_EMPTY) != 0)            
            {
            IllegalArgumentException varF750588A09C5E75412D313969A5EB532_1192903621 = new IllegalArgumentException("Bad flags: " + flags);
            varF750588A09C5E75412D313969A5EB532_1192903621.addTaint(taint);
            throw varF750588A09C5E75412D313969A5EB532_1192903621;
            }
            mTag = tag;
            mTimeMillis = millis;
            mData = null;
            mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            mFlags = flags;
            // ---------- Original Method ----------
            //if (tag == null) throw new NullPointerException("tag == null");
            //if ((flags & IS_EMPTY) != 0) throw new IllegalArgumentException("Bad flags: " + flags);
            //mTag = tag;
            //mTimeMillis = millis;
            //mData = null;
            //mFileDescriptor = ParcelFileDescriptor.open(data, ParcelFileDescriptor.MODE_READ_ONLY);
            //mFlags = flags;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.037 -0400", hash_original_method = "377836285D1E96A0220618E9638425CD", hash_generated_method = "EEB361D0E712E8EAD12BCE15450A80D3")
        public void close() {
            try 
            {
                if(mFileDescriptor != null)                
                mFileDescriptor.close();
            } //End block
            catch (IOException e)
            {
            } //End block
            // ---------- Original Method ----------
            //try { if (mFileDescriptor != null) mFileDescriptor.close(); } catch (IOException e) { }
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.037 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "544C098D59D124B17337B9F801C86976")
        public String getTag() {
String varD6A25044F8E609F6CD67330C1523D33D_132580768 =             mTag;
            varD6A25044F8E609F6CD67330C1523D33D_132580768.addTaint(taint);
            return varD6A25044F8E609F6CD67330C1523D33D_132580768;
            // ---------- Original Method ----------
            //return mTag;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.038 -0400", hash_original_method = "6C399926D10F83AEDA9A5ADCC6A5D3A1", hash_generated_method = "8E361930D400F199DE19D2DBF3C51C36")
        public long getTimeMillis() {
            long var6F3BEB4D53F7C410F1DAD4C6334EE882_1414042743 = (mTimeMillis);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1841621 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1841621;
            // ---------- Original Method ----------
            //return mTimeMillis;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.038 -0400", hash_original_method = "DEBA147F1626153ABBF4AEA4FEEBC80F", hash_generated_method = "3334E8A600C4821474B8276F1FDA9B80")
        public int getFlags() {
            int varB715A5FBEBA48B733FCB394E91827C12_90907064 = (mFlags & ~IS_GZIPPED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764408327 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764408327;
            // ---------- Original Method ----------
            //return mFlags & ~IS_GZIPPED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.038 -0400", hash_original_method = "5115D4296A1E9A49B9B7627B57AD3F2E", hash_generated_method = "1AF9A17E151E981353B26297AE4654B4")
        public String getText(int maxBytes) {
            addTaint(maxBytes);
            if((mFlags & IS_TEXT) == 0)            
            {
String var540C13E9E156B687226421B24F2DF178_908803646 =             null;
            var540C13E9E156B687226421B24F2DF178_908803646.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_908803646;
            }
            if(mData != null)            
            {
String var96864056F97ADD0F6ECB1F2BAF469666_2085165567 =             new String(mData, 0, Math.min(maxBytes, mData.length));
            var96864056F97ADD0F6ECB1F2BAF469666_2085165567.addTaint(taint);
            return var96864056F97ADD0F6ECB1F2BAF469666_2085165567;
            }
            InputStream is = null;
            try 
            {
                is = getInputStream();
                if(is == null)                
                {
String var540C13E9E156B687226421B24F2DF178_865432381 =                 null;
                var540C13E9E156B687226421B24F2DF178_865432381.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_865432381;
                }
                byte[] buf = new byte[maxBytes];
                int readBytes = 0;
                int n = 0;
                while
(n >= 0 && (readBytes += n) < maxBytes)                
                {
                    n = is.read(buf, readBytes, maxBytes - readBytes);
                } //End block
String varFFBEAD4F1BFF86616DF19DD0736D251E_1857679977 =                 new String(buf, 0, readBytes);
                varFFBEAD4F1BFF86616DF19DD0736D251E_1857679977.addTaint(taint);
                return varFFBEAD4F1BFF86616DF19DD0736D251E_1857679977;
            } //End block
            catch (IOException e)
            {
String var540C13E9E156B687226421B24F2DF178_1186446105 =                 null;
                var540C13E9E156B687226421B24F2DF178_1186446105.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1186446105;
            } //End block
            finally 
            {
                try 
                {
                    if(is != null)                    
                    is.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if ((mFlags & IS_TEXT) == 0) return null;
            //if (mData != null) return new String(mData, 0, Math.min(maxBytes, mData.length));
            //InputStream is = null;
            //try {
                //is = getInputStream();
                //if (is == null) return null;
                //byte[] buf = new byte[maxBytes];
                //int readBytes = 0;
                //int n = 0;
                //while (n >= 0 && (readBytes += n) < maxBytes) {
                    //n = is.read(buf, readBytes, maxBytes - readBytes);
                //}
                //return new String(buf, 0, readBytes);
            //} catch (IOException e) {
                //return null;
            //} finally {
                //try { if (is != null) is.close(); } catch (IOException e) {}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.039 -0400", hash_original_method = "1138A2AC2CDA63F5FD2C1DAD635BB1B0", hash_generated_method = "F4031678DF72BA5ED94E7B176B74DAED")
        public InputStream getInputStream() throws IOException {
            InputStream is;
            if(mData != null)            
            {
                is = new ByteArrayInputStream(mData);
            } //End block
            else
            if(mFileDescriptor != null)            
            {
                is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            } //End block
            else
            {
InputStream var540C13E9E156B687226421B24F2DF178_1118460576 =                 null;
                var540C13E9E156B687226421B24F2DF178_1118460576.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1118460576;
            } //End block
InputStream varE0596AA8DDE6DE71669BCED4AEBB387A_1587454095 =             (mFlags & IS_GZIPPED) != 0 ? new GZIPInputStream(is) : is;
            varE0596AA8DDE6DE71669BCED4AEBB387A_1587454095.addTaint(taint);
            return varE0596AA8DDE6DE71669BCED4AEBB387A_1587454095;
            // ---------- Original Method ----------
            //InputStream is;
            //if (mData != null) {
                //is = new ByteArrayInputStream(mData);
            //} else if (mFileDescriptor != null) {
                //is = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
            //} else {
                //return null;
            //}
            //return (mFlags & IS_GZIPPED) != 0 ? new GZIPInputStream(is) : is;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.039 -0400", hash_original_method = "CE12D992AD97C7CB4D92B660FD5831CC", hash_generated_method = "0A73F52B39825BC5D78D96A27A299494")
        public int describeContents() {
            int varCFD07FB51B103FA0811B00D763E3B42D_405677861 = (mFileDescriptor != null ? Parcelable.CONTENTS_FILE_DESCRIPTOR : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237222698 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237222698;
            // ---------- Original Method ----------
            //return mFileDescriptor != null ? Parcelable.CONTENTS_FILE_DESCRIPTOR : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.039 -0400", hash_original_method = "651672D7808B55AEFC112D3455309C97", hash_generated_method = "D22B08C0AA9278AA538C24A2EEA743E5")
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            out.writeString(mTag);
            out.writeLong(mTimeMillis);
            if(mFileDescriptor != null)            
            {
                out.writeInt(mFlags & ~HAS_BYTE_ARRAY);
                mFileDescriptor.writeToParcel(out, flags);
            } //End block
            else
            {
                out.writeInt(mFlags | HAS_BYTE_ARRAY);
                out.writeByteArray(mData);
            } //End block
            // ---------- Original Method ----------
            //out.writeString(mTag);
            //out.writeLong(mTimeMillis);
            //if (mFileDescriptor != null) {
                //out.writeInt(mFlags & ~HAS_BYTE_ARRAY);  
                //mFileDescriptor.writeToParcel(out, flags);
            //} else {
                //out.writeInt(mFlags | HAS_BYTE_ARRAY);
                //out.writeByteArray(mData);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.039 -0400", hash_original_field = "A8DC184895BB5B5BEE6BB5E9D72AA17F", hash_generated_field = "329A53A95C2F0B54BB6DBA5A539F5907")

        public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator() {
            public Entry[] newArray(int size) { return new Entry[size]; }
            public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        };
        // orphaned legacy method
        public Entry createFromParcel(Parcel in) {
                String tag = in.readString();
                long millis = in.readLong();
                int flags = in.readInt();
                if ((flags & HAS_BYTE_ARRAY) != 0) {
                    return new Entry(tag, millis, in.createByteArray(), flags & ~HAS_BYTE_ARRAY);
                } else {
                    return new Entry(tag, millis, in.readFileDescriptor(), flags);
                }
            }
        
        // orphaned legacy method
        public Entry[] newArray(int size) { return new Entry[size]; }
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "DF2FD460CAAAEBB1A10FC77F067462EB", hash_generated_field = "7F88B1F6C3AA23682B73D2063D96AD46")

    private static final String TAG = "DropBoxManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "79A4E1188426E01C21F71399E062B2DB", hash_generated_field = "4342C6618E9F33B619CAED2246633D02")

    public static final int IS_EMPTY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "58E57C056E79049DC8AFF3FE98FDEE08", hash_generated_field = "26AE776D9F0D1E8967689D8BDE25B1E4")

    public static final int IS_TEXT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "F03BF7F70E23C4614DE3AF15DEE42B19", hash_generated_field = "0467C01D2B434424775E1AEC77EA10FE")

    public static final int IS_GZIPPED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "3CC289AFB2A4BFCE9CF3B0CE20E7FE9C", hash_generated_field = "48D79452E0CE2C4C0A373F8DD88D3A93")

    private static final int HAS_BYTE_ARRAY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "1C1542243F83EC851C9D74881C834C3E", hash_generated_field = "C96D94412FCD56314FB7038C746F0C74")

    public static final String ACTION_DROPBOX_ENTRY_ADDED =
        "android.intent.action.DROPBOX_ENTRY_ADDED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "56A4A212BD6F81ED70338F2E0CD1786C", hash_generated_field = "DA52E65CF9683E9971D90CD0BBF2BACB")

    public static final String EXTRA_TAG = "tag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.040 -0400", hash_original_field = "F2F651B0DF45A4AA735D59F9077C5568", hash_generated_field = "BF72FAE2E20FCDE1DA6F95CAA1981EAC")

    public static final String EXTRA_TIME = "time";
}

