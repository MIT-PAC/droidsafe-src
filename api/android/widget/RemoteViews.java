package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.068 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.069 -0400", hash_original_field = "143EA7733FD06F80DE8D3B366855A342", hash_generated_field = "62824B28582365160D4F4E663AF78109")

    private int mLayoutId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.069 -0400", hash_original_field = "C268D719F2F67098628D1A8EEBB72B48", hash_generated_field = "BDB8276C1ABE28FC56F7F2EFF4E83F5A")

    private ArrayList<Action> mActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.069 -0400", hash_original_field = "302EDB52DCA958E10D9F1FB586627A2C", hash_generated_field = "428BAA212C6DEB5FEF7CB6370C9BEBDF")

    private MemoryUsageCounter mMemoryUsageCounter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.069 -0400", hash_original_field = "DF25E6BAFF11DD73CFFFA27BAA8B8CFC", hash_generated_field = "5F2713F2C4461A89B34556F5FA319D47")

    private boolean mIsWidgetCollectionChild = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.069 -0400", hash_original_method = "7ADC44A8B9BDF8C00FB4776840C5552D", hash_generated_method = "154333C84C3CBD1C406C406999A1627C")
    public  RemoteViews(String packageName, int layoutId) {
        mPackage = packageName;
        mLayoutId = layoutId;
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.070 -0400", hash_original_method = "B81662C8B479B3D3C957D533866FE808", hash_generated_method = "5934799FDECA1D6F0BA41893FDE041AB")
    public  RemoteViews(Parcel parcel) {
        mPackage = parcel.readString();
        mLayoutId = parcel.readInt();
        mIsWidgetCollectionChild = parcel.readInt() == 1 ? true : false;
        int count = parcel.readInt();
        {
            mActions = new ArrayList<Action>(count);
            {
                int i = 0;
                {
                    int tag = parcel.readInt();
                    
                    mActions.add(new SetOnClickPendingIntent(parcel));
                    
                    
                    mActions.add(new SetDrawableParameters(parcel));
                    
                    
                    mActions.add(new ReflectionAction(parcel));
                    
                    
                    mActions.add(new ViewGroupAction(parcel));
                    
                    
                    mActions.add(new ReflectionActionWithoutParams(parcel));
                    
                    
                    mActions.add(new SetEmptyView(parcel));
                    
                    
                    mActions.add(new SetPendingIntentTemplate(parcel));
                    
                    
                    mActions.add(new SetOnClickFillInIntent(parcel));
                    
                    
                    mActions.add(new SetRemoteViewsAdapterIntent(parcel));
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("Tag " + tag + " not found");
                    
                } 
            } 
        } 
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.070 -0400", hash_original_method = "67D19BE5CA3BC69F21B2B2516A1FA2D6", hash_generated_method = "3BF8321E3C433F4529216E03A0CA3A3C")
    @Override
    public RemoteViews clone() {
        RemoteViews varB4EAC82CA7396A68D541C85D26508E83_1206250938 = null; 
        final RemoteViews that = new RemoteViews(mPackage, mLayoutId);
        {
            that.mActions = (ArrayList<Action>)mActions.clone();
        } 
        that.recalculateMemoryUsage();
        varB4EAC82CA7396A68D541C85D26508E83_1206250938 = that;
        varB4EAC82CA7396A68D541C85D26508E83_1206250938.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1206250938;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.071 -0400", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "B94BF88443EF1EF5878B6F5EB0B1B141")
    public String getPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1217100516 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1217100516 = mPackage;
        varB4EAC82CA7396A68D541C85D26508E83_1217100516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1217100516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.072 -0400", hash_original_method = "613C00C60CA896BC5001BD5561015459", hash_generated_method = "E4F28B085810BD7F259AD4491DC102B3")
    public int getLayoutId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882902467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882902467;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.072 -0400", hash_original_method = "B2E01CE5E210E0306AAEDD7A25572B15", hash_generated_method = "C504A5E5F8CCD8C6A31C201D44889892")
     void setIsWidgetCollectionChild(boolean isWidgetCollectionChild) {
        mIsWidgetCollectionChild = isWidgetCollectionChild;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.073 -0400", hash_original_method = "F73414915FBB974B28CE5BE7CD6B07B1", hash_generated_method = "18FCC791DF8DA24D2368BBDE6F3D9188")
    private void recalculateMemoryUsage() {
        mMemoryUsageCounter.clear();
        {
            final int count = mActions.size();
            {
                int i = 0;
                {
                    mActions.get(i).updateMemoryUsageEstimate(mMemoryUsageCounter);
                } 
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.073 -0400", hash_original_method = "4E1C2F916A403E6D1D4B708360B7D61A", hash_generated_method = "6CB2BFADECA13A59474EA414A8171D06")
     int estimateBitmapMemoryUsage() {
        int var86B2D4DC43E82BB120116366B3BFF3DD_1557618620 = (mMemoryUsageCounter.getBitmapHeapMemoryUsage());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146779254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146779254;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.074 -0400", hash_original_method = "17103049C6B2546A05BB76759DAB3B89", hash_generated_method = "14D85083847E9B9992C73BE5A5A1C108")
    private void addAction(Action a) {
        {
            mActions = new ArrayList<Action>();
        } 
        mActions.add(a);
        a.updateMemoryUsageEstimate(mMemoryUsageCounter);
        addTaint(a.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.074 -0400", hash_original_method = "4A1BA0269DB90E506DB0959643DF475B", hash_generated_method = "BE51826B6DFABF603D3CC9C5EB042AB8")
    public void addView(int viewId, RemoteViews nestedView) {
        addAction(new ViewGroupAction(viewId, nestedView));
        addTaint(viewId);
        addTaint(nestedView.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.074 -0400", hash_original_method = "E70CF2F379D754A9B2BAC52704294677", hash_generated_method = "7DAFE72427A04B46D6AE7A6C690B16CF")
    public void removeAllViews(int viewId) {
        addAction(new ViewGroupAction(viewId, null));
        addTaint(viewId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.075 -0400", hash_original_method = "715372503FFB1BBD9EE3BEF4F54CECDE", hash_generated_method = "E5E7094C78B0342C8FBE818E967BED88")
    public void showNext(int viewId) {
        addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
        addTaint(viewId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.075 -0400", hash_original_method = "92870339C0CC6AF77A420F74F896E688", hash_generated_method = "7058F26D9AECA826E789F6C83BE8A1AC")
    public void showPrevious(int viewId) {
        addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
        addTaint(viewId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.075 -0400", hash_original_method = "D726270A4D4DC2D53B195715D168181D", hash_generated_method = "51948C5BA528D0BF0C16FC0DB8B9C456")
    public void setDisplayedChild(int viewId, int childIndex) {
        setInt(viewId, "setDisplayedChild", childIndex);
        addTaint(viewId);
        addTaint(childIndex);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.075 -0400", hash_original_method = "DEE52A50DF8AF905161D8440F9C7FD6B", hash_generated_method = "5042AB34DE0B094F8693F57AAD5EBDBE")
    public void setViewVisibility(int viewId, int visibility) {
        setInt(viewId, "setVisibility", visibility);
        addTaint(viewId);
        addTaint(visibility);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.075 -0400", hash_original_method = "5F8A789C1791A65B082D971694A97107", hash_generated_method = "C1686747B60B04994A641AC32DF00106")
    public void setTextViewText(int viewId, CharSequence text) {
        setCharSequence(viewId, "setText", text);
        addTaint(viewId);
        addTaint(text.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.076 -0400", hash_original_method = "BA7406E13895A91025A0507F41BF6313", hash_generated_method = "9EC64FFF95AE3A7F8A73FA6F77C9F492")
    public void setImageViewResource(int viewId, int srcId) {
        setInt(viewId, "setImageResource", srcId);
        addTaint(viewId);
        addTaint(srcId);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.076 -0400", hash_original_method = "433DFD276FBB02E0D7A2B8DA3B0F08D8", hash_generated_method = "4886F826B42973C5B36780910CDD3442")
    public void setImageViewUri(int viewId, Uri uri) {
        setUri(viewId, "setImageURI", uri);
        addTaint(viewId);
        addTaint(uri.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.076 -0400", hash_original_method = "957E8B822330AC731DF30A1543908B02", hash_generated_method = "254ADF3EE07F981DCF1CB0DDFC394ADA")
    public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        setBitmap(viewId, "setImageBitmap", bitmap);
        addTaint(viewId);
        addTaint(bitmap.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.076 -0400", hash_original_method = "4F3E7FFD56A31D2F2A8813C161A91D32", hash_generated_method = "46FFB0E9FA7C74856D21886F6686577C")
    public void setEmptyView(int viewId, int emptyViewId) {
        addAction(new SetEmptyView(viewId, emptyViewId));
        addTaint(viewId);
        addTaint(emptyViewId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.077 -0400", hash_original_method = "47E59AC623A4BD9BB48A3F2CB501DFB4", hash_generated_method = "190450189383961E1AE7EA8D7C6C9468")
    public void setChronometer(int viewId, long base, String format, boolean started) {
        setLong(viewId, "setBase", base);
        setString(viewId, "setFormat", format);
        setBoolean(viewId, "setStarted", started);
        addTaint(viewId);
        addTaint(base);
        addTaint(format.getTaint());
        addTaint(started);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.077 -0400", hash_original_method = "A929EFC8DD62C6A3F9A2F8FB0663D928", hash_generated_method = "E780DF68AF578C84D517E94BB1814E96")
    public void setProgressBar(int viewId, int max, int progress, 
            boolean indeterminate) {
        setBoolean(viewId, "setIndeterminate", indeterminate);
        {
            setInt(viewId, "setMax", max);
            setInt(viewId, "setProgress", progress);
        } 
        addTaint(viewId);
        addTaint(max);
        addTaint(progress);
        addTaint(indeterminate);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.077 -0400", hash_original_method = "84C6A4280B6852D03015FA2AE8D65E64", hash_generated_method = "10205052AA7B567FB33A85370542456A")
    public void setOnClickPendingIntent(int viewId, PendingIntent pendingIntent) {
        addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
        addTaint(viewId);
        addTaint(pendingIntent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.077 -0400", hash_original_method = "A434A09AC636025A142B2CC781D07FF1", hash_generated_method = "E5A0C10ED8F0807662E89DC6DC1B2D0E")
    public void setPendingIntentTemplate(int viewId, PendingIntent pendingIntentTemplate) {
        addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
        addTaint(viewId);
        addTaint(pendingIntentTemplate.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.078 -0400", hash_original_method = "899E714C9944265097024FA544BB7AC2", hash_generated_method = "FC803D3084FEE4BFE925B42BC2E4AD8E")
    public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
        addTaint(viewId);
        addTaint(fillInIntent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.078 -0400", hash_original_method = "09A5B1AD4F222B569CE2E6BD5BF01B12", hash_generated_method = "6FE53FFB3BEC3305193E1F43FE4188C5")
    public void setDrawableParameters(int viewId, boolean targetBackground, int alpha,
            int colorFilter, PorterDuff.Mode mode, int level) {
        addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                colorFilter, mode, level));
        addTaint(viewId);
        addTaint(targetBackground);
        addTaint(alpha);
        addTaint(colorFilter);
        addTaint(mode.getTaint());
        addTaint(level);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.078 -0400", hash_original_method = "F51B3B3FB58685A967056786739D5D5A", hash_generated_method = "D4C5BBDF3D4007BC29A57A35CC4C2DBE")
    public void setTextColor(int viewId, int color) {
        setInt(viewId, "setTextColor", color);
        addTaint(viewId);
        addTaint(color);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.078 -0400", hash_original_method = "F3196C5DB537F18A0B70CAAF74A09A0A", hash_generated_method = "1ED880BC8B6C456181055C17BF0482BF")
    @Deprecated
    public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        setRemoteAdapter(viewId, intent);
        addTaint(appWidgetId);
        addTaint(viewId);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.078 -0400", hash_original_method = "9F000F17F0336123DB5D1DD3E4F67BE6", hash_generated_method = "209EBF5096E4DFFB4FF13A86D14D2276")
    public void setRemoteAdapter(int viewId, Intent intent) {
        addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
        addTaint(viewId);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.079 -0400", hash_original_method = "15753F5F29C6091CCB595496C38B1963", hash_generated_method = "F2669B0CFFF5FCDD28D213E02584C3EE")
    public void setScrollPosition(int viewId, int position) {
        setInt(viewId, "smoothScrollToPosition", position);
        addTaint(viewId);
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.079 -0400", hash_original_method = "62C951046FF905CA4D61721F847C4DC5", hash_generated_method = "FF4FFBDC32144F1C0691C17995ADC9EC")
    public void setRelativeScrollPosition(int viewId, int offset) {
        setInt(viewId, "smoothScrollByOffset", offset);
        addTaint(viewId);
        addTaint(offset);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.079 -0400", hash_original_method = "ACF50C9E2E7A3E77B399A3E9AD77138B", hash_generated_method = "0AFE7CCC20496291CDC8599C5C3EA0B7")
    public void setBoolean(int viewId, String methodName, boolean value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.079 -0400", hash_original_method = "6577642D84CE42EC3FAE93CD4A676A48", hash_generated_method = "7E26476BD99A864F4C92D35888DC678E")
    public void setByte(int viewId, String methodName, byte value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.079 -0400", hash_original_method = "1EF837BE87322E5A782B07EBE8F017ED", hash_generated_method = "12E51C0AF74AA8C03D8BC102B801C7D3")
    public void setShort(int viewId, String methodName, short value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.080 -0400", hash_original_method = "2BA2097F7597ED476DFE96444FF2B47B", hash_generated_method = "C629D01D0D3E96687E0080FB6FB1AAFB")
    public void setInt(int viewId, String methodName, int value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.080 -0400", hash_original_method = "7BBB498795ABAEC2FC5C9E80D1FF1F8F", hash_generated_method = "7C9D858AD1C83D5BB6E0436A433BE27A")
    public void setLong(int viewId, String methodName, long value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.080 -0400", hash_original_method = "877DFBEE5EFFB4333EA4E3E01D628209", hash_generated_method = "6750497552EE6EB3729A84ADF4EEF057")
    public void setFloat(int viewId, String methodName, float value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.080 -0400", hash_original_method = "36511416C0ED3D737A57750DB7E0C821", hash_generated_method = "B8A6727A0CF67717F2DE5CAF6A58BC37")
    public void setDouble(int viewId, String methodName, double value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.081 -0400", hash_original_method = "E7DFE8EB27DC5DF6C76291F003DE876E", hash_generated_method = "B472EFE0AD720EB489982CE2CEAE8034")
    public void setChar(int viewId, String methodName, char value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.081 -0400", hash_original_method = "12B33E0B58F238F52279DFEB1871046D", hash_generated_method = "8E1CB0C5EB1F17AC4E89D030D09AA625")
    public void setString(int viewId, String methodName, String value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.081 -0400", hash_original_method = "93A93353A27881B93F029E1CB8E38561", hash_generated_method = "E36A98006B1B4913E74FBA5EB0D8EF9C")
    public void setCharSequence(int viewId, String methodName, CharSequence value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.081 -0400", hash_original_method = "33EE202B45F16FA5012E7C802B1E1162", hash_generated_method = "B4BED6EF95554EFA166211946117B443")
    public void setUri(int viewId, String methodName, Uri value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.082 -0400", hash_original_method = "BE18885A2548A0B5EB1C1E6420A7D63A", hash_generated_method = "5CB35D7C885AEB01DBD476D41B93F218")
    public void setBitmap(int viewId, String methodName, Bitmap value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.082 -0400", hash_original_method = "0BCEFBE1ECC6F937E30E64CCDC160671", hash_generated_method = "96318BAF418FC1F368282EF2A9AC9B79")
    public void setBundle(int viewId, String methodName, Bundle value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.082 -0400", hash_original_method = "1536FDACAD3B90F5944D61240D2247D6", hash_generated_method = "46565EF22497645D3884804BB0A6D419")
    public void setIntent(int viewId, String methodName, Intent value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
        addTaint(viewId);
        addTaint(methodName.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.082 -0400", hash_original_method = "DAF30AB9823DD59C17B2FD226E498806", hash_generated_method = "DE3CA1090F90BFFEA2A4EE8FDBC30AAA")
    public void setContentDescription(int viewId, CharSequence contentDescription) {
        setCharSequence(viewId, "setContentDescription", contentDescription);
        addTaint(viewId);
        addTaint(contentDescription.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.084 -0400", hash_original_method = "389CE470D5FBF8918932B7CDEB2F38A1", hash_generated_method = "70B3AAA80417C65E5C1CAD9A6C94E40D")
    public View apply(Context context, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_472772246 = null; 
        View result;
        Context c = prepareContext(context);
        LayoutInflater inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater = inflater.cloneInContext(c);
        inflater.setFilter(this);
        result = inflater.inflate(mLayoutId, parent, false);
        performApply(result, parent);
        varB4EAC82CA7396A68D541C85D26508E83_472772246 = result;
        addTaint(context.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_472772246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_472772246;
        
        
        
        
                
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.085 -0400", hash_original_method = "721D0331C9411BF86340BE2E97293121", hash_generated_method = "4E7B42AA9410C09239E197B17AC0EA6D")
    public void reapply(Context context, View v) {
        prepareContext(context);
        performApply(v, (ViewGroup) v.getParent());
        addTaint(context.getTaint());
        addTaint(v.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.085 -0400", hash_original_method = "8E5E3E88ABCC69E3321D1346316340C9", hash_generated_method = "3201E724637A8710801D274491977564")
    private void performApply(View v, ViewGroup parent) {
        {
            final int count = mActions.size();
            {
                int i = 0;
                {
                    Action a = mActions.get(i);
                    a.apply(v, parent);
                } 
            } 
        } 
        addTaint(v.getTaint());
        addTaint(parent.getTaint());
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.086 -0400", hash_original_method = "22DA97EA1494F0F193EF18C8ED8C5634", hash_generated_method = "A710FDDB923705F1C52D44120AD8121B")
    private Context prepareContext(Context context) {
        Context varB4EAC82CA7396A68D541C85D26508E83_160495205 = null; 
        Context c;
        String packageName = mPackage;
        {
            try 
            {
                c = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            } 
            catch (NameNotFoundException e)
            {
                c = context;
            } 
        } 
        {
            c = context;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_160495205 = c;
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_160495205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_160495205;
        
        
        
        
            
                
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.086 -0400", hash_original_method = "02A046D25F4E9D374E474E21F6366163", hash_generated_method = "2E74A3A932E4FE864911AA94BE15F6D9")
    public boolean onLoadClass(Class clazz) {
        
        boolean var240EFB7114C55D0ABD9923D7086CE184_47870541 = (clazz.isAnnotationPresent(RemoteView.class));
        addTaint(clazz.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194429198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194429198;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.087 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0EAD812F99D54B72296837C5EA7F938C")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315381495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315381495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.087 -0400", hash_original_method = "E42048CF3CAA5A680CE684B09E27CD46", hash_generated_method = "699B8F4384ABCFD65D9AA3729A397E46")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPackage);
        dest.writeInt(mLayoutId);
        dest.writeInt(mIsWidgetCollectionChild ? 1 : 0);
        int count;
        {
            count = mActions.size();
        } 
        {
            count = 0;
        } 
        dest.writeInt(count);
        {
            int i = 0;
            {
                Action a = mActions.get(i);
                a.writeToParcel(dest, 0);
            } 
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
            
        
            
        
        
        
            
            
        
    }

    
    public static class ActionException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.088 -0400", hash_original_method = "4338C0B6ED05990B68F77B56C502C8BC", hash_generated_method = "6A9B199E4B70296D28CD039E0E15FE3D")
        public  ActionException(Exception ex) {
            super(ex);
            addTaint(ex.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.088 -0400", hash_original_method = "E5DD8B85C6FF17BD695A219FDD405D42", hash_generated_method = "947B27CB5701852C6B41A566481318D7")
        public  ActionException(String message) {
            super(message);
            addTaint(message.getTaint());
            
        }

        
    }


    
    private abstract static class Action implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.088 -0400", hash_original_method = "6EEA56B449227AEBD2AEF88874F9C864", hash_generated_method = "6EEA56B449227AEBD2AEF88874F9C864")
        public Action ()
        {
            
        }


        public abstract void apply(View root, ViewGroup rootParent) throws ActionException;

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.089 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AEC5B25466E760D97F5CC599F1429796")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496208840 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496208840;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.089 -0400", hash_original_method = "F71AEDBFF608C755FB28C9D45BA8F347", hash_generated_method = "E6544460AD15DE17E386E7E557B83699")
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            addTaint(counter.getTaint());
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.089 -0400", hash_original_method = "18203BE61B7EF9CD6501BEC6EAEF8812", hash_generated_method = "F4E4DD03C038752C5ACEC6498855F688")
        protected boolean startIntentSafely(Context context, PendingIntent pendingIntent,
                Intent fillInIntent) {
            try 
            {
                context.startIntentSender(
                        pendingIntent.getIntentSender(), fillInIntent,
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_NEW_TASK, 0);
            } 
            catch (IntentSender.SendIntentException e)
            {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent: ", e);
            } 
            catch (Exception e)
            {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent due to " +
                        "unknown exception: ", e);
            } 
            addTaint(context.getTaint());
            addTaint(pendingIntent.getTaint());
            addTaint(fillInIntent.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845581278 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845581278;
            
            
                
                        
                        
                        
            
                
                
            
                
                        
                
            
            
        }

        
    }


    
    private class SetEmptyView extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.089 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.089 -0400", hash_original_field = "23D13A84EF4F7189027D73EC6744F6E8", hash_generated_field = "8D3D66B4863E42DCDD06D3EE8F80E8F7")

        int emptyViewId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.090 -0400", hash_original_method = "16159C50F4CD599B644ED014E4EA0822", hash_generated_method = "C1C4A274A58AFAF2063BE98C3846BAE4")
          SetEmptyView(int viewId, int emptyViewId) {
            this.viewId = viewId;
            this.emptyViewId = emptyViewId;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.090 -0400", hash_original_method = "F10F16648F57CF9FE4F3D806E803B1DC", hash_generated_method = "0CB8CADFFD90BE29657F9D6DCA52C11C")
          SetEmptyView(Parcel in) {
            this.viewId = in.readInt();
            this.emptyViewId = in.readInt();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.090 -0400", hash_original_method = "1EA9A4CD3E90F19D62658919976BDCDF", hash_generated_method = "6C1336B94F8BEF7389F402943DB3AB66")
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeInt(this.emptyViewId);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.091 -0400", hash_original_method = "BC00C709904F6A7A06083DBEA360E136", hash_generated_method = "B077FF5EB637649E46F0CE3C2457312F")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            AdapterView<?> adapterView = (AdapterView<?>) view;
            final View emptyView = root.findViewById(emptyViewId);
            adapterView.setEmptyView(emptyView);
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.091 -0400", hash_original_field = "9C473E90A5431830598CA413D5D4F376", hash_generated_field = "832C8F64E214207268768E39D7FCB9F3")

        public final static int TAG = 6;
    }


    
    private class SetOnClickFillInIntent extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.091 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.091 -0400", hash_original_field = "3BCE79238D517725ED23615F7B7237D8", hash_generated_field = "9D3AB3AC0219EE64EF3FF80AB068BB5E")

        Intent fillInIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.091 -0400", hash_original_method = "FE3667D87A305D86E9A8A6AD36F5EEAF", hash_generated_method = "18AF1F9FD9414C6BCF3DBFD2F1D4F53B")
        public  SetOnClickFillInIntent(int id, Intent fillInIntent) {
            this.viewId = id;
            this.fillInIntent = fillInIntent;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.092 -0400", hash_original_method = "8F893000547B59EAD09450FBC024CAC1", hash_generated_method = "D68C613EB9756E36CE15A86322799F88")
        public  SetOnClickFillInIntent(Parcel parcel) {
            viewId = parcel.readInt();
            fillInIntent = Intent.CREATOR.createFromParcel(parcel);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.092 -0400", hash_original_method = "4A68D926F0B47E5C592025763C57CD49", hash_generated_method = "BEBF0BA2F3A59CB1F53D2303004AD609")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            fillInIntent.writeToParcel(dest, 0 );
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.093 -0400", hash_original_method = "3474C680008284CA3FCD2C734DB61ED8", hash_generated_method = "F32192EE24463589921602EEF2FD4D0E")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            {
                target.setTagInternal(com.android.internal.R.id.fillInIntent, fillInIntent);
            } 
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
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.093 -0400", hash_original_field = "D91A2B10EDD4F80880F9239AF8DAACE6", hash_generated_field = "257D5F310A82D1AE988E43617C7394F4")

        public final static int TAG = 9;
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.093 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.093 -0400", hash_original_field = "176E2FA2A8B62FAC39A0DD8CC7A328C0", hash_generated_field = "D0EA5F86DAC5B859FF411BE20B81D705")

        PendingIntent pendingIntentTemplate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.094 -0400", hash_original_method = "319DBBF9EE021BC2BD14552E08C5F806", hash_generated_method = "D7A3DCE3AD9BD409E6F2A6466125223B")
        public  SetPendingIntentTemplate(int id, PendingIntent pendingIntentTemplate) {
            this.viewId = id;
            this.pendingIntentTemplate = pendingIntentTemplate;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.095 -0400", hash_original_method = "F35BA9665B1C6E88223062D1328FA579", hash_generated_method = "DD0B2CD3748A8B20A1DE310050B42710")
        public  SetPendingIntentTemplate(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.095 -0400", hash_original_method = "2DE56D1052D41AEA85684029786EA581", hash_generated_method = "DD2BD96A2726CB5130E4611112CF9B53")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntentTemplate.writeToParcel(dest, 0 );
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.096 -0400", hash_original_method = "BC6383FD3782B4E4299FBBF52DF5CBB4", hash_generated_method = "49E59D6773749E089E81677D8B5E2657")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
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
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.096 -0400", hash_original_field = "6065CCBD64FD6BA819686C609CBF3FA3", hash_generated_field = "999B6A111CF47CD01BFB86C10E0DFDAF")

        public final static int TAG = 8;
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.096 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.096 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.096 -0400", hash_original_method = "2562242EF5AD42CD0339F4CFA0A5651B", hash_generated_method = "4D41B794CEB49FBFDACF661D08DF1C0D")
        public  SetRemoteViewsAdapterIntent(int id, Intent intent) {
            this.viewId = id;
            this.intent = intent;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_method = "3062D841F9A527FF82C19CE8ED4DF47C", hash_generated_method = "79C217E5E76E9F79C11955E3F453D87B")
        public  SetRemoteViewsAdapterIntent(Parcel parcel) {
            viewId = parcel.readInt();
            intent = Intent.CREATOR.createFromParcel(parcel);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_method = "F580FE61025C5DC81DFB7BB9EA905954", hash_generated_method = "9953A53F8C5F283E7B0EDDCBA5358E5F")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            intent.writeToParcel(dest, flags);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_method = "EDE9247E350EBAB87917A7616D3465DB", hash_generated_method = "28125424B0126BEA148A3D9D25409FEC")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            AppWidgetHostView host = (AppWidgetHostView) rootParent;
            intent.putExtra(EXTRA_REMOTEADAPTER_APPWIDGET_ID, host.getAppWidgetId());
            {
                AbsListView v = (AbsListView) target;
                v.setRemoteViewsAdapter(intent);
            } 
            {
                AdapterViewAnimator v = (AdapterViewAnimator) target;
                v.setRemoteViewsAdapter(intent);
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_field = "454319544DE430D1FE4AE42999579103", hash_generated_field = "8FE5A8285A40B3CDB587BD72B1510F3F")

        public final static int TAG = 10;
    }


    
    private class SetOnClickPendingIntent extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.097 -0400", hash_original_field = "2FACCE917278B302FB28C98EBAEC216A", hash_generated_field = "7026E183996B4AEE13A8653E0B37928C")

        PendingIntent pendingIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.098 -0400", hash_original_method = "66EA2688C4B0F29524FFED0B8D1C4557", hash_generated_method = "DE4E1C8802A6B5161427D208A788FF49")
        public  SetOnClickPendingIntent(int id, PendingIntent pendingIntent) {
            this.viewId = id;
            this.pendingIntent = pendingIntent;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.098 -0400", hash_original_method = "2D335FA6E397EB90FCE69134FAC6C0E6", hash_generated_method = "7AF4DFE20455952984B5C6A7CBCA2E14")
        public  SetOnClickPendingIntent(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.098 -0400", hash_original_method = "7CEF806B95F0881A888E5DFCE712AF4A", hash_generated_method = "67B42A26D79B9D01866E55703FDC2114")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntent.writeToParcel(dest, 0 );
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_method = "7AB558D2EB1905941BBC96768E4F0260", hash_generated_method = "5C820A4155E74CFA2DB0869C18A60029")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
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
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "300A66DF77BAB65489ADB988403DB41B", hash_generated_field = "993712AACA5BFFF68C7775B3C6B7EE8B")

        public final static int TAG = 1;
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "A2AB643A05537436635D1E7D1C7AE662", hash_generated_field = "348353981961A3507DF6BC6E23EBAF56")

        boolean targetBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "2C1743A391305FBF367DF8E4F069F9F9", hash_generated_field = "1B559E55B8F17D21F08DC11CC377988E")

        int alpha;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "430580F08459C4E5E775DF0C2447C4DA", hash_generated_field = "1B107E6823167B68C4A8FA578E72F2B9")

        int colorFilter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "93065ABDC7B96A0A146EC1937D38C277", hash_generated_field = "1E0353AC2D4FEC5D3F86FBF63BA71A1F")

        PorterDuff.Mode filterMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "6C23DC7E65CEAB9FBA953CF49B6B6875")

        int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.099 -0400", hash_original_method = "18564016E13252E4F53F65794EE2D4BB", hash_generated_method = "5A814AA3D1EB7D235731941FAE0DA595")
        public  SetDrawableParameters(int id, boolean targetBackground, int alpha,
                int colorFilter, PorterDuff.Mode mode, int level) {
            this.viewId = id;
            this.targetBackground = targetBackground;
            this.alpha = alpha;
            this.colorFilter = colorFilter;
            this.filterMode = mode;
            this.level = level;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.100 -0400", hash_original_method = "72E671F08A71584E9232C176B97BC1C8", hash_generated_method = "52A1580FF50D0518599FBC34D76F70DD")
        public  SetDrawableParameters(Parcel parcel) {
            viewId = parcel.readInt();
            targetBackground = parcel.readInt() != 0;
            alpha = parcel.readInt();
            colorFilter = parcel.readInt();
            boolean hasMode = parcel.readInt() != 0;
            {
                filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            } 
            {
                filterMode = null;
            } 
            level = parcel.readInt();
            
            
            
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.100 -0400", hash_original_method = "DC629CA06C171381152FF8641B977C9F", hash_generated_method = "1CC6D6840A8D7C00D6B303396177796B")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeInt(targetBackground ? 1 : 0);
            dest.writeInt(alpha);
            dest.writeInt(colorFilter);
            {
                dest.writeInt(1);
                dest.writeString(filterMode.toString());
            } 
            {
                dest.writeInt(0);
            } 
            dest.writeInt(level);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
                
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.101 -0400", hash_original_method = "2B7DD23B0EB7FE8C6A2446FEC1367E7F", hash_generated_method = "9FA4E7719003ADECFE7A6F1188CBD888")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            Drawable targetDrawable = null;
            {
                targetDrawable = target.getBackground();
            } 
            {
                ImageView imageView = (ImageView) target;
                targetDrawable = imageView.getDrawable();
            } 
            {
                {
                    targetDrawable.setAlpha(alpha);
                } 
                {
                    targetDrawable.setColorFilter(colorFilter, filterMode);
                } 
                {
                    targetDrawable.setLevel(level);
                } 
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.101 -0400", hash_original_field = "6F4A6F730922DE22412A2E7EBF673639", hash_generated_field = "22845C1BD5EB1EFAC44EDEF6B7BDA751")

        public final static int TAG = 3;
    }


    
    private class ReflectionActionWithoutParams extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.101 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.101 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.101 -0400", hash_original_method = "9825933434EF5EC003AA8FF50203783A", hash_generated_method = "306E4CE94A121FCAD55ED69BD6877BBC")
          ReflectionActionWithoutParams(int viewId, String methodName) {
            this.viewId = viewId;
            this.methodName = methodName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.102 -0400", hash_original_method = "07A57AEC1ECBD4F4EF962F6964A9C9CB", hash_generated_method = "F389E821077AA3BB95015DCE93F78B32")
          ReflectionActionWithoutParams(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.102 -0400", hash_original_method = "E92934B0244E59AB6D933016F95632D8", hash_generated_method = "D01B7EF0A9D62897026A6B1F8773DE02")
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.103 -0400", hash_original_method = "B2755AE6CC74346ED57BF443914C2243", hash_generated_method = "A68D9C79E0482228E7FF71A427559BA2")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            Class klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName);
            } 
            catch (NoSuchMethodException ex)
            {
            	throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "()");
            } 
            {
                boolean varDF1EFAF7A9352F1C3347271AD170B8BD_226441401 = (!method.isAnnotationPresent(RemotableViewMethod.class));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "()");
                } 
            } 
            try 
            {
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "()");
                } 
                method.invoke(view);
            } 
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException(ex);
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.103 -0400", hash_original_field = "DE143BAD1003A83F29229B3A04BAF7B0", hash_generated_field = "03362AF19131C1207E62059104EDE4C5")

        public final static int TAG = 5;
    }


    
    private class ReflectionAction extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.104 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.104 -0400", hash_original_field = "DDAA6E8C8C412299272E183087B8F7B6", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.104 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "961B4204667A4AE2FF8DD374E6728ADE")

        int type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.104 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.105 -0400", hash_original_method = "C4E3EC196FB78FDD2AFD41CF23C84256", hash_generated_method = "66FBD19134023AF224E81CB8AE41B251")
          ReflectionAction(int viewId, String methodName, int type, Object value) {
            this.viewId = viewId;
            this.methodName = methodName;
            this.type = type;
            this.value = value;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.106 -0400", hash_original_method = "A86C68C4FD8B9D479580CAEA2D14C9BF", hash_generated_method = "2AC433509ED1882775BC6520D8FAA882")
          ReflectionAction(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
            this.type = in.readInt();
            {
                Log.d("RemoteViews", "read viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } 
            
            this.value = in.readInt() != 0;
            
            
            this.value = in.readByte();
            
            
            this.value = (short)in.readInt();
            
            
            this.value = in.readInt();
            
            
            this.value = in.readLong();
            
            
            this.value = in.readFloat();
            
            
            this.value = in.readDouble();
            
            
            this.value = (char)in.readInt();
            
            
            this.value = in.readString();
            
            
            this.value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            
            
            this.value = Uri.CREATOR.createFromParcel(in);
            
            
            this.value = Bitmap.CREATOR.createFromParcel(in);
            
            
            this.value = in.readBundle();
            
            
            this.value = Intent.CREATOR.createFromParcel(in);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.107 -0400", hash_original_method = "F759DD8CB1A89B34D073177D219BFFB9", hash_generated_method = "50168D34BE208CDD5825918B7C447ADA")
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            out.writeInt(this.type);
            {
                Log.d("RemoteViews", "write viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } 
            
            out.writeInt((Boolean) this.value ? 1 : 0);
            
            
            out.writeByte((Byte) this.value);
            
            
            out.writeInt((Short) this.value);
            
            
            out.writeInt((Integer) this.value);
            
            
            out.writeLong((Long) this.value);
            
            
            out.writeFloat((Float) this.value);
            
            
            out.writeDouble((Double) this.value);
            
            
            out.writeInt((int)((Character)this.value).charValue());
            
            
            out.writeString((String)this.value);
            
            
            TextUtils.writeToParcel((CharSequence)this.value, out, flags);
            
            
            ((Uri)this.value).writeToParcel(out, flags);
            
            
            ((Bitmap)this.value).writeToParcel(out, flags);
            
            
            out.writeBundle((Bundle) this.value);
            
            
            ((Intent)this.value).writeToParcel(out, flags);
            
            addTaint(out.getTaint());
            addTaint(flags);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.108 -0400", hash_original_method = "E66E0BF97844CCF37DCED039A425AFDA", hash_generated_method = "B6AD99CEF31BD84E25924E4205CB7F91")
        private Class getParameterType() {
            Class varB4EAC82CA7396A68D541C85D26508E83_1383944493 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1954732381 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_405695124 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_175357225 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_548429297 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_994023474 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1735111876 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1407779697 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_325051821 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_755329361 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1728448430 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1502072829 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1169075059 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1754099758 = null; 
            Class varB4EAC82CA7396A68D541C85D26508E83_1153338551 = null; 
            
            varB4EAC82CA7396A68D541C85D26508E83_1383944493 = boolean.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1954732381 = byte.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_405695124 = short.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_175357225 = int.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_548429297 = long.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_994023474 = float.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1735111876 = double.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1407779697 = char.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_325051821 = String.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_755329361 = CharSequence.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1728448430 = Uri.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1502072829 = Bitmap.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1169075059 = Bundle.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1754099758 = Intent.class;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1153338551 = null;
            
            Class varA7E53CE21691AB073D9660D615818899_170462816; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1383944493;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1954732381;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_405695124;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_175357225;
                    break;
                case 5: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_548429297;
                    break;
                case 6: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_994023474;
                    break;
                case 7: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1735111876;
                    break;
                case 8: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1407779697;
                    break;
                case 9: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_325051821;
                    break;
                case 10: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_755329361;
                    break;
                case 11: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1728448430;
                    break;
                case 12: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1502072829;
                    break;
                case 13: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1169075059;
                    break;
                case 14: 
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1754099758;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_170462816 = varB4EAC82CA7396A68D541C85D26508E83_1153338551;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_170462816.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_170462816;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.109 -0400", hash_original_method = "008B98D7581EEC47326A699C8B3D8035", hash_generated_method = "37317E4EE5912A72AE7B46FFF0E032E1")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            Class param = getParameterType();
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException("bad type: " + this.type);
            } 
            Class klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName, getParameterType());
            } 
            catch (NoSuchMethodException ex)
            {
            	throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "(" + param.getName() + ")");
            } 
            {
                boolean varDF1EFAF7A9352F1C3347271AD170B8BD_1929110065 = (!method.isAnnotationPresent(RemotableViewMethod.class));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "(" + param.getName() + ")");
                } 
            } 
            try 
            {
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "(" + param.getName() + ") with "
                        + (this.value == null ? "null" : this.value.getClass().getName()));
                } 
                method.invoke(view, this.value);
            } 
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException(ex);
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_method = "1F301B790026760CE401FF57484A4A78", hash_generated_method = "A0D97F6132EE85ED062867E2AA8F0876")
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            
            {
                final Bitmap b = (Bitmap) this.value;
                final Bitmap.Config c = b.getConfig();
                int bpp = 4;
                {
                    
                    bpp = 1;
                    
                    
                    bpp = 2;
                    
                    
                    bpp = 4;
                    
                } 
                counter.bitmapIncrement(b.getWidth() * b.getHeight() * bpp);
            } 
            
            addTaint(counter.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

        static final int TAG = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "2F374CAF065C6170DB0655822E60E222", hash_generated_field = "E11DCA29C7BD696B2526B497FF3EAAEC")

        static final int BOOLEAN = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "B4F8B987EF9A0C82A8C8267A98C738F6", hash_generated_field = "A08488B6E820CE04526667A0F65B2358")

        static final int BYTE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "175308D2FBF3B761DF0108367B225AD1", hash_generated_field = "A14B4D783E4BD28B22DF5708F3C91517")

        static final int SHORT = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "A0CB96DABFDCF4947E640C27B00A7309", hash_generated_field = "0D069F30768AEFEA236A6C7BEA66E7F4")

        static final int INT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "8BDB65EA307B4E2D6C3AD9BE937C6B35", hash_generated_field = "B58C5793378449CBE5C2C8BE4F7C6D55")

        static final int LONG = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "200338FA85BEDB28DAC8352AA5AE44A4", hash_generated_field = "46B9B78E20B9DFB9C97B6EB5CDFC1710")

        static final int FLOAT = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "E4100D4E6A32B99A6ED6E650D26B96F2", hash_generated_field = "A4501BC529B3B3B1F619CD5B69F60BEE")

        static final int DOUBLE = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "96FA09B152FC2C89E35AFA1C6505581E", hash_generated_field = "A4E7D9D246B6685E9E73E853EFB843FD")

        static final int CHAR = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "DCF91BC1D8F95A60EADB6F7461F79F2F", hash_generated_field = "E2738C0FD157A27F299AA096F2698ED6")

        static final int STRING = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "05F84E42B3F9A0FC5577C866771D1B45", hash_generated_field = "8B88FAA46496AA9341BA2AC74905D8B7")

        static final int CHAR_SEQUENCE = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "5E83DCA62102A3D88F57C136FE6ACEB4", hash_generated_field = "677DE19774DF27A76E4807597BCCE25E")

        static final int URI = 11;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "FC84E30432EF9DDE7E9FCCE78BB199A8", hash_generated_field = "848B8557A665FAFDBC86FEF0A38BE2A4")

        static final int BITMAP = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "F0E8DF40A7799BB61150AD69A1A9F5A0", hash_generated_field = "C2775C8AD4009091E8937A7799C946C2")

        static final int BUNDLE = 13;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "16DB5856FD50B8563BDD95884F5D1670", hash_generated_field = "819B6EFDD2B1951BA1F12E14D3F5638F")

        static final int INTENT = 14;
    }


    
    private class ViewGroupAction extends Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "4471D27E06AC724B5DD676BEE05854BE", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.110 -0400", hash_original_field = "27197E3E0B6B9B7BF6E9F835C5A0621D", hash_generated_field = "94DAE06500F0010791F8161444D05A58")

        RemoteViews nestedViews;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.111 -0400", hash_original_method = "ED007F9070164016B2129A58A247A132", hash_generated_method = "D73E8FB5CE189E15CC0ED4BFC4DE2A01")
        public  ViewGroupAction(int viewId, RemoteViews nestedViews) {
            this.viewId = viewId;
            this.nestedViews = nestedViews;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.111 -0400", hash_original_method = "3800854E305111A2B59A893F31CDD286", hash_generated_method = "B30611565EF1A179397305FFFC39C3E2")
        public  ViewGroupAction(Parcel parcel) {
            viewId = parcel.readInt();
            nestedViews = parcel.readParcelable(null);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.111 -0400", hash_original_method = "BEE1FD608BE154882376BC772CDB35A0", hash_generated_method = "2C36F78EC0229561FD9888C386632C72")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeParcelable(nestedViews, 0 );
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.112 -0400", hash_original_method = "3F6E8B427E9FBCBDEBB4E654B5696B90", hash_generated_method = "C4E9B99CC0BA14AA422693C95219948F")
        @Override
        public void apply(View root, ViewGroup rootParent) {
            final Context context = root.getContext();
            final ViewGroup target = (ViewGroup) root.findViewById(viewId);
            {
                target.addView(nestedViews.apply(context, target));
            } 
            {
                target.removeAllViews();
            } 
            addTaint(root.getTaint());
            addTaint(rootParent.getTaint());
            
            
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.112 -0400", hash_original_method = "9A98BF9B0C4ADB9C4C041E3C0533F17D", hash_generated_method = "F6F275E3B989A13BBFC079B6191E960A")
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            {
                counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            } 
            addTaint(counter.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.112 -0400", hash_original_field = "1C67B632B385F0EED4F9EDC3A5442AB0", hash_generated_field = "BFAD764BA58FF98FFB009C9036CFE299")

        public final static int TAG = 4;
    }


    
    private class MemoryUsageCounter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.112 -0400", hash_original_field = "C36FDDE1E5252D085B64B1B7ADEDAD8C", hash_generated_field = "B0DA7A32C463859C81C00F4CE0F0F3CC")

        int mBitmapHeapMemoryUsage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.112 -0400", hash_original_method = "35D450C627251B011B80F5473DD04513", hash_generated_method = "35D450C627251B011B80F5473DD04513")
        public MemoryUsageCounter ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.113 -0400", hash_original_method = "F68FB7282799CC52F4314E5E47499FED", hash_generated_method = "980B3E80527B474B5039262E61BD9D48")
        public void clear() {
            mBitmapHeapMemoryUsage = 0;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.113 -0400", hash_original_method = "9C864F7ABFEE7832A18F21C728CCE23F", hash_generated_method = "583FD2D740DF0E423E81CC172F08A31C")
        public void bitmapIncrement(int numBytes) {
            mBitmapHeapMemoryUsage += numBytes;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.113 -0400", hash_original_method = "F4B214FD82765971EA3822C02AABA16F", hash_generated_method = "8720A7669ABD3B396A1DBB8CA2664855")
        public int getBitmapHeapMemoryUsage() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505455615 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505455615;
            
            
        }

        
    }


    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface RemoteView {
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.114 -0400", hash_original_field = "4C31F39A08DE2EFB8DEBBB394A3254D5", hash_generated_field = "ACEFF52037C84D6363407415280404F5")

    private static final String LOG_TAG = "RemoteViews";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.114 -0400", hash_original_field = "800952FE10AA9D0D47085F390E4ECC86", hash_generated_field = "826EFFDEC6B49221DB3B3AF9DDB20D89")

    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.114 -0400", hash_original_field = "3C81D1A6471DBF098FBC5010948AFD3D", hash_generated_field = "BD08AD711A0271B27E85FFB2A2737195")

    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() {
        public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    };
    
    public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }
    
    
    public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    
}

