#!/usr/bin/perl -w
#
# script to put security labels on the methdo 
#
use Getopt::Long;
use IO::Handle;

$annoAtEndOfLine = 0;
$removeAnnotation = 0;
$reportFile = "none";
GetOptions(
        "end",        => \$annoAtEndOfLine,
        "remove",     => \$removeAnnotation,
        "report=s"    =>  \$reportFile);  # flag

$inName = shift @ARGV;
$outName = shift @ARGV;

if (!defined($inName)) {
    &syntax();
    exit -1;
}

#
# syntax: <infile> <outfile> <callback_out> <change_file_out> 
#

open($inFile, "<$inName") || die("Cannot open $inName \n");

@outLines = ();

while(<$inFile>) {
    $line = $_;

    $line =~ s/^\s+//g;
    $line =~ s/\s+$//g;

    @tokens = split(/-/, $line);
    @outList = ();
    $method = "";
    foreach $token(@tokens) {
        $token =~ s/^\s*//g;
        $token =~ s/\s*$//g;
        if ($token =~ /</) {
            $method = $token;
        }
        else {
            push @outList, $token;
        }
    }

    if ($method =~ /^$/) {
        push @outLines, $line;
        next;
    }

    if ($removeAnnotation) {
        @outList = ($method);
    } elsif ($annoAtEndOfLine) {
        @outList = ($method, @outList);
    }
    else {
        @outList = (@outList, $method);
    }
    $newLine = join(" - ", @outList);
    push @outLines, $newLine;
}

close $inFile;

if (defined($outName)) {
    print "Opening $outName ....\n";
	open($outFile, ">$outName") || die("Cannot open $outName \n");
} else {
    $outFile = \*STDOUT;
}  

foreach $line(@outLines) {
    print $outFile $line , "\n";
}


exit 0;

##################################################################################
# Functions
##################################################################################

