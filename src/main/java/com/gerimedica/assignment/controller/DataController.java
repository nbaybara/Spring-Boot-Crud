package com.gerimedica.assignment.controller;

import com.gerimedica.assignment.controller.data.DataCSVReaderUtil;
import com.gerimedica.assignment.entity.Data;
import com.gerimedica.assignment.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@RestController("data")
public class DataController {

    private final DataService dataService;

    @Async
    @PostMapping("/upload")
    public void uploadDataByCsvFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        DataCSVReaderUtil dataCSVReader = new DataCSVReaderUtil();
        List<Data> dataList = dataCSVReader.readCSV(file);
        dataService.saveAll(dataList);
    }

    @Async
    @GetMapping("/list")
    public List<Data> getAll(){
        return dataService.getAll();
    }

    @Async
    @GetMapping("/listByCode")
    public List<Data> getAllByCode(@RequestParam(value = "code") String code) {
        return dataService.getByCode(code);
    }


    @DeleteMapping("/delete")
    public void deleteAll() {
        dataService.deleteAll();
    }

}