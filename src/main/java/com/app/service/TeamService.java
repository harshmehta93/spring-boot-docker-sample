package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Player;

@Service
public class TeamService {

	public List<Player> listPlayers() {
		List<Player> players = new ArrayList<>();

		Player jack = new Player();
		jack.setName("Jack Wilshere");
		jack.setNumber(10);
		players.add(jack);

		Player laurent = new Player();
		laurent.setName("Laurent Koscielny");
		laurent.setNumber(6);
		players.add(laurent);

		Player per = new Player();
		per.setName("Per Mertsacker");
		per.setNumber(4);
		players.add(per);

		Player aaron = new Player();
		aaron.setName("Aaron Ramsey");
		aaron.setNumber(10);
		players.add(aaron);

		Player ozil = new Player();
		ozil.setName("Mesut Ozil");
		ozil.setNumber(11);
		players.add(ozil);

		return players;
	}
}
