package dk.brics.string.annotation;
import java.io.*;
import java.util.*;

public class ClassFinder {
	
	private String projectPath;
	private List<String> classFiles = new LinkedList<String>();

	public ClassFinder (String projectPath) {
		this.projectPath = projectPath;
	}
	
	public void findClasses(String path) {
		File file;
		
		//Try if path is a package (directory)
		file = new File(projectPath + "\\" + path.replace(".", "\\"));
		if (file.isDirectory())
			findClasses(file);
		
		//Try if path is a class file
		file = new File(projectPath + "\\" + path.replace(".", "\\") + ".class");
		if (file.isFile())
			findClasses(file);
	}
	
	private void findClasses(File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				findClasses(f);
			}
		}
		if (file.isFile()) {
			String filePath = file.getAbsolutePath();
			if (filePath.substring(filePath.length()-6).toLowerCase().equals(".class")) {
				String relativePath = filePath.substring(projectPath.length() + 1, filePath.length()-6);
				classFiles.add(relativePath.replace("\\", "."));
			}
		}
	}
	
	public List<String> getClassFiles() {
		return classFiles;
	}
	
}
