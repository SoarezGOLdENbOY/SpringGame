package com.senai.Daniel.PrjGame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.Daniel.PrjGame.entities.Jogo;
import com.senai.Daniel.PrjGame.repositories.JogoRepository;

@Service
public class JogoServices {
	private final JogoRepository jogoRepository;

	public JogoServices(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);

	}

	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}

	public List<Jogo> getAllJogo() {
		return jogoRepository.findAll();
	}

	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}

}
