package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import android.view.LayoutInflater.Filter;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;

public class RemoteViews implements Parcelable, Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.692 -0500", hash_original_field = "6FFEE8307332734755C14FC024A174EA", hash_generated_field = "ACEFF52037C84D6363407415280404F5")
    
    private static final String LOG_TAG = "RemoteViews";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.695 -0500", hash_original_field = "EF36B82D9AB59A0445BDFC5E58DBC652", hash_generated_field = "826EFFDEC6B49221DB3B3AF9DDB20D89")

    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.797 -0400", hash_original_field = "3C81D1A6471DBF098FBC5010948AFD3D", hash_generated_field = "BD08AD711A0271B27E85FFB2A2737195")

    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.117 -0500", hash_original_method = "FC3F962DDEC04FB3CB8064B237D4AD2E", hash_generated_method = "6E797158973DFFCE7F4F903A273D2687")
        
public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.119 -0500", hash_original_method = "955BCE822B5031BBA9175A15F8CAAE63", hash_generated_method = "F03F8A1BD2C5B320722EDF0EED69E1DF")
        
public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.697 -0500", hash_original_field = "024AAB9E2577CC3DE3304162F102B92C", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private  String mPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.700 -0500", hash_original_field = "8620DD624D5ABA6759B557835C5EB379", hash_generated_field = "62824B28582365160D4F4E663AF78109")

    private  int mLayoutId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.702 -0500", hash_original_field = "27E08896D7C631DE7F16C341DD4B835A", hash_generated_field = "BDB8276C1ABE28FC56F7F2EFF4E83F5A")

    private ArrayList<Action> mActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.704 -0500", hash_original_field = "3160C7467AA060612EFEBDBF119579B8", hash_generated_field = "428BAA212C6DEB5FEF7CB6370C9BEBDF")

    private MemoryUsageCounter mMemoryUsageCounter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.706 -0500", hash_original_field = "6E05C1C57ECF91F851A5EC7A7D4545B0", hash_generated_field = "5F2713F2C4461A89B34556F5FA319D47")

     private boolean mIsWidgetCollectionChild = false;

    /**
     * Create a new RemoteViews object that will display the views contained
     * in the specified layout file.
     * 
     * @param packageName Name of the package that contains the layout resource
     * @param layoutId The id of the layout resource
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.997 -0500", hash_original_method = "7ADC44A8B9BDF8C00FB4776840C5552D", hash_generated_method = "CCC49EDBEBEE8FE5F22E011E1EB338ED")
    
public RemoteViews(String packageName, int layoutId) {
        mPackage = packageName;
        mLayoutId = layoutId;

        // setup the memory usage statistics
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
    }

    /**
     * Reads a RemoteViews object from a parcel.
     * 
     * @param parcel
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.000 -0500", hash_original_method = "B81662C8B479B3D3C957D533866FE808", hash_generated_method = "0F60A5162E795F91957BC687802EF6F8")
    
public RemoteViews(Parcel parcel) {
        mPackage = parcel.readString();
        mLayoutId = parcel.readInt();
        mIsWidgetCollectionChild = parcel.readInt() == 1 ? true : false;

        int count = parcel.readInt();
        if (count > 0) {
            mActions = new ArrayList<Action>(count);
            for (int i=0; i<count; i++) {
                int tag = parcel.readInt();
                switch (tag) {
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
                    throw new ActionException("Tag " + tag + " not found");
                }
            }
        }

        // setup the memory usage statistics
        mMemoryUsageCounter = new MemoryUsageCounter();
        recalculateMemoryUsage();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.002 -0500", hash_original_method = "67D19BE5CA3BC69F21B2B2516A1FA2D6", hash_generated_method = "8D0A90225DBD95CD017FA44B645E3963")
    
@Override
    public RemoteViews clone() {
        final RemoteViews that = new RemoteViews(mPackage, mLayoutId);
        if (mActions != null) {
            that.mActions = (ArrayList<Action>)mActions.clone();
        }

        // update the memory usage stats of the cloned RemoteViews
        that.recalculateMemoryUsage();
        return that;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.004 -0500", hash_original_method = "D6B19F05A1BF219922EA06A43EF822A3", hash_generated_method = "E8E7BB1D5101EA7BCE0E9136023EF604")
    
public String getPackage() {
        return mPackage;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.007 -0500", hash_original_method = "613C00C60CA896BC5001BD5561015459", hash_generated_method = "2A8D7E72D3595B0AF66976D61F3F9022")
    
public int getLayoutId() {
        return mLayoutId;
    }

    /*
     * This flag indicates whether this RemoteViews object is being created from a
     * RemoteViewsService for use as a child of a widget collection. This flag is used
     * to determine whether or not certain features are available, in particular,
     * setting on click extras and setting on click pending intents. The former is enabled,
     * and the latter disabled when this flag is true.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.009 -0500", hash_original_method = "B2E01CE5E210E0306AAEDD7A25572B15", hash_generated_method = "B2E01CE5E210E0306AAEDD7A25572B15")
    
void setIsWidgetCollectionChild(boolean isWidgetCollectionChild) {
        mIsWidgetCollectionChild = isWidgetCollectionChild;
    }

    /**
     * Updates the memory usage statistics.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.011 -0500", hash_original_method = "F73414915FBB974B28CE5BE7CD6B07B1", hash_generated_method = "2B95E3882DC6BD034FE284736EA883CE")
    
private void recalculateMemoryUsage() {
        mMemoryUsageCounter.clear();

        // Accumulate the memory usage for each action
        if (mActions != null) {
            final int count = mActions.size();
            for (int i= 0; i < count; ++i) {
                mActions.get(i).updateMemoryUsageEstimate(mMemoryUsageCounter);
            }
        }
    }

    /**
     * Returns an estimate of the bitmap heap memory usage for this RemoteViews.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.013 -0500", hash_original_method = "4E1C2F916A403E6D1D4B708360B7D61A", hash_generated_method = "4E1C2F916A403E6D1D4B708360B7D61A")
    
int estimateBitmapMemoryUsage() {
        return mMemoryUsageCounter.getBitmapHeapMemoryUsage();
    }

    /**
     * Add an action to be executed on the remote side when apply is called.
     * 
     * @param a The action to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.015 -0500", hash_original_method = "17103049C6B2546A05BB76759DAB3B89", hash_generated_method = "270A5CA4396D3DA65EF36BE4500A016F")
    
private void addAction(Action a) {
        if (mActions == null) {
            mActions = new ArrayList<Action>();
        }
        mActions.add(a);

        // update the memory usage stats
        a.updateMemoryUsageEstimate(mMemoryUsageCounter);
    }

    /**
     * Equivalent to calling {@link ViewGroup#addView(View)} after inflating the
     * given {@link RemoteViews}. This allows users to build "nested"
     * {@link RemoteViews}. In cases where consumers of {@link RemoteViews} may
     * recycle layouts, use {@link #removeAllViews(int)} to clear any existing
     * children.
     *
     * @param viewId The id of the parent {@link ViewGroup} to add child into.
     * @param nestedView {@link RemoteViews} that describes the child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.017 -0500", hash_original_method = "4A1BA0269DB90E506DB0959643DF475B", hash_generated_method = "4886D770A7C3676B878E94B59BBB7E59")
    
public void addView(int viewId, RemoteViews nestedView) {
        addAction(new ViewGroupAction(viewId, nestedView));
    }

    /**
     * Equivalent to calling {@link ViewGroup#removeAllViews()}.
     *
     * @param viewId The id of the parent {@link ViewGroup} to remove all
     *            children from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.020 -0500", hash_original_method = "E70CF2F379D754A9B2BAC52704294677", hash_generated_method = "E327FE5A66D475AA2BFDABFFE1E15FE2")
    
public void removeAllViews(int viewId) {
        addAction(new ViewGroupAction(viewId, null));
    }

    /**
     * Equivalent to calling {@link AdapterViewAnimator#showNext()}
     *
     * @param viewId The id of the view on which to call {@link AdapterViewAnimator#showNext()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.022 -0500", hash_original_method = "715372503FFB1BBD9EE3BEF4F54CECDE", hash_generated_method = "66BA43190B0FD70FFBC0C77681AD53D1")
    
public void showNext(int viewId) {
        addAction(new ReflectionActionWithoutParams(viewId, "showNext"));
    }

    /**
     * Equivalent to calling {@link AdapterViewAnimator#showPrevious()}
     *
     * @param viewId The id of the view on which to call {@link AdapterViewAnimator#showPrevious()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.024 -0500", hash_original_method = "92870339C0CC6AF77A420F74F896E688", hash_generated_method = "29B958FA8B9174A63CFFF2A84D49A809")
    
public void showPrevious(int viewId) {
        addAction(new ReflectionActionWithoutParams(viewId, "showPrevious"));
    }

    /**
     * Equivalent to calling {@link AdapterViewAnimator#setDisplayedChild(int)}
     *
     * @param viewId The id of the view on which to call
     *               {@link AdapterViewAnimator#setDisplayedChild(int)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.026 -0500", hash_original_method = "D726270A4D4DC2D53B195715D168181D", hash_generated_method = "681FBA6691958B49B5276151E20D3578")
    
public void setDisplayedChild(int viewId, int childIndex) {
        setInt(viewId, "setDisplayedChild", childIndex);
    }

    /**
     * Equivalent to calling View.setVisibility
     * 
     * @param viewId The id of the view whose visibility should change
     * @param visibility The new visibility for the view
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.028 -0500", hash_original_method = "DEE52A50DF8AF905161D8440F9C7FD6B", hash_generated_method = "D35680D2C11D87B825D492B72945A47A")
    
public void setViewVisibility(int viewId, int visibility) {
        setInt(viewId, "setVisibility", visibility);
    }

    /**
     * Equivalent to calling TextView.setText
     * 
     * @param viewId The id of the view whose text should change
     * @param text The new text for the view
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.030 -0500", hash_original_method = "5F8A789C1791A65B082D971694A97107", hash_generated_method = "775D8E18D63705C8DCFC41111F9CBAE4")
    
public void setTextViewText(int viewId, CharSequence text) {
        setCharSequence(viewId, "setText", text);
    }
    
    /**
     * Equivalent to calling ImageView.setImageResource
     * 
     * @param viewId The id of the view whose drawable should change
     * @param srcId The new resource id for the drawable
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.032 -0500", hash_original_method = "BA7406E13895A91025A0507F41BF6313", hash_generated_method = "DBB6736C78776F4BCF9F89E2FEF0F799")
    
public void setImageViewResource(int viewId, int srcId) {   
        setInt(viewId, "setImageResource", srcId);
    }

    /**
     * Equivalent to calling ImageView.setImageURI
     * 
     * @param viewId The id of the view whose drawable should change
     * @param uri The Uri for the image
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.036 -0500", hash_original_method = "433DFD276FBB02E0D7A2B8DA3B0F08D8", hash_generated_method = "94D346594F571696B4CA207279C9B47E")
    
public void setImageViewUri(int viewId, Uri uri) {
        setUri(viewId, "setImageURI", uri);
    }

    /**
     * Equivalent to calling ImageView.setImageBitmap
     * 
     * @param viewId The id of the view whose drawable should change
     * @param bitmap The new Bitmap for the drawable
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.038 -0500", hash_original_method = "957E8B822330AC731DF30A1543908B02", hash_generated_method = "2339F9736A2AA7B946C7F32C608E9209")
    
public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        setBitmap(viewId, "setImageBitmap", bitmap);
    }

    /**
     * Equivalent to calling AdapterView.setEmptyView
     *
     * @param viewId The id of the view on which to set the empty view
     * @param emptyViewId The view id of the empty view
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.040 -0500", hash_original_method = "4F3E7FFD56A31D2F2A8813C161A91D32", hash_generated_method = "555A8322A72B254BF8C8DD9363F42F69")
    
public void setEmptyView(int viewId, int emptyViewId) {
        addAction(new SetEmptyView(viewId, emptyViewId));
    }

    /**
     * Equivalent to calling {@link Chronometer#setBase Chronometer.setBase},
     * {@link Chronometer#setFormat Chronometer.setFormat},
     * and {@link Chronometer#start Chronometer.start()} or
     * {@link Chronometer#stop Chronometer.stop()}.
     * 
     * @param viewId The id of the view whose text should change
     * @param base The time at which the timer would have read 0:00.  This
     *             time should be based off of
     *             {@link android.os.SystemClock#elapsedRealtime SystemClock.elapsedRealtime()}.
     * @param format The Chronometer format string, or null to
     *               simply display the timer value.
     * @param started True if you want the clock to be started, false if not.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.042 -0500", hash_original_method = "47E59AC623A4BD9BB48A3F2CB501DFB4", hash_generated_method = "038C89AFF2AE81D33E5C1C22F992CDE3")
    
public void setChronometer(int viewId, long base, String format, boolean started) {
        setLong(viewId, "setBase", base);
        setString(viewId, "setFormat", format);
        setBoolean(viewId, "setStarted", started);
    }
    
    /**
     * Equivalent to calling {@link ProgressBar#setMax ProgressBar.setMax},
     * {@link ProgressBar#setProgress ProgressBar.setProgress}, and
     * {@link ProgressBar#setIndeterminate ProgressBar.setIndeterminate}
     *
     * If indeterminate is true, then the values for max and progress are ignored.
     * 
     * @param viewId The id of the view whose text should change
     * @param max The 100% value for the progress bar
     * @param progress The current value of the progress bar.
     * @param indeterminate True if the progress bar is indeterminate, 
     *                false if not.
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.045 -0500", hash_original_method = "A929EFC8DD62C6A3F9A2F8FB0663D928", hash_generated_method = "46BB40528ECA49B60180D5C9534CCFF3")
    
public void setProgressBar(int viewId, int max, int progress, 
            boolean indeterminate) {
        setBoolean(viewId, "setIndeterminate", indeterminate);
        if (!indeterminate) {
            setInt(viewId, "setMax", max);
            setInt(viewId, "setProgress", progress);
        }
    }
    
    /**
     * Equivalent to calling
     * {@link android.view.View#setOnClickListener(android.view.View.OnClickListener)}
     * to launch the provided {@link PendingIntent}.
     * 
     * When setting the on-click action of items within collections (eg. {@link ListView},
     * {@link StackView} etc.), this method will not work. Instead, use {@link
     * RemoteViews#setPendingIntentTemplate(int, PendingIntent) in conjunction with
     * RemoteViews#setOnClickFillInIntent(int, Intent).
     *
     * @param viewId The id of the view that will trigger the {@link PendingIntent} when clicked
     * @param pendingIntent The {@link PendingIntent} to send when user clicks
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.047 -0500", hash_original_method = "84C6A4280B6852D03015FA2AE8D65E64", hash_generated_method = "927278201C3266DF8CCC1D5611BF65BC")
    
public void setOnClickPendingIntent(int viewId, PendingIntent pendingIntent) {
        addAction(new SetOnClickPendingIntent(viewId, pendingIntent));
    }

    /**
     * When using collections (eg. {@link ListView}, {@link StackView} etc.) in widgets, it is very
     * costly to set PendingIntents on the individual items, and is hence not permitted. Instead
     * this method should be used to set a single PendingIntent template on the collection, and
     * individual items can differentiate their on-click behavior using
     * {@link RemoteViews#setOnClickFillInIntent(int, Intent)}.
     *
     * @param viewId The id of the collection who's children will use this PendingIntent template
     *          when clicked
     * @param pendingIntentTemplate The {@link PendingIntent} to be combined with extras specified
     *          by a child of viewId and executed when that child is clicked
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.049 -0500", hash_original_method = "A434A09AC636025A142B2CC781D07FF1", hash_generated_method = "62AEF8C61235BF66F98E3B9994F4C2BD")
    
public void setPendingIntentTemplate(int viewId, PendingIntent pendingIntentTemplate) {
        addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
    }

    /**
     * When using collections (eg. {@link ListView}, {@link StackView} etc.) in widgets, it is very
     * costly to set PendingIntents on the individual items, and is hence not permitted. Instead
     * a single PendingIntent template can be set on the collection, see {@link
     * RemoteViews#setPendingIntentTemplate(int, PendingIntent)}, and the individual on-click
     * action of a given item can be distinguished by setting a fillInIntent on that item. The
     * fillInIntent is then combined with the PendingIntent template in order to determine the final
     * intent which will be executed when the item is clicked. This works as follows: any fields
     * which are left blank in the PendingIntent template, but are provided by the fillInIntent
     * will be overwritten, and the resulting PendingIntent will be used.
     *
     *
     * of the PendingIntent template will then be filled in with the associated fields that are
     * set in fillInIntent. See {@link Intent#fillIn(Intent, int)} for more details.
     *
     * @param viewId The id of the view on which to set the fillInIntent
     * @param fillInIntent The intent which will be combined with the parent's PendingIntent
     *        in order to determine the on-click behavior of the view specified by viewId
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.051 -0500", hash_original_method = "899E714C9944265097024FA544BB7AC2", hash_generated_method = "9A048ADC9E7E85148529F6949A853C6E")
    
public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        addAction(new SetOnClickFillInIntent(viewId, fillInIntent));
    }

    /**
     * @hide
     * Equivalent to calling a combination of {@link Drawable#setAlpha(int)},
     * {@link Drawable#setColorFilter(int, android.graphics.PorterDuff.Mode)},
     * and/or {@link Drawable#setLevel(int)} on the {@link Drawable} of a given
     * view.
     * <p>
     * You can omit specific calls by marking their values with null or -1.
     * 
     * @param viewId The id of the view that contains the target
     *            {@link Drawable}
     * @param targetBackground If true, apply these parameters to the
     *            {@link Drawable} returned by
     *            {@link android.view.View#getBackground()}. Otherwise, assume
     *            the target view is an {@link ImageView} and apply them to
     *            {@link ImageView#getDrawable()}.
     * @param alpha Specify an alpha value for the drawable, or -1 to leave
     *            unchanged.
     * @param colorFilter Specify a color for a
     *            {@link android.graphics.ColorFilter} for this drawable, or -1
     *            to leave unchanged.
     * @param mode Specify a PorterDuff mode for this drawable, or null to leave
     *            unchanged.
     * @param level Specify the level for the drawable, or -1 to leave
     *            unchanged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.053 -0500", hash_original_method = "09A5B1AD4F222B569CE2E6BD5BF01B12", hash_generated_method = "225A8C3B42A47EBB5706A9AA316AC457")
    
public void setDrawableParameters(int viewId, boolean targetBackground, int alpha,
            int colorFilter, PorterDuff.Mode mode, int level) {
        addAction(new SetDrawableParameters(viewId, targetBackground, alpha,
                colorFilter, mode, level));
    }

    /**
     * Equivalent to calling {@link android.widget.TextView#setTextColor(int)}.
     * 
     * @param viewId The id of the view whose text should change
     * @param color Sets the text color for all the states (normal, selected,
     *            focused) to be this color.
     */
    @DSComment("check setOnClickPendingIntent")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.056 -0500", hash_original_method = "F51B3B3FB58685A967056786739D5D5A", hash_generated_method = "58D578553E8BA2ACCE636D9C5DD9CE31")
    
