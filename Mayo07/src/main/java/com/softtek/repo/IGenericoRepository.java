package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
public interface IGenericoRepository<T, ID> extends JpaRepository<T, ID>{
}
