package edu.iu.habahram.ducksservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DucksFileRepository {
    private String IMAGES_FOLDER_PATH = "ducks/images/";
    private String AUDIO_FOLDER_PATH = "ducks/audio/";
    public DucksFileRepository() {
        File ducksImagesDirectory = new File("ducks/images");
        if (!ducksImagesDirectory.exists()) {
            ducksImagesDirectory.mkdirs();
        }
        File ducksAudioDirectory = new File("ducks/audio");
        if (!ducksAudioDirectory.exists()) {
            ducksAudioDirectory.mkdirs();
        }
    }

    public boolean updateImage(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".png";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }

    public boolean updateAudio(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".mp3";
        Path path = Paths.get(AUDIO_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }


    public byte[] getImage(int id) throws IOException {
        String fileExtension = ".png";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        byte[] image = Files.readAllBytes(path);
        return image;
    }

    public byte[] getAudio(int id) throws IOException {
        String fileExtension = ".mp3";
        Path path = Paths.get(AUDIO_FOLDER_PATH
                + id + fileExtension);
        byte[] file = Files.readAllBytes(path);
        return file;
    }


}
