package com.kazantsev.testEx.model;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    private static HashMap<String, Info> dataBase = new HashMap<>();

    public static Info getDataByKey(String key) {
        if (!dataBase.containsKey(key)) {
            return new Info(key, "is not found");
        }
        Info foundedData = dataBase.get(key);
        if (System.currentTimeMillis() > foundedData.getTtl() + foundedData.getCreateTime()) {
            dataBase.remove(key);
            return new Info(key, "ttl is out");
        }
        return foundedData;
    }

    public static String saveData(Info info) {
        if (info.getTtl() == null) {
            info.setTtl(6000);
        }
        info.setCreateTime(System.currentTimeMillis());
        dataBase.put(info.getKey(), info);
        if(dataBase.get(info.getKey()).equals(info)) {
            return "Success";
        }
        return "Fail";
    }

    public static Info removeDataByKey(String key) {
        if(!dataBase.containsKey(key)) {
            return new Info(key, "is not found");
        }
        Info responseInfo = dataBase.get(key);
        dataBase.remove(key);
        return responseInfo;
    }

    public static ResponseEntity<Resource> getDump() throws IOException {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Path dumpFilePath = Paths.get("src/dump", dateFormat.format(date) + ".txt");
        Files.createFile(dumpFilePath);
        ArrayList<String> list = new ArrayList<>();
        list.add("Key;Content;Ttl;CreateTime");
        for (Map.Entry<String, Info> entry : dataBase.entrySet()) {
            list.add(mapInfoToString(entry.getValue()));
        }
        Files.write(dumpFilePath, list);
        Resource dumpFile = new UrlResource(dumpFilePath.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dumpFile.getFilename() + "\"")
                .body(dumpFile);
    }

    public static void loadDataFromFile(MultipartFile file) {
        //TODO()
    }

    private static String mapInfoToString(Info info) {
        return info.getKey() + ";" + info.getContent() + ";" + info.getTtl() + ";" + new Timestamp(info.getCreateTime());
    }
}
