package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericoRepository<T, ID> extends JpaRepository<T, ID>{
}
