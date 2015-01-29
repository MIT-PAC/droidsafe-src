package droidsafe.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.LongType;
import soot.RefType;
import soot.ShortType;
import soot.SootMethod;
import soot.Type;
import soot.VoidType;

/**
 * This class keeps a set of Android classes that are innocuous for their direct actions.
 * 
 * These classes may store and forward values that are important, but their actions probably should 
 * not be reported to the analyst.
 * 
 * @author mgordon
 *
 */
public class SafeAndroidClassesAndMethods {
    /** set of classes for quick lookups */
    private Set<String> safeClasses;
    
    /** Maps class names to a map from method names to safe signatures.
     *  Semantics of the map:
     *  	- If a class does not appear as a key in the outer map
     *  	  then none of the methods in that class are considered
     *        safe.
     *      - If the class appears as a key in the outer map but
     *        is mapped to either a null value or an empty map
     *        then all of the methods in that class are considered
     *        safe (i.e. the entire class is safe).
     *      - If the class appears as a key in the outer map and
     *        maps to a non-null, non-empty inner map then only
     *        methods in that inner map are considered safe (the
     *        method name is the map key and the value is a set
     *        of safe signatures for the method).
     *        
     *  NOTE: Obviously, this data structure along with its associated
     *        rules could subsume the set above. This has not been
     *        done yet.
     **/
	private Map<String, Map<String,Set<List<Type>>>> safeClassesAndMethods;
    
    /** Singleton object */
    private static SafeAndroidClassesAndMethods v;
    
    /** private constructor that builds set */
    private SafeAndroidClassesAndMethods() {
        safeClasses = new HashSet<String>();
        safeClasses.addAll(Arrays.asList(safeClassesArray));
    	
    	SafeBuilder safe = createSafeBuilder();
    	
    	// Methods from java.lang.Class that are considered safe.
    	safe.addSafeClass("java.lang.Class")
            .addSafeMethod("asSubclass").addSafeSignature("java.lang.Class").done()
            .addSafeMethod("cast").addSafeSignature("java.lang.Object").done()
    	    .addSafeMethod("getName").addSafeSignature().done()
            .addSafeMethod("getCanonicalName").addSafeSignature().done()
            .addSafeMethod("getSimpleName").addSafeSignature().done()
            .addSafeMethod("isAnnotation").addSafeSignature().done()
            .addSafeMethod("isAnnotationPresent").addSafeSignature("java.lang.Class").done()
            .addSafeMethod("isAnonymousClass").addSafeSignature().done()
            .addSafeMethod("isArray").addSafeSignature().done()
            .addSafeMethod("isAssignableFrom").addSafeSignature("java.lang.Class").done()
            .addSafeMethod("isEnum").addSafeSignature().done()
            .addSafeMethod("isInstance").addSafeSignature("java.lang.Object").done()
            .addSafeMethod("isInterface").addSafeSignature().done()
            .addSafeMethod("isLocalClass").addSafeSignature().done()
            .addSafeMethod("isMemberClass").addSafeSignature().done()
            .addSafeMethod("isPrimitive").addSafeSignature().done()
            .addSafeMethod("isSynthetic").addSafeSignature().done()
            .addSafeMethod("toString").addSafeSignature().done()
            .done();
    	
    	// Methods from java.lang.System that are considered safe.
    	safe.addSafeClass("java.lang.System")
    	    .addSafeMethod("arraycopy").addSafeSignature("java.lang.Object","int","java.lang.Object","int","int").done()
            .addSafeMethod("currentTimeMillis").addSafeSignature().done()
            .addSafeMethod("exit").addSafeSignature("int").done()
            .addSafeMethod("gc").addSafeSignature().done()
            .addSafeMethod("identityHashCode").addSafeSignature("java.lang.Object").done()
            .addSafeMethod("nanoTime").addSafeSignature().done()
            .addSafeMethod("runFinalization").addSafeSignature().done()
            .addSafeMethod("runFinalizersOnExit").addSafeSignature("boolean").done()
    	    .done();
    	
        // Methods from android.app.AlertDialog$Builder that are considered safe.
        safe.addSafeClass("android.app.AlertDialog$Builder")
            .addSafeMethod("setTitle")
                .addSafeSignature("java.lang.CharSequence")
                .addSafeSignature("int")
                .done()
            .done();
        
        safe.addSafeClass("android.app.Activity")
        .addSafeMethod("getString").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.app.AlertDialog")
        .addSafeMethod("show").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.app.AlertDialog$Builder")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("create").allSignaturesSafe()
        .addSafeMethod("setMessage").allSignaturesSafe()
        .addSafeMethod("setNegativeButton").allSignaturesSafe()
        .addSafeMethod("setPositiveButton").allSignaturesSafe()
        .addSafeMethod("setTitle").allSignaturesSafe()
        .addSafeMethod("setView").allSignaturesSafe()
        .addSafeMethod("show").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.app.FragmentManager")
        .addSafeMethod("findFragmentById").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.app.NotificationManager")
        .addSafeMethod("notify").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.app.ProgressDialog")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("dismiss").allSignaturesSafe()
        .addSafeMethod("getContext").allSignaturesSafe()
        .addSafeMethod("isShowing").allSignaturesSafe()
        .addSafeMethod("setMessage").allSignaturesSafe()
        .addSafeMethod("setProgress").allSignaturesSafe()
        .addSafeMethod("show").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.ContentProviderOperation$Builder")
        .addSafeMethod("build").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.ContentResolver")
        .addSafeMethod("insert").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.ContentValues")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("containsKey").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.DialogInterface")
        .addSafeMethod("cancel").allSignaturesSafe()
        .addSafeMethod("dismiss").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.SharedPreferences")
        .addSafeMethod("edit").allSignaturesSafe()
        .addSafeMethod("getBoolean").allSignaturesSafe()
        .addSafeMethod("getString").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.SharedPreferences$Editor")
        .addSafeMethod("putBoolean").allSignaturesSafe()
        .addSafeMethod("putString").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.res.Resources")
        .addSafeMethod("getDrawable").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.content.res.TypedArray")
        .addSafeMethod("recycle").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.database.Cursor")
        .addSafeMethod("close").allSignaturesSafe()
        .addSafeMethod("getColumnIndex").allSignaturesSafe()
        .addSafeMethod("getColumnIndexOrThrow").allSignaturesSafe()
        .addSafeMethod("getCount").allSignaturesSafe()
        .addSafeMethod("getInt").allSignaturesSafe()
        .addSafeMethod("getLong").allSignaturesSafe()
        .addSafeMethod("getString").allSignaturesSafe()
        .addSafeMethod("isAfterLast").allSignaturesSafe()
        .addSafeMethod("isClosed").allSignaturesSafe()
        .addSafeMethod("moveToFirst").allSignaturesSafe()
        .addSafeMethod("moveToNext").allSignaturesSafe()
        .done();
        
