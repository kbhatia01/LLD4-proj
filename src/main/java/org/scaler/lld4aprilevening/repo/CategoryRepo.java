package org.scaler.lld4aprilevening.repo;

import org.scaler.lld4aprilevening.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
