package com.motechnologies.treebinary.service;

import com.motechnologies.treebinary.model.Node;
import com.motechnologies.treebinary.model.TreeRequest;

/**
 * 
 * @author juan pena
 *
 */
public interface TreeBinaryService {

	/**
	 * Method that allows the creation of a binary tree
	 * 
	 * @param treeRequest
	 * @return
	 */
	Node createTree(TreeRequest treeRequest);

	/**
	 * Method that allows to return the closest common ancestor.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	Node getLowestCommonAncestor(int x, int y);
}
