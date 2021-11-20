package com.EmirMuhamadZaidJmartAK.controller;

import com.EmirMuhamadZaidJmartAK.dbjson.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface BasicGetController<T extends Serializable> {
	
	@GetMapping("/{id}")
	public default T getById(int id) {
		return getJsonTable().get(id);
	}
	
	public abstract JsonTable<T> getJsonTable();
	
	@GetMapping("/page")
	public default List<T> getPage(int page, int pageSize) {
		return getJsonTable().subList(page, pageSize);
	}
	
}
