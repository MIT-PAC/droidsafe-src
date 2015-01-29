package dk.brics.string.annotation;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.Stmt;
import soot.tagkit.StringTag;

public class HotspotTagger {
	
	private HashMap<ValueBox,Stmt> boxStmtMap = new HashMap<ValueBox,Stmt>();

	@SuppressWarnings("unchecked")
	public HotspotTagger() {
	Collection<SootClass> classes = Scene.v().getApplicationClasses();
		for (SootClass sootClass : classes) {
			Collection<SootMethod> methods = sootClass.getMethods();
			for (SootMethod method : methods) {
				if (method.hasActiveBody()) {
					Body body = method.getActiveBody();
					Collection<Unit> uc = body.getUnits();
					for (Unit u : uc) {
						if (u instanceof Stmt) {
							Stmt stmt = (Stmt)u;
							List boxes = stmt.getUseAndDefBoxes();
							for (Object o : boxes) {
								if (o instanceof ValueBox) {
									ValueBox box = (ValueBox)o;
									boxStmtMap.put(box,stmt);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void tag(ValueBox box, String message) {
		Stmt stmt = boxStmtMap.get(box);
		stmt.addTag(new StringTag(message));
	}
	
	public Stmt getStmt(ValueBox box) {
		return boxStmtMap.get(box);
	}
}
