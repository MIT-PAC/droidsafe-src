package droidsafe.analyses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.SootMethod;
import soot.Type;

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
    	    .addSafeMethod("getName").allSignaturesSafe()
            .addSafeMethod("isAnnotation").allSignaturesSafe()
            .addSafeMethod("isAnnotationPresent").allSignaturesSafe()
            .addSafeMethod("isAnonymousClass").allSignaturesSafe()
            .addSafeMethod("isArray").allSignaturesSafe()
            .addSafeMethod("isAssignableFrom").allSignaturesSafe()
            .addSafeMethod("isEnum").allSignaturesSafe()
            .addSafeMethod("isInstance").allSignaturesSafe()
            .addSafeMethod("isInterface").allSignaturesSafe()
            .addSafeMethod("isLocalClass").allSignaturesSafe()
            .addSafeMethod("isMemberClass").allSignaturesSafe()
            .addSafeMethod("isPrimitive").allSignaturesSafe()
            .addSafeMethod("isSynthetic").allSignaturesSafe()
            .done();
    	
    	// Methods from java.lang.System that are considered safe.
    	safe.addSafeClass("java.lang.System")
    	    .addSafeMethod("arraycopy").allSignaturesSafe()
    	    .done();
    	
    	// Methods from android.content.Intent that are considered safe.
    	safe.addSafeClass("android.content.Intent")
    	    .addSafeMethod("<init>").allSignaturesSafe()
    	    .done();

        // Methods from android.app.AlertDialog$Builder that are considered safe.
        safe.addSafeClass("android.app.AlertDialog$Builder")
            .addSafeMethod("setTitle").allSignaturesSafe()
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

       // Case #3-#5: class is contained in the outer map and
       //             maps to a non-null, non-empty inner map;
       //             only methods contained in the inner map
       //             are considered safe.
       String mname = method.getName();
       
       // Case #3: The method name is not present in the inner
       //          map so all signatures of that method are
       //          considered potentially unsafe.
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
       
       @SuppressWarnings("unused")
       public SafeSignatureBuilder newSafeSignature() {
           return new SafeSignatureBuilder(this);
       }
       
       public SafeClassBuilder allSignaturesSafe() {
           if (done) throw new IllegalStateException("attempting to add same method to safe list twice");
           done = true;
           
           parent.addSafeMethod(name, null);
           return parent;
       }
       
       @SuppressWarnings("unused")
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
       
       public SafeSignatureBuilder next(String type) {
           // TODO: we really want to be able to create a 
           //       Soot type based on a string. Perhaps the
           //       best thing is to just use string everywhere
           //       instead of type, but that complicates the
           //       checking code which is executed much more
           //       frequently. At the present, I don't know
           //       enough about soot to reify the string
           //       here into a Type.
           throw new UnsupportedOperationException("cannot convert string to soot type");
       }       
       
       public SafeSignatureBuilder next(Type n) {
           signature.add(n);
           return this;
       }
   }
     
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
