package droidsafe.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.CannotFindMethodException;
import soot.AnySubType;
import soot.Body;
import soot.Local;
import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.Hierarchy;
import soot.IntType;
import soot.Modifier;
import soot.SootField;
import soot.SootMethodRef;
import soot.ValueBox;
import soot.jimple.ClassConstant;
import soot.jimple.DoubleConstant;
import soot.jimple.Expr;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.JasminClass;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.ParameterRef;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.internal.JIdentityStmt;
import soot.LongType;
import soot.NullType;
import soot.PrimType;
import soot.Printer;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.GeneratedPhantomMethodTag;
import soot.tagkit.LineNumberTag;
import soot.tagkit.SourceFileTag;
import soot.tagkit.SyntheticTag;
import soot.tagkit.Tag;
import soot.Type;
import soot.Unit;
import soot.util.Chain;
import soot.util.JasminOutputStream;
import soot.util.NumberedString;
import soot.Value;
import soot.VoidType;

/**
 * Class to hold general utility methods that are helpful for Soot.
 * 
 * @author mgordon
 * @author dpetters
 *
 */
public class SootUtils {

    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(SootUtils.class);

    /** Matches a Java method signature **/
    public static final Pattern sigRE = Pattern.compile("<(\\S+): (\\S+) (\\S+)\\((.*)\\)>");

    /**
     * Return true if this reference is to a String, CharSequence, StringBuffer, or StringBuilder.
     */
    public static boolean isStringOrSimilarType(Type type) {
        if (type instanceof RefType) {
            RefType refType = (RefType)type;

            return refType.equals(RefType.v("java.lang.String")) || 
                    refType.equals(RefType.v("java.lang.CharSequence")) ||
                    refType.equals(RefType.v("java.lang.StringBuffer")) ||
                    refType.equals(RefType.v("java.lang.StringBuilder"));

        }

        return false;
    }

    /** 
     * Is the type a void type
     */
    public static boolean isVoidType(Type type) {
        return type instanceof VoidType;
    }


    /**
     * Given a string representing a type in soot, (ex: int, java.lang.Class[]), return 
     * the appropriate Soot type for the object. 
     */
    public static Type toSootType(String str) {
        if (str.equals("int"))
            return IntType.v();
        else if (str.equals("char"))
            return CharType.v();
        else if (str.equals("boolean"))
            return BooleanType.v();
        else if (str.equals("long"))
            return LongType.v();
        else if (str.equals("byte"))
            return ByteType.v();
        else if (str.equals("double"))
            return DoubleType.v();
        else if (str.equals("float"))
            return FloatType.v();
        else if (str.equals("short"))
            return ShortType.v();
        else if (str.equals("void")) 
            return VoidType.v();
        else if (str.equals("null"))
            return NullType.v();
        else {
            //not a primitive type
            Pattern typeSig = Pattern.compile("([\\w\\$\\.]+)([\\[\\]]*)");
            Matcher matcher = typeSig.matcher(str);
            boolean b = matcher.matches();
            if (!b || matcher.groupCount() != 2) {
                logger.error("Something very wrong with parsing type: {}", str);
                droidsafe.main.Main.exit(1);
            }

            String baseType = matcher.group(1);


            if (!matcher.group(2).equals("")) {
                //array type
                String brackets = matcher.group(2);
                int numDims = brackets.length() / 2;
                return ArrayType.v(toSootType(baseType), numDims);
            } else if (!matcher.group(1).equals("")) {
                //class type
                return RefType.v(baseType);
            } else {
                logger.error("Cannot parse type: {}", str);
                droidsafe.main.Main.exit(1);
                return null;
            }
        }
    }

    /** Returns true if specified type is Java.lang.String **/
    public static boolean isStringType(Type t) {
        return t.equals(RefType.v("java.lang.String"));
    }

    /** Returns true if specified type is java.lang.Class **/
    public static boolean isClassType(Type t) {
        return t.equals(RefType.v("java.lang.Class"));
    }

    /**
     * Return true if type is a integral type (byte, char, short, int, or long).
     */
    public static boolean isIntegral(Type t) {
        return (t instanceof LongType ||
                t instanceof IntType ||
                t instanceof ShortType ||
                t instanceof CharType ||
                t instanceof ByteType); 
    }

    /**
     * Return a BF traversal of the super interfaces of a class.
     */
    public static List<SootClass> getSuperInterfacesOf(SootClass sc) {
        List<SootClass>   ret = new LinkedList<SootClass>();
        Queue<SootClass> q   = new LinkedList<SootClass>();
        //add initial interfaces
        for (SootClass i : sc.getInterfaces()) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            SootClass curr = q.poll();

            if (curr == null) {
                continue;
            }

            if (curr.toString().equals("java.lang.Object")) {
                continue;
            }

            if (!curr.isInterface()) {
                logger.error("getSuperInterfacesOf inspecting non interface: {}", curr);
                droidsafe.main.Main.exit(1);
            }

            ret.add(curr);

            if (!curr.isPhantom() && curr.getSuperclass().isInterface()) {
                q.add(curr.getSuperclass());
            }

        }

