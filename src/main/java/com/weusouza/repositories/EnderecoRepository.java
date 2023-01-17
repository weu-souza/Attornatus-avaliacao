package com.weusouza.repositories;

import com.weusouza.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
@Query("select obj from Endereco obj where obj.pessoa.Id = :id_pess")
    List<Endereco> findAlllByPessoa(@Param(value = "id_pess")Integer id_pess);
}
