package com.staging.incubator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staging.incubator.models.Element;
import com.staging.incubator.repository.ElementRepository;

@Service
public class ElementService {

	@Autowired
	private ElementRepository eRep;
	
	public ElementService(ElementRepository eRep) {
		this.eRep=eRep;
	}
	
	public List<Element> getAll() {
		return eRep.findAll();
	}
	
	public Element create(Element e) {
		return eRep.save(e);
	}
	
	public Element getById(int id) {
		return eRep.findByElementId(id);
	}

	public List<Element> storeHierarchy(List<Element> list) {
		for(Element ele: list) {
			eRep.save(ele);
		}
		return eRep.findAll();
	}
}
