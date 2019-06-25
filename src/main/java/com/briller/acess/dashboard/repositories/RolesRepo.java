package com.briller.acess.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.Roles;
@Repository
public interface RolesRepo extends CrudRepository<Roles,Integer> {


//@Query("select role_name from roles where roles.role_id=?1")
Roles findByRoleId(int roleId);
}
