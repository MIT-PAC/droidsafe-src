package droidsafe.analyses.infoflow;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringEscapeUtils;

import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.DominatorNode;
import soot.toolkits.graph.DominatorTree;
import soot.toolkits.graph.InverseGraph;
import soot.toolkits.graph.MHGDominatorsFinder;

/**
 * Class for constructing a post-dominator tree from a control-flow graph.
 * This class presumes that this graph has a single common entry/exit.
 * 
 * @author jeikenberry
 */
public class PostDominatorTree extends DominatorTree {

	public PostDominatorTree(DirectedGraph<Block> graph) {
		// The post-dominator tree is essentially the dominator tree of the
		// inverse control-flow graph.
		super(new MHGDominatorsFinder<Block>(new InverseGraph<Block>(graph)));
	}

	/**
     * Write out the .dot file of a particular method to destDir and 
     * prefixed by prefix.  The branchBlock will be colored red, and
     * all taintedBlocks will be colored blue.
     * 
     * @param method SootMethod of interest
     * @param destDir File of the directory to write to
     * @param suffix String of the file suffix 
	 * @param branchBlock Block of the branch to copy taint from
	 * @param taintedBlocks Set&lt;DominatorNode&gt; of the 
	 * 	siblings (and grand-siblings) of branchBlock in this 
	 * 	post-dominator tree
     * @throws IOException
     */
	public void toDotFile(SootMethod method, File destDir, String suffix,
			Block branchBlock, Set<DominatorNode> taintedBlocks)
			throws IOException {
		if (!destDir.exists()) {
			if (!destDir.mkdirs())
				throw new IOException("could not create directory " + destDir);
		} else if (!destDir.isDirectory()) {
			throw new IOException(destDir + " exists, but is a file");
		}

		// There should only be one head, since we are presuming all paths
		// have a single common exit.  But, let's just iterate through them
		// to be thorough.
		StringBuilder nodes = new StringBuilder();
		StringBuilder edges = new StringBuilder();
		Stack<DominatorNode> stack = new Stack<DominatorNode>();
		for (DominatorNode head : getHeads()) {
			stack.push(head);
		}

		int instOffset = 0;
		Map<Block, Integer> blockNumbers = new HashMap<Block, Integer>();
		while (!stack.isEmpty()) {
			DominatorNode node = stack.pop();
			Block nodeBlock = (Block) node.getGode();
			int bFrom = blockNumbers.containsKey(nodeBlock) ? blockNumbers
					.get(nodeBlock) : blockNumbers.size();
			blockNumbers.put(nodeBlock, bFrom);
			nodes.append("  bb");
			nodes.append(bFrom);
			nodes.append(" [shape=none, margin=0, label=<\n");
			
			if (node.getGode() == branchBlock) {
				nodes.append("    <table bgcolor=\"#FF6666\" border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			} else if (taintedBlocks.contains(node)) {
				nodes.append("    <table bgcolor=\"#66FFFF\" border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			} else {
				nodes.append("    <table border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			}
			
			int idx = nodeBlock.getIndexInMethod();
			if (idx == Integer.MIN_VALUE) {
				nodes.append("      <tr><td align=\"center\">START</td></tr>");
			} else if (idx == Integer.MAX_VALUE) {
				nodes.append("      <tr><td align=\"center\">END</td></tr>");
			} else {
				for (Unit unit : nodeBlock) {
					nodes.append("      <tr><td align=\"left\">");
					nodes.append(idx+instOffset);
					nodes.append("</td><td align=\"left\">");
					nodes.append(StringEscapeUtils.escapeHtml4(unit.toString()));
					nodes.append("</td></tr>\n");
					instOffset++;
				}
				instOffset--;
			}
			
			nodes.append("    </table>>];\n");
			for (DominatorNode child : node.getChildren()) {
				Block childBlock = (Block) child.getGode();
				int bTo = blockNumbers.containsKey(childBlock) ? blockNumbers
						.get(childBlock) : blockNumbers.size();
				blockNumbers.put(childBlock, bTo);
				edges.append("  bb");
				edges.append(bFrom);
				edges.append(" -> bb");
				edges.append(bTo);
				edges.append(";\n");
				stack.push(child);
			}
		}

		String className = method.getDeclaringClass().getName();
		try (PrintWriter fileOut = new PrintWriter(new File(destDir,
				className + "." + method.getName() + "." + branchBlock.getIndexInMethod() 
				+ suffix + ".dot"))) {
			fileOut.println("digraph " + method.getName() + "CFG {\n");
			fileOut.println(nodes);
			fileOut.println();
			fileOut.println(edges);
			fileOut.println("}");
		}
	}

	/**
	 * Obtains a set of DominatorNode objects that are siblings (or 
	 * grand-siblings) of node.
	 * 
	 * @param node DominatorNode
	 * @return Set&lt;DominatorNode&gt;
	 */
	public Set<DominatorNode> siblingsOf(DominatorNode node) {
		Stack<DominatorNode> stack = new Stack<DominatorNode>();
		for (DominatorNode head : getHeads()) {
			stack.push(head);
		}

		Set<DominatorNode> nodes = new HashSet<DominatorNode>();
		boolean addSiblings = false;
		while (!stack.isEmpty()) {
			DominatorNode nextNode = stack.pop();
			if (nextNode == node) {
				addSiblings = true;
				stack.clear();
				DominatorNode parent = nextNode.getParent();
				// Parent can't be null, since we are presuming that all
				// paths must pass through a single common exit.  I think
				// we could probably remove this condition.  If parent is
				// null, I think what we want is all of the other heads
				// of this post-dominator tree.
				assert (parent != null);
				stack.addAll(parent.getChildren());
				stack.remove(nextNode);
				nodes.addAll(stack);
			} else {
				for (DominatorNode child : nextNode.getChildren()) {
					stack.push(child);
					if (addSiblings)
						nodes.add(child);
				}
			}
		}
		return nodes;
	}
	
}
