package net.osgg.crudthymeleaf.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureService {

    @Value("${upload.path}")
    private String uploadDir;

    public void uploadPicture(MultipartFile file, UUID id) {
        try {
            if (file == null || file.isEmpty()) {
                throw new FileStorageException("No se ha seleccionado ningún archivo para subir.");
            }

            // Crear carpeta si no existe
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Nombre final del archivo
            Path copyLocation = uploadPath.resolve(id.toString() + ".jpg");

            // Guardar el archivo
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("✅ Imagen guardada en: " + copyLocation.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("Error al guardar el archivo: " + e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Error desconocido al subir la imagen.", e);
        }
    }

    public void deletePicture(UUID id) {
        try {
            Path fileToDeletePath = Paths.get(uploadDir, id.toString() + ".jpg");
            Files.deleteIfExists(fileToDeletePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
