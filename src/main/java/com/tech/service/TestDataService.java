package com.tech.service;

import com.tech.config.TestConfig;
import com.tech.dataLoader.csvReader.GenericTestDataCsvReader;
import com.tech.dataLoader.csvReader.UserDataCsvReader;
import com.tech.enums.Platform;
import com.tech.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TestDataService {

    private final String GENERIC_TEST_DATA_CSV_NAME = "generic_testdata.csv";
    private Map<String, Map<String, String>> testData;

    @Autowired
    private GenericTestDataCsvReader genericTestDataCsvReader;
    @Autowired
    private TestConfig testConfig;
    @Autowired
    private JsonUtil jsonUtil;
    @Autowired
    private UserDataCsvReader userDataCsvReader;

    /**
     * In place of hashmap, we can store the data in cache like Redis.
     * @param platform
     */
    public void initializeGenericTestData(Platform platform){
        this.testData = new HashMap<>();
        String absoluteFilePath = testConfig.getTestDataPath().concat(GENERIC_TEST_DATA_CSV_NAME);
        genericTestDataCsvReader.readCSV(absoluteFilePath).stream()
                .filter(
                        genericTestDataCsv -> genericTestDataCsv.getPlatform().equalsIgnoreCase(platform.toString())
                )
                .forEach(
                        genericTestDataCsv -> {
                            String key = getDataKey(genericTestDataCsv.getPlatform(), genericTestDataCsv.getKey());
                            Map<String, String> valueMap = jsonUtil.getJsonToKeyValueMap(genericTestDataCsv.getDataMapJson());
                            testData.put(key, valueMap);
                        }
                );
    }

    public Map<String, String> getData(Platform platform, String key){
        return testData.get(getDataKey(platform.toString(), key));
    }

    private String getDataKey(String platform, String key){
        return platform +"-"+ key;
    }
}
