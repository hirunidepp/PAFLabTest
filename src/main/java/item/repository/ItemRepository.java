package item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
