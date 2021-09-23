package com.kazantsev.testEx.services;

import com.kazantsev.testEx.model.Info;
import com.kazantsev.testEx.model.DataBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetInfoService {


    @GetMapping("/get")
    private Info getInfo(@RequestParam String key) {
        return DataBase.getDataByKey(key);
    }
}
