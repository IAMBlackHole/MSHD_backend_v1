package com.earthquake.managementPlatform.service;

import java.io.IOException;

public interface OutPut {
    boolean outPut(String categoryId, String code) throws IOException;
}
