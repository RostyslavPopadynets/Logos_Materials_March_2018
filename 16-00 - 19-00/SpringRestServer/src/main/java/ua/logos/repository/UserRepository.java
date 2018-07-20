package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.logos.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	// UserEntity findByUserId(String userId);
	
	@Query("SELECT u FROM UserEntity u WHERE u.userId = :userId")
	UserEntity findUserByUserId(@Param("userId") String userId);
	
}
