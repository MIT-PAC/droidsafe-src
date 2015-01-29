package dk.brics.string.annotation;

import java.util.LinkedList;
import java.util.List;

import soot.PackManager;
import soot.Transform;

public class AnnotationChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Default path is user.dir
		String projectPath = java.lang.System.getProperty("user.dir");
		
		//Try to find user defined project path
		for (int i=0; i<args.length; i++) {
			String arg = args[i];
			if (arg.toLowerCase().equals("-projectpath") && (i+1)<args.length) {
				projectPath = args[i+1];
				break;
			}
		}
		
		//Find class files
		ClassFinder classFinder = new ClassFinder(projectPath);
		for (int i=0; i<args.length; i++) {
			String arg = args[i];
			if (arg.toLowerCase().equals("-projectpath") && (i+1)<args.length) {
				//Skip project path since it is already found
				i++;
			}
			else {
				classFinder.findClasses(args[i]);
			}
		}
		//If no package or class specified then use project path
		if (classFinder.getClassFiles().isEmpty()) {
			classFinder.findClasses("");
		}

		//Create Soot argument array
		List<String> sootArgs = new LinkedList<String>();
		sootArgs.add("--f");
		sootArgs.add("J");
		sootArgs.add("--d");
		sootArgs.add(projectPath+"\\sootOutput");
		sootArgs.add("--xml-attributes");
		sootArgs.add("--keep-line-number");
		sootArgs.addAll(classFinder.getClassFiles());
		String[] sootArrayArgs = sootArgs.toArray(new String[0]);
		
		//Add JSA phase to Soot
		Transformer.v().reset();
		PackManager.v().getPack("jtp").add(new
				Transform("jtp." + Transformer.PHASE_NAME,
						Transformer.v()));
		
		//Run Soot
		soot.Main.main(sootArrayArgs);
	}

}
