package com.mahammad.msblog.specification;

import lombok.Builder;
import lombok.Data;

@Data
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}