package br.com.yuri.dailydev.repository;

import br.com.yuri.dailydev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<UserDetails> findUserByEmail(String email);
}
