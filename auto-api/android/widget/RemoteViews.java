package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private String mPackage;
    private int mLayoutId;
    private ArrayList<Action> mActions;
    private MemoryUsageCounter mMemoryUsageCounter;
    private boolean mIsWidgetCollectionChild = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.147 -0400", hash_original_method = "7ADC44A8B9BDF8C00FB4776840C5552D", hash_generated_method = "60CC8E9ECBD03C4F363A5BDCBFDDDB6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteViews(String packageName, int layoutId) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(layoutId);
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        // ---------- Original Method ----------
        //mPackage = packageName;
        //mLayoutId = layoutId;
        //mMemoryUsageCounter = new MemoryUsageCounter();
        //recalculateMemoryUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.148 -0400", hash_original_method = "B81662C8B479B3D3C957D533866FE808", hash_generated_method = "6D77797DBA422F6A9BCA254D5BE9E03E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteViews(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        mPackage = parcel.readString();
        mLayoutId = parcel.readInt();
        mIsWidgetCollectionChild = parcel.readInt() == 1 ? true : false;
        int count;
        count = parcel.readInt();
        {
            mActions = new ArrayList<Action>(count);
            {
                int i;
                i = 0;
                {
                    int tag;
                    tag = parcel.readInt();
                    //Begin case SetOnClickPendingIntent.TAG 
                    mActions.add(new SetOnClickPendingIntent(parcel));
                    //End case SetOnClickPendingIntent.TAG 
                    //Begin case SetDrawableParameters.TAG 
                    mActions.add(new SetDrawableParameters(parcel));
                    //End case SetDrawableParameters.TAG 
                    //Begin case ReflectionAction.TAG 
                    mActions.add(new ReflectionAction(parcel));
                    //End case ReflectionAction.TAG 
                    //Begin case ViewGroupAction.TAG 
                    mActions.add(new ViewGroupAction(parcel));
                    //End case ViewGroupAction.TAG 
                    //Begin case ReflectionActionWithoutParams.TAG 
                    mActions.add(new ReflectionActionWithoutParams(parcel));
                    //End case ReflectionActionWithoutParams.TAG 
                    //Begin case SetEmptyView.TAG 
                    mActions.add(new SetEmptyView(parcel));
                    //End case SetEmptyView.TAG 
                    //Begin case SetPendingIntentTemplate.TAG 
                    mActions.add(new SetPendingIntentTemplate(parcel));
                    //End case SetPendingIntentTemplate.TAG 
                    //Begin case SetOnClickFillInIntent.TAG 
                    mActions.add(new SetOnClickFillInIntent(parcel));
                    //End case SetOnClickFillInIntent.TAG 
                    //Begin case SetRemoteViewsAdapterIntent.TAG 
                    mActions.add(new SetRemoteViewsAdapterIntent(parcel));
                    //End case SetRemoteViewsAdapterIntent.TAG 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("Tag " + tag + " not found");
                    //End case default 
                } //End block
            } //End collapsed parenthetic
        } //End block
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.148 -0400", hash_original_method = "67D19BE5CA3BC69F21B2B2516A1FA2D6", hash_generated_method = "3C63D3D15A6A88E58B71514CBB620F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public RemoteViews clone() {
        RemoteViews that;
        that = new RemoteViews(mPackage, mLayoutId);
        {
            that.mActions = (ArrayList<Action>)mActions.clone();
        } //End block
        that.recalculateMemoryUsage();
        return (RemoteViews)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final RemoteViews that = new RemoteViews(mPackage, mLayoutId);
        //if (mActions != null) {
            //that.mActions = (ArrayList<Action>)mActions.clone();
        //}
        //that.recalculateMemoryUsage();
        //return that;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.148 -0400", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "2C04CA2E79DC80CA9002DD41D88C39A5")
    @DSModeled(DSC.SAFE)
    public String getPackage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.149 -0400", hash_original_method = "613C00C60CA896BC5001BD5561015459", hash_generated_method = "964B777F2B9977C8EBAE6C1AB6ADBD8D")
    @DSModeled(DSC.SAFE)
    public int getLayoutId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayoutId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.149 -0400", hash_original_method = "B2E01CE5E210E0306AAEDD7A25572B15", hash_generated_method = "47D68FB57A7D896FF1B3386A587378E4")
    @DSModeled(DSC.SAFE)
     void setIsWidgetCollectionChild(boolean isWidgetCollectionChild) {
        dsTaint.addTaint(isWidgetCollectionChild);
        // ---------- Original Method ----------
        //mIsWidgetCollectionChild = isWidgetCollectionChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.149 -0400", hash_original_method = "F73414915FBB974B28CE5BE7CD6B07B1", hash_generated_method = "9CB06F81C920E676592DB3B687829004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recalculateMemoryUsage() {
        mMemoryUsageCounter.clear();
        {
            int count;
            count = mActions.size();
            {
                int i;
                i = 0;
                {
                    mActions.get(i).updateMemoryUsageEstimate(mMemoryUsageCounter);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.149 -0400", hash_original_method = "4E1C2F916A403E6D1D4B708360B7D61A", hash_generated_method = "56566EE8F4725B1D0BCEFD76335BA2F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int estimateBitmapMemoryUsage() {
        int var86B2D4DC43E82BB120116366B3BFF3DD_1139034321 = (mMemoryUsageCounter.getBitmapHeapMemoryUsage());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMemoryUsageCounter.getBitmapHeapMemoryUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.149 -0400", hash_original_method = "17103049C6B2546A05BB76759DAB3B89", hash_generated_method = "F0084BB3088E83A4A46128D5D23CD9B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addAction(Action a) {
        dsTaint.addTaint(a.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "4A1BA0269DB90E506DB0959643DF475B", hash_generated_method = "57A3ED4A232390A1B348FA37FE0D5644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addView(int viewId, RemoteViews nestedView) {
        dsTaint.addTaint(nestedView.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new ViewGroupAction(viewId, nestedView));
        // ---------- Original Method ----------
        //addAction(new ViewGroupAction(viewId, nestedView));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "E70CF2F379D754A9B2BAC52704294677", hash_generated_method = "98E2A957B8688BB8DA1AEDA9928FC9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllViews(int viewId) {
        dsTaint.addTaint(viewId);
        addAction(new ViewGroupAction(viewId, null));
        // ---------- Original Method ----------
        //addAction(new ViewGroupAction(viewId, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "715372503FFB1BBD9EE3BEF4F54CECDE", hash_generated_method = "1518E0910A79EAA5FBB48FC6C53A1358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showNext(int viewId) {
        dsTaint.addTaint(viewId);
        addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
        // ---------- Original Method ----------
        //addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "92870339C0CC6AF77A420F74F896E688", hash_generated_method = "EBCE6DAAA3CB61BD2C5380F814B64ED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showPrevious(int viewId) {
        dsTaint.addTaint(viewId);
        addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
        // ---------- Original Method ----------
        //addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "D726270A4D4DC2D53B195715D168181D", hash_generated_method = "F1517E46D88387C970ACBF603FC7E9A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplayedChild(int viewId, int childIndex) {
        dsTaint.addTaint(childIndex);
        dsTaint.addTaint(viewId);
        setInt(viewId, "setDisplayedChild", childIndex);
        // ---------- Original Method ----------
        //setInt(viewId, "setDisplayedChild", childIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.150 -0400", hash_original_method = "DEE52A50DF8AF905161D8440F9C7FD6B", hash_generated_method = "EC90E067BF1FF240366C9441720B7ACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setViewVisibility(int viewId, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(viewId);
        setInt(viewId, "setVisibility", visibility);
        // ---------- Original Method ----------
        //setInt(viewId, "setVisibility", visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.151 -0400", hash_original_method = "5F8A789C1791A65B082D971694A97107", hash_generated_method = "23CC14973C651F6C132D1B867EAA2F0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextViewText(int viewId, CharSequence text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(viewId);
        setCharSequence(viewId, "setText", text);
        // ---------- Original Method ----------
        //setCharSequence(viewId, "setText", text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.151 -0400", hash_original_method = "BA7406E13895A91025A0507F41BF6313", hash_generated_method = "1D5EA0DD6161C30A09AF606B5D62B86E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImageViewResource(int viewId, int srcId) {
        dsTaint.addTaint(srcId);
        dsTaint.addTaint(viewId);
        setInt(viewId, "setImageResource", srcId);
        // ---------- Original Method ----------
        //setInt(viewId, "setImageResource", srcId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.151 -0400", hash_original_method = "433DFD276FBB02E0D7A2B8DA3B0F08D8", hash_generated_method = "F98922B6E8489BE0F0BB6098EE810FAD")
    @DSModeled(DSC.SPEC)
    public void setImageViewUri(int viewId, Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(viewId);
        setUri(viewId, "setImageURI", uri);
        // ---------- Original Method ----------
        //setUri(viewId, "setImageURI", uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.151 -0400", hash_original_method = "957E8B822330AC731DF30A1543908B02", hash_generated_method = "6F8721779B011117FA95A9DEA21641DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(viewId);
        setBitmap(viewId, "setImageBitmap", bitmap);
        // ---------- Original Method ----------
        //setBitmap(viewId, "setImageBitmap", bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.151 -0400", hash_original_method = "4F3E7FFD56A31D2F2A8813C161A91D32", hash_generated_method = "E6D9BFE0F5504D7E37D9B34AFFF155AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEmptyView(int viewId, int emptyViewId) {
        dsTaint.addTaint(emptyViewId);
        dsTaint.addTaint(viewId);
        addAction(new SetEmptyView(viewId, emptyViewId));
        // ---------- Original Method ----------
        //addAction(new SetEmptyView(viewId, emptyViewId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.152 -0400", hash_original_method = "47E59AC623A4BD9BB48A3F2CB501DFB4", hash_generated_method = "72CF08125F549B67791542C46DAA30ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChronometer(int viewId, long base, String format, boolean started) {
        dsTaint.addTaint(base);
        dsTaint.addTaint(started);
        dsTaint.addTaint(format);
        dsTaint.addTaint(viewId);
        setLong(viewId, "setBase", base);
        setString(viewId, "setFormat", format);
        setBoolean(viewId, "setStarted", started);
        // ---------- Original Method ----------
        //setLong(viewId, "setBase", base);
        //setString(viewId, "setFormat", format);
        //setBoolean(viewId, "setStarted", started);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.152 -0400", hash_original_method = "A929EFC8DD62C6A3F9A2F8FB0663D928", hash_generated_method = "CACFD9622F3B9D8B612E3FB86DE5BCC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProgressBar(int viewId, int max, int progress, 
            boolean indeterminate) {
        dsTaint.addTaint(progress);
        dsTaint.addTaint(max);
        dsTaint.addTaint(indeterminate);
        dsTaint.addTaint(viewId);
        setBoolean(viewId, "setIndeterminate", indeterminate);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.152 -0400", hash_original_method = "84C6A4280B6852D03015FA2AE8D65E64", hash_generated_method = "2EA16B4252BF2AB50A3E5AA6240E51F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnClickPendingIntent(int viewId, PendingIntent pendingIntent) {
        dsTaint.addTaint(pendingIntent.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
        // ---------- Original Method ----------
        //addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.152 -0400", hash_original_method = "A434A09AC636025A142B2CC781D07FF1", hash_generated_method = "FA357B1FC3B730244A0D3E2287AC6FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPendingIntentTemplate(int viewId, PendingIntent pendingIntentTemplate) {
        dsTaint.addTaint(pendingIntentTemplate.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
        // ---------- Original Method ----------
        //addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.152 -0400", hash_original_method = "899E714C9944265097024FA544BB7AC2", hash_generated_method = "D5C1E51BCC4F9AD3F2CC9EB2177FAC25")
    @DSModeled(DSC.SPEC)
    public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        dsTaint.addTaint(fillInIntent.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
        // ---------- Original Method ----------
        //addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.153 -0400", hash_original_method = "09A5B1AD4F222B569CE2E6BD5BF01B12", hash_generated_method = "7F86E790BEBEECC0430CE90FD953562C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDrawableParameters(int viewId, boolean targetBackground, int alpha,
            int colorFilter, PorterDuff.Mode mode, int level) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(targetBackground);
        dsTaint.addTaint(colorFilter);
        dsTaint.addTaint(mode.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                colorFilter, mode, level));
        // ---------- Original Method ----------
        //addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                //colorFilter, mode, level));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.153 -0400", hash_original_method = "F51B3B3FB58685A967056786739D5D5A", hash_generated_method = "73BC123F0F2497C53FE8CAF06C8D3C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextColor(int viewId, int color) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(viewId);
        setInt(viewId, "setTextColor", color);
        // ---------- Original Method ----------
        //setInt(viewId, "setTextColor", color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.153 -0400", hash_original_method = "F3196C5DB537F18A0B70CAAF74A09A0A", hash_generated_method = "BF51F0040E76D13ADABC6F86C0A7DC88")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(viewId);
        setRemoteAdapter(viewId, intent);
        // ---------- Original Method ----------
        //setRemoteAdapter(viewId, intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.153 -0400", hash_original_method = "9F000F17F0336123DB5D1DD3E4F67BE6", hash_generated_method = "6EAD41A57F7294DA1B28D8C83BAC04C4")
    @DSModeled(DSC.SPEC)
    public void setRemoteAdapter(int viewId, Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(viewId);
        addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
        // ---------- Original Method ----------
        //addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.153 -0400", hash_original_method = "15753F5F29C6091CCB595496C38B1963", hash_generated_method = "355BAD28E47A0A54A5C68CBAE704D3D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollPosition(int viewId, int position) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(viewId);
        setInt(viewId, "smoothScrollToPosition", position);
        // ---------- Original Method ----------
        //setInt(viewId, "smoothScrollToPosition", position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "62C951046FF905CA4D61721F847C4DC5", hash_generated_method = "1C2D105A14F59B1FDF4552B90464E5F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRelativeScrollPosition(int viewId, int offset) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(viewId);
        setInt(viewId, "smoothScrollByOffset", offset);
        // ---------- Original Method ----------
        //setInt(viewId, "smoothScrollByOffset", offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "ACF50C9E2E7A3E77B399A3E9AD77138B", hash_generated_method = "5913552C16DDBF2018142BB62F3600A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBoolean(int viewId, String methodName, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "6577642D84CE42EC3FAE93CD4A676A48", hash_generated_method = "E7D349A1462BA9BB5B5C3C0C2E78D85B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setByte(int viewId, String methodName, byte value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "1EF837BE87322E5A782B07EBE8F017ED", hash_generated_method = "BD4568B86CCC21EB74EC3D79A5E9A00B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShort(int viewId, String methodName, short value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "2BA2097F7597ED476DFE96444FF2B47B", hash_generated_method = "1D8A030673A758F63466DF65A55625F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInt(int viewId, String methodName, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.154 -0400", hash_original_method = "7BBB498795ABAEC2FC5C9E80D1FF1F8F", hash_generated_method = "B900F18541D4201AA612565B5E9B7220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLong(int viewId, String methodName, long value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.155 -0400", hash_original_method = "877DFBEE5EFFB4333EA4E3E01D628209", hash_generated_method = "D31F8F6632DBA6339DDE126228847D7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFloat(int viewId, String methodName, float value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.155 -0400", hash_original_method = "36511416C0ED3D737A57750DB7E0C821", hash_generated_method = "F69DFA1357135A5E5D9F95FE308C99D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDouble(int viewId, String methodName, double value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.155 -0400", hash_original_method = "E7DFE8EB27DC5DF6C76291F003DE876E", hash_generated_method = "78E477BD961B1EF856D67687DF0A87DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChar(int viewId, String methodName, char value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.155 -0400", hash_original_method = "12B33E0B58F238F52279DFEB1871046D", hash_generated_method = "6527CE726DF20235F6755311FB5A22FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setString(int viewId, String methodName, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.155 -0400", hash_original_method = "93A93353A27881B93F029E1CB8E38561", hash_generated_method = "C3ACE4866D322C8828C83162CE583F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCharSequence(int viewId, String methodName, CharSequence value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.156 -0400", hash_original_method = "33EE202B45F16FA5012E7C802B1E1162", hash_generated_method = "3833EC7FE6663EB6E86AEB5392978D44")
    @DSModeled(DSC.SPEC)
    public void setUri(int viewId, String methodName, Uri value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.156 -0400", hash_original_method = "BE18885A2548A0B5EB1C1E6420A7D63A", hash_generated_method = "0A9A134E9E4EBC97A719B278924B04D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBitmap(int viewId, String methodName, Bitmap value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.156 -0400", hash_original_method = "0BCEFBE1ECC6F937E30E64CCDC160671", hash_generated_method = "8AE06F7218674CFD98D9DABDCBAEF528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBundle(int viewId, String methodName, Bundle value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.156 -0400", hash_original_method = "1536FDACAD3B90F5944D61240D2247D6", hash_generated_method = "5BB7CA4A0667CBD0D66CDC75E3F35063")
    @DSModeled(DSC.SPEC)
    public void setIntent(int viewId, String methodName, Intent value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(methodName);
        dsTaint.addTaint(viewId);
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
        // ---------- Original Method ----------
        //addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.156 -0400", hash_original_method = "DAF30AB9823DD59C17B2FD226E498806", hash_generated_method = "A1347334315BA5FC6F3B9577D953824C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentDescription(int viewId, CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(viewId);
        setCharSequence(viewId, "setContentDescription", contentDescription);
        // ---------- Original Method ----------
        //setCharSequence(viewId, "setContentDescription", contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.157 -0400", hash_original_method = "389CE470D5FBF8918932B7CDEB2F38A1", hash_generated_method = "4B4C8173EF58F871C4AA63C1B60D6938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View apply(Context context, ViewGroup parent) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View result;
        Context c;
        c = prepareContext(context);
        LayoutInflater inflater;
        inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater = inflater.cloneInContext(c);
        inflater.setFilter(this);
        result = inflater.inflate(mLayoutId, parent, false);
        performApply(result, parent);
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.157 -0400", hash_original_method = "721D0331C9411BF86340BE2E97293121", hash_generated_method = "4CAD9CE3B4E857A0753AD54C3F03D150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reapply(Context context, View v) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        prepareContext(context);
        performApply(v, (ViewGroup) v.getParent());
        // ---------- Original Method ----------
        //prepareContext(context);
        //performApply(v, (ViewGroup) v.getParent());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.157 -0400", hash_original_method = "8E5E3E88ABCC69E3321D1346316340C9", hash_generated_method = "96C9794BAC1F2FF80E4BBFAD3D8E1BD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performApply(View v, ViewGroup parent) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        {
            int count;
            count = mActions.size();
            {
                int i;
                i = 0;
                {
                    Action a;
                    a = mActions.get(i);
                    a.apply(v, parent);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.157 -0400", hash_original_method = "22DA97EA1494F0F193EF18C8ED8C5634", hash_generated_method = "8B09E37709056D31099A1735A1559C2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Context prepareContext(Context context) {
        dsTaint.addTaint(context.dsTaint);
        Context c;
        String packageName;
        packageName = mPackage;
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
        {
            c = context;
        } //End block
        return (Context)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.157 -0400", hash_original_method = "02A046D25F4E9D374E474E21F6366163", hash_generated_method = "A31B92EC174A7A2FBAD0ED6BED3F5499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onLoadClass(Class clazz) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(clazz.dsTaint);
        boolean var240EFB7114C55D0ABD9923D7086CE184_314338534 = (clazz.isAnnotationPresent(RemoteView.class));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return clazz.isAnnotationPresent(RemoteView.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.158 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.158 -0400", hash_original_method = "E42048CF3CAA5A680CE684B09E27CD46", hash_generated_method = "4CC98633603FF6C80CD6FBAE6718BA68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mPackage);
        dest.writeInt(mLayoutId);
        dest.writeInt(mIsWidgetCollectionChild ? 1 : 0);
        int count;
        {
            count = mActions.size();
        } //End block
        {
            count = 0;
        } //End block
        dest.writeInt(count);
        {
            int i;
            i = 0;
            {
                Action a;
                a = mActions.get(i);
                a.writeToParcel(dest, 0);
            } //End block
        } //End collapsed parenthetic
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.158 -0400", hash_original_method = "4338C0B6ED05990B68F77B56C502C8BC", hash_generated_method = "FC31BCE83EC5177FF92AD6B226F4132C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActionException(Exception ex) {
            super(ex);
            dsTaint.addTaint(ex.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.158 -0400", hash_original_method = "E5DD8B85C6FF17BD695A219FDD405D42", hash_generated_method = "B56DA28E56FAE97CCA5E203F91F5F6B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ActionException(String message) {
            super(message);
            dsTaint.addTaint(message);
            // ---------- Original Method ----------
        }

        
    }


    
    private abstract static class Action implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.158 -0400", hash_original_method = "403706310EE1E789BB2B7D74B2F4A61D", hash_generated_method = "403706310EE1E789BB2B7D74B2F4A61D")
                public Action ()
        {
        }


        public abstract void apply(View root, ViewGroup rootParent) throws ActionException;

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.159 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.159 -0400", hash_original_method = "F71AEDBFF608C755FB28C9D45BA8F347", hash_generated_method = "61CCCFE7FF7E337990B723D159CB42F7")
        @DSModeled(DSC.SAFE)
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            dsTaint.addTaint(counter.dsTaint);
            // ---------- Original Method ----------
            //return;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.159 -0400", hash_original_method = "18203BE61B7EF9CD6501BEC6EAEF8812", hash_generated_method = "76D0DCB83C54BC309DB8B776F517A8A7")
        @DSModeled(DSC.SPEC)
        protected boolean startIntentSafely(Context context, PendingIntent pendingIntent,
                Intent fillInIntent) {
            dsTaint.addTaint(pendingIntent.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(fillInIntent.dsTaint);
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
            } //End block
            catch (Exception e)
            {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent due to " +
                        "unknown exception: ", e);
            } //End block
            return dsTaint.getTaintBoolean();
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
        int viewId;
        int emptyViewId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.159 -0400", hash_original_method = "16159C50F4CD599B644ED014E4EA0822", hash_generated_method = "F80168B2A13F2256B495C13CA57D3D97")
        @DSModeled(DSC.SAFE)
         SetEmptyView(int viewId, int emptyViewId) {
            dsTaint.addTaint(emptyViewId);
            dsTaint.addTaint(viewId);
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.emptyViewId = emptyViewId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.159 -0400", hash_original_method = "F10F16648F57CF9FE4F3D806E803B1DC", hash_generated_method = "870595C94DB2935332FBF4D6D8EF09E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SetEmptyView(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            this.viewId = in.readInt();
            this.emptyViewId = in.readInt();
            // ---------- Original Method ----------
            //this.viewId = in.readInt();
            //this.emptyViewId = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.160 -0400", hash_original_method = "1EA9A4CD3E90F19D62658919976BDCDF", hash_generated_method = "8D4453B9EA5833CDB00297782430E7C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeInt(this.emptyViewId);
            // ---------- Original Method ----------
            //out.writeInt(TAG);
            //out.writeInt(this.viewId);
            //out.writeInt(this.emptyViewId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.160 -0400", hash_original_method = "BC00C709904F6A7A06083DBEA360E136", hash_generated_method = "28EBEE94BEED1CBDA2D69B2C0364D774")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View view;
            view = root.findViewById(viewId);
            AdapterView<?> adapterView;
            adapterView = (AdapterView<?>) view;
            View emptyView;
            emptyView = root.findViewById(emptyViewId);
            adapterView.setEmptyView(emptyView);
            // ---------- Original Method ----------
            //final View view = root.findViewById(viewId);
            //if (!(view instanceof AdapterView<?>)) return;
            //AdapterView<?> adapterView = (AdapterView<?>) view;
            //final View emptyView = root.findViewById(emptyViewId);
            //if (emptyView == null) return;
            //adapterView.setEmptyView(emptyView);
        }

        
        public final static int TAG = 6;
    }


    
    private class SetOnClickFillInIntent extends Action {
        int viewId;
        Intent fillInIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.160 -0400", hash_original_method = "FE3667D87A305D86E9A8A6AD36F5EEAF", hash_generated_method = "CD714A1D3C0E7E2F796EC19AE2EC0953")
        @DSModeled(DSC.SPEC)
        public SetOnClickFillInIntent(int id, Intent fillInIntent) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(fillInIntent.dsTaint);
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.fillInIntent = fillInIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.160 -0400", hash_original_method = "8F893000547B59EAD09450FBC024CAC1", hash_generated_method = "DF646AF64EC77C3A49DBD92F835266EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SetOnClickFillInIntent(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            fillInIntent = Intent.CREATOR.createFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //fillInIntent = Intent.CREATOR.createFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.161 -0400", hash_original_method = "4A68D926F0B47E5C592025763C57CD49", hash_generated_method = "BD790B802673691532F13F3F6B6AB232")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            fillInIntent.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //fillInIntent.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.161 -0400", hash_original_method = "3474C680008284CA3FCD2C734DB61ED8", hash_generated_method = "54F80258D27457B5A4A5512AFB39A3AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View target;
            target = root.findViewById(viewId);
            {
                target.setTagInternal(com.android.internal.R.id.fillInIntent, fillInIntent);
            } //End block
            {
                OnClickListener listener;
                listener = new OnClickListener() {
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

        
        public final static int TAG = 9;
    }


    
    private class SetPendingIntentTemplate extends Action {
        int viewId;
        PendingIntent pendingIntentTemplate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.161 -0400", hash_original_method = "319DBBF9EE021BC2BD14552E08C5F806", hash_generated_method = "E2BCFEBE4682E2BF69990FB0FC48BC3D")
        @DSModeled(DSC.SAFE)
        public SetPendingIntentTemplate(int id, PendingIntent pendingIntentTemplate) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(pendingIntentTemplate.dsTaint);
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.pendingIntentTemplate = pendingIntentTemplate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.161 -0400", hash_original_method = "F35BA9665B1C6E88223062D1328FA579", hash_generated_method = "4EF4113F4314769A4196DBA1A2265A23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SetPendingIntentTemplate(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.162 -0400", hash_original_method = "2DE56D1052D41AEA85684029786EA581", hash_generated_method = "8B507517FF259A72DEB4FA608E4B5859")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntentTemplate.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //pendingIntentTemplate.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.162 -0400", hash_original_method = "BC6383FD3782B4E4299FBBF52DF5CBB4", hash_generated_method = "6F759EBAF2806BAFA93B8B3430323332")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View target;
            target = root.findViewById(viewId);
            {
                AdapterView<?> av;
                av = (AdapterView<?>) target;
                OnItemClickListener listener;
                listener = new OnItemClickListener() {
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public final static int TAG = 8;
    }


    
    private class SetRemoteViewsAdapterIntent extends Action {
        int viewId;
        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.162 -0400", hash_original_method = "2562242EF5AD42CD0339F4CFA0A5651B", hash_generated_method = "9B50A2DB22D2AE26F677473198A8559C")
        @DSModeled(DSC.SPEC)
        public SetRemoteViewsAdapterIntent(int id, Intent intent) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(intent.dsTaint);
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.intent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.162 -0400", hash_original_method = "3062D841F9A527FF82C19CE8ED4DF47C", hash_generated_method = "7CA7AC923F28EA93790C0030DCB6CFCF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SetRemoteViewsAdapterIntent(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            intent = Intent.CREATOR.createFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //intent = Intent.CREATOR.createFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.163 -0400", hash_original_method = "F580FE61025C5DC81DFB7BB9EA905954", hash_generated_method = "DF23E0E8C658C699BB7DB37AC6A37B82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            intent.writeToParcel(dest, flags);
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //intent.writeToParcel(dest, flags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.163 -0400", hash_original_method = "EDE9247E350EBAB87917A7616D3465DB", hash_generated_method = "3914A38857F58AC86672DA687DDC148C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View target;
            target = root.findViewById(viewId);
            AppWidgetHostView host;
            host = (AppWidgetHostView) rootParent;
            intent.putExtra(EXTRA_REMOTEADAPTER_APPWIDGET_ID, host.getAppWidgetId());
            {
                AbsListView v;
                v = (AbsListView) target;
                v.setRemoteViewsAdapter(intent);
            } //End block
            {
                AdapterViewAnimator v;
                v = (AdapterViewAnimator) target;
                v.setRemoteViewsAdapter(intent);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public final static int TAG = 10;
    }


    
    private class SetOnClickPendingIntent extends Action {
        int viewId;
        PendingIntent pendingIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.164 -0400", hash_original_method = "66EA2688C4B0F29524FFED0B8D1C4557", hash_generated_method = "36FDC3FFC43DDBDBB5D70022496FC5F5")
        @DSModeled(DSC.SAFE)
        public SetOnClickPendingIntent(int id, PendingIntent pendingIntent) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(pendingIntent.dsTaint);
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.pendingIntent = pendingIntent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.164 -0400", hash_original_method = "2D335FA6E397EB90FCE69134FAC6C0E6", hash_generated_method = "1D89F7ACDA6035863336D09716D5B387")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SetOnClickPendingIntent(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.165 -0400", hash_original_method = "7CEF806B95F0881A888E5DFCE712AF4A", hash_generated_method = "1C2DA8DC92427D22B8D8D3FCE156738F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntent.writeToParcel(dest, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //pendingIntent.writeToParcel(dest, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.165 -0400", hash_original_method = "7AB558D2EB1905941BBC96768E4F0260", hash_generated_method = "E2A2B61013B0F15518D4C45898EC7FE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View target;
            target = root.findViewById(viewId);
            {
                OnClickListener listener;
                listener = new OnClickListener() {
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

        
        public final static int TAG = 1;
    }


    
    private class SetDrawableParameters extends Action {
        int viewId;
        boolean targetBackground;
        int alpha;
        int colorFilter;
        PorterDuff.Mode filterMode;
        int level;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.165 -0400", hash_original_method = "18564016E13252E4F53F65794EE2D4BB", hash_generated_method = "0447B0461A683A394B1F35FC76CD4846")
        @DSModeled(DSC.SAFE)
        public SetDrawableParameters(int id, boolean targetBackground, int alpha,
                int colorFilter, PorterDuff.Mode mode, int level) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(level);
            dsTaint.addTaint(alpha);
            dsTaint.addTaint(targetBackground);
            dsTaint.addTaint(colorFilter);
            dsTaint.addTaint(mode.dsTaint);
            // ---------- Original Method ----------
            //this.viewId = id;
            //this.targetBackground = targetBackground;
            //this.alpha = alpha;
            //this.colorFilter = colorFilter;
            //this.filterMode = mode;
            //this.level = level;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.166 -0400", hash_original_method = "72E671F08A71584E9232C176B97BC1C8", hash_generated_method = "7E9C5316D07B5E658195497CBF57EEFF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SetDrawableParameters(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            targetBackground = parcel.readInt() != 0;
            alpha = parcel.readInt();
            colorFilter = parcel.readInt();
            boolean hasMode;
            hasMode = parcel.readInt() != 0;
            {
                filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.166 -0400", hash_original_method = "DC629CA06C171381152FF8641B977C9F", hash_generated_method = "8AB62673FE3D72E844D509666C50C8AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeInt(targetBackground ? 1 : 0);
            dest.writeInt(alpha);
            dest.writeInt(colorFilter);
            {
                dest.writeInt(1);
                dest.writeString(filterMode.toString());
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.167 -0400", hash_original_method = "2B7DD23B0EB7FE8C6A2446FEC1367E7F", hash_generated_method = "DF04D8420CC9CEDAF6CFAD425C6222A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View target;
            target = root.findViewById(viewId);
            Drawable targetDrawable;
            targetDrawable = null;
            {
                targetDrawable = target.getBackground();
            } //End block
            {
                ImageView imageView;
                imageView = (ImageView) target;
                targetDrawable = imageView.getDrawable();
            } //End block
            {
                {
                    targetDrawable.setAlpha(alpha);
                } //End block
                {
                    targetDrawable.setColorFilter(colorFilter, filterMode);
                } //End block
                {
                    targetDrawable.setLevel(level);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public final static int TAG = 3;
    }


    
    private class ReflectionActionWithoutParams extends Action {
        int viewId;
        String methodName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.167 -0400", hash_original_method = "9825933434EF5EC003AA8FF50203783A", hash_generated_method = "50D41CDF5924DDBD7A7382CE81DF9DDE")
        @DSModeled(DSC.SAFE)
         ReflectionActionWithoutParams(int viewId, String methodName) {
            dsTaint.addTaint(methodName);
            dsTaint.addTaint(viewId);
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.methodName = methodName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.167 -0400", hash_original_method = "07A57AEC1ECBD4F4EF962F6964A9C9CB", hash_generated_method = "5975FD0F5282C4FF0F7260F947084637")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ReflectionActionWithoutParams(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            this.viewId = in.readInt();
            this.methodName = in.readString();
            // ---------- Original Method ----------
            //this.viewId = in.readInt();
            //this.methodName = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.167 -0400", hash_original_method = "E92934B0244E59AB6D933016F95632D8", hash_generated_method = "45AF60CE0CA4D7BE5BCD0BBAE82A6578")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            // ---------- Original Method ----------
            //out.writeInt(TAG);
            //out.writeInt(this.viewId);
            //out.writeString(this.methodName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.168 -0400", hash_original_method = "B2755AE6CC74346ED57BF443914C2243", hash_generated_method = "598AAA9A0FE9D2C351A0DB41B282A11D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View view;
            view = root.findViewById(viewId);
            Class klass;
            klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName);
            } //End block
            catch (NoSuchMethodException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "()");
            } //End block
            {
                boolean varDF1EFAF7A9352F1C3347271AD170B8BD_2109833456 = (!method.isAnnotationPresent(RemotableViewMethod.class));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "()");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "()");
                } //End block
                method.invoke(view);
            } //End block
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException(ex);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public final static int TAG = 5;
    }


    
    private class ReflectionAction extends Action {
        int viewId;
        String methodName;
        int type;
        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.168 -0400", hash_original_method = "C4E3EC196FB78FDD2AFD41CF23C84256", hash_generated_method = "8A5C28755A7F2108799F65F24227D90D")
        @DSModeled(DSC.SAFE)
         ReflectionAction(int viewId, String methodName, int type, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(type);
            dsTaint.addTaint(methodName);
            dsTaint.addTaint(viewId);
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.methodName = methodName;
            //this.type = type;
            //this.value = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.168 -0400", hash_original_method = "A86C68C4FD8B9D479580CAEA2D14C9BF", hash_generated_method = "741AEE0D81D70576963C07332E035172")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ReflectionAction(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            this.viewId = in.readInt();
            this.methodName = in.readString();
            this.type = in.readInt();
            {
                Log.d("RemoteViews", "read viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } //End block
            //Begin case BOOLEAN 
            this.value = in.readInt() != 0;
            //End case BOOLEAN 
            //Begin case BYTE 
            this.value = in.readByte();
            //End case BYTE 
            //Begin case SHORT 
            this.value = (short)in.readInt();
            //End case SHORT 
            //Begin case INT 
            this.value = in.readInt();
            //End case INT 
            //Begin case LONG 
            this.value = in.readLong();
            //End case LONG 
            //Begin case FLOAT 
            this.value = in.readFloat();
            //End case FLOAT 
            //Begin case DOUBLE 
            this.value = in.readDouble();
            //End case DOUBLE 
            //Begin case CHAR 
            this.value = (char)in.readInt();
            //End case CHAR 
            //Begin case STRING 
            this.value = in.readString();
            //End case STRING 
            //Begin case CHAR_SEQUENCE 
            this.value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //End case CHAR_SEQUENCE 
            //Begin case URI 
            this.value = Uri.CREATOR.createFromParcel(in);
            //End case URI 
            //Begin case BITMAP 
            this.value = Bitmap.CREATOR.createFromParcel(in);
            //End case BITMAP 
            //Begin case BUNDLE 
            this.value = in.readBundle();
            //End case BUNDLE 
            //Begin case INTENT 
            this.value = Intent.CREATOR.createFromParcel(in);
            //End case INTENT 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.169 -0400", hash_original_method = "F759DD8CB1A89B34D073177D219BFFB9", hash_generated_method = "92D5C9C5AE6F63160EC6DA5846DB0F73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            out.writeInt(this.type);
            {
                Log.d("RemoteViews", "write viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            } //End block
            //Begin case BOOLEAN 
            out.writeInt((Boolean) this.value ? 1 : 0);
            //End case BOOLEAN 
            //Begin case BYTE 
            out.writeByte((Byte) this.value);
            //End case BYTE 
            //Begin case SHORT 
            out.writeInt((Short) this.value);
            //End case SHORT 
            //Begin case INT 
            out.writeInt((Integer) this.value);
            //End case INT 
            //Begin case LONG 
            out.writeLong((Long) this.value);
            //End case LONG 
            //Begin case FLOAT 
            out.writeFloat((Float) this.value);
            //End case FLOAT 
            //Begin case DOUBLE 
            out.writeDouble((Double) this.value);
            //End case DOUBLE 
            //Begin case CHAR 
            out.writeInt((int)((Character)this.value).charValue());
            //End case CHAR 
            //Begin case STRING 
            out.writeString((String)this.value);
            //End case STRING 
            //Begin case CHAR_SEQUENCE 
            TextUtils.writeToParcel((CharSequence)this.value, out, flags);
            //End case CHAR_SEQUENCE 
            //Begin case URI 
            ((Uri)this.value).writeToParcel(out, flags);
            //End case URI 
            //Begin case BITMAP 
            ((Bitmap)this.value).writeToParcel(out, flags);
            //End case BITMAP 
            //Begin case BUNDLE 
            out.writeBundle((Bundle) this.value);
            //End case BUNDLE 
            //Begin case INTENT 
            ((Intent)this.value).writeToParcel(out, flags);
            //End case INTENT 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.169 -0400", hash_original_method = "E66E0BF97844CCF37DCED039A425AFDA", hash_generated_method = "7D1167B754B8AC69B1B7040607C55A70")
        @DSModeled(DSC.SAFE)
        private Class getParameterType() {
            return (Class)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.170 -0400", hash_original_method = "008B98D7581EEC47326A699C8B3D8035", hash_generated_method = "60A0869BA3137CBBB680AD5A2DC273DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            View view;
            view = root.findViewById(viewId);
            Class param;
            param = getParameterType();
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException("bad type: " + this.type);
            } //End block
            Class klass;
            klass = view.getClass();
            Method method;
            try 
            {
                method = klass.getMethod(this.methodName, getParameterType());
            } //End block
            catch (NoSuchMethodException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "(" + param.getName() + ")");
            } //End block
            {
                boolean varDF1EFAF7A9352F1C3347271AD170B8BD_673575302 = (!method.isAnnotationPresent(RemotableViewMethod.class));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "(" + param.getName() + ")");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "(" + param.getName() + ") with "
                        + (this.value == null ? "null" : this.value.getClass().getName()));
                } //End block
                method.invoke(view, this.value);
            } //End block
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ActionException(ex);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.170 -0400", hash_original_method = "1F301B790026760CE401FF57484A4A78", hash_generated_method = "A123A9D237427B5BBEA84CD4DD7D25D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            dsTaint.addTaint(counter.dsTaint);
            //Begin case BITMAP 
            {
                Bitmap b;
                b = (Bitmap) this.value;
                Bitmap.Config c;
                c = b.getConfig();
                int bpp;
                bpp = 4;
                {
                    //Begin case ALPHA_8 
                    bpp = 1;
                    //End case ALPHA_8 
                    //Begin case RGB_565 ARGB_4444 
                    bpp = 2;
                    //End case RGB_565 ARGB_4444 
                    //Begin case ARGB_8888 
                    bpp = 4;
                    //End case ARGB_8888 
                } //End block
                counter.bitmapIncrement(b.getWidth() * b.getHeight() * bpp);
            } //End block
            //End case BITMAP 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static final int TAG = 2;
        static final int BOOLEAN = 1;
        static final int BYTE = 2;
        static final int SHORT = 3;
        static final int INT = 4;
        static final int LONG = 5;
        static final int FLOAT = 6;
        static final int DOUBLE = 7;
        static final int CHAR = 8;
        static final int STRING = 9;
        static final int CHAR_SEQUENCE = 10;
        static final int URI = 11;
        static final int BITMAP = 12;
        static final int BUNDLE = 13;
        static final int INTENT = 14;
    }


    
    private class ViewGroupAction extends Action {
        int viewId;
        RemoteViews nestedViews;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "ED007F9070164016B2129A58A247A132", hash_generated_method = "0A419CA02F9C78AD6A7317CF4B9134E9")
        @DSModeled(DSC.SAFE)
        public ViewGroupAction(int viewId, RemoteViews nestedViews) {
            dsTaint.addTaint(nestedViews.dsTaint);
            dsTaint.addTaint(viewId);
            // ---------- Original Method ----------
            //this.viewId = viewId;
            //this.nestedViews = nestedViews;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "3800854E305111A2B59A893F31CDD286", hash_generated_method = "18EDFABC7D14E06098B25E532540CCF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ViewGroupAction(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            viewId = parcel.readInt();
            nestedViews = parcel.readParcelable(null);
            // ---------- Original Method ----------
            //viewId = parcel.readInt();
            //nestedViews = parcel.readParcelable(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "BEE1FD608BE154882376BC772CDB35A0", hash_generated_method = "792901203CDB03E79E06F37DD1D6AAD7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeParcelable(nestedViews, 0 );
            // ---------- Original Method ----------
            //dest.writeInt(TAG);
            //dest.writeInt(viewId);
            //dest.writeParcelable(nestedViews, 0 );
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "3F6E8B427E9FBCBDEBB4E654B5696B90", hash_generated_method = "DEF9C852CA3D4635DE230F1B584E8E9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void apply(View root, ViewGroup rootParent) {
            dsTaint.addTaint(rootParent.dsTaint);
            dsTaint.addTaint(root.dsTaint);
            Context context;
            context = root.getContext();
            ViewGroup target;
            target = (ViewGroup) root.findViewById(viewId);
            {
                target.addView(nestedViews.apply(context, target));
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "9A98BF9B0C4ADB9C4C041E3C0533F17D", hash_generated_method = "0C56980DCE7683460282D08E07032C10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            dsTaint.addTaint(counter.dsTaint);
            {
                counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            } //End block
            // ---------- Original Method ----------
            //if (nestedViews != null) {
                //counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            //}
        }

        
        public final static int TAG = 4;
    }


    
    private class MemoryUsageCounter {
        int mBitmapHeapMemoryUsage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.171 -0400", hash_original_method = "D79B70233D0F444DC6CD2E4D4BEF9353", hash_generated_method = "D79B70233D0F444DC6CD2E4D4BEF9353")
                public MemoryUsageCounter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.172 -0400", hash_original_method = "F68FB7282799CC52F4314E5E47499FED", hash_generated_method = "980B3E80527B474B5039262E61BD9D48")
        @DSModeled(DSC.SAFE)
        public void clear() {
            mBitmapHeapMemoryUsage = 0;
            // ---------- Original Method ----------
            //mBitmapHeapMemoryUsage = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.172 -0400", hash_original_method = "9C864F7ABFEE7832A18F21C728CCE23F", hash_generated_method = "ED1779ECE7150AC4E7D9605553FF4DEC")
        @DSModeled(DSC.SAFE)
        public void bitmapIncrement(int numBytes) {
            dsTaint.addTaint(numBytes);
            // ---------- Original Method ----------
            //mBitmapHeapMemoryUsage += numBytes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.172 -0400", hash_original_method = "F4B214FD82765971EA3822C02AABA16F", hash_generated_method = "C3DB0D43EAFC3A76235B82CAB4180887")
        @DSModeled(DSC.SAFE)
        public int getBitmapHeapMemoryUsage() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBitmapHeapMemoryUsage;
        }

        
    }


    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface RemoteView {
    }
    
    private static final String LOG_TAG = "RemoteViews";
    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.172 -0400", hash_original_method = "FC3F962DDEC04FB3CB8064B237D4AD2E", hash_generated_method = "AEEA278537925FF27B5C1B7E8C677956")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViews createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            RemoteViews var3129541F19618C42D761A722FAEC06DC_546784915 = (new RemoteViews(parcel));
            return (RemoteViews)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RemoteViews(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.172 -0400", hash_original_method = "955BCE822B5031BBA9175A15F8CAAE63", hash_generated_method = "948DD433E4AA6250321CA387DA6B05F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RemoteViews[] newArray(int size) {
            dsTaint.addTaint(size);
            RemoteViews[] var93771BC30AEAA8ED21CD1E5E2DC64B02_94445610 = (new RemoteViews[size]);
            return (RemoteViews[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RemoteViews[size];
        }

        
}; //Transformed anonymous class
}

