package br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

}

