//package com.kazantsev.testEx.services;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//@RestController
//public class LoadDBService {
//
//    @PostMapping("/load")
//    public void load(@RequestParam("file") MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            Path fileStorageLocation = Paths.get("C:/Users/Denis/Downloads/testEx/testEx/download");
//            Path targetLocation = fileStorageLocation.resolve(fileName);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            TestDataBase.DataBase.clear();
//            List<String> lines = Files.readAllLines(targetLocation);
//            for (String line : lines) {
//                int index = line.indexOf(";");
//                String key = line.substring(0, index);
//                String value = line.substring(index + 1);
//                TestDataBase.DataBase.put(key, value);
//            }
//        } catch (IOException ex) {
//            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//    }
//
//
//}
