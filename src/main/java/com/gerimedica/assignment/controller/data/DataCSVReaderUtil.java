package com.gerimedica.assignment.controller.data;

import com.gerimedica.assignment.entity.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataCSVReaderUtil {


    public List<Data> readCSV(MultipartFile file) throws IOException {

        List<Data> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            Boolean header = true;
            String dataLine = br.readLine();
            while (dataLine != null) {

                if (header) {
                    header = false;
                    dataLine = br.readLine();
                    continue;
                }

                String[] dataString = dataLine.split(",");
                Data data = saveData(dataString);
                dataList.add(data);
                dataLine = br.readLine();
            }
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }


    public Data saveData(String[] datas) throws ParseException {

        String dataSource = getPrettierData(datas[0]);
        String codeListCode = getPrettierData(datas[1]);
        String code = getPrettierData(datas[2]);
        String displayValue = getPrettierData(datas[3]);
        String longDescription = getPrettierData(datas[4]);
        String fromDate = getPrettierData(datas[5]);
        String toDate = getPrettierData(datas[6]);
        String sortingPriority = getPrettierData(datas[7]);

        Data data = new Data();

        data.setSource(dataSource);

        data.setCode(code);

        data.setDisplayValue(displayValue);

        data.setSortingPriority(sortingPriority);

        data.setLongDescription(longDescription);

        data.setCodeListCode(codeListCode);

        data.setFromDate(getDate(fromDate));
        data.setToDate(getDate(toDate));

        return data;
    }


    private String getPrettierData(String value) {

        boolean isExist = (value != null && !value.equals(""));

        if (!isExist)
            return null;

        value = value.replace("\"", "");
        return value;

    }

    private Date getDate(String value) throws ParseException {

        if (value.equals(""))
            return null;

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedValue = formatter.parse(value);
        return formattedValue;
    }

}
