package com.kazantsev.testEx.services;

import com.kazantsev.testEx.data.TestDataBase;
import com.kazantsev.testEx.model.Info;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetInfoService {

    @PostMapping("/set")
    public String setInfo(@RequestBody Info info) {
        TestDataBase.DataBase.put(info.getKey(), info.getContent());
        return "cool";
    }
}
