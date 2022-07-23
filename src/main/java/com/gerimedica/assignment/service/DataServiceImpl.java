package com.gerimedica.assignment.service;


import com.gerimedica.assignment.entity.Data;
import com.gerimedica.assignment.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public void saveAll(List<Data> dataList) {
        dataRepository.saveAll(dataList);
    }

    @Override
    public List<Data> getAll() {
        return (List<Data>) dataRepository.findAll();
    }

    @Override
    public List<Data> getByCode(String code) {
        System.out.println("codeeee" + code);
        return dataRepository.findAllByCode(code);
    }

    @Override
    public void deleteAll() {
        dataRepository.deleteAll();
    }
}
