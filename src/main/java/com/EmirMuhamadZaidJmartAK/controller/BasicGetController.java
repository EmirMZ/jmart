
package com.EmirMuhamadZaidJmartAK.controller;
import com.EmirMuhamadZaidJmartAK.Algorithm;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonTable;


import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
	@GetMapping("/{id}")
	public default T getById (@PathVariable int id){
		return Algorithm.<T>find(getJsonTable(),e -> e.id == id);
	}

	public abstract JsonTable<T> getJsonTable ();

	@GetMapping("/page")
	public default List<T> getPage(int page, int pageSize){
		final JsonTable<T> table = getJsonTable();
		return Algorithm.paginate(table,page,pageSize,o->true);
	}

}