package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    Aluno aluno;

    @BeforeEach
    void config() {
        aluno = new Aluno();
    }

    @Test
    void deveriaAtribuirMatricula() {
        var matricula = "12345678910";
        aluno.setMatricula(matricula);

        assertEquals(matricula, aluno.getMatricula());
    }

    @Test
    void naoDeveriaAtribuirMatriculaComMenosDe11Digitos() {
        var matricula = "1234567890";
        assertThrows(RuntimeException.class, () -> aluno.setMatricula(matricula));
    }

    @Test
    void naoDeveriaAtribuirMatriculaComMaisDe11Digitos() {
        var matricula = "1234567890182";
        assertThrows(RuntimeException.class, () -> aluno.setMatricula(matricula));
    }

    @Test
    void naoDeveriaAtribuirMatriculaComCaracteresEspeciais() {
        var matricula = "1234567890;";
        assertThrows(RuntimeException.class, () -> aluno.setMatricula(matricula));
    }

    @Test
    void naoDeveriaAtribuirMatriculaComLetras() {
        var matricula = "1234567890k";
        assertThrows(RuntimeException.class, () -> aluno.setMatricula(matricula));
    }

}
