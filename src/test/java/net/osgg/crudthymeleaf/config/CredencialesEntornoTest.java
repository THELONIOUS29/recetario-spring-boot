package net.osgg.crudthymeleaf.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CredencialesEntornoTest {
    @Test void rechazaCredencialesAusentes() {
        assertThrows(IllegalStateException.class, () -> CredencialesEntorno.validar(null, null));
        assertThrows(IllegalStateException.class, () -> CredencialesEntorno.validar("", "fixture-password-0123456789"));
        assertThrows(IllegalStateException.class, () -> CredencialesEntorno.validar("fixture-user", null));
    }
    @Test void rechazaClavesDebilesYMarcadores() {
        assertThrows(IllegalStateException.class, () -> CredencialesEntorno.validar("fixture-user", "short"));
        assertThrows(IllegalStateException.class, () -> CredencialesEntorno.validar("fixture-user", "CONFIGURAR_LOCALMENTE"));
    }
    @Test void aceptaConfiguracionLocalValida() {
        assertDoesNotThrow(() -> CredencialesEntorno.validar("fixture-user", "fixture-password-0123456789"));
    }
}
