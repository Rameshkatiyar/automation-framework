package com.tech.dataLoader.csvModel;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericTestDataCsv {
    @Parsed(field = "platform")
    private String platform;

    @Parsed(field = "key")
    private String key;

    @Parsed(field = "datamap")
    private String dataMapJson;
}
