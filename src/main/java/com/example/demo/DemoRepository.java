package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemoRepository extends PagingAndSortingRepository<DemoModel, UUID> {}
