package com.kazantsev.testEx.services;

import com.kazantsev.testEx.model.DataBase;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DumpDBService {

    @GetMapping("/dump")
    public ResponseEntity<Resource> getDump() throws IOException {
        return DataBase.getDump();
    }
}
