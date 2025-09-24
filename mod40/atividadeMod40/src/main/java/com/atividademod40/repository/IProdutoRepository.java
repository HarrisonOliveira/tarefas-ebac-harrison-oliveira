package com.atividademod40.repository;

import com.atividademod40.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Long> {

}