public void setTextColor(int viewId, int color) {
        setInt(viewId, "setTextColor", color);
    }

    /**
     * Equivalent to calling {@link android.widget.AbsListView#setRemoteViewsAdapter(Intent)}.
     *
     * @param appWidgetId The id of the app widget which contains the specified view. (This
     *      parameter is ignored in this deprecated method)
     * @param viewId The id of the view whose text should change
     * @param intent The intent of the service which will be
     *            providing data to the RemoteViewsAdapter
     * @deprecated This method has been deprecated. See
     *      {@link android.widget.RemoteViews#setRemoteAdapter(int, Intent)}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.058 -0500", hash_original_method = "F3196C5DB537F18A0B70CAAF74A09A0A", hash_generated_method = "089DAFB52C583E0734174327DA38E35B")
    
@Deprecated
    public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        setRemoteAdapter(viewId, intent);
    }

    /**
     * Equivalent to calling {@link android.widget.AbsListView#setRemoteViewsAdapter(Intent)}.
     * Can only be used for App Widgets.
     *
     * @param viewId The id of the view whose text should change
     * @param intent The intent of the service which will be
     *            providing data to the RemoteViewsAdapter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.060 -0500", hash_original_method = "9F000F17F0336123DB5D1DD3E4F67BE6", hash_generated_method = "E059781CE94A62858243349EABE200B1")
    
public void setRemoteAdapter(int viewId, Intent intent) {
        addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
    }

    /**
     * Equivalent to calling {@link android.widget.AbsListView#smoothScrollToPosition(int, int)}.
     *
     * @param viewId The id of the view whose text should change
     * @param position Scroll to this adapter position
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.062 -0500", hash_original_method = "15753F5F29C6091CCB595496C38B1963", hash_generated_method = "D8A17A8E9EE28D2DE545E341066CC8A7")
    
public void setScrollPosition(int viewId, int position) {
        setInt(viewId, "smoothScrollToPosition", position);
    }

    /**
     * Equivalent to calling {@link android.widget.AbsListView#smoothScrollToPosition(int, int)}.
     *
     * @param viewId The id of the view whose text should change
     * @param offset Scroll by this adapter position offset
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.064 -0500", hash_original_method = "62C951046FF905CA4D61721F847C4DC5", hash_generated_method = "0D6A1882C006E5CF530376BB1A746B15")
    
public void setRelativeScrollPosition(int viewId, int offset) {
        setInt(viewId, "smoothScrollByOffset", offset);
    }

    /**
     * Call a method taking one boolean on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.067 -0500", hash_original_method = "ACF50C9E2E7A3E77B399A3E9AD77138B", hash_generated_method = "C9D9B91F1903061D62B5A83C6F736DF6")
    
public void setBoolean(int viewId, String methodName, boolean value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BOOLEAN, value));
    }

    /**
     * Call a method taking one byte on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.069 -0500", hash_original_method = "6577642D84CE42EC3FAE93CD4A676A48", hash_generated_method = "355AF5262A1C5FD33C4E538DBAF5C1B8")
    
public void setByte(int viewId, String methodName, byte value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BYTE, value));
    }

    /**
     * Call a method taking one short on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.071 -0500", hash_original_method = "1EF837BE87322E5A782B07EBE8F017ED", hash_generated_method = "FC2D62CF4DC4B97AE9D821CAA3BE3C62")
    
public void setShort(int viewId, String methodName, short value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.SHORT, value));
    }

    /**
     * Call a method taking one int on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.073 -0500", hash_original_method = "2BA2097F7597ED476DFE96444FF2B47B", hash_generated_method = "F9D14C9D9162D6EA5023E288E9A57F79")
    
public void setInt(int viewId, String methodName, int value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INT, value));
    }

    /**
     * Call a method taking one long on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.075 -0500", hash_original_method = "7BBB498795ABAEC2FC5C9E80D1FF1F8F", hash_generated_method = "5377C596437CB2A823F7DBF2916577D3")
    
public void setLong(int viewId, String methodName, long value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.LONG, value));
    }

    /**
     * Call a method taking one float on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.077 -0500", hash_original_method = "877DFBEE5EFFB4333EA4E3E01D628209", hash_generated_method = "2F879AF8958A0C5F804EA32CE29BAACD")
    
public void setFloat(int viewId, String methodName, float value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.FLOAT, value));
    }

    /**
     * Call a method taking one double on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.079 -0500", hash_original_method = "36511416C0ED3D737A57750DB7E0C821", hash_generated_method = "D25AD84884C60A69ECC45BFA6CB51927")
    
public void setDouble(int viewId, String methodName, double value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.DOUBLE, value));
    }

    /**
     * Call a method taking one char on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.083 -0500", hash_original_method = "E7DFE8EB27DC5DF6C76291F003DE876E", hash_generated_method = "EF1F3FF6144F881FBED8F807E27A148B")
    
public void setChar(int viewId, String methodName, char value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR, value));
    }

    /**
     * Call a method taking one String on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.085 -0500", hash_original_method = "12B33E0B58F238F52279DFEB1871046D", hash_generated_method = "B0939EAF9A451EA1148D9F675F7DF006")
    
public void setString(int viewId, String methodName, String value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.STRING, value));
    }

    /**
     * Call a method taking one CharSequence on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.087 -0500", hash_original_method = "93A93353A27881B93F029E1CB8E38561", hash_generated_method = "37941E36DE67B6565FB4643DD8504BFA")
    
public void setCharSequence(int viewId, String methodName, CharSequence value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.CHAR_SEQUENCE, value));
    }

    /**
     * Call a method taking one Uri on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.089 -0500", hash_original_method = "33EE202B45F16FA5012E7C802B1E1162", hash_generated_method = "1C40B88D3F4C67D6EB0B3302C4593F86")
    
public void setUri(int viewId, String methodName, Uri value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.URI, value));
    }

    /**
     * Call a method taking one Bitmap on a view in the layout for this RemoteViews.
     * @more
     * <p class="note">The bitmap will be flattened into the parcel if this object is
     * sent across processes, so it may end up using a lot of memory, and may be fairly slow.</p>
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.092 -0500", hash_original_method = "BE18885A2548A0B5EB1C1E6420A7D63A", hash_generated_method = "39F07A653CD5ACEDB7C38B1F50F30C86")
    
public void setBitmap(int viewId, String methodName, Bitmap value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BITMAP, value));
    }

    /**
     * Call a method taking one Bundle on a view in the layout for this RemoteViews.
     *
     * @param viewId The id of the view whose text should change
     * @param methodName The name of the method to call.
     * @param value The value to pass to the method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.094 -0500", hash_original_method = "0BCEFBE1ECC6F937E30E64CCDC160671", hash_generated_method = "7C9DCB523FF6B3B2EDE8EA967EA188BD")
    
public void setBundle(int viewId, String methodName, Bundle value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.BUNDLE, value));
    }

    /**
     *
     * @param viewId
     * @param methodName
     * @param value
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.096 -0500", hash_original_method = "1536FDACAD3B90F5944D61240D2247D6", hash_generated_method = "C8963E827DB2E3DE023A2918BE3A65B9")
    
public void setIntent(int viewId, String methodName, Intent value) {
        addAction(new ReflectionAction(viewId, methodName, ReflectionAction.INTENT, value));
    }

    /**
     * Equivalent to calling View.setContentDescription
     *
     * @param viewId The id of the view whose content description should change
     * @param contentDescription The new content description for the view
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.098 -0500", hash_original_method = "DAF30AB9823DD59C17B2FD226E498806", hash_generated_method = "6AD680900996DB50FC4A18CB0E27A3D5")
    
public void setContentDescription(int viewId, CharSequence contentDescription) {
        setCharSequence(viewId, "setContentDescription", contentDescription);
    }

    /**
     * Inflates the view hierarchy represented by this object and applies
     * all of the actions.
     * 
     * <p><strong>Caller beware: this may throw</strong>
     * 
     * @param context Default context to use
     * @param parent Parent that the resulting view hierarchy will be attached to. This method
     * does <strong>not</strong> attach the hierarchy. The caller should do so when appropriate.
     * @return The inflated view hierarchy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.101 -0500", hash_original_method = "389CE470D5FBF8918932B7CDEB2F38A1", hash_generated_method = "477AE5EF426390CEA27F62AA3B979C27")
    
public View apply(Context context, ViewGroup parent) {
        View result;

        Context c = prepareContext(context);

        LayoutInflater inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater = inflater.cloneInContext(c);
        inflater.setFilter(this);

        result = inflater.inflate(mLayoutId, parent, false);

        performApply(result, parent);

        return result;
    }
    
    /**
     * Applies all of the actions to the provided view.
     *
     * <p><strong>Caller beware: this may throw</strong>
     * 
     * @param v The view to apply the actions to.  This should be the result of
     * the {@link #apply(Context,ViewGroup)} call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.103 -0500", hash_original_method = "721D0331C9411BF86340BE2E97293121", hash_generated_method = "8434EB615B63C0CAE40E690111B9969C")
    
public void reapply(Context context, View v) {
        prepareContext(context);
        performApply(v, (ViewGroup) v.getParent());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.105 -0500", hash_original_method = "8E5E3E88ABCC69E3321D1346316340C9", hash_generated_method = "B7CD65CDD0FE3868DFAC519B78D7F9BC")
    
private void performApply(View v, ViewGroup parent) {
        if (mActions != null) {
            final int count = mActions.size();
            for (int i = 0; i < count; i++) {
                Action a = mActions.get(i);
                a.apply(v, parent);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.107 -0500", hash_original_method = "22DA97EA1494F0F193EF18C8ED8C5634", hash_generated_method = "B2D8E583C06BD07BDA77C7DDFC735575")
    
private Context prepareContext(Context context) {
        Context c;
        String packageName = mPackage;

        if (packageName != null) {
            try {
                c = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            } catch (NameNotFoundException e) {
                Log.e(LOG_TAG, "Package name " + packageName + " not found");
                c = context;
            }
        } else {
            c = context;
        }

        return c;
    }
    
    public static class ActionException extends RuntimeException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.712 -0500", hash_original_method = "4338C0B6ED05990B68F77B56C502C8BC", hash_generated_method = "8A6434B176D353F1936A155E629A021C")
        
public ActionException(Exception ex) {
            super(ex);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.714 -0500", hash_original_method = "E5DD8B85C6FF17BD695A219FDD405D42", hash_generated_method = "28BBE77B86360930B9436F0DF86632C6")
        
public ActionException(String message) {
            super(message);
        }
        
    }
    
    private abstract static class Action implements Parcelable {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.780 -0400", hash_original_method = "6EEA56B449227AEBD2AEF88874F9C864", hash_generated_method = "6EEA56B449227AEBD2AEF88874F9C864")
        public Action ()
        {
            //Synthesized constructor
        }
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.719 -0500", hash_original_method = "67F4BF9F6DDAE6F8C43B87EDA5B1A8FB", hash_generated_method = "BE0DC090C1879247B33B0996B0C8BCFF")
        
public abstract void apply(View root, ViewGroup rootParent) throws ActionException;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.721 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        /**
         * Overridden by each class to report on it's own memory usage
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.724 -0500", hash_original_method = "F71AEDBFF608C755FB28C9D45BA8F347", hash_generated_method = "E6F67FEF1D512F865EF80CA1E3C854B7")
        
public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            // We currently only calculate Bitmap memory usage, so by default, don't do anything
            // here
            return;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.726 -0500", hash_original_method = "18203BE61B7EF9CD6501BEC6EAEF8812", hash_generated_method = "0A240D8F91D78FF4CF84AC92B7FCCB95")
        
protected boolean startIntentSafely(Context context, PendingIntent pendingIntent,
                Intent fillInIntent) {
            try {
                // TODO: Unregister this handler if PendingIntent.FLAG_ONE_SHOT?
                context.startIntentSender(
                        pendingIntent.getIntentSender(), fillInIntent,
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_NEW_TASK, 0);
            } catch (IntentSender.SendIntentException e) {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent: ", e);
                return false;
            } catch (Exception e) {
                android.util.Log.e(LOG_TAG, "Cannot send pending intent due to " +
                        "unknown exception: ", e);
                return false;
            }
            return true;
        }
        
    }
    
    private class SetEmptyView extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.735 -0500", hash_original_field = "D59D4247F9ED236621C450A673C8EE48", hash_generated_field = "832C8F64E214207268768E39D7FCB9F3")

        public final static int TAG = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.730 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.732 -0500", hash_original_field = "8D3D66B4863E42DCDD06D3EE8F80E8F7", hash_generated_field = "8D3D66B4863E42DCDD06D3EE8F80E8F7")

        int emptyViewId;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.738 -0500", hash_original_method = "16159C50F4CD599B644ED014E4EA0822", hash_generated_method = "16159C50F4CD599B644ED014E4EA0822")
        
SetEmptyView(int viewId, int emptyViewId) {
            this.viewId = viewId;
            this.emptyViewId = emptyViewId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.740 -0500", hash_original_method = "F10F16648F57CF9FE4F3D806E803B1DC", hash_generated_method = "F10F16648F57CF9FE4F3D806E803B1DC")
        
SetEmptyView(Parcel in) {
            this.viewId = in.readInt();
            this.emptyViewId = in.readInt();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.744 -0500", hash_original_method = "1EA9A4CD3E90F19D62658919976BDCDF", hash_generated_method = "102CA6F7C365210ABD88939C30A9A93C")
        
public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeInt(this.emptyViewId);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.746 -0500", hash_original_method = "BC00C709904F6A7A06083DBEA360E136", hash_generated_method = "960074206CE8FDD1BBFB1FA45EEA249F")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            if (!(view instanceof AdapterView<?>)) return;

            AdapterView<?> adapterView = (AdapterView<?>) view;

            final View emptyView = root.findViewById(emptyViewId);
            if (emptyView == null) return;

            adapterView.setEmptyView(emptyView);
        }
    }
    
    private class SetOnClickFillInIntent extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.771 -0500", hash_original_field = "2CA6A73FAAA2D00670E3244D2C6BEA16", hash_generated_field = "257D5F310A82D1AE988E43617C7394F4")

        public final static int TAG = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.767 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.768 -0500", hash_original_field = "9D3AB3AC0219EE64EF3FF80AB068BB5E", hash_generated_field = "9D3AB3AC0219EE64EF3FF80AB068BB5E")

        Intent fillInIntent;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.751 -0500", hash_original_method = "FE3667D87A305D86E9A8A6AD36F5EEAF", hash_generated_method = "661AD41A4B9EC1106B3E87749FBE1A12")
        
public SetOnClickFillInIntent(int id, Intent fillInIntent) {
            this.viewId = id;
            this.fillInIntent = fillInIntent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.753 -0500", hash_original_method = "8F893000547B59EAD09450FBC024CAC1", hash_generated_method = "F2C3AB7C5E101A5DCE6A85AF80841AA0")
        
public SetOnClickFillInIntent(Parcel parcel) {
            viewId = parcel.readInt();
            fillInIntent = Intent.CREATOR.createFromParcel(parcel);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.756 -0500", hash_original_method = "4A68D926F0B47E5C592025763C57CD49", hash_generated_method = "ACC7BFF44F22149E7887ACA9580365E2")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            fillInIntent.writeToParcel(dest, 0 /* no flags */);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.764 -0500", hash_original_method = "3474C680008284CA3FCD2C734DB61ED8", hash_generated_method = "F462B6A153AA13F759A58322A11AD9A6")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            if (target == null) return;

            if (!mIsWidgetCollectionChild) {
                Log.e("RemoteViews", "The method setOnClickFillInIntent is available " +
                        "only from RemoteViewsFactory (ie. on collection items).");
                return;
            }
            if (target == root) {
                target.setTagInternal(com.android.internal.R.id.fillInIntent, fillInIntent);
            } else if (target != null && fillInIntent != null) {
                OnClickListener listener = new OnClickListener() {
                    public void onClick(View v) {
                        // Insure that this view is a child of an AdapterView
                        View parent = (View) v.getParent();
                        while (!(parent instanceof AdapterView<?>)
                                && !(parent instanceof AppWidgetHostView)) {
                            parent = (View) parent.getParent();
                        }

                        if (parent instanceof AppWidgetHostView) {
                            // Somehow they've managed to get this far without having
                            // and AdapterView as a parent.
                            Log.e("RemoteViews", "Collection item doesn't have AdapterView parent");
                            return;
                        }

                        // Insure that a template pending intent has been set on an ancestor
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
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.796 -0500", hash_original_field = "DA93FC8165D012ECFA574BB3EFD71D8E", hash_generated_field = "999B6A111CF47CD01BFB86C10E0DFDAF")

        public final static int TAG = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.791 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.793 -0500", hash_original_field = "D0EA5F86DAC5B859FF411BE20B81D705", hash_generated_field = "D0EA5F86DAC5B859FF411BE20B81D705")

        PendingIntent pendingIntentTemplate;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.776 -0500", hash_original_method = "319DBBF9EE021BC2BD14552E08C5F806", hash_generated_method = "2CF5D502ABA2EF6BD26CB66E15147110")
        
public SetPendingIntentTemplate(int id, PendingIntent pendingIntentTemplate) {
            this.viewId = id;
            this.pendingIntentTemplate = pendingIntentTemplate;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.779 -0500", hash_original_method = "F35BA9665B1C6E88223062D1328FA579", hash_generated_method = "00208728D17D55CA59088604709F7E3D")
        
public SetPendingIntentTemplate(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.782 -0500", hash_original_method = "2DE56D1052D41AEA85684029786EA581", hash_generated_method = "F0F77F5D14E4FBC0E30B4AA606DAA5AA")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntentTemplate.writeToParcel(dest, 0 /* no flags */);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.789 -0500", hash_original_method = "BC6383FD3782B4E4299FBBF52DF5CBB4", hash_generated_method = "A68ECDE7BFD20B8A18A21C230E389D93")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            if (target == null) return;

            // If the view isn't an AdapterView, setting a PendingIntent template doesn't make sense
            if (target instanceof AdapterView<?>) {
                AdapterView<?> av = (AdapterView<?>) target;
                // The PendingIntent template is stored in the view's tag.
                OnItemClickListener listener = new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                        // The view should be a frame layout
                        if (view instanceof ViewGroup) {
                            ViewGroup vg = (ViewGroup) view;

                            // AdapterViews contain their children in a frame
                            // so we need to go one layer deeper here.
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
            } else {
                Log.e("RemoteViews", "Cannot setPendingIntentTemplate on a view which is not" +
                        "an AdapterView (id: " + viewId + ")");
                return;
            }
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.817 -0500", hash_original_field = "9FA61F47E20184FF08B91738AD61CE72", hash_generated_field = "8FE5A8285A40B3CDB587BD72B1510F3F")

        public final static int TAG = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.812 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.815 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.802 -0500", hash_original_method = "2562242EF5AD42CD0339F4CFA0A5651B", hash_generated_method = "884FD0E7E26D655F8383375628BA01AF")
        
public SetRemoteViewsAdapterIntent(int id, Intent intent) {
            this.viewId = id;
            this.intent = intent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.805 -0500", hash_original_method = "3062D841F9A527FF82C19CE8ED4DF47C", hash_generated_method = "11E6CAFE8DCFD1E1840673A94586250D")
        
public SetRemoteViewsAdapterIntent(Parcel parcel) {
            viewId = parcel.readInt();
            intent = Intent.CREATOR.createFromParcel(parcel);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.807 -0500", hash_original_method = "F580FE61025C5DC81DFB7BB9EA905954", hash_generated_method = "AC4556E640C6EE512599A4790A90BDBC")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            intent.writeToParcel(dest, flags);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.810 -0500", hash_original_method = "EDE9247E350EBAB87917A7616D3465DB", hash_generated_method = "D5736400B130D067601E79366BF69615")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            if (target == null) return;

            // Ensure that we are applying to an AppWidget root
            if (!(rootParent instanceof AppWidgetHostView)) {
                Log.e("RemoteViews", "SetRemoteViewsAdapterIntent action can only be used for " +
                        "AppWidgets (root id: " + viewId + ")");
                return;
            }
            // Ensure that we are calling setRemoteAdapter on an AdapterView that supports it
            if (!(target instanceof AbsListView) && !(target instanceof AdapterViewAnimator)) {
                Log.e("RemoteViews", "Cannot setRemoteViewsAdapter on a view which is not " +
                        "an AbsListView or AdapterViewAnimator (id: " + viewId + ")");
                return;
            }

            // Embed the AppWidget Id for use in RemoteViewsAdapter when connecting to the intent
            // RemoteViewsService
            AppWidgetHostView host = (AppWidgetHostView) rootParent;
            intent.putExtra(EXTRA_REMOTEADAPTER_APPWIDGET_ID, host.getAppWidgetId());
            if (target instanceof AbsListView) {
                AbsListView v = (AbsListView) target;
                v.setRemoteViewsAdapter(intent);
            } else if (target instanceof AdapterViewAnimator) {
                AdapterViewAnimator v = (AdapterViewAnimator) target;
                v.setRemoteViewsAdapter(intent);
            }
        }
    }
    
    private class SetOnClickPendingIntent extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.841 -0500", hash_original_field = "6FEE6E7354E1D66F860D47EA16E89F13", hash_generated_field = "993712AACA5BFFF68C7775B3C6B7EE8B")

        public final static int TAG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.837 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")
        
        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.839 -0500", hash_original_field = "7026E183996B4AEE13A8653E0B37928C", hash_generated_field = "7026E183996B4AEE13A8653E0B37928C")

        PendingIntent pendingIntent;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.822 -0500", hash_original_method = "66EA2688C4B0F29524FFED0B8D1C4557", hash_generated_method = "42A906DE4CAD508CB2ADAD38D8156643")
        
public SetOnClickPendingIntent(int id, PendingIntent pendingIntent) {
            this.viewId = id;
            this.pendingIntent = pendingIntent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.824 -0500", hash_original_method = "2D335FA6E397EB90FCE69134FAC6C0E6", hash_generated_method = "A2B9C426EC954D0B36778C4764124058")
        
public SetOnClickPendingIntent(Parcel parcel) {
            viewId = parcel.readInt();
            pendingIntent = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.827 -0500", hash_original_method = "7CEF806B95F0881A888E5DFCE712AF4A", hash_generated_method = "BBFCADFE2B4C1116E5EDD48598D95180")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            pendingIntent.writeToParcel(dest, 0 /* no flags */);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.835 -0500", hash_original_method = "7AB558D2EB1905941BBC96768E4F0260", hash_generated_method = "BEF5A3A41B8EA144192F6DFBF68437C8")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            if (target == null) return;

            // If the view is an AdapterView, setting a PendingIntent on click doesn't make much
            // sense, do they mean to set a PendingIntent template for the AdapterView's children?
            if (mIsWidgetCollectionChild) {
                Log.e("RemoteViews", "Cannot setOnClickPendingIntent for collection item " +
				"(id: " + viewId + ")");
                // TODO: return; We'll let this slide until apps are up to date.
            }

            if (target != null && pendingIntent != null) {
                OnClickListener listener = new OnClickListener() {
                    public void onClick(View v) {
                        // Find target view location in screen coordinates and
                        // fill into PendingIntent before sending.
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
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.870 -0500", hash_original_field = "23AFD149B2BA99EFAAC01896459B3DF9", hash_generated_field = "22845C1BD5EB1EFAC44EDEF6B7BDA751")

        public final static int TAG = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.857 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.859 -0500", hash_original_field = "348353981961A3507DF6BC6E23EBAF56", hash_generated_field = "348353981961A3507DF6BC6E23EBAF56")

        boolean targetBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.861 -0500", hash_original_field = "1B559E55B8F17D21F08DC11CC377988E", hash_generated_field = "1B559E55B8F17D21F08DC11CC377988E")

        int alpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.863 -0500", hash_original_field = "1B107E6823167B68C4A8FA578E72F2B9", hash_generated_field = "1B107E6823167B68C4A8FA578E72F2B9")

        int colorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.865 -0500", hash_original_field = "1E0353AC2D4FEC5D3F86FBF63BA71A1F", hash_generated_field = "1E0353AC2D4FEC5D3F86FBF63BA71A1F")

        PorterDuff.Mode filterMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.867 -0500", hash_original_field = "6C23DC7E65CEAB9FBA953CF49B6B6875", hash_generated_field = "6C23DC7E65CEAB9FBA953CF49B6B6875")

        int level;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.847 -0500", hash_original_method = "18564016E13252E4F53F65794EE2D4BB", hash_generated_method = "2AA0AF4DAFEBA930C55717F288D57812")
        
public SetDrawableParameters(int id, boolean targetBackground, int alpha,
                int colorFilter, PorterDuff.Mode mode, int level) {
            this.viewId = id;
            this.targetBackground = targetBackground;
            this.alpha = alpha;
            this.colorFilter = colorFilter;
            this.filterMode = mode;
            this.level = level;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.850 -0500", hash_original_method = "72E671F08A71584E9232C176B97BC1C8", hash_generated_method = "4FFB6AF70BA77448C9B352C58AA49115")
        
public SetDrawableParameters(Parcel parcel) {
            viewId = parcel.readInt();
            targetBackground = parcel.readInt() != 0;
            alpha = parcel.readInt();
            colorFilter = parcel.readInt();
            boolean hasMode = parcel.readInt() != 0;
            if (hasMode) {
                filterMode = PorterDuff.Mode.valueOf(parcel.readString());
            } else {
                filterMode = null;
            }
            level = parcel.readInt();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.852 -0500", hash_original_method = "DC629CA06C171381152FF8641B977C9F", hash_generated_method = "DFFEA65A4CCE4E8F53DC6DF858C3AA74")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeInt(targetBackground ? 1 : 0);
            dest.writeInt(alpha);
            dest.writeInt(colorFilter);
            if (filterMode != null) {
                dest.writeInt(1);
                dest.writeString(filterMode.toString());
            } else {
                dest.writeInt(0);
            }
            dest.writeInt(level);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.855 -0500", hash_original_method = "2B7DD23B0EB7FE8C6A2446FEC1367E7F", hash_generated_method = "7E6A30F9CFF1237971F59555C7525B40")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View target = root.findViewById(viewId);
            if (target == null) return;
            
            // Pick the correct drawable to modify for this view
            Drawable targetDrawable = null;
            if (targetBackground) {
                targetDrawable = target.getBackground();
            } else if (target instanceof ImageView) {
                ImageView imageView = (ImageView) target;
                targetDrawable = imageView.getDrawable();
            }
            
            if (targetDrawable != null) {
                // Perform modifications only if values are set correctly
                if (alpha != -1) {
                    targetDrawable.setAlpha(alpha);
                }
                if (colorFilter != -1 && filterMode != null) {
                    targetDrawable.setColorFilter(colorFilter, filterMode);
                }
                if (level != -1) {
                    targetDrawable.setLevel(level);
                }
            }
        }
    }
    
    private class ReflectionActionWithoutParams extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.880 -0500", hash_original_field = "C5B69BCC9F5393E5C238B51A93CC6048", hash_generated_field = "03362AF19131C1207E62059104EDE4C5")

        public final static int TAG = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.875 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.877 -0500", hash_original_field = "1E5D18395D934B5D254686548A645BA9", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.882 -0500", hash_original_method = "9825933434EF5EC003AA8FF50203783A", hash_generated_method = "9825933434EF5EC003AA8FF50203783A")
        
ReflectionActionWithoutParams(int viewId, String methodName) {
            this.viewId = viewId;
            this.methodName = methodName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.885 -0500", hash_original_method = "07A57AEC1ECBD4F4EF962F6964A9C9CB", hash_generated_method = "07A57AEC1ECBD4F4EF962F6964A9C9CB")
        
ReflectionActionWithoutParams(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.887 -0500", hash_original_method = "E92934B0244E59AB6D933016F95632D8", hash_generated_method = "FE8082B9D7DA6D6F32DD575686DAA6DE")
        
public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.890 -0500", hash_original_method = "B2755AE6CC74346ED57BF443914C2243", hash_generated_method = "59D5689E5C35C42ADC4BA23A525767C6")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            if (view == null) return;

            Class klass = view.getClass();
            Method method;
            try {
                method = klass.getMethod(this.methodName);
            } catch (NoSuchMethodException ex) {
                throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "()");
            }

            if (!method.isAnnotationPresent(RemotableViewMethod.class)) {
                throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "()");
            }

            try {
                //noinspection ConstantIfStatement
                if (false) {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "()");
                }
                method.invoke(view);
            } catch (Exception ex) {
                throw new ActionException(ex);
            }
        }
    }
    
    private class ReflectionAction extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.896 -0500", hash_original_field = "CDAB39A11CA44163160BD0C9D448D341", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

        static final int TAG = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.898 -0500", hash_original_field = "7F7D44C438A386CA9622D4D3C9DB8C3F", hash_generated_field = "E11DCA29C7BD696B2526B497FF3EAAEC")

        static final int BOOLEAN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.900 -0500", hash_original_field = "563BE0C5D63C5121947A501848334D40", hash_generated_field = "A08488B6E820CE04526667A0F65B2358")

        static final int BYTE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.903 -0500", hash_original_field = "7BF049E805FA8C19C73CED1A14410777", hash_generated_field = "A14B4D783E4BD28B22DF5708F3C91517")

        static final int SHORT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.905 -0500", hash_original_field = "DD56A391C01C424454DE55937B2F98B2", hash_generated_field = "0D069F30768AEFEA236A6C7BEA66E7F4")

        static final int INT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.907 -0500", hash_original_field = "E3AC045FA98172D61AE646304C812F40", hash_generated_field = "B58C5793378449CBE5C2C8BE4F7C6D55")

        static final int LONG = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.909 -0500", hash_original_field = "15A6E58578DDF200DCED9F064C7ECA0A", hash_generated_field = "46B9B78E20B9DFB9C97B6EB5CDFC1710")

        static final int FLOAT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.912 -0500", hash_original_field = "016105965006501DBF1F3133FBD26372", hash_generated_field = "A4501BC529B3B3B1F619CD5B69F60BEE")

        static final int DOUBLE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.914 -0500", hash_original_field = "C01DEB4471C94A5B2BB7CB8C56ABFA24", hash_generated_field = "A4E7D9D246B6685E9E73E853EFB843FD")

        static final int CHAR = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.917 -0500", hash_original_field = "9CABBEDB7FB4C3BAA280969BE1865A4B", hash_generated_field = "E2738C0FD157A27F299AA096F2698ED6")

        static final int STRING = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.919 -0500", hash_original_field = "A8F8D3E92FC088EE743962F224273A2F", hash_generated_field = "8B88FAA46496AA9341BA2AC74905D8B7")

        static final int CHAR_SEQUENCE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.921 -0500", hash_original_field = "5532C8B7C599324CCD0246930E59E027", hash_generated_field = "677DE19774DF27A76E4807597BCCE25E")

        static final int URI = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.924 -0500", hash_original_field = "76AC39584238FD38DC4107CD3CCFB618", hash_generated_field = "848B8557A665FAFDBC86FEF0A38BE2A4")

        static final int BITMAP = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.926 -0500", hash_original_field = "ABDBA945CCB964411495C6A2132C04F4", hash_generated_field = "C2775C8AD4009091E8937A7799C946C2")

        static final int BUNDLE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.928 -0500", hash_original_field = "CD99E009A572C4F47B0A43DCAD72BAB4", hash_generated_field = "819B6EFDD2B1951BA1F12E14D3F5638F")

        static final int INTENT = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.931 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.933 -0500", hash_original_field = "1E5D18395D934B5D254686548A645BA9", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

        String methodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.935 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "961B4204667A4AE2FF8DD374E6728ADE")

        int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.938 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.940 -0500", hash_original_method = "C4E3EC196FB78FDD2AFD41CF23C84256", hash_generated_method = "C4E3EC196FB78FDD2AFD41CF23C84256")
        
ReflectionAction(int viewId, String methodName, int type, Object value) {
            this.viewId = viewId;
            this.methodName = methodName;
            this.type = type;
            this.value = value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.944 -0500", hash_original_method = "A86C68C4FD8B9D479580CAEA2D14C9BF", hash_generated_method = "1945626D83D5FDCE6093A82A43C5CA09")
        
ReflectionAction(Parcel in) {
            this.viewId = in.readInt();
            this.methodName = in.readString();
            this.type = in.readInt();
            //noinspection ConstantIfStatement
            if (false) {
                Log.d("RemoteViews", "read viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            }
            switch (this.type) {
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
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.947 -0500", hash_original_method = "F759DD8CB1A89B34D073177D219BFFB9", hash_generated_method = "710C59AE631B393DF2B2E9EFA5906642")
        
public void writeToParcel(Parcel out, int flags) {
            out.writeInt(TAG);
            out.writeInt(this.viewId);
            out.writeString(this.methodName);
            out.writeInt(this.type);
            //noinspection ConstantIfStatement
            if (false) {
                Log.d("RemoteViews", "write viewId=0x" + Integer.toHexString(this.viewId)
                        + " methodName=" + this.methodName + " type=" + this.type);
            }
            switch (this.type) {
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
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.950 -0500", hash_original_method = "E66E0BF97844CCF37DCED039A425AFDA", hash_generated_method = "D3ACCEA57A875FE5BF1B22C55ED1BC08")
        
private Class getParameterType() {
            switch (this.type) {
                case BOOLEAN:
                    return boolean.class;
                case BYTE:
                    return byte.class;
                case SHORT:
                    return short.class;
                case INT:
                    return int.class;
                case LONG:
                    return long.class;
                case FLOAT:
                    return float.class;
                case DOUBLE:
                    return double.class;
                case CHAR:
                    return char.class;
                case STRING:
                    return String.class;
                case CHAR_SEQUENCE:
                    return CharSequence.class;
                case URI:
                    return Uri.class;
                case BITMAP:
                    return Bitmap.class;
                case BUNDLE:
                    return Bundle.class;
                case INTENT:
                    return Intent.class;
                default:
                    return null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.953 -0500", hash_original_method = "008B98D7581EEC47326A699C8B3D8035", hash_generated_method = "A63296F8A9BEBFD342DADFD3DD013AC8")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final View view = root.findViewById(viewId);
            if (view == null) return;

            Class param = getParameterType();
            if (param == null) {
                throw new ActionException("bad type: " + this.type);
            }

            Class klass = view.getClass();
            Method method;
            try {
                method = klass.getMethod(this.methodName, getParameterType());
            }
            catch (NoSuchMethodException ex) {
                throw new ActionException("view: " + klass.getName() + " doesn't have method: "
                        + this.methodName + "(" + param.getName() + ")");
            }

            if (!method.isAnnotationPresent(RemotableViewMethod.class)) {
                throw new ActionException("view: " + klass.getName()
                        + " can't use method with RemoteViews: "
                        + this.methodName + "(" + param.getName() + ")");
            }

            try {
                //noinspection ConstantIfStatement
                if (false) {
                    Log.d("RemoteViews", "view: " + klass.getName() + " calling method: "
                        + this.methodName + "(" + param.getName() + ") with "
                        + (this.value == null ? "null" : this.value.getClass().getName()));
                }
                method.invoke(view, this.value);
            }
            catch (Exception ex) {
                throw new ActionException(ex);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.956 -0500", hash_original_method = "1F301B790026760CE401FF57484A4A78", hash_generated_method = "5776FF16602E514B414C7AA66F2C1859")
        
@Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            // We currently only calculate Bitmap memory usage
            switch (this.type) {
                case BITMAP:
                    if (this.value != null) {
                        final Bitmap b = (Bitmap) this.value;
                        final Bitmap.Config c = b.getConfig();
                        // If we don't know, be pessimistic and assume 4
                        int bpp = 4;
                        if (c != null) {
                            switch (c) {
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
                        }
                        counter.bitmapIncrement(b.getWidth() * b.getHeight() * bpp);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    private class ViewGroupAction extends Action {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.981 -0500", hash_original_field = "880881F73157436E3CF8EDEBE8AFED23", hash_generated_field = "BFAD764BA58FF98FFB009C9036CFE299")

        public final static int TAG = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.976 -0500", hash_original_field = "6D439F1D3806F3B8DDD66C155D4A0AD3", hash_generated_field = "6D439F1D3806F3B8DDD66C155D4A0AD3")

        int viewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.978 -0500", hash_original_field = "94DAE06500F0010791F8161444D05A58", hash_generated_field = "94DAE06500F0010791F8161444D05A58")

        RemoteViews nestedViews;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.963 -0500", hash_original_method = "ED007F9070164016B2129A58A247A132", hash_generated_method = "20DDC57F73C354895BEDF745884E6C13")
        
public ViewGroupAction(int viewId, RemoteViews nestedViews) {
            this.viewId = viewId;
            this.nestedViews = nestedViews;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.966 -0500", hash_original_method = "3800854E305111A2B59A893F31CDD286", hash_generated_method = "F8DAAB83DC60B47265485D7338232E3E")
        
public ViewGroupAction(Parcel parcel) {
            viewId = parcel.readInt();
            nestedViews = parcel.readParcelable(null);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.968 -0500", hash_original_method = "BEE1FD608BE154882376BC772CDB35A0", hash_generated_method = "4624A0ADDC40194455DF34D80EB6D94C")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(TAG);
            dest.writeInt(viewId);
            dest.writeParcelable(nestedViews, 0 /* no flags */);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.971 -0500", hash_original_method = "3F6E8B427E9FBCBDEBB4E654B5696B90", hash_generated_method = "FEBCB02E5616085FF26E219193A4BEB1")
        
@Override
        public void apply(View root, ViewGroup rootParent) {
            final Context context = root.getContext();
            final ViewGroup target = (ViewGroup) root.findViewById(viewId);
            if (target == null) return;
            if (nestedViews != null) {
                // Inflate nested views and add as children
                target.addView(nestedViews.apply(context, target));
            } else {
                // Clear all children when nested views omitted
                target.removeAllViews();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.974 -0500", hash_original_method = "9A98BF9B0C4ADB9C4C041E3C0533F17D", hash_generated_method = "7609540EC1E9A155BFF79314CD4189C8")
        
@Override
        public void updateMemoryUsageEstimate(MemoryUsageCounter counter) {
            if (nestedViews != null) {
                counter.bitmapIncrement(nestedViews.estimateBitmapMemoryUsage());
            }
        }
    }
    
    private class MemoryUsageCounter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.992 -0500", hash_original_field = "B0DA7A32C463859C81C00F4CE0F0F3CC", hash_generated_field = "B0DA7A32C463859C81C00F4CE0F0F3CC")

        int mBitmapHeapMemoryUsage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.794 -0400", hash_original_method = "35D450C627251B011B80F5473DD04513", hash_generated_method = "35D450C627251B011B80F5473DD04513")
        public MemoryUsageCounter ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.985 -0500", hash_original_method = "F68FB7282799CC52F4314E5E47499FED", hash_generated_method = "9DB4FB2F37D3A8DB72A4B6C46D7E41D0")
        
public void clear() {
            mBitmapHeapMemoryUsage = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.988 -0500", hash_original_method = "9C864F7ABFEE7832A18F21C728CCE23F", hash_generated_method = "0DC5C141295D92DA19CAA83B22CB3A55")
        
public void bitmapIncrement(int numBytes) {
            mBitmapHeapMemoryUsage += numBytes;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:50.990 -0500", hash_original_method = "F4B214FD82765971EA3822C02AABA16F", hash_generated_method = "69B6971C4665A92AE7D753A584751A62")
        
public int getBitmapHeapMemoryUsage() {
            return mBitmapHeapMemoryUsage;
        }
        
    }
    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface RemoteView {
    }

    /* (non-Javadoc)
     * Used to restrict the views which can be inflated
     * 
     * @see android.view.LayoutInflater.Filter#onLoadClass(java.lang.Class)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.109 -0500", hash_original_method = "02A046D25F4E9D374E474E21F6366163", hash_generated_method = "DCB9B631C459B30D0BD2D197025EB71B")
    
public boolean onLoadClass(Class clazz) {
        return clazz.isAnnotationPresent(RemoteView.class);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.112 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:51.114 -0500", hash_original_method = "E42048CF3CAA5A680CE684B09E27CD46", hash_generated_method = "87D3D1F357377E776CD4DC626F4BF5D0")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPackage);
        dest.writeInt(mLayoutId);
        dest.writeInt(mIsWidgetCollectionChild ? 1 : 0);
        int count;
        if (mActions != null) {
            count = mActions.size();
        } else {
            count = 0;
        }
        dest.writeInt(count);
        for (int i=0; i<count; i++) {
            Action a = mActions.get(i);
            a.writeToParcel(dest, 0);
        }
    }
    // orphaned legacy method
    public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }
    
    // orphaned legacy method
    public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    
}

