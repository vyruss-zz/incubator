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
import com.staging.incubator.models.ElemixerParent;
import com.staging.incubator.service.ElementService;

@RestController
@RequestMapping("/elements")
public class ElementController {
	@Autowired
	private ElementService eServ;

	private List<Element> eleList = new ArrayList<Element>();
	
	public ElementController(ElementService eServ) {
		this.eServ = eServ;
	}

	@GetMapping("/")
	public List<Element> getAllElements() {
//		return eleList;
		return eServ.getAll();
	}

	@PostMapping("/create")
	public Element createNewElement(@RequestBody Element e) {
		System.out.println(e);
		System.out.println(e.getParentOne());
		System.out.println(e.getParentTwo());
//		System.out.println(e.getParentOne().getParentOne());

//		eleList.add(e);
//		return e;

		return eServ.create(e);
	}

	@GetMapping("/{id}")
	public Element getElementById(@PathVariable("id") int id) {
		return eServ.getById(id);
	}
	
	@GetMapping("{id}/parents")
	public List<Element> getParentsById(@PathVariable("id") int id) {
		//Element e = eServ.getById(id);
		List<Element> list = new ArrayList<Element>();
		/*list.add(e);
		list.add(e.getParentOne().getParentOne());
		list.add(e.getParentTwo().getParentTwo());*/
		
		for(Element ele: eleList) {
			if(ele.getElementId() == id) list.add(ele);
			break;
		}
		
		list.add(list.get(0).getParentOne());
		list.add(list.get(0).getParentTwo());
		
		return list;
	}
	
	@PostMapping("/save")
	public List<Element> saveAll() {
		
		
		
		return eServ.storeHierarchy(eleList);
	}
	
	@GetMapping("/{id}/ancestors")
	public List<Element> getAllAncestors(@PathVariable("id") int id) {
		ArrayList<Element> list = new ArrayList<>();
		Element current = eServ.getById(id);
		Element base = current;
		list.add(current);
		/*int badThingsHappenedCounter = 0;
		while (current.getParentOne() != null && current.getParentTwo() != null) {
			System.out.println(current);
			System.out.println(current.getParentOne());
			System.out.println(current.getParentTwo());
			list.add(current.getParentOne().getParentOne());
			list.add(current.getParentTwo().getParentTwo());
			current = current.getParentOne().getParentOne();
			badThingsHappenedCounter++;
			if (badThingsHappenedCounter >= 1000)
				break;
		}
		badThingsHappenedCounter=0;
		current = base;
		while (current.getParentOne() != null && current.getParentTwo() != null) {
			System.out.println(current);
			System.out.println(current);
			System.out.println(current.getParentOne());
			System.out.println(current.getParentTwo());
			if (!list.contains(current.getParentOne()))
				list.add(current.getParentOne().getParentOne());
			if (!list.contains(current.getParentTwo()));
			list.add(current.getParentTwo().getParentTwo());
			current = current.getParentTwo().getParentTwo();
			badThingsHappenedCounter++;
			if (badThingsHappenedCounter >= 1000)
				break;
		}*/

		return list;
	}

}
