package droidsafe.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.Method;

import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.Hierarchy;
import soot.IntType;
import soot.LongType;
import soot.NullType;
import soot.PrimType;
import soot.Printer;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Value;
import soot.VoidType;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.JasminClass;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.tagkit.LineNumberTag;
import soot.util.JasminOutputStream;

/**
 * Class to hold general utility methods that are helpful for Soot.
 * 
 * @author mgordon
 *
 */
public class SootUtils {
	private final static Logger logger = LoggerFactory.getLogger(SootUtils.class);
	
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
				Utils.ERROR_AND_EXIT(logger, "Something very wrong with parsing type: {}", str);
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
				Utils.ERROR_AND_EXIT(logger, "Cannot parse type: {}", str);
				return null;
			}
		}
	}
	
	public static boolean isStringType(Type t) {
		return t.equals(RefType.v("java.lang.String"));
	}
	  
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
     * Get all superclasses and super interfaces of a soot class.
     */
    public static Set<SootClass> getParents(SootClass sc) {
        Set<SootClass>   ret = new HashSet<SootClass>();
        Queue<SootClass> q   = new LinkedList<SootClass>();
        q.add(sc);

        while (!q.isEmpty()) {
            SootClass curr = q.poll();
            if (curr.toString().equals("java.lang.Object")) {
                continue;
            }

            q.addAll(curr.getInterfaces());
            q.add(curr.getSuperclass());
            ret.addAll(curr.getInterfaces());
            ret.add(curr.getSuperclass());
        }

        return ret;
    }
    
    /**
     * Return true if child is a subtype of parent.  If both are primitive integral types, 
     * return true.If both are arraytypes, make sure element type of child is subtype of element 
     * type of parent.
     */
    public static boolean isSubTypeOf(Type child, Type parent) {
    	if (child.equals(parent))
    		return true;
    	else if (parent instanceof PrimType) {
    		//special case the integral types because they can be cast to
    		//each other and the spec language only have integer types
    		if (isIntegral(parent) && isIntegral(child))
    			return true;
    		return parent.equals(child);
    	} else if (parent instanceof ArrayType && child instanceof ArrayType) 	{
    		return isSubTypeOf(((ArrayType)child).getElementType(), ((ArrayType)parent).getElementType());
    	} else if (parent instanceof RefType && child instanceof RefType) {
    		SootClass pClass = ((RefType)parent).getSootClass();
    		SootClass cClass = ((RefType)child).getSootClass();
    		
    		Set<SootClass> parents = getParents(cClass);
    		return parents.contains(pClass);
    		
    	} else if (parent instanceof VoidType && child instanceof VoidType) {
    		return true;
    	} else if (parent instanceof NullType && child instanceof NullType) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Given a class, method name, return type string (in soot format) and the number of args,
     * try to find the method in the class, plus any methods that it could override in superclasses
     * and interfaces.
     */
    public static List<SootMethod> findPossibleInheritedMethods(SootClass clz, String name, String returnType, int numArgs) {
    	Hierarchy hierarchy = Scene.v().getActiveHierarchy();
    	LinkedList<SootMethod> methods = new LinkedList<SootMethod>();
    	
    	List<SootClass> classes = new LinkedList<SootClass>();
    	
    	if (!clz.isInterface()) 
    		classes.addAll(hierarchy.getSuperclassesOfIncluding(clz));
    	
    	classes.addAll(clz.getInterfaces());
   
    	
    	for (SootClass parent : classes) {
    		for (SootMethod method : parent.getMethods()) {
    			if (method.getName().equals(name) &&
    					method.getParameterCount() == numArgs &&
    					method.getReturnType().toString().equals(returnType))
    				methods.add(method);
    		}
    	}
    	
    	return methods;
    }
    
    /**
     * Given a method signature string, try to resolve the method from the scene of currently
     * loaded methods.  The use case is where the given method string has arguments that are subtypes
     * of a method defined in the scene.  The receiver type can be a subtype as well.
     */
    public static SootMethod resolveMethod(String signature) {
		if (Scene.v().containsMethod(signature))
			return Scene.v().getMethod(signature);
		
		Method method = new Method(signature);
		SootClass clz = Scene.v().getSootClass(method.getCname());
	
		List<SootMethod> possibleMethods = findPossibleInheritedMethods(clz, method.getName(), 
				method.getRtype(), method.getArgs().length);
		
		/*if (possibleMethods.isEmpty()) {
			Utils.ERROR_AND_EXIT(logger, "No possible methods targets for signature {}", signature);
		}*/
			
		
		boolean isStatic = possibleMethods.get(0).isStatic();
		for (SootMethod possibleMethod : possibleMethods) 
			if (isStatic != possibleMethod.isStatic())
				Utils.ERROR_AND_EXIT(logger, "Static modify disagrees among possible sources of inherited method!");
	
		List<Type> argTypes = new LinkedList<Type>();
		for (ArgumentValue value : method.getArgs()) {
			argTypes.add(value.getType());
		}
				
		//Use soot's method reference to try to resolve the specific call if args are not exact
		SootMethodRef methodRef = Scene.v().makeMethodRef(clz, method.getName(), argTypes, 
				toSootType(method.getRtype()), isStatic);
		SootMethod resolvedM = methodRef.resolve();
		
		if (resolvedM == null || !Scene.v().containsMethod(resolvedM.getSignature()))
			Utils.ERROR_AND_EXIT(logger, "Error resolving method: " + signature);
		
		
		return resolvedM;
	}
    
    /**
     * Load classes from the given jar file into Soot's current scene.  
     * Load the classes as application classes if appClass is true.
     * 
     * Return a set of all classes loaded from the jar.
     */
    public static Set<SootClass> loadClassesFromJar(JarFile jarFile, boolean appClass) {
    	LinkedHashSet<SootClass> classSet = new LinkedHashSet<SootClass>();
        Enumeration allEntries = jarFile.entries();
        while (allEntries.hasMoreElements()) {
            JarEntry entry = (JarEntry) allEntries.nextElement();
            String   name  = entry.getName();
            if (!name.endsWith(".class")) {
                continue;
            }

            String clsName = name.substring(0, name.length() - 6).replace('/', '.');
            logger.debug("Loading from {}: {}", jarFile.getName(), clsName);
            SootClass clz = Scene.v().loadClassAndSupport(clsName);
            classSet.add(clz);
            if (appClass)
            	clz.setApplicationClass();
            else
            	clz.setLibraryClass();
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
    	if (!clz.isAbstract() && !clz.isInterface())
    		Utils.ERROR_AND_EXIT(logger, "Trying to get close subclass of a non abstract class: {}", clz);
    	
    	logger.debug("Trying to get direct subclasses for: {}", clz);
    	//try to get direct implementors by adding them first
    	List<SootClass> implementors = 
    			new LinkedList<SootClass>();
    	
    	implementors.addAll((List<SootClass>)Scene.v().getActiveHierarchy().getDirectSubclassesOf(clz));  
    	
    	implementors.addAll(Scene.v().getActiveHierarchy().getSubclassesOf(clz));
    
    	//return the first concrete class
    	for (SootClass c : implementors) 
    		if (c.isConcrete())
    			return c;

    	return null;
    }
    
    /**
     * Return a concrete implementor of a given interface.  Try to find direct implementors first
     */
    public static SootClass getCloseImplementor(SootClass clz) {
    	if (!clz.isInterface())
    		Utils.ERROR_AND_EXIT(logger, "Trying to get implementor of a non interface: {}", clz);
    	
    	//try to get direct implementors by adding them first
    	List<SootClass> implementors = new LinkedList<SootClass>();
    			
    	implementors.addAll((List<SootClass>)Scene.v().getActiveHierarchy().getDirectImplementersOf(clz));  

    	implementors.addAll(Scene.v().getActiveHierarchy().getImplementersOf(clz));
    
    	//return the first concrete class
    	for (SootClass c : implementors) 
    		if (c.isConcrete())
    			return c;

    	return null;
    }
    
    /**
	 * Write the class and jimple file in the output directory. Prefix is the absolute 
	 * file name prefix for the class and jimple files (.class and .jimple will be appended).
	 */
	public static void writeByteCodeAndJimple(String filePrefix, SootClass clz) {
		String fileName = filePrefix + ".class";
		try {
			OutputStream streamOut = new JasminOutputStream(
					new FileOutputStream(fileName));
			PrintWriter writerOut = new PrintWriter(
					new OutputStreamWriter(streamOut));
			
			JasminClass jasminClass = new soot.jimple.JasminClass(clz);
		    jasminClass.print(writerOut);
		    writerOut.flush();
		    streamOut.close();
		    
		    fileName = filePrefix + ".jimple";
		    streamOut = new FileOutputStream(fileName);
		    writerOut = new PrintWriter(
		                                new OutputStreamWriter(streamOut));
		    Printer.v().printTo(clz, writerOut);
		    writerOut.flush();
		    streamOut.close();
			
		} catch (Exception e) {
			logger.error("Error writing class to file {}", e);
			System.exit(1);
		}
	}
	

	public static SourceLocationTag getSourceLocation(Stmt stmt, SootClass clz) {
		 SourceLocationTag line = null;
         
		 LineNumberTag tag = (LineNumberTag) stmt.getTag("LineNumberTag");
		 if (tag != null) {
			 line = new SourceLocationTag(clz.toString(),  tag.getLineNumber());
		 }
		 
		 return line;
	}
}
