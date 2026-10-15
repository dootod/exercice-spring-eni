package fr.eni.claudeentrainement.bll;

import fr.eni.claudeentrainement.bo.Atelier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AtelierServiceImplTest {
    @Autowired
    private AtelierService atelierService;

    @Test
    @DisplayName("Test de récupération des ateliers")
    public void testRecuperationAtelier() {
        List<Atelier> ateliers = atelierService.listerAtelier();

        assertThat(ateliers).isNotNull();
        assertThat(ateliers).hasSize(0);
    }
}
