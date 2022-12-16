package com.example.databasekp.service;

import com.example.databasekp.model.Partition;
import com.example.databasekp.model.Product;
import com.example.databasekp.repository.PartitionRepository;
import com.example.databasekp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final PartitionRepository partitionRepository;

    public Product getById(Long id) {
        return repository.findById(id).get();
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Partition getPartitionByName(String name) {
        return partitionRepository.findByName(name);
    }

    public List<Partition> getAllPartitions() {
        return partitionRepository.findAll();
    }
}