        return ret;
    }

    /**
     * Get all superclasses and super interfaces of a soot class.
     */
    public static Set<SootClass> getParents(SootClass sc) {
        Set<SootClass>   ret = new LinkedHashSet<SootClass>();
        Queue<SootClass> q   = new LinkedList<SootClass>();
        q.add(sc);

        while (!q.isEmpty()) {
            SootClass curr = q.poll();
            if (curr == null) {
                logger.info("Strange, null found in getParents on {}", sc);
                continue;
            }

            if (curr.toString().equals("java.lang.Object")) {
                continue;
            }

            if (!curr.isPhantom()){ 
                q.addAll(curr.getInterfaces());
                ret.addAll(curr.getInterfaces());
            }

            if (curr.hasSuperclass() && !curr.isPhantom()) {
                q.add(curr.getSuperclass());
                ret.add(curr.getSuperclass());
            }
        }

        return ret;
    }

    /**
     * Given a class or interface, get all classes that have this as ancestor.
     */
    public static List<SootClass> getChildrenIncluding(SootClass sc) {
        Hierarchy hier = Scene.v().getActiveHierarchy();

        if (sc.isInterface()) {
            LinkedList<SootClass> classes = new LinkedList<SootClass>();
            //want all sub interfaces, and all implementing classes
            classes.addAll(hier.getSubinterfacesOfIncluding(sc));
            classes.addAll(hier.getImplementersOf(sc));
            classes.add(sc);
            return classes;
        }
        else 
            return hier.getSubclassesOfIncluding(sc);

    }

    /**
     * Return true if child is a subtype of parent.  If both are primitive integral types, 
     * return true.If both are arraytypes, make sure element type of child is subtype of element 
     * type of parent.
     */
    public static boolean isSubTypeOfIncluding(Type child, Type parent) {
        if (child.equals(parent))
            return true;
        else if (child instanceof NullType ||
                parent instanceof NullType)
            return true;
        else if (parent instanceof PrimType) {
            //special case the integral types because they can be cast to
            //each other and the spec language only have integer types
            if (isIntegral(parent) && isIntegral(child))
                return true;
            return parent.equals(child);
        } else if (parent instanceof ArrayType && child instanceof ArrayType) {
            return isSubTypeOfIncluding(((ArrayType)child).getElementType(), ((ArrayType)parent).getElementType());
        } else if (parent instanceof RefType && child instanceof RefType) {
            SootClass pClass = ((RefType)parent).getSootClass();
            SootClass cClass = ((RefType)child).getSootClass();

            Set<SootClass> parents = getParents(cClass);
            return parents.contains(pClass);

        } else if (parent instanceof VoidType && child instanceof VoidType) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return true if the method invoked by the invoke expression could invoke the target.
     * 
     * Here, we are not looking at PTA information, this is just based on types.
     */
    public static boolean couldCallBasedOnTypes(InvokeExpr invoke, SootMethod target) {
        if (invoke instanceof StaticInvokeExpr) {
            //if a static invoke, then no polymorphic search, it must call the 
            //method exactly
            SootMethodRef invokedMethod= invoke.getMethodRef();
            SootClass invokeClass = invokedMethod.declaringClass();

            //target class must be equal
            if (!RefType.v(target.getDeclaringClass()).equals(RefType.v(invokeClass)))
                return false;

            //names of methods must match
            if (!target.getName().equals(invokedMethod.name()) || 
                    target.getParameterCount() != invokedMethod.parameterTypes().size())
                return false;

            //return type of target must be equal to of invoke
            if (!(target.getReturnType().equals(invokedMethod.returnType())))
                return false;

            //arg types must match
            for (int i = 0; i < target.getParameterCount(); i++)
                if (!target.getParameterType(i).equals(invokedMethod.parameterType(i)))
                    return false;

            //if we get here all has passed, so we could call it.
            return true;

        } else if (invoke instanceof InstanceInvokeExpr) {
            InstanceInvokeExpr iie = (InstanceInvokeExpr)invoke;
            SootMethodRef invokedMethod = iie.getMethodRef();
            SootClass invokeClass = invokedMethod.declaringClass();

            //target class must be subclass of invoke method class
            if (!isSubTypeOfIncluding(RefType.v(target.getDeclaringClass()), 
                RefType.v(invokeClass)))
                return false;

            //names of methods must match
            if (!target.getName().equals(invokedMethod.name()) || 
                    target.getParameterCount() != invokedMethod.parameterTypes().size())
                return false;

            //return type of target must be subtype of invoke
            if (!isSubTypeOfIncluding(target.getReturnType(), invokedMethod.returnType()))
                return false;

            //arg types must match
            for (int i = 0; i < target.getParameterCount(); i++)
                if (!isSubTypeOfIncluding(target.getParameterType(i),invokedMethod.parameterType(i)))
                    return false;

            //if we get here all has passed, so we could call it.
            return true;
        } else {
            logger.error("Unknown invoke type: {}", invoke);
            droidsafe.main.Main.exit(1);
        }

        return false;
    }

    /**
     * Given the signature of a method that may or may not concretely exist, search 
     * for the concrete call that will be resolved for the signature.
     * 
     * This search entails a polymorphic search over all the methods of the class
     * for return types and parameter types.  
     * 
     * It then searches parent classes if the method cannot be found in this class.
     */
    public static SootMethod resolveMethod(SootClass clz, String signature) {
        if (Scene.v().containsMethod(signature)) 
            return Scene.v().getMethod(signature);

        //check this class for the method with polymorpism
        String mName = grabName(signature);
        String[] args = grabArgs(signature);
        String rtype = grabReturnType(signature);

        for (SootMethod curr : clz.getMethods()) {
            if (!curr.getName().equals(mName) || curr.getParameterCount() != args.length)
                continue;

            //check the return types
            Type returnType = toSootType(rtype);
            if (!isSubTypeOfIncluding(returnType, curr.getReturnType())) 
                continue;

            boolean foundCounterEx = false;
            for (int i = 0; i < args.length; i++) {
                if (!isSubTypeOfIncluding(toSootType(args[i]), curr.getParameterType(i))) {
                    foundCounterEx = true;
                    continue;
                }
            }

            //found at least one argument position that differs
            if (foundCounterEx)
                continue;

            //if we got here all is well and we found a method that matches!
            return curr;
        }

        //if not found, and at object can't find it
        if (clz.getName().equals("java.lang.Object") ||
                clz.getSuperclass() == null)
            return null;

        //now check the parents
        return resolveMethod(clz.getSuperclass(), signature);
    }

    /* Given the signature of a method that may or may not concretely exist, search 
     * for the concrete call that will be resolved for the signature.
     * 
     * This search entails a polymorphic search over all the methods of the class
     * for return types and parameter types.  
     * 
     * It then searches parent classes if the method cannot be found in this class.
     */
    public static SootMethod resolveMethod(SootMethod method) {

        if (method.hasActiveBody())
            return method;

        SootClass clz = method.getDeclaringClass();

        //if not found, and at object can't find it
        if (clz.getName().equals("java.lang.Object") ||
                clz.getSuperclass() == null)
            return null;

        SootClass parentClass = clz.getSuperclass();

        SootMethod parentMethod;
        try {
            parentMethod = SootUtils.resolveConcreteDispatch(parentClass, method);
            if (parentMethod == null)
                return null;
            //now check the parents
            return resolveMethod(parentMethod);
        } catch (CannotFindMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * return the soot class referenced by the given class constant
     */
    public static SootClass getSootClass(ClassConstant cc) {
        return Scene.v().getSootClass(cc.getValue().replaceAll("/", "."));
    }


    /**
     * Matching a callback method.  We ignore return type as it is not important in callback
     * @param clz
     * @param signature
     * @return
     */
    public static SootMethod resolveCallbackMethod(SootClass clz, String signature) {
        if (Scene.v().containsMethod(signature)) 
            return Scene.v().getMethod(signature);

        //check this class for the method with polymorpism
        String mName = grabName(signature);
        String[] args = grabArgs(signature);
        String rtype = grabReturnType(signature);

        for (SootMethod curr : clz.getMethods()) {
            if (!curr.getName().equals(mName) || curr.getParameterCount() != args.length)
                continue;

            for (int i = 0; i < args.length; i++) 
                if (!isSubTypeOfIncluding(toSootType(args[i]), curr.getParameterType(i)))
                    continue;

            //if we got here all is well and we found a method that matches!
            return curr;
        }
        return null;
    }

    /**
     * Grab the args string from the method signature 
     */
    public static String[] grabArgs(String signature) {
        Matcher matcher = sigRE.matcher(signature);
        boolean b = matcher.matches();

        if (!b && matcher.groupCount() != 4)
            logger.error("Bad method signature: {}", signature);

        //args, create the args string array
        String args = matcher.group(4);

        if (args.isEmpty())
            return new String[0];

        return args.split(",");
    }

    /**
     * Grab the class from the signature
     */
    public static String grabClass(String signature) {
        Matcher matcher = sigRE.matcher(signature);
        boolean b = matcher.matches();

        if (!b && matcher.groupCount() != 4)
            logger.error("Bad method signature: {}", signature);

        return matcher.group(1);
    }

    /**
     * Grab the method name from the signature
     */
    public static String grabName(String signature) {
        Matcher matcher = sigRE.matcher(signature);
        boolean b = matcher.matches();

        if (!b && matcher.groupCount() != 4)
            logger.error("Bad method signature: {}", signature);

        return matcher.group(3);
    }

    /**
     * Grab the method return type string from the signature
     */
    public static String grabReturnType(String signature) {
        Matcher matcher = sigRE.matcher(signature);
        boolean b = matcher.matches();

        if (!b && matcher.groupCount() != 4) {
            logger.error("Cannot create Method from DroidBlaze Signature");
            droidsafe.main.Main.exit(1);
        }

        return matcher.group(2);

    }

    /**
     * Given a class, method name, return type string (in soot format) and the number of args,
     * try to find the method in the class, plus any methods that it could override in superclasses
     * and interfaces.
     */
    public static List<SootMethod> findPossibleInheritedMethods(SootClass clz, String name, 
        String returnType, int numArgs) {
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();
        LinkedList<SootMethod> methods = new LinkedList<SootMethod>();

        List<SootClass> classes = new LinkedList<SootClass>();

        if (!clz.isInterface()) 
            classes.addAll(hierarchy.getSuperclassesOfIncluding(clz));

        classes.addAll(clz.getInterfaces());


        for (SootClass parent : classes) {
            for (SootMethod method : parent.getMethods()) {
                //logger.debug("Looking at {} in {}", method, parent);
                if (method.getName().equals(name) &&
                        method.getParameterCount() == numArgs &&
                        method.getReturnType().toString().equals(returnType))
                    methods.add(method);
            }
        }

        return methods;
    }

    /**
     * Given a class and method name, find all po
     * @param clz
     * @param name
     * @return
     */
    public static List<SootMethod> findPossibleInheritedMethods(SootClass clz, String name) {
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();
        LinkedList<SootMethod> methods = new LinkedList<SootMethod>();

        List<SootClass> classes = new LinkedList<SootClass>();

        if (!clz.isInterface()) 
            classes.addAll(hierarchy.getSuperclassesOfIncluding(clz));

        classes.addAll(clz.getInterfaces());


        for (SootClass parent : classes) {
            for (SootMethod method : parent.getMethods()) {
                //logger.debug("Looking at {} in {}", method, parent);
                if (method.getName().equals(name))
                    methods.add(method);
            }
        }
        return methods;
    }



    /**
     * Load classes from the given jar file into Soot's current scene.  
     * Load the classes as application classes if appClass is true.
     * If overwrite is true, then overwrite any classes that were previously loaded.  If 
     * overwrite is false, then don't load from this jar any previously loaded classes.
     * 
     * Return a set of all classes loaded from the jar.
     */
    public static Set<SootClass> loadClassesFromJar(JarFile jarFile, boolean appClass, Set<String> doNotLoad) {
        LinkedHashSet<SootClass> classSet = new LinkedHashSet<SootClass>();
        Enumeration<JarEntry> allEntries = jarFile.entries();
        while (allEntries.hasMoreElements()) {
            JarEntry entry = allEntries.nextElement();
            String   name  = entry.getName();
            if (!name.endsWith(".class")) {
                continue;
            }

            String clsName = name.substring(0, name.length() - 6).replace('/', '.');

            if (doNotLoad.contains(clsName)) {
                continue;
            }

            if (appClass) {
                //SootClass clz = Scene.v().loadClassAndSupport(clsName);
                SootClass clz = Scene.v().loadClass(clsName, SootClass.BODIES);
                classSet.add(clz);
                clz.setApplicationClass();
                logger.debug("Loading from {}: {} (app)", jarFile.getName(), clsName);
            }
            else {
                SootClass clz = Scene.v().loadClass(clsName, SootClass.SIGNATURES);
                classSet.add(clz);
                clz.setLibraryClass();
                logger.debug("Loading from {}: {} (lib)", jarFile.getName(), clsName);
            }

        }
        return classSet;
    }

    /**
     * For the given class, return a constructor with the fewest number of 
     * arguments.
     */
    public static SootMethod findSimpliestConstructor(SootClass clz) {
        SootMethod currentCons = null;
        int currentConsArgs = Integer.MAX_VALUE;

        for (SootMethod method : clz.getMethods()) {
            if (method.isConstructor() && method.getParameterCount() < currentConsArgs) {
                currentCons = method;
                currentConsArgs = method.getParameterCount();
            }
        }

        return currentCons;
    }

    /**
     * Given a type, return a valid value for that type.
     */
    public static Value getNullValue(Type type) {
        if (type instanceof BooleanType)
            return IntConstant.v(1);
        else if (type instanceof IntType)
            return IntConstant.v(0);
        else if (type instanceof LongType)
            return LongConstant.v(0);
        else if (type instanceof FloatType)
            return FloatConstant.v((float) 0.0);
        else if (type instanceof DoubleType) 
            return DoubleConstant.v(0.0);
        else if (type instanceof CharType)
            return IntConstant.v(48); 
        else {
            return NullConstant.v();
        }
    }

    /**
     * Return a concrete implementor of interface or abstract class.
     */
    public static SootClass getCloseConcrete(SootClass clz) {
        if (clz.isInterface()) 
            return getCloseImplementor(clz);
        else if (clz.isAbstract()) 
            return getCloseSubclass(clz);
        else 
            return null;
    }

    /**
     * Return a concrete implementor of a given interface.  Try to find direct implementors first
     */
    public static SootClass getCloseSubclass(SootClass clz) {
        if (!clz.isAbstract() && !clz.isInterface()) {
            logger.error("Trying to get close subclass of a non abstract class: {}", clz);
            droidsafe.main.Main.exit(1);
        }

        logger.debug("Trying to get direct subclasses for: {}", clz);
        //try to get direct implementors by adding them first
        List<SootClass> implementors = new LinkedList<SootClass>();

        implementors.addAll((List<SootClass>)Scene.v().getActiveHierarchy().getDirectSubclassesOf(clz));  

        implementors.addAll(Scene.v().getActiveHierarchy().getSubclassesOf(clz));

        //return the first concrete class
        for (SootClass c : implementors) 
            if (c.isConcrete() && !ClassCloner.isClonedClass(c))
                return c;

        return null;
    }

    /**
     * Return a concrete implementor of a given interface.  Try to find direct implementors first
     */
    public static SootClass getCloseImplementor(SootClass clz) {
        if (!clz.isInterface()) {
            logger.error("Trying to get implementor of a non interface: {}", clz);
            droidsafe.main.Main.exit(1);
        }

        //try to get direct implementors by adding them first
        List<SootClass> implementors = new LinkedList<SootClass>();

        implementors.addAll((List<SootClass>)Scene.v().getActiveHierarchy().getDirectImplementersOf(clz));  

        implementors.addAll(Scene.v().getActiveHierarchy().getImplementersOf(clz));

        //return the first concrete class
        for (SootClass c : implementors) 
            if (c.isConcrete() && !ClassCloner.isClonedClass(c))
                return c;

        return null;
    }

    /**
     * Write the class and jimple file for clz. ParentDir is the absolute 
     * path of parent directory.
     */
    public static void writeByteCodeAndJimple(String parentDir, SootClass clz) {

        String methodThatFailed = "";

        File packageDirectory = new File(parentDir + File.separator +
            clz.getPackageName().replaceAll("\\.", File.separator));

        try {
            //make package directory
            packageDirectory.mkdirs();

            FileOutputStream fos = new FileOutputStream(packageDirectory.toString() + File.separator + 
                clz.getShortName() + ".class");
            OutputStream streamOut = new JasminOutputStream(fos);
            OutputStreamWriter osw = new OutputStreamWriter(streamOut);
            PrintWriter writerOut = new PrintWriter(osw);

            for (SootMethod method : clz.getMethods()) {
                methodThatFailed = method.getName();
                if (method.isConcrete())
                    method.retrieveActiveBody();
            }
            try {

                JasminClass jasminClass = new soot.jimple.JasminClass(clz);
                jasminClass.print(writerOut);
                //System.out.println("Succeeded writing class: " + clz);
            } catch (Exception e) {
                logger.warn("Error writing class to file {}", clz, e);
            }

            writerOut.flush();
            streamOut.close();


            streamOut = new FileOutputStream(packageDirectory.toString() + File.separator + clz.getShortName() + ".jimple");
            writerOut = new PrintWriter(new OutputStreamWriter(streamOut));
            Printer.v().printTo(clz, writerOut);
            writerOut.flush();
            writerOut.close();
            fos.close();
            osw.close();
            streamOut.close();

        } catch (Exception e) {
            logger.error("Method that failed = " + methodThatFailed);
            logger.error("Error writing class to file {}", clz, e);
        }
    }

    /** 
     * Return location for a class as the location of some constructor for the class
     * or null if no constructors with source location.
     */
    public static SourceLocationTag getClassLocation(SootClass clz) {
        for (SootMethod method : clz.getMethods()) {
            if (method.isConstructor()) {
                SourceLocationTag slt = getMethodLocation(method);
                if (slt != null) 
                    return slt;
            }
        }

        return null;
    }

    /**
     * Return the source location of a method based on its first statement.
     */
    public static SourceLocationTag getMethodLocation(SootMethod method) {
        if (method != null && method.isConcrete()) {
            Chain<Unit> stmts = ((StmtBody)method.retrieveActiveBody()).getUnits();
            Iterator<Unit> stmtIt = stmts.snapshotIterator();

            while (stmtIt.hasNext()) {
              SourceLocationTag loc = getSourceLocation((Stmt)stmtIt.next(), method.getDeclaringClass());
              if (loc != null)
                return loc;
            }
        }

        return null;
    }

    private static Map<Stmt, SourceLocationTag> stmtToSourceLocMap = new HashMap<Stmt, SourceLocationTag>();

    /**
     * Return the source location of a Jimple expression.
     */
    public static SourceLocationTag getSourceLocation(Expr expr) {
        Stmt stmt = JimpleRelationships.v().getEnclosingStmt((Expr)expr);
        if (stmt == null) {
            logger.debug("Cannot find enclosing statement for expression: {}", expr);
            return null;
        }

        return getSourceLocation(stmt);
    }

    /**
     * Return the source location of a Jimple value box.
     */
    public static SourceLocationTag getSourceLocation(ValueBox vb) {
        Stmt stmt = JimpleRelationships.v().getEnclosingStmt(vb);
        if (stmt == null) {
            logger.debug("Cannot find enclosing statement for value box: {}", vb);
            return null;
        }

        return getSourceLocation(stmt);
    }

    /**
     * Return the source location of a Jimple statement.
     */
    public static SourceLocationTag getSourceLocation(Stmt stmt) {
        SourceLocationTag line = stmtToSourceLocMap.get(stmt);
        if (line != null)
            return line;
        SootMethod method = JimpleRelationships.v().getEnclosingMethod(stmt);
        if (method == null) {
            logger.debug("Cannot find enclosing method for statement: {}", stmt);
            return null;
        }
        return getSourceLocation(stmt, method.getDeclaringClass());
    }

    /**
     * Return the source location of a Jimple statement in a soot class.
     */
    public static SourceLocationTag getSourceLocation(Stmt stmt, SootClass clz) {
        if (stmt != null && clz != null) {
            SourceLocationTag line = stmtToSourceLocMap.get(stmt);
            if (line != null)
                return line;
            if (ClassCloner.isClonedClass(clz))
                clz = ClassCloner.getClonedClassFromClone(clz);
            LineNumberTag lineNumberTag = (LineNumberTag) stmt.getTag("LineNumberTag");
            if (lineNumberTag != null) {
                SourceFileTag sourceFileTag = (SourceFileTag) clz.getTag("SourceFileTag");
                if (sourceFileTag != null) {
                    String sourceFile = sourceFileTag.getSourceFile();
                    int pos = sourceFile.indexOf(".");
                    if (pos > 0) {
                        String sourceFileClass = clz.getPackageName() + "." + sourceFile.substring(0, pos);
                        line = new SourceLocationTag(sourceFileClass,  lineNumberTag.getLineNumber());
                        stmtToSourceLocMap.put(stmt, line);
                        return line;
                    }
                }
            } else {
                logger.debug("Cannot find line number tag for {} {}", stmt, clz);
            }
        }
        return null;
    }

    /**
     * Wrapped resolve special dispatch method that will throw a more useful exception when
     * it cannot find the method.  
     */
    public static SootMethod resolveSpecialDispatch(SpecialInvokeExpr invoke) 
            throws CannotFindMethodException {
        SootMethod container = JimpleRelationships.v().getEnclosingMethod(invoke);
        try {
            return Scene.v().getActiveHierarchy().resolveSpecialDispatch( invoke, container);
        } catch (Exception e) {
            throw new CannotFindMethodException(invoke, container);
        }
    }

    /**
     * Wrapped resolve concrete dispatch method that will throw a more useful exception when
     * it cannot find the method.
     */
    public static SootMethod resolveConcreteDispatch(SootClass clz, SootMethod meth) 
            throws CannotFindMethodException {
        try {
            return Scene.v().getActiveHierarchy().resolveConcreteDispatch( clz, meth);
        } catch (Exception e) {
            throw new CannotFindMethodException(clz, meth);
        }
    }

    /** 
     * Returns the element type for an array, the 'base' of AnySubType.  If type is 
     * neither just returns type
     */
    public static Type getBaseType(RefLikeType type) {
        if (type instanceof ArrayType) 
            return ((ArrayType)type).getArrayElementType();
        else if (type instanceof AnySubType) 
            return ((AnySubType)type).getBase();
        else 
            return type;
    }

    /**
     * Given a type of a receiver, get the sootclass that will be used to resolve calls
     * for this type
     */
    public static SootClass getCallingTypeForReceiver(RefLikeType type) {
        if (type instanceof RefType) {
            return ((RefType)type).getSootClass();
        } else if (type instanceof ArrayType) {
            return Scene.v().getSootClass("java.lang.Object");
        } else {
            logger.error("Calling getCallingType() with {}", type.getClass());
        }

        return null;        
    }

    /**
     * Try to grab an instance invoke expr from a statement, if it does not
     * have one, return null.
     */
    public static InstanceInvokeExpr getInstanceInvokeExpr(Stmt stmt) {
        if (stmt == null || !stmt.containsInvokeExpr()) 
            return null;

        InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();

        if (!(expr instanceof InstanceInvokeExpr)) 
            return null;

        return (InstanceInvokeExpr)expr;
    }

    /**
     * Try to grab a virtual invoke expr from a statement, if it does not
     * have one, return null.
     */
    public static VirtualInvokeExpr getVirtualInvokeExpr(Stmt stmt) {
        if (stmt == null || !stmt.containsInvokeExpr()) 
            return null;

        InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();

        if (!(expr instanceof VirtualInvokeExpr)) 
            return null;

        return (VirtualInvokeExpr)expr;
    }


    /**
     * Return all methods that the given method (in the class) overrides 
     * from all of its parent classes (not interfaces).
     */
    public static List<SootMethod> getOverriddenMethodsFromSuperclasses(SootMethod method) {
        SootClass clz = method.getDeclaringClass();
        String subSig = method.getSubSignature();

        List<SootMethod> methods = new LinkedList<SootMethod>();

        List<SootClass> parents = getSuperClassList(clz);

        for (SootClass parent : parents) {
            if (parent.declaresMethod(subSig)) {
                SootMethod meth = parent.getMethod(subSig);
                methods.add(meth);
            }
        }

        return methods;
    }


    /**
     * Return all methods that override the given method (in the given class). Search all children
     */
    public static Set<SootMethod> getOverridingMethodsIncluding(SootClass clz, String subSig) {
        Set<SootMethod> methods = new LinkedHashSet<SootMethod>();

        List<SootClass> childrenIncluding = getChildrenIncluding(clz);

        for (SootClass child : childrenIncluding) {
            if (child.declaresMethod(subSig)) {
                SootMethod meth = child.getMethod(subSig);
                if (!meth.isAbstract())
                    methods.add(meth);
            }
        }

        return methods;
    }
    
    
     /**
     * Return all methods that override the given method (in the given class). Search all children
     * all methods including abstract classes are collected
     */
    public static Set<SootMethod> getAllOverridingMethodsIncluding(SootMethod method) {
        
        SootClass clz = method.getDeclaringClass();
        String subSig = method.getSubSignature();
        
        Set<SootMethod> methods = new LinkedHashSet<SootMethod>();

        List<SootClass> childrenIncluding = getChildrenIncluding(clz);

        for (SootClass child : childrenIncluding) {
            if (child.declaresMethod(subSig)) {
                SootMethod meth = child.getMethod(subSig);
                methods.add(meth);
            }
        }

        return methods;
    }


    /**
     * Is this class an innner class based on the presence of $ in the name.
     */
    public static boolean isInnerClass(SootClass clz) {
        return clz.getName().contains("$");        
    }

    /**
     * If this class is an inner class with "$" separating outer from inner, then,
     * return the outerclass defintion.
     */
    public static SootClass getOuterClass(SootClass clz) {
        if (!isInnerClass(clz))
            return null;

        String outer = clz.getName().substring(0, clz.getName().indexOf("$"));

        try {
            SootClass o = Scene.v().getSootClass(outer);
            return o;
        } catch (Exception e) {
            logger.warn("Exception trying to resolve outer class: {} for {}", outer, clz, e);
        }

        return null;
    }


    /**
     * Given two classes that could be related (one is a parent of the other or vice versa), return 
     * the child class.  If not related, then return null
     */
    public static SootClass narrowerClass(SootClass c1, SootClass c2) {
        Hierarchy hier = Scene.v().getActiveHierarchy();

        if (c1.isInterface() && c2.isInterface()) {
            logger.error("Cannot find a narrower concrete class for {} and {}", c1, c2);
            droidsafe.main.Main.exit(1);
        }

        if (c1.isInterface())
            return c2;

        if (c2.isInterface())
            return c1;

        if (!hier.isClassSuperclassOfIncluding(c1, c2) &&
                !hier.isClassSuperclassOf(c2, c1)) {
            return null;
        }

        if(hier.isClassSuperclassOfIncluding(c1, c2)) {
            return c2;
        } else { 
            return c1;
        }
    }

    /**
     * Starting at a class, return all the set of all concrete classes that implement the class,
     * stop the search at each concrete class at each branch.  So if we pass in a concrete class, just return it.
     */
    public static List<SootClass> smallestConcreteSetofImplementors(SootClass clz) {
        List<SootClass> clazzes = new LinkedList<SootClass>();
        Hierarchy h = Scene.v().getActiveHierarchy();

        if (clz.isConcrete()) {
            clazzes.add(clz);
            return clazzes;
        } 

        List<SootClass> imps;

        if (clz.isAbstract() && !clz.isInterface()) {
            imps = h.getDirectSubclassesOf(clz);
        } else if (clz.isInterface()) {
            imps = new LinkedList<SootClass>();
            imps.addAll(h.getImplementersOf(clz));
            imps.addAll(h.getSubinterfacesOf(clz));
        } else {
            return clazzes;
        }

        for (SootClass imp : imps) {

            if (imp.isConcrete())
                clazzes.add(imp);
            else
                clazzes.addAll(smallestConcreteSetofImplementors(imp));
        }

        return clazzes;
    }

    /**
     * removeNonstaticMethods:
     * remove all nonstatic methods.
     */
    public static void removeNonstaticMethods(SootClass clz) {
        Iterator<SootMethod> methodIter = clz.getMethods().iterator();
        while(methodIter.hasNext()) {
            SootMethod method = methodIter.next();
            if (!method.isStatic()) { 
                clz.removeMethod(method);
            }
        }
    }

    /**
     * For a given method, try to find a corresponding API overriden method
     * @param method
     * Method to look for corresponding API overriden
     * @return
     * API overriden method or null
     */
    public static SootMethod getApiOverridenMethod(SootMethod method) {
        if (method.isAbstract() || method.isPrivate()) {
            logger.debug("{} is either abstract or private", method);
            return null;
        }

        SootClass clz = method.getDeclaringClass().getSuperclass();

        logger.debug("getApiOverridenMethod: {} ", method);
        logger.debug("sig {}, subsig {} ", method.getSignature(), method.getSubSignature());

        while (clz != null && clz.getName()!= null &&
                !clz.getName().equals("java.lang.Object")) {

            SootMethod parentMethod = null;
            try {
                if (clz.isLibraryClass())
                    parentMethod = clz.getMethod(method.getSubSignature());
            }
            catch (Exception e) {
                logger.debug("Exception {} ", e);
            }

            logger.debug("parentMethod = {} ", parentMethod);
            if (parentMethod != null){
                return parentMethod;
            }
            clz = clz.getSuperclass();
        }

        String subSig = method.getSubSignature(); 
        // now we are dealing with interface
        for (SootClass parent: method.getDeclaringClass().getInterfaces()) {
            if (parent.declaresMethod(subSig)) {
                SootMethod meth = parent.getMethod(subSig);
                if (meth != null)
                    return meth;
            }
        }

        return null;
    }

    /**
     * check if a method is an API overriden method
     * @param method
     * @return
     */
    public static boolean isApiOverridenMethod(SootMethod method) {
        return (getApiOverridenMethod(method) != null);
    }

    /*
     *  * Given a method, get a set of methods that are called by this method
     * @param sootMethod
     * @return
     */
    public static Set<SootMethod> getCalleeSet(SootMethod sootMethod) {

        Set<SootMethod> calleeSet = new HashSet<SootMethod>();
        Body body;

        if (!sootMethod.isConcrete()) {
            return calleeSet;
        }

        try {
            body = sootMethod.retrieveActiveBody();
        }
        catch (Exception ex) {
            logger.warn("execption trying to get ActiveBody: {} ", ex);
            return calleeSet;
        }

        Chain<Unit> units = body.getUnits();


        /* Note that locals are named as follows:
         *  r => reference, i=> immediate
         *  $r, $i => true local
         *  r, i => parameter passing, and r0 is for this when it is non-static
         */

        for (Unit unit: units){
            Stmt statement = (Stmt)unit;

            if (statement.containsInvokeExpr())
            {
                InvokeExpr expr = statement.getInvokeExpr();
                SootMethod invokedMethod = expr.getMethod();
                calleeSet.add(invokedMethod);
            }

        }
        return calleeSet;
    }



    /**
     * get a list of ancestor of a given class, in order from immediate to oldest
     */
    public static List<SootClass> getSuperClassList(SootClass me) {
        List<SootClass> list = new LinkedList<SootClass>();

        if (!me.hasSuperclass())
            return list;

        SootClass current = me.getSuperclass();


        //System.out.println("checking accestor for = " + me.toString());
        while (current != null) {
            //System.out.println("parent = " + parent.toString());
            list.add(current);
            if (current.hasSuperclass())
                current = current.getSuperclass();
            else
                current = null;
        }
        return list;
    }

    /**
     * find the closest method in the inheritance chain (including itself) that matches
     * the signature
     * 
     * Returning null implies that the given class and none of its ancestors define the 
     * given method
     */
    public static SootMethod findClosetMatch(SootClass sootClass, SootMethodRef method) {
        List<SootClass> ancestorList = getSuperClassList(sootClass);

        ancestorList.add(0, sootClass);
        NumberedString subSig = method.getSubSignature();

        for (SootClass sc: ancestorList) {
            if (sc.declaresMethod(subSig))
                return sc.getMethod(subSig);
        }

        return null;
    }

    /**
     * check if a class is a decendent of posAncestor class
     */
    public static boolean checkAncestor(SootClass me, SootClass posAncestor) {
        SootClass parent = me.getSuperclass();
        SootClass objClass = Scene.v().getSootClass("java.lang.Object");

        //System.out.println("checking accestor for = " + me.toString());
        while (parent != null) {
            //System.out.println("parent = " + parent.toString());
            if (parent.equals(posAncestor))
                return true;

            if (parent.equals(objClass))
                return false;
            parent = parent.getSuperclass();
        }
        return false;
    }

    /**
     * get a list of classes that have the same short name
     */
    public static List<SootClass> matchShortName(String shortName) {
        Chain<SootClass> classes = Scene.v().getClasses();

        List<SootClass> list = new LinkedList();

        for (SootClass sootClass: classes) {
            if (sootClass.getShortName().equals(shortName))
                list.add(sootClass);
        }
        return list;
    }

    /**
     * Look for application callbacks with a given name.  No class info is available,
     * as some of the callbacks are not specified with packagename in xml layout
     * 1c/Wifinder is one
     * @param methodSig
     * @return
     */
    public static List<SootMethod> matchApplicationMethodName(String methodName) {
        List<SootMethod> matches = new LinkedList<SootMethod>();
        for (SootClass sootClass: Scene.v().getApplicationClasses()) {
            for (SootMethod method: sootClass.getMethods()) {
                String name = grabName(method.getSignature());
                if (name.equals(methodName)) {
                    logger.debug("Method {} MATCHED ", method);
                    matches.add(method);
                }
            }            
        }
        return matches;
    }

    /**
     * Return true if the method has the synthetic tag or flag.
     */
    public static boolean isSynthetic(SootMethod method) {      
        for (Tag tag : method.getTags()) {
            if (tag instanceof SyntheticTag) {
                return true;
            }
        }
        //modifier for synthetic flag
        if ((method.getModifiers() & 0x1000) != 0)
            return true;

        //bridge method?
        if ((method.getModifiers() & 0x0040) != 0)
            return true;

        return false;
    }

    static SootMethod stubExceptionMethod = null;
    /**
     * check if a given method is a runtime stub
     * @param method
     * @return
     */
    public static boolean isRuntimeStubMethod(SootMethod method) {    

        if (stubExceptionMethod == null) {
            String signature = "<java.lang.RuntimeException: void <init>(java.lang.String)>";
            stubExceptionMethod = Scene.v().getMethod(signature);
        }
        if (!method.hasActiveBody())
            return true; 

        for (Tag t : method.getTags()) {
            if (t instanceof GeneratedPhantomMethodTag)
                return true;
        }

        for (Unit unit: method.getActiveBody().getUnits()){
            Stmt stmt = (Stmt)unit;
            if (stmt.containsInvokeExpr()) {
                InvokeExpr invokeExpr = stmt.getInvokeExpr();
                SootMethod invokeMethod = invokeExpr.getMethod();
                if (invokeMethod == stubExceptionMethod) {
                    Value arg = invokeExpr.getArg(0);
                    if (arg.toString().equalsIgnoreCase("stub")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Return the set of concrete methods are inherited but not overriden by a class.
     */
    public static List<SootMethod> getInheritedMethods(SootClass clz) {
        List<SootMethod> methods = new LinkedList<SootMethod>();


        for (SootClass parent : getSuperClassList(clz)) {
            for (SootMethod method : parent.getMethods()) {
                //check if the a concrete resolve from the original class to the parent method 
                //resolves to this method, if so, it was not overriden.
                SootMethod resolved = Scene.v().getActiveHierarchy().resolveConcreteDispatch(clz, method);
                if (method.equals(resolved))
                    methods.add(method);
            }
        }

        return methods;
    }

    /**
     * Return true if the class has the synthetic tag or flag.
     */
    public static boolean isSynthetic(SootClass clz) {
        for (Tag tag : clz.getTags()) {
            if (tag instanceof SyntheticTag) {
                return true;
            }
        }

        if ((clz.getModifiers() & 0x1000) != 0)
            return true;

        return false;
    }

    /**
     * Return true if this class was defined as an enum.
     */
    public static boolean isEnum(SootClass clz) {
        return ((clz.getModifiers() & 0x4000) != 0);
    }

    public static SootMethod getMethodFromStmt(Stmt stmt) {
        if (stmt.containsInvokeExpr()) {
            InvokeExpr invokeExpr = stmt.getInvokeExpr();
            return invokeExpr.getMethod(); 
        }
        return null;

    }

    public static int getNumLines(SootMethod method) {
        if (method.isAbstract() || !method.isConcrete()) 
            return 0;

        try {
            int startingLine = getMethodLocation(method).getLine();
            
            Body body = method.retrieveActiveBody();

            Chain<Unit> units = body.getUnits();

            Unit curUnit = units.getLast();
            Unit first = units.getFirst();

            while (curUnit != first) {
                Stmt curStmt = (Stmt)curUnit;
                SourceLocationTag sl = getSourceLocation(curStmt); 
                if (sl != null)
                    return sl.getLine() - startingLine;

                curUnit = units.getPredOf(curUnit);
            }

        } catch (Exception e) {
            return 0;
        }
        
        return 0;
    }


//    /** 
//     * Returns a string describing the specified stmt.  
//     * Used for error messages 
//     **/
//    public static String app_location (Stmt stmt, Object msg) {
//        SootMethod method = InterproceduralControlFlowGraph.v().unitToBlock.get(stmt).getBody().getMethod();
//        SourceLocationTag loc = getSourceLocation(stmt, method.getDeclaringClass());
//        return String.format ("At method: %s, line %d, jimple stmt: %s: %s", method, loc.getLine(), stmt, msg);
//    }


    /**
     * Utility method to returned sorted map of input map, sorted by values (value must implement
     * comparator)
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
            {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
            } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

    /**
     * Change private to protected for ancestor fields.
     */
    public static void makeFieldsVisible(SootClass ancestor) {  
        for (SootField ancestorField : ancestor.getFields()) {
            if (ancestorField.isPrivate()) {
                //turn on protected
                ancestorField.setModifiers(ancestorField.getModifiers() | Modifier.PROTECTED);
                //turn off private
                ancestorField.setModifiers(ancestorField.getModifiers() ^ Modifier.PRIVATE);
            }

            //turn off final for ancestor methods
            if (ancestorField.isFinal())
                ancestorField.setModifiers(ancestorField.getModifiers() ^ Modifier.FINAL);
        }
    }

    public static List<SootClass> getSuperClassesOf(SootClass clazz) {
        //build ancestor
        //List<SootClass> ancestors = Scene.v().getActiveHierarchy().getSuperclassesOf(clazz);
        List<SootClass> ancestors = new LinkedList<SootClass>();

        //fill in ancestor list without using Soot.Hierarchy
        SootClass curAncestor = clazz;
        while (curAncestor.hasSuperclass())
        {
            ancestors.add(curAncestor.getSuperclass());
            curAncestor = curAncestor.getSuperclass();
        }

        return ancestors;
    }

    /**
     * get a list of statements that a method calls the other
     * @param sootMethod
     * @param callee
     * @return
     */
    public static List<Stmt> getInvokeStatements(SootMethod sootMethod, SootMethod callee) {
        List<Stmt> invokeStmtList = new LinkedList<Stmt>();

        if (!sootMethod.isConcrete()) {
            return invokeStmtList;
        }

        Body body;
        try {
            body = sootMethod.retrieveActiveBody();
        }
        catch (Exception ex) {
            logger.warn("execption trying to get ActiveBody: {} ", ex);
            return invokeStmtList;
        }

        Chain<Unit> units = body.getUnits();


        /* Note that locals are named as follows:
         *  r => reference, i=> immediate
         *  $r, $i => true local
         *  r, i => parameter passing, and r0 is for this when it is non-static
         */

        for (Unit unit: units){
            Stmt statement = (Stmt)unit;

            if (statement.containsInvokeExpr())
            {
                InvokeExpr expr = statement.getInvokeExpr();
                SootMethod invokedMethod = expr.getMethod();
                if (invokedMethod == callee)
                    invokeStmtList.add(statement);
            }

        }
        return invokeStmtList;
    }

}


