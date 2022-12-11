package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.History;
import Repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	HistoryRepository hR;

	@Override
	public List<History> selectAll() {
		return (List<History>) hR.findAll();
	}

	@Override
	public List<History> selectWhereFav(String mail) {
		return (List<History>) hR.findByFavorito(mail);
	}

}
