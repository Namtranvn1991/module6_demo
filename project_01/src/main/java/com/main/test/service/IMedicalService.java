package com.main.test.service;

import com.main.test.model.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalService extends IGeneralService<Medical> {
    Page<Medical> findAll(Pageable pageable);
}
