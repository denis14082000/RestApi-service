package com.kazantsev.testEx.services;

import com.kazantsev.testEx.model.Info;
import com.kazantsev.testEx.model.DataBase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SetInfoService {
    @PostMapping("/set")
    public String setInfo(@RequestBody Info info) {
        return DataBase.saveData(info);
    }
}
