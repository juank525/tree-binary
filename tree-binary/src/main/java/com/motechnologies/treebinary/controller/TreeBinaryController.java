package com.motechnologies.treebinary.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motechnologies.treebinary.model.Node;
import com.motechnologies.treebinary.model.TreeRequest;
import com.motechnologies.treebinary.service.TreeBinaryService;

@RestController
public class TreeBinaryController {

	private final TreeBinaryService treeBinaryService;

	public TreeBinaryController(TreeBinaryService treeBinaryService) {
		this.treeBinaryService = treeBinaryService;
	}

	@PostMapping(path = "/tree-binary", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Node> createTree(@RequestBody TreeRequest treeRequest) {
		Node tree = treeBinaryService.createTree(treeRequest);
		return ResponseEntity.ok().body(tree);
	}

	@GetMapping(path = "/lowest-common-ancestor", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Node> getLowestCommonAncestor(@RequestParam Integer nodeOne, @RequestParam Integer nodeTwo) {
		Node commonAncestor = treeBinaryService.getLowestCommonAncestor(nodeOne, nodeTwo);
		return ResponseEntity.ok().body(commonAncestor);
	}
}