sub loadClassCategory{

    my @safeClassList= ('android.graphics.LinearGradient',
         'android.graphics.Paint$Align',
         'android.graphics.EmbossMaskFilter',
         'android.graphics.Paint$Join',
         'android.graphics.Paint',
         'android.graphics.Bitmap$CompressFormat',
         'android.graphics.Region',
         'android.graphics.Paint$FontMetricsInt',
         'android.graphics.RectF',
         'android.graphics.SurfaceTexture$OnFrameAvailableListener',
         'android.graphics.AvoidXfermode',
         'android.graphics.PorterDuffXfermode',
         'android.graphics.Color',
         'android.graphics.Interpolator$Result',
         'android.graphics.Matrix',
         'android.graphics.SurfaceTexture$OutOfResourcesException',
         'android.graphics.Xfermode',
         'android.graphics.ComposeShader',
         'android.graphics.ColorMatrixColorFilter',
         'android.graphics.SumPathEffect',
         'android.graphics.PorterDuff',
         'android.graphics.Path',
         'android.graphics.ColorMatrix',
         'android.graphics.Shader',
         'android.graphics.CornerPathEffect',
         'android.graphics.NinePatch',
         'android.graphics.DiscretePathEffect',
         'android.graphics.Region$Op',
         'android.graphics.RegionIterator',
         'android.graphics.PathEffect',
         'android.graphics.Interpolator',
         'android.graphics.YuvImage',
         'android.graphics.ImageFormat',
         'android.graphics.Path$Direction',
         'android.graphics.Paint$Style',
         'android.graphics.RadialGradient',
         'android.graphics.BlurMaskFilter$Blur',
         'android.graphics.Path$FillType',
         'android.graphics.Canvas$EdgeType',
         'android.graphics.PixelFormat',
         'android.graphics.drawable.GradientDrawable$Orientation',
         'android.graphics.drawable.StateListDrawable',
         'android.graphics.drawable.ScaleDrawable',
         'android.graphics.drawable.RotateDrawable',
         'android.graphics.drawable.PictureDrawable',
         'android.graphics.drawable.Animatable',
         'android.graphics.drawable.BitmapDrawable',
         'android.graphics.drawable.ColorDrawable',
         'android.graphics.drawable.Drawable',
         'android.graphics.drawable.shapes.RoundRectShape',
         'android.graphics.drawable.shapes.RectShape',
         'android.graphics.drawable.shapes.ArcShape',
         'android.graphics.drawable.shapes.OvalShape',
         'android.graphics.drawable.shapes.PathShape',
         'android.graphics.drawable.shapes.Shape',
         'android.graphics.drawable.AnimationDrawable',
         'android.graphics.drawable.PaintDrawable',
         'android.graphics.drawable.DrawableContainer$DrawableContainerState',
         'android.graphics.drawable.DrawableContainer',
         'android.graphics.drawable.Drawable$ConstantState',
         'android.graphics.drawable.TransitionDrawable',
         'android.graphics.drawable.NinePatchDrawable',
         'android.graphics.drawable.Drawable$Callback',
         'android.graphics.drawable.GradientDrawable',
         'android.graphics.drawable.ClipDrawable',
         'android.graphics.drawable.ShapeDrawable$ShaderFactory',
         'android.graphics.drawable.LayerDrawable',
         'android.graphics.drawable.LevelListDrawable',
         'android.graphics.drawable.ShapeDrawable',
         'android.graphics.drawable.InsetDrawable',
         'android.graphics.MaskFilter',
         'android.graphics.Rect',
         'android.graphics.PorterDuff$Mode',
         'android.graphics.BlurMaskFilter',
         'android.graphics.LayerRasterizer',
         'android.graphics.Movie',
         'android.graphics.ColorFilter',
         'android.graphics.LightingColorFilter',
         'android.graphics.Typeface',
         'android.graphics.PorterDuffColorFilter',
         'android.graphics.Canvas$VertexMode',
         'android.graphics.BitmapRegionDecoder',
         'android.graphics.SurfaceTexture',
         'android.graphics.PixelXorXfermode',
         'android.graphics.PathDashPathEffect',
         'android.graphics.Paint$FontMetrics',
         'android.graphics.PathDashPathEffect$Style',
         'android.graphics.DrawFilter',
         'android.graphics.DashPathEffect',
         'android.graphics.BitmapShader',
         'android.graphics.SweepGradient',
         'android.graphics.Matrix$ScaleToFit',
         'android.graphics.PaintFlagsDrawFilter',
         'android.graphics.Canvas',
         'android.graphics.ComposePathEffect',
         'android.graphics.Point',
         'android.graphics.Shader$TileMode',
         'android.graphics.BitmapFactory',
         'android.graphics.Paint$Cap',
         'android.graphics.PathMeasure',
         'android.graphics.PointF',
         'android.graphics.AvoidXfermode$Mode',
         'android.graphics.Rasterizer',
         'android.graphics.Bitmap',
         'android.util.SparseArray',
         'android.util.SparseIntArray',
         'android.util.SparseBooleanArray',
         'android.util.LongSparseArray',
         'java.lang.OutOfMemoryError',
         'java.lang.NoSuchMethodError',
         'java.lang.TypeNotPresentException',
         'java.lang.ExceptionInInitializerError',
         'java.lang.InternalError',
         'java.lang.IllegalAccessException',
         'java.lang.RuntimePermission',
         'java.lang.StackOverflowError',
         'java.lang.String',
         'java.lang.ClassNotFoundException',
         'java.lang.Long',
         'java.lang.Appendable',
         'java.lang.Runtime',
         'java.lang.UnsupportedClassVersionError',
         'java.lang.StringBuffer',
         'java.lang.NullPointerException',
         'java.lang.ClassFormatError',
         'java.lang.UnknownError',
         'java.lang.StackTraceElement',
         'java.lang.RuntimeException',
         'java.lang.Thread$UncaughtExceptionHandler',
         'java.lang.ClassCircularityError',
         'java.lang.Exception',
         'java.lang.CharSequence',
         'java.lang.UnsupportedOperationException',
         'java.lang.Boolean',
         'java.lang.IllegalThreadStateException',
         'java.lang.Short',
         'java.lang.NoSuchFieldException',
         'java.lang.ClassCastException',
         'java.lang.SecurityException',
         'java.lang.Integer',
         'java.lang.NoSuchFieldError',
         'java.lang.InstantiationException',
         'java.lang.Number',
         'java.lang.ArithmeticException',
         'java.lang.AbstractMethodError',
         'java.lang.IndexOutOfBoundsException',
         'java.lang.Deprecated',
         'java.lang.StringBuilder',
         'java.lang.IncompatibleClassChangeError',
         'java.lang.InstantiationError',
         'java.lang.IllegalMonitorStateException',
         'java.lang.AssertionError',
         'java.lang.Enum',
         'java.lang.Character$UnicodeBlock',
         'java.lang.ArrayIndexOutOfBoundsException',
         'java.lang.Iterable',
         'java.lang.Math',
         'java.lang.IllegalAccessError',
         'java.lang.StringIndexOutOfBoundsException',
         'java.lang.StrictMath',
         'java.lang.Character',
         'java.lang.Throwable',
         'java.lang.Byte',
         'java.lang.Package',
         'java.lang.VerifyError',
         'java.lang.Void',
         'java.lang.Cloneable',
         'java.lang.annotation.Annotation',
         'java.lang.annotation.AnnotationTypeMismatchException',
         'java.lang.annotation.Inherited',
         'java.lang.annotation.IncompleteAnnotationException',
         'java.lang.annotation.Documented',
         'java.lang.annotation.Retention',
         'java.lang.annotation.RetentionPolicy',
         'java.lang.annotation.Target',
         'java.lang.annotation.AnnotationFormatError',
         'java.lang.annotation.ElementType',
         'java.lang.EnumConstantNotPresentException',
         'java.lang.Comparable',
         'java.lang.NoSuchMethodException',
         'java.lang.Double',
         'java.lang.NoClassDefFoundError',
         'java.lang.Readable',
         'java.lang.NegativeArraySizeException',
         'java.lang.CloneNotSupportedException',
         'java.lang.NumberFormatException',
         'java.lang.Float',
         'java.lang.LinkageError',
         'java.lang.ref.Reference',
         'java.lang.ref.SoftReference',
         'java.lang.ref.WeakReference',
         'java.lang.ref.ReferenceQueue',
         'java.lang.ref.PhantomReference',
         'java.lang.Override',
         'java.lang.ArrayStoreException',
         'java.lang.VirtualMachineError',
         'java.lang.IllegalArgumentException',
         'java.lang.IllegalStateException',
         'java.lang.Error',
         'java.lang.SuppressWarnings',
         'java.lang.UnsatisfiedLinkError',
         'java.lang.InterruptedException',
         'java.lang.AbstractStringBuilder',
         'java.lang.Character.Subset',
         'java.lang.Object',
         'java.text.DateFormatSymbols',
         'java.text.Collator',
         'java.text.Annotation',
         'java.text.DecimalFormat',
         'java.text.Format.Field',
         'java.text.DateFormat.Field',
         'java.text.Format',
         'java.text.DateFormat',
         'java.text.AttributedString',
         'java.text.ParseException',
         'java.text.MessageFormat',
         'java.text.NumberFormat$Field',
         'java.text.SimpleDateFormat',
         'java.text.MessageFormat$Field',
         'java.text.DecimalFormatSymbols',
         'java.text.CollationKey',
         'java.text.StringCharacterIterator',
         'java.text.Bidi',
         'java.text.ChoiceFormat',
         'java.text.CollationElementIterator',
         'java.text.AttributedCharacterIterator$Attribute',
         'java.text.CharacterIterator',
         'java.text.BreakIterator',
         'java.text.AttributedCharacterIterator',
         'java.text.NumberFormat',
         'java.text.Normalizer',
         'java.text.RuleBasedCollator',
         'java.text.FieldPosition',
         'java.text.Normalizer$Form',
         'java.text.ParsePosition',
         'junit.runner.TestSuiteLoader',
         'junit.runner.Version',
         'junit.runner.BaseTestRunner',
         'junit.framework.TestCase',
         'junit.framework.TestListener',
         'junit.framework.TestSuite',
         'junit.framework.TestResult',
         'junit.framework.Protectable',
         'junit.framework.TestFailure',
         'junit.framework.Assert',
         'junit.framework.ComparisonFailure',
         'junit.framework.AssertionFailedError',
         'junit.framework.Test',
         'java.math.BigInteger',
         'java.math.MathContext',
         'java.math.RoundingMode',
         'java.math.BigDecimal',
         'java.util.LinkedHashMap',
         'java.util.AbstractSet',
         'java.util.Properties',
         'java.util.AbstractMap$SimpleImmutableEntry',
         'java.util.TreeSet',
         'java.util.Enumeration',
         'java.util.InvalidPropertiesFormatException',
         'java.util.Vector',
         'java.util.SortedSet',
         'java.util.MissingResourceException',
         'java.util.Formatter',
         'java.util.AbstractMap',
         'java.util.Dictionary',
         'java.util.Hashtable',
         'java.util.Iterator',
         'java.util.AbstractCollection',
         'java.util.NavigableSet',
         'java.util.SimpleTimeZone',
         'java.util.PropertyResourceBundle',
         'java.util.Stack',
         'java.util.Random',
         'java.util.IllegalFormatWidthException',
         'java.util.AbstractList',
         'java.util.Formatter$BigDecimalLayoutForm',
         'java.util.Locale',
         'java.util.FormattableFlags',
         'java.util.SortedMap',
         'java.util.prefs.PreferencesFactory',
         'java.util.prefs.NodeChangeEvent',
         'java.util.prefs.NodeChangeListener',
         'java.util.prefs.InvalidPreferencesFormatException',
         'java.util.prefs.AbstractPreferences',
         'java.util.prefs.BackingStoreException',
         'java.util.prefs.PreferenceChangeListener',
         'java.util.prefs.Preferences',
         'java.util.prefs.PreferenceChangeEvent',
         'java.util.TimeZone',
         'java.util.AbstractQueue',
         'java.util.ArrayDeque',
         'java.util.Arrays',
         'java.util.EnumSet',
         'java.util.logging.ConsoleHandler',
         'java.util.logging.XMLFormatter',
         'java.util.logging.FileHandler',
         'java.util.logging.Formatter',
         'java.util.logging.Handler',
         'java.util.logging.SimpleFormatter',
         'java.util.logging.ErrorManager',
         'java.util.logging.LogManager',
         'java.util.logging.Filter',
         'java.util.logging.StreamHandler',
         'java.util.logging.MemoryHandler',
         'java.util.logging.SocketHandler',
         'java.util.logging.LogRecord',
         'java.util.logging.LoggingMXBean',
         'java.util.logging.LoggingPermission',
         'java.util.logging.Level',
         'java.util.logging.Logger',
         'java.util.RandomAccess',
         'java.util.IllegalFormatFlagsException',
         'java.util.EventListenerProxy',
         'java.util.ArrayList',
         'java.util.ServiceConfigurationError',
         'java.util.jar.Pack200',
         'java.util.jar.JarException',
         'java.util.jar.Attributes',
         'java.util.jar.Pack200$Unpacker',
         'java.util.jar.Pack200$Packer',
         'java.util.jar.Attributes$Name',
         'java.util.jar.JarOutputStream',
         'java.util.jar.JarInputStream',
         'java.util.jar.Manifest',
         'java.util.IllegalFormatPrecisionException',
         'java.util.Collection',
         'java.util.EventListener',
         'java.util.IllegalFormatException',
         'java.util.PropertyPermission',
         'java.util.UnknownFormatConversionException',
         'java.util.regex.Matcher',
         'java.util.regex.Pattern',
         'java.util.regex.PatternSyntaxException',
         'java.util.regex.MatchResult',
         'java.util.ResourceBundle$Control',
         'java.util.IllegalFormatCodePointException',
         'java.util.AbstractMap$SimpleEntry',
         'java.util.Map$Entry',
         'java.util.Observer',
         'java.util.Observable',
         'java.util.StringTokenizer',
         'java.util.Comparator',
         'java.util.TreeMap',
         'java.util.ListResourceBundle',
         'java.util.Currency',
         'java.util.FormatFlagsConversionMismatchException',
         'java.util.MissingFormatWidthException',
         'java.util.LinkedHashSet',
         'java.util.Map',
         'java.util.PriorityQueue',
         'java.util.EmptyStackException',
         'java.util.HashSet',
         'java.util.UnknownFormatFlagsException',
         'java.util.WeakHashMap',
         'java.util.ListIterator',
         'java.util.Formattable',
         'java.util.EventObject',
         'java.util.Set',
         'java.util.MissingFormatArgumentException',
         'java.util.FormatterClosedException',
         'java.util.Queue',
         'java.util.Scanner',
         'java.util.NoSuchElementException',
         'java.util.HashMap',
         'java.util.Deque',
         'java.util.BitSet',
         'java.util.Collections',
         'java.util.TooManyListenersException',
         'java.util.List',
         'java.util.DuplicateFormatFlagsException',
         'java.util.InputMismatchException',
         'java.util.LinkedList',
         'java.util.NavigableMap',
         'java.util.AbstractSequentialList',
         'java.util.IdentityHashMap',
#         'java.util.TimerTask',
         'java.util.EnumMap',
         'java.util.ResourceBundle',
         'java.util.IllegalFormatConversionException',
         'java.util.ConcurrentModificationException',
         'java.util.Collections$1',
         'java.util.Collections$AsLIFOQueue',
         'java.util.Collections$CheckedCollection',
         'java.util.Collections$CheckedList',
         'java.util.Collections$CheckedListIterator',
         'java.util.Collections$CheckedRandomAccessList',
         'java.util.Collections$CheckedSet',
         'java.util.Collections$CopiesList',
         'java.util.Collections$ReverseComparator',
         'java.util.Collections$ReverseComparator2',
         'java.util.Collections$SetFromMap',
         'java.util.Collections$SingletonList',
         'java.util.Collections$SingletonMap$1$1$1',
         'java.util.Collections$SingletonMap$1$1',
         'java.util.Collections$SingletonMap$1',
         'java.util.Collections$SingletonMap',
         'java.util.Collections$SingletonSet$1',
         'java.util.Collections$SingletonSet',
         'java.util.Collections$SynchronizedCollection',
         'java.util.Collections$SynchronizedList',
         'java.util.Collections$SynchronizedMap',
         'java.util.Collections$SynchronizedRandomAccessList',
         'java.util.Collections$SynchronizedSet',
         'java.util.Collections$SynchronizedSortedMap',
         'java.util.Collections$SynchronizedSortedSet',
         'java.util.Collections$UnmodifiableCollection$1',
         'java.util.Collections$UnmodifiableCollection',
         'java.util.Collections$UnmodifiableList$1',
         'java.util.Collections$UnmodifiableList',
         'java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$1',
         'java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry',
         'java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet',
         'java.util.Collections$UnmodifiableMap',
         'java.util.Collections$UnmodifiableRandomAccessList',
         'java.util.Collections$UnmodifiableSet',
         'java.util.Collections$UnmodifiableSortedMap',
         'java.util.Collections$UnmodifiableSortedSet',
         'java.util.concurrent.BlockingQueue',
         'java.util.concurrent.CopyOnWriteArraySet',
         'java.util.concurrent.TimeoutException',
         'java.util.concurrent.LinkedBlockingDeque',
         'java.util.concurrent.PriorityBlockingQueue',
         'java.util.concurrent.BlockingDeque',
         'java.util.concurrent.RejectedExecutionException',
         'java.util.concurrent.ArrayBlockingQueue',
         'java.util.concurrent.SynchronousQueue',
         'java.util.concurrent.ConcurrentHashMap',
         'java.util.concurrent.Executor',
         'java.util.concurrent.locks.ReadWriteLock',
         'java.util.concurrent.locks.ReentrantReadWriteLock',
         'java.util.concurrent.locks.Condition',
         'java.util.concurrent.locks.AbstractQueuedLongSynchronizer',
         'java.util.concurrent.locks.LockSupport',
         'java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject',
         'java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock',
         'java.util.concurrent.locks.AbstractOwnableSynchronizer',
         'java.util.concurrent.locks.Lock',
         'java.util.concurrent.locks.AbstractQueuedLongSynchronizer$ConditionObject',
         'java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock',
         'java.util.concurrent.locks.AbstractQueuedSynchronizer',
         'java.util.concurrent.locks.ReentrantLock',
         'java.util.concurrent.ConcurrentLinkedQueue',
         'java.util.concurrent.ConcurrentMap',
         'java.util.concurrent.atomic.AtomicInteger',
         'java.util.concurrent.atomic.AtomicReference',
         'java.util.concurrent.atomic.AtomicIntegerArray',
         'java.util.concurrent.atomic.AtomicLongArray',
         'java.util.concurrent.atomic.AtomicMarkableReference',
         'java.util.concurrent.atomic.AtomicStampedReference',
         'java.util.concurrent.atomic.AtomicIntegerFieldUpdater',
         'java.util.concurrent.atomic.AtomicLongFieldUpdater',
         'java.util.concurrent.atomic.AtomicBoolean',
         'java.util.concurrent.atomic.AtomicReferenceFieldUpdater',
         'java.util.concurrent.atomic.AtomicReferenceArray',
         'java.util.concurrent.atomic.AtomicLong',
         'java.util.concurrent.CancellationException',
         'java.util.concurrent.ConcurrentSkipListSet',
         'java.util.concurrent.BrokenBarrierException',
         'java.util.concurrent.LinkedBlockingQueue',
         'java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy',
         'java.util.concurrent.Callable',
         'java.util.concurrent.ThreadPoolExecutor$DiscardPolicy',
         'java.util.concurrent.ConcurrentSkipListMap',
         'java.util.concurrent.Executors',
         'java.util.concurrent.ThreadFactory',
         'java.util.concurrent.ScheduledThreadPoolExecutor',
         'java.util.concurrent.CyclicBarrier',
         'java.util.concurrent.TimeUnit',
         'java.util.concurrent.ExecutorCompletionService',
         'java.util.concurrent.DelayQueue',
         'java.util.concurrent.ConcurrentNavigableMap',
         'java.util.concurrent.CopyOnWriteArrayList',
         'java.util.concurrent.Semaphore',
         'java.util.concurrent.CountDownLatch',
         

         'java.util.TimeZone',
         'java.util.GregorianCalendar',
         'android.text.AlteredCharSequence',
         'android.text.SpannableStringBuilder',
         'android.text.SpannableStringInternal',
         'android.text.TextUtils$MyCreator',
         'android.text.TextUtils$SimpleStringSplitter',
         'android.text.TextUtils$StringSplitter',
         'android.text.TextUtils',
         'android.text.Editable$Factory',
         'android.text.style.LeadingMarginSpan$LeadingMarginSpan2',
         'android.text.style.LeadingMarginSpan$Standard',
         'android.text.style.MetricAffectingSpan',
         'android.text.style.LineHeightSpan$WithDensity',
         'android.text.style.ClickableSpan',
         'android.text.style.SubscriptSpan',
         'android.text.style.RasterizerSpan',
         'android.text.style.SuperscriptSpan',
         'android.text.style.WrapTogetherSpan',
         'android.text.style.QuoteSpan',
         'android.text.style.ForegroundColorSpan',
         'android.text.style.UnderlineSpan',
         'android.text.style.AbsoluteSizeSpan',
         'android.text.style.AlignmentSpan',
         'android.text.style.LineBackgroundSpan',
         'android.text.style.EasyEditSpan',
         'android.text.style.TextAppearanceSpan',
         'android.text.style.CharacterStyle',
         'android.text.style.URLSpan',
         'android.text.style.TabStopSpan$Standard',
         'android.text.style.ReplacementSpan',
         'android.text.style.MaskFilterSpan',
         'android.text.style.LineHeightSpan',
         'android.text.style.RelativeSizeSpan',
         'android.text.style.SuggestionSpan',
         'android.text.style.LeadingMarginSpan',
         'android.text.style.TabStopSpan',
         'android.text.style.DynamicDrawableSpan',
         'android.text.style.BackgroundColorSpan',
         'android.text.style.ScaleXSpan',
         'android.text.style.BulletSpan',
         'android.text.style.UpdateLayout',
         'android.text.style.ImageSpan',
         'android.text.style.TypefaceSpan',
         'android.text.style.IconMarginSpan',
         'android.text.style.StrikethroughSpan',
         'android.text.style.StyleSpan',
         'android.text.style.DrawableMarginSpan',
         'android.text.style.UpdateAppearance',
         'android.text.style.ParagraphStyle',
         'android.text.style.AlignmentSpan$Standard',
         'android.text.LoginFilter',
         'android.text.TextUtils$TruncateAt',
         'android.text.StaticLayout',
         'android.text.Editable',
         'android.text.DynamicLayout',
         'android.text.Html$TagHandler',
         'android.text.Annotation',
         'android.text.method.CharacterPickerDialog',
         'android.text.method.ReplacementTransformationMethod',
         'android.text.method.KeyListener',
         'android.text.method.TimeKeyListener',
         'android.text.method.Touch',
         'android.text.method.BaseMovementMethod',
         'android.text.method.TransformationMethod',
         'android.text.method.DateKeyListener',
         'android.text.method.TextKeyListener$Capitalize',
         'android.text.method.MetaKeyKeyListener',
         'android.text.method.MultiTapKeyListener',
         'android.text.method.SingleLineTransformationMethod',
         'android.text.method.DateTimeKeyListener',
         'android.text.method.HideReturnsTransformationMethod',
         'android.text.method.TextKeyListener',
         'android.text.method.LinkMovementMethod',
         'android.text.method.ArrowKeyMovementMethod',
         'android.text.method.NumberKeyListener',
         'android.text.method.PasswordTransformationMethod',
         'android.text.method.BaseKeyListener',
         'android.text.method.DialerKeyListener',
         'android.text.method.ScrollingMovementMethod',
         'android.text.method.DigitsKeyListener',
         'android.text.method.QwertyKeyListener',
         'android.text.method.MovementMethod',
         'android.text.Html$ImageGetter',
         'android.text.InputFilter',
         'android.text.Spannable',
         'android.text.LoginFilter$UsernameFilterGMail',
         'android.text.BoringLayout',
         'android.text.NoCopySpan',
         'android.text.GetChars',
         'android.text.SpannableString',
         'android.text.util.Rfc822Tokenizer',
         'android.text.util.Rfc822Token',
         'android.text.util.Linkify$TransformFilter',
         'android.text.util.Linkify',
         'android.text.util.Linkify$MatchFilter',
         'android.text.ParcelableSpan',
         'android.text.InputFilter$LengthFilter',
         'android.text.AndroidCharacter',
         'android.text.LoginFilter$UsernameFilterGeneric',
         'android.text.NoCopySpan$Concrete',
         'android.text.Layout$Directions',
         'android.text.AutoText',
         'android.text.Spannable$Factory',
         'android.text.SpanWatcher',
         'android.text.Layout$Alignment',
         'android.text.TextUtils$EllipsizeCallback',
         'android.text.TextWatcher',
         'android.text.TextPaint',
         'android.text.Selection',
         'android.text.Html',
         'android.text.InputType',
         'android.text.format.Formatter',
         'android.text.format.DateFormat',
         'android.text.format.Time',
         'android.text.format.DateUtils',
         'android.text.InputFilter$AllCaps',
         'android.text.BoringLayout$Metrics',
         'android.text.Spanned',
         'android.text.LoginFilter$PasswordFilterGMail',
         'android.text.SpannedString',
         'android.text.Layout',
         'android.util.AttributeSet',
         'android.util.Base64',
         'android.util.FloatMath',
         'android.util.Pair',
         'java.util.Calendar',
         'java.util.Date',
         'java.util.UUID',
         'android.util.TypedValue',
         'android.util.TimeUtils',
        );

    %safeClassHash = (
        'android.accessibilityservice.AccessibilityServiceInfo'
                               => ["DSCat.DATA_STRUCTURE", "Describes Acessibility Service"],
        'android.app.ActionBar$LayoutParams' =>
                               => ["DSCat.DATA_STRUCTURE", "Layout parameters"],
        'android.animation*'  => ["DSCat.ANDROID_ANIMATION", "Animation class"],
        'android.app.Application'        => ["DSCat.ANDROID_APPLICATION", "Safe, check callback modeling"],
        'android.app.Activity'           => ["DSCat.GUI", "Normal GUI"],
        'android.app.ActivityGroup'      => ["DSCat.GUI", "Normal GUI"],
        'android.app.DatePickerDialog'   => ["DSCat.GUI", "Date picker dialog"],
        'android.app.DownloadManager$Query' =>
                                            ["DSCat.DATA_STRUCTURE", "Formulating request to download"],
        'android.app.DownloadManager$Request' =>
                                            ["DSCat.DATA_STRUCTURE", "Formulating request to download"],
        'android.app.ExpandableListActivity'
                                         => ["DSCat.GUI", "Expandable list activity"],
        'android.app.ListActivity'       => ["DSCat.GUI", "Normal GUI"],
        'android.app.TabActivity'        => ["DSCat.GUI", "Normal GUI"],
        'android.app.ListFragment'       => ["DSCat.GUI", "GUI "],
        'android.app.Dialog'             => ["DSCat.GUI", "GUI, no info sink"],
        'android.app.AlertDialog'        => ["DSCat.GUI", "GUI, alert dialog"],
        'android.app.AlertDialog$Builder'=> ["DSCat.GUI", "Dialog builder"],
        'android.app.ProgressDialog'     => ["DSCat.GUI", "GUI, progress dialog"],

        'android.app.DialogFragment'     => ["DSCat.GUI", "GUI, dialog"],
        'android.app.Fragment'           => ["DSCat.GUI", "GUI, Fragment"],
        'android.app.FragmentManager'    => ["DSCat.GUI", "GUI, Fragment Manager"],

        'android.app.FragmentTransaction' => ["DSCat.GUI", "Fragment transation"],
        'android.app.Notification$Builder' =>["DSCat.UTIL_FUNCTION", "Building Notification"], 
        'android.app.NotificationManager'  =>["DSCat.GUI", "Notification can only go to screen"],
        'android.app.Service'             => ["DSCat.SERVICE", "Modeled"],

        'android.content.ComponentName'  => ["DSCat.DATA_STRUCTURE", "data structure class"],
        'android.content.ContentValues'  => ["DSCat.DATA_STRUCTURE", "data structure class"],
        'android.content.Intent'         => ["DSCat.DATA_STRUCTURE", "movement of Intent is spec"],
        'android.content.IntentFilter'         => ["DSCat.DATA_STRUCTURE", "movement of Intent is spec"],
        'android.content.ContentProviderOperation$Builder' =>
                                            => ["DSCat.UTIL_FUNCTION", "only building the operation, no action"],

        'android.content.SharedPreferences'  => ["DSCat.DATA_STRUCTURE", "is data structure"],
        'android.content.UriMatcher'         => ["DSCat.UTIL_FUNCTION", "URL matching utility"],
        'android.content.pm.PackageItemInfo' => ["DSCat.DATA_STRUCTURE", "information about package"],
        'android.content.ContentUris'        => ["DSCat.UTIL_FUNCTION", "Content uri manipulation utility"],
        'android.content.res.Resources$Theme' => ["DSCat.DATA_STRUCTURE", "data structure class"],
        'android.content.res.TypedArray' => ["DSCat.DATA_STRUCTURE", "data structure class"],
        'android.database.sqlite.SQLiteQueryBuilder' => 
                                            ["DSCat.UTIL_FUNCTION", "Build SQL queries"],
                                             
        'android.hardware.Camera$Parameters' => ["DSCat.DATA_STRUCTURE", "data structure class"],
        'android.inputmethodservice.KeyboardView' =>
                                            ["DSCat.GUI", "Only setting keyboard for this app"],

        "android.location.Address"        => ["DSCat.DATA_STRUCTURE", "Data structure only"],
        "android.location.Location"       => ["DSCat.DATA_STRUCTURE", "Data structure only"],
        "android.location.Geocoder"       => ["DSCat.UTIL_FUNCTION",  "Utility function"],

        "android.nfc.NdefRecord"          => ["DSCat.DATA_STRUCTURE", "data structure"],
        "android.nfc.NdefMessage"         => ["DSCat.DATA_STRUCTURE", "data structure, except writeToParcel"],
        "android.location.Criteria"       => ["DSCat.DATA_STRUCTURE", "Used for thresholding"],
        'android.net.sip.SipProfile$Builder'
                                          => ["DSCat.UTIL_FUNCTION", "Utility to build profile"],
        "android.net.Uri"                 => ["DSCat.DATA_STRUCTURE", "Only URI passing around is important"],
        'android.net.Uri$Builder'         => ["DSCat.UTIL_FUNCTION",  "Only URI passing around is important"],

        "android.net.NetworkInfo"         => ["DSCat.DATA_STRUCTURE", "Only getActiveNetworkInfo() is important"],
        "android.net.sip.SipProfile"      => ["DSCat.DATA_STRUCTURE", "Data structure only, except writeToParcel"],
        "android.opengl.GLES20"           => ["DSCat.GRAPHICS", "OpenGL Graphics Manipulation"],
        "android.opengl.GLSurfaceView"    => ["DSCat.GRAPHICS", "OpenGL Viewer"],
        "android.opengl.Matrix"           => ["DSCat.GRAPHICS", "OpenGL Math"],
        "android.opengl.ETC1"             => ["DSCat.GRAPHICS", "OpenGL ETC1"],
        "android.opengl.GLUtils"          => ["DSCat.GRAPHICS", "OpenGL Utils"],
        "android.opengl.GLU"              => ["DSCat.GRAPHICS", "OpenGL Utils"],

        "android.os.Bundle"               => ["DSCat.DATA_STRUCTURE", "OS Bundle data structure"],
        "android.os.Message"              => ["DSCat.DATA_STRUCTURE", "OS Message"],
        "android.os.CountDownTimer"       => ["DSCat.OS_GENERAL", "General OS service, check callback"],
        "android.os.Parcel"               => ["DSCat.DATA_STRUCTURE", "check any serialization"],
        "android.os.SystemClock"          => ["DSCat.OS_GENERAL", "SystemClock only allows reading time"],
        "android.os.Vibrator"             => ["DSCat.OS_GENERAL", "only vibrating the device"],
        'android.os.StrictMode$ThreadPolicy$Builder' =>
                                             ["DSCat.UTIL_FUNCTION",  "Only URI passing around is important"],
        'android.preference.Preference'   => ["DSCat.DATA_STRUCTURE", "data structure only, getPreferenceManager() is Spec"],
        'android.preference.ListPreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.DialogPreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.EditTextPreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.CheckBoxPreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.DialogPreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.PreferenceFragment' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.PreferenceGroup' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.PreferenceGroup' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
        'android.preference.TwoStatePreference' => 
                                             ["DSCat.GUI", "Perference UI, only change preference is spec"],
                                              
        'android.view.ActionMode'        => ["DSCat.GUI", "Action mode, providing alternative interaction mode"],
        'android.view.View'              => ["DSCat.GUI", "Normal GUI"],
        'android.view.ViewGroup'         => ["DSCat.GUI", "Normal GUI"],
        'android.view.Display'           => ["DSCat.GUI", "only for display view"],
        'android.view.ViewConfiguration' => ["DSCat.GUI", "View configuration"],
        'android.view.ViewGroup$'        => ["DSCat.GUI", "ViewGroup "],
        'android.view.Window$'           => ["DSCat.GUI", "Window of GUI subsystem"],
        'android.view.MotionEvent'       => ["DSCat.GUI", "Event associated with motion"],
        'android.view.MenuItem'          => ["DSCat.GUI", "Menu manipulation"],
        'android.view.SurfaceView'       => ["DSCat.GUI", "Dedicated drawing surface"],
        'android.view.VelocityTracker'   => ["DSCat.GUI", "Touch event tracking"],
        'android.view.Menu'              => ["DSCat.GUI", "Menu part of the UI"],
        'android.view.SubMenu'           => ["DSCat.GUI", "Menu part of the UI"],
        'android.telephony.SmsManager'   => ["DSCat.DATA_STRUCTURE", "SMS message data structure"],
        'android.view.SurfaceHolder'     => ["DSCat.GUI", "Surface Holder"],
        'android.view.KeyEvent'          => ["DSCat.DATA_STRUCTURE", "data structure only"],

        'android.widget.RatingBar'       => ["DSCat.GUI", "RatingBar"],
        'android.widget.RadioGroup'      => ["DSCat.GUI", "RadioGroup"],

        'android.widget.AbsSpinner'      => ["DSCat.GUI", "Spinner"],

        'android.appwidget.AppWidgetProvider' => [
                                             "DSCat.OS_WIDGET", "Widget wrapper"],
        "android.widget.BaseAdapter"        => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        "android.widget.BaseExpandableListAdapter"        => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        'android.widget.AbsListView$LayoutParams' 
                                            => ["DSCat.DATA_STRUCTURE", "Layout params"],
        'android.widget.AbsListView'        => ["DSCat.GUI", "Abstract AbsListView"],
        'android.widget.AbsSeekBar'         => ["DSCat.GUI", "Abstract SeekBar"],
        'android.widget.AbsSpinner'         => ["DSCat.GUI", "Spinner"],
        "android.widget.Adapter"            => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        "android.widget.AdapterView"        => ["DSCat.GUI", "GUI, AdapterView"],
        

        "android.widget.ArrayAdapter"       => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        'android.widget.AutoCompleteTextView'
                                            => ["DSCat.GUI", "Autocomplete"],
        "android.widget.BaseAdapter"        => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        'android.widget.BaseExpandableListAdapter'
                                            => ["DSCat.GUI", "Binding data, need modeling to e safe"],
        'android.widget.Button'          => ["DSCat.GUI", "Button"],
        'android.widget.CalendarView'       => ["DSCat.GUI", "just calendar view"],
        'android.widget.CheckBox'           => ["DSCat.GUI", "CheckBox"],
        'android.widget.CheckedTextView'    => ["DSCat.GUI", "CheckedTextView"],
        'android.widget.CompoundButton'     => ["DSCat.GUI", "CompoundButton, check modeling"],
#'android.widget.CursorAdapter'
        "android.widget.DatePicker"       => ["DSCat.GUI", "GUI/Date Picker"],
        "android.widget.EdgeEffect"       => ["DSCat.GUI", "GUI/Edge Effect, check callbacks"],
        "android.widget.EditText"         => ["DSCat.GUI", "GUI/EditText, check callbacks"],
        'android.widget.ExpandableListAdapter'
                                          => ["DSCat.GUI", "ExpandableListAdapter, data binding"],

        'android.widget.ExpandableListView' => ["DSCat.GUI", "CompoundButton, check modeling"],
        # 'android.widget.Filter$FilterResults'=>["DSCat.GUI", "Filter result"],
        # 'android.widget.Filter'              =>["DSCat.GUI", "Content filtering"],
        # 'android.widget.FilterQueryProvider'
        # 'android.widget.Filterable'
        'android.widget.FrameLayout$LayoutParams'
                                         => ["DSCat.DATA_STRUCTURE", "Layout parameters"],
        "android.widget.FrameLayout"     => ["DSCat.GUI", "GUI/FrameLayout, check callbacks"],
        "android.widget.GridView"        => ["DSCat.GUI", "GUI GridView"],
        "android.widget.HorizontalScrollView" => 
                                            ["DSCat.GUI", "GUI ScrollView"],
        'android.widget.ImageButton'     => ["DSCat.GUI", "ImageButton"],
        'android.widget.ImageView'       => ["DSCat.GUI", "Safe excetp setImageURI"],
        'android.widget.LinearLayout$LayoutParams' 
                                         => ["DSCat.GUI", "GUI Layout"],
        'android.widget.LinearLayout'    => ["DSCat.GUI", "Layout"],

        #'android.widget.ListAdapter'
        'android.widget.ListView'        => ["DSCat.GUI", "ListView"],
        'android.widget.MediaController' => ["DSCat.GUI", "No action.  Check callbacks modeling"],
        'android.widget.NumberPicker'    => ["DSCat.GUI", "UI of number picker"],
        'android.widget.PopupMenu'       => ["DSCat.GUI", "Popup menu, check callbacks modeled"],
        'android.widget.PopupWindow'     => ["DSCat.GUI", "Popup Window, check callbacks modeled"],
        'android.widget.ProgressBar'     => ["DSCat.GUI", "ProgressBar"],
        'android.widget.RadioButton'     => ["DSCat.GUI", "RadioButton"],
        'android.widget.RadioGroup$LayoutParams'
                                         => ["DSCat.DATA_STRUCTURE", "Contact data structure"],
        'android.widget.RadioGroup'      => ["DSCat.GUI", "RadioGroup"],
        'android.widget.RadioGroup$LayoutParams'
                                         => ["DSCat.DATA_STRUCTURE", ""],
        'android.widget.RatingBar'
                                         => ["DSCat.GUI", "RatingBar"],
        'android.widget.RelativeLayout$LayoutParams'
                                         => ["DSCat.DATA_STRUCTURE", "Layout info"],
        'android.widget.RelativeLayout'  => ["DSCat.GUI", "Layout"],
        'android.widget.RemoteViews'      
                                         => ["DSCat.GUI", "check setOnClickPendingIntent"],
        #'android.widget.ResourceCursorAdapter'
        'android.widget.ScrollView'      => ["DSCat.GUI", "ScrollView"],
        'android.widget.Scroller'        => ["DSCat.GUI", "Scroller"],
        'android.widget.SearchView'      => ["DSCat.GUI", "SearchView, check callback"],
        'android.widget.SeekBar'         => ["DSCat.GUI", "SeekBar"],
        # 'android.widget.SimpleAdapter'
        # 'android.widget.SimpleCursorAdapter'
        # 'android.widget.SimpleExpandableListAdapter'

        'android.widget.Spinner'         => ["DSCat.GUI", "Spinner"],
        'android.widget.SpinnerAdapter'  => ["DSCat.GUI", "Spinner data holder"],
        'android.widget.Switch'          => ["DSCat.GUI", "Switch, UI only"],

        'android.widget.TabHost$TabSpec' => ["DSCat.GUI", "Except setContent(Intent)"],

        'android.widget.TabHost'         => ["DSCat.GUI", "TabHost, check callbacks modeled"],
        'android.widget.Toast'           => ["DSCat.GUI", "Toast"],

        'android.widget.TabWidget'       => ["DSCat.GUI", "Tab Widget"],
        'android.widget.TableLayout$LayoutParams'
                                         => ["DSCat.DATA_STRUCTURE", "Layout parameters"],
        'android.widget.TableLayout'     => ["DSCat.GUI", "Layout"],
        'android.widget.TableRow$LayoutParams'  
                                         => ["DSCat.DATA_STRUCTURE", "Layout parameters"],
        #'android.widget.TableRow'
        'android.widget.TextSwitcher'    => ["DSCat.GUI", "TextSwitcher, switching among views"],
        'android.widget.TextView'        => ["DSCat.GUI", "TextView, check callbacks modeled"],
        'android.widget.TimePicker'      => ["DSCat.GUI", "TimePicker, check callbacks modeled"],
        'android.widget.ToggleButton'    => ["DSCat.GUI", "ToggleButton, check callbacks modeled"],
        'android.widget.TwoLineListItem' => ["DSCat.GUI", "ToggleButton, check callbacks modeled"],
        'android.widget.VideoView'       => ["DSCat.GUI", "VideoView, check callbacks modeled"],
        'android.widget.ViewAnimator'    => ["DSCat.GUI", "ViewAnimator, check callbacks modeled"],
        'android.widget.ZoomButtonsController' => ["DSCat.GUI", "ZoomButtonController"],

        'android.provider.ContactsContract$CommonDataKinds' =>
                                             ["DSCat.DATA_STRUCTURE", "Contact data structure"],
        "com.google.android.maps.GeoPoint"=> ["DSCat.DATA_STRUCTURE", "Simple data structure"], 
        "com.google.android.maps.MapView" => ["DSCat.GUI", "MapView only"],
        "com.google.android.maps.MapActivity" => ["DSCat.GUI", "MapActivity"],
        "com.google.android.maps.ItemizedOverlay" => ["DSCat.GUI", "ItemizedOverlay, display only"],

        "java.net.DatagramPacket",        => ["DSCat.DATA_STRUCTURE", "Data structure only"],
        "java.net.InetAddress",           => ["DSCat.DATA_STRUCTURE", "Data structure only"],
        "java.net.URLEncoder",            => ["DSCat.UTIL_FUNCTION",  "Utility function"],

        "java.nio.Buffer",                => ["DSCat.MEM_BUFFER",     "memory buffer only"],
        "java.nio.ByteBuffer",            => ["DSCat.MEM_BUFFER",     "memory buffer only"],
        "java.nio.CharBuffer",            => ["DSCat.MEM_BUFFER",     "memory buffer only"],
        "java.nio.FloatBuffer",           => ["DSCat.MEM_BUFFER",     "memory buffer only"],
        "java.nio.CharBuffer",            => ["DSCat.MEM_BUFFER",     "memory buffer only"],
        "java.nio.charset.CharsetDecoder" => ["DSCat.UTIL_FUNCTION",  "Character encoder/decoder"],
        "java.nio.charset.CharsetEncoder" => ["DSCat.UTIL_FUNCTION",  "Character encoder/decoder"],
        "java.nio.charset.CoderResult"    => ["DSCat.UTIL_FUNCTION",  "Character encoder/decoder"],
        "javax.microedition.khronos.opengles.GL10" => ["DSCat.GRAPHICS", "OpenGL Graphics Manipulation"],

        "org.apache.http.HttpMessage"     => ["DSCat.DATA_STRUCTURE", "Only data structure"],
        "org.apache.http.params.*"        => ["DSCat.DATA_STRUCTURE", "Http parameter structures"],
        "org.xml.sax.helpers.DefaultHandler" =>  ["DSCat.SAFE_LIST", "No op default handler"],

    );

    #generically adding class safe list
    foreach my $key(@safeClassList) {
        $safeClassHash{$key} = ["DSCat.SAFE_LIST", "From safe class list"]; 
    }

    %banClassHash = (
        #classpattern => ["category", "comment", "methodPat", "retPat"]
        'dalvik.system*' => ["DSCat.DALVIK", "Dalvik class method"],
        'java.lang.reflect*' => ["DSCat.REFLECTION", "Java language reflection"],
        'java.lang.Class'   => ["DSCat.REFLECTION", "Java language reflection"],
        'droidsafe*'        => ["DSCat.DROIDSAFE",  "Droidsafe internal"]
        );

    ###################Spec classes ######################################
    %specClassHash = (
        #classpattern => ["category", "comment", "methodPat", "retPat"]
	
        'android.app.ActionBar'          => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'android.app.ActionBar$Tab'      => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.xmlpull.v1.XmlSerializer'   => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.xmlpull.v1.XmlPullParser'   => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.xml.sax.Attributes'         => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.xml.sax.XMLReader'          => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.w3c.dom.Node'               => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.w3c.dom.NodeList'           => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.w3c.dom.Element'            => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.w3c.dom.Document'           => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.w3c.dom.NamedNodeMap'       => ["DSCat.ABSTRACT_METHOD", "Abstract method"],

        'org.apache.http.HttpEntity'     => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.apache.http.HttpResponse'   => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.apache.http.StatusLine'     => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.apache.http.TokenIterator'  => ["DSCat.ABSTRACT_METHOD", "Abstract method"],
        'org.apache.http.client.HttpClient'  => ["DSCat.ABSTRACT_METHOD", "Abstract method"],


        'android.app.KeyguardManager' => ["DSCat.DEVICE", "device control"],
        'android.app.admin*'           => ["DSCat.DEVICE",  "device administration"],
        "com.android.internal*"        => ["DSCat.ANDROID_INTERNAL", "Android internal"],
        "android.app.backup*"          => ["DSCat.BACKUP_SUBSYSTEM", "Backup subsystem"],
        "android.bluetooth.Bluetooth.*"=> ["DSCat.BLUETOOTH", "Bluetooth subsystem"],
        'android.content.SharedPreferences$Editor' =>
                                   ["DSCat.SYSTEM_PREFERENCES", "Bluetooth subsystem"], 
        'android.content.ContentResolver' =>
                                   ["DSCat.CONTENT", "Content model/data manipulation"],
        'android.database.sqlite.SQLiteDatabase' =>
                                   ["DSCat.DATABASE", "Database access"],
        'android.widget.CursorAdapter' => 
                                   ["DSCat.DATABASE", "Database cursor wrapper"],
        "android.net.wifi.*"            => ["DSCat.WIFI", "Wifi subsystem"],
        "android.nfc.NfcAdapter"      => ["DSCat.NFC", "NFC adapter manipulation"],
        "android.nfc.Tag"             => ["DSC.NFC", "NFC Tag"],
        "android.nfc.tech.*"            => ["DSC.NFC", "NFC technology implementation"],

        'android.hardware.Camera'        => ["DSCat.DEVICE", "Camera control"],
        'android.hardware.SensorManager' => ["DSCat.DEVICE", "Sensor accessing"],

        'android.location.GpsStatus'          => ["DSCat.LOCATION", "GPS status inquiry "],
        'android.location.GpsStatus.Listener' => ["DSCat.LOCATION", "GPS status listener"],
        'android.location.LocationListener'   => ["DSCat.LOCATION", "Location listener"],
        'android.location.LocationManager'    => ["DSCat.LOCATION", "Location manager"],
        'android.media.AudioManager'          => ["DSCat.DEVICE", "Controlling audio"],
        'android.net.sip.SipAudioCall'        => ["DSCat.PHONE_CALL", "Sip phone call"],
        'android.preference.PreferenceManager' => ["DSCat.SYSTEM_SETTINGS", "May change system behavior"],
        'android.provider.Settings'            => ["DSCat.SYSTEM_SETTINGS", "May change system behavior"],

        "android.telephony.PhoneStateListener" =>
                        ["DSCat.PHONE_STATE", "Phone state listener"],
        "android.util.Log"             =>  ["DSCat.LOG", "Android logging subsystem"],
        "android.content.pm"           =>  ["DSCat.PACKAGE_MANAGER", "Package Management accessing"],

        "android.content.res.AssetManager" =>  ["DSCat.SECURITY", "Low level access to application asset "],
        "android.widget.ShareActionProvider" 
                                       => ["DSCat.SHARING", "Sharing request"],
        
        "android.widget.QuickContactBadge" 
                                       => ["DSCat.CONTACT", "Contact manipulation UI"],
        "android.media.MediaRecorder"  
                                      =>  ["DSCat.MEDIA_RECORDER", "Media recorder function"],
        "android.net.TrafficStats"    => ["DSCat.NETWORK_STATS", "Traffic statistics"],
        "android.net.sip.SipManager"  => ["DSCat.ANDROID_MANAGER", "Sip Manager "],
        "java.io.FileWriter"          => ["DSCat.IO", "FileWrite class "],
        "java.io.FileReader"          => ["DSCat.IO", "FileReader class "],
        "java.io.PrintWriter"         => ["DSCat.IO", "PrintWriter class"],
        "java.io.FileInputStream"     => ["DSCat.IO", "File Input Stream"],
        "java.io.FileOutputStream"    => ["DSCat.IO", "File Output Stream"],
        "java.io.OutputStreamWriter"  => ["DSCat.IO", "OutputStreamWrite class "],
        "java.io.InputStreamReader"   => ["DSCat.IO", "InputStreamReader class "],
        "java.lang.Process"           => ["DSCat.OS_LOW_LEVEL", "external process"],

        "org.apache.http.client.methods" 
                                      => ["DSCat.INTERNET", "Http methods "],

        "android.app.DownloadManager" => ["DSCat.INTERNET", "Download manager access"],

        "android.os.FileObserver"     => ["DSCat.OS_LOW_LEVEL", "Low level monitoring file state"],
        "android.os.PowerManager*"     => ["DSCat.DEVICE", "Power management"],
        "android.os.StatFs"           =>  ["DSCat.OS_LOW_LEVEL", "OS low level"],

        'java.net.NetworkInterface' => ["DSCat.NETWORK", "Network interface accessing"],
        ## Listeners, will become SAFE once modeled
        'android.widget.AdapterView$OnItemClickListener'
                                            => ["DSCat.GUI", "Event listener"],
        'android.widget.AdapterView$OnItemLongClickListener'
                                            => ["DSCat.GUI", "Event listener"],
        'android.widget.AdapterView$OnItemSelectedListener'
                                            => ["DSCat.GUI", "Event listener"],
        'android.widget.CompoundButton$OnCheckedChangeListener'
                                            => ["DSCat.GUI", "Event listener"],
        'android.widget.ExpandableListView$OnChildClickListener'
                                          => ["DSCat.GUI", "Data binding"],
        'android.widget.PopupWindow$OnDismissListener'
                                         => ["DSCat.GUI", "GUI event listener, check modeling"],
        'android.widget.RatingBar$OnRatingBarChangeListener'
                                         => ["DSCat.GUI", "Event listener"],
        'android.widget.SeekBar$OnSeekBarChangeListener'
                                         => ["DSCat.GUI", "Event listener, check modeling"],
        'android.widget.TabHost$OnTabChangeListener'
                                         => ["DSCat.GUI", "Event listener"],
        );
}

