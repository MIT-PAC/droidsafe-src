package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import android.app.PendingIntent;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater.Filter;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class RemoteViews implements Parcelable, Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_field = "143EA7733FD06F80DE8D3B366855A342", hash_generated_field = "62824B28582365160D4F4E663AF78109")

    private int mLayoutId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BDB8276C1ABE28FC56F7F2EFF4E83F5A")

    private ArrayList<Action> mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_field = "302EDB52DCA958E10D9F1FB586627A2C", hash_generated_field = "428BAA212C6DEB5FEF7CB6370C9BEBDF")

    private MemoryUsageCounter mMemoryUsageCounter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_field = "DF25E6BAFF11DD73CFFFA27BAA8B8CFC", hash_generated_field = "5F2713F2C4461A89B34556F5FA319D47")

    private boolean mIsWidgetCollectionChild = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.693 -0400", hash_original_method = "7ADC44A8B9BDF8C00FB4776840C5552D", hash_generated_method = "154333C84C3CBD1C406C406999A1627C")
    public  RemoteViews(String packageName, int layoutId) {
        mPackage = packageName;
        mLayoutId = layoutId;
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        // ---------- Original Method ----------
        //mPackage = packageName;
        //mLayoutId = layoutId;
        //mMemoryUsageCounter = new MemoryUsageCounter();
        //recalculateMemoryUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.694 -0400", hash_original_method = "B81662C8B479B3D3C957D533866FE808", hash_generated_method = "DD1188C823E758F1B8CA165325EAF661")
    public  RemoteViews(Parcel parcel) {
        mPackage = parcel.readString();
        mLayoutId = parcel.readInt();
        mIsWidgetCollectionChild = parcel.readInt() == 1 ? true : false;
        int count = parcel.readInt();
    if(count > 0)        
        {
            mActions = new ArrayList<Action>(count);
for(int i=0;i<count;i++)
            {
                int tag = parcel.readInt();
switch(tag){
                case SetOnClickPendingIntent.TAG:
                mActions.add(new SetOnClickPendingIntent(parcel));
                break;
                case SetDrawableParameters.TAG:
                mActions.add(new SetDrawableParameters(parcel));
                break;
                case ReflectionAction.TAG:
                mActions.add(new ReflectionAction(parcel));
                break;
                case ViewGroupAction.TAG:
                mActions.add(new ViewGroupAction(parcel));
                break;
                case ReflectionActionWithoutParams.TAG:
                mActions.add(new ReflectionActionWithoutParams(parcel));
                break;
                case SetEmptyView.TAG:
                mActions.add(new SetEmptyView(parcel));
                break;
                case SetPendingIntentTemplate.TAG:
                mActions.add(new SetPendingIntentTemplate(parcel));
                break;
                case SetOnClickFillInIntent.TAG:
                mActions.add(new SetOnClickFillInIntent(parcel));
                break;
                case SetRemoteViewsAdapterIntent.TAG:
                mActions.add(new SetRemoteViewsAdapterIntent(parcel));
                break;
                default:
                ActionException var18F3965C1BB9FAE60EB4AD1DBA08EF2F_1653152720 = new ActionException("Tag " + tag + " not found");
                var18F3965C1BB9FAE60EB4AD1DBA08EF2F_1653152720.addTaint(taint);
                throw var18F3965C1BB9FAE60EB4AD1DBA08EF2F_1653152720;
}
            } //End block
        } //End block
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "67D19BE5CA3BC69F21B2B2516A1FA2D6", hash_generated_method = "DF6F806E3ABA923F1CC01BC387D0C002")
    @Override
    public RemoteViews clone() {
        final RemoteViews that = new RemoteViews(mPackage, mLayoutId);
    if(mActions != null)        
        {
            that.mActions = (ArrayList<Action>)mActions.clone();
        } //End block
        that.recalculateMemoryUsage();
RemoteViews varF9965B73D80F3C31BC4764828F08696D_608117871 =         that;
        varF9965B73D80F3C31BC4764828F08696D_608117871.addTaint(taint);
        return varF9965B73D80F3C31BC4764828F08696D_608117871;
        // ---------- Original Method ----------
        //final RemoteViews that = new RemoteViews(mPackage, mLayoutId);
        //if (mActions != null) {
            //that.mActions = (ArrayList<Action>)mActions.clone();
        //}
        //that.recalculateMemoryUsage();
        //return that;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "AB11E6DC624CBF5C7D73630F54549ADA")
    public String getPackage() {
String varD0D543EB218BC9E16C17B23C08BC19C7_1080025883 =         mPackage;
        varD0D543EB218BC9E16C17B23C08BC19C7_1080025883.addTaint(taint);
        return varD0D543EB218BC9E16C17B23C08BC19C7_1080025883;
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "613C00C60CA896BC5001BD5561015459", hash_generated_method = "547966D8D331A8689250645CD2D3CC6C")
    public int getLayoutId() {
        int var143EA7733FD06F80DE8D3B366855A342_1243786878 = (mLayoutId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065652215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065652215;
        // ---------- Original Method ----------
        //return mLayoutId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "B2E01CE5E210E0306AAEDD7A25572B15", hash_generated_method = "C504A5E5F8CCD8C6A31C201D44889892")
     void setIsWidgetCollectionChild(boolean isWidgetCollectionChild) {
        mIsWidgetCollectionChild = isWidgetCollectionChild;
        // ---------- Original Method ----------
        //mIsWidgetCollectionChild = isWidgetCollectionChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "F73414915FBB974B28CE5BE7CD6B07B1", hash_generated_method = "94027C00C143FC7879CEA2922EE72FA6")
    private void recalculateMemoryUsage() {
        mMemoryUsageCounter.clear();
    if(mActions != null)        
        {
            final int count = mActions.size();
for(int i= 0;i < count;++i)
            {
                mActions.get(i).updateMemoryUsageEstimate(mMemoryUsageCounter);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mMemoryUsageCounter.clear();
        //if (mActions != null) {
            //final int count = mActions.size();
            //for (int i= 0; i < count; ++i) {
                //mActions.get(i).updateMemoryUsageEstimate(mMemoryUsageCounter);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "4E1C2F916A403E6D1D4B708360B7D61A", hash_generated_method = "7362F7F130776BAE66710286E9D3E9D9")
     int estimateBitmapMemoryUsage() {
        int var5636738054CB1447726DCC68F6EB720D_403291261 = (mMemoryUsageCounter.getBitmapHeapMemoryUsage());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591501347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591501347;
        // ---------- Original Method ----------
        //return mMemoryUsageCounter.getBitmapHeapMemoryUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.695 -0400", hash_original_method = "17103049C6B2546A05BB76759DAB3B89", hash_generated_method = "41AB35E6CD13F07C492006A4E07CF7C3")
    private void addAction(Action a) {
        addTaint(a.getTaint());
    if(mActions == null)        
        {
            mActions = new ArrayList<Action>();
        } //End block
        mActions.add(a);
        a.updateMemoryUsageEstimate(mMemoryUsageCounter);
        // ---------- Original Method ----------
        //if (mActions == null) {
            //mActions = new ArrayList<Action>();
        //}
        //mActions.add(a);
        //a.updateMemoryUsageEstimate(mMemoryUsageCounter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.697 -0400", hash_original_method = "4A1BA0269DB90E506DB0959643DF475B", hash_generated_method = "F7A43FA56B4FD021CADC01BA3EAA2102")
    public void addView(int viewId, RemoteViews nestedView) {
        addTaint(nestedView.getTaint());
        addTaint(viewId);
        addAction(new ViewGroupAction(viewId, nestedView));
        // ---------- Original Method ----------
        //addAction(new ViewGroupAction(viewId, nestedView));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.697 -0400", hash_original_method = "E70CF2F379D754A9B2BAC52704294677", hash_generated_method = "B897667E4F45C435418AB4213365FE91")
    public void removeAllViews(int viewId) {
        addTaint(viewId);
        addAction(new ViewGroupAction(viewId, null));
        // ---------- Original Method ----------
        //addAction(new ViewGroupAction(viewId, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.697 -0400", hash_original_method = "715372503FFB1BBD9EE3BEF4F54CECDE", hash_generated_method = "4FBD4F8680049A52A9E5818E4FE3F5A8")
    public void showNext(int viewId) {
        addTaint(viewId);
        addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
        // ---------- Original Method ----------
        //addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.697 -0400", hash_original_method = "92870339C0CC6AF77A420F74F896E688", hash_generated_method = "91E57EB500EDC89270447F09526DFBC2")
    public void showPrevious(int viewId) {
        addTaint(viewId);
        addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
        // ---------- Original Method ----------
        //addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "D726270A4D4DC2D53B195715D168181D", hash_generated_method = "6971D42E37BDA8AC09932ED350CD8CE2")
    public void setDisplayedChild(int viewId, int childIndex) {
        addTaint(childIndex);
        addTaint(viewId);
        setInt(viewId, "setDisplayedChild", childIndex);
        // ---------- Original Method ----------
        //setInt(viewId, "setDisplayedChild", childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "DEE52A50DF8AF905161D8440F9C7FD6B", hash_generated_method = "1318BD859544A9FCC79C172EBB7DE41F")
    public void setViewVisibility(int viewId, int visibility) {
        addTaint(visibility);
        addTaint(viewId);
        setInt(viewId, "setVisibility", visibility);
        // ---------- Original Method ----------
        //setInt(viewId, "setVisibility", visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "5F8A789C1791A65B082D971694A97107", hash_generated_method = "A9E0DAEF74E814F2442CBF4375B5BDDD")
    public void setTextViewText(int viewId, CharSequence text) {
        addTaint(text.getTaint());
        addTaint(viewId);
        setCharSequence(viewId, "setText", text);
        // ---------- Original Method ----------
        //setCharSequence(viewId, "setText", text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "BA7406E13895A91025A0507F41BF6313", hash_generated_method = "90A83621EA6761D2247890C234BF57ED")
    public void setImageViewResource(int viewId, int srcId) {
        addTaint(srcId);
        addTaint(viewId);
        setInt(viewId, "setImageResource", srcId);
        // ---------- Original Method ----------
        //setInt(viewId, "setImageResource", srcId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "433DFD276FBB02E0D7A2B8DA3B0F08D8", hash_generated_method = "A214AC9C0996343A91C0F5E76CBAA841")
    public void setImageViewUri(int viewId, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(viewId);
        setUri(viewId, "setImageURI", uri);
        // ---------- Original Method ----------
        //setUri(viewId, "setImageURI", uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "957E8B822330AC731DF30A1543908B02", hash_generated_method = "EE418AE44F15DD1ADBE2D590F910876E")
    public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        addTaint(bitmap.getTaint());
        addTaint(viewId);
        setBitmap(viewId, "setImageBitmap", bitmap);
        // ---------- Original Method ----------
        //setBitmap(viewId, "setImageBitmap", bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "4F3E7FFD56A31D2F2A8813C161A91D32", hash_generated_method = "A91083CEAA9EA8D5E229884041C6C1D4")
    public void setEmptyView(int viewId, int emptyViewId) {
        addTaint(emptyViewId);
        addTaint(viewId);
        addAction(new SetEmptyView(viewId, emptyViewId));
        // ---------- Original Method ----------
        //addAction(new SetEmptyView(viewId, emptyViewId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.698 -0400", hash_original_method = "47E59AC623A4BD9BB48A3F2CB501DFB4", hash_generated_method = "8072C49A910830FEDDA172DCA07EE8C8")
    public void setChronometer(int viewId, long base, String format, boolean started) {
        addTaint(started);
        addTaint(format.getTaint());
        addTaint(base);
        addTaint(viewId);
        setLong(viewId, "setBase", base);
        setString(viewId, "setFormat", format);
        setBoolean(viewId, "setStarted", started);
        // ---------- Original Method ----------
        //setLong(viewId, "setBase", base);
        //setString(viewId, "setFormat", format);
        //setBoolean(viewId, "setStarted", started);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "A929EFC8DD62C6A3F9A2F8FB0663D928", hash_generated_method = "9A06ABE0C67EC98A498C4E1B99192EE5")
    public void setProgressBar(int viewId, int max, int progress, 
            boolean indeterminate) {
        addTaint(indeterminate);
        addTaint(progress);
        addTaint(max);
        addTaint(viewId);
        setBoolean(viewId, "setIndeterminate", indeterminate);
    if(!indeterminate)        
        {
            setInt(viewId, "setMax", max);
            setInt(viewId, "setProgress", progress);
        } //End block
        // ---------- Original Method ----------
        //setBoolean(viewId, "setIndeterminate", indeterminate);
        //if (!indeterminate) {
            //setInt(viewId, "setMax", max);
            //setInt(viewId, "setProgress", progress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "84C6A4280B6852D03015FA2AE8D65E64", hash_generated_method = "1BDD58796026F83223770BCC795BFF17")
    public void setOnClickPendingIntent(int viewId, PendingIntent pendingIntent) {
        addTaint(pendingIntent.getTaint());
        addTaint(viewId);
        addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
        // ---------- Original Method ----------
        //addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "A434A09AC636025A142B2CC781D07FF1", hash_generated_method = "740FEA23068D37561A480DCF39C1E3EF")
    public void setPendingIntentTemplate(int viewId, PendingIntent pendingIntentTemplate) {
        addTaint(pendingIntentTemplate.getTaint());
        addTaint(viewId);
        addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
        // ---------- Original Method ----------
        //addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "899E714C9944265097024FA544BB7AC2", hash_generated_method = "443FD951F7768975D580B14FB92E9F9D")
    public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        addTaint(fillInIntent.getTaint());
        addTaint(viewId);
        addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
        // ---------- Original Method ----------
        //addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "09A5B1AD4F222B569CE2E6BD5BF01B12", hash_generated_method = "46E1E4FFB2B94304E2534FDDE0544498")
    public void setDrawableParameters(int viewId, boolean targetBackground, int alpha,
            int colorFilter, PorterDuff.Mode mode, int level) {
        addTaint(level);
        addTaint(mode.getTaint());
        addTaint(colorFilter);
        addTaint(alpha);
        addTaint(targetBackground);
        addTaint(viewId);
        addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                colorFilter, mode, level));
        // ---------- Original Method ----------
        //addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                //colorFilter, mode, level));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "F51B3B3FB58685A967056786739D5D5A", hash_generated_method = "A651DE72B3603D07F38918CA7357B7C9")
    public void setTextColor(int viewId, int color) {
        addTaint(color);
        addTaint(viewId);
        setInt(viewId, "setTextColor", color);
        // ---------- Original Method ----------
        //setInt(viewId, "setTextColor", color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.699 -0400", hash_original_method = "F3196C5DB537F18A0B70CAAF74A09A0A", hash_generated_method = "7BA5642C25529CE983AA71D42830C192")
    @Deprecated
    public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        addTaint(intent.getTaint());
        addTaint(viewId);
        addTaint(appWidgetId);
        setRemoteAdapter(viewId, intent);
        // ---------- Original Method ----------
        //setRemoteAdapter(viewId, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "9F000F17F0336123DB5D1DD3E4F67BE6", hash_generated_method = "20BE7F1E719B3AD314419FA046E7DC4A")
    public void setRemoteAdapter(int viewId, Intent intent) {
        addTaint(intent.getTaint());
        addTaint(viewId);
        addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
        // ---------- Original Method ----------
        //addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "15753F5F29C6091CCB595496C38B1963", hash_generated_method = "9804635A7776A605A4194FC36DA603A1")
    public void setScrollPosition(int viewId, int position) {
        addTaint(position);
        addTaint(viewId);
        setInt(viewId, "smoothScrollToPosition", position);
        // ---------- Original Method ----------
        //setInt(viewId, "smoothScrollToPosition", position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "62C951046FF905CA4D61721F847C4DC5", hash_generated_method = "189CB013D9D4C67506872A34477E2B40")
    public void setRelativeScrollPosition(int viewId, int offset) {
        addTaint(offset);
        addTaint(viewId);
        setInt(viewId, "smoothScrollByOffset", offset);
        // ---------- Original Method ----------
        //setInt(viewId, "smoothScrollByOffset", offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "ACF50C9E2E7A3E77B399A3E9AD77138B", hash_generated_method = "0729759768EE2E8619D811BF3DD65869")
    public void setBoolean(int viewId, String methodName, boolean value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "6577642D84CE42EC3FAE93CD4A676A48", hash_generated_method = "1279E6B29577C3483AAB29C8AF16D232")
    public void setByte(int viewId, String methodName, byte value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "1EF837BE87322E5A782B07EBE8F017ED", hash_generated_method = "D056147F096F9327C17B735728911645")
    public void setShort(int viewId, String methodName, short value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "2BA2097F7597ED476DFE96444FF2B47B", hash_generated_method = "7425AD8F55555CB33DCF7007BED20049")
    public void setInt(int viewId, String methodName, int value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.700 -0400", hash_original_method = "7BBB498795ABAEC2FC5C9E80D1FF1F8F", hash_generated_method = "B0DD8A6DBF5BAE025384B554F8A6A3A0")
    public void setLong(int viewId, String methodName, long value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "877DFBEE5EFFB4333EA4E3E01D628209", hash_generated_method = "FA040A8921F05DAB93CF3EBA931523DA")
    public void setFloat(int viewId, String methodName, float value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "36511416C0ED3D737A57750DB7E0C821", hash_generated_method = "38D66894CB60146F8D5F318CFC8EE661")
    public void setDouble(int viewId, String methodName, double value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "E7DFE8EB27DC5DF6C76291F003DE876E", hash_generated_method = "EBBB1EDE5F5BA12A72FA6F69686C6198")
    public void setChar(int viewId, String methodName, char value) {
        addTaint(value);
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "12B33E0B58F238F52279DFEB1871046D", hash_generated_method = "39E50059B4D9E5EFDA54E18DAB1A08B2")
    public void setString(int viewId, String methodName, String value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "93A93353A27881B93F029E1CB8E38561", hash_generated_method = "DF70442EE54FBEC687A8B7E350E84DF9")
    public void setCharSequence(int viewId, String methodName, CharSequence value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "33EE202B45F16FA5012E7C802B1E1162", hash_generated_method = "A8B80A8412E3D4F82C72D8EC50F3976E")
    public void setUri(int viewId, String methodName, Uri value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "BE18885A2548A0B5EB1C1E6420A7D63A", hash_generated_method = "559BB7945E4504A3E5CDA29CC02DE905")
    public void setBitmap(int viewId, String methodName, Bitmap value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "0BCEFBE1ECC6F937E30E64CCDC160671", hash_generated_method = "A5FF6C066C1F6DC00BAAFF501E61FC56")
    public void setBundle(int viewId, String methodName, Bundle value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.701 -0400", hash_original_method = "1536FDACAD3B90F5944D61240D2247D6", hash_generated_method = "E7890A3CCB40E6A03DC49D0997111D88")
    public void setIntent(int viewId, String methodName, Intent value) {
        addTaint(value.getTaint());
        addTaint(methodName.getTaint());
        addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "DAF30AB9823DD59C17B2FD226E498806", hash_generated_method = "1FE2AC7A0E70234A140197AF9EECC2D7")
    public void setContentDescription(int viewId, CharSequence contentDescription) {
        addTaint(contentDescription.getTaint());
        addTaint(viewId);
        setCharSequence(viewId, "setContentDescription", contentDescription);
        // ---------- Original Method ----------
        //setCharSequence(viewId, "setContentDescription", contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "389CE470D5FBF8918932B7CDEB2F38A1", hash_generated_method = "DFB79007C3C93A0BFA56D8BEB2284515")
    public View apply(Context context, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(context.getTaint());
        View result;
        Context c = prepareContext(context);
        LayoutInflater inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater = inflater.cloneInContext(c);
        inflater.setFilter(this);
        result = inflater.inflate(mLayoutId, parent, false);
        performApply(result, parent);
View varDC838461EE2FA0CA4C9BBB70A15456B0_748157610 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_748157610.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_748157610;
        // ---------- Original Method ----------
        //View result;
        //Context c = prepareContext(context);
        //LayoutInflater inflater = (LayoutInflater)
                //c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater = inflater.cloneInContext(c);
        //inflater.setFilter(this);
        //result = inflater.inflate(mLayoutId, parent, false);
        //performApply(result, parent);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "721D0331C9411BF86340BE2E97293121", hash_generated_method = "69223AB8BA112CE672EE71C9094EAB66")
    public void reapply(Context context, View v) {
        addTaint(v.getTaint());
        addTaint(context.getTaint());
        prepareContext(context);
        performApply(v, (ViewGroup) v.getParent());
        // ---------- Original Method ----------
        //prepareContext(context);
        //performApply(v, (ViewGroup) v.getParent());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "8E5E3E88ABCC69E3321D1346316340C9", hash_generated_method = "98B120172AB8CDD4F398848FD6B7F5E5")
    private void performApply(View v, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(v.getTaint());
    if(mActions != null)        
        {
            final int count = mActions.size();
for(int i = 0;i < count;i++)
            {
                Action a = mActions.get(i);
                a.apply(v, parent);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mActions != null) {
            //final int count = mActions.size();
            //for (int i = 0; i < count; i++) {
                //Action a = mActions.get(i);
                //a.apply(v, parent);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "22DA97EA1494F0F193EF18C8ED8C5634", hash_generated_method = "46B853711E1DA89E26A1DC8C5FBDADE8")
    private Context prepareContext(Context context) {
        addTaint(context.getTaint());
        Context c;
        String packageName = mPackage;
    if(packageName != null)        
        {
            try 
            {
                c = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            } //End block
            catch (NameNotFoundException e)
            {
                c = context;
            } //End block
        } //End block
        else
        {
            c = context;
        } //End block
Context var807FB10045EE51C06BDB74744A6714DF_1573408397 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1573408397.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1573408397;
        // ---------- Original Method ----------
        //Context c;
        //String packageName = mPackage;
        //if (packageName != null) {
            //try {
                //c = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            //} catch (NameNotFoundException e) {
                //Log.e(LOG_TAG, "Package name " + packageName + " not found");
                //c = context;
            //}
        //} else {
            //c = context;
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.702 -0400", hash_original_method = "02A046D25F4E9D374E474E21F6366163", hash_generated_method = "2AC4A5261B1C829B7896C4C83F48B7A0")
    public boolean onLoadClass(Class clazz) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(clazz.getTaint());
        boolean var150E6783CEAB2778A42882A1500631E2_1979438129 = (clazz.isAnnotationPresent(RemoteView.class));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192093319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192093319;
        // ---------- Original Method ----------
        //return clazz.isAnnotationPresent(RemoteView.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.703 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C2B5C7078C85F582376FFA02ED2921BD")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1732139106 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813689256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813689256;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.703 -0400", hash_original_method = "E42048CF3CAA5A680CE684B09E27CD46", hash_generated_method = "486236D4B56BE0495CC3002C9FADA0D6")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mPackage);
        dest.writeInt(mLayoutId);
        dest.writeInt(mIsWidgetCollectionChild ? 1 : 0);
        int count;
    if(mActions != null)        
        {
            count = mActions.size();
        } //End block
        else
        {
            count = 0;
        } //End block
        dest.writeInt(count);
for(int i=0;i<count;i++)
        {
            Action a = mActions.get(i);
            a.writeToParcel(dest, 0);
        } //End block
        // ---------- Original Method ----------
        //dest.writeString(mPackage);
        //dest.writeInt(mLayoutId);
        //dest.writeInt(mIsWidgetCollectionChild ? 1 : 0);
        //int count;
        //if (mActions != null) {
            //count = mActions.size();
        //} else {
            //count = 0;
        //}
        //dest.writeInt(count);
        //for (int i=0; i<count; i++) {
            //Action a = mActions.get(i);
            //a.writeToParcel(dest, 0);
        //}
    }

    
    public static class ActionException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.703 -0400", hash_original_method = "4338C0B6ED05990B68F77B56C502C8BC", hash_generated_method = "6A9B199E4B70296D28CD039E0E15FE3D")
        public  ActionException(Exception ex) {
            super(ex);
            addTaint(ex.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.703 -0400", hash_original_method = "E5DD8B85C6FF17BD695A219FDD405D42", hash_generated_method = "947B27CB5701852C6B41A566481318D7")
        public  ActionException(String message) {
            super(message);
            addTaint(message.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private abstract static class Action implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.703 -0400", hash_original_method = "6EEA56B449227AEBD2AEF88874F9C864", hash_generated_method = "6EEA56B449227AEBD2AEF88874F9C864")
        public Action ()
        {
            //Synthesized constructor
        }


        public abstract void apply(View root, ViewGroup rootParent) throws ActionException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DB069259F8D53E119C2DB062CB2B8A2A")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1722423250 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522907395 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522907395;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_method = "F71AEDBFF608C755FB28C9D45BA8F347", hash_generated_method = "9A7E1CFD3CC84E49A82E0C1CD56BAC36")
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            addTaint(counter.getTaint());
            return;
            // ---------- Original Method ----------
            //return;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_method = "18203BE61B7EF9CD6501BEC6EAEF8812", hash_generated_method = "387334943AA0FBF6331A76AA58BC8696")
        protected boolean startIntentSafely(Context context, PendingIntent pendingIntent,
                Intent fillInIntent) {
            addTaint(fillInIntent.getTaint());
            addTaint(pendingIntent.getTaint());
            addTaint(context.getTaint());
            try 
            {
                context.startIntentSender(
                        pendingIntent.getIntentSender(), fillInIntent,
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_NEW_TASK, 0);
            } //End block
            catch (IntentSender.SendIntentException e)
            {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent: ", e);
                boolean var68934A3E9455FA72420237EB05902327_897750396 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103426958 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103426958;
            } //End block
            catch (Exception e)
            {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent due to " +
                        "unknown exception: ", e);
                boolean var68934A3E9455FA72420237EB05902327_1126413562 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795511772 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795511772;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1362285527 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390923673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390923673;
            // ---------- Original Method ----------
            //try {
                //context.startIntentSender(
                        //pendingIntent.getIntentSender(), fillInIntent,
                        //Intent.FLAG_ACTIVITY_NEW_TASK,
                        //Intent.FLAG_ACTIVITY_NEW_TASK, 0);
            //} catch (IntentSender.SendIntentException e) {
                //android.util.Log.e(LOG_TAG, "Cannot send pending intent: ", e);
                //return false;
            //} catch (Exception e) {
                //android.util.Log.e(LOG_TAG, "Cannot send pending intent due to " +
                        //"unknown exception: ", e);
                //return false;
            //}
            //return true;
        }

        
    }


    
    private class SetEmptyView extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_field = "23D13A84EF4F7189027D73EC6744F6E8", hash_generated_field = "8D3D66B4863E42DCDD06D3EE8F80E8F7")

        int emptyViewId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.704 -0400", hash_original_method = "16159C50F4CD599B644ED014E4EA0822", hash_generated_method = "C1C4A274A58AFAF2063BE98C3846BAE4")
          SetEmptyView(int viewId, int emptyViewId) {
            this.viewId = viewId;
            this.emptyViewId = emptyViewId;
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.emptyViewId = emptyViewId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "F10F16648F57CF9FE4F3D806E803B1DC", hash_generated_method = "0CB8CADFFD90BE29657F9D6DCA52C11C")
          SetEmptyView(Parcel in) {
            this.viewId = in.readInt();
            this.emptyViewId = in.readInt();
            // ---------- Original Method ----------
            //this.viewId = in.readInt();
            //this.emptyViewId = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "1EA9A4CD3E90F19D62658919976BDCDF", hash_generated_method = "BDCDEB835159FF3D8B6EC5654A2FCE19")
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeInt(this.emptyViewId);
            // ---------- Original Method ----------
            //out.writeInt(TAG);
            //out.writeInt(this.viewId);
            //out.writeInt(this.emptyViewId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "BC00C709904F6A7A06083DBEA360E136", hash_generated_method = "57D305BFC46269920AF6142E85B3F68F")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View view = root.findViewById(viewId);
    if(!(view instanceof AdapterView<?>))            
            return;
            AdapterView<?> adapterView = (AdapterView<?>) view;
            final View emptyView = root.findViewById(emptyViewId);
    if(emptyView == null)            
            return;
            adapterView.setEmptyView(emptyView);
            // ---------- Original Method ----------
            //final View view = root.findViewById(viewId);
            //if (!(view instanceof AdapterView<?>)) return;
            //AdapterView<?> adapterView = (AdapterView<?>) view;
            //final View emptyView = root.findViewById(emptyViewId);
            //if (emptyView == null) return;
            //adapterView.setEmptyView(emptyView);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_field = "9C473E90A5431830598CA413D5D4F376", hash_generated_field = "832C8F64E214207268768E39D7FCB9F3")

        public final static int TAG = 6;
    }


    
    private class SetOnClickFillInIntent extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_field = "3BCE79238D517725ED23615F7B7237D8", hash_generated_field = "9D3AB3AC0219EE64EF3FF80AB068BB5E")

        Intent fillInIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "FE3667D87A305D86E9A8A6AD36F5EEAF", hash_generated_method = "18AF1F9FD9414C6BCF3DBFD2F1D4F53B")
        public  SetOnClickFillInIntent(int id, Intent fillInIntent) {
            this.viewId = id;
            this.fillInIntent = fillInIntent;
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.fillInIntent = fillInIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "8F893000547B59EAD09450FBC024CAC1", hash_generated_method = "D68C613EB9756E36CE15A86322799F88")
        public  SetOnClickFillInIntent(Parcel parcel) {
            viewId = parcel.readInt();
            fillInIntent = Intent.CREATOR.createFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //fillInIntent = Intent.CREATOR.createFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.705 -0400", hash_original_method = "4A68D926F0B47E5C592025763C57CD49", hash_generated_method = "7DF2206EA6761B29E294427DDFA70EE9")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            fillInIntent.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //fillInIntent.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_method = "3474C680008284CA3FCD2C734DB61ED8", hash_generated_method = "AFFFC75621C5B797EAA769D2E4B76D93")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View target = root.findViewById(viewId);
    if(target == null)            
            return;
    if(!mIsWidgetCollectionChild)            
            {
                return;
            } //End block
    if(target == root)            
            {
                target.setTagInternal(com.android.internal.R.id.fillInIntent, fillInIntent);
            } //End block
            else
    if(target != null && fillInIntent != null)            
            {
                OnClickListener listener = new OnClickListener() {
                    public void onClick(View v) {
                        View parent = (View) v.getParent();
                        while (!(parent instanceof AdapterView<?>)
                                && !(parent instanceof AppWidgetHostView)) {
                            parent = (View) parent.getParent();
                        }
                        if (parent instanceof AppWidgetHostView) {
                            Log.e("RemoteViews", "Collection item doesn't have AdapterView parent");
                            return;
                        }
                        if (!(parent.getTag() instanceof PendingIntent)) {
                            Log.e("RemoteViews", "Attempting setOnClickFillInIntent without" +
                                    " calling setPendingIntentTemplate on parent.");
                            return;
                        }
                        PendingIntent pendingIntent = (PendingIntent) parent.getTag();
                        final float appScale = v.getContext().getResources()
                                .getCompatibilityInfo().applicationScale;
                        final int[] pos = new int[2];
                        v.getLocationOnScreen(pos);
                        final Rect rect = new Rect();
                        rect.left = (int) (pos[0] * appScale + 0.5f);
                        rect.top = (int) (pos[1] * appScale + 0.5f);
                        rect.right = (int) ((pos[0] + v.getWidth()) * appScale + 0.5f);
                        rect.bottom = (int) ((pos[1] + v.getHeight()) * appScale + 0.5f);
                        fillInIntent.setSourceBounds(rect);
                        startIntentSafely(v.getContext(), pendingIntent, fillInIntent);
                    }
                };
                target.setOnClickListener(listener);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_field = "D91A2B10EDD4F80880F9239AF8DAACE6", hash_generated_field = "257D5F310A82D1AE988E43617C7394F4")

        public final static int TAG = 9;
        // orphaned legacy method
        public void onClick(View v) {
                        View parent = (View) v.getParent();
                        while (!(parent instanceof AdapterView<?>)
                                && !(parent instanceof AppWidgetHostView)) {
                            parent = (View) parent.getParent();
                        }
                        if (parent instanceof AppWidgetHostView) {
                            Log.e("RemoteViews", "Collection item doesn't have AdapterView parent");
                            return;
                        }
                        if (!(parent.getTag() instanceof PendingIntent)) {
                            Log.e("RemoteViews", "Attempting setOnClickFillInIntent without" +
                                    " calling setPendingIntentTemplate on parent.");
                            return;
                        }
                        PendingIntent pendingIntent = (PendingIntent) parent.getTag();
                        final float appScale = v.getContext().getResources()
                                .getCompatibilityInfo().applicationScale;
                        final int[] pos = new int[2];
                        v.getLocationOnScreen(pos);
                        final Rect rect = new Rect();
                        rect.left = (int) (pos[0] * appScale + 0.5f);
                        rect.top = (int) (pos[1] * appScale + 0.5f);
                        rect.right = (int) ((pos[0] + v.getWidth()) * appScale + 0.5f);
                        rect.bottom = (int) ((pos[1] + v.getHeight()) * appScale + 0.5f);
                        fillInIntent.setSourceBounds(rect);
                        startIntentSafely(v.getContext(), pendingIntent, fillInIntent);
                    }
        
    }


    
    private class SetPendingIntentTemplate extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_field = "176E2FA2A8B62FAC39A0DD8CC7A328C0", hash_generated_field = "D0EA5F86DAC5B859FF411BE20B81D705")

        PendingIntent pendingIntentTemplate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_method = "319DBBF9EE021BC2BD14552E08C5F806", hash_generated_method = "D7A3DCE3AD9BD409E6F2A6466125223B")
        public  SetPendingIntentTemplate(int id, PendingIntent pendingIntentTemplate) {
            this.viewId = id;
            this.pendingIntentTemplate = pendingIntentTemplate;
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.pendingIntentTemplate = pendingIntentTemplate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.706 -0400", hash_original_method = "F35BA9665B1C6E88223062D1328FA579", hash_generated_method = "DD0B2CD3748A8B20A1DE310050B42710")
        public  SetPendingIntentTemplate(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_method = "2DE56D1052D41AEA85684029786EA581", hash_generated_method = "04D29CFB7CE01C81A1025050CF72DF16")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntentTemplate.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //pendingIntentTemplate.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_method = "BC6383FD3782B4E4299FBBF52DF5CBB4", hash_generated_method = "372E487691811E9C244E2E4385245940")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View target = root.findViewById(viewId);
    if(target == null)            
            return;
    if(target instanceof AdapterView<?>)            
            {
                AdapterView<?> av = (AdapterView<?>) target;
                OnItemClickListener listener = new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                        if (view instanceof ViewGroup) {
                            ViewGroup vg = (ViewGroup) view;
                            if (parent instanceof AdapterViewAnimator) {
                                vg = (ViewGroup) vg.getChildAt(0);
                            }
                            if (vg == null) return;
                            Intent fillInIntent = null;
                            int childCount = vg.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                Object tag = vg.getChildAt(i).getTag(com.android.internal.R.id.fillInIntent);
                                if (tag instanceof Intent) {
                                    fillInIntent = (Intent) tag;
                                    break;
                                }
                            }
                            if (fillInIntent == null) return;
                            final float appScale = view.getContext().getResources()
                                    .getCompatibilityInfo().applicationScale;
                            final int[] pos = new int[2];
                            view.getLocationOnScreen(pos);
                            final Rect rect = new Rect();
                            rect.left = (int) (pos[0] * appScale + 0.5f);
                            rect.top = (int) (pos[1] * appScale + 0.5f);
                            rect.right = (int) ((pos[0] + view.getWidth()) * appScale + 0.5f);
                            rect.bottom = (int) ((pos[1] + view.getHeight()) * appScale + 0.5f);
                            final Intent intent = new Intent();
                            intent.setSourceBounds(rect);
                            startIntentSafely(view.getContext(), pendingIntentTemplate, fillInIntent);
                        }
                    }
                };
                av.setOnItemClickListener(listener);
                av.setTag(pendingIntentTemplate);
            } //End block
            else
            {
                return;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_field = "6065CCBD64FD6BA819686C609CBF3FA3", hash_generated_field = "999B6A111CF47CD01BFB86C10E0DFDAF")

        public final static int TAG = 8;
        // orphaned legacy method
        public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                        if (view instanceof ViewGroup) {
                            ViewGroup vg = (ViewGroup) view;
                            if (parent instanceof AdapterViewAnimator) {
                                vg = (ViewGroup) vg.getChildAt(0);
                            }
                            if (vg == null) return;
                            Intent fillInIntent = null;
                            int childCount = vg.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                Object tag = vg.getChildAt(i).getTag(com.android.internal.R.id.fillInIntent);
                                if (tag instanceof Intent) {
                                    fillInIntent = (Intent) tag;
                                    break;
                                }
                            }
                            if (fillInIntent == null) return;
                            final float appScale = view.getContext().getResources()
                                    .getCompatibilityInfo().applicationScale;
                            final int[] pos = new int[2];
                            view.getLocationOnScreen(pos);
                            final Rect rect = new Rect();
                            rect.left = (int) (pos[0] * appScale + 0.5f);
                            rect.top = (int) (pos[1] * appScale + 0.5f);
                            rect.right = (int) ((pos[0] + view.getWidth()) * appScale + 0.5f);
                            rect.bottom = (int) ((pos[1] + view.getHeight()) * appScale + 0.5f);
                            final Intent intent = new Intent();
                            intent.setSourceBounds(rect);
                            startIntentSafely(view.getContext(), pendingIntentTemplate, fillInIntent);
                        }
                    }
        
    }


    
    private class SetRemoteViewsAdapterIntent extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_method = "2562242EF5AD42CD0339F4CFA0A5651B", hash_generated_method = "4D41B794CEB49FBFDACF661D08DF1C0D")
        public  SetRemoteViewsAdapterIntent(int id, Intent intent) {
            this.viewId = id;
            this.intent = intent;
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.intent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_method = "3062D841F9A527FF82C19CE8ED4DF47C", hash_generated_method = "79C217E5E76E9F79C11955E3F453D87B")
        public  SetRemoteViewsAdapterIntent(Parcel parcel) {
            viewId = parcel.readInt();
            intent = Intent.CREATOR.createFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //intent = Intent.CREATOR.createFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.707 -0400", hash_original_method = "F580FE61025C5DC81DFB7BB9EA905954", hash_generated_method = "016F1F527D26D95A60C8146E075DE2F2")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            intent.writeToParcel(dest, flags);
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //intent.writeToParcel(dest, flags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_method = "EDE9247E350EBAB87917A7616D3465DB", hash_generated_method = "8B5EE078B6EA174FC25483D5993A8317")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View target = root.findViewById(viewId);
    if(target == null)            
            return;
    if(!(rootParent instanceof AppWidgetHostView))            
            {
                return;
            } //End block
    if(!(target instanceof AbsListView) && !(target instanceof AdapterViewAnimator))            
            {
                return;
            } //End block
            AppWidgetHostView host = (AppWidgetHostView) rootParent;
            intent.putExtra(EXTRA_REMOTEADAPTER_APPWIDGET_ID, host.getAppWidgetId());
    if(target instanceof AbsListView)            
            {
                AbsListView v = (AbsListView) target;
                v.setRemoteViewsAdapter(intent);
            } //End block
            else
    if(target instanceof AdapterViewAnimator)            
            {
                AdapterViewAnimator v = (AdapterViewAnimator) target;
                v.setRemoteViewsAdapter(intent);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_field = "454319544DE430D1FE4AE42999579103", hash_generated_field = "8FE5A8285A40B3CDB587BD72B1510F3F")

        public final static int TAG = 10;
    }


    
    private class SetOnClickPendingIntent extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_field = "2FACCE917278B302FB28C98EBAEC216A", hash_generated_field = "7026E183996B4AEE13A8653E0B37928C")

        PendingIntent pendingIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_method = "66EA2688C4B0F29524FFED0B8D1C4557", hash_generated_method = "DE4E1C8802A6B5161427D208A788FF49")
        public  SetOnClickPendingIntent(int id, PendingIntent pendingIntent) {
            this.viewId = id;
            this.pendingIntent = pendingIntent;
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.pendingIntent = pendingIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_method = "2D335FA6E397EB90FCE69134FAC6C0E6", hash_generated_method = "7AF4DFE20455952984B5C6A7CBCA2E14")
        public  SetOnClickPendingIntent(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_method = "7CEF806B95F0881A888E5DFCE712AF4A", hash_generated_method = "669E8E8A97200FDEA6D39BD77054A4D2")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntent.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //pendingIntent.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.708 -0400", hash_original_method = "7AB558D2EB1905941BBC96768E4F0260", hash_generated_method = "49B19E7FC5F758B6D26E03320AFB8136")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View target = root.findViewById(viewId);
    if(target == null)            
            return;
    if(mIsWidgetCollectionChild)            
            {
            } //End block
    if(target != null && pendingIntent != null)            
            {
                OnClickListener listener = new OnClickListener() {
                    public void onClick(View v) {
                        final float appScale = v.getContext().getResources()
                                .getCompatibilityInfo().applicationScale;
                        final int[] pos = new int[2];
                        v.getLocationOnScreen(pos);
                        final Rect rect = new Rect();
                        rect.left = (int) (pos[0] * appScale + 0.5f);
                        rect.top = (int) (pos[1] * appScale + 0.5f);
                        rect.right = (int) ((pos[0] + v.getWidth()) * appScale + 0.5f);
                        rect.bottom = (int) ((pos[1] + v.getHeight()) * appScale + 0.5f);
                        final Intent intent = new Intent();
                        intent.setSourceBounds(rect);
                        startIntentSafely(v.getContext(), pendingIntent, intent);
                    }
                };
                target.setOnClickListener(listener);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "300A66DF77BAB65489ADB988403DB41B", hash_generated_field = "993712AACA5BFFF68C7775B3C6B7EE8B")

        public final static int TAG = 1;
        // orphaned legacy method
        public void onClick(View v) {
                        final float appScale = v.getContext().getResources()
                                .getCompatibilityInfo().applicationScale;
                        final int[] pos = new int[2];
                        v.getLocationOnScreen(pos);
                        final Rect rect = new Rect();
                        rect.left = (int) (pos[0] * appScale + 0.5f);
                        rect.top = (int) (pos[1] * appScale + 0.5f);
                        rect.right = (int) ((pos[0] + v.getWidth()) * appScale + 0.5f);
                        rect.bottom = (int) ((pos[1] + v.getHeight()) * appScale + 0.5f);
                        final Intent intent = new Intent();
                        intent.setSourceBounds(rect);
                        startIntentSafely(v.getContext(), pendingIntent, intent);
                    }
        
    }


    
    private class SetDrawableParameters extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "A2AB643A05537436635D1E7D1C7AE662", hash_generated_field = "348353981961A3507DF6BC6E23EBAF56")

        boolean targetBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "2C1743A391305FBF367DF8E4F069F9F9", hash_generated_field = "1B559E55B8F17D21F08DC11CC377988E")

        int alpha;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "430580F08459C4E5E775DF0C2447C4DA", hash_generated_field = "1B107E6823167B68C4A8FA578E72F2B9")

        int colorFilter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "93065ABDC7B96A0A146EC1937D38C277", hash_generated_field = "1E0353AC2D4FEC5D3F86FBF63BA71A1F")

        PorterDuff.Mode filterMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "6C23DC7E65CEAB9FBA953CF49B6B6875")

        int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_method = "18564016E13252E4F53F65794EE2D4BB", hash_generated_method = "5A814AA3D1EB7D235731941FAE0DA595")
        public  SetDrawableParameters(int id, boolean targetBackground, int alpha,
                int colorFilter, PorterDuff.Mode mode, int level) {
            this.viewId = id;
            this.targetBackground = targetBackground;
            this.alpha = alpha;
            this.colorFilter = colorFilter;
            this.filterMode = mode;
            this.level = level;
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.targetBackground = targetBackground;
            //this.alpha = alpha;
            //this.colorFilter = colorFilter;
            //this.filterMode = mode;
            //this.level = level;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.709 -0400", hash_original_method = "72E671F08A71584E9232C176B97BC1C8", hash_generated_method = "87A8F3CEF028F9E6345FF186CA6BC012")
        public  SetDrawableParameters(Parcel parcel) {
            viewId = parcel.readInt();
            targetBackground = parcel.readInt() != 0;
            alpha = parcel.readInt();
            colorFilter = parcel.readInt();
            boolean hasMode = parcel.readInt() != 0;
    if(hasMode)            
            {
                filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            } //End block
            else
            {
                filterMode = null;
            } //End block
            level = parcel.readInt();
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //targetBackground = parcel.readInt() != 0;
            //alpha = parcel.readInt();
            //colorFilter = parcel.readInt();
            //boolean hasMode = parcel.readInt() != 0;
            //if (hasMode) {
                //filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            //} else {
                //filterMode = null;
            //}
            //level = parcel.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.711 -0400", hash_original_method = "DC629CA06C171381152FF8641B977C9F", hash_generated_method = "97F80C563C92885818073A9A30F0E83D")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeInt(targetBackground ? 1 : 0);
            dest.writeInt(alpha);
            dest.writeInt(colorFilter);
    if(filterMode != null)            
            {
                dest.writeInt(1);
                dest.writeString(filterMode.toString());
            } //End block
            else
            {
                dest.writeInt(0);
            } //End block
            dest.writeInt(level);
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //dest.writeInt(targetBackground ? 1 : 0);
            //dest.writeInt(alpha);
            //dest.writeInt(colorFilter);
            //if (filterMode != null) {
                //dest.writeInt(1);
                //dest.writeString(filterMode.toString());
            //} else {
                //dest.writeInt(0);
            //}
            //dest.writeInt(level);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.711 -0400", hash_original_method = "2B7DD23B0EB7FE8C6A2446FEC1367E7F", hash_generated_method = "A9181765027AEE33CBB43C7EE83F6582")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View target = root.findViewById(viewId);
    if(target == null)            
            return;
            Drawable targetDrawable = null;
    if(targetBackground)            
            {
                targetDrawable = target.getBackground();
            } //End block
            else
    if(target instanceof ImageView)            
            {
                ImageView imageView = (ImageView) target;
                targetDrawable = imageView.getDrawable();
            } //End block
    if(targetDrawable != null)            
            {
    if(alpha != -1)                
                {
                    targetDrawable.setAlpha(alpha);
                } //End block
    if(colorFilter != -1 && filterMode != null)                
                {
                    targetDrawable.setColorFilter(colorFilter, filterMode);
                } //End block
    if(level != -1)                
                {
                    targetDrawable.setLevel(level);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.711 -0400", hash_original_field = "6F4A6F730922DE22412A2E7EBF673639", hash_generated_field = "22845C1BD5EB1EFAC44EDEF6B7BDA751")

        public final static int TAG = 3;
    }


    
    private class ReflectionActionWithoutParams extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.711 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.711 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.712 -0400", hash_original_method = "9825933434EF5EC003AA8FF50203783A", hash_generated_method = "306E4CE94A121FCAD55ED69BD6877BBC")
          ReflectionActionWithoutParams(int viewId, String methodName) {
            this.viewId = viewId;
            this.methodName = methodName;
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.methodName = methodName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.713 -0400", hash_original_method = "07A57AEC1ECBD4F4EF962F6964A9C9CB", hash_generated_method = "F389E821077AA3BB95015DCE93F78B32")
          ReflectionActionWithoutParams(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
            // ---------- Original Method ----------
            //this.viewId = in.readInt();
            //this.methodName = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_method = "E92934B0244E59AB6D933016F95632D8", hash_generated_method = "EF82BF2749830ED0C3E73118B0688DE4")
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            // ---------- Original Method ----------
            //out.writeInt(TAG);
            //out.writeInt(this.viewId);
            //out.writeString(this.methodName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_method = "B2755AE6CC74346ED57BF443914C2243", hash_generated_method = "CF217B7643D9E8D38AC52A07CF0563DA")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View view = root.findViewById(viewId);
    if(view == null)            
            return;
            Class klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName);
            } //End block
            catch (NoSuchMethodException ex)
            {
                ActionException var4B00E49A1579916E9F08BB92921F0D8C_769977692 = new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "()");
                var4B00E49A1579916E9F08BB92921F0D8C_769977692.addTaint(taint);
                throw var4B00E49A1579916E9F08BB92921F0D8C_769977692;
            } //End block
    if(!method.isAnnotationPresent(RemotableViewMethod.class))            
            {
                ActionException var3FAD6D28944E0ECE936A4662B03FAA31_238010134 = new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "()");
                var3FAD6D28944E0ECE936A4662B03FAA31_238010134.addTaint(taint);
                throw var3FAD6D28944E0ECE936A4662B03FAA31_238010134;
            } //End block
            try 
            {
    if(false)                
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "()");
                } //End block
                method.invoke(view);
            } //End block
            catch (Exception ex)
            {
                ActionException varC7C4CAC5C184D6A69E916B4E5066D46F_424272708 = new ActionException(ex);
                varC7C4CAC5C184D6A69E916B4E5066D46F_424272708.addTaint(taint);
                throw varC7C4CAC5C184D6A69E916B4E5066D46F_424272708;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_field = "DE143BAD1003A83F29229B3A04BAF7B0", hash_generated_field = "03362AF19131C1207E62059104EDE4C5")

        public final static int TAG = 5;
    }


    
    private class ReflectionAction extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "961B4204667A4AE2FF8DD374E6728ADE")

        int type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.714 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.716 -0400", hash_original_method = "C4E3EC196FB78FDD2AFD41CF23C84256", hash_generated_method = "66FBD19134023AF224E81CB8AE41B251")
          ReflectionAction(int viewId, String methodName, int type, Object value) {
            this.viewId = viewId;
            this.methodName = methodName;
            this.type = type;
            this.value = value;
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.methodName = methodName;
            //this.type = type;
            //this.value = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.719 -0400", hash_original_method = "A86C68C4FD8B9D479580CAEA2D14C9BF", hash_generated_method = "A907A784751DE7FA9B61F164632B1167")
          ReflectionAction(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
            this.type = in.readInt();
    if(false)            
            {
                Log.d("RemoteViews", "read viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } //End block
switch(this.type){
            case BOOLEAN:
            this.value = in.readInt() != 0;
            break;
            case BYTE:
            this.value = in.readByte();
            break;
            case SHORT:
            this.value = (short)in.readInt();
            break;
            case INT:
            this.value = in.readInt();
            break;
            case LONG:
            this.value = in.readLong();
            break;
            case FLOAT:
            this.value = in.readFloat();
            break;
            case DOUBLE:
            this.value = in.readDouble();
            break;
            case CHAR:
            this.value = (char)in.readInt();
            break;
            case STRING:
            this.value = in.readString();
            break;
            case CHAR_SEQUENCE:
            this.value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            break;
            case URI:
            this.value = Uri.CREATOR.createFromParcel(in);
            break;
            case BITMAP:
            this.value = Bitmap.CREATOR.createFromParcel(in);
            break;
            case BUNDLE:
            this.value = in.readBundle();
            break;
            case INTENT:
            this.value = Intent.CREATOR.createFromParcel(in);
            break;
            default:
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.719 -0400", hash_original_method = "F759DD8CB1A89B34D073177D219BFFB9", hash_generated_method = "DD017EAFAB6A8D0A0EA9F33E4523F1BF")
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            out.writeInt(this.type);
    if(false)            
            {
                Log.d("RemoteViews", "write viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } //End block
switch(this.type){
            case BOOLEAN:
            out.writeInt((Boolean) this.value ? 1 : 0);
            break;
            case BYTE:
            out.writeByte((Byte) this.value);
            break;
            case SHORT:
            out.writeInt((Short) this.value);
            break;
            case INT:
            out.writeInt((Integer) this.value);
            break;
            case LONG:
            out.writeLong((Long) this.value);
            break;
            case FLOAT:
            out.writeFloat((Float) this.value);
            break;
            case DOUBLE:
            out.writeDouble((Double) this.value);
            break;
            case CHAR:
            out.writeInt((int)((Character)this.value).charValue());
            break;
            case STRING:
            out.writeString((String)this.value);
            break;
            case CHAR_SEQUENCE:
            TextUtils.writeToParcel((CharSequence)this.value, out, flags);
            break;
            case URI:
            ((Uri)this.value).writeToParcel(out, flags);
            break;
            case BITMAP:
            ((Bitmap)this.value).writeToParcel(out, flags);
            break;
            case BUNDLE:
            out.writeBundle((Bundle) this.value);
            break;
            case INTENT:
            ((Intent)this.value).writeToParcel(out, flags);
            break;
            default:
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.720 -0400", hash_original_method = "E66E0BF97844CCF37DCED039A425AFDA", hash_generated_method = "6CA5FE05A88159D9613461A7BA47E257")
        private Class getParameterType() {
switch(this.type){
            case BOOLEAN:
Class var71787BF0A5FAFF61DD7FBBF958D99F8A_225570205 =             boolean.class;
            var71787BF0A5FAFF61DD7FBBF958D99F8A_225570205.addTaint(taint);
            return var71787BF0A5FAFF61DD7FBBF958D99F8A_225570205;
            case BYTE:
Class var7C0ACE62D963137DF2E56A3AE1830737_1508758367 =             byte.class;
            var7C0ACE62D963137DF2E56A3AE1830737_1508758367.addTaint(taint);
            return var7C0ACE62D963137DF2E56A3AE1830737_1508758367;
            case SHORT:
Class var2978261C2ED1639B358207B56E910496_318898899 =             short.class;
            var2978261C2ED1639B358207B56E910496_318898899.addTaint(taint);
            return var2978261C2ED1639B358207B56E910496_318898899;
            case INT:
Class var985DB82401C248C5D9E18F7141DEF72B_1609937503 =             int.class;
            var985DB82401C248C5D9E18F7141DEF72B_1609937503.addTaint(taint);
            return var985DB82401C248C5D9E18F7141DEF72B_1609937503;
            case LONG:
Class var5B79E8CD9A56F609FB5546A9D74A8875_1498908174 =             long.class;
            var5B79E8CD9A56F609FB5546A9D74A8875_1498908174.addTaint(taint);
            return var5B79E8CD9A56F609FB5546A9D74A8875_1498908174;
            case FLOAT:
Class var62B620E9FEA9AE784921F21A57CA37EF_879555661 =             float.class;
            var62B620E9FEA9AE784921F21A57CA37EF_879555661.addTaint(taint);
            return var62B620E9FEA9AE784921F21A57CA37EF_879555661;
            case DOUBLE:
Class varB1058CC7814EF2B7D2C1906F75D80941_1218175836 =             double.class;
            varB1058CC7814EF2B7D2C1906F75D80941_1218175836.addTaint(taint);
            return varB1058CC7814EF2B7D2C1906F75D80941_1218175836;
            case CHAR:
Class var021069F65BBE9A67357BF60BD5069AD9_2139628144 =             char.class;
            var021069F65BBE9A67357BF60BD5069AD9_2139628144.addTaint(taint);
            return var021069F65BBE9A67357BF60BD5069AD9_2139628144;
            case STRING:
Class var150C64354BF575772326FCF473C18575_971050806 =             String.class;
            var150C64354BF575772326FCF473C18575_971050806.addTaint(taint);
            return var150C64354BF575772326FCF473C18575_971050806;
            case CHAR_SEQUENCE:
Class var001C290C1B5DC579C5332BF8629169AD_754031998 =             CharSequence.class;
            var001C290C1B5DC579C5332BF8629169AD_754031998.addTaint(taint);
            return var001C290C1B5DC579C5332BF8629169AD_754031998;
            case URI:
Class varB6D8DC7F84507EECF8A5507F7B373322_990668800 =             Uri.class;
            varB6D8DC7F84507EECF8A5507F7B373322_990668800.addTaint(taint);
            return varB6D8DC7F84507EECF8A5507F7B373322_990668800;
            case BITMAP:
Class varC233717DB020FDC94E8C1BC4B666E704_1578309326 =             Bitmap.class;
            varC233717DB020FDC94E8C1BC4B666E704_1578309326.addTaint(taint);
            return varC233717DB020FDC94E8C1BC4B666E704_1578309326;
            case BUNDLE:
Class var07880C42B3516287136EF6C08635840A_1277765776 =             Bundle.class;
            var07880C42B3516287136EF6C08635840A_1277765776.addTaint(taint);
            return var07880C42B3516287136EF6C08635840A_1277765776;
            case INTENT:
Class varA55A18EAA2E17A4BE1A5DCF60DB9EC1B_1469644826 =             Intent.class;
            varA55A18EAA2E17A4BE1A5DCF60DB9EC1B_1469644826.addTaint(taint);
            return varA55A18EAA2E17A4BE1A5DCF60DB9EC1B_1469644826;
            default:
Class var540C13E9E156B687226421B24F2DF178_253280334 =             null;
            var540C13E9E156B687226421B24F2DF178_253280334.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_253280334;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.720 -0400", hash_original_method = "008B98D7581EEC47326A699C8B3D8035", hash_generated_method = "8FFF3E39381D8AE25ACB9A877EA88420")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final View view = root.findViewById(viewId);
    if(view == null)            
            return;
            Class param = getParameterType();
    if(param == null)            
            {
                ActionException var24C6C16C84E933689E566B3D0088DB60_1389199245 = new ActionException("bad type: " + this.type);
                var24C6C16C84E933689E566B3D0088DB60_1389199245.addTaint(taint);
                throw var24C6C16C84E933689E566B3D0088DB60_1389199245;
            } //End block
            Class klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName, getParameterType());
            } //End block
            catch (NoSuchMethodException ex)
            {
                ActionException var3C7F213007E369444B0A211FA382B9BB_1943240684 = new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "(" + param.getName() + ")");
                var3C7F213007E369444B0A211FA382B9BB_1943240684.addTaint(taint);
                throw var3C7F213007E369444B0A211FA382B9BB_1943240684;
            } //End block
    if(!method.isAnnotationPresent(RemotableViewMethod.class))            
            {
                ActionException var8A089883897B44FBECF7ACEC7A046E2A_515641446 = new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "(" + param.getName() + ")");
                var8A089883897B44FBECF7ACEC7A046E2A_515641446.addTaint(taint);
                throw var8A089883897B44FBECF7ACEC7A046E2A_515641446;
            } //End block
            try 
            {
    if(false)                
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "(" + param.getName() + ") with "
                        + (this.value == null ? "null" : this.value.getClass().getName()));
                } //End block
                method.invoke(view, this.value);
            } //End block
            catch (Exception ex)
            {
                ActionException varC7C4CAC5C184D6A69E916B4E5066D46F_96297314 = new ActionException(ex);
                varC7C4CAC5C184D6A69E916B4E5066D46F_96297314.addTaint(taint);
                throw varC7C4CAC5C184D6A69E916B4E5066D46F_96297314;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_method = "1F301B790026760CE401FF57484A4A78", hash_generated_method = "29838BD01F4A6405258A7FEA96B61663")
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            addTaint(counter.getTaint());
switch(this.type){
            case BITMAP:
    if(this.value != null)            
            {
                final Bitmap b = (Bitmap) this.value;
                final Bitmap.Config c = b.getConfig();
                int bpp = 4;
    if(c != null)                
                {
switch(c){
                    case ALPHA_8:
                    bpp = 1;
                    break;
                    case RGB_565:
                    case ARGB_4444:
                    bpp = 2;
                    break;
                    case ARGB_8888:
                    bpp = 4;
                    break;
}
                } //End block
                counter.bitmapIncrement(b.getWidth() * b.getHeight() * bpp);
            } //End block
            break;
            default:
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

        static final int TAG = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "2F374CAF065C6170DB0655822E60E222", hash_generated_field = "E11DCA29C7BD696B2526B497FF3EAAEC")

        static final int BOOLEAN = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "B4F8B987EF9A0C82A8C8267A98C738F6", hash_generated_field = "A08488B6E820CE04526667A0F65B2358")

        static final int BYTE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "175308D2FBF3B761DF0108367B225AD1", hash_generated_field = "A14B4D783E4BD28B22DF5708F3C91517")

        static final int SHORT = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "A0CB96DABFDCF4947E640C27B00A7309", hash_generated_field = "0D069F30768AEFEA236A6C7BEA66E7F4")

        static final int INT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "8BDB65EA307B4E2D6C3AD9BE937C6B35", hash_generated_field = "B58C5793378449CBE5C2C8BE4F7C6D55")

        static final int LONG = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "200338FA85BEDB28DAC8352AA5AE44A4", hash_generated_field = "46B9B78E20B9DFB9C97B6EB5CDFC1710")

        static final int FLOAT = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "E4100D4E6A32B99A6ED6E650D26B96F2", hash_generated_field = "A4501BC529B3B3B1F619CD5B69F60BEE")

        static final int DOUBLE = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "96FA09B152FC2C89E35AFA1C6505581E", hash_generated_field = "A4E7D9D246B6685E9E73E853EFB843FD")

        static final int CHAR = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "DCF91BC1D8F95A60EADB6F7461F79F2F", hash_generated_field = "E2738C0FD157A27F299AA096F2698ED6")

        static final int STRING = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "05F84E42B3F9A0FC5577C866771D1B45", hash_generated_field = "8B88FAA46496AA9341BA2AC74905D8B7")

        static final int CHAR_SEQUENCE = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.721 -0400", hash_original_field = "5E83DCA62102A3D88F57C136FE6ACEB4", hash_generated_field = "677DE19774DF27A76E4807597BCCE25E")

        static final int URI = 11;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_field = "FC84E30432EF9DDE7E9FCCE78BB199A8", hash_generated_field = "848B8557A665FAFDBC86FEF0A38BE2A4")

        static final int BITMAP = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_field = "F0E8DF40A7799BB61150AD69A1A9F5A0", hash_generated_field = "C2775C8AD4009091E8937A7799C946C2")

        static final int BUNDLE = 13;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_field = "16DB5856FD50B8563BDD95884F5D1670", hash_generated_field = "819B6EFDD2B1951BA1F12E14D3F5638F")

        static final int INTENT = 14;
    }


    
    private class ViewGroupAction extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_field = "27197E3E0B6B9B7BF6E9F835C5A0621D", hash_generated_field = "94DAE06500F0010791F8161444D05A58")

        RemoteViews nestedViews;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.722 -0400", hash_original_method = "ED007F9070164016B2129A58A247A132", hash_generated_method = "D73E8FB5CE189E15CC0ED4BFC4DE2A01")
        public  ViewGroupAction(int viewId, RemoteViews nestedViews) {
            this.viewId = viewId;
            this.nestedViews = nestedViews;
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.nestedViews = nestedViews;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_method = "3800854E305111A2B59A893F31CDD286", hash_generated_method = "B30611565EF1A179397305FFFC39C3E2")
        public  ViewGroupAction(Parcel parcel) {
            viewId = parcel.readInt();
            nestedViews = parcel.readParcelable(null);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //nestedViews = parcel.readParcelable(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_method = "BEE1FD608BE154882376BC772CDB35A0", hash_generated_method = "1D5187CEDC5619960DE4415C3EDC234A")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeParcelable(nestedViews, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //dest.writeParcelable(nestedViews, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_method = "3F6E8B427E9FBCBDEBB4E654B5696B90", hash_generated_method = "3B00F4C10DDBDA05F68CB98A17B0F288")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            addTaint(rootParent.getTaint());
            addTaint(root.getTaint());
            final Context context = root.getContext();
            final ViewGroup target = (ViewGroup) root.findViewById(viewId);
    if(target == null)            
            return;
    if(nestedViews != null)            
            {
                target.addView(nestedViews.apply(context, target));
            } //End block
            else
            {
                target.removeAllViews();
            } //End block
            // ---------- Original Method ----------
            //final Context context = root.getContext();
            //final ViewGroup target = (ViewGroup) root.findViewById(viewId);
            //if (target == null) return;
            //if (nestedViews != null) {
                //target.addView(nestedViews.apply(context, target));
            //} else {
                //target.removeAllViews();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_method = "9A98BF9B0C4ADB9C4C041E3C0533F17D", hash_generated_method = "EFCA05839D9A491B83CCF1CB584A82B6")
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            addTaint(counter.getTaint());
    if(nestedViews != null)            
            {
                counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            } //End block
            // ---------- Original Method ----------
            //if (nestedViews != null) {
                //counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_field = "1C67B632B385F0EED4F9EDC3A5442AB0", hash_generated_field = "BFAD764BA58FF98FFB009C9036CFE299")

        public final static int TAG = 4;
    }


    
    private class MemoryUsageCounter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_field = "C36FDDE1E5252D085B64B1B7ADEDAD8C", hash_generated_field = "B0DA7A32C463859C81C00F4CE0F0F3CC")

        int mBitmapHeapMemoryUsage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.723 -0400", hash_original_method = "35D450C627251B011B80F5473DD04513", hash_generated_method = "35D450C627251B011B80F5473DD04513")
        public MemoryUsageCounter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.724 -0400", hash_original_method = "F68FB7282799CC52F4314E5E47499FED", hash_generated_method = "980B3E80527B474B5039262E61BD9D48")
        public void clear() {
            mBitmapHeapMemoryUsage = 0;
            // ---------- Original Method ----------
            //mBitmapHeapMemoryUsage = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.724 -0400", hash_original_method = "9C864F7ABFEE7832A18F21C728CCE23F", hash_generated_method = "583FD2D740DF0E423E81CC172F08A31C")
        public void bitmapIncrement(int numBytes) {
            mBitmapHeapMemoryUsage += numBytes;
            // ---------- Original Method ----------
            //mBitmapHeapMemoryUsage += numBytes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.727 -0400", hash_original_method = "F4B214FD82765971EA3822C02AABA16F", hash_generated_method = "6294F6EE3EEB9808CE98D466DD2522A8")
        public int getBitmapHeapMemoryUsage() {
            int varC36FDDE1E5252D085B64B1B7ADEDAD8C_365752627 = (mBitmapHeapMemoryUsage);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528235119 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528235119;
            // ---------- Original Method ----------
            //return mBitmapHeapMemoryUsage;
        }

        
    }


    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface RemoteView {
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.727 -0400", hash_original_field = "4C31F39A08DE2EFB8DEBBB394A3254D5", hash_generated_field = "ACEFF52037C84D6363407415280404F5")

    private static final String LOG_TAG = "RemoteViews";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.727 -0400", hash_original_field = "800952FE10AA9D0D47085F390E4ECC86", hash_generated_field = "826EFFDEC6B49221DB3B3AF9DDB20D89")

    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.727 -0400", hash_original_field = "3C81D1A6471DBF098FBC5010948AFD3D", hash_generated_field = "BD08AD711A0271B27E85FFB2A2737195")

    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() {
        public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    };
    // orphaned legacy method
    public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }
    
    // orphaned legacy method
    public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    
}

