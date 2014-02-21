package droidsafe.android.system;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.SparkPTA;
import droidsafe.utils.SootUtils;
import soot.PrimType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

/**
 * To aid source code inspection, we automatically add source taint to methods of android api.
 * We ignore classes of certain packages (list created by mgordon).
 * 
 * The info kind label for a method is the package name of the declaring class.
 * 
 * 
 * @author mgordon
 *
 */
public class AutomatedSourceTagging {
    /** Logger field */
    private static final Logger logger = LoggerFactory.getLogger(SparkPTA.class);
    
    /** 
     * Aggressively add source taint to methods of the android api that seems interesting
     * and the method returns a primitive (or string).
     */
    public static void run() {
        Set<String> allPackages = new LinkedHashSet<String>();
        for (SootClass clz : Scene.v().getClasses()) {
            allPackages.add(clz.getPackageName());
        }

        Set<String> pkgsToIgnore = new HashSet<String>();
        //check that all packages in list exist
        for (String pkg : PKGS_TO_IGNORE) {
            if (!allPackages.contains(pkg)) {
                logger.error("Package in ignore list for sources does not exist: {}", pkg);
                droidsafe.main.Main.exit(1);
            }
            pkgsToIgnore.add(pkg);
        }
        
        //check that all classes in not to ignore list are defined
        Set<SootClass> classesNotToIgnore = new HashSet<SootClass>();
        for (String clz : CLASSES_NOT_TO_IGNORE) {
            classesNotToIgnore.add(Scene.v().getSootClass(clz));
        }
        
        //go through all system methods, and add method that returns a primitive or string
        //to the list of sources, unless declaring class of method should be ignored
        for (SootClass clz : Scene.v().getClasses()) {
            String pkg = clz.getPackageName();
            //ignore packages from the ignore list unless the class is specifically included 
            if (pkgsToIgnore.contains(pkg) && !classesNotToIgnore.contains(clz))
                continue;
                    
            for (SootMethod m : clz.getMethods()) {
                //if method already has source info kind, then don't add a pkg kind
                if (API.v().hasSourceInfoKind(m)) 
                    continue;
                //add a pkg kind for methods that return a prim or string
                if (m.getReturnType() instanceof PrimType || 
                        SootUtils.isStringOrSimilarType(m.getReturnType())) {
                    API.v().addSourceInfoKind(m, getInfoKindNameFromPkg(pkg));
                }
            }
        }
        
    }

    private static String getInfoKindNameFromPkg(String pkg) {
        return pkg.substring(pkg.indexOf(".") + 1);
    }
    
    private static String[] PKGS_TO_IGNORE = 
        {
         "android",
         "java.lang",
         "droidsafe.annotations",
         "java.lang.annotation",
         "java.util",
         "java.nio.charset",
         "java.nio",
         "droidsafe.runtime",
         "java.math",
         "java.text",
         "android.app",
         "android.content",
         "android.content.pm",
         "android.appwidget",
         "java.util.concurrent.atomic",
         "libcore.math",
         "java.util.concurrent",
         "android.graphics.drawable",
         "android.graphics",
         "android.view.accessibility",
         "android.os.storage",
         "android.view.textservice",
         "android.view.inputmethod",
         "android.media",
         "android.text",
         "com.android.internal.view.menu",
         "android.widget",
         "android.accessibilityservice",
         "android.animation",
         "android.app.backup",
         "android.drm",
         "android.drm.mobile1",
         "android.emoji",
         "android.graphics.drawable.shapes",
         "android.inputmethodservice",
         "android.media.audiofx",
         "android.media.effect",
         "android.media.effect.effects",
         "android.opengl",
         "android.renderscript",
         "android.service.textservice",
         "android.service.wallpaper",
         "android.text.method",
         "android.text.style",
         "android.text.util",
         "android.view.animation",
         "java.awt.font",
         "java.beans",
         "java.util.concurrent.locks",
         "java.util.regex",
         "javax.microedition.khronos.egl",
         "javax.microedition.khronos.opengles"
        };

    private static String[] CLASSES_NOT_TO_IGNORE = 
        {
         "java.util.Date",
         "java.util.Calendar",
         "java.util.GregorianCalendar",
         "java.util.Locale",
         "java.util.Runtime",
         "java.util.ClassLoader",
         "java.text.DateFormat",
         "java.text.DateFormat$Field",
         "java.text.DateFormatSymbols",
         "java.text.SimpleDateFormat",
         "android.content.Intent",
         "android.content.ContentValues",
         "android.content.ContentUris",
         "android.content.Context",
         "android.content.IntentFilter",
         "android.content.IntentSender",
         "android.media.ExifInterface",
         "android.widget.Button",
         "android.text.Editable",
         "android.widget.AutoCompleteTextView",
         "android.widget.CalendarView",
         "android.widget.DatePicker",
         "android.widget.EditText",
         "android.widget.NumberPicker",
         "android.widget.TextView"

        };
}
