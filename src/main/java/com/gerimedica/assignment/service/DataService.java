package com.gerimedica.assignment.service;

import com.gerimedica.assignment.entity.Data;

import java.util.List;

public interface DataService {

    void saveAll(List<Data> dataList);

    List<Data> getAll();

    List<Data> getByCode(String code);

    void deleteAll();
}
