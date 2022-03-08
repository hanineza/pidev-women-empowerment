package com.women.spring.service;

import com.women.spring.exception.FileNotFoundException;
import com.women.spring.exception.FileStorageException;
import com.women.spring.model.Certificat;
import com.women.spring.model.File;
import com.women.spring.model.Formation;
import com.women.spring.model.User;
import com.women.spring.repository.DatabaseFileRepository;
import com.women.spring.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DatabaseFileService {
    @Autowired
    private DatabaseFileRepository dbFileRepository;
    @Autowired
    FormationRepository formationRepository;

    public File storeFile(MultipartFile file ,Long id) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       Formation formation = formationRepository.findById(id).orElse(null);


        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes());
            dbFile.setFormation(formation);
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }

    public File findById(String id) {
        return dbFileRepository.findById(id).get() ;
    }

    public File save(File file) {   return dbFileRepository.save(file) ;

    }

}