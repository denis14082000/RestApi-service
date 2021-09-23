package com.kazantsev.testEx.services;

import com.kazantsev.testEx.model.DataBase;
import com.kazantsev.testEx.model.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveInfoService {

    @GetMapping("/remove")
    public Info removeInfo(@RequestParam String key) {
        return DataBase.removeDataByKey(key);
    }
}
