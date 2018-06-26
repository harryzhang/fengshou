package com.kder.business.service.choose;

import java.util.Map;

import com.kder.business.common.page.PageDo;

public interface ICommonChooseService {

	PageDo<Map<String, Object>> getChoosePage(Map<String, Object> param,
			PageDo<Map<String, Object>> page);

}
