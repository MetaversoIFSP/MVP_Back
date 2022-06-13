package com.arjuncodes.studentsystem.service.mocks;

import studentsystem.model.faq.*;

import java.util.List;

public class FaqMock {
    public static List<CategoriaNivelUm> getCategoriasUm(){
        return List.of(
                CategoriaNivelUm.builder()
                        .id(1L)
                        .name("Computador")
                        .urlImage("URL_TESTE")
                        .relevancePoints(1)
                        .build(),
                CategoriaNivelUm.builder()
                        .id(2L)
                        .name("Celular")
                        .urlImage("URL_TESTE2")
                        .relevancePoints(2)
                        .build()
        );
    }

    public static List<CategoriaNivelDoisDto> getCategoriaDois(Long id){
        return List.of(
                CategoriaNivelDoisDto.builder()
                        .id(1L)
                        .nome("Tela escura, mas faz barulho")
                        .posicao(1)
                        .solutions(
                                List.of(
                                        CategoriaNivelDoisDto.SolutionDto.builder()
                                                .relevancePoints(2)
                                                .pergunta("Já verificou todos os cabos de energia até a tomada?")
                                                .resposta("Às vezes, algum cabo pode estar mau encaixado ou, até mesmo, totalmente fora do lugar. Tente verificar se algum cabo de energia está bem fixado. Tente tirar e colocar. Apenas não realize força para encaixa-los ou desencaixa-los.")
                                                .build(),
                                        CategoriaNivelDoisDto.SolutionDto.builder()
                                                .relevancePoints(15)
                                                .pergunta("Existe alguma luzinha acesa no monitor?")
                                                .resposta("Se não existir, verifique ser o botão de energia está aceso.")
                                                .build()
                                )
                        )
                        .build(),
                CategoriaNivelDoisDto.builder()
                        .id(2L)
                        .nome("Computador liga, mas não consigo digitar nada")
                        .posicao(2)
                        .solutions(
                                List.of(
                                        CategoriaNivelDoisDto.SolutionDto.builder()
                                                .relevancePoints(3)
                                                .pergunta("O cabo do teclado está ligado?")
                                                .resposta("Verifique se o cabo do teclado está bem afixado.")
                                                .build(),
                                        CategoriaNivelDoisDto.SolutionDto.builder()
                                                .relevancePoints(15)
                                                .pergunta("Seu teclado tem cabo?")
                                                .resposta("Verifique se as pilhas estão carregadas.")
                                                .build()
                                )
                        )
                        .build()
        );
    }

}
