package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
}
