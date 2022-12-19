package com.Namfood.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.History;
import com.Namfood.Repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryRepository hR;

	@Override
	public List<History> selectWhereMail(String mail) {
		return (List<History>) hR.findByCorreo(mail);
	}

	@Override
	public List<History> selectWhereFav(String mail) {
		return (List<History>) hR.selectWhereCorreoAndFavorito(mail);
	}

}
