package com.ctsi.space.service;


import com.ctsi.space.domain.BasStation;
import com.ctsi.space.domain.BasStationExample;
import com.ctsi.space.domain.dto.SimpleStationDto;
import com.ctsi.ssdc.service.StrengthenBaseService;

import java.util.List;

/**
 * Service Interface for managing BasStation.
 *
 * @author ctsi-biyi-generator
 *
 */
public interface BasStationService 
	extends StrengthenBaseService<BasStation, Long, BasStationExample>{

	List<SimpleStationDto> searchStationByNameAndOrgId( String stationName, Long orgId);
}
