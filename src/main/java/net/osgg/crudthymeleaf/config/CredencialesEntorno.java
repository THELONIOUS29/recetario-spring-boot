package net.osgg.crudthymeleaf.config;

final class CredencialesEntorno {
    private CredencialesEntorno() { }
    static void validar(String usuario, String clave) {
        if (usuario == null || usuario.trim().isEmpty() || clave == null || clave.length() < 12
                || clave.toUpperCase(java.util.Locale.ROOT).contains("CONFIGURAR")) {
            throw new IllegalStateException("Configure APP_ADMIN_USER y APP_ADMIN_PASSWORD con una clave propia de al menos 12 caracteres.");
        }
    }
}
