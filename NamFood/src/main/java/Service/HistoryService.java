package Service;

import java.util.List;

import Model.History;

public interface HistoryService {

	public List<History> selectAll();

	public List<History> selectWhereFav(String mail);
}
