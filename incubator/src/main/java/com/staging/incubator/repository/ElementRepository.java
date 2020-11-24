package com.staging.incubator.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.staging.incubator.models.Element;

@Repository
@Transactional
public interface ElementRepository extends CrudRepository<Element, Integer>{
	public List<Element> findAll();
	public Element save(Element e);
	public Element findByElementId(int id);
	public List<Element> findAllByElementId(int id);
	public List<Element> save(List<Element> list);
}
