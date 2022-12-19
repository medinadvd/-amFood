package com.Namfood.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Namfood.Entity.History;
import com.Namfood.Entity.User;
import com.Namfood.Service.HistoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/history")
public class HistoryController {
	
	@Autowired
	HistoryService historyService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/history")
	@ResponseBody
	public List<History> getHistory(@RequestParam User u) {
		return historyService.selectWhereMail(u.getCorreo());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/history/faved")
	@ResponseBody
	public List<History> getHistoryFaved(@RequestParam User u) {
		return historyService.selectWhereFav(u.getCorreo());
	}
	
	
}
