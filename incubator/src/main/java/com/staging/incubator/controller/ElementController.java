package com.staging.incubator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staging.incubator.models.Element;
import com.staging.incubator.service.ElementService;

@RestController
@RequestMapping("/elements")
public class ElementController {
	@Autowired
	private ElementService eServ;
	
	public ElementController(ElementService eServ) {
		this.eServ=eServ;
	}
	
	@GetMapping("/")
	public List<Element> getAllElements() {
		return eServ.getAll();
	}
	
	@PostMapping("/create")
	public Element createNewElement(@RequestBody Element e) {
		return eServ.create(e);
	}
	
	@GetMapping("/{id}")
	public Element getElementById(@PathVariable("id") int id) {
		return eServ.getById(id);
	}
	
	@GetMapping("/{id}/ancestors") 
	public List<Element> getAllAncestors(@PathVariable("id") int id) {
		ArrayList<Element> list = new ArrayList<>();
		Element current = eServ.getById(id);
		Element base = current;
		list.add(current);
		while(current.getParentOne()!=null && current.getParentTwo() != null) {
			list.add(current.getParentOne());
			list.add(current.getParentTwo());
			current = current.getParentOne();
		}
		current = base;
		while(current.getParentOne()!=null && current.getParentTwo() != null) {
			if(!list.contains(current.getParentOne()))
				list.add(current.getParentOne());
			if(!list.contains(current.getParentTwo()));
				list.add(current.getParentTwo());
			current = current.getParentTwo();
		}

		return list;
	}
	
}
