package com.task.repository;

import com.task.model.DeviceInfoModel;
import org.springframework.data.repository.CrudRepository;

public interface IDeviceInfoRepository extends CrudRepository<DeviceInfoModel, Long> {
}
