package org.spr.dao;

import java.util.List;
import java.util.Map;

public interface Impos {

    List<Map<String, Object>> queryAll(String sql);

    void dele(String sql);
}
