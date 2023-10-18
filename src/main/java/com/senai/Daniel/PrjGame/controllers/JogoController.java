package com.senai.Daniel.PrjGame.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.Daniel.PrjGame.entities.Jogo;
import com.senai.Daniel.PrjGame.service.JogoServices;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	private final JogoServices jogoService;

	public JogoController(JogoServices jogoService) {
		this.jogoService = jogoService;
	}

	@PostMapping
	public Jogo createjogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogo> getAllJogo() {
		return jogoService.getAllJogo();
	}

	@GetMapping("/{id}")	
    public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
        Jogo jogo = jogoService.getJogoById(id);
        if (jogo != null) {
            return ResponseEntity.ok(jogo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}

}
