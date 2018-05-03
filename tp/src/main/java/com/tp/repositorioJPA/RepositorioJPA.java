package com.tp.repositorioJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.model.Informacion;

public interface RepositorioJPA extends JpaRepository<Informacion, Long> {

}
