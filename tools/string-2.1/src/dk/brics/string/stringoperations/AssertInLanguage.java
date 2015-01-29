package dk.brics.string.stringoperations;

import dk.brics.automaton.Automaton;
import dk.brics.string.charset.CharSet;

public class AssertInLanguage extends UnaryOperation {
	
	private Automaton automaton;
	
	public AssertInLanguage(Automaton automaton) {
		this.automaton = automaton;
	}
	
	@Override
	public CharSet charsetTransfer(CharSet a) {
		return a.intersection(new CharSet(automaton));
	}
	
	@Override
	public Automaton op(Automaton a) {
		return a.intersection(automaton);
	}
	
	@Override
	public int getPriority() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "in[" + Basic.getName(automaton) + "]";
	}
	
	@Override
	public boolean isAssertion() {
		return true;
	}
	
}
