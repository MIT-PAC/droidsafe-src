package droidsafe.android.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.Components;

import soot.Local;
import soot.Printer;
import soot.Scene;
import soot.SootField;
import soot.SourceLocator;
import soot.Type;
import soot.ArrayType;
import soot.Modifier;
import soot.RefType;
import soot.SootClass;
import soot.SootMethod;
import soot.VoidType;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.StmtBody;
import soot.util.JasminOutputStream;

/**
 * Create a harness class that will call the entry points of the android application
 * and create objects of appropriate type for the points-to analysis.
 * 
 * @author mgordon
 *
 */
public class Harness {
	private final static Logger logger = LoggerFactory.getLogger(Harness.class);
	
	private SootClass harnessClass;
	private SootMethod harnessMain;
	public static String HARNESS_CLASS_NAME = "DroidSafeMain";
	
	private Map<SootClass, SootField> fieldsMap;
	private int FIELD_ID = 0;
	
	/**
	 * Create a harness class with a main method that includes calls into
	 * all the entry points of the android application.
	 */
	public static Harness create() {
		Harness harness = new Harness();
		
		return harness;
	}
	
	private Harness() {
		//create the harness class
		harnessClass = new SootClass(HARNESS_CLASS_NAME, Modifier.PUBLIC | Modifier.FINAL);
		harnessClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
		 
		//create the harness main method
		List<Type> args = new LinkedList<Type>();
		args.add(ArrayType.v(RefType.v("java.lang.String"), 1));
		harnessMain = new SootMethod("main", 
				args, VoidType.v(),
				Modifier.PUBLIC | Modifier.STATIC);
		
		harnessMain.setDeclaringClass(harnessClass);
		harnessClass.addMethod(harnessMain);
		
		addFields();
		createBody();
		writeHarnessClass();
	}
	
	private void addFields() {
		fieldsMap = new LinkedHashMap<SootClass, SootField>();
		
		//add fields for all component classes 
		for (SootClass c : Hierarchy.v().getAllAppComponents()) {
			RefType type = RefType.v(c);
			SootField f = new SootField(fieldName(c.getName()), type, Modifier.PRIVATE | Modifier.STATIC);
			harnessClass.addField(f);
			logger.debug("Adding field to harness class: {}", f.toString());
			fieldsMap.put(c, f);
		}
		
		//add fields for all runtime objects that could be passed into entry points
		for (String n : Components.RUNTIME_OBJECTS) {
			SootClass c = Scene.v().getSootClass(n);
			RefType type = RefType.v(c);
			SootField f = new SootField(fieldName(c.getName()), type, Modifier.PRIVATE | Modifier.STATIC);
			harnessClass.addField(f);
			logger.debug("Adding field to harness class: {}", f.toString());
			fieldsMap.put(c, f);
		}
	}
	
	private void createBody() {
		JimpleBody body = Jimple.v().newBody(harnessMain);
		harnessMain.setActiveBody(body);
		
		//add access to the arg
		Local arg = Jimple.v().newLocal("l0", ArrayType.v(RefType.v("java.lang.String"), 1));
	    body.getLocals().add(arg);
	  
	    body.getUnits().add(Jimple.v().newIdentityStmt(arg, 
	            Jimple.v().newParameterRef(ArrayType.v
	              (RefType.v("java.lang.String"), 1), 0)));
	    
		//create objects for all components of application
		for (Map.Entry<SootClass, SootField> e : fieldsMap.entrySet()) {
			
		}
	
		//create objects for any classes used as arguments for entry points
	
		//create methods for all entry points
		
		body.getUnits().add(Jimple.v().newReturnVoidStmt());
	}
	
	/**
	 * Write the harness class file in the output directory.
	 */
	private void writeHarnessClass() {
		String fileName = Project.v().getOutputDir() + File.separator + HARNESS_CLASS_NAME + ".class";
		try {
			OutputStream streamOut = new JasminOutputStream(
					new FileOutputStream(fileName));
			PrintWriter writerOut = new PrintWriter(
					new OutputStreamWriter(streamOut));
			
			JasminClass jasminClass = new soot.jimple.JasminClass(harnessClass);
		    jasminClass.print(writerOut);
		    writerOut.flush();
		    streamOut.close();
		    
		    fileName = Project.v().getOutputDir() + File.separator + HARNESS_CLASS_NAME + ".jimple";
		    streamOut = new FileOutputStream(fileName);
		    writerOut = new PrintWriter(
		                                new OutputStreamWriter(streamOut));
		    Printer.v().printTo(harnessClass, writerOut);
		    writerOut.flush();
		    streamOut.close();
			
		} catch (Exception e) {
			logger.error("Error writing harness class file {}", e);
			System.exit(1);
		}
	}
	
	private String fieldName(String clz) {
		return clz.substring(clz.lastIndexOf(".") + 1).toLowerCase() + FIELD_ID++;
	}
}
