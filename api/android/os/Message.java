package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TimeUtils;

public final class Message implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.690 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "130AB11BC4A7C28A3CB0C97AC053381A")

    public int what;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.690 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "1808B9C59CDAD2173540A83CCC2F12FC")

    public int arg1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.690 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "D3008AC94E91096C7F8D70DE5B308A98")

    public int arg2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "BE8F80182E0C983916DA7338C2C1C040", hash_generated_field = "3D030F645B0E31EC2638A0FDB262ACF0")

    public Object obj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "18870C945F5A9236EE66F25EEE76F849", hash_generated_field = "59ACAA216DB03F1B21C3B4CE2CA4F885")

    public Messenger replyTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

    int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "4E7289569777021C55877266ACAD1845")

    long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BB882EDD7B91CD5D615428BED9D11B40")

    Bundle data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "6747FE4EAD68C59D650E1B0351577C58")

    Handler target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "717897033CD9178FC069A108DDA31DCB")

    Runnable callback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "165CCC48EE62810C4F5C8218FA3C8FD1")

    Message next;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.691 -0400", hash_original_method = "07161C5E5BFC528DA3FC2F6017B16172", hash_generated_method = "95F5AD60FAEEEF50B67BC5FEEDEC5F61")
    public  Message() {
        // ---------- Original Method ----------
    }

    
        public static Message obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message m = sPool;
                sPool = m.next;
                m.next = null;
                sPoolSize--;
                return m;
            }
        }
        return new Message();
    }

    
        public static Message obtain(Message orig) {
        Message m = obtain();
        m.what = orig.what;
        m.arg1 = orig.arg1;
        m.arg2 = orig.arg2;
        m.obj = orig.obj;
        m.replyTo = orig.replyTo;
        if (orig.data != null) {
            m.data = new Bundle(orig.data);
        }
        m.target = orig.target;
        m.callback = orig.callback;
        return m;
    }

    
        public static Message obtain(Handler h) {
        Message m = obtain();
        m.target = h;
        return m;
    }

    
        public static Message obtain(Handler h, Runnable callback) {
        Message m = obtain();
        m.target = h;
        m.callback = callback;
        return m;
    }

    
        public static Message obtain(Handler h, int what) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        return m;
    }

    
        public static Message obtain(Handler h, int what, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;
        return m;
    }

    
        public static Message obtain(Handler h, int what, int arg1, int arg2) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        return m;
    }

    
        public static Message obtain(Handler h, int what, 
            int arg1, int arg2, Object obj) {
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        m.obj = obj;
        return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.693 -0400", hash_original_method = "0036C7E97F14F697C30BFE1437947C9D", hash_generated_method = "F78A06C3F9DE463F815E6DAF407D0031")
    public void recycle() {
        clearForRecycle();
        synchronized
(sPoolSync)        {
    if(sPoolSize < MAX_POOL_SIZE)            
            {
                next = sPool;
                sPool = this;
                sPoolSize++;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //clearForRecycle();
        //synchronized (sPoolSync) {
            //if (sPoolSize < MAX_POOL_SIZE) {
                //next = sPool;
                //sPool = this;
                //sPoolSize++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.695 -0400", hash_original_method = "964842F017E82BDA48950DE2BC18315A", hash_generated_method = "9472B6CB70CA26D88794646C7BF1E8E9")
    public void copyFrom(Message o) {
        this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        this.what = o.what;
        this.arg1 = o.arg1;
        this.arg2 = o.arg2;
        this.obj = o.obj;
        this.replyTo = o.replyTo;
    if(o.data != null)        
        {
            this.data = (Bundle) o.data.clone();
        } //End block
        else
        {
            this.data = null;
        } //End block
        // ---------- Original Method ----------
        //this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        //this.what = o.what;
        //this.arg1 = o.arg1;
        //this.arg2 = o.arg2;
        //this.obj = o.obj;
        //this.replyTo = o.replyTo;
        //if (o.data != null) {
            //this.data = (Bundle) o.data.clone();
        //} else {
            //this.data = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.696 -0400", hash_original_method = "003296F505672677447BEB837B373395", hash_generated_method = "F35AD71564D31F4319BFDB612E79A606")
    public long getWhen() {
        long varDF491A4DE50739FA9CFFDBD4E3F4B4BB_1303423623 = (when);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1445492138 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1445492138;
        // ---------- Original Method ----------
        //return when;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.696 -0400", hash_original_method = "4206C8A14E5D790EB7EB282A0235F495", hash_generated_method = "BFA69EC1EEA25086C4D9E40A15F143AE")
    public void setTarget(Handler target) {
        this.target = target;
        // ---------- Original Method ----------
        //this.target = target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.696 -0400", hash_original_method = "71A342D68A16A50B25BC4BF2093BFF62", hash_generated_method = "FEEB8F0F96DDB732C09833C04CCA8E3A")
    public Handler getTarget() {
Handler varA7DD35DE8EDE4A2FCAF77CE202E687B3_659864432 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_659864432.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_659864432;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.697 -0400", hash_original_method = "BE120AA50B796443E57F262EC015813E", hash_generated_method = "93A968A1040D5E1B1F7E19B77595CBD2")
    public Runnable getCallback() {
Runnable var221B6914C84D3DFBD8B1EDBBC49B8CE3_319013397 =         callback;
        var221B6914C84D3DFBD8B1EDBBC49B8CE3_319013397.addTaint(taint);
        return var221B6914C84D3DFBD8B1EDBBC49B8CE3_319013397;
        // ---------- Original Method ----------
        //return callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.697 -0400", hash_original_method = "1D2563192E30736CE7AB1C4867F66034", hash_generated_method = "4129D1D986BB5BC85D63152E7DCA8ADE")
    public Bundle getData() {
    if(data == null)        
        {
            data = new Bundle();
        } //End block
Bundle var0C8B2C9585EB05DD9CD70726CF8CBC07_2085669608 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_2085669608.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_2085669608;
        // ---------- Original Method ----------
        //if (data == null) {
            //data = new Bundle();
        //}
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.697 -0400", hash_original_method = "82F96E5D1D9A678E87ADC3DA47E10262", hash_generated_method = "7A89545FECD67375F7ED764A56C8A198")
    public Bundle peekData() {
Bundle var0C8B2C9585EB05DD9CD70726CF8CBC07_1341795875 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_1341795875.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_1341795875;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.698 -0400", hash_original_method = "2A3AF1BEE5D39047FC40D7968EE3828B", hash_generated_method = "EAE8CA4F21A678E5FDC9CFA85AC5AD0E")
    public void setData(Bundle data) {
        this.data = data;
        // ---------- Original Method ----------
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.698 -0400", hash_original_method = "2D3F3759D60A7A1CBA79B8F487061097", hash_generated_method = "3B7F287400275060A2AE0E3943AFE99E")
    public void sendToTarget() {
        target.sendMessage(this);
        // ---------- Original Method ----------
        //target.sendMessage(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.699 -0400", hash_original_method = "9CE194651C6176A08C0A91B012A85C32", hash_generated_method = "11A13B0F3660F78F0D526315F89EA24B")
     void clearForRecycle() {
        flags = 0;
        what = 0;
        arg1 = 0;
        arg2 = 0;
        obj = null;
        replyTo = null;
        when = 0;
        target = null;
        callback = null;
        data = null;
        // ---------- Original Method ----------
        //flags = 0;
        //what = 0;
        //arg1 = 0;
        //arg2 = 0;
        //obj = null;
        //replyTo = null;
        //when = 0;
        //target = null;
        //callback = null;
        //data = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.699 -0400", hash_original_method = "2F71B67A0204C39D3FE8504F70842AAF", hash_generated_method = "19B48906729B976F872251C868C3A73A")
     boolean isInUse() {
        boolean var74582B96000F3154DC110B64F0D6FDDF_1799553454 = (((flags & FLAG_IN_USE) == FLAG_IN_USE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1404883348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1404883348;
        // ---------- Original Method ----------
        //return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.700 -0400", hash_original_method = "05D8812E72ABC796A0F0FB73D8BB23FD", hash_generated_method = "2406C8342B30A3F95EC80EECA1F8197F")
     void markInUse() {
        flags |= FLAG_IN_USE;
        // ---------- Original Method ----------
        //flags |= FLAG_IN_USE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.700 -0400", hash_original_method = "F5F2ADD77ACF5EFEB7E2DD825A11C06D", hash_generated_method = "9DFFCA7BFD0B37B024CC704431730965")
    public String toString() {
String var91A42A27C64601C07B4F59782CF2294C_436882112 =         toString(SystemClock.uptimeMillis());
        var91A42A27C64601C07B4F59782CF2294C_436882112.addTaint(taint);
        return var91A42A27C64601C07B4F59782CF2294C_436882112;
        // ---------- Original Method ----------
        //return toString(SystemClock.uptimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.700 -0400", hash_original_method = "94FE68A35FA2D79CB6E07D112DBAE9F2", hash_generated_method = "6DE4A3287CE15E10DAEC6B6D714CBFAB")
     String toString(long now) {
        addTaint(now);
        StringBuilder b = new StringBuilder();
        b.append("{ what=");
        b.append(what);
        b.append(" when=");
        TimeUtils.formatDuration(when-now, b);
    if(arg1 != 0)        
        {
            b.append(" arg1=");
            b.append(arg1);
        } //End block
    if(arg2 != 0)        
        {
            b.append(" arg2=");
            b.append(arg2);
        } //End block
    if(obj != null)        
        {
            b.append(" obj=");
            b.append(obj);
        } //End block
        b.append(" }");
String var53F188277CD163A95D3D9B5184E22806_1785862232 =         b.toString();
        var53F188277CD163A95D3D9B5184E22806_1785862232.addTaint(taint);
        return var53F188277CD163A95D3D9B5184E22806_1785862232;
        // ---------- Original Method ----------
        //StringBuilder   b = new StringBuilder();
        //b.append("{ what=");
        //b.append(what);
        //b.append(" when=");
        //TimeUtils.formatDuration(when-now, b);
        //if (arg1 != 0) {
            //b.append(" arg1=");
            //b.append(arg1);
        //}
        //if (arg2 != 0) {
            //b.append(" arg2=");
            //b.append(arg2);
        //}
        //if (obj != null) {
            //b.append(" obj=");
            //b.append(obj);
        //}
        //b.append(" }");
        //return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.701 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A2FE4B856800D447713920BEFA0B6324")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1486104355 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552047054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552047054;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.701 -0400", hash_original_method = "FA929F9306B89098CA5E11E46F85B0F7", hash_generated_method = "ADA23FE8A9A94BC42FA727E76DBCB2E6")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
    if(callback != null)        
        {
            RuntimeException var36B9E2BBA96CFD5DBB1D4D140A1FE82D_358068838 = new RuntimeException(
                "Can't marshal callbacks across processes.");
            var36B9E2BBA96CFD5DBB1D4D140A1FE82D_358068838.addTaint(taint);
            throw var36B9E2BBA96CFD5DBB1D4D140A1FE82D_358068838;
        } //End block
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
    if(obj != null)        
        {
            try 
            {
                Parcelable p = (Parcelable)obj;
                dest.writeInt(1);
                dest.writeParcelable(p, flags);
            } //End block
            catch (ClassCastException e)
            {
                RuntimeException varEF8002C3571C0E4E39167FD1D2280D44_1949986921 = new RuntimeException(
                    "Can't marshal non-Parcelable objects across processes.");
                varEF8002C3571C0E4E39167FD1D2280D44_1949986921.addTaint(taint);
                throw varEF8002C3571C0E4E39167FD1D2280D44_1949986921;
            } //End block
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
        dest.writeLong(when);
        dest.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, dest);
        // ---------- Original Method ----------
        //if (callback != null) {
            //throw new RuntimeException(
                //"Can't marshal callbacks across processes.");
        //}
        //dest.writeInt(what);
        //dest.writeInt(arg1);
        //dest.writeInt(arg2);
        //if (obj != null) {
            //try {
                //Parcelable p = (Parcelable)obj;
                //dest.writeInt(1);
                //dest.writeParcelable(p, flags);
            //} catch (ClassCastException e) {
                //throw new RuntimeException(
                    //"Can't marshal non-Parcelable objects across processes.");
            //}
        //} else {
            //dest.writeInt(0);
        //}
        //dest.writeLong(when);
        //dest.writeBundle(data);
        //Messenger.writeMessengerOrNullToParcel(replyTo, dest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.702 -0400", hash_original_method = "95144FD69C7B3357510BFAF1773BB579", hash_generated_method = "789CC29155B7A441B9EC869B61F7A9FD")
    private final void readFromParcel(Parcel source) {
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
    if(source.readInt() != 0)        
        {
            obj = source.readParcelable(getClass().getClassLoader());
        } //End block
        when = source.readLong();
        data = source.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(source);
        // ---------- Original Method ----------
        //what = source.readInt();
        //arg1 = source.readInt();
        //arg2 = source.readInt();
        //if (source.readInt() != 0) {
            //obj = source.readParcelable(getClass().getClassLoader());
        //}
        //when = source.readLong();
        //data = source.readBundle();
        //replyTo = Messenger.readMessengerOrNullFromParcel(source);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.702 -0400", hash_original_field = "57B7C7421075F6B6420F911D3527AFB6", hash_generated_field = "878DEDDD7B572ED9867CCDEBD4347356")

    static final int FLAG_IN_USE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "F2146583483B569FF112D02F21977BC5", hash_generated_field = "63BCD1D96706E3D5340B3C46A4396022")

    static final int FLAGS_RESERVED = ~FLAG_IN_USE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "3D49B55061DF5B14043047E338410BBA", hash_generated_field = "35B37EFAF229985395377BFF3A8A2664")

    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

    private static final Object sPoolSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "3C48422D8BFA116BB318D4BB60A34BBD")

    private static Message sPool;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

    private static final int MAX_POOL_SIZE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.703 -0400", hash_original_field = "43229C35F8261605B76A284A560DF109", hash_generated_field = "E157BCD0B97CB6AF314D46703252D6F2")

    public static final Parcelable.Creator<Message> CREATOR
            = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
        
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
    // orphaned legacy method
    public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
    
    // orphaned legacy method
    public Message[] newArray(int size) {
            return new Message[size];
        }
    
}

