package com.motechnologies.treebinary.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.motechnologies.treebinary.exceptions.TreeException;
import com.motechnologies.treebinary.model.Node;
import com.motechnologies.treebinary.model.Tree;
import com.motechnologies.treebinary.model.TreeRequest;
import com.motechnologies.treebinary.service.TreeBinaryService;

/**
 * 
 * @author juan pena
 *
 */
@Service
public class TreeBinaryServiceImpl implements TreeBinaryService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node createTree(TreeRequest treeRequest) {
		Node root = new Node(treeRequest.getRoot());
		treeRequest.getNodes().stream().forEach(value -> fillTree(root, value));
		Tree.setNode(root);
		return Tree.getNode();
	}

	/**
	 * Method that allows to fill a binary tree
	 * 
	 * @param node
	 * @param value
	 */
	private void fillTree(Node node, int value) {
		if (value < node.getValue()) {
			if (Objects.nonNull(node.getLeft())) {
				fillTree(node.getLeft(), value);
			} else {
				node.setLeft(new Node(value));
			}
		} else if (value > node.getValue()) {
			if (Objects.nonNull(node.getRigth())) {
				fillTree(node.getRigth(), value);
			} else {
				node.setRigth(new Node(value));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node getLowestCommonAncestor(int x, int y) {

		if (Objects.isNull(Tree.getNode())) {
			throw new TreeException("No existe información del árbol binario, ejecute el servicio de creación");
		}

		if (Tree.getNode().getValue() == x || Tree.getNode().getValue() == y) {
			throw new TreeException("Colocar un nodo diferente al root");
		}

		List<Integer> parentsX = new ArrayList<>();
		List<Integer> parentsY = new ArrayList<>();

		findParents(parentsX, Tree.getNode(), x);
		findParents(parentsY, Tree.getNode(), y);

		parentsX.retainAll(parentsY);

		return Node.builder().value(parentsX.get(parentsX.size() - 1)).build();
	}

	/**
	 * Method allows get elements parents of a node
	 * 
	 * @param parents
	 * @param node
	 * @param value
	 */
	private void findParents(List<Integer> parents, Node node, Integer value) {
		if (Objects.nonNull(node) && node.getValue() > value) {
			parents.add(node.getValue());
			findParents(parents, node.getLeft(), value);
		} else if (Objects.nonNull(node) && node.getValue() < value) {
			parents.add(node.getValue());
			findParents(parents, node.getRigth(), value);
		} else if (Objects.isNull(node) || node.getValue() != value) {
			throw new TreeException("No existe en el arbol el valor: " + value);
		}

	}

}