############################################################
# return (@DSType(DSReason), @DSComment("  ")) pair;
############################################################
sub autoClassify {
    my ($methodFullName) = @_;
    return () if ($methodFullName !~ /:/);


    #####################################
    ## method level processing
    #####################################
    if ($methodFullName =~ /^\"/) {
        return ('@DSBan(DSCat.DEFAULT_MODIFER)', '@DSComment("Default package permission")');
    }

    my ($modierList, $methodSig) = ("", "");

    if ($methodFullName =~ /:\"/) {
        ($modierList, $methodSig) = split(/:\"/, $methodFullName);
    }
    else {
        $methodSig = $methodFullName;
    }

    if ($modierList =~ /^private/) {
        return ('@DSBan(DSCat.PRIVATE_METHOD)', '@DSComment("Private method")');
    }

    #print "methodSig: $methodSig \n";
    $methodSig =~ s/\".*//g;

    my($class, $ret, $method) = split(/\s+/, $methodSig);


    $class =~ s/^<//;
    $class =~ s/:$//;
    $method =~ s/>$//;
    $methodName = $method;
    $methodParams = "";

    if ($methodName =~ /(.*?)\((.*)\)/) {
        $methodName = $1;
        $methodParams = $2;
        $methodParams = "" if (!defined($methodParams));
    }

    # if ($methodFullName =~ /setClass/) {
    #     print "**class: $class, ret: $ret, method: $method, params: $methodParams \n";
    # } 

    if ($ret =~ /java\.lang\.Class/ || $methodParams =~ /java\.lang\.Class/) {
        return ('@DSBan(DSCat.REFELECTION)', '@DSComment("Refelction/class loader")');
    }

    if ($methodName =~ /^writeToParcel/ || $ret =~ /android\.os\.Parcel/ || 
        $methodParams =~ /android\.os\.Parcel/) {
        return ('@DSSpec(DSCat.SERIALIZATION)', '@DSComment("Data serialization/deserialization")');
    }

    #if (defined($safeClassHash{$class})) {
    #    return ('@DSSafe(DSCat.SAFE_LIST)', '@DSComment("From safe class list")');
    #}

    if ($class =~ /^android(.*?)Manager$/ && 
        $methodName =~ /^(get|enable|disable|delete|clear|set|request|listen)/ ) {
        return ('@DSSpec(DSCat.ANDROID_MANAGER)', '@DSComment("Request/Change/Listen Android Manger")');
    }

    if ($methodName =~ /^get(.*?)Manager$/) {
        return ('@DSSpec(DSCat.ANDROID_MANAGER)', '@DSComment("Android Manager retrieved/accessed")');
    }

 #anything with send/receive will be spec
    if ($methodName =~ /^(send|receive|open|connect|sendto|recvfrom|query|move|print|bind)/ ||
            $methodName =~ /^(delete)[A-Z]/) {
#skip java.util, java.lang
        if ($class !~ /(java\.util|java\.lang)/) {
            return ('@DSSpec(DSCat.IO_ACTION_METHOD)', '@DSComment("IO movement methodName")');
        }
    }

#returig file something will be SPEC
    # if ($ret =~ /^(File|Input|Output|Stream|URL|Socket)/ || $ret =~ /(Writer|Reader|Stream|Socket|Connection|Channel)$/) {
    # }

    if ($ret =~ /^java\.(io|net|nio)\.(.*?)(File|Input|Output|Stream|Socket)/ || $ret =~ /(Writer|Reader|Stream|Socket|Connection|Channel)$/) {
        return ('@DSSpec(DSCat.IO)', '@DSComment("Method returns IO Object")');
    }

    if ($ret =~ /^android\.database/) {
        return ('@DSSpec(DSCat.DATABASE)', '@DSComment("returned DB object")');
    }

    if ($class =~ /^java\.(io|nio)\./ && $methodName =~ /^(write|read|delete|rename|mkdir|set|clear|list|print)/) {
        return ('@DSSpec(DSCat.IO)', '@DSComment("Activity on IO class")');
    }

    if ($methodParams =~ /(java\.net\.URI|java\.net\.URL|android\.os\.Uri)/)  {
        return ('@DSSpec(DSCat.URI_EXCHANGE)', '@DSComment("Potential Internet/URI processing")');
    }

    #print "** $class \n" if $class =~ /Preference/;

    # if ($methodParams =~ /Intent/) {
    #     print "** <$methodParams> \n";
    # }

    if ($methodParams =~ /android\.content\.Intent(,.*?)*$/ ||
       $ret =~ /android\.content\.Intent$/) {
       #print "** Matched \n";
       return ('@DSSpec(DSCat.INTENT_EXCHANGE)', '@DSComment("Potential intent to trigger other processing")');
    }

    #method return IBinder is vague, we have to manually examine it
    if ($ret =~ /android\.os\.IBinder/) {
       return ('@DSSpec(DSCat.IPC)', '@DSComment("Binder is vague, need modeling")');
    }

    if ($methodName =~ /^\s*(on)([A-Z]\w*)*$/)  {
       return ('@DSSafe(DSCat.ANROID_CALLBACK)', '@DSComment("normal android callback")');
    }

    if ($methodName =~ /^\s*(register|dispatch)([A-Z]\w*)*$/ || 
        $methodName =~ /^\s*(add|set)(\w*?)(Callback|Listener)/  ||
        $methodName =~ /Listener$/ || $class =~ /Listener$/) {
       return ('@DSSpec(DSCat.TO_MODEL)', '@DSComment("potential callback called inside method")');
    }



    #####################################
    ## class level labeling
    #####################################
    foreach my $classPat(keys %banClassHash) {
        my $matched = 0;
        if ($classPat =~ /\*$/) {
            my $modPat = $classPat;
            $modPat =~ s/\*//g;
            if ($class =~ /^$modPat/) {
                $matched = 1;
            }
        }
        $matched = 1 if ($class eq $classPat);
        if ($matched) {
            my @list = @{$banClassHash{$classPat}}; 
            my $cat = shift @list;
            my $comment = shift @list;
            return ("\@DSSBan($cat)", '@DSComment("'. $comment . '")');
        }
    }

    foreach my $classPat(keys %specClassHash) {
        my $matched = 0;
        if ($classPat =~ /\*$/) {
            my $modPat = $classPat;
            $modPat =~ s/\*//g;
            if ($class =~ /^$modPat/) {
                $matched = 1;
            }
        }
        
        $matched = 1 if ($class eq $classPat);

        if ($matched) {
            my @list = @{$specClassHash{$classPat}}; 
            my $cat = shift @list;
            my $comment = shift @list;
            return ("\@DSSpec($cat)", '@DSComment("'. $comment . '")');
        }
    }

    foreach my $classPat(keys %safeClassHash) {
        my $matched = 0;
        if ($classPat =~ /\*$/) {
            my $modPat = $classPat;
            $modPat =~ s/\*//g;
            if ($class =~ /^$modPat/) {
                $matched = 1;
            }
        }
        $matched = 1 if ($class eq $classPat);

        # if ($class =~ /android\.net\.Uri/ && $classPat =~ /Uri/) {
        #     print "** <$class> <$classPat> \n";
        # }

        if ($matched) {
            #print "*** MATCHED \n";
            my @list = @{$safeClassHash{$classPat}}; 
            my $cat = shift @list;
            my $comment = shift @list;
            return ("\@DSSafe($cat)", '@DSComment("'. $comment . '")');
        }
    }


    return ();
}

#############################################################
sub syntax() {
    print "classfication_reformat [-end | -remove] <infile> <outfile>\n";
    print "options: \n";
    print "  -end: annotations at then end of the line \n";
    print "  -remove: remove annotations \n";
    exit -1;
}


