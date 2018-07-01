package com.kder.business.dao.report;

import java.util.List;
import java.util.Map;

@Repository
public interface IReportDao {

	List<Map<String, Object>> selectOrderReport(Map<String, Object> param);

	List<Map<String, Object>> selectCommissionReport(Map<String, Object> param);

	List<Map<String, Object>> selectPeopleReport(Map<String, Object> param);

}
