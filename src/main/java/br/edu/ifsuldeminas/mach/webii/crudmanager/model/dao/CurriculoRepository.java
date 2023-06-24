package br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Curriculo;

//update,save, delete e list é so chamar o @Repository

@Repository // para as operações básicas do CRUD
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer> {

}