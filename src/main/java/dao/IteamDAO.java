package dao;

import allclass.Item;

public interface IteamDAO {
	
	void add(Item itm);
	void update(Item itm);
	void delete(Item itm);
	Item get(long id);
	void get(String name);

}
