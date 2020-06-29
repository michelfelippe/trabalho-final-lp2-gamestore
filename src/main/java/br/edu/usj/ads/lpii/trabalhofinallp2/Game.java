package br.edu.usj.ads.lpii.trabalhofinallp2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String jogo;
    String lancamento;
    String categoria;
    String desenvolvedora;
    String publicadora;
}