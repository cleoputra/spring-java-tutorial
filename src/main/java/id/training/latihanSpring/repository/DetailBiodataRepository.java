package id.training.latihanSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.training.latihanSpring.entity.DetailBiodataEntity;

@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer> {
	
	
}