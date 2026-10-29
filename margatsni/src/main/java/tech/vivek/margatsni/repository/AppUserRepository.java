package tech.vivek.margatsni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.vivek.margatsni.model.AppUser;

import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
