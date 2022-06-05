package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.service.mocks.FaqMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import studentsystem.repository.faq.CategoriaNivelUmRepository;
import studentsystem.service.FaqServiceImpl;
import studentsystem.service.interfaces.IFaqService;



import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = IFaqService.class)
public class FaqServiceImplTest {

    FaqServiceImpl service;
    @Mock
    private CategoriaNivelUmRepository catUm;

    @BeforeEach
    void setUp(){
        service = new FaqServiceImpl(catUm);
    }

    @AfterEach
    void tearDown(){
        service = null;
        catUm = null;
    }

    @Test
    void whenGetAllCategoria_thenGetListOfCategoriasUm(){
        var expected = FaqMock.getCategoriasUm();
        Mockito.when(catUm.findAllByOrderByRelevancePointsDesc()).thenReturn(expected);
        var optional = service.getAllCategoriasNivelUm()
                .orElse(null);
        assertEquals(optional, expected);
    }

}
