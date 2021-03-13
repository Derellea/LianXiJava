package com.derellea.service;

import com.derellea.domain.Vedio;

import java.util.List;

public interface VedioService {

    public void insert(Vedio vedio);
    public List<Vedio> findAll();
    public List<Vedio> findByvcId(int vcId);
}
