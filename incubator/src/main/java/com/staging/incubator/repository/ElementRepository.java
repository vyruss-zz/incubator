package com.staging.incubator.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.staging.incubator.models.Element;

public interface ElementRepository extends CrudRepository<Element, Integer>{
	public List<Element> findAll();
	public Element save(Element e);
	public Element findByElementId(int id);
	public List<Element> findAllByElementId(int id);
}
