package com.motechnologies.treebinary.model;

import java.io.Serializable;

public class Tree implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Node node;

	public static Node getNode() {
		return node;
	}

	public static void setNode(Node node) {
		Tree.node = node;
	}

}
