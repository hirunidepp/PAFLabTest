package item.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import item.model.Item;
import item.repository.ItemRepository;

@Service
public class ItemDAO {
	@Autowired
	ItemRepository itemRespository;
	
	//save a item
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public Item save(Item item) {
		return itemRespository.save(item);
	}
	
	//get all item
	public List<Item>findAll(){
		return itemRespository.findAll();
	}
	
	//get item by id
	public Item findOne(Long item_id) {
		Optional<Item> item = itemRespository.findById(item_id);
		if(item.isPresent()) {
			return item.get();
		}
		else {
			return null;
		}
		
	}
	
	//delete a item
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public void delete(Long item_id) {
		itemRespository.deleteById(item_id);
	}

}
