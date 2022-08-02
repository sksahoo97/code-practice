package com.shiv.solutions.leetcode.model;

import java.util.Iterator;
import java.util.List;

public class Node {

	private int val;
	private List<Node> children;

    public Node() {}

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, List<Node> _children) {
        this.val = _val;
        this.children = _children;
    }

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(val);
        buffer.append('\n');
        if(children != null) {
        	for (Iterator<Node> it = children.iterator(); it.hasNext();) {
                Node next = it.next();
                if (it.hasNext()) {
                    next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }
    
}
