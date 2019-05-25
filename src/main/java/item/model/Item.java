package item.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="items")
@EntityListeners(AuditingEntityListener.class)
public class Item {
	private static final long serialVersionUID = 1143993377101043360L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long item_id;
	private String item_name;
	private String item_discription;
	private Long price; 
	private String category;
	
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_discription() {
		return item_discription;
	}
	public void setItem_discription(String item_discription) {
		this.item_discription = item_discription;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	


}