        safe.addSafeClass("droidsafe.concrete.DSCursor")
        .addSafeMethod("close").allSignaturesSafe()
        .addSafeMethod("getColumnIndex").allSignaturesSafe()
        .addSafeMethod("getColumnIndexOrThrow").allSignaturesSafe()
        .addSafeMethod("getCount").allSignaturesSafe()
        .addSafeMethod("getInt").allSignaturesSafe()
        .addSafeMethod("getLong").allSignaturesSafe()
        .addSafeMethod("getString").allSignaturesSafe()
        .addSafeMethod("isAfterLast").allSignaturesSafe()
        .addSafeMethod("isClosed").allSignaturesSafe()
        .addSafeMethod("moveToFirst").allSignaturesSafe()
        .addSafeMethod("moveToNext").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.database.sqlite.SQLiteDatabase")
        .addSafeMethod("endTransaction").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.os.Bundle")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("get").allSignaturesSafe()
        .addSafeMethod("getInt").allSignaturesSafe()
        .addSafeMethod("getLong").allSignaturesSafe()
        .addSafeMethod("getParcelable").allSignaturesSafe()
        .addSafeMethod("getString").allSignaturesSafe()
        .addSafeMethod("putBoolean").allSignaturesSafe()
        .addSafeMethod("putInt").allSignaturesSafe()
        .addSafeMethod("putParcelable").allSignaturesSafe()
        .addSafeMethod("writeToParcel").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.os.Parcel")
        .addSafeMethod("dataPosition").allSignaturesSafe()
        .addSafeMethod("enforceInterface").allSignaturesSafe()
        .addSafeMethod("obtain").allSignaturesSafe()
        .addSafeMethod("readException").allSignaturesSafe()
        .addSafeMethod("readFloat").allSignaturesSafe()
        .addSafeMethod("readInt").allSignaturesSafe()
        .addSafeMethod("readString").allSignaturesSafe()
        .addSafeMethod("readStrongBinder").allSignaturesSafe()
        .addSafeMethod("recycle").allSignaturesSafe()
        .addSafeMethod("writeFloat").allSignaturesSafe()
        .addSafeMethod("writeInt").allSignaturesSafe()
        .addSafeMethod("writeInterfaceToken").allSignaturesSafe()
        .addSafeMethod("writeNoException").allSignaturesSafe()
        .addSafeMethod("writeStrongBinder").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.os.Parcelable$Creator")
        .addSafeMethod("createFromParcel").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.preference.PreferenceManager")
        .addSafeMethod("getDefaultSharedPreferences").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.BackStackRecord")
        .addSafeMethod("addOp").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.BackStackRecord$Op")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.Fragment")
        .addSafeMethod("setMenuVisibility").allSignaturesSafe()
        .addSafeMethod("setUserVisibleHint").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.FragmentActivity")
        .addSafeMethod("getLoaderManager").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.FragmentManager")
        .addSafeMethod("beginTransaction").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.FragmentManagerImpl")
        .addSafeMethod("execPendingActions").allSignaturesSafe()
        .addSafeMethod("moveToState").allSignaturesSafe()
        .addSafeMethod("noteStateNotSaved").allSignaturesSafe()
        .addSafeMethod("popBackStackState").allSignaturesSafe()
        .addSafeMethod("reverseTransit").allSignaturesSafe()
        .addSafeMethod("throwException").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.FragmentTabHost$TabInfo")
        .addSafeMethod("access$100").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.FragmentTransaction")
        .addSafeMethod("add").allSignaturesSafe()
        .addSafeMethod("commit").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.ListFragment")
        .addSafeMethod("ensureList").allSignaturesSafe()
        .addSafeMethod("getActivity").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.LoaderManagerImpl$LoaderInfo")
        .addSafeMethod("destroy").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.NotificationCompat$Style")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.ShareCompat$IntentBuilder")
        .addSafeMethod("combineArrayExtra").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.app.SuperNotCalledException")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.util.DebugUtils")
        .addSafeMethod("buildShortClassTag").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.util.LongSparseArray")
        .addSafeMethod("gc").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.util.SparseArrayCompat")
        .addSafeMethod("gc").allSignaturesSafe()
        .addSafeMethod("get").allSignaturesSafe()
        .addSafeMethod("put").allSignaturesSafe()
        .addSafeMethod("size").allSignaturesSafe()
        .addSafeMethod("valueAt").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.view.MotionEventCompat")
        .addSafeMethod("getPointerId").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.view.PagerAdapter")
        .addSafeMethod("destroyItem").allSignaturesSafe()
        .addSafeMethod("getCount").allSignaturesSafe()
        .addSafeMethod("getPageWidth").allSignaturesSafe()
        .addSafeMethod("startUpdate").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.view.PagerTitleStrip")
        .addSafeMethod("updateText").allSignaturesSafe()
        .addSafeMethod("updateTextPositions").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.view.ViewPager")
        .addSafeMethod("access$200").allSignaturesSafe()
        .addSafeMethod("access$300").allSignaturesSafe()
        .addSafeMethod("arrowScroll").allSignaturesSafe()
        .addSafeMethod("getChildAt").allSignaturesSafe()
        .addSafeMethod("getChildCount").allSignaturesSafe()
        .addSafeMethod("getCurrentItem").allSignaturesSafe()
        .addSafeMethod("getScrollX").allSignaturesSafe()
        .addSafeMethod("getWidth").allSignaturesSafe()
        .addSafeMethod("infoForChild").allSignaturesSafe()
        .addSafeMethod("infoForPosition").allSignaturesSafe()
        .addSafeMethod("populate").allSignaturesSafe()
        .addSafeMethod("scrollTo").allSignaturesSafe()
        .addSafeMethod("setCurrentItem").allSignaturesSafe()
        .addSafeMethod("setCurrentItemInternal").allSignaturesSafe()
        .addSafeMethod("setMeasuredDimension").allSignaturesSafe()
        .addSafeMethod("setScrollState").allSignaturesSafe()
        .addSafeMethod("setScrollingCacheEnabled").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.support.v4.view.accessibility.AccessibilityNodeInfoCompat")
        .addSafeMethod("wrapNonNullInstance").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.util.Log")
        .addSafeMethod("d").allSignaturesSafe()
        .addSafeMethod("e").allSignaturesSafe()
        .addSafeMethod("getStackTraceString").allSignaturesSafe()
        .addSafeMethod("i").allSignaturesSafe()
        .addSafeMethod("v").allSignaturesSafe()
        .addSafeMethod("w").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.ContextMenu")
        .addSafeMethod("add").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.LayoutInflater")
        .addSafeMethod("inflate").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.Menu")
        .addSafeMethod("add").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.MenuInflater")
        .addSafeMethod("inflate").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.MenuItem")
        .addSafeMethod("getItemId").allSignaturesSafe()
        .addSafeMethod("setIcon").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.View")
        .addSafeMethod("findViewById").allSignaturesSafe()
        .addSafeMethod("getContext").allSignaturesSafe()
        .addSafeMethod("getId").allSignaturesSafe()
        .addSafeMethod("getLayoutParams").allSignaturesSafe()
        .addSafeMethod("getLeft").allSignaturesSafe()
        .addSafeMethod("getMeasuredWidth").allSignaturesSafe()
        .addSafeMethod("getTag").allSignaturesSafe()
        .addSafeMethod("getVisibility").allSignaturesSafe()
        .addSafeMethod("measure").allSignaturesSafe()
        .addSafeMethod("setOnClickListener").allSignaturesSafe()
        .addSafeMethod("setVisibility").allSignaturesSafe()
        .addSafeMethod("startAnimation").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.View$BaseSavedState")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.View$MeasureSpec")
        .addSafeMethod("getSize").allSignaturesSafe()
        .addSafeMethod("makeMeasureSpec").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.view.animation.AnimationUtils")
        .addSafeMethod("loadAnimation").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.ArrayAdapter")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.BaseAdapter")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.Button")
        .addSafeMethod("setEnabled").allSignaturesSafe()
        .addSafeMethod("setOnClickListener").allSignaturesSafe()
        .addSafeMethod("setVisibility").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.EditText")
        .addSafeMethod("getText").allSignaturesSafe()
        .addSafeMethod("setText").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.FrameLayout")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("addView").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.FrameLayout$LayoutParams")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.ImageButton")
        .addSafeMethod("setImageResource").allSignaturesSafe()
        .addSafeMethod("setOnClickListener").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.ImageView")
        .addSafeMethod("setImageBitmap").allSignaturesSafe()
        .addSafeMethod("setImageResource").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.LinearLayout")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("addView").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.LinearLayout$LayoutParams")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.ListView")
        .addSafeMethod("setAdapter").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.ProgressBar")
        .addSafeMethod("setVisibility").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.TabHost")
        .addSafeMethod("setCurrentTab").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.TableRow")
        .addSafeMethod("addView").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.TextView")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("getCompoundDrawables").allSignaturesSafe()
        .addSafeMethod("measure").allSignaturesSafe()
        .addSafeMethod("setGravity").allSignaturesSafe()
        .addSafeMethod("setText").allSignaturesSafe()
        .addSafeMethod("setTextColor").allSignaturesSafe()
        .addSafeMethod("setVisibility").allSignaturesSafe()
        .addSafeMethod("setWidth").allSignaturesSafe()
        .done();

        safe.addSafeClass("android.widget.Toast")
        .addSafeMethod("makeText").allSignaturesSafe()
        .addSafeMethod("show").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.io.BufferedReader")
        .addSafeMethod("readLine").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.io.File")
        .addSafeMethod("isDirectory").allSignaturesSafe()
        .addSafeMethod("toString").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.io.IOException")
        .addSafeMethod("<init>").allSignaturesSafe()
        .addSafeMethod("getMessage").allSignaturesSafe()
        .addSafeMethod("printStackTrace").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.io.InputStream")
        .addSafeMethod("skip").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.io.ObjectInputStream")
        .addSafeMethod("defaultReadObject").allSignaturesSafe()
        .addSafeMethod("readInt").allSignaturesSafe()
        .addSafeMethod("writeObject").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.lang.Class")
        .addSafeMethod("isArray").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.nio.charset.Charset")
        .addSafeMethod("forName").allSignaturesSafe()
        .done();

        safe.addSafeClass("java.util.concurrent.ExecutionException")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.apache.commons.io.EndianUtils")
        .addSafeMethod("read").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.apache.commons.io.IOUtils")
        .addSafeMethod("copy").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.apache.commons.io.comparator.AbstractFileComparator")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.apache.commons.io.comparator.ReverseComparator")
        .addSafeMethod("<init>").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.apache.http.client.ClientProtocolException")
        .addSafeMethod("printStackTrace").allSignaturesSafe()
        .done();

        safe.addSafeClass("org.xmlpull.v1.XmlPullParser")
        .addSafeMethod("nextText").allSignaturesSafe()
        .done();

    	
        safeClassesAndMethods = safe.create();
    }
    
    /** get the singleton object */
    public static SafeAndroidClassesAndMethods v() {
        if (v == null)
            v = new SafeAndroidClassesAndMethods();
        
        return v;
    }
    
   /** 
    * Return true the methods declaring class is safe, or if the method 
    * has been specified as safe.
    */
   public boolean isSafeMethod(SootMethod method) {      
       String cname = method.getDeclaringClass().getName();
       if (safeClasses.contains(cname))
    	   return true;
       
       // Case #1: class not in outer map so all methods
       //          are considered potentially unsafe.
       if (!safeClassesAndMethods.containsKey(cname)) 
    	   return false;
       
       // Case #2: class is contained in the outer map but
       //          maps to a null or empty inner map; all
       //          methods are considered safe.
       Map<String,Set<List<Type>>> methods = safeClassesAndMethods.get(cname);
       if (methods == null || methods.isEmpty())
    	   return true;
       
       // Case #3: The method name is not present in the inner
       //          map so all signatures of that method are
       //          considered potentially unsafe.
       String mname = method.getName();
       if (!methods.containsKey(mname))
    	   return false;
       
       // Case #4: The method name is present in the inner
       //          map but maps to a null or empty signature
       //          set; all signatures are considered safe.
       Set<List<Type>> msigs = methods.get(mname);
       if (msigs == null || msigs.isEmpty())
    	   return true;

       // Case #5:  The method name was present in the inner
       //           map and mapped to a non-null, non-empty
       //           set of safe signatures.
       return msigs.contains(method.getParameterTypes());
   }
   
   private static SafeBuilder createSafeBuilder() {
       return new SafeBuilder();
   }
   
   private static class SafeBuilder {
       private final HashMap<String,Map<String,Set<List<Type>>>> results;
       
       public SafeBuilder() {
           this.results = new HashMap<String,Map<String,Set<List<Type>>>>();
       }
       
       public void addSafeClass(String name, Map<String,Set<List<Type>>> mths) {
           results.put(name, mths);
       }
       
       public SafeClassBuilder addSafeClass(String name) {
           return new SafeClassBuilder(this,name);
       }
       
       public Map<String,Map<String,Set<List<Type>>>> create() {
           return results;
       }
   }
   
   private static class SafeClassBuilder {
       private final SafeBuilder parent;
       private final String name;
       private final Map<String,Set<List<Type>>> methods;
       private boolean done;
       
       public SafeClassBuilder(SafeBuilder parent, String name) {
           this.parent = parent;
           this.name = name;
           this.methods = new HashMap<String,Set<List<Type>>>();
           this.done = false;
       }
       
       public void addSafeMethod(String name, Set<List<Type>> sigs) {
           if (methods.containsKey(name)) throw new IllegalStateException("cannot add the same method twice");
           methods.put(name,sigs);
       }
       
       public SafeMethodBuilder addSafeMethod(String name) {
           return new SafeMethodBuilder(this,name);
       }
       
       @SuppressWarnings("unused")
       public SafeBuilder allMethodsSafe() {
           if (done) throw new IllegalStateException("attempting to add same method to safe list twice");
           done = true;
           
           parent.addSafeClass(name, null);
           return parent;
       }
       
       public SafeBuilder done() {
           if (done) throw new IllegalStateException("attempting to add same method to safe list twice");
           done = true;
           
           parent.addSafeClass(name, methods);
           return parent;
       }
   }
   
   private static class SafeMethodBuilder {
       private final SafeClassBuilder parent;
       private final String name;
       private final HashSet<List<Type>> signatures;
       private boolean done;
       
       public SafeMethodBuilder(SafeClassBuilder parent, String name) {
           this.parent = parent;
           this.name = name;
           this.signatures = new HashSet<List<Type>>();
           this.done = false;
       }
       
       public void addSafeSignature(List<Type> sig) {
           if (signatures.contains(sig)) throw new IllegalStateException("cannot add the same signature twice");
           signatures.add(sig);
       }
       
       public SafeSignatureBuilder newSafeSignature() {
           return new SafeSignatureBuilder(this);
       }
       
       public SafeMethodBuilder addSafeSignature() {
           return newSafeSignature().done();
       }
       
       @SuppressWarnings("unused")
       public SafeMethodBuilder addSafeSignature(Type...args) {
           return newSafeSignature().args(args);
       }
       
       public SafeMethodBuilder addSafeSignature(String...args) {
           return newSafeSignature().args(args);
       }
       
       public SafeClassBuilder allSignaturesSafe() {
           if (done) throw new IllegalStateException("attempting to add same method to safe list twice");
           done = true;
           
           parent.addSafeMethod(name, null);
           return parent;
       }
       
       public SafeClassBuilder done() {
           if (done) throw new IllegalStateException("attempting to add same method to safe list twice");
           done = true;

           parent.addSafeMethod(name,signatures);
           return parent;
       }
   }
   
   public static final class SafeSignatureBuilder {
       private final SafeMethodBuilder parent;
       private final ArrayList<Type> signature;
       boolean done;
       
       private SafeSignatureBuilder(SafeMethodBuilder parent) {
           this.parent = parent;
           this.signature = new ArrayList<Type>(2);
           this.done = false;
       }
       
       public SafeMethodBuilder done() {
           if (done) throw new IllegalStateException("attempting to add same method signature to safe list twice");
           done = true;
           
           signature.trimToSize();
           parent.addSafeSignature(signature);
           return parent;
       }
       
       public SafeMethodBuilder args(String... types) {
           for (String type : types) next(type);
           return done();
       }
       
       public SafeMethodBuilder args(Type... types) {
           for (Type type : types) next(type);
           return done();
       }
       
       public SafeSignatureBuilder next(String type) {
           signature.add(reify(type));
           return this;
       }
       
       public SafeSignatureBuilder next(Type n) {
           signature.add(n);
           return this;
       }
   }
     
   static private Type reify(String type) {
       if (type == null || type.isEmpty()) throw new IllegalArgumentException("type must be non-null and non-empty");

       for (Type t : ALL_PRIMITIVE_SOOT_TYPES) {
           if (t.toString().equals(type)) 
               return t;
       }

       int brackets = (type.length() - type.replaceAll("\\[]", "").length()) / 2;
       if (brackets > 0) {
           for (Type t : ALL_PRIMITIVE_SOOT_TYPES) {
               if (VoidType.v().equals(t)) continue;
               if (ArrayType.v(t, brackets).toString().equals(type))
                   return ArrayType.v(t,brackets);
           }
           
           String base = type.substring(0, type.indexOf('['));
           return ArrayType.v(RefType.v(base), brackets);
       }
       
       return RefType.v(type);
   }
   
   static final Type[] ALL_PRIMITIVE_SOOT_TYPES = { 
       VoidType.v(),
       BooleanType.v(),
       CharType.v(),
       ByteType.v(),
       ShortType.v(),
       IntType.v(),
       LongType.v(),
       FloatType.v(),
       DoubleType.v(),
   };
   
   /** The list of safe classes */
   private static final String[] safeClassesArray = {
        "android.graphics.LinearGradient",
        "android.graphics.Paint$Align",
        "android.graphics.EmbossMaskFilter",
        "android.graphics.Paint$Join",
        "android.graphics.Paint",
        "android.graphics.Bitmap$CompressFormat",
        "android.graphics.Region",
        "android.graphics.Paint$FontMetricsInt",
        "android.graphics.RectF",
        "android.graphics.SurfaceTexture$OnFrameAvailableListener",
        "android.graphics.AvoidXfermode",
        "android.graphics.PorterDuffXfermode",
        "android.graphics.Color",
        "android.graphics.Interpolator$Result",
        "android.graphics.Matrix",
        "android.graphics.SurfaceTexture$OutOfResourcesException",
        "android.graphics.Xfermode",
        "android.graphics.ComposeShader",
        "android.graphics.ColorMatrixColorFilter",
        "android.graphics.SumPathEffect",
        "android.graphics.PorterDuff",
        "android.graphics.Path",
        "android.graphics.ColorMatrix",
        "android.graphics.Shader",
        "android.graphics.CornerPathEffect",
        "android.graphics.NinePatch",
        "android.graphics.DiscretePathEffect",
        "android.graphics.Region$Op",
        "android.graphics.RegionIterator",
        "android.graphics.PathEffect",
        "android.graphics.Interpolator",
        "android.graphics.YuvImage",
        "android.graphics.ImageFormat",
        "android.graphics.Path$Direction",
        "android.graphics.Paint$Style",
        "android.graphics.RadialGradient",
        "android.graphics.BlurMaskFilter$Blur",
        "android.graphics.Path$FillType",
        "android.graphics.Canvas$EdgeType",
        "android.graphics.PixelFormat",
        "android.graphics.drawable.GradientDrawable$Orientation",
        "android.graphics.drawable.StateListDrawable",
        "android.graphics.drawable.ScaleDrawable",
        "android.graphics.drawable.RotateDrawable",
        "android.graphics.drawable.PictureDrawable",
        "android.graphics.drawable.Animatable",
        "android.graphics.drawable.BitmapDrawable",
        "android.graphics.drawable.ColorDrawable",
        "android.graphics.drawable.Drawable",
        "android.graphics.drawable.shapes.RoundRectShape",
        "android.graphics.drawable.shapes.RectShape",
        "android.graphics.drawable.shapes.ArcShape",
        "android.graphics.drawable.shapes.OvalShape",
        "android.graphics.drawable.shapes.PathShape",
        "android.graphics.drawable.shapes.Shape",
        "android.graphics.drawable.AnimationDrawable",
        "android.graphics.drawable.PaintDrawable",
        "android.graphics.drawable.DrawableContainer$DrawableContainerState",
        "android.graphics.drawable.DrawableContainer",
        "android.graphics.drawable.Drawable$ConstantState",
        "android.graphics.drawable.TransitionDrawable",
        "android.graphics.drawable.NinePatchDrawable",
        "android.graphics.drawable.Drawable$Callback",
        "android.graphics.drawable.GradientDrawable",
        "android.graphics.drawable.ClipDrawable",
        "android.graphics.drawable.ShapeDrawable$ShaderFactory",
        "android.graphics.drawable.LayerDrawable",
        "android.graphics.drawable.LevelListDrawable",
        "android.graphics.drawable.ShapeDrawable",
        "android.graphics.drawable.InsetDrawable",
        "android.graphics.MaskFilter",
        "android.graphics.Rect",
        "android.graphics.PorterDuff$Mode",
        "android.graphics.BlurMaskFilter",
        "android.graphics.LayerRasterizer",
        "android.graphics.Movie",
        "android.graphics.ColorFilter",
        "android.graphics.LightingColorFilter",
        "android.graphics.Typeface",
        "android.graphics.PorterDuffColorFilter",
        "android.graphics.Canvas$VertexMode",
        "android.graphics.BitmapRegionDecoder",
        "android.graphics.SurfaceTexture",
        "android.graphics.PixelXorXfermode",
        "android.graphics.PathDashPathEffect",
        "android.graphics.Paint$FontMetrics",
        "android.graphics.PathDashPathEffect$Style",
        "android.graphics.DrawFilter",
        "android.graphics.DashPathEffect",
        "android.graphics.BitmapShader",
        "android.graphics.SweepGradient",
        "android.graphics.Matrix$ScaleToFit",
        "android.graphics.PaintFlagsDrawFilter",
        "android.graphics.Canvas",
        "android.graphics.ComposePathEffect",
        "android.graphics.Point",
        "android.graphics.Shader$TileMode",
        "android.graphics.BitmapFactory",
        "android.graphics.Paint$Cap",
        "android.graphics.PathMeasure",
        "android.graphics.PointF",
        "android.graphics.AvoidXfermode$Mode",
        "android.graphics.Rasterizer",
        "android.graphics.Bitmap",
        "android.util.SparseArray",
        "android.util.SparseIntArray",
        "android.util.SparseBooleanArray",
        "android.util.LongSparseArray",
        "java.lang.OutOfMemoryError",
        "java.lang.NoSuchMethodError",
        "java.lang.TypeNotPresentException",
        "java.lang.ExceptionInInitializerError",
        "java.lang.InternalError",
        "java.lang.IllegalAccessException",
        "java.lang.RuntimePermission",
        "java.lang.StackOverflowError",
        "java.lang.String",
        "java.lang.ClassNotFoundException",
        "java.lang.Long",
        "java.lang.Appendable",
        "java.lang.Runtime",
        "java.lang.UnsupportedClassVersionError",
        "java.lang.StringBuffer",
        "java.lang.NullPointerException",
        "java.lang.ClassFormatError",
        "java.lang.UnknownError",
        "java.lang.StackTraceElement",
        "java.lang.RuntimeException",
        "java.lang.Thread$UncaughtExceptionHandler",
        "java.lang.ClassCircularityError",
        "java.lang.Exception",
        "java.lang.CharSequence",
        "java.lang.UnsupportedOperationException",
        "java.lang.Boolean",
        "java.lang.IllegalThreadStateException",
        "java.lang.Short",
        "java.lang.NoSuchFieldException",
        "java.lang.ClassCastException",
        "java.lang.SecurityException",
        "java.lang.Integer",
        "java.lang.NoSuchFieldError",
        "java.lang.InstantiationException",
        "java.lang.Number",
        "java.lang.ArithmeticException",
        "java.lang.AbstractMethodError",
        "java.lang.IndexOutOfBoundsException",
        "java.lang.Deprecated",
        "java.lang.StringBuilder",
        "java.lang.IncompatibleClassChangeError",
        "java.lang.InstantiationError",
        "java.lang.IllegalMonitorStateException",
        "java.lang.AssertionError",
        "java.lang.Enum",
        "java.lang.Character$UnicodeBlock",
        "java.lang.ArrayIndexOutOfBoundsException",
        "java.lang.Iterable",
        "java.lang.Math",
        "java.lang.IllegalAccessError",
        "java.lang.StringIndexOutOfBoundsException",
        "java.lang.StrictMath",
        "java.lang.Character",
        "java.lang.Throwable",
        "java.lang.Byte",
        "java.lang.Package",
        "java.lang.VerifyError",
        "java.lang.Void",
        "java.lang.Cloneable",
        "java.lang.annotation.Annotation",
        "java.lang.annotation.AnnotationTypeMismatchException",
        "java.lang.annotation.Inherited",
        "java.lang.annotation.IncompleteAnnotationException",
        "java.lang.annotation.Documented",
        "java.lang.annotation.Retention",
        "java.lang.annotation.RetentionPolicy",
        "java.lang.annotation.Target",
        "java.lang.annotation.AnnotationFormatError",
        "java.lang.annotation.ElementType",
        "java.lang.EnumConstantNotPresentException",
        "java.lang.Comparable",
        "java.lang.NoSuchMethodException",
        "java.lang.Double",
        "java.lang.NoClassDefFoundError",
        "java.lang.Readable",
        "java.lang.NegativeArraySizeException",
        "java.lang.CloneNotSupportedException",
        "java.lang.NumberFormatException",
        "java.lang.Float",
        "java.lang.LinkageError",
        "java.lang.ref.Reference",
        "java.lang.ref.SoftReference",
        "java.lang.ref.WeakReference",
        "java.lang.ref.ReferenceQueue",
        "java.lang.ref.PhantomReference",
        "java.lang.Override",
        "java.lang.ArrayStoreException",
        "java.lang.VirtualMachineError",
        "java.lang.IllegalArgumentException",
        "java.lang.IllegalStateException",
        "java.lang.Error",
        "java.lang.SuppressWarnings",
        "java.lang.UnsatisfiedLinkError",
        "java.lang.InterruptedException",
        "java.lang.AbstractStringBuilder",
        "java.lang.Character.Subset",
        "java.lang.Object",
        "java.text.DateFormatSymbols",
        "java.text.Collator",
        "java.text.Annotation",
        "java.text.DecimalFormat",
        "java.text.Format.Field",
        "java.text.DateFormat.Field",
        "java.text.Format",
        "java.text.DateFormat",
        "java.text.AttributedString",
        "java.text.ParseException",
        "java.text.MessageFormat",
        "java.text.NumberFormat$Field",
        "java.text.SimpleDateFormat",
        "java.text.MessageFormat$Field",
        "java.text.DecimalFormatSymbols",
        "java.text.CollationKey",
        "java.text.StringCharacterIterator",
        "java.text.Bidi",
        "java.text.ChoiceFormat",
        "java.text.CollationElementIterator",
        "java.text.AttributedCharacterIterator$Attribute",
        "java.text.CharacterIterator",
        "java.text.BreakIterator",
        "java.text.AttributedCharacterIterator",
        "java.text.NumberFormat",
        "java.text.Normalizer",
        "java.text.RuleBasedCollator",
        "java.text.FieldPosition",
        "java.text.Normalizer$Form",
        "java.text.ParsePosition",
        "junit.runner.TestSuiteLoader",
        "junit.runner.Version",
        "junit.runner.BaseTestRunner",
        "junit.framework.TestCase",
        "junit.framework.TestListener",
        "junit.framework.TestSuite",
        "junit.framework.TestResult",
        "junit.framework.Protectable",
        "junit.framework.TestFailure",
        "junit.framework.Assert",
        "junit.framework.ComparisonFailure",
        "junit.framework.AssertionFailedError",
        "junit.framework.Test",
        "java.math.BigInteger",
        "java.math.MathContext",
        "java.math.RoundingMode",
        "java.math.BigDecimal",
        "java.util.LinkedHashMap",
        "java.util.AbstractSet",
        "java.util.Properties",
        "java.util.AbstractMap$SimpleImmutableEntry",
        "java.util.TreeSet",
        "java.util.Enumeration",
        "java.util.InvalidPropertiesFormatException",
        "java.util.Vector",
        "java.util.SortedSet",
        "java.util.MissingResourceException",
        "java.util.Formatter",
        "java.util.AbstractMap",
        "java.util.Dictionary",
        "java.util.Hashtable",
        "java.util.Iterator",
        "java.util.AbstractCollection",
        "java.util.NavigableSet",
        "java.util.SimpleTimeZone",
        "java.util.PropertyResourceBundle",
        "java.util.Stack",
        "java.util.Random",
        "java.util.IllegalFormatWidthException",
        "java.util.AbstractList",
        "java.util.Formatter$BigDecimalLayoutForm",
        "java.util.Locale",
        "java.util.FormattableFlags",
        "java.util.SortedMap",
        "java.util.prefs.PreferencesFactory",
        "java.util.prefs.NodeChangeEvent",
        "java.util.prefs.NodeChangeListener",
        "java.util.prefs.InvalidPreferencesFormatException",
        "java.util.prefs.AbstractPreferences",
        "java.util.prefs.BackingStoreException",
        "java.util.prefs.PreferenceChangeListener",
        "java.util.prefs.Preferences",
        "java.util.prefs.PreferenceChangeEvent",
        "java.util.AbstractQueue",
        "java.util.ArrayDeque",
        "java.util.Arrays",
        "java.util.EnumSet",
        "java.util.logging.ConsoleHandler",
        "java.util.logging.XMLFormatter",
        "java.util.logging.FileHandler",
        "java.util.logging.Formatter",
        "java.util.logging.Handler",
        "java.util.logging.SimpleFormatter",
        "java.util.logging.ErrorManager",
        "java.util.logging.LogManager",
        "java.util.logging.Filter",
        "java.util.logging.StreamHandler",
        "java.util.logging.MemoryHandler",
        "java.util.logging.SocketHandler",
        "java.util.logging.LogRecord",
        "java.util.logging.LoggingMXBean",
        "java.util.logging.LoggingPermission",
        "java.util.logging.Level",
        "java.util.logging.Logger",
        "java.util.RandomAccess",
        "java.util.IllegalFormatFlagsException",
        "java.util.EventListenerProxy",
        "java.util.ArrayList",
        "java.util.ServiceConfigurationError",
        "java.util.jar.Pack200",
        "java.util.jar.JarException",
        "java.util.jar.Attributes",
        "java.util.jar.Pack200$Unpacker",
        "java.util.jar.Pack200$Packer",
        "java.util.jar.Attributes$Name",
        "java.util.jar.JarOutputStream",
        "java.util.jar.JarInputStream",
        "java.util.jar.Manifest",
        "java.util.IllegalFormatPrecisionException",
        "java.util.Collection",
        "java.util.EventListener",
        "java.util.IllegalFormatException",
        "java.util.PropertyPermission",
        "java.util.UnknownFormatConversionException",
        "java.util.regex.Matcher",
        "java.util.regex.Pattern",
        "java.util.regex.PatternSyntaxException",
        "java.util.regex.MatchResult",
        "java.util.ResourceBundle$Control",
        "java.util.IllegalFormatCodePointException",
        "java.util.AbstractMap$SimpleEntry",
        "java.util.Map$Entry",
        "java.util.Observer",
        "java.util.Observable",
        "java.util.StringTokenizer",
        "java.util.Comparator",
        "java.util.TreeMap",
        "java.util.ListResourceBundle",
        "java.util.Currency",
        "java.util.FormatFlagsConversionMismatchException",
        "java.util.MissingFormatWidthException",
        "java.util.LinkedHashSet",
        "java.util.Map",
        "java.util.PriorityQueue",
        "java.util.EmptyStackException",
        "java.util.HashSet",
        "java.util.UnknownFormatFlagsException",
        "java.util.WeakHashMap",
        "java.util.ListIterator",
        "java.util.Formattable",
        "java.util.EventObject",
        "java.util.Set",
        "java.util.MissingFormatArgumentException",
        "java.util.FormatterClosedException",
        "java.util.Queue",
        "java.util.Scanner",
        "java.util.NoSuchElementException",
        "java.util.HashMap",
        "java.util.Deque",
        "java.util.BitSet",
        "java.util.Collections",
        "java.util.TooManyListenersException",
        "java.util.List",
        "java.util.DuplicateFormatFlagsException",
        "java.util.InputMismatchException",
        "java.util.LinkedList",
        "java.util.NavigableMap",
        "java.util.AbstractSequentialList",
        "java.util.IdentityHashMap",
        "java.util.EnumMap",
        "java.util.ResourceBundle",
        "java.util.IllegalFormatConversionException",
        "java.util.ConcurrentModificationException",
        "java.util.Collections$1",
        "java.util.Collections$AsLIFOQueue",
        "java.util.Collections$CheckedCollection",
        "java.util.Collections$CheckedList",
        "java.util.Collections$CheckedListIterator",
        "java.util.Collections$CheckedRandomAccessList",
        "java.util.Collections$CheckedSet",
        "java.util.Collections$CopiesList",
        "java.util.Collections$ReverseComparator",
        "java.util.Collections$ReverseComparator2",
        "java.util.Collections$SetFromMap",
        "java.util.Collections$SingletonList",
        "java.util.Collections$SingletonMap$1$1$1",
        "java.util.Collections$SingletonMap$1$1",
        "java.util.Collections$SingletonMap$1",
        "java.util.Collections$SingletonMap",
        "java.util.Collections$SingletonSet$1",
        "java.util.Collections$SingletonSet",
        "java.util.Collections$SynchronizedCollection",
        "java.util.Collections$SynchronizedList",
        "java.util.Collections$SynchronizedMap",
        "java.util.Collections$SynchronizedRandomAccessList",
        "java.util.Collections$SynchronizedSet",
        "java.util.Collections$SynchronizedSortedMap",
        "java.util.Collections$SynchronizedSortedSet",
        "java.util.Collections$UnmodifiableCollection$1",
        "java.util.Collections$UnmodifiableCollection",
        "java.util.Collections$UnmodifiableList$1",
        "java.util.Collections$UnmodifiableList",
        "java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1",
        "java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry",
        "java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet",
        "java.util.Collections$UnmodifiableMap",
        "java.util.Collections$UnmodifiableRandomAccessList",
        "java.util.Collections$UnmodifiableSet",
        "java.util.Collections$UnmodifiableSortedMap",
        "java.util.Collections$UnmodifiableSortedSet",
        "java.util.concurrent.BlockingQueue",
        "java.util.concurrent.CopyOnWriteArraySet",
        "java.util.concurrent.TimeoutException",
        "java.util.concurrent.LinkedBlockingDeque",
        "java.util.concurrent.PriorityBlockingQueue",
        "java.util.concurrent.BlockingDeque",
        "java.util.concurrent.RejectedExecutionException",
        "java.util.concurrent.ArrayBlockingQueue",
        "java.util.concurrent.SynchronousQueue",
        "java.util.concurrent.ConcurrentHashMap",
        "java.util.concurrent.Executor",
        "java.util.concurrent.locks.ReadWriteLock",
        "java.util.concurrent.locks.ReentrantReadWriteLock",
        "java.util.concurrent.locks.Condition",
        "java.util.concurrent.locks.AbstractQueuedLongSynchronizer",
        "java.util.concurrent.locks.LockSupport",
        "java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject",
        "java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock",
        "java.util.concurrent.locks.AbstractOwnableSynchronizer",
        "java.util.concurrent.locks.Lock",
        "java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject",
        "java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock",
        "java.util.concurrent.locks.AbstractQueuedSynchronizer",
        "java.util.concurrent.locks.ReentrantLock",
        "java.util.concurrent.ConcurrentLinkedQueue",
        "java.util.concurrent.ConcurrentMap",
        "java.util.concurrent.atomic.AtomicInteger",
        "java.util.concurrent.atomic.AtomicReference",
        "java.util.concurrent.atomic.AtomicIntegerArray",
        "java.util.concurrent.atomic.AtomicLongArray",
        "java.util.concurrent.atomic.AtomicMarkableReference",
        "java.util.concurrent.atomic.AtomicStampedReference",
        "java.util.concurrent.atomic.AtomicIntegerFieldUpdater",
        "java.util.concurrent.atomic.AtomicLongFieldUpdater",
        "java.util.concurrent.atomic.AtomicBoolean",
        "java.util.concurrent.atomic.AtomicReferenceFieldUpdater",
        "java.util.concurrent.atomic.AtomicReferenceArray",
        "java.util.concurrent.atomic.AtomicLong",
        "java.util.concurrent.CancellationException",
        "java.util.concurrent.ConcurrentSkipListSet",
        "java.util.concurrent.BrokenBarrierException",
        "java.util.concurrent.LinkedBlockingQueue",
        "java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy",
        "java.util.concurrent.Callable",
        "java.util.concurrent.ThreadPoolExecutor$DiscardPolicy",
        "java.util.concurrent.ConcurrentSkipListMap",
        "java.util.concurrent.Executors",
        "java.util.concurrent.ThreadFactory",
        "java.util.concurrent.ScheduledThreadPoolExecutor",
        "java.util.concurrent.CyclicBarrier",
        "java.util.concurrent.TimeUnit",
        "java.util.concurrent.ExecutorCompletionService",
        "java.util.concurrent.DelayQueue",
        "java.util.concurrent.ConcurrentNavigableMap",
        "java.util.concurrent.CopyOnWriteArrayList",
        "android.text.AlteredCharSequence",
        "android.text.SpannableStringBuilder",
        "android.text.SpannableStringInternal",
        "android.text.TextUtils$MyCreator",
        "android.text.TextUtils$SimpleStringSplitter",
        "android.text.TextUtils$StringSplitter",
        "android.text.TextUtils",
        "android.text.Editable$Factory",
        "android.text.style.LeadingMarginSpan$LeadingMarginSpan2",
        "android.text.style.LeadingMarginSpan$Standard",
        "android.text.style.MetricAffectingSpan",
        "android.text.style.LineHeightSpan$WithDensity",
        "android.text.style.ClickableSpan",
        "android.text.style.SubscriptSpan",
        "android.text.style.RasterizerSpan",
        "android.text.style.SuperscriptSpan",
        "android.text.style.WrapTogetherSpan",
        "android.text.style.QuoteSpan",
        "android.text.style.ForegroundColorSpan",
        "android.text.style.UnderlineSpan",
        "android.text.style.AbsoluteSizeSpan",
        "android.text.style.AlignmentSpan",
        "android.text.style.LineBackgroundSpan",
        "android.text.style.EasyEditSpan",
        "android.text.style.TextAppearanceSpan",
        "android.text.style.CharacterStyle",
        "android.text.style.URLSpan",
        "android.text.style.TabStopSpan$Standard",
        "android.text.style.ReplacementSpan",
        "android.text.style.MaskFilterSpan",
        "android.text.style.LineHeightSpan",
        "android.text.style.RelativeSizeSpan",
        "android.text.style.SuggestionSpan",
        "android.text.style.LeadingMarginSpan",
        "android.text.style.TabStopSpan",
        "android.text.style.DynamicDrawableSpan",
        "android.text.style.BackgroundColorSpan",
        "android.text.style.ScaleXSpan",
        "android.text.style.BulletSpan",
        "android.text.style.UpdateLayout",
        "android.text.style.ImageSpan",
        "android.text.style.TypefaceSpan",
        "android.text.style.IconMarginSpan",
        "android.text.style.StrikethroughSpan",
        "android.text.style.StyleSpan",
        "android.text.style.DrawableMarginSpan",
        "android.text.style.UpdateAppearance",
        "android.text.style.ParagraphStyle",
        "android.text.style.AlignmentSpan$Standard",
        "android.text.LoginFilter",
        "android.text.TextUtils$TruncateAt",
        "android.text.StaticLayout",
        "android.text.Editable",
        "android.text.DynamicLayout",
        "android.text.Html$TagHandler",
        "android.text.Annotation",
        "android.text.method.CharacterPickerDialog",
        "android.text.method.ReplacementTransformationMethod",
        "android.text.method.KeyListener",
        "android.text.method.TimeKeyListener",
        "android.text.method.Touch",
        "android.text.method.BaseMovementMethod",
        "android.text.method.TransformationMethod",
        "android.text.method.DateKeyListener",
        "android.text.method.TextKeyListener$Capitalize",
        "android.text.method.MetaKeyKeyListener",
        "android.text.method.MultiTapKeyListener",
        "android.text.method.SingleLineTransformationMethod",
        "android.text.method.DateTimeKeyListener",
        "android.text.method.HideReturnsTransformationMethod",
        "android.text.method.TextKeyListener",
        "android.text.method.LinkMovementMethod",
        "android.text.method.ArrowKeyMovementMethod",
        "android.text.method.NumberKeyListener",
        "android.text.method.PasswordTransformationMethod",
        "android.text.method.BaseKeyListener",
        "android.text.method.DialerKeyListener",
        "android.text.method.ScrollingMovementMethod",
        "android.text.method.DigitsKeyListener",
        "android.text.method.QwertyKeyListener",
        "android.text.method.MovementMethod",
        "android.text.Html$ImageGetter",
        "android.text.InputFilter",
        "android.text.Spannable",
        "android.text.LoginFilter$UsernameFilterGMail",
        "android.text.BoringLayout",
        "android.text.NoCopySpan",
        "android.text.GetChars",
        "android.text.SpannableString",
        "android.text.util.Rfc822Tokenizer",
        "android.text.util.Rfc822Token",
        "android.text.util.Linkify$TransformFilter",
        "android.text.util.Linkify",
        "android.text.util.Linkify$MatchFilter",
        "android.text.ParcelableSpan",
        "android.text.InputFilter$LengthFilter",
        "android.text.AndroidCharacter",
        "android.text.LoginFilter$UsernameFilterGeneric",
        "android.text.NoCopySpan$Concrete",
        "android.text.Layout$Directions",
        "android.text.AutoText",
        "android.text.Spannable$Factory",
        "android.text.SpanWatcher",
        "android.text.Layout$Alignment",
        "android.text.TextUtils$EllipsizeCallback",
        "android.text.TextWatcher",
        "android.text.TextPaint",
        "android.text.Selection",
        "android.text.Html",
        "android.text.InputType",
        "android.text.format.Formatter",
        "android.text.InputFilter$AllCaps",
        "android.text.BoringLayout$Metrics",
        "android.text.Spanned",
        "android.text.LoginFilter$PasswordFilterGMail",
        "android.text.SpannedString",
        "android.text.Layout",
        "android.animation.ValueAnimator",
        "android.graphics.PointF",
        
        // Note below here are non-system classes that seem
        // to be safe. One possible malware attack vector could
        // be to use these same class names for malware related
        // code. We should consider not allowing any non-system
        // classes/methods in the safe list.
        "org.apache.http.message.BasicNameValuePair"
        };
}
