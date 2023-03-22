package com.br.service.impl;

import com.br.repositories.DependenteRepository;
import com.br.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteServiceImpl implements DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;
}
