package com.example.databasekp.repository;

import com.example.databasekp.model.Partition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartitionRepository extends JpaRepository<Partition, Long> {
    Partition findByName(String name);
}
