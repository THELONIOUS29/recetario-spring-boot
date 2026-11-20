# Recetario con Spring Boot y Thymeleaf

Aplicación web académica Java para administrar recetas mediante Spring Boot, Thymeleaf y persistencia de datos.

## Funciones observadas en el código

- Alta, listado, modificación y eliminación de recetas.
- Controladores web, repositorio de datos y entidad de receta.
- Inicio de sesión y configuración de Spring Security.
- Gestión de imágenes y plantillas HTML.

## Preparación

Consultar las versiones de Java y Spring en `pom.xml`. Configurar `DB_URL`, `DB_USER` y `DB_PASSWORD`, revisar `src/main/resources/application.properties` y restaurar las dependencias con Maven. Los servicios externos y los datos de demostración no se provisionaron durante el respaldo.

## Estado del respaldo

Copia para portafolio preparada el 20 de noviembre de 2026. Se conservaron los archivos originales en el PC. Se excluyeron el historial Git, credenciales, configuraciones del IDE, dependencias instaladas y datos operativos. Se quitaron las salidas guardadas de notebooks y los bloques INSERT/COPY de SQL. Se requiere configurar y validar el entorno antes de ejecutar; no se ejecutó la aplicación ni se verificaron sus resultados durante este respaldo.

Proyecto recuperado de archivos académicos del propietario de la cuenta. La descripción no acredita autoría exclusiva; al presentarlo deben indicarse las contribuciones personales y grupales. No se añade una licencia nueva.

## Configuración de acceso después de la revisión de seguridad

Definir `APP_ADMIN_USER` y `APP_ADMIN_PASSWORD` en el entorno antes de iniciar. No hay cuenta ni contraseña predeterminadas. La contraseña debe tener al menos 12 caracteres. El acceso a rutas de la aplicación requiere autenticación; la consola H2 queda desactivada y CSRF permanece activado.

El cierre de sesión requiere un formulario POST a `/recetas/logout` con el token CSRF de Thymeleaf. Esta copia conserva dependencias antiguas; se necesita revisar y actualizar el framework antes de un despliegue real. Los cambios no se aplicaron a ningún servicio desplegado.
