package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Player;
import com.app.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/arsenal/players", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> listPlayers() {
		return new ResponseEntity<>(teamService.listPlayers(), HttpStatus.OK);
	}
}
