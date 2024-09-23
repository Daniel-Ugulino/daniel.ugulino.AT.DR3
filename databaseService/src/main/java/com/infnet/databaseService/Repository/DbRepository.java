package com.infnet.databaseService.Repository;

import com.infnet.databaseService.Domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbRepository extends JpaRepository<Tax, Long> {
}
