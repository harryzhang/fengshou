package com.kder.business.service.report;

import java.util.Map;

import com.kder.business.common.page.PageDo;

public interface IReportService {

	PageDo<Map<String, Object>> selectReport(Map<String, Object> param);

}
