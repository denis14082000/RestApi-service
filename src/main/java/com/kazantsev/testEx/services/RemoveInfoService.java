package com.kazantsev.testEx.services;

import com.kazantsev.testEx.data.TestDataBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class RemoveInfoService {

    @GetMapping("/remove")
    public String removeInfo(@RequestParam String key) {
        if (!TestDataBase.DataBase.containsKey(key)) {
            return "no key";
        }
        String content = TestDataBase.DataBase.get(key);
        TestDataBase.DataBase.remove(key);
        return content;
    }
}
