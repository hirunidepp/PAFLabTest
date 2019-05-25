package item.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import item.dao.ItemDAO;
import item.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemDAO itemDAO;
	
	//save a item
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemDAO.save(item);
	}
	
	//get all item
	@GetMapping("/items")
	public List<Item> getAllItems(){
		return itemDAO.findAll();
		
	}
	
	//get item by id
	@GetMapping("/items/{item_id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value="item_id") Long item_id){ 
		Item item = itemDAO.findOne(item_id);
		
		if(item == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(item);
	}
	
	//update item by id
	@PutMapping("/items/{item_id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value="item_id") Long item_id, @Valid @RequestBody Item itemDetails){ 
		Item item = itemDAO.findOne(item_id);
		if(item == null) {
			return ResponseEntity.notFound().build();
		}
		item.setItem_id(itemDetails.getItem_id());
		item.setItem_name(itemDetails.getItem_name());
		item.setItem_discription(itemDetails.getItem_discription());
		item.setCategory(itemDetails.getCategory());
		item.setPrice(itemDetails.getPrice());
		
		Item upItem = itemDAO.save(item);
		
		return ResponseEntity.ok().body(upItem);
		
	}
	
	//delete an item
	@DeleteMapping("/items/{item_id}")
	public ResponseEntity<Item> deleteItem(@PathVariable(value="item_id") Long item_id){
		Item item = itemDAO.findOne(item_id);
		if(item == null) {
			return ResponseEntity.notFound().build();
		}
		itemDAO.delete(item_id);
		return ResponseEntity.ok().build();
		
	}

}
