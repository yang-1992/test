package com.ctsi.space.service.impl;


import com.ctsi.space.domain.BasStation;
import com.ctsi.space.domain.BasStationExample;
import com.ctsi.space.domain.dto.SimpleStationDto;
import com.ctsi.space.repository.BasStationRepository;
import com.ctsi.space.service.BasStationService;
import com.ctsi.ssdc.service.impl.StrengthenBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing BasStation.
 *
 * @author ctsi-biyi-generator
 *
 */
@Service
public class BasStationServiceImpl 
	extends StrengthenBaseServiceImpl<BasStationRepository, BasStation, Long, BasStationExample> 
	implements BasStationService {

	@Override
	public List<SimpleStationDto> searchStationByNameAndOrgId(String stationName, Long orgId) {
		return r.searchStationByNameAndOrgId(stationName, orgId);
	}
}
