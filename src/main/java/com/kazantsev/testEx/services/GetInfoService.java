package com.kazantsev.testEx.services;

import com.kazantsev.testEx.data.TestDataBase;
import com.kazantsev.testEx.model.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInfoService {
    @GetMapping("/get")
    public Info getInfo(@RequestParam String key) {
        if (!TestDataBase.DataBase.containsKey(key)) {
            return new Info("key is not found", "");
        }
        return new Info(key, TestDataBase.DataBase.get(key));
    }
}
