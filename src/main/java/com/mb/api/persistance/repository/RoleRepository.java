package com.mb.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mb.api.business.constanst.ERole;
import com.mb.api.persistance.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
  Role findByRoleName(ERole role);
}
