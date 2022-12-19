package com.Namfood.Service;

import java.util.List;

import com.Namfood.Entity.History;

public interface HistoryService {

	List<History> selectWhereMail(String mail);

	List<History> selectWhereFav(String mail);

}
